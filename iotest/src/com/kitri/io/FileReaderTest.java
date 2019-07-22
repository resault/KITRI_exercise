package com.kitri.io;

import java.io.*;

public class FileReaderTest {

	public static void main(String[] args) {
		FileReader fr = null;
		FileWriter fw = null;
		try {
			//파일 특정
			File inFile = new File("E:\\iotest\\hello.txt"); //pathname으로 File 인스턴스 생성
			fr = new FileReader(inFile); //FileReader는 char단위로 데이터를 읽어옴. File인스턴스를 인자값으로 입력해서 생성
			System.out.println(fr); //FileReader에 입력된(?) 주소값이 출력됨
			
			//파일 내용 읽어오기
			long length = inFile.length(); //File의 length() : 파일 크기를 long으로 반환
			char c[] = new char[(int) length]; //파일 크기만큼의 char배열 생성 //cf.byte 단위로 읽어오는 InputStream을 쓸 때는 byte 배열 생성
			int x = fr.read(c); //FileReader의 상위클래스인 InputStreamReader의 read() : char단위로 읽어온 내용을 배열로 저장하고, char개수 int로 반환
			System.out.println(x + "characters read!!!");
			
			//파일 내용 출력
//			for(int i=0;i<(int)length;i++) { //char배열을 for문으로 돌려서 내용을 출력할 수도 있음
//				System.out.print(c[i]);
//			}
			String str = new String(c); // but, 이렇게 char 배열로 String 인스턴스를 생성하여 출력하는 것이 보다 효율적임!
			System.out.println(c);    

			
			File outFile = new File("E:\\iotest\\hello_copy2.txt");
			fw = new FileWriter(outFile);
			fw.write(str); // FileWriter의 write() char단위로 데이터 출력. 파일을 닫지 않으면 메모리상에서만 출력하기에 파일열어도 내용 없음
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
