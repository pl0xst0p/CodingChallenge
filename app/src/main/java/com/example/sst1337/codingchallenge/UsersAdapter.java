package com.example.sst1337.codingchallenge;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by sst1337 on 8/4/17.
 */

class UsersAdapter extends RecyclerView.Adapter
{

    OnItemClickListener mItemClickListener;

    public interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(
            final OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

    private List<User> usersData;

    public static class UserViewHolder extends RecyclerView.ViewHolder
    {
        CardView cv;
        TextView personName;
        TextView personInfo;
        ImageView personPhoto;

        public UserViewHolder(View itemView)
        {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.cv);
            personName = (TextView) itemView.findViewById(R.id.person_name);
            personInfo = (TextView) itemView.findViewById(R.id.person_age);
            personPhoto = (ImageView) itemView.findViewById(R.id.person_photo);

            itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    Intent myIntent = new Intent(v.getContext(), UserActivity.class);
                    // Pass object through GSON
                    v.getContext().startActivity(myIntent);
                }
            });
        }
    }

    public UsersAdapter(List<User> users)
    {
        usersData = users;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v = (View) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_card, parent, false);

        UserViewHolder vh = new UserViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position)
    {
        UserViewHolder view = (UserViewHolder) holder;
        view.personName.setText(usersData.get(position).name);
        view.personInfo.setText(usersData.get(position).getInformation());
    }

    @Override
    public int getItemCount()
    {
        return usersData.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView)
    {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
