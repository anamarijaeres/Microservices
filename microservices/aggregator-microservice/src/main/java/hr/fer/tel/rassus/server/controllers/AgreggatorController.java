package hr.fer.tel.rassus.server.controllers;
import java.net.URI;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import hr.fer.tel.rassus.server.beans.TempHumResponse;
@Configuration
@EnableAutoConfiguration
@RestController
@RefreshScope
@EnableDiscoveryClient
public class AgreggatorController {
	
	@Value("${my.unit: default value}")
	private String m_unit;
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	@Autowired
	private LoadBalancerClient loadBalancerClient;
	
	@GetMapping("/currentReading")
	public List<TempHumResponse> get() throws URISyntaxException{
	    ServiceInstance instance= loadBalancerClient.choose("temperature-service");
	    int missingpart= instance.getPort();
		
		//String port="8092"; 
//		String port=String.valueOf(missingpart);
//		final String baseUrl = "http://localhost:"+port+"/temperature/currentReading";
	    final String baseUrl= instance.getUri().toString()+"/temperature/currentReading";
		URI uri = new URI(baseUrl);
		System.out.println(m_unit);
	
		List<TempHumResponse> l=new ArrayList<>();
		TempHumResponse t=restTemplate.getForObject(uri, TempHumResponse.class);
		System.out.println(t);
		if(!m_unit.equals("Celsius")) {
			t.setUnit("K");
			t.setValue(t.getValue()+273.15);
		}
		l.add(t);
		
		instance= loadBalancerClient.choose("humidity-service");
//	    missingpart= instance.getPort();
////		port="8093";
////	    port=String.valueOf(missingpart);
//		final String baseUrl2 = "http://localhost:"+port+"/humid/currentReading";
	    final String baseUrl2= instance.getUri().toString()+"/humid/currentReading";
		URI uri2 = new URI(baseUrl2);
		TempHumResponse t2=restTemplate.getForObject(uri2, TempHumResponse.class);
		l.add(t2);
		
		return l;
	}
	
	
	
}
