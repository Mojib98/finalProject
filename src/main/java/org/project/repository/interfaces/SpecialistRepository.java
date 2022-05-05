package org.project.repository.interfaces;

import org.project.entity.AcceptOffer;
import org.project.entity.Customer;
import org.project.entity.Order;
import org.project.entity.Specialist;
import org.project.entity.enumeration.WorkStatus;

import java.util.List;

public interface SpecialistRepository {
    List<Order> findOrders(Integer id);
    Specialist findByEmail(String email);
    Customer findByIdCustomer(Integer id);
    void changeWorkFlow(Order order);
    List<AcceptOffer> findMyAcceptOffer(Integer id);
    void changeWorkBySpecialist(Integer id, WorkStatus workStatus);
    void changePassword(Specialist specialist,String password);
}