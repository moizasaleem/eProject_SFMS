package com.example.student_fees_management_system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txtWelCome;
    DatabaseConfiguration databaseConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseConfiguration = new DatabaseConfiguration(this);
        databaseConfiguration.ExecuteQuery();

        if (SessionInformation.LoggedInUser == null){
            // Explicit
            Intent obj = new Intent(getApplicationContext(), Login.class);
            startActivity(obj);
        }

        // test commit

        txtWelCome = (TextView) findViewById(R.id.txtWelCome);
        if (SessionInformation.LoggedInUser != null){
            String userType = "";
            if (SessionInformation.LoggedInUser.UserType == 1){
                // Explicit
                Intent obj = new Intent(getApplicationContext(), Admin_dashboard.class);
                startActivity(obj);
            }
            else if (SessionInformation.LoggedInUser.UserType == 2){
                // Explicit
                Intent obj = new Intent(getApplicationContext(), Admin_dashboard.class);
                startActivity(obj);
            }
        }
    }

    public void LogOut(View view) {
        SessionInformation.LoggedInUser = null;
        // Explicit
        Intent obj = new Intent(getApplicationContext(), Login.class);
        startActivity(obj);
    }

    public void GoToUserList(View view) {
        // Explicit
        Intent obj = new Intent(getApplicationContext(), Admin_dashboard.class);
        startActivity(obj);
    }
}