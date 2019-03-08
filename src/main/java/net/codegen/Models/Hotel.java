package net.codegen.Models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Hotel
{
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long hotelId;
	private String hotelName;
	private String address;

//	public Hotel( long hotelId, String hotelName, String address )
//	{
//		this.hotelId = hotelId;
//		this.hotelName = hotelName;
//		this.address = address;
//	}


	public long getHotelId()
	{
		return hotelId;
	}
	public String getHotelName()
	{
		return hotelName;
	}

	public void setHotelName( String hotelName )
	{
		this.hotelName = hotelName;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress( String address )
	{
		this.address = address;
	}

	public void setHotelId( long hotelId )
	{
		this.hotelId = hotelId;
	}
}
