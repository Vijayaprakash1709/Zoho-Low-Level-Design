import java.util.*;
public class ClimbingStairs {
    //recursion using dp
    public static int climbStairs(int n) {
        int[] dp=new int[n+1];
        return climbStairs(n,dp);
    }
    public static int climbStairs(int n,int[] dp) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        dp[n] = climbStairs(n - 1, dp) + climbStairs(n - 2, dp);
        return dp[n];
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(climbStairs(n));
    }
}
