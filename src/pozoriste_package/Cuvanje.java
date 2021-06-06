package pozoriste_package;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Cuvanje {

	public static ArrayList<Korisnik> Korisnici = new ArrayList<Korisnik>();
	public static ArrayList<Korisnik> Ulogovan = new ArrayList<Korisnik>();
	public static ArrayList<Predstava> Predstave = new ArrayList<Predstava>();
	public static ArrayList<Karta> Karte = new ArrayList<Karta>();
	public static ArrayList<Izvestaj> Izvestaji = new ArrayList<Izvestaj>();

	public static void SacuvajKorisnike(String fileName, ArrayList<Korisnik> Korisnici) {
		// The name of the file to open.

		try {
			// Assume default encoding.
			FileWriter fileWriter = new FileWriter(fileName);

			// Always wrap FileWriter in BufferedWriter.
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

			for (int i = 0; i < Korisnici.size(); i++) {
				bufferedWriter.write(Korisnici.get(i).getKorisnickoime() + '|');
				bufferedWriter.write(Korisnici.get(i).getLozinka() + '|');
				bufferedWriter.write(Korisnici.get(i).getImekorisnika() + '|');
				bufferedWriter.write(Korisnici.get(i).getPrezimekorisnika() + '|');
				bufferedWriter.write(Korisnici.get(i).getTipkorisnika().toString() + '|');
				bufferedWriter.write(Korisnici.get(i).getIdkorisnika().toString());
				bufferedWriter.newLine();
			}

			// Always close files.
			bufferedWriter.close();
		} catch (IOException ex) {
			System.out.println("Greška pri upisivanju u fajl '" + fileName + "'");
			// Or we could just do this:
			// ex.printStackTrace();
		}
	}

	public static ArrayList<Korisnik> UcitajKorisnike(String fileName) {
		try {
			File myObj = new File(fileName);
			Scanner myReader = new Scanner(myObj);
			ArrayList<Korisnik> korisnik = new ArrayList<Korisnik>();

			while (myReader.hasNextLine()) {

				String data = myReader.nextLine();
				if (!data.equals("")) {
					String[] niz = data.split("\\|");
					Korisnik k = new Korisnik();
					k.setKorisnickoime(niz[0]);
					k.setLozinka(niz[1]);
					k.setImekorisnika(niz[2]);
					k.setPrezimekorisnika(niz[3]);
					if (niz[4].equals("KORISNIK")) {
						k.setTipkorisnika(TipKorisnika.KORISNIK);
					} else {
						k.setTipkorisnika(TipKorisnika.ADMINISTRATOR);
					}
					k.setIdkorisnika(Integer.parseInt(niz[5]));
					korisnik.add(k);
					// System.out.println(data);
				}

			}
			myReader.close();

			return korisnik;

		} catch (FileNotFoundException e) {
			System.out.println("Nastala je greška.");
			e.printStackTrace();
		}
		return null;

		// PREDSTAVE

	}

	public static void SacuvajPredstavu(String fileName, ArrayList<Predstava> Predstave) {
		// The name of the file to open.

		try {
			// Assume default encoding.
			FileWriter fileWriter = new FileWriter(fileName);

			// Always wrap FileWriter in BufferedWriter.
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

			for (int i = 0; i < Predstave.size(); i++) {
				bufferedWriter.write(Predstave.get(i).getNazivPredstave() + '|');
				bufferedWriter.write(Predstave.get(i).getOpisPredstave() + '|');
				SimpleDateFormat formatDatuma = new SimpleDateFormat("dd.MM.yyyy");
				String datumString = formatDatuma.format(Predstave.get(i).getDatumPredstave());
				bufferedWriter.write(datumString + '|');
				SimpleDateFormat formatVreme = new SimpleDateFormat("HH:mm");
				String vremeString = formatVreme.format(Predstave.get(i).getVremePredstave());

				bufferedWriter.write(vremeString + '|');
				bufferedWriter.write(Predstave.get(i).getCenaKarte().toString() + '|');
				bufferedWriter.write(Predstave.get(i).getIdPredstave().toString() + '|');
				bufferedWriter.write(Predstave.get(i).getRasprodato());
				bufferedWriter.newLine();
			}

			// Always close files.
			bufferedWriter.close();
		} catch (IOException ex) {
			System.out.println("Greška pri upisivanju u fajl '" + fileName + "'");
			// Or we could just do this:
			// ex.printStackTrace();
		}
	}

	public static ArrayList<Predstava> UcitajPredstave(String fileName) throws ParseException {
		try {
			File myObj = new File(fileName);
			Scanner myReader = new Scanner(myObj);
			ArrayList<Predstava> predstava = new ArrayList<Predstava>();
			SimpleDateFormat formatDatuma = new SimpleDateFormat("dd.MM.yyyy");
			SimpleDateFormat formatVreme = new SimpleDateFormat("HH:mm");

			while (myReader.hasNextLine()) {

				String data = myReader.nextLine();
				if (!data.equals("")) {
					String[] niz = data.split("\\|");
					Predstava p = new Predstava();
					p.setNazivPredstave(niz[0]);
					p.setOpisPredstave(niz[1]);
					Date datumD = formatDatuma.parse(niz[2]);
					p.setDatumPredstave(datumD);
					Long vremeL = formatVreme.parse(niz[3]).getTime();
					Time vreme = new Time(vremeL);
					p.setVremePredstave(vreme);
					p.setCenaKarte(Integer.parseInt(niz[4]));
					p.setIdPredstave(Integer.parseInt(niz[5]));
					p.setRasprodato(niz[6]);
					predstava.add(p);
					// System.out.println(data);
				}

			}
			myReader.close();

			return predstava;

		} catch (FileNotFoundException e) {
			System.out.println("Nastala je greška.");
			e.printStackTrace();
		}
		return null;
	}

// KARTE

	public static void SacuvajKarte(String fileName, ArrayList<Karta> Karte) {
		// The name of the file to open

		try {
			// Assume default encoding.
			FileWriter fileWriter = new FileWriter(fileName);

			// Always wrap FileWriter in BufferedWriter.
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

			for (int i = 0; i < Karte.size(); i++) {
				bufferedWriter.write(Karte.get(i).getIdKarte().toString() + '|');
				bufferedWriter.write(Karte.get(i).getIdPredstave().toString() + '|');
				bufferedWriter.write(Karte.get(i).getIdKorisnika().toString() + '|');
				bufferedWriter.write(Karte.get(i).getSediste().toString() + '|');
				bufferedWriter.write(Karte.get(i).getCenaKarte().toString());
				bufferedWriter.newLine();
			}

			// Always close files.
			bufferedWriter.close();
		} catch (IOException ex) {
			System.out.println("Greška pri upisivanju u fajl '" + fileName + "'");
			// Or we could just do this:
			// ex.printStackTrace();
		}
	}

	public static ArrayList<Karta> UcitajKarte(String fileName) throws ParseException {
		try {
			File myObj = new File(fileName);
			Scanner myReader = new Scanner(myObj);
			ArrayList<Karta> karte = new ArrayList<Karta>();

			while (myReader.hasNextLine()) {

				String data = myReader.nextLine();
				if (!data.equals("")) {
					String[] niz = data.split("\\|");
					Karta k = new Karta();
					k.setIdKarte(Integer.parseInt(niz[0]));
					k.setIdPredstave(Integer.parseInt(niz[1]));
					k.setIdKorisnika(Integer.parseInt(niz[2]));
					k.setSediste(Integer.parseInt(niz[3]));
					k.setCenaKarte(Integer.parseInt(niz[4]));
					karte.add(k);
					// System.out.println(data);
				}
			}
			myReader.close();

			return karte;
		} catch (FileNotFoundException e) {
			System.out.println("Nastala je greška.");
			e.printStackTrace();
		}
		return null;
	}

	// IZVEŠTAJ

	public static void GenerisiIzvestaj(String fileName, ArrayList<Izvestaj> Izvestaji) {
		// The name of the file to open.

		try {
			// Assume default encoding.
			FileWriter fileWriter = new FileWriter(fileName);

			// Always wrap FileWriter in BufferedWriter.
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

			Integer idPred;
			String nazPred = new String();
			Integer cenKarte;
			Integer prodato;
			Integer zarada;

			for (int i = 0; i < Predstave.size(); i++) {
				idPred = Predstave.get(i).getIdPredstave();
//		         	Izvestaji.get(i).setIdPredstave(idPred);
				nazPred = Predstave.get(i).getNazivPredstave();
//		        	Izvestaji.get(i).setNazivPredstave(nazPred);
				cenKarte = Predstave.get(i).getCenaKarte();
//		        	Izvestaji.get(i).setCenaKarte(cenKarte);
				prodato = 0;
				zarada = 0;
				for (int j = 0; j < Karte.size(); j++) {
					if (Karte.get(j).getIdPredstave().equals(idPred)) {
						prodato = prodato + 1;
						zarada = zarada + Karte.get(j).getCenaKarte();
					}
				}
//		        	Izvestaji.get(i).setProdato(prodato);
//		        	zarada = prodato * cenKarte;
//		        	Izvestaji.get(i).setZarada(zarada);
				bufferedWriter.write(idPred.toString() + '|');
				bufferedWriter.write(nazPred + '|');
				bufferedWriter.write(cenKarte.toString() + '|');
				bufferedWriter.write(prodato.toString() + '|');
				bufferedWriter.write(zarada.toString());
				bufferedWriter.newLine();

			}

			// Always close files.
			bufferedWriter.close();
		} catch (IOException ex) {
			System.out.println("Greška pri upisivanju u fajl '" + fileName + "'");
			// Or we could just do this:
			// ex.printStackTrace();
		}
	}

	public static ArrayList<Izvestaj> UcitajIzvestaje(String fileName) {
		try {
			File myObj = new File(fileName);
			Scanner myReader = new Scanner(myObj);
			ArrayList<Izvestaj> izvestaji = new ArrayList<Izvestaj>();

			while (myReader.hasNextLine()) {

				String data = myReader.nextLine();
				if (!data.equals("")) {
					String[] niz = data.split("\\|");
					Izvestaj iz = new Izvestaj();
					iz.setIdPredstave(Integer.parseInt(niz[0]));
					iz.setNazivPredstave(niz[1]);
					iz.setCenaKarte(Integer.parseInt(niz[2]));
					iz.setProdato(Integer.parseInt(niz[3]));
					iz.setZarada(Integer.parseInt(niz[4]));
					izvestaji.add(iz);
					// System.out.println(data);
				}

			}
			myReader.close();

			return izvestaji;

		} catch (FileNotFoundException e) {
			System.out.println("Nastala je greška.");
			e.printStackTrace();
		}
		return null;
	}

}
