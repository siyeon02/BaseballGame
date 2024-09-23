package BaseballGame01;

public class BaseballGameDisplay{
    public void displayStrikeBall(int sCount, int bCount){
        System.out.println(Count.sCount + "strike" + Count.bCount + "ball");
    }
    public void clearStrikeBall(){
        Count.sCount = 0;
        Count.bCount = 0;
    }
    public void displayTry(){
        System.out.println("< 게임 기록 보기 >");

        for(int i = 0; i<Count.count; i++){
            System.out.println(i+1 + "번째 게임" + ": 시도 횟수 - " + BaseballGame.scores.get(i));
        }

    }

    public void clearTrial(){//횟수 초기화
        Count.trial = 0;
    }

    public void clearGame(){
        Count.count = 0;
    }
}
