public class Rect extends Dohyung {
	
	int width;
	int height;
	
	public Rect(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	@Override
	public double getArea() {
		return (double)(width * height);
	}
	
	@Override
	public double getRound() {
		return (double)((width + height) * 2);
	}
}
