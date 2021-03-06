package net.codegen.Models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Requirement
{
	private Date checkInDate;
	private int noOfnights;
	private List<Integer> rooms;
	private List<Integer> persons;

	public Requirement(@JsonProperty("checkInDate") Date checkInDate, @JsonProperty("noOfnights") int noOfnights,@JsonProperty("rooms") List<Integer> rooms,@JsonProperty("persons") List<Integer> persons )
	{
		this.checkInDate = checkInDate;
		this.noOfnights = noOfnights;
		this.rooms = rooms;
		this.persons = persons;
	}

	public Date getCheckInDate()
	{
		return checkInDate;
	}

	public void setCheckInDate( Date checkInDate )
	{
		this.checkInDate = checkInDate;
	}

	public int getNoOfnights()
	{
		return noOfnights;
	}

	public void setNoOfnights( int noOfnights )
	{
		this.noOfnights = noOfnights;
	}

	public List<Integer> getRooms()
	{
		return rooms;
	}

	public void setRooms( List<Integer> rooms )
	{
		this.rooms = rooms;
	}

	public List<Integer> getPersons()
	{
		return persons;
	}

	public void setPersons( List<Integer> persons )
	{
		this.persons = persons;
	}
}

