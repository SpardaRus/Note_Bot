package com.spardarus;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Configuration
@ComponentScan(basePackages = {"com.spardarus.service", "com.spardarus.bot", "com.spardarus.config"})
public class Application {

    private static TelegramLongPollingBot telegramLongPollingBot;

    public static void main(String[] args) {
        System.out.println("Bot Start");
        ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
        telegramLongPollingBot = context.getBean(TelegramLongPollingBot.class);
        ApiContextInitializer.init();
        TelegramBotsApi botsApi = new TelegramBotsApi();
        try {
            System.out.println("RegisterBot Start");
            botsApi.registerBot(telegramLongPollingBot);
            System.out.println("RegisterBot OK");
        } catch (TelegramApiException te) {
            System.out.println("RegisterBot FAIL");
            te.printStackTrace();
        }
        System.out.println("Bot Ok");
    }
}
