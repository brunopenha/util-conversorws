package br.nom.penha.bruno.wsrest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.nom.penha.bruno.wsrest.conversores.Temperatura;

/**
 * Classe que implementa o recebimento das requisições para os serviços
 * @author brunopenha
 *
 */
@Path("conversor")
public class ConversorImpl implements Conversor {

	/**
	 * {@inheritDoc}
	 */
	public String celciusParaFahrenheitSoap(float celcius) {

		float resultado = conversaoCelsiusParaFahrenheint(celcius);
		return Float.toString(resultado);

	}

	/**
	 * {@inheritDoc}
	 */
	public String fahrenheitParaCelciusSoap(float fahrenheit) {
		float resultado = converteFahrenheintParaCelcius(fahrenheit);
		return Float.toString(resultado);
	}

	/**
	 * Recebe a requisição para converter a temperatura de Celsius para Fahrenheint
	 * @param celcius - Temperatura em celcius
	 * @return objeto JSON com a temperatura em Farenheit
	 */
	@GET
	@Path("/cPf/{celcius}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response celciusParaFahrenheitRest(@PathParam("celcius") float celcius) {

		float resultado = conversaoCelsiusParaFahrenheint(new Float(celcius));
		Temperatura conversao = new Temperatura("celcius",resultado);
		return Response.status(200).entity(conversao).build();
	}

	/**
	 * Recebe a requisição para converter a temperatura de Fahrenheint para Celcius
	 * @param fahrenheit - Temperatura em Fahrenheint
	 * @return objeto JSON com a temperatura em Celsius
	 */
	@GET
	@Path("/fPc/{fahrenheit}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response fahrenheitParaCelciusRest(@PathParam("fahrenheit") float fahrenheit) {

		float resultado = converteFahrenheintParaCelcius(new Float(fahrenheit));
		Temperatura conversao = new Temperatura("fahrenheit",resultado);
		return Response.status(200).entity(conversao).build();
	}
	
	/**
	 * Converte a temperatura de Celsius para Fahrenheit
	 * @param celcius - temperatura em celcius
	 * @return a temperatura em Fahrenheint
	 */
	private float conversaoCelsiusParaFahrenheint(float celcius) {
		return 32.0f + (celcius * 9.0f / 5.0f);
	}
	
	/**
	 * Converte a temperatura de Fahrenheint para Celsius
	 * @param fahrenheit - temperatura em Fahrenheint
	 * @return temperatura em Celcius
	 */
	private float converteFahrenheintParaCelcius(float fahrenheit) {
		return (5.0f / 9.0f) * (fahrenheit - 32.0f);
	}


}
