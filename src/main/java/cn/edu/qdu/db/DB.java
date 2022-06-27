package cn.edu.qdu.db;

import cn.edu.qdu.domain.Todo;

import java.util.HashMap;
import java.util.Map;

public class DB {
    public final static Map<String, Todo> ongoings = new HashMap<>();
    public final static Map<String, Todo> completeds = new HashMap<>();
}
