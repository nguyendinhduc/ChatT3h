package com.t3h.chatfun;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ducnd.statuscircel.CircleStatusImageView;

import java.util.List;

public class AddFriendAdapter extends RecyclerView.Adapter<AddFriendAdapter.HolderAddFriend> {
    private List<AddFriend> addFriends;
    public AddFriendAdapter(List<AddFriend> addFriends){
        this.addFriends = addFriends;
    }
    @NonNull
    @Override
    public HolderAddFriend onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.item_add_friend, viewGroup, false);
        return new HolderAddFriend(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderAddFriend holderAddFriend, int i) {
        holderAddFriend.tvName.setText(
                addFriends.get(i).getDisplayName()
        );
        GlideApp.with(holderAddFriend.itemView)
                .load(addFriends.get(i).getAvatar())
                .into(holderAddFriend.avatar);
        holderAddFriend.avatar.setActive(
                addFriends.get(i).isOnline()
        );
    }

    @Override
    public int getItemCount() {
        if(addFriends == null ){
            return 0;
        }
        return addFriends.size();
    }

    static final class HolderAddFriend extends RecyclerView.ViewHolder{
        private CircleStatusImageView avatar;
        private TextView tvName;
        public HolderAddFriend(@NonNull View itemView) {
            super(itemView);
            avatar = itemView.findViewById(R.id.iv_avatar);
            tvName = itemView.findViewById(R.id.tv_name);
        }
    }
}
