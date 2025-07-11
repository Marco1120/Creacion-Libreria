/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package libreria;
import java.util.regex.Pattern;

/**
 * Clase Libreria que contiene métodos para validar contraseñas
 */
public class Libreria {
    
    /**
     * Valida que una contraseña tenga al menos la longitud mínima que quiera el diseñador
     * Este método es útil para asegurar que las contraseñas cumplan con un requisito básico de longitud
     * 
     * @param contra La contraseña a validar (String)
     * @param Minimo La longitud mínima requerida (int)
     * @return true si la contraseña cumple con la longitud mínima, false en caso contrario
     * @throws NullPointerException si contra es null (manejado internamente)
     */
    public static boolean validarContra(String contra, int Minimo) {
        // Verificar si la contraseña es null o está vacía después de quitar espacios
        if (contra == null || contra.trim().isEmpty()) {
            return false;
        }
        // Retornar true si la longitud igual al mínimo
        return contra.length() == Minimo;
    }
    
    /**
     * Valida que una contraseña contenga solo caracteres alfanuméricos y algunos especiales permitidos
     * Permite letras (a-z, A-Z), números (0-9), guiones (-) y símbolos de gato (#)
     * 
     * @param contra La contraseña a validar (String)
     * @return true si la contraseña contiene solo caracteres válidos, false en caso contrario
     * @see Pattern#matches(String, CharSequence)
     */
    public static boolean ValidarFuerza(String contra) {
        // Verificar si la contraseña es null
        if (contra == null) {
            return false;
        }
        // Expresión regular corregida para validar caracteres permitidos
        // Solo permite letras, números, guiones y símbolos de gato
        String regex = "^[a-zA-Z0-9#-]+$";
        return Pattern.matches(regex, contra);
    }
    
    /**
     * Verifica que dos contraseñas sean idénticas
     * Este método es útil para confirmar que el usuario escribió
     * correctamente su contraseña en campos de confirmación
     * 
     * @param VerificaContra La contraseña de confirmación (String)
     * @param contra La contraseña original (String)
     * @return true si ambas contraseñas son iguales, false en caso contrario
     */
    public static boolean VerificarContra(String VerificaContra, String contra) {
        // Comparar las dos contraseñas usando equals()
        if (!contra.equals(VerificaContra)) {
            return false;
        }
        return true;
    }
    
    /**
     * Valida que una contraseña contenga caracteres especiales específicos
     * Permite símbolos especiales y caracteres con acentos par que las contraseñas no cuenten con estos
     * 
     * @param contra La contraseña a validar (String)
     * @return true si la contraseña contiene caracteres especiales válidos, false en caso contrario
     */
    public static boolean ValidarEspeciales(String contra) {
        // Verificar si la contraseña es null
        if (contra == null) {
            return false;
        }
        // Expresión utilizada para validar caracteres especiales
        // Permite símbolos especiales y caracteres acentuados
        String regex = "^[%&*+\\-=<>?/Ççáéíóúüë]+$";
        return Pattern.matches(regex, contra);
    }
    
    /**
     * Valida que una contraseña tenga menor o igual a 20 caracteres
     * Este método asegura que la contraseña no exceda una longitud máxima
     * 
     * @param contra La contraseña a validar (String)
     * @return true si la contraseña tiene menor o igual a 20 caracteres, false en caso contrario
     * @throws NullPointerException si contra es null (manejado internamente)
     */
    public static boolean validarContraMax(String contra) {
        // Verificar si la contraseña es null o está vacía después de quitar espacios
        if (contra == null || contra.trim().isEmpty()) {
            return false;
        }
        // Retornar true si la longitud es menor o igual a 20
        return contra.length() <= 20;
    }
}