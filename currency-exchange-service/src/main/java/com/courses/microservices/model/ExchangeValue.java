package com.courses.microservices.model;

/**
 * Created by pasindu on 2018-12-27.
 * micro-services
 * com.courses.microservices.model
 */
public class ExchangeValue
{
	private long id;
	private String from;
	private String to;
	private double conversionMultiple;
	private int port;

	public ExchangeValue()
	{
	}

	public ExchangeValue( long id, String from, String to, double conversionMultiple )
	{
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
	}

	public long getId()
	{
		return id;
	}

	public void setId( long id )
	{
		this.id = id;
	}

	public String getFrom()
	{
		return from;
	}

	public void setFrom( String from )
	{
		this.from = from;
	}

	public String getTo()
	{
		return to;
	}

	public void setTo( String to )
	{
		this.to = to;
	}

	public double getConversionMultiple()
	{
		return conversionMultiple;
	}

	public void setConversionMultiple( double conversionMultiple )
	{
		this.conversionMultiple = conversionMultiple;
	}

	public int getPort()
	{
		return port;
	}

	public void setPort( int port )
	{
		this.port = port;
	}
}
