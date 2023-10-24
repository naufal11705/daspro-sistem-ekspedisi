import java.util.Scanner;

public class Login {

    public static String username;

    public static void main(String[] args) {
        String username = "user";
        String password = "password";

        Scanner scanner = new Scanner(System.in);
        boolean login = false;

        System.out.println("=============================================");
        System.out.println("\u001B[33m\u001B[44mSelamat datang di Aplikasi Ekspedisi!\u001B[0m");
        System.out.println("=============================================");

        while (!login) {
            System.out.print("Masukkan Username: ");
            String inputUsername = scanner.nextLine();

            if (inputUsername.equals(username)) {
                System.out.print("Masukkan Password: ");
                String inputPassword = scanner.nextLine();

                if (inputPassword.equals(password)) {
                    System.out.println("Login berhasil. Selamat datang, " + inputUsername + "!");
                    login = true;
                    System.out.print("\033[H\033[2J"); //membersihkan command line
                    UserDashboard.MainMenu();
                } else {
                    System.out.println("Login gagal. Password salah.");
                }
            } else {
                System.out.println("Login gagal. Username tidak ditemukan. Silakan coba lagi.");
                continue; // Meminta pengguna untuk mengisi ulang username
            }
        }

        scanner.close();
    }
}