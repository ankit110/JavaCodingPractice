package com.interview.dsa;

class CheckInclusion {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        
        int[] s1Freq = new int[26];
        int[] windowFreq = new int[26];
        
        // Step 1: Fill s1 frequency
        for (char c : s1.toCharArray()) {
            s1Freq[c - 'a']++;
        }
        
        int windowSize = s1.length();
        
        // Step 2: Start sliding window over s2
        for (int i = 0; i < s2.length(); i++) {
            // Add current char to window
            windowFreq[s2.charAt(i) - 'a']++;
            
            // Remove leftmost char if window size exceeded
            if (i >= windowSize) {
                windowFreq[s2.charAt(i - windowSize) - 'a']--;
            }
            
            // Step 3: Compare both frequency arrays
            if (matches(s1Freq, windowFreq)) {
                return true;
            }
        }
        
        return false;
    }

    private boolean matches(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
}