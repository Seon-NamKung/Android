package com.example.mskir.practice_4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;

public class Main2Activity extends AppCompatActivity {
    TabHost tabhost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tabhost = (TabHost)findViewById(R.id.tabHost1);
        tabhost.setup();

        TabHost.TabSpec tab1 = tabhost.newTabSpec("A").setContent(R.id.tab1).setIndicator("날짜선택");
        tabhost.addTab(tab1);

        TabHost.TabSpec tab2 = tabhost.newTabSpec("B").setContent(R.id.tab2).setIndicator("시간선택");
        tabhost.addTab(tab2);

        tabhost.addTab(tabhost.newTabSpec("C").setIndicator("음악별").setContent(new TabHost.TabContentFactory() {
            @Override
            public View createTabContent(String tag) {
                View view = View.inflate(Main2Activity.this,R.layout.newnew,null);
                Button btn = (Button)view.findViewById(R.id.button);
                return view;
            }
        }).setIndicator("외부선택"));
    }
}
