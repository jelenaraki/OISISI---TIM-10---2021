package pozoriste_package;

public class Izvestaj {
	private Integer idPredstave;
	private String nazivPredstave;
	private Integer cenaKarte;
	private Integer prodato;
	private Integer zarada;

	public Izvestaj() {
		super();
	}

	public Izvestaj(Integer idPredstave, String nazivPredstave, Integer cenaKarte, Integer prodato, Integer zarada) {
		super();
		this.idPredstave = idPredstave;
		this.nazivPredstave = nazivPredstave;
		this.cenaKarte = cenaKarte;
		this.prodato = prodato;
		this.zarada = zarada;

	}

	public Integer getIdPredstave() {
		return idPredstave;
	}

	public void setIdPredstave(Integer idPredstave) {
		this.idPredstave = idPredstave;
	}

	public String getNazivPredstave() {
		return nazivPredstave;
	}

	public void setNazivPredstave(String nazivPredstave) {
		this.nazivPredstave = nazivPredstave;
	}

	public Integer getCenaKarte() {
		return cenaKarte;
	}

	public void setCenaKarte(Integer cenaKarte) {
		this.cenaKarte = cenaKarte;
	}

	public Integer getProdato() {
		return prodato;
	}

	public void setProdato(Integer prodato) {
		this.prodato = prodato;
	}

	public Integer getZarada() {
		return zarada;
	}

	public void setZarada(Integer zarada) {
		this.zarada = zarada;
	}

}
