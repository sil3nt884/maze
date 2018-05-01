package com.rickyluu;

public class RunMaze {

	public static void main(String[] args) {
		MazeHelper helper = new MazeHelper();
		Map map = helper.MapMaze();
		helper.drawMap(map);
		helper.findPath(map);

	}

}
