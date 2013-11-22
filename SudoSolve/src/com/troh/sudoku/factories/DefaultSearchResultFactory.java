/**
 * 
 */
package com.troh.sudoku.factories;

import com.troh.sudoku.main.DefaultSearchResult;
import com.troh.sudoku.main.GridPossibilities;
import com.troh.sudoku.main.SearchResult;

/**
 * @author tom
 *
 */
public class DefaultSearchResultFactory implements SearchResultFactory {

	@Override
	public SearchResult createSearchResult(boolean status, GridPossibilities possibilities) {
		return new DefaultSearchResult(possibilities, status);
	}


}
