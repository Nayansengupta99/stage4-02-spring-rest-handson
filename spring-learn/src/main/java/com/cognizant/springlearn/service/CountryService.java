package com.cognizant.springlearn.service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@Service
public class CountryService {
	ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
	@SuppressWarnings("unchecked")
	List<Country> countries = (List<Country>) context.getBean("countryList");

	public List<Country> getAllCountries() {
		return countries;
	}

	public Country getCountry(String code) throws CountryNotFoundException {
		for (Country c : countries) {
			if (c.getCode().equalsIgnoreCase(code)) {
				return c;
			}
		}
		throw new CountryNotFoundException();
	}
}