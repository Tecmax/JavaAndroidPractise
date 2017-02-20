package com.example.mahesha.searchimp;

import android.app.SearchManager;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;

import java.util.HashMap;

public class CountryDB{
	
	private static final String DBNAME = "country";
	
	private static final int VERSION = 1;
	
	private CountryDBOpenHelper mCountryDBOpenHelper;
	
	private static final String FIELD_ID = "_id";
	private static final String FIELD_NAME = "name";
	private static final String FIELD_FLAG = "flag";
	private static final String FIELD_CURRENCY = "currency";
	private static final String TABLE_NAME = "countries";
	private HashMap<String, String> mAliasMap;
	
	
	public CountryDB(Context context){
		mCountryDBOpenHelper = new CountryDBOpenHelper(context, DBNAME, null, VERSION);
		
		// This HashMap is used to map table fields to Custom Suggestion fields
    	mAliasMap = new HashMap<String, String>();
    	
    	// Unique id for the each Suggestions ( Mandatory ) 
    	mAliasMap.put("_ID", FIELD_ID + " as " + "_id" );
    	
    	// Text for Suggestions ( Mandatory )
    	mAliasMap.put(SearchManager.SUGGEST_COLUMN_TEXT_1, FIELD_NAME + " as " + SearchManager.SUGGEST_COLUMN_TEXT_1);
    	
    	// Icon for Suggestions ( Optional ) 
    	mAliasMap.put( SearchManager.SUGGEST_COLUMN_ICON_1, FIELD_FLAG + " as " + SearchManager.SUGGEST_COLUMN_ICON_1);
    	
    	// This value will be appended to the Intent data on selecting an item from Search result or Suggestions ( Optional )
    	mAliasMap.put( SearchManager.SUGGEST_COLUMN_INTENT_DATA_ID, FIELD_ID + " as " + SearchManager.SUGGEST_COLUMN_INTENT_DATA_ID );
	}
		

	/** Returns Countries  */
    public Cursor getCountries(String[] selectionArgs){    	
    	
    	String selection = FIELD_NAME + " like ? ";
    	
    	if(selectionArgs!=null){
    		selectionArgs[0] = "%"+selectionArgs[0] + "%";   		
    	}    	    	
    	
    	SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
    	queryBuilder.setProjectionMap(mAliasMap);
    	
    	queryBuilder.setTables(TABLE_NAME);    	
    	
    	Cursor c = queryBuilder.query(mCountryDBOpenHelper.getReadableDatabase(), 
    									new String[] { "_ID", 
    													SearchManager.SUGGEST_COLUMN_TEXT_1 , 
    													SearchManager.SUGGEST_COLUMN_ICON_1 , 
    													SearchManager.SUGGEST_COLUMN_INTENT_DATA_ID } ,
    									selection, 
    									selectionArgs, 
    									null, 
    									null,
    									FIELD_NAME + " asc ","10"
    								);  	    	
	    return c;
	    
    }
    
    /** Return Country corresponding to the id */
    public Cursor getCountry(String id){
    	
    	SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();    	
    	
    	queryBuilder.setTables(TABLE_NAME);    	
    	
    	Cursor c = queryBuilder.query(mCountryDBOpenHelper.getReadableDatabase(), 
    									new String[] { "_id", "name", "flag", "currency" } ,
    									"_id = ?", new String[] { id } , null, null, null ,"1"
    								);  	
    	
    	return c;
    }

	
	class CountryDBOpenHelper extends SQLiteOpenHelper{

		public CountryDBOpenHelper(		Context context, 
										String name,
										CursorFactory factory, 
										int version ) {
			super(context, DBNAME, factory, VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			String sql = "";
			
			// Defining table structure
			sql = " create table " + TABLE_NAME + "" +
											" ( " +
												FIELD_ID + " integer primary key autoincrement, " + 
												FIELD_NAME + " varchar(100), " +
												FIELD_FLAG + "  int, " +
												FIELD_CURRENCY + " varchar(100) " + 
											" ) " ;
			
			// Creating table
			db.execSQL(sql);			
			
			for(int i=0;i<Country.countries.length;i++){
				
				// Defining insert statement
				sql = "insert into " + TABLE_NAME + " ( " +
						FIELD_NAME + " , " +
						FIELD_FLAG + " , " + 
						FIELD_CURRENCY + " ) " + 
						" values ( " + 
						" '" + Country.countries[i] + "' ," +
						"  " + Country.flags[i] + "  ," +
						" '" + Country.currency[i] + "' ) ";
				
				// Inserting values into table
				db.execSQL(sql);					
			}
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub			
		}		
	}	
}