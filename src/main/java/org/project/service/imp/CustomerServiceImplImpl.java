package org.project.service.imp;

import org.hibernate.SessionFactory;
import org.project.entity.Customer;
import org.project.entity.Orders;
import org.project.repository.interfaces.CustomerRepository;
import org.project.repository.imp.SessionFactorySingleton;
import org.project.service.interfaces.CustomerService;

import java.util.ArrayList;
import java.util.List;

public class CustomerServiceImplImpl extends GenericServiceImpl<Orders> implements CustomerService {
    private final SessionFactory sessionFactory = SessionFactorySingleton.getInstance();
    private final CustomerRepository<Orders> customerRepository = new org.project.repository.imp.CustomerRepository();
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

}