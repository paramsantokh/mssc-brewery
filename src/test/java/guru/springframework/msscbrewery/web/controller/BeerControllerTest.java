package guru.springframework.msscbrewery.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import guru.springframework.msscbrewery.web.model.BeerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author param singh
 */
@SpringBootTest
@AutoConfigureMockMvc
//@WebMvcTest(BeerController.class)
class BeerControllerTest {
  
  @Autowired
  MockMvc mockMvc;
  
  @Autowired
  ObjectMapper objectMapper;
  
  @Test
  void getBeerById() throws Exception {
    mockMvc.perform(get("/api/v1/beer/" + UUID.randomUUID().toString()).accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
  }
  
  @Test
  void saveNewBeer() throws Exception {
    BeerDto beerDto = BeerDto.builder().id(UUID.randomUUID())
        .beerName("Beera")
        .beerStyle("PALE_ALE")
        .build();
    String beerDtoJson = objectMapper.writeValueAsString(beerDto);
    
    mockMvc.perform(post("/api/v1/beer/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(beerDtoJson))
        .andExpect(status().isCreated());
  }
  
  @Test
  void updateBeerById() throws Exception {
    BeerDto beerDto = BeerDto.builder().id(UUID.randomUUID())
        .beerName("Beera")
        .beerStyle("PALE_ALE")
        .build();
    
    String beerDtoJson = objectMapper.writeValueAsString(beerDto);
    
    mockMvc.perform(put("/api/v1/beer/" + UUID.randomUUID())
                        .content(beerDtoJson)
                        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isNoContent());
  }
}
  