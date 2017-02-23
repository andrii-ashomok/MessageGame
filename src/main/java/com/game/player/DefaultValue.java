package com.game.player;

/**
 * Created by rado on 2/21/17.
 */
public enum DefaultValue {
    MESSAGE("Hello");

    private String value;

    DefaultValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
