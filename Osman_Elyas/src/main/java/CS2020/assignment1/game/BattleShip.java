package CS2020.assignment1.game;
import java.util.Random;

public class BattleShip extends AbstractBattleShip{

    public BattleShip(String name) {
        this.name = name;
        Random rand = new Random();
        int ran = rand.nextInt(2);
        if(ran == 0){
            this.shipOrientation = "vertical";
        } 
        else{
            this.shipOrientation = "horizontal";
        }
    }

    public String getName(){
        return name;
    }

    public int getHits(){
        return hits;
    } 

    public String getShipOrientation(){
        return shipOrientation;
    }

    public void setHits(int numberOfHits){
        this.hits = numberOfHits;
    }

    public int[][] getShipCoordinates(){
        return shipCoordinates;
    }

    public void setShipCoordinates(int[][] coordinates){
        this.shipCoordinates = coordinates;
    }

   public boolean checkAttack(int row, int column){
        if (hits == 3){
            return false;
        } 
        for (int i = 0; i < shipCoordinates.length; i++) {
            if(row == shipCoordinates[i][0] && column == shipCoordinates[i][1]){
                hits += 1; 
                return true;
            }
            
        } 
        return false;


    }


}


