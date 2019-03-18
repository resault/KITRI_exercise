public class Temp {

		String bookName;
		int price;


		public Temp(String bookName, int price) {
			this.bookName = bookName;
			this.price = price;
		}

		public void info() {
			System.out.println(bookName + " : " + price);
		}

}
