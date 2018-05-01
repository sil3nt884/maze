package com.rickyluu;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.swing.Spring;

public class MazeHelper {

	private Config config = new Config();
	private int width, height;
	private int startx, starty;
	private int endx, endy;
	private File mazeInput = new File(config.getFile());
	private int count = 0;

	/**
	 * 
	 * Creates the map;
	 * 
	 * @return map
	 */

	public Map MapMaze() {
		Path map = Paths.get(mazeInput.toURI());

		try {
			String first = Files.lines(map).map(s -> s).findFirst().get();
			String[] firstSplit = first.split(" ");
			width = Integer.parseInt(firstSplit[0]);
			height = Integer.parseInt(firstSplit[1]);
			String second = Files.lines(map).map(s -> s).skip(1).findFirst().get();
			String[] secondSplit = second.split(" ");
			startx = Integer.parseInt(secondSplit[0]);
			starty = Integer.parseInt(secondSplit[1]);
			String third = Files.lines(map).map(s -> s).skip(2).findFirst().get();
			String[] thirdSplit = third.split(" ");
			endx = Integer.parseInt(thirdSplit[0]);
			endy = Integer.parseInt(thirdSplit[1]);
			int mapInt[][] = new int[height][width];
			List<String> s2 = Files.lines(map).map(s -> s).skip(3).map(line -> line.replace(" ", ","))
					.collect(Collectors.toList());

			for (int row = 0; row < height; row++) {
				String line = s2.get(count);
				if (line == null || line.isEmpty()) {
					System.out.println("Line is empty or null");
				} else {
					System.out.println(line);
					String[] tileValues = line.split(",");
					for (int col = 0; col < width; col++) {

						mapInt[row][col] = Integer.parseInt(tileValues[col]);

					}
				}
				if (count < width) {
					count++;
				}
				if (count >= width) {
					count = 0;
				}

			}

			Map maze = new Map(width, height, startx, starty, endx, endy, mapInt);
			return maze;

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

	public void findPath(Map map) {
		map.findPath(map.starty, map.startx);
	}

	public void drawMap(Map map) {
		map.drawMap();
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getStartx() {
		return startx;
	}

	public void setStartx(int startx) {
		this.startx = startx;
	}

	public int getStarty() {
		return starty;
	}

	public void setStarty(int starty) {
		this.starty = starty;
	}

	public int getEndx() {
		return endx;
	}

	public void setEndx(int endx) {
		this.endx = endx;
	}

	public int getEndy() {
		return endy;
	}

	public void setEndy(int endy) {
		this.endy = endy;
	}

	public File getMazeInput() {
		return mazeInput;
	}

	public void setMazeInput(File mazeInput) {
		this.mazeInput = mazeInput;
	}

}
