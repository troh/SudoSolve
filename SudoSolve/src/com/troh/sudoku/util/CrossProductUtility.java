/**
 * 
 */
package com.troh.sudoku.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tom
 *
 */
public class CrossProductUtility {
	public static List<String> cross(String first, String second) {
		List<String> product = new ArrayList<>();
		for (int i = 0; i < first.length(); i++) {
			char currentChar = first.charAt(i);
			for (int j = 0; j < second.length(); j++) {
				StringBuilder stringBuilder = new StringBuilder().append(currentChar).append(second.charAt(j));
				product.add(stringBuilder.toString());
			}
		}
		return product;
	}
}
