public class Person {
	String name;
	String className;
	double attack;
	double defense;
	double health;
	double damage;

	void attack(Person attacking) {
		if(attacking != this) {
			double totalDamage = calcDamage(attacking);
			if(health > totalDamage) {
				health = health - totalDamage;
			} else {
				health = 0;
			}
		}
	}

	double calcDamage(Person attacking) {
		double totalDamage, percent;
		if(attacking.attack > defense) {
			percent = (attacking.attack - defense) * 0.05;
			if(percent > 4) {
				percent = 4;
			}
			totalDamage = attacking.damage * (1 + percent);
		} else {
			percent = (defense - attacking.attack) * 0.03;
			if(percent < 0.3) {
				percent = 0.3;
			}
			totalDamage = attacking.damage * (1 - percent);
		}
		return totalDamage;
	}

	boolean isAlive() {
		return health > 0;
	}
}
