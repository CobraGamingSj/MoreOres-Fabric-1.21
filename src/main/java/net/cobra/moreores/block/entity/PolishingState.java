package net.cobra.moreores.block.entity;

public enum PolishingState{
    IDLE(0),
    RUNNING(1),
    PAUSED(2);

    int id;

    PolishingState(int id) {
        this.id = id;
    }

    public void setState(int id) {
        this.id = id;
    }
}
