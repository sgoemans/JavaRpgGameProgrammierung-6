package de.neuromechanics;

import java.awt.Graphics;

public class Level {
	private TileSet ts;
	private int sizeX, sizeY;
	private int[][] tileMap;
	private Game game;

	public Level(Game game, String path, TileSet ts) {
		this.game = game;
		this.ts = ts;
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		sizeX = Utils.parseInt(tokens[0]);
		sizeY = Utils.parseInt(tokens[1]);
		tileMap = new int[sizeX][sizeY];
		int i = 2;
		for(int y = 0; y < sizeY; y++){
			for(int x = 0; x < sizeX; x++){
				tileMap[x][y] = Utils.parseInt(tokens[i++]);
			}
		}
	}
	public void renderMap(Graphics g){
		for(int tileY = 0; tileY < sizeY; tileY++){
			for(int tileX = 0; tileX < sizeX; tileX++){
				ts.renderTile(g, tileMap[tileX][tileY], tileX * TileSet.TILEWIDTH - game.getGameCamera().getxOffset(),
						tileY * TileSet.TILEHEIGHT - game.getGameCamera().getyOffset());
			}
		}
	}
	public int getSizeX() {
		return sizeX;
	}
	public int getSizeY() {
		return sizeY;
	}
}