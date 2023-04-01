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
            String payload = "{'exp':'"+momentoDeEmision+"', 'user':'"+user+"', 'pago':true, 'rol':'admin'}";
            String cadenota = base64encode(payload.replace('\'', '\"'));
            return cadenota + "_" + Digestion.generateMd5(cadenota);
        }
        return "{'error':'bad pasword or user'}";
    }

    @Override
    public String cambia(String tokenDado, String nuevoPassword) {
        try {
            int revisado = revisa(tokenDado);
            switch (revisado) {
                case 1: return "{'error':'cadena inválida 1'}";
                case 2: return "{'error':'cadena inválida 2'}";
                case 3:return "{'error':'cadena inválida 3'}";
                default: return "{'exito':'password cambiado por " + nuevoPassword + "'}";
            }
        } catch (Exception e) {
            return "{'error':'cadena inválida'}";
        }
    }
    
    private int revisa(String tokenDado) throws Exception {
        String[] arreglo = tokenDado.split("_");
        if(arreglo.length!=2) return 1;
        
        String base64DeCadenaOriginal = arreglo[0];
        String hash = arreglo[1];
        
        String digestion = Digestion.generateMd5(base64DeCadenaOriginal);
        if(!hash.equals(digestion)) return 2;
        
        String cadenaOriginal = base64decode(base64DeCadenaOriginal);
        ObjectMapper mapper = new ObjectMapper();
        Contenido contenido = mapper.readValue(cadenaOriginal, Contenido.class);
        long op = 1000 * 2;
        long minutos = 60;
        long tolerancia = op*minutos;
        long currentDate = System.currentTimeMillis();

        long diff = currentDate-contenido.getExp();
        if(tolerancia < diff) return 3;
        return 0;
    }
    
    public static String base64decode(String source) {
        return new String(Base64.getUrlDecoder().decode(source.getBytes()));
    }
    public static String base64encode(String source) {
        return new String(Base64.getUrlEncoder().encode(source.getBytes())).replace("=", "");
    }
    private boolean consultaBaseDeDatos(String user, String password) {
        if(user.equals("gus") && password.equals("tavo")) return true;
        if(user.equals("gus1") && password.equals("tavo1")) return true;
        if(user.equals("gus_1") && password.equals("tavo_1")) return true;
        if(user.equals("gus:1") && password.equals("tavo:1")) return true;
        if(user.equals("gustavo") && password.equals("tavo@")) return true;
        if(user.equals("adolfo") && password.equals("secreto")) return true;
        if(user.equals("arell") && password.equals("torres")) return true;
      else return false;
    }
}
