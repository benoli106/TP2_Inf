
import java.util.ArrayList;
import java.util.Date;

/**
 * Cette classe regroupe tous les attributs et les méthodes pour la classe
 * PlageHoraire, les attributs sont son identification et son numéro d'assurance social.
 * Cette classe fait la description d'un plagehoraire
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

    // *********************ACCESSEURS******************************************
    // Permet de retourner la date et l'heure
    public Date getDateHeure() {
        return this.dateHeure;
    }

    // Permet de retourner la liste des rendez-vous
    public ArrayList<RendezVous> getListeRendezVous() {
        return this.listeRendezVous;
    }

    // **********************MUTATEURS******************************************
    // Permet de modifier la date et l'heure de la PlageHoraire
    public void setDate(Date dateHeure) {
        
        // On change la date et l'heure par celle recu en paramètre
        this.dateHeure = dateHeure;
    }

    // Permet de modifier la liste des rendez-vous
   //addRdv public void setListeRendezVous(List  NAS) {      **************************************************************** <---------------
        
        // On change le NAS du PlageHoraire par celui passer 
        // en paramètre
        this.NAS = NAS;
    }

    // Retourne la concaténation du nom et du prénom et du numéro d'assurance
    // social.
    public String toString() {

        // On fait appel au toString de identification et on ajoute le n.
        // d'assurance social du PlageHoraire
        return (identification.toString() + NAS);

    }

    // Permet de comparer 2 objets du même type
    public boolean equals(PlageHoraire plagehoraire) {

        // Comparer les adressses de référence
        if (this == plagehoraire) {

            return true;

        }

        // Comparer les attributs des objets
        if (identification.getNom().equals(plagehoraire.identification.getNom())
                && identification.getPrenom().equals(plagehoraire.identification
                        .getPrenom()) && NAS == plagehoraire.NAS) {

            return true;

        } // Si l'adresse ou que les attributs ne sont pas pareils.
        else {

            return false;

        }
    
    }