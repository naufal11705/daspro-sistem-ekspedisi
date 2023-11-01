import java.util.Scanner;
public class DataUser {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        String [] data = new String[4]; //nama, alamat pengirim, alamat tujuan, tanggal kirim
        
        // Penginputan Data
        System.out.println("Silahkan masukkan nama pengirim: ");
        data [0]= input.nextLine();
        System.out.println("Alamat pengirim: ");
        data [1]= input.next();
        System.out.println("Alamat tujuan: ");
        data [2]= input.next();
        System.out.println("Waktu pengiriman: ");
        data [3]= input.nextLine();

        // Menghasilkan output print data user
        System.out.println("\n");
        System.out.println("==== INFORMASI USER ====");
        System.out.println("Nama Pengirim   : " +data[0]);
        System.out.println("Alamat pengirim : "+data[1]);
        System.out.println("Alamat tujuan   : "+data[2]);
        System.out.println("Waktu pengiriman: "+data[3]);
    }
}
