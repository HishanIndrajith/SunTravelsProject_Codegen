package net.codegen.Services;

import net.codegen.Models.RoomType;
import net.codegen.Repositories.RoomTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class RoomTypeService
{
	@Autowired
	private RoomTypeRepository roomTypeRepository;
	public Collection<RoomType> getAllRoomTypes(){
		return roomTypeRepository.findAll();
	}

	public RoomType getRoomTypeById(long id){
		return roomTypeRepository.findById( id ).get();
	}

	public void removeRoomTypeById( long id )
	{
		roomTypeRepository.deleteById( id );
	}
	public RoomType updateRoomType(RoomType roomType )
	{
		if ( roomTypeRepository.existsById( roomType.getId() ) )
		{
			return roomTypeRepository.save( roomType );
		}

		return null;
	}
	public RoomType insertRoomType(RoomType roomType ){
		return roomTypeRepository.save( roomType );
	}
}
