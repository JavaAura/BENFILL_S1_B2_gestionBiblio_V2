package views;

public class RoleChoosing {
	private int choice;

	public RoleChoosing() {
		System.out.println("============================================");
		System.out.println("|                                          |");
		System.out.println("|            ✨ Role Choosing ✨            |");
		System.out.println("|                                          |");
		System.out.println("============================================");
		System.out.println("|                                           |");
		System.out.println("|  1. 📄 Enter as Student                   |");
		System.out.println("|  2. 📖 Enter as Professor                 |");
		System.out.println("|  3. ❌ Exit                               |");
		System.out.println("|                                           |");
		System.out.println("============================================");
		System.out.println("Please enter your choice (1-3): ");
		System.out.println("============================================");

		int inputHolder = ConsoleUI.getUserInputInteger("Role Choosing", "Enter Your Choice", false);
		int choiceHolder = ConsoleUI.checkChoice(inputHolder, 0, 1, 3);
		setChoice(choiceHolder);

	}

	public int getChoice() {
		return choice;
	}

	public void setChoice(int choice) {
		this.choice = choice;
	}

}
