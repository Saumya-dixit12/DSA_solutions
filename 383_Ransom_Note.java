class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {

        int[] freq = new int[26];

        // Count characters in magazine
        for (char ch : magazine.toCharArray()) {
            freq[ch - 'a']++;
        }

        // Use characters for ransomNote
        for (char ch : ransomNote.toCharArray()) {
            freq[ch - 'a']--;

            if (freq[ch - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }
}
