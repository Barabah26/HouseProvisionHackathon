package ua.edu.ldubgd.HouseProvision.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Message;
import ua.edu.ldubgd.HouseProvision.messageSender.MessageSender;
import ua.edu.ldubgd.HouseProvision.services.SendMessageService;

@Component
public class MessageHandler implements Handler<Message>{
    private SendMessageService sendMessageService;
    private MessageSender messageSender;


//    private final Cache<BotUser> cache;

    @Autowired
    public void setSendMessageService(SendMessageService sendMessageService) {
        this.sendMessageService = sendMessageService;
    }

    @Autowired
    public void setMessageSender(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

//    public MessageHandler(Cache<BotUser> cache) {
//        this.cache = cache;
//
//    }



    @Override
    public void choose(Message message) {
        sendMessageService.sendMessage(message,"hello");


    }



}
