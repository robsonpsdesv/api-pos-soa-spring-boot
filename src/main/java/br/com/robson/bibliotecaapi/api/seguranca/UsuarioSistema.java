package br.com.robson.bibliotecaapi.api.seguranca;

import br.com.robson.bibliotecaapi.api.model.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class UsuarioSistema extends User {

	private static final long serialVersionUID = 3684333649668333106L;

	private Usuario usuario;
	
	public Usuario getUsuario() {
		return usuario;
	}

	public UsuarioSistema(Usuario usuario, Collection<? extends GrantedAuthority> authorities) {
		super(usuario.getEmail(), usuario.getSenha(), authorities);
		this.usuario = usuario;
	}
}
