package com.databasefirst.users.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.databasefirst.R;
import com.databasefirst.users.repo.dto.User;

import java.util.List;

public class UserRecyclerViewAdapter extends RecyclerView.Adapter<UserRecyclerViewAdapter.UserViewHolder> {
    private final Context context;
    private List<User> items;

    public UserRecyclerViewAdapter(Context context, List<User> items) {
        this.items = items;
        this.context = context;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent,
                                             int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_user, parent, false);
        return new UserViewHolder(v);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        User item = items.get(position);
        holder.set(context,item);
    }

    @Override
    public int getItemCount() {
        if (items == null) {
            return 0;
        }
        return items.size();
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {
        TextView textViewUserId, textViewUserFirstName, textViewUserLastName ;

        public UserViewHolder(View itemView) {
            super(itemView);

            textViewUserId = itemView.findViewById(R.id.text_view_user_id);
            textViewUserFirstName  = itemView.findViewById(R.id.text_view_user_first_name);
            textViewUserLastName  = itemView.findViewById(R.id.text_view_user_last_name);
        }

        public void set(Context context, User item) {
            //UI setting code
            textViewUserId.setText(context.getString(R.string.placeholder_id,item.getId()));
            textViewUserFirstName.setText(context.getString(R.string.placeholder_first_name,item.getFirstName()));
            textViewUserLastName.setText(context.getString(R.string.placeholder_last_name,item.getLastName()));
        }
    }
}