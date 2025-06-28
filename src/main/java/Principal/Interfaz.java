package Principal;

import java.util.ArrayList;
import java.util.Scanner;
import ClasesBancarias.Cliente;
import ClasesBancarias.CuentaAhorro;

public class Interfaz {
    private final Scanner sc = new Scanner(System.in);
    private final ArrayList<Cliente> clientes = new ArrayList<>();

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n--- Menu Principal ---");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Registrar cuenta de ahorro");
            System.out.println("3. Listar clientes");
            System.out.println("4. Listar cuentas de un cliente");
            System.out.println("5. Modificar cliente");
            System.out.println("6. Eliminar cliente");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> registrarCliente();
                case 2 -> registrarCuenta();
                case 3 -> listarClientes();
                case 4 -> listarCuentas();
                case 5 -> modificarCliente();
                case 6 -> eliminarCliente();
                case 7 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opcion invalida.");
            }
        } while (opcion != 7);
    }

    private void registrarCliente() {
        System.out.print("Cedula: ");
        String cedula = sc.nextLine();
        if (buscarCliente(cedula) != null) {
            System.out.println("Ya existe un cliente con esa cedula.");
            return;
        }

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Correo: ");
        String correo = sc.nextLine();
        System.out.print("Telefono: ");
        String telefono = sc.nextLine();
        System.out.print("Direccion: ");
        String direccion = sc.nextLine();

        Cliente nuevo = new Cliente(cedula, nombre, correo, telefono, direccion);
        clientes.add(nuevo);
        System.out.println("Cliente registrado con exito.");
    }

    private void registrarCuenta() {
        System.out.print("Cedula del cliente: ");
        String cedula = sc.nextLine();
        Cliente cliente = buscarCliente(cedula);
        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        System.out.print("Numero de cuenta: ");
        String numCuenta = sc.nextLine();
        if (buscarCuenta(cliente, numCuenta) != null) {
            System.out.println("Ya existe una cuenta con ese numero para este cliente.");
            return;
        }

        System.out.print("Saldo inicial: ");
        double saldo = sc.nextDouble();
        sc.nextLine();
        System.out.print("Fecha de creacion: ");
        String fecha = sc.nextLine();

        CuentaAhorro cuenta = new CuentaAhorro(numCuenta, saldo, fecha, true, cliente);
        cliente.agregarCuenta(cuenta);
        System.out.println("Cuenta creada correctamente.");
    }

    private void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
        } else {
            for (Cliente c : clientes) {
                System.out.println(c.toString());
            }
        }
    }

    private void listarCuentas() {
        System.out.print("Cedula del cliente: ");
        String cedula = sc.nextLine();
        Cliente cliente = buscarCliente(cedula);
        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
        } else {
            ArrayList<CuentaAhorro> cuentas = cliente.getCuentas();
            if (cuentas.isEmpty()) {
                System.out.println("El cliente no tiene cuentas registradas.");
            } else {
                for (CuentaAhorro ca : cuentas) {
                    System.out.println(ca.toString());
                }
            }
        }
    }

    private void modificarCliente() {
        System.out.print("Cedula del cliente a modificar: ");
        String cedula = sc.nextLine();
        Cliente cliente = buscarCliente(cedula);
        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        System.out.print("Nuevo nombre: ");
        cliente.setNombre(sc.nextLine());
        System.out.print("Nuevo correo: ");
        cliente.setCorreo(sc.nextLine());
        System.out.print("Nuevo telefono: ");
        cliente.setTelefono(sc.nextLine());
        System.out.print("Nueva direccion: ");
        cliente.setDireccion(sc.nextLine());

        System.out.println("Cliente modificado.");
    }

    private void eliminarCliente() {
        System.out.print("Cedula del cliente a eliminar: ");
        String cedula = sc.nextLine();
        Cliente cliente = buscarCliente(cedula);
        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }
        clientes.remove(cliente);
        System.out.println("Cliente eliminado correctamente.");
    }

    private Cliente buscarCliente(String cedula) {
        for (Cliente c : clientes) {
            if (c.getCedula().equalsIgnoreCase(cedula)) {
                return c;
            }
        }
        return null;
    }

    private CuentaAhorro buscarCuenta(Cliente cliente, String numCuenta) {
        for (CuentaAhorro ca : cliente.getCuentas()) {
            if (ca.getNumeroCuenta().equalsIgnoreCase(numCuenta)) {
                return ca;
            }
        }
        return null;
    }
}

