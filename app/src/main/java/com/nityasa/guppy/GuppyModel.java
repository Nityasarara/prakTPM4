package com.nityasa.guppy;

public class GuppyModel {
    private String image, name, price ,description;

    public GuppyModel(String image, String name, String price, String description) {
        this.image       = image;
        this.name        = name;
        this.price       = price;
        this.description = description;
    }

    public String getImage() {
        return image;
    }
    public String getName() {
        return name;
    }
    public String getPrice() { return price; }
    public String getDescription() {
        return description;
    }

}
