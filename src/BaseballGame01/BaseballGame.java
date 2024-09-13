package BaseballGame01;

import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;


public class BaseballGame {
    private String answerBall = "";
    private String answerNum;
    public boolean flag;
    public static int sCount = 0;
    public static int bCount = 0;

    public BaseballGame() {
        this.answerNum = null;
        this.flag = true;
    }

    public void start() {

        System.out.println("<게임을 시작합니다>");

        BaseballGameDisplay display = new BaseballGameDisplay();
        Random random = new Random();
        int ball = 0;
        String ranBall = "";
        int letter = 3;

        for (int i = 0; i < letter; i++) {//랜덤으로 정답 3자리 설정
            ball = random.nextInt(9) + 1;//0~9사이의 숫자 중 랜덤
            ranBall = Integer.toString(ball);//정수를 문자열로 바꿈
            answerBall = answerBall + ranBall;//정답 저장
            setAnswerBall(answerBall);//정답 저장
        }

        System.out.println(answerBall);
        System.out.println("정답을 입력해주세요 : ");
        Scanner sc = new Scanner(System.in);
        String answerNum = sc.next();
        setAnswerNum(answerNum);

        String first = answerNum.substring(0, 1);
        String second = answerNum.substring(1, 2);
        String third = answerNum.substring(2, 3);

        String firstAnswer = (answerBall.substring(0, 1));
        String secondAnswer = (answerBall.substring(1, 2));
        String thirdAnswer = (answerBall.substring(2, 3));

        for (int i = 0; i < answerNum.length(); i++) {
            if (first.equals(firstAnswer)) {
                countStrike();
            } else if (second.equals(secondAnswer)) {
                countStrike();
            } else if (third.equals(thirdAnswer)) {
                countStrike();
            } else if (first.equals(secondAnswer) || first.equals(thirdAnswer)) {
                countBall();
            } else if (second.equals(firstAnswer) || second.equals(thirdAnswer)) {
                countBall();
            } else if (third.equals(firstAnswer) || third.equals(secondAnswer)) {
                countBall();
            }
        }

        display.displayStrikeBall(sCount, bCount);

        if (sCount == 3) {
            System.out.println("정답입니다");
            answerBall = "";
            display.clearStrikeBall();
        } else {
            System.out.println("오답입니다");
            answerBall = "";
            display.clearStrikeBall();
        }


        /*if (answerNum.equals(answerBall)) {
            System.out.println("정답입니다");
            answerBall = "";
            display.clearStrikeBall();
        } else {
            System.out.println("오답입니다");
            answerBall = "";
            display.clearStrikeBall();
        }*/

    }

    public void setAnswerBall(String answerBall) {//정답 저장
        this.answerBall = answerBall;
    }

    public void setAnswerNum(String answerNum) {//대답 저장
        this.answerNum = answerNum;
    }

    public boolean validInput() {//모두 숫자이고 중복되지 않는 맞는 인풋인지 확인
        boolean flag = false;
        if (answerNum.length() != 3) {
            return flag;
        } else if (!Pattern.matches("-?\\d+", answerNum)) {
            return flag;
        } else {
            return !flag;
        }
    }

    public void countStrike() {//스트라이크 횟수 카운트
        ++sCount;
    }

    public void countBall() {//볼 횟수 카운트
        ++bCount;
    }
}
