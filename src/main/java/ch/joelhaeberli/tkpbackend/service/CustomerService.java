package ch.joelhaeberli.tkpbackend.service;

import ch.joelhaeberli.tkpbackend.domain.customer.Customer;
import ch.joelhaeberli.tkpbackend.domain.customer.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    CustomerRepo customerRepo;

    public Customer addCustomer(Customer customer) {

        return customerRepo.saveAndFlush(customer);
    }

    public void deleteCustomer(Long id) {

        customerRepo.delete(id);
    }
}
