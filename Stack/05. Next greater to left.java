// Just one change loop from left to right i.e 0 to arr.length-1
class Solution
{    
  public static int[] solve(int arr[])
    {
        int nge[] = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        // -a+ --> pop ans push
        for(int i = 0; i <= arr.length-1; i--){
            while(st.size() > 0 && arr[i] >= st.peek()){
                st.pop();
            }
            nge[i] = (st.size()==0)?-1:st.peek();
            st.push(arr[i]);
        }
        return nge;
    }
}
