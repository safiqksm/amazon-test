package soujava;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DistancePairNumbers {

	public List<Integer> calculateMinimalDistanceBetweenIndexes(List<Integer> mainListToSearchDistance, List<String> pairList) {
		
		for (String pair : pairList) {
			
			int[] pairsToBeFound = getPairNumbersAsInt(pair);
			
			findMinimalDistanceInList(mainListToSearchDistance, pairsToBeFound[0], pairsToBeFound[1]);
		}
		
		return null;
		
	}
	
	private int[] getPairNumbersAsInt(String pair) {
		String[] pairs = pair.split(" ");
		
		int firstNumberOfPair = Integer.parseInt(pairs[0]);
		int secondNumberOfPair = Integer.parseInt(pairs[1]);
		
		return new int[]{firstNumberOfPair, secondNumberOfPair};
	}

	private void findMinimalDistanceInList(List<Integer> mainListToSearchDistance, int firstNumberOfPair, int secondNumberOfPair) {
		boolean isFistNumberFound = false;
		boolean isSecondNumberFound = false;
		
		int firstIndexFound = 0;
		
		int firstNumberPositionIndexFound = 0;
		int secondNumberPositionIndexFound = 0;
		
		Map<String, Integer> resultMap = new HashMap<>();
		
		List<Integer> minimalDistanceBetweenNumbers = new ArrayList<>();
		
//		resultMap.put(key, value)
		
		for (int indexOfMainList = 0; indexOfMainList <=  mainListToSearchDistance.size(); indexOfMainList++) {
			int distanceCount = 0;
			
			if (mainListToSearchDistance.get(indexOfMainList).equals(firstNumberOfPair) && !isFistNumberFound) {
				firstNumberPositionIndexFound = indexOfMainList;
				
				isFistNumberFound = true;
			} else if (mainListToSearchDistance.get(indexOfMainList).equals(secondNumberOfPair) && !isSecondNumberFound) {
				secondNumberPositionIndexFound = indexOfMainList;

				isSecondNumberFound = true;
			} else if (isFistNumberFound && isSecondNumberFound) {
				if (firstNumberPositionIndexFound >= secondNumberPositionIndexFound) {
					firstIndexFound = firstNumberPositionIndexFound;
				} else {
					firstIndexFound = secondNumberPositionIndexFound;
				}
				
				indexOfMainList = firstIndexFound + 1;
			} else {
				distanceCount++;
			}
			
			indexOfMainList++;
		}
		
	}

}
