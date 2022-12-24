package CS2020.assignment1.game;

public class OpponentGameGrid extends GameGrid{
    public OpponentGameGrid(int width,int height,int noOfShips){
        super(width, height, noOfShips);
    }
    
    public void printGrid(){
        System.out.println("Opponent's Grid");

        for (int r = 0; r<gameGrid.length;r++){
            
            for (int c = 0; c <gameGrid[0].length;c++){
                if (gameGrid[r][c] == "*"){
                    System.out.print(". ");
                }else {
                    System.out.print(gameGrid[r][c] + " ");
                }
            }
            System.out.print("\n");
        }
        
    }
}
        
    


