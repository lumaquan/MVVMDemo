package com.ivan.mvvmdemo.ui.albums.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

public class Album implements Serializable {

    @Setter @Getter
    @SerializedName("userId")
    private int userId;

    @Setter @Getter
    @SerializedName("id")
    private int id;

    @Setter @Getter
    @SerializedName("title")
    private String title;

    public String getTitle() {
        return title;
    }
}
