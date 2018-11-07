package com.company;


public class Item implements Carryable  {
    private String itemName;
    private int itemWeight;
    private boolean isOnStock;



    public Item(String itemName, int itemWeight) {  //constructor
        this.itemName = itemName;
        this.itemWeight = itemWeight;
        this.isOnStock = true;
    }


    public String getName() {
        return itemName;
    }

    public void setName(String itemName) {
        this.itemName = itemName;
    }

    public int getWeight() {
        return itemWeight;
    }

    public void setWeight(int itemWeight) {
        this.itemWeight = itemWeight;
    }

    public boolean isOnStock() {
        return isOnStock;
    }

    public void setOnStock(boolean onStock) {
        isOnStock = onStock;
    }
}

