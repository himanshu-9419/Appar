package com.example.firstapp;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	private Button loginButton;
	private Button signupButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginButton=(Button)findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent loginPage=new Intent(MainActivity.this,Login.class);
				startActivity(loginPage);
				
			}
        	
        });
        
        signupButton=(Button)findViewById(R.id.signupButton);
        signupButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent signupPage=new Intent(MainActivity.this,Signup.class);
				startActivity(signupPage);
				
			}
        	
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public boolean onOptionsItemSelected(MenuItem item){
    	MenuActivity call= new MenuActivity();
    	if(call.updatePage(item,MainActivity.this)==false)
    		return super.onOptionsItemSelected(item);
    	else return true;
    	
    }
    
}
