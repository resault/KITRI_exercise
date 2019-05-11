
public class Temp {

	///// 인스턴스 멤버 /////
	
//	- 인스턴스 필드
	String isTempStr = "임시";
	String isTempStrP; 
	
//	- 생성자
	public Temp() {
		isTempStrP = isTempStr + "테스트";
	}
	
//	- 인스턴스 메소드
	void isTemp() {
		System.out.println(isTempStr);
		System.out.println(isTempStrP);
	}
	
	
	
	///// 정적 멤버 /////
	
//	- 정적 필드
	static String stTempStr = "temp";
	static String stTempStrP;
	
//	- static 블록 : 정적 필드 초기화
	static {
		stTempStrP = stTempStr + " Test";
	}
	
//	- 정적 메소드
    static void stTemp() {
    	System.out.println(stTempStr); //(o)
    	System.out.println(stTempStrP);	//(o)
    	
//    	System.out.println(isTempStr); //(x)

    	Temp temp = new Temp();
    	System.out.println(temp.isTempStr); //(o)  but, 이렇게 사용할 일이 있을지는 모르겠음
    }
    
    
    
    public static void main(String[] args) {
		// 정적 메소드 호출
    	Temp.stTemp();
		
		// 객체 생성 및 인스턴스 메소드 호출
		Temp temp = new Temp();
		temp.isTemp();
	}
}
