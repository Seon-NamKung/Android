package com.example.mskir.hw10;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {
    LinearLayout linear1,linear2;
    Button btnSave,btnCancel,btnEdit;
    TextView tvCount;
    DatePicker dp;
    EditText et;
    ListView listView;

    ArrayList<String> data;
    ArrayAdapter<String> adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkPermissioin();
        init();
    }

    public void onClick(View v){
        if(v.getId() == R.id.btn1){
            linear1.setVisibility(View.GONE);
            linear2.setVisibility(View.VISIBLE);
        }
    }

    public void init(){
        linear1 = (LinearLayout)findViewById(R.id.linear1);
        linear2= (LinearLayout)findViewById(R.id.linear2);
        btnSave = (Button)findViewById(R.id.btnsave);
        btnCancel = (Button)findViewById(R.id.btncancel);
        btnEdit = (Button)findViewById(R.id.btnedit);
        tvCount = (TextView)findViewById(R.id.tvCount);
        dp = (DatePicker)findViewById(R.id.dp);
        et = (EditText)findViewById(R.id.et);
        listView = (ListView)findViewById(R.id.listview);

        data = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data);
        listView.setAdapter(adapter);
        makeDir();
        readData();

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String path = getExternalPath() + "diary/";
                String file = String.format("%d-%02d-%02d.memo",dp.getYear(),(dp.getMonth()+1),dp.getDayOfMonth());

                try{
                    BufferedWriter bw = new BufferedWriter(new FileWriter(path + file,true));
                    bw.write(et.getText().toString());
                    bw.newLine();
                    bw.close();
                    Toast.makeText(getApplicationContext(),"저장완료",Toast.LENGTH_SHORT).show();
                    readData();
                    backToMain();

                }catch(IOException e){
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
                }

            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToMain();
            }
        });


        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                String file = data.get(position);
                String path = getExternalPath() + "diary/";
                final File f = new File(path + file);

                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("삭제확인")
                        .setMessage("삭제하시겠습니까?")
                        .setPositiveButton("삭제", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                f.delete();
                                readData();
                            }
                        })
                        .setNegativeButton("취소", null)
                        .create()
                        .show();
                return false;
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String file = data.get(position);
                String path = getExternalPath() + "diary/";
                dp.init(Integer.parseInt(file.substring(0,4)),Integer.parseInt(file.substring(5,7))-1,Integer.parseInt(file.substring(8,10)),null);
                File f = new File(path + file);
                try{
                    BufferedReader br = new BufferedReader(new FileReader(f));
                    String readStr = "";
                    String str = null;
                    while((str = br.readLine())!= null)
                        readStr += str + "\n";
                    br.close();
                    f.delete();
                    et.setText(readStr);
                    linear1.setVisibility(View.GONE);
                    linear2.setVisibility(View.VISIBLE);
                    btnSave.setVisibility(View.GONE);
                    btnEdit.setVisibility(View.VISIBLE);

                }catch(FileNotFoundException e){
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(),"File not found",Toast.LENGTH_SHORT).show();
                } catch(IOException e){
                    e.printStackTrace();
                }
            }
        });

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String file = String.format("%d-%02d-%02d.memo",dp.getYear(),(dp.getMonth()+1),dp.getDayOfMonth());
                    final File f = new File(getExternalPath() + "diary/" + file); //edited
                    BufferedWriter out = new BufferedWriter(new FileWriter(f));
                    out.write(et.getText().toString());
                    out.newLine();
                    out.close();
                    Toast.makeText(getApplicationContext(),"저장완료",Toast.LENGTH_SHORT).show();
                    readData();
                    backToMain();
                    linear2.setVisibility(View.GONE);
                    linear1.setVisibility(View.VISIBLE);
                    btnEdit.setVisibility(View.GONE);
                    btnSave.setVisibility(View.VISIBLE);
                }catch(IOException e){
                    e.printStackTrace();
                }

            }
        });
    }
    public void editFile(String name){

        Log.d("debug",name);



    }

    Comparator<String> nameAsc = new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            return o1.compareToIgnoreCase(o2);
        }
    };

    public void readData(){
        String path = getExternalPath() + "diary";

        File[] files = new File(path).listFiles();
        data.clear();

        for(File f:files){
            data.add(f.getName());
        }
        Collections.sort(data,nameAsc);
        tvCount.setText("등록된 메모 개수 : " + data.size());
        adapter.notifyDataSetChanged();
    }

    public void backToMain(){
        linear2.setVisibility(View.GONE);
        linear1.setVisibility(View.VISIBLE);
    }

    public String makeDir(){
        String path = getExternalPath() + "diary";
        File file = new File(path);
        file.mkdir();
        String msg = "디렉토리 생성";
        if(file.isDirectory() == false) msg = "디렉터리 생성 오류";
        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_SHORT).show();
        return path;
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
