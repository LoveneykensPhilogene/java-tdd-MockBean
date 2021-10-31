package br.testeunitario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.testeunitario.model.BookingModel;
import br.testeunitario.repository.BookingRepository;

@RestController
@RequestMapping("/bookings")
public class BookingController {
	
	@Autowired
	private BookingRepository bookingRepository;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<BookingModel>> getAll() {
		return ResponseEntity.status(HttpStatus.OK).body(bookingRepository.findAll());
	}
	
	@PostMapping
	public ResponseEntity<BookingModel> save(BookingModel bookingModel){
		return ResponseEntity.status(HttpStatus.OK).body(bookingModel);
	}
	
	@DeleteMapping
	public void delete(@RequestBody BookingModel bookinModel) {
		bookingRepository.delete(bookinModel);
	}
			
}
