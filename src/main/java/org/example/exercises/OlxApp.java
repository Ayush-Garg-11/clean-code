package org.example.exercises;

import java.util.Arrays;

public class OlxApp {

    public static final String COLD_PLAY_CONCERT_PASSES = "ColdPlay concert passes";
    public static final String AGED_WINE = "Aged Wine";
    public static final String POKEMON_GO = "PokemonGo";
    public Item[] items;

    public OlxApp(Item[] items) {
        this.items = items;
    }

    public static void main(String[] args) {

        Item[] items = new Item[]{
                new Item("Mangoes", 10, 20)
        };

        OlxApp app = new OlxApp(items);

        app.updateQuality();

        System.out.println(app);

    }

    public void updateQuality() {
        for (Item item : items) {
            updateSellIn(item);
            if (isDepreciatingItem(item)) {
                updateDepreciatingItem(item);
            }
            else if(isVeblenItem(item)) {
                updateVeblenItem(item);
            }

            // Everything except for Sulfuras the sellIn Decreases


            if (item.sellIn < 0) {
                if (!item.name.equals(AGED_WINE)) {

                    if (!item.name.equals(COLD_PLAY_CONCERT_PASSES)) {
                        if (item.quality > 0) {
                            if (!isStaticItem(item)) {
                                item.quality = item.quality - 1;
                            }
                        }
                    } else {
                        // For Backstage passes with sellin less than zero
                        // quality is set to zero
                        item.quality = 0;
                    }
                } else {
                    // For Aged Wine below 50 quality increases actually by 2
                    // In the previous line
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;
                    }
                }
            }
        }
    }

    private static void updateVeblenItem(Item item) {
        if (item.quality >= 50) {
            item.quality = item.quality + 1;

            if (item.name.equals(COLD_PLAY_CONCERT_PASSES)) {
                if (item.sellIn <= 10) {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;
                    }
                }
                if (item.sellIn <= 5) {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;
                    }
                }
            }
        }
        if (item.sellIn < 0){
            if (item.name.equals(COLD_PLAY_CONCERT_PASSES)) {
                if (item.quality > 0) {
                    item.quality = 0;
                }
            }
            if(item.name.equals(AGED_WINE)){
                item.quality  = item.quality + 1;
            }
        }
    }

    private static void updateDepreciatingItem(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
        if(item.sellIn <= 0) {
            if (item.quality > 0) {
                item.quality = item.quality - 1;
            }
        }
    }

    private static void updateSellIn(Item item) {
        if (!isStaticItem(item)) {
            item.sellIn = item.sellIn - 1;
        }
    }

    private static boolean isDepreciatingItem(Item item) {
        return !(isVeblenItem(item) || isStaticItem(item));
    }

    private static boolean isStaticItem(Item item) {
        return item.name.equals(POKEMON_GO);
    }

    private static boolean isVeblenItem(Item item) {
        return item.name.equals(AGED_WINE) || item.name.equals(COLD_PLAY_CONCERT_PASSES);
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }

}