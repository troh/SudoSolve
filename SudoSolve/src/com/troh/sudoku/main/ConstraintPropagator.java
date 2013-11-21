/**
 * 
 */
package com.troh.sudoku.main;


/**
 * @author tom
 *
 */
public interface ConstraintPropagator {
	public boolean assignWithoutContradiction(int value, String square, GridPossibilities gridPossibilities);

}
