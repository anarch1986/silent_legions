package com.anarch1986.silent_legions.region_generator;

import java.util.Random;

/**
 * Created by tomi on 2017.05.30..
 */
public class Region {
    public String name;
    public String terrain;
    private String[] terrains = {"Rocky", "Arid Badland", "Blasted Waste", "Desert",
            "Endless Sea", "Forest", "Icy Waste", "Island", "Jungle",
            "Moorland", "Mountains", "Plains", "River", "Savannah",
            "Swamp", "Tundra", "Underwater", "Volcanic"};

    public void terrainGenerator() {
        Random random = new Random();
        this.terrain = this.terrains[random.nextInt(terrains.length)];

    }

    public String[] getTerrains() {
        return terrains;
    }
}


