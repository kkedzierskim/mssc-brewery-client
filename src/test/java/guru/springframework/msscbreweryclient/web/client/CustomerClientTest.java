package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class CustomerClientTest {

    @Autowired
    CustomerClient customerClient;

    @Test
    void getBeerById() {
        CustomerDto dto = customerClient.getBeerById(UUID.randomUUID());
        assertNotNull(dto);
    }

    @Test
    void saveNewBeer() {
        //given
        CustomerDto dto = CustomerDto.builder().name("Mati Srati").build();

        URI uri = customerClient.saveNewCustomer(dto);

        assertNotNull(uri);

        System.out.println(uri);
    }

    @Test
    void updateBeer() {
        //given
        CustomerDto dto = CustomerDto.builder().name("Mati Srati").build();

        customerClient.updateCustomer(UUID.randomUUID(), dto);
    }

    @Test
    void deleteBeer() {
        //given
        UUID uuid = UUID.randomUUID();

        customerClient.deleteCustomer(uuid);
    }
}