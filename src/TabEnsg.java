import java.io.*;
import java.util.ArrayList;
import library.meths;
import java.util.Scanner;

//Classe TabEnsg
public class TabEnsg {
	//Attribut du TabEnsg
	private ArrayList<Enseignant>tabEn;
	
//	public void afficher() {
//		System.out.println("Tableau d'enseignants : ");
//		for (int i=0;i<tabEn.size();i++)
//			System.out.println("Enseignant "+i+" : "+tabEn.get(i).toString());
//	}
	
	//Méthodes du TabEnsg
	
	//Constructeur non parametré
	public TabEnsg() {
		tabEn = new ArrayList <Enseignant> ();
	}
	
	//Méthode d'ajout d'un enseignant
	public void add (Enseignant e) {
		tabEn.add(e);
	}
	
	
	//Méthode qui retourne la position d'enseignant avec numero de CIN donné
	public int pos(String ncinEN) {
		int test = -1;
		//parcours du tableau d'enseignants
		for (int i = 0; (i < tabEn.size() ); i++) {
			Enseignant E= tabEn.get(i);
			if ( E.getcin().equals(ncinEN)) {
				test=i;
				break;
			}
			
		}
		return test;
	}
	
	//getteur du nom
	public String getNom (String ncin) {
		String nom="";
		//parcours du tableau d'enseignants
		for (int i=0;i<tabEn.size();i++) {
			if (tabEn.get(i).getcin().equals(ncin))
				 nom=tabEn.get(i).getNom();
		}
		return nom;
	}
	
	//getteur du prenom
	public String getPrenom (String ncin) {
		String prenom="";
		//parcours du tableau d'enseignants
		for (int i=0;i<tabEn.size();i++) {
			if (tabEn.get(i).getcin().equals(ncin))
				 prenom=tabEn.get(i).getPrenom();
		}
		return prenom;
	}
	
	//méthode pour login (se connecter)
	public int loginEn(){
		Scanner s= new Scanner(System.in);
		String ncin;
		meths m = new meths();
		m.clearConsole();
		//controle de saisie du numero de CIN
		do {
			System.out.println("Doneer votre numéro carte identité : ");
			ncin=s.next();
		} while (ncin.length()==0);
		return pos(ncin);
	}
	
	//méthode pour signup (s'inscrire)
	public void signUpEn(TabQuiz tq, TabEnsg t, TabPasserQuiz tp) {
		Scanner s = new Scanner (System.in);
		String ncin,nom,pre;
		meths m= new meths();
		m.clearConsole();
		//controle de saisie du numero de CIN
		do {
			System.out.println("Donner votre numero carte identité : ");
			ncin=s.next();
		} while (!(m.cinValide(ncin)));
		//vérifier si il y a un enseignant avec ce numero de CIN
		if (pos(ncin)!=-1)
			{System.out.println("Il y a un énseignant existant avec ce numero CIN");m.sleep(2);}
		else {
			//controle de saisie du nom
			do {
				System.out.println("Saisir votre nom : ");
				nom=s.nextLine();
			} while (nom.length()==0);
			//controle de saisie du prenom
			do {
				System.out.println("Saisir votre prénom : ");
				pre=s.nextLine();
			} while (pre.length()==0);
			//création d'un nouveau enseignant avec ces attributs et l'ajouter au tableau correspondant
			Enseignant e = new Enseignant (nom,pre,ncin);
			tabEn.add(e);
			//appel à la methode liste d'apres cet enseignant
			e.liste(tq, t, tp);
		}
	}
	
	//getteur d'enseignant d'indice i
	public Enseignant getEnseignant (int i) {
		return tabEn.get(i);
	}


}
