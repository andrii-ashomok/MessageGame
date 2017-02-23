package com.game.chat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * Created by rado on 2/21/17.
 */
@RestController
@RequestMapping
public class ChatController implements Field {
    private Predicate<String> IS_STR_VALID = str -> Objects.nonNull(str) || !str.isEmpty();

    @Autowired
    private ChatService chatService;

    @RequestMapping("/signin")
    public boolean signIn(@RequestParam("id") String id,
                          @RequestParam(name = "domain", defaultValue = "false") boolean isDomainNode) {

        chatService.regClient(id, isDomainNode);
        return true;
    }

    @RequestMapping("/ready")
    public boolean isReady() {
        if (Objects.isNull(chatService))
            return false;

        return chatService.getPlayerState();
    }

    @RequestMapping("/message")
    public boolean getMessage(@RequestParam(ID) String id,
               @RequestParam(MSG) String msg,
               @RequestParam(COUNT) int count) {

        if (IS_STR_VALID.test(id)) {
            chatService.updateClient(id, msg, count);
            return true;
        }

        return false;
    }

}
