public class Circle implements DohyungArea {

	int radius;

	public Circle(int radius) {
		this.radius = radius;
	}

	@Override
	public double getArea() {
		return Math.pow(radius, 2) * Math.PI;
		//return radius*radius*3.14;
	}


	
}
