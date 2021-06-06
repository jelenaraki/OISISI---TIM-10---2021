package pozoriste_package;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class KorRezervacijaKarte extends JPanel {
	public JLabel naslov = new JLabel("REZERVACIJA KARATA");

	public JButton logout = new JButton("IZLOGUJ SE");
	public JButton rezervisi = new JButton("REZERVIŠI KARTE");
	public JButton otkazi = new JButton("OTKAŽI");

	public JTextField nazivPredTxt = new JTextField(50);
	public ButtonGroup sedista = new ButtonGroup();
	public JPanel pozorisnaSala = new JPanel();
	public Integer idpredstave;

	public JLabel izvestaj = new JLabel(new ImageIcon("/images/izvestaj.png"));
	public JLabel znakpoz = new JLabel(new ImageIcon(AdmUnosNovePredstave.class.getResource("/images/znakpoz.png")));
	public JLabel predstave = new JLabel(
			new ImageIcon(AdmUnosNovePredstave.class.getResource("/images/predstava.png")));
	public ArrayList<Karta> kuplj = new ArrayList<Karta>();

	// Boje
	Color tamnoZelena = new Color(8, 126, 139);
	Color tirkizna = new Color(221, 255, 247);
	Color bordo = new Color(136, 90, 90);
	Color roze = new Color(247, 193, 187);
	Color podloga = new Color(53, 58, 71);
	Color podlogaLevo = new Color(35, 38, 46);

	Color slobSed = new Color(211, 211, 211);
	Color txtSed = podlogaLevo;
	Dimension d = new Dimension(50, 40);

	public KorRezervacijaKarte() throws ParseException {

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

		naslov.setBounds(20, 0, 600, 80);
		naslov.setForeground(roze);
		naslov.setFont(new Font("Axis Extra Bold", Font.BOLD, 40));
		panel2.add(naslov);

		logout.setBounds(800, 25, 150, 30);
		logout.setForeground(bordo);
		logout.setBackground(roze);
		logout.setFont(new Font("Ubuntu Mono", Font.PLAIN, 20));
		panel2.add(logout);

		JLabel nazivPred = new JLabel("Naziv predstave");
		nazivPred.setBounds(100, 80, 150, 25);
		nazivPred.setForeground(tirkizna);
		nazivPred.setFont(new Font("Ubuntu Mono", Font.PLAIN, 20));
		nazivPred.setHorizontalAlignment(SwingConstants.RIGHT);
		panel2.add(nazivPred, BorderLayout.NORTH);

		nazivPredTxt.setBounds(300, 80, 400, 30);
		nazivPredTxt.setBackground(tirkizna);
		nazivPredTxt.setFont(new Font("Ubuntu Mono", Font.PLAIN, 20));
		panel2.add(nazivPredTxt);

		pozorisnaSala.setBackground(podlogaLevo);
		pozorisnaSala.setBounds(230, 170, 510, 380);
		panel2.add(pozorisnaSala);
		pozorisnaSala.setLayout(new FlowLayout(FlowLayout.LEADING, 30, 30));

		ArrayList<Karta> kuplj = Cuvanje.UcitajKarte("prodate.txt");

		if (kuplj.size() == 30) {
			for (int i = 0; i < Cuvanje.Predstave.size(); i++) {
				if (Cuvanje.Predstave.get(i).getIdPredstave() == kuplj.get(0).getIdPredstave()) {
					Predstava rasprodata = Cuvanje.Predstave.get(i);
					rasprodata.setRasprodato("DA");
					Cuvanje.Predstave.remove(i);
					Cuvanje.Predstave.add(rasprodata);
					Cuvanje.SacuvajPredstavu("predstave.txt", Cuvanje.Predstave);
					break;
				}
			}
		}

		ActionListener reserve = ActionEvent -> sedista.getSelection().setEnabled(false);

		for (int i = 0; i < 30; i++) {
			JToggleButton x = new JToggleButton(Integer.toString(i + 1));
			x.addActionListener(reserve);
			x.setEnabled(true);
			x.setBackground(slobSed);
			x.setForeground(txtSed);
			x.setPreferredSize(d);
			x.setActionCommand(Integer.toString(i + 1));
			for (int j = 0; j < kuplj.size(); j++) {
				if (kuplj.get(j).getSediste() == ((i + 1)) && kuplj.get(j).getIdPredstave() == idpredstave) {
					x.setEnabled(false);
					x.setBackground(roze);
					break;
				}
			}
			sedista.add(x);
			pozorisnaSala.add(x);

		}

		rezervisi.setBounds(300, 600, 200, 30);
		rezervisi.setForeground(tamnoZelena);
		rezervisi.setBackground(tirkizna);
		rezervisi.setFont(new Font("Ubuntu Mono", Font.PLAIN, 20));
		panel2.add(rezervisi);

		otkazi.setBounds(520, 600, 180, 30);
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

	public void refreshdugme() {
		// TODO Auto-generated method stub
		ArrayList<Karta> kuplj = null;
		try {
			kuplj = Cuvanje.UcitajKarte("prodate.txt");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ActionListener reserve = ActionEvent -> sedista.getSelection().setEnabled(false);

		int i = 0;

		for (Enumeration<AbstractButton> buttons = sedista.getElements(); buttons.hasMoreElements();) {
			AbstractButton x = buttons.nextElement();
			// x.addActionListener(reserve);
			x.setEnabled(true);
			x.setBackground(slobSed);
			x.setForeground(txtSed);
			x.setPreferredSize(d);
			x.setActionCommand(Integer.toString(i + 1));
			for (int j = 0; j < kuplj.size(); j++) {
				if (kuplj.get(j).getSediste().equals((i + 1)) && kuplj.get(j).getIdPredstave().equals(idpredstave)) {
					x.setEnabled(false);
					x.setBackground(roze);
					break;
				}
			}

			i++;
		}
		revalidate();
		repaint();

	}
}
