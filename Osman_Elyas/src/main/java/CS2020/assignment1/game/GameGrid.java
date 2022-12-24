package CS2020.assignment1.game;
import java.util.Random;


public class GameGrid extends AbstractGameGrid{

  public GameGrid(int width, int height, int noOfShips){

        this.gameGrid = new String[width][height];
        initializeGrid();
        generateShips(noOfShips);
        for(AbstractBattleShip ship1: ships){
            placeShip(ship1);
        }
    }
    
    public void initializeGrid(){

        for(int i = 0; i < this.gameGrid.length; i++){
            for (int c = 0; c < this.gameGrid[0].length; c++){
                this.gameGrid[i][c] = ".";
            }
        }
    }

    public void generateShips(int numberOfShips){
    ships = new BattleShip[numberOfShips];
    for (int i = 0; i < numberOfShips; i++){
        ships[i] = new BattleShip("Ship "+(i+1));
        }

    }

    public void placeShip(AbstractBattleShip ship){
        //get random coordinates. make sure they dont overspill. put on grid and store location.

        int gridHeight = this.gameGrid.length;
        int gridWidth = this.gameGrid[0].length;
        int shipsLength = 3;
        int[][] shipsCoordinates = new int[3][2];
        int startX;
        int startY;
        
        Random rand = new Random();
        
        if (ship.getShipOrientation() == "vertical"){
            startY = rand.nextInt(gridHeight - shipsLength + 1);
            startX = rand.nextInt(gridWidth) ;   
            for(int i = 0; i < 3; i++){
                shipsCoordinates[i][0] = startX;
                shipsCoordinates[i][1] = startY + i;
            }    
        }else{
            startY = rand.nextInt(gridHeight) ;   
            startX = rand.nextInt(gridWidth - shipsLength + 1);
            for(int i = 0; i < 3; i++){
                shipsCoordinates[i][0] = startX + i;
                shipsCoordinates[i][1] = startY;
            }  
            
        }
        for (int[] coordinate: shipsCoordinates){
            this.gameGrid[coordinate[1]][coordinate[0]] = "*";
        }
        ship.setShipCoordinates(shipsCoordinates);

    }
    public boolean allShipsDestroyed(){
        for (int x = 0; x < ships.length; x++){
            if(ships[x].getHits() < 3){
                return false;
            }
        }
        return true;
    }


}