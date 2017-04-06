package com.example.mskir.class6;

import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    Button button;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView)findViewById(R.id.tv);
    }

    public void onClick(View v){
        if(v.getId() == R.id.b4){
            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:/01099889131"));
            startActivity(intent);
        }
        else if(v.getId() == R.id.b2){
            startActivityForResult(new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI),102);
        }else if(v.getId() == R.id.b3){
            Intent intent = new Intent(this,Main2Activity.class);
            Student s1 = new Student("홍길동","2013333333",20,1);
            intent.putExtra("student1",s1);
            startActivityForResult(intent,10);
        }
        else{
        Intent intent = new Intent(this,Main2Activity.class);
        intent.putExtra("msg",tv.getText().toString());
        startActivityForResult(intent,100);}
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 10){
            if(resultCode == RESULT_OK){

            }
        }
        else if(requestCode == 102){
            if(resultCode == RESULT_OK)
                startActivity(data);

        }
        else if(requestCode == 100){
            if(resultCode == RESULT_OK){
                String msg = data.getStringExtra("remakemsg");
                tv.setText(msg);
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
