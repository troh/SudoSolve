/**
 * 
 */
package com.troh.sudoku.main;


/**
 * @author tom
 *
 */
public interface SearchResult {
	GridPossibilities getGridPossibilities();
	boolean getStatus();
}
