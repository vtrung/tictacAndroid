package com.example.svingt.tictac;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Main_Activity extends Activity {
    TicTacToe ticTacToe;
    TextView view1;
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button rbutton;
    boolean player1 = true;

    Button[] buttons = {
            button0,
            button1,
            button2,
            button3,
            button4,
            button5,
            button6,
            button7,
            button8,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //ticTacToe.reset();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_);


        ticTacToe = new TicTacToe();
        view1 = (TextView)findViewById(R.id.textView3);
        rbutton = (Button)findViewById(R.id.reset);
        buttons[0] = (Button)findViewById(R.id.button0);
        buttons[1] = (Button)findViewById(R.id.button1);
        buttons[2] = (Button)findViewById(R.id.button2);
        buttons[3] = (Button)findViewById(R.id.button3);
        buttons[4] = (Button)findViewById(R.id.button4);
        buttons[5] = (Button)findViewById(R.id.button5);
        buttons[6] = (Button)findViewById(R.id.button6);
        buttons[7] = (Button)findViewById(R.id.button7);
        buttons[8] = (Button)findViewById(R.id.button8);

        setAllButton();

    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main_, menu);
//        return true;
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void setButton(final Button b){
        b.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    int i = Integer.parseInt(b.getTag().toString());
                    //view1.setText(Integer.toString(i));
                    if (ticTacToe.play(i)) {
                        if (player1) {
                            b.setText("X");
                            player1 = false;
                        } else {
                            b.setText("O");
                            player1 = true;
                        }
                    }
                    winner();
                    b.setBackgroundColor(Color.GRAY);
                } else if(event.getAction() == MotionEvent.ACTION_UP){
                    b.setBackgroundColor(Color.WHITE);
                    b.setBackgroundResource(R.drawable.mystyle);
                }
                return false;
            }

        });
    }

    public void winner(){
        Main_Application mainApp = (Main_Application)getApplicationContext();
        mainApp.getSomeInt();
        if(ticTacToe.check_win()){
            if(player1)
                view1.setText("O is winner");
            else
                view1.setText("X is winner");
        }
    }
    public void setAllButton(){
        for(int i = 0; i < 9; i++){
            setButton(buttons[i]);
        }
        rbutton.setOnTouchListener(new View.OnTouchListener() {
           @Override
           public boolean onTouch(View v, MotionEvent event) {
               if (event.getAction() == MotionEvent.ACTION_DOWN) {
                   rbutton.setBackgroundColor(Color.GRAY);
                   reset() ;
               }else if (event.getAction() == MotionEvent.ACTION_UP) {
                   rbutton.setBackgroundColor(Color.WHITE);
                   rbutton.setBackgroundResource(R.drawable.mystyle);
               }
               return false;
           }

        }
        );

    }
    public void reset(){
        ticTacToe.reset();
        for(int i = 0; i < 9; i++){
            buttons[i].setText(" ");
        }
        player1 = true;
        view1.setText(" ");
    }
//    public void playTic(Button b){
//        for(int i = 0; i < 9; i++){
//            if(b == buttons[i]){
//                //ticTacToe.play(i);
//                //b.setText("X");
//                //tv3.setText(i);
//                break;
//            }
//        }
//    }
}
