package spy2fy;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws Exception {

		Integer inteiro = null;
		ArrayList lista = new ArrayList();
		lista.add(inteiro, 3); 
		
		
		
	}
}

/*
 * � composta pela cole��o de albuns do usu�rio e pela cole��o de playlists do
 * usu�rio
 * 
 * Albuns podem ser adicionados � cole��o e removidos da cole��o.
 * 
 * Albuns null n�o devem ser aceitos.
 * 
 * Deve ser poss�vel marcar albuns como favoritos e obter todos os albuns que
 * s�o favoritos.
 * 
 * M�todos que adicionam, removem e pesquisam albuns s�o necess�rios
 * 
 * Uma playlist encapsula uma cole��o de m�sicas, mas ao contr�rio do album,
 * essas m�sicas podem ser de diferentes artistas.
 * 
 * As playlists s�o armazenadas de forma que o nome da playlist (que serve de
 * chave) pode ser usado para recuperar as m�sicas da playlist.
 * 
 * � poss�vel adicionar m�sicas a uma playlist as m�sicas de qualquer playlist
 * devem ser todas m�sicas de albuns do usu�rio, caso contr�rio a m�sica n�o
 * pode ser adicionada � playlist.
 * 
 * Uma playlist inicia vazia e as m�sicas s�o adicionadas uma a uma.
 * 
 * Uma nova m�sica adicionada vai sempre para o fim da playlist.
 * 
 * Crie o m�todo adicionaPlaylist(String nomePlaylist, String nomeAlbum, int faixa)
 * 
 * todos os m�todos que adicionam, removem e pesquisam objetos em cole��es devem retornar um boolean
 */
