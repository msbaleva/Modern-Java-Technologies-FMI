package bg.sofia.uni.fmi.mjt.dungeon.actor;

import bg.sofia.uni.fmi.mjt.dungeon.treasure.Spell;
import bg.sofia.uni.fmi.mjt.dungeon.treasure.Weapon;

public class Enemy implements Actor {
	private String name;
	private int health;
	private int mana;
	private Weapon weapon;
	private Spell spell;

	public Enemy(String name, int health, int mana, Weapon weapon, Spell spell) {
		this.name = name;
		this.health = health;
		this.mana = mana;
		this.weapon = weapon;
		this.spell = spell;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getHealth() {
		return health;
	}

	@Override
	public int getMana() {
		return mana;
	}

	@Override
	public boolean isAlive() {
		return health > 0;
	}

	@Override
	public Weapon getWeapon() {
		return weapon;
	}

	@Override
	public Spell getSpell() {
		return spell;
	}

	@Override
	public boolean takeDamage(int damagePoints) {
		if (!isAlive() || damagePoints < 0) {
			return false;
		} else {
			if (damagePoints >= health) {
				health = 0;
			} else {
				health -= damagePoints;
			}
			return true;
		}
	}

	@Override
	public int attack() {
		if (spell == null) {
			if (weapon == null) {
				return 0;
			} else {
				return weapon.getDamage();
			}
		}

		if (weapon == null || weapon.getDamage() < spell.getDamage()) {
			if (spell.getManaCost() <= mana) {
				mana -= spell.getManaCost();
				return spell.getDamage();
			} else {
				return (weapon == null) ? 0 : weapon.getDamage();
			}
		}

		return weapon.getDamage();
	}

}
