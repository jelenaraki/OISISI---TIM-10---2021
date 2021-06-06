package pozoriste_package;

public class Karta {
	private Integer idKarte;
	private Integer idPredstave;
	private Integer idKorisnika;
	private Integer sediste;
	private Integer cenaKarte;
	
	public Karta() {
		super();
	}
	
	public Karta(Integer idKarte, Integer idPredstave, Integer idKorisnika, Integer sediste, Integer cenaKarte) {
		super();
		this.idKarte = idKarte;
		this.idPredstave = idPredstave;
		this.idKorisnika = idKorisnika;
		this.sediste = sediste;
		this.cenaKarte = cenaKarte;
		
	}

	public Integer getIdKarte() {
		return idKarte;
	}

	public void setIdKarte(Integer idKarte) {
		this.idKarte = idKarte;
	}

	public Integer getIdPredstave() {
		return idPredstave;
	}

	public void setIdPredstave(Integer idPredstave) {
		this.idPredstave = idPredstave;
	}

	public Integer getIdKorisnika() {
		return idKorisnika;
	}

	public void setIdKorisnika(Integer idKorisnika) {
		this.idKorisnika = idKorisnika;
	}

	public Integer getSediste() {
		return sediste;
	}

	public void setSediste(Integer sediste) {
		this.sediste = sediste;
	}

	public Integer getCenaKarte() {
		return cenaKarte;
	}

	public void setCenaKarte(Integer cenaKarte) {
		this.cenaKarte = cenaKarte;
	}

	
}
