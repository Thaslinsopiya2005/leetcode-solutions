class Solution {
    private int[] original;
    private Random rand = new Random();

    public Solution(int[] nums) {
        original = nums.clone();
    }

    public int[] reset() {
        return original.clone();
    }

    public int[] shuffle() {
        int[] arr = original.clone();
        for(int i = 0; i < arr.length; i++){
            int j = rand.nextInt(arr.length);
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        return arr;
    }
}