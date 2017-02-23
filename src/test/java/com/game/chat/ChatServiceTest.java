package com.game.chat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.util.UUID;

/**
 * Created by rado on 2/23/17.
 */
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.MOCK)
@DirtiesContext
@Test(suiteName = "chatService", groups = {"regression"})
public class ChatServiceTest extends AbstractTestNGSpringContextTests {

    static {
        System.setProperty("spring.config.location", "classpath:test.properties");
    }

   @Autowired
    private ChatService chatService;


    @Test
    public void testGetPlayerAndSetReady() {
        assert !chatService.getPlayerState();
        chatService.setReady();
        assert chatService.getPlayerState();
    }

    @Test
    public void testAddNewPlayer() {
        String id = UUID.randomUUID().toString();
        assert !chatService.containsClientId(id);

        chatService.regClient(null, false);
        assert !chatService.containsClientId(id);

        chatService.regClient("", false);
        assert !chatService.containsClientId(id);

        chatService.regClient(id, false);
        assert chatService.containsClientId(id);
    }

    @Test
    public void testContainsClientId() {
        String id = UUID.randomUUID().toString();
        assert !chatService.containsClientId(id);

        chatService.regClient(id, false);
        assert chatService.containsClientId(id);

        assert !chatService.containsClientId(null);
        assert !chatService.containsClientId("");
        assert !chatService.containsClientId(UUID.randomUUID().toString());
    }

}
