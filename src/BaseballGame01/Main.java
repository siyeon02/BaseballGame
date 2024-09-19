package BaseballGame01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        BaseballGame baseballGame = new BaseballGame();
        BaseballGameDisplay baseballGameDisplay = new BaseballGameDisplay();
        String text = "";
        Scanner sc = new Scanner(System.in);

        /*while(!Objects.equals(text, "exit")){
            System.out.println("종료는 exit 입력/종료 원치 않으면 아무키나 입력: ");
            Scanner sc = new Scanner(System.in);
            text = sc.next();
            if (text.equals("exit")) {
                break;
            }
            baseballGame.start();
        }*/

        while(true){
            System.out.println("1. 게임 시작하기 2. 게임 기록보기 3. 종료하기");
            text = sc.next();
            if(text.equals("1")){
                baseballGame.start();
                baseballGame.countGame();
            } else if (text.equals("2")) {
                System.out.println("게임 기록");
                baseballGameDisplay.displayTry(BaseballGame.count,BaseballGame.trial);
                //baseballGameDisplay.clearTrial();
            } else if (text.equals("3")) {
                System.out.println("< 숫자 야구 게임을 종료합니다 >");
                break;
            }
            else{
                System.out.println("올바른 숫자를 입력해주세요!");
            }
        }

    }
}