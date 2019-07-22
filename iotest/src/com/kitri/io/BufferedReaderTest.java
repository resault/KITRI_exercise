package com.kitri.io;

import java.io.*;

public class BufferedReaderTest {

	public static void main(String[] args) {
		BufferedReader fin = null;
		FileWriter fw = null; // String���� ����ϴ� method�� �ֱ� ������ BufferedWriter �� �ʿ� ����
		try {
			//console���� ���� �̸�(���) �޾ƿ���
//			InputStream is = System.in;
//			Reader r = new InputStreamReader(is);
//			BufferedReader in = new BufferedReader(r);
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));// r�� is�� ����� �� �����Ƿ�
			System.out.print("���� �����̸� : ");
			String inFile = in.readLine(); //BufferedReader�� readLine() : ���͸� �������� �о String���� ��ȯ��(but, ���ʹ� ���ۿ� ������� ����)
			System.out.println("infile == "+ inFile);

			System.out.print("������ �����̸� : ");
			String outFile = in.readLine();
			fw = new FileWriter(new File(outFile));
			
			//���Ͽ��� ���� �о����
//			fin = new BufferedReader(new InputStreamReader(new FileInputStream(inFile)));//FileInputStream�� �����ڴ� File�� ���ڰ����� �޴µ�, �̷��� �ϸ� String�� ���ڰ����� �ذ� �Ǿ����
			fin = new BufferedReader(new InputStreamReader(new FileInputStream(new File(inFile))));
			String str = null;
			while((str = fin.readLine()) != null) {//buffer�� ����� ���ϳ����� ���ٴ����� �о �� ���� ������ ������ while���� ����
				System.out.println(str);//���� ������ �о�� ���� ������ ���
				fw.write(str + "\n\r");//������ ���Ͽ� File�� write()�� �̿��Ͽ� ���� ��� //���� �ݾƾ� �ݿ���
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
