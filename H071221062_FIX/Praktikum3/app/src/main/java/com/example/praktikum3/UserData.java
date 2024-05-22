package com.example.praktikum3;

import android.os.Parcel;
import android.os.Parcelable;

public class UserData implements Parcelable {
    private Integer profilUser;
    private String usernameUser;
    private Integer imagePostStory;
    private int feedImage;
    private String caption;
    private int followingCount;
    private int followerCount;

    public UserData(Integer profilUser, Integer imagePostStory, String usernameUser, int feedImage, String caption, int followingCount, int followerCount) {
        this.profilUser = profilUser;
        this.imagePostStory = imagePostStory;
        this.usernameUser = usernameUser;
        this.feedImage = feedImage;
        this.caption = caption;
        this.followingCount = followingCount;
        this.followerCount = followerCount;
    }

    public Integer getProfilUser() {
        return profilUser;
    }

    public void setProfilUser(Integer profilUser) {
        this.profilUser = profilUser;
    }

    public Integer getImagePostStory() {
        return imagePostStory;
    }

    public void setImagePostStory(Integer imagePostStory) {
        this.imagePostStory = imagePostStory;
    }

    public String getUsernameUser() {
        return usernameUser;
    }

    public void setUsernameUser(String usernameUser) {
        this.usernameUser = usernameUser;
    }

    public int getFeedImage() {
        return feedImage;
    }

    public void setFeedImage(int feedImage) {
        this.feedImage = feedImage;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public int getFollowingCount() {
        return followingCount;
    }

    public void setFollowingCount(int followingCount) {
        this.followingCount = followingCount;
    }

    public int getFollowerCount() {
        return followerCount;
    }

    public void setFollowerCount(int followerCount) {
        this.followerCount = followerCount;
    }

    // Parcelable implementation
    protected UserData(Parcel in) {
        if (in != null) {
            profilUser = in.readInt();
            usernameUser = in.readString();
            imagePostStory = in.readInt();
            feedImage = in.readInt();
            caption = in.readString();
            followingCount = in.readInt();
            followerCount = in.readInt();
        }
    }

    public static final Creator<UserData> CREATOR = new Creator<UserData>() {
        @Override
        public UserData createFromParcel(Parcel in) {
            return new UserData(in);
        }

        @Override
        public UserData[] newArray(int size) {
            return new UserData[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (dest != null) {
            dest.writeInt(profilUser);
            dest.writeString(usernameUser);
            dest.writeInt(imagePostStory);
            dest.writeInt(feedImage);
            dest.writeString(caption);
            dest.writeInt(followingCount);
            dest.writeInt(followerCount);
        }
    }
}
