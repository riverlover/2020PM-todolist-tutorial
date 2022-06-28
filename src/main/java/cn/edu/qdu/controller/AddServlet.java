package cn.edu.qdu.controller;

import cn.edu.qdu.dao.Dao;
import cn.edu.qdu.dao.DaoFactory;
import cn.edu.qdu.dao.TodoJdbcDao;
import cn.edu.qdu.domain.Todo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class AddServlet extends HttpServlet {
    private final static DateFormat df = new SimpleDateFormat("yyyyMMdd HH:mm:ss");

    private Dao dao = DaoFactory.getDao();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String todoItem = req.getParameter("todoItem");


        Todo todo = new Todo();
        todo.setId(UUID.randomUUID().toString());
        todo.setTodoItem(todoItem);
        todo.setCreatedAt(df.format(new Date()));

        dao.addToOngoing(todo);

        req.setAttribute("ongoings", dao.getAllOngoings());
        req.setAttribute("completeds", dao.getAllCompleteds());

        req.getRequestDispatcher("todoList.jsp").forward(req, resp);
    }
}
