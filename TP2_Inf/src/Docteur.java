
/**
 * Cette classe regroupe tous les attributs et les méthodes pour la classe
 * Docteur, les attributs sont son identification et son numéro de département.
 * Cette classe fait la description d'un Docteur
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
        // Identification du Docteur
        this.identification = identification;
        this.numDepartement = numDepartement;

    }

    // Constructeur par copie d'objet, permet de copier les attributs de l'objet
    // passé en paramètre.
    public Docteur(Docteur Docteur) {

        // Copier les attributs de l'objet Docteur passé en paramètre
        this(Docteur.identification.clone(), Docteur.numDepartement);

    }

    // *********************ACCESSEURS******************************************
    // Permet de retourner l'objet identification
    public Identification getIdentification() {
        return this.identification;
    }

    // Permet de retourner numéro de département
    public int getNumDepartement() {
        return this.numDepartement;
    }

    // **********************MUTATEURS******************************************
    // Permet de modifier l'identification du Docteur
    public void setIdentification(Identification identification) {

        // On change les valeurs du nom et prenom du Docteur dans son objet 
        // identification
        this.identification.setNom(identification.getNom());
        this.identification.setPrenom(identification.getPrenom());
    }

    // Permet de modifier le prénom au prénom passé en paramètre
    public void setnumDepartement(int num) {

        // On change le numero de departement du Docteur par celui passer 
        // en paramètre
        this.numDepartement = num;
    }

    // Retourne la concaténation du nom et du prénom et du numéro de departement.
    public String toString() {

        // On fait appel au toString de identification et on ajoute le n. de
        // departement du Docteur
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
    public Docteur clone() {
        
        // On retourne le clone de l'objet
        return new Docteur(this);
    }
}
