package com.kitri.lang;

public class StringBufferTest1 {
	
	public static void main(String[] args) {
		
		// 1. 생성자
		// StringBuffer() : default 생성자
		StringBuffer sb1 = new StringBuffer();//16개의 문자가 들어갈 수 있는 빈 임시저장 공간 생성
		
			// capacity() : 초기 크기
		int cap = sb1.capacity();
		System.out.println(cap); //16
		
			// length() : 저장된 문자의 크기
		System.out.println("문자열 수 : " + sb1.length()); //0
		
		
		// StringBuffer(int capacity) : 인자값만큼의 임시저장 공간 생성(통상 8의 배수로 사용함)
		//근데 문자로 지정해도 글자수보다 큰 공간이 잡히기때문에 별 의미 없음
		
		// StringBuffer(CharSequence seq) | StringBuffer(String str) : 문자열을 가지고 임시저장 공간 생성
		// CharSequence는 interface 
		sb1 = new StringBuffer("hello");
		cap = sb1.capacity();
		System.out.println("1. sb1 == " + sb1);
		System.out.println("크기" + sb1.capacity() + "문자열 수 : " + sb1.length());
		

		
		//append() : String의 concat과 달리 문자열 자체가 바뀜
		sb1.append(" java");
		System.out.println("2. sb1 == " + sb1);//hello java
		
			//cf.
		String s = "hello";
		s.concat("java");
		System.out.println(s);//hello

		sb1.append(" !!!!!");
		System.out.println("3. sb1 == " + sb1);//hello java !!!!!
		cap = sb1.capacity();
		System.out.println("크기 : " +cap + "\t문자열 수 : " + sb1.length());
		
		sb1.append(" !!!!!!");
		System.out.println("4. sb1 == " + sb1);//hello java !!!!! !!!!!!
		cap = sb1.capacity();
		System.out.println("크기 : " +cap + "\t문자열 수 : " + sb1.length()); //공간을 넘어서면 자동으로 늘어남

		
		// 2. method
		
		// 1) charAt(int index)
		
		
		// 2) insert(int offset, 입력할 data) : 시작 위치에 인자값 입력
		sb1.insert(10, "@@@");
		System.out.println("5. sb1 == " + sb1);

		
		// 3) delete(int start, int end) : start부터 end 위치 전까지 삭제
		sb1.delete(10, 12);
		System.out.println("6. sb1 == " + sb1);
		
		
		// 4) deleteCharAt(int index) : index 위치의 값 삭제
		sb1.deleteCharAt(10);
		System.out.println("7. sb1 == " + sb1);
		
		
		// 5) indexOf(String str)
		
		
		// 6) replace(int start, int end, String str) : start부터 end전까지 str로 대체 (cf. String의 replace)
		sb1.replace(6, 10, "자바");
		System.out.println("8. sb1 == " + sb1);
		
		
		// 7) reverse()
		sb1.reverse();
		System.out.println("9. sb1 == " + sb1);
		sb1.reverse();
		
		
		// 8) setCharAt(int index, char ch) : index의 값을 char로 지정
		sb1.setCharAt(9, '@');
		System.out.println("10. sb1 == " + sb1);
		
		
		// 9) substring(int start)
		
		
		// 최종적으로 sb1에는 StringBuffer가 들어있으므로 String으로 바꿔줘야 함 (2가지 방법)
		// String 생성자 이용
		String s1 = new String(sb1);
		// StringBuffer의 toString()이용
		String s2 = sb1.toString();

		
		// 예제
		String str = "hello 자바 !!!";
		String findstr = "자바";
//		String findstr = "오라클";
		String restr = "java";
		
		//hello java !!!
		//오라클은 없습니다.
		int start = str.indexOf(findstr);
		
		if(start != 0) {
			StringBuffer sb = new StringBuffer(str);
			int end = start + findstr.length();
//			System.out.println(start + restr.length() -1);
			sb.replace(start, end, restr);
			System.out.println(sb.toString());
		} else {
			System.out.println(findstr + "은 없습니다.");
		}
		
		
		// 예제 다시!!
		
		

	}
}
