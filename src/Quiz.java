import java.util.ArrayList;
//Classe Quiz
public class Quiz {
	//Attributs du Quiz
	private String theme;
	private String auteur;
	private ArrayList <QCM> tabQCM;
	
	//M�thodes du Quiz
	
	//Constructeur non parametr�
	public Quiz() {
		tabQCM= new ArrayList<QCM>();
		theme="";
		auteur="";
	}
	
	//Constructeur parametr�
	public Quiz(String theme, String auteur) {
		tabQCM= new ArrayList<QCM>();
		this.theme=theme;
		this.auteur=auteur;
	}
	
	//M�thode d'ajout d'1 QCM
	public void addQCM (QCM q) {
		tabQCM.add(q);
	}
	
	//getteur du theme
	public String getTheme() {
		return theme;
	}
	
	//getteur du numero CIN d'auteur
	public String getAuteur() {
		return auteur;
	}
	
	//getteur du QCM d'indice i
	public QCM getQCM(int i) {
		return tabQCM.get(i);
	}
	
	//getteur du nombre de QCM
	public int getNbrQCM() {
		return tabQCM.size();
	}
}
