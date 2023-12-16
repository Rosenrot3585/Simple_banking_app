package egg;

import java.util.ArrayList;
import java.util.Scanner;

import egg.Entidades.Cuenta;
import egg.Servicios.ServicioCuenta;

/**
 * Hello world!
 *
 * Practice
 * 
 * Create a Java – Maven application for banking, in which a bank contains
 * multiple user accounts. Each account has a user and a password to log in and
 * a balance, which should be $0 at the creation of the account.
 * 
 * The application should have the following features:
 * 
 * The app should start with a login and there should be an admin user (it may
 * be hard-coded) that can add new user accounts (but not admin accounts)
 * 
 * The user accounts should be able to deposit, withdraw, or transfer money to
 * another account.
 * 
 * When withdrawing or transferring money, the application should verify if the
 * respective account has enough funds to make the transaction.
 * 
 * Each transaction, successful or failed, should print a message to the user
 * indicating the result.
 * 
 * The interactions with the user should be done via command line.
 * 
 * Use Lombok dependency for managing getters and setters
 * 
 * Use JUnit dependency to develop unit tests for the withdrawing, transferring
 * and depositing methods
 * 
 * Lastly, configure the project to execute the unit tests right after the
 * building stage.
 * 
 * 
 */
public class Banco {

    public static void main(String[] args) {
    try (Scanner scann = new Scanner(System.in)) {
        Cuenta admin;
        ArrayList<Cuenta> cuentas= new ArrayList<>();
        ServicioCuenta sCuenta = new ServicioCuenta();

        Cuenta cuentaLoggeada;
        
        admin = sCuenta.crearAdmin();

            boolean cerrarSesion = false;
            System.out.println("\t===============================================");
            System.out.println("Bienvenido al banco SimpleBanking");
            System.out.println("\t===============================================");
            System.out.println("Por favor completa los campos a continuación para operar");
            System.out.println("Ingrese su usuario");
            String usuario = scann.next();
            System.out.println("Ingrese su contraseña");
            String password = scann.next();
            if(usuario.equals("admin") && password.equals("admin")){
                do{
                    System.out.println("Ha iniciado sesión como administrador");
                    System.out.println("¿Qué desea hacer?");
                    System.out.println("1. Crear una cuenta");
                    System.out.println("2. Salir");
                    int opcion = scann.nextInt();
                    switch (opcion) {
                        case 1:
                            sCuenta.fabricaDeCuentas(cuentas, admin);
                            break;
                        case 2:
                            System.out.println("Gracias por utilizar nuestros servicios");
                            cerrarSesion = true;
                            break;
                        default:
                            System.out.println("Opción inválida");
                            break;
                    }
                } while (!cerrarSesion);
            }
            else {
                if (sCuenta.login(cuentas, usuario, password)) {
                    cuentaLoggeada = sCuenta.cuentaActual(cuentas, usuario);
                    do  {
                    System.out.println("Bienvenido " + cuentaLoggeada.getUsuario());
                    System.out.println("Su saldo es de " + cuentaLoggeada.getBalance());
                    System.out.println("¿Qué desea hacer?");
                    System.out.println("1. Depositar");
                    System.out.println("2. Retirar");
                    System.out.println("3. Transferir");
                    System.out.println("4. Salir");
                    int opcion = scann.nextInt();
                    switch (opcion) {
                        case 1:
                            System.out.println("Ingrese el monto a depositar");
                            double monto = scann.nextDouble();
                            sCuenta.depositar(cuentas, usuario, monto);
                            break;
                        case 2:
                            System.out.println("Ingrese el monto a retirar");
                            double montoRetiro = scann.nextDouble();
                            sCuenta.retirar(cuentas, usuario, montoRetiro);
                            break;
                        case 3:
                            System.out.println("Ingrese el monto a transferir");
                            double montoTransferencia = scann.nextDouble();
                            System.out.println("Ingrese el usuario a transferir");
                            String usuarioTransferencia = scann.next();
                            sCuenta.transferir(cuentas, usuario, usuarioTransferencia, montoTransferencia);
                            break;
                        case 4:
                            System.out.println("Gracias por utilizar nuestros servicios");
                            cerrarSesion = false;
                            break;
                        default:
                            System.out.println("Opción inválida");
                            break;
                    }
                    } while (!cerrarSesion);
                }
                else {
                    System.out.println("Usuario o contraseña incorrectos");
                }
            }

    }
}
}