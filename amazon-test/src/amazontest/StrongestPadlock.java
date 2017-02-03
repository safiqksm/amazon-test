package amazontest;

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
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class StrongestPadlock {
    static class Padlock implements Comparable<Padlock> {
        final private int id;
        final private int strength;

        public Padlock(int id, int strength) {
            this.id = id;
            this.strength = strength;
        }

        public int getId() {
            return id;
        }

        public int getStrength() {
            return strength;
        }

        @Override
        public int compareTo(Padlock padlock) {
            return this.strength - padlock.getStrength();
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
        LinkedList<Padlock> strongestPadlocks = new LinkedList<Padlock>();

        Set<Integer> existingKeys = new HashSet<Integer>();
        for (Key key : keys) {
            existingKeys.add(key.getId());
        }

        Queue<Padlock> heap = new PriorityQueue<Padlock>();

        for (Padlock padlock : padlocks) {
            if (existingKeys.contains(padlock.getId())) {
                if (heap.size() < n) {
                    heap.add(padlock);
                } else {
                    Padlock minPadlock = heap.peek();
                    if (padlock.getStrength() > minPadlock.getStrength()) {
                        heap.poll();
                        heap.add(padlock);
                    }
                }
            }
        }

        while(!heap.isEmpty()) {
            strongestPadlocks.addFirst(heap.poll());
        }

        for (Key key : keys) {
            existingKeys.add(key.getId());
        }

        LinkedList<Padlock> sortedPadlocks = new LinkedList<Padlock>();

        for (Padlock padlock : padlocks) {
            if (existingKeys.contains(padlock.getId())) {
                if (sortedPadlocks.size() < n) {
                    addSorted(sortedPadlocks, padlock);
                } else {
                    Padlock minPadlock = sortedPadlocks.get(0);
                    if (padlock.getStrength() > minPadlock.getStrength()) {
                        sortedPadlocks.removeFirst();
                        addSorted(sortedPadlocks, padlock);
                    }
                }
            }
        }

        final int m = sortedPadlocks.size();
        for(int i=0; i<m; i++) {
            Padlock padlock = sortedPadlocks.removeFirst();
            strongestPadlocks.addFirst(padlock);
        }
        for (Key key : keys) {
            existingKeys.add(key.getId());
        }

        Collections.sort(padlocks, Collections.reverseOrder());
        for (Padlock padlock : padlocks) {
            if (existingKeys.contains(padlock.getId())) {
                strongestPadlocks.add(padlock);

                if (strongestPadlocks.size() >= n) {
                    return strongestPadlocks;
                }
            }
        }

        Collections.sort(padlocks, Collections.reverseOrder());
        for (Padlock padlock : padlocks) {
            for (Key key : keys) {
                if (padlock.getId() == key.getId()) {
                    strongestPadlocks.add(padlock);

                    if (strongestPadlocks.size() >= n) {
                        return strongestPadlocks;
                    }

                    break;
                }
            }
        }

        return strongestPadlocks;
    }

    private static void addSorted(LinkedList<Padlock> sortedPadlocks, Padlock padlock) {
        ListIterator<Padlock> it = sortedPadlocks.listIterator();
        while(it.hasNext()) {
            Padlock curPadlock = it.next();
            if (curPadlock.getStrength() > padlock.getStrength()) {
                it.previous();
                it.add(padlock);
                return;
            }
        }

        it.add(padlock);
    }

    private static int loadPadlocksAndKeys(final Scanner in, final List<Padlock> padlocks, final List<Key> keys) {
        final int p = in.nextInt();
        final int k = in.nextInt();
        final int n = in.nextInt();

        // load padlocks
        for(int i = 0; i < p; i++) {
            int padlockId = in.nextInt();
            int padlockStrength = in.nextInt();
            Padlock padlock = new Padlock(padlockId, padlockStrength);
            padlocks.add(padlock);
        }

        // load keys
        for(int i = 0; i < k; i++) {
            int keyId = in.nextInt();
            Key key = new Key(keyId);
            keys.add(key);
        }

        return n;
    }

    public static void main(String args[]) throws FileNotFoundException {
        //Scanner in = new Scanner(new FileInputStream("/home/local/ANT/lestrozi/IdeaProjects/untitled1/src/sampleInput3"));
        Scanner in = new Scanner(System.in);

        final List<Padlock> padlocks = new ArrayList<Padlock>();
        final List<Key> keys = new ArrayList<Key>();

        final int n = loadPadlocksAndKeys(in, padlocks, keys);

        final List<Padlock> strongestPadlocks = strongestPadlocks(n, padlocks, keys);

        if (strongestPadlocks.size() < n) {
            System.out.println("Not enough padlocks with keys");
        } else {
            for (Padlock padlock : strongestPadlocks) {
                System.out.println(padlock.getId());
            }
        }
    }
}
