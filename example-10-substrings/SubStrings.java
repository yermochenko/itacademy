import java.util.Scanner;

public class SubStrings {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		System.out.print("Введите строку: ");
		String str = console.nextLine();
		System.out.print("Введите подстроку: ");
		String substr = console.nextLine();
		int index = -1;
		while((index = str.indexOf(substr, index + 1)) != -1) {
			System.out.println(index);
		}
		int index1, index2 = -1, counter = 0;
		String result;
		while((index1 = str.indexOf("[", index2 + 1)) != -1) {
			index2 = str.indexOf("]", index1 + 1);
			if(index2 != -1) {
				result = str.substring(index1 + 1, index2);
				counter = counter + 1;
				System.out.print(counter);
				System.out.print(". ");
				System.out.println(result);
			} else {
				System.out.print("открывающаяся квадратная скобка в ");
				System.out.print(index1 + 1);
				System.out.println(" позиции не закрыта");
				break;
			}
		}
		if(counter == 0) {
			System.out.println("нет цитат в квадратных скобках");
		}
		console.close();
	}
}
