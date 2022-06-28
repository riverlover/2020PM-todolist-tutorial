package cn.edu.qdu.dao;

import cn.edu.qdu.domain.Todo;

import java.util.Map;

public class TodoJdbcDao implements Dao{
    @Override
    public Todo getOngoing(String id) {
        return null;
    }

    @Override
    public String addToOngoing(Todo todo) {
        return null;
    }

    @Override
    public void deleteOngoing(String id) {

    }

    @Override
    public Map<String, Todo> getAllOngoings() {
        return null;
    }

    @Override
    public Todo getCompleteds(String id) {
        return null;
    }

    @Override
    public String addToCompleteds(Todo todo) {
        return null;
    }

    @Override
    public Map<String, Todo> getAllCompleteds() {
        return null;
    }
}
