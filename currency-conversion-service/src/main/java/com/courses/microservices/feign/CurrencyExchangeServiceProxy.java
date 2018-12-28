package com.courses.microservices.feign;

import com.courses.microservices.model.CurrencyConversionBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by pasindu on 2018-12-28.
 * micro-services
 * com.courses.microservices.feign
 */

//@FeignClient(name = "currency-exchange-service",url = "http://localhost:8000")
@FeignClient(name = "currency-exchange-service")
@RibbonClient(name = "currency-exchange-service")
public interface CurrencyExchangeServiceProxy
{
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionBean retrieveExchangeValue( @PathVariable(value = "from") String from, @PathVariable(value = "to") String to );
}
