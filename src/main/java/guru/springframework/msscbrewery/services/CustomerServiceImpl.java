package guru.springframework.msscbrewery.services;

import guru.springframework.msscbrewery.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author param singh
 */
@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {
  
  @Override
  public CustomerDto getCustomerById(UUID customerId) {
    return CustomerDto.builder().id(customerId)
        .name("Beer Dude")
        .build();
  }
  
  @Override
  public CustomerDto saveCustomer(CustomerDto customerDto) {
    return CustomerDto.builder().id(UUID.randomUUID())
        .name(customerDto.getName())
        .build();
  }
  
  @Override
  public CustomerDto updateCustomer(UUID customerId, CustomerDto customerDto) {
    return CustomerDto.builder().id(customerId)
        .name(customerDto.getName())
        .build();
  }
  
  @Override
  public void deleteCustomer(UUID customerId) {
    log.debug("deleting customer: "+ customerId);
  }
}
