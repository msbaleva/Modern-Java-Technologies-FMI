package bg.sofia.uni.fmi.mjt.dungeon.actor;

import bg.sofia.uni.fmi.mjt.dungeon.treasure.Spell;
import bg.sofia.uni.fmi.mjt.dungeon.treasure.Weapon;

public class Hero implements Actor {
	private String name;
	private int health;
	private int maxHealth;
	private int mana;
	private int maxMana;
	private Position position;
	private Weapon weapon;
	private Spell spell;

	public Hero(String name, int health, int mana) {
		this.name = name;
		this.health = health;
		this.maxHealth = health;
		this.mana = mana;
		this.maxMana = mana;
		this.position = new Position(0, 0);
		this.weapon = null;
		this.spell = null;
	}

	public Hero(Hero other) {
		this.name = other.name;
		this.health = other.health;
		this.maxHealth = other.health;
		this.mana = other.mana;
		this.maxMana = other.mana;
		this.position = other.position;
		this.weapon = other.weapon;
		this.spell = other.spell;
	}

	@Override
	public String getName() {
		return name; // - връща името на геро�?
	}

	@Override
	public int getHealth() {
		return health; // - връща о�?таналата кръв на геро�?
	}

	@Override
	public int getMana() {
		return mana; // - връща о�?таналата мана на геро�?
	}

	public Position getPosition() {
		return position; // - връща текущата позици�? на геро�?
	}

	public boolean setPosition(Position position) {
		if (position == null) {
			return false;
		}
		this.position = position;
		return true;
	}

	@Override
	public boolean isAlive() {
		return health > 0;// - връща true, ако кръвта на геро�? е повече от 0
	}

	public boolean takeHealing(int healingPoints) {
		if (!isAlive() || healingPoints < 0) {
			return false;
		} else {
			if (healingPoints > maxHealth - health) {
				health = maxHealth;
			} else {
				health += healingPoints;
			}
			return true;// - ако геро�?т е жив, добав�? healingPoints към кръвта му, но не повече от
						// началната му кръв. �?ко геро�?т не е жив, не прави нищо
		}

	}

	@Override
	public boolean takeDamage(int damagePoints) {
		if (!isAlive() || damagePoints < 0) {
			return false; // - отнема кръв на геро�? (кръвта не може да бъде по-малко от 0)
		} else {
			if (damagePoints >= health) {
				health = 0;
			} else {
				health -= damagePoints;
			}
			return true;
		}
	}

	public boolean takeMana(int manaPoints) {
		if (!isAlive() || manaPoints < 0) {
			return false;
		} else {
			if (manaPoints > maxMana - mana) {
				mana = maxMana;
			} else {
				mana += manaPoints;
			}

			return true;
		}
		// - добав�? manaPoints към маната на геро�?, но не повече от началната
	}

	public boolean equip(Weapon weapon) {
		if (weapon == null) {
			return false;
		}
		if (this.weapon == null || this.weapon.getDamage() < weapon.getDamage()) {
			this.weapon = weapon;
			return true;// - въоръжава геро�? �? това оръжие (замен�? го, ако геро�?т има друго). �?ко
						// текущото оръжие на геро�? е по-�?илно, методът не прави нищо. Първоначално
						// в�?еки герой е без оръжие.
		}
		return false;
	}

	@Override
	public Weapon getWeapon() {
		return weapon;// - връща оръжието на геро�?
	}

	public boolean learn(Spell spell) {
		if (spell == null) {
			return false;
		}
		if (this.spell == null || this.spell.getDamage() < spell.getDamage()) {
			this.spell = spell;
			return true;
		}
		return false;// - геро�?т научава маги�?та (замен�? текущата, ако тази е по �?илна).
						// Първоначално
						// в�?еки герой н�?ма маги�?
	}

	@Override
	public Spell getSpell() {
		return spell; // - връща маги�?та
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
