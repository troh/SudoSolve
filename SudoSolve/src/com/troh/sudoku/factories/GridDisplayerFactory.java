/**
 * 
 */
package com.troh.sudoku.factories;

import com.troh.sudoku.main.Grid;
import com.troh.sudoku.main.TemplateGridDisplayer;

/**
 * @author tom
 *
 */
public interface GridDisplayerFactory {
	TemplateGridDisplayer createGridDisplayer(Grid grid);
	TemplateGridDisplayer createGridDisplayer(String gridSignature);
}
