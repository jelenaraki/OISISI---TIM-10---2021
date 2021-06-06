package pozoriste_package;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowSorter;
import javax.swing.ScrollPaneConstants;
import javax.swing.SortOrder;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;

public class AdmIzvestajSvePreds extends JPanel {
	public JLabel naslov = new JLabel("IZVEŠTAJ O PRODAJI");
	public JLabel ukupnaZaradatxt = new JLabel("Ukupna zarada (RSD):");
	public JButton logout = new JButton("IZLOGUJ SE");
	public JTextField ukupnaZarada = new JTextField(25);

	@SuppressWarnings("serial")
	DefaultTableModel izvPred = new DefaultTableModel(new Object[][] {},
			new String[] { "ID predstave", "Naziv predstave", "Cena karte", "Prodato karata", "Zarada" }) {
		Class[] types = { Integer.class, String.class, Integer.class, Integer.class, Integer.class };

		@Override
		public Class getColumnClass(int columnIndex) {
			return this.types[columnIndex];
		}
	};

	public JTable tabela = new JTable(izvPred);

	public JLabel izvestaj = new JLabel(
			new ImageIcon(AdmPrikazPredstavaSvih.class.getResource("/images/izvestaj.png")));
	public JLabel znakpoz = new JLabel(new ImageIcon(AdmPrikazPredstavaSvih.class.getResource("/images/znakpoz.png")));
	public JLabel predstave = new JLabel(
			new ImageIcon(AdmPrikazPredstavaSvih.class.getResource("/images/predstava.png")));

	// Boje
	Color tamnoZelena = new Color(8, 126, 139);
	Color tirkizna = new Color(221, 255, 247);
	Color bordo = new Color(136, 90, 90);
	Color roze = new Color(247, 193, 187);
	Color podloga = new Color(53, 58, 71);
	Color podlogaLevo = new Color(35, 38, 46);

	public AdmIzvestajSvePreds() throws ParseException {

		// Leva strana
		JPanel panel1 = new JPanel();
		panel1.setBackground(podlogaLevo);
		panel1.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel1.setBounds(0, 0, 200, 720);

		try {
			panel1.setLayout(null);

			znakpoz.setBounds(0, 10, 200, 100);
			panel1.add(znakpoz);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {

			predstave.setBounds(65, 170, 70, 70);
			panel1.add(predstave);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		JLabel predstavetxt = new JLabel("Predstave");
		predstavetxt.setHorizontalAlignment(SwingConstants.CENTER);
		predstavetxt.setForeground(roze);
		predstavetxt.setFont(new Font("Ubuntu Mono", Font.PLAIN, 20));
		predstavetxt.setBounds(0, 240, 200, 25);
		panel1.add(predstavetxt);

		try {

			izvestaj.setBounds(65, 300, 70, 70);
			panel1.add(izvestaj);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		JLabel izvestajtxt = new JLabel("Izveštaj");
		izvestajtxt.setHorizontalAlignment(SwingConstants.CENTER);
		izvestajtxt.setForeground(roze);
		izvestajtxt.setFont(new Font("Ubuntu Mono", Font.PLAIN, 20));
		izvestajtxt.setBounds(0, 370, 200, 25);
		panel1.add(izvestajtxt);

		// Desna strana
		JPanel panel2 = new JPanel();
		panel2.setBackground(podloga);
		panel2.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel2.setBounds(200, 0, 1000, 720);
		panel2.setLayout(null);

		naslov.setBounds(33, 15, 496, 48);
		naslov.setForeground(roze);
		naslov.setFont(new Font("Axis Extra Bold", Font.BOLD, 40));
		panel2.add(naslov);

		ukupnaZaradatxt.setBounds(490, 600, 266, 30);
		ukupnaZaradatxt.setForeground(tirkizna);
		ukupnaZaradatxt.setFont(new Font("Ubuntu Mono", Font.PLAIN, 25));
		panel2.add(ukupnaZaradatxt);
		ukupnaZarada.setHorizontalAlignment(SwingConstants.CENTER);

		ukupnaZarada.setBounds(774, 600, 169, 30);
		ukupnaZarada.setForeground(podloga);
		ukupnaZarada.setFont(new Font("Ubuntu Mono", Font.PLAIN, 25));
		panel2.add(ukupnaZarada);

		logout.setBounds(809, 25, 134, 31);
		logout.setForeground(bordo);
		logout.setBackground(roze);
		logout.setFont(new Font("Ubuntu Mono", Font.PLAIN, 20));
		panel2.add(logout);

		tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		tabela.setColumnSelectionAllowed(true);
		tabela.setFont(new Font("Ubuntu Mono", Font.PLAIN, 20));
		tabela.setBounds(30, 180, 950, 480);
		tabela.setForeground(tirkizna);
		tabela.setBackground(podloga);
		tabela.setShowHorizontalLines(true);

		JTableHeader header = tabela.getTableHeader();
		header.setBackground(tirkizna);
		header.setForeground(podlogaLevo);
		header.setFont(new Font("Ubuntu Mono", Font.PLAIN, 20));

		tabela.setShowVerticalLines(false);
		tabela.setShowHorizontalLines(true);

		tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tabela.getColumnModel().getColumn(0).setPreferredWidth(100);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(500);
		tabela.getColumnModel().getColumn(2).setPreferredWidth(80);
		tabela.getColumnModel().getColumn(3).setPreferredWidth(150);
		tabela.getColumnModel().getColumn(4).setPreferredWidth(120);

		Cuvanje.GenerisiIzvestaj("izvestajsve.txt", Cuvanje.Izvestaji);
		Cuvanje.Izvestaji = Cuvanje.UcitajIzvestaje("izvestajsve.txt");
		ArrayList<Izvestaj> izv = Cuvanje.UcitajIzvestaje("izvestajsve.txt");

		Integer ukZar = 0;

		for (int i = 0; i < Cuvanje.Izvestaji.size(); i++) {

			izvPred.addRow(new Object[] { izv.get(i).getIdPredstave(), izv.get(i).getNazivPredstave(),
					izv.get(i).getCenaKarte(), izv.get(i).getProdato(), izv.get(i).getZarada() });
			ukZar = ukZar + izv.get(i).getZarada();
		}

		tabela.setRowHeight(30);

		ukupnaZarada.setText(ukZar.toString());

		tabela.getModel().addTableModelListener(tabela);
		((AbstractTableModel) tabela.getModel()).fireTableDataChanged();

		// SORTIRANJE

		TableRowSorter<AbstractTableModel> sorter = new TableRowSorter<AbstractTableModel>(
				(AbstractTableModel) tabela.getModel());

		tabela.setRowSorter(sorter);

		List<RowSorter.SortKey> sortKeys = new ArrayList<>(25);
		sortKeys.add(new RowSorter.SortKey(4, SortOrder.ASCENDING));
		sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
		sorter.setSortKeys(sortKeys);

		JScrollPane scrollPane = new JScrollPane(tabela);
		scrollPane.setViewportView(tabela);
		scrollPane.getViewport().setBackground(podloga);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		scrollPane.setBounds(30, 85, 950, 480);
		panel2.add(scrollPane);

		JPanel glavniPanel = new JPanel();
		glavniPanel.setBounds(0, 0, 1200, 720);
		glavniPanel.setBackground(podloga);
		glavniPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		glavniPanel.setLayout(null);
		glavniPanel.add(panel1);
		glavniPanel.add(panel2);

		this.add(glavniPanel, BorderLayout.CENTER);
		this.setBackground(podloga);
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(new BorderLayout(0, 0));
		this.repaint();

	}

}
