
/**
 * Cette classe regroupe tous les attributs et les méthodes pour la classe de 
 * rendez-vous, les attributs sont le patient, le docteur consulté et
 * l'infirmier
 *
 * @author Long Tran & Benjamin Fontaine
 * @since (copyright) LTran BFont - A2017
 * @version (copyright 2017)
 */
public class RendezVous {

    // Attributs
    // Le patient
    private Patient patient;

    // Le docteur
    private Docteur docteur;

    // L'infirmier
    private Infirmier infirmier;

    // *********************CONSTRUCTEURS***************************************
    // Constructeur par copie d'attributs
    public RendezVous(Patient patient, Docteur docteur, Infirmier infirmier) {

        // L'attribut patient va être copié du patient passé en paramètre
        setPatient(patient);

        // L'attribut docteur va être copié du docteur passé en paramètre
        setDocteur(docteur);

        // L'attribut Infirmier va être copié de l'infirmier passé en paramètre
        setInfirmier(infirmier);

    }

    // *********************ACCESSEURS******************************************
    // Retourne le patient
    public Patient getPatient() {
        return patient;
    }

    // Retourne le docteur
    public Docteur getDocteur() {
        return docteur;
    }

    // Retourne l'infirmier
    public Infirmier getInfirmier() {
        return infirmier;
    }
    

    // **********************MUTATEURS******************************************
    // Permet de modifier le patient
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    // Permet de modifier le docteur
    public void setDocteur(Docteur docteur) {
        this.docteur = docteur;
    }

    // Permet de modifier l'infirmier
    public void setInfirmier(Infirmier infirmier) {
        this.infirmier = infirmier;
    }

    // **********************MÉTHODES******************************************
    // Permet de retourner les informations complète sur le docteur, patient et
    // l'infirmier
    public String toString() {

        // On fait appel au toString du patient,docteur et de l'infirmier 
        // qui étaient définis auparavant
        return (patient.toString() + " " + docteur.toString() + " "
                + infirmier.toString());

    }

    // Permet de comparer 2 objets du même type
    public boolean equals(RendezVous rendezVous) {

        // Comparer les adressses de référence
        if (this == rendezVous) {

            return true;

        }

        // Comparer les attributs des objets
        if (rendezVous.getDocteur().equals(docteur)
                && rendezVous.getInfirmier().equals(infirmier)
                && rendezVous.getDocteur().equals(patient)) {

            return true;

        } // Si l'adresse ou que les attributs ne sont pas pareils.
        else {

            return false;

        }

    }
}
