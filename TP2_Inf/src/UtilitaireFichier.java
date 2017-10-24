import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
/**
 * Classe utilitaire pour la récupération et la sauvegarde de la bd
 * dans le travail sur le calendrier de clinique médicale. (voir énoncé tp2 A17 INF111).
 * @@@@@@@@@@@@@@@@@@@@@@@@2
 * @author Pierre Bélisle
 * @version (Copyright 2017)
 * 
 * Tout le code a été écrit par l'auteur pour l'École de technologie supérieure
 * de montréal (Éts).  Toute utilisation ou reproduction, en tout ou en partie,
 * doit mentionner l'école et l'auteur.
 *
 */
public class UtilitaireFichier {

	/**
	 * Tente d'ouvrir le fichier contenu dans le stream reçu.  S'il n'existe pas,
	 * la clinque est vide.
	 */
	public static Clinique obtenirClinique(FileInputStream fic){

		/*
		 * Stratégie : On utilise  un FileInputStream qui permet de lire
		 * la bd d'un coup, (comme elle a été sauvegardée).
		 */
		Clinique clinique = new Clinique();

		try {
			
			// Ouverture du tampon logique.
			ObjectInputStream tampon = null;			
			tampon = new ObjectInputStream(fic);

			clinique =  (Clinique)tampon.readObject();

			tampon.close();

		}

		// Si le fichier n'existe pas, on s'assure que tout est initialisé.
		catch(FileNotFoundException e){
			e.printStackTrace();
		}

		// Problème lors de la lecture.  On arrête.
		catch (ClassNotFoundException e) {			
			JOptionPane.showMessageDialog(null, "Format de fichier invalide");
			e.printStackTrace();
		}
		

		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Format de fichier invalide");
			e.printStackTrace();
		}

		return clinique;
	}

	/**
	 * Sauvegarde la bd dans le fichier nommé par NOM_FICHIER_BD.
	 *
	 */
	public static void sauvegarderClinique(Clinique clinique, String nomFic){

		/*
		 * Stratégie : On utilise  un FileOutputStream qui permet de lire
		 * la bd d'un coup.
		 */
		FileOutputStream fic;
		ObjectOutputStream tampon = null;

		try {

			//Crée le fichier 
			fic = new FileOutputStream(nomFic);

			//Ouverture du tampon d'écriture
			tampon = new ObjectOutputStream(fic);
			tampon.writeObject(clinique);
			tampon.close();		

		} catch (FileNotFoundException e1) {

			e1.printStackTrace();

			// Une erreur de lecture, on détruit le fichier.
		} catch (IOException e) {

			// On obtient le chemin du fichier pour le détruire.
			Path path = 
					FileSystems.getDefault().getPath(nomFic);

			try {

				tampon.close();
				Files.delete(path);

			} catch (IOException e1) {

				e1.printStackTrace();
			}

			e.printStackTrace();
		}

	}
}
