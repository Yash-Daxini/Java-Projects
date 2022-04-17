package otherclass;
import java.util.Random;
import java.util.*;
class Game{
    private int number;
    private int guessnumber;
    private int count=0;

    Game(){
        Random r = new Random();
        number = r.nextInt(100);
    }

    public void takeUserInput(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your number:");
        guessnumber = sc.nextInt();
    }

    public boolean isCorrectNumber(){
        count++;
        if(number  == guessnumber){
            System.out.format("\n\tYou guess the %d number in %d attempt.",number,count);
            return true;
        }
        else if(guessnumber < number){
            System.out.println("Number is lesser from original number.");
        }
        else if(guessnumber > number){
            System.out.println("Number is greater from original number.");
        }
        return false;
    }
}
public class GamePro {
    public static void main(String[] args) {
        Game g = new Game();
        boolean b = false;
        while(!b){
            g.takeUserInput();
            b = g.isCorrectNumber();
        }
    }
}
