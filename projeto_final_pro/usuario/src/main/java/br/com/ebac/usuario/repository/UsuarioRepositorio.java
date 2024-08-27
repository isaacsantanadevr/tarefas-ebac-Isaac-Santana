package br.com.ebac.usuario.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.ebac.usuario.entity.Usuarios;

public interface UsuarioRepositorio extends CrudRepository<Usuarios, Long>{

}
