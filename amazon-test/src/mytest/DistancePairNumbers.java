package mytest;

/**
You're given a list of integers and a list of pairs of integers.
For each pair of integers, print (stdout), one per line, the minimum distance at which they can be found in the list of integers, 
or -1 if at least one of them is not present in the list.
Consider that distance is defined as |j - i| where 'i' and 'j' are the indexes of the numbers in the list.

The first line of the input (stdin) will contain the number of integers ('n') and the number of pairs of integers ('p'), separated by space.
The following 'n' lines will contain an integer.
The following 'p' lines will contain two integers separated by space.


Example:
========
Input:
9 11
9
1
6
2
7
1
9
7
3
3 7
1 2
1 7
9 6
1 1
9 2
6 7
2 7
9 7
9 5
1 6


Output:
1
2
1
2
0
3
2
1
1
-1
1
*/
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DistancePairNumbers {

	public static void main(String args[]) throws FileNotFoundException {
		List<Integer> mainIntList = Arrays.asList(9, 1, 6, 2, 7, 1, 9, 7, 3);

		List<String> pairList = populatePairList("1 2", "1 7", "9 6", "1 1", "9 2", "6 7", "2 7", "9 7", "9 5", "1 6");

		calculateMinimalDistanceBetweenIndexes(mainIntList, pairList);
	}

	private static void calculateMinimalDistanceBetweenIndexes(List<Integer> mainIntList, List<String> pairList) {
		for (String eachPair : pairList) {
			String[] pairSplitted = eachPair.split(" ");

			int firstNumberPair = Integer.parseInt(pairSplitted[0]);
			int secondNumberPair = Integer.parseInt(pairSplitted[1]);

			if (mainIntList.contains(firstNumberPair) && mainIntList.contains(secondNumberPair)) {
				
				
				if (mainIntList.indexOf(secondNumberPair) >= mainIntList.indexOf(firstNumberPair)) {
					System.out.println(mainIntList.indexOf(secondNumberPair) - mainIntList.indexOf(firstNumberPair));
				} else {
					System.out.println(mainIntList.indexOf(firstNumberPair) - mainIntList.indexOf(secondNumberPair));
				}
			} else {
				System.out.println("-1");
			}
		}
	}

	private static List<String> populatePairList(String... pairs) {
		List<String> pairList = new ArrayList<>();

		for (String pair : pairs) {
			pairList.add(pair);
		}
		
		return pairList;
	}
}
