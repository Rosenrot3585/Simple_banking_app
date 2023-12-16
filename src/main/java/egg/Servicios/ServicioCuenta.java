package egg.Servicios;
import java.util.ArrayList;
import java.util.Scanner;

import egg.Entidades.Cuenta;

public class ServicioCuenta {
    
    public Cuenta crearCuenta(boolean admin, ArrayList<Cuenta> cuentas){
        Scanner scann = new Scanner(System.in);
        String usuario;
        if(admin){
            do {
                System.out.println("Ingrese el nombre de usuario");
            usuario = scann.next();
            if(usuarioExiste(cuentas, usuario)){
                System.out.println("El usuario ya existe");
            }
            } while (usuarioExiste(cuentas, usuario));
            System.out.println("Ingrese la contraseña");
            String password = scann.next();
            Cuenta cuenta = new Cuenta(usuario, password, false);
            return cuenta;
        }
        else{
            System.out.println("No tiene permisos para crear una cuenta");
            return null;
        }
    }
    public Cuenta crearAdmin(){
        Cuenta cuenta = new Cuenta("admin", "admin", true);
        return cuenta;
    }

    public void fabricaDeCuentas(ArrayList<Cuenta> cuentas, Cuenta cuentaLoggeada){
        cuentas.add(crearCuenta(cuentaLoggeada.isAdmin(), cuentas));
    
    }
    public void depositar(ArrayList<Cuenta> cuentas, String usuario, double monto){
        for (Cuenta cuenta : cuentas) {
            if(cuenta.getUsuario().equals(usuario)){
                cuenta.setBalance(cuenta.getBalance() + monto);
                System.out.println("Su nuevo saldo es de " + cuenta.getBalance());
            }
        }
    }
    public void consultarSaldo(ArrayList<Cuenta> cuentas, String usuario){
        for (Cuenta cuenta : cuentas) {
            if(cuenta.getUsuario().equals(usuario)){
                System.out.println("Su saldo es de " + cuenta.getBalance());
            }
        }
    }
    public void retirar(ArrayList<Cuenta> cuentas, String usuario, double monto){
        for (Cuenta cuenta : cuentas) {
            if(cuenta.getUsuario().equals(usuario)){
                if(cuenta.getBalance() >= monto){
                    cuenta.setBalance(cuenta.getBalance() - monto);
                    System.out.println("Su nuevo saldo es de " + cuenta.getBalance());
                }
                else{
                    System.out.println("No tiene saldo suficiente para realizar esta operación");
                }
            }
        }
    }
    public void transferir(ArrayList<Cuenta> cuentas, String usuario, String usuarioDestino, double monto){
        for (Cuenta cuenta : cuentas) {
            if(cuenta.getUsuario().equals(usuario)){
                if(cuenta.getBalance() >= monto){
                    cuenta.setBalance(cuenta.getBalance() - monto);
                    System.out.println("Su nuevo saldo es de " + cuenta.getBalance());
                }
                else{
                    System.out.println("No tiene saldo suficiente para realizar esta operación");
                }
            }
        }
        for (Cuenta cuenta : cuentas) {
            if(cuenta.getUsuario().equals(usuarioDestino)){
                cuenta.setBalance(cuenta.getBalance() + monto);
                System.out.println("Se ha transferido " + monto + " a la cuenta de " + usuarioDestino);
            }
        }
    }
    public boolean login(ArrayList<Cuenta> cuentas, String usuario, String password){
        for (Cuenta cuenta : cuentas) {
            if(cuenta.getUsuario().equals(usuario) && cuenta.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }
    public void mostrarCuentas(ArrayList<Cuenta> cuentas){
        for (Cuenta cuenta : cuentas) {
            System.out.println(cuenta.toString());
        }
    }
    public boolean usuarioExiste(ArrayList<Cuenta> cuentas, String usuario){
        for (Cuenta cuenta : cuentas) {
            if(cuenta.getUsuario().equals(usuario)){
                return true;
            }
        }
        return false;
    }

    public Cuenta cuentaActual(ArrayList<Cuenta> cuentas, String usuario){
        for (Cuenta cuenta : cuentas) {
            if(cuenta.getUsuario().equals(usuario)){
                return cuenta;
            }
        }
        return null;
    }
}
