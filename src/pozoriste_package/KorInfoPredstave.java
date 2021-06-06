package pozoriste_package;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class KorInfoPredstave extends JPanel {
	public JLabel naslov = new JLabel("PREDSTAVA");

	public JButton logout = new JButton("IZLOGUJ SE");
	public JButton rezervisi = new JButton("REZERVIŠI KARTE");
	public JButton otkazi = new JButton("OTKAŽI");

	DateFormat datum = new SimpleDateFormat("dd.MM.yyyy");
	DateFormat vreme = new SimpleDateFormat("HH:mm");
	DecimalFormat cena = new DecimalFormat("#");

	public JTextField idPredTxt = new JTextField(6);
	public JTextField nazivPredTxt = new JTextField(30);
	public JTextArea opisPredTxt = new JTextArea();
	public JFormattedTextField datumPredTxt = new JFormattedTextField(datum);
	public JFormattedTextField vremePredTxt = new JFormattedTextField(vreme);
	public JFormattedTextField cenaKarteTxt = new JFormattedTextField(cena);

	public JLabel izvestaj = new JLabel(new ImageIcon("/images/izvestaj.png"));
	public JLabel znakpoz = new JLabel(new ImageIcon(AdmUnosNovePredstave.class.getResource("/images/znakpoz.png")));
	public JLabel predstave = new JLabel(
			new ImageIcon(AdmUnosNovePredstave.class.getResource("/images/predstava.png")));

	// Boje
	Color tamnoZelena = new Color(8, 126, 139);
	Color tirkizna = new Color(221, 255, 247);
	Color bordo = new Color(136, 90, 90);
	Color roze = new Color(247, 193, 187);
	Color podloga = new Color(53, 58, 71);
	Color podlogaLevo = new Color(35, 38, 46);

	public KorInfoPredstave() {

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

		logout.setBounds(800, 25, 134, 31);
		logout.setForeground(bordo);
		logout.setBackground(roze);
		logout.setFont(new Font("Ubuntu Mono", Font.PLAIN, 20));
		panel2.add(logout);

		JLabel idPred = new JLabel("ID predstave");
		idPred.setBounds(100, 100, 150, 25);
		idPred.setForeground(tirkizna);
		idPred.setFont(new Font("Ubuntu Mono", Font.PLAIN, 20));
		idPred.setHorizontalAlignment(SwingConstants.RIGHT);
		panel2.add(idPred, BorderLayout.NORTH);

		idPredTxt.setBounds(300, 100, 100, 30);
		idPredTxt.setBackground(tirkizna);
		idPredTxt.setFont(new Font("Ubuntu Mono", Font.PLAIN, 20));
		panel2.add(idPredTxt);

		JLabel nazivPred = new JLabel("Naziv predstave");
		nazivPred.setBounds(100, 160, 150, 25);
		nazivPred.setForeground(tirkizna);
		nazivPred.setFont(new Font("Ubuntu Mono", Font.PLAIN, 20));
		nazivPred.setHorizontalAlignment(SwingConstants.RIGHT);
		panel2.add(nazivPred, BorderLayout.NORTH);

		nazivPredTxt.setBounds(300, 160, 500, 30);
		nazivPredTxt.setBackground(tirkizna);
		nazivPredTxt.setFont(new Font("Ubuntu Mono", Font.PLAIN, 20));
		panel2.add(nazivPredTxt);

		JLabel opisPred = new JLabel("Opis predstave");
		opisPred.setBounds(100, 220, 150, 25);
		opisPred.setForeground(tirkizna);
		opisPred.setFont(new Font("Ubuntu Mono", Font.PLAIN, 20));
		opisPred.setHorizontalAlignment(SwingConstants.RIGHT);
		panel2.add(opisPred);

		opisPredTxt.setRows(5);
		opisPredTxt.setLineWrap(true);
		opisPredTxt.setWrapStyleWord(true);
		opisPredTxt.setBounds(300, 220, 600, 100);
		opisPredTxt.setBackground(tirkizna);
		opisPredTxt.setFont(new Font("Ubuntu Mono", Font.PLAIN, 20));
		panel2.add(opisPredTxt);

		JLabel datumPred = new JLabel("Datum izvođenja");
		datumPred.setBounds(100, 350, 150, 25);
		datumPred.setForeground(tirkizna);
		datumPred.setFont(new Font("Ubuntu Mono", Font.PLAIN, 20));
		datumPred.setHorizontalAlignment(SwingConstants.RIGHT);
		panel2.add(datumPred);

		datumPredTxt.setBounds(300, 350, 150, 30);
		datumPredTxt.setBackground(tirkizna);
		datumPredTxt.setFont(new Font("Ubuntu Mono", Font.PLAIN, 20));
		panel2.add(datumPredTxt);

		JLabel vremePred = new JLabel("Vreme izvođenja");
		vremePred.setBounds(100, 410, 150, 25);
		vremePred.setForeground(tirkizna);
		vremePred.setFont(new Font("Ubuntu Mono", Font.PLAIN, 20));
		vremePred.setHorizontalAlignment(SwingConstants.RIGHT);
		panel2.add(vremePred);

		vremePredTxt.setBounds(300, 410, 150, 30);
		vremePredTxt.setBackground(tirkizna);
		vremePredTxt.setFont(new Font("Ubuntu Mono", Font.PLAIN, 20));
		panel2.add(vremePredTxt);

		JLabel cenaKarte = new JLabel("Cena karte");
		cenaKarte.setBounds(100, 470, 150, 25);
		cenaKarte.setForeground(tirkizna);
		cenaKarte.setFont(new Font("Ubuntu Mono", Font.PLAIN, 20));
		cenaKarte.setHorizontalAlignment(SwingConstants.RIGHT);
		panel2.add(cenaKarte);
		cenaKarteTxt.setText("");

		cenaKarteTxt.setBounds(300, 470, 150, 30);
		cenaKarteTxt.setBackground(tirkizna);
		cenaKarteTxt.setFont(new Font("Ubuntu Mono", Font.PLAIN, 20));
		panel2.add(cenaKarteTxt);

		rezervisi.setBounds(280, 580, 200, 30);
		rezervisi.setForeground(tamnoZelena);
		rezervisi.setBackground(tirkizna);
		rezervisi.setFont(new Font("Ubuntu Mono", Font.PLAIN, 20));
		panel2.add(rezervisi);

		otkazi.setBounds(520, 580, 180, 30);
		otkazi.setForeground(bordo);
		otkazi.setBackground(roze);
		otkazi.setFont(new Font("Ubuntu Mono", Font.PLAIN, 20));
		panel2.add(otkazi);

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
	}
}
