package com.saude.facil.demo.service;

import com.saude.facil.demo.entity.usuario.Usuario;
import com.saude.facil.demo.repository.UsuarioRepository;
import com.saude.facil.demo.service.dto.DadosAutenticacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;


    public Usuario criarUsuario(DadosAutenticacao dadosAutenticacao){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        Usuario usuario = new Usuario(dadosAutenticacao);
        usuario.setSenha(encoder.encode(usuario.getPassword()));
        return repository.save(usuario);
    }

    public List<Usuario> listarUsuarios(){
        return  repository.findAll();
    }
    public Optional<Usuario> listarUsuarioUnico(Long id){
        return  repository.findById(id);
    }
}
