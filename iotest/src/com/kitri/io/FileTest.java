package com.kitri.io;

import java.io.*;

public class FileTest {

	public static void main(String[] args) {
		InputStream in = null;
		OutputStream out = null;
		try {
			File infile = new File("d:\\iotest\\hello.txt");//pathname���� File �ν��Ͻ� ����
			long length = infile.length();//������ ũ�� ����
			byte b[] = new byte[(int)length];//byte �迭�� ũ�⸦ ���� ũ��� ����
			in = new FileInputStream(infile);//InputStream�� �߻�Ŭ�����̹Ƿ�, ����Ŭ������ ����
			int x = in.read(b);//������ ������ byte������ �о�ͼ� �迭�� �����ϰ�, �о�� byte���� ��ȯ
			String str = new String(b, 0, x);//�迭 b�� �ε��� 0���� �ε��� x(����ũ��)������ String���� ����
			System.out.println(x + "bytes read!!!");//����ũ��(�о�� byte ��)
			System.out.println(str);//���� ����
		
			File outfile = new File("e:\\iotest\\hello_copy.txt"); 
			out = new FileOutputStream(outfile);
			out.write(b);//infile�� ������ ���� ���� ���Ͽ� ����Ͽ� ����
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {//FileNotFoundE-�� IOE-�� ����Ŭ�����̹Ƿ� IOE-�� ���� ������ ������ ��� IOE-�� ó����
			e.printStackTrace();
		} finally {
			try {
				if(in != null)
					in.close();//���� ���� ������ ������� ����
				if(out != null)
					out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
