import java.util.Scanner;

public class GameImitationWithFunctions {
	static void outUnit(
			int order,
			double attack,
			double damage,
			double defense,
			double health
	) {
		System.out.print("Характеристики ");
		System.out.print(order);
		System.out.println(" персонажа:");
		System.out.print("Атака ");
		System.out.print(attack);
		System.out.println(" очков");
		System.out.print("Защита ");
		System.out.print(defense);
		System.out.println(" очков");
		System.out.print("Здоровье ");
		System.out.print(health);
		System.out.println(" очков");
		System.out.print("Урон ");
		System.out.print(damage);
		System.out.println(" очков");
	}

	static double calcHealthAfterAttack(
			double attack,
			double damage,
			double defense,
			double health
	) {
		double totalDamage = calcDamage(attack, damage, defense);
		if(health > totalDamage) {
			health = health - totalDamage;
		} else {
			health = 0;
		}
		return health;
	}

	static double calcDamage(double attack, double damage, double defense) {
		double totalDamage, percent;
		if(attack > defense) {
			percent = (attack - defense) * 0.05;
			if(percent > 4) {
				percent = 4;
			}
			totalDamage = damage * (1 + percent);
		} else {
			percent = (defense - attack) * 0.03;
			if(percent < 0.3) {
				percent = 0.3;
			}
			totalDamage = damage * (1 - percent);
		}
		return totalDamage;
	}

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
		System.out.println("1-ый персонаж атакует 2-ой персонаж");
		health2 = calcHealthAfterAttack(attack1, damage1, defense2, health2);
		if(health2 > 0) {
			outUnit(2, attack2, damage2, defense2, health2);
			System.out.println("2-ой персонаж даёт сдачи 1-му персонажу");
			health1 = calcHealthAfterAttack(attack2, damage2, defense1, health1);
			if(health1 > 0) {
				outUnit(1, attack1, damage1, defense1, health1);
				// 2-ой персонаж атакует 1-ый персонаж
			} else {
				System.out.println("1-ый персонаж убит");
			}
		} else {
			System.out.println("2-ой персонаж убит");
		}
		console.close();
	}
}
