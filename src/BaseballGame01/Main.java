package BaseballGame01;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

       BaseballGame baseballGame = new BaseballGame();
       while(true){
           System.out.println("종료는 exit 입력/종료 원치 않으면 아무키나 입력: ");
           Scanner sc = new Scanner(System.in);
           String text = sc.next();
           if (text.equals("exit")) {
               break;
           }

           baseballGame.start();
       }
    }
}