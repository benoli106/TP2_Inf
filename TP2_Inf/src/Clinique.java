
import java.util.LinkedList;
import java.util.Vector;

/**
 * Cette classe regroupe tous les attributs et les méthodes pour la classe de
 * clinique, les attributs sont le calendrier, une liste contenant tous les
 * docteurs de la clinique, une liste contenant tous les infirmiers de la
 * clinique et une liste de tous les patients de la clinique
 *
 * @author Long Tran & Benjamin Fontaine
 * @since (copyright) LTran BFont - A2017
 * @version (copyright 2017)
 */
public class Clinique {

    // Attributs
    // Le calendrier de la clinique
    private Calendrier calendrier;

    // Liste de tous les docteurs de la clinique
    private Vector<Docteur> docteurs;

    // Liste de tous les infirmiers de la clinique
    private LinkedList<Infirmier> infirmiers;

    // Liste de tous les patients de la clinique
    private LinkedList<Patient> patients;

    // *********************ACCESSEURS******************************************
    // Permet de retourner un docteur à l'aide d'un indice reçu en paramètre
    public Docteur getDocteur(int i) {

        return docteurs.get(i);

    }

    // Permet de retourner un infirmier à l'aide d'un indice reçu en paramètre
    public Infirmier getInfirmier(int i) {

        return infirmiers.get(i);

    }

    // Permet de retourner un patient à l'aide d'un indice reçu en paramètre
    public Patient getPatient(int i) {

        return patients.get(i);

    }

    // Permet de retourner le calendrier de la clinique
    public Calendrier getCalendrier() {

        return calendrier;

    }

    // **********************MUTATEURS******************************************
    // Permet de modifier le patient
    public void setCalendrier(Calendrier calendrier) {
        this.calendrier = calendrier;
    }

    // **********************MÉTHODES******************************************
    // Méthode qui reçoit un docteur et permet de l'ajouter à la liste des
    // des docteurs de la clinique
    public boolean ajouterDocteur(Docteur docteur) {

        /* STRATÉGIE : La stratégie est de faire une fouille dans la liste
         * des docteurs pour trouver le docteur reçu en paramètre et ça retourne
         * false si le docteur existe déjà dans la liste sinon ça retourne true
         * et va l'ajouter à la liste des docteurs de la clinique        
         */
        for (int i = 0; i < docteurs.size(); i++) {

            // Si le docteur existe déjà dans la liste 
            if (docteurs.get(i).equals(docteur)) {

                return false;

            }

        }

        // Si le docteur n'est pas encore dans la liste des docteurs de la 
        // clinique
        docteurs.add(docteur);
        return true;

    }

    // Méthode qui reçoit un infirmier et permet de l'ajouter à la liste des
    // des infirmiers de la clinique
    public boolean ajouterInfirmier(Infirmier infirmier) {

        /* STRATÉGIE : La stratégie est de faire une fouille dans la liste
         * des infirmiers pour trouver l'infirmier
         * reçu en paramètre et ça retourne
         * false si l'infirmier existe déjà dans la liste sinon ça retourne true
         * et va l'ajouter à la liste des infirmiers de la clinique        
         */
        for (int i = 0; i < infirmiers.size(); i++) {

            // Si l'infirmier existe déjà dans la liste 
            if (infirmiers.get(i).equals(infirmier)) {

                return false;

            }

        }

        // Si l'infirmier n'est pas encore dans la liste des infirmiers de la 
        // clinique
        infirmiers.add(infirmier);
        return true;

    }

    // Méthode qui reçoit un patient et permet de l'ajouter à la liste des
    // des patients de la clinique
    public boolean ajouterPatient(Patient patient) {

        /* STRATÉGIE : La stratégie est de faire une fouille dans la liste
         * des patients pour trouver le patient
         * reçu en paramètre et ça retourne
         * false si le patient existe déjà dans la liste sinon ça retourne true
         * et va l'ajouter à la liste des patients de la clinique        
         */
        for (int i = 0; i < patients.size(); i++) {

            // Si le patient existe déjà dans la liste 
            if (patients.get(i).equals(patient)) {

                return false;

            }

        }

        // Si le patient n'est pas encore dans la liste des patients de la 
        // clinique
        patients.add(patient);
        return true;

    }
    
    // Méthode qui reçoit un patient et reoturne le premier rendez-vous
    // disponible pour ce patien
    public RendezVous rendezVousPatient(Patient patient) {
        
        LinkedList<PlageHoraire> tmp;
        
        ListeDouble plageHorraires = calendrier.getPlageHorraires();
        
        
        
        for(int i = 0; i < plageHorraires.size(); i++)
            
            plageHorraires(1)
            
        
        
        
    }

}
