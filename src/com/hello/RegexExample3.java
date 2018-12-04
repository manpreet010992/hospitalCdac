package com.hello;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class RegexExample3
{
	/**
	 *
	 * @param args
	 */
	public static void main(String args[])
	{
	    //Commnnnnnot
	    //Commokkkt
	    //kksdaksdncspdncskl
		Map<Integer, String> map = new HashMap<>();
		Map<Integer, String> updatedMap = new HashMap<>();
		map.put(1, "P");
		map.put(2, "N");
		map.put(3, "O");
		map.put(4, "M)");

		List<String> list = new ArrayList<>();
		list.add("N");
		list.add("O");

		resultOut(map, updatedMap, list);

	}

	private static void resultOut(Map<Integer, String> map, Map<Integer, String> updatedMap, List<String> list)
	{
		// map.keySet().parallelStream().forEach(a -> updateData(map, updatedMap, list,
		// a));

		// System.out.println(updatedMap);

		map.forEach((k, v) -> putMap(map, updatedMap, list, k, v));
		System.out.println(updatedMap);
	}

	private static Map<Integer, String> updateData(Map<Integer, String> map, Map<Integer, String> updatedMap, List<String> list, Integer a)
	{
		if (list.contains(map.get(a)))
			updatedMap.put(a,
					map.get(a));

		return updatedMap;
	}

	private static Map<Integer, String> putMap(Map<Integer, String> map, Map<Integer, String> updatedMap, List<String> list, Integer k, String v)
	{
		int index = abc(list, k, v);
		if (index != -1)
			updatedMap.put(index, map.get(index));
		return updatedMap;
	}

	private static Integer abc(List<String> list, Integer k, String v)
	{
		return list.indexOf(v) != -1 ? k : -1;

	}
}
