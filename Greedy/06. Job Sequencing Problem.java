import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
   int id, profit, deadline;
   Job(int x, int y, int z) {
      this.id = x;
      this.deadline = y;
      this.profit = z;
   }
}

class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        // Your code here
        // 1. Sort on the basis of profit (Descending Order)
        Arrays.sort(arr, (a, b) -> Integer.compare(b.profit, a.profit));

        
        //2.Find maximum deadline
        int maxDeadline = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            if(arr[i].deadline > maxDeadline){
                maxDeadline = arr[i].deadline;
            }
        }
        
        // Create an array to keep track of free time slots (0 means free)
        int[] slots = new int[maxDeadline + 1];
        Arrays.fill(slots, -1); // Fill with -1 meaning free slots
        
        
        int countJobs = 0, jobProfit = 0;
        for(int i = 0; i < n; i++){
            for(int j = arr[i].deadline; j >= 1; j--){
                //  Free slot found 
                if(slots[j] == -1){
                    slots[j] = i;
                    countJobs++;
                    jobProfit += arr[i].profit;
                    break; // Move to the next job
                }
            }
            
        }
        return new int[]{countJobs, jobProfit};
    }
}

class Main {
   public static void main(String[] args) throws IOException {

      //size of array
      Job[] arr = new Job[4];
      arr[0] = new Job(1, 4, 20);
      arr[1] = new Job(2, 1, 10);
      arr[2] = new Job(3, 2, 40);
      arr[3] = new Job(4, 2, 30);

      solve ob = new solve();

      //function call
      int[] res = ob.JobScheduling(arr, 4);
      System.out.println(res[0] + " " + res[1]);

   }
}
