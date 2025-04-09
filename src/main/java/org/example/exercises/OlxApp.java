package org.example.exercises;

import java.util.Arrays;
import java.util.Map;

interface ItemUpdater {
    void updateItem(Item item);
}

class DefaultItemUpdater implements ItemUpdater {
    @Override
    public void updateItem(Item item) {
        if (item.quality > 0) {
            item.quality--;
        }
        item.sellIn--;

        if (item.sellIn < 0 && item.quality > 0) {
            item.quality--;
        }
    }
}

class WineUpdater implements ItemUpdater {
    @Override
    public void updateItem(Item item) {
        item.sellIn--;
        if (item.quality < 50) {
            item.quality++;
            if (item.sellIn < 0 && item.quality < 50) {
                item.quality++;
            }
        }
    }
}

class ConcertPassUpdater implements ItemUpdater {
    @Override
    public void updateItem(Item item) {
        item.sellIn--;
        if (item.sellIn < 0) {
            item.quality = 0;
            return;
        }

        if (item.quality < 50) {
            item.quality++;
            if (item.sellIn < 10 && item.quality < 50) item.quality++;
            if (item.sellIn < 5 && item.quality < 50) item.quality++;
        }
    }
}

class PokemonUpdater implements ItemUpdater {
    @Override
    public void updateItem(Item item) {
    }
}


class ItemUpdaterImplementation {
    private static final Map<String, ItemUpdater> updaterMap = Map.of(
            "Aged Wine", new WineUpdater(),
            "ColdPlay concert passes", new ConcertPassUpdater(),
            "PokemonGo", new PokemonUpdater()
    );

    public static ItemUpdater getUpdater(Item item) {
        return updaterMap.getOrDefault(item.name, new DefaultItemUpdater());
    }
}


public class OlxApp {

    public Item[] items;

    public OlxApp(Item[] items) {
        this.items = items;
    }

    public static void main(String[] args) {

        Item[] items = new Item[]{new Item("Mangoes", 10, 20)};

        OlxApp app = new OlxApp(items);

        app.updateQuality();

        System.out.println(app);

    }

    public void updateQuality() {
        for (Item item : items) {
            ItemUpdater updater = ItemUpdaterImplementation.getUpdater(item);
            updater.updateItem(item);
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }

}