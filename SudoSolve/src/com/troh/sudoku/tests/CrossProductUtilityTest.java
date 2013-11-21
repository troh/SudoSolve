/**
 * 
 */
package com.troh.sudoku.tests;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import com.troh.sudoku.util.CrossProductUtility;

/**
 * @author tom
 *
 */
public class CrossProductUtilityTest {

	@Test
    public final void testCrossSimple() {
            String first = "ABC";
            String second = "123";
            String[] arr1 = {"A1", "A2", "A3", "B1", "B2", "B3", "C1", "C2", "C3"};
            List<String> expected1 = Arrays.asList(arr1);
            List<String> result1 = CrossProductUtility.cross(first, second);
            Collections.sort(result1);
            assertTrue(result1.size() == first.length()*second.length());
            assertEquals(result1,expected1);
    }
    
    @Test
    public final void testCrossMore() {
            String first = "4";
            String second = "EFGH";
            String[] arr1 = {"4E", "4F", "4G", "4H"};
            List<String> expected1 = Arrays.asList(arr1);
            List<String> result1 = CrossProductUtility.cross(first, second);
            Collections.sort(result1);
            assertTrue(result1.size() == first.length()*second.length());
            assertEquals(result1, expected1);
    }
    
    @Test(expected = NullPointerException.class)
    public final void testCrossNullFirst() {
            String second = "EFGH";
            CrossProductUtility.cross(null, second);
    }
    
    @Test(expected = NullPointerException.class)
    public final void testCrossNullSecond() {
            String first = "EFGH";
            CrossProductUtility.cross(first, null);
    }

}
