//TC : O(N)
//SC :O(N)

//LC RUN :  N , not running for all the inputs.

class Solution {
    public int candy(int[] ratings) {
        
       int[] candies  = new int[ratings.length];
       Arrays.fill(candies, 1); 
       boolean cond2 = true; 
       for(int i=0;i<ratings.length;i++){
            if(i == 0 ){
                if((i+1 <= ratings.length -1) && ratings[i]>ratings[i+1])
                candies[i] += 1;
            }
            else if(ratings[i]>ratings[i-1] && cond2 ){
                candies[i] = candies[i]+1;
                cond2 = false;
            }else if(!cond2){
                cond2 = true;
            }
       }
       int sum=0;
       for(int i:candies)
       {
        System.out.println(i);
        sum = sum +i;
       }
        
       return sum; 
    }
}
