
/**
 * Cette classe regroupe tous les attributs et les méthodes pour la classe
 * d'identification, les attributs sont le nom et le prénom, cette classe va
 * être utilisé dans les autres classes afin de ne pas les répéter dans les
 * autres classes
 *
 * @author Long Tran
 * @since (copyright) LTran - A2017
 * @version (copyright 2017)
 */
public class Identification {

    // Attributs
    // Nom
    private String nom;

    // Prénom 
    private String prenom;

    // *********************CONSTRUCTEURS***************************************
    // Constructeur par défaut, lorsqu'il n'a pas de paramètres
    public Identification() {

        //Le nom est vide par défaut
        setNom("");

        //Le prénom est vide par défaut
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
    public Identification(Identification Identification) {

        // Copier les attributs de l'objet d'identification passé en paramètre
        this(Identification.nom, Identification.prenom);

    }

    // *********************ACCESSEURS******************************************
    // Permet de retourner le nom qui est en string
    public String getNom() {
        return nom;
    }

    // Permet de retourner le prenom qui est en string
    public String getPrenom() {
        return prenom;
    }

    // **********************MUTATEURS******************************************
    // Permet de modifier le nom au nom passé en paramètre
    public void setNom(String nom) {
        this.nom = nom;
    }

    // Permet de modifier le prénom au prénom passé en paramètre
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    
}
