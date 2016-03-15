package com.example.firstapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class DataBaseHelper extends SQLiteOpenHelper {
	public SQLiteDatabase db;
	public static Context currentContext;
	public String DBPath;
	public static String dbName="myFirstApp";
	public static final int version=1;
	public String table[]={"user"};

	public DataBaseHelper(Context context) {
		super(context, dbName, null, version);
		currentContext=context;
		DBPath = "/data/data/" + context.getPackageName() + "/databases/";
		Log.e("ok", "create side2");
		createDatabase();
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}
	
	void createDatabase(){
		Log.e("ok", "inside6");
		if(!dbExists()){
			db=currentContext.openOrCreateDatabase(dbName, version, null);
		}
		Log.e("ok", "inside7");
		for(String tableName:table){
		createTable(tableName);
		Log.e("ok", tableName);
		}
		
	}

	private void createTable(String tableName) { Log.e("ok", tableName+"1"); 
		Log.e("ok", "CREATE TABLE IF NOT EXISTS " +
    			tableName+
    			" (Name VARCHAR, Email VARCHAR," +
    			" Password VARCHAR);");   Log.e("ok", tableName+"2"); 
		db=currentContext.openOrCreateDatabase(dbName, version, null);  Log.e("ok", tableName+"3"); 
		db.execSQL("CREATE TABLE IF NOT EXISTS " +
    			tableName +
    			" (Name VARCHAR(100), Email VARCHAR(100)," +
    			" Password VARCHAR(100));");  Log.e("ok", tableName+"4"); 
		
	}
	
	public boolean registerUser(String name,String mail,String password){
		boolean userCreated = false;
		try{
			String query="INSERT INTO " +table[0] +" Values ('"+name+"','"+mail+"','"+password+"');";
			String myPath = DBPath+dbName;
			db = SQLiteDatabase.openDatabase(myPath, null,
					SQLiteDatabase.OPEN_READWRITE);
			Log.e("ok", "inside1");
			//DB=dbHelper.getWritableDatabase();
			db.execSQL(query);
			Log.e("ok", "side2");
			userCreated = true;
		}catch (SQLiteException se ) {
			userCreated = false;
        	Log.e(getClass().getSimpleName(), "Could not create or Open the database to entry");
        } finally {
        		db.close();
        }
		return userCreated;
	}
	
	public Boolean checkCredentials(String mail,String password){
		boolean userExists = false;
		try{
			String query="SELECT * FROM " +table[0] +" WHERE Email='"+mail+"' AND Password='"+password+"';";
			Log.e("ok",query);
			Toast.makeText(this.currentContext, query, Toast.LENGTH_LONG).show();
			String myPath = DBPath+dbName;
			db = SQLiteDatabase.openDatabase(myPath, null,
					SQLiteDatabase.OPEN_READWRITE);
			Cursor cursor = db.rawQuery(query, null);
			Log.e("ok",cursor.getCount()+"");
			if(cursor.getCount() <= 0){
	            cursor.close();
	            userExists=false;
	        }
			else {cursor.close();
	    userExists=true;}
			Log.e("ok", "inside2");
		}catch (SQLiteException se ) {
        	Log.e(getClass().getSimpleName(), "Could not create or Open the database to entry");
        }finally {
        		db.close();
        }
		return userExists;
		
	}

	private boolean dbExists() {
		    SQLiteDatabase checkDB = null; 
		    try {
		        checkDB = SQLiteDatabase.openDatabase(DBPath+dbName, null,
		                SQLiteDatabase.OPEN_READONLY);
		        checkDB.close();
		    } catch (SQLiteException e) {
		        // database doesn't exist yet.
		    }
		    return checkDB != null;
	}

}
