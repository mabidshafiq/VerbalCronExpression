package com.mabid.verbal;

public enum Months {

	JANUARY(1), FEBURARY(2), MARCH(3), APRIL(4), MAY(5), JUNE(6), JULY(7), AUGUST(
			8), SEPTEMBER(9), OCTOBER(10), NOVEMBER(11), DECEMBER(12);

	private final int m;

	Months(int m) {
		this.m = m;
	}

	public int getCode() {
		return this.m;
	}
}
