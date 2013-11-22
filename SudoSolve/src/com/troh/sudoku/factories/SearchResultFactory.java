/**
 * 
 */
package com.troh.sudoku.factories;

import com.troh.sudoku.main.GridPossibilities;
import com.troh.sudoku.main.SearchResult;

/**
 * @author tom
 *
 */
public interface SearchResultFactory {
	SearchResult createSearchResult(boolean status, GridPossibilities possibilities);
}
