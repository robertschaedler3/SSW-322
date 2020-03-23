/*
 * SimpleMazeGame.java
 * Copyright (c) 2008, Drexel University.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     * Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     * Neither the name of the Drexel University nor the
 *       names of its contributors may be used to endorse or promote products
 *       derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY DREXEL UNIVERSITY ``AS IS'' AND ANY
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL DREXEL UNIVERSITY BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package maze;

import maze.ui.MazeViewer;
import java.io.*;
import java.util.*;

/**
 * 
 * @author Sunny
 * @version 1.0
 * @since 1.0
 */
public class SimpleMazeGame {
	/**
	 * Creates a small maze.
	 */
	public Maze createMaze() {

		Maze maze = new Maze();

		Room r1 = new Room(0);
		Room r2 = new Room(1);
		Door d = new Door(r1, r2);

		maze.addRoom(r1);
		maze.addRoom(r2);

		r1.setSide(Direction.North, new Wall());
		r1.setSide(Direction.South, new Wall());
		r1.setSide(Direction.West, new Wall());
		r1.setSide(Direction.East, d);

		r2.setSide(Direction.South, new Wall());
		r2.setSide(Direction.North, new Wall());
		r2.setSide(Direction.East, new Wall());
		r2.setSide(Direction.West, d);

		return maze;
	}

	public Maze loadMaze(final String path) {
		Maze maze = new Maze();
		Scanner s = null;
		try {
			s = new Scanner(new File(path));
		} catch (FileNotFoundException e) {
			System.err.println(e);
			System.exit(1);
		}

		String line;
		LinkedList<Room> rooms = new LinkedList<>();
		LinkedList<Door> doors = new LinkedList<>();

		LinkedList<String[]> roomConfigs = new LinkedList<>();

		// Read rooms and doors from .maze file
		while (s.hasNextLine()) {
			line = s.nextLine();
			String[] lineVals = line.split(" ");

			if (lineVals[0].equals("room")) {
				roomConfigs.add(lineVals);
				Room room = new Room(Integer.parseInt(lineVals[1]));

				rooms.add(room);
				maze.addRoom(room);
			} else if (lineVals[0].equals("door")) {
				int r1 = Integer.parseInt(lineVals[2]);
				int r2 = Integer.parseInt(lineVals[3]);
				Door door = new Door(rooms.get(r1), rooms.get(r2));

				door.setOpen(lineVals[4].equals("open"));
				doors.add(door);
			}
		}
		s.close();

		Direction[] directions = { Direction.North, Direction.South, Direction.East, Direction.West };

		for (int roomId = 0; roomId < rooms.size(); roomId++) {
			Room room = rooms.get(roomId);
			String[] roomConf = roomConfigs.get(roomId);

			String conf;
			MapSite site;
			for (int confId = 2; confId < 6; confId++) {
				conf = roomConf[confId];

				if (conf.equals("wall")) { // if the room has a wall
					site = new Wall();
				} else if (conf.startsWith("d")) { // if the room has a door
					site = doors.get(Integer.parseInt(conf.substring(1)));
				} else { // two rooms are connected
					site = rooms.get(Integer.parseInt(conf));
				}

				// set the new side
				room.setSide(directions[confId - 2], site);
			}
		}
		return maze;
	}

	public static void main(String[] args) {
		if (args.length > 1) {
			System.err.printf("Usage: %s [maze file]", args[0]);
			System.exit(1);
		}

		Maze maze = null;
		SimpleMazeGame simpleMaze = new SimpleMazeGame();
		if (args.length == 1) {
			maze = simpleMaze.loadMaze(args[0]);
		} else {
			maze = simpleMaze.createMaze();
		}
		MazeViewer viewer = new MazeViewer(maze);
		viewer.run();
	}
}
