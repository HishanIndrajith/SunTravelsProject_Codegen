package net.codegen.Models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity // This tells Hibernate to make a table out of this class
public class Contract
{
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long id;
	private Date startDate;
	private Date endDate;
	@OneToMany(mappedBy = "contract",cascade = CascadeType.ALL)
	private List <RoomType> roomTypes;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "hotel", referencedColumnName = "hotelId")
	private Hotel hotel;

//	@JsonCreator
//	public Contract( @JsonProperty("id") long id, @JsonProperty("startDate") Date startDate, @JsonProperty("endDate") Date endDate, @JsonProperty("roomType") List<RoomType> roomTypes,@JsonProperty("hotel") Hotel hotel )
//	{
//		this.id = id;
//		this.startDate = startDate;
//		this.endDate = endDate;
//		this.roomTypes = roomTypes;
//		this.hotel = hotel;
//	}

	public long getId()
	{
		return id;
	}

	public void setId( int id )
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

	public List<RoomType> getRoomTypes()
	{
		return roomTypes;
	}

	public void setRoomType( List<RoomType> roomTypes )
	{
		this.roomTypes = roomTypes;
	}
//
	public Hotel getHotel()
	{
		return hotel;
	}

	public void setHotel( Hotel hotel )
	{
		this.hotel = hotel;
	}
}
