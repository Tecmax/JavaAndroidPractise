package com.example.mahesha.searchimp;

import android.app.SearchManager;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;

public class CountryContentProvider extends ContentProvider {
	
	 public static final String AUTHORITY = "com.example.mahesha.CountryContentProvider";
	 public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/countries" );

     CountryDB mCountryDB = null;

     private static final int SUGGESTIONS_COUNTRY = 1;
     private static final int SEARCH_COUNTRY = 2;
     private static final int GET_COUNTRY = 3;
     
     UriMatcher mUriMatcher = buildUriMatcher();
     
     private UriMatcher buildUriMatcher(){
    	 UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);    	 
    	 
    	 // Suggestion items of Search Dialog is provided by this uri
    	 uriMatcher.addURI(AUTHORITY, SearchManager.SUGGEST_URI_PATH_QUERY,SUGGESTIONS_COUNTRY);
    	 
    	 // This URI is invoked, when user presses "Go" in the Keyboard of Search Dialog
    	 // Listview items of SearchableActivity is provided by this uri    	 
    	 // See android:searchSuggestIntentData="content://in.wptrafficanalyzer.searchdialogdemo.provider/countries" of searchable.xml
    	 uriMatcher.addURI(AUTHORITY, "countries", SEARCH_COUNTRY);
    	 
    	 // This URI is invoked, when user selects a suggestion from search dialog or an item from the listview
    	 // Country details for CountryActivity is provided by this uri    	 
    	 // See, SearchManager.SUGGEST_COLUMN_INTENT_DATA_ID in CountryDB.java
    	 uriMatcher.addURI(AUTHORITY, "countries/#", GET_COUNTRY);
    	 
    	 return uriMatcher;
     }
     
     
     @Override
	 public boolean onCreate() {
		 	mCountryDB = new CountryDB(getContext());
		 	return true;
	 }
     
     @Override
	 public Cursor query(Uri uri, String[] projection, String selection,
			 String[] selectionArgs, String sortOrder) {
    	 
    	 Cursor c = null;
    	 switch(mUriMatcher.match(uri)){
    	 case SUGGESTIONS_COUNTRY :
    		 c = mCountryDB.getCountries(selectionArgs);
    		 break;
    	 case SEARCH_COUNTRY :
    		 c = mCountryDB.getCountries(selectionArgs);
    		 break;
    	 case GET_COUNTRY :
    		 String id = uri.getLastPathSegment();
    		 c = mCountryDB.getCountry(id);    		
    	 }

    	 return c;
    	 
	}     

	 @Override
	 public int delete(Uri uri, String selection, String[] selectionArgs) {
		 	throw new UnsupportedOperationException();
	 }

	 @Override
	 public String getType(Uri uri) {
		 	throw new UnsupportedOperationException();
	 }

	 @Override
	 public Uri insert(Uri uri, ContentValues values) {
		 	throw new UnsupportedOperationException();
	 }	 
	 

	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
	 		throw new UnsupportedOperationException();
	}
}