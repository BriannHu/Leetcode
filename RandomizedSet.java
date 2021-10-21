// MEDIUM - https://leetcode.com/problems/insert-delete-getrandom-o1/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class RandomizedSet {
    HashMap<Integer, Integer> store;
    ArrayList<Integer> list;
    Random rand = new Random();

    public RandomizedSet() {
        store = new HashMap<>();
        list = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (store.containsKey(val)) {
            return false;
        }
        store.put(val, list.size()); // store current index as value
        list.add(list.size(), val);
        return true;
    }

    public boolean remove(int val) {
        if (!store.containsKey(val)) {
            return false;
        }
        int lastElement = list.get(list.size()-1);
        int idx = store.get(val);

        // relocate last element in list and map
        list.set(idx, lastElement);
        store.put(lastElement, idx);

        // delete last element
        list.remove(list.size()-1);
        store.remove(val);
        return true;
    }

    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}