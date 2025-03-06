package com.example.lab_class1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lab_class1.himher.HimActivity;

public class FirstLayout  extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firsttry);
    }
    @Override
    protected  void onStart(){
        super.onStart();
        TextView profileViewName = findViewById(R.id.profileNameView);

        Intent intent = getIntent();
        String userName = intent.getStringExtra(Constant.USER_NAME);

        profileViewName.setText(userName);

    }
    @Override
    protected void onResume() {
        super.onResume();

        ImageButton airplane = findViewById(R.id.airplane);

        airplane.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent peopleIntent = new Intent(FirstLayout.this, HimActivity.class);
                startActivity(peopleIntent);
            }
        });
    }
}
