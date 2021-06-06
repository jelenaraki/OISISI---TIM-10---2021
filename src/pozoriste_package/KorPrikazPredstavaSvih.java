package pozoriste_package;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.ScrollPaneConstants;
import javax.swing.SortOrder;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;

public class KorPrikazPredstavaSvih extends JPanel {

	public JLabel naslov = new JLabel("PREDSTAVE");
	public JLabel filter = new JLabel("Filter");
	public JLabel listaPred = new JLabel("Naziv predstave");
	public JLabel cena = new JLabel("Cena (od - do)");
	public JLabel datum = new JLabel("Datum (d/m/g)");

	public JButton logout = new JButton("IZLOGUJ SE");
	public JButton filterButton = new JButton("FILTER");
	public JButton ocistiFormu = new JButton("OČISTI FORMU");

	public JTextField filterPredstava = new JTextField(25);
	public JTextField filterCenaOd = new JTextField(5);
	public JTextField filterCenaDo = new JTextField(5);
	public JTextField filterDatumOd = new JTextField(10);
	public JTextField filterDatumDo = new JTextField(10);

	public JLabel znakpoz = new JLabel(new ImageIcon(KorPrikazPredstavaSvih.class.getResource("/images/znakpoz.png")));
	public JLabel predstave = new JLabel(
			new ImageIcon(KorPrikazPredstavaSvih.class.getResource("/images/predstava.png")));

	@SuppressWarnings("serial")
	DefaultTableModel modelPred = new DefaultTableModel(new Object[][] {},
			new String[] { "Naziv predstave", "Datum izvođenja", "Cena", "Rasprodato", "Info" }) {
		Class[] types = { String.class, Date.class, Integer.class, String.class, Integer.class };

		@Override
		public Class getColumnClass(int columnIndex) {
			return this.types[columnIndex];
		}
	};

	public JTable tabela = new JTable(modelPred);

	// Boje
	Color tamnoZelena = new Color(8, 126, 139);
	Color tirkizna = new Color(221, 255, 247);
	Color bordo = new Color(136, 90, 90);
	Color roze = new Color(247, 193, 187);
	Color podloga = new Color(53, 58, 71);
	Color podlogaLevo = new Color(35, 38, 46);

	public KorPrikazPredstavaSvih() throws ParseException {

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

		// Desna strana
		JPanel panel2 = new JPanel();
		panel2.setBackground(podloga);
		panel2.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel2.setBounds(200, 0, 1000, 720);
		panel2.setLayout(null);

		naslov.setBounds(33, 15, 300, 48);
		naslov.setForeground(roze);
		naslov.setFont(new Font("Axis Extra Bold", Font.BOLD, 40));
		panel2.add(naslov);

		listaPred.setBounds(35, 103, 150, 21);
		listaPred.setForeground(tirkizna);
		listaPred.setFont(new Font("Ubuntu Mono", Font.PLAIN, 20));
		panel2.add(listaPred);

		cena.setBounds(395, 103, 140, 21);
		cena.setForeground(tirkizna);
		cena.setFont(new Font("Ubuntu Mono", Font.PLAIN, 20));
		panel2.add(cena);

		ocistiFormu.setBounds(543, 25, 154, 31);
		ocistiFormu.setForeground(tamnoZelena);
		ocistiFormu.setBackground(tirkizna);
		ocistiFormu.setFont(new Font("Ubuntu Mono", Font.PLAIN, 20));
		panel2.add(ocistiFormu);

		logout.setBounds(809, 25, 134, 31);
		logout.setForeground(bordo);
		logout.setBackground(roze);
		logout.setFont(new Font("Ubuntu Mono", Font.PLAIN, 20));
		panel2.add(logout);

		filterButton.setBounds(850, 133, 100, 31);
		filterButton.setForeground(tamnoZelena);
		filterButton.setBackground(tirkizna);
		filterButton.setFont(new Font("Ubuntu Mono", Font.PLAIN, 20));
		panel2.add(filterButton);

		filter.setBounds(35, 80, 60, 21);
		filter.setForeground(tirkizna);
		filter.setFont(new Font("Ubuntu Mono", Font.PLAIN, 20));
		panel2.add(filter);

		datum.setBounds(625, 103, 130, 21);
		datum.setForeground(tirkizna);
		datum.setFont(new Font("Ubuntu Mono", Font.PLAIN, 20));
		panel2.add(datum);

		filterPredstava.setBounds(33, 136, 254, 25);
		filterPredstava.setForeground(tamnoZelena);
		filterPredstava.setBackground(tirkizna);
		filterPredstava.setFont(new Font("Ubuntu Mono", Font.PLAIN, 20));
		panel2.add(filterPredstava);

		filterCenaOd.setBounds(390, 136, 54, 25);
		filterCenaOd.setForeground(tamnoZelena);
		filterCenaOd.setBackground(tirkizna);
		filterCenaOd.setFont(new Font("Ubuntu Mono", Font.PLAIN, 20));
		panel2.add(filterCenaOd);

		filterCenaDo.setBounds(482, 136, 54, 25);
		filterCenaDo.setForeground(tamnoZelena);
		filterCenaDo.setBackground(tirkizna);
		filterCenaDo.setFont(new Font("Ubuntu Mono", Font.PLAIN, 20));
		panel2.add(filterCenaDo);

		filterDatumOd.setBounds(570, 136, 120, 25);
		filterDatumOd.setForeground(tamnoZelena);
		filterDatumOd.setBackground(tirkizna);
		filterDatumOd.setFont(new Font("Ubuntu Mono", Font.PLAIN, 20));
		panel2.add(filterDatumOd);

		filterDatumDo.setBounds(707, 136, 120, 25);
		filterDatumDo.setForeground(tamnoZelena);
		filterDatumDo.setBackground(tirkizna);
		filterDatumDo.setFont(new Font("Ubuntu Mono", Font.PLAIN, 20));
		panel2.add(filterDatumDo);

		Cuvanje.Predstave = Cuvanje.UcitajPredstave("predstave.txt");

		tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabela.setColumnSelectionAllowed(true);
		tabela.setFont(new Font("Ubuntu Mono", Font.PLAIN, 20));
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
		tabela.getColumnModel().getColumn(0).setPreferredWidth(400);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(180);
		tabela.getColumnModel().getColumn(2).setPreferredWidth(100);
		tabela.getColumnModel().getColumn(3).setPreferredWidth(150);
		tabela.getColumnModel().getColumn(4).setPreferredWidth(70);

		for (int i = 0; i < Cuvanje.Predstave.size(); i++) {
			DefaultTableModel model = (DefaultTableModel) tabela.getModel();
			SimpleDateFormat formatDatuma = new SimpleDateFormat("dd.MM.yyyy");

			model.addRow(new Object[] { Cuvanje.Predstave.get(i).getNazivPredstave(),
					Cuvanje.Predstave.get(i).getDatumPredstave(), Cuvanje.Predstave.get(i).getCenaKarte(),
					Cuvanje.Predstave.get(i).getRasprodato(), Cuvanje.Predstave.get(i).getIdPredstave() });
		}

		tabela.setRowHeight(30);

		// SORTIRANJE

		TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(modelPred);

		tabela.setRowSorter(sorter);

		List<RowSorter.SortKey> sortKeys = new ArrayList<>(25);
		sortKeys.add(new RowSorter.SortKey(4, SortOrder.ASCENDING));
		sorter.setSortKeys(sortKeys);

		RowFilter<Object, Integer> cenaVeca = new RowFilter<Object, Integer>() {
			@Override
			public boolean include(@SuppressWarnings("rawtypes") RowFilter.Entry entry) {

				return ((Integer) entry.getValue(2)) >= Integer.parseInt(filterCenaOd.getText());
			}

		};

		RowFilter<Object, Integer> cenaManja = new RowFilter<Object, Integer>() {
			@Override
			public boolean include(@SuppressWarnings("rawtypes") RowFilter.Entry entry) {
				return (Integer.parseInt(entry.getValue(2).toString()) <= Integer.parseInt(filterCenaDo.getText()));
			}

		};

		SimpleDateFormat formatDatuma = new SimpleDateFormat("dd.MM.yyyy");

		Action filterisanje = new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {

				List<RowFilter<Object, Integer>> filters = new ArrayList<RowFilter<Object, Integer>>(5);
				String selected = filterPredstava.getText();
				filters.add(RowFilter.regexFilter("(?i)" + selected)); // added the string filter
				if (filterCenaOd.getText().length() != 0) {
					filters.add(cenaVeca);
				}
				if (filterCenaDo.getText().length() != 0) {
					filters.add(cenaManja);
				}
				if (filterDatumOd.getText().length() != 0) {
					try {
						filters.add(RowFilter.dateFilter(RowFilter.ComparisonType.AFTER,
								formatDatuma.parse(filterDatumOd.getText())));
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if (filterDatumDo.getText().length() != 0) {
					try {
						filters.add(RowFilter.dateFilter(RowFilter.ComparisonType.BEFORE,
								formatDatuma.parse(filterDatumDo.getText())));
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				RowFilter<Object, Integer> rf = RowFilter.andFilter(filters);
				sorter.setRowFilter(rf);
			}

		};

		filterButton.addActionListener(filterisanje);

		// KRAJ SORTIRANJA

		JScrollPane scrollPane = new JScrollPane(tabela);
		scrollPane.setViewportBorder(null);
		scrollPane.getViewport().setBackground(podloga);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		scrollPane.setBounds(30, 180, 900, 480);
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
