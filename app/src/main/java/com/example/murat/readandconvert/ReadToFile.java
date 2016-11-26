package com.example.murat.readandconvert;

import android.os.Environment;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by murat on 27.10.2015.
 */
public class ReadToFile {
    //private static final String TAG = "_ReadToFile";
    String line = "";
    public ArrayList<String> liste;
    public  void ReadFile(String fileName){
        liste=new ArrayList<String>();
        try {
            File root = Environment.getExternalStorageDirectory();
            File myFile = new File(root, fileName);

            if (myFile.exists()){
             //   Log.i(TAG, "file exist");
                FileInputStream fIn = new FileInputStream(myFile);
                InputStreamReader inputStreamReader = new InputStreamReader(fIn);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                while ((line = bufferedReader.readLine()) != null) {
                    liste.add(line);
                }
                fIn.close();
            }
        }
        catch (FileNotFoundException e) {
           // Log.e(TAG, "Dosya yok: " + e.toString());
        } catch (IOException e) {
            //Log.e(TAG, "Dosya okunamiyor: " + e.toString());
        }

    }


}
