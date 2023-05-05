import java.util.LinkedList;
import java.util.Scanner;


public class Main6 {

	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		} catch (InstantiationException| IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		Ui.menu();
		Scanner scan = new Scanner(System.in);
		int op = scan.nextInt();
		while (op != 0) {
			ProductDAO pdao = new ProductDAO();
			int id;
			switch(op) {
			case 1:
				LinkedList<Product> productos = new LinkedList();
				productos = pdao.getAll();
				for (Product p: productos) {
					System.out.println("\n" +p.getId()+ " " + p.getName() + " $" + p.getPrice());
				}
				break;
			
			case 2 :

				System.out.println("\n\nINGRESE EL ID DEL PRODUCTO: \n");
				id = scan.nextInt();
				Product product = pdao.getOne(id);
				System.out.println("\n" + product.getId() + " " + product.getName() + " " + product.getDescription() + " " + product.getPrice() + " " + product.getStock() + " " + product.isShippingIncluded());
				break;
			
			case 3:
				System.out.println("\n\nINGRESE EL NOMBRE DEL PRODUCTO: \n");
				scan.nextLine();
				String name = scan.nextLine();
				System.out.println("\nINGRESE LA DESCRIPCION DEL PRODUCTO: \n");
				String description = scan.nextLine();
				System.out.println("\nINGRESE EL PRECIO DEL PRODUCTO: \n");
				String price = scan.next(); 
				System.out.println("\nINGRESE EL STOCK DEL PRODUCTO: \n");
				int stock = scan.nextInt();
				System.out.println("\nINGRESE SI EL PRODUCTO INCLUYE ENVIO (1 SI 0 NO): \n");
				int shippingIncluded = scan.nextInt();				

				pdao.cargarProduct(name, description, Double.parseDouble(price), stock, shippingIncluded);
				System.out.println("\nDATOS CARGADOS CON EXITO\n");
				break;
			case 4:
				System.out.println("\n\nINGRESE EL ID DEL PRODUCTO: \n");
				id = scan.nextInt();
				pdao.deleteOne(id);
				System.out.println("\nDATOS BORRADOS CON EXITO\n");
				break;
			case 5:
				System.out.println("\n\nINGRESE EL ID DEL PRODUCTO: \n");
				id = scan.nextInt();
				Product producto = pdao.getOne(id);
				System.out.println("\n" + producto.getId() + " " + producto.getName() + " " + producto.getDescription() + " " + producto.getPrice() + " " + producto.getStock() + " " + producto.isShippingIncluded());
				System.out.println("\nINGRESE LOS NUEVOS DATOS A CAMBIAR A CONTINUACION:\n");
				System.out.println("\n\nINGRESE EL NOMBRE DEL PRODUCTO: \n");
				scan.nextLine();
				String namee = scan.nextLine();
				System.out.println("\nINGRESE LA DESCRIPCION DEL PRODUCTO: \n");
				String descriptionn = scan.nextLine();
				System.out.println("\nINGRESE EL PRECIO DEL PRODUCTO: \n");
				String pricee = scan.next(); 
				System.out.println("\nINGRESE EL STOCK DEL PRODUCTO: \n");
				int stockk = scan.nextInt();
				System.out.println("\nINGRESE SI EL PRODUCTO INCLUYE ENVIO (1 SI 0 NO): \n");
				int shippingIncludedd = scan.nextInt();
				pdao.changeOne(namee, descriptionn, Double.parseDouble(pricee), stockk, shippingIncludedd, id);
				System.out.println("\nOPERACION REALIZADA CON EXITO");
			}
			Ui.menu();
			op = scan.nextInt();		
		}
		scan.close();
		System.out.println("GRACIAS POR UTILIZAR EL PROGRAMA");

	}

}
