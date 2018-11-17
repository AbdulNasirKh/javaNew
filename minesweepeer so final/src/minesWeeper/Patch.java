/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesWeeper;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author adnan_kanakri
 */
public class Patch {

    public SquaerBox grid[][];
    Queue <pair> p = new LinkedList<>();
    Set<pair> checked = new HashSet<>();
    Scanner s = new Scanner(System.in);
    private int sizeOfBord;
    int numberOfMines;





    class pair {

        int x;
        int y;

        public pair(int x, int y) {
            
                this.x = x;
                this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            pair p = (pair) obj;

            if (p.x == this.x && p.y == this.y) {
                return true;
            }
            return false;
        }

        @Override
        public String toString() {
            String s = "";
            s += x + " " + y;

            return s;
        }

    }

    
    public Patch() {
        
        
        

        try {
            do
            {
              // int sizeOfBord;
              // sizeOfBord=Integer.parseInt(JOptionPane.showInputDialog(null,"please enter your play sizeOfBord:"));
            System.out.println("please enter your play sizeOfBord :");
            sizeOfBord = s.nextInt();
            double size1 = (double)(sizeOfBord * sizeOfBord);
            size1*=(0.4);            
            this.numberOfMines = (int)(size1);
            }while(sizeOfBord <3);
            
        } catch (InputMismatchException e) {
            System.out.println("error");
        } catch (Exception e) {
        }

        grid = new SquaerBox[sizeOfBord][sizeOfBord];

        for (int i = 0; i < this.sizeOfBord; i++) {

            for (int j = 0; j < this.sizeOfBord; j++) {
                grid[i][j] = new SquaerBox();
                grid[i][j].setPrint('o');
            }

        }
        minesGeneretor();
    }
    
    public int getBoardSize ()
    {
        return this.sizeOfBord;
    }

    void minesGeneretor() {

        List<pair> l = new LinkedList<>();

        int i = 0;

        do {

            Random ran = new Random();
            int x = ran.nextInt(this.sizeOfBord);
            int y = ran.nextInt(this.sizeOfBord);
            pair p = new pair(x, y);
            if (!l.contains(p)) {
                l.add(p);
                i++;

            }

        } while (i != numberOfMines);

        for (Iterator<pair> iterator = l.iterator(); iterator.hasNext();) {
            pair next = iterator.next();
            int key = next.x;
            int value = next.y;

            this.grid[key][value].containAMine = true;
        }

    }

    public void setNumberOfMines(int numberOfMines) {
        this.numberOfMines = numberOfMines;
    }

    public int getNumberOfMines() {
        return numberOfMines;
    }

    boolean checkCelles(int i, int j) {
        if (i >= 0 && i < sizeOfBord) {
            if (j >= 0 && j < sizeOfBord) {
                return true;
            }
        }

        return false;
    }

    int numberOfMinesArroundTheCell(int x, int y) {
        int i = 0;

        if (checkCelles(x - 1, y)) {
            if (grid[x - 1][y].containAMine) {
                i++;
            }
        }
        if (checkCelles(x - 1, y - 1)) {
            if (grid[x - 1][y - 1].containAMine) {
                i++;
            }
        }
        if (checkCelles(x, y - 1)) {
            if (grid[x][y - 1].containAMine) {
                i++;
            }
        }
        if (checkCelles(x + 1, y - 1)) {
            if (grid[x + 1][y - 1].containAMine) {
                i++;
            }
        }
        if (checkCelles(x + 1, y)) {
            if (grid[x + 1][y].containAMine) {
                i++;
            }
        }
        if (checkCelles(x + 1, y + 1)) {
            if (grid[x + 1][y + 1].containAMine) {
                i++;
            }
        }
        if (checkCelles(x, y + 1)) {
            if (grid[x][y + 1].containAMine) {
                i++;
            }
        }
        if (checkCelles(x - 1, y + 1)) {
            if (grid[x - 1][y + 1].containAMine) {
                i++;
            }
        }

        return i;
    }

    List<pair> checkNeighborsOfCell(int x, int y) {
        List<pair> p = new LinkedList<>();
        if (checkCelles(x - 1, y)) {
            p.add(new pair(x - 1, y));
        }
        if (checkCelles(x - 1, y - 1)) {
            p.add(new pair(x - 1, y - 1));
        }
        if (checkCelles(x, y - 1)) {
            p.add(new pair(x, y - 1));
        }
        if (checkCelles(x + 1, y - 1)) {
            p.add(new pair(x + 1, y - 1));
        }
        if (checkCelles(x + 1, y)) {
            p.add(new pair(x + 1, y));
        }
        if (checkCelles(x + 1, y + 1)) {
            p.add(new pair(x + 1, y + 1));
        }
        if (checkCelles(x, y + 1)) {
            p.add(new pair(x, y + 1));
        }
        if (checkCelles(x - 1, y + 1)) {
            p.add(new pair(x - 1, y + 1));
        }

        return p;
    }
    
    
    private int tempScore = 0;
    int FloodFillCelles(int x, int y) {
  
        
        int n = numberOfMinesArroundTheCell(x,y);
        
        if(n==0){ 
            
             tempScore++;     
             //System.out.println(this.tempScore);
             this.grid[x][y].setPrint(',');
             
             for (pair pa : checkNeighborsOfCell(x,y))
                 if(grid[pa.x][pa.y].getPrint()=='o')
             {
                 
                       this.FloodFillCelles(pa.x, pa.y);
                 
             }
             
        }else{
            this.grid[x][y].setPrint((char) ('0' + n));
        }
          
        return this.tempScore;
    }

    @Override
    public String toString() {

        String str = new String();
        str = "     ";
        for (int i = 0; i < this.sizeOfBord; i++) {
            str += ((char) (('a' + i)) + "  ");
        }

        str += "\n";

        for (int i = 0; i < this.sizeOfBord; i++) {
            if (i <= 9) {
                str += " ";
            }
            str += i + " : ";
            for (int j = 0; j < this.sizeOfBord; j++) {
                str += grid[i][j].getPrint() + "  ";
            }
            str += "\n";
        }

        return str;
    }

    public String printingTheBordWithMines() {

        String str = new String();
        str = "     ";
        for (int i = 0; i < this.sizeOfBord; i++) {
            str += ((char) (('a' + i)) + "  ");
        }

        str += "\n";

        for (int i = 0; i < this.sizeOfBord; i++) {
            if (i <= 9) {
                str += " ";
            }
            str += i + " : ";
            for (int j = 0; j < this.sizeOfBord; j++) {

                if (grid[i][j].containAMine) {
                    str += 'x';
                } else {
                    str += grid[i][j].getPrint();
                }

                str += "  ";
            }
            str += "\n";
        }

        return str;
    }

}
