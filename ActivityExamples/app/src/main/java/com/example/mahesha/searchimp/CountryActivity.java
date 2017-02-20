package com.example.mahesha.searchimp;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mahesha.activityexamples.R;

public class CountryActivity extends FragmentActivity implements LoaderCallbacks<Cursor>{
	
	private Uri mUri;
	private ImageView mIvFlag;
	private TextView mTvName;
	private TextView mTvCurrency;
	
	@Override
	protected void onCreate(Bundle arg0) {		
		super.onCreate(arg0);
		setContentView(R.layout.activity_country);
		
		Intent intent = getIntent();
		mUri = intent.getData();
		
		mIvFlag = (ImageView) findViewById(R.id.iv_flag);
		mTvName = (TextView) findViewById(R.id.tv_name);
		mTvCurrency = (TextView) findViewById(R.id.tv_currency);
		
		// Invokes the method onCreateloader() in non-ui thread
		getSupportLoaderManager().initLoader(0, null, this);
		
	}

	/** Invoked by initLoader() */
	@Override
	public Loader<Cursor> onCreateLoader(int arg0, Bundle arg1) {		
		return new CursorLoader(getBaseContext(), mUri, null, null , null, null);
	}

	/** Invoked by onCreateLoader(), will be executed in ui-thread */
	@Override
	public void onLoadFinished(Loader<Cursor> arg0, Cursor cursor) {
		if(cursor.moveToFirst()){
			mIvFlag.setImageResource(cursor.getInt(cursor.getColumnIndex(cursor.getColumnName(2))));
			mTvName.setText("Country: "+cursor.getString(cursor.getColumnIndex(cursor.getColumnName(1))));			
			mTvCurrency.setText("Currency: "+cursor.getString(cursor.getColumnIndex(cursor.getColumnName(3))));			
		}
				
	}

	@Override
	public void onLoaderReset(Loader<Cursor> arg0) {
		// TODO Auto-generated method stub
		
	}
}
