package bg.sofia.uni.fmi.mjt.dungeon.treasure;

import bg.sofia.uni.fmi.mjt.dungeon.actor.Hero;

public class ManaPotion implements Treasure {
	private int manaPoints;

	public ManaPotion(int manaPoints) {
		this.manaPoints = manaPoints; // кон�?труктор, който прима �?ледните аргументи - int manaPoints
	}

	public int heal() {
		return manaPoints; // - връща точките мана, които отварата добав�?
	}

	@Override
	public String collect(Hero hero) {
		if (hero.takeMana(manaPoints)) {
			return "Mana potion found! " + manaPoints + " mana points added to your hero!"; // - към точките мана �?е
																							// добав�?т тези от колбата
																							// �?
																							// мана (маната на геро�? не
																							// може да �?тане повече от
																							// началната) и връща
																							// String, �?ъдържащ "Mana
																							// potion found! X mana
																							// points added to your
																							// hero!", където X �?а
																							// точките мана, които
																							// �?ъдържа отварата (може
																							// да
																							// �?е различават от реално
																							// добавените към маната на
																							// геро�?)
		}
		return "";
	}

}
