package pozoriste_package;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class RegKorisnika extends JPanel {

	public JButton cancelButton = new JButton("OTKAŽI");
	public JButton regButton = new JButton("POTVRDI");
	public JPasswordField passwordText = new JPasswordField(20);
	public JTextField userText = new JTextField(20);
	public JTextField prezimeText = new JTextField(20);
	public JTextField imeText = new JTextField(20);

	// Boje
	public Color tamnoZelena = new Color(8, 126, 139);
	public Color tirkizna = new Color(221, 255, 247);
	public Color bordo = new Color(136, 90, 90);
	public Color roze = new Color(247, 193, 187);
	public Color podloga = new Color(53, 58, 71);
	public Color podlogaLevo = new Color(35, 38, 46);

	public RegKorisnika() {

		this.setBackground(podloga);
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(podloga);
		this.add(panel, BorderLayout.CENTER);

		try {
			panel.setLayout(null);
			JLabel logoreg = new JLabel(new ImageIcon(LogPoz.class.getResource("/images/logoregistracija.png")));
			logoreg.setBounds(300, 50, 600, 200);
			panel.add(logoreg);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Creating JLabel
		JLabel imeLabel = new JLabel("Ime korisnika");
		imeLabel.setBounds(400, 300, 150, 25);
		imeLabel.setForeground(tirkizna);
		imeLabel.setFont(new Font("Ubuntu Mono", Font.PLAIN, 20));
		imeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(imeLabel);

		imeText.setBounds(600, 300, 280, 30);
		imeText.setBackground(tirkizna);
		imeText.setFont(new Font("Ubuntu Mono", Font.PLAIN, 20));
		panel.add(imeText);

		JLabel prezimeLabel = new JLabel("Prezime korisnika");
		prezimeLabel.setBounds(350, 350, 200, 25);
		prezimeLabel.setForeground(tirkizna);
		prezimeLabel.setFont(new Font("Ubuntu Mono", Font.PLAIN, 20));
		prezimeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(prezimeLabel);

		prezimeText.setBounds(600, 350, 280, 30);
		prezimeText.setBackground(tirkizna);
		prezimeText.setFont(new Font("Ubuntu Mono", Font.PLAIN, 20));
		panel.add(prezimeText);

		JLabel userLabel = new JLabel("Korisničko ime");
		userLabel.setBounds(400, 400, 150, 25);
		userLabel.setForeground(tirkizna);
		userLabel.setFont(new Font("Ubuntu Mono", Font.PLAIN, 20));
		userLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(userLabel);

		userText.setBounds(600, 400, 280, 30);
		userText.setBackground(tirkizna);
		userText.setFont(new Font("Ubuntu Mono", Font.PLAIN, 20));
		panel.add(userText);

		// Same process for password label and text field.
		JLabel passwordLabel = new JLabel("Lozinka");
		passwordLabel.setBounds(400, 450, 150, 25);
		passwordLabel.setForeground(tirkizna);
		passwordLabel.setFont(new Font("Ubuntu Mono", Font.PLAIN, 20));
		passwordLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(passwordLabel);

		passwordText.setBounds(600, 450, 280, 30);
		passwordText.setBackground(tirkizna);
		passwordText.setFont(new Font("Ubuntu Mono", Font.PLAIN, 20));
		panel.add(passwordText);

		// Registracija button

		regButton.setBounds(370, 540, 200, 40);
		regButton.setForeground(tamnoZelena);
		regButton.setBackground(tirkizna);
		regButton.setFont(new Font("Ubuntu Mono", Font.BOLD, 20));
		panel.add(regButton);

		// Cancel button

		cancelButton.setBounds(630, 540, 200, 40);
		cancelButton.setForeground(roze);
		cancelButton.setBackground(bordo);
		cancelButton.setFont(new Font("Ubuntu Mono", Font.BOLD, 20));
		panel.add(cancelButton);

	}

}
