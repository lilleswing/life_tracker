package com.lilleswing.lifetracker.server.server.login;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import com.lilleswing.lifetracker.server.guice.RequestState;
import com.lilleswing.lifetracker.server.guice.aop.auth.Authorize;

@Path("/login")
@Singleton
public class LoginService {

    private final Provider<RequestState> requestStateProvider;

    @Inject
    public LoginService(final Provider<RequestState> requestStateProvider) {
        this.requestStateProvider = requestStateProvider;
    }

    @GET
    @Authorize
    public String login() {
        return "Logged In";
    }
}
