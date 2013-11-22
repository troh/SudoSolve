/**
 * 
 */
package com.troh.sudoku.factories;

/**
 * @author tom
 *
 */
public class DefaultNorvigComponentFactory implements AbstractNorvigComponentFactory {

	/* (non-Javadoc)
	 * @see com.troh.sudoku.factories.AbstractNorvigComponentFactory#createSearcherFactory()
	 */
	@Override
	public SearcherFactory createSearcherFactory() {
		return new DefaultSearcherFactory();
	}

	/* (non-Javadoc)
	 * @see com.troh.sudoku.factories.AbstractNorvigComponentFactory#createConstraintPropagatorFactory()
	 */
	@Override
	public ConstraintPropagatorFactory createConstraintPropagatorFactory() {
		return new DefaultConstraintPropagatorFactory();
	}

	/* (non-Javadoc)
	 * @see com.troh.sudoku.factories.AbstractNorvigComponentFactory#createGridPossibilitiesFactory()
	 */
	@Override
	public GridPossibilitiesFactory createGridPossibilitiesFactory() {
		return new DefaultGridPossibilitiesFactory();
	}

	/* (non-Javadoc)
	 * @see com.troh.sudoku.factories.AbstractNorvigComponentFactory#createGridStructureFactory()
	 */
	@Override
	public GridStructureFactory createGridStructureFactory() {
		return new DefaultGridStructureFactory();
	}

	/* (non-Javadoc)
	 * @see com.troh.sudoku.factories.AbstractNorvigComponentFactory#createGridParserFactory()
	 */
	@Override
	public GridParserFactory createGridParserFactory() {
		return new DefaultGridParserFactory();
	}

	/* (non-Javadoc)
	 * @see com.troh.sudoku.factories.AbstractNorvigComponentFactory#createGridFactory()
	 */
	@Override
	public GridFactory createGridFactory() {
		return new DefaultGridFactory();
	}

}
