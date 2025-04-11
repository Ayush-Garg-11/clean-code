package problems;

import org.example.exercises.Item;
import org.example.exercises.OlxApp;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OlxAppCBackstagePassesTest {

    @Test
    public void testUpdateQualityBackstagePasses1() {
        Item item = new Item("ColdPlay concert passes", 15, 3);
        Item[] items = new Item[]{item};
        OlxApp app = new OlxApp(items);
        app.updateQuality();
        assertEquals("ColdPlay concert passes", app.items[0].name);
        assertEquals(14, app.items[0].sellIn);
        assertEquals(4, app.items[0].quality);
    }

    @Test
    public void testUpdateQualityBackstagePasses2() {
        Item item = new Item("ColdPlay concert passes", 7, 3);
        Item[] items = new Item[]{item};
        OlxApp app = new OlxApp(items);
        app.updateQuality();
        assertEquals("ColdPlay concert passes", app.items[0].name);
        assertEquals(6, app.items[0].sellIn);
        assertEquals(5, app.items[0].quality);
    }

    @Test
    public void testUpdateQualityBackstagePasses3() {
        Item item = new Item("ColdPlay concert passes", 4, 3);
        Item[] items = new Item[]{item};
        OlxApp app = new OlxApp(items);
        app.updateQuality();
        assertEquals("ColdPlay concert passes", app.items[0].name);
        assertEquals(3, app.items[0].sellIn);
        assertEquals(6, app.items[0].quality);
    }

}