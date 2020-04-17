/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import gameoflife.GameOfLifeBoard;
import java.util.Random;

/**
 *
 * @author Mario
 */
public class PersonalBoard extends GameOfLifeBoard{
    
    public PersonalBoard(int width, int height){
        super(width, height);
    }
    

    @Override
    public void initiateRandomCells(double d) {
        for(int i=0; i<super.getBoard().length; i++){
            for(int j=0; j<super.getBoard()[i].length; j++){
                double probability = Math.random();
                if(probability<=d && d!=0){
                    super.getBoard()[i][j]=true;
                } else {
                    super.getBoard()[i][j]=false;
                }
                
            }
        }
    }

    @Override
    public boolean isAlive(int i, int i1) {
        if(i<super.getBoard().length && i>=0 && i1 <super.getBoard()[i].length && i1>=0){
            if(super.getBoard()[i][i1]==true){
                return true;
            } else {
                return false;
            } 
        } else {
            return false;
        }
        
    }

    @Override
    public void turnToLiving(int i, int i1) {
        if(i<super.getBoard().length && i>=0 && i1 <super.getBoard()[i].length && i1>=0){
            super.getBoard()[i][i1]=true;
        }
        
    }

    @Override
    public void turnToDead(int i, int i1) {
        if(i<super.getBoard().length && i>=0 && i1 <super.getBoard()[i].length && i1>=0){
        super.getBoard()[i][i1]=false;
        }
    }

    @Override
    public int getNumberOfLivingNeighbours(int i, int i1) {
        int count =0;
        if(i-1<super.getBoard().length && i-1>=0 && i1-1 <super.getBoard()[i].length && i1-1>=0){
            if(super.getBoard()[i-1][i1-1]==true){
                count++;
            }
        }
        if(i-1<super.getBoard().length && i-1>=0 && i1 <super.getBoard()[i].length && i1>=0){
            if(super.getBoard()[i-1][i1]==true){
                count++;
            }
        }
        if(i-1<super.getBoard().length && i-1>=0 && i1+1 <super.getBoard()[i].length && i1+1>=0){
            if(super.getBoard()[i-1][i1+1]==true){
                count++;
            }
        }
        if(i<super.getBoard().length && i>=0 && i1-1 <super.getBoard()[i].length && i1-1>=0){
            if(super.getBoard()[i][i1-1]==true){
                count++;
            }
        }
        if(i<super.getBoard().length && i>=0 && i1+1 <super.getBoard()[i].length && i1+1>=0){
            if(super.getBoard()[i][i1+1]==true){
                count++;
            }
        }
        if(i+1<super.getBoard().length && i+1>=0 && i1-1 <super.getBoard()[i].length && i1-1>=0){
            if(super.getBoard()[i+1][i1-1]==true){
                count++;
            }
        }
        if(i+1<super.getBoard().length && i+1>=0 && i1 <super.getBoard()[i].length && i1>=0){
            if(super.getBoard()[i+1][i1]==true){
                count++;
            }
        }
        if(i+1<super.getBoard().length && i+1>=0 && i1+1 <super.getBoard()[i].length && i1+1>=0){
            if(super.getBoard()[i+1][i1+1]==true){
                count++;
            }
        }
        return count;
        
    }

    @Override
    public void manageCell(int i, int i1, int i2) {
        if(i2 <2){
            turnToDead(i,i1);
        } else if (i2>3){
            turnToDead(i,i1);
        } else if (i2 ==3){
            turnToLiving(i,i1);
        }
    }
    
}
