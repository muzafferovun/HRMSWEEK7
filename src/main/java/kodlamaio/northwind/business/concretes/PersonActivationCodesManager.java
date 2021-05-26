package kodlamaio.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.northwind.business.abstracts.PersonActivationCodesService;
import kodlamaio.northwind.business.abstracts.UserService;
import kodlamaio.northwind.core.loggers.concretes.LoggerManager;
import kodlamaio.northwind.core.loggers.concretes.Utils;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.ErrorResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.core.utilities.results.SuccessDataResult;
import kodlamaio.northwind.core.utilities.results.SuccessResult;
import kodlamaio.northwind.dataAccess.abstracts.PersonActivationCodeDao;
import kodlamaio.northwind.dataAccess.abstracts.PersonDao;

import kodlamaio.northwind.entities.concretes.PersonActivationCodes;


@Service
public class PersonActivationCodesManager implements PersonActivationCodesService {
	private PersonActivationCodeDao personActivationCodeDao;
	private PersonDao personDao;

	private LoggerManager loggerManager;
	@Override
	public DataResult<List<PersonActivationCodes>> getAll(){
		return new SuccessDataResult<List<PersonActivationCodes>>(this.personActivationCodeDao.findAll(),"Data Listelendi");
	}
	@Autowired
	public PersonActivationCodesManager(PersonActivationCodeDao personActivationCodeDao,PersonDao personDao) {
		this.loggerManager=new LoggerManager();
		this.personActivationCodeDao=personActivationCodeDao;
		this.personDao=personDao;
	}
	@Override
	public Result activate(PersonActivationCodes personActivationCodes) {
		if(checkActivationCode(personActivationCodes)) {
			
			this.personDao.activatePerson(personActivationCodes.getPerson_id());
			
			return new SuccessResult("Aktivasyon Gerçekleştirildi");
		}
		return new ErrorResult("Hatalı Doğrulama Kodu");
	}
	private boolean checkActivationCode(PersonActivationCodes personActivationCodes) {
		if(this.personActivationCodeDao.checkActivationCode(personActivationCodes.getPerson_id(),personActivationCodes.getActivation_code()).isEmpty()) {
			return false;
		}
		return true;
	}
	
}
