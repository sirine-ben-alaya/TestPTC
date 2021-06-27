package com.ptc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PartitionList {

	/**
	 * returns a list of sub-list, where each sub-list has at most "taille"
	 * elements.
	 * 
	 * @param list   to split
	 * @param taille size of sub-list(s)
	 * @return partitionResult
	 */

	public static List<List<Object>> partition(List<Object> list, int taille) {

		if (list == null) {
			throw new NullPointerException("List is null");
		}
		if (taille <= 0) {
			throw new IllegalArgumentException("Size must be strictly positive");
		}
		if (list.isEmpty()) {
			return Collections.emptyList();
		}
		List<List<Object>> partitionResult = new ArrayList<>();
		if (list.size() <= taille) {
			partitionResult.add(list);
			return partitionResult;

		}
		int i = 0;
		do {
			List<Object> l = new ArrayList<>();
			for (int j = 0; j < taille; j++) {
				if (i < list.size()) {
					l.add(list.get(i));
				}
				i++;
			}
			partitionResult.add(l);

		} while (i < list.size());

		return partitionResult;

	}

}
