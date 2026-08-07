class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int med = nums[nums.length / 2], minMoves = 0;
        for (int n : nums){
            minMoves += Math.abs(n - med);
        }
        return minMoves;
    }
}