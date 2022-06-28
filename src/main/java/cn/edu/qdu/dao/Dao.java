package cn.edu.qdu.dao;

import cn.edu.qdu.domain.Todo;

import java.util.Map;

public interface Dao {
    /**
     * 根据ID查询一个正在处理中的待办
     * @param id
     * @return
     */
    public Todo getOngoing(String id);

    public String addToOngoing(Todo todo);

    /**
     * 根据ID删除一个处理中的待办
     * @param id
     */
    public void deleteOngoing(String id);

    /**
     * 查询所有正在进行中的
     * @return
     */
    public Map<String, Todo> getAllOngoings();
    /**
     * 获取全部已经完成的待办事项
     * @param id
     * @return
     */
    public Todo getCompleteds(String id);

    /**
     * 添加一个事项到已经完成的列表
     * @param todo
     * @return
     */
    public String addToCompleteds(Todo todo);

    /**
     * 获取全部已经完成的事项
     * @return
     */
    public Map<String, Todo> getAllCompleteds();
}
