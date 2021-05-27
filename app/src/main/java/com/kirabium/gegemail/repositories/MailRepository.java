package com.kirabium.gegemail.repositories;

import com.kirabium.gegemail.di.DI;
import com.kirabium.gegemail.model.Mail;
import com.kirabium.gegemail.service.DummyMailApiService;
import com.kirabium.gegemail.service.MailApiService;

import java.util.ArrayList;
import java.util.List;

public class MailRepository {
    private static final MailApiService service = DI.getMailApiService();

    public List<Mail> getMails(){
        return service.getMails();
    }

    public void deleteMail(Mail mail){
        service.deleteMail(mail);
    }

    public void addMail(Mail mail){
        service.createMail(mail);
    }

}