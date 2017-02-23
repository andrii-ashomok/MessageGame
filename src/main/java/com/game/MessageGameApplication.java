package com.game;

import com.game.chat.ChatService;
import com.game.chat.ChatServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MessageGameApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context =
				SpringApplication.run(MessageGameApplication.class, args);

		ChatService chatService = context.getBean(ChatServiceImpl.class);
		chatService.setReady();
		chatService.start();
	}
}
