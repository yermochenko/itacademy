public class Whitewash {
	int price;
	int expenseFirstLayer;
	int expenseSecondLayer;
	int calcVolume(double area) {
		return (int)Math.ceil(
			area * (expenseFirstLayer + expenseSecondLayer) / 1000
		);
	}
	int calcPrice(double area) {
		return calcVolume(area) * price;
	}
}
