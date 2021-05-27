package com.kirabium.gegemail.di;


import com.kirabium.gegemail.service.DummyMailApiService;
import com.kirabium.gegemail.service.MailApiService;

/**
 * Dependency injector to get instance of services
 */
public class DI {

    private static final MailApiService service = new DummyMailApiService();

    /**
     * Get an instance on @{@link MailApiService}
     * @return
     */
    public static MailApiService getMailApiService() {
        return service;
    }

    /**
     * Get always a new instance on @{@link MailApiService}. Useful for tests, so we ensure the context is clean.
     * @return
     */
    public static MailApiService getNewInstanceApiService() {
        return new DummyMailApiService();
    }
}
