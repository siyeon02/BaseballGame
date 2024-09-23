package BaseballGame01;

public class Count {
    public static int sCount = 0;
    public static int bCount = 0;
    public static int count = 0;
    public static int trial = 0;

    public void countStrike() {//스트라이크 횟수 카운트
        ++sCount;
    }

    public void countBall() {//볼 횟수 카운트
        ++bCount;
    }

    public void countGame(){//게임 횟수 카운트
        ++count;
    }

    public static void countTrial(){//시도 카운트
        ++trial;
    }


}
