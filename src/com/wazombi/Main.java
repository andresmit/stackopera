package com.wazombi;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Main {


    public static void main(String[] args) {

        dirTraverse("test");
    }

    static void dirTraverse(String path){
        Stack<File> stack = new Stack<>();

        File[] files = new File(path).listFiles();

        for (File ff: files){
            stack.add(ff);
        }
        ArrayList<File> fs = new ArrayList(Arrays.asList(new File(path).listFiles()));

        while (!stack.empty()) {
            File f = stack.pop();
            if (f.isDirectory()){

                System.out.println("[" + f.getName() + "]");
                for (File fil:f.listFiles()){
                    stack.add(fil);
                }
            } else {
                if (f.length() < 500 * 1000) {
                    System.out.print(f.getName() + " ");
                    System.out.println(f.length());
                }
            }
        }
    }



}


