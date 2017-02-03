package soujava;

/*
A company has 'n' spots for people to park their bicycles.
You're responsible for locking up the arriving bicycles using padlocks.

You have, at your disposal, one box full of padlocks and another box full of keys.
Each padlock has a tag containing its numeric ID and its unique strength.
Each key has a tag containing the numeric ID of the padlock it opens.

You want to select the 'n' strongest padlock for which you also have a key.

The first line of the input (stdin) will contain the number padlocks ('p'), keys ('k') and spots ('n'), separated by space.
The following 'p' lines will contain the numeric ID of the padlock and its strength, separated by space.
The following 'k' lines will contain the numeric ID of the padlock each key can open.

You need to print (stdout) the IDs of the 'n' strongest padlocks that also have a matching key, one per line.
If there aren't at least 'n', print "Not enough padlocks with keys".

Even though you're given an initial code, you can extend/modify it as much as you need (or even ignore it completely) to solve the problem.


Example:
========
Input:
7 5 3
4 11
2 15
5 16
3 40
1 20
9 60
6 22
2
6
7
3
4

Output:
3
6
2
*/
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class StrongestPadlock {
    static class Padlock implements Comparable<Padlock> {

        @Override
        public int compareTo(Padlock padlock) {
            return 0;
        }
    }

    static class Key {
        final private int id;

        public Key(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }
    }

    private static List<Padlock> strongestPadlocks(final int n, final List<Padlock> padlocks, final List<Key> keys) {
        return null;
    }

    private static void addSorted(LinkedList<Padlock> sortedPadlocks, Padlock padlock) {

    }

    private static int loadPadlocksAndKeys(final Scanner in, final List<Padlock> padlocks, final List<Key> keys) {
    	return 0;
    }

    public static void main(String args[]) throws FileNotFoundException {
       // TODO: Implementar algoritmo.
    }
}
