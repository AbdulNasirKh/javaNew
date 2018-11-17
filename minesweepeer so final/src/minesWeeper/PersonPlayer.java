/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesWeeper;
import java.util.Scanner;

/**
 *
 * @author ayed
 */
public class PersonPlayer extends player{
    
   
    public PersonPlayer() {
        //this.Score = 0;
        Score = new Score();
    }
    
    Scanner s = new Scanner(System.in);
    @Override
    public boolean play(Patch b  , minesWeeper.Score Score) {
       
        this.Score = Score;
              
        int x;
        int y;
        System.out.println("if you want to set sign press 1 ");
        System.out.println("if you want to open SquaerBox press 2 ");
        System.out.println("if you would to delet your sign press 3 ");
            int t = s.nextInt();

            if (t == 2) {
                do {
                    do
                    {
                    System.out.println("please enter your x position for play :");
                    x = s.nextInt();
                    System.out.println("please enter your y position for play :");
                    y = s.nextInt();
                    if(!b.checkCelles(x, y))
                    {
                        System.out.println("x and y must be grater than zero and less the " + b.getBoardSize() +"\n");
                    }
                    }while(!b.checkCelles(x, y));
                    if (b.grid[x][y].getPrint() == 'p') {
                        System.out.println("pleas try again ");
                    }else
                    if (b.grid[x][y].containAMine) {
                        b.grid[x][y].print = 'B';
                        System.out.println(b);
                        return  false;
                        
                    } else if (!b.grid[x][y].containAMine && b.grid[x][y].getPrint() != 'p' && b.grid[x][y].getPrint()=='o') {
                        int num = b.numberOfMinesArroundTheCell(x, y);
                        if(num != 0)
                        {
                            b.grid[x][y].print = (char)('0' + num) ;
                           
                            this.Score.addThemineNumber(num);
                        }
                        else{
                             this.Score.clickOnEmptyCell();
                             int floodScore = b.FloodFillCelles(x,y);
                             this.Score.flood(floodScore);
                        }                      
                    }

                } while (b.grid[x][y].getPrint() == 'p');

            } else if (t == 1) {

                do {
                    do
                    {
                    System.out.println("please enter your x position for play :");
                    x = s.nextInt();
                    System.out.println("please enter your y position for play :");
                    y = s.nextInt();
                    if(!b.checkCelles(x, y))
                    {
                        System.out.println("x and y must be grater than zero and less the " + b.getBoardSize() +"\n");
                    }
                    }while(!b.checkCelles(x, y));
                    if (b.grid[x][y].getPrint() != 'o') {
                        System.out.println("you cant put here");
                    } 
                    
                    

                } while (b.grid[x][y].getPrint() != 'o');
                
                if(b.grid[x][y].containAMine)
                {
                    this.Score.putSignOnMine();

                } else {
                    this.Score.putSignOnEmpty();
                }
                b.grid[x][y].setPrint('p');
                return true;

            } else if (t == 3) {
                do {

                    do
                    {
                    System.out.println("please enter your x position for play :");
                    x = s.nextInt();
                    System.out.println("please enter your y position for play :");
                    y = s.nextInt();
                    if(!b.checkCelles(x, y))
                    {
                        System.out.println("x and y must be grater than zero and less the " + b.getBoardSize() +"\n");
                    }
                    }while(!b.checkCelles(x, y));
                    if (b.grid[x][y].getPrint() != 'p') {
                        System.out.println("there is no sign here ");
                    }

                } while (b.grid[x][y].getPrint() != 'p');

                b.grid[x][y].setPrint('o');

        }
            return true;
    }
    
}
