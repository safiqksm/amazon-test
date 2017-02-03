package soujava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class DistancePairNumbers {

	public void calculateMinimalDistanceBetweenIndexes(List<Integer> mainListToSearchDistance, List<String> pairList) {
		calculateMinimalDistanceBetweenIndexes(mainListToSearchDistance, pairList);
	}

	private static List<String> populatePairList(String... pairs) {
		return new ArrayList<>(Arrays.asList(pairs));
	}
}
