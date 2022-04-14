public class Corsa {
	private String destinazione;
	private double costoKm;
	private int kmPercorsi;
	
	public Corsa(String destinazione, double costoKm) {
		this.destinazione = destinazione;
		this.costoKm = costoKm;
		this.kmPercorsi = 0;
	}
	
	public Corsa(String destinazione) {
		this(destinazione, 0.5);
	}
	
	public void aggiungiKm(int kmPercorsi) {
		if(kmPercorsi > 0) {
			this.kmPercorsi += kmPercorsi;
		}
	}
	
	public double calcolaTariffa() {
		return getCostoKm() * getKmPercorsi();
	}
	
	public double calcolaTariffa(double supplemento) {
		return supplemento + calcolaTariffa();
	}

	public String getDestinazione() {
		return destinazione;
	}

	public double getCostoKm() {
		return costoKm;
	}

	public int getKmPercorsi() {
		return kmPercorsi;
	}	
}
