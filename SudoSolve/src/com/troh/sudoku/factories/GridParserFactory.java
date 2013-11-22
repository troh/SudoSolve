/**
 * 
 */
package com.troh.sudoku.factories;

import com.troh.sudoku.main.GridParser;

/**
 * @author tom
 *
 */
public interface GridParserFactory {
	GridParser createGridParser(String gridSignature);
}
