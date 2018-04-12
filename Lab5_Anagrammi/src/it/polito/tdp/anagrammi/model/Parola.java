package it.polito.tdp.anagrammi.model;

public class Parola {

	private String parola ;



	public Parola() {
		// TODO Auto-generated constructor stub
	}

	public String getParola() {
		return parola;
	}

	public void setParola(String parola) {
		this.parola = parola;
	}
	
	public int getSize() {
		return parola.length() ;
	}
	
	public char[] getCharArray() {
		
		return parola.toCharArray() ;
	}
	
	
}
