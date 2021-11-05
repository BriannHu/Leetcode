// MEDIUM - https://leetcode.com/problems/fruit-into-baskets/

public class FruitIntoBaskets {

    public int totalFruit(int[] fruits) {
        int lastFruit = -1;
        int secondLastFruit = -1;
        int lastFruitCount = 0;
        int currMax = 0;
        int max = 0;

        for (int fruit: fruits) {
            if (fruit == lastFruit || fruit == secondLastFruit) {
                currMax++;
            } else {
                currMax = lastFruitCount + 1;
            }

            if (fruit == lastFruit) {
                lastFruitCount++;
            } else {
                lastFruitCount = 1;
            }

            if (fruit != lastFruit) {
                secondLastFruit = lastFruit;
                lastFruit = fruit;
            }

            max = Math.max(max, currMax);
        }

        return max;
    }

}
