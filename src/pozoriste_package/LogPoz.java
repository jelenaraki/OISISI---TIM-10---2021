package pozoriste_package;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class LogPoz extends JFrame {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					LogPoz frame = new LogPoz();
					frame.pack();
					frame.setSize(1200, 720);
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LogPoz() throws ParseException {

		Cuvanje.Korisnici = Cuvanje.UcitajKorisnike("korisnici.txt");
		Cuvanje.Karte = Cuvanje.UcitajKarte("karte.txt");

		setResizable(false);
		setTitle("Logovanje u sistem");
		setFont(new Font("Ubuntu Mono", Font.PLAIN, 12));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Logovanje pocetni = new Logovanje();
		RegKorisnika registracija = new RegKorisnika();
		AdmPrikazPredstavaSvih admpocetna = new AdmPrikazPredstavaSvih();
		AdmUnosNovePredstave admnovapred = new AdmUnosNovePredstave();
		KorPrikazPredstavaSvih korpocetna = new KorPrikazPredstavaSvih();
		KorInfoPredstave korinfopred = new KorInfoPredstave();
		KorRezervacijaKarte korrezkarte = new KorRezervacijaKarte();
		AdmIzvestajSvePreds admizvsvepred = new AdmIzvestajSvePreds();
		AdmIzvestajPred admizvpred = new AdmIzvestajPred();

		setContentPane(pocetni);

		Action pokretanje = new AbstractAction() {

			String ime = new String();
			String prez = new String();
			TipKorisnika k;

			Korisnik ulogovan = new Korisnik();

//		@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int sajz = Cuvanje.Korisnici.size() - 1;

				for (int i = 0; i < Cuvanje.Korisnici.size(); i++) {
					if (pocetni.userText.getText().equals(Cuvanje.Korisnici.get(i).getKorisnickoime())
							&& pocetni.passwordText.getText().equals(Cuvanje.Korisnici.get(i).getLozinka())) {
						k = Cuvanje.Korisnici.get(i).getTipkorisnika();
						ime = Cuvanje.Korisnici.get(i).getImekorisnika();
						prez = Cuvanje.Korisnici.get(i).getPrezimekorisnika();

						ulogovan.setIdkorisnika(Cuvanje.Korisnici.get(i).getIdkorisnika());
						ulogovan.setImekorisnika(Cuvanje.Korisnici.get(i).getImekorisnika());
						ulogovan.setKorisnickoime(Cuvanje.Korisnici.get(i).getKorisnickoime());
						ulogovan.setLozinka(Cuvanje.Korisnici.get(i).getLozinka());
						ulogovan.setPrezimekorisnika(Cuvanje.Korisnici.get(i).getPrezimekorisnika());
						ulogovan.setTipkorisnika(Cuvanje.Korisnici.get(i).getTipkorisnika());

						Cuvanje.Korisnici.add(ulogovan);
						ArrayList<Korisnik> arrr = new ArrayList<Korisnik>();
						arrr.add(ulogovan);
						Cuvanje.SacuvajKorisnike("ulogovan.txt", arrr);
						try {
							Cuvanje.UcitajPredstave("predstave.txt");
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

						switch (k) {
						case ADMINISTRATOR:

							setTitle("Administrator: Prikaz svih predstava");
							admpocetna.tabela.getModel();
							setContentPane(admpocetna);
							revalidate();
							repaint();
							break;
						case KORISNIK:
							setTitle("Korisnik " + ime + " " + prez + " : Prikaz svih predstava");
							setContentPane(korpocetna);
							revalidate();
							repaint();
							break;
						default:
							break;
						}
						break;
					} else {
						if (sajz == i)
							greska(pocetni);
					}
				}

			}

		};

		pocetni.passwordText.addActionListener(pokretanje);
		pocetni.loginButton.addActionListener(pokretanje);

		pocetni.cancelButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
				PrintWriter writer = null;
				try {
					writer = new PrintWriter("ulogovan.txt");
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				writer.print("");
				writer.close();

			}
		});

		pocetni.regButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setTitle("Registracija novog korisnika");
				setContentPane(registracija);
				registracija.imeText.requestFocus(true);
				registracija.imeText.setText("");
				registracija.prezimeText.setText("");
				registracija.userText.setText("");
				registracija.passwordText.setText("");
				revalidate();
				repaint();
			}
		});

		Action regnovog = new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				Korisnik k = new Korisnik();
				int min = 10000;
				int max = 99999;
				int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);

				k.setKorisnickoime(registracija.userText.getText());
				k.setLozinka(registracija.passwordText.getText());
				k.setImekorisnika(registracija.imeText.getText());
				k.setPrezimekorisnika(registracija.prezimeText.getText());
				k.setTipkorisnika(TipKorisnika.KORISNIK);

				int m = 0;

				while (m == 0) {
					for (int i = 0; i < Cuvanje.Korisnici.size(); i++) {
						if (Cuvanje.Korisnici.get(i).getIdkorisnika() == randomNum) {
							randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
						} else {
							m = 1;
						}
					}
					m = 1;
				}

				k.setIdkorisnika(randomNum);

				Cuvanje.Korisnici.add(k);
				Cuvanje.SacuvajKorisnike("korisnici.txt", Cuvanje.Korisnici);

				setTitle("Logovanje u sistem");
				setContentPane(pocetni);
				pocetni.userText.requestFocus(true);
				pocetni.userText.setText("");
				pocetni.passwordText.setText("");
				revalidate();
				repaint();
			}
		};
		registracija.regButton.addActionListener(regnovog);
		registracija.passwordText.addActionListener(regnovog);

		registracija.cancelButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				setTitle("Logovanje u sistem");
				setContentPane(pocetni);
				pocetni.userText.setText("");
				pocetni.passwordText.setText("");
				revalidate();
				repaint();

			}
		});

		Action admlogout = new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setTitle("Logovanje u sistem");
				setContentPane(pocetni);
				pocetni.userText.setText("");
				pocetni.passwordText.setText("");
				pocetni.userText.requestFocus(true);
				revalidate();
				repaint();

			}
		};

		admpocetna.logout.addActionListener(admlogout);

		admpocetna.izvestaj.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setTitle("Administrator: Izveštaj o prodaji karata");
				setContentPane(admizvsvepred);
				revalidate();
				repaint();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				admpocetna.izvestaj.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});

		admizvsvepred.logout.addActionListener(admlogout);

		admizvsvepred.predstave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setTitle("Administrator: Prikaz svih predstava");
				setContentPane(admpocetna);
				revalidate();
				repaint();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				admizvsvepred.predstave.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});

		admizvpred.predstave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setTitle("Administrator: Prikaz svih predstava");
				setContentPane(admpocetna);
				revalidate();
				repaint();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				admizvpred.predstave.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});

		admizvpred.izvestaj.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setTitle("Administrator: Izveštaj o prodaji karata");
				setContentPane(admizvsvepred);
				revalidate();
				repaint();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				admizvpred.izvestaj.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});

		admizvpred.logout.addActionListener(admlogout);

		Action unosnovepred = new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setTitle("Administrator: Unos nove predstave");
				setContentPane(admnovapred);
				admnovapred.nazivPredTxt.requestFocus(true);
				admnovapred.idPredTxt.setText("");
				admnovapred.nazivPredTxt.setText("");
				admnovapred.opisPredTxt.setText("");
				admnovapred.datumPredTxt.setText("");
				admnovapred.vremePredTxt.setText("");
				admnovapred.cenaKarteTxt.setText("");
				revalidate();
				repaint();

			}
		};

		Action ocisti = new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setTitle("Administrator: Prikaz svih predstava");
				setContentPane(admpocetna);
				admpocetna.filterPredstava.setText("");
				admpocetna.filterCenaOd.setText("");
				admpocetna.filterCenaDo.setText("");
				admpocetna.filterDatumOd.setText("");
				admpocetna.filterDatumDo.setText("");

				admpocetna.tabela.repaint();
				revalidate();
				repaint();
			}
		};

		admpocetna.novaPred.addActionListener(unosnovepred);
		admpocetna.ocistiFormu.addActionListener(ocisti);

		Action ocistiFormu = new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setTitle("Administrator: Prikaz svih predstava");
				setContentPane(korpocetna);
				korpocetna.filterPredstava.setText("");
				korpocetna.filterCenaOd.setText("");
				korpocetna.filterCenaDo.setText("");
				korpocetna.filterDatumOd.setText("");
				korpocetna.filterDatumDo.setText("");

				korpocetna.tabela.repaint();
				revalidate();
				repaint();
			}
		};
		korpocetna.ocistiFormu.addActionListener(ocistiFormu);

		korpocetna.logout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setTitle("Logovanje u sistem");
				try {
					Cuvanje.Predstave = Cuvanje.UcitajPredstave("predstave.txt");
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				setContentPane(pocetni);
				pocetni.userText.setText("");
				pocetni.passwordText.setText("");
				pocetni.userText.requestFocus(true);
				revalidate();
				repaint();

			}
		});

		// PREDSTAVA ADMINISTRATOR

		Action novapredstava = new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				if (admnovapred.idPredTxt.getText().toString().equals("")) {

					Predstava p = new Predstava();
					int min = 10000;
					int max = 99999;
					int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);

					SimpleDateFormat formatDatuma = new SimpleDateFormat("dd.MM.yyyy");
					SimpleDateFormat formatVreme = new SimpleDateFormat("HH:mm");

					p.setNazivPredstave(admnovapred.nazivPredTxt.getText());
					p.setOpisPredstave(admnovapred.opisPredTxt.getText());
					Date datum;
					try {
						datum = formatDatuma.parse(admnovapred.datumPredTxt.getText());
						p.setDatumPredstave(datum);
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					Long vremeL;
					try {
						vremeL = formatVreme.parse(admnovapred.vremePredTxt.getText()).getTime();
						Time vreme = new Time(vremeL);
						p.setVremePredstave(vreme);
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					p.setCenaKarte(Integer.parseInt(admnovapred.cenaKarteTxt.getText()));

					int m = 0;

					while (m == 0) {
						for (int i = 0; i < Cuvanje.Predstave.size(); i++) {
							if (Cuvanje.Predstave.get(i).getIdPredstave() == randomNum) {
								randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
							} else {
								m = 1;
							}
						}
						m = 1;
					}

					p.setIdPredstave(randomNum);

					p.setRasprodato("NE");

					Cuvanje.Predstave.add(p);
					Cuvanje.SacuvajPredstavu("predstave.txt", Cuvanje.Predstave);

					if (admpocetna.modelPred.getRowCount() > 0) {
						for (int i = admpocetna.modelPred.getRowCount() - 1; i > -1; i--) {
							admpocetna.modelPred.removeRow(i);
						}
					}

					try {
						Cuvanje.Predstave = Cuvanje.UcitajPredstave("predstave.txt");
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					for (int i = 0; i < Cuvanje.Predstave.size(); i++) {

						admpocetna.modelPred.addRow(new Object[] { Cuvanje.Predstave.get(i).getNazivPredstave(),
								Cuvanje.Predstave.get(i).getDatumPredstave(), Cuvanje.Predstave.get(i).getCenaKarte(),
								Cuvanje.Predstave.get(i).getRasprodato(), Cuvanje.Predstave.get(i).getIdPredstave() });
					}
					setTitle("Administrator: Prikaz svih predstava");

					setContentPane(admpocetna);
					revalidate();
					repaint();
				} else {
					Predstava p = null;

					for (int i = 0; i < Cuvanje.Predstave.size(); i++) {
						if (Cuvanje.Predstave.get(i).getIdPredstave() == Integer
								.parseInt(admnovapred.idPredTxt.getText())) {

							p = Cuvanje.Predstave.get(i);
							Cuvanje.Predstave.remove(i);
							break;
						}
					}

					SimpleDateFormat formatDatuma = new SimpleDateFormat("dd.MM.yyyy");
					SimpleDateFormat formatVreme = new SimpleDateFormat("HH:mm");

					p.setNazivPredstave(admnovapred.nazivPredTxt.getText());
					p.setOpisPredstave(admnovapred.opisPredTxt.getText());
					Date datum;
					try {
						datum = formatDatuma.parse(admnovapred.datumPredTxt.getText());
						p.setDatumPredstave(datum);
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					Long vremeL;
					try {
						vremeL = formatVreme.parse(admnovapred.vremePredTxt.getText()).getTime();
						Time vreme = new Time(vremeL);
						p.setVremePredstave(vreme);
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					p.setCenaKarte(Integer.parseInt(admnovapred.cenaKarteTxt.getText()));

					p.setRasprodato("NE");

					Cuvanje.Predstave.add(p);
					Cuvanje.SacuvajPredstavu("predstave.txt", Cuvanje.Predstave);
					try {
						Cuvanje.Predstave = Cuvanje.UcitajPredstave("predstave.txt");
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					if (admpocetna.modelPred.getRowCount() > 0) {
						for (int i = admpocetna.modelPred.getRowCount() - 1; i > -1; i--) {
							admpocetna.modelPred.removeRow(i);
						}
					}

					for (int i = 0; i < Cuvanje.Predstave.size(); i++) {

						admpocetna.modelPred.addRow(new Object[] { Cuvanje.Predstave.get(i).getNazivPredstave(),
								Cuvanje.Predstave.get(i).getDatumPredstave(), Cuvanje.Predstave.get(i).getCenaKarte(),
								Cuvanje.Predstave.get(i).getRasprodato(), Cuvanje.Predstave.get(i).getIdPredstave() });
					}
					setTitle("Administrator: Prikaz svih predstava");

					setContentPane(admpocetna);
					revalidate();
					repaint();
				}
			}
		};

		admnovapred.sacuvajPred.addActionListener(novapredstava);
		admnovapred.cenaKarteTxt.addActionListener(novapredstava);

		admnovapred.logout.addActionListener(admlogout);
		admnovapred.ocistiFormu.addActionListener(unosnovepred);
		admnovapred.otkazi.addActionListener(pokretanje);

		Predstava izbor = new Predstava();

		korpocetna.tabela.addMouseListener(new java.awt.event.MouseAdapter() {

			@Override
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				int row = korpocetna.tabela.rowAtPoint(evt.getPoint());
				korpocetna.tabela.columnAtPoint(evt.getPoint());

				Integer idInfPred = (Integer) korpocetna.tabela.getValueAt(row, 4);

				for (int i = 0; i < Cuvanje.Predstave.size(); i++) {
					if (idInfPred.equals(Cuvanje.Predstave.get(i).getIdPredstave())) {
						izbor.setIdPredstave(Cuvanje.Predstave.get(i).getIdPredstave());
						izbor.setNazivPredstave(Cuvanje.Predstave.get(i).getNazivPredstave());
						izbor.setOpisPredstave(Cuvanje.Predstave.get(i).getOpisPredstave());
						izbor.setDatumPredstave(Cuvanje.Predstave.get(i).getDatumPredstave());
						izbor.setVremePredstave(Cuvanje.Predstave.get(i).getVremePredstave());
						izbor.setCenaKarte(Cuvanje.Predstave.get(i).getCenaKarte());

					}
				}

				ArrayList<Korisnik> ulogovan = Cuvanje.UcitajKorisnike("ulogovan.txt");
				String ime = ulogovan.get(0).getImekorisnika();
				String prez = ulogovan.get(0).getPrezimekorisnika();

				setTitle("Korisnik " + ime + " " + prez + ": Informacije o predstavi");
				setContentPane(korinfopred);

				korinfopred.idPredTxt.setText(izbor.getIdPredstave().toString());
				korinfopred.nazivPredTxt.setText(izbor.getNazivPredstave());
				korinfopred.opisPredTxt.setText(izbor.getOpisPredstave());
				DateFormat formdat = new SimpleDateFormat("dd.MM.yyyy");
				korinfopred.datumPredTxt.setText(formdat.format(izbor.getDatumPredstave()));
				DateFormat formvreme = new SimpleDateFormat("HH:mm");
				korinfopred.vremePredTxt.setText(formvreme.format(izbor.getVremePredstave()));
				korinfopred.cenaKarteTxt.setText(izbor.getCenaKarte().toString());

				revalidate();
				repaint();

				// Da očisti file "prodate.txt"

				PrintWriter writer = null;
				try {
					writer = new PrintWriter("prodate.txt");
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				writer.print("");
				writer.close();

			}

		});

		Action korrezerv = new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ArrayList<Korisnik> ulogovan = Cuvanje.UcitajKorisnike("ulogovan.txt");
				String ime = ulogovan.get(0).getImekorisnika();
				String prez = ulogovan.get(0).getPrezimekorisnika();

				Integer predizbor = izbor.getIdPredstave();

				ArrayList<Karta> prodate = new ArrayList<Karta>();
				try {
					Cuvanje.Karte = Cuvanje.UcitajKarte("karte.txt");
					for (int i = 0; i < Cuvanje.Karte.size(); i++) {
						if (predizbor.equals(Cuvanje.Karte.get(i).getIdPredstave())) {
							Karta filtkarte = new Karta();
							filtkarte.setCenaKarte(Cuvanje.Karte.get(i).getCenaKarte());
							filtkarte.setIdKarte(Cuvanje.Karte.get(i).getIdKarte());
							filtkarte.setIdKorisnika(Cuvanje.Karte.get(i).getIdKorisnika());
							filtkarte.setIdPredstave(Cuvanje.Karte.get(i).getIdPredstave());
							filtkarte.setSediste(Cuvanje.Karte.get(i).getSediste());
							prodate.add(filtkarte);

						}

					}
					Cuvanje.SacuvajKarte("prodate.txt", prodate);

				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				setTitle("Korisnik " + ime + " " + prez + ": Rezervacija karata");
				setContentPane(korrezkarte);
				korrezkarte.idpredstave = predizbor;
				korrezkarte.refreshdugme();
				String preds = korinfopred.nazivPredTxt.getText();
				korrezkarte.nazivPredTxt.setText(preds);
				revalidate();
				repaint();

			}
		};

		korinfopred.otkazi.addActionListener(pokretanje);
		korinfopred.logout.addActionListener(admlogout);
		korinfopred.rezervisi.addActionListener(korrezerv);

		Action vrati = new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setContentPane(korinfopred);
				revalidate();
				repaint();
			}

		};

		korrezkarte.logout.addActionListener(admlogout);
		korrezkarte.otkazi.addActionListener(vrati);

		admpocetna.tabela.addMouseListener(new java.awt.event.MouseAdapter() {

			@Override
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				int row = admpocetna.tabela.rowAtPoint(evt.getPoint());
				admpocetna.tabela.columnAtPoint(evt.getPoint());

				Integer idInfPred = (Integer) admpocetna.tabela.getValueAt(row, 4);

				for (int i = 0; i < Cuvanje.Predstave.size(); i++) {
					if (idInfPred.equals(Cuvanje.Predstave.get(i).getIdPredstave())) {
						izbor.setIdPredstave(Cuvanje.Predstave.get(i).getIdPredstave());
						izbor.setNazivPredstave(Cuvanje.Predstave.get(i).getNazivPredstave());
						izbor.setOpisPredstave(Cuvanje.Predstave.get(i).getOpisPredstave());
						izbor.setDatumPredstave(Cuvanje.Predstave.get(i).getDatumPredstave());
						izbor.setVremePredstave(Cuvanje.Predstave.get(i).getVremePredstave());
						izbor.setCenaKarte(Cuvanje.Predstave.get(i).getCenaKarte());
						izbor.setRasprodato(Cuvanje.Predstave.get(i).getRasprodato());

					}
				}

				setTitle("Administrator: Izmena informacija o predstavi");
				setContentPane(admnovapred);

				admnovapred.idPredTxt.setText(izbor.getIdPredstave().toString());
				admnovapred.nazivPredTxt.setText(izbor.getNazivPredstave());
				admnovapred.opisPredTxt.setText(izbor.getOpisPredstave());
				DateFormat formdat = new SimpleDateFormat("dd.MM.yyyy");
				admnovapred.datumPredTxt.setText(formdat.format(izbor.getDatumPredstave()));
				DateFormat formvreme = new SimpleDateFormat("HH:mm");
				admnovapred.vremePredTxt.setText(formvreme.format(izbor.getVremePredstave()));
				admnovapred.cenaKarteTxt.setText(izbor.getCenaKarte().toString());

				revalidate();
				repaint();

			}

		});

		admizvsvepred.tabela.addMouseListener(new java.awt.event.MouseAdapter() {

			@Override
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				int row = admizvsvepred.tabela.rowAtPoint(evt.getPoint());
				admizvsvepred.tabela.columnAtPoint(evt.getPoint());

				Integer idIzvPred = (Integer) admizvsvepred.tabela.getValueAt(row, 0);
				String nazPred = (String) admizvsvepred.tabela.getValueAt(row, 1);

				ArrayList<Karta> izvkarte = new ArrayList<Karta>();
				try {
					Cuvanje.UcitajKarte("karte.txt");
					for (int i = 0; i < Cuvanje.Karte.size(); i++) {
						if (idIzvPred.equals(Cuvanje.Karte.get(i).getIdPredstave())) {
							Karta karte = new Karta();
							karte.setCenaKarte(Cuvanje.Karte.get(i).getCenaKarte());
							karte.setIdKarte(Cuvanje.Karte.get(i).getIdKarte());
							karte.setIdKorisnika(Cuvanje.Karte.get(i).getIdKorisnika());
							karte.setIdPredstave(Cuvanje.Karte.get(i).getIdPredstave());
							karte.setSediste(Cuvanje.Karte.get(i).getSediste());
							izvkarte.add(karte);

						}
					}
					Cuvanje.SacuvajKarte("izvkarte.txt", izvkarte);

				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				try {
					admizvpred.izvestajkarte = Cuvanje.UcitajKarte("izvkarte.txt");
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				if (admizvpred.izvPred.getRowCount() > 0) {
					for (int i = admizvpred.izvPred.getRowCount() - 1; i > -1; i--) {
						admizvpred.izvPred.removeRow(i);
					}
				}

				Integer ukZarPre = 0;

				for (int i = 0; i < admizvpred.izvestajkarte.size(); i++) {

					admizvpred.izvPred.addRow(new Object[] { admizvpred.izvestajkarte.get(i).getIdKarte(),
							admizvpred.izvestajkarte.get(i).getSediste(),
							admizvpred.izvestajkarte.get(i).getCenaKarte(), });
					ukZarPre = ukZarPre + admizvpred.izvestajkarte.get(i).getCenaKarte();
				}

				admizvpred.ukupnaZaradaPred.setText(ukZarPre.toString());

				admizvpred.izvestajkarte = null;

				setTitle("Administrator: Izveštaj o prodaji za predstavu");
				setContentPane(admizvpred);

				admizvpred.nazivPredTxt.setText(nazPred);

				revalidate();
				repaint();

			}

		});

		Action rezervisiKartu = new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Karta krt = new Karta();
				int min = 10000;
				int max = 99999;
				int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);

				int m = 0;

				while (m == 0) {
					for (int i = 0; i < Cuvanje.Karte.size(); i++) {
						if (Cuvanje.Karte.get(i).getIdKarte() == randomNum) {
							randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
						} else {
							m = 1;
						}
					}
					m = 1;
				}

				krt.setIdKarte(randomNum);

				krt.setIdPredstave(izbor.getIdPredstave());
				krt.setCenaKarte(izbor.getCenaKarte());

				Integer sed = Integer.parseInt(korrezkarte.sedista.getSelection().getActionCommand());
				krt.setSediste(sed);

				// Podaci o korisniku
				ArrayList<Korisnik> ulogovan = Cuvanje.UcitajKorisnike("ulogovan.txt");
				Integer idKor = ulogovan.get(0).getIdkorisnika();
				krt.setIdKorisnika(idKor);

				Cuvanje.Karte.add(krt);
				Cuvanje.SacuvajKarte("karte.txt", Cuvanje.Karte);

				Cuvanje.GenerisiIzvestaj("izvestajsve.txt", Cuvanje.Izvestaji);
				Cuvanje.Izvestaji = Cuvanje.UcitajIzvestaje("izvestajsve.txt");
				ArrayList<Izvestaj> izv = Cuvanje.UcitajIzvestaje("izvestajsve.txt");

				for (int j = 0; j < Cuvanje.Izvestaji.size(); j++) {

					if (izbor.getIdPredstave().equals(izv.get(j).getIdPredstave())) {

						if (izv.get(j).getProdato() == 30) {
							izbor.setRasprodato("DA");
							break;
						} else {
							izbor.setRasprodato("NE");
						}

					}
				}

				for (int i = 0; i < Cuvanje.Predstave.size(); i++) {
					if (Cuvanje.Predstave.get(i).getIdPredstave() == izbor.getIdPredstave()) {

						Cuvanje.Predstave.remove(i);
						break;
					}
				}

				Cuvanje.Predstave.add(izbor);
				Cuvanje.SacuvajPredstavu("predstave.txt", Cuvanje.Predstave);
				try {
					Cuvanje.Predstave = Cuvanje.UcitajPredstave("predstave.txt");
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				if (korpocetna.modelPred.getRowCount() > 0) {
					for (int i = korpocetna.modelPred.getRowCount() - 1; i > -1; i--) {
						korpocetna.modelPred.removeRow(i);
					}
				}

				for (int i = 0; i < Cuvanje.Predstave.size(); i++) {
					korpocetna.modelPred.addRow(new Object[] { Cuvanje.Predstave.get(i).getNazivPredstave(),
							Cuvanje.Predstave.get(i).getDatumPredstave(), Cuvanje.Predstave.get(i).getCenaKarte(),
							Cuvanje.Predstave.get(i).getRasprodato(), Cuvanje.Predstave.get(i).getIdPredstave() });
				}

				if (admpocetna.modelPred.getRowCount() > 0) {
					for (int i = admpocetna.modelPred.getRowCount() - 1; i > -1; i--) {
						admpocetna.modelPred.removeRow(i);
					}
				}

				for (int i = 0; i < Cuvanje.Predstave.size(); i++) {
					admpocetna.modelPred.addRow(new Object[] { Cuvanje.Predstave.get(i).getNazivPredstave(),
							Cuvanje.Predstave.get(i).getDatumPredstave(), Cuvanje.Predstave.get(i).getCenaKarte(),
							Cuvanje.Predstave.get(i).getRasprodato(), Cuvanje.Predstave.get(i).getIdPredstave() });
				}

				potvrda(korrezkarte);

				revalidate();
				repaint();
			}

		};

		korrezkarte.rezervisi.addActionListener(rezervisiKartu);

	}

	public void potvrda(KorRezervacijaKarte korRezervacijaKarte) {
		UIManager.put("OptionPane.messageFont", new Font("Ubuntu Mono", Font.PLAIN, 16));
		UIManager.put("OptionPane.buttonFont", new Font("Ubuntu Mono", Font.PLAIN, 16));

		UIManager.put("OptionPane.background", new Color(194, 236, 235));
		UIManager.put("Panel.background", new Color(194, 236, 235));
		UIManager.put("OptionPane.messageForeground", new Color(8, 126, 139));
		UIManager.put("OptionPane.okButtonText", "Potvrdi");
		UIManager.put("OptionPane.button.background", new Color(255, 90, 95));
		JOptionPane.showConfirmDialog(korRezervacijaKarte, "Uspešno ste rezervisali kartu za sedište",
				"Potvrda rezervacije karte", JOptionPane.DEFAULT_OPTION);

	}

	public void greska(Logovanje pocetni) {
		UIManager.put("OptionPane.messageFont", new Font("Ubuntu Mono", Font.PLAIN, 16));
		UIManager.put("OptionPane.buttonFont", new Font("Ubuntu Mono", Font.PLAIN, 16));

		UIManager.put("OptionPane.background", new Color(194, 236, 235));
		UIManager.put("Panel.background", new Color(194, 236, 235));
		UIManager.put("OptionPane.messageForeground", new Color(8, 126, 139));
		UIManager.put("OptionPane.okButtonText", "Zatvori");
		UIManager.put("OptionPane.button.background", new Color(255, 90, 95));

		JOptionPane.showMessageDialog(pocetni, "Ne postoji registrovani korisnik sa tim podacima.", "GREŠKA!",
				JOptionPane.ERROR_MESSAGE);
		pocetni.userText.setText("");
		pocetni.passwordText.setText("");

	}
}
