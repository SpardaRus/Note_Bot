package com.spardarus.service;

import com.spardarus.bot.NoteBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class BotService {
    public void start(Update update){
        SendMessage message = new SendMessage()
                .setChatId(update.getMessage().getChatId())
                .setText(update.getMessage().getText());
        try {
            new NoteBot().execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
