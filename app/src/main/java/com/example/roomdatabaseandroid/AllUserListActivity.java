package com.example.roomdatabaseandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.roomdatabaseandroid.adapter.UserListAdapter;
import com.example.roomdatabaseandroid.click_listeners.ItemClickListener;
import com.example.roomdatabaseandroid.database.DefaultAppRepo;
import com.example.roomdatabaseandroid.database.local.entity.UserEntity;
import com.example.roomdatabaseandroid.databinding.ActivityAllUserListBinding;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class AllUserListActivity extends AppCompatActivity implements ItemClickListener {
UserListAdapter userListAdapter;
RecyclerView recyclerView;
ActivityAllUserListBinding binding;
DefaultAppRepo defaultAppRepo;
List<UserEntity> list;
UserEntity user;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAllUserListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        defaultAppRepo = new DefaultAppRepo(getApplication());

        try {

            list = defaultAppRepo.getAllUsers();
            if(list != null) {
                binding.allUserCount.setText("No of User :" + String.valueOf(list.size()));
                setAdapter();
            }
            else
                binding.allUserCount.setText("No of User : 0");


        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    public void setAdapter()
    {
        binding.userRecyclerView.setHasFixedSize(true);
        binding.userRecyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),3));
        userListAdapter = new UserListAdapter(getApplicationContext(),list);
        binding.userRecyclerView.setAdapter(userListAdapter);
        userListAdapter.setItemClickListener(this);

    }

    @Override
    public void onItemClick(View view, int position) {
        if (userListAdapter != null)
        {
            user = list.get(position);
            defaultAppRepo.deleteUser(user);


            list.remove(position);
            userListAdapter.notifyDataSetChanged();

            if (userListAdapter.getItemCount()<1){
                binding.userRecyclerView.setVisibility(View.GONE);
                binding.allUserCount.setText("No of User : 0");
            }
            else
                binding.allUserCount.setText("No of User :" + String.valueOf(list.size()));


        }
    }
}
