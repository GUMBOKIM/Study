package jpabook.jpashop;

import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderItem;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {
        //DB에 묶인다. Persistenc의 설정을 따른다.
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        // 작업 시 엔티티매니저를 통해서 작업한다.
        EntityManager em = emf.createEntityManager();
        //데이터에 접근할때 - 트랜잭션 정의
        EntityTransaction tx = em.getTransaction();
        //트랜잭션 시작
        tx.begin();
        try {
            Order order = new Order();
            order.addOrderItem(new OrderItem());


            //트랜잭션 시작
            tx.commit();
        }catch (Exception e) {
            //에러발생시 트랜잭션을 롤백한다.
            tx.rollback();
        }finally {
            em.close(); // 엔티티 매니저를 닫아줘야한다.
        }
        //EMF를 닫아준다.
        emf.close();
    }
}
