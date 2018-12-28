package com.courses.microservices.controller;

import com.courses.microservices.model.ExchangeValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by pasindu on 2018-12-27.
 * micro-services
 * com.courses.microservices
 */
@RestController
public class CurrencyExchangeController
{
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue( @PathVariable String from, @PathVariable String to )
	{
		return new ExchangeValue( 1000L, from, to, 183 );
	}
}