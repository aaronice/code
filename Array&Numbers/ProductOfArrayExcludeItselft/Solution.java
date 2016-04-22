public class Solution {
    /**
     * @param A: Given an integers array A
     * @return: A Long array B and B[i]= A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]
     */
    public ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {
        // write your code
        int length = A.size();
        ArrayList<Long> list = new ArrayList<Long>();
        long[] product = new long[length];

        if (length == 0) {
            return list;
        }

        product[length - 1] = A.get(length - 1);

        for (int i = length - 2; i >= 0; i--) {
            product[i] = product[i + 1] * A.get(i);
        }

        long temp = 1;
        for (int j = 0; j < length; j++) {
            if (j < length - 1) {
                list.add(product[j + 1] * temp);
            } else {
                list.add(temp);
            }

            temp = temp * A.get(j);
        }

        return list;
    }
}
