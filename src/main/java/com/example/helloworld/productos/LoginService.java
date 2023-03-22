package com.example.helloworld.productos;

public interface LoginService {
    String login(String usuario, String password);
    String cambia(String tokenDado, String nuevoPassword);
}
