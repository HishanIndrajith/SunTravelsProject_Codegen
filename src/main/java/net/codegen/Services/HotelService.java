package net.codegen.Services;

import net.codegen.Models.Contract;
import net.codegen.Models.Hotel;
import net.codegen.Repositories.ContractRepository;
import net.codegen.Repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class HotelService
{
	@Autowired
	private HotelRepository hotelRepository;
	public Collection<Hotel> getAllHotels(){
		return hotelRepository.findAll();
	}

	public Hotel getHotelById(long id){
		return hotelRepository.findById( id ).get();
	}

	public void removeHotelById( long id )
	{
		hotelRepository.deleteById( id );
	}
	public Hotel updateHotel(Hotel hotel )
	{
		if ( hotelRepository.existsById( hotel.getHotelId() ) )
		{
			return hotelRepository.save( hotel );
		}

		return null;
	}
	public Hotel insertHotel(Hotel hotel ){
		return hotelRepository.save( hotel );
	}
}
