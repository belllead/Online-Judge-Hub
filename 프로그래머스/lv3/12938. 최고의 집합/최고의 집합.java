import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        
        int mid = s / n;
        
        if (mid == 0) return new int[] {-1};
        
        for (int i=0; i<n; i++) {
            answer[i] = mid;
        }
        
        if (s % n == 0) return answer;
        
        int rem = s % n;
        
        for (int i=n-1; i>=0; i--) {
            answer[i]++;
            rem--;
            if (rem == 0) break;
        }
        
        return answer;
    }
}