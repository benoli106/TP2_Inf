


/**
 * Cette classe regroupe tous les attributs et les méthodes pour la classe de de
 * Calendrier, l'attribut principal est une liste de plage horaire
 *
 * @author Long Tran & Benjamin Fontaine
 * @since (copyright) LTran BFont - A2017
 * @version (copyright 2017)
 */
public class Calendrier {

    // Attributs
    // Liste de Plage Horaire
    private ListeDouble listePlageHoraire;

    // Constructeur ... qui permet de créer un nouveau calendrier
    public Calendrier() {

    }

    // Retourne la liste des plagesHoraires 
    public ListeDouble getListePlageHoraire(){
        return listePlageHoraire;
    }
    //
    public void ajouterRendezVous() {

    }

    // Retourne une chaine de caractère qui décrit la date et la liste de rendez-vous
    // de chaque plage horaire dans la liste.
    public String toString() {

        // On initialise un string de retour avec un titre 
        String retour = "Calendrier : " + "\n";

        // On va chercher le toString de chacun des objet rendez-vous dans
        // chacune des plages de la liste, et on ajoute la date de la plage
        // horaire concernée 
        for (PlageHoraire plage : this.listePlageHoraire) {
            retour += ("\n" + plage.getDateHeure() + "\n");
            for (RendezVous rdv : plage.getListeRendezVous()) {
                retour += rdv.toString() + "\n";
            }
        }

        // Retourne le string;
        return retour;
    }

    // Cette méthode recoit un patient puis va tenter de trouver un rendez-vous
    // dans la liste de plages et leur rendezvous qui lui est assigner.
    // Si un rendezvous est trouver, on considère que c'est le prochaine et donc
    // on retourne ce rendezvous.
    public RendezVous obtenirProchainRendezVousPatient(Patient patient) {
        
        // Parcours la liste des plages Horaires
        for (PlageHoraire plage : this.listePlageHoraire) {
            
            // on regarde chaque rendezvous à savoir s'il est assigner à notre
            // patient
            for (RendezVous rdv : plage.getListeRendezVous()) {

                // On retourne le rendez-vous
                if (rdv.getPatient() == patient) {
                    return rdv;
                }
            }
        }
        return null;
    }

    // Cette méthode recoit un infirmier puis va tenter de trouver un rendez-vous
    // dans la liste de plages et leur rendezvous qui lui est assigner.
    // Si un rendezvous est trouver, on considère que c'est le prochaine et donc
    // on retourne ce rendezvous.
    public RendezVous obtenirProchainRendezVousInfirmier(Infirmier infirmier) {

           for (PlageHoraire plage : this.listePlageHoraire) {
            
            // on regarde chaque rendezvous à savoir s'il est assigner à notre
            // infirmier
            for (RendezVous rdv : plage.getListeRendezVous()) {

                // On retourne le rendez-vous
                if (rdv.getInfirmier()== infirmier) {
                    return rdv;
                }
            }
        }
        return null;
    }

   // Cette méthode recoit un docteur puis va tenter de trouver un rendez-vous
    // dans la liste de plages et leur rendezvous qui lui est assigner.
    // Si un rendezvous est trouver, on considère que c'est le prochaine et donc
    // on retourne ce rendezvous.
    public RendezVous obtenirProchainRendezVousDocteur(Docteur docteur) {

           for (PlageHoraire plage : this.listePlageHoraire) {
            
            // on regarde chaque rendezvous à savoir s'il est assigner à notre
            // docteur
            for (RendezVous rdv : plage.getListeRendezVous()) {

                // On retourne le rendez-vous
                if (rdv.getDocteur()== Docteur) {
                    return rdv;
                }
            }
        }
        return null;
    }


    // Retourne la plage horaire la plus proche, donc la plus récente
    public PlageHoraire obtenirProchainePlageHoraire() {

        return this.listePlageHoraire.get(0);
    }

    // On recherche chaque rendezvous de chaque plage horaire et on 
    // regarde s'il existe deja dans une plage horaire. Si oui, on l'annule
    // et on return true, si non, on return false.
    public boolean annulerRendezVous(RendezVous rdv) {

        // On cherche dans chaque plage horaire
        for (PlageHoraire plage : this.listePlageHoraire) {
        
            // On cherche dans chaque rendez vous
            for (RendezVous rdv2 : plage.getListeRendezVous()){
                
                // Si le rendezvous current est égal au rendez-vous recu en
                // paramètre, on l'annule.
                if(rdv2.equals(rdv)){
                 
                    // On enlève le rendez vous
                    plage.getListeRendezVous().remove(rdv);
                    
                    // Si la plage ne contient plus aucun rendez vous,
                    // on la supprimer de la liste
                    if(plage.getListeRendezVous().size() == 0){
                        this.listePlageHoraire.remove(plage);
                    }
                    return true;
                }
            }
        }
        return false;
    }

    //
    public Calendrier obtenirCalendrierDocteur() {

        return null;
    }

    //
    public Calendrier obtenirCalendrierInfirmier() {

        return null;
    }
}
