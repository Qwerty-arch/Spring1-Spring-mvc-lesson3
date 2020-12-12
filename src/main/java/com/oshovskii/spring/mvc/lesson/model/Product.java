package com.oshovskii.spring.mvc.lesson.model;

public class Product {
    private Long id;
    private int cost;
    private String title;

    public Product() {
    }

    public Product(Long id, int cost, String title) {
        this.id = id;
        this.cost = cost;
        this.title = title;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public int getCost() {
        return cost;
    }

    public String getTitle() {
        return title;
    }
}
