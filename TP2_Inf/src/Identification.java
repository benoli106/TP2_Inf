
/**
 * Cette classe regroupe tous les attributs et les méthodes pour la classe
 * d'identification, les attributs sont le nom et le prénom, cette classe va
 * être utilisé dans les autres classes afin de ne pas les répéter dans les
 * autres classes
 *
 * @author Long Tran & Benjamin Fontaine
 * @since (copyright) LTran BFont - A2017
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

        //L e nom est vide par défaut
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
    
    // Retourne la concaténation du nom et du prénom.
    public String toString() {
        
        return (nom+" "+prenom);
          
    }
    
    // Permet de comparer 2 objets du même type
    public boolean equals(Identification identification) {
        
        // Comparer les adressses de référence
        if (this == Identification) {
            
            return true;
            
        }
        
        // Comparer les attributs des objets
        if(nom.equals(identification.getNom()) 
                && prenom.equals(identification.getPrenom())) {
            
            return true;
            
        }
        
        // Si l'adresse et les attributs ne sont pas pareils.
        else {
            
           return false;
            
        }
        
    }
    
    // Permet d'obtenir une instance de la classe avec une copie des attributs
    // de l'objet passé en paramètre    
    public Identification clone(Identification identification) {
        
        // On créer un nouvel objet clone et on assigne les valeurs
        Identification leClone = new Identification();
        leClone.nom = identification.nom;
        leClone.prenom = identification.prenom;
        
        // On retourne le clone de l'objet
        return leClone;
    }
    
    

}
