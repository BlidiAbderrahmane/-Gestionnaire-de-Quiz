import java.io.*;
import java.util.ArrayList;

//Clase TabPasserQuiz
public class TabPasserQuiz {
	//Attribut du TabPasserQuiz
	private ArrayList<PasserQuiz> tabPass;
	
	//M�thodes du TabPasserQuiz  
	
	//Constructeur non parametr�
	public TabPasserQuiz() {
		tabPass = new ArrayList<PasserQuiz>();
	}
	
	//getteur du PasserQuiz
	public PasserQuiz getPasserQuiz(int i) {
		return tabPass.get(i);
	}
	
	//M�thode pour afficher des etudiants qui ont le quiz avec le th�me donn�
	public void afficheEtudiants(String theme) {
		for (int i=0;i<tabPass.size();i++) {
			if (tabPass.get(i).getQuiz().getTheme().toUpperCase().equals(theme.toUpperCase())) {
				System.out.println(tabPass.get(i).getEtudiant().getNom()+" "+tabPass.get(i).getEtudiant().getPrenom()+" ----- "+tabPass.get(i).getScore()+"%");
			}
		}
	}
	
	//M�thode pour afficher les quiz qui ont �t� pass� par un �tudiant donn�
	public void afficheQuiz (Etudiant e) {
		for (int i=0;i<tabPass.size();i++) {
			if (tabPass.get(i).getEtudiant().getcin().equals(e.getcin())) {
				System.out.println(tabPass.get(i).getQuiz().getTheme()+" --> "+tabPass.get(i).getScore());
			}
		}
	}
	
	//M�thode pour v�rifier si un �tudiant donn� a pass� un quiz donn�
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
	
	//M�thode pour v�rifier si un �tudiant donn� a pass� un quiz avec un th�me donn�
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
	
	//M�thode d'ajout d'un PasserQuiz
	public void add(PasserQuiz pq) {
		tabPass.add(pq);
	}


}
