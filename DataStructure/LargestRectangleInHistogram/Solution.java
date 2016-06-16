import java.util.Stack;
import java.util.Arrays;

public class Solution {
    /**
    * @param height: A list of integer
    * @return: The area of largest rectangle in the histogram
    */
    public int _largestRectangleArea(int[] height) {
        int maxV = 0;
        for(int i =0; i< height.length; i++)
        {
            if(i+1 < height.length && height[i] <= height[i+1]) {
                // if not peak node, skip it
                continue;
            }
            int minV = height[i];
            for(int j =i; j>=0; j--)
            {
                minV = Math.min(minV, height[j]);
                int area = minV*(i-j+1);
                if(area > maxV)
                maxV = area;
            }
        }
        return maxV;
    }

    public int largestRectangleArea(int[] height) {
        Stack<Integer> stack = new Stack<Integer>();
        int maxArea = 0;
        int i = 0;
        int[] h = new int[height.length + 1];
        h = Arrays.copyOf(height, height.length + 1);
        while (i < h.length) {
            if (stack.isEmpty() || h[stack.peek()] <= h[i]) {
                stack.push(i);
                i++;
            } else {
                int j = stack.pop();
                int width = stack.isEmpty()? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, h[j] * width);
                System.out.print("Area: " + maxArea + "\n");
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] height = new int[] {5, 4, 3, 2};
        s.largestRectangleArea(height);
    }
}
