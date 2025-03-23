package com.saude.facil.demo.controller;

import com.saude.facil.demo.entity.usuario.Usuario;
import com.saude.facil.demo.service.UsuarioService;
import com.saude.facil.demo.service.dto.DadosAutenticacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping
    public ResponseEntity<Usuario> criarUsuario(@RequestBody DadosAutenticacao dadosAutenticacao){

        return ResponseEntity.status(HttpStatus.CREATED).body(service.criarUsuario(dadosAutenticacao));
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios(){

        return ResponseEntity.ok(service.listarUsuarios());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Usuario>> listarUsuarios(@PathVariable Long id){

        return ResponseEntity.ok(service.listarUsuarioUnico(id));
    }
}
