package com.courses.microservices.model;

/**
 * Created by pasindu on 2018-12-28.
 * micro-services
 * com.courses.microservices.model
 */
public class CurrencyConversionBean
{
	private long id;
	private String from;
	private String to;
	private double conversionMultiple;
	private double requestedQuantity;
	private double calculatedAmount;
	private int port;

	public CurrencyConversionBean()
	{
	}

	public CurrencyConversionBean( long id, String from, String to, double conversionMultiple, double requestedQuantity, double calculatedAmount )
	{
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
		this.requestedQuantity = requestedQuantity;
		this.calculatedAmount = calculatedAmount;

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

	public double getRequestedQuantity()
	{
		return requestedQuantity;
	}

	public void setRequestedQuantity( double requestedQuantity )
	{
		this.requestedQuantity = requestedQuantity;
	}

	public double getCalculatedAmount()
	{
		return calculatedAmount;
	}

	public void setCalculatedAmount( double calculatedAmount )
	{
		this.calculatedAmount = calculatedAmount;
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
