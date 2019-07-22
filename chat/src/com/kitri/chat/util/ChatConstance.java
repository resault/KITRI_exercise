package com.kitri.chat.util;

public class ChatConstance {

	//포트 번호를 상수로 지정
	public static final int PORT = 9876;
	
	/*
	Protocol 정의
	client >> server		- 여기의 client는 "나"
		접속				100|대화명
		모든사람메세지	200|메세지			- 대화명은 이미 서버에서 가지고 있음
		특정사람메세지	250|대상자|메세지
		쪽지보내기		300|대상자|메세지
		대화명변경		400|변경할대화명
		접속종료			900|				- 데이터가 없더라도 토큰은 넣어줘야 분리할 수 있음
	 */
	public static final int CS_CONNECT = 100;
	public static final int CS_ALL = 200;
	public static final int CS_TO = 250;
	public static final int CS_PAPER = 300;
	public static final int CS_RENAME = 400;
	public static final int CS_DISCONNECT = 900;
	
	/*
	server >> client		- 여기의 client는 상대방
		접속				100|접속자대화명
		메세지(전체)		200|[보낸사람대화명] 메세지
		메세지(특정)		200|☆보낸사람대화명☆ 메세지
		쪽지보내기		300|보낸사람대화명|메세지
		대화명변경		400|변경전대화명|변경할대화명
		접속종료			900|접속종료자대화명
	 */
	public static final int SC_CONNECT = 100;
	public static final int SC_MESSAGE = 200;
	public static final int SC_PAPER = 300;
	public static final int SC_RENAME = 400;
	public static final int SC_DISCONNECT = 900;
}
