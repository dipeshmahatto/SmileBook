package com.example.lab_class1.menus;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.lab_class1.R;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menu);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        TextView contextTextView = findViewById(R.id.contextTextView);
        registerForContextMenu(contextTextView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        return super.onCreateOptionsMenu(menu);

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.option_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {



        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.option_menu,menu);
    }
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.item1) {
            Toast.makeText(this, "Its item 1...", Toast.LENGTH_SHORT).show();
            return true;
        } else if (item.getItemId() == R.id.item2) {
            Toast.makeText(this, "Its item 2...", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onContextItemSelected(item);
    }


}