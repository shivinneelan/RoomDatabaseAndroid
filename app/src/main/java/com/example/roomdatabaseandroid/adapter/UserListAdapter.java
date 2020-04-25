package com.example.roomdatabaseandroid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roomdatabaseandroid.R;
import com.example.roomdatabaseandroid.click_listeners.ItemClickListener;
import com.example.roomdatabaseandroid.database.local.entity.UserEntity;

import java.util.List;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.PoItemHolder>{
    private Context context;
    private List<UserEntity> userList;
    ItemClickListener itemClickListener;


    public UserListAdapter(Context context, List<UserEntity> userList)
    {
        this.context = context;
        this.userList = userList;

    }


    @NonNull
    @Override
    public PoItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_list_item,parent,false);
        return new PoItemHolder(v);    }

    @Override
    public void onBindViewHolder(@NonNull PoItemHolder holder, final int position) {

        UserEntity user = userList.get(position);

        holder.name.setText(String.valueOf(user.name));
        holder.userName.setText(user.user_name);
        holder.address.setText(user.address);

        holder.userCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        holder.remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemClickListener != null) itemClickListener.onItemClick(v,position);

            }
        });
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }



    class PoItemHolder extends RecyclerView.ViewHolder
    {

        public TextView name,userName,address;
        public CardView userCard;
        ImageView remove;

        public PoItemHolder(View itemView)
        {
            super(itemView);
            //txt_popup = itemView.findViewById(R.id.txt_item_popup);
            name = itemView.findViewById(R.id.name);
            userName = itemView.findViewById(R.id.user_name);
            address = itemView.findViewById(R.id.address);
            userCard = itemView.findViewById(R.id.userCard);
            remove = itemView.findViewById(R.id.remove_user);

        }
    }

    public void setItemClickListener(ItemClickListener itemClickListener)
    {
        this.itemClickListener = itemClickListener;
    }
}
