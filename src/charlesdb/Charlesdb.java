    package charlesdb;

    import java.util.Scanner;

    public class Charlesdb {
        static config dbConfig = new config(); 

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int choice;

            do {
                System.out.println("1. ADD BOOK");
                System.out.println("2. VIEW");
                System.out.println("3. EDIT");
                System.out.println("4. DELETE");
                System.out.println("5. EXIT");

                System.out.print("Enter your choice: ");
                choice = sc.nextInt();
                sc.nextLine();  

                switch (choice) {
                    case 1:
                        addBooks(sc);
                        break;
                    case 2:
                        viewBooks();
                        break;

                    case 3:
                        System.out.println("Thank you!!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } while (choice != 5);
        }

        public static void addBooks(Scanner sc) {
            System.out.print("Enter book title: ");
            String title = sc.nextLine();
            System.out.print("Enter author name: ");
            String author = sc.nextLine();
            System.out.print("Enter publication year: ");
            int year = sc.nextInt();

            String sql = "INSERT INTO tbl_books (b_title, b_author, b_year) VALUES (?, ?, ?)";
            dbConfig.addRecord(sql, title, author, year);
        }

        public static void viewBooks() {
            String sqlQuery = "SELECT * FROM tbl_books";
            String[] columnHeaders = {"Title", "Author", "Year"};
            String[] columnNames = {"b_title", "b_author", "b_year"};

            dbConfig.viewRecords(sqlQuery, columnHeaders, columnNames);
        }
    }