package bg.sofia.uni.fmi.mjt.dungeon.treasure;

import bg.sofia.uni.fmi.mjt.dungeon.actor.Hero;

public class Weapon implements Treasure {
	private String name;
	private int damage;

	public Weapon(String name, int damage) {
		this.name = name;
		this.damage = damage;
		// кон�?труктор, който прима �?ледните аргументи - String name, int damage
	}

	public String getName() {
		return name; // - връща името на оръжието
	}

	public int getDamage() {
		return damage; // - връща атаката на оръжието
	}

	@Override
	public String collect(Hero hero) {
		if (hero.equip(this)) {
			return "Weapon found! Damage points: " + damage; // - въоръжава геро�? �? това оръжие (ако то е по-�?илно от
																// текущото) и връща String, �?ъдържащ "Weapon found!
																// Damage points: X", където X е атаката на оръжието
		}
		return null;
	}

}
