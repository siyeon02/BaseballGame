package BaseballGame01;

import java.util.Scanner;

public class Level {

    public static int level;

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
        Level.level = level;
    }
}
