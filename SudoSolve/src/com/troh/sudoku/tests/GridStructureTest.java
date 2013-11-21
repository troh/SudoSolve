/**
 * 
 */
package com.troh.sudoku.tests;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import com.troh.sudoku.main.DefaultGridStructure;
import com.troh.sudoku.main.GridStructure;

/**
 * @author tom
 *
 */
public class GridStructureTest {
    private GridStructure gridStructure1;
    private GridStructure gridStructure2;
    private String[] expectedArr = {"A1", "A2", "A3", "A4", "A5", "A6", "A7", "A8", "A9",
                "B1", "B2", "B3", "B4", "B5", "B6", "B7", "B8", "B9",
                "C1", "C2", "C3", "C4", "C5", "C6", "C7", "C8", "C9",
                "D1", "D2", "D3", "D4", "D5", "D6", "D7", "D8", "D9",
                "E1", "E2", "E3", "E4", "E5", "E6", "E7", "E8", "E9",
                "F1", "F2", "F3", "F4", "F5", "F6", "F7", "F8", "F9",
                "G1", "G2", "G3", "G4", "G5", "G6", "G7", "G8", "G9",
                "H1", "H2", "H3", "H4", "H5", "H6", "H7", "H8", "H9",
                "I1", "I2", "I3", "I4", "I5", "I6", "I7", "I8", "I9"};
    private String[] c2unit1 = { "A2", "B2", "C2", "D2", "E2", "F2", "G2", "H2", "I2"};
    private String[] c2unit2 = {"C1", "C2", "C3", "C4", "C5", "C6", "C7", "C8", "C9"};
    private String[] c2unit3 = {"A1", "A2", "A3", "B1", "B2", "B3", "C1", "C2", "C3"};

    @Before
    public void setUp() {
        gridStructure1 = new DefaultGridStructure();
        gridStructure2 = new DefaultGridStructure();
    }
    
    /**
     * Test method for {@link main.strategies.BasicGridStructure#getSquares()}.
     */
    @Test
    public final void testGetSquares() {
        List<String> expected = Arrays.asList(expectedArr);
        List<String> result1 = gridStructure1.getSquares();
        List<String> result2 = gridStructure2.getSquares();
        assertTrue(result1.size() == 81 && result2.size() == 81);
        assertEquals(result1,expected);
        assertEquals(result2,expected);
    }


    /**
     * Test method for {@link main.strategies.BasicGridStructure#getUnits()}.
     */
    @Test
    public final void testGetUnits() {
        Map<String, List<List<String>>> units1 = gridStructure1.getUnits();
        Map<String, List<List<String>>> units2 = gridStructure2.getUnits();
        assertTrue(units1.get("C2").contains(Arrays.asList(c2unit1)));
        assertTrue(units1.get("C2").contains(Arrays.asList(c2unit2)));
        assertTrue(units1.get("C2").contains(Arrays.asList(c2unit3)));
        assertTrue(units2.get("C2").contains(Arrays.asList(c2unit1)));
        assertTrue(units2.get("C2").contains(Arrays.asList(c2unit2)));
        assertTrue(units2.get("C2").contains(Arrays.asList(c2unit3)));
        assertTrue(units1.size() == 81 && units2.size() == 81);
        for (Map.Entry<String, List<List<String>>> entry: units1.entrySet()) {
            assertTrue(entry.getValue().size() == 3);
        }
        for (Map.Entry<String, List<List<String>>> entry: units2.entrySet()) {
            assertTrue(entry.getValue().size() == 3);
        }
    }

    /**
     * Test method for {@link main.strategies.BasicGridStructure#getPeers()}.
     */
    @Test
    public final void testGetPeers() {
    	Set<String> expectedPeersC2 = new HashSet<>();
        addAllExcept("C2", c2unit1, expectedPeersC2);
        addAllExcept("C2", c2unit2, expectedPeersC2);
        addAllExcept("C2", c2unit3, expectedPeersC2);
        Map<String, Set<String>> peers1 = gridStructure1.getPeers();
        Map<String, Set<String>> peers2 = gridStructure2.getPeers();
        for (Map.Entry<String, Set<String>> entry: peers1.entrySet()) {
        	assertTrue(entry.getValue().size() == 20);
        }
        for (Map.Entry<String, Set<String>> entry: peers2.entrySet()) {
            assertTrue(entry.getValue().size() == 20);
        }
        assertTrue(peers1.size() == 81 && peers2.size() == 81);
        Set<String> result1 = peers1.get("C2");
        Set<String> result2 = peers2.get("C2");
        assertEquals(result1, expectedPeersC2);
        assertEquals(result2, expectedPeersC2);
    }


    private void addAllExcept(String except, String[] toAdd, Set<String> collection) {
    	for (String each: toAdd) {
    		if (!each.equals(except))
    			collection.add(each);
    	}
    }

}
