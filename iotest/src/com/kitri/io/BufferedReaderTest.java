package com.kitri.io;

import java.io.*;

public class BufferedReaderTest {

	public static void main(String[] args) {
		BufferedReader fin = null;
		FileWriter fw = null; // String으로 출력하는 method가 있기 때문에 BufferedWriter 쓸 필요 없음
		try {
			//console에서 파일 이름(경로) 받아오기
//			InputStream is = System.in;
//			Reader r = new InputStreamReader(is);
//			BufferedReader in = new BufferedReader(r);
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));// r과 is를 사용할 일 없으므로
			System.out.print("읽을 파일이름 : ");
			String inFile = in.readLine(); //BufferedReader의 readLine() : 엔터를 기준으로 읽어서 String으로 반환함(but, 엔터는 버퍼에 저장되지 않음)
			System.out.println("infile == "+ inFile);

			System.out.print("복사할 파일이름 : ");
			String outFile = in.readLine();
			fw = new FileWriter(new File(outFile));
			
			//파일에서 내용 읽어오기
//			fin = new BufferedReader(new InputStreamReader(new FileInputStream(inFile)));//FileInputStream의 생성자는 File을 인자값으로 받는데, 이렇게 하면 String을 인자값으로 준게 되어버림
			fin = new BufferedReader(new InputStreamReader(new FileInputStream(new File(inFile))));
			String str = null;
			while((str = fin.readLine()) != null) {//buffer에 저장된 파일내용을 한줄단위로 읽어서 더 읽을 내용이 없으면 while문이 끝남
				System.out.println(str);//한줄 단위로 읽어온 파일 내용을 출력
				fw.write(str + "\n\r");//복사할 파일에 File의 write()를 이용하여 내용 출력 //파일 닫아야 반영됨
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
