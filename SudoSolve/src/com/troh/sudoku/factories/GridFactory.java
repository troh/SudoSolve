/**
 * 
 */
package com.troh.sudoku.factories;

import com.troh.sudoku.main.Grid;
import com.troh.sudoku.main.GridPossibilities;

/**
 * @author tom
 *
 */
public interface GridFactory {
	Grid createGrid(GridPossibilities gridPossibilities);
}
