public class Linoleum {
	int price;
	double width;
	double calcLength(double width, double length) {
		double length1 = Math.ceil(width / this.width) * length;
		double length2 = Math.ceil(length / this.width) * width;
		if(length1 < length2) {
			return length1;
		} else {
			return length2;
		}
//		return Math.min(length1, length2);
	}
	int calcPrice(double width, double length) {
		return (int)Math.ceil(calcLength(width, length) * price);
	}
}
