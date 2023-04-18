package com.example.helloworld.productos;

import java.util.Base64;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.helloworld.utilerias.Digestion;
import com.fasterxml.jackson.databind.ObjectMapper;

@Primary
@Service
public class LoginServiceImpl implements LoginService {

    @Override
    public String login(String user, String password) {
        if (consultaBaseDeDatos(user, password)) {
            
            long momentoDeEmision = System.currentTimeMillis();
            String payload = "{'user':'"+user+"', 'exp':'"+momentoDeEmision+"', 'rol':'admin', 'pago':true}";
            String cadenota = base64encode(payload.replace('\'','\"'));
            return cadenota + "_" + Digestion.generateMd5(cadenota);
        }
        return "{'error':'bad pasword or user'}";
    }
    public String cambia(String tokenDado, String nuevoPassword) {
        int resultados;
        try {
            resultados = revisa(tokenDado);
        } catch (Exception e) {
            return "{cadena invalida}";
        }
            if(resultados == 1) return "{formato incorrecto}";
            if(resultados == 2) return "{el token no coincide}";
            if(resultados == 3) return "{token expirado}"; 
            return "{contraseña cambiada con exito}";
    }
    private int revisa(String tokenDado) throws Exception {
        // primer validación
        String[] arreglo = tokenDado.split("_");
        if(arreglo.length!=2) return 1;

        String base64DeCadenaOriginal = arreglo[0];
        String hash = arreglo[1];

        // segunda validacion
        String digestion = Digestion.generateMd5(base64DeCadenaOriginal);
        if(!hash.equals(digestion)) return 2;

        String cadenaOriginal = base64decode(base64DeCadenaOriginal);
         ObjectMapper mapper = new ObjectMapper();
         Contenido contenido = mapper.readValue(cadenaOriginal, Contenido.class);
        long tolerancia = 1000*60*(long)2;
        long currentDate = System.currentTimeMillis();
        long diff = currentDate-contenido.getExp();
        if(tolerancia < diff) return 3;

        return 4;
    }

    
    public static String base64decode(String source) {
        return new String(Base64.getUrlDecoder().decode(source.getBytes()));
    }
    public static String base64encode(String source) {
        return new String(Base64.getUrlEncoder().encode(source.getBytes())).replace("=", "");
    }
    private boolean consultaBaseDeDatos(String user, String pass) {
        if(user.equals("gus") && pass.equals("tavo")) return true;
        if(user.equals("gus1") && pass.equals("tavo1")) return true;
        if(user.equals("gus_1") && pass.equals("tavo_1")) return true;
        if(user.equals("gus:1") && pass.equals("tavo:1")) return true;
        if(user.equals("gustavo") && pass.equals("tavo@")) return true;
        if(user.equals("adolfo") && pass.equals("secreto")) return true;
        if(user.equals("arell") && pass.equals("torres")) return true;
        return false;
    }
}