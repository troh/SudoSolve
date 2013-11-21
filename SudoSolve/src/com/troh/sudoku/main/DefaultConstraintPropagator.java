/**
 * 
 */
package com.troh.sudoku.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author tom
 *
 */
public class DefaultConstraintPropagator implements ConstraintPropagator {
	private GridStructure gridStructure;
	
	public DefaultConstraintPropagator(GridStructure gridStructure) {
		this.gridStructure = gridStructure;
	}

	/* (non-Javadoc)
	 * @see com.troh.sudoku.main.ConstraintPropagator#assignWithoutContradiction(int, java.lang.String, com.troh.sudoku.main.GridPossibilities)
	 */
	@Override
	public boolean assignWithoutContradiction(int value, String square, GridPossibilities gridPossibilities) {
		List<Integer> otherPossibleValues = getAllOtherPossibleValues(value, square, gridPossibilities);
		for (Integer toEliminate: otherPossibleValues) {
			if (!eliminateWithoutContradiction(toEliminate, square, gridPossibilities))
				return false;
		}
		return true;
	}
	
	private boolean eliminateWithoutContradiction(int toEliminate, String square, GridPossibilities gridPossibilities) {
		if (alreadyEliminated(toEliminate, square, gridPossibilities))
			return true;
		gridPossibilities.removePossibility(square, toEliminate);
		if (noPossibilitiesLeft(square, gridPossibilities)) 
			return false;
		if (gridPossibilities.hasSinglePossibility(square)) {
			int remainingPossibility = gridPossibilities.getSinglePossibility(square);
			if (!eliminateFromPeersWithoutContradiction(remainingPossibility, square, gridPossibilities))
				return false;
		}
		return eliminateFromUnitsWithoutContradiction(toEliminate, square, gridPossibilities);
	}

	private boolean eliminateFromPeersWithoutContradiction(int value, String square, GridPossibilities gridPossibilities) {
		Set<String> peers = gridStructure.getPeers().get(square);
		for (String peer: peers) {
			if (!eliminateWithoutContradiction(value, peer, gridPossibilities))
				return false;
		}
		return true;
	}

	private boolean eliminateFromUnitsWithoutContradiction(int value, String square, GridPossibilities gridPossibilities) {
		List<List<String>> unitsThatContainSquare = gridStructure.getUnits().get(square);
		for (List<String> unit: unitsThatContainSquare) {
			List<String> squaresWithValue = findSquaresThatHavePossibility(value, unit, gridPossibilities);
			if (squaresWithValue.size() == 0) {
				return false;
			} else if (squaresWithValue.size() == 1) {
				if (!assignWithoutContradiction(value, squaresWithValue.get(0), gridPossibilities))
					return false;
			}
		}
		return true;
	}

	private List<String> findSquaresThatHavePossibility(int value, List<String> unit, GridPossibilities gridPossibilities) {
		List<String> squaresWithPossibility = new ArrayList<>();
		for (String square: unit) { //find the squares that are members of the units that contain the value in question
			if (gridPossibilities.getPossibilities(square).contains(value)) {
				squaresWithPossibility.add(square);
			}
		}
		return squaresWithPossibility;
	}

	private boolean noPossibilitiesLeft(String square, GridPossibilities gridPossibilities) {
		return (gridPossibilities.getNumberOfPossibilities(square) == 0);
	}

	private boolean alreadyEliminated(int value, String square, GridPossibilities gridPossibilities) {
		return !gridPossibilities.isPossible(square, value);
	}

	private List<Integer> getAllOtherPossibleValues(int value, String square, GridPossibilities gridPossibilities) {
		List<Integer> otherValues = new ArrayList<>();
		for (Integer possibility: gridPossibilities.getPossibilities(square)) {
			if (possibility != value)
				otherValues.add(possibility);
		}
		return otherValues;
	}
}
