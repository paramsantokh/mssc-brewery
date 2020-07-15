package guru.springframework.msscbrewery.services;

import guru.springframework.msscbrewery.web.model.CustomerDto;

import java.util.UUID;

/**
 * @author param singh
 */
public interface CustomerService {
  
  CustomerDto getCustomerById(UUID customerId);
  
  CustomerDto saveCustomer(CustomerDto customerDto);
  
  CustomerDto updateCustomer(UUID customerId, CustomerDto customerDto);
  
  void deleteCustomer(UUID customerId);
}
