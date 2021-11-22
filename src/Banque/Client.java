package Banque;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;
import java.util.Scanner;

import org.omg.CORBA.ORB;
import org.omg.CORBA.Object;
import org.omg.CORBA.SystemException;

public class Client {
	public static void main(String args[]) {
// Liaison à un compte
		Properties props = System.getProperties();
		Scanner sc = new Scanner(System.in);
		
		Object obj = null;
		try {		
			ORB orb = ORB.init(args,props);
			String refFile = "Compte.ref";
			BufferedReader reader = new BufferedReader(new FileReader(refFile));
			String ref = reader.readLine();
			obj = orb.string_to_object(ref);
			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
// Déclaration de l’objet compte et des variables
		Banque compte = BanqueHelper.narrow((Object)obj);
// Boucle de saisie du choix du client
		char ch = lire_choix();
		while (ch != '0') {
			switch (ch) {
			case '1':
				// Lecture du montant du compte
				System.out.println("montant du compte : "+compte.lire_compte());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				break;
			case '2':
				// Crediter le compte
				System.out.print("montant =");
				float credit = sc.nextFloat();
				compte.crediter(credit);
				break;
			case '3':
				// Debiter le compte
				System.out.print("montant =");
				float debit = sc.nextFloat();
				compte.debiter(debit);
				break;
			default:
				// Erreur de saisie
				System.out.println("Try again ...");
			}
			ch = lire_choix();
		}
	}// catch(SystemException ex)

	static char lire_choix() {
		System.out.println("+------------------+");
		System.out.println("| Service bancaire |");
		System.out.println("+------------------+\n");
		System.out.println("1 : Lecture du montant du compte");
		System.out.println("2 : Credit du compte");
		System.out.println("3 : Debit du compte\n");
		System.out.println("0 : Quitter\n");
		System.out.println("Taper le code de l'operation a effectuer : ");
		return (lire_char());
	}

	static char lire_char() {
		String chaine;
		try {
			java.io.DataInputStream dataIn = new java.io.DataInputStream(System.in);
			BufferedReader in = new BufferedReader(new InputStreamReader(dataIn));
			chaine = in.readLine();
		} catch (java.io.IOException ex) {
			System.err.println(ex.getMessage());
			ex.printStackTrace();
			return (' ');
		}
		return (chaine.charAt(0));
	}

	static float lire_float() {
		String chaine;
		try {
			java.io.DataInputStream dataIn = new java.io.DataInputStream(System.in);
			BufferedReader in = new BufferedReader(new InputStreamReader(dataIn));
			chaine = in.readLine();
		} catch (java.io.IOException ex) {
			System.err.println(ex.getMessage());
			ex.printStackTrace();
			return (0);
		}
		return (Float.parseFloat(chaine));
	}
}
