/**
 * 
 */
package com.troh.sudoku.main;


/**
 * @author tom
 *
 */
public class ConcreteGridDisplayer extends TemplateGridDisplayer {
	private Grid grid;
	private GridStructure gridStructure;
	
	public ConcreteGridDisplayer(Grid grid, GridStructure gridStructure) {
		this.grid = grid;
		this.gridStructure = gridStructure;
	}
	
	/* (non-Javadoc)
	 * @see com.troh.sudoku.main.TemplateGridDisplayer#getValueForIndex(int)
	 */
	@Override
	protected int getValueForIndex(int squareIndex) {
		String square = gridStructure.getSquares().get(squareIndex-1);
		return grid.getValue(square);
	}

}
