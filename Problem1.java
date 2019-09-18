//TC : O(N)
//SC : O(N) -- using the candies array.

// IDEA : first fill the 1 candies for every person. 
// Next,  Give the candy if previous person have more rating.
// next,  Give the Max( prev cand, new candy count) , rating is more than next person rating.


class Solution {
    public int candy(int[] ratings) {
        int[] candy = new int[ratings.length];
        Arrays.fill(candy,1);
        
        for(int i=1;i<ratings.length;i++){
            if(ratings[i]>ratings[i-1]) candy[i] = candy[i-1]+1;
        }
        for(int i=ratings.length-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]) 
                candy[i] = Math.max(candy[i],candy[i+1]+1);
        }
        int sum =0;
        for(int i: candy) sum += i;
        
        return sum;
    }
}
