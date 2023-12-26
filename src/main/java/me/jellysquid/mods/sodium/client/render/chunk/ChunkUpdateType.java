package me.jellysquid.mods.sodium.client.render.chunk;

public enum ChunkUpdateType {
    INITIAL_BUILD(64),
    REBUILD(64),
    IMPORTANT_REBUILD(Integer.MAX_VALUE);

    private static final int MAX_QUEUE_SIZE = 64;

    ChunkUpdateType() {
    }

    public static boolean canPromote(ChunkUpdateType prev, ChunkUpdateType next) {
        return prev != IMPORTANT_REBUILD && next == IMPORTANT_REBUILD;
    }

    public int getMaximumQueueSize() {
        return MAX_QUEUE_SIZE;
    }

    public boolean isImportant() {
        return this == IMPORTANT_REBUILD;
    }
}
