package com.barcode.com.cookingstove;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class AutomaticallyCookListActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView listView;
    DBhandler myDB = new DBhandler(this);
    ImageView back,home,exclimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_automatically_cook_list);
        DBhandler db = new DBhandler(this);
        home = (ImageView) findViewById(R.id.home);
        exclimation = (ImageView) findViewById(R.id.exclimation);
        exclimation.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AutomaticallyCookListActivity.this,"Exclimation Button Pressed",Toast.LENGTH_LONG).show();

            }
        });
        home.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AutomaticallyCookListActivity.this,"Home Button Pressed",Toast.LENGTH_LONG).show();

            }
        });


        back = (ImageView) findViewById(R.id.arrow);
        back.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        //* *EDIT* *
        listView = (ListView) findViewById(R.id.listView1);
        TextView textView = new TextView(AutomaticallyCookListActivity.this);
        textView.setText("Select what you want to cook");

        listView.addHeaderView(textView);
        listView.setOnItemClickListener(this);

        try {
            populateListView();
        }catch (Exception e){
            Toast.makeText(AutomaticallyCookListActivity.this,""+e, Toast.LENGTH_LONG).show();
            Log.d("Error: ", ""+e);
        }

    }
        @Override
    public void onItemClick(AdapterView<?> l, View v, int position, long id) {
            Toast.makeText(AutomaticallyCookListActivity.this,"You clicked Item: " + id + " at position:" + position, Toast.LENGTH_LONG).show();

            Intent myIntent = new Intent( AutomaticallyCookListActivity.this,AutomaticallyCookingActivity.class);
            myIntent.putExtra("FoodId",id);
            AutomaticallyCookListActivity.this.startActivity(myIntent);
    }



    public void populateListView(){

        Cursor cursor = myDB.getAllRows();
        String[] fromFieldNames = new String[] {DBhandler.KEY_ID,DBhandler.KEY_NAME};
        int[] toViewIDs = new int[] {R.id.TextViewId,R.id.TextViewTitle};
        SimpleCursorAdapter myCusrsorAdapter;
        myCusrsorAdapter = new SimpleCursorAdapter(getBaseContext(),R.layout.listitem,cursor,fromFieldNames,toViewIDs,0);

        listView = (ListView) findViewById(R.id.listView1);
        listView.setAdapter(myCusrsorAdapter);

    }



    }
