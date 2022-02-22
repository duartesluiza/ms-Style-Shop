package com.api.mscustomer.controllers;

import com.api.mscustomer.dtos.UsuarioDTO;
import com.api.mscustomer.models.UsuarioModel;
import com.api.mscustomer.services.UsuarioService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/usuario")
public class UsuarioController {

    // ponto de injeção
    final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @Transactional
    @RequestMapping(value = "create",
            method = RequestMethod.POST,
            produces = { MimeTypeUtils.APPLICATION_JSON_VALUE },
            consumes = { MimeTypeUtils.APPLICATION_JSON_VALUE })
    public ResponseEntity<Object> create(@RequestBody @Valid UsuarioDTO usuarioDTO) {
        var usuarioModel = new UsuarioModel();
        BeanUtils.copyProperties(usuarioDTO, usuarioModel);
//        usuarioModel.setBirthdate(new Date());
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuarioModel));
    }

    @RequestMapping(value = "findall",
                    method = RequestMethod.GET,
                    produces = { MimeTypeUtils.APPLICATION_JSON_VALUE })
    public ResponseEntity<List<UsuarioModel>> getAllUsuario() {
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneUsuario(@PathVariable(value = "id") UUID id) {
        Optional<UsuarioModel> usuarioModelOptional = usuarioService.findById(id);
        if (!usuarioModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(usuarioModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUsuario(@PathVariable(value = "id") UUID id) {
        Optional<UsuarioModel> usuarioModelOptional = usuarioService.findById(id);
        if (!usuarioModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
        }
        usuarioService.delete(usuarioModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("User deleted successfully.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateUser(@PathVariable(value = "id") UUID id, @RequestBody @Valid UsuarioDTO usuarioDTO){
        Optional<UsuarioModel> usuarioModelOptional = usuarioService.findById(id);
        if (!usuarioModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
        }
//        var usuarioModel = usuarioModelOptional.get();
 //       usuarioModel.setFirstName(usuarioDTO.getFirstName());
 //       usuarioModel.setLastName(usuarioDTO.getLastName());
 //       usuarioModel.setGenero(usuarioDTO.getGenero());
 //       usuarioModel.setCpf(usuarioDTO.getCpf());
 //       usuarioModel.setEmail(usuarioDTO.getEmail());
 //       usuarioModel.setPassword(usuarioDTO.getPassword());
 //       usuarioModel.setActive(usuarioDTO.isActive());
        var usuarioModel = new UsuarioModel();
        BeanUtils.copyProperties(usuarioDTO, usuarioModel);
        usuarioModel.setId(usuarioModelOptional.get().getId());
        usuarioModel.setBirthdate(usuarioModelOptional.get().getBirthdate());
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.save(usuarioModel));

    }

}
