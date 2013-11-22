/**
 * 
 */
package com.troh.sudoku.factories;

import com.troh.sudoku.main.DefaultGridParser;
import com.troh.sudoku.main.GridParser;

/**
 * @author tom
 *
 */
public class DefaultGridParserFactory implements GridParserFactory {


	@Override
	public GridParser createGridParser(String gridSignature) {
		return new DefaultGridParser(gridSignature);
	}

}
