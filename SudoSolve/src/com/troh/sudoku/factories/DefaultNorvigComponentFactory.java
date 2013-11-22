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
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.troh.sudoku.factories.AbstractNorvigComponentFactory#createGridPossibilitiesFactory()
	 */
	@Override
	public GridPossibilitiesFactory createGridPossibilitiesFactory() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.troh.sudoku.factories.AbstractNorvigComponentFactory#createGridStructureFactory()
	 */
	@Override
	public GridStructureFactory createGridStructureFactory() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.troh.sudoku.factories.AbstractNorvigComponentFactory#createGridParserFactory()
	 */
	@Override
	public GridParserFactory createGridParserFactory() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.troh.sudoku.factories.AbstractNorvigComponentFactory#createGridFactory()
	 */
	@Override
	public GridFactory createGridFactory() {
		// TODO Auto-generated method stub
		return null;
	}

}
