package org.example.exercises;

public class Item {

    public String name;

    public int sellIn;

    public int quality;

    private static final String STRING_PREFIX = "name=";
    private static final String STRING_BREAKS = ", ";
    private static final String LINE_FEED = "\n";

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return LINE_FEED + STRING_PREFIX + name + STRING_BREAKS + sellIn + STRING_BREAKS + quality + LINE_FEED;
    }


}
