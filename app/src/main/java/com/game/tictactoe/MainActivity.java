package com.game.tictactoe;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.color.utilities.ColorUtils;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9,btnrestart, btnnewGame;
    TextView txtUserX,txtUserO;
    String b1, b2, b3, b4, b5, b6, b7, b8, b9;
    String Winningmove;
    static Boolean WinnerDeclared = false;
    int UserX=0,UserO=0;

    int flag = 0;
    int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        if (flag==0) {
            txtUserX.setTextColor(Color.RED);
        }
        btnrestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Restarting the Game...", Toast.LENGTH_SHORT).show();
                Winningmove="D";
                Restart();
            }
        });
        btnnewGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "NewGame...", Toast.LENGTH_SHORT).show();
                Winningmove="D";
                newGame();
            }
        });



    }


    private void init() {
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnrestart = findViewById(R.id.btnrestart);
        btnnewGame = findViewById(R.id.btnnewGame);
        txtUserX = findViewById(R.id.txtUserX);
        txtUserO = findViewById(R.id.txtUserO);
    }

    public void Check(View view){
        if(WinnerDeclared==false) {
            Button currentbtn = (Button) view;

            if (currentbtn.getText().toString().equals("")) {
                count++;
                if (flag == 0) {
                    currentbtn.setTextColor(Color.RED);
                    currentbtn.setText("X");
                    flag = 1;
                    txtUserX.setTextColor(Color.BLACK);
                    txtUserO.setTextColor(Color.BLUE);
                } else {
                    currentbtn.setTextColor(Color.BLUE);
                    currentbtn.setText("0");
                    flag = 0;
                    txtUserO.setTextColor(Color.BLACK);
                    txtUserX.setTextColor(Color.RED);
                }

                if (count > 4) {
                    b1 = btn1.getText().toString();
                    b2 = btn2.getText().toString();
                    b3 = btn3.getText().toString();
                    b4 = btn4.getText().toString();
                    b5 = btn5.getText().toString();
                    b6 = btn6.getText().toString();
                    b7 = btn7.getText().toString();
                    b8 = btn8.getText().toString();
                    b9 = btn9.getText().toString();

                    if (b1.equals(b2) && b2.equals(b3) && !b1.equals("")) {
                        Toast.makeText(this, "Winner is " + b1, Toast.LENGTH_SHORT).show();
//                    btn1.setTextSize(34);
//                    btn2.setTextSize(34);
//                    btn3.setTextSize(34);
                        Winningmove = b1;
                        WinnerDeclared=true;
                        Restart();
                    } else if (b4.equals(b5) && b5.equals(b6) && !b4.equals("")) {
                        Toast.makeText(this, "Winner is " + b4, Toast.LENGTH_SHORT).show();
                        Winningmove = b4;
                        WinnerDeclared=true;
                        Restart();
                    } else if (b7.equals(b8) && b8.equals(b9) && !b7.equals("")) {
                        Toast.makeText(this, "Winner is " + b7, Toast.LENGTH_SHORT).show();
                        Winningmove = b7;
                        WinnerDeclared=true;
                        Restart();
                    } else if (b1.equals(b4) && b4.equals(b7) && !b1.equals("")) {
                        Toast.makeText(this, "Winner is " + b1, Toast.LENGTH_SHORT).show();
                        Winningmove = b1;
                        WinnerDeclared=true;
                        Restart();
                    } else if (b2.equals(b5) && b5.equals(b8) && !b2.equals("")) {
                        Toast.makeText(this, "Winner is " + b2, Toast.LENGTH_SHORT).show();
                        Winningmove = b2;
                        WinnerDeclared=true;
                        Restart();
                    } else if (b3.equals(b6) && b6.equals(b9) && !b3.equals("")) {
                        Toast.makeText(this, "Winner is " + b3, Toast.LENGTH_SHORT).show();
                        Winningmove = b3;
                        WinnerDeclared=true;
                        Restart();
                    } else if (b1.equals(b5) && b5.equals(b9) && !b1.equals("")) {
                        Toast.makeText(this, "Winner is " + b1, Toast.LENGTH_SHORT).show();
                        Winningmove = b1;
                        WinnerDeclared=true;
                        Restart();
                    } else if (b3.equals(b5) && b5.equals(b7) && !b3.equals("")) {
                        Toast.makeText(this, "Winner is " + b3, Toast.LENGTH_SHORT).show();
                        Winningmove = b3;
                        WinnerDeclared=true;
                        Restart();
                    } else if (count == 9) {
                        Toast.makeText(this, "Match is Drawn", Toast.LENGTH_SHORT).show();
                        Winningmove = "D";
                        WinnerDeclared=true;
                        Restart();
                    }
                }
            }
        }
    }

    public void newGame(){
        UserX=0;UserO=0;flag=0;count=0;
        txtUserX.setText("User X : "+UserX);
        txtUserO.setText("User O : "+UserO);
        Winningmove = "D";
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");
        txtUserO.setTextColor(Color.BLACK);
        txtUserX.setTextColor(Color.RED);
    }
    public void Restart(){

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                btn1.setText("");
                btn2.setText("");
                btn3.setText("");
                btn4.setText("");
                btn5.setText("");
                btn6.setText("");
                btn7.setText("");
                btn8.setText("");
                btn9.setText("");
                WinnerDeclared=false;
                if(Winningmove.equals("X")){
                    UserX++;
                    txtUserX.setText("User X : "+UserX);
                    flag=0;
                    txtUserO.setTextColor(Color.BLACK);
                    txtUserX.setTextColor(Color.RED);
                }else if(Winningmove.equals("0")){
                    UserO++;
                    txtUserO.setText("User O : "+UserO);
                    flag = 1;
                    txtUserX.setTextColor(Color.BLACK);
                    txtUserO.setTextColor(Color.BLUE);
                }else {

                }
                count=0;
            }
        },1000);


    }
}