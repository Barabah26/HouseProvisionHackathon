package ua.edu.ldubgd.HouseProvision.messageSender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ua.edu.ldubgd.HouseProvision.HouseProvisionBot;

@Component
public class MessageSenderImpl implements MessageSender{
    private HouseProvisionBot telegramBot;
    @Override
    public void sendMessage(SendMessage sendMessage) {
        try {
            telegramBot.execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
    @Autowired
    public void setTelegramBot(@Lazy HouseProvisionBot telegramBot) {
        this.telegramBot = telegramBot;
    }

}
