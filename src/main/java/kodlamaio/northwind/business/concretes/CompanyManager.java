package kodlamaio.northwind.business.concretes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import kodlamaio.northwind.business.abstracts.CompanyService;
import kodlamaio.northwind.core.loggers.concretes.LoggerManager;
import kodlamaio.northwind.core.loggers.concretes.Utils;
import kodlamaio.northwind.core.methods.GlobalMethods;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.ErrorResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.core.utilities.results.SuccessDataResult;
import kodlamaio.northwind.core.utilities.results.SuccessResult;
import kodlamaio.northwind.dataAccess.abstracts.CompanyActivationCodeDao;
import kodlamaio.northwind.dataAccess.abstracts.CompanyDao;
import kodlamaio.northwind.dataAccess.abstracts.UserDao;
import kodlamaio.northwind.entities.concretes.Company;
import kodlamaio.northwind.entities.concretes.CompanyActivationCodes;
import kodlamaio.northwind.entities.concretes.CompanyUser;
import kodlamaio.northwind.entities.concretes.PersonActivationCodes;
import kodlamaio.northwind.entities.concretes.User;



@Service
public class CompanyManager implements CompanyService {
	private CompanyDao companyDao;
	private UserDao userDao;
	private CompanyActivationCodeDao companyActivationCodeDao;
	private LoggerManager loggerManager;
	@Override
	public DataResult<List<Company>> getAll(){
		Utils.RunLoggers(loggerManager.log("Company")," sector tablosu listelendi");		
		return new SuccessDataResult<List<Company>>(this.companyDao.findAll(),"Data Listelendi");
	}
	@Autowired
	public CompanyManager(CompanyDao companyDao,UserDao userDao,CompanyActivationCodeDao companyActivationCodeDao) {
		this.loggerManager=new LoggerManager();
		this.companyDao=companyDao;
		this.userDao=userDao;
		this.companyActivationCodeDao=companyActivationCodeDao;
	}
	@Override
	public Result add(CompanyUser companyUser) {
		String checkUserMessage=checkUser(companyUser);
		if(checkUserMessage!="") {
			return new ErrorResult(checkUserMessage);
		}
		String checkEmailMessage=checkEmail(companyUser);
		if(checkEmailMessage!="") {
			return new ErrorResult(checkEmailMessage);
		}
		
		User user=new User();
		user.setEmail(companyUser.getEmail());
		user.setPassword(companyUser.getEmail());
		user.setStatus(true);
		this.userDao.save(user);
		
		Company company=new Company();
		company.setUser_id(user.getId());
		company.setCompany_email(companyUser.getCompany_email());
		company.setCompany_name(companyUser.getCompany_name());
		company.setIs_verify(false);
		company.setPhone(companyUser.getPhone());
		company.setWebsite(companyUser.getWebsite());
		company.setIs_activate(false);
		company.setCompany_city(Integer.parseInt(companyUser.getCompany_city()));
		this.companyDao.save(company);
		CompanyActivationCodes companyActivationCodes=new CompanyActivationCodes();
		companyActivationCodes.setCompany_id(company.getId());
		companyActivationCodes.setActivation_code(GlobalMethods.passwordGenerator(50));
		companyActivationCodeDao.save(companyActivationCodes);
		
//		this.companyDao.save(company);
//		Utils.RunLoggers(loggerManager.log("Company"),company.getCompany_name()+" Company tablosuna eklendi");		
		return new SuccessResult(company.getCompany_name()+" Company oluşturuldu");
	}
	private String checkCompany(CompanyUser companyUser) {
		if(companyUser.getPhone().length()<10) {
			return "Telefon Numarası Hatalı";
		}
		companyUser.setPhone(companyUser.getPhone().replace(" ",""));
		String regex = "^[0-9]";
		if(Pattern.matches(regex, companyUser.getPhone())==false){
			return "Telefon Numarası Hatalı";
		}
		
		return "";
	}
	private String checkUser(CompanyUser companyUser) {
		if(!this.userDao.findEmail(companyUser.getEmail()).isEmpty()) {
			return "Email Adresi sistemde kayıtlı";
		}
		if(companyUser.getPassword().length()<4|!companyUser.getPassword().equals(companyUser.getRepassword())) {
			return "Şifreler uyuşmuyor yada şifre 4 karakterden az";
		}
		
		return "";
	}
	private String checkEmail(CompanyUser companyUser) {
		String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
		if(Pattern.matches(regex, companyUser.getEmail())==false){
			return "Email adresi Hatalı";
		}
		String[] emailpart= companyUser.getEmail().split("@");
		String[] websitepart=companyUser.getWebsite().split("www.");
		if(emailpart.length<2) {
			return "Hatalı Email Adresi";
		}
		if(websitepart.length<2) {
			return "Hatalı Web Adresi";
		}
		if(!emailpart[1].equals(websitepart[1]) ) {
			return "Şirket adına kayıtlı web sitenize uygun mail adresi girmediniz";
		}
		if(websitepart[1].length()<1) {
			return "hatalı web adresi";
		}
	    return "";
	}
}
