package net.codegen.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
public class RoomType
{
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	private String typeName;
	private double price;
	private int noOfRooms;
	private int availableRooms;
	private int maxadults;

	@ManyToOne
	@JoinColumn(name = "contract")
	private Contract contract;

	public long getId()
	{
		return id;
	}

	public void setId( long id )
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
	@JsonBackReference //stop refering inside
	public Contract getContract()
	{
		return contract;
	}

	public void setContract( Contract contract )
	{
		this.contract = contract;
	}
}
