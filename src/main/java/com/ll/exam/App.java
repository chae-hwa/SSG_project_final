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

            Rq rq = new Rq(cmd);

            switch(rq.path){
                case "등록":
                    write(rq);
                    break;
                case "목록":
                    list(rq);
                    break;
                case "삭제":
                    remove(rq);
                    break;
                case "수정":
                    modify(rq);
                    break;
                case "종료":
                    break outer;
            }
        }
    }

    private void modify(Rq rq) {
        int paramId = rq.getIntParam("id",0);

        if(paramId == 0){
            System.out.println("id를 입력해주세요.");
            return;
        }

        WiseSaying foundwiseSaying = findById(paramId);

        if(foundwiseSaying == null){
            System.out.printf("%d번 명언은 존재하지 않습니다.\n",paramId);
            return;
        }
        System.out.printf("명언 (기존) :%s\n",foundwiseSaying.content);
        System.out.printf("명언 : ");
        foundwiseSaying.content = sc.nextLine().trim();
        System.out.printf("작가 (기존) :%s\n",foundwiseSaying.author);
        System.out.printf("작가 : ");
        foundwiseSaying.author = sc.nextLine().trim();

        System.out.printf("%d번 명언이 수정되었습니다.\n",paramId);

    }


    private void remove(Rq rq){
        int paramId = rq.getIntParam("id",0);
        if(paramId == 0){
            System.out.println("id를 입력해주세요");
            return;
        }

        WiseSaying foundwiseSaying = findById(paramId);
        // 전사 a전사 =  a원숭이();
        if(foundwiseSaying == null){
            System.out.printf("%d번 명언은 존재하지 않습니다.\n",paramId);
            return;
        }

        wiseSayings.remove(foundwiseSaying);
        System.out.printf("%d번 명언을 삭제합니다.\n",paramId);
    }

    private WiseSaying findById(int paramId) { // 명언찾기 메서드(찾) 집(주소)
        for(WiseSaying wiseSaying : wiseSayings){
            if(wiseSaying.id == paramId){
                return wiseSaying; // 명언 반환값
            }
        }return null;
    }

    private void list(Rq rq) {
        System.out.println("번호 / 명언 / 작가");
        System.out.println("----------------");

        for(int i = wiseSayings.size() - 1; i>=0; i--){
            WiseSaying wiseSaying_ = wiseSayings.get(i);
            System.out.printf("%d / %s / %s\n",wiseSaying_.id,wiseSaying_.content,wiseSaying_.author);
        }
    }

    private void write(Rq rq) {
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
