public class Taxi {
	Corsa corsaInSvolgimento;
	Corsa[] corseEffettuate;
	private int totaleCorseEffetuate;
	
	public Taxi() {
		this.corsaInSvolgimento = null;
		this.corseEffettuate = new Corsa[5];
		this.totaleCorseEffetuate = 0;
	}
	
	public boolean nuovaCorsa(String destinazione) {
		if(this.isLibero() && destinazione != null && !destinazione.equalsIgnoreCase("") && this.getTotaleCorseEffettuate() < 5) {
			corsaInSvolgimento = new Corsa(destinazione);
			return true;
		}
		return false;
	}
	
	public void terminaCorsa(int kmPercorsi) {
		if(corsaInSvolgimento != null) {
			corsaInSvolgimento.aggiungiKm(kmPercorsi);
			if(this.corseEffettuate != null) {
				int i = 0;
				while(corseEffettuate[i] != null && i < corseEffettuate.length) {
					i++;
				}
				if(i < corseEffettuate.length) {
					corseEffettuate[i] = corsaInSvolgimento;
					totaleCorseEffetuate++;
					corsaInSvolgimento = null;
				}
			}
		}
	}
	
	public int getTotaleCorseEffettuate() {
		return totaleCorseEffetuate;
	}

	public boolean isLibero() {
		if(this.corsaInSvolgimento == null) {
			return true;
		}
		return false;
	}

	public Corsa trovaCorsaConCostoMaggiore(String destinazione) {
		Corsa max = null;
		if(corseEffettuate != null) {
			for(int i = 0; i< corseEffettuate.length; i++) {
				if(corseEffettuate[i] != null && corseEffettuate[i].getDestinazione().equalsIgnoreCase(destinazione)) {
					if(max == null || corseEffettuate[i].calcolaTariffa() > max.calcolaTariffa()) {
						max = corseEffettuate[i];
					}
				}
			}
		}
		return max;
	}
}
