import java.util.ArrayList;
import java.util.Scanner;
import library.meths;
import java.io.*;

//Classe TabEtud
public class TabEtud {
	//Attribut du TabEtud
	private ArrayList<Etudiant> tabEt;
	
	//Méthodes du TabEtud
	
	//Contstructeur non parametré
	public TabEtud() {
		tabEt = new ArrayList <Etudiant> ();
	}
	
	//Méthode d'ajout d'un étudiant
	public void add (Etudiant e) {
		tabEt.add(e);
	}
	
	//getteur d'un etudiant d'indice i
	public Etudiant getEtudiant(int i) {
		return tabEt.get(i);
	}
	
	//Méthode qui retourne la position d'etudiant avec numero de CIN donné
	public int pos(String ncinEt) {
		int test=-1;
		//parcours du tableau des etudiants
		for (int i = 0; (i < tabEt.size() ); i++) {
			Etudiant E= tabEt.get(i);
			if ( E.getcin().equals(ncinEt)) {
				test=i;
				break;
			}
		}
		return test;
	}
	
	//méthode pour login (se connecter)
	public int loginEt(){
		Scanner s= new Scanner(System.in);
		String ncin;
		meths m = new meths();
		m.clearConsole();
		//controle de saisie du numero de CIN
		do {
			System.out.println("doneer votre numéro carte indentité : ");
			ncin=s.next();
		} while (ncin.length()==0);
		return pos(ncin);
	}
	
	//méthode pour signup (s'inscrire)
	public void signUpEt(TabQuiz tq, TabPasserQuiz tp){
		Scanner s = new Scanner (System.in);
		String ncin,nom,pre;
		int g;
		meths m= new meths();
		m.clearConsole();
		//controle de saisie du numero de CIN
		do {
			System.out.println("Donner votre numero carte identité : ");
			ncin=s.next();
		} while (!(m.cinValide(ncin)));
		//vérifier si il y a un enseignant avec ce numero de CIN
		if (pos(ncin)!=-1) {
			System.out.println("Il y a un étudiant existant avec ce numero CIN");
			m.sleep(2);
		}
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
			//controle de saisie du groupe
			do {
				System.out.println("Saisir votre groupe : ");
				g=s.nextInt();
;			} while (g<=0);
			//création d'un nouveau etudiant avec ces attributs et l'ajouter au tableau correspondant
			Etudiant e = new Etudiant (nom, pre, g, ncin);
			tabEt.add(e);
			//appel à la methode liste d'apres cet etudiant
			e.liste(tq, tp);
		}
	}

}
