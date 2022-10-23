import java.util.Scanner;

import library.meths;

//Classe Etudiants
public class Etudiant {
	//Attributs d'etudiant
	private String nomET;
	private String prenomET;
	private int groupET;
	private String ncinET;
	
	//Méthodes d'etudiant
	
	//constructeur paramétré
	public Etudiant (String nom, String pre, int g, String cin) {
		nomET=nom;
		prenomET=pre;
		groupET=g;
		ncinET=cin;
	}
	
	// Méthode de liste d'etudiant
	public void liste (TabQuiz tq, TabPasserQuiz tp) {
		meths m = new meths();
		char choix;
		Scanner s = new Scanner(System.in);
		do {
			m.clearConsole();
			System.out.print("||----------------------------------------------------||\n");
			System.out.print("||----------------------------------------------------||\n");		
			System.out.print("||                                                    ||\n");
			System.out.print("||           1- Visualiser la liste des Quiz          ||\n");
			System.out.print("||                2- Répondre au quiz                 ||\n");
			System.out.print("||          3- Consulter les scores obtenus           ||\n");
			System.out.print("||       4- Consulter la correction d’un Quiz         ||\n");
			System.out.print("||                   5-Se déconnecter                 ||\n");
			System.out.print("||                                                    ||\n");		
			System.out.print("||----------------------------------------------------||\n");
			System.out.print("||----------------------------------------------------||\n");
			choix=s.next().charAt(0);
		} while ((choix<'1')||(choix>'5'));
		switch (choix) {
		case '1' : visQuiz(tq,tp); break;
		case '2' : repondre(tq,tp); break;
		case '3' : consultScore(tq,tp); break;
		case '4' : consultCorr(tq,tp); break;
		}
	}
	
	//méthode de visualiser les quiz
	public void visQuiz(TabQuiz tq, TabPasserQuiz tp) {
		meths m=new meths();
		m.clearConsole();
		Scanner s = new Scanner (System.in);
		//parcours des quiz d'après le tableau des quiz
		for (int i=0;i<tq.getTaille();i++) {
			System.out.print("Le quiz de "+tq.getQuiz(i).getTheme()+" est ");
			//vérifier si il a passé ce quiz
			if (tp.existPass(tq.getQuiz(i), this)) 
				System.out.println("déja passé");
			else
				System.out.println("encore disponible");
		}
		System.out.println("\n\nTapez N'importe quoi pour retourner à la liste précédente : ");
		String s1 = s.next();
		liste(tq,tp);
	}
	
	//méthode de répondre à un quiz
	public void repondre (TabQuiz tq, TabPasserQuiz tp) {
		meths m=new meths();
		m.clearConsole();
		Scanner s = new Scanner (System.in);
		String theme;
		//refaire les instructions du methode visQuiz
		for (int i=0;i<tq.getTaille();i++) {
			System.out.print("Le quiz de "+tq.getQuiz(i).getTheme()+" est ");
			if (tp.existPass(tq.getQuiz(i), this)) 
				System.out.println("dejà passé");
			else
				System.out.println("encore disponible");
		}
		System.out.println("Tapez le module que vous voulez le passer (sans autres caractères) : ");
		theme = s.nextLine();
		//vérfier si il y a un quiz avec ce thème
		if (!(tq.existTheme(theme)))
			System.out.println("Il n'y a pas un quiz avec ce thème");
		else {
			//vérifier si il a passé ce quiz
			if (tp.existPass(theme, this)) 
				System.out.println("Vous avez déjà passé ce quiz");
			else {
				//créer un objet PasserQuiz
				int nbReponses=0;
				Quiz q = tq.getQuiz(theme);
				int rep;
				//parcours des QCM du quiz
				for (int i=0;i<q.getNbrQCM();i++) {
					System.out.println("Question "+(i+1)+": "+q.getQCM(i).getTexteQCM());
					//parcours des options du QCM
					for (int j=0;j<q.getQCM(i).getNbrOption();j++) {
						System.out.println("Option "+(j+1)+": "+q.getQCM(i).getOption(j).getTexte());
					}
					//controle de saisie du réponse d'etudiant
					do {
						System.out.println("Tapez le numero de l'option : ");
						rep=s.nextInt();
					} while ((rep<1)||(rep>(q.getQCM(i).getNbrOption())));
					//vérifier si la réponse est correcte
					if (rep==q.getQCM(i).nbValide()) {
						nbReponses++;
						q.getQCM(i).increment_nbrepbVrai();
					}
					q.getQCM(i).increment_nbrep();
				}
				
				double score = (nbReponses/q.getNbrQCM())*100;
				PasserQuiz pq = new PasserQuiz(this,q,score);
				//ajouter l'objet PasserQuiz au tableau correspondant
				tp.add(pq);
				//affichage du score
				System.out.println("QUIZ PASSÉ\nVOTRE SCORE EST "+pq.getScore());
			}
		}
		m.sleep(5);
		liste(tq,tp);
	}
	
	//méthode du consultation des scores des quiz que l'etudiant a passé
	public void consultScore(TabQuiz tq, TabPasserQuiz tp) {
		meths m=new meths();
		Scanner s = new Scanner (System.in);
		m.clearConsole();
		System.out.println("Les quiz que vous avez passé sont :");
		//affichage les quiz qu'il a passé du tableau TabPasserQuiz
		tp.afficheQuiz(this);
		System.out.println("\n\nTapez N'importe quoi pour retourner à la liste précédente : ");
		String s1 = s.next();
		liste(tq,tp);
	}
	
	//méthode de consultation du correction des quiz du module donné (s'il l'a passé)
	public void consultCorr(TabQuiz tq, TabPasserQuiz tp) {
		meths m = new meths();
		m.clearConsole();
		Scanner s = new Scanner (System.in);
		String theme;
		//controle de saisie du module
		do {
			System.out.println("Donner le module : ");
			theme = s.nextLine();
		} while (theme.length()==0);
		//vérifier si il y a un quiz avec ce thème
		if (!(tq.existTheme(theme)))
			System.out.println("Il n'y a pas un quiz avec ce thème");
		else {
			//vérifier si il a passé ce quiz
			if (!(tp.existPass(theme, this)))
				System.out.println("Vous n'avez pas passé ce quiz");
			else {
				//affichage du correction du quiz
				Quiz q=tq.getQuiz(theme);
				System.out.println("Module : "+q.getTheme());
				for (int i=0;i<q.getNbrQCM();i++) {
					System.out.println("Question N°"+q.getQCM(i).getNumQCM()+" - "+q.getQCM(i).getTexteQCM());
					for (int j=0;j<q.getQCM(i).getNbrOption();j++) {
						System.out.println("Option N°"+(i+1)+" "+q.getQCM(i).getOption(j).getTexte()+"-->"+m.validite(q.getQCM(i).getOption(j).getReponse()));
					}
				}
			}
		}
		System.out.println("\n\nTapez N'importe quoi pour retourner à la liste précédente : ");
		String s1 = s.next();
		liste(tq,tp);
	}
	
	//getteur du cin
	public String getcin() {
		return ncinET;
	}
	
	//getteur du nom
	public String getNom() {
		return nomET;
	}
	
	//getteur du prénom
	public String getPrenom() {
		return prenomET;
	}
	
	//getteur du groupe
	public int getGroupe() {
		return groupET;
	}
}
