package org.project.repository.imp;

import org.hibernate.SessionFactory;
import org.project.entity.AcceptOffer;
import org.project.entity.Offer;
import org.project.entity.Order;
import org.project.entity.Specialist;

import java.util.List;


public class CustomerRepository extends GenericRepositoryImpl<Order> implements org.project.repository.interfaces.CustomerRepository<Order> {


    private final SessionFactory sessionFactory = SessionFactorySingleton.getInstance();


    public List<Offer> findAllOffer(Integer id){
        var session = sessionFactory.getCurrentSession();
        String sql="select * from orders o inner join offer o2 on o.id = o2.order_id where customers_id=25;";
        var query = session.createNativeQuery(sql,"offer");
        return (List<Offer>) query.getResultList();
    }
    public Offer findOfferById(Integer id){
        var session = sessionFactory.getCurrentSession();
        String hql="select new Offer(o.id,o.time,o.offerPrice,o.workTime,o.timeWorkPerMinute,o.order.id,o.specialists.id) from Offer o " +
                " where o.id=:id";
      var query=  session.createQuery(hql,Offer.class).setParameter("id",id);
     return query.getSingleResult();
    }
    public AcceptOffer insertAcceptOffer(AcceptOffer acceptOffer){
        var session = sessionFactory.getCurrentSession();
        session.save(acceptOffer);
        return acceptOffer;
    }
    public Order findOrder(Integer id){
        var session = sessionFactory.getCurrentSession();
        String hql="from Order o " +
                " where o.id=:id";
        var query=  session.createQuery(hql,Order.class).setParameter("id",id);
        return query.getSingleResult();
    }
    public Specialist find(Integer id){
        var session = sessionFactory.getCurrentSession();
        String hql="from Specialist o " +
                " where o.id=:id";
        var query=  session.createQuery(hql,Specialist.class).setParameter("id",id);
        return query.getSingleResult();
    }
}
