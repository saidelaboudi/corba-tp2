package Banque;

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Properties;


import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.POAManager;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;

// import …
public class Serveur {
	public static void main(String args[]) {
		Properties props = System.getProperties();
		
		System.out.println("+------------------+");
		System.out.println("| Service bancaire |");
		System.out.println("+------------------+\n");

// Création de l’objet d’implantation

// Copie de la référence dans un fichier
		try {
			ORB orb = ORB.init(args, props);
			POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
			POAManager manager = rootPOA.the_POAManager();
			
			Banque_Impl unCompte = new Banque_Impl(10000);
			Banque banque = unCompte._this(orb);
			
			String ref = orb.object_to_string(banque);
			String refFile = "Compte.ref";
			
			FileOutputStream file = new FileOutputStream(refFile);
			PrintWriter out = new PrintWriter(file);
			
			out.println(ref);
			
			out.flush();
			file.close();
			
			manager.activate();
			
			orb.run();
		} catch (java.io.IOException ex) {
			System.out.println(ex.getMessage());
		} catch (InvalidName e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AdapterInactive e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
