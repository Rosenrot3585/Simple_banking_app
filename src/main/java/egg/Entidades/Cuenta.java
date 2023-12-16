package egg.Entidades;

public class Cuenta {
    private String usuario;
    private String password;
    private double balance;
    private boolean admin;

    public Cuenta(String usuario, String password, boolean admin) {
        this.usuario = usuario;
        this.password = password;
        this.balance = 0;
        this.admin = admin;
    }

    public Cuenta() {
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "Cuenta [Usuario:" + usuario + ", Password:" + password + ", Saldo:" + balance + ", Administrador:" + admin
                + "]";
    }
    
    
}
