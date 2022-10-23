import java.io.*;
import java.util.ArrayList;

//Classe TabQuiz
public class TabQuiz {
	//Attribut du TabQuiz
	private ArrayList<Quiz> tabQuiz;
	
	//Méthode du TabQuiz
	
	//constructeur non parametré
	public TabQuiz() {
		tabQuiz = new ArrayList <Quiz>();
	}

	//Méthode pour vérifier si il y a un quiz avec un thème donné
	public boolean existTheme(String theme) {
		boolean b = false;
		for (int i=0;i<tabQuiz.size();i++) {
			if (tabQuiz.get(i).getTheme().toUpperCase().equals(theme.toUpperCase() ) ) {
				b=true;
				break;
			}
		}
		return b;
	}
	
	//Méthode pour retourner la position d'un quiz avec un thème donné
	public int pos (String theme) {
		int p=-1;
		for (int i=0;i<tabQuiz.size();i++) {
			if (tabQuiz.get(i).getTheme().toUpperCase().equals(theme.toUpperCase())) {
				p=i;
				break;
			}
		}
		return p;
	}
	
	//getter du Quiz avec un thème donné
	public Quiz getQuiz (String theme) {
		Quiz q=new Quiz();
		for (int i=0;i<tabQuiz.size();i++)
		{
			if (tabQuiz.get(i).getTheme().toUpperCase().equals(theme.toUpperCase())) {
				q=tabQuiz.get(i);
				break;
			}
		}
		return q;
	}
	
	//getteur du quiz avec indice i
	public Quiz getQuiz (int i) {
		return tabQuiz.get(i);
	}
	
	//getteur du nombre des quiz
	public int getTaille () {
		return tabQuiz.size();
	}
	
	//Méthode d'ajout d'un quiz donné
	public void addQuiz (Quiz q) {
		tabQuiz.add(q);
	}
	
	//Méthode pour remplacer un quiz au indice i par un autre quiz q donné
	public void setQuiz (int i,Quiz q) {
		tabQuiz.set(i, q);
	}
	
	//Méthode pour supprimer un quiz avec un thème donné
	public void supp(String theme) {
		for (int i=0;i<tabQuiz.size();i++) {
			if (tabQuiz.get(i).getTheme().toUpperCase().equals(theme.toUpperCase())) {
				tabQuiz.remove(i);
				break;
			}
		}
	}
	
}
