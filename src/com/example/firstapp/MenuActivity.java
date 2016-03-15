package com.example.firstapp;

import android.app.Activity;
import android.content.Intent;
import android.view.MenuItem;
import android.widget.Toast;

public class MenuActivity  {
	
	public boolean updatePage(MenuItem item,Activity calledBy){
		
		switch(item.getItemId()){
    	case R.id.homeItem:
    		//Toast.makeText(calledBy,"You have chosen the " + getResources().getString(R.string.welcome) + " menu option", Toast.LENGTH_LONG).show();
    		Intent welcomePage= new Intent(calledBy,Welcome.class);
    		calledBy.startActivity(welcomePage);
    		return true; 
    	case R.id.loginItem:
    		//Toast.makeText(calledBy,"You have chosen the " + getResources().getString(R.string.login) + " menu option", Toast.LENGTH_LONG).show();
    		Intent loginPage= new Intent(calledBy,Login.class);
    		calledBy.startActivity(loginPage);
    		return true;
    	case R.id.signupItem:
    		//Toast.makeText(calledBy,"You have chosen the " + getResources().getString(R.string.signup) + " menu option", Toast.LENGTH_LONG).show();
    		Intent signupPage= new Intent(calledBy,Signup.class);
    		calledBy.startActivity(signupPage);
    		//Toast.makeText(calledBy,"You have chosen the ", Toast.LENGTH_LONG).show();
    		return true;
    	default:
    		return false;
    				//super.onOptionsItemSelected(item);
  
    	}
    }
		
}


