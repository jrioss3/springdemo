package com.example.demo02.controladores;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import com.example.demo02.modelo.UsuarioModel;
import com.example.demo02.servicio.UserRepository;
import com.example.demo02.servicio.UserServicio;
import com.example.demo02.servicio.impl.UserServicioImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/usuario")
public class UserControlador {

    @Autowired
    UserRepository userRepo;

    @RequestMapping("/all")
    @ResponseBody
    public ResponseEntity<List<UsuarioModel>> getAllItems(){
        List<UsuarioModel> items =  userRepo.findAll();
        return new ResponseEntity<List<UsuarioModel>>(items, HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    @ResponseBody
    public ResponseEntity<UsuarioModel> getItem(@PathVariable Long id){
        Optional<UsuarioModel> item = userRepo.findById(id);
        return new ResponseEntity<UsuarioModel>(item.get(), HttpStatus.OK);
    }

    @PostMapping(value = "/add",consumes = {"application/json"},produces = {"application/json"})
    @ResponseBody
    public ResponseEntity<UsuarioModel> addItem(@RequestBody UsuarioModel item, UriComponentsBuilder builder){
        userRepo.save(item);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/addItem/{id}").buildAndExpand(item.getId()).toUri());
        return new ResponseEntity<UsuarioModel>(headers, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    @ResponseBody
    public ResponseEntity<UsuarioModel> updateItem(@RequestBody UsuarioModel item){
        if(item != null){
            userRepo.save(item);
        }
        return new ResponseEntity<UsuarioModel>(item, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity<Void> deleteItem(@PathVariable Long id){
        Optional<UsuarioModel> item = userRepo.findById(id);
        userRepo.delete(item.get());
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }

    
}
