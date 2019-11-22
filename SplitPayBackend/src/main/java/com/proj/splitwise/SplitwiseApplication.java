package com.proj.splitwise;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@EnableJpaRepositories(basePackages="com.nested")
@EntityScan(basePackages="com.nested")
public class SplitwiseApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SplitwiseApplication.class, args);
		System.out.println(InetAddress.getLocalHost());
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				//login
				registry.addMapping("/splitpay/signin").allowedOrigins("*");
				registry.addMapping("/splitpay/signin").allowCredentials(true);
				
				registry.addMapping("/splitpay/signup").allowedOrigins("*");
				registry.addMapping("/splitpay/signup").allowCredentials(true);
				
				registry.addMapping("/splitpay/signout").allowedOrigins("*");
				registry.addMapping("/splitpay/signout").allowCredentials(true);
				
				registry.addMapping("/splitpay/users/all").allowedOrigins("*");
				registry.addMapping("/splitpay/users/all").allowCredentials(true);
				
				
				//transaction
				registry.addMapping("/splitpay/transactions/all").allowedOrigins("*");
				registry.addMapping("/splitpay/transactions/all").allowCredentials(true);
				  
				registry.addMapping("/splitpay/transactions/search/*").allowedOrigins("*");
				registry.addMapping("/splitpay/transactions/search/*").allowCredentials(true);
				
				
				registry.addMapping("/splitpay/transactions/save").allowedOrigins("*");
				registry.addMapping("/splitpay/transactions/save").allowCredentials(true);
				
				registry.addMapping("/splitpay/transactions/delete/*").allowedOrigins("*");
				registry.addMapping("/splitpay/transactions/delete/*").allowCredentials(true);
				
				registry.addMapping("/splitpay/transactions/edit").allowedOrigins("*");
				registry.addMapping("/splitpay/transactions/edit").allowCredentials(true);
				
				
				//purposed
				registry.addMapping("/splitpay/purpose/all").allowedOrigins("*");
				registry.addMapping("/splitpay/purpose/all").allowCredentials(true);
				
				registry.addMapping("/splitpay/purpose/save").allowedOrigins("*");
				registry.addMapping("/splitpay/purpose/save").allowCredentials(true);

				registry.addMapping("/splitpay/purposes/delete/*").allowedOrigins("*");
				registry.addMapping("/splitpay/purposes/delete/*").allowCredentials(true);
				
				registry.addMapping("/splitpay/purpose/edit").allowedOrigins("*");
				registry.addMapping("/splitpay/purpose/edit").allowCredentials(true);
				
				//split amount
				registry.addMapping("/splitpay/split/save").allowedOrigins("*");
				registry.addMapping("/splitpay/split/save").allowCredentials(true);
				
				registry.addMapping("/splitpay/group/save").allowedOrigins("*");
				registry.addMapping("/splitpay/group/save").allowCredentials(true);
				
				registry.addMapping("/splitpay/group/all").allowedOrigins("*");
				registry.addMapping("/splitpay/group/all").allowCredentials(true);
//				
			//	registry.addMapping("/splitpay/group/usergroup/save/*").allowedOrigins("*");
			//	registry.addMapping("/splitpay/group/usergroup/save/*").allowCredentials(true);
//				
				registry.addMapping("/splitpay/group/user/saved").allowedOrigins("*");
				registry.addMapping("/splitpay/group/user/saved").allowCredentials(true);
				

				registry.addMapping("/splitpay/grouprelation/all").allowedOrigins("*");
				registry.addMapping("/splitpay/grouprelation/all").allowCredentials(true);
//				
				
				
				registry.addMapping("/splitpay/group/delete/*/*").allowedOrigins("*");
				registry.addMapping("/splitpay/group/delete/*/*").allowCredentials(true);
			}
		};
	}
}

