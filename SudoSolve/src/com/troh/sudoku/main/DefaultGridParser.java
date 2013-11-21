/**
 * 
 */
package com.troh.sudoku.main;

/**
 * @author tom
 *
 */
public class DefaultGridParser implements GridParser {
	private String gridSignature;
	private int currentIndex = 0;
	
	public DefaultGridParser(String gridSignature) {
		this.gridSignature = gridSignature;
	}

	/* (non-Javadoc)
	 * @see com.troh.sudoku.main.GridParser#hasNext()
	 */
	@Override
	public boolean hasNext() {
		if (currentIndex < gridSignature.length()+1)
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see com.troh.sudoku.main.GridParser#next()
	 */
	@Override
	public int next() {
		return gridSignature.charAt(currentIndex++)-48;
	}

}
