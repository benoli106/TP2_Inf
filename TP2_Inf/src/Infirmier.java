/**
 * Cette classe regroupe tous les attributs et les méthodes pour la classe
 * de l'infirmier, les attributs sont l'idenfitication et sa disponibilité
 *
 * @author Long Tran & Benjamin Fontaine
 * @since (copyright) LTran BFont - A2017
 * @version (copyright 2017)
 */
public class Infirmier {
    
    // Attributs
    
    // Identification
    private Identification identification;
    
    // Sa disponibilité
    private boolean disponibilite;
    
    

 // *********************CONSTRUCTEURS***************************************
    // Constructeur par défaut, lorsqu'il n'a pas de paramètres
    public Infirmier() {

        // Le nom est vide par défaut
        setNom("");

        // Le prénom est vide par défaut
        setPrenom("");

    }

    // Constructeur par copie d'attributs, permet de copier les attributs
    // passés en paramètre
    public Identification(String nom, String Prenom) {

        // Le nom de l'objet va être identique au nom passé en paramètre
        setNom(nom);

        // Le prénom de l'objet va être identique au prénom passé en paramètre
        setPrenom(prenom);

    }

    // Constructeur par copie d'objet, permet de copier les attributs de l'objet
    // passé en paramètre.
    public Identification (Identification Identification) {

        // Copier les attributs de l'objet d'identification passé en paramètre
        this(Identification.nom, Identification.prenom);

    }
    
    
    
    
    
    
    
}
