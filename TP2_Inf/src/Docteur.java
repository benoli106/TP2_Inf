
/**
 * Cette classe regroupe tous les attributs et les méthodes pour la classe
 * docteur, les attributs sont son identification et son numéro de département.
 * Cette classe fait la description d'un docteur
 *
 * @author Long Tran & Benjamin Fontaine
 * @since (copyright) LTran & BFon - A2017
 * @version (copyright 2017)
 */

/**
 *
 * @author AP02990 & AP09770
 */
public class Docteur {

    // Attributs
    // Identification
    private Identification identification;

    // Numéro de Département
    private int numDepartement;

    // *********************CONSTRUCTEURS***************************************
    // Constructeur par défaut, lorsqu'il n'a pas de paramètres
    public Docteur() {

        // On initialise une idenfication avec des valeurs par défaut et un
        // numéro de département à 0 
        this.identification = null;
        this.numDepartement = 0;
    }

    // Constructeur par copie d'attributs, permet de copier les attributs
    // passés en paramètre
    public Docteur(Identification identification, int numDepartement) {

        // On copie les attributs de l'objet identification recu dans l'objet 
        // Identification du docteur
        this.identification = identification;
        this.numDepartement = numDepartement;

    }

    // Constructeur par copie d'objet, permet de copier les attributs de l'objet
    // passé en paramètre.
    public Docteur(Docteur docteur) {

        // Copier les attributs de l'objet docteur passé en paramètre
        this.identification.setNom(docteur.identification.getNom());
        this.identification.setPrenom(docteur.identification.getPrenom());
        this.numDepartement = docteur.numDepartement;
      
    }

    
    // *********************ACCESSEURS******************************************
    // Permet de retourner l'objet identification
    public Identification getIdentification() {
        return this.identification;
    }

    // Permet de retourner numéro de département
    public int getPrenom() {
        return this.numDepartement;
    }

    
    // **********************MUTATEURS******************************************
    // Permet de modifier l'identification du docteur
    public void setIdentification(Identification identification) {

        // On change les valeurs du nom et prenom du docteur dans son objet 
        // identification
        this.identification.setNom(identification.getNom());
        this.identification.setPrenom(identification.getPrenom());
    }

    // Permet de modifier le prénom au prénom passé en paramètre
    public void setNumDepartement(int num) {
        
        // On change le numero de departement du docteur par celui passer 
        // en paramètre
        this.numDepartement = num;
    }

    
}
