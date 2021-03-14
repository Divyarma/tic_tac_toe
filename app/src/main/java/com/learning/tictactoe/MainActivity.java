package com.learning.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int[] ids={R.id.c1,R.id.c2,R.id.c3,R.id.c4,R.id.c5,R.id.c6,R.id.c7,R.id.c8,R.id.c9};
    int p=1;
    int[] game={0,0,0,0,0,0,0,0,0};
    int[][] winpos={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    boolean G=true;
    public void clicked(View view){
        ImageView img= (ImageView) view;
        int t=Integer.parseInt(img.getTag().toString());
        if(G) {
            if (game[t] == 0) {
                if (p == 1) {
                    img.setImageResource(R.drawable.circle);
                    game[t] = 1;
                    check(p);
                    p = 2;
                } else {
                    img.setImageResource(R.drawable.cross);
                    game[t] = 2;
                    check(p);
                    p = 1;
                }
            }
        }

    }
    public void reset(View view){
        for(int i=0;i<9;i++){
            ImageView img=(ImageView) findViewById(ids[i]);
            img.setImageResource(0);
        }
        G=true;
        for(int i=0;i<9;i++){
            game[i]=0;
        }
        p=1;

    }

    public int check(int a){
        for(int i=0;i<8;i++){
            System.out.println(game[winpos[i][0]]+"  "+game[winpos[i][1]]+"  "+game[winpos[i][2]]);
            if(game[winpos[i][0]]!=0 && game[winpos[i][0]]==game[winpos[i][1]] && game[winpos[i][1]]==game[winpos[i][2]]){
                Toast.makeText(this, "We have a Winner !! Player"+a , Toast.LENGTH_SHORT).show();
                G=false;
                return 0;
            }
        }
        int k=0;
        for(int i=0;i<9;i++){
            if(game[i]==0){
                k++;
            }
        }
        if(k==0){
            Toast.makeText(this, "Draw !!" , Toast.LENGTH_SHORT).show();
            G=false;
            return 0;
        }
        return 0;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

}