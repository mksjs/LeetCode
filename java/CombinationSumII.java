/*
 *
 *Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.

Example 

	Input: candidates = [10,1,2,7,6,1,5], target = 8
	Output:
	[
	[1,1,6],
	[1,2,5],
	[1,7],
	[2,6]
	]
 *
 */
 
 
 
 
 class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum2Utility(0, candidates, target, ans, ds);
        return ans;
    }

    public void combinationSum2Utility(int ind, int[] arr, int target, List<List<Integer>> ans, List<Integer> ds) {

            if(target == 0 ){
                ans.add(new ArrayList<>(ds));
                return;
            }



        // All possibilities of pick condition
        for(int i = ind ; i< arr.length; i++) {
            if(i > ind && arr[i] == arr[i-1]) continue;
            if(arr[i]  > target ) break;

            ds.add(arr[i]);
            combinationSum2Utility(i+1, arr, target - arr[i], ans, ds);
            ds.remove(ds.size() - 1);
        }


    }
}
