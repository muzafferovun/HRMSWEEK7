package kodlamaio.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.northwind.business.abstracts.CountrieCitysService;

import kodlamaio.northwind.core.loggers.concretes.LoggerManager;
import kodlamaio.northwind.core.loggers.concretes.Utils;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.core.utilities.results.SuccessDataResult;
import kodlamaio.northwind.core.utilities.results.SuccessResult;
import kodlamaio.northwind.dataAccess.abstracts.CountrieCitysDao;

import kodlamaio.northwind.entities.concretes.CountrieCitys;



@Service
public class CountrieCitysManager implements CountrieCitysService {
	private CountrieCitysDao countrieCitysDao;
	private LoggerManager loggerManager;
	@Override
	public DataResult<List<CountrieCitys>> getAll(){
		Utils.RunLoggers(loggerManager.log("Sector")," sector tablosu listelendi");		
		return new SuccessDataResult<List<CountrieCitys>>(this.countrieCitysDao.findAll(),"Data Listelendi");
	}
	@Autowired
	public CountrieCitysManager(CountrieCitysDao countrieCitysDao) {
		this.loggerManager=new LoggerManager();
		this.countrieCitysDao=countrieCitysDao;
	}
	@Override
	public Result add(CountrieCitys countrieCitys) {
		this.countrieCitysDao.save(countrieCitys);
		Utils.RunLoggers(loggerManager.log("Sector"),countrieCitys.getCity_name()+" countrie_citys tablosuna eklendi");		
		return new SuccessResult(countrieCitys.getCity_name()+" countrie_citys tablosuna Eklendi");
	}
	
}
