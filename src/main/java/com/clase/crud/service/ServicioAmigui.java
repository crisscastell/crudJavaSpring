package com.clase.crud.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.clase.crud.model.ListaDeAmiguis;

@Service
public class ServicioAmigui {
    private List<ListaDeAmiguis> amiguis = new ArrayList<>();
    private Long nextId = 1L;

    public List<ListaDeAmiguis> getUsers(){
        return amiguis;
    }

    public Optional<ListaDeAmiguis> getUserById(Long id){
        return amiguis.stream().filter(user -> user.getId().equals(id)).findFirst();
    }

    public ListaDeAmiguis createUser(ListaDeAmiguis amigui){
        amigui.setId(nextId++);
        amiguis.add(amigui);
        return amigui;
    }

    public Optional<ListaDeAmiguis> updateUser(Long id, ListaDeAmiguis DetallesAmigui){
        return getUserById(id).map(amigui -> {
           amigui.setNombre(DetallesAmigui.getNombre());
           amigui.setApellido(DetallesAmigui.getApellido());
           return amigui;
        });
    }

    public boolean deleteUser(Long id){
        return amiguis.removeIf(amigui -> amigui.getId().equals(id));
    }

}
