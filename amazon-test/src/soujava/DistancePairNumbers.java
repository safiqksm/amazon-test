package soujava;

import java.util.List;


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
		
		int firstPositionIndexFoun = 0;
		
		for (Integer numberOfMainList : mainListToSearchDistance) {
			int distanceCount = 0;
			
			if (numberOfMainList.equals(firstNumberOfPair) && !isFistNumberFound) {
				
				
				isFistNumberFound = true;
			} else if (numberOfMainList.equals(secondNumberOfPair) && !isSecondNumberFound) {
				isSecondNumberFound = true;
			} else if (isFistNumberFound && isSecondNumberFound) {
				
			} else {
				distanceCount++;
			}
		}
		
	}

}
