package cn.hyperchain.ink.core.util;


import java.util.Random;

public class NumUtil {


    public static String randomCode(Integer codeLength) {
        StringBuilder str = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < codeLength; i++) {
            str.append(random.nextInt(10));
        }
        return str.toString();
    }


    public static String gen6Codes() {
        char[] arr = {48,49,50,51,52,53,54,55,56,57,//从0到9的数字
                65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,//从A到Z的数字
                97,98,99,100,101,102,103,104,105,106,107,108,109,110,111,112,113,114,115,116,117,118,119,120,121,122//从a到z的数字
        };
        int i=1;
        Random r = new Random();
        StringBuffer string = new StringBuffer();
        while (i++ <= 6){
            char msg = arr[r.nextInt(arr.length)];
            String str = String.valueOf(msg);
            string.append(str);
        }
        return string.toString();
    }
}
