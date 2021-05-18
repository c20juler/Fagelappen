package com.example.fgelappen;

public class Bird {

    private String ID;
    private String name;
    private String type;
    private String category;
    private int size;
    private Auxdata auxdata;

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public int getSize() {
        return size;
    }

    public Auxdata getAuxdata() {
        return auxdata;
    }

    @Override
    public String toString() {
        return name;
    }
}


