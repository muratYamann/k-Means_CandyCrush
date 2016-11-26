package com.example.murat.readandconvert;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.spec.ECField;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public static  String TAG ="_Main";

    EditText ETnumberCluster;
    Button   BTNread,BTNCreateKmeans,BTNkolay,BTNorta,BTNzor;
    TextView tv;



    final static int PERMISSIONS_REQUEST_CODE = 1;

    WriteToFile w1 =new WriteToFile();
    ReadToFile readToFile = new ReadToFile();

    Random rnd =new Random();
    int []rnddizi ;

    String fileClusterName1 ="cluster1.csv";
    String fileClusterName2 ="cluster2.csv";
    String fileClusterName3 ="cluster3.csv";
    String fileClusterName4 ="cluster4.csv";
    String fileClusterName5 ="cluster5.csv";

    String decimalFileName  ="renk_dec.csv";
    String hexFileName      ="renk_hex.csv";

    String[] cluster1;
    String[] cluster2;
    String[] cluster3;
    String[] cluster4;
    String[] cluster5;
    String[] decimal;

    int dizi1Counter=1;
    int dizi2Counter=1;
    int dizi3Counter=1;
    int dizi4Counter=1;
    int dizi5Counter=1;

    int dizi1Sum =0;
    int dizi2Sum =0;
    int dizi3Sum =0;
    int dizi4Sum =0;
    int dizi5Sum =0;

    int dizi1Avarage =0;
    int dizi2Avarage =0;
    int dizi3Avarage =0;
    int dizi4Avarage =0;
    int dizi5Avarage =0;

    int count1 =0;
    int count2 =0;
    int count3 =0;
    int count4 =0;
    int count5 =0;

    int centroid1 ;
    int centroid2 ;
    int centroid3 ;
    int centroid4 ;
    int centroid5 ;


    int newTepm ;




    int difference1 ;
    int difference2 ;
    int difference3 ;
    int difference4 ;
    int difference5 ;

    String[] cluster2_1Centroit ;
    String[] cluster3_1Centroit ;
    String[] cluster4_1Centroit ;
    String[] cluster5_1Centroit ;

    String dizi1[];
    String dizi2[];
    String dizi3[];
    String dizi4[];
    String dizi5[];

    Boolean sayi1 =true;
    Boolean sayi2 =true;
    Boolean sayi3 =true;
    Boolean sayi4 =true;
    Boolean sayi5 =true;

    public ArrayList<String> liste;
    public  ArrayList<String>listedec;
    String mesaj;

    MediaPlayer mp ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getPermissionRead();
        getPermissionWriteExternalStorage();

        SetupVariable();
        onClick();

        Uri path= Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.btn);
        mp =MediaPlayer.create(MainActivity.this,path);



        liste=new ArrayList<String>();
        listedec=new ArrayList<String>();
        /**dosyadan okuma için ReadToFile clasından nesne
         * üretip o nesneye okunacak dosya ismi gonder*/

        readToFile.ReadFile(hexFileName);

        /**okunan dosyada Arraylist tanımlanmıstı listenin bütün elemanları
         * aynı şekilde main de de tanımlanan Arraylist e atandı  */
        liste = readToFile.liste;

        decimal = new String[liste.size()];/**decimal dizisi icin listenin boyutunu  al*/
        cluster1 =new String[80];
        cluster2 =new String[80];
        cluster3 =new String[80];
        cluster4 =new String[60];
        cluster5 =new String[60];


        BTNread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();

                for (int i = 0; i < liste.size(); i++) {
                       mesaj = liste.get(i);
                       String []mesaj2=mesaj.split(" ");
                       String last =mesaj2[mesaj2.length-1];
                       int d =Integer.parseInt(last,16);
                       decimal[i]=d+"";
                }//for end

                WriteToFile writeMyFile=new WriteToFile();
                writeMyFile.WriteFile(decimalFileName,decimal);
            }
        });/**button end*/




            BTNCreateKmeans.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    mp.start();

                    int cluster =Integer.parseInt(ETnumberCluster.getText().toString());


                    ReadToFile read =new ReadToFile();
                    read.ReadFile("renk_dec.csv");
                    listedec=read.liste;

                    /**cluster 2*/

                    if (cluster==2){

                        cluster2_1Centroit =new String[2];

                        rnddizi =new int[2];
                        for (int i=0; i<2;i++){
                            rnddizi[i] =rnd.nextInt(142);
                        }

                       Log.d(TAG, "random secilen sayılar alma ");
                       for (int k=0; k<listedec.size();k++){
                        if(k==rnddizi[0]){
                            cluster2_1Centroit[0]=listedec.get(k);//cluster centroid
                            Log.d(TAG, "Random_kume1 "+cluster2_1Centroit[0]);
                        }
                        if(k==rnddizi[1]){
                            cluster2_1Centroit[1]=listedec.get(k);
                            Log.d(TAG, "Random_kume2 "+cluster2_1Centroit[1]);
                        }
                    }
                        tv.setText("1. cluster centroid :"+cluster2_1Centroit[0]+"\n"+
                                   "2. cluster centroid :"+cluster2_1Centroit[1]);



                        centroid1 =Integer.parseInt(cluster2_1Centroit[0].toString());
                        centroid2 =Integer.parseInt(cluster2_1Centroit[1].toString());

                        dizi1[0]=String.valueOf(centroid1);
                        Log.d(TAG, "kume1 ilk eleman "+dizi1[0]);
                        dizi2[0]=String.valueOf(centroid2);
                        Log.d(TAG, "kume2 ilk eleman "+dizi2[0]);


                        for (int m =0; m<listedec.size();m++){
                            /**dizi1 deki elemanların ortalamasını hesaplar */

                              Log.d(TAG, "kume 1 de ki sayac :"+count1);

                            if(sayi1==true) {

                                double dizi1Eleman =Double.valueOf(dizi1[count1]);
                                //int dizi1Eleman = Integer.parseInt(dizi1[count1]);
                                dizi1Sum += dizi1Eleman;
                                Log.d(TAG, "kume1 elamnlarının toplamı " + dizi1Sum);
                                count1++;
                                sayi1=false;
                                dizi1Avarage=dizi1Sum/count1;
                            }

                            Log.d(TAG, "kume 1 elemanlarının ortalaması :"+dizi1Avarage);
                            Log.d(TAG, "kume1 eleman sayisi"+count1);

                            /**dizi2 deki elemanların ortalamasını hesaplar*/


                            if (sayi2==true) {


                                double dizi2Eleman=Double.valueOf(dizi2[count2]);
                                //int dizi2Eleman = Integer.parseInt(dizi2[count2]);
                                dizi2Sum += dizi2Eleman;
                                Log.d(TAG, "kume2 elamnlarının toplamı:" + dizi2Sum);
                                 count2++;
                                dizi2Avarage =dizi2Sum/count2;
                                sayi2 =false;
                            }

                            int newTepm =Integer.parseInt(listedec.get(m));

                            int difference1 =Math.abs(dizi1Avarage-newTepm);
                            int difference2 =Math.abs(dizi2Avarage-newTepm);



                            if ((difference1<difference2)){
                                Log.d(TAG, "if 1dongüsü :"+listedec.get(m));
                                String temp =listedec.get(m);
                                String yeniTemp= temp.substring(0,temp.length()-1);
                                dizi1[dizi1Counter]=yeniTemp+1;
                                //dizi1[dizi1Counter]=listedec.get(m);
                                Log.d(TAG, "if 1 dongüsü :"+dizi1[dizi1Counter]);
                                dizi1Counter++;
                                sayi1=true;
                            }else {
                                String temp2=listedec.get(m);
                                String yeniTemp= temp2.substring(0, temp2.length()- 1);
                                dizi2[dizi2Counter] =yeniTemp+2;
                                Log.d(TAG, "if 2 :" + dizi2[dizi2Counter]);
                                dizi2Counter++;
                                sayi2 = true;
                            }

                            w1.WriteFile(fileClusterName1,dizi1);
                            w1.WriteFile(fileClusterName2,dizi2);

                       }//for end
                    }//cluster 2 end



                            /**Cluster3*/


                    if (cluster==3){

                        cluster3_1Centroit =new String[3];

                        rnddizi =new int[3];
                        for (int i=0; i<3;i++){
                            rnddizi[i] =rnd.nextInt(142);
                        }

                        Log.d(TAG, "random secilen sayılar alma ");
                        for (int k=0; k<listedec.size();k++){
                            if(k==rnddizi[0]){
                                cluster3_1Centroit[0]=listedec.get(k);//cluster centroid
                                Log.d(TAG, "Random_kume1 "+cluster3_1Centroit[0]);
                            }
                            if(k==rnddizi[1]){
                                cluster3_1Centroit[1]=listedec.get(k);
                                Log.d(TAG, "Random_kume2 "+cluster3_1Centroit[1]);
                            }

                            if(k==rnddizi[2]){
                                cluster3_1Centroit[2]=listedec.get(k);
                                Log.d(TAG, "Random_kume3 "+cluster3_1Centroit[2]);
                            }
                        }
                        tv.setText("1. cluster centroid :" +cluster3_1Centroit[0]+"\n"+
                                   "2. cluster centroid :" +cluster3_1Centroit[1]+"\n"+
                                   "3. cluster centroid :" +cluster3_1Centroit[2]);


                        centroid1 =Integer.parseInt(cluster3_1Centroit[0].toString());
                        centroid2 =Integer.parseInt(cluster3_1Centroit[1].toString());
                        centroid3 =Integer.parseInt(cluster3_1Centroit[2].toString());

                        dizi1[0]=String.valueOf(centroid1);
                        Log.d(TAG, "kume1 ilk eleman "+dizi1[0]);
                        dizi2[0]=String.valueOf(centroid2);
                        Log.d(TAG, "kume2 ilk eleman "+dizi2[0]);
                        dizi3[0]=String.valueOf(centroid3);
                        Log.d(TAG, "kume3 ilk eleman "+dizi3[0]);

                        for (int m =0; m<listedec.size();m++){
                            /**dizi1 deki elemanların ortalamasını hesaplar */
                            Log.d(TAG, "kume 1 de ki sayac :"+count1);

                            if(sayi1==true) {
                                int dizi1Eleman = Integer.parseInt(dizi1[count1]);
                                dizi1Sum += dizi1Eleman;
                                Log.d(TAG, "kume1 elamnlarının toplamı " + dizi1Sum);
                                count1++;
                                sayi1=false;
                                dizi1Avarage=dizi1Sum/count1;

                            }
                            if (sayi2==true) {
                                int dizi2Eleman = Integer.parseInt(dizi2[count2]);
                                dizi2Sum += dizi2Eleman;
                                Log.d(TAG, "kume2 elamnlarının toplamı:" + dizi2Sum);
                                count2++;
                                dizi2Avarage =dizi2Sum/count2;
                                sayi2 =false;

                            }
                            if (sayi3==true) {
                                int dizi3Eleman = Integer.parseInt(dizi3[count3]);
                                dizi3Sum += dizi3Eleman;
                                Log.d(TAG, "kume2 elamnlarının toplamı:" + dizi3Sum);
                                count3++;
                                dizi3Avarage =dizi3Sum/count3;
                                sayi3 =false;

                            }

                             newTepm =Integer.parseInt(listedec.get(m));

                             difference1 =Math.abs(dizi1Avarage - newTepm);
                             difference2 =Math.abs(dizi2Avarage - newTepm);
                             difference3 =Math.abs(dizi3Avarage - newTepm);

                            if ((difference1<difference2)&&(difference1<difference3)){

                                String temp =listedec.get(m);
                                String yeniTemp= temp.substring(0, temp.length() - 1);
                                dizi1[dizi1Counter]=yeniTemp+1;
                                //dizi1[dizi1Counter]=listedec.get(m);
                                Log.d(TAG, "if 1 dongüsü :"+dizi1[dizi1Counter]);
                                dizi1Counter++;
                                sayi1=true;
                                ///l1++;
                            }else if ((difference2<difference1)&&(difference2<difference3)){
                                 String temp =listedec.get(m);
                                String yeniTemp= temp.substring(0,temp.length()-1);
                                dizi2[dizi2Counter]=yeniTemp+2;
                                Log.d(TAG, "if 2 :"+dizi2[dizi2Counter]);
                                dizi2Counter++;
                                sayi2=true;
                               /// l2++;

                            }else {

                                String temp =listedec.get(m);
                                String yeniTemp= temp.substring(0,temp.length()-1);
                                dizi3[dizi3Counter]=yeniTemp+3;
                                Log.d(TAG, " if 3 :"+dizi3[dizi3Counter]);
                                dizi3Counter++;
                                sayi3=true;
                                //l3++;
                            }

                            w1.WriteFile(fileClusterName1,dizi1);
                            w1.WriteFile(fileClusterName2,dizi2);
                            w1.WriteFile(fileClusterName3,dizi3);
                            
                        }//for end
                    }//cluster 3 end





                    /**Cluster4*/
/*
                    if (cluster==4){

                        cluster4_1Centroit =new String[4];

                        rnddizi =new int[4];
                        for (int i=0; i<4; i++){
                            rnddizi[i] =rnd.nextInt(142);
                        }

                        Log.d(TAG, "random secilen sayılar alma ");

                        for (int k=0; k<listedec.size();k++){
                            if(k==rnddizi[0]){
                                cluster4_1Centroit[0]=listedec.get(k);//cluster centroid
                                Log.d(TAG, "Random_kume1 "+cluster4_1Centroit[0]);
                            }
                            if(k==rnddizi[1]){
                                cluster4_1Centroit[1]=listedec.get(k);
                                Log.d(TAG, "Random_kume2 "+cluster4_1Centroit[1]);
                            }
                            if(k==rnddizi[2]){
                                cluster4_1Centroit[2]=listedec.get(k);
                                Log.d(TAG, "Random_kume3 "+cluster4_1Centroit[2]);
                            }
                            if(k==rnddizi[3]){
                                cluster4_1Centroit[3]=listedec.get(k);
                                Log.d(TAG, "Random_kume4 "+cluster4_1Centroit[3]);
                            }

                        }
                        tv.setText("1. cluster centroid :"+cluster4_1Centroit[0]+"\n"+
                                   "2. cluster centroid :"+cluster4_1Centroit[1]+"\n"+
                                   "3. cluster centroid :"+cluster4_1Centroit[2]+"\n"+
                                   "4. cluster centroid :"+cluster4_1Centroit[3]);


                        centroid1 =Integer.parseInt(cluster4_1Centroit[0].toString());
                        centroid2 =Integer.parseInt(cluster4_1Centroit[1].toString());
                        centroid3 =Integer.parseInt(cluster4_1Centroit[2].toString());
                        centroid4 =Integer.parseInt(cluster4_1Centroit[3].toString());

                        dizi1[0]=String.valueOf(centroid1);
                        Log.d(TAG, "kume1 ilk eleman "+dizi1[0]);
                        dizi2[0]=String.valueOf(centroid2);
                        Log.d(TAG, "kume2 ilk eleman "+dizi2[0]);
                        dizi3[0]=String.valueOf(centroid3);
                        Log.d(TAG, "kume3 ilk eleman "+dizi3[0]);
                        dizi4[0]=String.valueOf(centroid4);
                        Log.d(TAG, "kume4 ilk eleman "+dizi4[0]);

                        for (int m =0; m<listedec.size();m++){
                            /**dizi1 deki elemanların ortalamasını hesaplar */
      /*                      Log.d(TAG, "kume 1 de ki sayac :"+count1);

                            if(sayi1==true) {

                                int dizi1Eleman = Integer.parseInt(dizi1[count1]);
                                dizi1Sum += dizi1Eleman;
                                Log.d(TAG, "kume1 elamnlarının toplamı " + dizi1Sum);
                                count1++;
                                sayi1=false;
                                dizi1Avarage=dizi1Sum/count1;
                            }

                            Log.d(TAG, "kume 1 elemanlarının ortalaması :"+dizi1Avarage);
                            Log.d(TAG, "kume1 eleman sayisi"+count1);

                            /**dizi2 deki elemanların ortalamasını hesaplar*/

    /*                        if (sayi2==true) {

                                int dizi2Eleman = Integer.parseInt(dizi2[count2]);
                                dizi2Sum += dizi2Eleman;
                                Log.d(TAG, "kume2 elamnlarının toplamı:" + dizi2Sum);
                                count2++;
                                dizi2Avarage =dizi2Sum/count2;
                                sayi2 =false;
                            }

                            if (sayi3==true) {

                                int dizi3Eleman = Integer.parseInt(dizi3[count3]);
                                dizi3Sum += dizi3Eleman;
                                Log.d(TAG, "kume2 elamnlarının toplamı:" + dizi3Sum);
                                count3++;
                                dizi3Avarage =dizi3Sum/count3;
                                sayi3 =false;
                            }

                            if (sayi4==true) {

                                int dizi4Eleman = Integer.parseInt(dizi4[count4]);
                                dizi4Sum += dizi4Eleman;
                                Log.d(TAG, "kume2 elamnlarının toplamı:" + dizi4Sum);
                                count4++;
                                dizi4Avarage =dizi4Sum/count4;
                                sayi4 =false;
                            }

                              newTepm =Integer.parseInt(listedec.get(m));

                              difference1 =Math.abs(dizi1Avarage - newTepm);
                              difference2 =Math.abs(dizi2Avarage - newTepm);
                              difference3 =Math.abs(dizi3Avarage - newTepm);
                              difference4 =Math.abs(dizi4Avarage - newTepm);

                            if ((difference1<difference2)&&(difference1<difference3)&&(difference1<difference4)){
                                Log.d(TAG, "if 1dongüsü :"+listedec.get(m));

                                String temp =listedec.get(m);
                                String yeniTemp= temp.substring(0,temp.length()-1);
                                dizi1[dizi1Counter]=yeniTemp+1;
                                //dizi1[dizi1Counter]=listedec.get(m);
                                Log.d(TAG, "if 1 dongüsü :"+dizi1[dizi1Counter]);
                                dizi1Counter++;
                                sayi1=true;

                            }else if ((difference2<difference1)&&(difference2<difference3)&&(difference2<difference4)){

                                String temp =listedec.get(m);
                                String yeniTemp= temp.substring(0,temp.length()-1);
                                dizi1[dizi2Counter]=yeniTemp+2;
                                Log.d(TAG, "if 2 :"+dizi2[dizi2Counter]);
                                dizi2Counter++;
                                sayi2=true;

                            }else if ((difference3<difference1)&&(difference3<difference2)&&(difference3<difference4)){

                                String temp =listedec.get(m);
                                String yeniTemp= temp.substring(0,temp.length()-1);

                                dizi3[dizi3Counter]=yeniTemp+3;
                                Log.d(TAG, " if 3 :"+dizi3[dizi3Counter]);
                                dizi3Counter++;
                                sayi3=true;

                            }else {

                                String temp =listedec.get(m);
                                String yeniTemp= temp.substring(0,temp.length()-1);
                                dizi4[dizi4Counter]=yeniTemp+4;
                                Log.d(TAG, " if 4 :"+dizi4[dizi4Counter]);
                                dizi4Counter++;
                                sayi4=true;
                            }


                            w1.WriteFile(fileClusterName1,dizi1);
                            w1.WriteFile(fileClusterName2,dizi2);
                            w1.WriteFile(fileClusterName3,dizi3);
                            w1.WriteFile(fileClusterName4,dizi4);
                        }//for end
                    }//cluster 4 end

*/


                    if (cluster==4){

                        cluster4_1Centroit =new String[4];

                        rnddizi =new int[4];
                        for (int i=0; i<4;i++){
                            rnddizi[i] =rnd.nextInt(142);
                        }

                        Log.d(TAG, "random secilen sayılar alma ");

                        for (int k=0; k<listedec.size();k++){
                            if(k==rnddizi[0]){
                                cluster4_1Centroit[0]=listedec.get(k);//cluster centroid
                                Log.d(TAG, "Random_kume1 "+cluster5_1Centroit[0]);
                            }
                            if(k==rnddizi[1]){
                                cluster4_1Centroit[1]=listedec.get(k);
                                Log.d(TAG, "Random_kume2 "+cluster5_1Centroit[1]);
                            }
                            if(k==rnddizi[2]){
                                cluster4_1Centroit[2]=listedec.get(k);
                                Log.d(TAG, "Random_kume3 "+cluster5_1Centroit[2]);
                            }
                            if(k==rnddizi[3]){
                                cluster4_1Centroit[3]=listedec.get(k);
                                Log.d(TAG, "Random_kume4 "+cluster4_1Centroit[3]);
                            }

                        }
                        tv.setText("1. cluster centroid  :"+cluster4_1Centroit[0]+"\n"+
                                "2. cluster centroid  :"+cluster4_1Centroit[1]+"\n"+
                                "3. cluster centroid  :"+cluster4_1Centroit[2]+"\n"+
                                "4. cluster centroid  :"+cluster4_1Centroit[3]+"\n"+
                                "5. cluster centroid  :"+cluster4_1Centroit[4]);


                        centroid1 =Integer.parseInt(cluster4_1Centroit[0].toString());
                        centroid2 =Integer.parseInt(cluster4_1Centroit[1].toString());
                        centroid3 =Integer.parseInt(cluster4_1Centroit[2].toString());
                        centroid4 =Integer.parseInt(cluster4_1Centroit[3].toString());

                        dizi1[0]=String.valueOf(centroid1);
                        Log.d(TAG, "kume1 ilk eleman "+dizi1[0]);
                        dizi2[0]=String.valueOf(centroid2);
                        Log.d(TAG, "kume2 ilk eleman "+dizi2[0]);
                        dizi3[0]=String.valueOf(centroid3);
                        Log.d(TAG, "kume3 ilk eleman "+dizi3[0]);
                        dizi4[0]=String.valueOf(centroid4);
                        Log.d(TAG, "kume4 ilk eleman "+dizi4[0]);


                        for (int m =0; m<listedec.size();m++){
                            /**dizi1 deki elemanların ortalamasını hesaplar */
                            Log.d(TAG, "kume 1 de ki sayac :"+count1);

                            if(sayi1==true) {

                                int dizi1Eleman = Integer.parseInt(dizi1[count1]);
                                dizi1Sum += dizi1Eleman;
                                Log.d(TAG, "kume1 elamnlarının toplamı " + dizi1Sum);
                                count1++;
                                sayi1=false;
                                dizi1Avarage=dizi1Sum/count1;
                            }

                            Log.d(TAG, "kume 1 elemanlarının ortalaması :"+dizi1Avarage);
                            Log.d(TAG, "kume1 eleman sayisi"+count1);

                            /**dizi2 deki elemanların ortalamasını hesaplar*/

                            if (sayi2==true) {

                                int dizi2Eleman = Integer.parseInt(dizi2[count2]);
                                dizi2Sum += dizi2Eleman;
                                Log.d(TAG, "kume2 elamnlarının toplamı:" + dizi2Sum);
                                count2++;
                                dizi2Avarage =dizi2Sum/count2;
                                sayi2 =false;
                            }

                            if (sayi3==true) {

                                int dizi3Eleman = Integer.parseInt(dizi3[count3]);
                                dizi3Sum += dizi3Eleman;
                                Log.d(TAG, "kume2 elamnlarının toplamı:" + dizi3Sum);
                                count3++;
                                dizi3Avarage =dizi3Sum/count3;
                                sayi3 =false;
                            }

                            if (sayi4==true) {
                                int dizi4Eleman = Integer.parseInt(dizi4[count4]);
                                dizi4Sum += dizi4Eleman;
                                Log.d(TAG, "kume2 elamnlarının toplamı:" + dizi4Sum);
                                count4++;
                                dizi4Avarage =dizi4Sum/count4;
                                sayi4 =false;
                            }


                            newTepm =Integer.parseInt(listedec.get(m));

                            difference1 =Math.abs(dizi1Avarage - newTepm);
                            difference2 =Math.abs(dizi2Avarage - newTepm);
                            difference3 =Math.abs(dizi3Avarage - newTepm);
                            difference4 =Math.abs(dizi4Avarage - newTepm);

                            if ((difference1<difference2)&&(difference1<difference3)&&(difference1<difference4)){

                                String temp =listedec.get(m);
                                String yeniTemp= temp.substring(0,temp.length()-1);
                                dizi1[dizi1Counter]=yeniTemp+1;
                                dizi1Counter++;
                                sayi1=true;
                            }else if ((difference2<difference1)&&(difference2<difference3)&&(difference2<difference4)){

                                String temp =listedec.get(m);
                                String yeniTemp= temp.substring(0,temp.length()-1);
                                dizi2[dizi2Counter]=yeniTemp+2;
                                Log.d(TAG, "if 2 :"+dizi2[dizi2Counter]);
                                dizi2Counter++;
                                sayi2=true;
                            }else if ((difference3<difference1)&&(difference3<difference2)&&(difference3<difference4)){

                                String temp =listedec.get(m);
                                String yeniTemp= temp.substring(0,temp.length()-1);
                                dizi3[dizi3Counter]=yeniTemp+3;
                                Log.d(TAG, " if 3 :"+dizi3[dizi3Counter]);
                                dizi3Counter++;
                                sayi3=true;

                            } else  {

                                String temp =listedec.get(m);
                                String yeniTemp= temp.substring(0,temp.length()-1);
                                dizi4[dizi4Counter] = yeniTemp+4;
                                Log.d(TAG, " if 3 :" + dizi4[dizi4Counter]);
                                dizi4Counter++;
                                sayi4 = true;
                            }



                            w1.WriteFile(fileClusterName1,dizi1);
                            w1.WriteFile(fileClusterName2,dizi2);
                            w1.WriteFile(fileClusterName3,dizi3);
                            w1.WriteFile(fileClusterName4,dizi4);

                        }//for end
                    }//cluster 5 end











                    /**Cluster5*/

                    if (cluster==5){

                        cluster5_1Centroit =new String[5];

                        rnddizi =new int[5];
                        for (int i=0; i<5;i++){
                            rnddizi[i] =rnd.nextInt(142);
                        }

                        Log.d(TAG, "random secilen sayılar alma ");

                        for (int k=0; k<listedec.size();k++){
                            if(k==rnddizi[0]){
                                cluster5_1Centroit[0]=listedec.get(k);//cluster centroid
                                Log.d(TAG, "Random_kume1 "+cluster5_1Centroit[0]);
                            }
                            if(k==rnddizi[1]){
                                cluster5_1Centroit[1]=listedec.get(k);
                                Log.d(TAG, "Random_kume2 "+cluster5_1Centroit[1]);
                            }
                            if(k==rnddizi[2]){
                                cluster5_1Centroit[2]=listedec.get(k);
                                Log.d(TAG, "Random_kume3 "+cluster5_1Centroit[2]);
                            }
                            if(k==rnddizi[3]){
                                cluster5_1Centroit[3]=listedec.get(k);
                                Log.d(TAG, "Random_kume4 "+cluster5_1Centroit[3]);
                            }
                            if(k==rnddizi[4]){
                                cluster5_1Centroit[4]=listedec.get(k);
                                Log.d(TAG, "Random_kume5 "+cluster5_1Centroit[4]);
                            }

                        }
                        tv.setText("1. cluster centroid  :"+cluster5_1Centroit[0]+"\n"+
                                   "2. cluster centroid  :"+cluster5_1Centroit[1]+"\n"+
                                   "3. cluster centroid  :"+cluster5_1Centroit[2]+"\n"+
                                   "4. cluster centroid  :"+cluster5_1Centroit[3]+"\n"+
                                   "5. cluster centroid  :"+cluster5_1Centroit[4]);


                        centroid1 =Integer.parseInt(cluster5_1Centroit[0].toString());
                        centroid2 =Integer.parseInt(cluster5_1Centroit[1].toString());
                        centroid3 =Integer.parseInt(cluster5_1Centroit[2].toString());
                        centroid4 =Integer.parseInt(cluster5_1Centroit[3].toString());
                        centroid5 =Integer.parseInt(cluster5_1Centroit[4].toString());

                        dizi1[0]=String.valueOf(centroid1);
                        Log.d(TAG, "kume1 ilk eleman "+dizi1[0]);
                        dizi2[0]=String.valueOf(centroid2);
                        Log.d(TAG, "kume2 ilk eleman "+dizi2[0]);
                        dizi3[0]=String.valueOf(centroid3);
                        Log.d(TAG, "kume3 ilk eleman "+dizi3[0]);
                        dizi4[0]=String.valueOf(centroid4);
                        Log.d(TAG, "kume4 ilk eleman "+dizi4[0]);
                        dizi5[0]=String.valueOf(centroid5);
                        Log.d(TAG, "kume5 ilk eleman "+dizi5[0]);


                        for (int m =0; m<listedec.size();m++){
                            /**dizi1 deki elemanların ortalamasını hesaplar */
                            Log.d(TAG, "kume 1 de ki sayac :"+count1);

                            if(sayi1==true) {

                                int dizi1Eleman = Integer.parseInt(dizi1[count1]);
                                dizi1Sum += dizi1Eleman;
                                Log.d(TAG, "kume1 elamnlarının toplamı " + dizi1Sum);
                                count1++;
                                sayi1=false;
                                dizi1Avarage=dizi1Sum/count1;
                            }

                            Log.d(TAG, "kume 1 elemanlarının ortalaması :"+dizi1Avarage);
                            Log.d(TAG, "kume1 eleman sayisi"+count1);

                            /**dizi2 deki elemanların ortalamasını hesaplar*/

                            if (sayi2==true) {

                                int dizi2Eleman = Integer.parseInt(dizi2[count2]);
                                dizi2Sum += dizi2Eleman;
                                Log.d(TAG, "kume2 elamnlarının toplamı:" + dizi2Sum);
                                count2++;
                                dizi2Avarage =dizi2Sum/count2;
                                sayi2 =false;
                            }

                            if (sayi3==true) {

                                int dizi3Eleman = Integer.parseInt(dizi3[count3]);
                                dizi3Sum += dizi3Eleman;
                                Log.d(TAG, "kume2 elamnlarının toplamı:" + dizi3Sum);
                                count3++;
                                dizi3Avarage =dizi3Sum/count3;
                                sayi3 =false;
                            }

                            if (sayi4==true) {
                                int dizi4Eleman = Integer.parseInt(dizi4[count4]);
                                dizi4Sum += dizi4Eleman;
                                Log.d(TAG, "kume2 elamnlarının toplamı:" + dizi4Sum);
                                count4++;
                                dizi4Avarage =dizi4Sum/count4;
                                sayi4 =false;
                            }
                            if (sayi5==true) {

                                int dizi5Eleman = Integer.parseInt(dizi5[count5]);
                                dizi5Sum += dizi5Eleman;
                                Log.d(TAG, "kume2 elamnlarının toplamı:" + dizi5Sum);
                                count5++;
                                dizi5Avarage =dizi5Sum/count5;
                                sayi5 =false;
                            }


                            newTepm =Integer.parseInt(listedec.get(m));

                            difference1 =Math.abs(dizi1Avarage - newTepm);
                            difference2 =Math.abs(dizi2Avarage - newTepm);
                            difference3 =Math.abs(dizi3Avarage - newTepm);
                            difference4 =Math.abs(dizi4Avarage - newTepm);
                            difference5 =Math.abs(dizi5Avarage - newTepm);

                            if ((difference1<difference2)&&(difference1<difference3)&&(difference1<difference4)&&(difference1<difference5)){

                                String temp =listedec.get(m);
                                String yeniTemp= temp.substring(0,temp.length()-1);
                                dizi1[dizi1Counter]=yeniTemp+1;
                                dizi1Counter++;
                                sayi1=true;
                            }else if ((difference2<difference1)&&(difference2<difference3)&&(difference2<difference4)&&(difference2<difference5)){


                                String temp =listedec.get(m);
                                String yeniTemp= temp.substring(0,temp.length()-1);
                                dizi2[dizi2Counter]=yeniTemp+2;
                                Log.d(TAG, "if 2 :"+dizi2[dizi2Counter]);
                                dizi2Counter++;
                                sayi2=true;
                            }else if ((difference3<difference1)&&(difference3<difference2)&&(difference3<difference4)&&(difference3<difference5)){

                                String temp =listedec.get(m);
                                String yeniTemp= temp.substring(0,temp.length()-1);
                                dizi3[dizi3Counter]=yeniTemp+3;
                                Log.d(TAG, " if 3 :"+dizi3[dizi3Counter]);
                                dizi3Counter++;
                                sayi3=true;

                            } else if ((difference4<difference1)&&(difference4<difference2)&&(difference4<difference3)&&(difference4<difference5)) {


                                String temp =listedec.get(m);
                                String yeniTemp= temp.substring(0,temp.length()-1);
                                dizi4[dizi4Counter] = yeniTemp+4;
                                Log.d(TAG, " if 3 :" + dizi4[dizi4Counter]);
                                dizi4Counter++;
                                sayi4 = true;
                            }    else {

                                String temp =listedec.get(m);
                                String yeniTemp= temp.substring(0,temp.length()-1);
                                dizi5[dizi5Counter]=yeniTemp+5;
                                Log.d(TAG, " if 4 :"+dizi5[dizi5Counter]);
                                dizi5Counter++;
                                sayi5=true;
                            }

                            w1.WriteFile(fileClusterName1,dizi1);
                            w1.WriteFile(fileClusterName2,dizi2);
                            w1.WriteFile(fileClusterName3,dizi3);
                            w1.WriteFile(fileClusterName4,dizi4);
                            w1.WriteFile(fileClusterName5,dizi5);

                        }//for end
                    }//cluster 5 end
                }//onClick
            });//button click end


    }
    public  void  SetupVariable(){

        dizi1= new String[90];
        dizi2= new String[90];
        dizi3= new String[90];
        dizi4= new String[90];
        dizi5= new String[90];


        BTNread =(Button)findViewById(R.id.button);
        BTNCreateKmeans =(Button)findViewById(R.id.btnKMeans);
        BTNkolay =(Button)findViewById(R.id.BTNseviye1);
        BTNorta =(Button)findViewById(R.id.BTNseviye2);
        BTNzor =(Button)findViewById(R.id.BTNseviye3);

        ETnumberCluster=(EditText)findViewById(R.id.etClusterNumber);

        tv =(TextView)findViewById(R.id.textView);
    }




    public void onClick() {


        BTNkolay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();

                Intent i = new Intent(MainActivity.this, Adim1.class);
                startActivity(i);

            }
        });


        BTNorta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();

                Intent i = new Intent(MainActivity.this, Adim2.class);
                startActivity(i);
            }
        });

        BTNzor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
                Intent i = new Intent(MainActivity.this, Adim3.class);
                startActivity(i);

            }
        });

    }




        public void getPermissionRead() {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED) {


                if (shouldShowRequestPermissionRationale(
                        Manifest.permission.READ_EXTERNAL_STORAGE)) {
                }
                requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        PERMISSIONS_REQUEST_CODE);
            }
        }







        public void getPermissionWriteExternalStorage() {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED) {


                if (shouldShowRequestPermissionRationale(
                        Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                }
                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        PERMISSIONS_REQUEST_CODE);
            }
        }



        @Override
        public void onRequestPermissionsResult(int requestCode,
        @NonNull String permissions[],
        @NonNull int[] grantResults) {
            if (requestCode == PERMISSIONS_REQUEST_CODE) {
                if (grantResults.length == 1 &&
                        grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "permission granted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "permission denied", Toast.LENGTH_SHORT).show();
                }
            } else {
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
            }
        }




    }



