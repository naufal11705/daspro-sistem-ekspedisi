import java.util.Scanner;

public class Login {

    public static void main(String[] args) {
        
        String username = "user";
        String password = "password";

        Scanner scanner = new Scanner(System.in);

        System.out.println("***LOGIN***");
        
        
        System.out.print("Masukkan username: ");
        String inputUsername = scanner.nextLine();
        
        
        if (inputUsername.equals(username)) {
            
            System.out.print("Masukkan password: ");
            String inputPassword = scanner.nextLine();
            
            
            if (inputPassword.equals(password)) {
                System.out.println("Login berhasil. Selamat datang, " + inputUsername + "!");
            } else {
                System.out.println("Login gagal. Password salah.");
            }
        } else {
            System.out.println("Login gagal. Username tidak ditemukan.");
        }
        scanner.close();
    }
}