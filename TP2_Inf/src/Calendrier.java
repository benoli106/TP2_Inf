
import java.util.Date;

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
    public ListeDouble getListePlageHoraire() {
        return listePlageHoraire;
    }

    //
    public void ajouterRendezVous(RendezVous rdvAjouter, Date dateHeure) {

        if (isValid(dateHeure)) {
            this.listePlageHoraire.setPosDebut();

            for (int i = 0; i < this.listePlageHoraire.getNbElements() - 1; i++) {

                PlageHoraire current = (PlageHoraire) listePlageHoraire.getElement();

                if(current.getDateHeure() == dateHeure){
                    current.addRendezVous(rdvAjouter);
                }

                this.listePlageHoraire.setPosSuivant();

            }
        }
    }

    // Retourne une chaine de caractère qui décrit la date et la liste de rendez-vous
    // de chaque plage horaire dans la liste.
    public String toString() {

        // On initialise un string de retour avec un titre 
        String retour = "Calendrier : " + "\n";
        // On va chercher le toString de chacun des objet rendez-vous dans
        // chacune des plages de la liste, et on ajoute la date de la plage
        // horaire concernée 

        /*    Recherche dans une liste à Noeud 
        
         Stratégie : 
       
         On met le pointeur au début, puis, pour chaque itération on va aller
         chercher le toString des rendezVous concernés. Quand c'est fait, nous 
         changeons le pointeur de plage de facon à continuer la recherche sur chaque
         plage horaire de la liste.
         */
        this.listePlageHoraire.setPosDebut();

        for (int i = 0; i < this.listePlageHoraire.getNbElements() - 1; i++) {

            PlageHoraire current = (PlageHoraire) listePlageHoraire.getElement();
            retour += ("\n" + current.getDateHeure());

            for (RendezVous rdv : current.getListeRendezVous()) {
                retour += rdv.toString() + "\n";
            }

            this.listePlageHoraire.setPosSuivant();

        }

        // Retourne le string;
        return retour;
    }

    // Cette méthode recoit un patient puis va tenter de trouver un rendez-vous
    // dans la liste de plages et leur rendezvous qui lui est assigner.
    // Si un rendezvous est trouver, on considère que c'est le prochaine et donc
    // on retourne ce rendezvous.
    public RendezVous obtenirProchainRendezVousPatient(Patient patient) {

        // On remet le pointeur au debut de la liste
        this.listePlageHoraire.setPosDebut();

        // On itère dans la liste de plages
        for (int i = 0; i < this.listePlageHoraire.getNbElements() - 1; i++) {

            // On instancie un objet pour meilleur visibiliter
            PlageHoraire current = (PlageHoraire) listePlageHoraire.getElement();

            // On recherche le rendez-vous avec un patient qui correspond
            // au patient donner en argument
            for (RendezVous rdv : current.getListeRendezVous()) {
                if (rdv.getPatient().equals(patient)) {
                    return rdv;
                }
            }

            // Si on ne trouve pas le patient on continue la recherche
            this.listePlageHoraire.setPosSuivant();

        }

        // Retourne le null si rien n'est trouver
        return null;
    }

    // Cette méthode recoit un infirmier puis va tenter de trouver un rendez-vous
    // dans la liste de plages et leur rendezvous qui lui est assigner.
    // Si un rendezvous est trouver, on considère que c'est le prochaine et donc
    // on retourne ce rendezvous.
    public RendezVous obtenirProchainRendezVousInfirmier(Infirmier infirmier) {

        // On remet le pointeur au debut de la liste
        this.listePlageHoraire.setPosDebut();

        // On itère dans la liste de plages
        for (int i = 0; i < this.listePlageHoraire.getNbElements() - 1; i++) {

            // On instancie un objet pour meilleur visibiliter
            PlageHoraire current = (PlageHoraire) listePlageHoraire.getElement();

            // On recherche le rendez-vous avec un infirmier qui correspond
            // a l'infirmier donner en argument
            for (RendezVous rdv : current.getListeRendezVous()) {
                if (rdv.getInfirmier().equals(infirmier)) {
                    return rdv;
                }
            }

            // Si on ne trouve pas le patient on continue la recherche
            this.listePlageHoraire.setPosSuivant();

        }

        // Retourne le null si rien n'est trouver
        return null;
    }

    // Cette méthode recoit un docteur puis va tenter de trouver un rendez-vous
    // dans la liste de plages et leur rendezvous qui lui est assigner.
    // Si un rendezvous est trouver, on considère que c'est le prochaine et donc
    // on retourne ce rendezvous.
    public RendezVous obtenirProchainRendezVousDocteur(Docteur docteur) {

        // On remet le pointeur au debut de la liste
        this.listePlageHoraire.setPosDebut();

        // On itère dans la liste de plages
        for (int i = 0; i < this.listePlageHoraire.getNbElements() - 1; i++) {

            // On instancie un objet pour meilleur visibiliter
            PlageHoraire current = (PlageHoraire) listePlageHoraire.getElement();

            // On recherche le rendez-vous avec un docteur qui correspond
            // au docteur donner en argument
            for (RendezVous rdv : current.getListeRendezVous()) {
                if (rdv.getDocteur().equals(docteur)) {
                    return rdv;
                }
            }

            // Si on ne trouve pas le patient on continue la recherche
            this.listePlageHoraire.setPosSuivant();

        }

        // Retourne le null si rien n'est trouver
        return null;
    }

    // Retourne la plage horaire la plus proche, donc la plus récente
    public PlageHoraire obtenirProchainePlageHoraire() {

        // On remet le pointeur au debut de la liste
        this.listePlageHoraire.setPosDebut();

        return (PlageHoraire) this.listePlageHoraire.getElement();
    }

    // On recherche chaque rendezvous de chaque plage horaire et on 
    // regarde s'il existe deja dans une plage horaire. Si oui, on l'annule
    // et on return true, si non, on return false.
    public boolean annulerRendezVous(RendezVous rdvAnuller) {

        // On remet le pointeur au debut de la liste
        this.listePlageHoraire.setPosDebut();

        // On itère dans la liste de plages
        for (int i = 0; i < this.listePlageHoraire.getNbElements() - 1; i++) {

            // On instancie un objet pour meilleur visibiliter
            PlageHoraire current = (PlageHoraire) listePlageHoraire.getElement();

            // On recherche le rendez-vous avec un docteur qui correspond
            // au docteur donner en argument
            for (RendezVous rdv : current.getListeRendezVous()) {

                // Si le rendezvous current est égal au rendez-vous recu en
                // paramètre, on l'annule, donc supprime le rdv.
                if (rdv.equals(rdvAnuller)) {

                    current.getListeRendezVous().remove((rdv));
                    // Si la plage ne contient plus aucun rendez vous,
                    // on la supprimer de la liste
                    if (current.getListeRendezVous().isEmpty()) {
                        listePlageHoraire.supprimer();
                    }
                    return true;
                }

            }

            // Si on ne trouve pas le rendezVous on continue la recherche
            this.listePlageHoraire.setPosSuivant();

        }
        return false;
    }

    // Recoit un docteur, et créer une calendrier des rendez-vous de ce docteur
    // en question
    public Calendrier obtenirCalendrierDocteur(Docteur docteur) {

        Calendrier retour = new Calendrier();

        // On remet le pointeur au debut de la liste
        this.listePlageHoraire.setPosDebut();

        // On itère dans la liste de plages
        for (int i = 0; i < this.listePlageHoraire.getNbElements() - 1; i++) {

            // On instancie un objet pour meilleur visibiliter
            PlageHoraire current = (PlageHoraire) listePlageHoraire.getElement();

            // On recherche le rendez-vous avec un docteur qui correspond
            // au docteur donner en argument
            for (RendezVous rdv : current.getListeRendezVous()) {

                // On ajoute le rendez vous au calendrier si le docteur correspond
                if (rdv.getDocteur().equals(docteur)) {
                    retour.ajouterRendezVous(rdv, current.getDateHeure());
                }
            }

            // Si on ne trouve pas le patient on continue la recherche
            this.listePlageHoraire.setPosSuivant();
        }
        return retour;
    }

    // Recoit un infirmier, et créer une calendrier des rendez-vous de ce infirmier
    // en question
    public Calendrier obtenirCalendrierInfirmier(Infirmier infirmier) {

        Calendrier retour = new Calendrier();

        // On remet le pointeur au debut de la liste
        this.listePlageHoraire.setPosDebut();

        // On itère dans la liste de plages
        for (int i = 0; i < this.listePlageHoraire.getNbElements() - 1; i++) {

            // On instancie un objet pour meilleur visibiliter
            PlageHoraire current = (PlageHoraire) listePlageHoraire.getElement();

            // On recherche le rendez-vous avec un docteur qui correspond
            // au docteur donner en argument
            for (RendezVous rdv : current.getListeRendezVous()) {

                // On ajoute le rendez vous au calendrier si le docteur correspond
                if (rdv.getInfirmier().equals(infirmier)) {
                   retour.ajouterRendezVous(rdv, current.getDateHeure());
               }
            }

            // Si on ne trouve pas le patient on continue la recherche
            this.listePlageHoraire.setPosSuivant();

        }
        return retour;

    }

    public boolean isValid(Date dateHeure) {

        // Variables temporaire pour visibilitée
        int Hours = dateHeure.getHours();
        int Minutes = dateHeure.getMinutes();

        // On regarde si l'heure du rdv respect la condition de après 8h et avant
        // 20h
        if (Hours < 8 && Hours > 20) {

            // On regarde si les minutes du rdv respecte l'intervalle de 15
            // minutes pour les rdv.
            switch (Minutes / 4) {
                case 0:
                    return true;
                case 1:
                    return true;
                case 2:
                    return true;
                case 3:
                    return true;
                default:
                    return false;

            }
        }
        return false;
    }

}
