package com.musala.demo;

import com.musala.demo.models.Gateway;
import com.musala.demo.repositories.GatewayRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DemoApplicationTests {

	@Autowired
	private GatewayRepository gatewayRepository;

	@Test
	public void whenFindBySerialNumber_thenReturnJsonTest() {

		//Arrange
		Gateway gateway = new Gateway();
		gateway.setSerialNumber(1L);

		//Act
		Optional<Gateway> foundGateway = gatewayRepository.findById(1L);

		//Assert
		assertEquals(gateway.getSerialNumber(), foundGateway.get().getSerialNumber());
	}

}

