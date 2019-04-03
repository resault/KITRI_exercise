package com.kitri.io;

import java.io.*;

public class BufferedReaderTest {

	public static void main(String[] args) {
		BufferedReader fin = null;
		FileWriter fw = null; // String���� ����ϴ� method�� �ֱ� ������ BufferedWriter �� �ʿ� ����
		try {
//			InputStream is = System.in;
//			Reader r = new InputStreamReader(is);
//			BufferedReader in = new BufferedReader(r);
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));// r�� is�� ����� �� �����Ƿ�
			System.out.print("���� �����̸� : ");
			String inFile = in.readLine(); //readLine�� ���͸� �������� �о����(but, ���ʹ� ���ۿ� ������� ����)
//			System.out.println("infile == "+ inFile);

			System.out.print("������ �����̸� : ");
			String outFile = in.readLine();
			fw = new FileWriter(new File(outFile));
			
//			fin = new BufferedReader(new InputStreamReader(new FileInputStream(inFile)));
			fin = new BufferedReader(new InputStreamReader(new FileInputStream(new File(inFile))));
			String str = null;
			while((str = fin.readLine()) != null) {
				System.out.println(str);
				fw.write(str + "\n\r");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fw !=null)
					fw.close();
				if(fin !=null)
					fin.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
