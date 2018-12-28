package com.courses.microservices.util;

import com.courses.microservices.model.ExchangeValue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by pasindu on 2018-12-28.
 * micro-services
 * com.courses.microservices
 */
public class ExchangeValuesCache
{
	public static final List<ExchangeValue> EXCHANGE_VALUES =
			Arrays.asList( new ExchangeValue( 100L, "USD", "LKR", 183 ),
					new ExchangeValue( 101L, "EUR", "LKR", 209 ),
					new ExchangeValue( 102L, "SID", "LKR", 133 ),
					new ExchangeValue( 102L, "INR", "LKR", 2 )
			);

	public static ExchangeValue filter( String from, String to )
	{
		List<ExchangeValue> collect = EXCHANGE_VALUES.stream().filter( exchangeValue -> exchangeValue.getFrom().equals( from )
				&& exchangeValue.getTo().equals( to ) ).collect( Collectors.toList() );

		if ( !collect.isEmpty() )
		{
			return collect.get( 0 );
		}
		return null;
	}
}
