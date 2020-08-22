package com.example.ddbb;

class LibContans  {
    private int id_book;
    private String name_book;
    private int amount_book;
    private double price_book;

    public LibContans(  String name_book, int amount_book, double price_book) {

        this.name_book = name_book;
        this.amount_book = amount_book;
        this.price_book = price_book;
    }

    public LibContans(int id_book, String name_book, int amount_book, double price_book) {
        this.id_book = id_book;
        this.name_book = name_book;
        this.amount_book = amount_book;
        this.price_book = price_book;
    }

    public int getId_book() {
        return id_book;
    }

    public void setId_book(int id_book) {
        this.id_book = id_book;
    }

    public String getName_book() {
        return name_book;
    }

    public void setName_book(String name_book) {
        this.name_book = name_book;
    }

    public int getAmount_book() {
        return amount_book;
    }

    public void setAmount_book(int amount_book) {
        this.amount_book = amount_book;
    }

    public double getPrice_book() {
        return price_book;
    }

    public void setPrice_book(double price_book) {
        this.price_book = price_book;
    }
}
