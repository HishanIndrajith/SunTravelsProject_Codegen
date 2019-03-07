package net.codegen.Models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Contract
{
	private int id;
	private Date startDate;
	private Date endDate;

	@JsonCreator
	public Contract( @JsonProperty("id") int id, @JsonProperty("startDate") Date startDate, @JsonProperty("endDate") Date endDate )
	{
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public int getId()
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
}
