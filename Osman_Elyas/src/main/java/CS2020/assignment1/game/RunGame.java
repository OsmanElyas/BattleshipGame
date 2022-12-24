package CS2020.assignment1.game;
import java.util.Scanner;

public class RunGame{
    
    
    public static void main(String[] args){
        int inHeight = Integer.parseInt(args[0]);
        int inWidth = Integer.parseInt(args[1]);
        int numShips = Integer.parseInt(args[2]);

        Game game1 = new Game(inHeight,inWidth,numShips);
        Scanner myObj = new Scanner(System.in);

        
        while(game1.checkVictory() == false){            
            System.out.println("Enter attack coordinates (x,y)");
            try{
            String input = myObj.nextLine();   
            game1.exitGame(input);
            game1.playRound(input);
            }catch(NumberFormatException e){
                System.out.println("Incorrect input");
            }

        }


    }
}
//To run navigate into target and paste java -jar assignment1-1.0-SNAPSHOT.jar 10 10 4