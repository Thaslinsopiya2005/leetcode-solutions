class Solution {
    public boolean isNumber(String s) 
    {
        int n=s.length(), count=0,digit=0,dot=0,exp=0;
        int j=0;
        for(int i=0;i<n;i++)
        {
            if(i<n-1)
            { 
                j=i+1;
            }

            char c=s.charAt(i);
            char d = (i < n-1) ? s.charAt(i+1) : ' ';

            if(c=='-'&&d=='-') 
            {
                return false;
            }

            else if(c>='0'&&c<='9') 
            {
                // if(exp==1) return false;
                count++;
                digit++;
            }

            else if(c=='.'&&n>1) 
            {
                if(exp==1) return false;
                if(i>0 && (s.charAt(i-1)=='e' || s.charAt(i-1)=='E'))
                    return false;
                count++;
                dot++;
                if(dot>1) return false;
            }

            else if(i>0&&(c=='E'||c=='e'))
            { 
                if(exp==1) return false;
                if(digit==0 || i==n-1) return false;
                exp=1;
                count++;
            }

            else if(c=='E'&&d=='+') 
            {
                count++;
                if(i!=0 && s.charAt(i-1)<='9' && s.charAt(i-1)>='0')
                    return false;
            }

            else if(c=='+' || c=='-')
            {
                if(i!=0 && s.charAt(i-1)!='e' && s.charAt(i-1)!='E')
                    return false;
                if(i==n-1)
                    return false;
                if(i>0 && (s.charAt(i-1)=='e' || s.charAt(i-1)=='E'))    {
                        if(!(s.charAt(i+1)>='0' && s.charAt(i+1)<='9'))
                            return false;
                    }
                count++;
            }

            else return false;
        }
        if(count==n && digit>0)return true;
        else return false;
    }
}