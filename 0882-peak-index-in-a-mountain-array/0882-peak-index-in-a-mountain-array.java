class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int n=arr.length;
        int low=1,high=n-2, mid=-1;
        while(low<=high){
            mid=low+(high-low)/2;
            if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1]) return mid;
            else if(arr[mid]<arr[mid-1]){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return mid;
    }
}