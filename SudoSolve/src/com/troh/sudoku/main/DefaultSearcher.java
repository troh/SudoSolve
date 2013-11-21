/**
 * 
 */
package com.troh.sudoku.main;

import java.util.List;

import com.troh.sudoku.factories.GridPossibilitiesFactory;

/**
 * @author tom
 *
 */
public class DefaultSearcher implements Searcher {
	private ConstraintPropagator constraintPropagator;
	private GridPossibilitiesFactory possibilitiesFactory;
	private GridStructure gridStructure;
	private int MAX_NUMBER_OF_POSSIBILITIES= 9;
	
	public DefaultSearcher(GridStructure gridStructure, ConstraintPropagator constraintPropagator, GridPossibilitiesFactory possibilitiesFactory) {
		this.gridStructure = gridStructure;
		this.constraintPropagator = constraintPropagator;
		this.possibilitiesFactory = possibilitiesFactory;
	}
	/* (non-Javadoc)
	 * @see com.troh.sudoku.main.Searcher#search(com.troh.sudoku.main.GridPossibilities)
	 */
	@Override
	public SearchResult search(GridPossibilities gridPossibilities) {
		if (gridPossibilities.isComplete()) 
			return new DefaultSearchResult(gridPossibilities, true);
		String square = getSquareWithLeastPossibilities(gridPossibilities);
		return assignNonContradictoryValueToSquare(square, gridPossibilities);
	}
	
	private SearchResult assignNonContradictoryValueToSquare(String square, GridPossibilities gridPossibilities) {
		List<Integer> possibilities = gridPossibilities.getPossibilities(square); 
		for (Integer value: possibilities) { 
			GridPossibilities copy = possibilitiesFactory.createGridPossibilities(gridPossibilities); 
			if (constraintPropagator.assignWithoutContradiction(value, square, copy)) {
				SearchResult result = search(copy);
				if (result.getStatus())
					return result;
			}
		}		
		return new DefaultSearchResult(null, false);
	}

	private String getSquareWithLeastPossibilities(GridPossibilities gridPossibilities) {
		int currentMinimum = MAX_NUMBER_OF_POSSIBILITIES;
		String currentSquare = null;
		for (String square: gridStructure.getSquares()) { 
			int numberOfPossibilities = gridPossibilities.getPossibilities(square).size();
			if (numberOfPossibilities > 1 && numberOfPossibilities <= currentMinimum) {
				currentMinimum = numberOfPossibilities;
				currentSquare = square;
			}
		}
		return currentSquare;
	}
}
