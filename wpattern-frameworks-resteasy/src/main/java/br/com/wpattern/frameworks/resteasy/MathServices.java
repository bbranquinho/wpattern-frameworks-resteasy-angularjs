package br.com.wpattern.frameworks.resteasy;

import javax.inject.Named;
import org.apache.log4j.Logger;

import br.com.wpattern.frameworks.resteasy.utils.beans.RequestBean;
import br.com.wpattern.frameworks.resteasy.utils.beans.ResponseBean;
import br.com.wpattern.frameworks.resteasy.utils.interfaces.IMathRestService;

@Named
public class MathServices implements IMathRestService {
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	public MathServices() {
		this.logger.info("Math service started.");
	}
	
	@Override
	public String hello() {
		this.logger.info("GET service called.");
		return "Hello RESTEasy!";
	}
	
	@Override
	public ResponseBean hello(RequestBean requestBean) {
		this.logger.info("POST service called.");
		int sum = requestBean.getValue1() + requestBean.getValue2();
		return new ResponseBean(sum);
	}
	
	@Override
	public String exemplo1(int valorA, int valorB) {
		return "Exemplo 1 - Soma = " + (valorA + valorB);
	}
	
	@Override
	public String exemplo2(int valorA, int valorB) {
		return "Exemplo 2 - Soma = " + (valorA + valorB);
	}
	
}
