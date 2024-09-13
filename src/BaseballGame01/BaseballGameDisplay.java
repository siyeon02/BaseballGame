package BaseballGame01;

public class BaseballGameDisplay{
    public void displayStrikeBall(int sCount, int bCount){
        System.out.println(BaseballGame.sCount + "strike" + BaseballGame.bCount + "ball");
    }
    public void clearStrikeBall(){
        BaseballGame.sCount = 0;
        BaseballGame.bCount = 0;
    }
}
