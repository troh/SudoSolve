/**
 * 
 */
package com.troh.sudoku.main;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author tom
 *
 */
public interface GridStructure {
	List<String> getSquares();
	Map<String, List<List<String>>> getUnits();
	Map<String, Set<String>> getPeers();
}
