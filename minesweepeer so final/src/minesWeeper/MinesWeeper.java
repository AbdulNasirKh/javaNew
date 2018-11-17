package minesWeeper;

import java.util.Scanner;

public class MinesWeeper {

    private Patch bord;
    Scanner s;
    minesWeeper.Score Score;

    public MinesWeeper() {
        s = new Scanner(System.in);
        Score = new Score();
        System.out.println(Score);
        System.out.println("do you wanna change anyting ??? \n 1 enter 1 to change");
        int choice = s.nextInt();
        if(choice==1)
        {
            do
            {
            Score.edit();
            System.out.println(Score);
                System.out.println("enter 0 to exit or 1 to continue\n");
            choice = s.nextInt();
            }while(choice!=0);
        }
        bord = new Patch();


        
    }
    
    
    boolean TheWinner(){
       
        int counter = 0;
        for(int i = 0; i< bord.getBoardSize(); i++)
        {
            for(int j = 0; j< bord.getBoardSize(); j++)
            {
                char ch = bord.grid[i][j].getPrint();
                
               /* if(ch!='o')
                {
                    if((ch=='p' && !bord.grid[i][j].containAMine) || ch!='p')
                        counter++;
                }*/
               //
                if(ch!='o' && ch!='p')
                {
                   counter++;
                }
            }
        }
        
        
        if((counter + bord.getNumberOfMines())== bord.getBoardSize()* bord.getBoardSize())
        {
            System.out.println("win!!!");
            return true;
        }
            
        return false;
        
    }

    void PlayChoices() {

       new  Frame();
        
        System.out.println("if you want play with your self  press 1 ");
        System.out.println("if you want play with another player press 2 ");
        System.out.println("if you want play with the computer press 3 ");
        
        int choice = s.nextInt();
        
        switch(choice){
            
            case 1:
                player p  = new PersonPlayer();
                do{
                    if(p.Score.getTotalScore()<=10)
                    {
                        System.out.println("worring: your Score is tooo low.." + p.Score.getTotalScore());
                    }
                    if(!p.play(bord, Score))
                    {
                        
                        System.out.println("Your Score is: " + p.Score.getTotalScore());
                        System.out.println("game over");
                        break;
                    } else if(TheWinner()){
                        System.out.println("Your Score is: " + p.Score.getTotalScore());
                        System.out.println("Congrats");
                        break ;
                    }

                    System.out.println(bord);
                }while(!TheWinner());
                break;
            case 2:
                PersonPlayer p1,p2;
                minesWeeper.Score scorePlayer1 = new Score();
                minesWeeper.Score scorePlayer2 = new Score();
                p1 = new PersonPlayer();
                p2 = new PersonPlayer();
                int i=1;
                do {   
                if(p1.Score.getTotalScore()<=10)
                    {
                        System.out.println("worring: your Score is tooo low.." + p1.Score.getTotalScore());
                    }
                if(p2.Score.getTotalScore()<=10)
                    {
                        System.out.println("worring: your Score is tooo low.." + p2.Score.getTotalScore());
                    }
                
                    System.out.println(bord);
                    if(i%2!=0)
                    {
                        System.out.println("turn player 1 :");
                        if(!p1.play(bord, scorePlayer1)){
                            
                            System.out.println("player 2 is the winner  ......");
                            break;
                        }
                    
                    }
                    else
                    {
                        System.out.println("turn player 2 :");
                        if(!p2.play(bord, scorePlayer2)){
                            
                            System.out.println("player 1 is the winner ......");
                            break;
                            
                        }
               
                    }
                    i++;
                    
                } while (!TheWinner());
                
                
                
                break;
            case 3:
                 player Player, Computer;
                Player = new PersonPlayer();
                Computer = new CpuPlayer();
                minesWeeper.Score scorePlayer= new Score();
                minesWeeper.Score scoreComputer= new Score();
                int j=1;
                do {
                if(Player.Score.getTotalScore()<=10)
                    {
                        System.out.println("worring: your Score is tooo low.." + Player.Score.getTotalScore());
                    }
                if(Computer.Score.getTotalScore()<=10)
                    {
                        System.out.println("worring: your Score is tooo low.." + Computer.Score.getTotalScore());
                    }
                    System.out.println(bord);
                    if(j%2!=0)
                    {
                        System.out.println("turn player  :");
                        if(!Player.play(bord,scorePlayer)){
                            System.out.println("worring: your Score is tooo low.." + Player.Score.getTotalScore());
                            System.out.println("worring: your Score is tooo low.." + Computer.Score.getTotalScore());
                            System.out.println("Computer won ......");
                            break;
                        }
                    
                    
                    }
                    else
                    {
                        System.out.println("turn Computer  :");
                        if(!Computer.play(bord,scoreComputer)){
                            
                            System.out.println("worring: your Score is tooo low.." + Player.Score.getTotalScore());
                            System.out.println("worring: your Score is tooo low.." + Computer.Score.getTotalScore());
                            System.out.println("player  won ......");
                            break;
                            
                        }
               
                    }
                    j++;
                    
                } while (!TheWinner());
                
                
                break;
            default:
                break;
        
    };
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MinesWeeper game = new MinesWeeper();
        System.out.println(game.bord.printingTheBordWithMines());
        game.PlayChoices();

    }

}
