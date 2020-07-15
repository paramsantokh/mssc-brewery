package guru.springframework.msscbrewery.services;

import guru.springframework.msscbrewery.web.model.BeerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author param singh
 */
@Slf4j
@Service
public class BeerServiceImpl implements BeerService {
  
  @Override
  public BeerDto getBeerById(UUID beerId) {
    return BeerDto.builder().id(UUID.randomUUID())
        .beerName("Beera")
        .beetStyle("Pale Ale")
        .build();
  }
  
  @Override
  public BeerDto saveNewBeer(BeerDto beerDto) {
    return BeerDto.builder().id(UUID.randomUUID())
        .beerName(beerDto.getBeerName())
        .beetStyle(beerDto.getBeetStyle())
        .build();
  }
  
  @Override
  public void updateBeer(UUID beerId, BeerDto beerDto) {
  
  }
  
  @Override
  public void deleteById(UUID beerId) {
    log.debug("Deleting a beer:" + beerId);
  }
}
