package com.ll.exam;

import java.util.Scanner;

public class App {
    Scanner sc;



    App(){
    sc = new Scanner(System.in);


    }
    public void run() {
        System.out.println("== SSG 명언 ==");

        outer:
        while(true){
            System.out.printf("명령) ");
            String cmd = sc.nextLine().trim();

            switch(cmd){
                case "등록":
                    write();
                    break;
                case "종료":
                    break outer;
            }
        }
    }

    private void write() {
        System.out.printf("명언 : ");
        String content = sc.nextLine().trim();
        System.out.printf("작가 : ");
        String author = sc.nextLine().trim();

    }
}
