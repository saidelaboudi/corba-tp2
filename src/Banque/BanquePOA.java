package Banque;


/**
* Banque/BanquePOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from idl
* mercredi 17 novembre 2021 11 h 21 WEST
*/

public abstract class BanquePOA extends org.omg.PortableServer.Servant
 implements BanqueOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("lire_compte", new java.lang.Integer (0));
    _methods.put ("debiter", new java.lang.Integer (1));
    _methods.put ("crediter", new java.lang.Integer (2));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // Banque/Banque/lire_compte
       {
         float $result = (float)0;
         $result = this.lire_compte ();
         out = $rh.createReply();
         out.write_float ($result);
         break;
       }

       case 1:  // Banque/Banque/debiter
       {
         float solde = in.read_float ();
         this.debiter (solde);
         out = $rh.createReply();
         break;
       }

       case 2:  // Banque/Banque/crediter
       {
         float solde = in.read_float ();
         this.crediter (solde);
         out = $rh.createReply();
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:Banque/Banque:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public Banque _this() 
  {
    return BanqueHelper.narrow(
    super._this_object());
  }

  public Banque _this(org.omg.CORBA.ORB orb) 
  {
    return BanqueHelper.narrow(
    super._this_object(orb));
  }


} // class BanquePOA
