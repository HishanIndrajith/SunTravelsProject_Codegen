package net.codegen.Models;

import javax.persistence.*;

@Entity
public class RoomType
{
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long id;
	private String typeName;
	private double price;
	private int noOfRooms;
	private int availableRooms;
	private int maxadults;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="contractId", referencedColumnName = "id")
	private Contract contract;

//	public RoomType( long id, String typeName, double price, int noOfRooms, int availableRooms, int maxadults )
//	{
//		this.id = id;
//		this.typeName = typeName;
//		this.price = price;
//		this.noOfRooms = noOfRooms;
//		this.availableRooms = availableRooms;
//		this.maxadults = maxadults;
//	}

	public long getId()
	{
		return id;
	}

	public void setId( int id )
	{
		this.id = id;
	}

	public String getTypeName()
	{
		return typeName;
	}

	public void setTypeName( String typeName )
	{
		this.typeName = typeName;
	}

	public double getPrice()
	{
		return price;
	}

	public void setPrice( double price )
	{
		this.price = price;
	}

	public int getNoOfRooms()
	{
		return noOfRooms;
	}

	public void setNoOfRooms( int noOfRooms )
	{
		this.noOfRooms = noOfRooms;
	}

	public int getAvailableRooms()
	{
		return availableRooms;
	}

	public void setAvailableRooms( int availableRooms )
	{
		this.availableRooms = availableRooms;
	}

	public int getMaxadults()
	{
		return maxadults;
	}

	public void setMaxadults( int maxadults )
	{
		this.maxadults = maxadults;
	}
}
