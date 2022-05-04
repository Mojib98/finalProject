package org.project.service.interfaces;

import org.project.entity.Customer;

import java.util.List;

public interface ManageServiceForCustomer extends GenericService<Customer> {
    void changeStatus(Customer customer);
    List<Customer> search(Customer customer);
}