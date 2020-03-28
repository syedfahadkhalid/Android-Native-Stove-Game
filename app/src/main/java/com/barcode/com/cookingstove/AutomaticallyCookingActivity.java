package com.barcode.com.cookingstove;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AutomaticallyCookingActivity extends AppCompatActivity {
    DBhandler db = new DBhandler(AutomaticallyCookingActivity.this);
    TextView name,temp,time;
    Button editTime,editTemp,startcooking;
    SharedPreferences sharedpreferences ;
    SharedPreferences.Editor editor;

    ImageView back,home,exclimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_automatically_cooking);
        sharedpreferences = getSharedPreferences("mypref", Context.MODE_PRIVATE);
        editor = sharedpreferences.edit();
        name = (TextView) findViewById(R.id.cookNameTextView);
        time = (TextView) findViewById(R.id.timeTextView);
        temp = (TextView) findViewById(R.id.tempTextView);
        editTemp = (Button) findViewById(R.id.btnEditTemp);
        editTime = (Button) findViewById(R.id.btnEditTime);
        startcooking = (Button) findViewById((R.id.startCookBtn));
        exclimation = (ImageView) findViewById(R.id.exclimation);
        exclimation.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AutomaticallyCookingActivity.this,"Exclimation Button Pressed",Toast.LENGTH_LONG).show();

            }
        });
        back = (ImageView) findViewById(R.id.arrow);
        back.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        home = (ImageView) findViewById(R.id.home);
        home.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AutomaticallyCookingActivity.this,"Home Button Pressed",Toast.LENGTH_LONG).show();

            }
        });
        Intent intent = getIntent();
        Bundle bd = intent.getExtras();
        int id;

        id =  Integer.parseInt(bd.get("FoodId").toString());
        try {
            Food food = db.getFood(id);
            String timeVal = Integer.toString( food.getTime());
            String tempVal = Integer.toString(food.getTemp());
            String nameVal = food.getName();


            name.setText(nameVal);
            time.setText(timeVal);
            temp.setText(tempVal);
        }catch (Exception e){
            Toast.makeText(AutomaticallyCookingActivity.this,""+e, Toast.LENGTH_LONG).show();

        }

        editTemp.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialogEditTemp();
            }
        });
        editTime.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialogEditTime();
            }
        });
        startcooking.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Time timeObj = new Time();
//                timeObj.timeStove1= time.getText().toString();
                Calendar c = Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
                String currentDateTimeString= sdf.format(c.getTime());

                if (utils.currentChola.equals("1"))
                {
                        editor.putString("c1",currentDateTimeString);
                    editor.putString("t1",time.getText().toString());

                }
                if (utils.currentChola.equals("2"))
                {
                    editor.putString("c2",currentDateTimeString);
                    editor.putString("t2",time.getText().toString());

                }
                if (utils.currentChola.equals("3"))
                {
                    editor.putString("c3",currentDateTimeString);
                    editor.putString("t3",time.getText().toString());

                }
                if (utils.currentChola.equals("4"))
                {
                    editor.putString("c4",currentDateTimeString);
                    editor.putString("t4",time.getText().toString());

                }
                editor.commit();
                Toast.makeText(AutomaticallyCookingActivity.this,"Startcokkng",Toast.LENGTH_SHORT).show();
                Intent myIntent = new Intent(AutomaticallyCookingActivity.this, StoveActivity.class);
                myIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                AutomaticallyCookingActivity.this.startActivity(myIntent);
            }
        });
    }

    private void openDialogEditTemp(){
        LayoutInflater inflater = LayoutInflater.from(AutomaticallyCookingActivity.this);
        View subView = inflater.inflate(R.layout.prompt, null);

        name = (EditText) subView.findViewById(R.id.dialogEditText);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Enter new temp");

        builder.setView(subView);
        AlertDialog alertDialog = builder.create();

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // textInfo.setText(subEditText.getText().toString());


                temp.setText(name.getText().toString());
                Toast.makeText(AutomaticallyCookingActivity.this, temp.getText().toString()+" "+name.getText().toString(), Toast.LENGTH_LONG).show();//+" "+name.getText()


            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(AutomaticallyCookingActivity.this, "Cancel", Toast.LENGTH_LONG).show();
            }
        });

        builder.show();
    }

    private void openDialogEditTime(){
        LayoutInflater inflater = LayoutInflater.from(AutomaticallyCookingActivity.this);
        View subView = inflater.inflate(R.layout.prompt, null);

        name = (EditText) subView.findViewById(R.id.dialogEditText);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Enter new Time");

        builder.setView(subView);
        AlertDialog alertDialog = builder.create();

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // textInfo.setText(subEditText.getText().toString());

                time.setText(name.getText().toString());
                Toast.makeText(AutomaticallyCookingActivity.this,time.getText().toString()+" "+name.getText().toString(), Toast.LENGTH_LONG).show();//+" "+name.getText()


            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(AutomaticallyCookingActivity.this, "Cancel", Toast.LENGTH_LONG).show();
            }
        });

        builder.show();
    }
}
