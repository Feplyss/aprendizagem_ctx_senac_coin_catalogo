package com.senac.projetoIntegrador.usuario.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.projetoIntegrador.usuario.dto.UsuarioDto;
import com.senac.projetoIntegrador.usuario.repository.IUsuarioRepository;
import com.senac.projetoIntegrador.usuario.service.IUsuarioService;

@Service
public class UsuarioService implements IUsuarioService{
	@Autowired
	IUsuarioRepository repository;
	
	public UsuarioDto getUsuario(String id) {
		return repository.getUsuarioById(id);
	}
}
