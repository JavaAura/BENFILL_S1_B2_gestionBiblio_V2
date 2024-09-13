package views;

public class StudentView {

	private int choice;

	public StudentView() {
		System.out.println("============================================");
		System.out.println("|                                          |");
		System.out.println("|            ✨ Main Menu ✨               |");
		System.out.println("|                                          |");
		System.out.println("============================================");
		System.out.println("|                                          |");
		System.out.println("|  1. 📄 Reserve a document                |");
		System.out.println("|  2. ❌ Cancel reservation                |");
		System.out.println("|  3. 📖 Borrow a document                 |");
		System.out.println("|  4. 🔄 Return a document                 |");
		System.out.println("|  5. 📑 Display all documents             |");
		System.out.println("|  6. 🔎 Search for a document             |");
		System.out.println("|  7. ❌ Exit                              |");
		System.out.println("|                                          |");
		System.out.println("============================================");
		System.out.println("Please enter your choice (1-7): ");
		System.out.println("============================================");

		int inputHolder = ConsoleUI.getUserInputInteger("Home Menu Choice", "Enter Your Choice", false);
		int choiceHolder = ConsoleUI.checkChoice(inputHolder, 0, 1, 7);
		setChoice(choiceHolder);
	}

	public int getChoice() {
		return choice;
	}

	public void setChoice(int choice) {
		this.choice = choice;
	}

}
