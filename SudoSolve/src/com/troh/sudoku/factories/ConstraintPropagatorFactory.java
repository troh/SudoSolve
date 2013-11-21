/**
 * 
 */
package com.troh.sudoku.factories;

import com.troh.sudoku.main.ConstraintPropagator;

/**
 * @author tom
 *
 */
public interface ConstraintPropagatorFactory {
	ConstraintPropagator createConstraintPropagator();
}
