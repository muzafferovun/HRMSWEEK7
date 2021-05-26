package kodlamaio.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import kodlamaio.northwind.business.abstracts.PersonService;

import kodlamaio.northwind.core.loggers.concretes.LoggerManager;
import kodlamaio.northwind.core.loggers.concretes.Utils;
import kodlamaio.northwind.core.methods.GlobalMethods;
import kodlamaio.northwind.core.utilities.mernis.MernisControl;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.ErrorDataResult;
import kodlamaio.northwind.core.utilities.results.ErrorResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.core.utilities.results.SuccessDataResult;
import kodlamaio.northwind.core.utilities.results.SuccessResult;
import kodlamaio.northwind.dataAccess.abstracts.PersonActivationCodeDao;
import kodlamaio.northwind.dataAccess.abstracts.PersonDao;
import kodlamaio.northwind.dataAccess.abstracts.UserDao;
import kodlamaio.northwind.entities.concretes.Person;
import kodlamaio.northwind.entities.concretes.PersonActivationCodes;
import kodlamaio.northwind.entities.concretes.PersonUser;
import kodlamaio.northwind.entities.concretes.User;



@Service
public class PersonManager implements PersonService {
	private PersonDao personDao;
	private UserDao userDao;
	private PersonActivationCodeDao personActivationCodeDao;
	private LoggerManager loggerManager;
	@Override
	public DataResult<List<Person>> getAll(){
		Utils.RunLoggers(loggerManager.log("Sector")," sector tablosu listelendi");		
		return new SuccessDataResult<List<Person>>(this.personDao.findAll(),"Data Listelendi");
	}
	@Autowired
	public PersonManager(PersonDao personDao,UserDao userDao,PersonActivationCodeDao personActivationCodeDao) {
		this.loggerManager=new LoggerManager();
		this.personDao=personDao;
		this.userDao=userDao;
		this.personActivationCodeDao=personActivationCodeDao;
	}
	@Override
	public Result add(PersonUser personUser) {
		if(!checkUser(personUser.getUser())) {
			return new ErrorResult(false, "email adresi boş veya sistemde kayıtlı");
		}
		MernisControl mernisControl=new MernisControl();
		if(mernisControl.checkPerson(personUser.getPerson()).getMessage().length()>0) {
			return new ErrorResult(mernisControl.checkPerson(personUser.getPerson()).getMessage());
		}
		
		if(!checkNationalIdentity(personUser.getPerson())) {
			return new ErrorResult(false, "National_identity sistemde kayıtlı");
		}
		
			
			 
		this.userDao.save(personUser.getUser());
		personUser.getPerson().setUser_id(personUser.getUser().getId());
		personUser.getPerson().setIs_verify(false);
		this.personDao.save(personUser.getPerson());
		PersonActivationCodes personActivationCode=new PersonActivationCodes();
		personActivationCode.setPerson_id(personUser.getPerson().getId());
		personActivationCode.setActivation_code(GlobalMethods.passwordGenerator(50));
		personActivationCodeDao.save(personActivationCode);
		Utils.RunLoggers(loggerManager.log("User"),personUser.getPerson().getName()+" "+personUser.getPerson().getSurname()+" person tablosuna eklendi");
		return new SuccessResult("Person Eklendi");
	}
	private boolean checkNationalIdentity(Person person) {
		
		if(this.personDao.findNational_identity(person.getNational_identity()).isEmpty()) {
			return true;
		}
		Utils.RunLoggers(loggerManager.log("User"),person.getNational_identity()+" sistemde kayıtlı");
		return false;
	}
	
	private boolean checkUser(User user) {
		if(user.getPassword().length()<4) {
			Utils.RunLoggers(loggerManager.log("User")," Şifre enaz 4 karakter olmalı");
			return false;
		}
		
		if(this.userDao.findEmail(user.getEmail()).isEmpty()) {
			return true;
		}
		Utils.RunLoggers(loggerManager.log("User"),user.getEmail()+" sistemde kayıtlı");
		return false;
	}
	
}
