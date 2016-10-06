package com.wawawa;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class TraverseDirStack {


    public static void main(String[] args) {

        dirTraverse("test");
    }

    static void dirTraverse(String path){
        Stack<File> stack = new Stack<>();
        Stack<Integer> taane = new Stack<>();


        File[] files = new File(path).listFiles();

        for (File ff: files){
            taane.add(0);
            stack.add(ff);
        }
        ArrayList<File> fs = new ArrayList(Arrays.asList(new File(path).listFiles()));

        while (!stack.empty()) {
            File f = stack.pop();
            int taanePraegu = taane.pop();

            if (f.isDirectory()){

                System.out.println( ehitaTaane(taanePraegu) + "[" + f.getName() + "]");

                int taaneUus = taanePraegu + 1;

                for (File fil:f.listFiles()){
                    taane.add(taaneUus);
                    stack.add(fil);
                }

            } else {
                if (f.length() < 500 * 1000) {
                    System.out.print(ehitaTaane(taanePraegu)+ f.getName() + " ");
                    System.out.println(f.length());
                }
            }
        }
    }

    static String ehitaTaane(int n){
        StringBuilder s = new StringBuilder("");
        for (int i = 0; i < n; i++) {
            s.append("   ");
        }
        return new String(s);
    }



}


