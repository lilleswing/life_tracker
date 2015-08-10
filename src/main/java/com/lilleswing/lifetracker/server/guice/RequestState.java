package com.lilleswing.lifetracker.server.guice;

import com.google.inject.Inject;
import com.google.inject.servlet.RequestScoped;
import com.lilleswing.lifetracker.server.db.model.AppUser;

@RequestScoped
public class RequestState {

    private AppUser appUser;

    @Inject
    public RequestState() {
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(final AppUser appUser) {
        this.appUser = appUser;
    }
}
