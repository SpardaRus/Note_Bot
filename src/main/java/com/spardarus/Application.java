package com.spardarus;

import com.spardarus.bot.NoteBot;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Application {
    public static void main(String[] args) {
        System.out.println("Start");
        ApiContextInitializer.init();
        TelegramBotsApi botsApi = new TelegramBotsApi();
        try {
            System.out.println("RegisterBot Start");
            botsApi.registerBot(new NoteBot());
            System.out.println("RegisterBot OK");
        } catch (TelegramApiException te) {
            System.out.println("RegisterBot FAIL");
            te.printStackTrace();
        }

        System.out.println("End");
    }
}
