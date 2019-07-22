package com.kitri.haksa.service;

import java.io.*;
import java.util.ArrayList;

import com.kitri.haksa.data.HaksaDto;


public class HaksaServiceImpl implements HaksaService {

	private ArrayList<HaksaDto> list = new ArrayList<HaksaDto>();
	private String[] job = {"�� �� : ", "�� �� : ", "�� �� : "};
	private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	

	@Override
	public void menu() {
		System.out.println("========== �޴� ���� ==========");
		System.out.println("1. ���");
		System.out.println("2. ã��");
		System.out.println("3. ����");
		System.out.println("4. ��ü ���");
		System.out.println("-------------------");
		System.out.println("0. ����");
		System.out.println("-------------------");
		System.out.print("��ȣ�� ������ �ּ���..");
		
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
				System.out.println("�߸� �Է��Ͽ����ϴ�.\n");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void registerMenu() {
			try {
				System.out.println("\n========== �޴� ���� ==========");
				System.out.println("1. �л�");
				System.out.println("2. ����");
				System.out.println("3. ������");
				System.out.println("4. �����޴�");
				System.out.print("��ȣ�� ������ �ּ���..");

				String x = in.readLine().trim();
				if(!x.equals("4")) {
					if(x.equals("1") || x.equals("2") || x.equals("3")) {
						int key = Integer.parseInt(x);
						System.out.print("�� �� : ");
						String ageStr = in.readLine().trim(); 
						int size = ageStr.length();
						
						for(int i=0;i<size;i++) {
							int check = ageStr.charAt(i) - 48;
							if(check < 0 && check >= 10) {
								System.out.println("���̴� ���ڷ� �Է��� �� �����ϴ�.");
								registerMenu();
								return;
							}
						}
						
						int age = Integer.parseInt(ageStr);
						System.out.print("�� �� : ");
						String name = in.readLine().trim();
						System.out.print((key==1 ? job[0] : (key==2 ? job[1] : job[2])));
						String value = in.readLine().trim();
						register(new HaksaDto(age, name, key, value));
						return;
					}
					System.out.println("�߸� �Է��Ͽ����ϴ�.");
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
		System.out.println("����� �Ϸ�Ǿ����ϴ�.");
		processExit();
	}

	@Override
	public void findNameMenu() {
		System.out.println("ã�� �̸��� �Է��� �ּ���.");
		System.out.print("�̸� : ");
		try {
			String name = in.readLine();
			HaksaDto haksa = findName(name);
			if(haksa != null)
				System.out.println("���� : " + haksa.getAge() + "\t�̸� : " + haksa.getName() + "\t" + 
						(haksa.getKey()==1 ? job[0] : (haksa.getKey() == 2 ? job[1] : job[2])) + haksa.getValue());
			else
				System.out.println(name + "���� ��ϵ��� ���� ����Դϴ�.");
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
		System.out.println("������ ����� �̸��� �Է��� �ּ���.");
		System.out.print("�̸� : ");
		try {
			String name = in.readLine();
			int result = delete(name);
			if(result != 0)
				System.out.println(name + "���� ���� �Ͽ����ϴ�.");
			else
				System.out.println(name + "���� ��ϵ��� ���� ����Դϴ�.");
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
				System.out.println("�̸� : " + haksa[i].getName() + "\t���� : " + haksa[i].getAge() + "\t" +
						(haksa[i].getKey()==1 ? job[0] : (haksa[i].getKey() == 2 ? job[1] : job[2])) + haksa[i].getValue());
		} else {
			System.out.println("��ϵ� ����� �����ϴ�.");
		}
		processExit();
	}

	@Override
	public void processExit() {
		try {
			System.out.print("\n��� �Ͻ÷��� 1, �����Ͻ÷��� 0�� �Է����ּ���. ");
			if(in.readLine().equals("0"))
				System.exit(0);
			System.out.println();
			menu();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
