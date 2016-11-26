package com.example.murat.readandconvert;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by murat on 02.11.2015.
 */

public class Score  extends Activity{

    Button btn1 ,btn2,btn3;

    TextView tvSaat;

    public  static  String TAG ="_Score";

    ArrayList<String>puanAl ;

    ReadToFile rd ;

    String []puanGoster ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score);
        setupVariable();

   try {

       rd =new ReadToFile();
       rd.ReadFile("score.csv");
       puanAl=rd.liste;

       puanGoster =new String[4];
       for (int y =0; y<puanAl.size();y++){
           puanGoster[y]=puanAl.get(y);
       }

       btn1.setText(puanGoster[0]);
       btn2.setText(puanGoster[1]);
       btn3.setText(puanGoster[2]);


       Calendar c =Calendar.getInstance();
       System.out.print(c);
       Log.d(TAG, "Date :" + c);
       c.getTime();
       String date =String.valueOf(c);

       String  yil =  date.substring(147, 156);
       String  saat =  date.substring(294, 296);
       String  dk  =  date.substring(305,307);
     //  String gun   = date.substring("");


       int d=date.indexOf("MINUTE");

   }catch (Exception e){}

    }















    public  void setupVariable(){

        btn1 =(Button)findViewById(R.id.BTN1);
        btn2 =(Button)findViewById(R.id.BTN2);
        btn3 =(Button)findViewById(R.id.BTN3);

        tvSaat =(TextView)findViewById(R.id.tvSaat);

        puanAl =new ArrayList<String>();

    }
}
