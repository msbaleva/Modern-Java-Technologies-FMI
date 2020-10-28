package bg.sofia.uni.fmi.mjt.dungeon.actor;

public class Position {
	private int row;
	private int col;

	public Position(int row, int col) {
		this.row = row;
		this.col = col;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	public boolean setRow(int row) {
		if (row > -1) {
			this.row = row;
			return true;
		}
		return false;

	}

	public boolean setCol(int col) {
		if (col > -1) {
			this.col = col;
			return true;
		}
		return false;

	}

}
