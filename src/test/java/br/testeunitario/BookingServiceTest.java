package br.testeunitario;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import br.testeunitario.model.BookingModel;
import br.testeunitario.repository.BookingRepository;
import br.testeunitario.service.BookingService;

@RunWith(SpringRunner.class)
public class BookingServiceTest {

	@TestConfiguration
	static class BookingServiceTestConfiguration {

		@Bean
		public BookingService bookingService() {

			return new BookingService();
		}
	}

	@Autowired
	BookingService bookingService;

	@MockBean
	BookingRepository bookingRepository;

	@Test
	public void bookingTestServiceDaysCalculator() {

		String name = "Love";
		int days = bookingService.bookingDaysCalculatorWithDatabase(name);
		Assertions.assertEquals(days, 10);
	}

	@Before
	public void setup() {
		LocalDate checkIn = LocalDate.parse("2020-11-10");
		LocalDate checkOut = LocalDate.parse("2020-11-20");
		BookingModel bookingModel = new BookingModel("1", "Love", checkIn, checkOut, 2);

		Mockito.when(bookingRepository.findByReserveName(bookingModel.getReserveName()))
				.thenReturn(java.util.Optional.of(bookingModel));

	}

}
