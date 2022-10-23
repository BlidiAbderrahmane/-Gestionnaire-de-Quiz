import library.meths;
import java.util.Scanner;

//Classe Enseignant
public class Enseignant {
	// Attributs Enseignant
	private String nomEN;
	private String prenomEN;
	private String ncinEN;
	
	// Méthodes Enseignant
	
	// Constructeur paramétré
	public Enseignant (String nom,String pre,String cin) {
		nomEN=nom;
		prenomEN=pre;
		ncinEN=cin;
	}
	
	// Méthode de liste d'enseignant
	public void liste(TabQuiz tq,TabEnsg t, TabPasserQuiz tp) {
		meths m = new meths();
		char choix;
		Scanner s = new Scanner(System.in);
		do {
			m.clearConsole();
			System.out.print("||--------------------------------------------------------------||\n");
			System.out.print("||--------------------------------------------------------------||\n");		
			System.out.print("||                                                              ||\n");
			System.out.print("||                  1- Créer un nouveau Quiz                    ||\n");
			System.out.print("||           2- Visualiser le Quiz d’un module donné            ||\n");
			System.out.print("||            3- Supprimer le Quiz d’un module donné            ||\n");
			System.out.print("||           4- Modifier le Quiz d’un module donné              ||\n");
			System.out.print("|| 5-Visualiser étudiants ayant passé le quiz d'un module donné ||\n");
			System.out.print("||             6- Visualiser le taux de réponses                ||\n");				
			System.out.print("||                      7-Se déconnecter                        ||\n");	
			System.out.print("||                                                              ||\n");
			System.out.print("||--------------------------------------------------------------||\n");
			System.out.print("||--------------------------------------------------------------||\n");
			choix=s.next().charAt(0);
		} while ((choix<'1')||(choix>'7'));
		switch (choix) {
			case '1' :  creerQuiz(tq,t,tp); break;
			case '2' :  visQuiz(tq,t,tp); break;
			case '3' : supprimerQuiz(tq,t,tp); break;
			case '4' : modifierQuiz(tq,t,tp); break;
			case '5' : visEtud(tq,t,tp); break;
			case '6' : visTauxRep(tq,t,tp); break;
		}
		
	}
	
	//getteur du cin
	public String getcin() {
		return ncinEN;
	}
	
	//getteur du nom
	public String getNom() {
		return nomEN;
	}
	
	//getteur du prenom
	public String getPrenom() {
		return prenomEN;
	}
	
	

	//méthode de création d'un quiz
	public void creerQuiz(TabQuiz tq, TabEnsg t, TabPasserQuiz tp) {
		meths m=new meths();
		m.clearConsole();
		Scanner s = new Scanner (System.in);
		String theme,txtQCM,txtOpt;
		int nbQcm,nbOpt,repInt;
		boolean rep=true ;
		QCM qq;
		//vérifier si le module donnée est non vide et existe
		do {
			System.out.println("Donner un nouveau module : ");
			theme=s.nextLine();
			if (tq.existTheme(theme))
				System.out.println("Le module existe déja");
		} while ((theme.length()==0)||(tq.existTheme(theme)));
		//controle de saisie de nombre de qcm
		do {
			System.out.println("Donner le nombre de QCMs (Au minimum 3 QCM) : ");
			nbQcm=s.nextInt();
		} while (nbQcm<3);
		Quiz q = new Quiz (theme,ncinEN);
		//saisir les QCMs
		for (int i=0;i<nbQcm;i++) {
			//controle de saisie de texte du QCM
			do {
				System.out.println("Donner la question de QCM "+(i+1)+" : ");
				txtQCM=s.nextLine();
			} while (txtQCM.length()==0);
			//controle de saisie du nombre d'options
			do {
				System.out.println("Donner le nombre des options (Au minimum 2 options et au maximum 5) : ");
				nbOpt=s.nextInt();
			} while ((nbOpt<=1)||(nbOpt>5));
			//vérifier si une seule option est valide
			do {
				System.out.println("!Il faut qu'une seule réponse soit valide!");
				qq=new QCM((i+1),txtQCM);
				//saisir les options
				for (int j=0;j<nbOpt;j++) {
					//controle de saisie du texte d'option
					do {
						System.out.println("Donner le texte de la réponse numero "+(j+1)+" : ");
						txtOpt=s.nextLine();
					} while (txtOpt.length()==0);
					//saisir la validité d'option
					do {
						System.out.println("Tapez 1 si la réponse est valide\nTapez 0 sinon : ");
						repInt=s.nextInt();
					} while ((repInt!=0)&&(repInt!=1));
					//conversion du validité d'entier vers le booléen
					switch (repInt) {
						case 1:
							rep=true;
							break;
						case 0:
							rep=false;
							break;
					}
					Option op = new Option(j+1,txtOpt,rep);
					//ajout l'option dans le QCM
					qq.addOption(op);
				}
			} while(!(qq.oneValid()));
			//ajout le QCM dans le quiz
			q.addQCM(qq);
		}
		//ajout le quiz dans le tableau des quiz
		tq.addQuiz(q);
		m.clearConsole();
		System.out.print("||----------------------------------------------||\n");		
		System.out.print("||----------------------------------------------||\n");
		System.out.print("||----------------------------------------------||\n");		
		System.out.print("||----------------------------------------------||\n");
		System.out.print("||----------------------------------------------||\n");		
		System.out.print("||                                              ||\n");
		System.out.print("||           QUIZ AJOUTÉ AVEC SUCCÈS            ||\n");
		System.out.print("||                                              ||\n");		
		System.out.print("||----------------------------------------------||\n");
		System.out.print("||----------------------------------------------||\n");
		System.out.print("||----------------------------------------------||\n");
		System.out.print("||----------------------------------------------||\n");		
		System.out.print("||----------------------------------------------||\n");
		System.out.print("\n\n\n\n");
		m.sleep(5);
		liste(tq,t,tp);
	}
	
	//méthode de visualiser le quiz d'un module donné
	public void visQuiz(TabQuiz tq,TabEnsg t, TabPasserQuiz tp) {
		meths m=new meths();
		m.clearConsole();
		Scanner s = new Scanner (System.in);
		String theme;
		//controle de saisie de module
		do {
			System.out.println("Donner le module : ");
			theme=s.nextLine();
		} while (theme.length()==0);
		//vérifier si il y a un Quiz avec ce thème
		if (!(tq.existTheme(theme)))
			System.out.println("Il n'y a pas un quiz avec ce thème");
		else {
			Quiz q=tq.getQuiz(theme);
			System.out.println("Module : "+q.getTheme());
			System.out.println("Auteur : "+   t.getNom( q.getAuteur() )  +" " +  t.getPrenom( q.getAuteur() ) );
			//parcours des QCMs
			for (int i=0;i<q.getNbrQCM();i++) {
				System.out.println("Question N°"+(i+1)+" - "+q.getQCM(i).getTexteQCM());
				//parcours des options
				for (int j=0;j<q.getQCM(i).getNbrOption();j++) {
					System.out.println("Option N°"+(j+1)+q.getQCM(i).getOption(j).getTexte()+"-->"+m.validite(q.getQCM(i).getOption(j).getReponse()));
				}
			}
		}
		System.out.println("\n\nTapez N'importe quoi pour retourner à la liste précédente : ");
		String s1 = s.next();
		liste(tq,t,tp);
	}
	
	//méthode de suppression de quiz d'un module donné
	public void supprimerQuiz (TabQuiz tq,TabEnsg t, TabPasserQuiz tp) {
		meths m=new meths();
		m.clearConsole();
		Scanner s = new Scanner (System.in);
		String theme;
		//controle de saisie du thème
		do {
			System.out.println("Donner le thème à supprimer : ");
			theme=s.nextLine();
		} while (theme.length()==0);
		//vérifier si il y a un quiz avec ce thème
		if (!(tq.existTheme(theme)))
			System.out.println("Il n'y a pas un quiz avec ce thème");
		else {
			//suppression du quiz de table des quiz
			tq.supp(theme);
			m.clearConsole();
			System.out.print("||----------------------------------------------||\n");		
			System.out.print("||----------------------------------------------||\n");
			System.out.print("||----------------------------------------------||\n");		
			System.out.print("||----------------------------------------------||\n");
			System.out.print("||----------------------------------------------||\n");		
			System.out.print("||                                              ||\n");
			System.out.print("||           QUIZ SUPPRIMÉ AVEC SUCCÈS          ||\n");
			System.out.print("||                                              ||\n");		
			System.out.print("||----------------------------------------------||\n");
			System.out.print("||----------------------------------------------||\n");
			System.out.print("||----------------------------------------------||\n");
			System.out.print("||----------------------------------------------||\n");		
			System.out.print("||----------------------------------------------||\n");
			System.out.print("\n\n\n\n");
		}
		m.sleep(5);
		liste(tq,t,tp);
	}
	
	//méthode de modification de quiz
	public void modifierQuiz(TabQuiz tq,TabEnsg t, TabPasserQuiz tp) {
		meths m=new meths();
		m.clearConsole();
		String theme;
		Scanner s = new Scanner (System.in);
		//controle de saisie du thème
		do {
			System.out.println("Donner le thème à modifier : ");
			theme=s.nextLine();
		} while (theme.length()==0);
		//vérifier si il y a un quiz avec ce thème
		if (!(tq.existTheme(theme)))
			System.out.println("Il n'y a pas un quiz avec ce thème");
		else {
			//création d'un nouveau quiz avec le meme theme et l'auteur de cet enseignant
			int pos=tq.pos(theme),nbQcm,nbOpt,repInt;
			String txtQCM,txtOpt;
			boolean rep=true;
			QCM qq;
			Quiz q = new Quiz(theme,getcin());
			do {
				System.out.println("Donner le nombre de QCMs (Au minimum 3 QCM) : ");
				nbQcm=s.nextInt();
			} while (nbQcm<3);
			for (int i=0;i<nbQcm;i++) {	
				do {
					System.out.println("Donner la question de QCM "+(i+1)+" : ");
					txtQCM=s.nextLine();
				} while (txtQCM.length()==0);
				do {
					System.out.println("Donner le nombre des options (Au minimum 2 options et au maximum 5) : ");
					nbOpt=s.nextInt();
				} while ((nbOpt<=1)||(nbOpt>5));
				do {
					System.out.println("!Il faut qu'une seule réponse soit valide!");
					qq=new QCM((i+1),txtQCM);
					for (int j=0;j<nbOpt;j++) {
						do {
							System.out.println("Donner le texte de la réponse numero "+(j+1)+" : ");
							txtOpt=s.nextLine();
						} while (txtOpt.length()==0);
						do {
							System.out.println("Tapez 1 si la réponse est valide\nTapez 0 sinon : ");
							repInt=s.nextInt();
						} while ((repInt!=0)&&(repInt!=1));
						switch (repInt) {
							case 1:
								rep=true; break;
							case 0:
								rep=false; break;
						}
						Option op = new Option(j+1,txtOpt,rep);
						qq.addOption(op);
					}
				} while(!(qq.oneValid()));
				q.addQCM(qq);
			}
			//remplacer le quiz ancien avec notre nouveau quiz
			tq.setQuiz(pos, q);
			m.clearConsole();
			System.out.print("||----------------------------------------------||\n");		
			System.out.print("||----------------------------------------------||\n");
			System.out.print("||----------------------------------------------||\n");		
			System.out.print("||----------------------------------------------||\n");
			System.out.print("||----------------------------------------------||\n");		
			System.out.print("||                                              ||\n");
			System.out.print("||           QUIZ MODIFIÉ AVEC SUCCÈS           ||\n");
			System.out.print("||                                              ||\n");		
			System.out.print("||----------------------------------------------||\n");
			System.out.print("||----------------------------------------------||\n");
			System.out.print("||----------------------------------------------||\n");
			System.out.print("||----------------------------------------------||\n");		
			System.out.print("||----------------------------------------------||\n");
			System.out.print("\n\n\n\n");
		}
		m.sleep(5);
		liste(tq,t,tp);
	}
	
	//méthode de visualiser les etudiants qui ont passé le quiz du thème donné
	public void visEtud(TabQuiz tq, TabEnsg t, TabPasserQuiz tp) {
		meths m=new meths();
		m.clearConsole();
		Scanner s = new Scanner (System.in);
		String theme;
		//controle de saisie du theme
		do {
			System.out.println("Donner le thème : ");
			theme=s.nextLine();
		} while (theme.length()==0);
		//verifier si il y a un quiz avec ce theme
		if (!(tq.existTheme(theme)))
			System.out.println("Il n'y a pas un quiz avec ce thème");
		else {
			//affichage les etudiants qui on passé le quiz avec ce thème, d'après le tableau PasserQuiz
			tp.afficheEtudiants(theme);
		}
		System.out.println("\n\nTapez N'importe quoi pour retourner à la liste précédente : ");
		String s1 = s.next();
		liste(tq,t,tp);
	}
	
	//méthode de visualiser le taux reponses vraies et fausses, de chaque question, du quiz avec le thème donné
	public void visTauxRep(TabQuiz tq, TabEnsg t, TabPasserQuiz tp) {
		meths m=new meths();
		m.clearConsole();
		Scanner s = new Scanner (System.in);
		String theme;
		//controle de saisie du thème
		do {
			System.out.println("Donner le thème : ");
			theme=s.nextLine();
		} while (theme.length()==0);
		//vérifier si il y a un quiz avec ce thème
		if (!(tq.existTheme(theme)))
			System.out.println("Il n'y a pas un quiz avec ce thème");
		else {
			Quiz q= tq.getQuiz(theme); 
			int nbQcm= q.getNbrQCM();
			//parcours des QCMs du quiz
			for (int i=0;i<nbQcm;i++) {
				QCM qq=q.getQCM(i);
				System.out.println("Question n°"+i+" : "+qq.getTexteQCM());
				System.out.println("Le taux des réponses justes ="+( ( qq.getNbrepVrai(i) / qq.getNbrep(i)) * 100 ) +"%");
				System.out.println("Le taux des réponses fausses ="+( ( 1 - ( qq.getNbrepVrai(i) / qq.getNbrep(i)) )  * 100) +"%");				
			}
		}
		System.out.println("\n\nTapez N'importe quoi pour retourner à la liste précédente : ");
		String s1 = s.next();
		liste(tq,t,tp);
		
	}
	
}
