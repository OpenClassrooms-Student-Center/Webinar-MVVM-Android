package com.kirabium.gegemail.events;

import com.kirabium.gegemail.di.DI;
import com.kirabium.gegemail.model.Mail;

public class DeleteMailEvent {
    public Mail mail;

    public DeleteMailEvent(Mail mail){
        this.mail = mail;
        DI.getMailApiService().deleteMail(mail);
    }
}
