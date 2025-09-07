class Solution {
    public int[] sumZero(int n) {
        int[] fin= new int[n];
        if(n==1){
            fin[0]=0;
            return fin;}

        for(int i=0;i<n;i++){
            if(i<n/2){
                fin[i]=i+1;
            }
            else{
                if(n%2!=0){
                    fin[i]=i-n+1;
                }
                else{
                    fin[i]=i-n;
                }
            }
        }
        return fin;
    }
}