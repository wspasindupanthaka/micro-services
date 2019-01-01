package com.courses.microservices.controller;

import com.courses.microservices.util.ExchangeValuesCache;
import com.courses.microservices.model.ExchangeValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
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

	private Logger logger = LoggerFactory.getLogger(this.getClass());


	@Autowired
	Environment environment;

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue( @PathVariable String from, @PathVariable String to )
	{
		ExchangeValue exchangeValue = ExchangeValuesCache.filter(from,to);
		exchangeValue.setPort( Integer.parseInt( environment.getProperty( "local.server.port" ) ) );
		logger.info("{}", exchangeValue);
		return exchangeValue;
	}
}
