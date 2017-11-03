
/**
 * Cette classe regroupe tous les attributs et les méthodes pour la classe de
 * l'infirmier, les attributs sont l'idenfitication et sa disponibilité
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

        // Aucune identification
        identification = null;

        // Disponibilite est false par défaut
        setDisponibilite(false);

    }

    // Constructeur par copie d'attributs, permet de copier les attributs
    // passés en paramètre
    public Infirmier(Identification identification, boolean disponibilite) {

        // L'attribut identification va être copié de l'identification passé
        // en paramètre
        setIdentification(identification);

        // L'attribut disponibilité va être copié de la disponibilité passé
        // en paramètre
        setDisponibilite(disponibilite);

    }

    // Constructeur par copie d'objet, permet de copier les attributs de l'objet
    // passé en paramètre.
    public Infirmier(Infirmier infirmier) {

        // Copier les attributs de l'objet infirmier passé en paramètre
        this(infirmier.identification.clone(), infirmier.disponibilite);

    }

    // *********************ACCESSEURS******************************************
    // Retourne l'identification
    public Identification getIdentification() {
        
        return identification;
        
    }

    // Retourne la disponibilité
    public boolean getDisponibilite() {
        
        return disponibilite;
        
    }

    // **********************MUTATEURS******************************************
    // Modifier l'identification 
    public void setIdentification(Identification identification) {
        
        this.identification = identification;
    }

    // Modifier la disponibilité
    public void setDisponibilite(boolean disponibilite) {
        
        this.disponibilite = disponibilite;
        
    }

    // **********************MÉTHODES******************************************
    // Retourne la concaténation du nom et du prénom.
    public String toString() {

        return (identification.toString() + " " + disponibilite);
 
    }

    // Permet de comparer 2 objets du même type
    public boolean equals(Infirmier infirmier) {

        // Comparer les adressses de référence
        if (this == infirmier) {

            return true;

        }

        // Comparer les attributs des objets
        if (infirmier.getDisponibilite() == getDisponibilite()
                && infirmier.getIdentification() == getIdentification()) {

            return true;

        } // Si l'adresse ou que les attributs ne sont pas pareils.
        else {

            return false;

        }

    }

    // Permet d'obtenir une instance de la classe avec une copie des attributs.
    // de l'objet passé en paramètre    
    public Infirmier clone() {

        // On retourne le clone de l'objet
        return new Infirmier(this);
    }

}
