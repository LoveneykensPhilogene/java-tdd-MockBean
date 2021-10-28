package br.testeunitario.model;

import java.time.LocalDate;

import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class BookingModel {
	
	@Id
	@Generated
	 
	@Setter@Getter
	private String id;
	@Getter 
	@Setter
	private String reserveName;
	@Getter 
	@Setter
	private LocalDate checkIn;
	@Getter 
	@Setter
	private LocalDate checkOut;
	@Getter 
	@Setter
	private int numberGuests;
	

}
