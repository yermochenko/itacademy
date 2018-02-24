import java.util.Scanner;

public class RepairCalculator {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		Repair repair = new Repair();
		System.out.println("Введите размеры комнаты");
		System.out.print("длина [м]: ");
		repair.length = console.nextDouble();
		System.out.print("ширина [м]: ");
		repair.width = console.nextDouble();
		System.out.print("высота [м]: ");
		repair.height = console.nextDouble();

		repair.plaster = new Plaster();
		System.out.print("Введите стоимость мешка (1 кг) штукатурки [коп.]: ");
		repair.plaster.price = console.nextInt();
		System.out.print("Введите расход штукатурки на 1 м² [кг]: ");
		repair.plaster.expense = console.nextDouble();

		repair.whitewash = new Whitewash();
		System.out.print("Введите стоимость банки (1 л) побелки [коп.]: ");
		repair.whitewash.price = console.nextInt();
		System.out.print("Введите расход побелки на 1 м² на первый слой [мл]: ");
		repair.whitewash.expenseFirstLayer = console.nextInt();
		System.out.print("Введите расход побелки на 1 м² на второй слой [мл]: ");
		repair.whitewash.expenseSecondLayer = console.nextInt();

		repair.wallpaper = new Wallpaper();
		System.out.print("Введите стоимость 1 трубки обоев [коп.]: ");
		repair.wallpaper.price = console.nextInt();
		System.out.print("Введите ширину трубки обоев [см]: ");
		repair.wallpaper.width = console.nextDouble();
		System.out.print("Введите длину трубки обоев [см]: ");
		repair.wallpaper.length = console.nextDouble();

		repair.linoleum = new Linoleum();
		System.out.print("Введите стоимость (1 м) линолеума [коп.]: ");
		repair.linoleum.price = console.nextInt();
		System.out.print("Введите ширину рулона линолеума [м]: ");
		repair.linoleum.width = console.nextDouble();

		int price = repair.totalPrice();
		System.out.print("Для ремонта Вам понадобится ");
		System.out.print(price / 100);
		System.out.print(" руб. ");
		System.out.print(price % 100);
		System.out.println(" коп.");
		console.close();
	}
}
