public class Repair {
	double length;
	double width;
	double height;
	Plaster plaster;
	Whitewash whitewash;
	Wallpaper wallpaper;
	Linoleum linoleum;
	int totalPrice() {
		double roomArea = length * width;
		double roomPerimeter = 2 * (width + length);
		double wallArea = roomPerimeter * height;
		return plaster.calcPrice(roomArea + wallArea) +
		       whitewash.calcPrice(roomArea) +
		       wallpaper.calcPrice(roomPerimeter, height) +
		       linoleum.calcPrice(width, length);
	}
}
