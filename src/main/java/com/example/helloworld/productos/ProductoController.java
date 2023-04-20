//package com.example.helloworld.productos;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Base64;
//import java.util.Date;
//import java.util.regex.Pattern;
//import java.util.regex.Matcher;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestHeader;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.helloworld.productos.model.ResultadoConsulta;
//import com.example.helloworld.utilerias.Digestion;
//
//@RestController
//@RequestMapping(value="/hola")
//public class ProductoController {
//    private ProductoService productoService;
//    private LoginService loginService;
//    
//    public ProductoController(ProductoService productoService, LoginService loginService) {
//        this.productoService = productoService;
//        this.loginService = loginService;
//    }
//    
//    @GetMapping(
//            value="/dameProducto", 
//            produces = "application/json; charset=utf-8")
//    public ResultadoConsulta listaTotal(int id) {
//        return this.productoService.getBigResult(id);
//    }
//    @GetMapping(
//            value="/login", 
//            produces = "application/json; charset=utf-8")
//    public String fakeLogin(
//            @RequestParam String user, 
//            @RequestParam String password) {
//        return loginService.login(user, password);
//    }
//    
//    @GetMapping(
//            value="/cambia", 
//            produces = "application/json; charset=utf-8")
//    public String fakeCambiaPassword(
//            @RequestHeader String tokenDado,
//            @RequestParam String nuevoPassword) {
//        return loginService.cambia(tokenDado, nuevoPassword);
//    }
//
//
//    
////    public static void main(String...argv) {
////        String q1 = "gustavo@_hola 123:456  .;-ñ";
////        String q2="{'user':'gus_plus', 'exp':'2023-03-22 14:17:01'}";
////        String enc = base64encode(q2);
////        System.out.println(enc);
////        
////        String dec = base64decode(enc);
////        System.out.println(dec);
////    }
//}
