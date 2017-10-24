
/**
 * Cette classe regroupe tous les attributs et les méthodes pour la classe
 * patient, les attributs sont son identification et son numéro d'assurance social.
 * Cette classe fait la description d'un patient
 *
 * @author Long Tran & Benjamin Fontaine
 * @since (copyright) LTran & BFon - A2017
 * @version (copyright 2017)
 */
/**
 *
 * @author AP02990 & AP09770
 */
public class Patient {

    // Attributs
    // Identification
    private Identification identification;

    // Numéro d'assurance social
    private int NAS;

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

    // Retourne la concaténation du nom et du prénom et du numéro de departement.
    public String toString() {

        // On fait appel au toString de identification et on ajoute le n. de
        // departement du docteur
        return (identification.toString() + numDepartement);

    }

    // Permet de comparer 2 objets du même type
    public boolean equals(Docteur docteur) {

        // Comparer les adressses de référence
        if (this == docteur) {

            return true;

        }

        // Comparer les attributs des objets
        if (identification.getNom().equals(docteur.identification.getNom())
                && identification.getPrenom().equals(docteur.identification
                        .getPrenom()) && numDepartement == docteur.numDepartement) {

            return true;

        } // Si l'adresse ou que les attributs ne sont pas pareils.
        else {

            return false;

        }
    
    }
    
    // Permet d'obtenir une instance de la classe avec une copie des attributs
    // de l'objet passé en paramètre    
    public Docteur clone(Docteur docteur) {
        
        // On créer un nouvel objet clone et on assigne les valeurs
        Docteur leClone = new Docteur();
        leClone.identification.setNom(docteur.getIdentification().getNom());
        leClone.identification.setPrenom(docteur.getIdentification().getPrenom());
 
        // On retourne le clone de l'objet
        return leClone;
    }
}
