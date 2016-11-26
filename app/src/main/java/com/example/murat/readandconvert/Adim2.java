package com.example.murat.readandconvert;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by murat on 02.11.2015.
 */
public class Adim2 extends Activity {



    public String TAG="_Adim2";

    TextView t2,Tscore ,Ttimer;


   public  static String scoreFileName ="score.csv";

    Button btGeri;
    Button b00,b01,b02,b03,b04,b05,b10,b11,b12,b13,b14,b15,b20,b21,b22,b23,b24,b25,b30,b31;
    Button b32,b33,b34,b35,b40,b41,b42,b43,b44,b45,b50,b51,b52,b53,b54,b55,b60,b61,b62,b63,b64,b65,b70,b71,b72,b73,b74,b75,b80,b81,b82,b83,b84,b85;

    public String d00,d01,d02,d03,d04,d05,d10,d11,d12,d13,d14,d15,d20,d21,d22,d23,d24,d25;
          String d30,d31,d32,d33,d34,d35,d40,d41,d42,d43,d44,d45,d50,d51,d52,d53,d54,d55,d60,d61,d62,d63,d64,d65,d70,d71,d72,d73,d74,d75,d80,d81,d82,d83,d84,d85;

    public String t00,t01,t02,t03,t04,t05,t10,t11,t12,t13,t14,t15,t20,t21,t22,t23,t24,t25,t30,t31,t32,t33,t34,t35;
           String t40,t41,t42,t43,t44,t45,t50,t51,t52,t53,t54,t55, t60,t61,t62,t63,t64,t65,t70,t71,t72,t73,t74,t75,t80,t81,t82,t83,t84,t85;

   public String s00,s01,s02,s03,s04,s05,s10,s11,s12,s13,s14,s15,s20,s21,s22,s23,s24,s25,s30,s31,s32,s33,s34,s35;
          String s40,s41,s42,s43,s44,s45,s50,s51,s52,s53,s54,s55,s60,s61,s62,s63,s64,s65,s70,s71,s72,s73,s74,s75,s80,s81,s82,s83,s84,s85;

    ReadToFile  read1  =new ReadToFile();
    ReadToFile  read2  =new ReadToFile();
    ReadToFile  read3  =new ReadToFile();
    ReadToFile  read4  =new ReadToFile();


    Random rnd =new Random();

    ArrayList<String> liste1;
    ArrayList<String>liste2;
    ArrayList<String>liste3;
    ArrayList<String>liste4;

    ArrayList<String>listeMatris;
    ArrayList<String>liste123;


    public ArrayList<String>aPuan;

    ArrayList<String>y;
    ArrayList<String>p;
    ArrayList<String>g;

    String[] dScore ;



    int[] matrisDizi;
    int[][]matrisOyun;

    int Score =0;

    public  String line ="";
    MediaPlayer mp;
    MediaPlayer mb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adim2);
        setupVariable();
       // onClick();
        //color();

        /**Timer*/
        final CounterClas timer =new CounterClas(1500000,1000);
        timer.start();

        Uri path= Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.game);
        mp = MediaPlayer.create(Adim2.this, path);
        mp.start();

        Uri pathb= Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.btn);
        mb =MediaPlayer.create(Adim2.this,pathb);

        matrisOyun =new int[9][6];
        matrisDizi =new int[56];

        liste1 = new ArrayList<String>();
        liste2 = new ArrayList<String>();
        liste3 = new ArrayList<String>();
        liste4 = new ArrayList<String>();

        y =new ArrayList<String >();
        p =new ArrayList<String >();
        g =new ArrayList<String>();

        liste123 = new ArrayList<String>();

        listeMatris = new ArrayList<String>();

        read1.ReadFile("cluster1.csv");
        read2.ReadFile("cluster2.csv");
        read3.ReadFile("cluster3.csv");
        read4.ReadFile("cluster4.csv");

        liste1=read1.liste;
        liste2=read2.liste;
        liste3=read3.liste;
        liste4=read4.liste;

        //listelerdeki null degerini almamak için kosul koyuldu

        for ( int il=0;il<liste1.size();il++) {
            line = liste1.get(il);
            if (line.equalsIgnoreCase("null")) {
                liste1.remove(il);
            }
        }

        for (int asd =0; asd<liste1.size();asd++){
            Log.d(TAG, "liste 1 remove :"+liste1.get(asd));
        }


        for (int g=0;g<liste1.size();g++){
            if ((line =liste1.get(g))!=" "){
                y.add(line);
            }
            else break;
        }

        for ( int r=0;r<liste2.size();r++){
            if ((line=liste2.get(r))!=" "){
                p.add(line);
            }
            else break;
        }

        for ( int l=0;l<liste3.size();l++){
            if ((line=liste3.get(l))!=null){
                g.add(line);
            }
            else
                break;
        }

        for (int as=0;as<g.size();as++){
            Log.d(TAG, "g :"+g.get(as));
        }


        /**liste1 2 ve 3 teki elemanlar liste123 e eklendi */

        String a;
        for (int d =0; d<y.size();d++){
            a =y.get(d);
            if((a.equalsIgnoreCase("null")||a.equals(" ")||a.equalsIgnoreCase(null))){
                break;
            }
            else
              liste123.add(line=y.get(d));
            }


        String b;
        for(int y=0; y<p.size();y++){
            b=p.get(y);
            if((b.equalsIgnoreCase("null")||b.equals(" ")||b.equalsIgnoreCase(null))){
                break;
            }
            else
            liste123.add(p.get(y));
            }

        String c;
        for(int p=0; p<g.size();p++){
            c=g.get(p);
           // if (c!=null ||c!=""||c!="null")
           if((c.equalsIgnoreCase("null")||c.equals(" ")||c.equalsIgnoreCase(null))){
               break;
            }
            else
            liste123.add(g.get(p));
        }

        String d;
        for(int j=0; j<g.size();j++){
            d=liste4.get(j);
            // if (c!=null ||c!=""||c!="null")
            if((d.equalsIgnoreCase("null")||d.equals(" ")||d.equalsIgnoreCase(null))){
                break;
            }
            else
                liste123.add(liste4.get(j));
        }




        for(int k= 0; k<liste123.size();k++){
            Log.d(TAG, " lister123 : "+liste123.get(k));
        }

        /**listeden 36 random sayı secilip tek boyutlu bir diziye atanır*/
      //  for (int g=0; g<36; g++){
        //    matrisDizi[g]= rnd.nextInt(Integer.parseInt(liste123);
          //  Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
       // }

       /* int m1[] =new int[36];
        for (int l=0; l<36;l++){
            m1[l]=rnd.nextInt(Integer.parseInt(liste123.get(l)));
            Log.d(TAG, "m1 dizisi :"+liste123.get(l));
        }*/


        int[] rndDizi =new int[54];
        for (int j =0; j<54;j++){
            rndDizi[j]=rnd.nextInt(liste123.size());
        }

        for (int s =0; s<liste123.size();s++){

            if (s==rndDizi[0]){
                matrisDizi[0]= Integer.parseInt(liste123.get(s));
            }
            else if (s==rndDizi[1]){
                matrisDizi[1]=Integer.parseInt(liste123.get(s));
            }
            else if (s==rndDizi[2]){
                matrisDizi[2]=Integer.parseInt(liste123.get(s));
            }
            else if (s==rndDizi[3]){
                matrisDizi[3]=Integer.parseInt(liste123.get(s));
            }
            else if (s==rndDizi[4]){
                matrisDizi[4]=Integer.parseInt(liste123.get(s));
            }
            else if (s==rndDizi[5]){
                matrisDizi[5]=Integer.parseInt(liste123.get(s));
            }
            else if (s==rndDizi[6]){
                matrisDizi[6]=Integer.parseInt(liste123.get(s));
            }
            else if (s==rndDizi[7]){
                matrisDizi[7]=Integer.parseInt(liste123.get(s));
            }
            else if (s==rndDizi[8]){
                matrisDizi[8]=Integer.parseInt(liste123.get(s));
            }
            else if (s==rndDizi[9]){
                matrisDizi[9]=Integer.parseInt(liste123.get(s));
            }
            else if (s==rndDizi[10]){
                matrisDizi[10]=Integer.parseInt(liste123.get(s));
            }
            else if (s==rndDizi[11]){
                matrisDizi[11]=Integer.parseInt(liste123.get(s));
            }
            else if (s==rndDizi[12]){
                matrisDizi[12]=Integer.parseInt(liste123.get(s));
            }
            else if (s==rndDizi[13]){
                matrisDizi[13]=Integer.parseInt(liste123.get(s));
            }
            else if (s==rndDizi[14]){
                matrisDizi[14]=Integer.parseInt(liste123.get(s));
            }
            else if (s==rndDizi[15]){
                matrisDizi[15]=Integer.parseInt(liste123.get(s));
            }
            else if (s==rndDizi[16]){
                matrisDizi[16]=Integer.parseInt(liste123.get(s));
            }
            else if (s==rndDizi[17]){
                matrisDizi[17]=Integer.parseInt(liste123.get(s));
            }
            else if (s==rndDizi[18]){
                matrisDizi[18]=Integer.parseInt(liste123.get(s));
            }
            else if (s==rndDizi[19]){
                matrisDizi[19]=Integer.parseInt(liste123.get(s));
            }
            else if (s==rndDizi[20]){
                matrisDizi[20]=Integer.parseInt(liste123.get(s));
            }
            else if (s==rndDizi[21]){
                matrisDizi[21]=Integer.parseInt(liste123.get(s));
            }
            else if (s==rndDizi[22]){
                matrisDizi[22]=Integer.parseInt(liste123.get(s));
            }
            else if (s==rndDizi[23]){
                matrisDizi[23]=Integer.parseInt(liste123.get(s));
            }
            else if (s==rndDizi[24]){
                matrisDizi[24]=Integer.parseInt(liste123.get(s));
            }
            else if (s==rndDizi[25]){
                matrisDizi[25]=Integer.parseInt(liste123.get(s));
            }
            else if (s==rndDizi[26]){
                matrisDizi[26]=Integer.parseInt(liste123.get(s));
            }
            else if (s==rndDizi[27]){
                matrisDizi[27]=Integer.parseInt(liste123.get(s));
            }
            else if (s==rndDizi[28]){
                matrisDizi[28]=Integer.parseInt(liste123.get(s));
            }
            else if (s==rndDizi[29]){
                matrisDizi[29]=Integer.parseInt(liste123.get(s));
            }
            else if (s==rndDizi[30]){
                matrisDizi[30]=Integer.parseInt(liste123.get(s));
            }
            else if (s==rndDizi[31]){
                matrisDizi[31]=Integer.parseInt(liste123.get(s));
            }
            else if (s==rndDizi[32]){
                matrisDizi[32]=Integer.parseInt(liste123.get(s));
            }
            else if (s==rndDizi[33]){
                matrisDizi[33]=Integer.parseInt(liste123.get(s));
            }
            else if (s==rndDizi[34]){
                matrisDizi[34]=Integer.parseInt(liste123.get(s));
            }
            else if (s==rndDizi[35]){
                matrisDizi[35]=Integer.parseInt(liste123.get(s));
            }
            else if (s==rndDizi[36]){
                matrisDizi[36]=Integer.parseInt(liste123.get(s));
            }
            else if (s==rndDizi[37]){
                matrisDizi[37]=Integer.parseInt(liste123.get(s));
            }
            else if (s==rndDizi[38]){
                matrisDizi[38]=Integer.parseInt(liste123.get(s));
            }
            else if (s==rndDizi[39]){
                matrisDizi[39]=Integer.parseInt(liste123.get(s));
            }
            else if (s==rndDizi[40]){
                matrisDizi[40]=Integer.parseInt(liste123.get(s));
            }
            else if (s==rndDizi[41]){
                matrisDizi[41]=Integer.parseInt(liste123.get(s));
            }
            else if (s==rndDizi[42]){
                matrisDizi[43]=Integer.parseInt(liste123.get(s));
            }
            else if (s==rndDizi[44]){
                matrisDizi[44]=Integer.parseInt(liste123.get(s));
            }
            else if (s==rndDizi[45]){
                matrisDizi[45]=Integer.parseInt(liste123.get(s));
            }
            else if (s==rndDizi[46]){
                matrisDizi[46]=Integer.parseInt(liste123.get(s));
            }
            else if (s==rndDizi[47]){
                matrisDizi[47]=Integer.parseInt(liste123.get(s));
            }
            else if (s==rndDizi[48]){
                matrisDizi[48]=Integer.parseInt(liste123.get(s));
            }
            else if (s==rndDizi[49]){
                matrisDizi[49]=Integer.parseInt(liste123.get(s));
            }
            else if (s==rndDizi[50]){
                matrisDizi[50]=Integer.parseInt(liste123.get(s));
            }
            else if (s==rndDizi[51]){
                matrisDizi[51]=Integer.parseInt(liste123.get(s));
            }
            else if (s==rndDizi[52]){
                matrisDizi[52]=Integer.parseInt(liste123.get(s));
            }
            else if (s==rndDizi[53]){
                matrisDizi[53]=Integer.parseInt(liste123.get(s));
            }





        }//for dizi end


        /**matsimize 36 adet random olarak 3 kumeden gelen sayılar eklendi*/
        int k=0;
        for (int i = 0; i < matrisOyun.length; i++){
            for (int j = 0; j < matrisOyun.length; j++) {
                matrisOyun[i][j] = matrisDizi[k];
                Log.d(TAG, "matrisin  ["+i+"]"+"["+j+"]"+matrisOyun[i][j]);
                k++;
            }

        }


        b00.setText(String.valueOf(matrisOyun[0][0]));
        b01.setText(String.valueOf(matrisOyun[0][1]));
        b02.setText(String.valueOf(matrisOyun[0][2]));
        b03.setText(String.valueOf(matrisOyun[0][3]));
        b04.setText(String.valueOf(matrisOyun[0][4]));
        b05.setText(String.valueOf(matrisOyun[0][5]));
        b10.setText(String.valueOf(matrisOyun[1][0]));
        b11.setText(String.valueOf(matrisOyun[1][1]));
        b12.setText(String.valueOf(matrisOyun[1][2]));
        b13.setText(String.valueOf(matrisOyun[1][3]));
        b14.setText(String.valueOf(matrisOyun[1][4]));
        b15.setText(String.valueOf(matrisOyun[1][5]));
        b20.setText(String.valueOf(matrisOyun[2][0]));
        b21.setText(String.valueOf(matrisOyun[2][1]));
        b22.setText(String.valueOf(matrisOyun[2][2]));
        b23.setText(String.valueOf(matrisOyun[2][3]));
        b24.setText(String.valueOf(matrisOyun[2][4]));
        b25.setText(String.valueOf(matrisOyun[2][5]));
        b30.setText(String.valueOf(matrisOyun[3][0]));
        b31.setText(String.valueOf(matrisOyun[3][1]));
        b32.setText(String.valueOf(matrisOyun[3][2]));
        b33.setText(String.valueOf(matrisOyun[3][3]));
        b34.setText(String.valueOf(matrisOyun[3][4]));
        b35.setText(String.valueOf(matrisOyun[3][5]));
        b40.setText(String.valueOf(matrisOyun[4][0]));
        b41.setText(String.valueOf(matrisOyun[4][1]));
        b42.setText(String.valueOf(matrisOyun[4][2]));
        b43.setText(String.valueOf(matrisOyun[4][3]));
        b44.setText(String.valueOf(matrisOyun[4][4]));
        b45.setText(String.valueOf(matrisOyun[4][5]));
        b50.setText(String.valueOf(matrisOyun[5][0]));
        b51.setText(String.valueOf(matrisOyun[5][1]));
        b52.setText(String.valueOf(matrisOyun[5][2]));
        b53.setText(String.valueOf(matrisOyun[5][3]));
        b54.setText(String.valueOf(matrisOyun[5][4]));
        b55.setText(String.valueOf(matrisOyun[5][5]));
        b60.setText(String.valueOf(matrisOyun[6][1]));
        b61.setText(String.valueOf(matrisOyun[6][1]));
        b62.setText(String.valueOf(matrisOyun[6][2]));
        b63.setText(String.valueOf(matrisOyun[6][3]));
        b64.setText(String.valueOf(matrisOyun[6][4]));
        b65.setText(String.valueOf(matrisOyun[6][5]));
        b70.setText(String.valueOf(matrisOyun[7][0]));
        b71.setText(String.valueOf(matrisOyun[7][1]));
        b72.setText(String.valueOf(matrisOyun[7][2]));
        b73.setText(String.valueOf(matrisOyun[7][3]));
        b74.setText(String.valueOf(matrisOyun[7][4]));
        b75.setText(String.valueOf(matrisOyun[7][5]));
        b80.setText(String.valueOf(matrisOyun[8][0]));
        b81.setText(String.valueOf(matrisOyun[8][1]));
        b82.setText(String.valueOf(matrisOyun[8][2]));
        b83.setText(String.valueOf(matrisOyun[8][3]));
        b84.setText(String.valueOf(matrisOyun[8][4]));
        b85.setText(String.valueOf(matrisOyun[8][5]));



        /**diziden alınan deferlerin elemanları tek tek yazıldı*/
        d00=String.valueOf(matrisOyun[0][0]);
        d01=String.valueOf(matrisOyun[0][1]);
        d02=String.valueOf(matrisOyun[0][2]);
        d03=String.valueOf(matrisOyun[0][3]);
        d04=String.valueOf(matrisOyun[0][4]);
        d05=String.valueOf(matrisOyun[0][5]);
        d10=String.valueOf(matrisOyun[1][0]);
        d11=String.valueOf(matrisOyun[1][1]);
        d12=String.valueOf(matrisOyun[1][2]);
        d13=String.valueOf(matrisOyun[1][3]);
        d14=String.valueOf(matrisOyun[1][4]);
        d15=String.valueOf(matrisOyun[1][5]);
        d20=String.valueOf(matrisOyun[2][0]);
        d21=String.valueOf(matrisOyun[2][1]);
        d22=String.valueOf(matrisOyun[2][2]);
        d23=String.valueOf(matrisOyun[2][3]);
        d24=String.valueOf(matrisOyun[2][4]);
        d25=String.valueOf(matrisOyun[2][5]);
        d30=String.valueOf(matrisOyun[3][0]);
        d31=String.valueOf(matrisOyun[3][1]);
        d32=String.valueOf(matrisOyun[3][2]);
        d33=String.valueOf(matrisOyun[3][3]);
        d34=String.valueOf(matrisOyun[3][4]);
        d35=String.valueOf(matrisOyun[3][5]);
        d40=String.valueOf(matrisOyun[4][0]);
        d41=String.valueOf(matrisOyun[4][1]);
        d42=String.valueOf(matrisOyun[4][2]);
        d43=String.valueOf(matrisOyun[4][3]);
        d44=String.valueOf(matrisOyun[4][4]);
        d45=String.valueOf(matrisOyun[4][5]);
        d50=String.valueOf(matrisOyun[5][0]);
        d51=String.valueOf(matrisOyun[5][1]);
        d52=String.valueOf(matrisOyun[5][2]);
        d53=String.valueOf(matrisOyun[5][3]);
        d54=String.valueOf(matrisOyun[5][4]);
        d55=String.valueOf(matrisOyun[5][5]);
        d60=String.valueOf(matrisOyun[6][0]);
        d61=String.valueOf(matrisOyun[6][1]);
        d62=String.valueOf(matrisOyun[6][2]);
        d63=String.valueOf(matrisOyun[6][3]);
        d64=String.valueOf(matrisOyun[6][4]);
        d65=String.valueOf(matrisOyun[6][5]);
        d70=String.valueOf(matrisOyun[7][0]);
        d71=String.valueOf(matrisOyun[7][1]);
        d72=String.valueOf(matrisOyun[7][2]);
        d73=String.valueOf(matrisOyun[7][3]);
        d74=String.valueOf(matrisOyun[7][4]);
        d75=String.valueOf(matrisOyun[7][5]);
        d80=String.valueOf(matrisOyun[8][0]);
        d81=String.valueOf(matrisOyun[8][1]);
        d82=String.valueOf(matrisOyun[8][2]);
        d83=String.valueOf(matrisOyun[8][3]);
        d84=String.valueOf(matrisOyun[8][4]);
        d85=String.valueOf(matrisOyun[8][5]);


        /**matris elemanlarının son hanesi alınır */
        t00 =String.valueOf(matrisOyun[0][0]);
        s00 =t00.substring(t00.length() - 1);
        t01 =String.valueOf(matrisOyun[0][1]);
        s01 =t01.substring(t01.length() - 1);
        t02 =String.valueOf(matrisOyun[0][2]);
        s02 =t02.substring(t02.length() - 1);
        t03 =String.valueOf(matrisOyun[0][3]);
        s03 =t03.substring(t03.length() - 1);
        t04 =String.valueOf(matrisOyun[0][4]);
        s04 =t04.substring(t04.length() - 1);
        t05 =String.valueOf(matrisOyun[0][5]);
        s05 =t05.substring(t05.length() - 1);
        t10 =String.valueOf(matrisOyun[1][0]);
        s10 =t10.substring(t10.length() - 1);
        t11 =String.valueOf(matrisOyun[1][1]);
        s11 =t11.substring(t11.length() - 1);
        t12 =String.valueOf(matrisOyun[1][2]);
        s12 =t12.substring(t12.length() - 1);
        t13 =String.valueOf(matrisOyun[1][3]);
        s13 =t13.substring(t13.length() - 1);
        t14 =String.valueOf(matrisOyun[1][4]);
        s14 =t14.substring(t14.length() - 1);
        t15 =String.valueOf(matrisOyun[1][5]);
        s15 =t15.substring(t15.length() - 1);
        t20 =String.valueOf(matrisOyun[2][0]);
        s20 =t20.substring(t20.length() - 1);
        t21 =String.valueOf(matrisOyun[2][1]);
        s21 =t21.substring(t21.length() - 1);
        t22 =String.valueOf(matrisOyun[2][2]);
        s22 =t22.substring(t22.length() - 1);
        t23 =String.valueOf(matrisOyun[2][3]);
        s23 =t23.substring(t23.length() - 1);
        t24 =String.valueOf(matrisOyun[2][4]);
        s24 =t24.substring(t24.length() - 1);
        t25 =String.valueOf(matrisOyun[2][5]);
        s25 =t25.substring(t25.length() - 1);
        t30 =String.valueOf(matrisOyun[3][0]);
        s30 =t30.substring(t30.length() - 1);
        t31 =String.valueOf(matrisOyun[3][1]);
        s31 =t31.substring(t31.length() - 1);
        t32 =String.valueOf(matrisOyun[3][2]);
        s32 =t32.substring(t32.length() - 1);
        t33 =String.valueOf(matrisOyun[3][3]);
        s33 =t33.substring(t33.length() - 1);
        t34 =String.valueOf(matrisOyun[3][4]);
        s34 =t34.substring(t34.length() - 1);
        t35 =String.valueOf(matrisOyun[3][5]);
        s35 =t35.substring(t35.length() - 1);
        t40 =String.valueOf(matrisOyun[4][0]);
        s40 =t40.substring(t40.length() - 1);
        t41 =String.valueOf(matrisOyun[4][1]);
        s41 =t41.substring(t41.length() - 1);
        t42 =String.valueOf(matrisOyun[4][2]);
        s42 =t42.substring(t42.length() - 1);
        t43 =String.valueOf(matrisOyun[4][3]);
        s43 =t43.substring(t43.length() - 1);
        t44 =String.valueOf(matrisOyun[4][4]);
        s44 =t44.substring(t44.length() - 1);
        t45 =String.valueOf(matrisOyun[4][5]);
        s45 =t45.substring(t45.length() - 1);
        t50 =String.valueOf(matrisOyun[5][0]);
        s50 =t50.substring(t50.length() - 1);
        t51 =String.valueOf(matrisOyun[5][1]);
        s51 =t51.substring(t51.length() - 1);
        t52 =String.valueOf(matrisOyun[5][2]);
        s52 =t52.substring(t52.length() - 1);
        t53 =String.valueOf(matrisOyun[5][3]);
        s53 =t53.substring(t53.length() - 1);
        t54 =String.valueOf(matrisOyun[5][4]);
        s54 =t54.substring(t54.length() - 1);
        t55 =String.valueOf(matrisOyun[5][5]);
        s55 =t55.substring(t55.length() - 1);
        t60 =String.valueOf(matrisOyun[6][0]);
        s60 =s60.substring(t60.length() - 1);
        t61 =String.valueOf(matrisOyun[6][1]);
        s61 =t61.substring(t61.length() - 1);
        t62 =String.valueOf(matrisOyun[6][2]);
        s62 =t62.substring(t62.length() - 1);
        t63 =String.valueOf(matrisOyun[6][3]);
        s63 =t63.substring(t63.length() - 1);
        t64 =String.valueOf(matrisOyun[6][4]);
        s64 =t64.substring(t64.length() - 1);
        t65 =String.valueOf(matrisOyun[6][5]);
        s65 =t65.substring(t65.length() - 1);
        t70 =String.valueOf(matrisOyun[7][0]);
        s70 =t70.substring(t70.length() - 1);
        t71 =String.valueOf(matrisOyun[7][1]);
        s71 =t71.substring(t71.length() - 1);
        t72 =String.valueOf(matrisOyun[7][2]);
        s72 =t72.substring(t72.length() - 1);
        t73 =String.valueOf(matrisOyun[7][3]);
        s73 =t73.substring(t73.length() - 1);
        t74 =String.valueOf(matrisOyun[7][4]);
        s74 =t74.substring(t74.length() - 1);
        t75 =String.valueOf(matrisOyun[7][5]);
        s75 =t75.substring(t75.length() - 1);
        t80 =String.valueOf(matrisOyun[8][0]);
        s80 =t80.substring(t80.length() - 1);
        t81 =String.valueOf(matrisOyun[8][1]);
        s81 =t81.substring(t81.length() - 1);
        t82 =String.valueOf(matrisOyun[8][2]);
        s82 =t82.substring(t82.length() - 1);
        t53 =String.valueOf(matrisOyun[8][3]);
        s83 =t83.substring(t83.length() - 1);
        t84 =String.valueOf(matrisOyun[8][4]);
        s84 =t84.substring(t84.length() - 1);
        t85 =String.valueOf(matrisOyun[8][5]);
        s85 =t85.substring(t85.length() - 1);



        if (s00.equals("1")) {
            b00.setBackgroundResource(R.drawable.futball);
        }else if(s00.equals("2")){
            b00.setBackgroundResource(R.drawable.basket);
        }else if (s00.equals("3"))
        {
            b00.setBackgroundResource(R.drawable.hentball);
        }
        else if (s00.equals("4"))
        {
            b00.setBackgroundResource(R.drawable.hentball);
        }
        else if (s00.equals("5"))
        {
            b00.setBackgroundResource(R.drawable.hentball);
        }

        if (s01.equals("1")) {
            b01.setBackgroundResource(R.drawable.futball);
        }else if(s01.equals("2")){
            b01.setBackgroundResource(R.drawable.basket);
        }else if (s01.equals("3"))
        {
            b01.setBackgroundResource(R.drawable.hentball);
        }
        else if (s01.equals("4"))
        {
            b01.setBackgroundResource(R.drawable.hentball);
        }
        else if (s01.equals("5"))
        {
            b01.setBackgroundResource(R.drawable.hentball);
        }


        if (s03.equals("1")) {
            b03.setBackgroundResource(R.drawable.futball);
        }else if(s03.equals("2")){
            b03.setBackgroundResource(R.drawable.basket);
        }else if (s03.equals("3"))
        {
            b03.setBackgroundResource(R.drawable.hentball);
        }
        else if (s03.equals("4"))
        {
            b03.setBackgroundResource(R.drawable.hentball);
        }
        else if (s03.equals("5"))
        {
            b03.setBackgroundResource(R.drawable.hentball);
        }

        if (s02.equals("1")) {
            b02.setBackgroundResource(R.drawable.futball);
        }else if(s02.equals("2")){
            b00.setBackgroundResource(R.drawable.basket);
        }else if (s02.equals("3"))
        {
            b02.setBackgroundResource(R.drawable.hentball);
        }
        else if (s02.equals("4"))
        {
            b02.setBackgroundResource(R.drawable.hentball);
        }
        else if (s02.equals("5"))
        {
            b02.setBackgroundResource(R.drawable.hentball);
        }


        if (s04.equals("1")) {
            b04.setBackgroundResource(R.drawable.futball);
        }else if(s04.equals("2")){
            b04.setBackgroundResource(R.drawable.basket);
        }else if (s04.equals("3"))
        {
            b04.setBackgroundResource(R.drawable.hentball);
        }
        else if (s04.equals("4"))
        {
            b04.setBackgroundResource(R.drawable.hentball);
        }
        else if (s04.equals("5"))
        {
            b04.setBackgroundResource(R.drawable.hentball);
        }


        if (s05.equals("1")) {
            b05.setBackgroundResource(R.drawable.futball);
        }else if(s00.equals("2")){
            b05.setBackgroundResource(R.drawable.basket);
        }else if (s00.equals("3"))
        {
            b05.setBackgroundResource(R.drawable.hentball);
        }
        else if (s00.equals("4"))
        {
            b05.setBackgroundResource(R.drawable.hentball);
        }
        else if (s00.equals("5"))
        {
            b05.setBackgroundResource(R.drawable.hentball);
        }


        if (s10.equals("1")) {
            b10.setBackgroundResource(R.drawable.futball);
        }else if(s10.equals("2")){
            b10.setBackgroundResource(R.drawable.basket);
        }else if (s10.equals("3"))
        {
            b10.setBackgroundResource(R.drawable.hentball);
        }
        else if (s00.equals("4"))
        {
            b10.setBackgroundResource(R.drawable.hentball);
        }
        else if (s10.equals("5"))
        {
            b10.setBackgroundResource(R.drawable.hentball);

        }


        if (s11.equals("1")) {
            b11.setBackgroundResource(R.drawable.futball);
        }else if(s11.equals("2")){
            b11.setBackgroundResource(R.drawable.basket);
        }else if (s11.equals("3"))
        {
            b11.setBackgroundResource(R.drawable.hentball);
        }
        else if (s11.equals("4"))
        {
            b11.setBackgroundResource(R.drawable.hentball);
        }
        else if (s11.equals("5"))
        {
            b11.setBackgroundResource(R.drawable.hentball);
        }


        if (s12.equals("1")) {
            b12.setBackgroundResource(R.drawable.futball);
        }else if(s12.equals("2")){
            b12.setBackgroundResource(R.drawable.basket);
        }else if (s12.equals("3"))
        {
            b12.setBackgroundResource(R.drawable.hentball);
        }
        else if (s12.equals("4"))
        {
            b12.setBackgroundResource(R.drawable.hentball);
        }
        else if (s12.equals("5"))
        {
            b12.setBackgroundResource(R.drawable.hentball);
        }


        if (s13.equals("1")) {
            b13.setBackgroundResource(R.drawable.futball);
        }else if(s13.equals("2")){
            b00.setBackgroundResource(R.drawable.basket);
        }else if (s13.equals("3"))
        {
            b13.setBackgroundResource(R.drawable.hentball);
        }
        else if (s13.equals("4"))
        {
            b13.setBackgroundResource(R.drawable.hentball);
        }
        else if (s13.equals("5"))
        {
            b13.setBackgroundResource(R.drawable.hentball);
        }


        if (s14.equals("1")) {
            b14.setBackgroundResource(R.drawable.futball);
        }else if(s14.equals("2")){
            b14.setBackgroundResource(R.drawable.basket);
        }else if (s14.equals("3"))
        {
            b14.setBackgroundResource(R.drawable.hentball);
        }
        else if (s14.equals("4"))
        {
            b14.setBackgroundResource(R.drawable.hentball);
        }
        else if (s14.equals("5"))
        {
            b14.setBackgroundResource(R.drawable.hentball);
        }


        if (s15.equals("1")) {
            b15.setBackgroundResource(R.drawable.futball);
        }else if(s15.equals("2")){
            b15.setBackgroundResource(R.drawable.basket);
        }else if (s15.equals("3"))
        {
            b15.setBackgroundResource(R.drawable.hentball);
        }
        else if (s15.equals("4"))
        {
            b15.setBackgroundResource(R.drawable.hentball);
        }
        else if (s15.equals("5"))
        {
            b15.setBackgroundResource(R.drawable.hentball);
        }

        if (s20.equals("1")) {
            b20.setBackgroundResource(R.drawable.futball);
        }else if(s20.equals("2")){
            b20.setBackgroundResource(R.drawable.basket);
        }else if (s20.equals("3"))
        {
            b20.setBackgroundResource(R.drawable.hentball);
        }
        else if (s20.equals("4"))
        {
            b20.setBackgroundResource(R.drawable.hentball);
        }
        else if (s20.equals("5"))
        {
            b20.setBackgroundResource(R.drawable.hentball);
        }


        if (s21.equals("1")) {
            b21.setBackgroundResource(R.drawable.futball);
        }else if(s21.equals("2")){
            b21.setBackgroundResource(R.drawable.basket);
        }else if (s21.equals("3"))
        {
            b21.setBackgroundResource(R.drawable.hentball);
        }
        else if (s21.equals("4"))
        {
            b21.setBackgroundResource(R.drawable.hentball);
        }
        else if (s21.equals("5"))
        {
            b21.setBackgroundResource(R.drawable.hentball);
        }


        if (s22.equals("1")) {
            b22.setBackgroundResource(R.drawable.futball);
        }else if(s22.equals("2")){
            b22.setBackgroundResource(R.drawable.basket);
        }else if (s22.equals("3"))
        {
            b22.setBackgroundResource(R.drawable.hentball);
        }
        else if (s22.equals("4"))
        {
            b22.setBackgroundResource(R.drawable.hentball);
        }
        else if (s22.equals("5"))
        {
            b22.setBackgroundResource(R.drawable.hentball);
        }


        if (s23.equals("1")) {
            b23.setBackgroundResource(R.drawable.futball);
        }else if(s23.equals("2")){
            b23.setBackgroundResource(R.drawable.basket);
        }else if (s23.equals("3"))
        {
            b23.setBackgroundResource(R.drawable.hentball);
        }
        else if (s23.equals("4"))
        {
            b23.setBackgroundResource(R.drawable.hentball);
        }
        else if (s23.equals("5"))
        {
            b23.setBackgroundResource(R.drawable.hentball);
        }


        if (s24.equals("1")) {
            b24.setBackgroundResource(R.drawable.futball);
        }else if(s24.equals("2")){
            b24.setBackgroundResource(R.drawable.basket);
        }else if (s24.equals("3"))
        {
            b24.setBackgroundResource(R.drawable.hentball);
        }
        else if (s24.equals("4"))
        {
            b24.setBackgroundResource(R.drawable.hentball);
        }
        else if (s24.equals("5"))
        {
            b24.setBackgroundResource(R.drawable.hentball);
        }

        if (s25.equals("1")) {
            b25.setBackgroundResource(R.drawable.futball);
        }else if(s25.equals("2")){
            b25.setBackgroundResource(R.drawable.basket);
        }else if (s25.equals("3"))
        {
            b25.setBackgroundResource(R.drawable.hentball);
        }
        else if (s25.equals("4"))
        {
            b25.setBackgroundResource(R.drawable.hentball);
        }
        else if (s25.equals("5"))
        {
            b25.setBackgroundResource(R.drawable.hentball);
        }

        if (s30.equals("1")) {
            b30.setBackgroundResource(R.drawable.futball);
        }else if(s30.equals("2")){
            b30.setBackgroundResource(R.drawable.basket);
        }else if (s30.equals("3"))
        {
            b30.setBackgroundResource(R.drawable.hentball);
        }
        else if (s30.equals("4"))
        {
            b30.setBackgroundResource(R.drawable.hentball);
        }
        else if (s30.equals("5"))
        {
            b30.setBackgroundResource(R.drawable.hentball);
        } //t2.setText(s00);

        if (s31.equals("1")) {
            b31.setBackgroundResource(R.drawable.futball);
        }else if(s31.equals("2")){
            b15.setBackgroundResource(R.drawable.basket);
        }else if (s31.equals("3"))
        {
            b31.setBackgroundResource(R.drawable.hentball);
        }
        else if (s31.equals("4"))
        {
            b31.setBackgroundResource(R.drawable.hentball);
        }
        else if (s31.equals("5"))
        {
            b31.setBackgroundResource(R.drawable.hentball);
        }

        if (s32.equals("1")) {
            b32.setBackgroundResource(R.drawable.futball);
        }else if(s32.equals("2")){
            b32.setBackgroundResource(R.drawable.basket);
        }else if (s32.equals("3"))
        {
            b32.setBackgroundResource(R.drawable.hentball);
        }
        else if (s32.equals("4"))
        {
            b32.setBackgroundResource(R.drawable.hentball);
        }
        else if (s32.equals("5"))
        {
            b32.setBackgroundResource(R.drawable.hentball);
        }


        if (s33.equals("1")) {
            b33.setBackgroundResource(R.drawable.futball);
        }else if(s33.equals("2")){
            b33.setBackgroundResource(R.drawable.basket);
        }else if (s33.equals("3"))
        {
            b33.setBackgroundResource(R.drawable.hentball);
        }
        else if (s33.equals("4"))
        {
            b33.setBackgroundResource(R.drawable.hentball);
        }
        else if (s33.equals("5"))
        {
            b33.setBackgroundResource(R.drawable.hentball);
        }


        if (s34.equals("1")) {
            b34.setBackgroundResource(R.drawable.futball);
        }else if(s34.equals("2")){
            b34.setBackgroundResource(R.drawable.basket);
        }else if (s34.equals("3"))
        {
            b34.setBackgroundResource(R.drawable.hentball);
        }
        else if (s34.equals("4"))
        {
            b34.setBackgroundResource(R.drawable.hentball);
        }
        else if (s34.equals("5"))
        {
            b34.setBackgroundResource(R.drawable.hentball);
        }

        if (s35.equals("1")) {
            b35.setBackgroundResource(R.drawable.futball);
        }else if(s35.equals("2")){
            b35.setBackgroundResource(R.drawable.basket);
        }else if (s35.equals("3"))
        {
            b35.setBackgroundResource(R.drawable.hentball);
        }
        else if (s35.equals("4"))
        {
            b35.setBackgroundResource(R.drawable.hentball);
        }
        else if (s35.equals("5"))
        {
            b35.setBackgroundResource(R.drawable.hentball);
        }


        if (s40.equals("1")) {
            b40.setBackgroundResource(R.drawable.futball);
        }else if(s40.equals("2")){
            b40.setBackgroundResource(R.drawable.basket);
        }else if (s40.equals("3"))
        {
            b40.setBackgroundResource(R.drawable.hentball);
        }
        else if (s40.equals("4"))
        {
            b40.setBackgroundResource(R.drawable.hentball);
        }
        else if (s40.equals("5"))
        {
            b40.setBackgroundResource(R.drawable.hentball);
        } //t2.setText(s00);

        if (s41.equals("1")) {
            b41.setBackgroundResource(R.drawable.futball);
        }else if(s41.equals("2")){
            b41.setBackgroundResource(R.drawable.basket);
        }else if (s41.equals("3"))
        {
            b41.setBackgroundResource(R.drawable.hentball);
        }
        else if (s41.equals("4"))
        {
            b41.setBackgroundResource(R.drawable.hentball);
        }
        else if (s41.equals("5"))
        {
            b41.setBackgroundResource(R.drawable.hentball);
        }

        if (s42.equals("1")) {
            b42.setBackgroundResource(R.drawable.futball);
        }else if(s42.equals("2")){
            b42.setBackgroundResource(R.drawable.basket);
        }else if (s42.equals("3"))
        {
            b42.setBackgroundResource(R.drawable.hentball);
        }
        else if (s42.equals("4"))
        {
            b42.setBackgroundResource(R.drawable.hentball);
        }
        else if (s42.equals("5"))
        {
            b42.setBackgroundResource(R.drawable.hentball);
        }


        if (s43.equals("1")) {
            b43.setBackgroundResource(R.drawable.futball);
        }else if(s43.equals("2")){
            b43.setBackgroundResource(R.drawable.basket);
        }else if (s43.equals("3"))
        {
            b43.setBackgroundResource(R.drawable.hentball);
        }
        else if (s43.equals("4"))
        {
            b43.setBackgroundResource(R.drawable.hentball);
        }
        else if (s43.equals("5"))
        {
            b43.setBackgroundResource(R.drawable.hentball);
        }

        if (s44.equals("1")) {
            b44.setBackgroundResource(R.drawable.futball);
        }else if(s44.equals("2")){
            b44.setBackgroundResource(R.drawable.basket);
        }else if (s44.equals("3"))
        {
            b44.setBackgroundResource(R.drawable.hentball);
        }
        else if (s44.equals("4"))
        {
            b44.setBackgroundResource(R.drawable.hentball);
        }
        else if (s44.equals("5"))
        {
            b44.setBackgroundResource(R.drawable.hentball);
        }


        if (s45.equals("1")) {
            b45.setBackgroundResource(R.drawable.futball);
        }else if(s45.equals("2")){
            b45.setBackgroundResource(R.drawable.basket);
        }else if (s45.equals("3"))
        {
            b45.setBackgroundResource(R.drawable.hentball);
        }
        else if (s45.equals("4"))
        {
            b45.setBackgroundResource(R.drawable.hentball);
        }
        else if (s45.equals("5"))
        {
            b45.setBackgroundResource(R.drawable.hentball);
        }


        if (s50.equals("1")) {
            b50.setBackgroundResource(R.drawable.futball);
        }else if(s50.equals("2")){
            b50.setBackgroundResource(R.drawable.basket);
        }else if (s50.equals("3"))
        {
            b50.setBackgroundResource(R.drawable.hentball);
        }
        else if (s50.equals("4"))
        {
            b50.setBackgroundResource(R.drawable.hentball);
        }
        else if (s50.equals("5"))
        {
            b50.setBackgroundResource(R.drawable.hentball);
        }

        if (s51.equals("1")) {
            b51.setBackgroundResource(R.drawable.futball);
        }else if(s51.equals("2")){
            b51.setBackgroundResource(R.drawable.basket);
        }else if (s51.equals("3"))
        {
            b51.setBackgroundResource(R.drawable.hentball);
        }
        else if (s51.equals("4"))
        {
            b51.setBackgroundResource(R.drawable.hentball);
        }
        else if (s51.equals("5"))
        {
            b51.setBackgroundResource(R.drawable.hentball);
        }


        if (s52.equals("1")) {
            b52.setBackgroundResource(R.drawable.futball);
        }else if(s52.equals("2")){
            b52.setBackgroundResource(R.drawable.basket);
        }else if (s52.equals("3"))
        {
            b52.setBackgroundResource(R.drawable.hentball);
        }
        else if (s52.equals("4"))
        {
            b52.setBackgroundResource(R.drawable.hentball);
        }
        else if (s52.equals("5"))
        {
            b52.setBackgroundResource(R.drawable.hentball);
        }


        if (s53.equals("1")) {
            b53.setBackgroundResource(R.drawable.futball);
        }else if(s53.equals("2")){
            b53.setBackgroundResource(R.drawable.basket);
        }else if (s53.equals("3"))
        {
            b53.setBackgroundResource(R.drawable.hentball);
        }
        else if (s53.equals("4"))
        {
            b53.setBackgroundResource(R.drawable.hentball);
        }
        else if (s53.equals("5"))
        {
            b53.setBackgroundResource(R.drawable.hentball);
        }


        if (s54.equals("1")) {
            b54.setBackgroundResource(R.drawable.futball);
        }else if(s54.equals("2")){
            b54.setBackgroundResource(R.drawable.basket);
        }else if (s54.equals("3"))
        {
            b54.setBackgroundResource(R.drawable.hentball);
        }
        else if (s54.equals("4"))
        {
            b54.setBackgroundResource(R.drawable.hentball);
        }
        else if (s54.equals("5"))
        {
            b54.setBackgroundResource(R.drawable.hentball);
        }



        if (s55.equals("1")) {
            b55.setBackgroundResource(R.drawable.futball);
        }else if(s55.equals("2")){
            b55.setBackgroundResource(R.drawable.basket);
        }else if (s55.equals("3"))
        {
            b55.setBackgroundResource(R.drawable.hentball);
        }
        else if (s55.equals("4"))
        {
            b55.setBackgroundResource(R.drawable.hentball);
        }
        else if (s55.equals("5"))
        {
            b55.setBackgroundResource(R.drawable.hentball);
        }








        /**---------1.satır baslangıcı--------------------------------------------------------------------------*/
        b00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
       mb.start();

                if (s00.equals(s20)&&s20.equals(s30))
                {
                    Log.d(TAG, "b00 click");
                    int [][]matrisTemp=new int[1][1];
                    matrisTemp[0][0] =matrisOyun[0][0];
                    matrisOyun[0][0] =matrisOyun[0][1];
                    matrisOyun[0][1] =matrisTemp[0][0];
                    b00.setText(String.valueOf(matrisOyun[0][0]));

                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b01.setText(String.valueOf(matrisYeni[0]));
                    b02.setText(String.valueOf(matrisYeni[1]));
                    b03.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));

                    t2.setText(s00 + "  " + s01 + "  " + s02 +"  "+s03 + "  "+s04 +"  "+s05 +"\n" +
                            s10 + "  " + s11 + "  " + s12 +"  "+s13 + "  "+s14 +"  "+s15 + "\n" +
                            s20 + "  " + s21 + "  " + s22 +"  "+s23 + "  "+s24 +"  "+s25 +"\n" +
                            s30 + "  " + s31 + "  " + s32 +"  "+s33 + "  "+s34 +"  "+s35 + "\n" +
                            s40 + "  " + s41 + "  " + s42 +"  "+s43 + "  "+s44 +"  "+s45 +"\n" +
                            s50 + "  " + s51 + "  " + s52 +"  "+s53 + "  "+s54 +"  "+s55 );


                }
                else if (s00.equals(s02)&&s02.equalsIgnoreCase(s03)){

                    Log.d(TAG, "b00 click");
                    int [][]matrisTemp=new int[1][1];
                    matrisTemp[0][0] =matrisOyun[0][0];
                    matrisOyun[0][0] =matrisOyun[1][0];
                    matrisOyun[1][0] =matrisTemp[0][0];
                    b00.setText(String.valueOf(matrisOyun[1][0]));

                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b10.setText(String.valueOf(matrisYeni[0]));
                    b20.setText(String.valueOf(matrisYeni[1]));
                    b30.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }
                else if(s00.equals(s11)&&s11.equals(s12)){

                    Log.d(TAG, "b00 click");
                    int [][]matrisTemp=new int[1][1];
                    matrisTemp[0][0] =matrisOyun[0][0];
                    matrisOyun[0][0] =matrisOyun[1][0];
                    matrisOyun[1][0] =matrisTemp[0][0];
                    b00.setText(String.valueOf(matrisOyun[0][0]));

                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b10.setText(String.valueOf(matrisYeni[0]));
                    b11.setText(String.valueOf(matrisYeni[1]));
                    b12.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));



                }

                else if (s00.equals(s01)&&s01.equals(s02)){

                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b00.setText(String.valueOf(matrisYeni[0]));
                    b01.setText(String.valueOf(matrisYeni[1]));
                    b02.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));

                }
                else  if(s00.equals(s10)&&s10.equals(s20)){
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b00.setText(String.valueOf(matrisYeni[0]));
                    b10.setText(String.valueOf(matrisYeni[1]));
                    b20.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }

                else {
                    Toast.makeText(getApplicationContext(),"dikkatli bak ",Toast.LENGTH_SHORT).show();
                }

            }
        });




        /**b01 click */
        b01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

             mb.start();

               if (s01.equals(s03)&&s03.equals(s04))
                {
                    Log.d(TAG, "b01 click");
                    int [][]matrisTemp=new int[1][1];
                    matrisTemp[0][0] =matrisOyun[0][1];
                    matrisOyun[0][1] =matrisOyun[0][2];
                    matrisOyun[0][2] =matrisTemp[0][0];
                    b01.setText(String.valueOf(matrisOyun[0][1]));

                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b02.setText(String.valueOf(matrisYeni[0]));
                    b03.setText(String.valueOf(matrisYeni[1]));
                    b04.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }

              else if (s01.equals(s21)&&s21.equals(s31)){

                    Log.d(TAG, "b00 click");
                    int  [][]matrisTemp=new int[1][1];
                    matrisTemp[0][0] =matrisOyun[0][1];
                    matrisOyun[0][1] =matrisOyun[1][1];
                    matrisOyun[1][1] =matrisTemp[0][0];
                    b01.setText(String.valueOf(matrisOyun[0][1]));

                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b11.setText(String.valueOf(matrisYeni[0]));
                    b21.setText(String.valueOf(matrisYeni[1]));
                    b31.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }



               else if (s01.equals(s12)&&s12.equals(s13)){

                   Log.d(TAG, "b00 click");
                   int  [][]matrisTemp=new int[1][1];
                   matrisTemp[0][0] =matrisOyun[0][1];
                   matrisOyun[0][1] =matrisOyun[1][1];
                   matrisOyun[1][1] =matrisTemp[0][0];
                   b01.setText(String.valueOf(matrisOyun[0][1]));

                   /**silinen elemanlar icin yeni deger bulup atama random */
                   int []matrisYeni =new int[3];
                   for (int g=0; g<3; g++){
                       matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                       Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                   }
                   b01.setText(String.valueOf(matrisYeni[0]));
                   b12.setText(String.valueOf(matrisYeni[1]));
                   b13.setText(String.valueOf(matrisYeni[2]));

                   Score +=5;
                   Tscore.setText(String.valueOf("Score :"+Score));
               }


               else if (s01.equals(s02)&&s02.equals(s03)){

                   int []matrisYeni =new int[3];
                   for (int g=0; g<3; g++){
                       matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                       Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                   }
                   b01.setText(String.valueOf(matrisYeni[0]));
                   b02.setText(String.valueOf(matrisYeni[1]));
                   b03.setText(String.valueOf(matrisYeni[2]));

                   Score +=5;
                   Tscore.setText(String.valueOf("Score :"+Score));

               }
               else  if (s01.equals(s11)&&s11.equals(s21)){
                   int []matrisYeni =new int[3];
                   for (int g=0; g<3; g++){
                       matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                       Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                   }
                   b01.setText(String.valueOf(matrisYeni[0]));
                   b11.setText(String.valueOf(matrisYeni[1]));
                   b21.setText(String.valueOf(matrisYeni[2]));

                   Score +=5;
                   Tscore.setText(String.valueOf("Score :"+Score));

               }
                else {
                    Toast.makeText(getApplicationContext(),"dikkatli bak ",Toast.LENGTH_SHORT).show();
                }

            }
        });



        /**b02 click */
        b02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //1
                mb.start();
                if (s02.equals(s04)&&s04.equals(s05))
                {
                    Log.d(TAG, "b02 click");
                    int [][]matrisTemp=new int[1][1];

                    matrisTemp[0][0] =matrisOyun[0][2];
                    matrisOyun[0][2] =matrisOyun[0][3];
                    matrisOyun[0][3] =matrisTemp[0][0];
                    b02.setText(String.valueOf(matrisOyun[0][2]));

                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b03.setText(String.valueOf(matrisYeni[0]));
                    b04.setText(String.valueOf(matrisYeni[1]));
                    b05.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }
                //2
                else if (s02.equals(s22)&&s22.equals(s32)){

                    Log.d(TAG, "b02 click");
                    int  [][]matrisTemp=new int[1][1];
                    matrisTemp[0][0] =matrisOyun[0][2];
                    matrisOyun[0][2] =matrisOyun[1][2];
                    matrisOyun[1][2] =matrisTemp[0][0];

                    b02.setText(String.valueOf(matrisOyun[0][2]));

                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b12.setText(String.valueOf(matrisYeni[0]));
                    b22.setText(String.valueOf(matrisYeni[1]));
                    b32.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }
                //3
                else if (s02.equals(s13)&&s13.equals(s14)){

                    Log.d(TAG, "b00 click");
                    int  [][]matrisTemp=new int[1][1];
                    matrisTemp[0][0] =matrisOyun[0][2];
                    matrisOyun[0][2] =matrisOyun[1][2];
                    matrisOyun[1][2] =matrisTemp[0][0];

                    b02.setText(String.valueOf(matrisOyun[0][2]));

                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b12.setText(String.valueOf(matrisYeni[0]));
                    b13.setText(String.valueOf(matrisYeni[1]));
                    b14.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));

                }
                //4
                else if (s02.equals(s11)&&s11.equals(s10)){

                    Log.d(TAG, "b00 click");
                    int  [][]matrisTemp=new int[1][1];
                    matrisTemp[0][0] =matrisOyun[0][2];
                    matrisOyun[0][2] =matrisOyun[1][2];
                    matrisOyun[1][2] =matrisTemp[0][0];

                    b02.setText(String.valueOf(matrisOyun[0][2]));

                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b12.setText(String.valueOf(matrisYeni[0]));
                    b11.setText(String.valueOf(matrisYeni[1]));
                    b10.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }
                //5
                else  if (s02.equals(s03)&&s03.equals(s04)){
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b02.setText(String.valueOf(matrisYeni[0]));
                    b03.setText(String.valueOf(matrisYeni[1]));
                    b04.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }
                //6
                else  if (s02.equals(s01)&&s01.equals(s00)){
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b02.setText(String.valueOf(matrisYeni[0]));
                    b01.setText(String.valueOf(matrisYeni[1]));
                    b00.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));

                }
                //7
                else if (s02.equals(s12)&&s12.equals(s22)){

                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b02.setText(String.valueOf(matrisYeni[0]));
                    b12.setText(String.valueOf(matrisYeni[1]));
                    b22.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }
                //8
                else if(s02.equals(s01)&&s01.equals(s03)){

                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b02.setText(String.valueOf(matrisYeni[0]));
                    b01.setText(String.valueOf(matrisYeni[1]));
                    b03.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));

                }
                //9
                else {
                    Toast.makeText(getApplicationContext(),"dikkatli bak ",Toast.LENGTH_SHORT).show();
                }

            }
        });



        /**b03 click */
        b03.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
              mb.start();
               //1
                if (s03.equals(s01)&&s01.equals(s00))
                {
                    Log.d(TAG, "b03 click");
                     int [][]matrisTemp=new int[1][1];

                    matrisTemp[0][0] =matrisOyun[0][3];
                    matrisOyun[0][3] =matrisOyun[0][2];
                    matrisOyun[0][2] =matrisTemp[0][0];
                    b03.setText(String.valueOf(matrisOyun[0][3]));

                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b02.setText(String.valueOf(matrisYeni[0]));
                    b01.setText(String.valueOf(matrisYeni[1]));
                    b00.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }
                 //2
                else if (s03.equals(s23)&&s23.equals(s33)){

                    Log.d(TAG, "b03 click");
                    int  [][]matrisTemp=new int[1][1];
                    matrisTemp[0][0] =matrisOyun[0][3];
                    matrisOyun[0][3] =matrisOyun[1][3];
                    matrisOyun[1][3] =matrisTemp[0][0];

                    b03.setText(String.valueOf(matrisOyun[0][3]));

                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b13.setText(String.valueOf(matrisYeni[0]));
                    b23.setText(String.valueOf(matrisYeni[1]));
                    b33.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }

                //3
                else if (s02.equals(s03)&&s03.equals(s04)){

                    Log.d(TAG, "b03 click");
                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b02.setText(String.valueOf(matrisYeni[0]));
                    b03.setText(String.valueOf(matrisYeni[1]));
                    b04.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }

                //4
                else if (s03.equals(s12)&&s12.equals(s11)){

                    Log.d(TAG, "b03 click");
                    int  [][]matrisTemp=new int[1][1];
                    matrisTemp[0][0] =matrisOyun[0][3];
                    matrisOyun[0][3] =matrisOyun[1][3];
                    matrisOyun[1][3] =matrisTemp[0][0];

                    b03.setText(String.valueOf(matrisOyun[0][3]));

                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b03.setText(String.valueOf(matrisYeni[0]));
                    b12.setText(String.valueOf(matrisYeni[1]));
                    b11.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }


                //5
                else if (s03.equals(s14)&&s14.equals(s15)){

                    Log.d(TAG, "b03 click");
                    int  [][]matrisTemp=new int[1][1];
                    matrisTemp[0][0] =matrisOyun[0][3];
                    matrisOyun[0][3] =matrisOyun[1][3];
                    matrisOyun[1][3] =matrisTemp[0][0];

                    b03.setText(String.valueOf(matrisOyun[0][3]));

                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b13.setText(String.valueOf(matrisYeni[0]));
                    b14.setText(String.valueOf(matrisYeni[1]));
                    b15.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }

                //5
                else if (s03.equals(s13)&&s13.equals(s23)){

                    Log.d(TAG, "b03 click");

                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b03.setText(String.valueOf(matrisYeni[0]));
                    b13.setText(String.valueOf(matrisYeni[1]));
                    b23.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }

                //6
                else if (s03.equals(s04)&&s04.equals(s05)){

                    Log.d(TAG, "b03 click");

                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b03.setText(String.valueOf(matrisYeni[0]));
                    b04.setText(String.valueOf(matrisYeni[1]));
                    b05.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }


                //7
                else if (s03.equals(s02)&&s02.equals(s01)){

                    Log.d(TAG, "b03 click");

                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b03.setText(String.valueOf(matrisYeni[0]));
                    b02.setText(String.valueOf(matrisYeni[1]));
                    b01.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }

                else {
                    Toast.makeText(getApplicationContext(),"dikkatli bak ",Toast.LENGTH_SHORT).show();
                }

            }
        });





        /**b04 click */
        b04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 //1
                mb.start();
                if (s04.equals(s02)&&s02.equals(s01))
                {
                    Log.d(TAG, "b01 click");
                    int [][]matrisTemp=new int[1][1];

                    matrisTemp[0][0] =matrisOyun[0][4];
                    matrisOyun[0][4] =matrisOyun[0][3];
                    matrisOyun[0][3] =matrisTemp[0][0];
                    b04.setText(String.valueOf(matrisOyun[0][4]));

                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b03.setText(String.valueOf(matrisYeni[0]));
                    b02.setText(String.valueOf(matrisYeni[1]));
                    b01.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }
                   //2
                else if (s04.equals(s24)&&s24.equals(s34)){

                    Log.d(TAG, "b00 click");
                    int  [][]matrisTemp=new int[1][1];
                    matrisTemp[0][0] =matrisOyun[0][4];
                    matrisOyun[0][4] =matrisOyun[1][4];
                    matrisOyun[1][4] =matrisTemp[0][0];

                    b04.setText(String.valueOf(matrisOyun[0][4]));

                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b14.setText(String.valueOf(matrisYeni[0]));
                    b24.setText(String.valueOf(matrisYeni[1]));
                    b34.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }

                //3
                else if (s04.equals(s14)&&s14.equals(s24)){


                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b04.setText(String.valueOf(matrisYeni[0]));
                    b14.setText(String.valueOf(matrisYeni[1]));
                    b24.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }

                //4
                else if (s03.equals(s04)&&s24.equals(s05)){


                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b14.setText(String.valueOf(matrisYeni[0]));
                    b24.setText(String.valueOf(matrisYeni[1]));
                    b34.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }

                //5
                else if (s04.equals(s13)&&s13.equals(s12)){

                    Log.d(TAG, "b00 click");
                    int  [][]matrisTemp=new int[1][1];
                    matrisTemp[0][0] =matrisOyun[0][4];
                    matrisOyun[0][4] =matrisOyun[1][4];
                    matrisOyun[1][4] =matrisTemp[0][0];

                    b04.setText(String.valueOf(matrisOyun[0][4]));

                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b04.setText(String.valueOf(matrisYeni[0]));
                    b13.setText(String.valueOf(matrisYeni[1]));
                    b12.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }
                 //6
                else if (s04.equals(s03)&&s03.equals(s02)){

                    Log.d(TAG, "b04 click");
                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b04.setText(String.valueOf(matrisYeni[0]));
                    b03.setText(String.valueOf(matrisYeni[1]));
                    b02.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }

                else {
                    Toast.makeText(getApplicationContext(),"dikkatli bak ",Toast.LENGTH_SHORT).show();
                }

            }
        });



        /**b05 click */
        b05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        mb.start();
                if (s05.equals(s03)&&s03.equals(s02))
                {
                    Log.d(TAG, "b01 click");
                    int [][]matrisTemp=new int[1][1];

                    matrisTemp[0][0] =matrisOyun[0][5];
                    matrisOyun[0][5] =matrisOyun[0][4];
                    matrisOyun[0][4] =matrisTemp[0][0];
                    b05.setText(String.valueOf(matrisOyun[0][5]));

                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b04.setText(String.valueOf(matrisYeni[0]));
                    b03.setText(String.valueOf(matrisYeni[1]));
                    b02.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }
                //2
                else if (s05.equals(s25)&&s25.equals(s35)){

                    Log.d(TAG, "b00 click");
                    int  [][]matrisTemp=new int[1][1];
                    matrisTemp[0][0] =matrisOyun[0][5];
                    matrisOyun[0][5] =matrisOyun[1][5];
                    matrisOyun[1][5] =matrisTemp[0][0];

                    b05.setText(String.valueOf(matrisOyun[0][5]));

                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b15.setText(String.valueOf(matrisYeni[0]));
                    b25.setText(String.valueOf(matrisYeni[1]));
                    b35.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }

                //3
                else if (s05.equals(s15)&&s15.equals(s25)){

                    Log.d(TAG, "b05 click");
                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b05.setText(String.valueOf(matrisYeni[0]));
                    b15.setText(String.valueOf(matrisYeni[1]));
                    b25.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }


                //4
                else if (s05.equals(s45)&&s45.equals(s03)){
                    Log.d(TAG, "b05 click");
                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b05.setText(String.valueOf(matrisYeni[0]));
                    b04.setText(String.valueOf(matrisYeni[1]));
                    b03.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }



               //5
                else if (s05.equals(s14)&&s14.equals(s13)){

                    Log.d(TAG, "b00 click");
                    int  [][]matrisTemp=new int[1][1];
                    matrisTemp[0][0] =matrisOyun[0][5];
                    matrisOyun[0][5] =matrisOyun[1][5];
                    matrisOyun[1][5] =matrisTemp[0][0];

                    b05.setText(String.valueOf(matrisOyun[0][5]));

                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b15.setText(String.valueOf(matrisYeni[0]));
                    b14.setText(String.valueOf(matrisYeni[1]));
                    b13.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }
                else {
                    Toast.makeText(getApplicationContext(),"dikkatli bak ",Toast.LENGTH_SHORT).show();
                }

            }
        });


/**----------------------------------1. satır sonu -----------------------------------------------------------------*/


        /**---------2.satır baslangıcı--------------------------------------------------------------------------*/
        b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           mb.start();
                if (s10.equals(s12)&&s12.equals(s13))
                {
                    Log.d(TAG, "b00 click");
                    int [][]matrisTemp=new int[1][1];
                    matrisTemp[0][0] =matrisOyun[1][0];
                    matrisOyun[1][0] =matrisOyun[1][1];
                    matrisOyun[1][1] =matrisTemp[0][0];
                    b10.setText(String.valueOf(matrisOyun[1][0]));

                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b11.setText(String.valueOf(matrisYeni[0]));
                    b12.setText(String.valueOf(matrisYeni[1]));
                    b13.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }
                //2
                else if (s10.equals(s30)&&s30.equals(s40)){

                    Log.d(TAG, "b00 click");
                    int [][]matrisTemp=new int[1][1];
                    matrisTemp[0][0] =matrisOyun[1][0];
                    matrisOyun[1][0] =matrisOyun[2][0];
                    matrisOyun[2][0] =matrisTemp[0][0];
                    b10.setText(String.valueOf(matrisOyun[1][0]));

                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b20.setText(String.valueOf(matrisYeni[0]));
                    b30.setText(String.valueOf(matrisYeni[1]));
                    b40.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }


                //3
                else if (s10.equals(s21)&&s21.equals(s31)){

                    Log.d(TAG, "b00 click");
                    int [][]matrisTemp=new int[1][1];
                    matrisTemp[0][0] =matrisOyun[1][0];
                    matrisOyun[1][0] =matrisOyun[1][1];
                    matrisOyun[1][1] =matrisTemp[0][0];
                    b10.setText(String.valueOf(matrisOyun[1][0]));

                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b11.setText(String.valueOf(matrisYeni[0]));
                    b21.setText(String.valueOf(matrisYeni[1]));
                    b31.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }


                //4
                else if (s10.equals(s01)&&s01.equals(s02)){

                    Log.d(TAG, "b00 click");
                    int [][]matrisTemp=new int[1][1];
                    matrisTemp[0][0] =matrisOyun[1][0];
                    matrisOyun[1][0] =matrisOyun[0][0];
                    matrisOyun[0][0] =matrisTemp[0][0];
                    b10.setText(String.valueOf(matrisOyun[1][0]));

                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b00.setText(String.valueOf(matrisYeni[0]));
                    b10.setText(String.valueOf(matrisYeni[1]));
                    b20.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }



                //5
                else if (s10.equals(s01)&&s01.equals(s21)){

                    Log.d(TAG, "b10 click");
                    int [][]matrisTemp=new int[1][1];
                    matrisTemp[0][0] =matrisOyun[1][0];
                    matrisOyun[1][0] =matrisOyun[1][1];
                    matrisOyun[1][1] =matrisTemp[0][0];
                    b10.setText(String.valueOf(matrisOyun[1][0]));

                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b01.setText(String.valueOf(matrisYeni[0]));
                    b11.setText(String.valueOf(matrisYeni[1]));
                    b21.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }

                //6
                else if (s10.equals(s11)&&s11.equals(s12)){

                    Log.d(TAG, "b00 click");
                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b10.setText(String.valueOf(matrisYeni[0]));
                    b11.setText(String.valueOf(matrisYeni[1]));
                    b12.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }


                //7
                else if (s10.equals(s20)&&s20.equals(s30)){

                    Log.d(TAG, "b00 click");
                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b10.setText(String.valueOf(matrisYeni[0]));
                    b20.setText(String.valueOf(matrisYeni[1]));
                    b30.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }

                else {
                    Toast.makeText(getApplicationContext(),"dikkatli bak ",Toast.LENGTH_SHORT).show();
                }

            }
        });




        /**b11 click */
        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
         mb.start();
                if (s11.equals(s13)&&s13.equals(s14))
                {
                    Log.d(TAG, "b01 click");
                    int [][]matrisTemp=new int[1][1];
                    matrisTemp[0][0] =matrisOyun[1][1];
                    matrisOyun[1][1] =matrisOyun[1][2];
                    matrisOyun[1][2] =matrisTemp[0][0];
                    b11.setText(String.valueOf(matrisOyun[1][1]));

                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b12.setText(String.valueOf(matrisYeni[0]));
                    b13.setText(String.valueOf(matrisYeni[1]));
                    b14.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }
                 //2
                else if (s11.equals(s31)&&s31.equals(s41)){

                    Log.d(TAG, "b00 click");
                    int  [][]matrisTemp=new int[1][1];
                    matrisTemp[0][0] =matrisOyun[1][1];
                    matrisOyun[1][1] =matrisOyun[2][1];
                    matrisOyun[2][1] =matrisTemp[0][0];
                    b11.setText(String.valueOf(matrisOyun[1][1]));

                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b21.setText(String.valueOf(matrisYeni[0]));
                    b31.setText(String.valueOf(matrisYeni[1]));
                    b41.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }
                else {
                    Toast.makeText(getApplicationContext(),"dikkatli bak ",Toast.LENGTH_SHORT).show();
                }

            }
        });










        /**b12 click */
        b12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
          mb.start();

                if (s12.equals(s11)&&s11.equals(s10))
                {
                    Log.d(TAG, "b02 click");
                      /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b10.setText(String.valueOf(matrisYeni[0]));
                    b11.setText(String.valueOf(matrisYeni[1]));
                    b12.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }

                else if (s12.equals(s32)&&s32.equals(s42)){

                    Log.d(TAG, "b00 click");
                    int  [][]matrisTemp=new int[1][1];
                    matrisTemp[0][0] =matrisOyun[1][2];
                    matrisOyun[1][2] =matrisOyun[2][2];
                    matrisOyun[2][2] =matrisTemp[0][0];

                    b12.setText(String.valueOf(matrisOyun[1][2]));

                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b22.setText(String.valueOf(matrisYeni[0]));
                    b32.setText(String.valueOf(matrisYeni[1]));
                    b42.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }



                else if (s12.equals(s21)&&s21.equals(s31)){

                    Log.d(TAG, "b00 click");
                    int  [][]matrisTemp=new int[1][1];
                    matrisTemp[0][0] =matrisOyun[1][2];
                    matrisOyun[1][2] =matrisOyun[1][1];
                    matrisOyun[1][1] =matrisTemp[0][0];

                    b12.setText(String.valueOf(matrisOyun[1][2]));

                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b11.setText(String.valueOf(matrisYeni[0]));
                    b21.setText(String.valueOf(matrisYeni[1]));
                    b31.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }
               else if (s12.equals(s22)&&s22.equals(s32))
                {
                    Log.d(TAG, "b02 click");
                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b12.setText(String.valueOf(matrisYeni[0]));
                    b22.setText(String.valueOf(matrisYeni[1]));
                    b32.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }

                else if (s12.equals(s01)&&s01.equals(s03)){

                    Log.d(TAG, "b00 click");
                    int  [][]matrisTemp=new int[1][1];
                    matrisTemp[0][0] =matrisOyun[1][2];
                    matrisOyun[1][2] =matrisOyun[0][2];
                    matrisOyun[0][2] =matrisTemp[0][0];

                    b12.setText(String.valueOf(matrisOyun[1][2]));

                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b01.setText(String.valueOf(matrisYeni[0]));
                    b02.setText(String.valueOf(matrisYeni[1]));
                    b03.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }

                else if (s02.equals(s12)&&s12.equals(s22))
                {
                    Log.d(TAG, "b02 click");
                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b12.setText(String.valueOf(matrisYeni[0]));
                    b22.setText(String.valueOf(matrisYeni[1]));
                    b02.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }

                else if (s12.equals(s22)&&s22.equals(s32))
                {
                    Log.d(TAG, "b02 click");
                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b12.setText(String.valueOf(matrisYeni[0]));
                    b22.setText(String.valueOf(matrisYeni[1]));
                    b32.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }
                else if (s11.equals(s12)&&s12.equals(s13))
                {
                    Log.d(TAG, "b02 click");
                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b11.setText(String.valueOf(matrisYeni[0]));
                    b12.setText(String.valueOf(matrisYeni[1]));
                    b13.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }
                else if (s12.equals(s13)&&s13.equals(s14))
                {
                    Log.d(TAG, "b02 click");
                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b12.setText(String.valueOf(matrisYeni[0]));
                    b13.setText(String.valueOf(matrisYeni[1]));
                    b14.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }


                else if (s12.equals(s03)&&s03.equals(s23))
                {
                    int  [][]matrisTemp=new int[1][1];
                    matrisTemp[0][0] =matrisOyun[1][2];
                    matrisOyun[1][2] =matrisOyun[1][3];
                    matrisOyun[1][3] =matrisTemp[0][0];

                    b12.setText(String.valueOf(matrisOyun[1][2]));

                    Log.d(TAG, "b02 click");
                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b03.setText(String.valueOf(matrisYeni[0]));
                    b13.setText(String.valueOf(matrisYeni[1]));
                    b23.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }
                else if (s12.equals(s14)&&s14.equals(s15))
                {
                    int  [][]matrisTemp=new int[1][1];
                    matrisTemp[0][0] =matrisOyun[1][2];
                    matrisOyun[1][2] =matrisOyun[1][3];
                    matrisOyun[1][3] =matrisTemp[0][0];

                    b12.setText(String.valueOf(matrisOyun[1][2]));

                    Log.d(TAG, "b02 click");
                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b13.setText(String.valueOf(matrisYeni[0]));
                    b14.setText(String.valueOf(matrisYeni[1]));
                    b15.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }

                else if (s12.equals(s23)&&s23.equals(s24))
                {
                    int  [][]matrisTemp=new int[1][1];
                    matrisTemp[0][0] =matrisOyun[1][2];
                    matrisOyun[1][2] =matrisOyun[2][2];
                    matrisOyun[2][2] =matrisTemp[0][0];

                    b12.setText(String.valueOf(matrisOyun[1][2]));

                    Log.d(TAG, "b02 click");
                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b22.setText(String.valueOf(matrisYeni[0]));
                    b23.setText(String.valueOf(matrisYeni[1]));
                    b24.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }

                else {
                    Toast.makeText(getApplicationContext(),"dikkatli bak ",Toast.LENGTH_SHORT).show();
                }

            }
        });




        /**b13 click */
        b13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             mb.start();

                if (s13.equals(s11)&&s11.equals(s10))
                {
                    Log.d(TAG, "b01 click");
                    int [][]matrisTemp=new int[1][1];

                    matrisTemp[0][0] =matrisOyun[1][3];
                    matrisOyun[1][3] =matrisOyun[1][2];
                    matrisOyun[1][2] =matrisTemp[0][0];
                    b13.setText(String.valueOf(matrisOyun[1][3]));

                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b12.setText(String.valueOf(matrisYeni[0]));
                    b11.setText(String.valueOf(matrisYeni[1]));
                    b10.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }

                else if (s13.equals(s33)&&s33.equals(s43)){

                    Log.d(TAG, "b00 click");
                    int  [][]matrisTemp=new int[1][1];
                    matrisTemp[0][0] =matrisOyun[1][3];
                    matrisOyun[1][3] =matrisOyun[2][3];
                    matrisOyun[2][3] =matrisTemp[0][0];

                    b13.setText(String.valueOf(matrisOyun[1][3]));

                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b23.setText(String.valueOf(matrisYeni[0]));
                    b33.setText(String.valueOf(matrisYeni[1]));
                    b43.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }

                else if (s13.equals(s02)&&s02.equals(s22)){

                    Log.d(TAG, "b00 click");
                    int  [][]matrisTemp=new int[1][1];
                    matrisTemp[0][0] =matrisOyun[1][3];
                    matrisOyun[1][3] =matrisOyun[1][2];
                    matrisOyun[1][2] =matrisTemp[0][0];

                    b13.setText(String.valueOf(matrisOyun[1][3]));

                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b02.setText(String.valueOf(matrisYeni[0]));
                    b12.setText(String.valueOf(matrisYeni[1]));
                    b22.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }

                else if (s11.equals(s12)&&s12.equals(s13)){

                    Log.d(TAG, "b00 click");

                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b11.setText(String.valueOf(matrisYeni[0]));
                    b12.setText(String.valueOf(matrisYeni[1]));
                    b13.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }


                else if (s13.equals(s22)&&s22.equals(s32)){

                    Log.d(TAG, "b00 click");
                    int  [][]matrisTemp=new int[1][1];
                    matrisTemp[0][0] =matrisOyun[1][3];
                    matrisOyun[1][3] =matrisOyun[1][2];
                    matrisOyun[1][2] =matrisTemp[0][0];

                    b13.setText(String.valueOf(matrisOyun[1][3]));

                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b12.setText(String.valueOf(matrisYeni[0]));
                    b22.setText(String.valueOf(matrisYeni[1]));
                    b32.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }


                else if (s13.equals(s02)&&s02.equals(s04)){

                    Log.d(TAG, "b00 click");
                    int  [][]matrisTemp=new int[1][1];
                    matrisTemp[0][0] =matrisOyun[1][3];
                    matrisOyun[1][3] =matrisOyun[0][3];
                    matrisOyun[0][3] =matrisTemp[0][0];

                    b13.setText(String.valueOf(matrisOyun[1][3]));

                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b03.setText(String.valueOf(matrisYeni[0]));
                    b04.setText(String.valueOf(matrisYeni[1]));
                    b13.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }



                else if (s13.equals(s22)&&s22.equals(s24)){

                    Log.d(TAG, "b00 click");
                    int  [][]matrisTemp=new int[1][1];
                    matrisTemp[0][0] =matrisOyun[1][3];
                    matrisOyun[1][3] =matrisOyun[2][3];
                    matrisOyun[2][3] =matrisTemp[0][0];

                    b13.setText(String.valueOf(matrisOyun[1][3]));

                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b22.setText(String.valueOf(matrisYeni[0]));
                    b23.setText(String.valueOf(matrisYeni[1]));
                    b24.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }


                else if (s13.equals(s24)&&s24.equals(s25)){

                    Log.d(TAG, "b00 click");
                    int  [][]matrisTemp=new int[1][1];
                    matrisTemp[0][0] =matrisOyun[1][3];
                    matrisOyun[1][3] =matrisOyun[2][3];
                    matrisOyun[2][3] =matrisTemp[0][0];

                    b13.setText(String.valueOf(matrisOyun[1][3]));

                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b23.setText(String.valueOf(matrisYeni[0]));
                    b24.setText(String.valueOf(matrisYeni[1]));
                    b25.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }

                else if (s13.equals(s22)&&s22.equals(s24)){

                    Log.d(TAG, "b00 click");
                    int  [][]matrisTemp=new int[1][1];
                    matrisTemp[0][0] =matrisOyun[1][3];
                    matrisOyun[1][3] =matrisOyun[2][3];
                    matrisOyun[2][3] =matrisTemp[0][0];

                    b13.setText(String.valueOf(matrisOyun[1][3]));

                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b22.setText(String.valueOf(matrisYeni[0]));
                    b23.setText(String.valueOf(matrisYeni[1]));
                    b24.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }


                else if (s13.equals(s14)&&s14.equals(s15)){


                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b13.setText(String.valueOf(matrisYeni[0]));
                    b14.setText(String.valueOf(matrisYeni[1]));
                    b15.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }


                else if (s03.equals(s13)&&s13.equals(s23)){


                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b03.setText(String.valueOf(matrisYeni[0]));
                    b13.setText(String.valueOf(matrisYeni[1]));
                    b23.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }
                else {
                    Toast.makeText(getApplicationContext(),"dikkatli bak ",Toast.LENGTH_SHORT).show();
                }

            }
        });





        /**b14 click */
        b14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           mb.start();
                if (s14.equals(s12)&&s12.equals(s11))
                {
                    Log.d(TAG, "b01 click");
                    int [][]matrisTemp=new int[1][1];

                    matrisTemp[0][0] =matrisOyun[1][4];
                    matrisOyun[1][4] =matrisOyun[1][3];
                    matrisOyun[1][3] =matrisTemp[0][0];
                    b14.setText(String.valueOf(matrisOyun[1][4]));

                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b13.setText(String.valueOf(matrisYeni[0]));
                    b12.setText(String.valueOf(matrisYeni[1]));
                    b11.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }

                else if (s24.equals(s34)&&s34.equals(s44)){

                    Log.d(TAG, "b00 click");
                    int  [][]matrisTemp=new int[1][1];
                    matrisTemp[0][0] =matrisOyun[1][4];
                    matrisOyun[1][4] =matrisOyun[2][4];
                    matrisOyun[2][4] =matrisTemp[0][0];

                    b14.setText(String.valueOf(matrisOyun[1][4]));

                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b24.setText(String.valueOf(matrisYeni[0]));
                    b34.setText(String.valueOf(matrisYeni[1]));
                    b44.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }
                else {
                    Toast.makeText(getApplicationContext(),"dikkatli bak ",Toast.LENGTH_SHORT).show();
                }

            }
        });



        /**b15 click */
        b15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              mb.start();
                if (s15.equals(s13)&&s13.equals(s12))
                {
                    Log.d(TAG, "b01 click");
                    int [][]matrisTemp=new int[1][1];

                    matrisTemp[0][0] =matrisOyun[1][5];
                    matrisOyun[1][5] =matrisOyun[1][4];
                    matrisOyun[1][4] =matrisTemp[0][0];
                    b15.setText(String.valueOf(matrisOyun[1][5]));

                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b14.setText(String.valueOf(matrisYeni[0]));
                    b13.setText(String.valueOf(matrisYeni[1]));
                    b12.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }

                else if (s15.equals(s35)&&s35.equals(s45)){

                    Log.d(TAG, "b00 click");
                    int  [][]matrisTemp=new int[1][1];
                    matrisTemp[0][0] =matrisOyun[1][5];
                    matrisOyun[1][5] =matrisOyun[2][5];
                    matrisOyun[2][5] =matrisTemp[0][0];

                    b15.setText(String.valueOf(matrisOyun[1][5]));

                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b25.setText(String.valueOf(matrisYeni[0]));
                    b35.setText(String.valueOf(matrisYeni[1]));
                    b45.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }
                else {
                    Toast.makeText(getApplicationContext(),"dikkatli bak ",Toast.LENGTH_SHORT).show();
                }

            }
        });

/**---------------------------2. satır bitisi----------------------------------------------------------------------*/

        /**---------3.satır baslangıcı--------------------------------------------------------------------------*/
        b20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mb.start();
                if (s20.equals(s22)&&s22.equals(s23))
                {
                    Log.d(TAG, "b00 click");
                    int [][]matrisTemp=new int[1][1];
                    matrisTemp[0][0] =matrisOyun[2][0];
                    matrisOyun[2][0] =matrisOyun[2][1];
                    matrisOyun[2][1] =matrisTemp[0][0];
                    b20.setText(String.valueOf(matrisOyun[2][0]));

                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b21.setText(String.valueOf(matrisYeni[0]));
                    b22.setText(String.valueOf(matrisYeni[1]));
                    b23.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }
                else if (s20.equals(s40)&&s40.equals(s50)){

                    Log.d(TAG, "b00 click");
                    int [][]matrisTemp=new int[1][1];
                    matrisTemp[0][0] =matrisOyun[2][0];
                    matrisOyun[2][0] =matrisOyun[3][0];
                    matrisOyun[3][0] =matrisTemp[0][0];
                    b20.setText(String.valueOf(matrisOyun[2][0]));

                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b30.setText(String.valueOf(matrisYeni[0]));
                    b40.setText(String.valueOf(matrisYeni[1]));
                    b50.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }
                else {
                    Toast.makeText(getApplicationContext(),"dikkatli bak ",Toast.LENGTH_SHORT).show();
                }

            }
        });




        /**b21 click */
        b21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               mb.start();

                if (s21.equals(s23)&&s23.equals(s24))
                {
                    Log.d(TAG, "b01 click");
                    int [][]matrisTemp=new int[1][1];
                    matrisTemp[0][0] =matrisOyun[2][1];
                    matrisOyun[2][1] =matrisOyun[2][2];
                    matrisOyun[2][2] =matrisTemp[0][0];
                    b21.setText(String.valueOf(matrisOyun[2][1]));
                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b22.setText(String.valueOf(matrisYeni[0]));
                    b23.setText(String.valueOf(matrisYeni[1]));
                    b24.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }

                else if (s21.equals(s41)&&s41.equals(s51)){

                    Log.d(TAG, "b00 click");
                    int  [][]matrisTemp=new int[1][1];
                    matrisTemp[0][0] =matrisOyun[2][1];
                    matrisOyun[2][1] =matrisOyun[3][1];
                    matrisOyun[3][1] =matrisTemp[0][0];
                    b21.setText(String.valueOf(matrisOyun[2][1]));

                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b31.setText(String.valueOf(matrisYeni[0]));
                    b41.setText(String.valueOf(matrisYeni[1]));
                    b51.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }
                else {
                    Toast.makeText(getApplicationContext(),"dikkatli bak ",Toast.LENGTH_SHORT).show();
                }

            }
        });

        /**b22 click */
        b22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              mb.start();

                if (s22.equals(s24)&&s24.equals(s25))
                {
                    Log.d(TAG, "b02 click");
                    int [][]matrisTemp=new int[1][1];

                    matrisTemp[0][0] =matrisOyun[2][2];
                    matrisOyun[2][2] =matrisOyun[2][3];
                    matrisOyun[2][3] =matrisTemp[0][0];
                    b22.setText(String.valueOf(matrisOyun[2][2]));

                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b23.setText(String.valueOf(matrisYeni[0]));
                    b24.setText(String.valueOf(matrisYeni[1]));
                    b25.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }

                else if (s22.equals(s42)&&s42.equals(s52)){

                    Log.d(TAG, "b00 click");
                    int  [][]matrisTemp=new int[1][1];
                    matrisTemp[0][0] =matrisOyun[2][2];
                    matrisOyun[2][2] =matrisOyun[3][2];
                    matrisOyun[3][2] =matrisTemp[0][0];

                    b22.setText(String.valueOf(matrisOyun[2][2]));

                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b32.setText(String.valueOf(matrisYeni[0]));
                    b42.setText(String.valueOf(matrisYeni[1]));
                    b52.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }
                else {
                    Toast.makeText(getApplicationContext(),"dikkatli bak ",Toast.LENGTH_SHORT).show();
                }

            }
        });



        /**b23 click */
        b23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mb.start();
                if (s23.equals(s21)&&s21.equals(s20))
                {
                    Log.d(TAG, "b01 click");
                    int [][]matrisTemp=new int[1][1];

                    matrisTemp[0][0] =matrisOyun[2][3];
                    matrisOyun[2][3] =matrisOyun[2][2];
                    matrisOyun[2][2] =matrisTemp[0][0];
                    b23.setText(String.valueOf(matrisOyun[2][3]));

                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b22.setText(String.valueOf(matrisYeni[0]));
                    b21.setText(String.valueOf(matrisYeni[1]));
                    b20.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }

                else if (s23.equals(s43)&&s43.equals(s53)){

                    Log.d(TAG, "b00 click");
                    int  [][]matrisTemp=new int[1][1];
                    matrisTemp[0][0] =matrisOyun[2][3];
                    matrisOyun[2][3] =matrisOyun[3][3];
                    matrisOyun[3][3] =matrisTemp[0][0];

                    b23.setText(String.valueOf(matrisOyun[2][3]));

                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b33.setText(String.valueOf(matrisYeni[0]));
                    b34.setText(String.valueOf(matrisYeni[1]));
                    b53.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }
                else {
                    Toast.makeText(getApplicationContext(),"dikkatli bak ",Toast.LENGTH_SHORT).show();
                }

            }
        });





        /**b24 click */
        b24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mb.start();

                if (s24.equals(s22)&&s22.equals(s21))
                {
                    Log.d(TAG, "b01 click");
                    int [][]matrisTemp=new int[1][1];

                    matrisTemp[0][0] =matrisOyun[2][4];
                    matrisOyun[2][4] =matrisOyun[2][3];
                    matrisOyun[2][3] =matrisTemp[0][0];
                    b24.setText(String.valueOf(matrisOyun[2][4]));

                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b23.setText(String.valueOf(matrisYeni[0]));
                    b22.setText(String.valueOf(matrisYeni[1]));
                    b21.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }

                else if (s24.equals(s44)&&s44.equals(s54)){

                    Log.d(TAG, "b00 click");
                    int  [][]matrisTemp=new int[1][1];
                    matrisTemp[0][0] =matrisOyun[2][4];
                    matrisOyun[2][4] =matrisOyun[3][4];
                    matrisOyun[3][4] =matrisTemp[0][0];

                    b24.setText(String.valueOf(matrisOyun[2][4]));

                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b34.setText(String.valueOf(matrisYeni[0]));
                    b44.setText(String.valueOf(matrisYeni[1]));
                    b54.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }
                else {
                    Toast.makeText(getApplicationContext(),"dikkatli bak ",Toast.LENGTH_SHORT).show();
                }

            }
        });



        /**b15 click */
        b25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mb.start();

                if (s25.equals(s23)&&s23.equals(s22))
                {
                    Log.d(TAG, "b01 click");
                    int [][]matrisTemp=new int[1][1];

                    matrisTemp[0][0] =matrisOyun[2][5];
                    matrisOyun[2][5] =matrisOyun[2][4];
                    matrisOyun[2][4] =matrisTemp[0][0];
                    b25.setText(String.valueOf(matrisOyun[2][5]));

                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b24.setText(String.valueOf(matrisYeni[0]));
                    b23.setText(String.valueOf(matrisYeni[1]));
                    b22.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }

                else if (s25.equals(s45)&&s35.equals(s55)){

                    Log.d(TAG, "b00 click");
                    int  [][]matrisTemp=new int[1][1];
                    matrisTemp[0][0] =matrisOyun[2][5];
                    matrisOyun[2][5] =matrisOyun[3][5];
                    matrisOyun[3][5] =matrisTemp[0][0];

                    b25.setText(String.valueOf(matrisOyun[2][5]));

                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b35.setText(String.valueOf(matrisYeni[0]));
                    b45.setText(String.valueOf(matrisYeni[1]));
                    b55.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }
                else {
                    Toast.makeText(getApplicationContext(),"dikkatli bak ",Toast.LENGTH_SHORT).show();
                }

            }
        });






        /**---------4.satır baslangıcı--------------------------------------------------------------------------*/
        b30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mb.start();
                if (s30.equals(s32)&&s32.equals(s33))
                {
                    Log.d(TAG, "b00 click");
                    int [][]matrisTemp=new int[1][1];
                    matrisTemp[0][0] =matrisOyun[3][0];
                    matrisOyun[3][0] =matrisOyun[3][1];
                    matrisOyun[3][1] =matrisTemp[0][0];
                    b30.setText(String.valueOf(matrisOyun[3][0]));

                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b31.setText(String.valueOf(matrisYeni[0]));
                    b32.setText(String.valueOf(matrisYeni[1]));
                    b33.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }
                else if (s30.equals(s10)&&s10.equals(s00)){

                    Log.d(TAG, "b00 click");
                    int [][]matrisTemp=new int[1][1];
                    matrisTemp[0][0] =matrisOyun[3][0];
                    matrisOyun[3][0] =matrisOyun[2][0];
                    matrisOyun[2][0] =matrisTemp[0][0];
                    b30.setText(String.valueOf(matrisOyun[3][0]));

                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b20.setText(String.valueOf(matrisYeni[0]));
                    b10.setText(String.valueOf(matrisYeni[1]));
                    b00.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }
                else {
                    Toast.makeText(getApplicationContext(),"dikkatli bak ",Toast.LENGTH_SHORT).show();
                }

            }
        });




        /**b31 click */
        b21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mb.start();

                if (s31.equals(s33)&&s33.equals(s34))
                {
                    Log.d(TAG, "b01 click");
                    int [][]matrisTemp=new int[1][1];
                    matrisTemp[0][0] =matrisOyun[3][1];
                    matrisOyun[3][1] =matrisOyun[3][2];
                    matrisOyun[3][2] =matrisTemp[0][0];
                    b31.setText(String.valueOf(matrisOyun[3][1]));
                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b32.setText(String.valueOf(matrisYeni[0]));
                    b33.setText(String.valueOf(matrisYeni[1]));
                    b34.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }

                else if (s31.equals(s11)&&s11.equals(s01)){

                    Log.d(TAG, "b00 click");
                    int  [][]matrisTemp=new int[1][1];
                    matrisTemp[0][0] =matrisOyun[3][1];
                    matrisOyun[3][1] =matrisOyun[2][1];
                    matrisOyun[2][1] =matrisTemp[0][0];
                    b31.setText(String.valueOf(matrisOyun[3][1]));

                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b21.setText(String.valueOf(matrisYeni[0]));
                    b11.setText(String.valueOf(matrisYeni[1]));
                    b01.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }
                else {
                    Toast.makeText(getApplicationContext(),"dikkatli bak ",Toast.LENGTH_SHORT).show();
                }

            }
        });

        /**b22 click */
        b32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mb.start();

                if (s32.equals(s34)&&s24.equals(s35))
                {
                    Log.d(TAG, "b02 click");
                    int [][]matrisTemp=new int[1][1];

                    matrisTemp[0][0] =matrisOyun[3][2];
                    matrisOyun[3][2] =matrisOyun[3][3];
                    matrisOyun[3][3] =matrisTemp[0][0];
                    b32.setText(String.valueOf(matrisOyun[3][2]));

                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b33.setText(String.valueOf(matrisYeni[0]));
                    b34.setText(String.valueOf(matrisYeni[1]));
                    b35.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }

                else if (s32.equals(s12)&&s12.equals(s02)){

                    Log.d(TAG, "b00 click");
                    int  [][]matrisTemp=new int[1][1];
                    matrisTemp[0][0] =matrisOyun[3][2];
                    matrisOyun[3][2] =matrisOyun[2][2];
                    matrisOyun[2][2] =matrisTemp[0][0];

                    b32.setText(String.valueOf(matrisOyun[3][2]));

                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b22.setText(String.valueOf(matrisYeni[0]));
                    b12.setText(String.valueOf(matrisYeni[1]));
                    b02.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }
                else {
                    Toast.makeText(getApplicationContext(),"dikkatli bak ",Toast.LENGTH_SHORT).show();
                }

            }
        });



        /**b33 click */
        b33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            mb.start();
                if (s33.equals(s31)&&s31.equals(s30))
                {
                    Log.d(TAG, "b01 click");
                    int [][]matrisTemp=new int[1][1];

                    matrisTemp[0][0] =matrisOyun[3][3];
                    matrisOyun[3][3] =matrisOyun[3][2];
                    matrisOyun[3][2] =matrisTemp[0][0];
                    b33.setText(String.valueOf(matrisOyun[3][3]));

                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b32.setText(String.valueOf(matrisYeni[0]));
                    b31.setText(String.valueOf(matrisYeni[1]));
                    b30.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }

                else if (s33.equals(s13)&&s13.equals(s03)){

                    Log.d(TAG, "b00 click");
                    int  [][]matrisTemp=new int[1][1];
                    matrisTemp[0][0] =matrisOyun[3][3];
                    matrisOyun[3][3] =matrisOyun[2][3];
                    matrisOyun[2][3] =matrisTemp[0][0];

                    b33.setText(String.valueOf(matrisOyun[3][3]));

                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b23.setText(String.valueOf(matrisYeni[0]));
                    b13.setText(String.valueOf(matrisYeni[1]));
                    b03.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }
                else {
                    Toast.makeText(getApplicationContext(),"dikkatli bak ",Toast.LENGTH_SHORT).show();
                }

            }
        });





        /**b34 click */
        b34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mb.start();
                if (s34.equals(s32)&&s32.equals(s31))
                {
                    Log.d(TAG, "b01 click");
                    int [][]matrisTemp=new int[1][1];

                    matrisTemp[0][0] =matrisOyun[3][4];
                    matrisOyun[3][4] =matrisOyun[3][3];
                    matrisOyun[3][3] =matrisTemp[0][0];
                    b34.setText(String.valueOf(matrisOyun[3][4]));

                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b33.setText(String.valueOf(matrisYeni[0]));
                    b32.setText(String.valueOf(matrisYeni[1]));
                    b31.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }

                else if (s34.equals(s14)&&s14.equals(s04)){

                    Log.d(TAG, "b00 click");
                    int  [][]matrisTemp=new int[1][1];
                    matrisTemp[0][0] =matrisOyun[3][4];
                    matrisOyun[3][4] =matrisOyun[2][4];
                    matrisOyun[2][4] =matrisTemp[0][0];

                    b34.setText(String.valueOf(matrisOyun[3][4]));

                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b24.setText(String.valueOf(matrisYeni[0]));
                    b14.setText(String.valueOf(matrisYeni[1]));
                    b04.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }
                else {
                    Toast.makeText(getApplicationContext(),"dikkatli bak ",Toast.LENGTH_SHORT).show();
                }

            }
        });



        /**b35 click */
        b35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
          mb.start();
                if (s35.equals(s33)&&s33.equals(s32))
                {
                    Log.d(TAG, "b01 click");
                    int [][]matrisTemp=new int[1][1];

                    matrisTemp[0][0] =matrisOyun[3][5];
                    matrisOyun[3][5] =matrisOyun[3][4];
                    matrisOyun[3][4] =matrisTemp[0][0];
                    b35.setText(String.valueOf(matrisOyun[3][5]));

                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b34.setText(String.valueOf(matrisYeni[0]));
                    b33.setText(String.valueOf(matrisYeni[1]));
                    b32.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }

                else if (s35.equals(s15)&&s15.equals(s05)){

                    Log.d(TAG, "b00 click");
                    int  [][]matrisTemp=new int[1][1];
                    matrisTemp[0][0] =matrisOyun[3][5];
                    matrisOyun[3][5] =matrisOyun[2][5];
                    matrisOyun[2][5] =matrisTemp[0][0];

                    b35.setText(String.valueOf(matrisOyun[3][5]));

                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b25.setText(String.valueOf(matrisYeni[0]));
                    b15.setText(String.valueOf(matrisYeni[1]));
                    b05.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }
                else {
                    Toast.makeText(getApplicationContext(),"dikkatli bak ",Toast.LENGTH_SHORT).show();
                }

            }
        });


   /**--------------------5.satır ---------------------------------------------------*/

        b40.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mb.start();
                if (s40.equals(s42)&&s42.equals(s43))
                {
                    Log.d(TAG, "b00 click");
                    int [][]matrisTemp=new int[1][1];
                    matrisTemp[0][0] =matrisOyun[4][0];
                    matrisOyun[4][0] =matrisOyun[4][1];
                    matrisOyun[4][1] =matrisTemp[0][0];
                    b40.setText(String.valueOf(matrisOyun[4][0]));

                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b41.setText(String.valueOf(matrisYeni[0]));
                    b42.setText(String.valueOf(matrisYeni[1]));
                    b43.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }
                else if (s40.equals(s20)&&s20.equals(s10)){

                    Log.d(TAG, "b00 click");
                    int [][]matrisTemp=new int[1][1];
                    matrisTemp[0][0] =matrisOyun[4][0];
                    matrisOyun[4][0] =matrisOyun[3][0];
                    matrisOyun[3][0] =matrisTemp[0][0];
                    b40.setText(String.valueOf(matrisOyun[4][0]));

                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b30.setText(String.valueOf(matrisYeni[0]));
                    b20.setText(String.valueOf(matrisYeni[1]));
                    b10.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }
                else {
                    Toast.makeText(getApplicationContext(),"dikkatli bak ",Toast.LENGTH_SHORT).show();
                }

            }
        });




        /**b41 click */
        b41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mb.start();
                if (s41.equals(s43)&&s43.equals(s44))
                {
                    Log.d(TAG, "b01 click");
                    int [][]matrisTemp=new int[1][1];
                    matrisTemp[0][0] =matrisOyun[4][1];
                    matrisOyun[4][1] =matrisOyun[4][2];
                    matrisOyun[4][2] =matrisTemp[0][0];
                    b41.setText(String.valueOf(matrisOyun[4][1]));
                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b42.setText(String.valueOf(matrisYeni[0]));
                    b43.setText(String.valueOf(matrisYeni[1]));
                    b44.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }

                else if (s41.equals(s21)&&s21.equals(s11)){

                    Log.d(TAG, "b00 click");
                    int  [][]matrisTemp=new int[1][1];
                    matrisTemp[0][0] =matrisOyun[4][1];
                    matrisOyun[4][1] =matrisOyun[3][1];
                    matrisOyun[3][1] =matrisTemp[0][0];
                    b41.setText(String.valueOf(matrisOyun[4][1]));

                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b31.setText(String.valueOf(matrisYeni[0]));
                    b31.setText(String.valueOf(matrisYeni[1]));
                    b21.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }
                else {
                    Toast.makeText(getApplicationContext(),"dikkatli bak ",Toast.LENGTH_SHORT).show();
                }

            }
        });

        /**b42 click */
        b42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mb.start();
                if (s42.equals(s44)&&s44.equals(s45))
                {
                    Log.d(TAG, "b02 click");
                    int [][]matrisTemp=new int[1][1];

                    matrisTemp[0][0] =matrisOyun[4][2];
                    matrisOyun[4][2] =matrisOyun[4][3];
                    matrisOyun[4][3] =matrisTemp[0][0];
                    b42.setText(String.valueOf(matrisOyun[4][2]));

                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b43.setText(String.valueOf(matrisYeni[0]));
                    b44.setText(String.valueOf(matrisYeni[1]));
                    b45.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }

                else if (s42.equals(s22)&&s22.equals(s12)){

                    Log.d(TAG, "b00 click");
                    int  [][]matrisTemp=new int[1][1];
                    matrisTemp[0][0] =matrisOyun[4][2];
                    matrisOyun[4][2] =matrisOyun[3][2];
                    matrisOyun[3][2] =matrisTemp[0][0];

                    b42.setText(String.valueOf(matrisOyun[4][2]));

                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b32.setText(String.valueOf(matrisYeni[0]));
                    b22.setText(String.valueOf(matrisYeni[1]));
                    b12.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }
                else {
                    Toast.makeText(getApplicationContext(),"dikkatli bak ",Toast.LENGTH_SHORT).show();
                }

            }
        });



        /**b43 click */
        b43.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mb.start();

                if (s43.equals(s41)&&s41.equals(s40))
                {
                    Log.d(TAG, "b01 click");
                    int [][]matrisTemp=new int[1][1];

                    matrisTemp[0][0] =matrisOyun[4][3];
                    matrisOyun[4][3] =matrisOyun[4][2];
                    matrisOyun[4][2] =matrisTemp[0][0];
                    b43.setText(String.valueOf(matrisOyun[4][3]));

                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b42.setText(String.valueOf(matrisYeni[0]));
                    b41.setText(String.valueOf(matrisYeni[1]));
                    b40.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }

                else if (s43.equals(s23)&&s23.equals(s13)){

                    Log.d(TAG, "b00 click");
                    int  [][]matrisTemp=new int[1][1];
                    matrisTemp[0][0] =matrisOyun[4][3];
                    matrisOyun[4][3] =matrisOyun[3][3];
                    matrisOyun[3][3] =matrisTemp[0][0];

                    b43.setText(String.valueOf(matrisOyun[4][3]));

                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b33.setText(String.valueOf(matrisYeni[0]));
                    b23.setText(String.valueOf(matrisYeni[1]));
                    b13.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }
                else {
                    Toast.makeText(getApplicationContext(),"dikkatli bak ",Toast.LENGTH_SHORT).show();
                }

            }
        });





        /**b44 click */
        b44.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mb.start();
                if (s44.equals(s42)&&s42.equals(s41))
                {
                    Log.d(TAG, "b01 click");
                    int [][]matrisTemp=new int[1][1];

                    matrisTemp[0][0] =matrisOyun[4][4];
                    matrisOyun[4][4] =matrisOyun[4][3];
                    matrisOyun[4][3] =matrisTemp[0][0];
                    b44.setText(String.valueOf(matrisOyun[4][4]));

                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b43.setText(String.valueOf(matrisYeni[0]));
                    b42.setText(String.valueOf(matrisYeni[1]));
                    b41.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }

                else if (s44.equals(s24)&&s24.equals(s14)){

                    Log.d(TAG, "b00 click");
                    int  [][]matrisTemp=new int[1][1];
                    matrisTemp[0][0] =matrisOyun[4][4];
                    matrisOyun[4][4] =matrisOyun[3][4];
                    matrisOyun[3][4] =matrisTemp[0][0];

                    b44.setText(String.valueOf(matrisOyun[4][4]));

                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b34.setText(String.valueOf(matrisYeni[0]));
                    b24.setText(String.valueOf(matrisYeni[1]));
                    b24.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }
                else {
                    Toast.makeText(getApplicationContext(),"dikkatli bak ",Toast.LENGTH_SHORT).show();
                }

            }
        });



        /**b45 click */
        b45.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mb.start();

                if (s45.equals(s43)&&s43.equals(s42))
                {
                    Log.d(TAG, "b01 click");
                    int [][]matrisTemp=new int[1][1];

                    matrisTemp[0][0] =matrisOyun[4][5];
                    matrisOyun[4][5] =matrisOyun[4][4];
                    matrisOyun[4][4] =matrisTemp[0][0];
                    b45.setText(String.valueOf(matrisOyun[4][5]));

                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b44.setText(String.valueOf(matrisYeni[0]));
                    b43.setText(String.valueOf(matrisYeni[1]));
                    b42.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }

                else if (s45.equals(s25)&&s25.equals(s15)){

                    Log.d(TAG, "b00 click");
                    int  [][]matrisTemp=new int[1][1];
                    matrisTemp[0][0] =matrisOyun[4][5];
                    matrisOyun[4][5] =matrisOyun[3][5];
                    matrisOyun[3][5] =matrisTemp[0][0];

                    b45.setText(String.valueOf(matrisOyun[4][5]));

                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b35.setText(String.valueOf(matrisYeni[0]));
                    b25.setText(String.valueOf(matrisYeni[1]));
                    b15.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }
                else {
                    Toast.makeText(getApplicationContext(),"dikkatli bak ",Toast.LENGTH_SHORT).show();
                }

            }
        });


/**--------------------------6.sıra-----------------------------------------------------------------------------*/




        b50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (s50.equals(s52)&&s52.equals(s53))
                {
                    Log.d(TAG, "b00 click");
                    int [][]matrisTemp=new int[1][1];
                    matrisTemp[0][0] =matrisOyun[5][0];
                    matrisOyun[5][0] =matrisOyun[5][1];
                    matrisOyun[5][1] =matrisTemp[0][0];
                    b50.setText(String.valueOf(matrisOyun[5][0]));

                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b51.setText(String.valueOf(matrisYeni[0]));
                    b52.setText(String.valueOf(matrisYeni[1]));
                    b53.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }
                else if (s50.equals(s30)&&s30.equals(s20)){

                    Log.d(TAG, "b00 click");
                    int [][]matrisTemp=new int[1][1];
                    matrisTemp[0][0] =matrisOyun[5][0];
                    matrisOyun[5][0] =matrisOyun[4][0];
                    matrisOyun[4][0] =matrisTemp[0][0];
                    b50.setText(String.valueOf(matrisOyun[5][0]));

                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b40.setText(String.valueOf(matrisYeni[0]));
                    b30.setText(String.valueOf(matrisYeni[1]));
                    b20.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }
                else {
                    Toast.makeText(getApplicationContext(),"dikkatli bak ",Toast.LENGTH_SHORT).show();
                }

            }
        });




        /**b51 click */
        b51.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mb.start();

                if (s51.equals(s53)&&s53.equals(s54))
                {
                    Log.d(TAG, "b01 click");
                    int [][]matrisTemp=new int[1][1];
                    matrisTemp[0][0] =matrisOyun[5][1];
                    matrisOyun[5][1] =matrisOyun[5][2];
                    matrisOyun[5][2] =matrisTemp[0][0];
                    b51.setText(String.valueOf(matrisOyun[5][1]));
                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b52.setText(String.valueOf(matrisYeni[0]));
                    b53.setText(String.valueOf(matrisYeni[1]));
                    b54.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }

                else if (s51.equals(s31)&&s31.equals(s21)){

                    Log.d(TAG, "b00 click");
                    int  [][]matrisTemp=new int[1][1];
                    matrisTemp[0][0] =matrisOyun[5][1];
                    matrisOyun[5][1] =matrisOyun[4][1];
                    matrisOyun[4][1] =matrisTemp[0][0];
                    b51.setText(String.valueOf(matrisOyun[5][1]));

                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b41.setText(String.valueOf(matrisYeni[0]));
                    b31.setText(String.valueOf(matrisYeni[1]));
                    b21.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }
                else {
                    Toast.makeText(getApplicationContext(),"dikkatli bak ",Toast.LENGTH_SHORT).show();
                }

            }
        });

        /**b52 click */
        b52.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
      mb.start();

                if (s52.equals(s54)&&s54.equals(s55))
                {
                    Log.d(TAG, "b02 click");
                    int [][]matrisTemp=new int[1][1];

                    matrisTemp[0][0] =matrisOyun[5][2];
                    matrisOyun[5][2] =matrisOyun[5][3];
                    matrisOyun[5][3] =matrisTemp[0][0];
                    b52.setText(String.valueOf(matrisOyun[5][2]));

                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b53.setText(String.valueOf(matrisYeni[0]));
                    b54.setText(String.valueOf(matrisYeni[1]));
                    b55.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }

                else if (s52.equals(s32)&&s32.equals(s22)){

                    Log.d(TAG, "b00 click");
                    int  [][]matrisTemp=new int[1][1];
                    matrisTemp[0][0] =matrisOyun[5][2];
                    matrisOyun[5][2] =matrisOyun[4][2];
                    matrisOyun[4][2] =matrisTemp[0][0];

                    b52.setText(String.valueOf(matrisOyun[5][2]));

                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b42.setText(String.valueOf(matrisYeni[0]));
                    b32.setText(String.valueOf(matrisYeni[1]));
                    b32.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }
                else {
                    Toast.makeText(getApplicationContext(),"dikkatli bak ",Toast.LENGTH_SHORT).show();
                }

            }
        });



        /**b53 click */
        b53.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mb.start();
                if (s53.equals(s51)&&s51.equals(s50))
                {
                    Log.d(TAG, "b01 click");
                    int [][]matrisTemp=new int[1][1];

                    matrisTemp[0][0] =matrisOyun[5][3];
                    matrisOyun[5][3] =matrisOyun[5][2];
                    matrisOyun[5][2] =matrisTemp[0][0];
                    b53.setText(String.valueOf(matrisOyun[5][3]));

                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b52.setText(String.valueOf(matrisYeni[0]));
                    b51.setText(String.valueOf(matrisYeni[1]));
                    b50.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }

                else if (s53.equals(s33)&&s33.equals(s23)){

                    Log.d(TAG, "b00 click");
                    int  [][]matrisTemp=new int[1][1];
                    matrisTemp[0][0] =matrisOyun[5][3];
                    matrisOyun[5][3] =matrisOyun[4][3];
                    matrisOyun[4][3] =matrisTemp[0][0];

                    b53.setText(String.valueOf(matrisOyun[5][3]));

                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int []matrisYeni =new int[3];
                    for (int g=0; g<3; g++){
                        matrisYeni[g]= rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b43.setText(String.valueOf(matrisYeni[0]));
                    b33.setText(String.valueOf(matrisYeni[1]));
                    b23.setText(String.valueOf(matrisYeni[2]));

                    Score +=5;
                    Tscore.setText(String.valueOf("Score :"+Score));
                }
                else {
                    Toast.makeText(getApplicationContext(),"dikkatli bak ",Toast.LENGTH_SHORT).show();
                }

            }
        });





        /**b54 click */
        b54.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mb.start();

                if (s54.equals(s52) && s52.equals( s51)) {
                    Log.d(TAG, "b01 click");
                    int[][] matrisTemp = new int[1][1];

                    matrisTemp[0][0] = matrisOyun[5][4];
                    matrisOyun[5][4] = matrisOyun[5][3];
                    matrisOyun[5][3] = matrisTemp[0][0];
                    b54.setText(String.valueOf(matrisOyun[5][4]));

                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int[] matrisYeni = new int[3];
                    for (int g = 0; g < 3; g++) {
                        matrisYeni[g] = rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b53.setText(String.valueOf(matrisYeni[0]));
                    b52.setText(String.valueOf(matrisYeni[1]));
                    b51.setText(String.valueOf(matrisYeni[2]));

                    Score += 5;
                    Tscore.setText(String.valueOf("Score :" + Score));
                } else if (s54.equals(s34)&& s34.equals(s24)) {

                    Log.d(TAG, "b00 click");
                    int[][] matrisTemp = new int[1][1];
                    matrisTemp[0][0] = matrisOyun[5][4];
                    matrisOyun[5][4] = matrisOyun[4][4];
                    matrisOyun[4][4] = matrisTemp[0][0];

                    b54.setText(String.valueOf(matrisOyun[5][4]));

                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int[] matrisYeni = new int[3];
                    for (int g = 0; g < 3; g++) {
                        matrisYeni[g] = rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b44.setText(String.valueOf(matrisYeni[0]));
                    b34.setText(String.valueOf(matrisYeni[1]));
                    b24.setText(String.valueOf(matrisYeni[2]));

                    Score += 5;
                    Tscore.setText(String.valueOf("Score :" + Score));
                } else {
                    Toast.makeText(getApplicationContext(), "dikkatli bak ", Toast.LENGTH_SHORT).show();
                }

            }
        });



        /**b55 click */
        b55.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mb.start();

                if (s55.equals(s52) && s52.equals(s51)) {
                    Log.d(TAG, "b01 click");
                    int[][] matrisTemp = new int[1][1];

                    matrisTemp[0][0] = matrisOyun[5][5];
                    matrisOyun[5][5] = matrisOyun[5][4];
                    matrisOyun[5][4] = matrisTemp[0][0];
                    b55.setText(String.valueOf(matrisOyun[5][5]));

                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int[] matrisYeni = new int[3];
                    for (int g = 0; g < 3; g++) {
                        matrisYeni[g] = rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b54.setText(String.valueOf(matrisYeni[0]));
                    b53.setText(String.valueOf(matrisYeni[1]));
                    b52.setText(String.valueOf(matrisYeni[2]));

                    Score += 5;
                    Tscore.setText(String.valueOf("Score :" + Score));
                } else if (s55.equals(s35) && s35.equals(s25)) {

                    Log.d(TAG, "b00 click");
                    int[][] matrisTemp = new int[1][1];
                    matrisTemp[0][0] = matrisOyun[5][5];
                    matrisOyun[5][5] = matrisOyun[4][5];
                    matrisOyun[4][5] = matrisTemp[0][0];

                    b55.setText(String.valueOf(matrisOyun[5][5]));

                    /**silinen elemanlar icin yeni deger bulup atama random */
                    int[] matrisYeni = new int[3];
                    for (int g = 0; g < 3; g++) {
                        matrisYeni[g] = rnd.nextInt(Integer.parseInt(liste1.get(g)));
                        Log.d(TAG, "Matris dizi " + (g + 1) + ". eleman:" + matrisDizi[g]);
                    }
                    b45.setText(String.valueOf(matrisYeni[0]));
                    b35.setText(String.valueOf(matrisYeni[1]));
                    b25.setText(String.valueOf(matrisYeni[2]));

                    Score += 5;
                    Tscore.setText(String.valueOf("Score :" + Score));
                } else {
                    Toast.makeText(getApplicationContext(), "dikkatli bak ", Toast.LENGTH_SHORT).show();
                }

            }
        });



        btGeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                WriteToFile w =new WriteToFile();

                aPuan = new ArrayList<>();
                aPuan.add(String.valueOf(Score));

                String[] puan = new String[3];

                for (int y = 0; y < aPuan.size(); y++) {
                    puan[y] = aPuan.get(y);
                }
                w.WriteFile(scoreFileName, puan);

                System.exit(1);

            }
        });





        t2.setText(s00 + "  " + s01 + "  " + s02 + "  " + s03 + "  " + s04 + "  " + s05 + "\n" +
                s10 + "  " + s11 + "  " + s12 + "  " + s13 + "  " + s14 + "  " + s15 + "\n" +
                s20 + "  " + s21 + "  " + s22 + "  " + s23 + "  " + s24 + "  " + s25 + "\n" +
                s30 + "  " + s31 + "  " + s32 + "  " + s33 + "  " + s34 + "  " + s35 + "\n" +
                s40 + "  " + s41 + "  " + s42 + "  " + s43 + "  " + s44 + "  " + s45 + "\n" +
                s50 + "  " + s51 + "  " + s52 + "  " + s53 + "  " + s54 + "  " + s55);


       /* btGeri.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                quit();
                mp.stop();
            }
        });
*/




    }

    public void quit() {
        Intent startMain = new Intent(Intent.ACTION_MAIN);
        startMain.addCategory(Intent.CATEGORY_HOME);
        startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startMain.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(startMain);

    }

    public  void setupVariable(){



       /**mattrisin olusturdugu butonlar*/
        b00 =(Button)findViewById(R.id.b00);
        b01 =(Button)findViewById(R.id.b01);
        b02 =(Button)findViewById(R.id.b02);
        b03 =(Button)findViewById(R.id.b03);
        b04 =(Button)findViewById(R.id.b04);
        b05 =(Button)findViewById(R.id.b05);
        b10 =(Button)findViewById(R.id.b10);
        b11 =(Button)findViewById(R.id.b11);
        b12 =(Button)findViewById(R.id.b12);
        b13 =(Button)findViewById(R.id.b13);
        b14 =(Button)findViewById(R.id.b14);
        b15 =(Button)findViewById(R.id.b15);
        b20 =(Button)findViewById(R.id.b20);
        b21 =(Button)findViewById(R.id.b21);
        b22 =(Button)findViewById(R.id.b22);
        b23 =(Button)findViewById(R.id.b23);
        b24 =(Button)findViewById(R.id.b24);
        b25 =(Button)findViewById(R.id.b25);
        b30 =(Button)findViewById(R.id.b30);
        b31 =(Button)findViewById(R.id.b31);
        b32 =(Button)findViewById(R.id.b32);
        b33 =(Button)findViewById(R.id.b33);
        b34 =(Button)findViewById(R.id.b34);
        b35 =(Button)findViewById(R.id.b35);
        b40 =(Button)findViewById(R.id.b40);
        b41 =(Button)findViewById(R.id.b41);
        b42 =(Button)findViewById(R.id.b42);
        b43 =(Button)findViewById(R.id.b43);
        b44 =(Button)findViewById(R.id.b44);
        b45 =(Button)findViewById(R.id.b45);
        b50 =(Button)findViewById(R.id.b50);
        b51 =(Button)findViewById(R.id.b51);
        b52 =(Button)findViewById(R.id.b52);
        b53 =(Button)findViewById(R.id.b53);
        b54 =(Button)findViewById(R.id.b54);
        b55 =(Button)findViewById(R.id.b55);


        t2 =(TextView)findViewById(R.id.T2);
        Tscore =(TextView)findViewById(R.id.Tscore);
        Ttimer =(TextView)findViewById(R.id.T1);

        btGeri =(Button)findViewById(R.id.BTgeri);



    }//setupVariable End





    public  class  CounterClas extends CountDownTimer {

        public  CounterClas(long milisInFuture ,long counDownInterval){
            super(milisInFuture,counDownInterval);
        }
        @Override
        public  void onTick (long milisUntilFinished){

            long milis =milisUntilFinished;
            String hms =String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(milis),
                    TimeUnit.MILLISECONDS.toMinutes(milis)-TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(milis)),
                    TimeUnit.MILLISECONDS.toSeconds(milis)-TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(milis)));
            Ttimer.setText("Kalan Süre :"+hms);
        }
        @Override
        public void onFinish(){
            Ttimer.setText("completed.");

            quit();

        }

    }





 /*   public void color(){


        /**matris elemanlarının son hanesi alınır */
    /*if (s00.equals("1")) {
            b00.setBackgroundResource(R.drawable.futball);
        }else if(s00.equals("2")){
            b00.setBackgroundResource(R.drawable.basket);
        }else if (s00.equals("3"))
        {
            b00.setBackgroundResource(R.drawable.hentball);
        }
        else if (s00.equals("4"))
        {
            b00.setBackgroundResource(R.drawable.hentball);
        }
        else if (s00.equals("5"))
        {
            b00.setBackgroundResource(R.drawable.hentball);
        }

  if (s01.equals("1")) {
            b01.setBackgroundResource(R.drawable.futball);
        }else if(s01.equals("2")){
            b01.setBackgroundResource(R.drawable.basket);
        }else if (s01.equals("3"))
        {
            b01.setBackgroundResource(R.drawable.hentball);
        }
        else if (s01.equals("4"))
        {
            b01.setBackgroundResource(R.drawable.hentball);
        }
        else if (s01.equals("5"))
        {
            b01.setBackgroundResource(R.drawable.hentball);
        }
        if (s02.equals("1")) {
            b02.setBackgroundResource(R.drawable.futball);
        }else if(s02.equals("2")){
            b00.setBackgroundResource(R.drawable.basket);
        }else if (s02.equals("3"))
        {
            b02.setBackgroundResource(R.drawable.hentball);
        }
        else if (s02.equals("4"))
        {
            b02.setBackgroundResource(R.drawable.hentball);
        }
        else if (s02.equals("5"))
        {
            b02.setBackgroundResource(R.drawable.hentball);
        }
        if (s03.equals("1")) {
            b03.setBackgroundResource(R.drawable.futball);
        }else if(s03.equals("2")){
            b03.setBackgroundResource(R.drawable.basket);
        }else if (s03.equals("3"))
        {
            b03.setBackgroundResource(R.drawable.hentball);
        }
        else if (s03.equals("4"))
        {
            b03.setBackgroundResource(R.drawable.hentball);
        }
        else if (s03.equals("5"))
        {
            b03.setBackgroundResource(R.drawable.hentball);
        }

        if (s04.equals("1")) {
            b04.setBackgroundResource(R.drawable.futball);
        }else if(s04.equals("2")){
            b04.setBackgroundResource(R.drawable.basket);
        }else if (s04.equals("3"))
        {
            b04.setBackgroundResource(R.drawable.hentball);
        }
        else if (s04.equals("4"))
        {
            b04.setBackgroundResource(R.drawable.hentball);
        }
        else if (s04.equals("5"))
        {
            b04.setBackgroundResource(R.drawable.hentball);
        }

        if (s05.equals("1")) {
            b05.setBackgroundResource(R.drawable.futball);
        }else if(s00.equals("2")){
            b05.setBackgroundResource(R.drawable.basket);
        }else if (s00.equals("3"))
        {
            b05.setBackgroundResource(R.drawable.hentball);
        }
        else if (s00.equals("4"))
        {
            b05.setBackgroundResource(R.drawable.hentball);
        }
        else if (s00.equals("5"))
        {
            b05.setBackgroundResource(R.drawable.hentball);
        }

        if (s10.equals("1")) {
            b10.setBackgroundResource(R.drawable.futball);
        }else if(s10.equals("2")){
            b10.setBackgroundResource(R.drawable.basket);
        }else if (s10.equals("3"))
        {
            b10.setBackgroundResource(R.drawable.hentball);
        }
        else if (s00.equals("4"))
        {
            b10.setBackgroundResource(R.drawable.hentball);
        }
        else if (s10.equals("5"))
        {
            b10.setBackgroundResource(R.drawable.hentball);

        }
        if (s11.equals("1")) {
            b11.setBackgroundResource(R.drawable.futball);
        }else if(s11.equals("2")){
            b11.setBackgroundResource(R.drawable.basket);
        }else if (s11.equals("3"))
        {
            b11.setBackgroundResource(R.drawable.hentball);
        }
        else if (s11.equals("4"))
        {
            b11.setBackgroundResource(R.drawable.hentball);
        }
        else if (s11.equals("5"))
        {
            b11.setBackgroundResource(R.drawable.hentball);
        }
        if (s12.equals("1")) {
            b12.setBackgroundResource(R.drawable.futball);
        }else if(s12.equals("2")){
            b12.setBackgroundResource(R.drawable.basket);
        }else if (s12.equals("3"))
        {
            b12.setBackgroundResource(R.drawable.hentball);
        }
        else if (s12.equals("4"))
        {
            b12.setBackgroundResource(R.drawable.hentball);
        }
        else if (s12.equals("5"))
        {
            b12.setBackgroundResource(R.drawable.hentball);
        }
        if (s13.equals("1")) {
            b13.setBackgroundResource(R.drawable.futball);
        }else if(s13.equals("2")){
            b00.setBackgroundResource(R.drawable.basket);
        }else if (s13.equals("3"))
        {
            b13.setBackgroundResource(R.drawable.hentball);
        }
        else if (s13.equals("4"))
        {
            b13.setBackgroundResource(R.drawable.hentball);
        }
        else if (s13.equals("5"))
        {
            b13.setBackgroundResource(R.drawable.hentball);
        }
        if (s14.equals("1")) {
            b14.setBackgroundResource(R.drawable.futball);
        }else if(s14.equals("2")){
            b14.setBackgroundResource(R.drawable.basket);
        }else if (s14.equals("3"))
        {
            b14.setBackgroundResource(R.drawable.hentball);
        }
        else if (s14.equals("4"))
        {
            b14.setBackgroundResource(R.drawable.hentball);
        }
        else if (s14.equals("5"))
        {
            b14.setBackgroundResource(R.drawable.hentball);
        }
        if (s15.equals("1")) {
            b15.setBackgroundResource(R.drawable.futball);
        }else if(s15.equals("2")){
            b15.setBackgroundResource(R.drawable.basket);
        }else if (s15.equals("3"))
        {
            b15.setBackgroundResource(R.drawable.hentball);
        }
        else if (s15.equals("4"))
        {
            b15.setBackgroundResource(R.drawable.hentball);
        }
        else if (s15.equals("5"))
        {
            b15.setBackgroundResource(R.drawable.hentball);
        }
        if (s20.equals("1")) {
            b20.setBackgroundResource(R.drawable.futball);
        }else if(s20.equals("2")){
            b20.setBackgroundResource(R.drawable.basket);
        }else if (s20.equals("3"))
        {
            b20.setBackgroundResource(R.drawable.hentball);
        }
        else if (s20.equals("4"))
        {
            b20.setBackgroundResource(R.drawable.hentball);
        }
        else if (s20.equals("5"))
        {
            b20.setBackgroundResource(R.drawable.hentball);
        }
        if (s21.equals("1")) {
            b21.setBackgroundResource(R.drawable.futball);
        }else if(s21.equals("2")){
            b21.setBackgroundResource(R.drawable.basket);
        }else if (s21.equals("3"))
        {
            b21.setBackgroundResource(R.drawable.hentball);
        }
        else if (s21.equals("4"))
        {
            b21.setBackgroundResource(R.drawable.hentball);
        }
        else if (s21.equals("5"))
        {
            b21.setBackgroundResource(R.drawable.hentball);
        }
        if (s22.equals("1")) {
            b22.setBackgroundResource(R.drawable.futball);
        }else if(s22.equals("2")){
            b22.setBackgroundResource(R.drawable.basket);
        }else if (s22.equals("3"))
        {
            b22.setBackgroundResource(R.drawable.hentball);
        }
        else if (s22.equals("4"))
        {
            b22.setBackgroundResource(R.drawable.hentball);
        }
        else if (s22.equals("5"))
        {
            b22.setBackgroundResource(R.drawable.hentball);
        }
        if (s23.equals("1")) {
            b23.setBackgroundResource(R.drawable.futball);
        }else if(s23.equals("2")){
            b23.setBackgroundResource(R.drawable.basket);
        }else if (s23.equals("3"))
        {
            b23.setBackgroundResource(R.drawable.hentball);
        }
        else if (s23.equals("4"))
        {
            b23.setBackgroundResource(R.drawable.hentball);
        }
        else if (s23.equals("5"))
        {
            b23.setBackgroundResource(R.drawable.hentball);
        }
        if (s24.equals("1")) {
            b24.setBackgroundResource(R.drawable.futball);
        }else if(s24.equals("2")){
            b24.setBackgroundResource(R.drawable.basket);
        }else if (s24.equals("3"))
        {
            b24.setBackgroundResource(R.drawable.hentball);
        }
        else if (s24.equals("4"))
        {
            b24.setBackgroundResource(R.drawable.hentball);
        }
        else if (s24.equals("5"))
        {
            b24.setBackgroundResource(R.drawable.hentball);
        }
        if (s25.equals("1")) {
            b25.setBackgroundResource(R.drawable.futball);
        }else if(s25.equals("2")){
            b25.setBackgroundResource(R.drawable.basket);
        }else if (s25.equals("3"))
        {
            b25.setBackgroundResource(R.drawable.hentball);
        }
        else if (s25.equals("4"))
        {
            b25.setBackgroundResource(R.drawable.hentball);
        }
        else if (s25.equals("5"))
        {
            b25.setBackgroundResource(R.drawable.hentball);
        }
        if (s30.equals("1")) {
            b30.setBackgroundResource(R.drawable.futball);
        }else if(s30.equals("2")){
            b30.setBackgroundResource(R.drawable.basket);
        }else if (s30.equals("3"))
        {
            b30.setBackgroundResource(R.drawable.hentball);
        }
        else if (s30.equals("4"))
        {
            b30.setBackgroundResource(R.drawable.hentball);
        }
        else if (s30.equals("5"))
        {
            b30.setBackgroundResource(R.drawable.hentball);
        } //t2.setText(s00);
        if (s31.equals("1")) {
            b31.setBackgroundResource(R.drawable.futball);
        }else if(s31.equals("2")){
            b15.setBackgroundResource(R.drawable.basket);
        }else if (s31.equals("3"))
        {
            b31.setBackgroundResource(R.drawable.hentball);
        }
        else if (s31.equals("4"))
        {
            b31.setBackgroundResource(R.drawable.hentball);
        }
        else if (s31.equals("5"))
        {
            b31.setBackgroundResource(R.drawable.hentball);
        }
        if (s32.equals("1")) {
            b32.setBackgroundResource(R.drawable.futball);
        }else if(s32.equals("2")){
            b32.setBackgroundResource(R.drawable.basket);
        }else if (s32.equals("3"))
        {
            b32.setBackgroundResource(R.drawable.hentball);
        }
        else if (s32.equals("4"))
        {
            b32.setBackgroundResource(R.drawable.hentball);
        }
        else if (s32.equals("5"))
        {
            b32.setBackgroundResource(R.drawable.hentball);
        }
        if (s33.equals("1")) {
            b33.setBackgroundResource(R.drawable.futball);
        }else if(s33.equals("2")){
            b33.setBackgroundResource(R.drawable.basket);
        }else if (s33.equals("3"))
        {
            b33.setBackgroundResource(R.drawable.hentball);
        }
        else if (s33.equals("4"))
        {
            b33.setBackgroundResource(R.drawable.hentball);
        }
        else if (s33.equals("5"))
        {
            b33.setBackgroundResource(R.drawable.hentball);
        }
        t34 =String.valueOf(matrisOyun[3][4]);
        s34 =t34.substring(t34.length() - 1);
        if (s34.equals("1")) {
            b34.setBackgroundResource(R.drawable.futball);
        }else if(s34.equals("2")){
            b34.setBackgroundResource(R.drawable.basket);
        }else if (s34.equals("3"))
        {
            b34.setBackgroundResource(R.drawable.hentball);
        }
        else if (s34.equals("4"))
        {
            b34.setBackgroundResource(R.drawable.hentball);
        }
        else if (s34.equals("5"))
        {
            b34.setBackgroundResource(R.drawable.hentball);
        }
        if (s35.equals("1")) {
            b35.setBackgroundResource(R.drawable.futball);
        }else if(s35.equals("2")){
            b35.setBackgroundResource(R.drawable.basket);
        }else if (s35.equals("3"))
        {
            b35.setBackgroundResource(R.drawable.hentball);
        }
        else if (s35.equals("4"))
        {
            b35.setBackgroundResource(R.drawable.hentball);
        }
        else if (s35.equals("5"))
        {
            b35.setBackgroundResource(R.drawable.hentball);
        }
        if (s40.equals("1")) {
            b40.setBackgroundResource(R.drawable.futball);
        }else if(s40.equals("2")){
            b40.setBackgroundResource(R.drawable.basket);
        }else if (s40.equals("3"))
        {
            b40.setBackgroundResource(R.drawable.hentball);
        }
        else if (s40.equals("4"))
        {
            b40.setBackgroundResource(R.drawable.hentball);
        }
        else if (s40.equals("5"))
        {
            b40.setBackgroundResource(R.drawable.hentball);
        } //t2.setText(s00);
        if (s41.equals("1")) {
            b41.setBackgroundResource(R.drawable.futball);
        }else if(s41.equals("2")){
            b41.setBackgroundResource(R.drawable.basket);
        }else if (s41.equals("3"))
        {
            b41.setBackgroundResource(R.drawable.hentball);
        }
        else if (s41.equals("4"))
        {
            b41.setBackgroundResource(R.drawable.hentball);
        }
        else if (s41.equals("5"))
        {
            b41.setBackgroundResource(R.drawable.hentball);
        }
        if (s42.equals("1")) {
            b42.setBackgroundResource(R.drawable.futball);
        }else if(s42.equals("2")){
            b42.setBackgroundResource(R.drawable.basket);
        }else if (s42.equals("3"))
        {
            b42.setBackgroundResource(R.drawable.hentball);
        }
        else if (s42.equals("4"))
        {
            b42.setBackgroundResource(R.drawable.hentball);
        }
        else if (s42.equals("5"))
        {
            b42.setBackgroundResource(R.drawable.hentball);
        }
        if (s43.equals("1")) {
            b43.setBackgroundResource(R.drawable.futball);
        }else if(s43.equals("2")){
            b43.setBackgroundResource(R.drawable.basket);
        }else if (s43.equals("3"))
        {
            b43.setBackgroundResource(R.drawable.hentball);
        }
        else if (s43.equals("4"))
        {
            b43.setBackgroundResource(R.drawable.hentball);
        }
        else if (s43.equals("5"))
        {
            b43.setBackgroundResource(R.drawable.hentball);
        }
        if (s44.equals("1")) {
            b44.setBackgroundResource(R.drawable.futball);
        }else if(s44.equals("2")){
            b44.setBackgroundResource(R.drawable.basket);
        }else if (s44.equals("3"))
        {
            b44.setBackgroundResource(R.drawable.hentball);
        }
        else if (s44.equals("4"))
        {
            b44.setBackgroundResource(R.drawable.hentball);
        }
        else if (s44.equals("5"))
        {
            b44.setBackgroundResource(R.drawable.hentball);
        }
        if (s45.equals("1")) {
            b45.setBackgroundResource(R.drawable.futball);
        }else if(s45.equals("2")){
            b45.setBackgroundResource(R.drawable.basket);
        }else if (s45.equals("3"))
        {
            b45.setBackgroundResource(R.drawable.hentball);
        }
        else if (s45.equals("4"))
        {
            b45.setBackgroundResource(R.drawable.hentball);
        }
        else if (s45.equals("5"))
        {
            b45.setBackgroundResource(R.drawable.hentball);
        }
        if (s50.equals("1")) {
            b50.setBackgroundResource(R.drawable.futball);
        }else if(s50.equals("2")){
            b50.setBackgroundResource(R.drawable.basket);
        }else if (s50.equals("3"))
        {
            b50.setBackgroundResource(R.drawable.hentball);
        }
        else if (s50.equals("4"))
        {
            b50.setBackgroundResource(R.drawable.hentball);
        }
        else if (s50.equals("5"))
        {
            b50.setBackgroundResource(R.drawable.hentball);
        }
        if (s51.equals("1")) {
            b51.setBackgroundResource(R.drawable.futball);
        }else if(s51.equals("2")){
            b51.setBackgroundResource(R.drawable.basket);
        }else if (s51.equals("3"))
        {
            b51.setBackgroundResource(R.drawable.hentball);
        }
        else if (s51.equals("4"))
        {
            b51.setBackgroundResource(R.drawable.hentball);
        }
        else if (s51.equals("5"))
        {
            b51.setBackgroundResource(R.drawable.hentball);
        }
        if (s52.equals("1")) {
            b52.setBackgroundResource(R.drawable.futball);
        }else if(s52.equals("2")){
            b52.setBackgroundResource(R.drawable.basket);
        }else if (s52.equals("3"))
        {
            b52.setBackgroundResource(R.drawable.hentball);
        }
        else if (s52.equals("4"))
        {
            b52.setBackgroundResource(R.drawable.hentball);
        }
        else if (s52.equals("5"))
        {
            b52.setBackgroundResource(R.drawable.hentball);
        }
        if (s53.equals("1")) {
            b53.setBackgroundResource(R.drawable.futball);
        }else if(s53.equals("2")){
            b53.setBackgroundResource(R.drawable.basket);
        }else if (s53.equals("3"))
        {
            b53.setBackgroundResource(R.drawable.hentball);
        }
        else if (s53.equals("4"))
        {
            b53.setBackgroundResource(R.drawable.hentball);
        }
        else if (s53.equals("5"))
        {
            b53.setBackgroundResource(R.drawable.hentball);
        }
        if (s54.equals("1")) {
            b54.setBackgroundResource(R.drawable.futball);
        }else if(s54.equals("2")){
            b54.setBackgroundResource(R.drawable.basket);
        }else if (s54.equals("3"))
        {
            b54.setBackgroundResource(R.drawable.hentball);
        }
        else if (s54.equals("4"))
        {
            b54.setBackgroundResource(R.drawable.hentball);
        }
        else if (s54.equals("5"))
        {
            b54.setBackgroundResource(R.drawable.hentball);
        }
        if (s55.equals("1")) {
            b55.setBackgroundResource(R.drawable.futball);
        }else if(s55.equals("2")){
            b55.setBackgroundResource(R.drawable.basket);
        }else if (s55.equals("3"))
        {
            b55.setBackgroundResource(R.drawable.hentball);
        }
        else if (s55.equals("4"))
        {
            b55.setBackgroundResource(R.drawable.hentball);
        }
        else if (s55.equals("5"))
        {
            b55.setBackgroundResource(R.drawable.hentball);
        }

        /*if (s55.equals(0)){
            b55.setBackground(R.drawable.futball);
        }
        if (b00.getText().toString().length()-1==1){
            b00.setBackgroundResource(R.drawable.hentball);
            b00.setTextColor(Color.WHITE);
        }
        else if (b00.getText().toString().length()-1==2){
            b00.setBackgroundResource(R.drawable.basket);
            b00.setTextColor(Color.BLACK);
        }
        else if (b00.getText().toString().length()-1==3){
            //   b00.setBackgroundResource(R.drawable.hentball);
            b00.setBackgroundResource(R.drawable.futball);
            b00.setTextColor(Color.WHITE);
        }
        else if (b00.getText().toString().length()-1==4){
        }
        else {
            b00.setTextColor(Color.hentball);
        } */
        /**
         b00.setBackgroundColor(Color.hentball);
         b02.setTextColor(Color.BLACK);
         b33.setBackgroundColor(Color.WHITE);
         b44.setTextColor(Color.futball);
         b55.setBackgroundColor(Color.YELLOW);
         b11.setTextColor(Color.basket);
         bakgroun image
         b05.setBackgroundResource(R.drawable.futball);
         */

    //}




}
