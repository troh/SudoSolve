/**
 * 
 */
package com.troh.sudoku.main;


/**
 * @author tom
 *
 */
public interface Searcher {
	SearchResult search(GridPossibilities gridPossibilities);
}
