package com.ll.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    Scanner sc;
    int wiseSayingLastId;
    List<WiseSaying> wiseSayings;

    App(){
    sc = new Scanner(System.in);
    wiseSayingLastId = 0;
    wiseSayings = new ArrayList<>();

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
                case "목록":
                    list();
                    break;
                case "종료":
                    break outer;
            }
        }
    }

    private void list() {
        System.out.println("번호 / 명언 / 작가");
        System.out.println("----------------");

        for(int i = wiseSayings.size() - 1; i>=0; i--){
            WiseSaying wiseSaying_ = wiseSayings.get(i);
            System.out.printf("%d / %s / %s\n",wiseSaying_.id,wiseSaying_.content,wiseSaying_.author);
        }
    }

    private void write() {
        System.out.printf("명언 : ");
        String content = sc.nextLine().trim();
        System.out.printf("작가 : ");
        String author = sc.nextLine().trim();

        int id = ++wiseSayingLastId;
        WiseSaying wiseSaying = new WiseSaying(id, content, author);
        wiseSayings.add(wiseSaying);

        System.out.printf("%d번 명언이 등록되었습니다.\n",id);
    }
}
