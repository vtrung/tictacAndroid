package com.example.svingt.tictac;

/**
 * Created by svingt on 8/8/14.
 */
public class TicTacToe {

    private boolean win = false;
    private boolean playerx = true;
    private char[] chart = {
        ' ', ' ', ' ',
        ' ', ' ', ' ',
        ' ', ' ', ' ',
    };

    TicTacToe(){
        playerx = true;
        win = false;
        for(int i = 0; i < 9; i++){
            chart[i] = ' ';
        }
    }

    public boolean check_win(){
        if(check_combo(0,1,2))
            win = true;
        if(check_combo(3,4,5))
            win = true;
        if(check_combo(6,7,8))
            win = true;
        if(check_combo(0,4,8))
            win = true;
        if(check_combo(2,4,6))
            win = true;
        if(check_combo(0,3,6))
            win = true;
        if(check_combo(1,4,7))
            win = true;
        if(check_combo(2,5,8))
            win = true;
        return win;
    }
    // Check combination if they match
    private boolean check_combo(int a, int b, int c){
        if(chart[a] == chart[b] && chart[b] == chart[c] && chart[a] != ' ' && chart[b] != ' ' && chart[c] != ' ')
            return true;
        return false;
    }

    public boolean play(int spot){
        if(win || chart[spot] != ' ')
            return false;
        else {
            if (playerx) {
                chart[spot] = 'x';
                if(!check_win())
                    playerx = false;
            } else {
                chart[spot] = 'o';
                if(!check_win())
                    playerx = true;
            }
        }
        return true;
    }

    public void reset(){
        for(int i = 0; i < 9; i++){
            chart[i] = ' ';
        }
        playerx = true;
        win = false;
    }

    public char winner(){
        if(playerx)
            return 'x';
        return 'o';
    }

}
