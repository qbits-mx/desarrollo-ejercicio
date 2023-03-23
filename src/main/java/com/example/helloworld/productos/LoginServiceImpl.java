package com.example.helloworld.productos;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.helloworld.utilerias.Digestion;

@Primary
@Service

public class LoginServiceImpl implements LoginService{
    private String passN;

    public String login(String user, String password) {
        if (consultaBaseDeDatos(user, password)) {
            // numero de milisegundos transcurridos desde el 1 de enero de 1970 hasta el milisegundo actual
            long momentoDeEmision = System.currentTimeMillis();
            String cadenota = base64encode("{'user':'"+user+"', 'exp':'"+momentoDeEmision+"', 'rol':'admin', 'pago':true}");
            return cadenota + "_" + Digestion.generateMd5(cadenota);
        }
        return "{'error':'bad pasword or user'}";
    }

    public List<String> cambia(String tokenDado, String nuevoPassword) {
        this.setPassN(nuevoPassword);
        return revisa(tokenDado);
    }
    
    private List<String> revisa(String tokenDado) {
        int[] errores = new int[6];//[0,0,0,0,0,0]
        // primer validación
        String[] arreglo = tokenDado.split("_");
        if(arreglo.length!=2) {
            errores[0] = 1;
        };
        
        String base64DeCadenaOriginal = arreglo[0];
        String hash = arreglo[1];
        
        // segunda validacion
        String digestion = Digestion.generateMd5(base64DeCadenaOriginal);
        if(!hash.equals(digestion)) {
            errores[1] = 1;
        };
        
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

        // tercer validacion
        long diff = currentDate-mili;
        long diff2 = 7200000;
        if(tolerancia < diff) {
            errores[2] = 1;
        };
        // cuarta validacion
        if(diff > diff2) {
            errores[3] = 1;
        };
        // quita validacion
        String rol = partesJson[2].substring(8, partesJson[2].length()-1);
        if(rol.equals("admin") == false) {
            errores[4] = 1;
        }
        String pago = partesJson[3].substring(8, partesJson[3].length()-1);
        // sexta validacion
        if (pago.equals("true") == false) {
            errores[5] = 1;
        }
        for (int i = 0; i < errores.length; i++) { //for loop to print the array  
            System.out.print( errores[i]+ " ");     
            }

        return cadenaDeErrores(errores);
    }
    
    private List<String> cadenaDeErrores(int[] arrErrores) {
        String passN2 = getPassN();
        int interna = 0;
        String[] arr = {"'error':'La cadena tiene 2 o mas guines bajos'", 
                "'error':'El MD5 no coincide'", 
                "'error':'El token ya caduco'",
                "'error':'El token es muy viejo'",
                "'error':'No eres administrador'",
                "'error':'El pago de tu token esta vencido'",
                "'exito':'Password cambiado "+passN2+"'"
                };
        List<String> out = new ArrayList<>();
        for (int i = 0; i < arrErrores.length; i++) {
            if (arrErrores[i] == 1) {
                out.add(arr[i]);
                interna++;
            }
        }
        if (interna == 0) {
            out.add(arr[6]);
        }
        System.out.println(out);
        return out;
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

    private String getPassN() {
        return passN;
    }

    private void setPassN(String passN) {
        this.passN = passN;
    }

}
