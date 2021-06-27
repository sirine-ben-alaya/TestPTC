package com.testjunit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.*;

import com.ptc.PartitionList;

public class PartitionListTest {
	List l;

	@Before
	public void init() {
		l = new ArrayList<>();
		l.add(1);
		l.add(2);
		l.add(3);
	}

	@Test
	public void testEmptyList()

	{
		assertTrue(PartitionList.partition(Collections.emptyList(), 1).isEmpty());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNegativeSize()

	{
		PartitionList.partition(l, -1);
	}

	@Test(expected = NullPointerException.class)
	public void testListIsNull()

	{
		PartitionList.partition(null, 1);
	}

	@Test
	public void testSizeGreaterThanListSize()

	{
		List<List<Object>> expectedList = new ArrayList<>();
		List<Object> innerList = new ArrayList<>();
		innerList.add(1);
		innerList.add(2);
		innerList.add(3);
		expectedList.add(innerList);
		List<List<Object>> result = PartitionList.partition(l, 4);
		assertEquals(expectedList, result);
	}

	@Test
	public void testSizeLessThanListSize()

	{
		List<List<Object>> expectedList = new ArrayList<>();
		List<Object> innerList = new ArrayList<>();
		innerList.add(1);
		innerList.add(2);
		expectedList.add(innerList);
		innerList = new ArrayList<>();
		innerList.add(3);
		expectedList.add(innerList);
		List<List<Object>> result = PartitionList.partition(l, 2);
		assertEquals(expectedList, result);
	}

	@Test
	public void testSizeEqualsListSize()

	{
		List<List<Object>> expectedList = new ArrayList<>();
		expectedList.add(l);
		List<List<Object>> result = PartitionList.partition(l, 3);
		assertEquals(expectedList, result);
	}

}
