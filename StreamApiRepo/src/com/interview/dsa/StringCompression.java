package com.interview.dsa;

class StringCompression {
    public int compress(char[] chars) {
        int write = 0;
        int read = 0;
        
        while (read < chars.length) {
            char current = chars[read];
            int count = 0;
            
            // Count consecutive occurrences
            while (read < chars.length && chars[read] == current) {
                read++;
                count++;
            }
            
            // Write the character
            chars[write++] = current;
            
            // Write count digits if count > 1
            if (count > 1) {
                for (char c : String.valueOf(count).toCharArray()) {
                    chars[write++] = c;
                }
            }
        }
        
        return write;
    }
}