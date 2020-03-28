package com.barcode.com.cookingstove;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class StoveActivity extends AppCompatActivity{
    SharedPreferences sharedpreferences ;
    SharedPreferences.Editor editor;
    ImageView im1,im2,im3,im4;
    String c1="",c2="",c3="",c4="",t1="",t2="",t3="",t4="";
    ImageView back,home,exclimation;
    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stove);
        back = (ImageView) findViewById(R.id.arrow);
        home = (ImageView) findViewById(R.id.home);
        back.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        home.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(StoveActivity.this,"Home Button Pressed",Toast.LENGTH_LONG).show();
            }
        });
        exclimation = (ImageView) findViewById(R.id.exclimation);
        exclimation.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(StoveActivity.this,"Exclimation Button Pressed",Toast.LENGTH_LONG).show();

            }
        });
         initialize();
          setUpComponent();
    }

    private void setUpComponent() {
        Calendar cal = Calendar.getInstance();
        c1= sharedpreferences.getString("c1",null);
        c2= sharedpreferences.getString("c2",null);
        c3= sharedpreferences.getString("c3",null);
        c4= sharedpreferences.getString("c4",null);
        t1= sharedpreferences.getString("t1",null);
        t2= sharedpreferences.getString("t2",null);
        t3= sharedpreferences.getString("t3",null);
        t4= sharedpreferences.getString("t4",null);
        //start
        if (c1!=null){
            Log.d("c1",c1);
            Log.d("t1",t1);
        java.text.DateFormat df = new java.text.SimpleDateFormat("hh:mm:ss");

        java.util.Date date1 = null;
        try {
            date1 = df.parse(c1);
          cal.setTime(date1);
            cal.add(Calendar.MINUTE, Integer.parseInt(t1));
        } catch (ParseException e) {
            e.printStackTrace();
        }
            Calendar c = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
            String currentDateTimeString= sdf.format(c.getTime());
            SimpleDateFormat formatter1 = new SimpleDateFormat("hh:mm:ss");
            String targetTime = formatter1.format(cal.getTime());
            if(currentDateTimeString.compareTo(targetTime)>=0) {
               // Toast.makeText(this, "Stove 1 is free now", Toast.LENGTH_SHORT).show();
              im1.setImageResource(R.drawable.circle_black);
                findViewById(R.id.p1).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        utils.currentChola="1";

                        startActivity(new Intent(StoveActivity.this,CookingModeActivity.class));
                    }
                });
            }
            else {
              //  Toast.makeText(this, "Stove 1 is occupied", Toast.LENGTH_SHORT).show();
                im1.setImageResource(R.drawable.circle);
            }
        }
        else
        {
            im1.setImageResource(R.drawable.circle_black);
            findViewById(R.id.p1).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    utils.currentChola="1";

                    startActivity(new Intent(StoveActivity.this,CookingModeActivity.class));
                }
            });
        }
        //end
        if (c2!=null){
            Log.d("c2",c2);
            Log.d("t2",t2);
            java.text.DateFormat df = new java.text.SimpleDateFormat("hh:mm:ss");

            java.util.Date date2 = null;
            try {
                date2 = df.parse(c2);
                cal.setTime(date2);
                cal.add(Calendar.MINUTE, Integer.parseInt(t2));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Calendar c = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
            String currentDateTimeString= sdf.format(c.getTime());
            SimpleDateFormat formatter1 = new SimpleDateFormat("hh:mm:ss");
            String targetTime = formatter1.format(cal.getTime());
            if(currentDateTimeString.compareTo(targetTime)>=0) {
                //Toast.makeText(this, "Stove 2 is now free", Toast.LENGTH_SHORT).show();
                im2.setImageResource(R.drawable.circle_black);
                findViewById(R.id.p2).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        utils.currentChola="2";

                        startActivity(new Intent(StoveActivity.this,CookingModeActivity.class));
                    }
                });
            }
            else {
              //  Toast.makeText(this, "Stove 2 is occupied", Toast.LENGTH_SHORT).show();
                im2.setImageResource(R.drawable.circle);
            }
        }
        else
        {
            im2.setImageResource(R.drawable.circle_black);
            findViewById(R.id.p2).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    utils.currentChola="2";

                    startActivity(new Intent(StoveActivity.this,CookingModeActivity.class));
                }
            });
        }
        //end
        if (c3!=null){
            Log.d("c3",c3);
            Log.d("t3",t3);
            java.text.DateFormat df = new java.text.SimpleDateFormat("hh:mm:ss");

            java.util.Date date3 = null;
            try {
                date3 = df.parse(c3);
                cal.setTime(date3);
                cal.add(Calendar.MINUTE, Integer.parseInt(t3));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Calendar c = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
            String currentDateTimeString= sdf.format(c.getTime());
            SimpleDateFormat formatter1 = new SimpleDateFormat("hh:mm:ss");
            String targetTime = formatter1.format(cal.getTime());
            if(currentDateTimeString.compareTo(targetTime)>=0) {
              //  Toast.makeText(this, "Stove 3 is now free", Toast.LENGTH_SHORT).show();
                im3.setImageResource(R.drawable.circle_black);
                findViewById(R.id.p3).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        utils.currentChola="3";

                        startActivity(new Intent(StoveActivity.this,CookingModeActivity.class));
                    }
                });
            }
            else {
              //  Toast.makeText(this, "Stove 3 is occupied", Toast.LENGTH_SHORT).show();
                im3.setImageResource(R.drawable.circle);
            }
        }
        else
        {
            im3.setImageResource(R.drawable.circle_black);
            findViewById(R.id.p3).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    utils.currentChola="3";

                    startActivity(new Intent(StoveActivity.this,CookingModeActivity.class));
                }
            });
        }
        //end

                if (c4!=null){
                    Log.d("c4",c4);
                    Log.d("t4",t4);
                    java.text.DateFormat df = new java.text.SimpleDateFormat("hh:mm:ss");

                    java.util.Date date4 = null;
                    try {
                        date4 = df.parse(c4);
                        cal.setTime(date4);
                        cal.add(Calendar.MINUTE, Integer.parseInt(t4));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    Calendar c = Calendar.getInstance();
                    SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
                    String currentDateTimeString= sdf.format(c.getTime());
                    SimpleDateFormat formatter1 = new SimpleDateFormat("hh:mm:ss");
                    String targetTime = formatter1.format(cal.getTime());
                    if(currentDateTimeString.compareTo(targetTime)>=0) {
                      //  Toast.makeText(this, "Stove 4 is now free", Toast.LENGTH_SHORT).show();
                        im4.setImageResource(R.drawable.circle_black);
                        findViewById(R.id.p4).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                utils.currentChola="4";

                                startActivity(new Intent(StoveActivity.this,CookingModeActivity.class));
                            }
                        });
                    }
                    else {
                  //      Toast.makeText(this, "Stove 4 is occupied", Toast.LENGTH_SHORT).show();
                        im4.setImageResource(R.drawable.circle);
                    }
                }
                else
                {
                    im4.setImageResource(R.drawable.circle_black);
                    findViewById(R.id.p4).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            utils.currentChola="4";

                            startActivity(new Intent(StoveActivity.this,CookingModeActivity.class));
                        }
                    });
                }
    }

    private void initialize() {
        sharedpreferences = getSharedPreferences("mypref", Context.MODE_PRIVATE);
        editor = sharedpreferences.edit();
        im1=(ImageView)this.findViewById(R.id.p1);
        im2=(ImageView)this.findViewById(R.id.p2);
        im3=(ImageView)this.findViewById(R.id.p3);
        im4=(ImageView)this.findViewById(R.id.p4);
    }


}

