package cn.edu.qdu.controller;

import cn.edu.qdu.dao.TodoDao;
import cn.edu.qdu.service.TodoService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CompleteServlet extends HttpServlet {
    private final TodoDao todoDao = new TodoDao();
    private final TodoService service = new TodoService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        service.complete(id);



        req.setAttribute("ongoings", todoDao.getAllOngoings());
        req.setAttribute("completeds", todoDao.getAllCompleteds());

        req.getRequestDispatcher("todoList.jsp").forward(req, resp);
    }
}
