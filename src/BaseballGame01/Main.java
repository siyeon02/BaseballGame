package BaseballGame01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        BaseballGame baseballGame = new BaseballGame();
        BaseballGameDisplay baseballGameDisplay = new BaseballGameDisplay();
        String text = "";
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("환영합니다! 원하시는 번호를 입력해주세요");
            System.out.println("0. 자리수 설정 1. 게임 시작하기 2. 게임 기록보기 3. 종료하기");
            text = sc.next();
            if(text.equals("0")){
                System.out.println("설정하고자 하는 자리수를 입력하세요");
                baseballGame.makeLevel();
                baseballGame.start();
                baseballGame.countGame();
            } else if(text.equals("1")){
                baseballGame.start();
                baseballGame.countGame();
            } else if (text.equals("2")) {
                System.out.println("게임 기록");
                baseballGameDisplay.displayTry();
            } else if (text.equals("3")) {
                System.out.println("< 숫자 야구 게임을 종료합니다 >");
                baseballGameDisplay.clearTrial();
                baseballGameDisplay.clearGame();
                break;
            }
            else{
                System.out.println("올바른 숫자를 입력해주세요!");
            }
        }

    }
}