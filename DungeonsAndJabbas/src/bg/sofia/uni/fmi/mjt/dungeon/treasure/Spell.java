package bg.sofia.uni.fmi.mjt.dungeon.treasure;

import bg.sofia.uni.fmi.mjt.dungeon.actor.Hero;

public class Spell implements Treasure {

	private String name;
	private int damage;
	private int manaCost;

	public Spell(String name, int damage, int manaCost) {
		this.name = name;
		this.damage = damage;
		this.manaCost = manaCost;
	}

	
	public String getName() {
		return name; 
	}

	public int getDamage() {
		return damage; 
	}

	public int getManaCost() {
		return manaCost; 
	}

	@Override
	public String collect(Hero hero) {
		if (hero.learn(this)) {
			return "Spell found! Damage points: " + damage + ", Mana cost: " + manaCost; 
		}
		return null;
	}

}
