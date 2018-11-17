/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesWeeper;

/**
 *
 * @author ayed
 */
abstract  class player {
    abstract public boolean play(Patch b , minesWeeper.Score Score);
    public minesWeeper.Score Score;
}
