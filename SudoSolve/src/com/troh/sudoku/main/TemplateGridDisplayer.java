/**
 * 
 */
package com.troh.sudoku.main;

/**
 * @author tom
 *
 */
public abstract class TemplateGridDisplayer {
	private final static String DASHES = "------+------+------\n";
	
	public void display() {
		StringBuilder stringBuilder = new StringBuilder();
		for (int squareIndex = 1; squareIndex <= 81; squareIndex++) {
			int currentValue = getValueForIndex(squareIndex);
			stringBuilder.append(currentValue);
			formatAdjacentChars(stringBuilder, squareIndex);
		}
		System.out.println(stringBuilder.toString());
	}
	
	private void formatAdjacentChars(StringBuilder stringBuilder, int squareIndex) {
		if (squareIndex % 9 == 0) {
			stringBuilder.append("\n");
			if (squareIndex % 27 == 0 && squareIndex != 81) {
				stringBuilder.append(DASHES);
			}
		} else {
			stringBuilder.append(" ");
			if (squareIndex % 3 == 0)
				stringBuilder.append("|");
		}
	}
	
	protected abstract int getValueForIndex(int squareIndex);
}
