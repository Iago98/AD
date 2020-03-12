package esica.ui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import esica.modelo.facade.ProductoFacade;
import esica.modelo.vo.ProductoVO;

public class ListaRef {

	// frame
	JFrame f;
	// Table
	JTable j;

	// Constructor
	public ListaRef(String ref) {
		// Frame initiallization
		f = new JFrame();

		// Frame Title
		f.setTitle("Productos");

		// Data to be displayed in the JTable

		// Column Names
		DefaultTableModel tm = new DefaultTableModel();
		tm.addColumn("ID");
		tm.addColumn("Nombre");
		tm.addColumn("Descripcion");
		tm.addColumn("Referencia");
		tm.addColumn("Cantidad");
		tm.addColumn("Precio €");
		
		int x=0;
		
		for (String[] s : transformarListaVO(ref)) {
			s[0] = String.valueOf(x);
			x++;
			tm.addRow(s);
		}
		
		

		// Initializing the JTable
		j = new JTable(tm);
		j.setBounds(30, 40, 200, 300);




		// adding it to JScrollPane
		JScrollPane sp = new JScrollPane(j);
		f.add(sp);
		// Frame Size
		f.setSize(500, 200);
		// Frame Visible = true
		
		f.setVisible(true);
		
	}
	
	private List<String[]> transformarListaVO(String ref) {
		ArrayList<String[]> dam = new ArrayList<String[]>();
		List<ProductoVO> productosLista = new ArrayList<ProductoVO>();
		if(ref==null){
			productosLista = ProductoFacade.recuperar();

		}else {
			productosLista = ProductoFacade.verProductoRefe(ref);

		}
		for (int x = 0; x < productosLista.size(); x++) {
			String[] arr = {"" ,productosLista.get(x).getNombre(), productosLista.get(x).getDescripcion(),
					productosLista.get(x).getReferencia(), String.valueOf(productosLista.get(x).getCantidad()),
					String.valueOf(productosLista.get(x).getPrecio())};
			dam.add(arr);
		}

		return dam;
	}

	// Driver method
	public static void main(String[] args) {
		new ListaRef(null);
	}
}