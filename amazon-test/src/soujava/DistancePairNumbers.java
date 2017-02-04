package soujava;

import java.util.*;

public class DistancePairNumbers {

	public List<Integer> calculateMinimalDistanceBetweenIndexes(List<Integer> mainListToSearchDistance, List<String> pairList) {
		List<Integer> resultOfMinimalDistance = new ArrayList<>();

		Map<Integer, Deque<Integer>> positions = buildMapOfPositions(mainListToSearchDistance);

		for (String pair : pairList) {
			int[] pairsToBeFound = getPairNumbersAsInt(pair);
			resultOfMinimalDistance.add(findMinimalDistanceInList(positions, pairsToBeFound));
		}

		return resultOfMinimalDistance;
	}

	private Map<Integer, Deque<Integer>> buildMapOfPositions(List<Integer> mainListToSearchDistance) {
		Map<Integer, Deque<Integer>> positions = new HashMap<>();

		for (int i = 0; i < mainListToSearchDistance.size(); i++) {
			Integer el = mainListToSearchDistance.get(i);
			if (!positions.containsKey(el)) {
				positions.put(el, new ArrayDeque<>());
			}
			positions.get(el).add(i);
		}

		return Collections.unmodifiableMap(positions);
	}

	private int[] getPairNumbersAsInt(String pair) {
		String[] pairs = pair.split(" ");

		int firstNumberOfPair = Integer.parseInt(pairs[0]);
		int secondNumberOfPair = Integer.parseInt(pairs[1]);

		return new int[]{firstNumberOfPair, secondNumberOfPair};
	}

	private int findMinimalDistanceInList(Map<Integer, Deque<Integer>> positions, int[] pairsToBeFound) {
		Deque<Integer> firstElementPositions = positions.get(pairsToBeFound[0]);
		Deque<Integer> secondElementPositions = positions.get(pairsToBeFound[1]);

		List<Integer> distances = new ArrayList<>();
		if (firstElementPositions == null || secondElementPositions == null) {
			return -1;
		}
		for (Integer firstPosition : firstElementPositions) {
			for (Integer secondPosition : secondElementPositions) {
				distances.add(Math.abs(firstPosition - secondPosition));
			}
		}

		return Collections.min(distances);
	}

}
