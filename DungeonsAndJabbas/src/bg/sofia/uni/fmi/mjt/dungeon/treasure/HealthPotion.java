package bg.sofia.uni.fmi.mjt.dungeon.treasure;

import bg.sofia.uni.fmi.mjt.dungeon.actor.Hero;

public class HealthPotion implements Treasure {
	private int healingPoints;

	public HealthPotion(int healingPoints) {
		this.healingPoints = healingPoints; // кон�?труктор, който прима �?ледните аргументи - int healingPoints
	}

	public int heal() {
		return healingPoints; // - връща точките кръв, които отварата добав�?
	}

	@Override
	public String collect(Hero hero) {
		if (hero.takeHealing(healingPoints)) {
			return "Health potion found! " + healingPoints + " health points added to your hero!"; // - към точките кръв
																									// �?е добав�?т тези
																									// от колбата �?
																									// отварата (кръвта
																									// на геро�? не може
																									// да �?тане повече
																									// от началната; ако
																									// геро�?т е �? 0
																									// кръв, колбата не
																									// прави нищо) и
																									// връща String,
																									// �?ъдържащ "Health
																									// potion found! X
																									// health points
																									// added to your
																									// hero!", където X
																									// �?а точките кръв,
																									// които �?ъдържа
																									// отварата (може да
																									// �?е различават от
																									// реално добавените
																									// към кръвта на
																									// геро�?)
		}
		return "";
	}

}
