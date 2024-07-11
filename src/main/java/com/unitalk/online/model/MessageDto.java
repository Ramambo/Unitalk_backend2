package com.unitalk.online.model;

public MessageDto createMessage(MessageCreateRequestDto requestDto) {

    alarmService.alarmByMessage(messageDto);
    return messageDto;
}