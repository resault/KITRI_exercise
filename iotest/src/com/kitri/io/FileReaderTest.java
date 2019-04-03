package com.kitri.io;

import java.io.*;

public class FileReaderTest {

	public static void main(String[] args) {
		FileReader fr = null;
		FileWriter fw = null;
		try {
			File inFile = new File("E:\\iotest\\hello.txt");
			fr = new FileReader(inFile);
			System.out.println(fr);
			long length = inFile.length();
			char c[] = new char[(int) length];
			int x = fr.read(c);
			System.out.println(x + "characters read!!!");
			String str = new String(c);
			System.out.println(c);

			File outFile = new File("E:\\iotest\\hello_copy2.txt");
			fw = new FileWriter(outFile);
			fw.write(str); // 파일을 닫지 않으면 입력되지 않음
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
