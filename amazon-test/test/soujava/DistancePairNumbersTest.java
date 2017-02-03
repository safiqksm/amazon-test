package soujava;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.runners.Parameterized.Parameters

@RunWith(Parameterized.class)
public class DistancePairNumbersTest {

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {
                    Arrays.asList(9, 1, 6, 2, 7, 1, 9, 7, 3),
                    Arrays.asList("3 7", "1 2", "1 7", "9 6", "1 1", "9 2", "6 7", "2 7", "9 7", "9 5", "1 6"),
                    Arrays.asList(1, 2, 1, 2, 0, 3, 2, 1, 1, -1, 1)
                }
        });
    }


    private List<Integer> mainListToSearchDistance;
    private List<String> pairList;
    private List<Integer> distances;

    public DistancePairNumbersTest(List<Integer> mainListToSearchDistance, List<String> pairList, List<Integer> distances) {
        this.mainListToSearchDistance = mainListToSearchDistance;
        this.pairList = pairList;
        this.distances = distances;
    }

    public void testCalculateDistance() {
        DistancePairNumbers dpn = new DistancePairNumbers();
        List<Integer> actualDistances = dpn.calculateMinimalDistanceBetweenIndexes(mainListToSearchDistance, pairList);
        for (int i = 0; i < pairList.size(); i++) {
            assertEquals("Erro ao avaliar o par: " + pairList.get(i), distances.get(i), actualDistances.get(i));
        }
    }
}