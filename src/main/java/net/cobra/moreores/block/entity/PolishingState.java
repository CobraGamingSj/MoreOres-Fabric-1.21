package net.cobra.moreores.block.entity;

import net.minecraft.util.StringIdentifiable;

public enum PolishingState{
    IDLE(0),
    RUNNING(1),
    PAUSED(2);

    final int id;

    PolishingState(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
