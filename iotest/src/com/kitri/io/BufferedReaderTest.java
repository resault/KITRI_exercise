package com.kitri.io;

import java.io.*;

public class BufferedReaderTest {

	public static void main(String[] args) {
		BufferedReader fin = null;
		FileWriter fw = null; // String으로 출력하는 method가 있기 때문에 BufferedWriter 쓸 필요 없음
		try {
//			InputStream is = System.in;
//			Reader r = new InputStreamReader(is);
//			BufferedReader in = new BufferedReader(r);
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));// r과 is를 사용할 일 없으므로
			System.out.print("읽을 파일이름 : ");
			String inFile = in.readLine(); //readLine는 엔터를 기준으로 읽어들임(but, 엔터는 버퍼에 저장되지 않음)
//			System.out.println("infile == "+ inFile);

			System.out.print("복사할 파일이름 : ");
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
