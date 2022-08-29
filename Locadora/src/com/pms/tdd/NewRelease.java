package com.pms.tdd;

public class NewRelease extends Movie {

	public NewRelease(String title) {
		super(title);
	}

	@Override
	public int getFrequentRenterPoints(int daysRented) {
		if (daysRented > 1)
			return 2;
		return 1;
	}

	@Override
	public double getAmount(int daysRented) {
		return daysRented * 3;
	}
}
