import java.util.Scanner;
import library.meths;
public class Main {
	
	public static void main(String[] args) {
		//création des instances des classes des tableaux (étudiant, enseignant, quiz, passerQuiz)
		TabEtud t1 = new TabEtud();
		TabEnsg t2 = new TabEnsg();
		TabQuiz t3 = new TabQuiz();
		TabPasserQuiz t4 = new TabPasserQuiz ();
		
		meths m=new meths();
		Scanner s= new Scanner(System.in);
		char choix1,choix2;
		int pos;
		//boucle tant que l'utilisateur n'a pas décidé de quitter
		do {
			//controle de saisie du choix1
			do {
				m.clearConsole();
				System.out.print("||----------------------------------------------||\n||----------------------------------------------||\n");
				System.out.print("||            BIENVENUE AU PROGRAMME            ||\n");
				System.out.print("||----------------------------------------------||\n||----------------------------------------------||\n");
				System.out.print("\n\n");
				System.out.print("||----------------------------------------------||\n||----------------------------------------------||\n");
				System.out.print("||                   Vous êtes :                ||\n");
				System.out.print("||----------------------------------------------||\n||----------------------------------------------||\n");
				System.out.print("||                  1- Étudiant                 ||\n");
				System.out.print("||                  2- Enseignant               ||\n");
				System.out.print("||----------------------------------------------||\n||----------------------------------------------||\n");
				System.out.print("||                  3- Quitter                  ||\n");
				System.out.print("||----------------------------------------------||\n||----------------------------------------------||\n");	
				System.out.println("Saisir votre choix");
				choix1=s.next().charAt(0);
			}while((choix1<'1')||(choix1>'3'));
			
			switch (choix1) {
				case '1': System.out.println(" 1- Se Connecter ");
						  System.out.println(" 2- S'inscrire ");
						  //controle de saisie du choix2
						  do{
						  	choix2=s.next().charAt(0);
						  }while((choix2!='1')&&(choix2!='2'));
						  switch(choix2) {
						  	case '1' : 	//appel du méthode login d'étudiant
						  				pos=t1.loginEt();
						  				//verifier si il y a un etudiant avec ce numero de CIN
						  				if (pos==-1) {
									  		System.out.println("Il n'y a pas un étudiant avec ce numero de CIN");
									  		m.sleep(2);
									  	}
									  	else {
									  		//appel au methode de liste à partir l'etudiant avec ce numero de CIN
									  		t1.getEtudiant(pos).liste(t3, t4);
									  	}
						  				break;
						  	case '2' :  //appel au methode signup d'étudiant
						  				t1.signUpEt(t3, t4); break;
						  }
						break;
				case '2': System.out.println(" 1- Se Connecter ");
						  System.out.println(" 2- S'inscrire ");
						  //controle de saisie du choix2
						  do {
							  choix2=s.next().charAt(0);
						  }while((choix2!='1')&&(choix2!='2'));
						  switch(choix2) {
						  	case '1' :  //appel du méthode login d'enseignant
						  				pos=t2.loginEn();
						  				//verifier si il y a un enseignant avec ce numero de CIN
						  				if (pos==-1) {
									  		System.out.println("Il n'y a pas un enseignant avec ce numero de CIN");
									  		m.sleep(2);
									  	}
									  	else {
									  		//appel au methode de liste à partir l'enseignant avec ce numero de CIN
									  		t2.getEnseignant(pos).liste(t3, t2, t4);
									  	} break;
						  	case '2' :  //appel au methode signup d'enseignant
						  				t2.signUpEn(t3, t2, t4); break;
						  }
				 		break;
				case '3':	
					//affichage du méssage d'adieu
					m.ext ();
		 			break;
			}
		} while (choix1!='3');	
	}
}
