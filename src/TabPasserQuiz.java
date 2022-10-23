import java.io.*;
import java.util.ArrayList;

//Clase TabPasserQuiz
public class TabPasserQuiz {
	//Attribut du TabPasserQuiz
	private ArrayList<PasserQuiz> tabPass;
	
	//Méthodes du TabPasserQuiz  
	
	//Constructeur non parametré
	public TabPasserQuiz() {
		tabPass = new ArrayList<PasserQuiz>();
	}
	
	//getteur du PasserQuiz
	public PasserQuiz getPasserQuiz(int i) {
		return tabPass.get(i);
	}
	
	//Méthode pour afficher des etudiants qui ont le quiz avec le thème donné
	public void afficheEtudiants(String theme) {
		for (int i=0;i<tabPass.size();i++) {
			if (tabPass.get(i).getQuiz().getTheme().toUpperCase().equals(theme.toUpperCase())) {
				System.out.println(tabPass.get(i).getEtudiant().getNom()+" "+tabPass.get(i).getEtudiant().getPrenom()+" ----- "+tabPass.get(i).getScore()+"%");
			}
		}
	}
	
	//Méthode pour afficher les quiz qui ont été passé par un étudiant donné
	public void afficheQuiz (Etudiant e) {
		for (int i=0;i<tabPass.size();i++) {
			if (tabPass.get(i).getEtudiant().getcin().equals(e.getcin())) {
				System.out.println(tabPass.get(i).getQuiz().getTheme()+" --> "+tabPass.get(i).getScore());
			}
		}
	}
	
	//Méthode pour vérifier si un étudiant donné a passé un quiz donné
	public boolean existPass (Quiz q, Etudiant e) {
		boolean b=false;
		for (int i=0;i<tabPass.size();i++) {
			if ((tabPass.get(i).getQuiz().getTheme().toUpperCase().equals(q.getTheme().toUpperCase()))&&(tabPass.get(i).getEtudiant().getcin().equals(e.getcin()))) {
				b=true;
				break;
			}
		}
		return b;
	}
	
	//Méthode pour vérifier si un étudiant donné a passé un quiz avec un thème donné
	public boolean existPass (String theme, Etudiant e) {
		boolean b=false;
		for (int i=0;i<tabPass.size();i++) {
			if ((tabPass.get(i).getQuiz().getTheme().toUpperCase().equals(theme.toUpperCase()))&&(tabPass.get(i).getEtudiant().getcin().equals(e.getcin()))) {
				b=true;
				break;
			}
		}
		return b;
	}
	
	//Méthode d'ajout d'un PasserQuiz
	public void add(PasserQuiz pq) {
		tabPass.add(pq);
	}


}
