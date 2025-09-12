class Solution {
    public boolean canWinNim(int n) {
        int a=(n-1)/3;
        if(a==0) return true;
        else if(n%4==0) return false;
        else return true;
    }
}