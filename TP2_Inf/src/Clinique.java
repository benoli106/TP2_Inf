
import java.util.Date;
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

    // *********************CONSTRUCTEURS***************************************
    public Clinique() {

        calendrier = new Calendrier();
        docteurs = new Vector();
        infirmiers = new LinkedList();
        patients = new LinkedList();

    }

    // *********************ACCESSEURS******************************************
    // Permet de retourner un docteur à l'aide d'un indice reçu en paramètre
    public Docteur getDocteur(int i) {
        return docteurs.get(i);

    }

    // retourne la liste des infirmiers
    public LinkedList<Infirmier> getInfirmiers() {
        return infirmiers;
    }

    // retourne la liste des patients
    public LinkedList<Patient> getPatients() {
        return patients;
    }

    // retourne la liste des docteurs
    public Vector<Docteur> getDocteurs() {
        return docteurs;
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
    // disponible pour ce patient   
    public RendezVous rendezVousPatient(Patient patient) {

        // **********************VARIABLES*****************************************
        // Une variable qui store la liste des plages horaire du calendrier
        ListeDouble plageHoraires = calendrier.getListePlageHoraire();

        // La date de la journée courante
        Date currentDate = new Date();

        // Pour storer un docteur qui est disponible
        Docteur docteurDisponible = null;

        // Pour storer une plage horaire disponible pour créer le rendez vous
        PlageHoraire plageHoraireDispo = null;

        // Pour storer un infirmier disponible pour créer le rendez vous
        Infirmier infirmierDispo = null;

        // Le rendez vous le plus tôt
        RendezVous rdvDispo = null;

        // On remet le curseur de la plage horaire à 0
        plageHoraires.setPosDebut();

        /* STRATÉGIE : Boucler tous les plages horaires , ensuite dans une plage
         * on boucle les docteurs et ensuite dans un docteur, o n boucle 
         * les rendez vous pour s'assurer que le docteur n'a pas déjà un rdv,
         * façcon similaire pour les infirmiers
         * sinon on continue des boucler les docteurs et les plages horaires
         * jusqu'à temps qu'on trouve une plage horaire avec un docteur et 
         * infirmier de libre
         */
        // Boucler dans tous les plage horaires jusqu'à temps qu'il trouve 
        // une plage horaire disponible
        for (int j = 0; j < plageHoraires.getNbElements()
                || plageHoraireDispo == null; j++) {

            PlageHoraire tmpPlage
                    = (PlageHoraire) (plageHoraires.getElement());
            int test = tmpPlage.getListeRendezVous().size();
            if (tmpPlage.getListeRendezVous().size() > 0) {

                // Boucler dans tous les docteurs jusqu'à temps qu'il trouve un docteur
                // disponible
                for (int i = 0; i < docteurs.size()
                        || docteurDisponible == null; i++) {

                    int k = 0;

                    // Un rdv temporaire
                    RendezVous tmpRdv = null;

                    // Boucler tous les rendez vous de la plage horaire et 
                    // boucler à travers les docteurs 
                    // tant que le docteur ne se retrouve pas déjà 
                    // dans un rendez vous
                    do {

                        tmpRdv
                                = (RendezVous) tmpPlage.getListeRendezVous().get(k);

                        k++;
                    } while (k < tmpPlage.getListeRendezVous().size()
                            || tmpRdv.getDocteur() != docteurs.get(i));

                    // Si on a parcouru tous les rendez vous et que le docteur
                    // n'était pas dans un des rendez vous,
                    if (k == tmpPlage.getListeRendezVous().size() - 1) {

                        // Boucler dans les infirmiers pour trouver un
                        // infirmier de disponible
                        for (int l = 0; l < infirmiers.size()
                                || infirmierDispo == null; i++) {

                            int ii = 0;

                            // Boucler à travers tous les rendez vous pour savoir
                            // si un infirmier est libre
                            do {

                                tmpRdv
                                        = (RendezVous) tmpPlage
                                                .getListeRendezVous().get(ii);

                                ii++;

                            } while (ii < tmpPlage.getListeRendezVous().size()
                                    || tmpRdv.getInfirmier() != infirmiers.get(l));

                            // Pour vérifier si l'infirmier est dans aucun des
                            // des rendez vous
                            if (ii < tmpPlage.getListeRendezVous().size() - 1) {

                                infirmierDispo = infirmiers.get(ii);
                                // sauvegarder le docteur pour créer un rendez vous
                                docteurDisponible = docteurs.get(i);

                                plageHoraireDispo = tmpPlage;

                                // Créer un nouveau rendez vous 
                                // avec un docteur,infirmier et patient
                                rdvDispo
                                        = new RendezVous(patient,
                                                docteurDisponible,
                                                infirmierDispo);

                            }

                        }

                    }
                }

                plageHoraires.setPosSuivant();
            } else {
                // Si il n'y a aucun rendez vous à la plage d'horaire, on va 
                // prendre le premier docteur et infirmier
                docteurDisponible = docteurs.firstElement();
                infirmierDispo = infirmiers.getFirst();
                plageHoraireDispo = tmpPlage;

                rdvDispo = new RendezVous(patient, docteurDisponible, infirmierDispo);
                plageHoraireDispo.addRendezVous(rdvDispo);

            }

        }

        return rdvDispo;

    }
}
