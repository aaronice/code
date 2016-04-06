public class Solution {
    /*
     * @param numbers : An array of Integer
     * @param target : target = numbers[index1] + numbers[index2]
     * @return : [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
        // write your code here
        Map<Integer, Integer> hashmap = new HashMap<Integer, Integer>();

        int[] twoIndices = new int[2];

        for (int i = 0; i < numbers.length; i++) {
            if (hashmap.containsKey(target - numbers[i])) {
                int index = hashmap.get(target - numbers[i]);
                // the index will always be smaller than i
                twoIndices[0] = index + 1;
                twoIndices[1] = i + 1;
            }
            hashmap.put(numbers[i], i);

        }
        return twoIndices;
    }
}
