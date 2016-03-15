package com.example.firstapp;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends Activity {
	private Button loginButton;
	private EditText emailEditText;
	private EditText passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        emailEditText=(EditText)findViewById(R.id.editText2);
        passwordEditText=(EditText)findViewById(R.id.editText4);
        loginButton=(Button)findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				boolean verified=false;
				DataBaseHelper dbHelper = new DataBaseHelper(Login.this);
				verified=dbHelper.checkCredentials(emailEditText.getText().toString(),passwordEditText.getText().toString());
				
				if(verified){
					Toast.makeText(Login.this, "valid credentials", Toast.LENGTH_LONG).show();
				Intent welcomePage=new Intent(Login.this,Welcome.class);
				startActivity(welcomePage);}
				else {
				Toast.makeText(Login.this, "invalid credentials", Toast.LENGTH_LONG).show();
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
    	if(call.updatePage(item,Login.this)==false)
    		return super.onOptionsItemSelected(item);
    	else return true;
    	
    }
  }
    

