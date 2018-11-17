/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesWeeper;
import java.util.Scanner;
/**
 *
 * @author
 */
import java.util.Scanner;
public class Score {
    
    private int  totalScore;
    private int clickOnEmptyCell;
    private int flood;
    private int putSignOnMine;
    private int putSignOnEmpty;
    private int pressOnMine;
    private int containNumber;
    private int endGame;
    private int Continue;
    private Scanner read;
    public Score()
    {
        this.totalScore = 0 ;
        this.containNumber = 0;
        this.clickOnEmptyCell = 10;
        this.flood = 1;
        this.putSignOnMine = 5;
        this.putSignOnEmpty = -1;
        this.pressOnMine = -250;
        this.endGame = 100;
        this.Continue = -250;
        this.read = new Scanner(System.in);
        
    }
    
   public void edit()
   {    
//       Score s = new Score();
//       System.out.println(s);
       System.out.println("choose the one that you would like to change");
       System.out.println("1: clickOnEmptyCell");
       System.out.println("2: flood");
       System.out.println("3: putSignOnMine");
       System.out.println("4: putSignOnEmpty");
       System.out.println("5: pressOnMine");
       System.out.println("6: containNumber");
       System.out.println("7: endGame");
       int choose =  read.nextInt();
       
       switch(choose)
       {
           case 1:
           {
               System.out.println("enter the value the you want");
               int N = read.nextInt();
               this.clickOnEmptyCell = N;
               break;
           }
           case 2:
           {
               System.out.println("enter the value the you want");
               int N = read.nextInt();
               this.flood = N;
               break;
           }
            case 3:
           {               
               System.out.println("enter the value the you want");
               int N = read.nextInt();
               this.putSignOnMine = N;
               break;
           }
            case 4:
           {    
               System.out.println("enter the value the you want");
               int N = read.nextInt();
               this.putSignOnEmpty = N;
               break;
           }
            case 5:
           {
               System.out.println("enter the value the you want");
               int N = read.nextInt();
               this.pressOnMine = N;
               break;
           }
            case 6:
           {
                System.out.println("enter the value the you want");
               int N = read.nextInt();
               this.containNumber = N;
               break;
           }
            case 7:
           {
                System.out.println("enter the value the you want");
               int N = read.nextInt();
               this.endGame = N;
               break;
           }
       }
   }
    public int getTotalScore()
    {
        return  this.totalScore;
    }
    
    
    //sign//
    public void putSignOnEmpty()
    {
        this.totalScore-=this.putSignOnEmpty;
    }
    
    public void putSignOnMine()
    {
        this.totalScore+=this.putSignOnMine;
    }
    
    //end sign
    
    public void addThemineNumber(int mine)
    {
        this.containNumber = mine;
        this.totalScore+=this.containNumber;
    }
    
    
    public void clickOnEmptyCell()
    {
        this.totalScore+=this.clickOnEmptyCell;
    }
    
    public void flood(int numberOfCells)
    {
        this.totalScore+=this.flood*numberOfCells;
    }
    
    
    public void endGame()
    {
        this.totalScore+=this.endGame;
    }
    
    public void Continue()
    {
        this.totalScore-=this.Continue;
    }
    
  public String toString() {
     
      
       String s = new String();
       
       s+="Score board\n";
       s+="1: clickOnEmptyCell: " + this.clickOnEmptyCell +"\n";
       s+="2: flood: " + this.flood +"\n";
       s+="3: putSignOnMine: " + this.putSignOnMine +"\n";
       s+="4: putSignOnEmpty: " + this.putSignOnEmpty +"\n";
       s+="5: pressOnMine:  " + this.pressOnMine +"\n";
       s+="6: containNumber:  " + this.containNumber +"\n";
       s+="7: endGame: " + this.endGame +"\n";
       
       return s;
  }
  
}
