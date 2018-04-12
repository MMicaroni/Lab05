package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.List;

public class TestModel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Model m = new Model();
		List<String> anag=m.trovaAnagrammi("routine");
		List<String> anagrammiErrati = m.anagrammiErrati() ;
		System.out.println("QUESTI SONO GLI ANAGRAMMI CORRETTI");
		for(String s : anag) {
			System.out.println(s);
		}
		
		System.out.println("\n\nQUESTI SONO GLI ANAGRAMMI ERRATI");
		for(String s: anagrammiErrati) {
			System.out.println(s);
		}
	
	
	}

}
