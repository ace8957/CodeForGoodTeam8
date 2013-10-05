package com.example.handsoncentralohio;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.*;
import android.util.Log;

public class DatabaseHandler extends SQLiteOpenHelper {
	
	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "handsOnDatabase";
	
	private static final String TABLE_CONTENTS = "events";
	
	//column names
	private static final String KEY_ID = "eventID";
	//private static final String START_DATE = "startDate";
	//private static final String END_DATE = "endDate";
	private static final String KEY_NAME = "eventID";
	private static final String DESCRIPTION = "description";
	
	private final ArrayList<EventData> event_list = new ArrayList<EventData>();
	
	public DatabaseHandler(Context context){
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	
	// Create Tables
	@Override
	public void onCreate(SQLiteDatabase db) {
		String CREATE_EVENTS_TABLE = "CREATE TABLE " + TABLE_CONTENTS + "("
				+ KEY_ID + " INTEGER PRIMARY KEY, " + KEY_NAME + " TEXT,"
				+ DESCRIPTION + " TEXT)";
		db.execSQL(CREATE_EVENTS_TABLE);
	}
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTENTS);
		onCreate(db);
	}
	
	public void Add_Event(EventData event) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(KEY_NAME, event.getName());
		values.put(DESCRIPTION, event.getDescr());
		
		db.insert(TABLE_CONTENTS, null, values);
		db.close();
	}
	
	//TODO: implement Get_Event
	
	public ArrayList<EventData> Get_Events() {
		try {
			event_list.clear();
			
			String selectQuery = "SELECT * FROM " + TABLE_CONTENTS;
			
			SQLiteDatabase db = this.getWritableDatabase();
			Cursor cursor = db.rawQuery(selectQuery, null);
			
			if(cursor.moveToLast()) {
				do {
					EventData event = new EventData();
					event.setID(Integer.parseInt(cursor.getString(0)));
					event.setDescr(cursor.getString(0));
				} while(cursor.moveToNext());
			}
			
			cursor.close();
			db.close();
		} catch (Exception e) {
			Log.e("all_events", "" + e);
		}
		
		return event_list;
	}
	
	//TODO: update an event

}
