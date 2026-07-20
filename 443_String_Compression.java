class Solution {
    public int compress(char[] chars) {

        int n = chars.length;
        int index = 0;

        for (int i = 0; i < n; ) {

            char cur = chars[i];
            int count = 0;

            while (i < n && cur == chars[i]) {
                count++;
                i++;
            }

            chars[index++] = cur;

            if (count > 1) {

                String s = String.valueOf(count);

                for (char ch : s.toCharArray()) {
                    chars[index++] = ch;
                }
            }
        }

        return index;
    }
}
