package com.troh.sudoku.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.troh.sudoku.main.DefaultGridParser;
import com.troh.sudoku.main.GridParser;

public class GridParserTest {
	
	private String gridSignature = "0123456789";
	private GridParser gridParser;
	
	@Before
	public void setup() {
		gridParser = new DefaultGridParser(gridSignature);
	}

	@Test
	public void testCorrectOutput() {
		for (int i = 0; i <= 9; i++) {
			assertTrue(gridParser.hasNext());
			assertEquals(gridParser.next(), i);
		}
		assertFalse(gridParser.hasNext());
	}

}
