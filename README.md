# MessageGame
#Having a Player object
1. a Player object has a state "ready" or "not ready"
2. a Player object can send and receive messages

#The use case for this task is as bellow:
1. create 2 players
2. wait until both players are "ready"
3. one of the players should send a message to second player
4. when a player receives a message should send back a new message that contains the previous message concatenated with the message counter that this player sent.
5. finalize the program (gracefully) after one of the players sent 10 messages (stop condition)
6. document for every class the responsibilities it has.
7. additional challenge: have every player in a separate JAVA process
