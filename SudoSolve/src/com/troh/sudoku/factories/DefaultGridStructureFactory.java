/**
 * 
 */
package com.troh.sudoku.factories;

import com.troh.sudoku.main.DefaultGridStructure;
import com.troh.sudoku.main.GridStructure;

/**
 * @author tom
 *
 */
public class DefaultGridStructureFactory implements GridStructureFactory {

	/* (non-Javadoc)
	 * @see com.troh.sudoku.factories.GridStructureFactory#createGridStructure()
	 */
	@Override
	public GridStructure createGridStructure() {
		return new DefaultGridStructure();
	}

}
