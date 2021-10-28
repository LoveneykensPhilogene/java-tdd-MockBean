package br.testeunitario.service;

import java.time.Period;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.testeunitario.model.BookingModel;
import br.testeunitario.repository.BookingRepository;

@Service
public class BookingService {
	
	@Autowired
	private BookingRepository bookingRepository;

	public int bookingDaysCalculatorWithDatabase(String name) {
		
		Optional<BookingModel> bookingModelOptional=bookingRepository.findByReserveName(name);
		
		
		return Period.between(bookingModelOptional.get().getCheckIn(), bookingModelOptional.get().getCheckOut()).getDays();
	}
	
	

}
