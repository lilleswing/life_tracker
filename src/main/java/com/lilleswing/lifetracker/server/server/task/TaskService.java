package com.lilleswing.lifetracker.server.server.task;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import com.lilleswing.lifetracker.server.db.dao.DaoProvider;
import com.lilleswing.lifetracker.server.db.dao.TaskDao;
import com.lilleswing.lifetracker.server.db.dao.TaskUserDao;
import com.lilleswing.lifetracker.server.db.model.AppUser;
import com.lilleswing.lifetracker.server.db.model.Task;
import com.lilleswing.lifetracker.server.db.model.TaskUser;
import com.lilleswing.lifetracker.server.guice.RequestState;
import com.lilleswing.lifetracker.server.guice.aop.auth.Authorize;
import com.lilleswing.lifetracker.server.server.model.WsTask;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/task")
@Singleton
public class TaskService {

    private final Provider<RequestState> requestStateProvider;
    private final TaskDao taskDao;
    private final TaskUserDao taskUserDao;

    @Inject
    public TaskService(final Provider<RequestState> requestStateProvider,
                       final DaoProvider daoProvider) {
        this.requestStateProvider = requestStateProvider;
        this.taskDao = daoProvider.getTaskDao();
        this.taskUserDao = daoProvider.getTaskUserDao();
    }

    @GET
    @Produces(APPLICATION_JSON)
    @Authorize
    public List<WsTask> listTasks() {
        final RequestState requestState = requestStateProvider.get();
        final AppUser appUser = requestState.getAppUser();
        final List<Task> tasks = (List<Task>) taskDao.getAll();
        final List<TaskUser> completed = taskUserDao.getForUser(appUser);
        return toWs(tasks, completed);
    }

    @VisibleForTesting
    List<WsTask> toWs(final List<Task> tasks, final List<TaskUser> completed) {
        final Set<Long> completedTasks = completed.stream()
                .map(new Function<TaskUser, Long>() {
                    @Override
                    public Long apply(TaskUser taskUser) {
                        return taskUser.getAppUser().getId();
                    }
                }).collect(Collectors.toSet());
        final List<WsTask> wsTasks = Lists.newArrayListWithCapacity(tasks.size());
        for(final Task task: tasks) {
            final WsTask wsTask = new WsTask();
            wsTask.setId(task.getId());
            wsTask.setName(task.getName());
            wsTask.setDescription(wsTask.getDescription());
            wsTask.setDifficulty(task.getDifficulty());
            wsTasks.add(wsTask);
            wsTask.setCompleted(completedTasks.contains(task.getId()));
        }
        return wsTasks;
    }

}
