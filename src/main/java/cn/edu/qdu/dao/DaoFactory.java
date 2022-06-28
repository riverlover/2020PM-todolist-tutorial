package cn.edu.qdu.dao;

import java.io.IOException;
import java.util.Properties;

public class DaoFactory {
    public static Dao getDao(){
//        return new TodoDao();
//        return new TodoJdbcDao();
        Properties prop = new Properties();
        try {
            //加载配置，拿到dao字符串
            prop.load(DaoFactory.class.getClassLoader().getResourceAsStream("dao-config.properties"));
            String daoString = prop.getProperty("dao");

            //给定字符串， 加载指定的类。
//            System.out.println(daoString);
            Class<?> dao = Class.forName(daoString);
            return (Dao) dao.newInstance();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Dao dao = getDao();
        System.out.println(dao.getClass().getName());
    }
}
