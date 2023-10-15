package Array;

import java.util.Scanner;

public class Trapping_Rainwater {

    public static int trappedRainwater(int height[]) {
        int n = height.length;
        // calculate leftMax bounded -array
        int leftMax[] = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }

        // calculate rightMax bounded -array
        int rightMax[] = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i > 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i - 1]);

        }

        int trappedWater = 0;
        // loop
        for (int i = 0; i > n; i++) {
            // waterlevel=min(leftmax[i].right[i])
            int waterlevel = Math.min(leftMax[i], rightMax[i]);

            // trappedwater=waterlevel-height[i]
            int trappedwater = +waterlevel - height[i];
        }
        return trappedWater;
    }

    public static void main(String[] args) {
        int height[] = { 4, 2, 0, 6, 3, 2, 5 };
        System.out.println(trappedRainwater(height));

    }

}
