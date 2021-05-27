package com.kirabium.gegemail.service;


import com.kirabium.gegemail.model.Mail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

abstract class DummyMailGenerator {

    public static List<Mail> DUMMY_MAILS = Arrays.asList(new Mail("Réunion", "nouvelle réunion demain soir à 19h", "toto@gegemail.com"),
            new Mail("Financement", "votre financement va se terminer dans 3 jours", "Pole emploi"),
            new Mail("Webinar", "nouveau webinar demain soir à 19h", "Openclassrooms"),
            new Mail("Raclette", "raclette demain soir à 20h", "hugue@gegemail.com"),
            new Mail("Réunion", "nouvelle réunion demain soir à 19h", "toto@gegemail.com"),
            new Mail("Financement", "votre financement va se terminer dans 3 jours", "Pole emploi"),
            new Mail("Webinar", "nouveau webinar demain soir à 19h", "Openclassrooms"),
            new Mail("Raclette", "raclette demain soir à 20h", "hugue@gegemail.com"),
            new Mail("Réunion", "nouvelle réunion demain soir à 19h", "toto@gegemail.com"),
            new Mail("Financement", "votre financement va se terminer dans 3 jours", "Pole emploi"),
            new Mail("Webinar", "nouveau webinar demain soir à 19h", "Openclassrooms"),
            new Mail("Raclette", "raclette demain soir à 20h", "hugue@gegemail.com"));

    static List<Mail> generateMails() {
        return new ArrayList<>(DUMMY_MAILS);
    }
}
