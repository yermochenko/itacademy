public class Plaster {
	int price;
	double expense;
	int calcWeight(double area) {
		return (int)Math.ceil(area * expense);
	}
	int calcPrice(double area) {
		return calcWeight(area) * price;
	}
}
