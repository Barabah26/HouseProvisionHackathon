package ua.edu.ldubgd.HouseProvision;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import ua.edu.ldubgd.HouseProvision.config.BotConfig;
import ua.edu.ldubgd.HouseProvision.processors.DefaultProcessor;

@Component
public class HouseProvisionBot extends TelegramLongPollingBot {

    @Autowired
    BotConfig config;
    @Override
    public String getBotUsername() {
        return config.getBotName();
    }

    @Override
    public String getBotToken() {
        return config.getToken();
    }

    private DefaultProcessor processor;

    @Override
    public void onUpdateReceived(Update update) {
        processor.process(update);
    }

    @Autowired
    public void setProcessor(DefaultProcessor processor) {
        this.processor = processor;
    }
}
