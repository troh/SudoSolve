/**
 * 
 */
package com.troh.sudoku.main;

import com.troh.sudoku.factories.AbstractNorvigComponentFactory;
import com.troh.sudoku.factories.GridFactory;
import com.troh.sudoku.factories.GridParserFactory;
import com.troh.sudoku.factories.GridPossibilitiesFactory;

/**
 * @author tom
 *
 */
public class NorvigSolverStrategy implements SolverStrategy {
	private static final int NUMBER_OF_SQUARES = 81;
	private Searcher searcher;
	private GridParserFactory parserFactory;
	private ConstraintPropagator constraintPropagator;
	private GridStructure gridStructure;
	private GridPossibilitiesFactory gridPossibilitiesFactory;
	private GridFactory gridFactory;
	
	
	public NorvigSolverStrategy(AbstractNorvigComponentFactory abstractFactory) {
		this.gridStructure = abstractFactory.createGridStructureFactory().createGridStructure();
		this.parserFactory = abstractFactory.createGridParserFactory();
		this.gridPossibilitiesFactory = abstractFactory.createGridPossibilitiesFactory();
		this.constraintPropagator = abstractFactory.createConstraintPropagatorFactory().createConstraintPropagator();
		this.searcher = abstractFactory.createSearcherFactory().createSearcher();
		this.gridFactory = abstractFactory.createGridFactory();
	}

	/* (non-Javadoc)
	 * @see com.troh.sudoku.main.SolverStrategy#solve(java.lang.String)
	 */
	@Override
	public Grid solve(String gridSignature) {
		GridPossibilities possibilities = gridPossibilitiesFactory.createGridPossibilities();
		GridParser gridParser = parserFactory.createGridParser(gridSignature);
		if (!assignSignatureToPossibleGrid(gridParser, possibilities)) {
			throw new IllegalArgumentException();
		}
		SearchResult searchResult = searcher.search(possibilities);
		if (!searchResult.getStatus()) {
			throw new IllegalArgumentException();
		}
		return gridFactory.createGrid(possibilities);
	}

	private boolean assignSignatureToPossibleGrid(GridParser gridParser, GridPossibilities possibilities) {
		for (int i = 0; i < NUMBER_OF_SQUARES; i++) {
			String currentSquare = gridStructure.getSquares().get(i);
			int currentValue;
			if (!gridParser.hasNext()) {
				return false;
			} else {
				currentValue = gridParser.next();
			}
			if (currentValue > 0 && !constraintPropagator.assignWithoutContradiction(currentValue, currentSquare, possibilities)) {
				return false;
			}
		}
		return true;
	}

}
