package net.codegen.Models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity// This tells Hibernate to make a table out of this class
public class Contract
{
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "contract_id")
	private long id;
	private Date startDate;
	private Date endDate;
	@OneToMany(mappedBy = "contract",cascade = CascadeType.ALL)
	private List <RoomType> roomTypes;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "hotel", referencedColumnName = "hotelId")
	private Hotel hotel;

	public long getId()
	{
		return id;
	}

	public void setId( long id )
	{
		this.id = id;
	}

	public Date getStartDate()
	{
		return startDate;
	}

	public void setStartDate( Date startDate )
	{
		this.startDate = startDate;
	}

	public Date getEndDate()
	{
		return endDate;
	}

	public void setEndDate( Date endDate )
	{
		this.endDate = endDate;
	}

	@JsonManagedReference
	public List<RoomType> getRoomTypes()
	{
		return roomTypes;
	}

	public void setRoomTypes( List<RoomType> roomTypes )
	{
		for(RoomType roomType:roomTypes){
			roomType.setContract( this );
		}
		this.roomTypes = roomTypes;
	}

	public Hotel getHotel()
	{
		return hotel;
	}

	public void setHotel( Hotel hotel )
	{
		this.hotel = hotel;
	}
}
