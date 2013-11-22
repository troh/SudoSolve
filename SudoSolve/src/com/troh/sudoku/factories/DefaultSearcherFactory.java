/**
 * 
 */
package com.troh.sudoku.factories;

import com.troh.sudoku.main.ConstraintPropagator;
import com.troh.sudoku.main.DefaultConstraintPropagator;
import com.troh.sudoku.main.DefaultGridStructure;
import com.troh.sudoku.main.DefaultSearcher;
import com.troh.sudoku.main.GridStructure;
import com.troh.sudoku.main.Searcher;

/**
 * @author tom
 *
 */
public class DefaultSearcherFactory implements SearcherFactory {
	private GridStructure gridStructure = new DefaultGridStructure();
	private ConstraintPropagator constraintPropagator = new DefaultConstraintPropagator(gridStructure);
	private GridPossibilitiesFactory possibilitiesFactory = new DefaultGridPossibilitiesFactory(gridStructure);
	private SearchResultFactory searchResultFactory = new DefaultSearchResultFactory();

	/* (non-Javadoc)
	 * @see com.troh.sudoku.factories.SearcherFactory#createSearcher()
	 */
	@Override
	public Searcher createSearcher() {
		return new DefaultSearcher(gridStructure, constraintPropagator, possibilitiesFactory, searchResultFactory);
	}

}
