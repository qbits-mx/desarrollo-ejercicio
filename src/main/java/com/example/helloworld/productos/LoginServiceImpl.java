package com.example.helloworld.productos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.helloworld.utilerias.Digestion;

@Primary
@Service
public class LoginServiceImpl implements LoginService {

    @Override
    public String login(String user, String password) {
        if (consultaBaseDeDatos(user, password)) {
            // numero de milisegundos transcurridos desde el 1 de enero de 1970 hasta el milisegundo actual
            long momentoDeEmision = System.currentTimeMillis();
            String cadenota = base64encode("{'user':'"+user+"', 'exp':'"+momentoDeEmision+"', 'rol':'admin', 'pago':true}");
            return cadenota + "_" + Digestion.generateMd5(cadenota);
        }
        return "{'error':'bad pasword or user'}";
    }

    @Override
    public String cambia(String tokenDado, String nuevoPassword) {
        if(revisa(tokenDado)) {
            // enteoría aqui se manda llamar al update del password dado.
            return "{'exito':'password cambiado por " + nuevoPassword + "'}";
        }
        return "{'error':'bad token'}";
    }
    
    
    private boolean revisa(String tokenDado) {
        // primer validación
        String[] arreglo = tokenDado.split("_");
        if(arreglo.length!=2) return false;
        
        String base64DeCadenaOriginal = arreglo[0];
        String hash = arreglo[1];
        
        // segunda validacion
        String digestion = Digestion.generateMd5(base64DeCadenaOriginal);
        if(!hash.equals(digestion)) return false;
        
        String cadenaOriginal = base64decode(base64DeCadenaOriginal);
        String[] partesJson = cadenaOriginal.split(",");
        // {'user':'gus_1',  'exp':'1679509695186',  'rol':'admin',  'pago':true}
        
        // {'user':'gus_1'
        //  'exp':'1679509695186' 
        //  'rol':'admin'
        //  'pago':true}
        String milisegundos = partesJson[1].substring(8, partesJson[1].length()-1);
        
        long mili = Long.parseLong(milisegundos);
        long tolerancia = 1000*60*2;
        long currentDate = System.currentTimeMillis();

        // tercer y última validación
        long diff = currentDate-mili;
        if(tolerancia < diff) return false;

        return true;
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
