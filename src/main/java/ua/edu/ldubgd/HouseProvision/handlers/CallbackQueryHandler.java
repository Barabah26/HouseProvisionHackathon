package ua.edu.ldubgd.HouseProvision.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import ua.edu.ldubgd.HouseProvision.services.SendMessageService;

@Component
public class CallbackQueryHandler implements Handler<CallbackQuery>{
    private SendMessageService sendMessageService;
//    private final Cache<BotUser> cache;


    @Autowired
    public void setSendMessageService(SendMessageService sendMessageService) {
        this.sendMessageService = sendMessageService;
    }


//    public CallbackQueryHandler(Cache<BotUser> cache) {
//        this.cache = cache;
//    }

    @Override
    public void choose(CallbackQuery callbackQuery) {

        }
}

