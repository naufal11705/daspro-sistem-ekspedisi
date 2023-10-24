import java.util.Scanner;

public class UserDashboard {

    public static void MainMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("=============================================");
            System.out.println("Dashboard User - Nama Pengguna");
            System.out.println("=============================================");
            System.out.println("1. Transaksi");
            System.out.println("2. Ganti Bahasa");
            System.out.println("3. Keluar");
            System.out.print("Silakan pilih menu (1/2/3): ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    Transaksi.Transaction();
                    break;
                case 2:
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
