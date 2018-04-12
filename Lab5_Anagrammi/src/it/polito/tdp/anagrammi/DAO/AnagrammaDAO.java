package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class AnagrammaDAO {

	public List<String> cercoAnagrammiCorretti(List<String> soluzioneFinale) {
		
		List<String> anagrammiCorretti = new ArrayList<String>() ;
		
		for(String s : soluzioneFinale) {
			
			if(isCorrect(s)) {
				anagrammiCorretti.add(s);
			}
			
		}
		
		
		return anagrammiCorretti;
	}

	private boolean isCorrect(String s) {
		
		final String sql= "SELECT * FROM parola  WHERE parola.nome=?";
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, s);
			ResultSet rs = st.executeQuery();
			
			if(!rs.isBeforeFirst())
				return false ;
			
			conn.close();
			
			}catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("Errore Db");
			}
		
		
		return true;
	}



	

}
