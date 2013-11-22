/**
 * 
 */
package com.troh.sudoku.launchers;

import com.troh.sudoku.factories.DefaultNorvigComponentFactory;
import com.troh.sudoku.main.ConcreteGridDisplayer;
import com.troh.sudoku.main.DefaultGridStructure;
import com.troh.sudoku.main.Grid;
import com.troh.sudoku.main.NorvigSolverStrategy;
import com.troh.sudoku.main.SolverStrategy;
import com.troh.sudoku.main.TemplateGridDisplayer;

/**
 * @author tom
 *
 */
public class ExampleLauncher {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new ExampleLauncher().launch(args);
	}

	private void launch(String[] gridSignatures) {
		SolverStrategy solverStrategy = new NorvigSolverStrategy(new DefaultNorvigComponentFactory());
		for (String puzzle: gridSignatures) {
			Grid completeGrid = solverStrategy.solve(puzzle);
			TemplateGridDisplayer gridDisplayer = new ConcreteGridDisplayer(completeGrid, new DefaultGridStructure());
			gridDisplayer.display();
		}
	}

}
