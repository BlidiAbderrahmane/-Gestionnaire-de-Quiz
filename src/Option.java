//Classe Option
public class Option {
	//Attributs d'Option
	private int nbOp;
	private String texteOp;
	private boolean reponse;
	
	//Méthodes d'Option
	
	//Constructeur parametré
	public Option (int nb, String txt, boolean rep) {
		nbOp = nb;
		texteOp = txt;
		reponse = rep;
	}
	
	//getteur du numero d'option
	public int getNumero() {
		return nbOp;
	}
	
	//getteur du réponse
	public boolean getReponse() {
		return reponse;
	}
	
	//getteur du texte
	public String getTexte() {
		return texteOp;
	}
}
