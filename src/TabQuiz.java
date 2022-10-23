import java.io.*;
import java.util.ArrayList;

//Classe TabQuiz
public class TabQuiz {
	//Attribut du TabQuiz
	private ArrayList<Quiz> tabQuiz;
	
	//M�thode du TabQuiz
	
	//constructeur non parametr�
	public TabQuiz() {
		tabQuiz = new ArrayList <Quiz>();
	}

	//M�thode pour v�rifier si il y a un quiz avec un th�me donn�
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
	
	//M�thode pour retourner la position d'un quiz avec un th�me donn�
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
	
	//getter du Quiz avec un th�me donn�
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
	
	//M�thode d'ajout d'un quiz donn�
	public void addQuiz (Quiz q) {
		tabQuiz.add(q);
	}
	
	//M�thode pour remplacer un quiz au indice i par un autre quiz q donn�
	public void setQuiz (int i,Quiz q) {
		tabQuiz.set(i, q);
	}
	
	//M�thode pour supprimer un quiz avec un th�me donn�
	public void supp(String theme) {
		for (int i=0;i<tabQuiz.size();i++) {
			if (tabQuiz.get(i).getTheme().toUpperCase().equals(theme.toUpperCase())) {
				tabQuiz.remove(i);
				break;
			}
		}
	}
	
}
