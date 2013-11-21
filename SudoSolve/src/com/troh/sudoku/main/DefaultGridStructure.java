/**
 * 
 */
package com.troh.sudoku.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.troh.sudoku.util.CrossProductUtility;

/**
 * @author tom
 *
 */
public class DefaultGridStructure implements GridStructure {
	private String LETTERS = "ABCDEFGHI";
	private String NUMBERS = "123456789";
	private String[] LETTER_TRIPLETS = {"ABC", "DEF", "GHI"};
	private String[] NUMBER_TRIPLETS = {"123","456","789"};
	private List<String> unmodifiableSquares;
	private Map<String, List<List<String>>> unmodifiableUnits;
	private Map<String, Set<String>> unmodifiablePeers;
	
	
	public DefaultGridStructure() {
		buildSquares();
		buildUnits();
		buildPeers();
	}

	private void buildPeers() {
		Map<String, Set<String>> modifiablePeers = new HashMap<>();
		for (Map.Entry<String, List<List<String>>> entry: unmodifiableUnits.entrySet()) {
			Set<String> peersOfSquare = new HashSet<>();
			for (List<String> peersInUnit: entry.getValue()) {
				peersOfSquare.addAll(peersInUnit);
			}
			peersOfSquare.remove(entry.getKey());
			modifiablePeers.put(entry.getKey(), Collections.unmodifiableSet(peersOfSquare));
		}
		unmodifiablePeers = Collections.unmodifiableMap(modifiablePeers);
	}

	private void buildUnits() {
		initUnitMap(buildUnitList());
	}

	private void initUnitMap(List<List<String>> unitList) {
		Map<String, List<List<String>>> modifiableUnits = new HashMap<>();
		for (String square: unmodifiableSquares) {
			List<List<String>> unitsForSquare = new ArrayList<>();
			for (List<String> unit: unitList) {
				if (unit.contains(square))
					unitsForSquare.add(Collections.unmodifiableList(unit));
			}
			modifiableUnits.put(square, Collections.unmodifiableList(unitsForSquare));
		}
		unmodifiableUnits = Collections.unmodifiableMap(modifiableUnits);
	}

	private List<List<String>> buildUnitList() {
		List<List<String>> unitList = new ArrayList<>();
		addColumnAndRowUnits(unitList);
		addSquareUnits(unitList);
		return unitList;
	}

	private void addSquareUnits(List<List<String>> unitList) {
		for (String letterTriplet: LETTER_TRIPLETS) {
			for (String numberTriplet: NUMBER_TRIPLETS) {
				unitList.add(CrossProductUtility.cross(letterTriplet, numberTriplet));
			}
		}
	}

	private void addColumnAndRowUnits(List<List<String>> unitList) {
		for (int i = 0; i < LETTERS.length(); i++) {
			unitList.add(CrossProductUtility.cross(Character.toString(LETTERS.charAt(i)), NUMBERS));
			unitList.add(CrossProductUtility.cross(LETTERS, Character.toString(NUMBERS.charAt(i))));
		}		
	}

	private void buildSquares() {
		List<String> modifiableSquares = CrossProductUtility.cross(LETTERS, NUMBERS);
		unmodifiableSquares = Collections.unmodifiableList(modifiableSquares);
	}

	/* (non-Javadoc)
	 * @see com.troh.sudoku.main.GridStructure#getSquares()
	 */
	@Override
	public List<String> getSquares() {
		return unmodifiableSquares;
	}

	/* (non-Javadoc)
	 * @see com.troh.sudoku.main.GridStructure#getUnits()
	 */
	@Override
	public Map<String, List<List<String>>> getUnits() {
		return unmodifiableUnits;
	}

	/* (non-Javadoc)
	 * @see com.troh.sudoku.main.GridStructure#getPeers()
	 */
	@Override
	public Map<String, Set<String>> getPeers() {
		return unmodifiablePeers;
	}

}
