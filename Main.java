import java.io.File;
import java.io.IOException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        try {
            File rFile = new File("maze.dat");                      
            Scanner scan = new Scanner(rFile);                      

            int rows = scan.nextInt();                              
            int cols = scan.nextInt();                              
            scan.nextLine();                                        

            char[][] maze = new char[rows][cols];                   

            for (int line = 0; line < rows; line++){                
                String rLine = scan.nextLine();                     
                maze[line] = rLine.toCharArray();                   
            }
            scan.close();                                           

            if (solveMaze(maze,1,1)){                        
                printMaze(maze);                                    
                System.out.println("\n Maze solved! :)");
            } else {                                                
                printMaze(maze);                                    
                System.out.println("\n Maze unsolvable. :()");
            }


        } catch (IOException e) {                                   
            System.out.println("An error has occured.");
            e.printStackTrace();
        }


    }

    public static boolean solveMaze(char[][] maze, int r, int c){   

        //BASE CASE
        if (r < 0 ||                    
            c < 0 ||                    
            r >= maze.length ||         
            c >= maze[0].length ||      
            maze[r][c] == 'X' ||        
             maze[r][c] == '+'){        
            return false;              
        }

        if (maze[r][c] == '-'){         
            return true;                
        }

        //GENERAL CASE
        maze[r][c] = '+';                       

        if (solveMaze(maze, r - 1, c) ||        
        solveMaze(maze, r + 1, c) ||            
        solveMaze(maze, r, c - 1) ||            
        solveMaze(maze, r, c + 1)){             
            return true;                       
        }
        maze[r][c] = '.';                       
        return false;                       
    }

    public static void printMaze(char[][] inMaze){      
                                                        
        for (char[] line : inMaze){
            for (char charac : line){
                System.out.print(charac);
            }
            System.out.println();
        }
    }
}
