/**
 * 
 */
package com.troh.sudoku.main;

/**
 * @author tom
 *
 */
public class StringGridDisplayer extends TemplateGridDisplayer {
	private String grid;
	
	public StringGridDisplayer(String grid) {
		this.grid = grid;
	}
	
	/* (non-Javadoc)
	 * @see com.troh.sudoku.main.TemplateGridDisplayer#getValueForIndex(int)
	 */
	@Override
	protected int getValueForIndex(int squareIndex) {
		return grid.charAt(squareIndex-1);
	}

}
