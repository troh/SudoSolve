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
	GridPossibilitiesFactory createGridPossibilitiesFactory();
	GridStructureFactory createGridStructureFactory();
	GridParserFactory createGridParserFactory();
	GridFactory createGridFactory();
}
