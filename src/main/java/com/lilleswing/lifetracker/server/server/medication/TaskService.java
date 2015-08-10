package com.lilleswing.lifetracker.server.server.medication;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import com.lilleswing.lifetracker.server.db.dao.DaoProvider;
import com.lilleswing.lifetracker.server.db.model.AppUser;
import com.lilleswing.lifetracker.server.guice.RequestState;
import com.lilleswing.lifetracker.server.guice.aop.auth.Authorize;
import com.lilleswing.lifetracker.server.server.model.WsTask;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/task")
@Singleton
public class TaskService {

    private final Provider<RequestState> requestStateProvider;

    @Inject
    public TaskService(final Provider<RequestState> requestStateProvider,
                       final DaoProvider daoProvider) {
        this.requestStateProvider = requestStateProvider;
    }

    @GET
    @Produces(APPLICATION_JSON)
    @Authorize
    public List<WsTask> listTasks() {
        final RequestState requestState = requestStateProvider.get();
        final AppUser appUser = requestState.getAppUser();
        return Lists.newArrayList();
    }
}
