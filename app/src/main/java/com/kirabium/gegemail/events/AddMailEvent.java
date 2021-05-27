package com.kirabium.gegemail.events;

import com.kirabium.gegemail.di.DI;
import com.kirabium.gegemail.model.Mail;

public class AddMailEvent {
    public Mail mail;

    public AddMailEvent(Mail mail){
        this.mail = mail;
        DI.getMailApiService().createMail(mail);
    }
}
