package com.mabid.verbal;

public enum DaysOfWeek {
	 MONDAY(1), TUESDAY(2), WEDNESDAY(3), THURSDAY(4), FRIDAY(5), SATURDAY(6),SUNDAY(0);
	
	 private final int day;

	 DaysOfWeek(int day) {
        this.day = day;
    }
    
    public int getCode() {
        return this.day;
    }
}
