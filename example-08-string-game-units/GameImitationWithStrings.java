import java.util.Scanner;

public class GameImitationWithStrings {
	static void outPerson(Person person) {
		System.out.print("Характеристики персонажа ");
		System.out.print(person.className);
		System.out.print(" ");
		System.out.print(person.name);
		System.out.println(":");
		System.out.print("Атака ");
		System.out.print(person.attack);
		System.out.println(" очков");
		System.out.print("Защита ");
		System.out.print(person.defense);
		System.out.println(" очков");
		System.out.print("Здоровье ");
		System.out.print(person.health);
		System.out.println(" очков");
		System.out.print("Урон ");
		System.out.print(person.damage);
		System.out.println(" очков");
	}

	static Person inPerson(Scanner console) {
		Person person = new Person();
		System.out.print("Введите класс персонажа: ");
		person.className = console.nextLine();
		System.out.print("Введите имя персонажа: ");
		person.name = console.nextLine();
		System.out.println("Введите характеристики персонажа.");
		System.out.print("Атака: ");
		person.attack = console.nextDouble();
		System.out.print("Защита: ");
		person.defense = console.nextDouble();
		System.out.print("Здоровье: ");
		person.health = console.nextDouble();
		System.out.print("Урон: ");
		person.damage = console.nextDouble();
		console.nextLine();
		return person;
	}

	static void outMessage(Person attacking, Person defensible, String message) {
		System.out.print("Персонаж ");
		System.out.print(attacking.className);
		System.out.print(" ");
		System.out.print(attacking.name);
		System.out.print(message);
		System.out.print(defensible.className);
		System.out.print(" ");
		System.out.print(defensible.name);
		System.out.println(".");
	}

	static void outAttackMessage(Person attacking, Person defensible) {
		outMessage(attacking, defensible, " нападает на персонаж ");
	}

	static void outCounterstrikeMessage(Person attacking, Person defensible) {
		outMessage(attacking, defensible, " даёт сдачи персонажу ");
	}

	static void outKilledMessage(Person person) {
		System.out.print(person.className);
		System.out.print(" ");
		System.out.print(person.name);
		System.out.println(" убит.");
	}

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		Person person1 = inPerson(console);
		Person person2 = inPerson(console);
		outAttackMessage(person1, person2);
		person2.attack(person1);
		if(person2.isAlive()) {
			outPerson(person2);
			outCounterstrikeMessage(person2, person1);
			person1.attack(person2);
			if(person1.isAlive()) {
				outPerson(person1);
				outAttackMessage(person2, person1);
				person1.attack(person2);
				if(person1.isAlive()) {
					outPerson(person1);
					outCounterstrikeMessage(person1, person2);
					person2.attack(person1);
					if(person2.isAlive()) {
						System.out.println("Бой окончен в ничью");
						outPerson(person1);
						outPerson(person2);
					} else {
						outKilledMessage(person2);
					}
				} else {
					outKilledMessage(person1);
				}
			} else {
				outKilledMessage(person1);
			}
		} else {
			outKilledMessage(person2);
		}
		console.close();
	}
}
