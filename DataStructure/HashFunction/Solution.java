class Solution {
    /**
     * @param key: A String you should hash
     * @param HASH_SIZE: An integer
     * @return an integer
     */
    public int hashCode(char[] key,int HASH_SIZE) {
        int N = key.length;
        long sum = 0;
        for (int i = 0; i < N; i++) {
            sum = (sum * 33 + (int) (key[i])) % HASH_SIZE;
        }

        return (int) (sum);
    }
};
