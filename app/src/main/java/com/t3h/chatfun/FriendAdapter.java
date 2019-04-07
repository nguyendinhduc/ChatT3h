package com.t3h.chatfun;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ducnd.statuscircel.CircleStatusImageView;

import java.util.List;

public class FriendAdapter extends RecyclerView.Adapter<FriendAdapter.FriendHolder> {
    private List<Friend> friends;

    public FriendAdapter(List<Friend> friends) {
        this.friends = friends;
    }

    @NonNull
    @Override
    public FriendHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.item_friend, viewGroup, false);
        return new FriendHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FriendHolder friendHolder, int position) {
        Friend friend = friends.get(position);
        friendHolder.tvName.setText(friend.getDisplayNameFriend());
        friendHolder.tvLastMessage.setText(friend.getContent());
        friendHolder.img.setActive(friend.isOnline());
        GlideApp.with(friendHolder.itemView.getContext())
                .load(friend.getFriendAvatar())
                .placeholder(R.drawable.ic_person_grey_400_48dp)
                .error(R.drawable.ic_person_grey_400_48dp)
                .into(friendHolder.img);
    }

    @Override
    public int getItemCount() {
        return friends.size();
    }

    static class FriendHolder extends RecyclerView.ViewHolder {
        private CircleStatusImageView img;
        private TextView tvName;
        private TextView tvLastMessage;
        private TextView tvTime;

        public FriendHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.iv_avatar);
            tvName = itemView.findViewById(R.id.tv_name);
            tvLastMessage = itemView.findViewById(R.id.tv_last_message);
            tvTime = itemView.findViewById(R.id.tv_date_last_message);
        }
    }

    public List<Friend> getFriends() {
        return friends;
    }

    public void setFriends(List<Friend> friends) {
        this.friends = friends;
    }
}
