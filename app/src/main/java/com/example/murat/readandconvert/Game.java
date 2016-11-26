package com.example.murat.readandconvert;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by murat on 07.11.2015.
 */
public class Game extends Activity{

    Button btPlay,btScore,btExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    setContentView(R.layout.game);

        setupVariable();
        onClick();


    }

    public  void  setupVariable(){

        btPlay =(Button)findViewById(R.id.BToyna);
        btScore=(Button)findViewById(R.id.BTscore);
        btExit =(Button)findViewById(R.id.BTexit);
    }

    public  void onClick(){

        btPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mp ;

                Uri path= Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.btn);
                mp =MediaPlayer.create(Game.this,path);
                mp.start();

                Intent i =new Intent(Game.this,MainActivity.class);
                startActivity(i);



            }
        });

      btScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MediaPlayer mp ;

                Uri path= Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.btn);
                mp =MediaPlayer.create(Game.this,path);
                mp.start();

                Intent i =new Intent(Game.this,Score.class);
                startActivity(i);
            }
        });

        btExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mp ;
                Uri path= Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.btn);
                mp =MediaPlayer.create(Game.this,path);
                mp.start();
                finish();
            }
        });



    }


}
