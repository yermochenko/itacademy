public class Wallpaper {
	int price;
	double width;
	double length;
	int calcAmount(double perimeter, double height) {
		int bandsAmount = (int)Math.ceil(100 * perimeter / width);
		int bandsPerTubeAmount = (int)Math.floor(length / (100 * height));
		return (int)Math.ceil((double)bandsAmount / bandsPerTubeAmount);
	}
	int calcPrice(double perimeter, double height) {
		return calcAmount(perimeter, height) * price;
	}
}
