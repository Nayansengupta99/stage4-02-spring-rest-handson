package com.cognizant.springlearn;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringLearnApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

	public static void main(String[] args) throws ParseException {
		SpringApplication.run(SpringLearnApplication.class, args);
		displayDate();
		// displayCountry();
		displayCountries();

	}

	public static void displayDate() throws ParseException {
		LOGGER.info("START");
		ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
		SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
		Date d = format.parse("31/12/2018");
		String date = d.toString();
		LOGGER.debug("Date : {}", date);
		LOGGER.info("END");

	}

	/*
	 * public static void displayCountry() { LOGGER.debug("START"); // Initialize
	 * the context ApplicationContext context = new
	 * ClassPathXmlApplicationContext("country.xml");
	 * 
	 * Country country = (Country) context.getBean("country", Country.class);
	 * Country anotherCountry = context.getBean("country", Country.class);
	 * LOGGER.debug("Country : {}", country.toString());
	 * 
	 * LOGGER.debug("END"); }
	 */
	public static void displayCountries() {
		LOGGER.debug("START");
		// Initialize the context
		ApplicationContext context1 = new ClassPathXmlApplicationContext("country.xml");
		ArrayList<Country> countryList = context1.getBean("countryList", ArrayList.class);
		LOGGER.debug("Country List : {} ", countryList);
		LOGGER.debug("END");

	}

}
