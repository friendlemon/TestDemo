package cn.itcast.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {


    //EntityManagerFactory在系统中单例存在
    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("myJpa");


    public static EntityManagerFactory getFactory() {
        return factory;
    }



    public static EntityManager getEntityManager() {
        //获得EntityManager对象
        return factory.createEntityManager();
    }
}