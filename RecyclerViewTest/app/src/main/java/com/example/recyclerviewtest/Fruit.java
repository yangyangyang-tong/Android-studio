package com.example.recyclerviewtest;

public class Fruit{
    private String name;
    private int imageid;
    public Fruit(String name,int imageid)
    {
        this.name=name;
        this.imageid=imageid;
    }
    public String getName()
    {
        return name;
    }
    public int getImageId(){
        return imageid;
    }
}