package com.shakil.ni_khoj.models.newsfeed;

public class NewFeedModel {
    private String UserName;
    private String PostDate;
    private String Location;
    private String Description;
    private int imageIcon;

    public NewFeedModel(String userName, String PostDate, String location, String description, int imageIcon) {
        this.UserName = userName;
        this.PostDate = PostDate;
        this.Location = location;
        this.Description = description;
        this.imageIcon = imageIcon;
    }

    public NewFeedModel() {
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPostDate() {
        return PostDate;
    }

    public void setPostDate(String postDate) {
        PostDate = postDate;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getImageIcon() {
        return imageIcon;
    }

    public void setImageIcon(int imageIcon) {
        this.imageIcon = imageIcon;
    }
}
