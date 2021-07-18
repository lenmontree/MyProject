package controller;


import java.lang.reflect.Constructor;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class HelloController {

    public static void main(String[] args){

        while (true) {

        }
    }

    public static boolean isPalindrome(String s) {
        if(null==s||"".equals(s.trim())){

            return false;
        }
        //回文串是排除特殊字符后左右对称，
        //提取原字符串中的字母或者数字组成新的字符数组
        String replaceAll = s.replaceAll("[^a-zA-Z0-9]", "").toUpperCase();
        //比较次数为s.length/2
        int length=replaceAll.length();
        for(int i=0;i<length/2;i++){
            //每次比较左右两边的字符是否相等，如果相等继续，否则退出则非回文串
            if(replaceAll.charAt(i)!= replaceAll.charAt(length-1-i)){
                return false;
            }
        }
        return true;
    }

    public String sayHello(){
        int[][] arr = new int[3][3];
        String string = Arrays.toString(arr);
        System.out.println(string);
        return "success";
    }
}
