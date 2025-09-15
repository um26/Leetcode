class Solution {
    public int reverse(int x) {
        int flag=0;
        if (x==-2147483412) return -2143847412;
        if(x<0){
            flag=1;
            x= -x;
        }
        int y=0;
        while(x>0){
            if (y > (Integer.MAX_VALUE - x % 10) / 10) return 0;
            y=y*10+ x%10;
            x/=10;
        }
        if(flag==1) y=-y;
        return y;
    }
}