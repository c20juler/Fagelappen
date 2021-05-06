package com.example.fgelappen;

/*
    "ID": "f_blåmes",
	"name": "Blåmes",
	"type": "c20juler",
	"company": "",
	"location": "",
	"category": "Mesar",
	"size": 12,
	"cost": 0,
	"auxdata": null

	*/

public class Bird {

    private String ID;
    private String name;
    private String type;
    private String category;
    private int size;
    //private Auxdata auxdata - lägg till medlemsvariabel

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return name;
    }

}
