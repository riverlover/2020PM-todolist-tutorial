package cn.edu.qdu.dao;

import cn.edu.qdu.db.DB;
import cn.edu.qdu.domain.Todo;

import java.util.Map;

public class TodoDao implements Dao{

    /**
     * 根据ID查询一个正在处理中的待办
     * @param id
     * @return
     */
    public Todo getOngoing(String id){
        return DB.ongoings.get(id);
    }

    public String addToOngoing(Todo todo){
        String id = todo.getId();
        DB.ongoings.put(id, todo);
        return id;
    }

    /**
     * 根据ID删除一个处理中的待办
     * @param id
     */
    public void deleteOngoing(String id){
        DB.ongoings.remove(id);
    }

    /**
     * 查询所有正在进行中的
     * @return
     */
    public Map<String, Todo> getAllOngoings(){
        return DB.ongoings;
    }

    /**
     * 获取全部已经完成的待办事项
     * @param id
     * @return
     */
    public Todo getCompleteds(String id){
        return DB.completeds.get(id);
    }

    /**
     * 添加一个事项到已经完成的列表
     * @param todo
     * @return
     */
    public String addToCompleteds(Todo todo){
        DB.completeds.put(todo.getId(), todo);
        return todo.getId();
    }

    /**
     * 获取全部已经完成的事项
     * @return
     */
    public Map<String, Todo> getAllCompleteds(){
        return DB.completeds;
    }
}
