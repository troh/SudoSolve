package com.troh.sudoku.tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.troh.sudoku.factories.DefaultNorvigComponentFactory;
import com.troh.sudoku.main.DefaultGridStructure;
import com.troh.sudoku.main.Grid;
import com.troh.sudoku.main.GridStructure;
import com.troh.sudoku.main.NorvigSolverStrategy;
import com.troh.sudoku.main.SolverStrategy;

public class SolverStrategyTest {
	private String hardPuzzle1 = "4.....8.5.3..........7......2.....6.....8.4......1.......6.3.7.5..2.....1.4......";
	private String hardPuzzle2 = "52...6.........7.13...........4..8..6......5...........418.........3..2...87.....";
	private String solution1 = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
	private String solution2 = "527316489896542731314987562172453896689271354453698217941825673765134928238769145";
	private SolverStrategy norvigSolve;
	private GridStructure gridStructure;
	
	@Before
	public void setUp() {
		norvigSolve = new NorvigSolverStrategy(new DefaultNorvigComponentFactory());
		gridStructure = new DefaultGridStructure();
	}
	
	@Test
	public void testHardPuzzle1() {
		Grid result = norvigSolve.solve(hardPuzzle1);
		assertTrue(compareSignatureWithGrid(solution1, result));
	}
	
	@Test
	public void testHardPuzzle2() {
		Grid result = norvigSolve.solve(hardPuzzle2);
		assertTrue(compareSignatureWithGrid(solution2, result));
	}
	
	private boolean compareSignatureWithGrid(String signature, Grid grid) {
		List<String> squares = gridStructure.getSquares();
		for (int i = 0; i < 81; i++) {
			if (signature.charAt(i)-48 != grid.getValue(squares.get(i))) {
				return false;
			}
		}
		return true;
	}

}
