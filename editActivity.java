package com.nikolaihost.crud2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.HashSet;

public class editActivity extends AppCompatActivity {

    int userId;
    //int passId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        EditText userEditText = (EditText) findViewById(R.id.userEditText);
        //EditText passEditText = (EditText) findViewById(R.id.passEditText);


        Intent intent = getIntent();
        userId = intent.getIntExtra("userId", -1);
       // passId = intent.getIntExtra("passId", -1);

        if (userId != -1){

            userEditText.setText(MainActivity.user.get(userId));

        }else{
            MainActivity.user.add("");
            userId = MainActivity.user.size() -1;
        }
      //  if (passId != -1){

       //     passEditText.setText(MainActivity.user.get(passId));

       // }else{
      //      MainActivity.user.add("");
      //      passId = MainActivity.user.size() -1;
      //  }
       userEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                MainActivity.user.set(userId, String.valueOf(s));
                MainActivity.arrayAdapter.notifyDataSetChanged();

                SharedPreferences sharedPreferences = getApplicationContext()
                        .getSharedPreferences("com.nikolaihost.crud2", Context.MODE_PRIVATE);
                HashSet<String> set = new HashSet<>(MainActivity.user);
                sharedPreferences.edit().putStringSet("user", set).apply();

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


     // passEditText.addTextChangedListener(new TextWatcher() {
     //     @Override
     //      public void beforeTextChanged(CharSequence s, int start, int count, int after) {

     //     }

     //   @Override
     //    public void onTextChanged(CharSequence s, int start, int before, int count) {

     //          MainActivity.user.set(passId, String.valueOf(s));
     //          MainActivity.arrayAdapter2.notifyDataSetChanged();

     //          SharedPreferences sharedPreferences = getApplicationContext()
     //                  .getSharedPreferences("com.nikolaihost.crud2", Context.MODE_PRIVATE);
     //          HashSet<String> set = new HashSet<>(MainActivity.user);
      //      sharedPreferences.edit().putStringSet("user", set).apply();

       //   }

       //   @Override
       //   public void afterTextChanged(Editable s) {

      //   }
      // });

    }

}
