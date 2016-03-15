package spy2fy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class Musicoteca {

	ArrayList<Album> biblioteca;
	HashMap<String, Playlist> playlist;
	
	public Musicoteca(){
		
		this.biblioteca = new ArrayList<Album>();
		this.playlist = new HashMap<String, Playlist>();
		
	}
	
	public boolean addAlbum(Album album) throws Exception{
		
		if(this.biblioteca.contains(album)){

			return false;
			
		} else {

			this.biblioteca.add(album);
			return true;
		}
		
	}
	
	public boolean removeAlbum(String titulo) throws Exception{
		
		if (titulo.equals(null) || titulo.trim().equals("")){
			throw new Exception("O titulo n�o pode ser null ou vazio.");
		}
		
		int indice = this.biblioteca.procuraIndiceMusica(titulo);
		
		if(this.biblioteca.contains(album)){
			
			return true;
			
		} else {
			return false;
		}
		
	}
	
	private Album procuraAlbum(String nomeAlbum) throws Exception{
		
		Album albumProcurado = null;
		
		int indice = 0;
		
		while(indice < this.biblioteca.size()){
			
			if(this.biblioteca.get(indice).getTitulo().equals(nomeAlbum)){
				
				albumProcurado = this.biblioteca.get(indice);
				
			} 
			indice++;
		}
	
		if (albumProcurado == null){
			throw new Exception("Album nao pertence ao Perfil especificado");
		}

		return albumProcurado;
		
	}
	
	
	public boolean favoritaAlbum(Album album) throws Exception{
		
		if (album == null){

			throw new Exception("O album nao pode ser null");
		}
		
		int indice = 0;
		
		while(indice < this.biblioteca.size()){
			
			if(this.biblioteca.get(indice).equals(album)){
				
				this.biblioteca.get(indice).setFavorito();
				return true;
				
			} 
			indice++;
		}
		
		return false;
	}
		
}
