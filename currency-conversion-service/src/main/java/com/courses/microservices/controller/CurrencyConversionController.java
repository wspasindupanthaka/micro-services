package com.courses.microservices.controller;

import com.courses.microservices.feign.CurrencyExchangeServiceProxy;
import com.courses.microservices.model.CurrencyConversionBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pasindu on 2018-12-28.
 * micro-services
 * com.courses.microservices.controller
 */
@RestController
public class CurrencyConversionController
{

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CurrencyExchangeServiceProxy proxy;

	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrency( @PathVariable String from,
			@PathVariable String to,
			@PathVariable double quantity )
	{

		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put( "from", from );
		uriVariables.put( "to", to );

		ResponseEntity<CurrencyConversionBean> responseEntity = new RestTemplate().getForEntity( "http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversionBean.class, uriVariables );

		CurrencyConversionBean response = responseEntity.getBody();

		CurrencyConversionBean currencyConversionBean = new CurrencyConversionBean( response.getId()
				, from, to, response.getConversionMultiple(), quantity, response.getConversionMultiple() * quantity );
		currencyConversionBean.setPort( response.getPort() );

		logger.info("{}", currencyConversionBean);

		return currencyConversionBean;

	}

	@GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrencyFeign( @PathVariable String from,
			@PathVariable String to,
			@PathVariable double quantity )
	{

		CurrencyConversionBean response = proxy.retrieveExchangeValue( from, to );

		CurrencyConversionBean currencyConversionBean = new CurrencyConversionBean( response.getId()
				, from, to, response.getConversionMultiple(), quantity, response.getConversionMultiple() * quantity );
		currencyConversionBean.setPort( response.getPort() );
		return currencyConversionBean;

	}

}
