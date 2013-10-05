package com.example.handsoncentralohio;

import java.util.GregorianCalendar;

import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.provider.CalendarContract.EventDays;
import android.provider.CalendarContract.Events;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.support.v4.app.NavUtils;

public class SelectedEventActivity extends Activity {
	
	static public int selectedID;
	EventData event;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_selected_event);
		// Show the Up button in the action bar.
		setupActionBar();
		
		event = DispEventActivity.list.get(selectedID);
		
		TextView nameText = (TextView) findViewById(R.id.textView5);
		nameText.setText(event.getName());
		
		TextView dateText = (TextView) findViewById(R.id.textView7);
		dateText.setText(event.getStartDate());
		
		TextView descText = (TextView) findViewById(R.id.textView6);
		descText.setText(event.getDescr());
		
	}
	
	public EventData ed;
	
	public void addCalendarEvent(View view) {
		Intent intent = new Intent(Intent.ACTION_INSERT);
		intent.setType("vnd.android.cursor.item/event");
		intent.putExtra(Events.TITLE, event.getName());
		intent.putExtra(Events.DESCRIPTION, event.getDescr());

		int month, day, year;
		month = Integer.parseInt(event.getStartDate().split("/")[0]);
		day = Integer.parseInt(event.getStartDate().split("/")[1]);
		year = Integer.parseInt(event.getStartDate().split("/")[2]);
		// Setting dates
		GregorianCalendar calDate = new GregorianCalendar(year, month, day);
		intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,
				  calDate.getTimeInMillis());
		intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME,
		  calDate.getTimeInMillis());
		// Make it a full day event
		intent.putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, true);

	}

	/**
	 * Set up the {@link android.app.ActionBar}.
	 */
	private void setupActionBar() {

		getActionBar().setDisplayHomeAsUpEnabled(true);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.selected_event, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	public void signUp(View view)
	{
		//if(MainLayoutActivity.loggedIn())
		//{	
			Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.volunteercentralohio.org/HOC__Volunteer_Opportunity_Calendar_Page&quot"));
			startActivity(browserIntent);
		//}
	}
	//android:onClick="goToUrl ( &quot;http://www.volunteercentralohio.org/HOC__Volunteer_Opportunity_Calendar_Page&quot;);"
}
