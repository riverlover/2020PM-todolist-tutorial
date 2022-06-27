<%@ page pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>待办任务</title>
    </head>
    <body>
        <header>
           <form action="add" method="post">
               <input type="text" name="todoItem" placeholder="填写待办事项"/>
               <input type="submit" value="添加">
           </form>
        </header>

        <hr>
        <h3>正在进行中的${requestScope.ongoings.size()}个任务</h3>
        <ol>
            <c:forEach var="entry" items="${requestScope.ongoings}">
                <li>${entry.value.todoItem} ${entry.value.createdAt}  <a href="complete?id=${entry.key}">完成</a></li>
            </c:forEach>

<!--            <li>任务1</li>-->
<!--            <li>任务2</li>-->
<!--            <li>任务3</li>-->
        </ol>

        <hr>
        <h3>已经完成的${requestScope.completeds.size()}个任务</h3>
        <ol>
            <c:forEach var="entry" items="${requestScope.completeds}">
                <li>${entry.value.todoItem} ${entry.value.createdAt}  <a href="delete?id=${entry.key}">删除</a></li>
            </c:forEach>
<!--            <li>已经完成的任务1</li>-->
<!--            <li>已经完成的任务2</li>-->
        </ol>
    </body>
</html>