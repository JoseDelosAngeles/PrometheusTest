package com.everis.bootcamp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;

@RestController
public class ControllerTest {

	private Counter counter;
	
	
	public ControllerTest(MeterRegistry registry) {
		this.counter = Counter.builder("invocaciones.hello").description("Invocaciones totales").register(registry);
	}
	
	@GetMapping(path="/hello")
	public String hello() {
		counter.increment();
		return "hola";
	}
}
