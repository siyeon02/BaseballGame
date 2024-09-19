package BaseballGame01;

public class BaseballGameDisplay{
    public void displayStrikeBall(int sCount, int bCount){
        System.out.println(BaseballGame.sCount + "strike" + BaseballGame.bCount + "ball");
    }
    public void clearStrikeBall(){
        BaseballGame.sCount = 0;
        BaseballGame.bCount = 0;
    }
    public void displayTry(){
        System.out.println("< 게임 기록 보기 >");

        for(int i = 0; i<BaseballGame.count; i++){
            System.out.println(i+1 + "번째 게임" + ": 시도 횟수 - " + BaseballGame.scores.get(i));
        }

    }

    public void clearTrial(){//횟수 초기화
        BaseballGame.trial = 0;
    }

    public void clearGame(){
        BaseballGame.count = 0;
    }
}
