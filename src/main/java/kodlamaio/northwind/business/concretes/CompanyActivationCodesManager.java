package kodlamaio.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.northwind.business.abstracts.CompanyActivationCodesService;
import kodlamaio.northwind.business.abstracts.PersonActivationCodesService;
import kodlamaio.northwind.core.loggers.concretes.LoggerManager;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.ErrorResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.core.utilities.results.SuccessDataResult;
import kodlamaio.northwind.core.utilities.results.SuccessResult;
import kodlamaio.northwind.dataAccess.abstracts.CompanyActivationCodeDao;
import kodlamaio.northwind.dataAccess.abstracts.CompanyDao;
import kodlamaio.northwind.dataAccess.abstracts.PersonActivationCodeDao;
import kodlamaio.northwind.dataAccess.abstracts.PersonDao;
import kodlamaio.northwind.entities.concretes.CompanyActivationCodes;
import kodlamaio.northwind.entities.concretes.PersonActivationCodes;


@Service
public class CompanyActivationCodesManager implements CompanyActivationCodesService {
	private CompanyActivationCodeDao companyActivationCodeDao;
	private CompanyDao companyDao;

	private LoggerManager loggerManager;
	@Autowired
	public CompanyActivationCodesManager(CompanyActivationCodeDao companyActivationCodeDao,CompanyDao companyDao) {
		this.loggerManager=new LoggerManager();
		this.companyActivationCodeDao=companyActivationCodeDao;
		this.companyDao=companyDao;
	}
	@Override
	public Result activate(CompanyActivationCodes companyActivationCodes) {
		if(checkActivationCode(companyActivationCodes)) {
			
			this.companyDao.activateCompany(companyActivationCodes.getCompany_id());
			
			return new SuccessResult("Aktivasyon Gerçekleştirildi");
		}
		return new ErrorResult("Hatalı Doğrulama Kodu");
	}
	private boolean checkActivationCode(CompanyActivationCodes companyActivationCodes) {
		if(this.companyActivationCodeDao.checkActivationCode(companyActivationCodes.getCompany_id(),companyActivationCodes.getActivation_code()).isEmpty()) {
			return false;
		}
		return true;
	}
	
}
