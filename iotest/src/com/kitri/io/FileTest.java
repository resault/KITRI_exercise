package com.kitri.io;

import java.io.*;

public class FileTest {

	public static void main(String[] args) {
		InputStream in = null;
		OutputStream out = null;
		try {
			File infile = new File("d:\\iotest\\hello.txt");//pathname으로 File 인스턴스 생성
			long length = infile.length();//파일의 크기 리턴
			byte b[] = new byte[(int)length];//byte 배열의 크기를 파일 크기로 지정
			in = new FileInputStream(infile);//InputStream은 추상클래스이므로, 하위클래스로 생성
			int x = in.read(b);//파일의 내용을 byte단위로 읽어와서 배열에 저장하고, 읽어온 byte수를 반환
			String str = new String(b, 0, x);//배열 b의 인덱스 0부터 인덱스 x(파일크기)까지를 String으로 생성
			System.out.println(x + "bytes read!!!");//파일크기(읽어온 byte 수)
			System.out.println(str);//파일 내용
		
			File outfile = new File("e:\\iotest\\hello_copy.txt"); 
			out = new FileOutputStream(outfile);
			out.write(b);//infile의 내용을 새로 만든 파일에 출력하여 저장
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {//FileNotFoundE-은 IOE-의 하위클래스이므로 IOE-가 먼저 나오면 파일이 없어도 IOE-로 처리됨
			e.printStackTrace();
		} finally {
			try {
				if(in != null)
					in.close();//파일 닫지 않으면 저장되지 않음
				if(out != null)
					out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
