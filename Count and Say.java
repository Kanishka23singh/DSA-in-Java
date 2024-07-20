/*
    YOUTUBE VIDEO ON THIS Qn : https://www.youtube.com/watch?v=5uJitfSM3vk
    Company Tags  : Facebook, Amazon, Microsoft, Zoho, Google (3 years ago)
    Leetcode Link : https://leetcode.com/problems/count-and-say/
    GfG Link      : https://practice.geeksforgeeks.org/problems/decode-the-pattern1138/1

Count and Say Algorithm

i   ------>                   = 1
i+1 ------> एक बार 1 लिखा है   = 11
i+2 ------> दो  बार 1 लिखा है   = 21
i+3 ------> एक बार 1 लिखा है & = 1211
            एक बार 1 लिखा है
*/
    
class Solution {
    public String countAndSay(int n) {
        if(n == 1){
            return "1";
        }
        String say = countAndSay(n-1);
        // Processing

        String res = "";
        for(int i = 0; i < say.length(); i++){
            int count = 1;

            while(i < say.length()-1 && say.charAt(i) == say.charAt(i+1)){
                count++;
                i++;
            }
            res += Integer.toString(count) + Character.toString(say.charAt(i));
        }
        return res;
    }
}
