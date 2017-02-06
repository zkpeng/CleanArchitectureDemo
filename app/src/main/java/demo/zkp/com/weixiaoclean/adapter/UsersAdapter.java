/**
 * Copyright (C) 2014 android10.org. All rights reserved.
 *
 * @author Fernando Cejas (the android10 coder)
 */
package demo.zkp.com.weixiaoclean.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import demo.zkp.com.data.entity.entity.UserEntity;
import demo.zkp.com.weixiaoclean.R;
import demo.zkp.com.weixiaoclean.model.UserModel;

/**
 * Adaptar that manages a collection of {@link UserModel}.
 */
public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UserViewHolder> {

    public interface OnItemClickListener {
        void onUserItemClicked(UserEntity userModel);
    }

    private List<UserEntity> usersCollection;
    private final LayoutInflater layoutInflater;

    private OnItemClickListener onItemClickListener;

    public UsersAdapter(Context context) {
        this.layoutInflater =
                (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.usersCollection = Collections.emptyList();
    }

    @Override
    public int getItemCount() {
        return (this.usersCollection != null) ? this.usersCollection.size() : 0;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = this.layoutInflater.inflate(R.layout.row_user, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, final int position) {
        final UserEntity userModel = this.usersCollection.get(position);
        holder.textViewTitle.setText(userModel.getFullname());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (UsersAdapter.this.onItemClickListener != null) {
                    UsersAdapter.this.onItemClickListener.onUserItemClicked(userModel);
                }
            }
        });
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void setUsersCollection(Collection<UserEntity> usersCollection) {
        this.validateUsersCollection(usersCollection);
        this.usersCollection = (List<UserEntity>) usersCollection;
        this.notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    private void validateUsersCollection(Collection<UserEntity> usersCollection) {
        if (usersCollection == null) {
            throw new IllegalArgumentException("The list cannot be null");
        }
    }

    static class UserViewHolder extends RecyclerView.ViewHolder {
        TextView textViewTitle;

        public UserViewHolder(View itemView) {
            super(itemView);
            textViewTitle = (TextView) itemView.findViewById(R.id.title);
        }
    }
}
