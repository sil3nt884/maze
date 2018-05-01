package com.rickyluu;

public class Map {

	String wall = "#";
	String space = " ";
	int width;
	int height;
	int map[][] = new int[width][height];
	int startx, starty, endx, endy;
	int startint = 6;
	int endint = 7;

	public Map(int width, int height, int startx, int starty, int endx, int endy ,int[][] map) {
		this.width = width;
		this.height = height;
		this.startx = startx;
		this.starty = starty;
		this.endx = endx;
		this.endy = endy;
		this.map = map;
	}

	public void  drawMap() {
	    for (int i = 0; i < height; i++) {
	    	System.out.print("\n");
            for (int j = 0; j < width; j++) {
            	if(map[i][j]== 0) {
            		System.out.print(space);
            	}
            	else if(map[i][j]== 1) {
            		System.out.print(wall);
            	}
              
            }
           
        }
    }
	
			
			
	/**
	 * Takes two params and uses a recursive method to attempt to find a path.
	 * see @link {@link #gettoPath(int, int, int[][])}
	 * @param startx
	 * @param starty
	 */
	
	public void findPath(int startx, int starty) {
		System.out.println("                                   \n");
		System.out.print("starting point.."+startx+","+starty +" ending point "+ endy + "," +endx+"\n");
		 map[starty][startx]= 6;
		 map[endy][endx] = 7;
		 int currenty = starty , currentx=startx;
		 gettoPath(currenty, currentx, map);
		  for (int i = 0; i < height; i++) {
		    	System.out.print("\n");
	            for (int j = 0; j < width; j++) {
	            	 if(map[i][j]==6) {
	            		System.out.print("S");
	            	}
	            	 if(map[i][j]==9) {
		            		System.out.print("X");
		            }
	            	else if(map[i][j]==7) {
	            		System.out.print("E");
	            	}
	            	else if(map[i][j]== 0) {
	            		System.out.print(space);
	            	}
	            	else if(map[i][j]== 1) {
	            		System.out.print(wall);
	            	}
	            	
	              
	            }
	           
	        }
		
		
		
		
	}
	
	/**
	 *  Recursive method attempting to find a path.
	 * @param currenty
	 * @param currentx
	 * @param map2
	 * @return
	 */

	private int gettoPath(int currenty, int currentx, int[][] map2) {
		
		System.out.println(currenty+","+currentx);
		
			
		if(goDown (currenty, currentx, map2)) {
			currenty++;
			map2[currenty][currentx] = 9;
			if(currenty == endy && currentx == endx) {
				return 1;
			}
	
			return gettoPath(currenty, currentx,  map2);		
		}
		
		else if(goRight (currenty, currentx, map2)) {
			currentx++;
			map2[currenty][currentx] = 9;
			if(currenty == endy && currentx == endx) {
				return 1;
			}
		
			return gettoPath(currenty, currentx,  map2);		
		}
		
		else if(goUP(currenty, currentx, map2)){
			currenty--;
			map2[currenty][currentx] = 9;
			if(currenty == endy && currentx == endx) {
				return 1;
			}
	
			return gettoPath(currenty, currentx,  map2);		
		}
		
		
		else if(goLeft(currenty, currentx, map2)){
			currentx--;
			map2[currenty][currentx] = 9;
			if(currenty == endy && currentx == endx) {
				return 1;
			}
	
			return gettoPath(currenty, currentx,  map2);		
		}
	
		
	
		else if(currenty == endy && currentx == endx) {
			return gettoPath(currenty, currentx,  map2);
		}

	
		
		
		return -1;
	}

	private boolean goDown(int currenty, int currentx, int[][] map2) {
		int next = currenty +1;
		if(map2[next][currentx]==0) {
			currenty++;
			return true;
		}
		
		else if(map2[next][currentx]==1) {
			return false;
		}
		
		return false;
		
	}

	private boolean goUP(int currenty, int currentx, int[][] map2) {
		int next = currenty -1;
		if(map2[next][currentx]==0) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	private boolean goRight(int currenty, int currentx, int[][] map2) {
		int next = currentx +1;
		if(map2[currenty][next]==0) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	
	private boolean goLeft(int currenty, int currentx, int[][] map2) {
		int next = currentx -1;
		if(map2[currenty][next]==0) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	
}
