package com.example.mskir.restaurant;

import android.os.Build;
import android.os.SystemClock;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.sql.Time;

public class MainActivity extends AppCompatActivity {
    //start page
    Switch startSwitch;

    //chronometer
    TextView passTime;
    Chronometer chronometer;

    //After and Before buttons
    TableLayout pageButtons;
    Button before,after;

    //First Page
    LinearLayout dateLayout;
    DatePicker datePicker;

    //Second Page
    LinearLayout timeLayout;
    TimePicker timePicker;

    //Third Page
    TableLayout numOfPeople;
    EditText adults,teenager,kids;

    //Last Page
    LinearLayout result;
    TextView date,time,numOfAdults,numOfTenns,numOfKids;

    //pageNumber
    private int pageNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    void init(){
        startSwitch = (Switch)findViewById(R.id.startSwitch);
        passTime = (TextView)findViewById(R.id.passTime);
        chronometer = (Chronometer)findViewById(R.id.chronometer);

        pageButtons = (TableLayout)findViewById(R.id.pageButtons);
        before = (Button)findViewById(R.id.before);
        after = (Button)findViewById(R.id.after);


        dateLayout = (LinearLayout)findViewById(R.id.dateLayout);
        datePicker = (DatePicker)findViewById(R.id.datePicker);

        timeLayout = (LinearLayout)findViewById(R.id.timeLayout);
        timePicker = (TimePicker)findViewById(R.id.timePicker);

        numOfPeople = (TableLayout)findViewById(R.id.numOfPeople);
        adults = (EditText)findViewById(R.id.adults);
        teenager = (EditText)findViewById(R.id.teenager);
        kids = (EditText)findViewById(R.id.kids);

        result = (LinearLayout)findViewById(R.id.result);
        date = (TextView)findViewById(R.id.date);
        time = (TextView)findViewById(R.id.time);
        numOfAdults= (TextView)findViewById(R.id.numOfAdults);
        numOfTenns = (TextView)findViewById(R.id.numOfTeens);
        numOfKids = (TextView)findViewById(R.id.numOfKids);

        startSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(startSwitch.isChecked()) {

                    //Make be visible to components which was set invisible
                    passTime.setVisibility(View.VISIBLE);

                    dateLayout.setVisibility(View.VISIBLE);
                    pageButtons.setVisibility(View.VISIBLE);

                    //Activate chronometer
                    chronometer.setBase(SystemClock.elapsedRealtime());
                    chronometer.start();
                    chronometer.setVisibility(View.VISIBLE);

                    buttonSetting(after,1);
                    buttonSetting(before,0);

                    pageNumber = 1;
                }else{
                    dateLayout.setVisibility(View.GONE);
                    timeLayout.setVisibility(View.GONE);
                    numOfPeople.setVisibility(View.GONE);
                    result.setVisibility(View.GONE);


                    passTime.setVisibility(View.GONE);
                    chronometer.stop();
                    chronometer.setVisibility(View.GONE);

                    pageButtons.setVisibility(View.INVISIBLE);
                }
            }
        });

        after.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                int day, month, year;
                int hour,min;
                if(pageNumber <4 ) {
                    pageNumber++;
                    buttonSetting(before,1);
                }
                if(pageNumber == 4){
                    buttonSetting(after,0);
                }
                if(pageNumber == 2){
                    dateLayout.setVisibility(View.GONE);
                    timeLayout.setVisibility(View.VISIBLE);
                }
                else if(pageNumber == 3){
                    timeLayout.setVisibility(View.GONE);
                    numOfPeople.setVisibility(View.VISIBLE);
                }
                else if(pageNumber == 4) {
                    numOfPeople.setVisibility(View.GONE);
                    result.setVisibility(View.VISIBLE);

                    day = datePicker.getDayOfMonth();
                    month = datePicker.getMonth();
                    year = datePicker.getYear();

                    hour = timePicker.getHour();
                    min = timePicker.getMinute();

                    date.setText(year+"년 "+month+"월 "+day+"일");
                    time.setText(hour+"시 "+min+"분");
                    numOfAdults.setText(adults.getText()+"명");
                    numOfTenns.setText(teenager.getText()+"명");
                    numOfKids.setText(kids.getText()+"명");
                }
            }
        });

        before.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pageNumber > 0) {
                    pageNumber--;
                    buttonSetting(after,1);
                }

                if(pageNumber == 1){
                    buttonSetting(before,0);
                    dateLayout.setVisibility(View.VISIBLE);
                    timeLayout.setVisibility(View.GONE);
                }
                if(pageNumber == 2){
                    timeLayout.setVisibility(View.VISIBLE);
                    numOfPeople.setVisibility(View.GONE);
                }
                else if(pageNumber == 3){
                    numOfPeople.setVisibility(View.VISIBLE);
                    result.setVisibility(View.GONE);
                }
            }
        });
    }

    //Change state of buttons, 1 is enabled, 0 is disabled;
    void buttonSetting(Button button, int state){
        if(state == 1){
            button.setEnabled(true);
        }else{
            button.setEnabled(false);
        }
    }

}
