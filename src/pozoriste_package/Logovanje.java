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

public class Logovanje extends JPanel {

	public JButton loginButton = new JButton("POTVRDI");
	public JButton cancelButton = new JButton("OTKAŽI");
	public JButton regButton = new JButton("REGISTRACIJA");
	public JTextField userText = new JTextField();
	public JPasswordField passwordText = new JPasswordField();

	// Boje
	public Color tamnoZelena = new Color(8, 126, 139);
	public Color tirkizna = new Color(221, 255, 247);
	public Color bordo = new Color(136, 90, 90);
	public Color roze = new Color(247, 193, 187);
	public Color podloga = new Color(53, 58, 71);
	public Color podlogaLevo = new Color(35, 38, 46);

	public Logovanje() {

		this.setBackground(podloga);
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(podloga);
		this.add(panel, BorderLayout.CENTER);

		try {
			panel.setLayout(null);
			JLabel logopoc = new JLabel(new ImageIcon(LogPoz.class.getResource("/images/pocetnilogo3.png")));
			logopoc.setBounds(300, 50, 600, 300);
			panel.add(logopoc);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JLabel prijava = new JLabel("PRIJAVA");
		prijava.setBounds(500, 370, 200, 25);
		prijava.setHorizontalAlignment(SwingConstants.CENTER);
		prijava.setForeground(tamnoZelena);
		prijava.setFont(new Font("Axis Extra Bold", Font.BOLD, 26));
		panel.add(prijava);

		// Creating JLabel
		JLabel userLabel = new JLabel("Korisničko ime");
		/*
		 * This method specifies the location and size of component. setBounds(x, y,
		 * width, height) here (x,y) are cordinates from the top left corner and
		 * remaining two arguments are the width and height of the component.
		 */
		userLabel.setBounds(400, 430, 150, 25);
		userLabel.setForeground(tirkizna);
		userLabel.setFont(new Font("Ubuntu Mono", Font.PLAIN, 20));
		userLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(userLabel);

		/*
		 * Creating text field where user is supposed to enter user name.
		 */
//        JTextField userText = new JTextField(20);
		userText.requestFocus(true);
		userText.setBounds(600, 430, 280, 30);
		userText.setBackground(tirkizna);
		userText.setFont(new Font("Ubuntu Mono", Font.PLAIN, 20));
		panel.add(userText);

		// Same process for password label and text field.
		JLabel passwordLabel = new JLabel("Lozinka");
		passwordLabel.setBounds(400, 480, 150, 25);
		passwordLabel.setForeground(tirkizna);
		passwordLabel.setFont(new Font("Ubuntu Mono", Font.PLAIN, 20));
		passwordLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(passwordLabel);

		/*
		 * This is similar to text field but it hides the user entered data and displays
		 * dots instead to protect the password like we normally see on login screens.
		 */
		passwordText.setBounds(600, 480, 280, 30);
		passwordText.setBackground(tirkizna);
		passwordText.setFont(new Font("Ubuntu Mono", Font.PLAIN, 20));
		panel.add(passwordText);

		loginButton.setBounds(370, 540, 200, 40);
		loginButton.setForeground(tamnoZelena);
		loginButton.setBackground(tirkizna);
		loginButton.setFont(new Font("Ubuntu Mono", Font.BOLD, 20));
		panel.add(loginButton);

		// Cancel button
		cancelButton.setBounds(630, 540, 200, 40);
		cancelButton.setForeground(roze);
		cancelButton.setBackground(bordo);
		cancelButton.setFont(new Font("Ubuntu Mono", Font.BOLD, 20));
		panel.add(cancelButton);

		// Registracija button
		regButton.setBounds(500, 600, 200, 40);
		regButton.setForeground(tamnoZelena);
		regButton.setBackground(tirkizna);
		regButton.setFont(new Font("Ubuntu Mono", Font.BOLD, 20));
		panel.add(regButton);

	}
}
