package com.clase.crud.controller;

import com.clase.crud.model.ListaDeAmiguis;
import com.clase.crud.service.ServicioAmigui;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Amiguis")
public class ControladorAmiguis {
    private final ServicioAmigui servicioAmigui;

    @Autowired
    public ControladorAmiguis(ServicioAmigui servicioAmigui) {
        this.servicioAmigui = servicioAmigui;
    }

    @GetMapping
    public List<ListaDeAmiguis> getAllAmiguis(){
        return servicioAmigui.getUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ListaDeAmiguis> getUserById(@PathVariable Long id){
        Optional<ListaDeAmiguis> amigui = servicioAmigui.getUserById(id);
        return amigui.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    @PostMapping
    public ListaDeAmiguis createAmigui(@RequestBody ListaDeAmiguis amigui){
        return servicioAmigui.createUser(amigui);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ListaDeAmiguis> updateAmigui(@PathVariable Long id, @RequestBody ListaDeAmiguis detallesUsuario){
        Optional<ListaDeAmiguis> amigui = servicioAmigui.updateUser(id, detallesUsuario);
        return amigui.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAmigui (@PathVariable Long id){
        if (servicioAmigui.deleteUser(id)){
            return ResponseEntity.ok().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }

}
