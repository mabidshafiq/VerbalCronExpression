package com.mabid.verbal;

import junit.framework.TestCase;

public class CronExpressionTest extends TestCase {

	private CronExpression ce;

	protected void setUp() throws Exception {
		super.setUp();
		ce = new CronExpression();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	
	public void testLastMinuteOfYearWithFriday(){
		String exp = ce.cronExp()
				.minuteOfHour("59")
				.hourOfDay("23")
				.dayOfMonth("31")
				.monthOfYear(Months.DECEMBER)
				.dayOfWeek(DaysOfWeek.FRIDAY)
				.year(CronExpression.EVERY)
				.user("root")
				.commdand("ls")
				.generate();
		
				 assertEquals("59 23 31 12 5 * root ls", exp);
		
	}
	
	public void testOnceAnYearIn2001And2002(){
		//	Once a   year, on June 7th at 17:45, if the year is 2001 or  2002
		
		String exp = ce.cronExp()
				.minuteOfHour("45")
				.hourOfDay("17")
				.dayOfMonth("7")
				.monthOfYear(Months.JUNE)
				.year("2001,2002")
				.generate();
		assertEquals("45 17 7 6 * 2001,2002  ", exp);
	}
	public void testComplicated1(){
/*		At 00:00, 00:15, 00:30, 00:45, 06:00, 06:15, 06:30,
        06:45, 12:00, 12:15, 12:30, 12:45, 18:00, 18:15,
        18:30, 18:45, on 1st, 15th or  31st of each  month, but not on weekends
        
        */
		
		String exp = ce.cronExp()
				.minuteOfHour("0,15,30,45")
				.hourOfDay("0,6,12,18")
				.dayOfMonth("1,15,31")
				.everyMonth()
				.dayOfWeek("1-5")
				.everyYear()
				.generate();
		assertEquals("0,15,30,45 0,6,12,18 1,15,31 * 1-5 *  ", exp);
		
	}
	public void testEachMinute(){
		String exp = ce.cronExp().everyMinute().user("root").commdand("ls").generate();
		assertEquals("* * * * * root ls", exp);
	}

	public void testExpEveryMinute() {
		String exp = ce.cronExp().minuteOfHour("01")
				.user("root")
				.commdand("echo This command is run at one min past every hour")
				.generate();

		assertEquals("01 * * * * root echo This command is run at one min past every hour", exp);
	}
	
	public void testDailyAtTime(){
		String exp = ce.cronExp().dailyAt()
				.hourOfDay("8").minuteOfHour("17")
				.user("root")
				.commdand("echo This command is run daily at 8:17 am")
				.generate();
		
		assertEquals("17 8 * * * root echo This command is run daily at 8:17 am", exp);
	}
	
	public void testWeeklyOnDayAndTime(){
		String exp = ce.cronExp().weeklyOn().dayOfWeek("0")
				.hourOfDay("4").minuteOfHour("00")
				.user("root")
				.commdand("echo This command is run at 4 am every Sunday")
				.generate();
		
		assertEquals("00 4 * * 0 root echo This command is run at 4 am every Sunday", exp);
	}
	
	public void testWeeklyOnDayAndTimeAgain(){
		String exp = ce.cronExp().weeklyOn().dayOfWeek("Sun")
				.hourOfDay("4")
				.user("root")
				.commdand("echo This command is run at 4 am every Sunday")
				.generate();
		
		assertEquals("* 4 * * Sun root echo This command is run at 4 am every Sunday", exp);
	}
	
	public void testWeeklyOnDayAndTimeAgainDW(){
		String exp = ce.cronExp().weeklyOn().dayOfWeek(DaysOfWeek.SUNDAY)
				.hourOfDay("4")
				.user("root")
				.commdand("echo This command is run at 4 am every Sunday")
				.generate();
		
		assertEquals("* 4 * * 0 root echo This command is run at 4 am every Sunday", exp);
	}
	
	public void testEveryMonthOnDateTime(){
		String exp = ce.cronExp().dayOfMonth("1")
				.hourOfDay("4").minuteOfHour("42")
				.user("root")
				.commdand("echo This command is run 4:42 am every 1st of the month")
				.generate();
		
		assertEquals("42 4 1 * * root echo This command is run 4:42 am every 1st of the month", exp);
	}
	
//	01 * 19 07 * root echo "This command is run hourly on the 19th of July"

	public void testEveryHourOnSpecificDate(){
		String exp = ce.cronExp().monthOfYear(Months.JULY)
				.dayOfMonth("19")
				.everyHour()
				.minuteOfHour("01")
				.user("root")
				.commdand("echo This command is run hourly on the 19th of July")
				.generate();
		
		assertEquals("01 * 19 7 * root echo This command is run hourly on the 19th of July", exp);
	}
	
	public void testExpEverHour() {

		assertTrue(false);
	}
}
