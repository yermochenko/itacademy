import java.util.Scanner;

public class GameImitation {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		System.out.println("Введите характеристики 1-го персонажа.");
		System.out.print("атака: ");
		double attack1 = console.nextDouble();
		System.out.print("защита: ");
		double defense1 = console.nextDouble();
		System.out.print("здоровье: ");
		double health1 = console.nextDouble();
		System.out.print("урон: ");
		double damage1 = console.nextDouble();
		System.out.println("Введите характеристики 2-го персонажа.");
		System.out.print("атака: ");
		double attack2 = console.nextDouble();
		System.out.print("защита: ");
		double defense2 = console.nextDouble();
		System.out.print("здоровье: ");
		double health2 = console.nextDouble();
		System.out.print("урон: ");
		double damage2 = console.nextDouble();
		double totalDamage, percent;
		System.out.println("1-ый персонаж атакует 2-ой персонаж");
		if(attack1 > defense2) {
			percent = (attack1 - defense2) * 0.05;
			if(percent > 4) {
				percent = 4;
			}
			totalDamage = damage1 * (1 + percent);
		} else {
			percent = (defense2 - attack1) * 0.03;
			if(percent > 0.3) {
				percent = 0.3;
			}
			totalDamage = damage1 * (1 - percent);
		}
		if(health2 > totalDamage) {
			health2 = health2 - totalDamage;
		} else {
			health2 = 0;
		}
		if(health2 > 0) {
			System.out.print("Здоровье 2-ого персонажа ");
			System.out.print(health2);
			System.out.println(" очков");
		} else {
			System.out.println("2-ой персонаж убит");
		}
		console.close();
	}
}
