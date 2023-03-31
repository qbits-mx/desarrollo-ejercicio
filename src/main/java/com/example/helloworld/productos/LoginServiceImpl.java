package com.example.helloworld.productos;

import java.util.Base64;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.helloworld.utileria.Digestion;
import com.fasterxml.jackson.databind.ObjectMapper;

@Primary
@Service
public class LoginServiceImpl implements LoginService {

    @Override
    public String login(String user, String password) {
        if (consultaBaseDeDatos(user, password)) {
            // numero de milisegundos transcurridos desde el 1 de enero de 1970 hasta el milisegundo actual
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
                case 1: return "{'error':'caracteres de mas '}";
                case 2: return "{'error':'Hacen falta mas datos'}";
                case 3: return "{'error':'Token expirado'}";
            }
            return "{'exito':'password cambiado por " + nuevoPassword + "'}";
        } catch (Exception e) {
            return "{'error':'cadena inválida'}";
        }
    }
    
    private int revisa(String tokenDado) throws Exception {
        // primera validación (len==2 implica que hay cosas antes y después del _ )
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
        
        long tolerancia = 1000*60*2;
        long currentDate = System.currentTimeMillis();

        // tercer y última validación
        long diff = currentDate-contenido.getExp();
        if(tolerancia < diff) return 3;

        return 0;
    }
    
    public static String base64decode(String source) {
        return new String(Base64.getUrlDecoder().decode(source.getBytes()));
    }
    public static String base64encode(String source) {
        return new String(Base64.getUrlEncoder().encode(source.getBytes())).replaceAll("=", "");
    }
    private boolean consultaBaseDeDatos(String user, String password) {
        if(user.equals("gus") && password.equals("tavo")) return true;
        if(user.equals("gus1") && password.equals("tavo1")) return true;
        if(user.equals("gus_1") && password.equals("tavo_1")) return true;
        if(user.equals("gus:1") && password.equals("tavo:1")) return true;
        if(user.equals("gustavo") && password.equals("tavo@")) return true;
        if(user.equals("adolfo") && password.equals("secreto")) return true;
        if(user.equals("arell") && password.equals("torres")) return true;
        return false;
    }
}