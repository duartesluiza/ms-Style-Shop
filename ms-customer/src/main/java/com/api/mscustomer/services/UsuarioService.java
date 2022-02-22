package com.api.mscustomer.services;

import com.api.mscustomer.models.UsuarioModel;
import com.api.mscustomer.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UsuarioService {

    final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Transactional
    public UsuarioModel save(UsuarioModel usuarioModel) {
        return usuarioRepository.save(usuarioModel);
    }

    public List<UsuarioModel> findAll() {
        return usuarioRepository.findAll();
    }

    public Optional<UsuarioModel> findById(UUID id) {
        return usuarioRepository.findById(id);
    }

    @Transactional
    public void delete(UsuarioModel usuarioModel) {
        usuarioRepository.delete(usuarioModel);
    }
}
