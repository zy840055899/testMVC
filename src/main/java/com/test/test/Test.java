package com.test.test;

import java.io.File;

/**
 * Created by zhengying on 15/11/27.
 */
public class Test {
    public static void main(String[] args) throws Exception {
        File directory = new File("");//设定为当前文件夹
        System.out.println(directory.getCanonicalPath());//获取标准的路径
        System.out.println(directory.getAbsolutePath());//获取绝对路径
    }
}
