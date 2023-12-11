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

    static String[][] languageModule = {
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
        {"⤷ Enter Options: ", "⤷ Masukkan Pilihan: "}, 
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

    static String RESET = "\u001B[0m";
    static String CLEAR = "\033[H\033[2J";
    static String GREEN = "\u001B[32m";
    static String RED = "\u001B[31m";
    static String YELLOW = "\u001B[33m";

    static int selectedLanguage = 1;

    static boolean login = false;
    static boolean isAdmin = false;
    static boolean masuk = false;

    static String loggedInUsername = "";

    static double tarifPerKg = 5000;
    static double tarifPerKm = 500;

    // Array History Pemesanan
    static String[][] historyTransaksi = {
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
    };

    static String reportFormat = 
        "╔══════════════════════════════════════════════════════════════════════════════════════════════════╗\n" +
        "║                                                                                                  ║\n" +
        "║                                        ╦═╗╔═╗╔═╗╔═╗╦═╗╔╦╗                                        ║\n" + 
        "║                                        ╠╦╝║╣ ╠═╝║ ║╠╦╝ ║                                         ║\n" +
        "║                                        ╩╚═╚═╝╩  ╚═╝╩╚═ ╩                                         ║\n" +
        "║                                                                                                  ║\n" +
        "╠══════════════════════════════════════════════════════════════════════════════════════════════════╣\n" +
        "║ POLINEMA EKPEDITION                                                                              ║\n" +
        "║ Laporan Pengiriman Per Bulan                                                                     ║\n" + 
        "╠═══════════════════════════════════════════════════════╦════════════════════════╦═════════════════╣\n" +
        "║                                                       ║       Nilai            ║     Satuan      ║\n" +
        "║                                                       ╠════════════════════════╬═════════════════╣\n" +
        "║ Total Pengiriman Per Asset                            ║      %s   ║      Buah       ║\n" +
        "║ Total Pengiriman Per kg                               ║      %s   ║       Kg        ║\n" +
        "║ Total Pendapatan                                      ║      %s   ║     Rupiah      ║\n" +
        "║                                                       ║                        ║                 ║\n" +
        "╚═══════════════════════════════════════════════════════╩════════════════════════╩═════════════════╝";

    static String labelFormat = 
        "╔══════════════════════════════════════════════════════════════════════════════════════════════════╗\n" +
        "║%s║\n" +
        "╠══════════════════════════════════════════════════════════════════════════════════════════════════╣\n" +
        "║                                                                                                  ║\n" +
        "║  Penerima:    %-34sPengirim:    %-36s║\n" +
        "║  %-60s%-36s║\n" +
        "║                                                              %-36s║\n" + 
        "║                                                                                                  ║\n" +
        "║  ╭─────────────────────────────────────────────╮╭─────────────────────────────────────────────╮  ║\n" +
        "║  │%s││%s│  ║\n" +
        "║  ╰─────────────────────────────────────────────╯╰─────────────────────────────────────────────╯  ║\n" +
        "║                                                                                                  ║\n" +
        "║  Tanggal:     %-83s║\n" +
        "║  Biaya:       %-83s║\n" +
        "║                                                                                                  ║\n" +
        "╚══════════════════════════════════════════════════════════════════════════════════════════════════╝";

    public static void main(String[] args) {
        // Deklarasi scanner untuk memasukkan inputan
        Scanner input = new Scanner(System.in);

        // Deklarasi boolean
        boolean exit = false;
        boolean isLoop = false;
        boolean validInput = false;
        boolean inputValid = false;

        // Variabel untuk switch case menu
        int menuUtama, subMenu, editMenu;

        int inputselectedLanguage;

        clearTerminal();

        while (!login) {
            login = false;
            exit = false;
            isLoop = false;
            isAdmin = false;
            masuk = false;
            while (!masuk) {
                displayHeader();
                displayIndonesianMap();

                System.out.print("║ -> Masukkan Username\t: ");
                String inputUsername = input.next();

                System.out.print("║ -> Masukan Password\t: ");
                String inputPassword = input.next();
                input.nextLine();

                loginValidation(inputUsername, inputPassword);

                if(!masuk){
                    System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
                    System.out.println("║"+RED+centerString(98, "Login Gagal, silahkan coba lagi!")+RESET);
                    System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════════════╝");
                    System.out.print("Enter: ");
                    input.nextLine();
                    clearTerminal();
                }
            }

            System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
            System.out.println("║                                                                                                  ║");
            System.out.println("║"+centerString(97, "✅ Anda berhasil masuk. Selamat datang " + loggedInUsername)+"║");
            System.out.println("║                                                                                                  ║");
            System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════════════╝");
            System.out.print("Tekan ⏎ Enter untuk melanjutkan ");
            input.nextLine();
            clearTerminal();

            do {
                displayHeader();
                displayIndonesianMap();

                if(isAdmin){

                    System.out.println("║                                                                                                  ║");
                    System.out.println("║             ╭──────────────────────────────────────────────────────────────────────╮             ║");
                    System.out.println("║             │                                                                      │             ║");
                    System.out.println("║             │     [1]. Manajemen Pengguna              [6]. Manajemen Tarif Dasar  │             ║");
                    System.out.println("║             │                                                                      │             ║");
                    System.out.println("║             │     [2]. Transaksi Pengiriman            [7]. Laporan                │             ║");
                    System.out.println("║             │                                                                      │             ║");
                    System.out.println("║             │     [3]. Manajemen Rute                  [8]. Pengiriman Barang      │             ║");
                    System.out.println("║             │                                                                      │             ║");
                    System.out.println("║             │     [4]. Manajemen Layanan               [9]. Keluar                 │             ║");
                    System.out.println("║             │                                                                      │             ║");
                    System.out.println("║             │     [5]. Ganti Bahasa                                                │             ║");
                    System.out.println("║             │                                                                      │             ║"); 
                    System.out.println("║             ╰──────────────────────────────────────────────────────────────────────╯             ║");
                    System.out.println("║                                                                                                  ║"); 
                    System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");

                } else if (isKurir) {
                    System.out.println("║                                                                                                  ║");
                    System.out.println("║             ╭──────────────────────────────────────────────────────────────────────╮             ║");
                    System.out.println("║             │                                                                      │             ║");
                    System.out.println("║             │                                                                      │             ║");
                    System.out.println("║             │                                                                      │             ║");
                    System.out.println("║             │                     [1]. Pengiriman Barang                           │             ║");
                    System.out.println("║             │                                                                      │             ║");
                    System.out.println("║             │                                                                      │             ║");
                    System.out.println("║             │                                                                      │             ║");
                    System.out.println("║             │                     [2]. Keluar                                      │             ║");
                    System.out.println("║             │                                                                      │             ║");
                    System.out.println("║             │                                                                      │             ║");
                    System.out.println("║             │                                                                      │             ║"); 
                    System.out.println("║             ╰──────────────────────────────────────────────────────────────────────╯             ║");
                    System.out.println("║                                                                                                  ║"); 
                    System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
                } else {
                    System.out.println("║                                                                                                  ║");
                    System.out.println("║             ╭──────────────────────────────────────────────────────────────────────╮             ║");
                    System.out.println("║             │                                                                      │             ║");
                    System.out.println("║             │                                                                      │             ║");
                    System.out.println("║             │                                                                      │             ║");
                    System.out.println("║             │          [1]. Transaksi Pengiriman         [4]. Ganti Bahasa         │             ║");
                    System.out.println("║             │                                                                      │             ║");
                    System.out.println("║             │          [2]. Manajemen Lokasi             [5]. Laporan              │             ║");
                    System.out.println("║             │                                                                      │             ║");
                    System.out.println("║             │          [3]. Manajemen Tarif              [6]. Keluar               │             ║");
                    System.out.println("║             │                                                                      │             ║");
                    System.out.println("║             │                                                                      │             ║");
                    System.out.println("║             │                                                                      │             ║"); 
                    System.out.println("║             ╰──────────────────────────────────────────────────────────────────────╯             ║");
                    System.out.println("║                                                                                                  ║"); 
                    System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
            }
                
                System.out.print("║ " + languageModule[26][selectedLanguage]);
                menuUtama = input.nextInt();
                input.nextLine();
                clearTerminal();

                isLoop = true;
                do {

                    if(isAdmin){
                    menuUtama = menuUtama-1;
                    switch (menuUtama) {
                        case 0:
                            if(isAdmin){
                                while(!exit) {
                                displayHeader();
                                displayIndonesianMap();

                                System.out.println("║"+YELLOW+centerString(98,"Manajemen Pengguna")+RESET+"║");
                                System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
                                System.out.println("║ [1] Tambahkan Pengguna");
                                System.out.println("║ [2] Hapus Pengguna");
                                System.out.println("║ [3] Data Pengguna");
                                System.out.println("║ [4] Keluar");
                                System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");

                                System.out.print("║ ⤷ Masukan Pilihan: ");
                                int pilihan = input.nextInt();

                                switch (pilihan) {
                                    case 1:
                                    System.out.print("║ ⤷ Masukan nama pengguna baru: ");
                                    String usernameBaru = input.next();
                                    System.out.print("║ ⤷ Masukan kata sandi baru: ");
                                    String katasandiBaru = input.next();
                                    System.out.print("║ ⤷ Masukkan jabatan pengguna baru: ");
                                    String jabatanBaru = input.next();
                                    input.nextLine();
                                                                
                                    userData = Arrays.copyOf(userData,userData.length + 1);
                                    userData[userData.length-1] = new String[] {
                                        usernameBaru,
                                        katasandiBaru,
                                        jabatanBaru};

                                    System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
                                    System.out.println("║                                                                                                  ║");
                                    System.out.println("║"+centerString(97, "✅ Pengguna baru berhasil ditambahkan.")+"║");
                                    System.out.println("║                                                                                                  ║");
                                    System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════════════╝");

                                    System.out.print("Enter: ");
                                    input.nextLine();
                                    clearTerminal();
                                    
                                    break;
                                    case 2:
                                        boolean found = false;
                                        System.out.print("║ ⤷ Masukan username yang akan dihapus: ");
                                        String usernameToRemove = input.next();
                                        input.nextLine(); //konsumsi
                        
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
                                            System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
                                            System.out.println("║                                                                                                  ║");
                                            System.out.println("║"+centerString(100, "🗑️  Pengguna telah dihapus.")+"║");
                                            System.out.println("║                                                                                                  ║");
                                            System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════════════╝");
                                        } else {
                                            System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
                                            System.out.println("║                                                                                                  ║");
                                            System.out.println("║"+centerString(99, "⚠️  PENGGUNA TIDAK DITEMUKAN. SILAKAN COBA LAGI.")+"║");
                                            System.out.println("║                                                                                                  ║");
                                            System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════════════╝");
                                        }
                                        System.out.print("Enter: ");
                                        input.nextLine();
                                        clearTerminal();
                                        break;   
                                    case 3:
                                        input.nextLine(); //konsumsi
                                        viewUserAccounts();
                                        System.out.print("Enter: ");
                                        input.nextLine();
                                        clearTerminal();
                                        break;
                                    case 4:
                                        exit = true;
                                        clearTerminal();
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
                            displayHeader();
                            displayIndonesianMap();

                            System.out.println("║"+YELLOW+centerString(98,"Pengiriman Barang")+RESET+"║");
                            System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
                            System.out.println("║ [1]. Melakukan Transaksi"); //Melakukan Transaksi
                            System.out.println("║ [2]. Manajemen Status Pengiriman"); //Mengedit status pengiriman
                            System.out.println("║ [3]. Menghapus Data Transaksi"); //Menghapus Transaksi
                            System.out.println("║ [4]. Menampilkan Data Transaksi"); //Menampilkan Data Transaksi
                            System.out.println("║ [5]. Kembali ke Menu Utama"); //Kembali ke Menu Utama
                            System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
                            System.out.print("║ -> Masukkan Pilihan: "); 

                            subMenu = input.nextInt();
                            input.nextLine();

                            switch (subMenu) {
                                case 1:
                                    String nomorResi;
                                    int pilihanLayanan;
                                    double biayaJarak = 0;

                                    System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");

                                    System.out.print ("║ Masukkan Nama Pengirim: ");
                                    String namaPengirim = input.nextLine();

                                    System.out.print ("║ Masukkan Nomor Kontak: ");
                                    String nomorKontak = input.nextLine();

                                    System.out.print ("║ Masukkan Nama Penerima: ");
                                    String namaPenerima = input.nextLine();

                                    System.out.print ("║ Masukkan Alamat: ");
                                    String alamatPenerima = input.nextLine();

                                    System.out.print("║ Masukkan Deskripsi Barang: ");
                                    String deskripsiBarang = input.nextLine();
            
                                    double beratBarang=0;
                                    int panjang;
                                    int luas;
                                    int tinggi;
                                    double berat=0;
                                    do {
                                        System.out.print("║ Masukkan Berat (Kg): ");
                                        while (!input.hasNextInt()) {
                                            System.out.println("Input harus berupa bilangan bulat. Silakan coba lagi.");
                                            System.out.print("Masukkan Berat (Kg): ");
                                            input.next(); // mengonsumsi input yang tidak valid
                                        }
                                        berat= input.nextInt();

                                        input.nextLine(); // membersihkan buffer input
                                        if (berat < 0) {
                                            System.out.println("berat harus lebih besar dari 0. Silakan coba lagi.");
                                        } else {
                                            validInput = true;
                                        }
                                    } while (!validInput);

                                    do {
                                        System.out.print("║ Masukkan Panjang (cm): ");
                                        while (!input.hasNextInt()) {
                                            System.out.println("Input harus berupa bilangan bulat. Silakan coba lagi.");
                                            System.out.print("Masukkan Panjang (cm): ");
                                            input.next(); // mengonsumsi input yang tidak valid
                                        }
                                        panjang= input.nextInt();

                                        input.nextLine(); // membersihkan buffer input
                                        if (panjang < 0) {
                                            System.out.println("panjang harus lebih besar dari 0. Silakan coba lagi.");
                                        } else {
                                            validInput = true;
                                        }
                                    } while (!validInput);
                                    
                                    do {
                                        System.out.print("║ Masukkan Lebar (cm): ");
                                        while (!input.hasNextInt()) {
                                            System.out.println("Input harus berupa bilangan bulat. Silakan coba lagi.");
                                            System.out.print("Masukkan Lebar (cm): ");
                                            input.next(); // mengonsumsi input yang tidak valid
                                        }
                                        luas = input.nextInt();

                                        input.nextLine(); // membersihkan buffer input
                                        if (luas <= 0) {
                                            System.out.println("Luas harus lebih besar dari 0. Silakan coba lagi.");
                                        } else {
                                            validInput = true;
                                        }
                                    } while (!validInput);

                                    do {
                                        System.out.print("║ Masukkan Tinggi (cm): ");
                                        while (!input.hasNextInt()) {
                                            System.out.println("Input harus berupa bilangan bulat. Silakan coba lagi.");
                                            System.out.print("Masukkan Tinggi (cm): ");
                                            input.next(); // mengonsumsi input yang tidak valid
                                        }
                                        tinggi = input.nextInt();

                                        input.nextLine(); // membersihkan buffer input
                                        if (tinggi <= 0) {
                                            System.out.println("Luas harus lebih besar dari 0. Silakan coba lagi.");
                                        } else {
                                            validInput = true;
                                        }
                                    } while (!validInput);
                                    validInput = false;
                                    //Mencari Kota Pengiriman pada Array
                                    boolean found = false;
                                    String origin;
                                    String destination;
                                    do {
                                        System.out.print ("║ Origin: ");
                                        origin = input.nextLine();

                                        System.out.print (("║ Destination: "));
                                        destination = input.nextLine();

                                        for (int i = 0; i < rutePengiriman.length; i++) {
                                            if ((rutePengiriman[i][0].equalsIgnoreCase(origin) && rutePengiriman[i][1].equalsIgnoreCase(destination)) || 
                                            (rutePengiriman[i][0].equalsIgnoreCase(destination) && rutePengiriman[i][1].equalsIgnoreCase(origin))) {
                                                int jarak = Integer.parseInt(rutePengiriman[i][2]);
                                                
                                                biayaJarak = (jarak * tarifPerKm)/100;
                                                found = true;
                                                break;
                                            }
                                        }
                                        if(!found) {
                                            origin = "";
                                            destination = "";
                                            System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
                                            System.out.println("║                                                                                                  ║");
                                            System.out.println("║"+centerString(97, "⚠️ RUTE TIDAK DITEMUKAN. SILAKAN COBA LAGI.")+"║");
                                            System.out.println("║                                                                                                  ║");
                                            System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════════════╝");
                                            System.out.print("Tekan ⏎ Enter untuk melanjutkan ");
                                            input.nextLine();  
                                            System.out.print("\033[8A\033[0J");
                                        }    
                                    } while (!found);

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
                                    double tarifLayanan = Double.parseDouble(arrayLayanan[pilihanLayanan][1]); 
                                    double beratBarangTemp; // Variabel sementara untuk menyimpan nilai dari kedua kondisi

                                    if (beratBarang >= 0) {
                                        beratBarangTemp = (berat * tarifPerKg) / 5;
                                    } else {
                                        beratBarangTemp = (tarifPerKg * (panjang * luas * tinggi) / 4000) / 100;
                                    }

                                    // Menggunakan nilai terbesar dari kedua kondisi untuk beratBarang
                                    beratBarang = Math.max(beratBarang, beratBarangTemp);

                                    // Menghitung biayaAkhir dengan nilai beratBarang yang telah ditentukan
                                    double biayaAkhir = tarifLayanan + beratBarang + biayaJarak;
                                    nomorResi = generateTrackingNumber();

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
                                        deskripsiBarang,
                                        "On Process",
                                        origin};

                                    clearTerminal();
                                    System.out.println(String.format(
                                        labelFormat,
                                        centerString(98, "No. Resi: "+nomorResi),
                                        namaPenerima, 
                                        namaPengirim,
                                        alamatPenerima, 
                                        nomorKontak,
                                        origin,
                                        centerString(45, origin), 
                                        centerString(45, destination),
                                        tanggalHariIni,
                                        biayaAkhir
                                    ));       
                                    input.nextLine(); //konsumsi

                                    System.out.print("Enter: ");
                                    input.nextLine();   
                                    clearTerminal();                                 
                                    break;
                                case 2:
                                    validInput = false;
                                    int index = -1;

                                    while (!validInput) {
                                        System.out.print("║ ⤷ Masukkan nomor resi: ");
                                        try {
                                            String trackingNumber = input.nextLine();
                                            validInput = true;

                                            for (int i=0; i<historyTransaksi.length; i++) {
                                                if (historyTransaksi[i][0].equals(trackingNumber)) {
                                                    index = i;
                                                    break;
                                            }
                                        } 
                                        if (index != -1) {
                                            validInput = true;
                                            System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╗");
                                            System.out.println("║"+YELLOW+centerString(98,"Status Pengiriman")+RESET+"║");
                                            System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
                                            System.out.println("║ [1]. On Process"); //Melakukan Transaksi
                                            System.out.println("║ [2]. Shipping"); //Mengedit status pengiriman
                                            System.out.println("║ [3]. Delivered"); //Menghapus Transaksi
                                            System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
                                            System.out.print("║ -> Masukkan Pilihan: ");
                                            String selected = input.nextLine();

                                            if(selected.equals("1")){
                                                historyTransaksi[index][12] = "On Process";
                                            } else if(selected.equals("2")) {
                                                historyTransaksi[index][12] = "Shipping";
                                            } else if(selected.equals("3")) {
                                                historyTransaksi[index][12] = "Delivered";
                                            } else {
                                                break;
                                            }
                                        } else {
                                            System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
                                            System.out.println("║"+YELLOW+centerString(98, "Data tidak ditemukan")+RESET);
                                            System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════════════╝");
                                        }

                                    } catch (NumberFormatException exception) {
                                            System.out.println("║ Input yang dimasukkan tidak valid. Silakan masukkan nomor resi kembali!.");
                                        }
                                    }

                                    System.out.print("Enter: ");
                                    input.nextLine();   
                                    clearTerminal(); 
                                break;

                                case 3: 
                                    // menghapus transaksi berdasarkan nomor resi
                                    validInput = false;
                                    int deleteIndex = -1;

                                    while (!validInput) {
                                        System.out.print("║ ⤷ Masukkan nomor resi: ");
                                        try {
                                            String deleteString = input.nextLine();
                                            validInput = true;

                                            for (int i=0; i<historyTransaksi.length; i++) {
                                                if (historyTransaksi[i][0].equals(deleteString)) {
                                                    deleteIndex = i;
                                                    break;
                                            }
                                        } 

                                    } catch (NumberFormatException exception) {
                                            System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
                                            System.out.println("║"+YELLOW+centerString(98, "Input yang dimasukkan tidak valid. Silahkan masukkan nomor resi kembali!")+RESET);
                                            System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════════════╝");
                                        }
                                    }

                                    // Hapus elemen jika validInput adalah true
                                    if (deleteIndex >= 0 && deleteIndex < historyTransaksi.length) {
                                        System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
                                        System.out.println("║"+RED+centerString(98, "Data dengan nomor resi yang sesuai sudah dihapus")+RESET);
                                        System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════════════╝");
                                        System.arraycopy(historyTransaksi, deleteIndex + 1, historyTransaksi, deleteIndex, historyTransaksi.length - deleteIndex - 1);
                                        historyTransaksi = Arrays.copyOf(historyTransaksi, historyTransaksi.length - 1);
                                    } else {
                                        System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
                                        System.out.println("║"+YELLOW+centerString(98, "Data tidak ditemukan")+RESET);
                                        System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════════════╝");
                                    }

                                    System.out.print("Enter: ");
                                    input.nextLine();   
                                    clearTerminal(); 

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
                                    input.nextLine();
                                    switch (editMenu) {
                                        case 1:
                                            boolean validInputTanggalAwal = false;
                                            boolean validInputTanggalAkhir = false;
                                            do {
                                                try {
                                                    System.out.print("║ ⤷ Masukkan Tanggal Awal (dd-MM-yyyy): ");
                                                    inputanTanggalAwal = input.next();
                                                    startDate = dateFormat.parse(inputanTanggalAwal);
                                                    validInputTanggalAwal = true;
                                                } catch (ParseException | InputMismatchException e) {
                                                    System.out.println("║ Format tanggal tidak valid. Harap masukkan tanggal dengan format dd-MM-yyyy.");
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
                                                    System.out.println("║ Format tanggal tidak valid. Harap masukkan tanggal dengan format dd-MM-yyyy.");
                                                    input.nextLine(); 
                                                }
                                            } while (!validInputTanggalAkhir);
                                        
                                            try {
                                                viewExpeditionHistoryByRange(startDate, endDate);
                                            } catch (Exception e) {
                                                e.printStackTrace();
                                            }
                                            System.out.print("Enter: ");
                                            input.nextLine();   
                                            clearTerminal(); 
                                            break;
                                        case 2:
                                        try {
                                            int tanggalInput;
                                            validInput = false;
                                            while (!validInput) {
                                                System.out.print("║ ⤷ Masukkan Tanggal (dd): ");
                                                if (input.hasNextInt()) {
                                                    tanggalInput = input.nextInt();
                                        
                                                    if (tanggalInput < 1 || tanggalInput > 31) {
                                                        System.out.println("║ Tanggal tidak valid.");
                                                    } else {
                                                        validInput = true;
                                                        Calendar cal = Calendar.getInstance();
                                                        int bulanSekarang = cal.get(Calendar.MONTH) + 1; // Bulan dimulai dari 0
                                                        int tahunSekarang = cal.get(Calendar.YEAR);
                                        
                                                        String tanggalYangDiinginkan = String.format("%02d-%02d-%d", tanggalInput, bulanSekarang, tahunSekarang);
                                                        Date startDate = dateFormat.parse(tanggalYangDiinginkan);
                                                        Date endDate = dateFormat.parse(tanggalYangDiinginkan);
                                        
                                                        viewExpeditionHistoryByDay(startDate, endDate);
                                                    }
                                                } else {
                                                    System.out.println("║ Input harus berupa angka.");
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
                                                validInput = false;
                                                while (true) {
                                                    System.out.print("║ ⤷ Masukkan Bulan (MM): ");
                                                    if (input.hasNextInt()) {
                                                        bulanInput = input.nextInt();
                                                        if (bulanInput >= 1 && bulanInput <= 12) {
                                                            break; // Keluar dari loop saat input valid
                                                        } else {
                                                            System.out.println("║ Bulan tidak valid. Masukkan angka antara 1 sampai 12.");
                                                        }
                                                    } else {
                                                        System.out.println("║ Masukkan angka antara 1 sampai 12.");
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
                                    
                                                viewExpeditionHistoryByMonth(startDate, endDate);
                                            } catch (Exception e) {
                                                e.printStackTrace();
                                            }
                                            break;
                                        case 4:
                                            try {
                                                int tahunInput = 0;
                                    
                                                validInput = false;
                                                while (!validInput) {
                                                    System.out.print("║ ⤷ Masukkan Tahun: ");
                                    
                                                    if (input.hasNextInt()) {
                                                        tahunInput = input.nextInt();
                                                        input.nextLine();
                                    
                                                        if (tahunInput >= 1900 && tahunInput <= 3000) {
                                                            validInput = true;
                                                        } else {
                                                            System.out.println("║ Tahun tidak valid. Harap masukkan tahun antara 1900 dan 3000.");
                                                        }
                                                    } else {
                                                        System.out.println("║ Input bukan angka. Silakan masukkan tahun antara 1900 dan 3000.");
                                                        input.next(); 
                                                    }
                                                }
                                    
                                                viewExpeditionHistoryByYear(tahunInput);
                                    
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
                                                System.out.print("║ ⤷ Masukkan nomor resi: ");
                                                searchString = input.nextLine();
                                                try {
                                                    searchString = input.nextLine();
                                                    validInput = true;

                                                    for (int i=0; i<historyTransaksi.length; i++) {
                                                        if (historyTransaksi[i][0].equals(searchString)) {
                                                            viewExpeditionHistoryByTrackingNumber(searchString);
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

                            displayHeader();
                            displayIndonesianMap();

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
                                        System.out.print("║ ⤷ Origin: ");
                                        origin = input.nextLine();
                                        System.out.print("║ ⤷ Destination: ");
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

                                        System.out.print("║ ⤷ Masukkan Jarak antara "+origin+" dan "+destination+": ");
                                        String jarak = input.next();

                                        rutePengiriman = Arrays.copyOf(rutePengiriman,rutePengiriman.length + 1);
                                        rutePengiriman[rutePengiriman.length-1] = new String[] {
                                            origin,
                                            destination,
                                            jarak};

                                    clearTerminal(); 
                                    break;
                                case 2:
                                    System.out.println("║ Daftar rute yang Tersedia:");
                                    for (int i = 0; i < rutePengiriman.length; i++) {
                                        System.out.println("║ " + (i + 1) + ". " + rutePengiriman[i][0] + ". " + rutePengiriman[i][1] + ". " + rutePengiriman[i][2]);
                                    }
                        
                                    int deleteIndex = 0;
            
                                    while (!validInput) {
                                        System.out.print("║ ⤷ Masukkan nomor rute yang ingin dihapus: ");
                                        try {
                                            deleteIndex = Integer.parseInt(input.nextLine());
                                            validInput = true;
                                        } catch (NumberFormatException e) {
                                            System.out.println("║ Input yang dimasukkan bukan angka. Silakan masukkan nomor.");
                                        }
                                    }

                                    if (deleteIndex >= 1 && deleteIndex <= rutePengiriman.length) {
                                        String deletedLocation = rutePengiriman[deleteIndex - 1][0]+" "+rutePengiriman[deleteIndex - 1][1];
                                        System.out.println("║ " + deletedLocation + " Telah Dihapus!");

                                        System.arraycopy(rutePengiriman, deleteIndex, rutePengiriman, deleteIndex - 1, rutePengiriman.length - deleteIndex);
                                        rutePengiriman = Arrays.copyOf(rutePengiriman, rutePengiriman.length - 1);
                                    } else {
                                        System.out.println("║ Nomor rute tidak valid");
                                        continue;
                                    }

                                    System.out.print("Enter: ");
                                    input.nextLine();   
                                    clearTerminal(); 
                                         
                                    break;
                                case 3:
                                    viewExpeditionRoutes();
                                    System.out.print("Enter: ");
                                    input.nextLine();   
                                    clearTerminal(); 
                                    break;
                                case 4:
                                    keluar = false;
                                    clearTerminal();
                                    break;
                                default:
                                System.out.println("║ Invalid choice. Please try again.");
                                }
                        } break;
                        case 3:
                            displayHeader();
                            displayIndonesianMap();

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

                                        System.out.print("║ ⤷ Masukkan Nama Layanan: ");
                                        namaLayanan = input.next();
                                        while (!inputValid) {
                                            System.out.print("║ ⤷ Masukkan Tarif: ");
                                            if (input.hasNextDouble()) {
                                                tarifLayanan = input.nextDouble();
                                                inputValid = true;
                                            } else {
                                                System.out.println("║ Masukan bukan angka. Mohon masukkan angka.");
                                                input.next();
                                            }
                                        }

                                        System.out.print("║ ⤷ Masukkan Waktu Pengiriman Minimum: ");
                                        startEstimation = input.nextInt();
                                        System.out.print("║ ⤷ Masukkan Waktu Pengiriman Maximum: ");
                                        endEstimation = input.nextInt();

                                        arrayLayanan = Arrays.copyOf(arrayLayanan,arrayLayanan.length + 1);
                                        arrayLayanan[arrayLayanan.length-1] = new String[] {
                                            namaLayanan,
                                            String.valueOf(tarifLayanan),
                                            String.valueOf(startEstimation),
                                            String.valueOf(endEstimation)};

                                    System.out.print("Enter: ");
                                    input.nextLine();   
                                    clearTerminal(); 
                                    break;
                                case 2:
                                System.out.println("║ Daftar Layanan yang Tersedia:");
                                for (int i = 0; i < arrayLayanan.length; i++) {
                                    System.out.println("║ "+(i + 1) + ". " + arrayLayanan[i][0] );
                                }
                        
                                System.out.print("║ ⤷ Masukkan nomor layanan yang ingin diubah: ");
                                int selectedService = 0;

                                while (!inputValid) {
                                    if (input.hasNextInt()) {
                                        selectedService = input.nextInt();
                                        if (selectedService >= 1 && selectedService <= arrayLayanan.length) {
                                            inputValid = true;
                                        } else {
                                            System.out.println("║ Nomor layanan tidak valid. Masukkan nomor layanan yang valid:");
                                            input.nextLine();
                                        }
                                    } else {
                                        System.out.println("║ Input bukan angka. Mohon masukkan nomor layanan yang valid:");
                                        input.next();
                                    }
                                }

                                inputValid = false;

                                if (selectedService >= 1 && selectedService <= arrayLayanan.length) {
                                    System.out.println("║ Pilih yang ingin diubah:");
                                    System.out.println("║ [1]. Nama Layanan");
                                    System.out.println("║ [2]. Tarif Layanan");
                                    System.out.print("║ ⤷ Masukkan nomor pilihan: ");
                                    int changeOption = 0;

                                    while (!inputValid) {
                                        if (input.hasNextInt()) {
                                            changeOption = input.nextInt();
                                            if (changeOption == 1 || changeOption == 2) {
                                                inputValid = true;
                                            } else {
                                                System.out.println("║ Pilihan tidak valid. Masukkan nomor pilihan yang valid:");
                                                input.nextLine();
                                            }
                                        } else {
                                            System.out.println("║ Input bukan angka. Mohon masukkan nomor pilihan yang valid:");
                                            input.next();
                                        }
                                    }

                                    if (changeOption == 1) {
                                        System.out.print("║ ⤷ Masukkan Nama Layanan Baru: ");
                                        input.nextLine();
                                        arrayLayanan[selectedService - 1][0] = input.nextLine();
                                        System.out.println("║ Data nama layanan berhasil diupdate.");
                                    } else if (changeOption == 2) {
                                        double newTarif = 0.0;
                                        inputValid = false;

                                        while (!inputValid) {
                                            System.out.print("║ ⤷ Masukkan Tarif Baru: ");
                                            if (input.hasNextDouble()) {
                                                newTarif = input.nextDouble();
                                                inputValid = true;
                                            } else {
                                                System.out.println("║ Masukan bukan angka. Mohon masukkan angka.");
                                                input.next();
                                            }
                                        }

                                        arrayLayanan[selectedService - 1][1] = String.valueOf(newTarif);
                                        System.out.println("║ Data tarif layanan berhasil diupdate.");

                                        break;
                                    }
                                } else {
                                    System.out.println("║ Nomor layanan tidak valid");
                                }
                                System.out.print("Enter: ");
                                input.nextLine();   
                                clearTerminal(); 
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
                                            System.out.print("║ ⤷Pilih nomor layanan yang ingin dihapus: ");
                                            selectedNumber = input.nextInt();
                                            validInput = true;
                                        } catch (InputMismatchException e) {
                                            System.out.println("║ Masukan bukan angka. Silakan masukkan nomor layanan yang valid.");
                                            input.nextLine();
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
                                    System.out.print("Enter: ");
                                    input.nextLine();   
                                    clearTerminal(); 
                                    break;
                                case 4:
                                    viewExpeditionServices();
                                    System.out.print("Enter: ");
                                    input.nextLine();   
                                    clearTerminal(); 
                                    break;
                                case 5:
                                    isLoop = false;
                                    clearTerminal();
                                    break;
                                default:
                                System.out.println("║ Invalid choice. Please try again.");
                            }
                            break;

                        case 4:
                            do {
                                displayHeader();
                                displayIndonesianMap();

                                System.out.println("║ Pilih bahasa (Choose a language):");
                                System.out.println("║ [1]. English");
                                System.out.println("║ [2]. Indonesian");
                                System.out.print("║ -> Masukkan Pilihan: ");
                                inputselectedLanguage = input.nextInt();
                                changeLanguage(inputselectedLanguage);
                            } while (inputselectedLanguage > languageModule[0].length);
                            clearTerminal();
                            break;
                        case 5:

                            System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
                            System.out.println("║"+YELLOW+centerString(98,"Manajemen Tarif Dasar")+RESET+"║");
                            System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");

                            System.out.println("║ [1]. Tarif Dasar per Kg"); //Tambahan Jenis Layanan
                            System.out.println("║ [2]. Tarif Dasar per Km"); //Merubah Tarif Layanan
                            System.out.println("║ [3]. Keluar"); //Keluar

                            System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
                            System.out.print("║ ⤷ Masukkan Pilihan: ");
                            subMenu = input.nextInt();

                            switch (subMenu) {
                                case 1:
                                    System.out.print("║ ⤷ Masukkan tarif dasar per Kg: ");
                                    tarifPerKg = input.nextInt();
                                    break;
                                case 2:
                                    System.out.print("║ ⤷ Masukkan tarif dasar per Km: ");
                                    tarifPerKm = input.nextInt();
                                    break;
                                case 3:
                                    isLoop = false;
                                    break;
                                default:
                                    break;
                            }
                        default:
                            break; 
                        }

                        if (isAdmin) { 
                            switch (menuUtama) {
                            case 6: 

                            Calendar calendar = Calendar.getInstance();
                            calendar.set(Calendar.DAY_OF_MONTH, 1);
                            Date startDate = calendar.getTime();

                            calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
                            Date endDate = calendar.getTime();

                            System.out.println(String.format(
                                reportFormat,
                                centerString(15, Integer.toString(getExpeditionCount(startDate, endDate))),
                                centerString(15, Integer.toString(getTotalWeight(startDate, endDate))),
                                centerString(15, "Rp "+Double.toString(getRevenue(startDate, endDate)))
                            ));
                            System.out.print("Enter: ");
                            input.nextLine();   
                            clearTerminal(); 
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
                                    boolean inputFound = false;
                                    System.out.print("║ ⤷ Masukkan lokasi gudang: ");
                                    String location  = input.nextLine();

                                            inputFound = true;

                                    while (inputFound) {
                                        int[] columnWidths = calculateColumnWidths(historyTransaksi);
                                        String formattedHeader = String.format("║ %3s ║ %-" + columnWidths[0] + "s ║ %-" + columnWidths[2] + "s ║ %-" + columnWidths[5] + "s ║ %-" + columnWidths[4] + "s ║ %-" + columnWidths[10] + "s ║ %-" + columnWidths[8] + "s ║ %-" + columnWidths[9] + "s ║ %-" + columnWidths[13] + "s ║ %-" + columnWidths[12] + "s",
                                            "No", 
                                            "No Resi", 
                                            "Pengirim",
                                            "Layanan",
                                            "Tujuan",
                                            "Berat",
                                            "Penerima",
                                            "Alamat Penerima",
                                            "Origin",
                                            "Status"
                                        );

                                        System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣");
                                        System.out.println(formattedHeader);
                                        System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣");

                                        for (int i = 0; i < historyTransaksi.length; i++) {
                                            if (historyTransaksi[i][13].equalsIgnoreCase(location) && historyTransaksi[i][12].equalsIgnoreCase("Waiting for pickup") ||
                                                historyTransaksi[i][4].equalsIgnoreCase(location) && historyTransaksi[i][12].equalsIgnoreCase("Arrived at warehouse")) {
                                                System.out.println(String.format("║ %3s ║ %-" + columnWidths[0] + "s ║ %-" + columnWidths[2] + "s ║ %-" + columnWidths[5] + "s ║ %-" + columnWidths[4] + "s ║ %-" + columnWidths[10] + "s ║ %-" + columnWidths[8] + "s ║ %-" + columnWidths[9] + "s ║ %-" + columnWidths[13] + "s ║ %-" + columnWidths[12] + "s",
                                                    i,
                                                    historyTransaksi[i][0], // Nomor Resi
                                                    historyTransaksi[i][2], // Nama Pengirim
                                                    historyTransaksi[i][5],  //Jenis Layanan
                                                    historyTransaksi[i][4], // Tujuan
                                                    historyTransaksi[i][10], // Berat
                                                    historyTransaksi[i][8], // Nama Penerima
                                                    historyTransaksi[i][9], // Alamat
                                                    historyTransaksi[i][13], // Origin
                                                    historyTransaksi[i][12]
                                                ));
                                            }
                                        }
                                        break;
                                    }
                                    System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣");
                                    System.out.print("Tekan ⏎ Enter untuk melanjutkan ");
                                    input.nextLine();   
                                    clearTerminal(); 
                                    break;
                                case 2:
                                            inputFound = false;
                                            boolean shipmentFound = false;
                                            int searchIndex = 0;
                                            for (int k = 0; k < shipmentDetails.length; k++) {
                                                if (shipmentDetails[k][1].equalsIgnoreCase(loggedInUsername) && shipmentDetails[k][2].equalsIgnoreCase("Sending")) {
                                                    shipmentFound = true;
                                                }
                                            }
                                                                

                                            while (shipmentFound) {
                                                int[] columnWidths = calculateColumnWidths(historyTransaksi);
                                                String formattedHeader = String.format("║ %3s ║ %-" + columnWidths[0] + "s ║ %-" + columnWidths[2] + "s ║ %-" + columnWidths[5] + "s ║ %-" + columnWidths[4] + "s ║ %-" + columnWidths[10] + "s ║ %-" + columnWidths[8] + "s ║ %-" + columnWidths[9] + "s ║ %-" + columnWidths[13] + "s ║ %-" + columnWidths[12] + "s",
                                                    "No", 
                                                    "No Resi", 
                                                    "Pengirim",
                                                    "Layanan",
                                                    "Tujuan",
                                                    "Berat",
                                                    "Penerima",
                                                    "Alamat Penerima",
                                                    "Origin",
                                                    "Status"
                                                );
                                                System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣");
                                                System.out.println(centerString(98, "Driver: " +loggedInUsername));
                                                System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣");
                                                for (int k = 0; k < shipmentDetails.length; k++) {
                                                    if (shipmentDetails[k][1].equalsIgnoreCase(loggedInUsername) && shipmentDetails[k][2].equalsIgnoreCase("Sending")) {
                                                        for (int i = 0; i < historyTransaksi.length; i++) {
                                                            if(historyTransaksi[i][0].equals(shipmentDetails[k][0])) {
                                                                System.out.println(String.format("║ %3s ║ %-" + columnWidths[0] + "s ║ %-" + columnWidths[2] + "s ║ %-" + columnWidths[5] + "s ║ %-" + columnWidths[4] + "s ║ %-" + columnWidths[10] + "s ║ %-" + columnWidths[8] + "s ║ %-" + columnWidths[9] + "s ║ %-" + columnWidths[13] + "s ║ %-" + columnWidths[12] + "s",
                                                                    i,
                                                                    historyTransaksi[i][0], // Nomor Resi
                                                                    historyTransaksi[i][2], // Nama Pengirim
                                                                    historyTransaksi[i][5],  //Jenis Layanan
                                                                    historyTransaksi[i][4], // Tujuan
                                                                    historyTransaksi[i][10], // Berat
                                                                    historyTransaksi[i][8], // Nama Penerima
                                                                    historyTransaksi[i][9], // Alamat
                                                                    historyTransaksi[i][13], // Origin
                                                                    historyTransaksi[i][12]
                                                                ));
                                                            }
                                                        }
                                                    }
                                                }

                                                System.out.print("╠ Apakah anda ingin mengubah status pengiriman menjadi selesai? (Y/N): " );
                                                String driverChoice = input.nextLine();
                                                if (driverChoice.equalsIgnoreCase("Y")) {
                                                    for (int k = 0; k < shipmentDetails.length; k++) {
                                                        if (shipmentDetails[k][1].equalsIgnoreCase(loggedInUsername) && shipmentDetails[k][2].equalsIgnoreCase("Sending")) {
                                                            shipmentDetails[k][2] = "Done";

                                                            for (int i = 0; i < historyTransaksi.length; i++) {
                                                                if(historyTransaksi[i][0].equals(shipmentDetails[k][0])) {
                                                                    historyTransaksi[i][12] = "Arrived at warehouse";
                                                                }
                                                            }

                                                            shipmentFound = true;
                                                        }
                                                    }
                                                    break;
                                                } else {
                                                    break;
                                                }
                                            }

                                            while (!shipmentFound) {
                                                System.out.print("║ ⤷ Masukkan lokasi gudang: ");
                                                location  = input.nextLine();

                                                for (int i = 0; i < rutePengiriman.length; i++) {
                                                    if ((rutePengiriman[i][0].equalsIgnoreCase(location) || rutePengiriman[i][1].equalsIgnoreCase(location))) {
                                                        inputFound = true;
                                                    } 
                                                }

                                                while (inputFound) {
                                                    int[] columnWidths = calculateColumnWidths(historyTransaksi);
                                                    String formattedHeader = String.format("║ %3s ║ %-" + columnWidths[0] + "s ║ %-" + columnWidths[2] + "s ║ %-" + columnWidths[5] + "s ║ %-" + columnWidths[4] + "s ║ %-" + columnWidths[10] + "s ║ %-" + columnWidths[8] + "s ║ %-" + columnWidths[9] + "s ║ %-" + columnWidths[13] + "s ║ %-" + columnWidths[12] + "s",
                                                        "No", 
                                                        "No Resi", 
                                                        "Pengirim",
                                                        "Layanan",
                                                        "Tujuan",
                                                        "Berat",
                                                        "Penerima",
                                                        "Alamat Penerima",
                                                        "Origin",
                                                        "Status"
                                                    );

                                                    System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣");
                                                    System.out.println(formattedHeader);
                                                    System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣");

                                                    for (int i = 0; i < historyTransaksi.length; i++) {
                                                        if (historyTransaksi[i][13].equalsIgnoreCase(location) && historyTransaksi[i][12].equalsIgnoreCase("Waiting for pickup")) {
                                                            System.out.println(String.format("║ %3s ║ %-" + columnWidths[0] + "s ║ %-" + columnWidths[2] + "s ║ %-" + columnWidths[5] + "s ║ %-" + columnWidths[4] + "s ║ %-" + columnWidths[10] + "s ║ %-" + columnWidths[8] + "s ║ %-" + columnWidths[9] + "s ║ %-" + columnWidths[13] + "s ║ %-" + columnWidths[12] + "s",
                                                                i,
                                                                historyTransaksi[i][0], // Nomor Resi
                                                                historyTransaksi[i][2], // Nama Pengirim
                                                                historyTransaksi[i][5],  //Jenis Layanan
                                                                historyTransaksi[i][4], // Tujuan
                                                                historyTransaksi[i][10], // Berat
                                                                historyTransaksi[i][8], // Nama Penerima
                                                                historyTransaksi[i][9], // Alamat
                                                                historyTransaksi[i][13], // Origin
                                                                historyTransaksi[i][12]
                                                            ));
                                                            searchIndex++;
                                                        }
                                                    }


                                                    if (searchIndex != 0){
                                                        int indexKirim;
                                                        System.out.print("║ ⤷ Masukkan index: ");
                                                        indexKirim = input.nextInt();

                                                        boolean adaKesamaanData = false;           
                                                        for (int i = 0; i < historyTransaksi.length; i++) {
                                                            if (i != indexKirim && historyTransaksi[i][12].equals("Waiting for pickup" ) && 
                                                                    historyTransaksi[i][4].equals(historyTransaksi[indexKirim][4]) && 
                                                                    historyTransaksi[i][5].equals(historyTransaksi[indexKirim][5]) && 
                                                                    historyTransaksi[i][0] != historyTransaksi[indexKirim][0] &&
                                                                    historyTransaksi[i][13].equals(historyTransaksi[indexKirim][13])) {
                                                                    adaKesamaanData = true;
                                                            }
                                                        }

                                                        if (adaKesamaanData){
                                                            System.out.println("║ ⤷ Terdapat beberapa barang yang dapat dikirim bersama dengan paket ini!");
                                                            for (int i = 0; i < historyTransaksi.length; i++) {
                                                                if (historyTransaksi[i][12].equals("Waiting for pickup" ) && 
                                                                        historyTransaksi[i][4].equals(historyTransaksi[indexKirim][4]) && 
                                                                        historyTransaksi[i][5].equals(historyTransaksi[indexKirim][5]) && 
                                                                        historyTransaksi[i][0] != historyTransaksi[indexKirim][0] &&
                                                                        historyTransaksi[i][13].equals(historyTransaksi[indexKirim][13])) {
                                                                        historyTransaksi[i][12] = "Sending to destination";
                                                                        historyTransaksi[indexKirim][12] = "Sending to destination";

                                                                        shipmentDetails = Arrays.copyOf(shipmentDetails,shipmentDetails.length + 1);
                                                                        shipmentDetails[shipmentDetails.length-1] = new String[] {
                                                                            historyTransaksi[i][0],
                                                                            loggedInUsername,
                                                                            "Sending"};

                                                                        shipmentDetails = Arrays.copyOf(shipmentDetails,shipmentDetails.length + 1);
                                                                        shipmentDetails[shipmentDetails.length-1] = new String[] {
                                                                            historyTransaksi[indexKirim][0],
                                                                            loggedInUsername,
                                                                            "Sending"};

                                                                                }
                                                                }
                                                            System.out.println("║ ⤷ Status pengiriman telah diubah!");
                                                            System.out.println(shipmentDetails);
                                                        } else {
                                                            System.out.println("║ ⤷ Fitur apaan dah ini, kodenya panjang banget");
                                                        }

                                                        
                                                    }
                                                    break;
                                                }
                                                break;
                                            }
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
                             
                        // SWITCHCASE KURIR
                        } else if (isKurir) {
                            switch (menuUtama) {
                                case 1:
                                    displayHeader();
                                    displayIndonesianMap();

                                    System.out.println("║"+YELLOW+centerString(98,"Pengiriman Barang")+RESET+"║");
                                    System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
                                    System.out.println("║                                                                                                  ║");
                                    System.out.println("║             ╭──────────────────────────────────────────────────────────────────────╮             ║");
                                    System.out.println("║             │                                                                      │             ║");
                                    System.out.println("║             │                                                                      │             ║");
                                    System.out.println("║             │                     [1]. Inventori Gudang                            │             ║");
                                    System.out.println("║             │                                                                      │             ║");
                                    System.out.println("║             │                     [2]. Kirim Paket                                 │             ║");
                                    System.out.println("║             │                                                                      │             ║");
                                    System.out.println("║             │                     [3]. Antar Paket                                 │             ║");
                                    System.out.println("║             │                                                                      │             ║");
                                    System.out.println("║             │                     [4]. Keluar                                      │             ║");
                                    System.out.println("║             │                                                                      │             ║");
                                    System.out.println("║             │                                                                      │             ║"); 
                                    System.out.println("║             ╰──────────────────────────────────────────────────────────────────────╯             ║");
                                    System.out.println("║                                                                                                  ║"); 
                                    System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
                                    System.out.print("║ ⤷ Masukkan Pilihan: ");
                                    subMenu = input.nextInt();
                                    input.nextLine();

                                    switch (subMenu) {
                                        case 1:
                                            boolean inputFound = false;
                                            System.out.print("║ ⤷ Masukkan lokasi gudang: ");
                                            String location  = input.nextLine();

                                                    inputFound = true;

                                            while (inputFound) {
                                                int[] columnWidths = calculateColumnWidths(historyTransaksi);
                                                String formattedHeader = String.format("║ %3s ║ %-" + columnWidths[0] + "s ║ %-" + columnWidths[2] + "s ║ %-" + columnWidths[5] + "s ║ %-" + columnWidths[4] + "s ║ %-" + columnWidths[10] + "s ║ %-" + columnWidths[8] + "s ║ %-" + columnWidths[9] + "s ║ %-" + columnWidths[13] + "s ║ %-" + columnWidths[12] + "s",
                                                    "No", 
                                                    "No Resi", 
                                                    "Pengirim",
                                                    "Layanan",
                                                    "Tujuan",
                                                    "Berat",
                                                    "Penerima",
                                                    "Alamat Penerima",
                                                    "Origin",
                                                    "Status"
                                                );

                                                System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣");
                                                System.out.println(formattedHeader);
                                                System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣");

                                                for (int i = 0; i < historyTransaksi.length; i++) {
                                                    if (historyTransaksi[i][13].equalsIgnoreCase(location) && historyTransaksi[i][12].equalsIgnoreCase("Waiting for pickup") ||
                                                        historyTransaksi[i][4].equalsIgnoreCase(location) && historyTransaksi[i][12].equalsIgnoreCase("Arrived at warehouse")) {
                                                        System.out.println(String.format("║ %3s ║ %-" + columnWidths[0] + "s ║ %-" + columnWidths[2] + "s ║ %-" + columnWidths[5] + "s ║ %-" + columnWidths[4] + "s ║ %-" + columnWidths[10] + "s ║ %-" + columnWidths[8] + "s ║ %-" + columnWidths[9] + "s ║ %-" + columnWidths[13] + "s ║ %-" + columnWidths[12] + "s",
                                                            i,
                                                            historyTransaksi[i][0], // Nomor Resi
                                                            historyTransaksi[i][2], // Nama Pengirim
                                                            historyTransaksi[i][5],  //Jenis Layanan
                                                            historyTransaksi[i][4], // Tujuan
                                                            historyTransaksi[i][10], // Berat
                                                            historyTransaksi[i][8], // Nama Penerima
                                                            historyTransaksi[i][9], // Alamat
                                                            historyTransaksi[i][13], // Origin
                                                            historyTransaksi[i][12]
                                                        ));
                                                    }
                                                }
                                                break;
                                            }
                                            System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣");
                                            System.out.print("Tekan ⏎ Enter untuk melanjutkan ");
                                            input.nextLine();   
                                            clearTerminal(); 
                                            break;
                                        case 2:
                                            inputFound = false;
                                            boolean shipmentFound = false;
                                            int searchIndex = 0;
                                            for (int k = 0; k < shipmentDetails.length; k++) {
                                                if (shipmentDetails[k][1].equalsIgnoreCase(loggedInUsername) && shipmentDetails[k][2].equalsIgnoreCase("Sending")) {
                                                    shipmentFound = true;
                                                }
                                            }
                                                                


            } while(!exit);
        }
    }



                                            while (!shipmentFound) {
                                                System.out.print("║ ⤷ Masukkan lokasi gudang: ");
                                                location  = input.nextLine();

                                                    if (searchIndex != 0){
                                                        int indexKirim;
                                                        System.out.print("║ ⤷ Masukkan index: ");
                                                        indexKirim = input.nextInt();

                                                        boolean adaKesamaanData = false;           
                                                        for (int i = 0; i < historyTransaksi.length; i++) {
                                                            if (i != indexKirim && historyTransaksi[i][12].equals("Waiting for pickup" ) && 
                                                                    historyTransaksi[i][4].equals(historyTransaksi[indexKirim][4]) && 
                                                                    historyTransaksi[i][5].equals(historyTransaksi[indexKirim][5]) && 
                                                                    historyTransaksi[i][0] != historyTransaksi[indexKirim][0] &&
                                                                    historyTransaksi[i][13].equals(historyTransaksi[indexKirim][13])) {
                                                                    adaKesamaanData = true;
                                                            }
                                                        }

                                                        if (adaKesamaanData){
                                                            System.out.println("║ ⤷ Terdapat beberapa barang yang dapat dikirim bersama dengan paket ini!");
                                                            for (int i = 0; i < historyTransaksi.length; i++) {
                                                                if (historyTransaksi[i][12].equals("Waiting for pickup" ) && 
                                                                        historyTransaksi[i][4].equals(historyTransaksi[indexKirim][4]) && 
                                                                        historyTransaksi[i][5].equals(historyTransaksi[indexKirim][5]) && 
                                                                        historyTransaksi[i][0] != historyTransaksi[indexKirim][0] &&
                                                                        historyTransaksi[i][13].equals(historyTransaksi[indexKirim][13])) {
                                                                        historyTransaksi[i][12] = "Sending to destination";
                                                                        historyTransaksi[indexKirim][12] = "Sending to destination";

                                                                        shipmentDetails = Arrays.copyOf(shipmentDetails,shipmentDetails.length + 1);
                                                                        shipmentDetails[shipmentDetails.length-1] = new String[] {
                                                                            historyTransaksi[i][0],
                                                                            loggedInUsername,
                                                                            "Sending"};

                                                                        shipmentDetails = Arrays.copyOf(shipmentDetails,shipmentDetails.length + 1);
                                                                        shipmentDetails[shipmentDetails.length-1] = new String[] {
                                                                            historyTransaksi[indexKirim][0],
                                                                            loggedInUsername,
                                                                            "Sending"};

                                                                                }
                                                                }
                                                            System.out.println("║ ⤷ Status pengiriman telah diubah!");
                                                            System.out.println(shipmentDetails);
                                                        } else {
                                                            System.out.println("║ ⤷ Fitur apaan dah ini, kodenya panjang banget");
                                                        }




    private static int[] calculateColumnWidths(String[][] array) {
        int[] columnWidths = new int[array[0].length];
    
        for (int j = 0; j < array[0].length; j++) {
            int maxWidth = 0;
            for (int i = 0; i < array.length; i++) {
                if (maxWidth < array[i][j].length()) {
                    maxWidth = array[i][j].length();
                }
            }
            columnWidths[j] = maxWidth + 4;
        }
    
        return columnWidths;
    }

    private static String centerString(int width, String s) {
        int padSize = (width - s.length()) / 2;
        return String.format("%" + padSize + "s%s%" + (padSize + (width - s.length()) % 2) + "s", "", s, "");
    }

    private static String generateTrackingNumber() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyyHHmmss");
        String timestamp = dateFormat.format(new Date());
        return timestamp;
    }

    private static void changeLanguage(int languageIndex) {
        selectedLanguage = languageIndex - 1; 
    }

    private static String getLanguageModuleText(int row) {
        return languageModule[row][selectedLanguage];
    }

    private static void loginValidation(String username, String password) {
        for (int i = 0; i < userData.length ; i++ ) {
            if (userData[i][0].equals(username) && userData[i][1].equals(password)) {
                login = true;
                masuk = true;
                loggedInUsername = username;
                
                if("ADMIN".equals(userData[i][2])){
                    isAdmin = true;
                }
                break;
            }
        }
    }

    private static void viewUserAccounts() {
        int[] columnWidths = calculateColumnWidths(rutePengiriman);
        String formattedHeader = String.format("║ %-" + columnWidths[0] + "s ║ %-" + columnWidths[1] + "s ║ %-" + columnWidths[2] + "s",
            "Username", 
            "Password", 
            "Role" 
        );
        System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
        System.out.println("║"+centerString(98,"Manajemen Pengguna")+"║");
        System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
        System.out.println(formattedHeader);
        System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");

        for (int i = 0; i < userData.length; i++) {
            System.out.printf("║ %-" + columnWidths[0] + "s ║ %-" + columnWidths[1] + "s ║ %-" + columnWidths[2] + "s\n", userData[i][0], userData[i][1], userData[i][2]);
        }
    }

    private static void viewExpeditionRoutes() {
        int[] columnWidths = calculateColumnWidths(rutePengiriman);
        String formattedHeader = String.format("║ %3s ║ %-" + columnWidths[0] + "s ║ %-" + columnWidths[1] + "s ║ %-" + columnWidths[2] + "s",
            "No", 
            "Nama Kota", 
            "Nama Kota",
            "Jarak" 
        );
        System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
        System.out.println("║"+centerString(98,"Data Rute")+"║");
        System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
        System.out.println(formattedHeader);
        System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
        for (int i = 0; i < rutePengiriman.length; i++) {
            String formattedString = String.format("║ %3d ║ %-" + columnWidths[0] + "s ║ %-" + columnWidths[1] + "s ║ %-" + columnWidths[2] + "s Km",
                    i,
                    rutePengiriman[i][0], 
                    rutePengiriman[i][1], 
                    rutePengiriman[i][2] 
            );
            System.out.println(formattedString);
        }
    } 
    
    private static void viewExpeditionServices() {
        int[] columnWidths = calculateColumnWidths(rutePengiriman);
        String formattedHeader = String.format("║ %3s ║ %-" + columnWidths[0] + "s ║ %-" + columnWidths[1] + "s",
            "No", 
            "Layanan", 
            "Biaya" 
        );
        System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
        System.out.println("║"+centerString(98,"Data Layanan")+"║");
        System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
        System.out.println(formattedHeader);
        System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
        for (int i = 0; i < arrayLayanan.length; i++) {
            if (arrayLayanan[i] != null) {
                    String formattedString = String.format("║ %3s ║ %-" + columnWidths[0] + "s ║ %-" + columnWidths[1] + "s",
                    i,
                    arrayLayanan[i][0], // Nama Kota
                    arrayLayanan[i][1] // Tarif
            );
            System.out.println(formattedString);
            }
        }
    } 

    private static void viewExpeditionHistoryByTrackingNumber(String resi){
        int[] columnWidths = calculateColumnWidths(historyTransaksi);
        String formattedHeader = String.format("║ %3s ║ %-" + columnWidths[0] + "s ║ %-" + columnWidths[1] + "s ║ %-" + columnWidths[2] + "s ║ %-" + columnWidths[3] + "s ║ %-" + columnWidths[5] + "s ║ %-" + columnWidths[4] + "s ║ %-" + columnWidths[10] + "s ║ %-" + columnWidths[11] + "s ║ %-" + columnWidths[6] + "s ║ %-" + columnWidths[7] + "s ║ %-" + columnWidths[8] + "s ║ %-" + columnWidths[9] + "s ║ %-" + columnWidths[10] + "s",
            "No", 
            "No Resi", 
            "Tanggal",
            "Pengirim",
            "Kontak",
            "Layanan",
            "Tujuan",
            "Berat",
            "Deskripsi",
            "Biaya",
            "Kasir",
            "Penerima",
            "Alamat Penerima",
            "Status Pengiriman"
        );
        System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣"); 
        System.out.println("║                                                                                       History Transaksi");
        System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣"); 
        System.out.println(formattedHeader);
        System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣");              
        for (int i = 0; i < historyTransaksi.length; i++) {
            if (historyTransaksi[i][0].equals(resi)) {
                System.out.println(String.format("║ %3s ║ %-" + columnWidths[0] + "s ║ %-" + columnWidths[1] + "s ║ %-" + columnWidths[2] + "s ║ %-" + columnWidths[3] + "s ║ %-" + columnWidths[5] + "s ║ %-" + columnWidths[4] + "s ║ %-" + columnWidths[10] + "s ║ %-" + columnWidths[11] + "s ║ %-" + columnWidths[6] + "s ║ %-" + columnWidths[7] + "s ║ %-" + columnWidths[8] + "s ║ %-" + columnWidths[9] + "s ║ %-" + columnWidths[10] + "s",
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
                    historyTransaksi[i][9], // Alamat
                    historyTransaksi[i][12]
                ));
            }
        }
        System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣"); 
    }

    private static void viewExpeditionHistoryByRange(Date startDate, Date endDate){
        int[] columnWidths = calculateColumnWidths(historyTransaksi);
        String formattedHeader = String.format("║ %3s ║ %-" + columnWidths[0] + "s ║ %-" + columnWidths[1] + "s ║ %-" + columnWidths[2] + "s ║ %-" + columnWidths[3] + "s ║ %-" + columnWidths[5] + "s ║ %-" + columnWidths[4] + "s ║ %-" + columnWidths[10] + "s ║ %-" + columnWidths[11] + "s ║ %-" + columnWidths[6] + "s ║ %-" + columnWidths[7] + "s ║ %-" + columnWidths[8] + "s ║ %-" + columnWidths[9] + "s ║ %-" + columnWidths[10] + "s",
            "No", 
            "No Resi", 
            "Tanggal",
            "Pengirim",
            "Kontak",
            "Layanan",
            "Tujuan",
            "Berat",
            "Deskripsi",
            "Biaya",
            "Kasir",
            "Penerima",
            "Alamat Penerima",
            "Status Pengiriman"
        );
        try{
            System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣"); 
            System.out.println("║                                                                                       History Transaksi");
            System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣"); 
            System.out.println(formattedHeader);
            System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣");              
            for (int i = 0; i < historyTransaksi.length; i++) {
                if (historyTransaksi[i][0] != null){
                    Date transaksiDate = dateFormat.parse(historyTransaksi[i][1]);
                    if (transaksiDate.compareTo(startDate) >= 0 && transaksiDate.compareTo(endDate) <= 0) {
                        System.out.println(String.format("║ %3s ║ %-" + columnWidths[0] + "s ║ %-" + columnWidths[1] + "s ║ %-" + columnWidths[2] + "s ║ %-" + columnWidths[3] + "s ║ %-" + columnWidths[5] + "s ║ %-" + columnWidths[4] + "s ║ %-" + columnWidths[10] + "s ║ %-" + columnWidths[11] + "s ║ %-" + columnWidths[6] + "s ║ %-" + columnWidths[7] + "s ║ %-" + columnWidths[8] + "s ║ %-" + columnWidths[9] + "s ║ %-" + columnWidths[10] + "s",
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
                            historyTransaksi[i][9], // Alamat
                            historyTransaksi[i][12]
                        ));
                    }
                }
            }
            System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣"); 
        }catch (ParseException e){
            e.printStackTrace();
        }
    }

    private static void viewExpeditionHistoryByDay(Date startDate, Date endDate) {
        int[] columnWidths = calculateColumnWidths(historyTransaksi);
        String formattedHeader = String.format("║ %3s ║ %-" + columnWidths[0] + "s ║ %-" + columnWidths[1] + "s ║ %-" + columnWidths[2] + "s ║ %-" + columnWidths[3] + "s ║ %-" + columnWidths[5] + "s ║ %-" + columnWidths[4] + "s ║ %-" + columnWidths[10] + "s ║ %-" + columnWidths[11] + "s ║ %-" + columnWidths[6] + "s ║ %-" + columnWidths[7] + "s ║ %-" + columnWidths[8] + "s ║ %-" + columnWidths[9] + "s ║ %-" + columnWidths[10] + "s",
            "No", 
            "No Resi", 
            "Tanggal",
            "Pengirim",
            "Kontak",
            "Layanan",
            "Tujuan",
            "Berat",
            "Deskripsi",
            "Biaya",
            "Kasir",
            "Penerima",
            "Alamat Penerima",
            "Status Pengiriman"
        );
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        boolean dataDitemukan = false;

        System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣"); 
        System.out.println("║                                                                                       History Transaksi");
        System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣"); 
        System.out.println(formattedHeader);
        System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣");  

        for (int i = 0; i < historyTransaksi.length; i++) {
            try {
                Date transaksiDate = dateFormat.parse(historyTransaksi[i][1]);
                Calendar cal = Calendar.getInstance();
                int bulanSekarang = cal.get(Calendar.MONTH) + 1; // Bulan dimulai dari 0
                int tahunSekarang = cal.get(Calendar.YEAR);

                if (transaksiDate.compareTo(startDate) >= 0 && transaksiDate.compareTo(endDate) <= 0
                        && dateFormat.format(transaksiDate).startsWith(String.format("%02d-%02d", startDate.getDate(), bulanSekarang))) {
                        System.out.println(String.format("║ %3s ║ %-" + columnWidths[0] + "s ║ %-" + columnWidths[1] + "s ║ %-" + columnWidths[2] + "s ║ %-" + columnWidths[3] + "s ║ %-" + columnWidths[5] + "s ║ %-" + columnWidths[4] + "s ║ %-" + columnWidths[10] + "s ║ %-" + columnWidths[11] + "s ║ %-" + columnWidths[6] + "s ║ %-" + columnWidths[7] + "s ║ %-" + columnWidths[8] + "s ║ %-" + columnWidths[9] + "s ║ %-" + columnWidths[10] + "s",
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
                            historyTransaksi[i][9], // Alamat
                            historyTransaksi[i][12]
                        ));
                    dataDitemukan = true;
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣"); 


        if (!dataDitemukan) {
            System.out.println("Tidak ada transaksi pada rentang tanggal tersebut atau yang sesuai dengan bulan dan tahun ini.");
        }
    }

    private static void viewExpeditionHistoryByMonth(Date startDate, Date endDate) {
        int[] columnWidths = calculateColumnWidths(historyTransaksi);
        String formattedHeader = String.format("║ %3s ║ %-" + columnWidths[0] + "s ║ %-" + columnWidths[1] + "s ║ %-" + columnWidths[2] + "s ║ %-" + columnWidths[3] + "s ║ %-" + columnWidths[5] + "s ║ %-" + columnWidths[4] + "s ║ %-" + columnWidths[10] + "s ║ %-" + columnWidths[11] + "s ║ %-" + columnWidths[6] + "s ║ %-" + columnWidths[7] + "s ║ %-" + columnWidths[8] + "s ║ %-" + columnWidths[9] + "s ║ %-" + columnWidths[10] + "s",
            "No", 
            "No Resi", 
            "Tanggal",
            "Pengirim",
            "Kontak",
            "Layanan",
            "Tujuan",
            "Berat",
            "Deskripsi",
            "Biaya",
            "Kasir",
            "Penerima",
            "Alamat Penerima",
            "Status Pengiriman"
        );
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        boolean dataDitemukan = false;

        System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣"); 
        System.out.println("║                                                                                       History Transaksi");
        System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣"); 
        System.out.println(formattedHeader);
        System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣");  

        for (int i = 0; i < historyTransaksi.length; i++) {
            try {
                Date transaksiDate = dateFormat.parse(historyTransaksi[i][1]);

                Calendar cal = Calendar.getInstance();
                cal.setTime(transaksiDate);
                int transaksiBulan = cal.get(Calendar.MONTH) + 1; // Bulan dimulai dari 0
                int transaksiTahun = cal.get(Calendar.YEAR);

                if (transaksiDate.compareTo(startDate) >= 0 && transaksiDate.compareTo(endDate) <= 0
                        && transaksiBulan == startDate.getMonth() + 1 && transaksiTahun == startDate.getYear() + 1900) {
                        System.out.println(String.format("║ %3s ║ %-" + columnWidths[0] + "s ║ %-" + columnWidths[1] + "s ║ %-" + columnWidths[2] + "s ║ %-" + columnWidths[3] + "s ║ %-" + columnWidths[5] + "s ║ %-" + columnWidths[4] + "s ║ %-" + columnWidths[10] + "s ║ %-" + columnWidths[11] + "s ║ %-" + columnWidths[6] + "s ║ %-" + columnWidths[7] + "s ║ %-" + columnWidths[8] + "s ║ %-" + columnWidths[9] + "s ║ %-" + columnWidths[10] + "s",
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
                            historyTransaksi[i][9], // Alamat
                            historyTransaksi[i][12]
                        ));
                    dataDitemukan = true;
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣"); 

        if (!dataDitemukan) {
            System.out.println("Tidak ada transaksi pada rentang tanggal tersebut atau yang sesuai dengan bulan dan tahun ini.");
        }

    }

    private static void viewExpeditionHistoryByYear(int tahunInput) {
        int[] columnWidths = calculateColumnWidths(historyTransaksi);
        String formattedHeader = String.format("║ %3s ║ %-" + columnWidths[0] + "s ║ %-" + columnWidths[1] + "s ║ %-" + columnWidths[2] + "s ║ %-" + columnWidths[3] + "s ║ %-" + columnWidths[5] + "s ║ %-" + columnWidths[4] + "s ║ %-" + columnWidths[10] + "s ║ %-" + columnWidths[11] + "s ║ %-" + columnWidths[6] + "s ║ %-" + columnWidths[7] + "s ║ %-" + columnWidths[8] + "s ║ %-" + columnWidths[9] + "s ║ %-" + columnWidths[10] + "s",
            "No", 
            "No Resi", 
            "Tanggal",
            "Pengirim",
            "Kontak",
            "Layanan",
            "Tujuan",
            "Berat",
            "Deskripsi",
            "Biaya",
            "Kasir",
            "Penerima",
            "Alamat Penerima",
            "Status Pengiriman"
        );
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        boolean dataDitemukan = false;

        System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣"); 
        System.out.println("║                                                                                       History Transaksi");
        System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣"); 
        System.out.println(formattedHeader);
        System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣");  

        for (int i = 0; i < historyTransaksi.length; i++) {
            try {
                Date transaksiDate = dateFormat.parse(historyTransaksi[i][1]);
                Calendar cal = Calendar.getInstance();
                cal.setTime(transaksiDate);
                int tahunTransaksi = cal.get(Calendar.YEAR);

                if (tahunTransaksi == tahunInput) {
                    System.out.println(String.format("║ %3s ║ %-" + columnWidths[0] + "s ║ %-" + columnWidths[1] + "s ║ %-" + columnWidths[2] + "s ║ %-" + columnWidths[3] + "s ║ %-" + columnWidths[5] + "s ║ %-" + columnWidths[4] + "s ║ %-" + columnWidths[10] + "s ║ %-" + columnWidths[11] + "s ║ %-" + columnWidths[6] + "s ║ %-" + columnWidths[7] + "s ║ %-" + columnWidths[8] + "s ║ %-" + columnWidths[9] + "s ║ %-" + columnWidths[10] + "s",
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
                        historyTransaksi[i][9], // Alamat
                        historyTransaksi[i][12]
                    ));
                    dataDitemukan = true;
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣"); 

        if (!dataDitemukan) {
            System.out.println("Tidak ada transaksi pada tahun tersebut.");
        }
    }

    private static double getRevenue(Date startDate, Date endDate) {
        int revenue = 0;
        try {
            for (int i = 0; i < historyTransaksi.length; i++) {
                Date transaksiDate = dateFormat.parse(historyTransaksi[i][1]);
                if (transaksiDate.compareTo(startDate) >= 0 && transaksiDate.compareTo(endDate) <= 0) {
                    revenue += Double.parseDouble(historyTransaksi[i][6]);
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return revenue;  
    }

    private static int getTotalWeight(Date startDate, Date endDate) {
        int weight = 0;
        try {
            for (int i = 0; i < historyTransaksi.length; i++) {
                Date transaksiDate = dateFormat.parse(historyTransaksi[i][1]);
                if (transaksiDate.compareTo(startDate) >= 0 && transaksiDate.compareTo(endDate) <= 0) {
                    weight += Double.parseDouble(historyTransaksi[i][10]);
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return weight;  
    }

    private static int getExpeditionCount(Date startDate, Date endDate) {
        int count = 0;
        try {
            for (int i = 0; i < historyTransaksi.length; i++) {
                Date transaksiDate = dateFormat.parse(historyTransaksi[i][1]);
                if (transaksiDate.compareTo(startDate) >= 0 && transaksiDate.compareTo(endDate) <= 0) {
                    count++;
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return count;  
    }

    private static void displayHeader(){
        System.out.println("╔══════════════════════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║");
        System.out.println("║"+YELLOW+centerString(98, "╔═╗╦╔═╗╔╦╗╔═╗╔╦╗  ╔═╗╦╔═╔═╗╔═╗╔═╗╔╦╗╦╔═╗╦"+RESET));
        System.out.println("║"+YELLOW+centerString(98, "╚═╗║╚═╗ ║ ║╣ ║║║  ║╣ ╠╩╗╚═╗╠═╝║╣  ║║║╚═╗║"+RESET));
        System.out.println("║"+YELLOW+centerString(98, "╚═╝╩╚═╝ ╩ ╚═╝╩ ╩  ╚═╝╩ ╩╚═╝╩  ╚═╝═╩╝╩╚═╝╩"+RESET));
        System.out.println("║");
        System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
    }

    private static void clearTerminal(){
        System.out.println(CLEAR);
        System.out.flush();
    }

    private static void displayIndonesianMap(){
        System.out.println("║   ..                                                                                              \r\n" + //
                "║   .-===-                                                                                          \r\n" + //
                "║     .:===:.                 .              ===-                                                   \r\n" + //
                "║        -===-.                             -====:                                                  \r\n" + //
                "║          -====-:              :.    ..  .-======.            .     :..                            \r\n" + //
                "║        .  =======-.           ===-=============:..  ::-::.:::.     ::.                            \r\n" + //
                "║            :======-           -================    .               :     .  .:.                   \r\n" + //
                "║          :  .======-:          .=============:     ==::=-..        .      .-====:   .  .          \r\n" + //
                "║              .=======::-:       -===========-     -====:                .   .:-::    :-===-:..    \r\n" + //
                "║                :=======-   .       .::.::===:     -=- ==:       .-. .::::.   :=-=-.:==========.   \r\n" + //
                "║                  :=====:                 .         --  =-..                   .  .:-==========.   \r\n" + //
                "║                    .===:                           =:    :                             :======.   \r\n" + //
                "║                        :---:.    .                                              .:       -====    \r\n" + //
                "║                         .--==-==-====:..                                   .             :====    \r\n" + //
                "║                                 .:::--:--.: ......  ...  .   .                          -:.::=.   \r\n" + //
                "║                                               ..  ...       .:                                    \r\n" + //
                "║                                                     :.     ::                                     \r\n" + //
                "╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
    }
    
}
