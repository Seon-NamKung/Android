package com.example.mskir.class10;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.os.EnvironmentCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = (EditText)findViewById(R.id.et);

        checkPermissioin();
    }

    public void onclick(View v){
        if(v.getId() == R.id.bt_1){
            try{
                BufferedReader br = new BufferedReader(new FileReader(getFilesDir() + "test.txt"));
                String readStr = "";
                String str = null;
                while((str = br.readLine())!= null)
                    readStr += str + "\n";
                br.close();
                Toast.makeText(this,readStr.substring(0,readStr.length()-1),Toast.LENGTH_SHORT).show();

            }catch(FileNotFoundException e){
                e.printStackTrace();
                Toast.makeText(this,"File not found",Toast.LENGTH_SHORT).show();

            } catch(IOException e){
                e.printStackTrace();
            }
        }
        else if(v.getId() == R.id.bt_2){
            try{
                BufferedWriter bw = new BufferedWriter(new FileWriter(getFilesDir() + "test.txt",true));
                bw.write("안녕하세요 Hello");
                bw.newLine();
                bw.close();
                Toast.makeText(this,"저장완료",Toast.LENGTH_SHORT).show();

            }catch(IOException e){
                e.printStackTrace();
                Toast.makeText(this,e.getMessage(),Toast.LENGTH_SHORT).show();
            }
        }else if(v.getId() == R.id.bt_3) {
            try {
                InputStream is = getResources().openRawResource(R.raw.about);
                byte[] readStr = new byte[is.available()];

                is.read(readStr);
                is.close();
                Toast.makeText(this, new String(readStr), Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(v.getId() == R.id.bt_4){
            String path = getExternalPath();
            try{
                BufferedReader br = new BufferedReader(new FileReader(path + "test.txt"));
                String readStr = "";
                String str = null;
                while((str = br.readLine())!= null)
                    readStr += str + "\n";
                br.close();
                Toast.makeText(this,readStr.substring(0,readStr.length()-1),Toast.LENGTH_SHORT).show();

            }catch(FileNotFoundException e){
                e.printStackTrace();
                Toast.makeText(this,"File not found",Toast.LENGTH_SHORT).show();

            } catch(IOException e){
                e.printStackTrace();
            }

            }
            else if(v.getId() == R.id.bt_5){
                String path = getExternalPath();
                try{
                    BufferedWriter bw = new BufferedWriter(new FileWriter(path + "test.txt",true));
                    bw.write("SD카드 쓰기");
                    bw.newLine();
                    bw.close();
                    Toast.makeText(this,"SD 저장완료",Toast.LENGTH_SHORT).show();

                }catch(IOException e){
                    e.printStackTrace();
                    Toast.makeText(this,e.getMessage(),Toast.LENGTH_SHORT).show();
                    }
            }
            else if(v.getId() == R.id.bt_6){
                String path = getExternalPath();

            File file = new File(path + "mydir3");
            file.mkdir();

            String msg = "디렉토리 생성";
            if(file.isDirectory() == false) msg = "디렉터리 생성 오류";
            Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
            }
            else if(v.getId() == R.id.bt_7){
            String path = getExternalPath();

            File[] files = new File(path).listFiles();

            String str = "";
            for(File f:files){
                str += f.getName() +"\n";
            }

            et.setText(str);
        }
        }

        public void checkPermissioin(){
        int permissioninfo = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if(permissioninfo == PackageManager.PERMISSION_GRANTED){
            Toast.makeText(getApplicationContext(),"SDCard 쓰기 권한 있음",Toast.LENGTH_SHORT).show();
        }else{
            if(ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.WRITE_EXTERNAL_STORAGE)){
                Toast.makeText(getApplicationContext(),"권한의 필요성 설명",Toast.LENGTH_SHORT).show();
            }else{
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},100);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        String str = null;
        if(requestCode == 100){
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                str = "SD Card 쓰기권한 승인";
            else str = "SD Card 쓰기권한 거부";
            Toast.makeText(this,str,Toast.LENGTH_SHORT).show();
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
    public String getExternalPath(){
        String sdPath = "";
        String ext = Environment.getExternalStorageState();
        if(ext.equals(Environment.MEDIA_MOUNTED)){
            sdPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/";
        }else{
            sdPath = getFilesDir() + "";
            Toast.makeText(getApplicationContext(),sdPath,Toast.LENGTH_SHORT).show();
        }
        return sdPath;
    }
}