package esica.ui;

import javax.swing.JOptionPane;

public abstract class ProductosUI {
	private boolean salir = true;
	private static String nombre;
	private static String referencia;
	private static String descripcion;
	private static String cantidad;
	private static String precio;
	private static String id = "";
	private static String opcion;

	public void initialize() {
		do {
			opcion = JOptionPane.showInputDialog("\r\n" + "1- Alta producto\r\n" + "2- Baja producto\r\n"
					+ "3-Obtener producto por referencia \r\n" + "4-Listar productos\r\n"
					+ "5-Importar productos: Importa una lista de productos desde un fichero XML.\r\n"
					+ "6-Exportar productos: Exporta en un fichero XML todos los productos de la base de datos. \r\n"
					+ "7-Salir\r\n" + "");
			try {
				switch (Integer.valueOf(opcion)) {
				case 1:
//					do {
//				        playerName =
//				            JOptionPane.showInputDialog(message);
//				        message = "<html><b style='color:red'>Enter Your Name:</b><br>"
//				                + "Use letters only.";          
//				    } while(playerName != null && !playerName.matches("[a-zA-Z]+"));
					nombre = JOptionPane.showInputDialog(null, "Nombre del producto");
					referencia = JOptionPane.showInputDialog(null, "Referencia del producto");
					descripcion = JOptionPane.showInputDialog(null, "Descripcion del producto");
					cantidad = JOptionPane.showInputDialog(null, "Cantidad del producto");
					precio = JOptionPane.showInputDialog(null, "Precio del producto");
					agregarProducto();
					break;
				case 2:
					listarProducto();
					id = JOptionPane.showInputDialog("Introduzca el ID que desea eliminar");

					eliminarProducto();
					break;
				case 3:
					referencia = JOptionPane.showInputDialog(null, "Referencia del producto");
					listaProductoRef();
					break;
				case 4:
					listarProducto();
					break;
				case 5:
					System.out.println("Friday");
					break;
				case 6:
					System.out.println("Saturday");
					break;
				case 7:
					salir = false;
					break;
				}

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "La opción elegida no es valida.");
				initialize();
			}
		} while (opcion != null && !opcion.matches("[7]"));
	}

	public static String getId() {
		return id;
	}

	public static void setId(String id) {
		ProductosUI.id = id;
	}

	public static String getNombre() {
		return nombre;
	}

	public static void setNombre(String nombre) {
		ProductosUI.nombre = nombre;
	}

	public static String getReferencia() {
		return referencia;
	}

	public static void setReferencia(String referencia) {
		ProductosUI.referencia = referencia;
	}

	public static String getDescripcion() {
		return descripcion;
	}

	public static void setDescripcion(String descripcion) {
		ProductosUI.descripcion = descripcion;
	}

	public static String getCantidad() {
		return cantidad;
	}

	public static void setCantidad(String cantidad) {
		ProductosUI.cantidad = cantidad;
	}

	public static String getPrecio() {
		return precio;
	}

	public static void setPrecio(String precio) {
		ProductosUI.precio = precio;
	}

	protected abstract void agregarProducto();

	protected abstract void eliminarProducto();

	protected abstract void listarProducto();

	protected abstract void listaProductoRef();
}
