package cn.itcast.test;

import cn.itcast.pojo.Customer;
import cn.itcast.utils.JpaUtil;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

/**
 * @description:
 * @author: yjsong
 * @date: 2018-10-25 3:20 PM
 */
public class EntityManagerDemo {

    @Test
    public void test01() {
        EntityManager entityManager = JpaUtil.getEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();

        Customer customer = new Customer();
        customer.setCustName("喵喵");

        entityManager.persist(customer);

        tx.commit();
        entityManager.close();

    }


    @Test
    public void testJPQL1() {
        EntityManager entityManager = JpaUtil.getEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();

        String sql = "from Customer";
        Query query = entityManager.createQuery(sql);
        List list = query.getResultList();
        System.out.println(list);
    }


    @Test
    public void findByCount() {
        //获得EntityManager对象
        EntityManager entityManager = JpaUtil.getEntityManager();
        //JPQL查询语句
        String sql = "select count(c) from Customer c where custName like ?";
        //创建查询对象
        Query query = entityManager.createQuery(sql);
        //设置查询条件。参数1：参数的索引从1开始，参数2：查询参数
        query.setParameter(1, "%喵%");
        //执行查询
        Object result = query.getSingleResult();
        System.out.println(result);
    }
}
