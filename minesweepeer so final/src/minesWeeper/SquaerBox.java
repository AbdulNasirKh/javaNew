 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesWeeper;

/**
 *
 * @author adnan_kanakri
 */
public class SquaerBox {
    public char print;
    public boolean containAMine;
    

    public SquaerBox() {
        this.print = 'o';
        this.containAMine = false;
    }

    public void setIsMine(boolean isMine) {
        this.containAMine = isMine;
    }

    public void setPrint(char print) {
        this.print = print;

    }

    public char getPrint() {
        return print;
    }
    
    public boolean getIsMIne() {
        return containAMine;
    }
    
   
    
    
}
