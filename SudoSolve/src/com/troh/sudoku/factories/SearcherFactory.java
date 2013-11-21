/**
 * 
 */
package com.troh.sudoku.factories;

import com.troh.sudoku.main.Searcher;

/**
 * @author tom
 *
 */
public interface SearcherFactory {
	Searcher createSearcher();
}
