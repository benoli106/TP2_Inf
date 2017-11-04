
import java.util.ArrayList;
import java.util.Date;

/**
 * Cette classe regroupe tous les attributs et les méthodes pour la classe
 * PlageHoraire, les attributs sont son identification et son numéro d'assurance
 * social. Cette classe fait la description d'un plagehoraire
 *
 * @author Long Tran & Benjamin Fontaine
 * @since (copyright) LTran & BFon - A2017
 * @version (copyright 2017)
 */
/**
 *
 * @author AP02990 & AP09770
 */
public class PlageHoraire {

    // Attributs
    // Date et Heure
    private Date dateHeure;

    // Liste des Rendez Vous pour cette plage horaire
    private ArrayList<RendezVous> listeRendezVous;

    // *********************CONSTRUCTEURS***************************************
    // Constructeur par copie d'attributs, on instancie la liste mais elle est vide
    // et on assigne la dateHeure recue à la dateHeur de la plage créer
    public PlageHoraire(Date dateHeure) {

        this.dateHeure = dateHeure;
        this.listeRendezVous = new ArrayList<RendezVous>();

    }

    public PlageHoraire() {
    }

    // *********************ACCESSEURS******************************************
    // Permet de retourner la date 
    public int getDate() {
        return dateHeure.getDay();

    }

    // Permet de retourner la date 
    public long getHeure() {
        return dateHeure.getTime();

    }

    // Permet de retourner la date et l'heure
    public Date getDateHeure() {
        return dateHeure;

    }

    // Permet de retourner la liste des rendez-vous
    public ArrayList<RendezVous> getListeRendezVous() {
        return this.listeRendezVous;
    }

    // **********************MUTATEURS******************************************
    // Permet de modifier la date et l'heure de la PlageHoraire
    public void setDateHeure(Date dateHeure) {

        // On change la date et l'heure par celle recu en paramètre
        this.dateHeure = dateHeure;
    }

    // Permet de modifier la liste des rendez-vous
    public void addRendezVous(RendezVous rdv) {

        // On ajoute un rendez vous à la liste de rendez-vous sur cette
        //plage horaire
        this.listeRendezVous.add(rdv);

    }

    // Retourne la date de la plage horaire et une description des rendez-vous
    // inscrits.
    public String toString() {

        // On initialise un String de retour avec la date et l'heure
        String retour = "Date : " + this.dateHeure
                + "\n" + "Liste des Rendez-vous : " + "\n";

        // Pour chaque rendez vous dans la liste, on appel son toString()
        // de facon à lister tous les rendez vous dans le string de retour
   
        for (RendezVous rdv : this.listeRendezVous) {
            retour += rdv.toString() + "\n";
     
        }

        return (retour);

    }
}
