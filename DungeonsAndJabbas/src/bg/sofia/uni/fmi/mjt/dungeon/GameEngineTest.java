package bg.sofia.uni.fmi.mjt.dungeon;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import bg.sofia.uni.fmi.mjt.dungeon.actor.Enemy;
import bg.sofia.uni.fmi.mjt.dungeon.actor.Hero;
import bg.sofia.uni.fmi.mjt.dungeon.treasure.HealthPotion;
import bg.sofia.uni.fmi.mjt.dungeon.treasure.ManaPotion;
import bg.sofia.uni.fmi.mjt.dungeon.treasure.Spell;
import bg.sofia.uni.fmi.mjt.dungeon.treasure.Treasure;
import bg.sofia.uni.fmi.mjt.dungeon.treasure.Weapon;

public class GameEngineTest {
	private Hero hero;
	private char[][] map;
	private Enemy[] enemies;
	private Treasure[] treasures;
	private GameEngine gameEngine;
	private HealthPotion healthPotion;
	private ManaPotion manaPotion;
	private Spell spell;
	private Weapon weapon;

	@Before
	public void setup() {
		hero = new Hero("hero", 100, 100);
		map = new char[][] { "###".toCharArray(), "TS.".toCharArray(), "TEG".toCharArray() };
		enemies = new Enemy[] { new Enemy("enemy", 100, 0, new Weapon("enemy weapon", 30), null) };
		treasures = new Treasure[] { new Weapon("strong weapon", 50), new Spell("strong spell", 55, 50) };
		gameEngine = new GameEngine(map, hero, enemies, treasures);
		healthPotion = new HealthPotion(10);
		manaPotion = new ManaPotion(10);
		spell = new Spell("strong spell", 50, 50);
		weapon = new Weapon("first", 10);
	}

	@Test
	public void testHeroClass() {
		String name = "hero";
		assertEquals(gameEngine.getHero().getName(), name);
		int points = 100;
		assertEquals(gameEngine.getHero().getHealth(), points);
		assertEquals(gameEngine.getHero().getMana(), points);
		assertEquals(gameEngine.getHero().isAlive(), true);
		assertEquals(gameEngine.getHero().takeHealing(10), true);
		assertEquals(gameEngine.getHero().takeMana(10), true);
		assertEquals(gameEngine.getHero().getHealth(), points);
		assertEquals(gameEngine.getHero().getMana(), points);
	}

	@Test
	public void testEnemyClass() {
		String name = "enemy";
		assertEquals(enemies[0].getName(), name);
		int points = 100;
		int manaPoints = 0;
		assertEquals(enemies[0].getHealth(), points);
		assertEquals(enemies[0].getMana(), manaPoints);
		assertEquals(enemies[0].getWeapon().getName(), "enemy weapon");
		assertEquals(enemies[0].getSpell(), null);
		assertEquals(enemies[0].isAlive(), true);
	}

	@Test
	public void testHealthPotionClass() {
		int points = 10;
		String str = "Health potion found! " + points + " health points added to your hero!";
		assertEquals(healthPotion.heal(), points);
		assertEquals(healthPotion.collect(hero), str);
	}

	@Test
	public void testManaPotionClass() {
		int points = 10;
		String str = "Mana potion found! " + points + " mana points added to your hero!";
		assertEquals(manaPotion.heal(), points);
		assertEquals(manaPotion.collect(hero), str);
	}

	@Test
	public void testSpellClass() {
		int points = 50;
		String str = "Spell found! Damage points: " + spell.getDamage() + ", Mana cost: " + spell.getManaCost();
		String str2 = "strong spell";
		assertEquals(spell.getDamage(), points);
		assertEquals(spell.getManaCost(), points);
		assertEquals(spell.collect(hero), str);
		assertEquals(spell.getName(), str2);
	}

	@Test
	public void testWeaponClass() {
		int points = 10;
		String str = "Weapon found! Damage points: " + weapon.getDamage();
		String str2 = "first";
		assertEquals(weapon.getDamage(), points);
		assertEquals(weapon.collect(hero), str);
		assertEquals(weapon.getName(), str2);
	}

	@Test
	public void testMoveToEmptyBlock() {
		String moveMessage = gameEngine.makeMove(Direction.RIGHT);

		assertEquals("You moved successfully to the next position.", moveMessage);
		assertEquals('.', gameEngine.getMap()[1][1]);
		assertEquals('H', gameEngine.getMap()[1][2]);
	}

	@Test
	public void testBattle() {
		String moveMessage = gameEngine.makeMove(Direction.DOWN);

		assertEquals("Hero is dead! Game over!", moveMessage);
	}

	@Test
	public void testBattleWithWeapon() {
		gameEngine.makeMove(Direction.LEFT);
		gameEngine.makeMove(Direction.RIGHT);
		String moveMessage = gameEngine.makeMove(Direction.DOWN);
		assertEquals(gameEngine.getHero().getWeapon().getName(), "strong weapon");
		assertEquals("Enemy died.", moveMessage);
		assertEquals('.', gameEngine.getMap()[1][1]);
		assertEquals('.', gameEngine.getMap()[1][0]);
		assertEquals('.', gameEngine.getMap()[1][1]);
		assertEquals('H', gameEngine.getMap()[2][1]);
	}

	@Test
	public void testBattleWithSpell() {
		gameEngine.makeMove(Direction.LEFT);
		gameEngine.makeMove(Direction.DOWN);
		int initMana = gameEngine.getHero().getMana();
		String moveMessage = gameEngine.makeMove(Direction.RIGHT);
		assertEquals(gameEngine.getHero().getSpell().getName(), "strong spell"); //
		assertEquals(gameEngine.getHero().getMana(), initMana - 2 * gameEngine.getHero().getSpell().getManaCost());
		assertEquals("Enemy died.", moveMessage);
		assertEquals(enemies[0].isAlive(), false);
		assertEquals('.', gameEngine.getMap()[1][1]);
		assertEquals('.', gameEngine.getMap()[1][0]);
		assertEquals('.', gameEngine.getMap()[1][1]);
		assertEquals('H', gameEngine.getMap()[2][1]);
	}

	@Test
	public void testMoveToExit() {
		gameEngine.makeMove(Direction.RIGHT);
		String moveMessage = gameEngine.makeMove(Direction.DOWN);
		assertEquals("You have successfully passed through the dungeon. Congrats!", moveMessage);
	}

	@Test
	public void testMoveToObstacle() {
		gameEngine.makeMove(Direction.RIGHT);
		String moveMessage = gameEngine.makeMove(Direction.UP);

		assertEquals("Wrong move. There is an obstacle and you cannot bypass it.", moveMessage);
		assertEquals('H', gameEngine.getMap()[1][2]);
	}

	@Test
	public void testMoveToTreasure() {
		String moveMessage = gameEngine.makeMove(Direction.LEFT);

		assertEquals("Weapon found! Damage points: 50", moveMessage);
		assertEquals('.', gameEngine.getMap()[1][1]);
		assertEquals('H', gameEngine.getMap()[1][0]);

		assertEquals("strong weapon", gameEngine.getHero().getWeapon().getName());
		assertEquals(50, gameEngine.getHero().getWeapon().getDamage());
	}

	@Test
	public void testEnemyAttackWithSpell() {
		Enemy dummy = new Enemy("dummy", 100, 100, null, new Spell("hardcore spell", 100, 10));
		gameEngine.battle(hero, dummy);
		assertEquals(dummy.isAlive(), true);
		assertEquals(hero.isAlive(), false);
	}

}