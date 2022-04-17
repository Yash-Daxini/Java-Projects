package otherclass;
import java.util.Random;
public class RandomNum {
    public static void main(String[] args) {
        // Random r = new Random();
        // int n = r.nextInt(500);
        // System.out.println("Random number is:"+ n);
        // while(true){
        //     System.out.println("Hello");
        // }
        int min = 450;
        int max  = 500;
        
        for(int i =0;i<5;i++){
            int random = (int)(Math.floor(Math.random()*(max-min+1)+min));
            System.out.println(random);
        }
    }
}
