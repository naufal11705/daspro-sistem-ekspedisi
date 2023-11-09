import java.util.Arrays;
import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[][] userData = {{"naufal", "000"}, {"putra", "111"}, {"farhan", "222"}};

        boolean login = false;
        boolean exit = false;
        boolean found = false;

        while (!login) {
            System.out.print("Masukkan Username: ");
            String inputUsername = input.next();
            System.out.print("Masukkan Password: ");
            String inputPassword = input.next();

            for (int i = 0; i < userData.length; i++) {
                if (userData[i][0].equals(inputUsername) && userData[i][1].equals(inputPassword)) {
                    System.out.println("Login Berhasil");
                    login = true;
                    break;
                }
            }

            if (!login) {
                System.out.println("Login Gagal, silahkan coba lagi!");
            }
        }

        while (!exit) {
            System.out.println("=======================================");
            System.out.println("Menu");
            System.out.println("=======================================");
            System.out.println("[1] Tambahkan Pengguna");
            System.out.println("[2] Hapus Pengguna");
            System.out.println("[3] Data Pengguna");
            System.out.println("[4] Keluar");
            System.out.println("=======================================");

            System.out.print("Masukan Pilihan: ");
            int menuUtama = input.nextInt();
            input.nextLine();

            switch (menuUtama) {
                case 1:
                    System.out.print("Masukan Username Baru: ");
                    String newUsername = input.next();
                    System.out.print("Enter new password: ");
                    String newPassword = input.next();

                    // Menambahkan user baru ke array userData
                    userData = Arrays.copyOf(userData, userData.length + 1);
                    userData[userData.length - 1] = new String[]{newUsername, newPassword};

                    System.out.println("Pengguna baru berhasi ditambahkan!");
                    break;
                case 2:
                    System.out.print("Masukan username yang akan dihapus: ");
                    String usernameToRemove = input.next();

                    for (int i = 0; i < userData.length; i++) {
                        if (userData[i][0].equals(usernameToRemove)) {
                            // Menghapus user dari array userData
                            System.arraycopy(userData, i + 1, userData, i, userData.length - 1 - i);
                            userData = Arrays.copyOf(userData, userData.length - 1);
                            found = true;
                            break;
                        }
                    }

                    if (found) {
                        System.out.println("Perngguna berhasi dihapus!");
                    } else {
                        System.out.println("Pengguna tidak ditemukan.");
                    }
                    break;
                case 3:
                System.out.println("=======================================");
                System.out.println("Data Pengguna");
                System.out.println("=======================================");
                for (int i = 0; i < userData.length; i++) {
                    System.out.println("Username: " + userData[i][0] + " Password: " + userData[i][1]);
                }

                break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Pilihan tidak valid,Silahkan coba lagi!!!");
                    break;
            }
        }
    }
}
