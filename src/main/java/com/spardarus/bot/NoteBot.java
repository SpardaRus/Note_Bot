package com.spardarus.bot;

import com.spardarus.service.BotService;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.spardarus.config.Proxy.buildBotOptions;

public class NoteBot extends TelegramLongPollingBot {

    public NoteBot() {
        super(buildBotOptions());
    }
    @Override
    public void onUpdateReceived(Update update) {
        new BotService().start(update);
    }

    @Override
    public String getBotUsername() {
        return "Note_1_bot";
    }

    @Override
    public String getBotToken() {
        return "739035818:AAEB2__vZ2eWV68sZps5ftLD8gOmfj_wZb4";
    }
}
