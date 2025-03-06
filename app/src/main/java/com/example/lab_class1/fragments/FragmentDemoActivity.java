package com.example.lab_class1.fragments;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.lab_class1.R;

public class FragmentDemoActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    @Override
    public  void onResume(){
       super.onResume();

       Button andriodButton  = findViewById(R.id.andriodButton);
       Button iOSButton = findViewById(R.id.iSOButton);

       andriodButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {


           }
       });

       iOSButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

           }
       });
   }
   private  void  loadFragment(Fragment fragment){
       FragmentManager fragmentManager = getSupportFragmentManager();

       FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//               fragmentTransaction.setCustomAnimations(andriod.R.anim.fade_in)

       fragmentTransaction.replace(R.id.fragmentContainerView, new AndriodFragment());

       fragmentTransaction.commit();
   }
}
