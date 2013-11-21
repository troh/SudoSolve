/**
 * 
 */
package com.troh.sudoku.factories;

import com.troh.sudoku.main.GridPossibilities;


/**
 * @author tom
 *
 */
public interface GridPossibilitiesFactory {
	GridPossibilities createGridPossibilities();
	GridPossibilities createGridPossibilities(GridPossibilities gridPossibilities);
}
