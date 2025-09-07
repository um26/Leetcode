class Solution {
    public int[] sumZero(int n) {
        ArrayList<Integer> ans= new ArrayList<>();
        if (n==1){
            ans.add(0);
            int[] fin=ans.stream().mapToInt(i -> i).toArray();
        return fin;}
        else{
            for(int i=1;i<=n/2;i++){
                ans.add(i);
                ans.add(-i);
            }
        }
        if (n%2 !=0 ) ans.add(0);
        int[] fin=ans.stream().mapToInt(i -> i).toArray();
        return fin;
    }
}