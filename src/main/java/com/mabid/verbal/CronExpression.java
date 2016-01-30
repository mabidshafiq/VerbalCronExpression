package com.mabid.verbal;

/*
 * @Author mabid
 * http://www.unixgeeks.org/security/newbie/unix/cron-1.html
 */

public class CronExpression {

	public static String EVERY = "*";
	public static class Builder {

		private StringBuilder e = new StringBuilder();
		
		private String minute = EVERY ; //	This controls what minute of the hour the command will run on, and is between '0' and '59'
		private String hour = EVERY;   //	This controls what hour the command will run on, and is specified in the 24 hour clock, values must be between 0 and 23 (0 is midnight)
	    private String dom	= EVERY;   //  This is the Day of Month, that you want the command run on, e.g. to run a command on the 19th of each month, the dom would be 19.
		private String month = EVERY;   //	This is the month a specified command will run on, it may be specified numerically (0-12), or as the name of the month (e.g. May)
		private String dow =EVERY;    //	This is the Day of Week that you want a command to be run on, it can also be numeric (0-7) or as the name of the day (e.g. sun).
		private String year = ""; // year
		private String user="" ; 	//  This is the user who runs the command.
		private String cmd	="";   //  This is the command that you want run. This field may contain 
		
	

		/**
		 * Package private. Use {@link #cronExp()} to build a new one
		 */
		Builder() {
		}

		public Builder minuteOfHour(String m) {
			minute = m;
			return this;
		}

		public Builder hourOfDay(String h) {
			hour = h;
			return this;
		}

		public Builder dayOfMonth(String d) {
			dom = d;
			return this;
		}

		public Builder dayOfWeek(String d){
			dow = d;
			return this;
		}
		
		public Builder dayOfWeek(DaysOfWeek dw){
			dow= String.valueOf(dw.getCode());
			return this;
		}
		
		public Builder monthOfYear(String m) {
			month = m;
			return this;
		}
		
		public Builder monthOfYear(Months m) {
			month = String.valueOf(m.getCode());
			return this;
		}
		
		public Builder year(String y){
			year = y;
			return this;
		}
		
		public Builder everyYear(){
			year = EVERY;
			return this;
		}
		
		public Builder user(String u){
			user = u;
			return this;
		}
		
		public Builder commdand(String c){
			cmd = c ;
			return this;
		}
		
		public Builder everyMinute(){
			minute = EVERY; 
			return this;
		}
		
		public Builder everyHour(){
			hour = EVERY; 
			return this;
		}
		
		public Builder everyDay(){
			dom = EVERY;
			dow = EVERY;
			return this;
		}
		
		public Builder dailyAt(){
			dom = EVERY;
			month = EVERY;
			dow =EVERY;
			return this;
		}
		
		public Builder everyMonth(){
			month = EVERY;
			return this;
		}
		
		public Builder weeklyOn(){
			dom = EVERY;
			month = EVERY;
			return this;
		}
		
		public String generate() {
			e.append(minute).append(" ")
			.append(hour).append(" ")
			.append(dom).append(" ")
			.append(month).append(" ")
			.append(dow).append(" ");
			
			if(!year.equalsIgnoreCase("")){
				e.append(year).append(" ");
			}
			
			e.append(user).append(" ")
			.append(cmd);
			
			return e.toString();
		}
	}

	
	/**
	 * Creates new instance of CronExpression builder
	 *
	 * @return new VerbalCronExpression.Builder
	 * @since 1.1
	 */
	public static Builder cronExp() {
		return new Builder();
	}
}
