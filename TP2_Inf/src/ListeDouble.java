/**
 * Classe qui implémente une liste doublement chaînée
 * avec une position courante.  En tout temps les opérations
 * se font par rapport à la position courante qui fait partie intégrante de la liste.
 *
 * Les méthodes pour déplacer la position courante font partie de la classe.
 *
 * Pour l'insertion, la position courante est toujours sur le noeud ajouté.
 *
 * Pour la suppression, la position courante est le noeud suivant celui qui vient
 * d'être supprimé (non implémentée).
 *
 * On ne lève aucune exception pour cet exemple.  Seul les exceptions systèmes
 * seront levées s'il y a un problème.
 *
 * @author  <a href="mailto:pierre.belisle@etsmtl.ca">Pierre Bélisle</a>
 * @version février 2014
 */
public class ListeDouble {

	/*
	 * STRATÉGIE : On garde une référence sur le premier et le dernier noeud
	 * de la liste.  Une référence sur la position courante et le nombre d'éléments
	 * est mis à jour après chaque insertion.
	 *
	 * Le chaînage est double alors le noeud contient une référence sur
	 * le noeud suivant et le noeud précédent
	 *
	 * Les statégies pour chaque méthode sont décrites dans leur commentaire
	 * de stratégie respectf.
	 */


	 /*
	  *Une liste est un ou pls noeuds liés ensemble dans les deux sens.
	  */
	 private class Noeud{

		 //La liste peut les utiliser directement via un objet (classe interne)
		 //donc pas besoin d'accesseurs et de mutateurs.
		 private Object element;
		 private Noeud suivant;
		 private Noeud precedent;

		 //Constructeur par copie d'attributs.
		 private Noeud(Object element, Noeud suivant, Noeud precedent){
			 this.element = element;
			 this. suivant = suivant;
			 this.precedent = precedent;
		 }
	 }


	 //Pointeur sur le premier et le dernier noeud (null lorsque la liste est vide).
	 private Noeud debut;
	 private Noeud fin;

	 //Référence sur la position où sont effectué les opération.
	 private Noeud positionCourante;

	 //Maintenu à jour après une insertion ou une suppresion.
	 private int nbElements;


	 /**
	  * Crée une liste vide.
	  */
	 public ListeDouble(){

	    	/**
	    	 * STRATÉGIE : On initialise explicitement les valeurs plutôt 
	    	 *  que d'utiliser l'initialisation automatique de l'environnement.
	    	 */
		         debut = null;
				 fin = null;
				 positionCourante = null;
		         nbElements = 0;

	 }

	 /**
	  * Retourne si la liste est vide.
	  *
	  * Antécédent : Aucun.
	  *
	  * Conséquent : Aucun.
	  *
	  * @return Si true la liste est vide et false autrement
	  */
	 public boolean estVide(){

		 /*
		  * STRATÉGIE : On retourne simplement l'évaluation booléenne de la
		  *  comparaison du nombre d'éléments avec 0.
		  */
	     return nbElements == 0;
	 }


	 //LES MÉTHODES DE DÉPLACEMENT
	 /**
	  * Passe la position courante au suivant dans la liste.
	  *
	  * Antécédent : Aucun.
	  *
	  * Conséquent : La position est déplacée sur l'élément suivant s'il existe.
	  * Sinon position courante est sur le dernier de la liste.
 	  *
	  *  @throws JavaNullPointerException
	  */
	 public void setPosSuivant() {


		 /*
		  * STRATÉGIE : Si c'est la fin, on ne déplace pas, sinon 
		  * on passe au suivant.
		  */
		 if(positionCourante.suivant != null){


    	     positionCourante = positionCourante.suivant;

		 }

	 }

	 /**
	  * Met la position courante au début de la  liste.
	  *
	  * Conséquent : position == debut.
	  */
	 public void setPosDebut() {


         /*
          * STRATÉGIE : On déplace la position courante 
          *  au noeud pointé par début.
          */
		 positionCourante = debut;

	 }

	 /**
	  * Met la position courante à la fin de la liste.
	  *
	  * Conséquent : position == fin.
	  *
	  */
	 public void setPosFin() {


         /*
          * STRATÉGIE : On déplace la position courante au noeud pointé 
          * par le pointeur de fin.
          */
		 positionCourante = fin;


	 }

	 /**
	  * Passe la position courante au précédent dans la liste.
	  *
	  * Antécédent : La liste ne doit pas être vide.
	  *
	  * Conséquent : La position courante est sur l'élément précédent s'il existe.
	  * Sinon position courante == debut.
	  *
 	  *  @throws JavaNullPointerException
	  */
	 public void setPosPrecedent(){


		 /*
		  *STRATÉGIE : On déplace la position sur son précédent sauf 
		  *si elle est au début.
		  */

		 // On ne déplace rien si on est au début.
		 if(positionCourante != debut) {

		    positionCourante = positionCourante.precedent;

		 }

	 }


	 //LES MÉTHODES D'INSERTION
	 /**
	  * Insère l'élément reçu en début de liste
	  *
	  * Antédécent : Aucun.
	  *
	  * Conséquent : nbElement = nbElement + 1 &  position == debut &
	  *  this.getElement() == element.
	  *
      * @param element L'Élément à insérer au début  de la liste
	  */
	 public void insererDebut(Object element){

		 /*
		  * STRATÉGIE : On crée un noeud en faisant le lien sur l'ancien début.  
		  * On  utilise le nombre d'éléments pour tester si la liste est vide.
		  * Si c'est le cas, il faut placer le pointeur de fin.  On place  la position 
		  * courante sur le noeud qui vient d'être créé.  
		  * On incrémente le nombre d'éléments dans tous les cas.
		  */

     	 // Création du noeud avec le lien sur l'ancien début.
  	     debut = new Noeud(element,debut,null);

  	     // La liste est vide, on place le pointeur de fin.
  	     if (nbElements == 0)
		     fin = debut;

  	     // Sinon, il faut ajuste le précédent de l'ancien début.
  	     else
  	        debut.suivant.precedent = debut;

  	     // On place la position courante sur le nouveau noeud en tête de liste.
  	     positionCourante = debut;

		 // Un élément de plus.
		 nbElements++;
	 }

	 /**
	  * Insère l'élément reçu en fin de liste.
	  *
	  * Antédécent : Aucun.
	  *
	  * Conséquent : nbElement = nbElement + 1 & position == fin &
	  *  liste.getElement() == element.
	  *
	  * @param element L'élément à insérer à la fin de  la liste.
	  */
	 public void insererFin(Object element){

		 /*
		  * STRATÉGIE : On utilise le nombre d'éléments pour tester si la liste est
		  *  vide. Si c'est le cas, on utilise la méthode qui insère au début.
		  * Sinon, on crée un nouveau noeud et on le lie à celui de fin.  On déplace
		  * ensuite le pointeur de fin et la position courante sur le nouveau noeud.
		  * On incrémente le nombre d'éléments.
		  */

		 // Si la liste est vide, on insère au début.
		 if(nbElements == 0)
			 insererDebut(element);

		 // Sinon on insère après le dernier.
		 else{

			    // Création du nouveau noeud lié après la fin avec chaînage sur
			    // l'ancienne fin
			    fin.suivant = new Noeud(element,null,fin);

			    // Déplace le pointeur de fin.
			    fin = fin.suivant;

			    // Place la position courante à la fin.
			    positionCourante = fin;

			    // Un élément de plus.
			    nbElements++;
		 }
	 }


	 /**
	  * Insère l'élément reçu après la position courante.
      *
      * Antédécent : Aucun.
      *
	  * Conséquent : nbElement = nbElement + 1 & liste.getElement() == element.
	  *
	  * @param element L'Élément à insérer après la position courante.
	  *
	  */
	 public void insererApres(Object element){

		 /*
		  * STRATÉGIE : On utilise le nombre d'éléments pour tester si la liste est
		  *  vide et on regarde si la position courante est à la fin. Si c'est le cas,
		  *  on utilise la méthode qui insère à la fin.
		  *  Sinon, on crée un nouveau noeud et on le lie au noeud pointé
		  *  par la position courante.  Si c'est le dernier noeud, on il faut ajuster le
		  *  pointeur de fin (on aurait pu penser à utiliser insererFin mais c'est plus lent)
		  *  On déplace la position courante sur le nouveau noeud.
		  *  On incrémente le nombre d'éléments.
		  */

		 // Si la liste est vide, ou que la position courante est à la fin,
		 // on insère à la fin.
		 if(nbElements == 0 || positionCourante == fin)
			 insererFin(element);

		 else{

			 // Ajuste le précédent du suivant de la position courante.
			 positionCourante.suivant.precedent =
					 new Noeud(element,positionCourante.suivant,positionCourante);

			 // Le suivant de la position courantepointe aussi sur le nouveau noeud.
		     positionCourante.suivant = positionCourante.suivant.precedent;

             // On place la position courante sur le suivant.
             positionCourante = positionCourante.suivant;

		     //OU
		     // Noeud tmp = new Noeud(element,
             //                                          positionCourante.suivant,
             //                                          positionCourante);
             //
		     // positionCourante.suivant.precedent = tmp;
		     // positionCourante.suivant = tmp;
		     // positionCourante = tmp;

		      //un élément de plus
		      nbElements++;
		 }
	 }

	 /**
	  * Insère l'élément reçu avant la position courante
	  *
      * Antédécent : Aucun.
      *
	  * Conséquent : nbElement = nbElement + 1 & liste.getElement() == element.
	  *
	  * @param element L'Élément à insérer dans la liste avant la position courante.
	  */
	 public void insererAvant(Object element){

		 /*
		  * STRATÉGIE : On utilise le nombre d'éléments pour tester si la liste est
		  *  vide. Si c'est le cas, on utilise la méthode qui insère au début mais
		  * on n'incrémente pas le nombre d'éléments puisque insererDebut le fait.
		  *
		  * Sinon, c'est la même technique que pour l'insertion après sauf que le
		  * chaînage se fait avant la position courante.  Là, il faut incrémémenter le
		  * nombre d'Éléments.
		  *
		  */

		 //Si la liste est vide ou un seul élément, on insère au début.
		 if(nbElements <= 1 || positionCourante == debut)
			 insererDebut(element);

		 		 
		 //On effectue le chaînage avec le nouveau noeud, des deux côtés.
		 else{

              // Ex: avant l'ajout de D2 à la position courante.
			 //               D1        D3       D5
			 // debut->         ->        ->  null   
			 //              null  <-        <-           <- fin
             //                             ^
			 //                             ||
			 //                            pc

			 /* On met le nouveau noeud directement au suivant du prédécent 
			      (Cela coupe le lien suivant entre D1 et D3).
			       
			       À l'aide du constructeur de Noeud, D2.suivant == D3 et 
		           D2.précédent == D1.		         
		     */
			 
			 // On pourrait utiliser une variable temporaire aussi mais cest inutile.
			 positionCourante.precedent.suivant =
	            	 new Noeud(element, positionCourante, positionCourante.precedent);


			 // On ajuste le précédent de D3 à D2.
			 positionCourante.precedent =  positionCourante.precedent.suivant;
			 
			 // On déplace la position courante sur le nouveau noeud (D2).
			 positionCourante = positionCourante.precedent.suivant ;

			 
             // après l'ajout de D2 à la position courante.
			 //               D1        D2       D3       D5
			 // debut->         ->        ->        ->  null
			 //              null  ->        <-        <-          <- fin 
            //                              ^
			 //                             ||
			 //                            pc
			 nbElements++;
		 }
	 }


	 //LES AUTRES MÉTHODES
	 /**
	  * Retourne l'élément à la position courante
	  *
	  * Antécédent : La liste ne doit pas être vide.
	  *
	  * Conséquent : Le contenu de la liste est inchangé et la position courante
	  * reste inchangée.
	  *
	  *  @throws JavaNullPointerException
 	  * @return L'élément à la position courante
	  */
	 public Object getElement(){

		      /*STRATÉGIE : Retourne simplement l'élément du noeud à la
		       * position courante.
		       */
			 return positionCourante.element;
	 }

	 /**
	  * Retourne le nombre d'éléments actuellement dans la liste.
	  *
	  * Antécédent : aucun.
	  * Conséquent : aucun.
	  *
	  * @return Le nombre d'éléments de la liste.
	  */
	 public int getNbElements(){

		 return nbElements;
	 }

	 // La suppression de chaînage double vous est laissée en exercice.

}