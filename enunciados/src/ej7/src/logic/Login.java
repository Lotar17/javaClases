package logic;

import java.util.LinkedList;

import data.*;
import entities.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Login {
	private DataPersona dp;
	
	public Login() {
		dp=new DataPersona();
	}
	
	public Persona validate(Persona p) {
		/* para hacer más seguro el manejo de passwords este sería un lugar 
		 * adecuado para generar un hash de la password utilizando un cifrado
		 * asimétrico como sha256 y utilizar el hash en lugar de la password en plano 
		 */
		p.setPassword(getSHA256Hash(p.getPassword()));
		return dp.getByUser(p);
	}

	public LinkedList<Persona> getAll(){
		return dp.getAll();
	}
	
	public LinkedList<Persona> getByApellido(String apellido){
		return dp.getByApellido(apellido);
	}

	public Persona getByDocumento(Persona per) {
		return dp.getByDocumento(per);
	}
	
	public static String getSHA256Hash(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedHash = digest.digest(input.getBytes(StandardCharsets.UTF_8));

            StringBuilder hexString = new StringBuilder();
            for (byte b : encodedHash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
	
	public void addPersona(Persona p) {
		p.setPassword(getSHA256Hash(p.getPassword()));
		dp.add(p);
	}
	
	
}