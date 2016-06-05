// HashMap Approach
public class Solution {
    /**
     * @param nums1 an integer array
     * @param nums2 an integer array
     * @return an integer array
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Boolean> map1 = new HashMap<Integer, Boolean>();
        HashMap<Integer, Boolean> intersectMap = new HashMap<Integer, Boolean>();
        for (int i = 0; i < nums1.length; i++) {
            if (!map1.containsKey(nums1[i])) {
                map1.put(nums1[i], true);
            }
        }
        for (int j = 0; j < nums2.length; j++) {
            if (map1.containsKey(nums2[j]) && !intersectMap.containsKey(nums2[j])) {
                intersectMap.put(nums2[j], true);
            }
        }
        int[] result = new int[intersectMap.size()];
        int i = 0;
        for (Integer e : intersectMap.keySet()) {
            result[i] = e;
            i++;
        }
        return result;
    }
}

// Sort & Merge
public class Solution {
    /**
     * @param nums1 an integer array
     * @param nums2 an integer array
     * @return an integer array
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0, j = 0;
        int[] temp = new int[nums1.length];
        int index = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                if (index == 0 || temp[index - 1] != nums1[i]) {
                    temp[index++] = nums1[i];
                }
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        int[] result = new int[index];
        for (int k = 0; k < index; k++) {
            result[k] = temp[k];
        }

        return result;
    }
}
