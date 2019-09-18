//TC : O(N) -- we are looping throught the no of tasks given.
//SC : O(1) -- Constant Space.

// idea  : put the high frequest task first and fill in the next available tasks in the gaps.
// so we find the idle gaps of processing time. by the below formulas
// partCount = max -1;
// emptySlot =  partCount * (n-(maxCountTask-1));
// availableSlots = tasks.length - (maxCountTask*max);
// idleSlot = Math.max(0,emptySlot-availableSlots);
        

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] counter = new int[26];
        int max = 0;
        int maxCountTask =0;
        
        for(char c: tasks){
            counter[c-'A']++;
            if(max == counter[c-'A'])
            {
                maxCountTask++;
            }
            else if(max<counter[c-'A']){
                max = counter[c-'A'];
                maxCountTask = 1;
            }
        }
        
        int partCount = max -1;
        int emptySlot =  partCount * (n-(maxCountTask-1));
        int availableSlots = tasks.length - (maxCountTask*max);
        int idleSlot = Math.max(0,emptySlot-availableSlots);
        
        return tasks.length+idleSlot;
    }
}
