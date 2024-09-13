package views;

public class Home {
	private int choice;

	public Home() {
		System.out.println("============================================");
		System.out.println("|                                          |");
		System.out.println("|            ✨ Main Menu ✨               |");
		System.out.println("|                                          |");
		System.out.println("============================================");
		System.out.println("|                                          |");
		System.out.println("|  1. 📄 Add a document                    |");
		System.out.println("|  2. 📖 Borrow a document                 |");
		System.out.println("|  3. 🔄 Return a document                 |");
		System.out.println("|  4. 📑 Display all documents             |");
		System.out.println("|  5. 🔎 Search for a document             |");
		System.out.println("|  6. ❌ Exit                              |");
		System.out.println("|                                          |");
		System.out.println("============================================");
		System.out.println("Please enter your choice (1-6): ");
		System.out.println("============================================");
		int inputHolder = ConsoleUI.getUserInputInteger("Home Menu Choice", "Enter Your Choice", false);
		int choiceHolder = ConsoleUI.checkChoice(inputHolder, 0, 1, 6);
		setChoice(choiceHolder);
	}

	public int getChoice() {
		return choice;
	}

	public void setChoice(int choice) {
		this.choice = choice;
	}

}
