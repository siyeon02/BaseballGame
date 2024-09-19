package BaseballGame01;

public class BaseballGameDisplay{
    public void displayStrikeBall(int sCount, int bCount){
        System.out.println(BaseballGame.sCount + "strike" + BaseballGame.bCount + "ball");
    }
    public void clearStrikeBall(){
        BaseballGame.sCount = 0;
        BaseballGame.bCount = 0;
    }
    public void displayTry(int count, int trial){
        System.out.println("< 게임 기록 보기 >");

        for(int i = 1; i<BaseballGame.count+1; i++){
            System.out.println(i + "번째 게임" + ": 시도 횟수 - " + BaseballGame.trial);
        }

    }

    public void clearTrial(){
        BaseballGame.trial = 0;
    }
}
