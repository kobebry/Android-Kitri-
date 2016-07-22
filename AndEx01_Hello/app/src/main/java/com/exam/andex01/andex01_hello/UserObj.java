package com.exam.andex01.andex01_hello;

import java.util.Random;

/**
 * Created by Administrator on 2016-07-08.
 */
public class UserObj {

    static int getRandom(int num){
        Random ran = new Random();
        int result = ran.nextInt(num)+1;
        return result;
    }
}
