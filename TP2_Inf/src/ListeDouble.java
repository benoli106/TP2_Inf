/**
 * Classe qui impl�mente une liste doublement cha�n�e
 * avec une position courante.  En tout temps les op�rations
 * se font par rapport � la position courante qui fait partie int�grante de la liste.
 *
 * Les m�thodes pour d�placer la position courante font partie de la classe.
 *
 * Pour l'insertion, la position courante est toujours sur le noeud ajout�.
 *
 * Pour la suppression, la position courante est le noeud suivant celui qui vient
 * d'�tre supprim� (non impl�ment�e).
 *
 * On ne l�ve aucune exception pour cet exemple.  Seul les exceptions syst�mes
 * seront lev�es s'il y a un probl�me.
 *
 * @author  <a href="mailto:pierre.belisle@etsmtl.ca">Pierre B�lisle</a>
 * @version f�vrier 2014
 */
public class ListeDouble {

	/*
	 * STRAT�GIE : On garde une r�f�rence sur le premier et le dernier noeud
	 * de la liste.  Une r�f�rence sur la position courante et le nombre d'�l�ments
	 * est mis � jour apr�s chaque insertion.
	 *
	 * Le cha�nage est double alors le noeud contient une r�f�rence sur
	 * le noeud suivant et le noeud pr�c�dent
	 *
	 * Les stat�gies pour chaque m�thode sont d�crites dans leur commentaire
	 * de strat�gie respectf.
	 */


	 /*
	  *Une liste est un ou pls noeuds li�s ensemble dans les deux sens.
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

	 //R�f�rence sur la position o� sont effectu� les op�ration.
	 private Noeud positionCourante;

	 //Maintenu � jour apr�s une insertion ou une suppresion.
	 private int nbElements;


	 /**
	  * Cr�e une liste vide.
	  */
	 public ListeDouble(){

	    	/**
	    	 * STRAT�GIE : On initialise explicitement les valeurs plut�t 
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
	  * Ant�c�dent : Aucun.
	  *
	  * Cons�quent : Aucun.
	  *
	  * @return Si true la liste est vide et false autrement
	  */
	 public boolean estVide(){

		 /*
		  * STRAT�GIE : On retourne simplement l'�valuation bool�enne de la
		  *  comparaison du nombre d'�l�ments avec 0.
		  */
	     return nbElements == 0;
	 }


	 //LES M�THODES DE D�PLACEMENT
	 /**
	  * Passe la position courante au suivant dans la liste.
	  *
	  * Ant�c�dent : Aucun.
	  *
	  * Cons�quent : La position est d�plac�e sur l'�l�ment suivant s'il existe.
	  * Sinon position courante est sur le dernier de la liste.
 	  *
	  *  @throws JavaNullPointerException
	  */
	 public void setPosSuivant() {


		 /*
		  * STRAT�GIE : Si c'est la fin, on ne d�place pas, sinon 
		  * on passe au suivant.
		  */
		 if(positionCourante.suivant != null){


    	     positionCourante = positionCourante.suivant;

		 }

	 }

	 /**
	  * Met la position courante au d�but de la  liste.
	  *
	  * Cons�quent : position == debut.
	  */
	 public void setPosDebut() {


         /*
          * STRAT�GIE : On d�place la position courante 
          *  au noeud point� par d�but.
          */
		 positionCourante = debut;

	 }

	 /**
	  * Met la position courante � la fin de la liste.
	  *
	  * Cons�quent : position == fin.
	  *
	  */
	 public void setPosFin() {


         /*
          * STRAT�GIE : On d�place la position courante au noeud point� 
          * par le pointeur de fin.
          */
		 positionCourante = fin;


	 }

	 /**
	  * Passe la position courante au pr�c�dent dans la liste.
	  *
	  * Ant�c�dent : La liste ne doit pas �tre vide.
	  *
	  * Cons�quent : La position courante est sur l'�l�ment pr�c�dent s'il existe.
	  * Sinon position courante == debut.
	  *
 	  *  @throws JavaNullPointerException
	  */
	 public void setPosPrecedent(){


		 /*
		  *STRAT�GIE : On d�place la position sur son pr�c�dent sauf 
		  *si elle est au d�but.
		  */

		 // On ne d�place rien si on est au d�but.
		 if(positionCourante != debut) {

		    positionCourante = positionCourante.precedent;

		 }

	 }


	 //LES M�THODES D'INSERTION
	 /**
	  * Ins�re l'�l�ment re�u en d�but de liste
	  *
	  * Ant�d�cent : Aucun.
	  *
	  * Cons�quent : nbElement = nbElement + 1 &  position == debut &
	  *  this.getElement() == element.
	  *
      * @param element L'�l�ment � ins�rer au d�but  de la liste
	  */
	 public void insererDebut(Object element){

		 /*
		  * STRAT�GIE : On cr�e un noeud en faisant le lien sur l'ancien d�but.  
		  * On  utilise le nombre d'�l�ments pour tester si la liste est vide.
		  * Si c'est le cas, il faut placer le pointeur de fin.  On place  la position 
		  * courante sur le noeud qui vient d'�tre cr��.  
		  * On incr�mente le nombre d'�l�ments dans tous les cas.
		  */

     	 // Cr�ation du noeud avec le lien sur l'ancien d�but.
  	     debut = new Noeud(element,debut,null);

  	     // La liste est vide, on place le pointeur de fin.
  	     if (nbElements == 0)
		     fin = debut;

  	     // Sinon, il faut ajuste le pr�c�dent de l'ancien d�but.
  	     else
  	        debut.suivant.precedent = debut;

  	     // On place la position courante sur le nouveau noeud en t�te de liste.
  	     positionCourante = debut;

		 // Un �l�ment de plus.
		 nbElements++;
	 }

	 /**
	  * Ins�re l'�l�ment re�u en fin de liste.
	  *
	  * Ant�d�cent : Aucun.
	  *
	  * Cons�quent : nbElement = nbElement + 1 & position == fin &
	  *  liste.getElement() == element.
	  *
	  * @param element L'�l�ment � ins�rer � la fin de  la liste.
	  */
	 public void insererFin(Object element){

		 /*
		  * STRAT�GIE : On utilise le nombre d'�l�ments pour tester si la liste est
		  *  vide. Si c'est le cas, on utilise la m�thode qui ins�re au d�but.
		  * Sinon, on cr�e un nouveau noeud et on le lie � celui de fin.  On d�place
		  * ensuite le pointeur de fin et la position courante sur le nouveau noeud.
		  * On incr�mente le nombre d'�l�ments.
		  */

		 // Si la liste est vide, on ins�re au d�but.
		 if(nbElements == 0)
			 insererDebut(element);

		 // Sinon on ins�re apr�s le dernier.
		 else{

			    // Cr�ation du nouveau noeud li� apr�s la fin avec cha�nage sur
			    // l'ancienne fin
			    fin.suivant = new Noeud(element,null,fin);

			    // D�place le pointeur de fin.
			    fin = fin.suivant;

			    // Place la position courante � la fin.
			    positionCourante = fin;

			    // Un �l�ment de plus.
			    nbElements++;
		 }
	 }


	 /**
	  * Ins�re l'�l�ment re�u apr�s la position courante.
      *
      * Ant�d�cent : Aucun.
      *
	  * Cons�quent : nbElement = nbElement + 1 & liste.getElement() == element.
	  *
	  * @param element L'�l�ment � ins�rer apr�s la position courante.
	  *
	  */
	 public void insererApres(Object element){

		 /*
		  * STRAT�GIE : On utilise le nombre d'�l�ments pour tester si la liste est
		  *  vide et on regarde si la position courante est � la fin. Si c'est le cas,
		  *  on utilise la m�thode qui ins�re � la fin.
		  *  Sinon, on cr�e un nouveau noeud et on le lie au noeud point�
		  *  par la position courante.  Si c'est le dernier noeud, on il faut ajuster le
		  *  pointeur de fin (on aurait pu penser � utiliser insererFin mais c'est plus lent)
		  *  On d�place la position courante sur le nouveau noeud.
		  *  On incr�mente le nombre d'�l�ments.
		  */

		 // Si la liste est vide, ou que la position courante est � la fin,
		 // on ins�re � la fin.
		 if(nbElements == 0 || positionCourante == fin)
			 insererFin(element);

		 else{

			 // Ajuste le pr�c�dent du suivant de la position courante.
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

		      //un �l�ment de plus
		      nbElements++;
		 }
	 }

	 /**
	  * Ins�re l'�l�ment re�u avant la position courante
	  *
      * Ant�d�cent : Aucun.
      *
	  * Cons�quent : nbElement = nbElement + 1 & liste.getElement() == element.
	  *
	  * @param element L'�l�ment � ins�rer dans la liste avant la position courante.
	  */
	 public void insererAvant(Object element){

		 /*
		  * STRAT�GIE : On utilise le nombre d'�l�ments pour tester si la liste est
		  *  vide. Si c'est le cas, on utilise la m�thode qui ins�re au d�but mais
		  * on n'incr�mente pas le nombre d'�l�ments puisque insererDebut le fait.
		  *
		  * Sinon, c'est la m�me technique que pour l'insertion apr�s sauf que le
		  * cha�nage se fait avant la position courante.  L�, il faut incr�m�menter le
		  * nombre d'�l�ments.
		  *
		  */

		 //Si la liste est vide ou un seul �l�ment, on ins�re au d�but.
		 if(nbElements <= 1 || positionCourante == debut)
			 insererDebut(element);

		 		 
		 //On effectue le cha�nage avec le nouveau noeud, des deux c�t�s.
		 else{

              // Ex: avant l'ajout de D2 � la position courante.
			 //               D1        D3       D5
			 // debut->         ->        ->  null   
			 //              null  <-        <-           <- fin
             //                             ^
			 //                             ||
			 //                            pc

			 /* On met le nouveau noeud directement au suivant du pr�d�cent 
			      (Cela coupe le lien suivant entre D1 et D3).
			       
			       � l'aide du constructeur de Noeud, D2.suivant == D3 et 
		           D2.pr�c�dent == D1.		         
		     */
			 
			 // On pourrait utiliser une variable temporaire aussi mais cest inutile.
			 positionCourante.precedent.suivant =
	            	 new Noeud(element, positionCourante, positionCourante.precedent);


			 // On ajuste le pr�c�dent de D3 � D2.
			 positionCourante.precedent =  positionCourante.precedent.suivant;
			 
			 // On d�place la position courante sur le nouveau noeud (D2).
			 positionCourante = positionCourante.precedent.suivant ;

			 
             // apr�s l'ajout de D2 � la position courante.
			 //               D1        D2       D3       D5
			 // debut->         ->        ->        ->  null
			 //              null  ->        <-        <-          <- fin 
            //                              ^
			 //                             ||
			 //                            pc
			 nbElements++;
		 }
	 }


	 //LES AUTRES M�THODES
	 /**
	  * Retourne l'�l�ment � la position courante
	  *
	  * Ant�c�dent : La liste ne doit pas �tre vide.
	  *
	  * Cons�quent : Le contenu de la liste est inchang� et la position courante
	  * reste inchang�e.
	  *
	  *  @throws JavaNullPointerException
 	  * @return L'�l�ment � la position courante
	  */
	 public Object getElement(){

		      /*STRAT�GIE : Retourne simplement l'�l�ment du noeud � la
		       * position courante.
		       */
			 return positionCourante.element;
	 }

	 /**
	  * Retourne le nombre d'�l�ments actuellement dans la liste.
	  *
	  * Ant�c�dent : aucun.
	  * Cons�quent : aucun.
	  *
	  * @return Le nombre d'�l�ments de la liste.
	  */
	 public int getNbElements(){

		 return nbElements;
	 }

	 // La suppression de cha�nage double vous est laiss�e en exercice.

         public void supprimer(){
          
             // Si le PC est au debut, on supprime le PC en enlevant son lien avec
             // le prochain noeud et on change la position au prochain noeud
             if(nbElements == 1){
                 
                positionCourante = null;
                debut = null;
                fin = null;
                
             }
             // Si le PC est à la fin, on remplace le noeud précédant par le PC
             // et on coupe le lien en changeat la fin et la position courante
             else if(positionCourante == fin){
                positionCourante.precedent.element = positionCourante.element;
                positionCourante.precedent.suivant = null;
                positionCourante = positionCourante.precedent;
                fin = positionCourante;
             }
             else{
             
            // Pour tous les autres cas, on change le precedant et le suivant du PC
            // pour qu'ils pointe sur chacun d'eux de facon à ne plus pointer sur le 
            // PC pour qu'il s'efface
                  positionCourante.precedent.suivant = positionCourante.suivant;
                 positionCourante.suivant.precedent = positionCourante.precedent;
                 positionCourante = positionCourante.precedent;
                 
             }
             
             nbElements -- ;
         }
}