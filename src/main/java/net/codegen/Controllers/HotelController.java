package net.codegen.Controllers;


import net.codegen.Models.Hotel;
import net.codegen.Services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/hotels")
public class HotelController
{
	@Autowired
	private HotelService hotelService;

	@RequestMapping(method = RequestMethod.GET)
	public Collection<Hotel> getAllHotels(){
		return hotelService.getAllHotels();
	}

	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public Hotel getHotelById(@PathVariable("id") int id){
		return hotelService.getHotelById(id);
	}

	@RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
	public void deleteHotelById(@PathVariable("id") int id){
		hotelService.removeHotelById(id);
	}

	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateHotel(@RequestBody Hotel hotel){
		hotelService.updateHotel(hotel);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void insertHotel(@RequestBody Hotel hotel ){
		hotelService.insertHotel(hotel );
	}
}
