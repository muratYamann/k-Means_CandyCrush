package com.example.murat.readandconvert;

import android.os.CountDownTimer;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * Created by murat on 03.11.2015.
 */

public class RemainingTime extends CountDownTimer {
  public String hms;

  Adim1 adim =new Adim1();



        public RemainingTime(long milisInFuture, long counDownInterval){
            super(milisInFuture,counDownInterval);
        }
        @Override
        public  void onTick (long milisUntilFinished){

            long milis =milisUntilFinished;
             hms =String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(milis),
                    TimeUnit.MILLISECONDS.toMinutes(milis)-TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(milis)),
                    TimeUnit.MILLISECONDS.toSeconds(milis)-TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(milis)));


         //   tv1.setText(hms);
        }
        @Override
        public void onFinish(){
         //   tv1.setText("completed.");


    }


}
