public class HackingPasswordTime {
	public static void main(String[] args) {
		int passwordLength = 27;
		int alphabetSize = 54;
		double timePerPassword = 3;
		final int SECONDS_PER_DAY = 86400;
		double totalTime = Math.pow(alphabetSize, passwordLength) * timePerPassword / SECONDS_PER_DAY;
		System.out.println(totalTime);
	}
}
