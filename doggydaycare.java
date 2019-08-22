import java.util.*;
import java.util.regex.*;
public class doggydaycare {

	
	public static void main (String args[]) throws InterruptedException {
		
		ArrayList<Dog> allDoggies= new ArrayList<>();
		ArrayList<String> comments= new ArrayList();
		ArrayList<Appointment> allApps= new ArrayList<>();
		boolean leave=false;
		
		System.out.println("Welcome to the Doggy Daycare Scheduling Center!");
		//Thread.sleep(2000);
		while(leave==false){
		String choice;
		System.out.println("\n**********************************");
		System.out.println("   	   Main Menu");
		System.out.println("**********************************");
		System.out.println("	Register your Dog");
		System.out.println("**********************************");
		System.out.println("      Set up an appointment");
		System.out.println("**********************************");
		System.out.println("        See all Doggos");
		System.out.println("**********************************");
		System.out.println("	Leave a comment");
		System.out.println("**********************************");
		System.out.println("     Check out our Reviews");
		System.out.println("**********************************");
		System.out.println("       Leave the Program");
		
		
		Scanner s = new Scanner(System.in);
		choice= s.nextLine();

		if(choice.contentEquals("Register")||choice.contentEquals("Register my dog")|| choice.contentEquals("Register your Dog")||choice.contentEquals("Register My Dog")||choice.contentEquals("register")||choice.contentEquals("register your dog")) {
			allDoggies=Register(allDoggies);
			
			}
		else if (choice.contentEquals("Set up an appointment")||choice.contentEquals("appointment")||choice.contentEquals("Set Up an Appointment")||choice.contentEquals("Set Appointment")||choice.contentEquals("set appointment")||choice.contentEquals("Appointment")||choice.contentEquals("set an appointment")||choice.contentEquals("set up appointment")) {
			allApps=SetAppointment(allDoggies, allApps);
		}
		else if (choice.contentEquals("Leave a comment")||choice.contentEquals("leave a comment")||choice.contentEquals("Leave A Comment")||choice.contentEquals("leave comment")||choice.contentEquals("Leave comment")||choice.contentEquals("Leave Comment")) {
			comments= leaveComment(comments);
		}
		else if (choice.contentEquals("Check out Reviews")||choice.contentEquals("Reviews")||choice.contentEquals("Check Reviews")||choice.contentEquals("check reviews")||choice.contentEquals("reviews")||choice.contentEquals("check out reviews")) {
			checkReviews(comments);
		}
		else if (choice.contentEquals("See all Doggos")||choice.contentEquals("see doggos")||choice.contentEquals("See all dogs")||choice.contentEquals("See All Dogs")||choice.contentEquals("see all dogs")||choice.contentEquals("see all doggos")||choice.contentEquals("see dogs")) {
			for(int i=0;i<allDoggies.size();i++) {
				System.out.println("Name: "+allDoggies.get(i).getName()+"\n"
						+ "Age: "+allDoggies.get(i).getAge()
						+"\nGender: "+allDoggies.get(i).getGender()
						+"\nFavorite Food: "+allDoggies.get(i).getFavfood()
						+"\nSpecial Needs: "+allDoggies.get(i).getSpecialNeeds());
				System.out.println("******************");
			}
		}
		else if (choice.contentEquals("Leave the Program")||choice.contentEquals("Leave")||choice.contentEquals("Leave Program")||choice.contentEquals("leave the program")||choice.contentEquals("leave")||choice.contentEquals("leave program")) {
			System.out.println("******************");
			System.out.println("Goodbye!");
			System.out.println("******************");
			leave=true;
			
		}
		
		
		
		}
	}
		

public static ArrayList<Dog> Register(ArrayList<Dog> AllDoggies) throws InterruptedException {	
	
	boolean keepgoing=true;//do you want to register another dog?
	Scanner s = new Scanner(System.in);
	
	while(keepgoing==true) {
	Dog client = new Dog();	
	System.out.println("Let's get your dog registered to use all our premium services.");
	Thread.sleep(2000);
	System.out.println("We're going to ask a few questions about your dog(s) to get to know them better.");
	Thread.sleep(2000);
	//***************************
	System.out.println("What's your dogs name?");
	String name= s.next();
	if(name.contains("fuck")||name.contains("shit")||name.contains("bitch")||name.contains("slut")||name.contains("whore")||name.isEmpty()) {
		System.out.println("You cannot register a dog with that name. Taking you to the Main Menu...");
		Thread.sleep(3000);
		break;
	}else {
	client.setName(name);
	System.out.println("What a lovely name!");
	}
	//***************************
	System.out.println("What's your dog's age?");
	int age=s.nextInt();
	if(age>30) {
		System.out.println("You cannot register a dog with a fake age! Taking you to the Main Menu...");
		Thread.sleep(3000);
		break;
	}else {
		client.setAge(age);
		System.out.println("Awesome! Our kennel workers are great with dogs of all ages!");
	}
	//***************************
	System.out.println("What is the gender of your dog?");
	s.nextLine();
	String gender=s.nextLine();
	
	if (gender.contentEquals("female")||gender.contentEquals("Female")||gender.contentEquals("Male")||gender.contentEquals("male")||gender.contentEquals("non-binary")||gender.contentEquals("non binary")||gender.contentEquals("no gender")||gender.contentEquals("Non Binary")){
		client.setGender(gender);
	}
	else {
		System.out.println("The accepted 'gender' values are female, male, and non-binary. Taking you to the Main Menu...");
		Thread.sleep(3000);
		break;
		
	}
	//***************************
	System.out.println("Does your dog have a favorite food we should know about? Type 'yes' or 'no'.");
	String findingout= s.next();
	if (findingout.contentEquals("yes")) {
		System.out.println("Lovely! What's your dog's favorite food?");
		s.nextLine();
		String fav=s.nextLine();
		client.setFavoriteFood(fav);
		
	}
	else if (findingout.contentEquals("no")) {
		s.nextLine();
		System.out.print("Cool. Let's continue...");
		client.setFavoriteFood("No favorite food");
	}else {
		System.out.println("That is not a valid answer. Please restart the program.");
	}
	//***************************
	System.out.println("Does your dog have any special needs? Type 'yes' or 'no'.");
	findingout=s.nextLine();
	
	
	if (findingout.contentEquals("yes")) {
		System.out.println("Let us know what your dog needs. We're dedicated to providing the best care for your pets.");
		String replace=s.nextLine();
		client.setSpecialNeeds(replace);
		//s.hasNextLine(); //consumes new line character
	}
	else if (findingout.contentEquals("no")) {
		System.out.print("Happy to hear. Let's continue...");
		client.setSpecialNeeds("No special needs");
	}else {
		System.out.println("That is not a valid answer. Please restart the program.");
	}
	
	System.out.println("Last Step! Is this your dog's correct information?");
	System.out.println("Name: "+client.getName()+"\n"
						+ "Age: "+client.getAge()
						+"\nGender: "+client.getGender()
						+"\nFavorite Food: "+client.getFavfood()
						+"\nSpecial Needs: "+client.getSpecialNeeds());
	String correctorNo=s.next();
	if(correctorNo.contentEquals("Yes")||correctorNo.contentEquals("yes")) {
		System.out.println("Great! Your dog has been successfully registered!");
	}
	else {
		System.out.println("What information is incorrect? Please refer to the categories in the same language used above.");
		String fixit=s.next();
		
		if(fixit.contentEquals("Name")||fixit.contentEquals("name")){
			System.out.println("What's your dog's correct name?");
			client.setName(s.next());
			System.out.println("Your dog's name has been updated!");
			System.out.println("Name: "+client.getName()+"\n"
					+ "Age: "+client.getAge()
					+"\nGender: "+client.getGender()
					+"\nFavorite Food: "+client.getFavfood()
					+"\nSpecial Needs: "+client.getSpecialNeeds());
		}
		else if (fixit.contentEquals("Age")||fixit.contentEquals("age")) {
			System.out.println("What is your dog's correct age?");
			int replace=s.nextInt();
			if(replace>30) {
				System.out.println("You cannot register a dog with a fake age! Please begin again.");
				client=null;
				keepgoing=false;
				break;
			}else {
			client.setAge(replace);
			System.out.println("Your dog's age has been updated!");
			System.out.println("Name: "+client.getName()+"\n"
					+ "Age: "+client.getAge()
					+"\nGender: "+client.getGender()
					+"\nFavorite Food: "+client.getFavfood()
					+"\nSpecial Needs: "+client.getSpecialNeeds());
			}
		}
		else if (fixit.contentEquals("Gender")||fixit.contentEquals("gender")) {
			System.out.println("What is your dogs correct gender?");
			String replace=s.next();
			client.setGender(replace);
			System.out.println("Your dog's gender has been updated!");
			System.out.println("Name: "+client.getName()+"\n"
					+ "Age: "+client.getAge()
					+"\nGender: "+client.getGender()
					+"\nFavorite Food: "+client.getFavfood()
					+"\nSpecial Needs: "+client.getSpecialNeeds());
		}
		else if (fixit.contentEquals("Favorite food")||fixit.contentEquals("favorite food")||fixit.contentEquals("Food")||fixit.contentEquals("food")||fixit.contentEquals("Favorite Food")) {
			System.out.println("What is your dogs correct favorite food?");
			String replace=s.next();
			client.setFavoriteFood(replace);
			System.out.println("Your dog's favorite food has been updated!");
			System.out.println("Name: "+client.getName()+"\n"
					+ "Age: "+client.getAge()
					+"\nGender: "+client.getGender()
					+"\nFavorite Food: "+client.getFavfood()
					+"\nSpecial Needs: "+client.getSpecialNeeds());
		}
		else if(fixit.contentEquals("Special Needs")||fixit.contentEquals("special needs")||fixit.contentEquals("Needs")||fixit.contentEquals("needs")) {
			System.out.println("What are your dogs correct special needs?");
			String replace=s.next();
			client.setSpecialNeeds(replace);
		}
		else {
			System.out.println("Sorry, that input was invalid. Please restart the program.");
		}
	}
	System.out.println("Would you like to register another dog?");
	AllDoggies.add(client);
	String wouldyou= s.next();
	if(wouldyou.contentEquals("Yes")||wouldyou.contentEquals("yes")||wouldyou.contentEquals("y")) {
		keepgoing=true;
	}
	else {
		keepgoing=false;
		for (int i=0; i<AllDoggies.size();i++){
			System.out.println("Size: "+AllDoggies.size());
			System.out.println("Dog: "+ AllDoggies.get(i).getName());
		}
		return AllDoggies;
	}
	
}
	return AllDoggies;
}//end of register 

public static ArrayList<Appointment> SetAppointment(ArrayList<Dog> AllDoggies, ArrayList<Appointment> allApps) throws InterruptedException{
	Scanner s = new Scanner(System.in);
	System.out.println("We're so excited to meet or see your dog again!\nFirst, is your dog already registered? Please type 'yes' or 'no'.");
	String isregistered= s.nextLine();
	if (isregistered.contentEquals("no")||isregistered.contentEquals("No")) {
		System.out.println("Your dog must first be registered to set up an appointment.");
		System.out.println("Taking you to register your dog...");
		Thread.sleep(2000);
		Register(AllDoggies);
	}else if (isregistered.contentEquals("yes")||isregistered.contentEquals("Yes")) {
		System.out.println("Wonderful! What's your dog's name?");
		
		String dogname= s.nextLine();
		for (int i=0; i<AllDoggies.size();i++){
			if(AllDoggies.get(i).getName().contentEquals(dogname)) {
				Appointment app= new Appointment();
				
				
				System.out.println("Great! We see your dog in our system.\nIs this your dog's correct information?");
				
				System.out.println("Name: "+AllDoggies.get(i).getName()+"\n"
						+ "Age: "+AllDoggies.get(i).getAge()
						+"\nGender: "+AllDoggies.get(i).getGender()
						+"\nFavorite Food: "+AllDoggies.get(i).getFavfood()
						+"\nSpecial Needs: "+AllDoggies.get(i).getSpecialNeeds());
				String correctInfo= s.nextLine();
				if (correctInfo.contentEquals("no")||correctInfo.contentEquals("No")) {
					System.out.println("We're sorry about that. Please try again at the main menu.");
					break;
				}
				else if (correctInfo.contentEquals("yes")||correctInfo.contentEquals("Yes")) {
					app.setDog(AllDoggies.get(i));
					System.out.println("Lovely! Let's continue...\n What day would you like to set your appointment for? Please use a 00/00 format (no year)");
					String date= s.nextLine();
					if (Pattern.matches("\\d{2}\\/\\d{2}", date)){
						app.setDate(date);
						System.out.println("Great! What is your preferred drop off time. Please use 00:00AM/PM format.");
						String dropoff=s.nextLine();
						if(Pattern.matches("((0|1)(9|0|1)\\:[0-5][0-9]AM)|((0)[0-9]\\:[0-5][0-9]PM)", dropoff)) {
							
							app.setDropTime(dropoff);
							System.out.println("Great, we're available then! Lastly, what time will you pick up your dog? Please use the same format.");
							String pickup=s.nextLine();
							if(Pattern.matches("((0|1)(9|0|1)\\:[0-5][0-9]AM)|((0)[0-9]\\:[0-5][0-9]PM)", pickup)) {
								app.setPickUpTime(pickup);
								System.out.println("You're all set! Here's your appointment information:");
								allApps.add(app);
								System.out.println("For Dog: "+app.getDog().getName()+
													"\nDate: "+app.getDate()+
													"\nDrop Off Time: "+app.getDropTime()+
													"\nPick Up Time: "+app.getPickUpTime());
								System.out.println("Taking you back to the Main Menu...");
								Thread.sleep(4000);
								return allApps;
							}else {
								System.out.println("Sorry, we're not open at that time. Our hours are from 9:00AM - 9:00PM. Please try again from the Main Menu.");
								app=null;
								break;
							}
							
						}else {
							System.out.println("Sorry, we're not open at that time. Our hours are from 9:00AM - 9:00PM. Please try again from the Main Menu.");
							app=null;
							break;
						}
					}else {
						System.out.println("Sorry, you entered the date in the wrong format. Please try again from the Main Menu.");
						app=null;
						break;
					}
				}
			}
		}
	}
	return allApps;
}


public static ArrayList<String> leaveComment(ArrayList<String> comments) {
	System.out.println("Your opinions are extremely important to us. Let us know what you think...");
	Scanner s = new Scanner(System.in);
	String comment=s.nextLine();
	comments.add(comment);
	if(comment.contains("bad")||comment.contains("nasty")||comment.contains("poop")||comment.contains("hate")||comment.contains("gross")||comment.contains("unhappy")||comment.contains("mean")||comment.contains("rude")||comment.contains("dislike")||comment.contains("worst")||comment.contains("fire")) {
		System.out.println("We see you're using some negative words in your comment. Did you have a negative experience?");
		String xp= s.nextLine();
		if (xp.contentEquals("yes")||xp.contentEquals("Yes")) {
			System.out.println("We're so sorry to hear that. Please enjoy this $10 coupon off your next purchase.");
			System.out.println("*************************\n"+
					           "10 DOLLARS OFF\n"+
					            "*************************");
		}else if(xp.contentEquals("no")||xp.contentEquals("No")) {
			System.out.println("We're relieved! Your comment has been recorded! Thank you.");
		}
		
	}else if(comment.contains("happy")|comment.contains("great")||comment.contains("amazing")||comment.contains("beautiful")||comment.contains("love")||comment.contains("fun")||comment.contains("can't wait")) {
		System.out.println("It seems you had a positive experience based on your word choices. Is that true?");
		String xp= s.nextLine();
		if (xp.contains("yes")||xp.contains("Yes")) {
			System.out.println("We're so happy to hear you and your dog had a great time. We're looking forward to seeing you again!\nYour comment has been recorded. Thank you.");
			
		}else if(xp.contains("no")||xp.contains("No")) {
			System.out.println("We're sorry to hear that. Did you have a negative experience?");
			
			  xp= s.nextLine();
			if (xp.contains("yes")||xp.contains("Yes")) {
				System.out.println("We're so sorry to hear that. Please enjoy this $10 coupon off your next purchase.");
				System.out.println("*************************\n"+
						           "10 DOLLARS OFF\n"+
						            "*************************");
			}else if(xp.contains("no")||xp.contains("No")) {
				System.out.println("We're relieved! Your comment has been recorded! Thank you.");
		}
		}
	}
	return comments;
}

public static void checkReviews(ArrayList<String> comments) throws InterruptedException{
	if(comments.isEmpty()) {
		System.out.println("Sorry! No comments yet. Taking you back the main menu...");
		Thread.sleep(3000);
		return;
	}
	else {
		
	for(int i=0;i<comments.size();i++) {
		System.out.println("This is what some our customers had to say about us! Check it out!");
		System.out.println(comments.get(i));
		Thread.sleep(6000);
		System.out.println("Taking you back to the Main Menu...");
		Thread.sleep(2000);
		return;
	}
	}//end of else
}

}


