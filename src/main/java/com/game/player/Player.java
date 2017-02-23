package com.game.player;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by rado on 2/21/17.
 */
public class Player {
    private String id;
    private String message;
    private AtomicInteger count;
    private boolean isMaster;
    private PlayerState state;

    public Player() {
        this.id = UUID.randomUUID().toString();
        this.message = DefaultValue.MESSAGE.getValue();
        this.count = new AtomicInteger(0);
        this.isMaster = false;
        this.state = PlayerState.NOT_READY;
    }

    public Player(String id, boolean isMaster, PlayerState state) {
        this.id = id;
        this.message = DefaultValue.MESSAGE.getValue();
        this.count = new AtomicInteger(0);
        this.isMaster = isMaster;
        this.state = state;
    }

    public Player(boolean isMaster, PlayerState state) {
        this.id = UUID.randomUUID().toString();
        this.message = DefaultValue.MESSAGE.getValue();
        this.count = new AtomicInteger(0);
        this.isMaster = isMaster;
        this.state = state;
    }

    public Player(boolean isMaster) {
        this.id = UUID.randomUUID().toString();
        this.message = DefaultValue.MESSAGE.getValue();
        this.count = new AtomicInteger(0);
        this.isMaster = isMaster;
        this.state = PlayerState.NOT_READY;
    }

    public Player(String id, String message, int count, boolean isMaster, PlayerState playerState) {
        this.id = id;
        this.message = message;
        this.count = new AtomicInteger(count);
        this.isMaster = isMaster;
        this.state = playerState;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCount() {
        return count.get();
    }

    public void setCount(int count) {
        this.count = new AtomicInteger(count);
    }

    public boolean isMaster() {
        return isMaster;
    }

    public void setMaster(boolean master) {
        isMaster = master;
    }

    public PlayerState getState() {
        return state;
    }

    public int incr() {
        return count.incrementAndGet();
    }

    public String getStringCount() {
        return String.valueOf(count);
    }

    public void setReady() {
        this.state = PlayerState.READY;
    }

    public boolean isReady() {
        return PlayerState.READY.equals(state);
    }

    @Override
    public String toString() {
        return "Player{" +
                "id='" + id + '\'' +
                ", message='" + message + '\'' +
                ", count=" + count +
                ", isMaster=" + isMaster +
                ", state=" + state +
                '}';
    }
}
