package com.spardarus.service;

import org.telegram.telegrambots.meta.api.objects.Update;

public interface BotStartable {
    void start(Update update);
}
