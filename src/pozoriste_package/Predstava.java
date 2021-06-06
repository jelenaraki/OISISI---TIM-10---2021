package pozoriste_package;

import java.util.Date;
import java.sql.Time;
import java.util.ArrayList;

public class Predstava {
	private Integer idPredstave;
	private String nazivPredstave;
	private String opisPredstave;
	private Date datumPredstave;
	private Time vremePredstave;
	private Integer cenaKarte;
	private String rasprodato;
	private Integer[][] sedista;


	public Predstava() {
		super();
	}
	
	public Predstava(Integer idPredstave, String nazivPredstave, String opisPredstave, Date datumPredstave,
			Time vremePredstave, Integer cenaKarte, String rasprodato, Integer[][]sedista) {
			super();
			this.idPredstave = idPredstave;
			this.nazivPredstave = nazivPredstave;
			this.opisPredstave = opisPredstave;
			this.datumPredstave = datumPredstave;
			this.vremePredstave = vremePredstave;
			this.cenaKarte = cenaKarte;
			this.rasprodato = rasprodato;
			this.sedista = sedista;
			
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

	public String getOpisPredstave() {
		return opisPredstave;
	}

	public void setOpisPredstave(String opisPredstave) {
		this.opisPredstave = opisPredstave;
	}

	public Date getDatumPredstave() {
		return datumPredstave;
	}

	public void setDatumPredstave(Date datumPredstave) {
		this.datumPredstave = datumPredstave;
	}

	public Time getVremePredstave() {
		return vremePredstave;
	}

	public void setVremePredstave(Time vremePredstave) {
		this.vremePredstave = vremePredstave;
	}

	public Integer getCenaKarte() {
		return cenaKarte;
	}

	public void setCenaKarte(Integer cenaKarte) {
		this.cenaKarte = cenaKarte;
	}


	public String getRasprodato() {
		return rasprodato;
	}

	public void setRasprodato(String rasprodato) {
		this.rasprodato = rasprodato;
	}

	public Integer[][] getSedista() {
		return sedista;
	}

	public void setSedista(Integer[][] sedista) {
		this.sedista = sedista;
	}
	
}