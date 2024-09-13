package BaseballGame01;

import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;


public class BaseballGame {
    public String answerNum;
    private boolean flag;
    public static int sCount;
    public static int bCount;

    public BaseballGame() {

    }

    public void start() {

        System.out.println("<게임을 시작합니다>");
        Random random = new Random();
        int ball = 0;
        String ranBall = "";
        int letter = 3;
        String answerBall = "";

        for (int i = 0; i < letter; i++) {//랜덤으로 정답 3자리 설정
            ball = random.nextInt(9) + 1;//0~9사이의 숫자 중 랜덤
            ranBall = Integer.toString(ball);//정수를 문자열로 바꿈
            answerBall = answerBall + ranBall;//정답 저장

        }

        System.out.println(answerBall);
        System.out.println("정답을 입력해주세요 : ");
        Scanner sc = new Scanner(System.in);
        String answerNum = sc.next();
        setAnswerNum(answerNum);

        String first = answerNum.substring(0, 1);
        String second = answerNum.substring(1, 2);
        String third = answerNum.substring(2, 3);

        if(first.equals(answerBall.substring(0,1))){
            BaseballGameDisplay.displayStrike();
        }

        if (answerNum.equals(answerBall)) {
            System.out.println("정답입니다");
        }else {
            System.out.println("오답입니다");
        }

    }

    public void setAnswerNum(String answerNum) {
        this.answerNum = answerNum;
    }

    public void getAnswerNum(String answerNum) {
        this.answerNum = answerNum;
    }

    public boolean validInput() {
        boolean flag = false;
        if (answerNum.length() != 3) {
            return flag;
        } else if (!Pattern.matches("-?\\d+", answerNum)) {
            return flag;
        } else {
            return !flag;
        }
    }

    public int countStrike() {
        int sCount = 0;
        ++sCount;
        return sCount;
    }

    public int countBall() {
        int bCount = 0;
        ++bCount;
        return bCount;
    }
}
