package CS2020.assignment1.game;

import java.util.Random;

public class Game implements GameControls{
    private Random rand = new Random();
    PlayerGameGrid playersGrid;
    OpponentGameGrid opponentsGrid;

    public Game(int width, int height, int noOfShips){
        playersGrid = new PlayerGameGrid(width, height, noOfShips);
        opponentsGrid = new OpponentGameGrid(width, height, noOfShips);
    }

	public AbstractGameGrid getPlayersGrid (){
        return playersGrid;
    }
	
	public AbstractGameGrid getOpponentssGrid (){

        return opponentsGrid;
    }


    public void exitGame (String input){
        if (input.toUpperCase().equals("EXIT")){
            System.out.println("Exiting game – thank you for playing... ");
            System.exit(0);
        }

    }

    public boolean checkVictory (){
        if(playersGrid.allShipsDestroyed() == true){
            System.out.println("You have lost!");
            return true;
        }else if (opponentsGrid.allShipsDestroyed() == true){
            System.out.println("You have won!");
            return true;
        }

            return false;

        }

    public void playRound (String input){
       // int newInput;
        input.split(",");
        String[] splitInput= input.split(",");
        int xCoordinate;
        int yCoordinate;
        int startY;
        int startX;
        
        xCoordinate = Integer.parseInt(splitInput[0]);
        yCoordinate = Integer.parseInt(splitInput[1]);

        if(opponentsGrid.gameGrid[yCoordinate][xCoordinate].equals("*")){
            for(AbstractBattleShip opponentsShip : opponentsGrid.ships){
                for(int[] coordinates: opponentsShip.getShipCoordinates()){
                    if(yCoordinate == coordinates[1] && xCoordinate == coordinates[0]){
                        System.out.println("HIT "+opponentsShip.getName()+ "!!!");
                    }
                }
            }
            opponentsGrid.gameGrid[yCoordinate][xCoordinate] = "X";
            
            opponentsGrid.printGrid();
        }else {
            System.out.println("MISS"+"!!!");
            opponentsGrid.gameGrid[yCoordinate][xCoordinate] = "%";
            opponentsGrid.printGrid();
        }

        
            startY = rand.nextInt(playersGrid.gameGrid.length);
            startX = rand.nextInt(playersGrid.gameGrid[0].length) ; 
            if(playersGrid.gameGrid[startY][startX].equals("*")){
                System.out.println("HIT "+"!!!");
                playersGrid.gameGrid[startY][startX] = "X";
                playersGrid.printGrid();
            }else {
                System.out.println("MISS"+"!!!");
                playersGrid.gameGrid[startY][startX] = "%";
                playersGrid.printGrid();
                } 

            

        }


    }




