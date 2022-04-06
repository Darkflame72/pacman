// This program is copyright VUW.  You are granted permission to use it to
// construct your answer to a SWEN221 assignment. You may not distribute
// it in any other way without permission.
package pacman.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import pacman.Game;
import pacman.io.*;

public class PacmanTests {

	/**
	 * ============================================================
	 * Part 1 --- Basic Moves
	 * ============================================================
	 */

	@Test
	public void test_01() {
		// Check player can move right
		String startingBoard =
				"7|###############|\n" +
				"6|#.            #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|#  #       #  #|\n" +
				"3|#  #  ###  #  #|\n" +
				"2|## #   #   # ##|\n" +
				"1|#      o      #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		String sequence = "R";

		String finalBoard =
				"7|###############|\n" +
				"6|#.            #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|#  #       #  #|\n" +
				"3|#  #  ###  #  #|\n" +
				"2|## #   #   # ##|\n" +
				"1|#       o     #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_02() {
		// Check player can move left
		String startingBoard =
				"7|###############|\n" +
				"6|#..           #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|#  #       #  #|\n" +
				"3|#  #  ###  #  #|\n" +
				"2|## #   #   # ##|\n" +
				"1|#      o      #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		String sequence = "L";

		String finalBoard =
				"7|###############|\n" +
				"6|#..           #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|#  #       #  #|\n" +
				"3|#  #  ###  #  #|\n" +
				"2|## #   #   # ##|\n" +
				"1|#     o       #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_03() {
		// Check player can move up
		String startingBoard =
				"7|###############|\n" +
				"6|#             #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|#  #       #  #|\n" +
				"3|#  #  ###  #  #|\n" +
				"2|## #   #   # ##|\n" +
				"1|#..   o       #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		String sequence = "U";

		String finalBoard =
				"7|###############|\n" +
				"6|#             #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|#  #       #  #|\n" +
				"3|#  #  ###  #  #|\n" +
				"2|## #  o#   # ##|\n" +
				"1|#..           #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_04() {
		// Check player can move down
		String startingBoard =
				"7|###############|\n" +
				"6|#             #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|#  #       #  #|\n" +
				"3|#..#  ###  #  #|\n" +
				"2|##.#  o#   # ##|\n" +
				"1|#..           #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		String sequence = "D";

		String finalBoard =
				"7|###############|\n" +
				"6|#             #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|#  #       #  #|\n" +
				"3|#..#  ###  #  #|\n" +
				"2|##.#   #   # ##|\n" +
				"1|#..   o       #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_05() {
		// Check player can move right twice
		String startingBoard =
				"7|###############|\n" +
				"6|#             #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|#  # ..... #  #|\n" +
				"3|#  # .###. #  #|\n" +
				"2|## #   #   # ##|\n" +
				"1|#      o      #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		String sequence = "RR";

		String finalBoard =
				"7|###############|\n" +
				"6|#             #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|#  # ..... #  #|\n" +
				"3|#  # .###. #  #|\n" +
				"2|## #   #   # ##|\n" +
				"1|#        o    #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_06() {
		// Check player can move left twice
		String startingBoard =
				"7|###############|\n" +
				"6|#             #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|#  #       #  #|\n" +
				"3|#  #  ###  #  #|\n" +
				"2|## #   #   # ##|\n" +
				"1|#      o    ..#|\n" +
				"0|###############|\n" +
				"  012345678901234";

		String sequence = "LL";

		String finalBoard =
				"7|###############|\n" +
				"6|#             #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|#  #       #  #|\n" +
				"3|#  #  ###  #  #|\n" +
				"2|## #   #   # ##|\n" +
				"1|#    o      ..#|\n" +
				"0|###############|\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_07() {
		// Check player can move up twice
		String startingBoard =
				"7|###############|\n" +
				"6|#             #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|#  #       #  #|\n" +
				"3|#  #  ###  #..#|\n" +
				"2|## #   #   #.##|\n" +
				"1|#    o        #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		String sequence = "UU";

		String finalBoard =
				"7|###############|\n" +
				"6|#             #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|#  #       #  #|\n" +
				"3|#  # o###  #..#|\n" +
				"2|## #   #   #.##|\n" +
				"1|#             #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_08() {
		// Check player can move down twice
		String startingBoard =
				"7|###############|\n" +
				"6|#             #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|#  #o      #  #|\n" +
				"3|#  #  ###  #  #|\n" +
				"2|## #   #   # ##|\n" +
				"1|#            .#|\n" +
				"0|###############|\n" +
				"  012345678901234";

		String sequence = "DD";

		String finalBoard =
				"7|###############|\n" +
				"6|#             #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|#  #       #  #|\n" +
				"3|#  #  ###  #  #|\n" +
				"2|## #o  #   # ##|\n" +
				"1|#            .#|\n" +
				"0|###############|\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_09() {
		// Check longer move sequence
		String startingBoard =
				"7|###############|\n" +
				"6|#             #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|#  #       #  #|\n" +
				"3|#  #  ###  #  #|\n" +
				"2|## #   #   # ##|\n" +
				"1|#      o     .#|\n" +
				"0|###############|\n" +
				"  012345678901234";

		String sequence = "LULUURR";

		String finalBoard =
				"7|###############|\n" +
				"6|#             #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|#  #   o   #  #|\n" +
				"3|#  #  ###  #  #|\n" +
				"2|## #   #   # ##|\n" +
				"1|#            .#|\n" +
				"0|###############|\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_10() {
		// Check longer move sequence
		String startingBoard =
				"7|###############|\n" +
				"6|#    ..       #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|#  #   o   #  #|\n" +
				"3|#  #  ###  #  #|\n" +
				"2|## #   #   # ##|\n" +
				"1|#             #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		String sequence = "RRDDDLL";

		String finalBoard =
				"7|###############|\n" +
				"6|#    ..       #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|#  #       #  #|\n" +
				"3|#  #  ###  #  #|\n" +
				"2|## #   #   # ##|\n" +
				"1|#      o      #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	/**
	 * ============================================================
	 * Part 2 --- Obstructions
	 * ============================================================
	 */

	@Test
	public void test_11() {
		// Check player can move right (obstruction)
		String startingBoard =
				"7|###############|\n" +
				"6|#       ..    #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|#  #       #  #|\n" +
				"3|#  #  ###  #  #|\n" +
				"2|## #  o#   # ##|\n" +
				"1|#             #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		String sequence = "R";

		String finalBoard =
				"7|###############|\n" +
				"6|#       ..    #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|#  #       #  #|\n" +
				"3|#  #  ###  #  #|\n" +
				"2|## #  o#   # ##|\n" +
				"1|#             #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_12() {
		// Check player can move right twice (obstruction)
		String startingBoard =
				"7|###############|\n" +
				"6|#       ..    #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|#  #       #  #|\n" +
				"3|#  #  ###  #  #|\n" +
				"2|## # o #   # ##|\n" +
				"1|#             #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		String sequence = "RR";

		String finalBoard =
				"7|###############|\n" +
				"6|#       ..    #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|#  #       #  #|\n" +
				"3|#  #  ###  #  #|\n" +
				"2|## #  o#   # ##|\n" +
				"1|#             #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_13() {
		// Check player can move left (obstruction)
		String startingBoard =
				"7|###############|\n" +
				"6|#      .      #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|#  #       #  #|\n" +
				"3|#  #  ###  #  #|\n" +
				"2|## #   #o  # ##|\n" +
				"1|#             #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		String sequence = "L";

		String finalBoard =
				"7|###############|\n" +
				"6|#      .      #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|#  #       #  #|\n" +
				"3|#  #  ###  #  #|\n" +
				"2|## #   #o  # ##|\n" +
				"1|#             #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_14() {
		// Check player can move left twice (obstruction)
		String startingBoard =
				"7|###############|\n" +
				"6|#.           .#|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|#  #       #  #|\n" +
				"3|#  #  ###  #  #|\n" +
				"2|## #   # o # ##|\n" +
				"1|#             #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		String sequence = "LL";

		String finalBoard =
				"7|###############|\n" +
				"6|#.           .#|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|#  #       #  #|\n" +
				"3|#  #  ###  #  #|\n" +
				"2|## #   #o  # ##|\n" +
				"1|#             #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_15() {
		// Check player can move up (obstruction)
		String startingBoard =
				"7|###############|\n" +
				"6|#             #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|#  #       #  #|\n" +
				"3|#. #  ###  # .#|\n" +
				"2|## #   #o  # ##|\n" +
				"1|#             #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		String sequence = "U";

		String finalBoard =
				"7|###############|\n" +
				"6|#             #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|#  #       #  #|\n" +
				"3|#. #  ###  # .#|\n" +
				"2|## #   #o  # ##|\n" +
				"1|#             #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_16() {
		// Check player can move up twice (obstruction)
		String startingBoard =
				"7|###############|\n" +
				"6|#             #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|#  #.      #  #|\n" +
				"3|#  #  ###  #  #|\n" +
				"2|## #   #   # ##|\n" +
				"1|#.      o     #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		String sequence = "UU";

		String finalBoard =
				"7|###############|\n" +
				"6|#             #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|#  #.      #  #|\n" +
				"3|#  #  ###  #  #|\n" +
				"2|## #   #o  # ##|\n" +
				"1|#.            #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_17() {
		// Check player can move down (obstruction)
		String startingBoard =
				"7|###############|\n" +
				"6|#             #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|#  #      .#  #|\n" +
				"3|#  #  ###  #  #|\n" +
				"2|## #   #   # ##|\n" +
				"1|#       o    .#|\n" +
				"0|###############|\n" +
				"  012345678901234";

		String sequence = "D";

		String finalBoard =
				"7|###############|\n" +
				"6|#             #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|#  #      .#  #|\n" +
				"3|#  #  ###  #  #|\n" +
				"2|## #   #   # ##|\n" +
				"1|#       o    .#|\n" +
				"0|###############|\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_18() {
		// Check player can move down twice (obstruction)
		String startingBoard =
				"7|###############|\n" +
				"6|#             #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|#  #  ...  #  #|\n" +
				"3|#  #  ###  #  #|\n" +
				"2|## #   #o  # ##|\n" +
				"1|#             #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		String sequence = "DD";

		String finalBoard =
				"7|###############|\n" +
				"6|#             #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|#  #  ...  #  #|\n" +
				"3|#  #  ###  #  #|\n" +
				"2|## #   #   # ##|\n" +
				"1|#       o     #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_19() {
		// Check player can eat dot (down)
		String startingBoard =
				"7|###############|\n" +
				"6|#             #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|#  #       #  #|\n" +
				"3|#  #  ###  #  #|\n" +
				"2|## #   #o  # ##|\n" +
				"1|#      ..     #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		String sequence = "D";

		String finalBoard =
				"7|###############|\n" +
				"6|#             #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|#  #       #  #|\n" +
				"3|#  #  ###  #  #|\n" +
				"2|## #   #   # ##|\n" +
				"1|#      .o     #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_20() {
		// Check player can eat dot (up)
		String startingBoard =
				"7|###############|\n" +
				"6|#             #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|#  #       #  #|\n" +
				"3|#  #  ###  #  #|\n" +
				"2|## #   #.  # ##|\n" +
				"1|#      .o     #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		String sequence = "U";

		String finalBoard =
				"7|###############|\n" +
				"6|#             #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|#  #       #  #|\n" +
				"3|#  #  ###  #  #|\n" +
				"2|## #   #o  # ##|\n" +
				"1|#      .      #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_21() {
		// Check player can eat dot (left)
		String startingBoard =
				"7|###############|\n" +
				"6|#             #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|#  #       #  #|\n" +
				"3|#  #  ###  #  #|\n" +
				"2|## #   #.  # ##|\n" +
				"1|#      .o     #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		String sequence = "L";

		String finalBoard =
				"7|###############|\n" +
				"6|#             #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|#  #       #  #|\n" +
				"3|#  #  ###  #  #|\n" +
				"2|## #   #.  # ##|\n" +
				"1|#      o      #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_22() {
		// Check player can eat dot (right)
		String startingBoard =
				"7|###############|\n" +
				"6|#             #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|#  #       #  #|\n" +
				"3|#  #  ###  #  #|\n" +
				"2|## #   #.  # ##|\n" +
				"1|#      .o.    #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		String sequence = "R";

		String finalBoard =
				"7|###############|\n" +
				"6|#             #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|#  #       #  #|\n" +
				"3|#  #  ###  #  #|\n" +
				"2|## #   #.  # ##|\n" +
				"1|#      . o    #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	/**
	 * ============================================================
	 * Part 3 --- Moving Around
	 * ============================================================
	 */

	@Test
	public void test_23() {
		// Check player can move around board (left to right)
		String startingBoard =
				"7|###############|\n" +
				"6|#             #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|####       ####|\n" +
				"3|      ###o     |\n" +
				"2|####   # . ####|\n" +
				"1|#        .    #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		String sequence = "RRRRRR";

		String finalBoard =
				"7|###############|\n" +
				"6|#             #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|####       ####|\n" +
				"3|o     ###      |\n" +
				"2|####   # . ####|\n" +
				"1|#        .    #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_24() {
		// Check player can move around board (left to right)
		String startingBoard =
				"7|###############|\n" +
				"6|#             #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|####       ####|\n" +
				"3|      ###o     |\n" +
				"2|####   # . ####|\n" +
				"1|#        .    #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		String sequence = "RRRRRRRR";

		String finalBoard =
				"7|###############|\n" +
				"6|#             #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|####       ####|\n" +
				"3|  o   ###      |\n" +
				"2|####   # . ####|\n" +
				"1|#        .    #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_25() {
		// Check player can move around board (right to left)
		String startingBoard =
				"7|###############|\n" +
				"6|#             #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|####       ####|\n" +
				"3|     o###      |\n" +
				"2|####   # . ####|\n" +
				"1|#        .    #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		String sequence = "LLLLLL";

		String finalBoard =
				"7|###############|\n" +
				"6|#             #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|####       ####|\n" +
				"3|      ###     o|\n" +
				"2|####   # . ####|\n" +
				"1|#        .    #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_26() {
		// Check player can move around board (north to south)
		String startingBoard =
				"7|##### #########|\n" +
				"6|#   #         #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|####       ####|\n" +
				"3|     o###      |\n" +
				"2|####   # . ####|\n" +
				"1|#        .    #|\n" +
				"0|##### #########|\n" +
				"  012345678901234";

		String sequence = "UUUUU";

		String finalBoard =
				"7|##### #########|\n" +
				"6|#   #         #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|####       ####|\n" +
				"3|      ###      |\n" +
				"2|####   # . ####|\n" +
				"1|#        .    #|\n" +
				"0|#####o#########|\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_27() {
		// Check player can move around board (north to south)
		String startingBoard =
				"7|##### #########|\n" +
				"6|#   #         #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|####       ####|\n" +
				"3|     o###      |\n" +
				"2|####   # . ####|\n" +
				"1|#        .    #|\n" +
				"0|##### #########|\n" +
				"  012345678901234";

		String sequence = "UUUUUU";

		String finalBoard =
				"7|##### #########|\n" +
				"6|#   #         #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|####       ####|\n" +
				"3|      ###      |\n" +
				"2|####   # . ####|\n" +
				"1|#    o   .    #|\n" +
				"0|##### #########|\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_28() {
		// Check player can move around board (south to north)
		String startingBoard =
				"7|##### #########|\n" +
				"6|#   #         #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|####       ####|\n" +
				"3|     o###      |\n" +
				"2|####   # . ####|\n" +
				"1|#        .    #|\n" +
				"0|##### #########|\n" +
				"  012345678901234";

		String sequence = "DDDD";

		String finalBoard =
				"7|#####o#########|\n" +
				"6|#   #         #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|####       ####|\n" +
				"3|      ###      |\n" +
				"2|####   # . ####|\n" +
				"1|#        .    #|\n" +
				"0|##### #########|\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_29() {
		// Check player can move around board (south to north)
		String startingBoard =
				"7|##### #########|\n" +
				"6|#   #         #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|####       ####|\n" +
				"3|     o###      |\n" +
				"2|####   # . ####|\n" +
				"1|#        .    #|\n" +
				"0|##### #########|\n" +
				"  012345678901234";

		String sequence = "DDDDD";

		String finalBoard =
				"7|##### #########|\n" +
				"6|#   #o        #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|####       ####|\n" +
				"3|      ###      |\n" +
				"2|####   # . ####|\n" +
				"1|#        .    #|\n" +
				"0|##### #########|\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	/**
	 * ============================================================
	 * Part 4 --- Game Over
	 * ============================================================
	 */
	@Test
	public void test_30() {
		// Check player can eat dot and finish game (left)
		String startingBoard =
				"7|###############|\n" +
				"6|#             #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|#  #       #  #|\n" +
				"3|#  #  ###  #  #|\n" +
				"2|## #   #   # ##|\n" +
				"1|#      .o     #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		String sequence = "L!";

		String finalBoard =
				"7|###############|\n" +
				"6|#             #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|#  #       #  #|\n" +
				"3|#  #  ###  #  #|\n" +
				"2|## #   #   # ##|\n" +
				"1|#      o      #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_31() {
		// Check player can eat dot and finish game (right)
		String startingBoard =
				"7|###############|\n" +
				"6|#             #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|#  #       #  #|\n" +
				"3|#  #  ###  #  #|\n" +
				"2|## #   #   # ##|\n" +
				"1|#       o.    #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		String sequence = "R!";

		String finalBoard =
				"7|###############|\n" +
				"6|#             #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|#  #       #  #|\n" +
				"3|#  #  ###  #  #|\n" +
				"2|## #   #   # ##|\n" +
				"1|#        o    #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_32() {
		// Check player can eat dot and finish game (right)
		String startingBoard =
				"7|###############|\n" +
				"6|#             #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|#  #       #  #|\n" +
				"3|#  #  ###  #  #|\n" +
				"2|## #   #.  # ##|\n" +
				"1|#       o     #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		String sequence = "U!";

		String finalBoard =
				"7|###############|\n" +
				"6|#             #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|#  #       #  #|\n" +
				"3|#  #  ###  #  #|\n" +
				"2|## #   #o  # ##|\n" +
				"1|#             #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_33() {
		// Check player can eat dot and finish game (right)
		String startingBoard =
				"7|###############|\n" +
				"6|#             #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|#  #       #  #|\n" +
				"3|#  #  ###  #  #|\n" +
				"2|## #   #o  # ##|\n" +
				"1|#       .     #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		String sequence = "D!";

		String finalBoard =
				"7|###############|\n" +
				"6|#             #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|#  #       #  #|\n" +
				"3|#  #  ###  #  #|\n" +
				"2|## #   #   # ##|\n" +
				"1|#       o     #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_34() {
		// Check player can eat dot and finish game (left)
		String startingBoard =
				"7|###############|\n" +
				"6|#             #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|#  #       #  #|\n" +
				"3|#  #  ###  #  #|\n" +
				"2|## #   #   # ##|\n" +
				"1|#     ..o     #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		String sequence = "LL!";

		String finalBoard =
				"7|###############|\n" +
				"6|#             #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|#  #       #  #|\n" +
				"3|#  #  ###  #  #|\n" +
				"2|## #   #   # ##|\n" +
				"1|#     o       #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_35() {
		// Check player can eat dot and finish game (right)
		String startingBoard =
				"7|###############|\n" +
				"6|#             #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|#  #       #  #|\n" +
				"3|#  #  ###  #  #|\n" +
				"2|## #   #   # ##|\n" +
				"1|#       o..   #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		String sequence = "RR!";

		String finalBoard =
				"7|###############|\n" +
				"6|#             #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|#  #       #  #|\n" +
				"3|#  #  ###  #  #|\n" +
				"2|## #   #   # ##|\n" +
				"1|#         o   #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_36() {
		// Check player can eat dot and finish game (right)
		String startingBoard =
				"7|###############|\n" +
				"6|#             #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|#  #       #  #|\n" +
				"3|#  #  ###. #  #|\n" +
				"2|## #   # . # ##|\n" +
				"1|#        o    #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		String sequence = "UU!";

		String finalBoard =
				"7|###############|\n" +
				"6|#             #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|#  #       #  #|\n" +
				"3|#  #  ###o #  #|\n" +
				"2|## #   #   # ##|\n" +
				"1|#             #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_37() {
		// Check player can eat dot and finish game (right)
		String startingBoard =
				"7|###############|\n" +
				"6|#             #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|#  #       #  #|\n" +
				"3|#  #  ###o #  #|\n" +
				"2|## #   # . # ##|\n" +
				"1|#        .    #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		String sequence = "DD!";

		String finalBoard =
				"7|###############|\n" +
				"6|#             #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|#  #       #  #|\n" +
				"3|#  #  ###  #  #|\n" +
				"2|## #   #   # ##|\n" +
				"1|#        o    #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_38() {
		// Check game not finished if dots remains
		String startingBoard =
				"7|###############|\n" +
				"6|#             #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|#  #       #  #|\n" +
				"3|#  #  ###  #  #|\n" +
				"2|## #   #   # ##|\n" +
				"1|#    ...o     #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		String sequence = "LL!";

		checkInvalid(sequence,startingBoard);
	}

	@Test
	public void test_39() {
		// Check game not finished if dots remains
		String startingBoard =
				"7|###############|\n" +
				"6|#             #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|#  #       #  #|\n" +
				"3|#  #  ###  #  #|\n" +
				"2|## #   #   # ##|\n" +
				"1|#   o...      #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		String sequence = "RR!";

		checkInvalid(sequence,startingBoard);
	}

	@Test
	public void test_40() {
		// Check game not finished if dots remains
		String startingBoard =
				"7|###############|\n" +
				"6|#             #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|#  #.      #  #|\n" +
				"3|#  #. ###  #  #|\n" +
				"2|## #.  #   # ##|\n" +
				"1|#   o         #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		String sequence = "UU!";

		checkInvalid(sequence,startingBoard);
	}

	@Test
	public void test_41() {
		// Check game not finished if dots remains
		String startingBoard =
				"7|###############|\n" +
				"6|#             #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|#  #       #  #|\n" +
				"3|#  #o ###  #  #|\n" +
				"2|## #.  #   # ##|\n" +
				"1|#   . .       #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		String sequence = "DD!";

		checkInvalid(sequence,startingBoard);
	}

	@Test
	public void test_42() {
		// Check player cannot move after game finished
		String startingBoard =
				"7|###############|\n" +
				"6|#             #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|#  #       #  #|\n" +
				"3|#  #  ###  #  #|\n" +
				"2|## #   #   # ##|\n" +
				"1|#  .o         #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		String sequence = "LL";

		checkInvalid(sequence,startingBoard);
	}

	@Test
	public void test_43() {
		// Check player cannot move after game finished
		String startingBoard =
				"7|###############|\n" +
				"6|#             #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|#  #       #  #|\n" +
				"3|#  #  ###  #  #|\n" +
				"2|## #   #   # ##|\n" +
				"1|# o.          #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		String sequence = "RR";

		checkInvalid(sequence,startingBoard);
	}

	@Test
	public void test_44() {
		// Check player cannot move after game finished
		String startingBoard =
				"7|###############|\n" +
				"6|#             #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|#  #       #  #|\n" +
				"3|#  #  ###  #  #|\n" +
				"2|##.#   #   # ##|\n" +
				"1|# o           #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		String sequence = "UU";

		checkInvalid(sequence,startingBoard);
	}

	@Test
	public void test_45() {
		// Check player cannot move after game finished
		String startingBoard =
				"7|###############|\n" +
				"6|#             #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|#  #       #  #|\n" +
				"3|# o#  ###  #  #|\n" +
				"2|##.#   #   # ##|\n" +
				"1|#             #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		String sequence = "DD";

		checkInvalid(sequence,startingBoard);
	}

	@Test
	public void test_46() {
		// Check player cannot lose without being eaten!
		String startingBoard =
				"7|###############|\n" +
				"6|#             #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|#  #       #  #|\n" +
				"3|# o#  ###  #  #|\n" +
				"2|##.#   #   # ##|\n" +
				"1|# .           #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		String sequence = "D?";

		checkInvalid(sequence,startingBoard);
	}

	@Test
	public void test_47() {
		// Check player cannot lose without being eaten!
		String startingBoard =
				"7|###############|\n" +
				"6|#             #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|#  #       #  #|\n" +
				"3|#  #  ###  #  #|\n" +
				"2|##.#   #   # ##|\n" +
				"1|# . o         #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		String sequence = "U?";

		checkInvalid(sequence,startingBoard);
	}

	@Test
	public void test_48() {
		// Check player cannot lose without being eaten!
		String startingBoard =
				"7|###############|\n" +
				"6|#             #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|#  #o      #  #|\n" +
				"3|#  #  ###  #  #|\n" +
				"2|##.#   #   # ##|\n" +
				"1|# .           #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		String sequence = "R?";

		checkInvalid(sequence,startingBoard);
	}

	@Test
	public void test_49() {
		// Check player cannot lose without being eaten!
		String startingBoard =
				"7|###############|\n" +
				"6|#             #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|#  #o      #  #|\n" +
				"3|#  #  ###  #  #|\n" +
				"2|##.#   #   # ##|\n" +
				"1|# .           #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		String sequence = "L?";

		checkInvalid(sequence,startingBoard);
	}

	/**
	 * ============================================================
	 * Part 5 --- Basic Ghost Movement
	 * ============================================================
	 */

	@Test
	public void test_50() {
		// Check ghost moves right
		String startingBoard =
				"7|##### #########|\n" +
				"6|#   #>        #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|####       ####|\n" +
				"3|      ###   o  |\n" +
				"2|####   # . ####|\n" +
				"1|#        .    #|\n" +
				"0|##### #########|\n" +
				"  012345678901234";

		String sequence = "R";

		String finalBoard =
				"7|##### #########|\n" +
				"6|#   # >       #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|####       ####|\n" +
				"3|      ###    o |\n" +
				"2|####   # . ####|\n" +
				"1|#        .    #|\n" +
				"0|##### #########|\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_51() {
		// Check ghost moves left
		String startingBoard =
				"7|##### #########|\n" +
				"6|#   #   <     #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|####       ####|\n" +
				"3|  o   ###      |\n" +
				"2|####   # . ####|\n" +
				"1|#        .    #|\n" +
				"0|##### #########|\n" +
				"  012345678901234";

		String sequence = "D";

		String finalBoard =
				"7|##### #########|\n" +
				"6|#   #  <      #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|####       ####|\n" +
				"3|  o   ###      |\n" +
				"2|####   # . ####|\n" +
				"1|#        .    #|\n" +
				"0|##### #########|\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_52() {
		// Check ghost moves up
		String startingBoard =
				"7|##### #########|\n" +
				"6|#   #    o    #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|####    ^  ####|\n" +
				"3|      ###      |\n" +
				"2|####   # . ####|\n" +
				"1|#        .    #|\n" +
				"0|##### #########|\n" +
				"  012345678901234";

		String sequence = "L";

		String finalBoard =
				"7|##### #########|\n" +
				"6|#   #   o     #|\n" +
				"5|#  ##  #^ ##  #|\n" +
				"4|####       ####|\n" +
				"3|      ###      |\n" +
				"2|####   # . ####|\n" +
				"1|#        .    #|\n" +
				"0|##### #########|\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_53() {
		// Check ghost moves down
		String startingBoard =
				"7|##### #########|\n" +
				"6|#   #   v     #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|####       ####|\n" +
				"3|     o###      |\n" +
				"2|####   # . ####|\n" +
				"1|#        .    #|\n" +
				"0|##### #########|\n" +
				"  012345678901234";

		String sequence = "D";

		String finalBoard =
				"7|##### #########|\n" +
				"6|#   #         #|\n" +
				"5|#  ##  #v ##  #|\n" +
				"4|####       ####|\n" +
				"3|      ###      |\n" +
				"2|#### o # . ####|\n" +
				"1|#        .    #|\n" +
				"0|##### #########|\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_54() {
		// Check ghost continues moving left
		String startingBoard =
				"7|##### #########|\n" +
				"6|#   #         #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|####      < ###|\n" +
				"3|     o######   |\n" +
				"2|####   # . ####|\n" +
				"1|#        .    #|\n" +
				"0|##### #########|\n" +
				"  012345678901234";

		String sequence = "DLD";

		String finalBoard =
				"7|##### #########|\n" +
				"6|#   #         #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|####   <    ###|\n" +
				"3|      ######   |\n" +
				"2|####   # . ####|\n" +
				"1|#   o    .    #|\n" +
				"0|##### #########|\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_55() {
		// Check ghost continues moving right
		String startingBoard =
				"7|##### #########|\n" +
				"6|#   #         #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|### >      ####|\n" +
				"3|   ######      |\n" +
				"2|###    # . ####|\n" +
				"1|#        .o   #|\n" +
				"0|##### #########|\n" +
				"  012345678901234";

		String sequence = "UUR";

		String finalBoard =
				"7|##### #########|\n" +
				"6|#   #         #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|###    >   ####|\n" +
				"3|   ######  o   |\n" +
				"2|###    # . ####|\n" +
				"1|#        .    #|\n" +
				"0|##### #########|\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_56() {
		// Check ghost continues moving down
		String startingBoard =
				"7|##### #########|\n" +
				"6|#   #v        #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|####       ####|\n" +
				"3|     o###      |\n" +
				"2|####   # . ####|\n" +
				"1|#        .    #|\n" +
				"0|##### #########|\n" +
				"  012345678901234";

		String sequence = "DDR";

		String finalBoard =
				"7|##### #########|\n" +
				"6|#   #         #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|####       ####|\n" +
				"3|     v###      |\n" +
				"2|####   # . ####|\n" +
				"1|#     o  .    #|\n" +
				"0|##### #########|\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_57() {
		// Check ghost continues moving up
		String startingBoard =
				"7|##### #########|\n" +
				"6|#   #         #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|####       ####|\n" +
				"3|     o###      |\n" +
				"2|####   # . ####|\n" +
				"1|#   ^    .    #|\n" +
				"0|##### #########|\n" +
				"  012345678901234";

		String sequence = "UUU";

		String finalBoard =
				"7|##### #########|\n" +
				"6|#   #o        #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|####^      ####|\n" +
				"3|      ###      |\n" +
				"2|####   # . ####|\n" +
				"1|#        .    #|\n" +
				"0|##### #########|\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_58() {
		// Check ghost eats player (so game over)
		String startingBoard =
				"7|##### #########|\n" +
				"6|#   #         #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|####       ####|\n" +
				"3|    o ###      |\n" +
				"2|####   # . ####|\n" +
				"1|#   ^    .    #|\n" +
				"0|##### #########|\n" +
				"  012345678901234";

		String sequence = "D?";

		String finalBoard =
				"7|##### #########|\n" +
				"6|#   #         #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|####       ####|\n" +
				"3|      ###      |\n" +
				"2|####^  # . ####|\n" +
				"1|#        .    #|\n" +
				"0|##### #########|\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_59() {
		// Check ghost eats player (so game over)
		String startingBoard =
				"7|##### #########|\n" +
				"6|#   #         #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|####       ####|\n" +
				"3|  o   ###      |\n" +
				"2|####   # . ####|\n" +
				"1|#   ^    .    #|\n" +
				"0|##### #########|\n" +
				"  012345678901234";

		String sequence = "RR?";

		String finalBoard =
				"7|##### #########|\n" +
				"6|#   #         #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|####       ####|\n" +
				"3|    ^ ###      |\n" +
				"2|####   # . ####|\n" +
				"1|#        .    #|\n" +
				"0|##### #########|\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_60() {
		// Check ghost eats player (so game over)
		String startingBoard =
				"7|##### #########|\n" +
				"6|#   #         #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|####       ####|\n" +
				"3|      ###      |\n" +
				"2|####   # . ####|\n" +
				"1|# >  o   .    #|\n" +
				"0|##### #########|\n" +
				"  012345678901234";

		String sequence = "LL?";

		String finalBoard =
				"7|##### #########|\n" +
				"6|#   #         #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|####       ####|\n" +
				"3|      ###      |\n" +
				"2|####   # . ####|\n" +
				"1|#   >    .    #|\n" +
				"0|##### #########|\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_61() {
		// Check two ghosts
		String startingBoard =
				"7|#####v#########|\n" +
				"6|#   #         #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|####       ####|\n" +
				"3|      ###      |\n" +
				"2|####   # . ####|\n" +
				"1|# >    o .    #|\n" +
				"0|##### #########|\n" +
				"  012345678901234";

		String sequence = "RR";

		String finalBoard =
				"7|##### #########|\n" +
				"6|#   #         #|\n" +
				"5|#  ##v #  ##  #|\n" +
				"4|####       ####|\n" +
				"3|      ###      |\n" +
				"2|####   # . ####|\n" +
				"1|#   >    o    #|\n" +
				"0|##### #########|\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_62() {
		// Check three ghosts
		String startingBoard =
				"7|#####v#########|\n" +
				"6|#   #         #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|####    o  ####|\n" +
				"3|      ###     <|\n" +
				"2|####   # . ####|\n" +
				"1|# >      .    #|\n" +
				"0|##### #########|\n" +
				"  012345678901234";

		String sequence = "LL";

		String finalBoard =
				"7|##### #########|\n" +
				"6|#   #         #|\n" +
				"5|#  ##v #  ##  #|\n" +
				"4|####  o    ####|\n" +
				"3|      ###   <  |\n" +
				"2|####   # . ####|\n" +
				"1|#   >    .    #|\n" +
				"0|##### #########|\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_63() {
		// Check ghosts wrap around the board
		String startingBoard =
				"7|##### #########|\n" +
				"6|#   #         #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|####       ####|\n" +
				"3| o <  ###      |\n" +
				"2|####   # . ####|\n" +
				"1|#        .    #|\n" +
				"0|##### #########|\n" +
				"  012345678901234";

		String sequence = "LLLL";

		String finalBoard =
				"7|##### #########|\n" +
				"6|#   #         #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|####       ####|\n" +
				"3|      ###   o <|\n" +
				"2|####   # . ####|\n" +
				"1|#        .    #|\n" +
				"0|##### #########|\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_64() {
		// Check ghosts wrap around the board
		String startingBoard =
				"7|##### #########|\n" +
				"6|#   #o#       #|\n" +
				"5|#  ## #   ##  #|\n" +
				"4|#### ^     ####|\n" +
				"3|      ###      |\n" +
				"2|####   # . ####|\n" +
				"1|#        .    #|\n" +
				"0|##### #########|\n" +
				"  012345678901234";

		String sequence = "UUUU";

		String finalBoard =
				"7|##### #########|\n" +
				"6|#   # #       #|\n" +
				"5|#  ## #   ##  #|\n" +
				"4|####       ####|\n" +
				"3|      ###      |\n" +
				"2|#### o # . ####|\n" +
				"1|#        .    #|\n" +
				"0|#####^#########|\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_65() {
		// Check ghosts wrap around the board
		String startingBoard =
				"7|##### #########|\n" +
				"6|#   #         #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|####       ####|\n" +
				"3|      ###   >o |\n" +
				"2|####   # . ####|\n" +
				"1|#        .    #|\n" +
				"0|##### #########|\n" +
				"  012345678901234";

		String sequence = "RRR";

		String finalBoard =
				"7|##### #########|\n" +
				"6|#   #         #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|####       ####|\n" +
				"3|>o    ###      |\n" +
				"2|####   # . ####|\n" +
				"1|#        .    #|\n" +
				"0|##### #########|\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	/**
	 * ============================================================
	 * Part 6 --- Advanced Ghost Movement
	 * ============================================================
	 */

	@Test
	public void test_66() {
		// Check ghost moves around corner
		String startingBoard =
				"7|##### #########|\n" +
				"6|#             #|\n" +
				"5|# ###  #  ##  #|\n" +
				"4|#^#        ####|\n" +
				"3|      ###      |\n" +
				"2|####   # . ####|\n" +
				"1|# ..o    .    #|\n" +
				"0|##### #########|\n" +
				"  012345678901234";

		String sequence = "RRRR";

		String finalBoard =
				"7|##### #########|\n" +
				"6|#  >          #|\n" +
				"5|# ###  #  ##  #|\n" +
				"4|# #        ####|\n" +
				"3|      ###      |\n" +
				"2|####   # . ####|\n" +
				"1|# ..    o.    #|\n" +
				"0|##### #########|\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_67() {
		// Check ghost moves around corner
		String startingBoard =
				"7|##### #########|\n" +
				"6|#  <          #|\n" +
				"5|# ###  #  ##  #|\n" +
				"4|# #        ####|\n" +
				"3|      ###      |\n" +
				"2|####   # . ####|\n" +
				"1|# ..o    .    #|\n" +
				"0|##### #########|\n" +
				"  012345678901234";

		String sequence = "RRRR";

		String finalBoard =
				"7|##### #########|\n" +
				"6|#             #|\n" +
				"5|# ###  #  ##  #|\n" +
				"4|#v#        ####|\n" +
				"3|      ###      |\n" +
				"2|####   # . ####|\n" +
				"1|# ..    o.    #|\n" +
				"0|##### #########|\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_68() {
		// Check ghost moves around corner
		String startingBoard =
				"7|##### #########|\n" +
				"6|#             #|\n" +
				"5|# ###  #  ###^#|\n" +
				"4|# #         # #|\n" +
				"3|      ###      |\n" +
				"2|####   # . ####|\n" +
				"1|# ..o    .    #|\n" +
				"0|##### #########|\n" +
				"  012345678901234";

		String sequence = "RRRR";

		String finalBoard =
				"7|##### #########|\n" +
				"6|#         <   #|\n" +
				"5|# ###  #  ### #|\n" +
				"4|# #         # #|\n" +
				"3|      ###      |\n" +
				"2|####   # . ####|\n" +
				"1|# ..    o.    #|\n" +
				"0|##### #########|\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_69() {
		// Check ghost moves back on itself
		String startingBoard =
				"7|##### #########|\n" +
				"6|#o            #|\n" +
				"5|# ###  #  ### #|\n" +
				"4|# #         # #|\n" +
				"3|      ###      |\n" +
				"2|#v##   # . ####|\n" +
				"1|# #.     .    #|\n" +
				"0|##### #########|\n" +
				"  012345678901234";

		String sequence = "RRRR";

		String finalBoard =
				"7|##### #########|\n" +
				"6|#    o        #|\n" +
				"5|# ###  #  ### #|\n" +
				"4|# #         # #|\n" +
				"3|  >   ###      |\n" +
				"2|# ##   # . ####|\n" +
				"1|# #.     .    #|\n" +
				"0|##### #########|\n" +
				"  012345678901234";
		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_70() {
		// Check awkward starting position
		String startingBoard =
				"7|##### #########|\n" +
				"6|#o            #|\n" +
				"5|# ###  #  ### #|\n" +
				"4|# #         # #|\n" +
				"3|      ###      |\n" +
				"2|# ##   # . ####|\n" +
				"1|#^#.     .    #|\n" +
				"0|##### #########|\n" +
				"  012345678901234";

		String sequence = "UUU";

		String finalBoard =
				"7|##### #########|\n" +
				"6|#o            #|\n" +
				"5|# ###  #  ### #|\n" +
				"4|#^#         # #|\n" +
				"3|      ###      |\n" +
				"2|# ##   # . ####|\n" +
				"1|# #.     .    #|\n" +
				"0|##### #########|\n" +
				"  012345678901234";
		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_71() {
		// Check awkward starting position
		String startingBoard =
				"7|##### #########|\n" +
				"6|#o            #|\n" +
				"5|# ###  #  ### #|\n" +
				"4|# #         # #|\n" +
				"3|      ###      |\n" +
				"2|####   # . ####|\n" +
				"1|#> .     .    #|\n" +
				"0|##### #########|\n" +
				"  012345678901234";

		String sequence = "UU";

		String finalBoard =
				"7|##### #########|\n" +
				"6|#o            #|\n" +
				"5|# ###  #  ### #|\n" +
				"4|# #         # #|\n" +
				"3|      ###      |\n" +
				"2|####   # . ####|\n" +
				"1|#  >     .    #|\n" +
				"0|##### #########|\n" +
				"  012345678901234";
		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_72() {
		// Check awkward starting position
		String startingBoard =
				"7|##### #########|\n" +
				"6|#o            #|\n" +
				"5|# ###  #  ### #|\n" +
				"4|# #         # #|\n" +
				"3|      ###      |\n" +
				"2|# ##   # . ####|\n" +
				"1|#^ .     .    #|\n" +
				"0|##### #########|\n" +
				"  012345678901234";

		String sequence = "UUU";

		String finalBoard =
				"7|##### #########|\n" +
				"6|#o            #|\n" +
				"5|# ###  #  ### #|\n" +
				"4|#^#         # #|\n" +
				"3|      ###      |\n" +
				"2|# ##   # . ####|\n" +
				"1|#  .     .    #|\n" +
				"0|##### #########|\n" +
				"  012345678901234";
		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_73() {
		// Check awkward starting position
		String startingBoard =
				"7|##### #########|\n" +
				"6|#             #|\n" +
				"5|# ###  #  ### #|\n" +
				"4|#o#         # #|\n" +
				"3|      ###      |\n" +
				"2|# ##   # . ## #|\n" +
				"1|#  .     .   <#|\n" +
				"0|##### #########|\n" +
				"  012345678901234";

		String sequence = "UUU";

		String finalBoard =
				"7|##### #########|\n" +
				"6|#o            #|\n" +
				"5|# ###  #  ### #|\n" +
				"4|# #         # #|\n" +
				"3|      ###      |\n" +
				"2|# ##   # . ## #|\n" +
				"1|#  .     .<   #|\n" +
				"0|##### #########|\n" +
				"  012345678901234";
		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_74() {
		// Check ghost continues towards player
		String startingBoard =
				"7|##### #########|\n" +
				"6|#             #|\n" +
				"5|# # ####  ### #|\n" +
				"4|### ####    # #|\n" +
				"3| > o           |\n" +
				"2|#### ### . ####|\n" +
				"1|# ..     .    #|\n" +
				"0|##### #########|\n" +
				"  012345678901234";

		String sequence = "RRRR";

		String finalBoard =
				"7|##### #########|\n" +
				"6|#             #|\n" +
				"5|# # ####  ### #|\n" +
				"4|### ####    # #|\n" +
				"3|     > o       |\n" +
				"2|#### ### . ####|\n" +
				"1|# ..     .    #|\n" +
				"0|##### #########|\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_75() {
		// Check ghost changes direction towards player
		String startingBoard =
				"7|##### #########|\n" +
				"6|#             #|\n" +
				"5|# # ####  ### #|\n" +
				"4|### ####    # #|\n" +
				"3| > o           |\n" +
				"2|#### ### . ####|\n" +
				"1|# ..     .    #|\n" +
				"0|##### #########|\n" +
				"  012345678901234";

		String sequence = "UUU";

		String finalBoard =
				"7|##### #########|\n" +
				"6|#  o          #|\n" +
				"5|# # ####  ### #|\n" +
				"4|###^####    # #|\n" +
				"3|               |\n" +
				"2|#### ### . ####|\n" +
				"1|# ..     .    #|\n" +
				"0|##### #########|\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_76() {
		// Check ghost changes direction towards player
		String startingBoard =
				"7|##### #########|\n" +
				"6|#             #|\n" +
				"5|# # ####  ### #|\n" +
				"4|### ####    # #|\n" +
				"3| >o            |\n" +
				"2|#### ### . ####|\n" +
				"1|# ..     .    #|\n" +
				"0|##### #########|\n" +
				"  012345678901234";

		String sequence = "RRDD";

		String finalBoard =
				"7|##### #########|\n" +
				"6|#             #|\n" +
				"5|# # ####  ### #|\n" +
				"4|### ####    # #|\n" +
				"3|               |\n" +
				"2|####v### . ####|\n" +
				"1|# ..o    .    #|\n" +
				"0|##### #########|\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_77() {
		// Check ghost changes direction towards player
		String startingBoard =
				"7|##### #########|\n" +
				"6|#             #|\n" +
				"5|# # ####  ### #|\n" +
				"4|### ####    # #|\n" +
				"3|        o      |\n" +
				"2|#### ### . ####|\n" +
				"1|# ..    ^.    #|\n" +
				"0|##### #########|\n" +
				"  012345678901234";

		String sequence = "UUULLL";

		String finalBoard =
				"7|##### #########|\n" +
				"6|#    o <      #|\n" +
				"5|# # ####  ### #|\n" +
				"4|### ####    # #|\n" +
				"3|               |\n" +
				"2|#### ### . ####|\n" +
				"1|# ..     .    #|\n" +
				"0|##### #########|\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_78() {
		// Check ghost changes direction towards player
		String startingBoard =
				"7|##### #########|\n" +
				"6|#             #|\n" +
				"5|# # #### #### #|\n" +
				"4|### ####    # #|\n" +
				"3|        o      |\n" +
				"2|#### ### . ####|\n" +
				"1|# ..    ^.    #|\n" +
				"0|##### #########|\n" +
				"  012345678901234";

		String sequence = "UUURRR";

		String finalBoard =
				"7|##### #########|\n" +
				"6|#        > o  #|\n" +
				"5|# # #### #### #|\n" +
				"4|### ####    # #|\n" +
				"3|               |\n" +
				"2|#### ### . ####|\n" +
				"1|# ..     .    #|\n" +
				"0|##### #########|\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_79() {
		// Check ghost changes direction towards player
		String startingBoard =
				"7|##### #########|\n" +
				"6|#             #|\n" +
				"5|# # #### #### #|\n" +
				"4|########    # #|\n" +
				"3| o <           |\n" +
				"2|# ## ### . ####|\n" +
				"1|# ..     .    #|\n" +
				"0|##### #########|\n" +
				"  012345678901234";

		String sequence = "LLL";

		String finalBoard =
				"7|##### #########|\n" +
				"6|#             #|\n" +
				"5|# # #### #### #|\n" +
				"4|########    # #|\n" +
				"3|  >          o |\n" +
				"2|# ## ### . ####|\n" +
				"1|# ..     .    #|\n" +
				"0|##### #########|\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_80() {
		// Check ghost takes correct direction given ambiguous choices
		String startingBoard =
				"7|##### #########|\n" +
				"6|#             #|\n" +
				"5|# # #### #### #|\n" +
				"4|########    # #|\n" +
				"3|  >            |\n" +
				"2|#### ### . ####|\n" +
				"1|# .o     .    #|\n" +
				"0|##### #########|\n" +
				"  012345678901234";

		String sequence = "RRR";

		String finalBoard =
				"7|##### #########|\n" +
				"6|#             #|\n" +
				"5|# # #### #### #|\n" +
				"4|########    # #|\n" +
				"3|               |\n" +
				"2|####v### . ####|\n" +
				"1|# .   o  .    #|\n" +
				"0|##### #########|\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_81() {
		// Check ghost takes correct direction given ambiguous choices
		String startingBoard =
				"7|##### #########|\n" +
				"6|#             #|\n" +
				"5|# # #### #### #|\n" +
				"4|########    # #|\n" +
				"3|      <        |\n" +
				"2|#### ### . ####|\n" +
				"1|# .  o   .    #|\n" +
				"0|##### #########|\n" +
				"  012345678901234";

		String sequence = "LLL";

		String finalBoard =
				"7|##### #########|\n" +
				"6|#             #|\n" +
				"5|# # #### #### #|\n" +
				"4|########    # #|\n" +
				"3|   <           |\n" +
				"2|#### ### . ####|\n" +
				"1|# o      .    #|\n" +
				"0|##### #########|\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_82() {
		// Check ghost takes correct direction given ambiguous choices
		String startingBoard =
				"7|##### #########|\n" +
				"6|#             #|\n" +
				"5|# # #### #### #|\n" +
				"4|########    # #|\n" +
				"3|    o          |\n" +
				"2|#### ### . ####|\n" +
				"1|# .>     .    #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		String sequence = "RRR";

		String finalBoard =
				"7|##### #########|\n" +
				"6|#             #|\n" +
				"5|# # #### #### #|\n" +
				"4|########    # #|\n" +
				"3|    ^  o       |\n" +
				"2|#### ### . ####|\n" +
				"1|# .      .    #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_83() {
		// Check ghost takes correct direction given ambiguous choices
		String startingBoard =
				"7|##### #########|\n" +
				"6|#             #|\n" +
				"5|# # #### #### #|\n" +
				"4|########    # #|\n" +
				"3|     o         |\n" +
				"2|#### ### . ####|\n" +
				"1|# .   <  .    #|\n" +
				"0|##### #########|\n" +
				"  012345678901234";

		String sequence = "LLL";

		String finalBoard =
				"7|##### #########|\n" +
				"6|#             #|\n" +
				"5|# # #### #### #|\n" +
				"4|########    # #|\n" +
				"3|  o            |\n" +
				"2|####^### . ####|\n" +
				"1|# .      .    #|\n" +
				"0|##### #########|\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_84() {
		// Check ghost moves over dots
		String startingBoard =
				"7|##### #########|\n" +
				"6|#   #         #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|####       ####|\n" +
				"3|      ###      |\n" +
				"2|####   # . ####|\n" +
				"1|#>..o    .    #|\n" +
				"0|##### #########|\n" +
				"  012345678901234";

		String sequence = "RRR";

		String finalBoard =
				"7|##### #########|\n" +
				"6|#   #         #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|####       ####|\n" +
				"3|      ###      |\n" +
				"2|####   # . ####|\n" +
				"1|# ..>  o .    #|\n" +
				"0|##### #########|\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_85() {
		// Check ghost moves over dots
		String startingBoard =
				"7|##### #########|\n" +
				"6|#   #         #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|####o      ####|\n" +
				"3|      ###      |\n" +
				"2|####.  # . ####|\n" +
				"1|#   ^    .    #|\n" +
				"0|##### #########|\n" +
				"  012345678901234";

		String sequence = "RUU";

		String finalBoard =
				"7|##### #########|\n" +
				"6|#   #o        #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|####^      ####|\n" +
				"3|      ###      |\n" +
				"2|####.  # . ####|\n" +
				"1|#        .    #|\n" +
				"0|##### #########|\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_86() {
		// Check game not finished it ghost hidding dot!
		String startingBoard =
				"7|##### #########|\n" +
				"6|#   #         #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|####o      ####|\n" +
				"3|      ###      |\n" +
				"2|# ########### #|\n" +
				"1|#  > .        #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		String sequence = "RRR";

		String finalBoard =
				"7|##### #########|\n" +
				"6|#   #         #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|####   o   ####|\n" +
				"3|      ###      |\n" +
				"2|# ########### #|\n" +
				"1|#    .>       #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_87() {
		// Check game not finished if ghost hidding dot!
		String startingBoard =
				"7|##### #########|\n" +
				"6|#   #         #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|####o      ####|\n" +
				"3|      ### . <  |\n" +
				"2|# ########### #|\n" +
				"1|#  > .        #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		String sequence = "RRR";

		String finalBoard =
				"7|##### #########|\n" +
				"6|#   #         #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|####   o   ####|\n" +
				"3|      ###<.    |\n" +
				"2|# ########### #|\n" +
				"1|#    .>       #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	/**
	 * ============================================================
	 * Part 7 --- Power Pills
	 * ============================================================
	 */

	@Test
	public void test_88() {
		// Check player can eat powerup pill
		String startingBoard =
				"7|##### #########|\n" +
				"6|#   #         #|\n" +
				"5|#  ##o #  ##  #|\n" +
				"4|####       ####|\n" +
				"3|    * ### .    |\n" +
				"2|# ########### #|\n" +
				"1|#  ...        #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		String sequence = "DDLL";

		String finalBoard =
				"7|##### #########|\n" +
				"6|#   #         #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|####       ####|\n" +
				"3|   O  ### .    |\n" +
				"2|# ########### #|\n" +
				"1|#  ...        #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_89() {
		// power-up pill lasts five turns
		String startingBoard =
				"7|##### #########|\n" +
				"6|#   #         #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|####       ####|\n" +
				"3|    *o### .    |\n" +
				"2|# ########### #|\n" +
				"1|#  ...        #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		String sequence = "LLLL";

		String finalBoard =
				"7|##### #########|\n" +
				"6|#   #         #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|####       ####|\n" +
				"3| O    ### .    |\n" +
				"2|# ########### #|\n" +
				"1|#  ...        #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_90() {
		// power-up pill lasts five turns
		String startingBoard =
				"7|##### #########|\n" +
				"6|#   #         #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|####       ####|\n" +
				"3|    *o### .    |\n" +
				"2|# ########### #|\n" +
				"1|#  ...        #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		String sequence = "LLLLDD";

		String finalBoard =
				"7|##### #########|\n" +
				"6|#   #         #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|####       ####|\n" +
				"3|      ### .    |\n" +
				"2|# ########### #|\n" +
				"1|#O ...        #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_91() {
		// power-up pill lasts five turns
		String startingBoard =
				"7|##### #########|\n" +
				"6|#   #         #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|####       ####|\n" +
				"3|    *o### .    |\n" +
				"2|# ########### #|\n" +
				"1|#  ...        #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		String sequence = "LLLLDDR";

		String finalBoard =
				"7|##### #########|\n" +
				"6|#   #         #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|####       ####|\n" +
				"3|      ### .    |\n" +
				"2|# ########### #|\n" +
				"1|# o...        #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_92() {
		// power-up pill lasts five turns
		String startingBoard =
				"7|##### #########|\n" +
				"6|#   #         #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|####       ####|\n" +
				"3|   **o### .    |\n" +
				"2|# ########### #|\n" +
				"1|#  ...        #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		String sequence = "LLLLDDR";

		String finalBoard =
				"7|##### #########|\n" +
				"6|#   #         #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|####       ####|\n" +
				"3|      ### .    |\n" +
				"2|# ########### #|\n" +
				"1|# O...        #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_93() {
		// Check player can eat ghost
		String startingBoard =
				"7|##### #########|\n" +
				"6|#   #         #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|####       ####|\n" +
				"3|      ### .    |\n" +
				"2|# ########### #|\n" +
				"1|# o ..*     < #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		String sequence = "RRRRR";

		String finalBoard =
				"7|##### #########|\n" +
				"6|#   #         #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|####       ####|\n" +
				"3|      ### .    |\n" +
				"2|# ########### #|\n" +
				"1|#      O      #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_94() {
		// Check player can eat ghost
		String startingBoard =
				"7|##### #########|\n" +
				"6|#   #         #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|####       ####|\n" +
				"3|      ### .    |\n" +
				"2|# ########### #|\n" +
				"1|#  o..*     < #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		String sequence = "RRRRR";

		String finalBoard =
				"7|##### #########|\n" +
				"6|#   #         #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|####       ####|\n" +
				"3|      ### .    |\n" +
				"2|# ########### #|\n" +
				"1|#       O     #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_95() {
		// Check ghost moves away when frightened
		String startingBoard =
				"7|##### #########|\n" +
				"6|#   #         #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|####       ####|\n" +
				"3|      ### .    |\n" +
				"2|# ####### ### #|\n" +
				"1|#  o..*     < #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		String sequence = "RRRRR";

		String finalBoard =
				"7|##### #########|\n" +
				"6|#   #         #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|####       ####|\n" +
				"3|      ### .    |\n" +
				"2|# ####### ### #|\n" +
				"1|#       O  >  #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_96() {
		// Check ghost moves away when frightened
		String startingBoard =
				"7|##### #########|\n" +
				"6|#   #         #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|####   <   ####|\n" +
				"3|      ### .    |\n" +
				"2|# ####### ### #|\n" +
				"1|#  o..*       #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		String sequence = "RRRRR";

		String finalBoard =
				"7|#####^#########|\n" +
				"6|#   #         #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|####       ####|\n" +
				"3|      ### .    |\n" +
				"2|# ####### ### #|\n" +
				"1|#       O     #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_97() {
		// Check ghost moves away if frightened (when it can)
		String startingBoard =
				"7|##### #########|\n" +
				"6|#   #         #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|####       ####|\n" +
				"3|      ### .    |\n" +
				"2|# ####### ### #|\n" +
				"1|#> o..*       #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		String sequence = "RRRRR";

		String finalBoard =
				"7|##### #########|\n" +
				"6|#   #         #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|####       ####|\n" +
				"3|      ### .    |\n" +
				"2|# ####### ### #|\n" +
				"1|#     > O     #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_98() {
		// Check ghost moves away if frightened (when it can)
		String startingBoard =
				"7|##### #########|\n" +
				"6|#   #         #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|####       ####|\n" +
				"3|      ### ..   |\n" +
				"2|# ####### ### #|\n" +
				"1|#> o..  *     #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		String sequence = "RRRRRRUURR!";

		String finalBoard =
				"7|##### #########|\n" +
				"6|#   #         #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|####       ####|\n" +
				"3|      ###  O   |\n" +
				"2|# ####### ### #|\n" +
				"1|#      <      #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_99() {
		// Check ghost moves away if frightened (when it can)
		String startingBoard =
				"7|##### #########|\n" +
				"6|#   #         #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|####       ####|\n" +
				"3|      ### .... |\n" +
				"2|# ####### ### #|\n" +
				"1|# > o*.       #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		String sequence = "RRRRRUUU";

		String finalBoard =
				"7|##### #########|\n" +
				"6|#   #         #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|####     o ####|\n" +
				"3|      ### .... |\n" +
				"2|# #######^### #|\n" +
				"1|#             #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_100() {
		// Check ghost moves away if frightened (when it can)
		String startingBoard =
				"7|##### #########|\n" +
				"6|#   #         #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|####    *  ####|\n" +
				"3|      ### .... |\n" +
				"2|# ####### ### #|\n" +
				"1|# > o*.       #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		String sequence = "RRRRRUUULR";

		String finalBoard =
				"7|##### #########|\n" +
				"6|#   #         #|\n" +
				"5|#  ##  #  ##  #|\n" +
				"4|####     O ####|\n" +
				"3|      ### .... |\n" +
				"2|# #######v### #|\n" +
				"1|#             #|\n" +
				"0|###############|\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	/**
	 * ============================================================
	 * Helper Functions
	 * ============================================================
	 */

	/**
	 * This method checks whether or not the given input string is valid.
	 *
	 * ** DO NOT MODIFY THIS FUNCTION **
	 *
	 * @param sequence
	 */
	public void checkValid(String sequence, String startingBoard, String expectedFinalBoard) {
		Game game;
		System.out
		.println("===================================================");
		System.out.println("TEST " + determineTestNumber());
		System.out
		.println("===================================================");
		// Boards set to 15x8 dimension
		game = new Parser(sequence).parse(15, 8);
		game.initialiseBoard(startingBoard);
		game.run();
		// Second, create the board and apply each move to the board.
		String finalBoard = game.toString();
		if (!finalBoard.equals(expectedFinalBoard)) {
			System.out.println("EXPECTED:");
			System.out.println(expectedFinalBoard);
			System.out.println("ACTUAL:");
			System.out.println(finalBoard);
			// Using assertEquals enables result comparator in Eclipse
			assertEquals(expectedFinalBoard, finalBoard, "Invalid final board --- see the console for details");
		}
	}

	/**
	 * This method checks whether or not the given input string is invalid.
	 *
	 * ** DO NOT MODIFY THIS FUNCTION **
	 *
	 * @param sequence
	 */
	public void checkInvalid(String sequence, String startingBoard) {
		Game game;

		System.out
		.println("===================================================");
		System.out.println("TEST " + determineTestNumber());
		System.out
		.println("===================================================");

		// First, parse the list of moves
		try {
			// Boards set to 15x8 dimension
			game = new Parser(sequence).parse(15, 8);
			game.initialiseBoard(startingBoard);
			game.run();
			System.out.println("Test should have generated a GameError, but didn't");
			System.out.println("\nBOARD:");
			System.out.println(game.toString());
			fail("Test failed to throw a GameError (as expected)");
		} catch (GameError e) {
			// This is what we want to happen, since the input game is invalid.
			// Therefore, we simply exit the test correctly.
			return;
		}
	}

	/**
	 * Determine the number of the test being executed based on its method name.
	 *
	 * ** DO NOT MODIFY THIS FUNCTION **
	 *
	 * @return
	 */
	private int determineTestNumber() {
		StackTraceElement[] e = Thread.currentThread().getStackTrace();
		String line = e[3].toString();
		int numStart = line.indexOf('_')+1;
		return Integer.valueOf(line.substring(numStart, numStart+2));
	}
}
