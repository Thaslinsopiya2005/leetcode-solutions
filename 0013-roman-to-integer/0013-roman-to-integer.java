class Solution {
    public int romanToInt(String s) {
        int[]map = new int[26];
        map['I'-'A'] = 1;
        map['V'-'A'] = 5;
        map['X'-'A'] = 10;
        map['L'-'A'] = 50;
        map['C'-'A'] = 100;
        map['D'-'A'] = 500;
        map['M'-'A'] = 1000;

        int res = 0;

        for(int i=0;i<s.length();i++){
            if(i+1 < s.length()){
                if(map[s.charAt(i)-'A'] >= map[s.charAt(i+1)-'A']){
                    res+=map[s.charAt(i)-'A'];
                } else {
                    res+=(map[s.charAt(i+1)-'A'] - map[s.charAt(i)-'A']);
                    i++;
                }
            } else {
                res+=map[s.charAt(i)-'A'];
            }
        }

        return res;
    }
}