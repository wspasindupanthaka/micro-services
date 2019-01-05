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

//when using the below code line, no change has to be done in the other server
//@FeignClient(name = "currency-exchange-service",url = "http://localhost:8000")

//when not calling this service via api gateway server *here
//@FeignClient(name = "currency-exchange-service")


//when calling this service via api gateway server
@FeignClient(name = "netflix-zuul-api-gateway-server")

@RibbonClient(name = "currency-exchange-service")
public interface CurrencyExchangeServiceProxy
{
	//when not calling this service via api gateway server
//	@GetMapping("/currency-exchange/from/{from}/to/{to}")

	//when calling this service via api gateway server
	@GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionBean retrieveExchangeValue( @PathVariable(value = "from") String from, @PathVariable(value = "to") String to );
}
