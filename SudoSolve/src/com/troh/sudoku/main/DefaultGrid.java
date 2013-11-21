/**
 * 
 */
package com.troh.sudoku.main;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


/**
 * @author tom
 *
 */
public class DefaultGrid implements Grid {
	private Map<String, Integer> grid = new HashMap<>();
	private GridStructure gridStructure;
	
	public DefaultGrid(GridStructure gridStructure, GridPossibilities gridPossibilities) {
		this.gridStructure = gridStructure;
		copyContentsToMap(gridPossibilities);
	}
	
	private void copyContentsToMap(GridPossibilities gridPossibilities) {
		if (!gridPossibilities.isComplete())
			throw new IllegalArgumentException();
		for (String square: gridStructure.getSquares()) {
			grid.put(square, gridPossibilities.getSinglePossibility(square));
		}
	}

	/* (non-Javadoc)
	 * @see com.troh.sudoku.main.Grid#getValue(java.lang.String)
	 */
	@Override
	public int getValue(String square) {
		return grid.get(square);
	}

	/* (non-Javadoc)
	 * @see com.troh.sudoku.main.Grid#getValues()
	 */
	@Override
	public Map<String, Integer> getValues() {
		return Collections.unmodifiableMap(grid);
	}

}
