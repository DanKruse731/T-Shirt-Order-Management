import java.util.ArrayList;
import java.util.Scanner;

public class OrderMain {

	public static void main(String[] args) throws Exception {
		
		/*
		 * T-SHIRT ORDER DELIVERY MANAGER
		 * 
		 * This is the foundation for the order delivery manager that is yet to come.
		 * Users can navigate a text-based user interface through the console.
		 * The following can be accomplished:
		 *
		 * -View Orders
		 * -Mark Orders as Delivered
		 * -Add New Orders
		 * -Cancel Existing Orders
		 * 
		 * More features and a robust GUI are yet to come.
		 *
		 */
		
		
		
		
		
		//Variables specifically for the main code.
		Scanner scnr = new Scanner(System.in);
		boolean running = true;
		int option = -1;
		
		//Variables related to the Order objects.
		String state;
		int zip;
		String address;
		String color;
		String text;
		boolean customImage;
		
		
		
		/*
		 * The orders for now are stored through an ArrayList of Order objects.
		 * A few fake orders are built in to make testing significantly easier.
		 * These will be removed in the future.
		 */
		ArrayList<Order> orders = new ArrayList<Order>();
		orders.add(new Order("MN", 34638, "3739 Fake St.", "Red", "", false, false));
		orders.add(new Order("KS", 58347, "4823 False Ave.", "Black", "LET'S GET CRAZY", false, false));
		orders.add(new Order("FL", 29028, "2811 Rumor Ct.", "Blue", "", true, false));
		orders.add(new Order("NV", 93748, "2921 Incorrect Blvd.", "Orange", "ORANGE YOU GLAD I'M HERE?", false, false));
		
		while(running) {
			
			System.out.println("INPUT AN ACTION \n==========================");
			System.out.println("1 = View All Orders");
			System.out.println("2 = Mark Order as Finished");
			System.out.println("3 = Add Order");
			System.out.println("4 = Cancel Order");
			System.out.println("5 = Exit\n");
			option = scnr.nextInt();
			scnr.nextLine();
			System.out.println("\n\n\n\n\n\n\n\n\n\n");
			
			
			//An integer-selection Switch function is used for the text-based user interface.
			switch(option) {
				case 1:
					/*
					 * The first option displays all orders.
					 * The order objects are called to print information.
					 */
					for(int i = 0; i < orders.size(); i++) {
						orders.get(i).printOrder(i+1);
					}
					
					System.out.println("\n\n\nPress ENTER to Continue");
					scnr.nextLine();
					
					break;
				case 2:
					/*
					 * The second option allows users to cancel orders.
					 * All orders are also displayed for viewing,
					 * making it easier to mark a finished order.
					 */
					for(int i = 0; i < orders.size(); i++) {
						orders.get(i).printOrder(i+1);
					}
					
					System.out.println("\nSELECT AN ORDER TO MARK FINISHED");
					try {
					orders.get(scnr.nextInt()-1).markFinished();
					System.out.println("Order has been marked as finished.");
					System.out.println("Press ENTER to Continue");
					} catch (Exception e) {
						System.out.println("Invalid Entry");
						System.out.println("Press ENTER to Continue");
					}
					scnr.nextLine();
					break;
				case 3:
					/*
					 * The third option allows users to add orders.
					 * The scanner is used heavily here.
					 */
					System.out.println("INPUT STATE\n==========================");
					state = scnr.nextLine();
					System.out.println("Press ENTER to Continue");
					scnr.nextLine();
					
					System.out.println("INPUT ZIP CODE\n==========================");
					zip = scnr.nextInt();
					System.out.println("Press ENTER to Continue");
					scnr.nextLine();
					
					System.out.println("INPUT ADDRESS\n==========================");
					address = scnr.nextLine();
					System.out.println("Press ENTER to Continue");
					scnr.nextLine();
					
					System.out.println("INPUT COLOR OF T-SHIRT\n==========================");
					color = scnr.nextLine();
					System.out.println("Press ENTER to Continue");
					scnr.nextLine();
					
					System.out.println("INPUT MESSAGE ON T-SHIRT\n==========================");
					text = scnr.nextLine();
					System.out.println("Press ENTER to Continue");
					scnr.nextLine();
					
					System.out.println("IS THERE A CUSTOM IMAGE? (true, false)\n==========================");
					customImage = scnr.nextBoolean();
					System.out.println("Press ENTER to Continue");
					scnr.nextLine();
					
					orders.add(new Order(state, zip, address, color, text, customImage, false));
					
					System.out.println("Order has been added.");
					System.out.println("Press ENTER to Continue");
					scnr.nextLine();
					
					break;
				case 4:
					/*
					 * The fourth option allows users to cancel orders.
					 * The orders are also displayed.
					 */
					for(int i = 0; i < orders.size(); i++) {
						orders.get(i).printOrder(i+1);
					}
					try {
						System.out.println("\n\nSELECT AN ORDER TO CANCEL");
						orders.remove(scnr.nextInt()-1);
						System.out.println("Order has been cancelled.");
						System.out.println("Press ENTER to Continue");
					} catch (Exception e) {
						System.out.println("Invalid Entry");
						System.out.println("Press ENTER to Continue");
					}
					
					scnr.nextLine();
					break;
					
				case 5:
					/*
					 * It's nice to be able to end a program without terminating it.
					 */
					System.out.println("See you next time!");
					running = false;
					
					break;
				default:
					/*
					 * If an incorrect value is inputted, users will be notified about it.
					 */
					System.out.println("Invalid Entry");
					System.out.println("Press ENTER to Continue");
					scnr.nextLine();
					break;
				
			}
			
			System.out.println("\n\n\n\n\n\n\n\n\n\n");
			
		}
		
		scnr.close();

	}

}
