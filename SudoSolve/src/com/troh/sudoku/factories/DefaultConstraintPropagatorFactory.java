/**
 * 
 */
package com.troh.sudoku.factories;

import com.troh.sudoku.main.ConstraintPropagator;
import com.troh.sudoku.main.DefaultConstraintPropagator;
import com.troh.sudoku.main.DefaultGridStructure;
import com.troh.sudoku.main.GridStructure;

/**
 * @author tom
 *
 */
public class DefaultConstraintPropagatorFactory implements
		ConstraintPropagatorFactory {
	
	private GridStructure gridStructure = new DefaultGridStructure();

	/* (non-Javadoc)
	 * @see com.troh.sudoku.factories.ConstraintPropagatorFactory#createConstraintPropagator()
	 */
	@Override
	public ConstraintPropagator createConstraintPropagator() {
		return new DefaultConstraintPropagator(gridStructure);
	}

}
