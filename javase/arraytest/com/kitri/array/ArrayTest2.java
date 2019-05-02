package com.kitri.array;

import java.io.UnsupportedEncodingException;

public class ArrayTest2 {

	public static void main(String[] args) throws UnsupportedEncodingException {
		Car car[] = new Car[6];
		car[0] = new Car("쏘나타", "검정색", "현대");
		car[1] = new Car("K5", "흰색", "기아");
		car[2] = new Car("SM5", "은색", "삼성");
		car[3] = new Car("아반떼", "흰색", "현대");
		car[4] = new Car("니어로", "비둘기색", "기아");
		car[5] = new Car("싼타페", "검정색", "현대");
		
		int len = car.length;
		for(int i=0;i<len;i++) {
			System.out.println(i + 1 + "번째구역 : " + car[i]);
		}
		
//		String name = "니어로";
		String name = "QM5";
//		비둘기색 니어로(기아)은 5번째에 있습니다.
//		QM5는 없습니다.
		Car findCar = null;
		int count = 0;
		for(int i=0;i<len;i++) {
			if(name.equals(car[i].getCarName())) {			
				findCar = car[i];
				count = i + 1;
				break;
			}
		}
		
		if(findCar != null) {
			System.out.println(findCar.getColor() + " " + 
					findCar.getCarName() + "(" + findCar.getMaker() + ")은 "+ 
					count + "번째구역에 있습니다.");
		} else {	
			System.out.println(name + "은 없습니다.");
		}
		
	}
	
}


