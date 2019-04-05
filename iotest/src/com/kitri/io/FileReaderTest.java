package com.kitri.io;

import java.io.*;

public class FileReaderTest {

	public static void main(String[] args) {
		FileReader fr = null;
		FileWriter fw = null;
		try {
			//���� Ư��
			File inFile = new File("E:\\iotest\\hello.txt"); //pathname���� File �ν��Ͻ� ����
			fr = new FileReader(inFile); //FileReader�� char������ �����͸� �о��. File�ν��Ͻ��� ���ڰ����� �Է��ؼ� ����
			System.out.println(fr); //FileReader�� �Էµ�(?) �ּҰ��� ��µ�
			
			//���� ���� �о����
			long length = inFile.length(); //File�� length() : ���� ũ�⸦ long���� ��ȯ
			char c[] = new char[(int) length]; //���� ũ�⸸ŭ�� char�迭 ���� //cf.byte ������ �о���� InputStream�� �� ���� byte �迭 ����
			int x = fr.read(c); //FileReader�� ����Ŭ������ InputStreamReader�� read() : char������ �о�� ������ �迭�� �����ϰ�, char���� int�� ��ȯ
			System.out.println(x + "characters read!!!");
			
			//���� ���� ���
//			for(int i=0;i<(int)length;i++) { //char�迭�� for������ ������ ������ ����� ���� ����
//				System.out.print(c[i]);
//			}
			String str = new String(c); // but, �̷��� char �迭�� String �ν��Ͻ��� �����Ͽ� ����ϴ� ���� ���� ȿ������!
			System.out.println(c);    

			
			File outFile = new File("E:\\iotest\\hello_copy2.txt");
			fw = new FileWriter(outFile);
			fw.write(str); // FileWriter�� write() char������ ������ ���. ������ ���� ������ �޸𸮻󿡼��� ����ϱ⿡ ���Ͽ�� ���� ����
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fw != null)
					fw.close();
				if (fr != null)
					fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
