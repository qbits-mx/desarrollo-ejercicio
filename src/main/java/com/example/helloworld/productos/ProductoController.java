package com.example.helloworld.productos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.helloworld.personas.Persona;
import com.example.helloworld.productos.model.ResultadoConsulta;
import com.example.helloworld.utilerias.JwtBody;

@RestController
@RequestMapping(value="/hola")
public class ProductoController {
    private ProductoService productoService;
    private LoginService loginService;
    private InvokeRemoteRestService invokeService;
    
    public ProductoController(
            ProductoService productoService, 
            LoginService loginService, 
            InvokeRemoteRestService invokeService) {
        this.productoService = productoService;
        this.loginService = loginService;
        this.invokeService = invokeService;
    }
    @DeleteMapping(
            path = "/up/delete-media/{idMedia}",
            produces = "application/json; charset=utf-8")
     public String deleteMedia(
             @RequestHeader("jwt") String jwt,
             @RequestHeader("idUser") int idUser,
             @PathVariable int idMedia
             ) throws Exception {
         System.out.println(jwt);
         System.out.println(idUser);
         System.out.println(idMedia);
         return "{'result':'ok'}".replace('\'','\"');
     }
    @GetMapping(
            value="/dameProducto", 
            produces = "application/json; charset=utf-8")
    public ResultadoConsulta listaTotal(int id) {
        return this.productoService.getBigResult(id);
    }
    @GetMapping(
            value="/login", 
            produces = "application/json; charset=utf-8")
    public String fakeLogin(
            @RequestParam String user, 
            @RequestParam String password) {
        return loginService.login(user, password);
    }
    
    @GetMapping(
            value="/cambia", 
            produces = "application/json; charset=utf-8")
    public String fakeCambiaPassword(
            @RequestHeader String tokenDado,
            @RequestParam String nuevoPassword) {
        return loginService.cambia(tokenDado, nuevoPassword);
    }
    
    @GetMapping(
            value="/urls-imagenes-usuarios", 
            produces = "application/json; charset=utf-8")
    public List<String> urlsImagenesUsuariosController(
            @RequestBody List<Anuncio> anuncios) {
        return anuncios.stream().map(p -> this.invokeService.profileImage(p.getId())).collect(Collectors.toList());
    }
    
    @PostMapping(
            value = "/prueba",
            produces = "application/json; charset=utf-8")
    public JwtBody Pruebita(
            @RequestHeader("jwt") String jwt, 
            @RequestBody Persona ccr) {
        // pido ccr sólo para ejemplificar el uso del body
        return invokeService.checkJwt(jwt);
    }
    
    /**
     * Este metodo declara una variable de tipo double y la inicializa a cero.
     * Posteriormente, mediante un ciclo de 2000000-1 iteraciones, agrega a la
     * variable suma el valor de Math.pow(-1, n)/(2*n+1) y lo vuenve a agregar
     * a la variable suma.
     * 
     * Finalmente multiplica el valor de suma por 4 y lo imprime en pantalla.
     * 
     * @param argv este argumento no se usa.
     */
    public static void main(String...argv) {
        double suma = 0;
        for(int n=0; n<2000000; n++) {
            suma += Math.pow(-1, n)/(2*n+1);
        }
        suma  = 4*suma;
        System.out.println("----->"+suma);
    }// Imprime una aproximación de PI empleando la 
     // serie de Leibniz con 2000000-1 iteraciones
    
     // Calcula e imprime una aproximación de PI con 6 decimales de precisión 
}
