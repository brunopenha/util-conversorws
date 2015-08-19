/**
 * 
 */
package br.nom.penha.bruno.wsrest;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author brunopenha
 * Interface que possui serviços web para conversão
 */
@WebService
public interface Conversor {
	
	/***
	 * Converte da temperatura Celcius para Fahrenheit
	 * @param celcius - temperatura em Celcius
	 * @return a temperatura em Fahrenheit 
	 */
	@WebMethod
	public String celciusParaFahrenheitSoap(@WebParam(name="celcius") float celcius);
	
	/**
	 * Converte da temperatura Fahrenheit para Celcius
	 * @param fahrenheit - temperatura em Fahrenheit
	 * @return a temperatura em Celcius
	 */
	@WebMethod
	public String fahrenheitParaCelciusSoap(@WebParam(name="fahrenheint") float fahrenheit);
	
	
	
}
