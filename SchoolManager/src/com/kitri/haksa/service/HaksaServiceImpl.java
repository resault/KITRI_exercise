package com.kitri.haksa.service;

import java.io.*;
import java.util.ArrayList;

import com.kitri.haksa.data.HaksaDto;


public class HaksaServiceImpl implements HaksaService {

	private ArrayList<HaksaDto> list = new ArrayList<HaksaDto>();
	private String[] job = {"학 번 : ", "과 목 : ", "부 서 : "};
	private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	

	@Override
	public void menu() {
		System.out.println("========== 메뉴 선택 ==========");
		System.out.println("1. 등록");
		System.out.println("2. 찾기");
		System.out.println("3. 삭제");
		System.out.println("4. 전체 출력");
		System.out.println("-------------------");
		System.out.println("0. 종료");
		System.out.println("-------------------");
		System.out.print("번호를 선택해 주세요..");
		
		try { 
			String key = in.readLine();
			if(key.equals("1"))
				registerMenu();
			else if(key.equals("2"))
				findNameMenu();
			else if(key.equals("3"))
				deleteMenu();
			else if(key.equals("4"))
				selectAll();
			else if(key.equals("0"))
				System.exit(0);
			else
				System.out.println("잘못 입력하였습니다.\n");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void registerMenu() {
			try {
				System.out.println("\n========== 메뉴 선택 ==========");
				System.out.println("1. 학생");
				System.out.println("2. 교수");
				System.out.println("3. 관리자");
				System.out.println("4. 이전메뉴");
				System.out.print("번호를 선택해 주세요..");

				String x = in.readLine().trim();
				if(!x.equals("4")) {
					if(x.equals("1") || x.equals("2") || x.equals("3")) {
						int key = Integer.parseInt(x);
						System.out.print("나 이 : ");
						String ageStr = in.readLine().trim(); 
						int size = ageStr.length();
						
						for(int i=0;i<size;i++) {
							int check = ageStr.charAt(i) - 48;
							if(check < 0 && check >= 10) {
								System.out.println("나이는 문자로 입력할 수 없습니다.");
								registerMenu();
								return;
							}
						}
						
						int age = Integer.parseInt(ageStr);
						System.out.print("이 름 : ");
						String name = in.readLine().trim();
						System.out.print((key==1 ? job[0] : (key==2 ? job[1] : job[2])));
						String value = in.readLine().trim();
						register(new HaksaDto(age, name, key, value));
						return;
					}
					System.out.println("잘못 입력하였습니다.");
					registerMenu();
				} else {
					System.out.println();
					return;
				}					
						
			} catch (IOException e) {
				e.printStackTrace();
			}

	}

	@Override
	public void register(HaksaDto haksa) {
		list.add(haksa);
		System.out.println("등록이 완료되었습니다.");
		processExit();
	}

	@Override
	public void findNameMenu() {
		System.out.println("찾을 이름을 입력해 주세요.");
		System.out.print("이름 : ");
		try {
			String name = in.readLine();
			HaksaDto haksa = findName(name);
			if(haksa != null)
				System.out.println("나이 : " + haksa.getAge() + "\t이름 : " + haksa.getName() + "\t" + 
						(haksa.getKey()==1 ? job[0] : (haksa.getKey() == 2 ? job[1] : job[2])) + haksa.getValue());
			else
				System.out.println(name + "님은 등록되지 않은 사람입니다.");
			processExit();
		} catch (IOException e) {
			e.printStackTrace();
		}
			
	
	}

	@Override
	public HaksaDto findName(String name) {
		HaksaDto haksa = null;
		int size = list.size();
		for(int i=0;i<size;i++) {
			if (list.get(i).getName().equals(name)) {
				return list.get(i);
			}
		}
		return haksa;
	}

	@Override
	public void deleteMenu() {
		System.out.println("삭제할 사람의 이름을 입력해 주세요.");
		System.out.print("이름 : ");
		try {
			String name = in.readLine();
			int result = delete(name);
			if(result != 0)
				System.out.println(name + "님을 삭제 하였습니다.");
			else
				System.out.println(name + "님은 등록되지 않은 사람입니다.");
			processExit();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int delete(String name) {
		HaksaDto haksa = null;
		int size = list.size();
		for(int i=0;i<size;i++) {
			if (list.get(i).getName().equals(name)) {
				list.remove(i);
				return 1;
			}
		}
		return 0;
	}

	@Override
	public void selectAll() {
		HaksaDto[] haksa = list.toArray(new HaksaDto[0]);
		int size = list.size();
		if(size != 0)
			for(int i=0;i<size;i++) {
				System.out.println("이름 : " + haksa[i].getName() + "\t나이 : " + haksa[i].getAge() + "\t" +
						(haksa[i].getKey()==1 ? job[0] : (haksa[i].getKey() == 2 ? job[1] : job[2])) + haksa[i].getValue());
		} else {
			System.out.println("등록된 사람이 없습니다.");
		}
		processExit();
	}

	@Override
	public void processExit() {
		try {
			System.out.print("\n계속 하시려면 1, 종료하시려면 0을 입력해주세요. ");
			if(in.readLine().equals("0"))
				System.exit(0);
			System.out.println();
			menu();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
