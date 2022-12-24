package CS2020.assignment1.game;

public class PlayerGameGrid extends GameGrid{

    public PlayerGameGrid(int width, int height, int noOfShips){
        super(width,height,noOfShips);
    }

    public void printGrid(){
        int width = gameGrid.length;
        int height = gameGrid[0].length;
        System.out.println("Player's Grid");
        for (int r = 0; r< width ;r++){
            for (int c = 0; c < height;c++){
                System.out.print(gameGrid[r][c]+ " ");
            }
            System.out.print("\n");
        }
        
    }
}