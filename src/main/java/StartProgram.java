import java.util.List;
import java.util.Scanner;

import controller.BookListHelper;
import model.BookList;

/**
 * @author Roman-rggeleta@dmacc.edu CIS175-Spring 2022 Feb 24, 2022
 */
public class StartProgram {

	static Scanner in = new Scanner(System.in);
	static BookListHelper blh = new BookListHelper();

	private static void addAuthor() {
		// TODO Auto-generated method stub
		System.out.print("Enter a title: ");
		String title = in.nextLine();
		System.out.print("Enter a author: ");
		String author = in.nextLine();

	}

	private static void deleteAuthor() {
		// TODO Auto-generated method stub
		System.out.print("Enter the name to delete: ");
		String title = in.nextLine();
		System.out.print("Enter the author to delete: ");
		String author = in.nextLine();

	}

	private static void editAuthor() {
			// TODO Auto-generated method stub
			System.out.println("How would you like to search? ");
			System.out.println("1 : Search by title");
			System.out.println("2 : Search by author");
			int searchBy = in.nextInt();
			in.nextLine();
			List<BookList> foundAuthor = null;
			if (searchBy == 1) {
				System.out.print("Enter the author name: ");
				String authorName = in.nextLine();
				
			} else {
				System.out.print("Enter the author: ");
				String authorName = in.nextLine();
			}
				

			if (!foundAuthor.isEmpty()) {
				System.out.println("Found Results.");
				for (BookList l : foundAuthor) {
					System.out.println(l.getId() + " : " + l.toString());
				}
				System.out.print("Which ID to edit: ");
				int idToEdit = in.nextInt();

				BookList toEdit = blh.searchForAuthorById(idToEdit);
				System.out.println("Retrieved " + toEdit.getAuthor() + " from " + toEdit.getTitle());
				System.out.println("1 : Update Name");
				System.out.println("2 : Update Author");
				int update = in.nextInt();
				in.nextLine();

				if (update == 1) {
					System.out.print("New Name: ");
					String newName = in.nextLine();
					toEdit.setTitle(newName);
				} else if (update == 2) {
					System.out.print("New Author: ");
					String newAuthor = in.nextLine();
					toEdit.setAuthor(newAuthor);
				}

				blh.updateAuthor(toEdit);

			} else {
				System.out.println("---- No results found");
			}
	}


		public static void main(String[] args) {
			// TODO Auto-generated method stub
			runMenu();

		}

		public static void runMenu() {
			boolean goAgain = true;
			System.out.println("--- Welcome to our awesome shopping list! ---");
			while (goAgain) {
				System.out.println("*  Select author:");
				System.out.println("*  1 -- Add an author");
				System.out.println("*  2 -- Edit an author");
				System.out.println("*  3 -- Delete an author");
				System.out.println("*  4 -- View the list");
				System.out.println("*  5 -- Exit the awesome program");
				System.out.print("*  Your selection: ");
				int selection = in.nextInt();
				in.nextLine();

				if (selection == 1) {
					addAuthor();
				} else if (selection == 2) {
					editAuthor();
				} else if (selection == 3) {
					deleteAuthor();
				} else if (selection == 4) {
					viewTheList();
				} else {
					//blh.cleanUp();
					System.out.println("   Goodbye!   ");
					goAgain = false;
				}

			}
		
		


	}

		private static void viewTheList() {
			// TODO Auto-generated method stub
			
		}
}