package ClasesBancarias; 
import java.util.ArrayList;

public class Cliente {
    private String cedula;
    private String nombre;
    private String correo;
    private String telefono;
    private String direccion;
    private ArrayList<CuentaAhorro> cuentas;

    public Cliente() {
        this.cedula = "";
        this.nombre = "";
        this.correo = "";
        this.telefono = "";
        this.direccion = "";
        this.cuentas = new ArrayList<>();
    }

    public Cliente(String cedula, String nombre, String correo, String telefono, String direccion) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.cuentas = new ArrayList<>();
    }

    public String getCedula() { return cedula; }
    public void setCedula(String cedula) { this.cedula = cedula; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public ArrayList<CuentaAhorro> getCuentas() { return cuentas; }
    public void setCuentas(ArrayList<CuentaAhorro> cuentas) { this.cuentas = cuentas; }

    public void agregarCuenta(CuentaAhorro cuenta) {
        this.cuentas.add(cuenta);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Cliente)) return false;
        Cliente otro = (Cliente) obj;
        return this.cedula.equals(otro.cedula);
    }

    @Override
    public String toString() {
        return "Cliente:\n" +
               "Cedula: " + cedula + "\n" +
               "Nombre: " + nombre + "\n" +
               "Correo: " + correo + "\n" +
               "Telefono: " + telefono + "\n" +
               "Direccion: " + direccion + "\n";
    }
}
