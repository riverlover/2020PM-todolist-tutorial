package cn.edu.qdu.service;

import cn.edu.qdu.dao.Dao;
import cn.edu.qdu.dao.DaoFactory;
import cn.edu.qdu.dao.Factory;
import cn.edu.qdu.dao.TodoDao;
import cn.edu.qdu.domain.Todo;

public class TodoService {
    private Dao dao;

    public TodoService() {
    }

    public TodoService(Factory factory) {
        this.dao = factory.getDao();
    }

    /**
     * 待办的完成， 1。从正在进行中删除， 2， 添加到已经完成列表
     * @param id
     */
    public void complete(String id){

        Todo todo = dao.getOngoing(id);
        dao.addToCompleteds(todo);
        dao.deleteOngoing(id);
    }
}
