package guru.springframework.msscbrewery.web.controller;

import guru.springframework.msscbrewery.services.CustomerService;
import guru.springframework.msscbrewery.web.model.CustomerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author param singh
 */
@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController {
  
  private final CustomerService customerService;
  
  CustomerController(CustomerService customerService){
    this.customerService = customerService;
  }
  
  @GetMapping("/{customerId}")
  public ResponseEntity<CustomerDto> getCustomer(@PathVariable("customerId") UUID customerId){
    return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
  }
  
  @PostMapping
  public ResponseEntity handlePost(@RequestBody CustomerDto customerDto){
    CustomerDto savedCustomer = customerService.saveCustomer(customerDto);
  
    HttpHeaders headers = new HttpHeaders();
    headers.add("Location", "/api/v1/customer/" + savedCustomer.getId());
    
    return new ResponseEntity(headers, HttpStatus.CREATED);
  }
  
  @PutMapping("/{customerId}")
  public ResponseEntity<CustomerDto> updateCustomer(@PathVariable UUID customerId, @RequestBody CustomerDto customerDto) {
    CustomerDto updatedCustomer = customerService.updateCustomer(customerId, customerDto);
    
    return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
  }
  
  @DeleteMapping("/{customerId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteCustomer(@PathVariable UUID customerId){
    customerService.deleteCustomer(customerId);
  }
  
}
