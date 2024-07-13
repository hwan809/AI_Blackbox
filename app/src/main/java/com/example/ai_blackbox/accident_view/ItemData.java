package com.example.ai_blackbox.accident_view;

public class ItemData {
    public String accident_value;
    public int accident_image_id;
    public String accident_location;

    public String getAccidentValue() {
        return accident_value;
    }
    public void setAccidentValue(String item_num) {
        this.accident_value = item_num;
    }
    public int getAccident_image_id() {
        return accident_image_id;
    }
    public void setAccident_image_id(int accident_image_id) {
        this.accident_image_id = accident_image_id;
    }
    public String getAccident_location() {
        return accident_location;
    }
    public void setAccident_location(String accident_location) {
        this.accident_location = accident_location;
    }
}