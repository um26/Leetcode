/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int low=0, high=n-1, data=-1;
        while(high>=low){
            int mid=low+(high-low)/2;
            if(isBadVersion(mid+1)){
                high=mid-1;
                data=mid;
            }
            else{
                low=mid+1;
            }
        }
        return data+1;
    }
}