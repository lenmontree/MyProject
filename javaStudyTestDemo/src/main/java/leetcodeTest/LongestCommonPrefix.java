package leetcodeTest;

public class LongestCommonPrefix {

    public static void main(String[] args){
        String s = longestCommonPrefix(new String[]{"a"});
        System.out.println(s);
    }

    public static String longestCommonPrefix(String[] strs) {
        if (null == strs || strs.length < 1) {
            return "";
        }
        int length = strs.length;
        int i = 0;
        int index = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            //数组索引小于数组中字符串的长度
            if (index >= strs[i].length()) {
                return stringBuilder.toString();
            }

            char tempChar = strs[0].charAt(index);

            if (strs[i].charAt(index) != tempChar) {
                return stringBuilder.toString();
            }
            i++;
            if (i == length) {
                i = 0;
                stringBuilder.append(String.valueOf(tempChar));
                index++;
            }
        }
    }
}
