package library;

//Classe des méthodes utiles
public class meths {
	//Méthodes pour vider le console
	public void clearConsole() {
		System.out.println(System.lineSeparator().repeat(100));
	}
	
	//Méthode pour vérifier la validité du numero de CIN
	public boolean cinValide(String ch)
	{
		if (ch.length()!=8) 
			return false;
		else if (!isNumeric(ch)) 
			return false;
		else if ((ch.charAt(0)<'0')||(ch.charAt(0)>'1'))
			return false;
		else
			return true;
	}
	
	//Méthode pour vérifier si une chaine donné est numérique
	public static boolean isNumeric(String str) { 
		  try {  
		    Double.parseDouble(str);  
		    return true;
		  } catch(NumberFormatException e){  
		    return false;  
		  }  
	}
	
	//Méthode qui transforme une variable booléene vers une chaine (vrai ou faux)
	public String validite(boolean b) {
		if (b)
			return "Vrai";
		else
			return "Faux";
	}
	
	//Méthode pour pauser l'execution du programme pour x secondes
	public void sleep(int x) {
		try {
			Thread.sleep(x*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			Thread.currentThread().interrupt();
		}
	}
	
	//Méthode qui affiche le message d'adieu
	public  void ext () {
		clearConsole();
		System.out.print("||----------------------------------------------||\n");		
		System.out.print("||----------------------------------------------||\n");
		System.out.print("||----------------------------------------------||\n");		
		System.out.print("||----------------------------------------------||\n");
		System.out.print("||----------------------------------------------||\n");		
		System.out.print("||                                              ||\n");
		System.out.print("||                   AU REVOIR!                 ||\n");
		System.out.print("||                                              ||\n");		
		System.out.print("||----------------------------------------------||\n");
		System.out.print("||----------------------------------------------||\n");
		System.out.print("||----------------------------------------------||\n");
		System.out.print("||----------------------------------------------||\n");		
		System.out.print("||----------------------------------------------||\n");
		System.out.print("\n\n\n\n");
	}
	
}