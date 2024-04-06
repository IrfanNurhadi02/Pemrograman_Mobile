package com.example.tugas3;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Instagram implements Parcelable {
    private String username;
    private String caption;
    private Integer fotoProfile;
    private Integer fotoPostingan;
    private Integer fotoStory;
    private String followers;
    private String following;
    private String likes;

    public Instagram(String username, String caption, Integer fotoProfile, Integer fotoPostingan, Integer fotoStory, String followers, String following, String likes) {
        this.username = username;
        this.caption = caption;
        this.fotoProfile = fotoProfile;
        this.fotoPostingan = fotoPostingan;
        this.fotoStory = fotoStory;
        this.followers = followers;
        this.following = following;
        this.likes = likes;
    }

    protected Instagram(Parcel in) {
        username = in.readString();
        caption = in.readString();
        if (in.readByte() == 0) {
            fotoProfile = null;
        } else {
            fotoProfile = in.readInt();
        }
        if (in.readByte() == 0) {
            fotoPostingan = null;
        } else {
            fotoPostingan = in.readInt();
        }
        if (in.readByte() == 0) {
            fotoStory = null;
        } else {
            fotoStory = in.readInt();
        }
        followers = in.readString();
        following = in.readString();
        likes = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(username);
        dest.writeString(caption);
        if (fotoProfile == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(fotoProfile);
        }
        if (fotoPostingan == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(fotoPostingan);
        }
        if (fotoStory == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(fotoStory);
        }
        dest.writeString(followers);
        dest.writeString(following);
        dest.writeString(likes);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Instagram> CREATOR = new Creator<Instagram>() {
        @Override
        public Instagram createFromParcel(Parcel in) {
            return new Instagram(in);
        }

        @Override
        public Instagram[] newArray(int size) {
            return new Instagram[size];
        }
    };

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public Integer getFotoProfile() {
        return fotoProfile;
    }

    public void setFotoProfile(Integer fotoProfile) {
        this.fotoProfile = fotoProfile;
    }

    public Integer getFotoPostingan() {
        return fotoPostingan;
    }

    public void setFotoPostingan(Integer fotoPostingan) {
        this.fotoPostingan = fotoPostingan;
    }

    public Integer getFotoStory() {
        return fotoStory;
    }

    public void setFotoStory(Integer fotoStory) {
        this.fotoStory = fotoStory;
    }

    public String getFollowers() {
        return followers;
    }

    public void setFollowers(String followers) {
        this.followers = followers;
    }

    public String getFollowing() {
        return following;
    }

    public void setFollowing(String following) {
        this.following = following;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }
}
