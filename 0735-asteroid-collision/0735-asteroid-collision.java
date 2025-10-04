class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> pos= new Stack<>();
        for(int i=0;i<asteroids.length;i++){
            if(asteroids[i]>0) pos.push(asteroids[i]);
            else{
                while(!pos.isEmpty() && pos.peek()>0 && pos.peek()<-asteroids[i]){
                    pos.pop();
                }
                if(pos.isEmpty() || pos.peek()<0){
                    pos.push(asteroids[i]);
                }
                if(pos.peek()==-asteroids[i]) pos.pop();
            }
        }
        int[] a= new int[pos.size()];
        int i=pos.size()-1;
        while(!pos.isEmpty()){
            a[i--]=pos.pop();
        }
        return a;
    }
}