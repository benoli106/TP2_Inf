
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Cette classe est la classe principale qui permet d'exécuter le programme,
 * contient un menu des actions que l'utilisateur peut faire dans une clinique
 *
 * @author Long Tran & Benjamin Fontaine
 * @since (copyright) LTran BFont - A2017
 * @version (copyright 2017)
 */
public class Main {

    public static void main(String[] args) {
        // Variables

        // La clinique
        Clinique clinique = null;

        // Le clavier
        Scanner clavier = new Scanner(System.in);

        // Le choix d'utilisateur
        int choix = 0;

        // Message qui affiche tous les chois possible
        String menu = "Que voulez vous faire ?" + "\n"
                + " 1 - Ajouter un docteur " + "\n"
                + " 2 - Ajouter un infirmier " + "\n"
                + " 3 - Ajouter un patient " + "\n"
                + " 4 - Ajouter un rdv " + "\n"
                + " 5 - Trouver un rdv pour un patient " + "\n"
                + " 6 - Afficher le prochain rdv d'un docteur " + "\n"
                + " 7 - Afficher le prochain rdv d'un infirmier " + "\n"
                + " 8 - Afficher le prochain rdv d'un patient " + "\n"
                + " 9 - Passer à la prochaine plage horaire " + "\n"
                + " 10 - Afficher le calendrier complet " + "\n"
                + " 11 - Afficher le calendrier complet d'un docteur " + "\n"
                + " 12 - Afficher le calendrier complet d'un infirmier " + "\n"
                + " 13 - Annuler un rdv " + "\n"
                + " 14 - Quitter ";

        // Va rechercher le fichier contenant les données de la clinique
        //clinique = UtilitaireFichier.obtenirClinique(NOM_FICHIER_BD);
        // Si on ne trouve pas le fichier de la clinique
        if (clinique == null) {

            clinique = new Clinique();

        }
        // Afficher le message de début
        System.out.println("Bienvenue à la clinique");

        // Boucler jusqu'a temps que l'utilisateur veut quitter
        do {

            System.out.println(menu);

            // Saisir le choix de l'utilisateur
            choix = clavier.nextInt();

            switch (choix) {
                // Ajout d'un docteur
                case 1: {

                    System.out.println("Entrer le nom, le prénom et le no de"
                            + " département du docteur dans l'ordre indiqué svp");
                    // Saisi du nom, prénom et du no de département
                    String nom = clavier.next();
                    String prenom = clavier.next();
                    int numDepart = clavier.nextInt();

                    // Créer le docteur
                    Docteur doc = new Docteur(new Identification(nom, prenom),
                            numDepart);

                    // Ajouter le docteur à la clinique
                    clinique.ajouterDocteur(doc);

                    break;
                }
                // Ajout d'un infirmier
                case 2: {

                    System.out.println("Entrer le nom, le prénom de l'infirmier"
                            + " dans l'ordre indiqué svp");

                    // Saisi du nom, prénom 
                    String nom = clavier.next();
                    String prenom = clavier.next();

                    // Créer l'infirmier
                    Infirmier infirmier
                            = new Infirmier(new Identification(nom, prenom), true);

                    // Ajouter l'infirmier à la clinique
                    clinique.ajouterInfirmier(infirmier);

                    break;
                }
                // Ajout d'un patient
                case 3: {

                    System.out.println("Entrer le nom, le prénom et le NAS"
                            + " du patient dans l'ordre indiqué svp");
                    // Saisi du nom, prénom et du NAS
                    String nom = clavier.next();
                    String prenom = clavier.next();
                    int nas = clavier.nextInt();

                    // Créer le patient
                    Patient patient
                            = new Patient(new Identification(nom, prenom), nas);

                    // Ajouter le patient à la clinique
                    clinique.ajouterPatient(patient);

                    break;
                }
                // Ajout d'un rdv
                case 4: {
                    int noChoix;

                    Docteur docteur;
                    Infirmier infirmier;
                    Patient patient;
                    Date date;

                    noChoix = choixDeDocteur(clinique, clavier);
                    docteur = clinique.getDocteur(noChoix);

                    // Vérifier si l'utilisateur a sélectionner un docteur
                    if (noChoix >= 0 && noChoix < clinique.getDocteurs().size()) {

                        // Les Infirmiers
                        noChoix = 0;
                        noChoix = choixDInfirmier(clinique, clavier);
                        infirmier = clinique.getInfirmier(noChoix);

                        // Vérifier si l'utilisateur a sélectionner un infirmier
                        if (noChoix >= 0
                                && noChoix < clinique.getInfirmiers().size()) {

                            noChoix = 0;
                            noChoix = choixDePatient(clinique, clavier);
                            patient = clinique.getPatient(noChoix);

                            if (noChoix >= 0
                                    && noChoix < clinique.getPatients().size()) {

                                // Parsing du date inspirée de 
                                // https://stackoverflow.com/questions/28385099/java-input-date-from-scanner-in-one-line
                                SimpleDateFormat myFormat
                                        = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");

                                System.out.println("Entrez une date pour le rdv"
                                        + " dans le format AAAA-MM-jj-THH:mm");
                                System.out.println("Par exemple, "
                                        + myFormat.format(new Date()));

                                String strDate = clavier.next();
                                try {

                                    date = myFormat.parse(strDate);

                                    // Créer le rendez vous
                                    PlageHoraire ph = new PlageHoraire(date);

                                    // Ajouter le rdv à la plage horaire
                                    ph.addRendezVous(new RendezVous(patient,
                                            docteur, infirmier));

                                } catch (Exception e) {

                                    System.out.println("La date et l'heure "
                                            + "n'est pas valide veuillez"
                                            + " réesayer.");
                                }

                            }
                        }

                    }

                    break;
                }
                // Trouver un rdv pour patient
                case 5: {

                    int noChoix = choixDePatient(clinique, clavier);
                    Patient patient = clinique.getPatient(noChoix);

                    if (noChoix >= 0) {
                        clinique.rendezVousPatient(patient);

                    }

                    break;
                }
                // Obtenir le prochain rdv d'un docteur
                case 6: {

                    int noChoix = choixDeDocteur(clinique, clavier);

                    Docteur docteur = clinique.getDocteur(noChoix);

                    if (noChoix >= 0) {
                        RendezVous rdv = clinique.getCalendrier().
                                obtenirProchainRendezVousDocteur(docteur);
                        System.out.println(rdv.toString());
                    }

                    break;
                }

                // Obtenir le prochain rdv d'un infirmier
                case 7: {

                    int noChoix = choixDInfirmier(clinique, clavier);

                    Infirmier infirmier = clinique.getInfirmier(noChoix);

                    if (noChoix >= 0) {
                        RendezVous rdv = clinique.getCalendrier().
                                obtenirProchainRendezVousInfirmier(infirmier);
                        System.out.println(rdv.toString());
                    }

                    break;
                }

                // Obtenir le prochain rdv d'un patient
                case 8: {

                    int noChoix = choixDePatient(clinique, clavier);

                    Patient patient = clinique.getPatient(noChoix);

                    if (noChoix >= 0) {
                        RendezVous rdv = clinique.getCalendrier().
                                obtenirProchainRendezVousPatient(patient);
                        System.out.println(rdv.toString());
                    }

                    break;
                }

            }

        } while (choix != 14);

    }

    // Permet de lister les retourner les docteurs et de retourner le choix
    public static int choixDeDocteur(Clinique clinique, Scanner clavier) {

        // Les docteurs
        System.out.println("Entrez votre choix de docteur");
        for (int i = 0; i < clinique.getDocteurs().size(); i++) {

            System.out.println(i + " - "
                    + clinique.getDocteurs().get(i).toString() + "\n");
        }

        return clavier.nextInt();
    }

    // Permet de lister les retourner les infirmiers et de retourner le choix
    public static int choixDInfirmier(Clinique clinique, Scanner clavier) {

        System.out.println("Entrez votre choix d'infirmier");
        for (int i = 0; i < clinique.getInfirmiers().size(); i++) {

            System.out.println(i + " - "
                    + clinique.getDocteurs().get(i) + "\n");
        }

        return clavier.nextInt();
    }

    // Permet de lister les retourner les patients et de retourner le choix
    public static int choixDePatient(Clinique clinique, Scanner clavier) {

        // Les patients
        System.out.println("Entrez votre choix de patient");
        for (int i = 0; i < clinique.getPatients().size(); i++) {

            System.out.println(i + " - "
                    + clinique.getPatients().get(i) + "\n");
        }
        return clavier.nextInt();
    }

}
