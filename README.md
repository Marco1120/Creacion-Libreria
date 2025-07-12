### Integrantes del Equipo.
Jimenez Juarez Marco Anatonio
Gonzalez Valentin Adrian
Equipo 7

# VALIDACIOIN DE CONTRASEÑAS (Libreria).
Libreria en Java NetBeans para validar contraseñas

## Estructura General de la Clase
import java.util.regex.Pattern; public class Libreria { // Métodos de validación }

La clase utiliza la importación de java.util.regex.Pattern; para trabajar con expresiones regulares y todos los  métodos fueron declarados como públicos y estáticos para tener un uso más fácil.

### Método 1: validarContra(String contra, int Minimo)
public static boolean validarContra(String contra, int Minimo) { if (contra == null || contra.trim().isEmpty()) { return false; } return contra.length() == Minimo; }

Este método válida si una contraseña tiene exactamente la longitud dada, primero verifica que la contraseña no sea nula o vacía y luego compara la longitud con el valor minímo.

### Método 2: ValidarFuerza(String contra)
public static boolean ValidarFuerza(String contra) { if (contra == null) { return false; } String regex = "^[a-zA-Z0-9#-]+$"; return Pattern.matches(regex, contra); }

Este método utiliza expresiones regyulares para validar que la contraseña contenga únicamente letras (mayúsculas y minúsculas), números, el símbolo # y guiones. La expresión regular ^[a-zA-Z0-9#-]+$ asegura que toda la cadena este formada solo por estos carácteres.

### Método 3: VerificarContra(String VerificarContra, String contra)
public static boolean VerificarContra(String VerificaContra, String contra) { if (!contra.equals(VerificaContra)) { return false; } return true; }

Este método compara dos contraseñas para verificar que sean identicas y utiliza el método equals() que compara el contenido de las cadenas.

### Método 4: ValidarEspeciales(String contra)
public static boolean ValidarEspeciales(String contra) { if (contra == null) { return false; } String regex = "^[%&*+\\-=<>?/Ççáéíóúüë]+$"; return Pattern.matches(regex, contra); }

Este método valida que la contraseña tenga únicamente caracteres especiales definidos en la expresión regular e incluye símbolos como %, &, *, +, también como algunos caracteres acentuados.

### Método 5: validarContra Max(String contra)
public static boolean validarContraMax(String contra) { if (contra == null || contra.trim().isEmpty()) { return false; } return contra.length() <= 20; }

Este método valida que la contraseña no exceda los 20 caracteres de longitud, también incluye validación para que otros métodos paoder manejar casos nulos o vacíos.

### ════════════════════════════════════════════════════════════════

### Importacion de la libreria a un proyecto nuevo.
Para poder importar la libreria a un proyecto deseaso lo que debemos de hacer a continuacion es ir a la carpeta de "Libraries" de nuestro proyecto y darle click derecho y seleccionaremos
la opcion de "ADD JAR".
<img width="1920" height="1080" alt="Captura de pantalla (19)" src="https://github.com/user-attachments/assets/f137b607-d815-45c5-bfe1-a8cde06df925" />

despues de seleccionar la opcion antes mencionada lo que tendremos que hacer será seleccionar el archivo ".jar" de donde lo haya guardardado el usuario y ledará a listo y asi es como se 
importa la libreria del proyecto.
<img width="1920" height="1080" alt="Captura de pantalla (20)" src="https://github.com/user-attachments/assets/2fb543c3-0a59-4c41-8d71-01109bdeba39" />

### Clase Prueba
import javax.swing.JOptionPane;

import libreria.Libreria;

Importa a la clase JOptionPane para mostrar diálogos de mensaje y también importa la libreria personalizada llamada Libreria

### Constructor
public Login() {
initComponents();
setTitle("Login");
}
Llama a initComponents() para inicializar todos los elementos gráficos y establece el título de la ventana como "Login"

### Método btnIngresarActionPerformed
private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {

El método que se ejecuta cuando el usuario hace clic en el botón "Ingresar". Recibe un evento ActionEvent como parámetro.

String correo;
 
String Contra;

String ConfirmarContra;

 Declara tres variables String para almacenar: correo: el email ingresado por el usuario, Contra: la contraseña ingresada, ConfirmarContra: la confirmación de contraseña

### Obtención de Datos de los campos
correo = txtCorreo.getText();

Obtiene el texto ingresado en el campo de correo electrónico y lo asigna a la variable "correo".

Contra = pswContraseña.getText();

Obtiene el texto del campo de contraseña usando getText().

ConfirmarContra = new String(txtConfirmarContra.getPassword());

Obtiene la contraseña de confirmación usando getPassword() (método correcto) y la convierte a String.
<img width="1920" height="1080" alt="Captura de pantalla (21)" src="https://github.com/user-attachments/assets/c6814224-f4cf-426c-86d0-0e8945a6a927" />


### Verificación de correo y contraseña
if (correo.equals("marcojimenezjuarez@gmail.com") && Contra.equals("Marco#1234")) {

Verifica si las credenciales coinciden con valores hardcoded:

Correo: "marcojimenezjuarez@gmail.com"

Contraseña: "Marco#1234"

JOptionPane.showMessageDialog(null, "Inicio de sesión correcto", "Correcto", JOptionPane.INFORMATION_MESSAGE);

Muestra mensaje de éxito si las credenciales son correctas.

<img width="1920" height="1080" alt="Captura de pantalla (22)" src="https://github.com/user-attachments/assets/f6fd7882-3703-420b-8a8a-e4849011678f" />

PanelControl ventana2 = new PanelControl();
ventana2.setVisible(true);
 this.dispose();
 
Si las credenciales son correctas:

Crea una nueva instancia de PanelControl

Hace visible la nueva ventana

Cierra la ventana actual con dispose()

<img width="1920" height="1080" alt="Captura de pantalla (23)" src="https://github.com/user-attachments/assets/6f9ec046-01a7-491f-8960-10162e1b0dec" />

} else {
JOptionPane.showMessageDialog(null, "El correo o contraseña es incorrecto, verifique", "Aviso", JOptionPane.ERROR_MESSAGE);
 }
 Si las credenciales son incorrectas, muestra un mensaje de error.

 <img width="1920" height="1080" alt="Captura de pantalla (24)" src="https://github.com/user-attachments/assets/0146c08a-7771-49f0-b8e1-9590d207d8e6" />

### Validaciones de seguridad
if (!Libreria.validarContra(Contra, 6)) {
JOptionPane.showMessageDialog(this, "La contraseña debe tener al menos 6 caracteres.");
return;
}

Valida que la contraseña tenga al menos 6 caracteres usando un método de la librería externa.

<img width="1920" height="1080" alt="Captura de pantalla (25)" src="https://github.com/user-attachments/assets/d8b6fd48-4c7f-42bf-852f-ae2eba724998" />

if (!Libreria.ValidarFuerza(Contra)) {
JOptionPane.showMessageDialog(this, "La contraseña no cumple con los requisitos de fuerza.");
return;
}

Valida la fuerza de la contraseña (probablemente verifica mayúsculas, minúsculas, números).

<img width="1920" height="1080" alt="Captura de pantalla (26)" src="https://github.com/user-attachments/assets/8794e6f4-9cb8-4d59-86fb-8c8d4a632092" />

if (!Libreria.VerificarContra(ConfirmarContra, Contra)) {
JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden.");
return;
}

 Verifica que la contraseña y su confirmación coincidan.

 <img width="1920" height="1080" alt="Captura de pantalla (27)" src="https://github.com/user-attachments/assets/6e4db3ca-9101-41af-ae71-31253de40be0" />

if (!Libreria.ValidarEspeciales(Contra)) {
JOptionPane.showMessageDialog(this, "La contraseña no debe incluir carácteres especiales.");
return;
}
 Valida que la contraseña incluya al menos un carácter especial.

if (!Libreria.validarContraMax(Contra)) {
JOptionPane.showMessageDialog(this, "La contraseña debe tener exactamente 20 caracteres.");
return;
}

Valida que la contraseña tenga exactamente 20 caracteres.

<img width="1920" height="1080" alt="Captura de pantalla (29)" src="https://github.com/user-attachments/assets/491ff00e-3ffd-48da-8559-fa115d0e27d9" />

### Validacionesde campos vacios
if (correo.isEmpty() && Contra.isEmpty()) {
JOptionPane.showMessageDialog(null, "Ingrese su correo y contrseña", "Aviso", JOptionPane.ERROR_MESSAGE);
return;
 }

 Vuelve a verificar si ambos campos están vacios.
 
<img width="1920" height="1080" alt="Captura de pantalla (28)" src="https://github.com/user-attachments/assets/1be0711e-9241-4e19-90f3-67eeb7ed98ee" />

### ════════════════════════════════════════════════════════════════
### Video en YouTube
https://youtu.be/GSNHKqrJSlk?si=IyUk6528qIAoinJn
