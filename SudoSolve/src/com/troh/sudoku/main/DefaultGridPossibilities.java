/**
 * 
 */
package com.troh.sudoku.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author tom
 *
 */
public class DefaultGridPossibilities implements GridPossibilities {
	private Map<String, List<Integer>> possibilities = new HashMap<>();
	private List<String> squares;
	private static int TOTAL_SQUARES = 81;
	private int completedSquares = 0;
	
	
	public DefaultGridPossibilities(GridStructure gridStructure) {
		this.squares = gridStructure.getSquares();
		populateWithAllPossibilities();
	}
	
	private void populateWithAllPossibilities() {
		for (String square: squares) {
			possibilities.put(square, buildFullList());
		}
	}
	
	private List<Integer> buildFullList() {
		List<Integer> fullList = new ArrayList<>();
		for (int i = 1; i <= 9; i++) {
			fullList.add(i);
		}
		return fullList;
	}

	public DefaultGridPossibilities(GridStructure gridStructure, GridPossibilities gridPossibilities) {
		this.squares = gridStructure.getSquares();
		copyConstruct(gridPossibilities);
	}
	
	private void copyConstruct(GridPossibilities gridPossibilities) {
		this.completedSquares = ((DefaultGridPossibilities)gridPossibilities).completedSquares;
		for (String square: squares) {
			List<Integer> possibleValuesForSquare = gridPossibilities.getPossibilities(square);
			List<Integer> copiedValues = new ArrayList<>();
			copiedValues.addAll(possibleValuesForSquare);
			possibilities.put(square, copiedValues);
		}
	}
	
	/* (non-Javadoc)
	 * @see com.troh.sudoku.main.GridPossibilities#getPossibilities(java.lang.String)
	 */
	@Override
	public List<Integer> getPossibilities(String square) {
		return Collections.unmodifiableList(possibilities.get(square));
	}

	/* (non-Javadoc)
	 * @see com.troh.sudoku.main.GridPossibilities#isPossible(java.lang.String, int)
	 */
	@Override
	public boolean isPossible(String square, int value) {
		return possibilities.get(square).contains(value);
	}

	/* (non-Javadoc)
	 * @see com.troh.sudoku.main.GridPossibilities#eliminateAllPossibilitiesExcept(java.lang.String, int)
	 */
	@Override
	public void eliminateAllPossibilitiesExcept(String square, int value) {
		List<Integer> values = possibilities.get(square);
		values.clear();
		values.add(value);
	}

	/* (non-Javadoc)
	 * @see com.troh.sudoku.main.GridPossibilities#getNumberOfPossibilities(java.lang.String)
	 */
	@Override
	public int getNumberOfPossibilities(String square) {
		return possibilities.get(square).size();
	}

	/* (non-Javadoc)
	 * @see com.troh.sudoku.main.GridPossibilities#hasSinglePossibility(java.lang.String)
	 */
	@Override
	public boolean hasSinglePossibility(String square) {
		return (possibilities.get(square).size() == 1);
	}

	/* (non-Javadoc)
	 * @see com.troh.sudoku.main.GridPossibilities#getSinglePossibility(java.lang.String)
	 */
	@Override
	public int getSinglePossibility(String square) {
		int numberOfPossibilities = possibilities.get(square).size();
		if (numberOfPossibilities != 1)
			throw new IllegalArgumentException();
		return possibilities.get(square).get(0);
	}

	/* (non-Javadoc)
	 * @see com.troh.sudoku.main.GridPossibilities#isComplete()
	 */
	@Override
	public boolean isComplete() {
		return (completedSquares == TOTAL_SQUARES);
	}

	/* (non-Javadoc)
	 * @see com.troh.sudoku.main.GridPossibilities#addPossibility(java.lang.String, int)
	 */
	@Override
	public void addPossibility(String square, int value) {
		List<Integer> possibleValues = possibilities.get(square); 
		if (possibleValues.contains(value))
			throw new IllegalArgumentException();
		possibleValues.add(value);
		possibilityAdded(square);
	}

	/* (non-Javadoc)
	 * @see com.troh.sudoku.main.GridPossibilities#removePossibility(java.lang.String, int)
	 */
	@Override
	public void removePossibility(String square, int value) {
		List<Integer> possibleValues = possibilities.get(square);
		int index = possibleValues.indexOf(value);
		if (index == -1)
			throw new IllegalArgumentException();
		possibleValues.remove(index);
		possibilityRemoved(square);
	}
	
	private void possibilityRemoved(String square) {
		if (hasSinglePossibility(square))
			completedSquares++;
	}
	
	private void possibilityAdded(String square) {
		if (possibilities.get(square).size() == 2)
			completedSquares--;
	}	
}
