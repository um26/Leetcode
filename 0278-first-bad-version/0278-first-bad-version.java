/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int a=0,b=n-1, temp=-1;
        while(a<=b){
            int mid=a+(b-a)/2;
            if(isBadVersion(mid+1)){
                b=mid-1;
                temp=mid+1;
            }
            else{
                a=mid+1;
            }

        } return temp;
    }
}