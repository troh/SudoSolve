/**
 * 
 */
package com.troh.sudoku.factories;

/**
 * @author tom
 *
 */
public interface AbstractNorvigComponentFactory {
	SearcherFactory createSearcherFactory();
	ConstraintPropagatorFactory createConstraintPropagatorFactory();
	GridDisplayerFactory createGridDisplayerFactory();
	GridPossibilitiesFactory createGridPossibilitiesFactory();
	GridStructureFactory createGridStructureFactory();
}
