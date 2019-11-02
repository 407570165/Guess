package com.tom.guess;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int secret =new Random().nextInt(10)+1;
    private EditText g;
    private TextView total;
    private Button reset;
    private TextView counter;
    int vacount;
    private DialogInterface.OnClickListener dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        g = findViewById(R.id.guess);
        total = findViewById(R.id.result);
        reset = findViewById(R.id.reset_bottun);
        counter = findViewById(R.id.count);
        counter.setText(vacount+"");
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View view) {
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    public void reset(){
        secret =new Random().nextInt(10)+1;
        g.setText("");
        total.setText("");
        vacount =0;
        counter.setText(vacount+"");

    }
    public void zero(View view){
        int i=0;

    }
    public void turn(View view) {
        int guess = Integer.parseInt(g.getText().toString());
        total.setAlpha(1.0f);
        vacount++;
        counter.setText(vacount + "");
        DialogInterface.OnClickListener listener =new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                reset();
            }
        };
        String message ="BINGO";
       if (guess>secret){
           message ="SMALLER";
           listener=null;
           /*total.setText("SMALLER");
           total.setVisibility(View.VISIBLE);
           total.animate().alpha(0.0f).setDuration(1200);*/
       }else if (guess<secret){
           message="BIGGER";
           listener=null;
           /*total.setText("BIGGER");
           total.setVisibility(View.VISIBLE);
           new AlertDialog.Builder(MainActivity.this)
                   .setTitle("hahahaha")
                   .setMessage("Bigger")
                    .setPositiveButton("ok",null)
                   .show();*/

       }
           new AlertDialog.Builder(MainActivity.this)
                   .setTitle("hahah")
                   .setMessage(message)
                   .setPositiveButton("ok", listener).show();


/*
            total.setText("BINGO");
            reset.setVisibility(View.VISIBLE);
*/


    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);

    }

}
