package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.standard.MediaSize.Other;

public class Anagramma {

	private 	List<Character> lettere ;
	private int N ;
	
	public Anagramma(int N) {
		lettere = new ArrayList<Character>() ;
		this.N=N ;
	}
	
	public Anagramma(Anagramma other) {
		this.N=other.N;
		this.lettere=new ArrayList<>(other.lettere);
	}

	public void add(char c) {
		
		if(lettere.size()<N)
			lettere.add(c);
	}
	public void removeLast() {
		lettere.remove(lettere.size()-1) ;
	}
	public String toString() {
		String s = "" ;
		for(char c : lettere) {
			s+=c ;
		}
		
	   // s = String.valueOf(lettere) ;
		
		return s;
		
	}

	public char getChar(int i) {
		
		return lettere.get(i);
	}
}
