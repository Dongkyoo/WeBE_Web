package com.dongkyoo.webe.datas.vos;

public class Group {

    private int id;
    private String name;
    private String description;
    private String titleImageUri;
    private boolean isPublic;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitleImageUri() {
        return titleImageUri;
    }

    public void setTitleImageUri(String titleImageUri) {
        this.titleImageUri = titleImageUri;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }

    public String getIsPublic() {
        return isPublic ? "Y" : "N";
    }
}
