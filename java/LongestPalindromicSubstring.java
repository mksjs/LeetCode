

/*
 * LeetCode Questions
 * credit : LeetCode
 *
 * Given a string s, return the longest palindromic substring in s.
 *
 * Example : Input: s ="banana"
	  Output: "anana"
 * Solution: @Author Manish
 */


// checking palindrome Recursively
class Solution {
    public String longestPalindrome(String s) {
        int n= s.length();
        int maxLenLP = 0;
        int start =0;
        for(int i=0;i<n;i++) {
            for(int j=i;j<n;j++) {
                // checking possibility of palindrome from index i to j
                if(solvePalindrome(s,i, j) == 1) { // if this palidrome
                    if(maxLenLP < (j-i+1)) { // then check previous palindrom max length if less
                        maxLenLP= (j-i+1); // then update
                        start = i; // for printing palindrome keep track starting index of palidrome
                    }
                }
            }
        }
        return s.substring(start , start+maxLenLP);
    }

    private int solvePalindrome(String s, int l, int r) {
        if(l>=r) return 1; //  if l >= r then string is palidrome because we check full condition for palindrome

        if(s.charAt(l) == s.charAt(r)) { // palindrome condition check
            return solvePalindrome(s, l+1, r-1 ); // recursively contracting string to check respective char
        }

        return 0; // if if character of l and r do not match then definetly this is a palindrome
    }
}

//used memoization for checking palindrome 
class Solution {
    public String longestPalindrome(String s) {
        int n= s.length();
        int maxLenLP = 0;
        int start =0;
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++) {
            for(int j=i;j<n;j++) {
                // checking possibility of palindrome from index i to j
                if(solvePalindrome(s,i, j,dp) == 1) { // if this palidrome
                    if(maxLenLP < (j-i+1)) { // then check previous palindrom max length if less
                        maxLenLP= (j-i+1); // then update
                        start = i; // for printing palindrome keep track starting index of palidrome
                    }
                }
            }
        }
        return s.substring(start , start+maxLenLP);
    }

    private int solvePalindrome(String s, int l, int r, int[][] dp) {
        if(l>=r) return 1; //  if l >= r then string is palidrome because we check full condition for palindrome

        if(dp[l][r] ==1) return 1;
        if(s.charAt(l) == s.charAt(r)) { // palindrome condition check
            return dp[l][r] = solvePalindrome(s, l+1, r-1, dp ); // recursively contracting string to check respective char
        }

        return dp[l][r]=0; // if if character of l and r do not match then definetly this is a palindrome
    }
}
