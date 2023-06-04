package com.senac.projetoIntegrador.usuario.repository;

import com.senac.projetoIntegrador.usuario.dto.UsuarioDto;

public interface IUsuarioRepository {
	public UsuarioDto getUsuarioById(String id);
}
