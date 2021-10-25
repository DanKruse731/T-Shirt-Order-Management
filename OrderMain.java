import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;

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
		
		//Get the current date and time and convert it into a String
		Date date = Calendar.getInstance().getTime();  
		DateFormat dFormat = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss");  
		String strDate = dFormat.format(date);
				
		//The log is initialized and named after the date and time.
		OrderLog log = new OrderLog("Log_" + strDate + ".txt");
						
		//Log Parameters are set.
		log.logger.setLevel(Level.ALL);
		log.logger.setUseParentHandlers(false);
								
		try {
			log.logger.info("Log file has been successfully created.");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
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
		int indexForLog = 0;
		
		
		
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
		log.logger.info("Sample Orders have been created.");
		
		try {
		
		while(running) {
			
			System.out.println("INPUT AN ACTION \n==========================");
			System.out.println("1 = View All Orders");
			System.out.println("2 = Mark Order as Finished");
			System.out.println("3 = Add Order");
			System.out.println("4 = Cancel Order");
			System.out.println("5 = Exit\n");
			
			try {
				option = scnr.nextInt();
				log.logger.info("Option is set to value of " + option);
			} catch(Exception e) { 
				log.logger.info("Invalid int for Option was caught.");
			}
			
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
					
					log.logger.info("All orders have been printed (View All Orders)");
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
					
					log.logger.info("All orders have been printed (Mark Order as Finished)");
					
					System.out.println("\nSELECT AN ORDER TO MARK FINISHED");
					try {
						indexForLog = scnr.nextInt();
						log.logger.info("Attempting to mark Order #" + indexForLog + " as finished...");
						orders.get(indexForLog-1).markFinished();
						System.out.println("Order has been marked as finished.");
						log.logger.info("Order #" + indexForLog + "has been marked as finished...");
						
						System.out.println("Press ENTER to Continue");
					} catch (Exception e) {
						log.logger.info("An invalid index for marking as finished has been caught.");
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
					log.logger.info("Attempting to add a new T-Shirt Order...");
					try {
					System.out.println("INPUT STATE\n==========================");
					state = scnr.nextLine();
					log.logger.info("State: " + state);
					System.out.println("Press ENTER to Continue");
					scnr.nextLine();
					
					System.out.println("INPUT ZIP CODE\n==========================");
					zip = scnr.nextInt();
					log.logger.info("Zip: " + zip);
					System.out.println("Press ENTER to Continue");
					scnr.nextLine();
					
					System.out.println("INPUT ADDRESS\n==========================");
					address = scnr.nextLine();
					log.logger.info("Address: " + address);
					System.out.println("Press ENTER to Continue");
					scnr.nextLine();
					
					System.out.println("INPUT COLOR OF T-SHIRT\n==========================");
					color = scnr.nextLine();
					log.logger.info("Color: " + color);
					System.out.println("Press ENTER to Continue");
					scnr.nextLine();
					
					System.out.println("INPUT MESSAGE ON T-SHIRT\n==========================");
					text = scnr.nextLine();
					log.logger.info("Text: " + text);
					System.out.println("Press ENTER to Continue");
					scnr.nextLine();
					
					System.out.println("IS THERE A CUSTOM IMAGE? (true, false)\n==========================");
					customImage = scnr.nextBoolean();
					log.logger.info("Custom Image? : " + customImage);
					System.out.println("Press ENTER to Continue");
					scnr.nextLine();
					
					orders.add(new Order(state, zip, address, color, text, customImage, false));
					
					log.logger.info("Order has successfully been added.");
					System.out.println("Order has been added.");
					System.out.println("Press ENTER to Continue");
					
					} catch(Exception e) {
						log.logger.info("An error occured while attempting to make a T-Shirt order");
					}
					
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
						indexForLog = scnr.nextInt();
						log.logger.info("Attempting to delete Order #" + indexForLog + "...");
						orders.remove(indexForLog-1);
						log.logger.info("Successfully deleted Order #" + indexForLog + ".");
						System.out.println("Order has been cancelled.");
						System.out.println("Press ENTER to Continue");
					} catch (Exception e) {
						log.logger.info("An invalid index for deleting an entry has been caught.");
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
					log.logger.info("Exitting program.");
					running = false;
					
					break;
				default:
					/*
					 * If an incorrect value is inputted, users will be notified about it.
					 */
					log.logger.info("Invalid menu option has been caught (Case Default).");
					System.out.println("Invalid Entry");
					System.out.println("Press ENTER to Continue");
					scnr.nextLine();
					break;
				
			}
			
			System.out.println("\n\n\n\n\n\n\n\n\n\n");
			
		}
		
		}
		
		catch(Exception e) {
			log.logger.warning("An fatal error has occured. The program will now be terminated.");
		}
		
		scnr.close();

	}

}
