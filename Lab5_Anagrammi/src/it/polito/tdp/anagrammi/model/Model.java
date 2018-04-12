package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.anagrammi.DAO.AnagrammaDAO;



public class Model {

	private List<Anagramma> soluzione ;
	private List<String> soluzioneFinale ;
	private AnagrammaDAO anagrammaDAO ;
	private List<String> anagrammiCorretti ;
	public Model() {
		anagrammaDAO = new AnagrammaDAO() ;
	}
	
	public List<String> trovaAnagrammi (String parola){
		//Creo una nuova parola
		Parola p = new Parola() ;
		p.setParola(parola);
		
		soluzione = new ArrayList<Anagramma>() ;
		Anagramma parziale = new Anagramma(parola.length()) ;
		recursive(0,p,parziale);
		

		soluzioneFinale = eliminoDoppioni(soluzione) ;
		anagrammiCorretti = anagrammaDAO.cercoAnagrammiCorretti(soluzioneFinale) ;
		return anagrammiCorretti ;
	}

	public List<String> anagrammiErrati(){
		
		List<String> anagrammiErrati = new ArrayList<String>() ;
		
		for(String s:soluzioneFinale) {
			
			if(!anagrammiCorretti.contains(s))
				anagrammiErrati.add(s);
		}
		
		return anagrammiErrati ;
		
	}

	private List<String> eliminoDoppioni(List<Anagramma> soluzione) {
		List<String> solFinale = new ArrayList<String>() ;
		
		for(Anagramma a: soluzione) {
		    boolean flag = true ;
			for(String a1: solFinale) {
				if(a.toString().equals(a1.toString())) {
					flag = false ;
				}
			}
			if(flag==true)
				solFinale.add(a.toString()) ;
			
			}
		
		return solFinale;
	}


	private void recursive(int livello, Parola parola,Anagramma parziale) {
		
		if(livello==parola.getSize()) {
			//Soluzione completa
		//	System.out.println(parziale);
			soluzione.add(new Anagramma(parziale));
		}
		
		for(char lettera : parola.getCharArray()) {
			if(isValid(lettera,parziale,livello,parola)){
			parziale.add(lettera);
			recursive(livello+1,parola,parziale);
			parziale.removeLast();
			}
		}
		
		
	}


	private boolean isValid(char lettera, Anagramma parziale, int livello, Parola parola) {
		int countLetter = 0 ;
		int countIn = 0 ;
		for(char c : parola.getCharArray()) {
			if(c == lettera)
				countLetter++;
		}
		for(int i=0; i< livello; i++) {
			if(lettera == parziale.getChar(i))
				countIn++;
		}
		
		for(int i=0; i < livello; i++) {
			
			if(lettera==parziale.getChar(i) && countLetter<=1)
			return false;
			
			if(lettera==parziale.getChar(i) && countLetter>=1 && countLetter==countIn)
				return false ;
		}
		return true;
	}

	




}
