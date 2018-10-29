package cn.itcast.test;

import cn.itcast.pojo.Customer;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * @description:
 * @author: yjsong
 * @date: 2018-10-24 9:07 PM
 */
public class JPADemo {

    @Test
    public void testJpaDemo() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myJpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Customer c = new Customer();
        c.setCustName("小兔子");
        entityManager.persist(c);
        transaction.commit();

        entityManager.close();
        entityManagerFactory.close();

    }
}
