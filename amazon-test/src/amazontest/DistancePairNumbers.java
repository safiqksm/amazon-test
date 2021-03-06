package amazontest;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class DistancePairNumbers {
    public static void main(String args[]) throws FileNotFoundException {
//        Scanner in = new Scanner(new FileInputStream("/home/local/ANT/lestrozi/IdeaProjects/untitled1/src/q2/test15"));
        //Scanner in = new Scanner(new FileInputStream(args[0]));
        Scanner in = new Scanner(System.in);

        final int n = in.nextInt();
        final int p = in.nextInt();

        HashMap<Integer, ArrayList<Integer>> valueToPositions = new HashMap<Integer, ArrayList<Integer>>();
        for(int i = 0; i < n; i++) {
            int v = in.nextInt();
            if (!valueToPositions.containsKey(v)) {
                valueToPositions.put(v, new ArrayList<Integer>());
            }
            valueToPositions.get(v).add(i);
        }

        for(int i = 0; i < p; i++) {
            Integer n1 = in.nextInt();
            Integer n2 = in.nextInt();

            if ((!valueToPositions.containsKey(n1)) || (!valueToPositions.containsKey(n2))) {
                System.out.println(-1);
                continue;
            }

            ArrayList<Integer> n1Pos = valueToPositions.get(n1);
            ArrayList<Integer> n2Pos = valueToPositions.get(n2);
            int minDistance = Integer.MAX_VALUE;
            int j=0;
            int k=0;
            while((j < n1Pos.size()) && (k < n2Pos.size())) {
                int thisDistance = Math.abs(n1Pos.get(j) - n2Pos.get(k));
                if (thisDistance < minDistance) {
                    minDistance = thisDistance;
                }

                if (n1Pos.get(j) < n2Pos.get(k)) {
                    j++;
                }
                else {
                    k++;
                }
            }

            System.out.println(minDistance);
        }
/*
        HashMap<Integer, ArrayList<Integer>> valueToPositions = new HashMap<Integer, ArrayList<Integer>>();
        for(int i = 0; i < n; i++) {
            int v = in.nextInt();
            if (!valueToPositions.containsKey(v)) {
                valueToPositions.put(v, new ArrayList<Integer>());
            }
            valueToPositions.get(v).add(i);
        }

        for(int i = 0; i < p; i++) {
            Integer n1 = in.nextInt();
            Integer n2 = in.nextInt();

            if ((!valueToPositions.containsKey(n1)) || (!valueToPositions.containsKey(n2))) {
                System.out.println(-1);
                continue;
            }

            ArrayList<Integer> n1Pos = valueToPositions.get(n1);
            ArrayList<Integer> n2Pos = valueToPositions.get(n2);
            int minDistance = Integer.MAX_VALUE;
            for(int j=0; j<n1Pos.size(); j++) {
                for(int k=0; k<n2Pos.size(); k++) {
                    int thisDistance = Math.abs(n1Pos.get(j) - n2Pos.get(k));
                    if (thisDistance < minDistance) {
                        minDistance = thisDistance;
                    }
                }
            }

            System.out.println(minDistance);
        }
*/

/*
        List<Integer> numbers = new ArrayList<Integer>();
        for(int i = 0; i < n; i++) {
            int v = in.nextInt();
            numbers.add(v);
        }

        for(int i = 0; i < p; i++) {
            Integer n1 = in.nextInt();
            Integer n2 = in.nextInt();

            int pos1 = -1;
            int pos2 = -1;
            int minDistance = Integer.MAX_VALUE;
            for(int j=0; j<n; j++) {
                if (n1.equals(numbers.get(j))) {
                    pos1 = j;

                    int thisDistance = Math.abs(pos1 - pos2);
                    if ((pos2 != -1) && (thisDistance < minDistance)) {
                        minDistance = thisDistance;
                    }
                }
                if (n2.equals(numbers.get(j))) {
                    pos2 = j;

                    int thisDistance = Math.abs(pos1 - pos2);
                    if ((pos1 != -1) && (thisDistance < minDistance)) {
                        minDistance = thisDistance;
                    }
                }

                if (minDistance == 1) {
                    break;
                }
            }

            if (minDistance == Integer.MAX_VALUE) {
                System.out.println(-1);
            }
            else {
                System.out.println(minDistance);
            }
        }
*/
    }
}
