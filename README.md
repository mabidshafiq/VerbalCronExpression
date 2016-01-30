# VerbalCronExpression
VerbalCronExpressions is a Java library that helps to construct difficult Cron expressions.

Examples 1:
Creating Cron Exp to run ls command by root every minute
```java
private CronExpression ce;
String exp = ce.cronExp().everyMinute().user("root").commdand("ls").generate();
```
Result: * * * * * root ls 

Example 2:
Follow code creates Cron expression that will run "ls" command daily at 8:17 am by User Root
```
String exp = ce.cronExp().dailyAt()
				.hourOfDay("8").minuteOfHour("17")
				.user("root")
				.commdand("ls -a")
				.generate();
```
Result : 17 8 * * * root ls

Example 3:
Run At 00:00, 00:15, 00:30, 00:45, 06:00, 06:15, 06:30,
06:45, 12:00, 12:15, 12:30, 12:45, 18:00, 18:15,
18:30, 18:45, on 1st, 15th or  31st of each  month, but not on weekends
```
String exp = ce.cronExp().minuteOfHour("0,15,30,45")
				.hourOfDay("0,6,12,18")
				.dayOfMonth("1,15,31")
				.everyMonth()
				.dayOfWeek("1-5")
				.everyYear()
				.generate();
```
Result: 0,15,30,45 0,6,12,18 1,15,31 * 1-5 *  


Look into [Test Class](https://github.com/mabidshafiq/VerbalCronExpression/blob/master/src/test/java/com/mabid/verbal/CronExpressionTest.java) for more scenarios to create Cron expression using Verbal Cron Expression tool.
