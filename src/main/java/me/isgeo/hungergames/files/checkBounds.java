package me.isgeo.hungergames.files;

import me.isgeo.hungergames.commands.createArena;

public class checkBounds {

    public checkBounds() {
        int arenas = createArena.arenaList.size();
    }

    public static boolean arenaBox(Double x, Double y, Double z) {
        return createArena.arenaBox.contains(x, y, z);

    }

    // TODO: Add checks to ensure that arena boundaries do not overlap

}

