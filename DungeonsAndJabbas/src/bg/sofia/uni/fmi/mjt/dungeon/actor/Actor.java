package bg.sofia.uni.fmi.mjt.dungeon.actor;

import bg.sofia.uni.fmi.mjt.dungeon.treasure.Spell;
import bg.sofia.uni.fmi.mjt.dungeon.treasure.Weapon;

public interface Actor {
	String getName();// - връща името на врага

	int getHealth();// - връща о�?таналата кръв на врага

	int getMana(); // - връща о�?таналата мана на врага

	boolean isAlive(); // - връща true, ако кръвта на врага е повече от 0

	Weapon getWeapon();// - връща оръжието на врага

	Spell getSpell(); // - връща маги�?та на врага

	boolean takeDamage(int damagePoints); // - отнема кръв на врага (кръвта не може да бъде по-малко от 0)

	int attack(); // - връща атакуващите точки врага - по-�?илното от оръжието и маги�?та (за да
					// �?е
					// използва маги�?, врагът тр�?бва да има поне толкова мана, колкото �?трува
					// маги�?та. При използване на маги�?, от маната �?е отнемат толкова точки,
					// колкото
					// �?трува маги�?та). Възможно е в даден момент врагът да има �?амо оръжие или
					// �?амо
					// маги�?

}
