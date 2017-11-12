package com.neptune.itcenter.boms;

public enum Level {
    BEGINNER,
    BASIC,
    INTERMEDIATE,
    ADVANCED {
        @Override
        public Level next() {
            return this;
        }
    };

    public Level next() {
        return values()[ordinal() + 1];
    }
}
