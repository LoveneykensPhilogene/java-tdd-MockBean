package br.testeunitario;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.testeunitario.model.BookingModel;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BookingControllerTest {

	@Autowired
	MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	public void bookingTestGetAll() throws Exception {

		mockMvc.perform(get("/bookings").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andReturn();

	}

	@Test
	public void bookingTestSave() throws Exception, Exception {

		LocalDate checkIn = LocalDate.parse("2020-11-10");
		LocalDate checkOut = LocalDate.parse("2020-11-20");
		BookingModel bookingModel = new BookingModel("1", "Love", checkIn, checkOut, 2);

		mockMvc.perform(post("/bookings").contentType("application/json")
				.content(objectMapper.writeValueAsString(bookingModel))).andExpect(status().isOk());

	}
	
	@Test
	public void bookingTestDelete() throws Exception, Exception {
		
		LocalDate checkIn = LocalDate.parse("2020-11-10");
		LocalDate checkOut = LocalDate.parse("2020-11-20");
		BookingModel bookingModel = new BookingModel("2", "Philogene", checkIn, checkOut, 3);
		mockMvc.perform(delete("/bookings").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(bookingModel))).andExpect(status().isOk());
	}
	
	
}
