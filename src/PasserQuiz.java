//Classe PasserQuiz
public class PasserQuiz {
	//Attributs du PasserQuiz
	private Etudiant etud;
	private Quiz quiz;
	private double score;
	
	//Méthodes du PasserQuiz
	
	//Constructeur parametré
	public PasserQuiz (Etudiant e, Quiz q, double s) {
		etud=e;
		quiz=q;
		score=s;
	}
	
	//getteur d'etudiant
	public Etudiant getEtudiant() {
		return etud;
	}
	
	//getteur du quiz
	public Quiz getQuiz() {
		return quiz;
	}
	
	//getteur du score
	public double getScore() {
		return score;
	}
}
