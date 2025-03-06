package com.example.lab_class1.himher;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.lab_class1.Constant;
import com.example.lab_class1.R;

public class HimActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_him);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.him), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

        EditText giftEditText = findViewById(R.id.giftEditText);

        Button sendGiftBtn = findViewById(R.id.sendGiftBtn);

        sendGiftBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HimActivity.this,HerActivity.class);

                String gift = giftEditText.getText().toString();

                intent.putExtra(Constant.GIFT,gift);

//                startActivityForResult(intent,Constant.REQUEST_CODE);
                activityResultLauncher.launch(intent);
            }
        });
    }

    ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult activityResult) {
                    if(activityResult.getResultCode() == RESULT_OK && activityResult.getData() !=null){
                        String response = activityResult.getData().getStringExtra(Constant.GIFT_RESPONSE);

                        Toast.makeText(HimActivity.this, response, Toast.LENGTH_LONG).show();
                    }
                }
            }
    );


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==Constant.REQUEST_CODE){
            if(resultCode==RESULT_OK){
                if(data != null){
                    String response = data.getStringExtra(Constant.GIFT_RESPONSE);

                    Toast.makeText(HimActivity.this,response,Toast.LENGTH_LONG).show();
                }
            }
        }
    }
}