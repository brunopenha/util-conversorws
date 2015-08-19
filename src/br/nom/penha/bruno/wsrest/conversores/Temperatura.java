package br.nom.penha.bruno.wsrest.conversores;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Dados para conversão de temperatura
 * @author brunopenha
 *
 */
@XmlRootElement
public class Temperatura {
	
	private String escala;
	private float conversao;
	
	public Temperatura(String escalaParam, float conversaoParam){
		escala = escalaParam;
		conversao = conversaoParam;
	}
	
	
	
	public Temperatura() {
		super();
	}



	public String getEscala() {
		return escala;
	}
	public void setEscala(String escala) {
		this.escala = escala;
	}
	public float getConversao() {
		return conversao;
	}
	public void setConversao(float conversao) {
		this.conversao = conversao;
	}
	
	

}
