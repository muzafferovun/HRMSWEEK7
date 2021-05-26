package kodlamaio.northwind.core.loggers.concretes;

import kodlamaio.northwind.core.loggers.abstracts.Logger;

public class DatabaseLogger implements Logger  {

	@Override
	public void log(String message) {
		System.out.println("Database Log : "+message);
		
	}

}
