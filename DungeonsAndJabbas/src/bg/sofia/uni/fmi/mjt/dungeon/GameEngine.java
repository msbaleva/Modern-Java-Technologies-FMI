package bg.sofia.uni.fmi.mjt.dungeon;

import bg.sofia.uni.fmi.mjt.dungeon.actor.Enemy;
import bg.sofia.uni.fmi.mjt.dungeon.actor.Hero;
import bg.sofia.uni.fmi.mjt.dungeon.actor.Position;
import bg.sofia.uni.fmi.mjt.dungeon.treasure.Treasure;

public class GameEngine {
	private char[][] map;
	private Hero hero;
	private Enemy[] enemies;
	private Treasure[] treasures;
	private int tookTreasures;
	private int foughtEnemies;

	public GameEngine(char[][] map, Hero hero, Enemy[] enemies, Treasure[] treasures) {
		this.map = map;
		this.hero = new Hero(hero); //
		this.enemies = enemies;
		this.treasures = treasures;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if (map[i][j] == 'S') {
					this.hero.setPosition(new Position(i, j)); //
					break;
				}
			}
		}
	}

	public char[][] getMap() {
		return map;
	}

	public Hero getHero() {
		return hero;
	}

	public Position getHeroPosition() {
		return hero.getPosition();
	}

	public boolean battle(Hero hero, Enemy enemy) {
		boolean flag = true;
		while (hero.isAlive() && enemy.isAlive()) {
			if (flag) {
				enemy.takeDamage(hero.attack());
			} else {
				hero.takeDamage(enemy.attack());
			}
			flag = !flag;
		}
		if (hero.isAlive()) {
			foughtEnemies++;
			return true;
		}
		return false;
	}

	public void moveHero(int i, int j) {
		int heroRow = hero.getPosition().getRow();
		int heroCol = hero.getPosition().getCol();
		map[heroRow][heroCol] = '.';
		map[heroRow + i][heroCol + j] = 'H';
		hero.getPosition().setRow(heroRow + i);
		hero.getPosition().setCol(heroCol + j);

	}

	public String makeMove(Direction direction) {
		int heroRow = getHeroPosition().getRow();
		int heroCol = getHeroPosition().getCol();
		int i = 0;
		int j = 0;
		switch (direction) {
		case LEFT:
			j = -1;
			break;
		case UP:
			i = -1;
			break;
		case RIGHT:
			j = 1;
			break;
		case DOWN:
			i = 1;
			break;
		default:
			return "Unknown command entered.";
		}
		if (heroRow + i < 0 && heroCol + j < 0 && heroRow + i >= map.length && heroCol + j >= map[0].length) {
			return "Wrong move. There is an obstacle and you cannot bypass it.";
		}
		switch (map[heroRow + i][heroCol + j]) {
		case '.':
			moveHero(i, j);
			return "You moved successfully to the next position.";
		case '#':
			return "Wrong move. There is an obstacle and you cannot bypass it.";
		case 'T':
			moveHero(i, j);
			return treasures[tookTreasures++].collect(hero);
		case 'E':
			if (battle(hero, enemies[foughtEnemies])) {
				moveHero(i, j);
				return "Enemy died.";
			}
			return "Hero is dead! Game over!";
		case 'G':
			// map[heroRow][heroCol] = '.';
			return "You have successfully passed through the dungeon. Congrats!";
		}
		return "Wrong move. You started here.";
	}

}
