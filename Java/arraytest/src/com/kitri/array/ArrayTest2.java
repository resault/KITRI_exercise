package com.kitri.array;

public class ArrayTest2 {

	public static void main(String[] args) {
		Car car[] = new Car[6];
		System.out.println(car);
		System.out.println(car[0]);
//		System.out.println(car[0].getCarName());//car[0]이 null이라서 null point exception
		car[0] = new Car("쏘나타", "검정색", "현대");
		car[1] = new Car("K5", "흰색", "기아");
		car[2] = new Car("SM5", "은색", "삼성");
		car[3] = new Car("아반떼", "흰색", "현대");
		car[4] = new Car("니어로", "비둘기색", "기아");
		car[5] = new Car("싼타페", "검정색", "현대");

		int len = car.length;
		for (int i = 0; i < len; i++)
			System.out.println(i + 1 + "번째구역 : " + car[i]);

		// 니어로 찾기
		String name = "니어로";
//		int num = 0;
//		for(int i=0;i<=len;i++) {
//			if(car[i].getCarName() == "니어로") {//문자열은 == 쓰지 말것!!
//				num = i;
//				break;
//			}
//		}
//		
//		//비둘기색 니어로(기아)은 5번째에 있습니다.
//		System.out.println(car[num].getColor()+ " "+ car[num].getCarName() + "("+car[num].getMaker()+")은 "+(num+1)+"번째에 있습니다.");

		for (int i = 0; i < len; i++) {
			if (name.equals(car[i].getCarName())) {
				System.out.println(car[i].getColor() + " " + car[i].getCarName() + "(" + car[i].getMaker() + ")은 "
						+ (i + 1) + "번째에 있습니다.");
				break;
			}
		}

		// QM5 찾기 //answer 참고!!
		

		/*
		 * boolean check = true;
		 * 
		 * for (int i = 0; i < len; i++) { if (name.equals(car[i].getCarName())) {
		 * System.out.println(car[i].getColor() + " " + car[i].getCarName() + "(" +
		 * car[i].getMaker() + ")은 " + (i + 1) + "번째에 있습니다."); check = true; break; }
		 * else { check = false; } } if (check = false) System.out.println(name +
		 * "은 없습니다.");
		 */

		name = "QM5";
		Car findCar = null;
		
		int count = 0;
		len = car.length;
		for (int i = 0; i < len; i++) {
			if(name.equals(car[i].getCarName())) {
				findCar = car[i];
				count = i + 1;
			}
		}
		
		if (findCar != null) {
			System.out.println(findCar.getColor() + " " + findCar.getCarName() + "(" + findCar.getMaker() + ")" + "은 " + count + "번째에 있습니다.");			
		} else {
			System.out.println(name + "은 없습니다.");
		}
		// switch는 안되나?
	}
}
