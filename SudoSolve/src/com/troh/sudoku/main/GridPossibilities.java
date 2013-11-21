/**
 * 
 */
package com.troh.sudoku.main;

import java.util.List;

/**
 * @author tom
 *
 */
public interface GridPossibilities {
	List<Integer> getPossibilities(String square);
	boolean isPossible(String square, int value);
	void eliminateAllPossibilitiesExcept(String square, int value);
	int getNumberOfPossibilities(String square);
	boolean hasSinglePossibility(String square);
	int getSinglePossibility(String square);
	boolean isComplete();
	void addPossibility(String square, int value);  
	void removePossibility(String square, int value);
}
