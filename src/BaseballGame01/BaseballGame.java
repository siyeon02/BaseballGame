package BaseballGame01;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;


public class BaseballGame {
    private String answerBall = "";
    public boolean flag;
    public static int sCount = 0;
    public static int bCount = 0;
    public static int count = 0;
    public static int trial = 0;
    static final ArrayList<Integer> scores = new ArrayList<>();
    public static int level;

    public BaseballGame() {
        this.flag = true;
    }

    public void start() {

        System.out.println("<게임을 시작합니다>");

        BaseballGameDisplay display = new BaseballGameDisplay();
        Random random = new Random();
        HashSet<Integer> uniqueNumber = new HashSet<>();
        int ball = 0;
        int letter = 3;

        while(uniqueNumber.size()<level){//레벨 수 따라 자리 수 설정
            ball = random.nextInt(9)+1;
            uniqueNumber.add(ball);
        }

        for(int num : uniqueNumber){
            answerBall = answerBall + Integer.toString(num);
        }

        /*for (int i = 0; i < letter; i++) {//랜덤으로 정답 3자리 설정
            ball = random.nextInt(9) + 1;//0~9사이의 숫자 중 랜덤
            ranBall = Integer.toString(ball);//정수를 문자열로 바꿈
            answerBall = answerBall + ranBall;//정답 저장

        }*/

        setAnswerBall(answerBall);//정답 저장

        boolean isOut = true;//out 판단

        Scanner sc = new Scanner(System.in);
        while(sCount!=3){
            System.out.println(answerBall);//정답표시
            System.out.println("정답을 입력해주세요 : ");
            String answerNum = sc.next();
            countTrial();

            try{
                for(int i=0; i<answerNum.length();i++){
                    char user = answerNum.charAt(i);
                    char answer = answerBall.charAt(i);

                    if(user == answer){//스트라이크 조건 먼저
                        countStrike();
                        isOut = false;//스트라이크면 아웃 아님
                    }else if(answerBall.contains(String.valueOf(user))&&answer != user){//볼 조건은 스트라이크 조건 예외하고 생각
                        countBall();
                        isOut = false;//볼이면 아웃 아님
                    }

                }

                /*for(int i = 0;i<answerNum.length();i++){
                    char user = answerNum.charAt(i);
                    char answer = answerBall.charAt(i);

                    if(answerBall.contains(String.valueOf(user))&&answer != user){//볼 조건은 스트라이크 조건 예외하고 생각
                        countBall();
                        isOut = false;//볼이면 아웃 아님
                    }
                }*/
            }
            catch(IndexOutOfBoundsException e){//사용자의 답 길이가 3 초과일 떄 예외발생
                System.out.println("올바르지 않은 입력값입니다");
            }


            if(isOut){//아웃
                System.out.println("out!");
            }

            display.displayStrikeBall(sCount, bCount);

            if (sCount == level) {
                System.out.println("정답입니다");
                answerBall = "";
                display.clearStrikeBall();
                break;
            } else if (!validInput(answerNum)) {
                System.out.println("올바른 세 자리 수를 입력하세요!");
                display.clearStrikeBall();
            } else {
                System.out.println("오답입니다");
                display.clearStrikeBall();
            }

        }
        scores.add(trial);
        display.clearTrial();

    }

    public void setAnswerBall(String answerBall) {//정답 저장
        this.answerBall = answerBall;
    }


    public boolean validInput(String answerNum) {//모두 숫자이고 중복되지 않는 맞는 인풋인지 확인
        boolean flag = false;
        if (answerNum.length() != level) {//레벨 수에 따라 예외 처리
            System.out.println("세 자리 수를 입력하세요");
            return flag;
        } else if (!Pattern.matches("\\d+", answerNum)) {
            System.out.println("문자가 아닌 숫자를 입력하세요.");
            return flag;
        }
        HashSet<Character> set = new HashSet<>();
        for(int i=0;i<answerNum.length();i++){//중복 입력 확인
            if(!set.add(answerNum.charAt(i))){
                System.out.println("중복되는 수 입니다. 다시 입력하세요.");
                return flag;
            }
        }
        return !flag;
    }

    public void countStrike() {//스트라이크 횟수 카운트
        ++sCount;
    }

    public void countBall() {//볼 횟수 카운트
        ++bCount;
    }

    public void countGame(){//게임 횟수 카운트
        ++count;
    }

    public void countTrial(){//시도 카운트
        ++trial;
    }

    public void makeLevel(){
        Scanner sc = new Scanner(System.in);
        level = sc.nextInt();
        setLevel(level);
        switch (level){
            case 3 :
                System.out.println("3자리 수 난이도로 설정되었습니다");
                break;
            case 4 :
                System.out.println("4자리 수 난이도로 설정 되었습니다");
                break;
            case 5 :
                System.out.println("5자리 수 난이도로 설정 되었습니다.");
                break;
            default:
                System.out.println("3,4,5 중 선택하세요.");
                break;
        }
    }

    public void setLevel(int level){
        BaseballGame.level = level;
    }

}