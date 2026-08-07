class Solution {
    public int findMinMoves(int[] machines) {
      int sum = 0;
      for(int i : machines){
        sum += i;
      }
      int steps = 0;
      int n = machines.length;
      int avg = sum / n;
      int need = 0;
      for(int d : machines){
        d -= avg;
        need += d;
        steps = Math.max(steps, Math.max(Math.abs(need), d));
      }
      if(sum % n != 0){
        steps = -1;
      }
      return steps;
    }
}