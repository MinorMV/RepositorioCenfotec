package ClasesBancarias; 
public class CuentaAhorro {
    private String numeroCuenta;
    private double saldo;
    private String fechaCreacion;
    private boolean estado;
    private Cliente cliente;

    public CuentaAhorro() {
        this.numeroCuenta = "";
        this.saldo = 0.0;
        this.fechaCreacion = "";
        this.estado = true; 
        this.cliente = null;
    }

    public CuentaAhorro(String numeroCuenta, double saldo, String fechaCreacion, boolean estado, Cliente cliente) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.fechaCreacion = fechaCreacion;
        this.estado = estado;
        this.cliente = cliente;
    }

    public String getNumeroCuenta() { return numeroCuenta; }
    public void setNumeroCuenta(String numeroCuenta) { this.numeroCuenta = numeroCuenta; }

    public double getSaldo() { return saldo; }
    public void setSaldo(double saldo) { this.saldo = saldo; }

    public String getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(String fechaCreacion) { this.fechaCreacion = fechaCreacion; }

    public boolean isEstado() { return estado; }
    public void setEstado(boolean estado) { this.estado = estado; }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof CuentaAhorro)) return false;
        CuentaAhorro otra = (CuentaAhorro) obj;
        return this.numeroCuenta.equals(otra.numeroCuenta);
    }

    @Override
    public String toString() {
        return "Cuenta de Ahorro:\n" +
               "Numero de cuenta: " + numeroCuenta + "\n" +
               "Saldo: " + saldo + "\n" +
               "Fecha de creacion: " + fechaCreacion + "\n" +
               "Estado: " + (estado ? "Activa" : "Inactiva") + "\n" +
               "Cliente: " + (cliente != null ? cliente.getNombre() : "No asignado") + "\n";
    }
}
