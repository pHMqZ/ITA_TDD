package com.pms.tdd.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.pms.tdd.Customer;
import com.pms.tdd.Movie;
import com.pms.tdd.Rental;

class TestCustomer {

	Customer client;
	
	@BeforeEach
	protected void setUp() throws Exception {
		client = new Customer("John");
	}
	
	@Test
	public void testNameCreation() {
		String result = client.statement();
		assertContain(result, "Rental Record for John");
	}
	
	@Test
	public void testOneRegularOneDay() {
		rentMovie("Indiana Jones", Movie.REGULAR,1);
		String result = client.statement();
		assertContain(result, "Amount owed is 2.0");
		assertContain(result, "You earned 1 frequent renter points");
	}
	
	@Test
	public void testOneRegularTreeDays() {
		rentMovie("Indiana Jones", Movie.REGULAR,3);
		String result = client.statement();
		assertContain(result, "Amount owed is 3.5");
		assertContain(result, "You earned 1 frequent renter points");
	}
	
	@Test
	public void testOneChildrensOneDay() {
		rentMovie("Procurando Nemo", Movie.CHILDRENS,1);
		String result = client.statement();
		assertContain(result, "Amount owed is 1.5");
		assertContain(result, "You earned 1 frequent renter points");
	}
	
	@Test
	public void testOneChildrensFiveDays() {
		rentMovie("Procurando Nemo", Movie.CHILDRENS,5);
		String result = client.statement();
		assertContain(result, "Amount owed is 4.5");
		assertContain(result, "You earned 1 frequent renter points");
	}
	
	@Test
	public void testOneNewReleaseOneDay() {
		rentMovie("Elvis", Movie.NEW_RELEASE,1);
		String result = client.statement();
		assertContain(result, "Amount owed is 3.0");
		assertContain(result, "You earned 1 frequent renter points");
	}
	
	@Test
	public void testOneNewReleasetreeDays() {
		rentMovie("Elvis", Movie.NEW_RELEASE,3);
		String result = client.statement();
		assertContain(result, "Amount owed is 9.0");
		assertContain(result, "You earned 2 frequent renter points");
	}
	
	@Test
	public void testManyRents() {
		rentMovie("Elvis", Movie.NEW_RELEASE,2);
		rentMovie("Thor - Love and Thunder", Movie.NEW_RELEASE,3);
		rentMovie("Procurando Nemo", Movie.CHILDRENS,3);
		rentMovie("Indiana Jones", Movie.REGULAR,2);
		rentMovie("Frozen", Movie.CHILDRENS,4);
		rentMovie("Star Wars IV - A New Hope", Movie.REGULAR,3);
		String result = client.statement();
		assertContain(result, "Amount owed is 25.0");
		assertContain(result, "You earned 8 frequent renter points");
	}
	
	private void rentMovie(String title, int type, int days) {
		Movie movie = Movie.createMovie(title,type);
		Rental rent = new Rental(movie, days);
		client.addRental(rent);
	}
	
	private void assertContain (String result, String content) {
		assertTrue(result.indexOf(content)>=0);
	}
}
