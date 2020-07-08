package process;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DatabaseConfigTest {
	public static void main(String args[])
	{
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
	context.scan("process");
	context.refresh();
	System.out.println("Success");
	context.close();
	}
}
