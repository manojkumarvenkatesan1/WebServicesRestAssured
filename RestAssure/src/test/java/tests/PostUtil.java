package tests;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

public class PostUtil {

//http://dummy.restapiexample.com/api/v1/create
public static int getAge()
{
	int generated=RandomUtils.nextInt(20, 27);
	return(generated);
}
public static int getSalary()
{
	int generated=RandomUtils.nextInt(28000, 60000);
	return(generated);
}
public static String getName()
{
	String generated=RandomStringUtils.randomAlphabetic(6);
	return ("manojkumar"+generated);
}	


//https://jsonplaceholder.typicode.com/posts
public static int userId()
{
	int generated=RandomUtils.nextInt(6, 9);
	return(generated);
}
public static int id()
{
	int generated=RandomUtils.nextInt(200, 299);
	return(generated);
}
public static String title()
{
	String generated=RandomStringUtils.randomAlphabetic(6);
	return ("manojkumar"+generated);
}
public static String body()
{
	String generated=RandomStringUtils.randomAlphabetic(6);
	return ("manojkumar"+generated);
}

}
