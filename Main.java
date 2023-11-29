import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Arrays;
import java.util.Calendar;

public class Main {

    /**
     * @param args
     */

    // Akun default
    static String[][] userData = {
        {"Naufal", "000","ADMIN"},
        {"Putra", "111","ADMIN"},
        {"Farhan", "222","ADMIN"},
        {"Kasir", "333", "KASIR"}
    };

    // Format tanggal
    static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    static Date date = new Date();
    static String tanggalHariIni = dateFormat.format(date);
    static String inputanTanggalAwal = "00-00-000", inputanTanggalAkhir = "00-00-0000";

    static String[][] arrayLayanan = {
        {"Ekonomi","5000", "1", "5"},
        {"Reguler", "10000", "1", "3"},
        {"Sameday", "20000", "1", "1"}
    };

    static String[][] rutePengiriman = {
        {"Malang", "Bekasi", "818"},
        {"Malang", "Bandung", "753"},
        {"Malang", "Medan", "2738"},
        {"Malang", "Bogor", "875"}
    };

    static Date startDate;
    static Date endDate;

    static String CLEAR = "\u001B[2J";


    // Array History Pemesanan
    static String[][] historyTransaksi = {
        {"9876543210995", "28-10-2023", "InnamTest", "08822334455", "Surabaya", "Sameday", "55000.0", "Putra", "Farrel2", "Jl. Melati 10 No. 9", "3", "Buku2", "On Process", "Bekasi"},
        {"8032468109752", "29-01-2023", "Nanda", "08866778899", "Yogyakarta", "Reguler", "25700.0", "Farhan", "Abdi", "Jl. Kembang 5 No. 15", "3", "Makanan", "On Process", "Malang"},
        {"9276354185046", "12-02-2023", "Gabriel", "08811223344", "Tangerang", "Ekonomi", "33200.0", "Naufal", "Afifah", "Jl. Anggrek 12 No. 8", "7", "Elektronik", "On Process", "Bekasi"},
        {"1492578034685", "03-03-2023", "Afifah", "08876543210", "Makassar", "Reguler", "50900.0", "Putra", "Naufal", "Jl. Melati 9 No. 21", "5", "Pakaian", "On Process", "Bandung"},
        {"5283176490254", "26-04-2023", "Esa", "08822334455", "Medan", "Ekonomi", "65400.0", "Farhan", "Luthfi", "Jl. Seroja 3 No. 7", "2", "Buku", "On Process", "Medan"},
        {"3091754682351", "21-05-2023", "Abdi", "08811223344", "Bogor", "Ekonomi", "34800.0", "Naufal", "Julian", "Jl. Mawar 17 No. 5", "9", "Mainan", "On Process", "Bogor"},
        {"6750912348526", "17-06-2023", "Naufal", "08822334455", "Semarang", "Sameday", "66500.0", "Putra", "Gabriel", "Jl. Anggrek 7 No. 12", "8", "Kesehatan", "On Process", "Malang"},
        {"8013564729835", "30-06-2023", "Farrel", "08855443322", "Jakarta", "Reguler", "76800.0", "Farhan", "Chiko", "Jl. Melati 15 No. 10", "4", "Alat Tulis", "On Process", "Bekasi"},
        {"2674853902164", "14-07-2023", "Atabik", "08855443322", "Bandung", "Ekonomi", "45300.0", "Naufal", "Vincent", "Jl. Kembang 2 No. 19", "1", "Elektronik", "On Process", "Bandung"},
        {"4501628397517", "05-08-2023", "Dio", "08876543210", "Surabaya", "Sameday", "29100.0", "Putra", "Saputra", "Jl. Seroja 11 No. 14", "6", "Makanan", "On Process", "Medan"},
        {"7246109385273", "09-09-2023", "Pasha", "08899887766", "Serang", "Reguler", "78000.0", "Farhan", "Naufal", "Jl. Anggrek 8 No. 5", "10", "Pakaian", "On Process", "Bogor"},
        {"3751928643058", "18-10-2023", "Farhan", "08866778899", "Denpasar", "Reguler", "55700.0", "Naufal", "Petrus", "Jl. Mawar 5 No. 11", "2", "Mainan", "On Process", "Malang"},
        {"5038921467584", "02-12-2023", "Chiko", "08811223344", "Malang", "Ekonomi", "87600.0", "Putra", "Saka", "Jl. Kembang 10 No. 17", "7", "Elektronik", "On Process", "Bogor"},
        {"6904715283142", "27-09-2023", "Haikal", "08887654321", "Bengkulu", "Sameday", "98800.0", "Farhan", "Vincent", "Jl. Melati 3 No. 9", "3", "Kesehatan", "On Process", "Bekasi"},
        {"4892307162453", "11-11-2023", "Cindy", "08899887766", "Bekasi", "Sameday", "65400.0", "Naufal", "Petrus", "Jl. Seroja 8 No. 6", "5", "Makanan", "On Process", "Bekasi"},
        {"1234567890123", "01-01-2023", "Ivan", "08812345678", "Surabaya", "Ekonomi", "45000.0", "Putra", "Abdi", "Jl. Anggrek 14 No. 20", "9", "Buku", "On Process", "Bogor"},
        {"9876543210987", "07-04-2023", "Luthfi", "08887654321", "Jakarta", "Reguler", "60000.0", "Farhan", "Farrel", "Jl. Kembang 1 No. 18", "1", "Elektronik", "On Process", "Malang"},
        {"3456789012345", "14-06-2023", "Adri", "08811223344", "Bandung", "Ekonomi", "35000.0", "Naufal", "Petrus", "Jl. Melati 6 No. 13", "6", "Makanan", "On Process", "Bogor"},
        {"8765432109876", "21-08-2023", "Alif", "08899887766", "Makassar", "Sameday", "42000.0", "Putra", "Saputra", "Jl. Anggrek 20 No. 3", "4", "Buku", "On Process", "Bandung"},
        {"6543210987654", "03-10-2023", "Dimas", "08876543210", "Denpasar", "Reguler", "58000.0", "Farhan", "Farrel", "Jl. Mawar 13 No. 16", "10", "Mainan", "On Process", "Bekasi"},
        {"8765432109876", "11-12-2023", "Julian", "08822334455", "Malang", "Sameday", "67000.0", "Naufal", "Naufal", "Jl. Seroja 2 No. 4", "8", "Kesehatan", "On Process", "Malang"},
        {"5432109876543", "25-02-2023", "Petrus", "08866778899", "Bogor", "Reguler", "73000.0", "Putra", "Saka", "Jl. Kembang 8 No. 1", "3", "Elektronik", "On Process", "Bogor"},
        {"3210987654321", "10-05-2023", "Saputra", "08855443322", "Surabaya", "Ekonomi", "32000.0", "Farhan", "Rio", "Jl. Mawar 14 No. 7", "5", "Makanan", "On Process", "Bekasi"},
        {"9876543210987", "15-07-2023", "Reika", "08811223344", "Semarang", "Reguler", "52000.0", "Naufal", "Chiko", "Jl. Anggrek 11 No. 15", "2", "Alat Tulis", "On Process", "Medan"},
        {"3456789012345", "20-09-2023", "Rio", "08887654321", "Yogyakarta", "Sameday", "47000.0", "Putra", "Naufal", "Jl. Seroja 10 No. 2", "9", "Elektronik", "On Process", "Bogor"},
        {"9876543210987", "05-11-2023", "Saka", "08899887766", "Tangerang", "Sameday", "69000.0", "Farhan", "Chiko", "Jl. Melati 20 No. 16", "1", "Pakaian", "On Process", "Bekasi"},
        {"3210987654321", "15-01-2023", "Taufik", "08876543210", "Bekasi", "Ekonomi", "40000.0", "Naufal", "Vincent", "Jl. Kembang 7 No. 19", "10", "Buku", "On Process", "Surabaya"},
        {"9876543210987", "20-03-2023", "Mera", "08822334455", "Gorontalo", "Sameday", "61000.0", "Putra", "Saputra", "Jl. Seroja 4 No. 11", "4", "Kesehatan", "On Process", "Bogor"},
        {"3456789012345", "05-05-2023", "Vincent", "08866778899", "Medan", "Reguler", "54000.0", "Farhan", "Petrus", "Jl. Anggrek 3 No. 14", "7", "Makanan", "On Process", "Medan"},
        {"3210987654321", "10-07-2023", "Vira", "08855443322", "Bengkulu", "Ekonomi", "37000.0", "Naufal", "Haikal", "Jl. Kembang 12 No. 9", "1", "Elektronik", "On Process", "Bogor"},
        {"9876543210987", "28-10-2023", "Innam", "08822334455", "Surabaya", "Sameday", "55000.0", "Putra", "Farrel", "Jl. Melati 9 No. 5", "6", "Buku", "On Process", "Bekasi"},
        {"8032468109798", "29-01-2023", "NandaTest", "08866778899", "Yogyakarta", "Reguler", "25700.0", "Farhan", "Abdi", "Jl. Kembang 5 No. 15", "3", "Makanan", "On Process", "Malang"},
    };

    static String laporanFormat = 
        "╔══════════════════════════════════════════════════════════════════════════════════════════════╗\n" +
        "║                                                                                              ║\n" +
        "║                      __     ___     ____    ____     ____     ___     _   __                 ║\n" + 
        "║                     / /    /   |   / __ \\  / __ \\   / __ \\   /   |   / | / /                 ║\n" +
        "║                    / /    / /| |  / /_/ / / / / /  / /_/ /  / /| |  /  |/ /                  ║\n" +
        "║                   / /___ / ___ | / ____/ / /_/ /  / _, _/  / ___ | / /|  /                   ║\n" +
        "║                  /_____//_/  |_|/_/      \\____/  /_/ |_|  /_/  |_|/_/ |_/                    ║\n" +
        "║                                                                                              ║\n" +
        "║                                                                                              ║\n" +
        "╠══════════════════════════════════════════════════════════════════════════════════════════════╣\n" +
        "║ POLINEMA EKPEDITION                                                                          ║\n" +
        "║ Laporan Pengiriman Per Bulan                                                                 ║\n" + 
        "║===================================================╦========================╦=================║\n" +
        "║                                                   ║       Nilai            ║     Satuan      ║\n" +
        "║                                                   ╠========================╬=================║\n" +
        "║ Total Pengiriman Per Asset                        ║                 %-2s     ║      Buah       ║\n" +
        "║ Total Pengiriman Per kg                           ║                 %-2s     ║       Kg        ║\n" +
        "║ Total Pendapatan                                  ║      Rp %-10s     ║     Rupiah      ║\n" +
        "║                                                   ║                        ║                 ║\n" +
        "╚═══════════════════════════════════════════════════╩════════════════════════╩═════════════════╝";

    static String formulirTransaksi =
        "╠══════════════════════════════════════════════════════════════════════════════════════════════════╣\n" +
        "║                                                                                                  ║\n" +
        "║  Nama Pengirim:                [%-40s]                        ║\n" +
        "║                                                                                                  ║\n" +
        "║  Nomor Kontak:                 [%-40s]                        ║\n" +
        "║                                                                                                  ║\n" +
        "║  Nama Penerima:                [%-40s]                        ║\n" +
        "║                                                                                                  ║\n" +
        "║  Alamat Tujuan:                [%-40s]                        ║\n" +
        "║                                                                                                  ║\n" +
        "║  Deskripsi Barang:             [%-40s]                        ║\n" +
        "║                                                                                                  ║\n" +
        "║  Berat Barang:                 [%-40s]                        ║\n" +
        "║                                                                                                  ║\n" +
        "║  Origin:                       [%-40s]                        ║\n" +
        "║                                                                                                  ║\n" +
        "║  Destination:                  [%-40s]                        ║\n" +
        "║                                                                                                  ║\n" +
        "║  Layanan:                      [%-40s]                        ║\n" +
        "║                                                                                                  ║\n" +
        "╠══════════════════════════════════════════════════════════════════════════════════════════════════╣";

    static String labelFormat = 
        "╔══════════════════════════════════════════════════════════════════════════════════════════════════╗\n" +
        "║  %44s║  Tanggal: %-40s║\n" +
        "╠════════════╦═════════════════════════════════╣  Layanan: %-40s║\n" +
        "║            ║ Pengirim:                       ║  Berat: %-42s║\n" +
        "║            ║ %-32s║  Deskripsi:                                       ║\n" + 
        "║            ║                                 ║  %-49s║\n" +
        "║            ║                                 ║                                                   ║\n" +
        "║            ║ Penerima:                       ║  Biaya Kirim: %-36s║\n" +
        "║            ║ %-32s║  Lokasi Tujuan: %-34s║\n" +
        "║            ║                                 ║  Alamat: %-41s║\n" +
        "╚════════════╩═════════════════════════════════╩═══════════════════════════════════════════════════╝";

    public static void CetakLaporan(){
        int totalAsset=0, totalBerat=0, totalHarga=0;

        try {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.DAY_OF_MONTH, 1); // Set the day of the month to the first day
            Date startDate = calendar.getTime();

            calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
            Date endDate = calendar.getTime();

            for (int i = 0; i < historyTransaksi.length; i++) {
                if (historyTransaksi[i][0] != null) {
                    Date transaksiDate = dateFormat.parse(historyTransaksi[i][1]);
                    if (transaksiDate.compareTo(startDate) >= 0 && transaksiDate.compareTo(endDate) <= 0) {
                        totalBerat += Integer.parseInt(historyTransaksi[i][10]);
                        totalAsset++;
                        totalHarga += Double.parseDouble(historyTransaksi[i][6]);
                    }
                }
            }

            System.out.println(String.format(
                laporanFormat,
                totalAsset,
                totalBerat,
                totalHarga));

            } catch (ParseException e) {
                e.printStackTrace();
            }  
    }
    public static void main(String[] args) {
        // Deklarasi scanner untuk memasukkan inputan
        Scanner input = new Scanner(System.in);

        String loggedInUsername = "";

        // Deklarasi boolean
        boolean login = false;
        boolean found = false;
        boolean exit = false;
        boolean isLoop = false;
        boolean isAdmin = false;
        boolean masuk = false;
        boolean validInput = false;
        boolean inputValid = false;

        // Variabel untuk switch case menu
        int menuUtama, subMenu, editMenu;
        
        double tarifPerKg = 5000;
        double tarifPerKm = 200;
        int pilihanLayanan;
        double biayaJarak = 0;

        String RESET = "\u001B[0m";
        String YELLOW = "\u001B[33m";

        int pilihanBahasa = 1, inputPilihanBahasa;

        // Array Multi Bahasa
        String[][] multilingual = {
            {"Welcome to the Expedition System", "Selamat Datang di Sistem Ekspedisi"},
            {"", "Manajemen Pengguna"}, //1
            {"Delivery of Goods", "Pengiriman Barang"}, //2
                // Bahasa menu pengiriman barang
                {"Transactions", "Melakukan Transaksi"}, 
                    {"Enter the Sender's Name: ","Masukkan Nama Pengirim: "},
                    {"Enter the weight of the item: ", "Masukkan Berat Barang: "},
                    {"Enter Destination: ", "Masukkan Kota Tujuan: "},
                    {"Destination not Found", "Kota Tujuan tidak ditemukan"},
                {"Editing Transactions", "Mengedit Data Transaksi"},
                {"Remove Transactions", "Menghapus Data Transaksi"},
                {"Displyas Transactions' Data", "Menampilkan Data Transaksi"},
                {"Back to the Main Menu", "Kembali ke Menu Utama"},
            {"Route Management", "Manajemen Rute"}, //12
                // Bahasa menu manajemen lokasi
                {"Add Location", "Menambahkan Rute"},
                {"Remove Location", "Menghapus Rute"},
                {"Displays Location's Data", "Menampilkan Data Rute Pengiriman"},
                {"Back to the Main Menu", "Kembali ke Menu Utama"},
            {"Cost Management", "Manajemen Layanan"}, //17
                // Bahasa menu Manajemen Tarif
                {"Add Service Types", "Tambahkan Jenis Layanan"},
                {"Change Cost Service", "Merubah Tarif Layanan"},
                {"Remove Service", "Menghapus Layanan"},
                {"Displays Services' Data", "Menampilkan Layanan Data"},
                {"Exit", "Keluar"}, 
            {"Change Language", "Ganti Bahasa"}, //23
            {"", "Laporan Ekspedisi"}, //24
            {"Exit", "Keluar"}, //25

            // Bahasa input pilihan
            {"-> Enter Options: ", "-> Masukkan Pilihan: "}, 

        };

        System.out.println("╔══════════════════════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║"+YELLOW+centerString(98, multilingual[0][pilihanBahasa])+RESET+"║");
        System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");

        while (!login) {
            login = false;
            found = false;
            exit = false;
            isLoop = false;
            isAdmin = false;
            masuk = false;
            while (!masuk) {
                System.out.print("║ -> Masukkan Username: ");
                String inputUsername = input.next();

                System.out.print("║ -> Masukan Password: ");
                String inputPassword = input.next();

                for (int i = 0; i < userData.length ; i++ ) {
                    if (userData[i][0].equals(inputUsername) && userData[i][1].equals(inputPassword)) {
                        System.out.println("║ Login Berhasil");
                        login = true;
                        masuk = true;
                        loggedInUsername = inputUsername;
                        
                        if("ADMIN".equals(userData[i][2])){
                            isAdmin = true;
                        }
                        break;
                    }
                }
                if(!masuk){
                    System.out.println("Login Gagal, silahkan coba lagi!");
                }
            }

            do {
                System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╗");
                System.out.println("║"+YELLOW+centerString(98, multilingual[0][pilihanBahasa])+RESET+"║");
                System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
                if(isAdmin){
                    System.out.println("║ [0]. " + multilingual[1][pilihanBahasa]); //Manajemen Pengguna
                }
                System.out.println("║ [1]. " + multilingual[2][pilihanBahasa]); //Pengiriman Barang
                System.out.println("║ [2]. " + multilingual[12][pilihanBahasa]); //Manajemen Lokasi
                System.out.println("║ [3]. " + multilingual[17][pilihanBahasa]); //Manajemen Tarif
                System.out.println("║ [4]. " + multilingual[23][pilihanBahasa]); //Ganti Bahasa
                System.out.println("║ [5]. Laporan"); //Laporan
                System.out.println("║ [6]. Keluar"); //Keluar
                System.out.println("║ [7]. Manajemen Tarif Dasar");
                System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");

                System.out.print("║ " + multilingual[26][pilihanBahasa]);
                menuUtama = input.nextInt();
                input.nextLine();

                isLoop = true;

                do {
                    switch (menuUtama) {
                        case 0:
                            if(isAdmin){
                                while(!exit) {
                                System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╗");
                                System.out.println("║"+YELLOW+centerString(98,"Manajemen Pengguna")+RESET+"║");
                                System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
                                System.out.println("║ [1] Tambahkan Pengguna");
                                System.out.println("║ [2] Hapus Pengguna");
                                System.out.println("║ [3] Data Pengguna");
                                System.out.println("║ [4] Keluar");
                                System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");

                                System.out.print("║ -> Masukan Pilihan: ");
                                int pilihan = input.nextInt();

                                switch (pilihan) {
                                    case 1:
                                    System.out.print("║ -> Masukan nama pengguna baru: ");
                                    String usernameBaru = input.next();
                                    System.out.print("║ -> Masukan kata sandi baru: ");
                                    String katasandiBaru = input.next();
                                    System.out.print("║ -> Masukkan jabatan pengguna baru: ");
                                    String jabatanBaru = input.next();
                                
                                    String[][] newUser = {
                                            {usernameBaru, katasandiBaru, jabatanBaru}
                                    };
                                
                                    // Menggabungkan array userData dengan newUser
                                    String[][] tempUserData = new String[userData.length + newUser.length][userData[0].length];
                                    System.arraycopy(userData, 0, tempUserData, 0, userData.length);
                                    System.arraycopy(newUser, 0, tempUserData, userData.length, newUser.length);
                                    userData = tempUserData;
                                
                                    System.out.println("║ Pengguna baru berhasil ditambahkan!!!");
                                    break;
                                    case 2:
                                        System.out.print("║ -> Masukan username yang akan dihapus: ");
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
                                            System.out.println("║ Perngguna berhasi dihapus!");
                                        } else {
                                            System.out.println("║ Pengguna tidak ditemukan.");
                                        }
                                        break;   
                                    case 3:
                                        System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
                                        System.out.println("║"+YELLOW+centerString(98,"Manajemen Pengguna")+RESET+"║");
                                        System.out.println("╠════════════════╦════════════════╦══════════════╦═════════════════════════════════════════════════╣");
                                        System.out.println("║ Username       ║ Password       ║ Jabatan      ║");
                                        System.out.println("╠════════════════╬════════════════╬══════════════╣");

                                        for (int i = 0; i < userData.length; i++) {
                                            System.out.printf("║ %-14s ║ %-14s ║ %-12s ║%n", userData[i][0], userData[i][1], userData[i][2]);
                                        }
                                        System.out.println("╠════════════════╩════════════════╩══════════════╝");
                                        break;
                                    case 4:
                                        exit = true;
                                        break;                                     
                                    default:
                                        System.out.println("Invalid");
                                        break;
                                }                
                            }
                            }
                            exit = false;
                            break;
                                
                                
                        case 1:
                            System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╗");
                            System.out.println("║"+YELLOW+centerString(98,"Pengiriman Barang")+RESET+"║");
                            System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
                            System.out.println("║ [1]. Melakukan Transaksi"); //Melakukan Transaksi
                            System.out.println("║ [2]. Manajemen Status Pengiriman (Beta)"); //Mengedit status pengiriman
                            System.out.println("║ [3]. Menghapus Data Transaksi"); //Menghapus Transaksi
                            System.out.println("║ [4]. Menampilkan Data Transaksi"); //Menampilkan Data Transaksi
                            System.out.println("║ [5]. Kembali ke Menu Utama"); //Kembali ke Menu Utama
                            System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
                            System.out.print("║ -> Masukkan Pilihan: "); 

                            subMenu = input.nextInt();
                            input.nextLine();

                            switch (subMenu) {
                                case 1:
                                    String namaPengirim = "";
                                    String nomorKontak = "";
                                    String namaPenerima = "";
                                    String alamatPenerima = "";
                                    String deskripsiBarang = "";
                                    double tarifLayanan = 0;
                                    String layanan = "";
                                    int beratBarang = 0;
                                    String origin = "";
                                    String destination = "";
                                    int jarak = 0;
                                    String nomorResi;

                                    tampilFormulirEkspedisi(namaPengirim, nomorKontak, namaPenerima, alamatPenerima, deskripsiBarang, beratBarang, origin, destination, layanan);

                                    System.out.print ("║ -> Masukkan Nama Pengirim: ");
                                    namaPengirim = input.nextLine();
                                    tampilFormulirEkspedisi(namaPengirim, nomorKontak, namaPenerima, alamatPenerima, deskripsiBarang, beratBarang, origin, destination, layanan);

                                    System.out.print ("║ -> Masukkan Nomor Kontak: ");
                                    nomorKontak = input.nextLine();
                                    tampilFormulirEkspedisi(namaPengirim, nomorKontak, namaPenerima, alamatPenerima, deskripsiBarang, beratBarang, origin, destination, layanan);

                                    System.out.print ("║ -> Masukkan Nama Penerima: ");
                                    namaPenerima = input.nextLine();
                                    tampilFormulirEkspedisi(namaPengirim, nomorKontak, namaPenerima, alamatPenerima, deskripsiBarang, beratBarang, origin, destination, layanan);

                                    System.out.print ("║ -> Masukkan Alamat: ");
                                    alamatPenerima = input.nextLine();
                                    tampilFormulirEkspedisi(namaPengirim, nomorKontak, namaPenerima, alamatPenerima, deskripsiBarang, beratBarang, origin, destination, layanan);

                                    System.out.print("║ -> Masukkan Deskripsi Barang: ");
                                    deskripsiBarang = input.nextLine();
                                    tampilFormulirEkspedisi(namaPengirim, nomorKontak, namaPenerima, alamatPenerima, deskripsiBarang, beratBarang, origin, destination, layanan);
                                    do {
                                        System.out.print("║ -> Masukkan Berat Barang: ");
                                        while (!input.hasNextInt()) {
                                            System.out.println("Input harus berupa bilangan bulat. Silakan coba lagi.");
                                            System.out.print("Masukkan Berat Barang: ");
                                            input.next(); // mengonsumsi input yang tidak valid
                                        }
                                        beratBarang = input.nextInt();
                                        tampilFormulirEkspedisi(namaPengirim, nomorKontak, namaPenerima, alamatPenerima, deskripsiBarang, beratBarang, origin, destination, layanan);
                                        input.nextLine(); // membersihkan buffer input
                                        if (beratBarang <= 0) {
                                            System.out.println("Berat barang harus lebih besar dari 0. Silakan coba lagi.");
                                        } else {
                                            validInput = true;
                                        }
                                    } while (!validInput);
                                    validInput = false;
                                    //Mencari Kota Pengiriman pada Array
                                    do {
                                        System.out.print ("║ -> Origin: ");
                                        origin = input.nextLine();
                                        tampilFormulirEkspedisi(namaPengirim, nomorKontak, namaPenerima, alamatPenerima, deskripsiBarang, beratBarang, origin, destination, layanan);
                                        System.out.print (("║ -> Destination: "));
                                        destination = input.nextLine();
                                        tampilFormulirEkspedisi(namaPengirim, nomorKontak, namaPenerima, alamatPenerima, deskripsiBarang, beratBarang, origin, destination, layanan);
                                        for (int i = 0; i < rutePengiriman.length; i++) {
                                            if ((rutePengiriman[i][0].equalsIgnoreCase(origin) && rutePengiriman[i][1].equalsIgnoreCase(destination)) || 
                                            (rutePengiriman[i][0].equalsIgnoreCase(destination) && rutePengiriman[i][1].equalsIgnoreCase(origin))) {
                                                jarak = Integer.parseInt(rutePengiriman[i][2]);
                                                biayaJarak = jarak * tarifPerKm;
                                                found = true;
                                                break;
                                            }
                                        }
                                        if(!found) {
                                            origin = "";
                                            destination = "";
                                            tampilFormulirEkspedisi(namaPengirim, nomorKontak, namaPenerima, alamatPenerima, deskripsiBarang, beratBarang, origin, destination, layanan);
                                            System.out.println ("║ Kota Tujuan tidak Ditemukan!");
                                        }    
                                    } while (!found);
                                    found = false;

                                    //Memilih Jenis Layanan pada Array

                                    for (int i = 0; i < arrayLayanan.length; i++) {
                                        if (arrayLayanan[i][2] != arrayLayanan[i][3]) {
                                            System.out.println("║ ["+i+"]. "+arrayLayanan[i][0]+" - "+arrayLayanan[i][1]+ " - Estimasi: "+arrayLayanan[i][2]+" - "+arrayLayanan[i][3]+" hari");
                                        } else {
                                            System.out.println("║ ["+i+"]. "+arrayLayanan[i][0]+" - "+arrayLayanan[i][1]+ " - Estimasi: "+arrayLayanan[i][2]+" hari");
                                        }
                                    }
                                    System.out.print ("║ -> Masukkan Pilihan: ");
                                    pilihanLayanan = input.nextInt();
                                    layanan = arrayLayanan[pilihanLayanan][0];
                                    tampilFormulirEkspedisi(namaPengirim, nomorKontak, namaPenerima, alamatPenerima, deskripsiBarang, beratBarang, origin, destination, layanan);
                                    tarifLayanan = Double.parseDouble(arrayLayanan[pilihanLayanan][1]);                      

                                    double biayaAkhir = tarifLayanan + (tarifPerKg * beratBarang) + biayaJarak;
                                    nomorResi = generateNomorResi();

                                    historyTransaksi = Arrays.copyOf(historyTransaksi,historyTransaksi.length + 1);
                                    historyTransaksi[historyTransaksi.length-1] = new String[]{
                                        nomorResi,
                                        tanggalHariIni,
                                        namaPengirim,
                                        nomorKontak,
                                        destination,
                                        arrayLayanan[pilihanLayanan][0],
                                        Double.toString(biayaAkhir),
                                        loggedInUsername,
                                        namaPenerima,
                                        alamatPenerima,
                                        String.valueOf(beratBarang),
                                        deskripsiBarang};

                                    System.out.println(String.format(
                                        labelFormat,
                                        nomorResi,
                                        tanggalHariIni, // Tanggal
                                        arrayLayanan[pilihanLayanan][0],
                                        beratBarang, // Berat
                                        namaPengirim,
                                        deskripsiBarang,
                                        biayaAkhir, // Biaya Akhir
                                        namaPenerima,
                                        destination, // Lokasi
                                        alamatPenerima

                                        


                                    ));                                        
                                    break;
                                case 2:
                                    System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣"); 
                                    System.out.println("║                                                                                       History Transaksi");
                                    System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣"); 
                                    System.out.println("║ No  |     No Resi     |   Tanggal   |   Layanan   |      Tujuan      | Berat |      Deskripsi      |    Biaya    |  Nama Penerima  |  Alamat  ");
                                    System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣");              
                                    for (int i = 0; i < historyTransaksi.length; i++) {
                                        System.out.println(String.format("║ %3d ║ %15s ║ %11s ║ %11s ║ %16s ║ %5s ║ %19s ║ %11s ║ %15s ║ %30s ║ %15s ║ %15s",
                                            i,
                                            historyTransaksi[i][0], // Nomor Resi
                                            historyTransaksi[i][1], // Tanggal
                                            historyTransaksi[i][5],  //Jenis Layanan
                                            historyTransaksi[i][4], // Tujuan
                                            historyTransaksi[i][10], // Berat
                                            historyTransaksi[i][11], // Deskripsi
                                            historyTransaksi[i][6], // Tarif
                                            historyTransaksi[i][8], // Nama Penerima
                                            historyTransaksi[i][9], // Alamat
                                            historyTransaksi[i][12],
                                            historyTransaksi[i][13]
                                        ));
                                    }  
                                    System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣"); 

                                    int indexKirim;
                                    System.out.print("║ -> Masukkan index: ");
                                    indexKirim = input.nextInt();

                                    boolean adaKesamaanData = false;           
                                    for (int i = 0; i < historyTransaksi.length; i++) {
                                        if (i != indexKirim && historyTransaksi[i][12].equals("On Process" ) && 
                                                historyTransaksi[i][4].equals(historyTransaksi[indexKirim][4]) && 
                                                historyTransaksi[i][5].equals(historyTransaksi[indexKirim][5]) && 
                                                historyTransaksi[i][0] != historyTransaksi[indexKirim][0] &&
                                                historyTransaksi[i][13].equals(historyTransaksi[indexKirim][13])) {
                                                adaKesamaanData = true;
                                        }
                                    }
                                    
                                    if (adaKesamaanData){
                                        System.out.println("║ -> Terdapat beberapa barang yang dapat dikirim bersama dengan paket ini!");
                                        for (int i = 0; i < historyTransaksi.length; i++) {
                                            if (historyTransaksi[i][12].equals("On Process" ) && 
                                                    historyTransaksi[i][4].equals(historyTransaksi[indexKirim][4]) && 
                                                    historyTransaksi[i][5].equals(historyTransaksi[indexKirim][5]) && 
                                                    historyTransaksi[i][0] != historyTransaksi[indexKirim][0] &&
                                                    historyTransaksi[i][13].equals(historyTransaksi[indexKirim][13])) {
                                                    historyTransaksi[i][12] = "Shipping";
                                                    historyTransaksi[indexKirim][12] = "Shipping";
                                                    System.out.println(String.format("║ %15s ║ %11s ║ %11s ║ %16s ║ %5s ║ %19s ║ %11s ║ %15s ║ %30s ║ %15s ║ %15s",
                                                        historyTransaksi[i][0], // Nomor Resi
                                                        historyTransaksi[i][1], // Tanggal
                                                        historyTransaksi[i][5],  //Jenis Layanan
                                                        historyTransaksi[i][4], // Tujuan
                                                        historyTransaksi[i][10], // Berat
                                                        historyTransaksi[i][11], // Deskripsi
                                                        historyTransaksi[i][6], // Tarif
                                                        historyTransaksi[i][8], // Nama Penerima
                                                        historyTransaksi[i][9], // Alamat
                                                        historyTransaksi[i][12],
                                                        historyTransaksi[i][13]
                                                    ));
                                            }
                                        }
                                        System.out.println(String.format("║ %15s ║ %11s ║ %11s ║ %16s ║ %5s ║ %19s ║ %11s ║ %15s ║ %30s ║ %15s ║ %15s",
                                            historyTransaksi[indexKirim][0], // Nomor Resi
                                            historyTransaksi[indexKirim][1], // Tanggal
                                            historyTransaksi[indexKirim][5],  //Jenis Layanan
                                            historyTransaksi[indexKirim][4], // Tujuan
                                            historyTransaksi[indexKirim][10], // Berat
                                            historyTransaksi[indexKirim][11], // Deskripsi
                                            historyTransaksi[indexKirim][6], // Tarif
                                            historyTransaksi[indexKirim][8], // Nama Penerima
                                            historyTransaksi[indexKirim][9], // Alamat
                                            historyTransaksi[indexKirim][12],
                                            historyTransaksi[indexKirim][13]
                                        ));
                                    } else {
                                        System.out.println("║ -> Fitur apaan dah ini, kodenya panjang banget");
                                    }

                                    break;

                                case 3: 
                                    // menghapus transaksi berdasarkan nomor resi
                                    validInput = false;
                                    int deleteIndex = -1;

                                    while (!validInput) {
                                        System.out.print("║ -> Masukkan nomor resi: ");
                                        try {
                                            String deleteString = input.nextLine();
                                            validInput = true;

                                            for (int i=0; i<historyTransaksi.length; i++) {
                                                if (historyTransaksi[i][0].equals(deleteString)) {
                                                    deleteIndex = i;
                                                    break;
                                            }
                                        } 
                                        if (deleteIndex != -1) {
                                            validInput = true;
                                        } else { System.out.println("║ Data tidak ditemukan. Silakan coba lagi."); }

                                    } catch (NumberFormatException exception) {
                                            System.out.println("║ Input yang dimasukkan tidak valid. Silakan masukkan nomor resi kembali!.");
                                        }
                                    }

                                    // Hapus elemen jika validInput adalah true
                                    if (deleteIndex >= 0 && deleteIndex < historyTransaksi.length) {
                                        System.out.println("║ Transaksi dengan nomor resi yang sesuai telah dihapus!");
                                        System.arraycopy(historyTransaksi, deleteIndex + 1, historyTransaksi, deleteIndex, historyTransaksi.length - deleteIndex - 1);
                                        historyTransaksi = Arrays.copyOf(historyTransaksi, historyTransaksi.length - 1);
                                    } else {
                                        System.out.println("║ Data tidak ditemukan.");
                                    }   

                                break;
                                case 4:
                                    Calendar calendar = Calendar.getInstance();
                                    System.out.println("╔══════════════════════════════════════════════════════════════════════════════════════════════════╗");
                                    System.out.println("║"+YELLOW+centerString(98,"History Transaksi")+RESET+"║");
                                    System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
                                    System.out.println("║ [1]. Berdasarkan Rentang Tanggal");
                                    System.out.println("║ [2]. Hari");
                                    System.out.println("║ [3]. Bulan");
                                    System.out.println("║ [4]. Tahun");
                                    System.out.println("║ [5]. Nomor Resi");
                                    System.out.println("║ [6]. Kembali ke Menu Utama");
                                    System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
                                    System.out.print("║ -> Masukkan Pilihan: ");
                                    editMenu = input.nextInt();
                                    switch (editMenu) {
                                        case 1:
                                            boolean validInputTanggalAwal = false;
                                            boolean validInputTanggalAkhir = false;
                                            do {
                                                try {
                                                    System.out.print("║ Masukkan Tanggal Awal (dd-MM-yyyy): ");
                                                    inputanTanggalAwal = input.next();
                                                    startDate = dateFormat.parse(inputanTanggalAwal);
                                                    validInputTanggalAwal = true;
                                                } catch (ParseException | InputMismatchException e) {
                                                    System.out.println("Format tanggal tidak valid. Harap masukkan tanggal dengan format dd-MM-yyyy.");
                                                    input.nextLine(); 
                                                }
                                            } while (!validInputTanggalAwal);
                                        
                                            do {
                                                try {
                                                    System.out.print("║ Masukkan Tanggal Akhir (dd-MM-yyyy): ");
                                                    inputanTanggalAkhir = input.next();
                                                    endDate = dateFormat.parse(inputanTanggalAkhir);
                                                    validInputTanggalAkhir = true;
                                                } catch (ParseException | InputMismatchException e) {
                                                    System.out.println("Format tanggal tidak valid. Harap masukkan tanggal dengan format dd-MM-yyyy.");
                                                    input.nextLine(); 
                                                }
                                            } while (!validInputTanggalAkhir);
                                        
                                            try {
                                                tampilHistory(startDate, endDate);
                                            } catch (Exception e) {
                                                e.printStackTrace();
                                            }
                                            break;
                                        case 2:
                                        try {
                                            int tanggalInput;
                                        
                                            while (!inputValid) {
                                                System.out.print("Masukkan Tanggal (dd): ");
                                                if (input.hasNextInt()) {
                                                    tanggalInput = input.nextInt();
                                        
                                                    if (tanggalInput < 1 || tanggalInput > 31) {
                                                        System.out.println("Tanggal tidak valid.");
                                                    } else {
                                                        inputValid = true;
                                                        Calendar cal = Calendar.getInstance();
                                                        int bulanSekarang = cal.get(Calendar.MONTH) + 1; // Bulan dimulai dari 0
                                                        int tahunSekarang = cal.get(Calendar.YEAR);
                                        
                                                        String tanggalYangDiinginkan = String.format("%02d-%02d-%d", tanggalInput, bulanSekarang, tahunSekarang);
                                                        Date startDate = dateFormat.parse(tanggalYangDiinginkan);
                                                        Date endDate = dateFormat.parse(tanggalYangDiinginkan);
                                        
                                                        tampilHistoryhari(startDate, endDate);
                                                    }
                                                } else {
                                                    System.out.println("Input harus berupa angka.");
                                                    input.next(); 
                                                }
                                            }
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                            break;
                                        case 3:
                                            try {
                                                int bulanInput;
                                                while (true) {
                                                    System.out.print("Masukkan Bulan (MM): ");
                                                    if (input.hasNextInt()) {
                                                        bulanInput = input.nextInt();
                                                        if (bulanInput >= 1 && bulanInput <= 12) {
                                                            break; // Keluar dari loop saat input valid
                                                        } else {
                                                            System.out.println("Bulan tidak valid. Masukkan angka antara 1 sampai 12.");
                                                        }
                                                    } else {
                                                        System.out.println("Masukkan angka antara 1 sampai 12.");
                                                        input.next(); 
                                                    }
                                                }
                                    
                                                Calendar cal = Calendar.getInstance();
                                                int tahunSekarang = cal.get(Calendar.YEAR);
                                    
                                                // Membuat tanggal awal dan akhir pada bulan dan tahun yang dimasukkan
                                                String tanggalAwal = String.format("01-%02d-%d", bulanInput, tahunSekarang);
                                                cal.set(Calendar.MONTH, bulanInput - 1); // Bulan dimulai dari 0
                                                int hariTerakhir = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
                                                String tanggalAkhir = String.format("%02d-%02d-%d", hariTerakhir, bulanInput, tahunSekarang);
                                    
                                                Date startDate = dateFormat.parse(tanggalAwal);
                                                Date endDate = dateFormat.parse(tanggalAkhir);
                                    
                                                tampilHistoryBulan(startDate, endDate);
                                            } catch (Exception e) {
                                                e.printStackTrace();
                                            }
                                            break;
                                        case 4:
                                            try {
                                                int tahunInput = 0;
                                    
                                                while (!validInput) {
                                                    System.out.print("Masukkan Tahun: ");
                                    
                                                    if (input.hasNextInt()) {
                                                        tahunInput = input.nextInt();
                                    
                                                        if (tahunInput >= 1900 && tahunInput <= 3000) {
                                                            validInput = true;
                                                        } else {
                                                            System.out.println("Tahun tidak valid. Harap masukkan tahun antara 1900 dan 3000.");
                                                        }
                                                    } else {
                                                        System.out.println("Input bukan angka. Silakan masukkan tahun antara 1900 dan 3000.");
                                                        input.next(); 
                                                    }
                                                }
                                    
                                                tampilHistoryTahun(tahunInput);
                                    
                                            } catch (Exception e) {
                                                e.printStackTrace();
                                            }
                                            break;
                                        case 5:
                                            // mencari transaksi berdasarkan nomor resi
                                            validInput = false;
                                            int searchIndex = -1;
                                            String searchString = "";

                                            while (!validInput) {
                                                System.out.print("║ -> Masukkan nomor resi: ");
                                                input.nextLine();
                                                try {
                                                    searchString = input.nextLine();
                                                    validInput = true;

                                                    for (int i=0; i<historyTransaksi.length; i++) {
                                                        if (historyTransaksi[i][0].equals(searchString)) {
                                                            tampilHistoryResi(searchString);
                                                            searchIndex = i;
                                                            break;
                                                    }
                                                } 
                                                if (searchIndex != -1) {
                                                    validInput = true;
                                                } else { System.out.println("║ Data tidak ditemukan. Silakan coba lagi."); }

                                            } catch (NumberFormatException exception) {
                                                    System.out.println("║ Input yang dimasukkan tidak valid. Silakan masukkan nomor resi kembali!.");
                                                }
                                            }
                                                                                
                                            break;
                                        default:
                                            break;
                                    }
                                    break;
                                case 5:
                                    isLoop = false;
                                    break;
                                default:
                                System.out.println("Invalid choice. Please try again.");
                            }
                            break;                        
                        case 2:
                            boolean keluar = true;
                            while (keluar) {
                            System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
                            System.out.println("║"+YELLOW+centerString(98,"Manajemen Rute")+RESET+"║");
                            System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");

                            System.out.println("║ [1]. Menambah Rute"); //Menambahkan Lokasi
                            System.out.println("║ [2]. Menghapus Rute"); //Menghapus Lokasi
                            System.out.println("║ [3]. Menampilkan Data Rute"); //Menampilkan Data Lokasi
                            System.out.println("║ [4]. Kembali ke Menu Utama"); //Kembali ke Menu Utama
                            System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
                            System.out.print("║ -> Masukkan Pilihan: "); 
                            subMenu = input.nextInt();

                            input.nextLine();
                
                            switch (subMenu) {
                                case 1:
                                    boolean routeExist = false;
                                    String origin;
                                    String destination;
                                    
                                    do {
                                        routeExist = false;
                                        System.out.print("║ -> Origin: ");
                                        origin = input.nextLine();
                                        System.out.print("║ -> Destination: ");
                                        destination = input.nextLine();

                                        for (int i = 0; i < rutePengiriman.length; i++) {
                                            if ((rutePengiriman[i][0].equalsIgnoreCase(origin) && rutePengiriman[i][1].equalsIgnoreCase(destination)) || 
                                            (rutePengiriman[i][0].equalsIgnoreCase(destination) && rutePengiriman[i][1].equalsIgnoreCase(origin))) {
                                                System.out.println("║ Rute tersebut sudah ada!");
                                                routeExist = true;
                                                break;
                                            } 
                                        }


                                        } while (routeExist); 

                                        System.out.print("║ -> Masukkan Jarak antara "+origin+" dan "+destination+": ");
                                        String jarak = input.next();

                                        rutePengiriman = Arrays.copyOf(rutePengiriman,rutePengiriman.length + 1);
                                        rutePengiriman[rutePengiriman.length-1] = new String[] {
                                            origin,
                                            destination,
                                            jarak};
                                    
                                    break;
                                case 2:
                                    System.out.println("║ Daftar rute yang Tersedia:");
                                    for (int i = 0; i < rutePengiriman.length; i++) {
                                        System.out.println("║ " + (i + 1) + ". " + rutePengiriman[i][0] + ". " + rutePengiriman[i][1] + ". " + rutePengiriman[i][2]);
                                    }
                        
                                    int deleteIndex = 0;
            

                                    // Validation loop for non-integer input
                                    while (!validInput) {
                                        System.out.print("║ -> Masukkan nomor rute yang ingin dihapus: ");
                                        try {
                                            deleteIndex = Integer.parseInt(input.nextLine());
                                            validInput = true;
                                        } catch (NumberFormatException e) {
                                            System.out.println("║ Input yang dimasukkan bukan angka. Silakan masukkan nomor.");
                                        }
                                    }

                                    if (deleteIndex >= 1 && deleteIndex <= rutePengiriman.length) {
                                        String[] deletedLocation = rutePengiriman[deleteIndex - 1];
                                        System.out.println("║ " + deletedLocation + " Telah Dihapus!");

                                        System.arraycopy(rutePengiriman, deleteIndex, rutePengiriman, deleteIndex - 1, rutePengiriman.length - deleteIndex);
                                        rutePengiriman = Arrays.copyOf(rutePengiriman, rutePengiriman.length - 1);
                                    } else {
                                        System.out.println("║ Nomor rute tidak valid");
                                        continue;
                                    }

                                    if (found) {
                                        found = false;
                                    } else {
                                        System.out.println("║ Key tidak ditemukan");
                                    }                                           
                                    break;
                                case 3:
                                    tampilDataRute();
                                    break;
                                case 4:
                                    keluar = false;
                                    break;
                                default:
                                System.out.println("║ Invalid choice. Please try again.");
                                }
                        } break;
                        case 3:
                            System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
                            System.out.println("║"+YELLOW+centerString(98,"Manajemen Layanan")+RESET+"║");
                            System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");

                            System.out.println("║ [1]. Tambah Jenis Layanan"); //Tambahan Jenis Layanan
                            System.out.println("║ [2]. Mengedit Layanan"); //Merubah Tarif Layanan
                            System.out.println("║ [3]. Menghapus Layanan"); //Menghapus Layanan
                            System.out.println("║ [4]. Menampilkan Data Layanan"); //Menampilkan Layanan Data
                            System.out.println("║ [5]. Keluar"); //Keluar

                            System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
                            System.out.print("║ -> Masukkan Pilihan: ");
                            subMenu = input.nextInt();
                            input.nextLine();

                            switch (subMenu) {
                                case 1:
                                    String namaLayanan = "";
                                    double tarifLayanan = 0;
                                    int startEstimation = 0;
                                    int endEstimation = 0;

                                        System.out.print("║ -> Masukkan Nama Layanan: ");
                                        namaLayanan = input.next();
                                        while (!inputValid) {
                                            System.out.print("║ -> Masukkan Tarif: ");
                                            if (input.hasNextDouble()) {
                                                tarifLayanan = input.nextDouble();
                                                inputValid = true;
                                            } else {
                                                System.out.println("║ Masukan bukan angka. Mohon masukkan angka.");
                                                input.next(); // Membersihkan input yang tidak valid dari buffer
                                            }
                                        }

                                        System.out.print("║ -> Masukkan Waktu Pengiriman Minimum: ");
                                        startEstimation = input.nextInt();
                                        System.out.print("║ -> Masukkan Waktu Pengiriman Maximum: ");
                                        endEstimation = input.nextInt();

                                        arrayLayanan = Arrays.copyOf(arrayLayanan,arrayLayanan.length + 1);
                                        arrayLayanan[arrayLayanan.length-1] = new String[] {
                                            namaLayanan,
                                            String.valueOf(tarifLayanan),
                                            String.valueOf(startEstimation),
                                            String.valueOf(endEstimation)};
                                    break;
                                case 2:
                                System.out.println("║ Daftar Layanan yang Tersedia:");
                                for (int i = 0; i < arrayLayanan.length; i++) {
                                    System.out.println((i + 1) + ". " + arrayLayanan[i][0] );
                                }
                        
                                System.out.print("║ -> Masukkan nomor layanan yang ingin diubah: ");
                                int selectedService = 0;

                                while (!inputValid) {
                                    if (input.hasNextInt()) {
                                        selectedService = input.nextInt();
                                        if (selectedService >= 1 && selectedService <= arrayLayanan.length) {
                                            inputValid = true;
                                        } else {
                                            System.out.println("║ Nomor layanan tidak valid. Masukkan nomor layanan yang valid:");
                                            input.nextLine(); // Membersihkan newline di buffer
                                        }
                                    } else {
                                        System.out.println("║ Input bukan angka. Mohon masukkan nomor layanan yang valid:");
                                        input.next(); // Membersihkan input yang tidak valid dari buffer
                                    }
                                }

                                inputValid = false; // Reset inputValid untuk validasi berikutnya

                                if (selectedService >= 1 && selectedService <= arrayLayanan.length) {
                                    System.out.println("║ Pilih yang ingin diubah:");
                                    System.out.println("║ [1]. Nama Layanan");
                                    System.out.println("║ [2]. Tarif Layanan");
                                    System.out.print("║ -> Masukkan nomor pilihan: ");
                                    int changeOption = 0;

                                    while (!inputValid) {
                                        if (input.hasNextInt()) {
                                            changeOption = input.nextInt();
                                            if (changeOption == 1 || changeOption == 2) {
                                                inputValid = true;
                                            } else {
                                                System.out.println("║ Pilihan tidak valid. Masukkan nomor pilihan yang valid:");
                                                input.nextLine(); // Membersihkan newline di buffer
                                            }
                                        } else {
                                            System.out.println("║ Input bukan angka. Mohon masukkan nomor pilihan yang valid:");
                                            input.next(); // Membersihkan input yang tidak valid dari buffer
                                        }
                                    }

                                    if (changeOption == 1) {
                                        System.out.print("║ -> Masukkan Nama Layanan Baru: ");
                                        input.nextLine(); // Membersihkan newline di buffer
                                        arrayLayanan[selectedService - 1][0] = input.nextLine();
                                        System.out.println("║ Data nama layanan berhasil diupdate.");
                                    } else if (changeOption == 2) {
                                        double newTarif = 0.0;
                                        inputValid = false; // Reset inputValid untuk validasi berikutnya

                                        while (!inputValid) {
                                            System.out.print("║ -> Masukkan Tarif Baru: ");
                                            if (input.hasNextDouble()) {
                                                newTarif = input.nextDouble();
                                                inputValid = true;
                                            } else {
                                                System.out.println("║ Masukan bukan angka. Mohon masukkan angka.");
                                                input.next(); // Membersihkan input yang tidak valid dari buffer
                                            }
                                        }

                                        arrayLayanan[selectedService - 1][1] = String.valueOf(newTarif);
                                        System.out.println("║ Data tarif layanan berhasil diupdate.");
                                        break;
                                    }
                                } else {
                                    System.out.println("║ Nomor layanan tidak valid");
                                }
                                break;
                                case 3:
                                    System.out.println("║ Daftar Layanan yang Tersedia:");
                                    for (int i = 0; i < arrayLayanan.length; i++) {
                                        if (arrayLayanan[i] != null) {
                                            System.out.println("║ " + (i + 1) + ". " + arrayLayanan[i][0]);
                                        }
                                    }
                        
                                    int selectedNumber = 0;
        
                                    while (!validInput) {
                                        try {
                                            System.out.print("║ ->Pilih nomor layanan yang ingin dihapus: ");
                                            selectedNumber = input.nextInt();
                                            validInput = true;
                                        } catch (InputMismatchException e) {
                                            System.out.println("║ Masukan bukan angka. Silakan masukkan nomor layanan yang valid.");
                                            input.nextLine(); // Membersihkan buffer
                                        }
                                    }

                                    if (selectedNumber > 0 && selectedNumber <= arrayLayanan.length) {
                                        String pilih = arrayLayanan[selectedNumber - 1][0];

                                        for (int i = 0; i < arrayLayanan.length; i++) {
                                            if (arrayLayanan[i][0].equalsIgnoreCase(pilih)) {
                                                System.out.println("║ " + arrayLayanan[i][0] + " - " + arrayLayanan[i][1] + " Telah Dihapus!");
                                                arrayLayanan[i] = null;
                                                break;
                                            }
                                        }
                                    } else {
                                        System.out.println("║ Nomor layanan tidak valid.");
                                    }
                                    break;
                                case 4:
                                    tampilDataTarifLayanan ();
                                    break;
                                case 5:
                                    isLoop = false;
                                    break;
                                default:
                                System.out.println("║ Invalid choice. Please try again.");
                            }
                            break;

                        case 4:
                            do {
                                System.out.println("║ Pilih bahasa (Choose a language):");
                                System.out.println("║ [1]. English");
                                System.out.println("║ [2]. Indonesian");
                                System.out.print("║ -> Masukkan Pilihan: ");
                                inputPilihanBahasa = input.nextInt();

                                switch (inputPilihanBahasa) {
                                    case 1:
                                        pilihanBahasa = inputPilihanBahasa-1;
                                        break;
                                    case 2:
                                        pilihanBahasa = inputPilihanBahasa-1;
                                        break;
                                    default:
                                        System.out.println("║ Invalid choice. Please try again.");
                                }
                            } while (inputPilihanBahasa > multilingual[0].length);
                            break;
                        case 5:
                            CetakLaporan();
                            break;
                        case 6:
                            exit=true;
                            login=false;
                            masuk=false;
                            break;
                        case 7:
                            System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
                            System.out.println("║"+YELLOW+centerString(98,"Manajemen Tarif Dasar")+RESET+"║");
                            System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");

                            System.out.println("║ [1]. Tarif Dasar per Kg"); //Tambahan Jenis Layanan
                            System.out.println("║ [2]. Tarif Dasar per Km"); //Merubah Tarif Layanan
                            System.out.println("║ [3]. Keluar"); //Keluar

                            System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
                            System.out.print("║ -> Masukkan Pilihan: ");
                            subMenu = input.nextInt();

                            switch (subMenu) {
                                case 1:
                                    System.out.print("║ -> Masukkan tarif dasar per Kg: ");
                                    tarifPerKg = input.nextInt();
                                    break;
                                case 2:
                                    System.out.print("║ -> Masukkan tarif dasar per Km: ");
                                    tarifPerKm = input.nextInt();
                                    break;
                                case 3:
                                    isLoop = false;
                                    break;
                                default:
                                    break;
                            }

                            break;
                        default:
                            System.out.println("║ Invalid choice. Please try again.");
                            break;
                    }
                    break;
                } while (isLoop);
                


            } while(!exit);
        }
    }
    public static void tampilDataRute() {
        System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
        System.out.println("║"+centerString(98,"Data Rute")+"║");
        System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
        System.out.println("║ No  ║       Nama Kota      ║       Nama Kota      ║  Jarak");
        System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
        for (int i = 0; i < rutePengiriman.length; i++) {
            String formattedString = String.format("║ %3d ║ %20s ║ %20s ║ %5s Km",
                    i,
                    rutePengiriman[i][0], 
                    rutePengiriman[i][1], 
                    rutePengiriman[i][2] 
            );
            System.out.println(formattedString);
        }
    } 
    
    public static void tampilDataTarifLayanan() {
        System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
        System.out.println("║"+centerString(98,"Data Layanan")+"║");
        System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
        System.out.println("║ No  ║   Nama Layanan   ║  Biaya");
        System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
        for (int i = 0; i < arrayLayanan.length; i++) {
            if (arrayLayanan[i] != null) {
                    String formattedString = String.format("║ %3d ║ %16s ║ %5s",
                    i,
                    arrayLayanan[i][1], // Nama Kota
                    arrayLayanan[i][0] // Tarif
            );
            System.out.println(formattedString);
            }
        }
    } 

    public static void tampilHistory(Date startDate, Date endDate){
        try{
            System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣"); 
            System.out.println("║                                                                                       History Transaksi");
            System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣"); 
            System.out.println("║ No  |     No Resi     |   Tanggal   |  Nama Pengirim  |  Nomor Kontak  |   Layanan   |      Tujuan      | Berat |      Deskripsi      |    Biaya    |    Kasir    |  Nama Penerima  |         Alamat Penerima");
            System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣");              
            for (int i = 0; i < historyTransaksi.length; i++) {
                if (historyTransaksi[i][0] != null){
                    Date transaksiDate = dateFormat.parse(historyTransaksi[i][1]);
                    if (transaksiDate.compareTo(startDate) >= 0 && transaksiDate.compareTo(endDate) <= 0) {
                        System.out.println(String.format("║ %3d ║ %15s ║ %11s ║ %15s ║ %14s ║ %11s ║ %16s ║ %5s ║ %19s ║ %11s ║ %11s ║ %15s ║ %30s",
                            i,
                            historyTransaksi[i][0], // Nomor Resi
                            historyTransaksi[i][1], // Tanggal
                            historyTransaksi[i][2], // Nama Pengirim
                            historyTransaksi[i][3], // Nomor Kontak
                            historyTransaksi[i][5],  //Jenis Layanan
                            historyTransaksi[i][4], // Tujuan
                            historyTransaksi[i][10], // Berat
                            historyTransaksi[i][11], // Deskripsi
                            historyTransaksi[i][6], // Tarif
                            historyTransaksi[i][7], // Nama Kasir
                            historyTransaksi[i][8], // Nama Penerima
                            historyTransaksi[i][9] // Alamat



                        ));
                    }
                }
            }
            System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣"); 
        }catch (ParseException e){
            e.printStackTrace();
        }
    }

    public static String centerText(String text) {
        int totalWidth = 40;
        int spaces = (totalWidth - text.length()) / 2;
        return String.format("%" + spaces + "s%s%" + spaces + "s", "", text, "");
    }

    private static String centerString(int width, String s) {
        int padSize = (width - s.length()) / 2;
        return String.format("%" + padSize + "s%s%" + (padSize + (width - s.length()) % 2) + "s", "", s, "");
    }

    public static void tampilFormulirEkspedisi(String namaPengirim, String nomorKontak, String namaPenerima, String alamatPenerima, String deskripsibarang, int beratBarang, String origin, String destination, String layanan){

        if (beratBarang != 0) {
            System.out.println(String.format(
                formulirTransaksi,
                centerText(namaPengirim),
                centerText(nomorKontak),
                centerText(namaPenerima),
                centerText(alamatPenerima),
                centerText(deskripsibarang),
                centerText(Integer.toString(beratBarang)),
                centerText(origin),
                centerText(destination),
                centerText(layanan)
            ));
        } else {
            System.out.println(String.format(
                formulirTransaksi,
                centerText(namaPengirim),
                centerText(nomorKontak),
                centerText(namaPenerima),
                centerText(alamatPenerima),
                centerText(deskripsibarang),
                centerText(""),
                centerText(origin),
                centerText(destination),
                centerText(layanan)
            ));
        }

    }
    public static void tampilHistoryhari(Date startDate, Date endDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        boolean dataDitemukan = false;

        System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣"); 
        System.out.println("║                                                                                       History Transaksi");
        System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣"); 
        System.out.println("║ No  |     No Resi     |   Tanggal   |  Nama Pengirim  |  Nomor Kontak  |   Layanan   |      Tujuan      | Berat |      Deskripsi      |    Biaya    |    Kasir    |  Nama Penerima  |         Alamat Penerima");
        System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣");  

        for (int i = 0; i < historyTransaksi.length; i++) {
            if (historyTransaksi[i][0] != null) {
                try {
                    Date transaksiDate = dateFormat.parse(historyTransaksi[i][1]);
                    Calendar cal = Calendar.getInstance();
                    int bulanSekarang = cal.get(Calendar.MONTH) + 1; // Bulan dimulai dari 0
                    int tahunSekarang = cal.get(Calendar.YEAR);

                    if (transaksiDate.compareTo(startDate) >= 0 && transaksiDate.compareTo(endDate) <= 0
                            && dateFormat.format(transaksiDate).startsWith(String.format("%02d-%02d", startDate.getDate(), bulanSekarang))) {
                            System.out.println(String.format("║ %3d ║ %15s ║ %11s ║ %15s ║ %14s ║ %11s ║ %16s ║ %5s ║ %19s ║ %11s ║ %11s ║ %15s ║ %30s",
                                i,
                                historyTransaksi[i][0], // Nomor Resi
                                historyTransaksi[i][1], // Tanggal
                                historyTransaksi[i][2], // Nama Pengirim
                                historyTransaksi[i][3], // Nomor Kontak
                                historyTransaksi[i][5],  //Jenis Layanan
                                historyTransaksi[i][4], // Tujuan
                                historyTransaksi[i][10], // Berat
                                historyTransaksi[i][11], // Deskripsi
                                historyTransaksi[i][6], // Tarif
                                historyTransaksi[i][7], // Nama Kasir
                                historyTransaksi[i][8], // Nama Penerima
                                historyTransaksi[i][9] // Alamat



                            ));
                        dataDitemukan = true;
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣"); 


        if (!dataDitemukan) {
            System.out.println("Tidak ada transaksi pada rentang tanggal tersebut atau yang sesuai dengan bulan dan tahun ini.");
        }
    }

    public static void tampilHistoryBulan(Date startDate, Date endDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        boolean dataDitemukan = false;

        System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣"); 
        System.out.println("║                                                                                       History Transaksi");
        System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣"); 
        System.out.println("║ No  |     No Resi     |   Tanggal   |  Nama Pengirim  |  Nomor Kontak  |   Layanan   |      Tujuan      | Berat |      Deskripsi      |    Biaya    |    Kasir    |  Nama Penerima  |         Alamat Penerima");
        System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣");  

        for (int i = 0; i < historyTransaksi.length; i++) {
            if (historyTransaksi[i][0] != null) {
                try {
                    Date transaksiDate = dateFormat.parse(historyTransaksi[i][1]);

                    Calendar cal = Calendar.getInstance();
                    cal.setTime(transaksiDate);
                    int transaksiBulan = cal.get(Calendar.MONTH) + 1; // Bulan dimulai dari 0
                    int transaksiTahun = cal.get(Calendar.YEAR);

                    if (transaksiDate.compareTo(startDate) >= 0 && transaksiDate.compareTo(endDate) <= 0
                            && transaksiBulan == startDate.getMonth() + 1 && transaksiTahun == startDate.getYear() + 1900) {
                        System.out.println(String.format("║ %3d ║ %15s ║ %11s ║ %15s ║ %14s ║ %11s ║ %16s ║ %5s ║ %19s ║ %11s ║ %11s ║ %15s ║ %30s",
                            i,
                            historyTransaksi[i][0], // Nomor Resi
                            historyTransaksi[i][1], // Tanggal
                            historyTransaksi[i][2], // Nama Pengirim
                            historyTransaksi[i][3], // Nomor Kontak
                            historyTransaksi[i][5],  //Jenis Layanan
                            historyTransaksi[i][4], // Tujuan
                            historyTransaksi[i][10], // Berat
                            historyTransaksi[i][11], // Deskripsi
                            historyTransaksi[i][6], // Tarif
                            historyTransaksi[i][7], // Nama Kasir
                            historyTransaksi[i][8], // Nama Penerima
                            historyTransaksi[i][9] // Alamat
                        ));
                        dataDitemukan = true;
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣"); 

        if (!dataDitemukan) {
            System.out.println("Tidak ada transaksi pada rentang tanggal tersebut atau yang sesuai dengan bulan dan tahun ini.");
        }

    }
    public static void tampilHistoryTahun(int tahunInput) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        boolean dataDitemukan = false;

        System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣"); 
        System.out.println("║                                                                                       History Transaksi");
        System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣"); 
        System.out.println("║ No  |     No Resi     |   Tanggal   |  Nama Pengirim  |  Nomor Kontak  |   Layanan   |      Tujuan      | Berat |      Deskripsi      |    Biaya    |    Kasir    |  Nama Penerima  |         Alamat Penerima");
        System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣");  

        for (int i = 0; i < historyTransaksi.length; i++) {
            if (historyTransaksi[i][0] != null) {
                try {
                    Date transaksiDate = dateFormat.parse(historyTransaksi[i][1]);
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(transaksiDate);
                    int tahunTransaksi = cal.get(Calendar.YEAR);

                    if (tahunTransaksi == tahunInput) {
                        System.out.println(String.format("║ %3d ║ %15s ║ %11s ║ %15s ║ %14s ║ %11s ║ %16s ║ %5s ║ %19s ║ %11s ║ %11s ║ %15s ║ %30s",
                            i,
                            historyTransaksi[i][0], // Nomor Resi
                            historyTransaksi[i][1], // Tanggal
                            historyTransaksi[i][2], // Nama Pengirim
                            historyTransaksi[i][3], // Nomor Kontak
                            historyTransaksi[i][5],  //Jenis Layanan
                            historyTransaksi[i][4], // Tujuan
                            historyTransaksi[i][10], // Berat
                            historyTransaksi[i][11], // Deskripsi
                            historyTransaksi[i][6], // Tarif
                            historyTransaksi[i][7], // Nama Kasir
                            historyTransaksi[i][8], // Nama Penerima
                            historyTransaksi[i][9] // Alamat
                        ));
                        dataDitemukan = true;
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣"); 

        if (!dataDitemukan) {
            System.out.println("Tidak ada transaksi pada tahun tersebut.");
        }
    }

    public static void tampilHistoryResi(String resi){
        System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣"); 
        System.out.println("║                                                                                       History Transaksi");
        System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣"); 
        System.out.println("║ No  |     No Resi     |   Tanggal   |  Nama Pengirim  |  Nomor Kontak  |   Layanan   |      Tujuan      | Berat |      Deskripsi      |    Biaya    |    Kasir    |  Nama Penerima  |         Alamat Penerima");
        System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣");              
        for (int i = 0; i < historyTransaksi.length; i++) {
            if (historyTransaksi[i][0].equals(resi)) {
                System.out.println(String.format("║ %3d ║ %15s ║ %11s ║ %15s ║ %14s ║ %11s ║ %16s ║ %5s ║ %19s ║ %11s ║ %11s ║ %15s ║ %30s",
                    i,
                    historyTransaksi[i][0], // Nomor Resi
                    historyTransaksi[i][1], // Tanggal
                    historyTransaksi[i][2], // Nama Pengirim
                    historyTransaksi[i][3], // Nomor Kontak
                    historyTransaksi[i][5],  //Jenis Layanan
                    historyTransaksi[i][4], // Tujuan
                    historyTransaksi[i][10], // Berat
                    historyTransaksi[i][11], // Deskripsi
                    historyTransaksi[i][6], // Tarif
                    historyTransaksi[i][7], // Nama Kasir
                    historyTransaksi[i][8], // Nama Penerima
                    historyTransaksi[i][9] // Alamat
                ));
            }
        }
        System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣"); 
    }

    private static String generateNomorResi() {
        long timestamp = System.currentTimeMillis();
        return String.valueOf(timestamp);
    }

}
