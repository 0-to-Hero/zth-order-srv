package br.com.zeroth.order;

import org.springframework.boot.SpringApplication;

public class TestZthOrderSrvApplication {

	public static void main(String[] args) {
		SpringApplication.from(ZthOrderSrvApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
