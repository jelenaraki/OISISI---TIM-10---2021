package pozoriste_package;

import pozoriste_package.TipKorisnika;

public class Korisnik {
	private String korisnickoIme;
	private String lozinka;
	private String imeKorisnika;
	private String prezimeKorisnika;
	private TipKorisnika tipKorisnika;
	private Integer idKorisnika;
//	private Integer[] kupljeneKarte;

	public Korisnik() {
		super();
	}

	public Korisnik(String korisnickoIme, String lozinka, String imeKorisnika, String prezimeKorisnika,
			TipKorisnika tipKorisnika, Integer idKorisnika) {
		super();
		this.korisnickoIme = korisnickoIme;
		this.lozinka = lozinka;
		this.imeKorisnika = imeKorisnika;
		this.prezimeKorisnika = prezimeKorisnika;
		this.tipKorisnika = tipKorisnika;
		this.idKorisnika = idKorisnika;
//		this.kupljeneKarte = kupljeneKarte;
	}

	
//	public Integer[] getKupljeneKarte() {
//		return kupljeneKarte;
//	}

//	public void setKupljeneKarte(Integer[] kupljeneKarte) {
//		this.kupljeneKarte = kupljeneKarte;
//	}

	public Integer getIdkorisnika() {
		return idKorisnika;
	}

	public void setIdkorisnika(Integer idKorisnika) {
		this.idKorisnika = idKorisnika;
	}

	public String getKorisnickoime() {
		return korisnickoIme;
	}

	public void setKorisnickoime(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}

	public String getImekorisnika() {
		return imeKorisnika;
	}

	public void setImekorisnika(String imeKorisnika) {
		this.imeKorisnika = imeKorisnika;
	}

	public String getPrezimekorisnika() {
		return prezimeKorisnika;
	}

	public void setPrezimekorisnika(String prezimeKorisnika) {
		this.prezimeKorisnika = prezimeKorisnika;
	}

	public TipKorisnika getTipkorisnika() {
		return tipKorisnika;
	}

	public void setTipkorisnika(TipKorisnika tipKorisnika) {
		this.tipKorisnika = tipKorisnika;
	}
}