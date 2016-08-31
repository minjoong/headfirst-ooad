package gameframework.board;

import java.util.ArrayList;
import java.util.List;

import gameframework.unit.Unit;

public class Board {

	private int width, height;
	private List<List<Tile>> tiles;

	public Board(int width, int height) {
		this.width = width;
		this.height = height;
		initialize();
	}

	private void initialize() {
		tiles = new ArrayList<>();

		for (int width_i = 0; width_i < width; width_i++) {
			List<Tile> rowTiles = new ArrayList<>();
			for (int height_i = 0; height_i < height; height_i++) {
				rowTiles.add(new Tile());
			}
			tiles.add(rowTiles);
		}
	}

	public Tile getTile(int x, int y) {
		return tiles.get(x - 1).get(y - 1);
	}

	public void addUnit(Unit unit, int x, int y) {
		getTile(x, y).addUnit(unit);
	}

	public void removeUnit(Unit unit, int x, int y) {
		getTile(x, y).removeUnit(unit);
	}

	public void removeUnits(int x, int y) {
		getTile(x, y).removeUnits();
	}

	public List<Unit> getUnits(int x, int y) {
		return getTile(x, y).getUnits();
	}

}
