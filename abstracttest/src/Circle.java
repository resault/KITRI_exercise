public class Circle extends Dohyung {

	int radius;

	public Circle(int radius) {
		this.radius = radius;
	}

	@Override
	public double getArea() {
		return Math.pow(radius, 2) * Math.PI;
		//return radius*radius*3.14;
	}

	@Override
	public double getRound() {
		return 2 * Math.PI * radius;
		//return radius*2*3.14;

	}
}
