package com.kitri.haksa.service.db;

import java.io.*;
import java.util.ArrayList;

import com.kitri.haksa.data.db.HaksaDto;

public class HaksaServiceImpl implements HaksaService {

	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	HaksaDto haksaDto;
	
	public HaksaServiceImpl() {
		haksaDto = new HaksaDto();
		
		while (true)
			menu();
	}

	@Override
	public void menu() {
		try {
			System.out.println("========== 메뉴 선택 ==========");
			System.out.println("1. 등록");
			System.out.println("2. 찾기");
			System.out.println("3. 삭제");
			System.out.println("4. 전체 출력");
			System.out.println("----------------");
			System.out.println("0. 종료");

			System.out.print("번호를 선택해 주세요..");
			switch (in.readLine()) {
				case "1" : registerMenu(); break;
				case "2" : findNameMenu(); break;
				case "3" : deleteMenu(); break;
				case "4" : selectAll(); break;
				case "0" : processExit(); break;
			}
			System.out.print("계속 하시려면 1, 종료하시려면 0을 입력해 주세요");
			switch (in.readLine()) {
				case "1" : break;
				case "0" : processExit();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void registerMenu() {
		try {
			System.out.println("========== 메뉴 선택 ==========");
			System.out.println("1. 학생");
			System.out.println("2. 교수");
			System.out.println("3. 관리자");
			System.out.println("4. 이전메뉴");
			System.out.println("----------------");

			System.out.print("번호를 선택해 주세요..");
			haksaDto.setKey(Integer.parseInt(in.readLine()));
			switch (haksaDto.getKey()) {
				case 4 : System.out.println(); break;
				default :
					System.out.print("나 이 : ");
					haksaDto.setAge(Integer.parseInt(in.readLine()));
					System.out.print("이 름 : ");
					haksaDto.setName(in.readLine());
					System.out.print((haksaDto.getKey()==1 ? "학 번 : " : (haksaDto.getKey()==2 ? "과 목 :" : "부 서 : ")));
					haksaDto.setKeyName(in.readLine());
					HaksaDao.getInstance().register(haksaDto);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void findNameMenu() {
		try {
			System.out.println("찾을 이름을 입력해 주세요.");
			System.out.print("이름 : ");
			String name = in.readLine();
			haksaDto = HaksaDao.getInstance().findName(name);
			if(haksaDto != null)
				System.out.println(haksaDto);
			else
				System.out.println("해당하는 사람이 없습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteMenu() {
		try {
			System.out.println("삭제할 사람의 이름을 입력해 주세요.");
			System.out.print("이름 : ");
			String name = in.readLine();
			int result = HaksaDao.getInstance().delete(name);
			if(result != 0)
				System.out.println(name + "님을 삭제하였습니다.");
			else
				System.out.println(name + "님을 삭제하는데 실패하였습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void selectAll() {
		ArrayList<HaksaDto> all = HaksaDao.getInstance().selecArrayList();
		int size = all.size();
		for (int i = 0; i < size; i++) {
			System.out.println(all.get(i));
		}
	}

	@Override
	public void processExit() {
		System.exit(0);
	}
}
