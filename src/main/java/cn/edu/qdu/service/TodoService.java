package cn.edu.qdu.service;

import cn.edu.qdu.dao.TodoDao;
import cn.edu.qdu.db.DB;
import cn.edu.qdu.domain.Todo;

public class TodoService {
    /**
     * 待办的完成， 1。从正在进行中删除， 2， 添加到已经完成列表
     * @param id
     */
    public void complete(String id){
        TodoDao todoDao = new TodoDao();
        Todo todo = todoDao.getOngoing(id);
        todoDao.addToCompleteds(todo);
        todoDao.deleteOngoing(id);
    }
}
