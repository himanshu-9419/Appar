package com.example.firstapp;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Signup  extends Activity {
	
	private Button signupButton;
	private EditText emailEditText;
	private EditText passwordEditText;
	private EditText nameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        emailEditText=(EditText)findViewById(R.id.editText2);
        passwordEditText=(EditText)findViewById(R.id.editText4);
        nameEditText=(EditText)findViewById(R.id.editText4);
        signupButton=(Button)findViewById(R.id.signupButton);
        signupButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				boolean accCreated=false;
				DataBaseHelper dbHelper = new DataBaseHelper(Signup.this);
				accCreated=dbHelper.registerUser(nameEditText.getText().toString(),emailEditText.getText().toString(),passwordEditText.getText().toString());
				if(accCreated){
				Intent welcomePage=new Intent(Signup.this,Login.class);
				startActivity(welcomePage);}
				else {
				Toast.makeText(Signup.this, "Error creating", Toast.LENGTH_LONG).show();
			}
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
    	if(call.updatePage(item,Signup.this)==false)
    		return super.onOptionsItemSelected(item);
    	else return true;
    	
    }
    
}
