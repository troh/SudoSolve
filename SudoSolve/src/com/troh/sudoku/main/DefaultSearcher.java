/**
 * 
 */
package com.troh.sudoku.main;

import java.util.List;

import com.troh.sudoku.factories.GridPossibilitiesFactory;
import com.troh.sudoku.factories.SearchResultFactory;

/**
 * @author tom
 *
 */
public class DefaultSearcher implements Searcher {
	private ConstraintPropagator constraintPropagator;
	private GridPossibilitiesFactory possibilitiesFactory;
	private SearchResultFactory searchResultFactory;
	private GridStructure gridStructure;
	private int MAX_NUMBER_OF_POSSIBILITIES= 9;
	
	public DefaultSearcher(GridStructure gridStructure, ConstraintPropagator constraintPropagator, 
							GridPossibilitiesFactory possibilitiesFactory, SearchResultFactory searchResultFactory) {
		this.gridStructure = gridStructure;
		this.constraintPropagator = constraintPropagator;
		this.possibilitiesFactory = possibilitiesFactory;
		this.searchResultFactory = searchResultFactory;
	}
	
	/* (non-Javadoc)
	 * @see com.troh.sudoku.main.Searcher#search(com.troh.sudoku.main.GridPossibilities)
	 */
	@Override
	public SearchResult search(GridPossibilities gridPossibilities) {
		if (gridPossibilities.isComplete()) 
			return searchResultFactory.createSearchResult(true, gridPossibilities);
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
		return searchResultFactory.createSearchResult(false, null);
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
