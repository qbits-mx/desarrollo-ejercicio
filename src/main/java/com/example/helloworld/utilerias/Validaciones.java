package com.example.helloworld.utilerias;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;


public class Validaciones {
    
    public static boolean validarToken(String token) {
        try {
            String[] arreglo = token.split("_");
            String cadenaOriginal = arreglo[0];
            String hash = arreglo[1];
            String[] arreglo2 = arreglo[0].split(" ");
            String arreglo3 = (arreglo2[1].substring(7)+" "+arreglo2[2].replace("',", "")); //bug de posiciones del guion extra : condicionar accion con la validacion de guion
            String digestion = Digestion.generateMd5(cadenaOriginal);
            boolean result1 = digestion.equals(hash);// valida que no existan cambios en la informacion
            boolean result2 = validacionFecha(arreglo3);// validacion de fecha y hora
            boolean result3 = validacionGuion(arreglo);// validacion de existencia de guion
            boolean result4 = validacionDeFormato(token);// validacion de formato xxxx_xxxxxx
            if (result1&&result2&&result3&&result4) {//validacion de que se cumplan las 4 condiciones de validacion
                System.out.println("token valido");
                return true;
            }else {
                System.out.println("token invalido");
                return false;
            }
        } catch (Exception e) {
            System.out.println("token malo");
            return false;
        }
    }
    
    private static boolean validacionFecha(String fechaValidar) {
        Date d = new Date(); //resultado de la cadena: Tue Mar 21 13:03:03 CST 2023
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strDate = dateFormat.format(d); //strDate es la fhecha y hora en cadena de texto 2023-32-21 02:32:01
        int result = strDate.compareTo(fechaValidar);
        return result  <= 0 ? true : false;
    }
    private static boolean validacionGuion(String[] tokenDado) { // valida que solo exista un guion en toda la cadena
        return tokenDado.length == 2;
    }
    
    private static boolean validacionDeFormato(String tokenDado2) { // valida el formato xxxx_xxxxx
        int resultA = tokenDado2.indexOf("_");
        if ((resultA != 0)&&(resultA != tokenDado2.length())) {
            return true;
        }
        return false;
    }
    
    public String base64decode(String source) {
        return new String(Base64.getUrlDecoder().decode(source.getBytes()));
    }
    public String base64encode(String source) {
        String res = new String(Base64.getUrlEncoder().encode(source.getBytes()));
        return res.replaceAll("=", "");
    }
    
    /*public static void main(String...argv) {
        validarToken("{'user':'gus', 'exp':'2023-03-22 14:01:37', 'rol':'admin', 'pago':'true'}_595f678fbd766546425b862171b8dc88");
    }*/
}
