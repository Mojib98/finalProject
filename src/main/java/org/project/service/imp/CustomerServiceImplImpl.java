package org.project.service.imp;

import org.hibernate.SessionFactory;
import org.project.entity.*;
import org.project.entity.enumeration.WorkStatus;
import org.project.repository.imp.CustomerRepository;
import org.project.repository.imp.SessionFactorySingleton;
import org.project.service.interfaces.CustomerService;

import java.util.ArrayList;
import java.util.List;

public class CustomerServiceImplImpl extends GenericServiceImpl<Order> implements CustomerService {
    private final SessionFactory sessionFactory = SessionFactorySingleton.getInstance();
    private final CustomerRepository customerRepository = new CustomerRepository();
    public List<Customer> search(Customer customer) {
        List<Customer> list = new ArrayList<>();
        try (var session = sessionFactory.getCurrentSession()) {
            var transaction = session.getTransaction();
            try {
                transaction.begin();

                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                System.out.println(e.getMessage());
                return null;
            }
            return list;
        }
    }
    public List<Offer> AllOffer(Integer id){
        List<Offer> list = null;
        try (var session = sessionFactory.getCurrentSession()) {
            var transaction = session.getTransaction();
            try {
                transaction.begin();
                list=customerRepository.findAllOffer(25);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                System.out.println(e.getMessage());
                return null;
            }
            return list;
        }
    }
    public Offer findOfferById(Integer id){
        Offer offer = null;
        try (var session = sessionFactory.getCurrentSession()) {
            var transaction = session.getTransaction();
            try {
                transaction.begin();
                offer=customerRepository.findOfferById(id);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                System.out.println(e.getMessage());
                return null;
            }
            return offer;
        }
    }
    public void choice(Offer offer,AcceptOffer acceptOffer){
        try (var session = sessionFactory.getCurrentSession()) {
            var transaction = session.getTransaction();
            try {
//                AcceptOffer acceptOffer1 = new AcceptOffer(null,null);
                /*Specialist specialist = new Specialist();
                acceptOffer1.setOfferPrice(offer.getOfferPrice());
                acceptOffer.setSpecialists(specialist);
                specialist.setId(offer.getSpecialists().getId());*/
//                acceptOffer1.setOfferPrice(13213D);

                transaction.begin();
                Order order = customerRepository.findOrder(offer.getOrder().getId());
                acceptOffer.setOrder(order);
                Specialist specialist = customerRepository.find(offer.getSpecialists().getId());
                acceptOffer.setSpecialists(specialist);
//                Order order = new Order();
//                order.setId(offer.getOrder().getId());
//                order.setWorkStatus(WorkStatus.WAIT_FOR_ARRIVE);
//                acceptOffer1.setOrder(order);
                customerRepository.insertAcceptOffer(acceptOffer);
//                customerRepository.update(order);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                System.out.println(e.getMessage());
            }
        }
    }
    public Order findOrderById(Integer id){
        Order order = null;
        try (var session = sessionFactory.getCurrentSession()) {
            var transaction = session.getTransaction();
            try {
                transaction.begin();
                order=customerRepository.findOrder(id);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                System.out.println(e.getMessage());
                return null;
            }
            return order;
        }
    }

}
