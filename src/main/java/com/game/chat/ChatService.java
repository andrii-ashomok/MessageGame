package com.game.chat;

/**
 * Created by rado on 2/21/17.
 */
public interface ChatService {
    String CLIENT_HOST = "http://localhost:";
    int COUNT_LIMIT = 10;
    String READY_LINK = "/ready";

    /**
     * @return true - if player (process owner) is ready, false - player is not ready
     */
    boolean getPlayerState();

    /**
     * Player (process owner) change state to READY
     */
    void setReady();

    /**
     * Registration second player
     * @param id - the number identify second player
     * @param isDomainNode - true - gives player chance to send first message;
     *                     false - player waits for incoming message;
     */
    void regClient(String id, boolean isDomainNode);

    boolean containsClientId(String id);

    /**
     * send message by http, using player id, player message, player count
     */
    void sendMessage();

    /**
     * Update second player data using incoming message and count identified by id
     * @param id - second player id;
     * @param msg - new message;
     * @param count - message number;
     */
    void updateClient(String id, String msg, int count);

    /**
     * Start chat process
     */
    void start();

    /**
     * turn off chatting and hole program at all;
     * @param id - player id that first sent 10 messages
     */
    void exit(String id);
}
