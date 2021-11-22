package Banque;



public class Banque_Impl extends BanquePOA {
	private float solde;
	
	public Banque_Impl(float solde) {
		this.solde=solde;
	}
	@Override
	public void debiter(float solde) {
		this.solde += solde;

	}

	@Override
	public void crediter(float solde) {
		if (this.solde >= solde)
			this.solde -= solde;
	}

	@Override
	public float lire_compte() {
		return this.solde;
	}

}
