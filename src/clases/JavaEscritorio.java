package clases;

import formularios.frmLogin;

public class JavaEscritorio {

    public static void main(String[] args) {
        //creo el objeto datos
        Datos misDatos= new Datos();

        //Llamamos al formulario de login
        frmLogin miLogin = new frmLogin();
        miLogin.setDatos(misDatos);
        miLogin.setLocationRelativeTo(null);
        miLogin.loadTheme();
        miLogin.setVisible(true);
    }

}
