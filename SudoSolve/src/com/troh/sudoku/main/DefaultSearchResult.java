/**
 * 
 */
package com.troh.sudoku.main;


/**
 * @author tom
 *
 */
public class DefaultSearchResult implements SearchResult {
	private boolean status;
	private GridPossibilities gridPossibilities;
	
	public DefaultSearchResult(GridPossibilities gridPossibilities, boolean status) {
		this.gridPossibilities = gridPossibilities;
		this.status = status;
	}
	/* (non-Javadoc)
	 * @see com.troh.sudoku.main.SearchResult#getGridPossibilities()
	 */
	@Override
	public GridPossibilities getGridPossibilities() {
		return gridPossibilities;
	}

	/* (non-Javadoc)
	 * @see com.troh.sudoku.main.SearchResult#getStatus()
	 */
	@Override
	public boolean getStatus() {
		return status;
	}

}
