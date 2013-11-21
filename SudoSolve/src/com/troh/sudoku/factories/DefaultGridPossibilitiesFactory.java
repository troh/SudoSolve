/**
 * 
 */
package com.troh.sudoku.factories;

import com.troh.sudoku.main.DefaultGridPossibilities;
import com.troh.sudoku.main.GridPossibilities;
import com.troh.sudoku.main.GridStructure;

/**
 * @author tom
 *
 */
public class DefaultGridPossibilitiesFactory implements GridPossibilitiesFactory {

	private GridStructure gridStructure;
	
	public DefaultGridPossibilitiesFactory(GridStructure gridStructure) {
		this.gridStructure = gridStructure;
	}
	
	@Override
	public GridPossibilities createGridPossibilities() {
		return new DefaultGridPossibilities(gridStructure);
	}

	@Override
	public GridPossibilities createGridPossibilities(GridPossibilities gridPossibilities) {
		return new DefaultGridPossibilities(gridStructure, gridPossibilities);
	}

}
