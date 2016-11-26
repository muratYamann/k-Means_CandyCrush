package com.example.murat.readandconvert;

import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

/**
 * Created by murat on 28.10.2015.
 */
public class WriteToFile {
    private  static final String TAG ="_writeToFile";

    public  void WriteFile(String decimalFileName,String[] decimal){
        Log.d(TAG, "WriteFile method");

        try {

            File fileRoot = Environment.getExternalStorageDirectory();
            File myFile =new File(fileRoot,decimalFileName);
            if (myFile.exists()){
                myFile.delete();
            }
            myFile.createNewFile();
            FileOutputStream fOut =new FileOutputStream(myFile,true);
            OutputStreamWriter myOutWriter =new OutputStreamWriter(fOut);
            /**gelen degerin satır sayısı kadar satır satır yazdırılır */
            for (int i=0; i<decimal.length;i++){
                myOutWriter.write(decimal[i]+"\n");
            }
            myOutWriter.flush();
            /**yazıcıyı kapat*/
            myOutWriter.close();
            /**akış işlemini kapat */
            fOut.close();
            Log.d(TAG, "telefonda dosya yoneticisinde verilen isimdeki dosya içine kayıt yapıldı ve dosya olusturuldu");
        }
        catch (Exception e){}
    }
}
