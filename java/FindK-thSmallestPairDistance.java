/*
 *The distance of a pair of integers a and b is defined as the absolute difference between a and b.

Given an integer array nums and an integer k, return the kth smallest distance among all the pairs nums[i] and nums[j] where 0 <= i < j < nums.length.

Example 1:

	Input: nums = [1,3,1], k = 1
	Output: 0
	Explanation: Here are all the pairs:
	(1,3) -> 2
	(1,1) -> 0
	(3,1) -> 2
	Then the 1st smallest distance pair is (1,1), and its distance is 0.

Example 2:

	Input: nums = [1,1,1], k = 2
	Output: 0

 *
 */



class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        int n=nums.length;

        int maxEle = Integer.MIN_VALUE;
        for(int num :  nums) {
            maxEle = Math.max(num, maxEle);
        }
        int[] distBuck =  new int[maxEle +1];
        
        for(int i=0;i<n;i++) {
            for(int j=i+1;j<n;j++) {
                int x = Math.abs(nums[i]-nums[j]);
                ++distBuck[x];
            }
        }

        for(int dist=0;dist <=maxEle;++dist) {
            k -= distBuck[dist];

            if(k<=0) return dist;
        }

        return -1;
        

    }
}
