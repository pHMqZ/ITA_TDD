package com.pms.tdd;

public abstract class Movie {

	public static final int CHILDRENS = 2;
	
	public static final int REGULAR = 0;
	
	public static final int NEW_RELEASE = 1;
	
	private String title;
		
	public static Movie createMovie(String title, int priceCode) {
		if(priceCode == REGULAR)
			return new Regular(title);
		if(priceCode == NEW_RELEASE)
			return new NewRelease(title);
		if(priceCode == CHILDRENS)
			return new Childrens(title);
		throw new RuntimeException("Não existe esse tipo de filme");
	}
	
	public Movie(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public int getFrequentRenterPoints(int daysRented) {
		return 1;
	}

	public abstract double getAmount(int daysRented);
	
}
