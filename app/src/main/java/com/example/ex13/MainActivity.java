package com.example.ex13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btn1,btn2,btn3;
    TextView tv1;

    EditText et1;
    int count=0;
    String shay;


    SharedPreferences settings;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        tv1 = findViewById(R.id.tv1);
        et1 = findViewById(R.id.et1);
        settings =getSharedPreferences("PREFS_NAME",MODE_PRIVATE);
        editor=settings.edit();
        count =settings.getInt("count", 0);
        shay = settings.getString("name" , et1.getText().toString());
        tv1.setText(""+count);
        et1.setText(shay);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);


        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        String st = item.getTitle().toString();
        if(st.equals("Cradits")){
            Intent dorel2 = new Intent(this,SecondActivity.class);
            startActivity(dorel2);
        }
        return true;
    }

    public void button1(View view) {
        count++;
        tv1.setText(""+count);

    }

    public void button2(View view) {
        count =0;
        tv1.setText(""+count);
        et1.setText("");

    }

    public void button3(View view) {
        editor.putInt("count", count);
        editor.putString("name", et1.getText().toString());
        editor.commit();
        finish();
    }
}