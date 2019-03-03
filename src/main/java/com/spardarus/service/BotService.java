package com.spardarus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class BotService implements BotStartable{

    @Autowired
    private TelegramLongPollingBot telegramLongPollingBot;

    public void start(Update update){
        SendMessage message = new SendMessage()
                .setChatId(update.getMessage().getChatId())
                .setText(update.getMessage().getText());
        try {
            telegramLongPollingBot.execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
