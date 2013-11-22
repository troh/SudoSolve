/**
 * 
 */
package com.troh.sudoku.factories;

import com.troh.sudoku.main.DefaultGrid;
import com.troh.sudoku.main.DefaultGridStructure;
import com.troh.sudoku.main.Grid;
import com.troh.sudoku.main.GridPossibilities;
import com.troh.sudoku.main.GridStructure;

/**
 * @author tom
 *
 */
public class DefaultGridFactory implements GridFactory {
	private GridStructure gridStructure = new DefaultGridStructure();

	/* (non-Javadoc)
	 * @see com.troh.sudoku.factories.GridFactory#createGrid(com.troh.sudoku.main.GridPossibilities)
	 */
	@Override
	public Grid createGrid(GridPossibilities gridPossibilities) {
		return new DefaultGrid(gridStructure,gridPossibilities);
	}

}
