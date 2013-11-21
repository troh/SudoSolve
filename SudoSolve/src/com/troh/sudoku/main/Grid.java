/**
 * 
 */
package com.troh.sudoku.main;

import java.util.Map;

/**
 * @author tom
 *
 */
public interface Grid {
	int getValue(String square);
	Map<String, Integer> getValues();
}
