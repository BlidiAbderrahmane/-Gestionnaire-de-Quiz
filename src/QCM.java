import java.util.ArrayList;
//Classe QCM
public class QCM {
	//Attributs QCM
	private int numQCM;
	private String texteQCM;
	private ArrayList <Option> optionQCM;
	private int nbrep;
	private int nbrepvrai;
	
	//M�thodes QCM
	
	//constructeur parametr�
	public QCM(int numQCM, String texteQCM) {
		optionQCM= new ArrayList<Option>();
		this.numQCM=numQCM;
		this.texteQCM=texteQCM;
		nbrep=0;
		nbrepvrai=0;
	}
	
	//M�thode d'ajout d'un option
	public void addOption(Option o) {
		optionQCM.add(o);
	}
	
	//M�thode pour v�rifier si il y a une seule option valide
	public boolean oneValid() {
		int n=0;
		//parcours le tableau des options
		for (int i=0;i<optionQCM.size();i++) {
			if (optionQCM.get(i).getReponse()==true) {
				n++;
			}
		}
		return (n==1);
	}
	
	//m�thode retourne le nombre d'option valide
	public int nbValide() {
		int n=0;
		//parcours le tableau des options
		for (int i=0;i<optionQCM.size();i++) {
			if (optionQCM.get(i).getReponse())
			{
				n=optionQCM.get(i).getNumero();
				break;
			}
		}
		return n;
	}
	
	//getteur du numero
	public int getNumQCM() {
		return numQCM;
	}
	
	//getteur du texte
	public String getTexteQCM() {
		return texteQCM;
	}
	
	//getteur du nombre d'options
	public int getNbrOption() {
		return optionQCM.size()	;
	}
	
	//getteur d'option d'indice i
	public Option getOption (int i) {
		return optionQCM.get(i);
	}
	
	//getteur du nombre total des �tudiants qui ont r�pondu ce QCM
	public int getNbrep (int i) {
		return nbrep;
	}
	
	//getteur du nombre total des �tudiants qui ont r�pondu ce QCM avec succ�s
	public int getNbrepVrai (int i) {
		return nbrepvrai;
	}
	
	//incrementation d'attribut nbrep
	public void increment_nbrep() {
		nbrep++;
	}
	
	//incrementation d'attribut nbrepvrai
	public void increment_nbrepbVrai() {
		nbrepvrai++;
	}
	
}
