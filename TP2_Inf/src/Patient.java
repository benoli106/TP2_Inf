
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
    public Patient() {

        // On initialise une idenfication avec des valeurs par défaut et un
        // NAS a 0
        this.identification = null; 
        this.NAS = 0;
    }

    // Constructeur par copie d'attributs, permet de copier les attributs
    // passés en paramètre
    public Patient(Identification identification, int NAS) {

        // On copie les attributs de l'objet identification recu dans l'objet 
        // Identification du Patient
        this.identification = identification;
        this.NAS = NAS;

    }

    // Constructeur par copie d'objet, permet de copier les attributs de l'objet
    // passé en paramètre.
    public Patient(Patient Patient) {

        // Copier les attributs de l'objet Patient passé en paramètre
        this.identification.setNom(Patient.identification.getNom());
        this.identification.setPrenom(Patient.identification.getPrenom());
        this.NAS = Patient.NAS;

    }

    // *********************ACCESSEURS******************************************
    // Permet de retourner l'objet identification
    public Identification getIdentification() {
        return this.identification;
    }

    // Permet de retourner le NAS
    public int getNAS() {
        return this.NAS;
    }

    // **********************MUTATEURS******************************************
    // Permet de modifier l'identification du Patient
    public void setIdentification(Identification identification) {

        // On change les valeurs du nom et prenom du Patient dans son objet 
        // identification
        this.identification.setNom(identification.getNom());
        this.identification.setPrenom(identification.getPrenom());
    }

    // Permet de modifier le NAS avec lui passé en paramètre
    public void setNAS(int NAS) {

        // On change le NAS du Patient par celui passer 
        // en paramètre
        this.NAS = NAS;
    }

    // Retourne la concaténation du nom et du prénom et du numéro d'assurance
    // social.
    public String toString() {

        // On fait appel au toString de identification et on ajoute le n.
        // d'assurance social du Patient
        return (identification.toString() + NAS);

    }

    // Permet de comparer 2 objets du même type
    public boolean equals(Patient patient) {

        // Comparer les adressses de référence
        if (this == patient) {

            return true;

        }

        // Comparer les attributs des objets
        if (identification.getNom().equals(patient.identification.getNom())
                && identification.getPrenom().equals(patient.identification
                        .getPrenom()) && NAS == patient.NAS) {

            return true;

        } // Si l'adresse ou que les attributs ne sont pas pareils.
        else {

            return false;

        }
    
    }
    
    // Permet d'obtenir une instance de la classe avec une copie des attributs
    // de l'objet passé en paramètre    
    public Patient clone() {
        
        // On retourne le clone de l'objet
        return new Patient(this);
    }
}
