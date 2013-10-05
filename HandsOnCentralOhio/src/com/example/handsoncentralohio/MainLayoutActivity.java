package com.example.handsoncentralohio;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;

public class MainLayoutActivity extends Activity {
	static boolean isLoggedIn = true;
	public static boolean loggedIn()
	{
		return isLoggedIn;
	}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        SQLiteDatabase db;
        DatabaseHandler dbh = new DatabaseHandler(this.getApplicationContext());
        for(int i = 0; i < RawData.data.length; i++) {
        	dbh.Add_Event(RawData.data[i]);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_layout, menu);
        return true;
    }
    
    public void showEvents (View view)
    {
    	// Do something in response to button being preseed
    	Intent intent = new Intent(this, EventsActivity.class);
    	startActivity(intent);
    }
    
    public void showLogin (View view)
    {
    	if(isLoggedIn)//if already logged in go to profile
    	{
    		Intent intent = new Intent(this, ProfileActivity.class);
    		startActivity(intent);
    	}
    	else
    	{
	    	Intent intent = new Intent(this, LoginActivity.class);
	    	startActivity(intent);
    	}
    }
    
}
