package esica.ui;

import java.math.BigDecimal;
import java.text.DecimalFormat;

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
	private static String ruta;
	DecimalFormat df = new DecimalFormat("#.00");

	public void initialize() {
		do {

			opcion = JOptionPane.showInputDialog("\r\n" + "1- Alta producto\r\n" + "2- Baja producto\r\n"
					+ "3-Obtener producto por referencia \r\n" + "4-Listar productos\r\n"
					+ "5-Importar productos: Importa una lista de productos desde un fichero XML.\r\n"
					+ "6-Exportar productos: Exporta en un fichero XML todos los productos de la base de datos. \r\n"
					+ "7-Salir\r\n" + "");

			if (opcion != null && isNum(opcion)) {
				switch (Integer.valueOf(opcion)) {
				case 1:
					try {
						nombre = JOptionPane.showInputDialog(null, "Nombre del producto");
						if (nombre.isEmpty()) {
							JOptionPane.showMessageDialog(null, "Formato no valido");
							while (nombre.isEmpty() || nombre.trim().length() > 50) {
								JOptionPane.showMessageDialog(null, "Formato no valido");
								nombre = JOptionPane.showInputDialog(null, "Nombre del producto");
							}
						}
						referencia = JOptionPane.showInputDialog(null, "Referencia del producto");
						if (referencia.isEmpty()) {
							JOptionPane.showMessageDialog(null, "Formato no valido");
							while (referencia.isEmpty() || referencia.trim().length() > 10) {
								JOptionPane.showMessageDialog(null, "Formato no valido");
								referencia = JOptionPane.showInputDialog(null, "Referencia del producto");
							}
						}

						descripcion = JOptionPane.showInputDialog(null, "Descripcion del producto");
						if (descripcion.trim().length() > 200) {
							JOptionPane.showMessageDialog(null, "Formato no valido");
							while (descripcion.trim().length() > 200) {
								JOptionPane.showMessageDialog(null, "Formato no valido");
								descripcion = JOptionPane.showInputDialog(null, "Descripcion del producto");
							}
						} else if (descripcion.equals("")) {
							descripcion = null;
						}
						cantidad = JOptionPane.showInputDialog(null, "Cantidad del producto");
						if (cantidad.trim().length() > 4 || !isNumOrNull(cantidad)) {
							JOptionPane.showMessageDialog(null, "Formato no valido");
							while (cantidad.trim().length() > 4 || !isNumOrNull(cantidad)) {
								JOptionPane.showMessageDialog(null, "Formato no valido");
								cantidad = JOptionPane.showInputDialog(null, "Cantidad del producto");

							}
						} else if (cantidad.equals("")) {
							cantidad = null;
						}

						BigDecimal precio = new BigDecimal(-1);
						String[] div = null;
						while (precio.equals(new BigDecimal(-1))) {
							try {
								precio = new BigDecimal(JOptionPane.showInputDialog(null, "Precio del producto"));
							} catch (NumberFormatException e) {
								JOptionPane.showMessageDialog(null, "Formato no valido");
							}

							div = String.valueOf(precio).split("\\.");
							if (div.length > 1) {
								if (String.valueOf(precio).length() > 7) {
									JOptionPane.showMessageDialog(null, "Formato no valido");
									precio = new BigDecimal(-1);
								} else if (div[1].length() > 2) {
									JOptionPane.showMessageDialog(null, "Formato no valido");
									precio = new BigDecimal(-1);
								}
							} else if (precio.equals("")) {
								precio = null;
							} else {
								if (String.valueOf(precio).length()>4) {
									JOptionPane.showMessageDialog(null, "Formato no valido");
									precio = new BigDecimal(-1);
								}
							}

						}

						agregarProducto();
					} catch (Exception e) {
						initialize();
					}
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
					ruta = JOptionPane.showInputDialog(null, "Ruta del XML a importar");
					importarXML();
					break;
				case 6:
					crearXML();
					break;
				case 7:
					break;
				default:
					JOptionPane.showMessageDialog(null, "Opcion no valida");
					break;
				}
			}

		} while (!opcion.equals("7") || opcion == null);
	}

	private boolean isNum(String val) {
		try {
			Integer.valueOf(val);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	private boolean isNumOrNull(String val) {
		if (val.equals("")) {
			return true;
		} else {
			try {
				Integer.valueOf(val);
				return true;
			} catch (NumberFormatException e) {
				return false;
			}
		}
	}

	public static String getRuta() {
		return ruta;
	}

	public static void setRuta(String ruta) {
		ProductosUI.ruta = ruta;
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

	protected abstract void crearXML();

	protected abstract void importarXML();

}
