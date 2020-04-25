package com.example.roomdatabaseandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.roomdatabaseandroid.database.DefaultAppRepo;
import com.example.roomdatabaseandroid.database.local.entity.UserEntity;
import com.example.roomdatabaseandroid.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
   UserEntity userEntity;
   DefaultAppRepo defaultAppRepo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        defaultAppRepo = new DefaultAppRepo(getApplication());

        binding.submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SubmitClick();
            }
        });

        binding.viewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AllUserListActivity.class);
                startActivity(intent);
            }
        });
    }

    public void SubmitClick()
    {
        userEntity = new UserEntity();

        userEntity.user_name = binding.userName.getText().toString().trim();
        userEntity.name = binding.name.getText().toString().trim();
        userEntity.password = binding.password.getText().toString().trim();
        userEntity.address = binding.address.getText().toString().trim();

        defaultAppRepo.insertUser(userEntity);

        binding.userName.setText("");
        binding.name.setText("");
        binding.password.setText("");
        binding.address.setText("");

    }
}
