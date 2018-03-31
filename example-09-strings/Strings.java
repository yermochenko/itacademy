import java.util.Scanner;

public class Strings {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		System.out.print("Введите строку: ");
		String str = console.nextLine();
		int size = str.length();
		System.out.print("Размер строки ");
		System.out.print(size);
		System.out.println(" символов");
		int index = 0, count = 0;
		String newStr = new String();
		while(index < size) {
			char c = str.charAt(index);
			if(c == 'a') {
				count = count + 1;
				newStr = newStr + '_'; // конкатенация
			} else {
				newStr = newStr + c; // конкатенация
			}
			index = index + 1;
		}
		System.out.println(count);
		System.out.println(newStr);
		console.close();
	}
}
