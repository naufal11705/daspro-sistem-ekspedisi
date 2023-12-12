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
        {"Kasir", "333", "KASIR"},
        {"Kurir", "444", "KURIR"}
    };

    static String[][] languageModule = {
        {"Welcome to the Expedition System", "Selamat Datang di Sistem Ekspedisi"}, //1
        {"║ ⤷ Input Username  : ", "║ ⤷ Masukkan Username   : "}, //2
        {"║ ⤷ Input Password  : ", "║ ⤷ Masukkan Password   : "}, //3
        {"✅ Loggin Success. Welcome ","✅ Anda berhasil masuk. Selamat datang "}, //4
        {"⛔ OOPS! THERE IS A PROBLEM WITH YOUR LOGIN CREDENTIALS. PLEASE VERIFCATION AND TRY AGAIN.","⛔ OOPS! TERDAPAT MASALAH DENGAN KREDENSIAL LOGIN ANDA. SILAKAN VERIFIKASI DAN COBA LAGI."}, //5

            {"User Management", "Manajemen Pengguna         "}, //6
                {"Add User", "Tambahkan Pengguna"}, //7
                    {"║ ⤷ Enter new Username: ", "║ ⤷ Masukkan nama pengguna baru: "},  //8
                    {"║ ⤷ Enter new Password: ", "║ ⤷ Masukkan kata sandi baru: "}, //9
                    {"║ ⤷ Enter new role user: ", "║ ⤷ Masukkan jabatan penggun baru: "},   //10
                    {"✅ New User Successfully Added.","✅ Pengguna baru berhasil ditambahkan."},   //11
                {"Remove User", "Hapus Pengguna"},  //12
                    {"║ ⤷ Enter Username want to remove: ","║ ⤷ Masukan username yang akan dihapus: "}, //13
                    {"🗑️  User successfully removed.","🗑️  Pengguna telah dihapus."},   //14
                    {"⚠️  USER NOT FOUND. PLEASE TRY AGAIN.","⚠️  PENGGUNA TIDAK DITEMUKAN. SILAKAN COBA LAGI."},   //15
                {" User Data", "Data Pengguna"},    //16
                    {"User Management", "Manajemen Pengguna"},  //17
                {"Back to the Main Menu", "Kembali ke Menu Utama"}, //18

            {"Delivery of Goods' Transaction", "Transaksi Pengiriman       "}, //19
                {"Transactions", "Melakukan Transaksi"}, //20
                    {"║ Enter the Sender's Name: ","║ Masukkan Nama Pengirim: "},   //21
                    {"║ Enter contact number: ", "║ Masukkan nomor kontak: "},  //22
                    {"║ Enter receiver's name:","║ Masukkan Nama Penerima:"},   //23
                    {"║ Enter Address: ", "║ Masukkan Alamat: "},   //24
                    {"║ Enter Description: ", "║ Masukkan Deskripsi Barang:"},  //25
                    {"Length: ", "Masukkan Panjang: "}, //26
                    {"Weidht: ", "Masukkan Lebar: "}, //27
                    {"Height: ", "Masukkan Tinggi: "},  //28
                    {"⚠️ RUTE IS NOT FOUND. PLEASE TRY AGAIN", "⚠️ RUTE TIDAK DITEMUKAN. SILAKAN COBA LAGI."},  //29
                    {"day", "hari"},    //30
                    {"║ Payment Methode", "║ Metode Pembayaran"},   //31
                    {"║ Choose Payment methode: ", "║ Pilih Metode Pembayaran: "},  //32
                    {"║ Available Bank (Name)", "║ Bank yang tersedia (Nama)"}, //33
                    {"Payment successfully used ","Pembayaran berhasil menggunakan "},   //34
                    {"║ Please make payment of the amound Rp.","║ Silahkan lakukan Pembayaran sejumlah Rp."},   //35
                        {" before receiving goods. The Fee will be charged to the receiver!!!"," sebelum menerima barang. Biaya akan dibebankan kepada penerima!!!"},   //36
                    {"║ Shipping cost amount to: ","║ Biaya Pengiriman sebesar: "}, //37
                        {"║ Pay: Rp.", "║ Bayar: Rp."},     //38
                        {"║ Return: Rp", "║ Kembalian: Rp"},    //39
                    {"Sender", "Pegiriman"},    //40
                    {"Receiver", "Penerima"},   //41
                    {"Date", "Tanggal"},        //42
                    {"Cost", "Biaya"},      //43
                {"Edit Delivery Status", "Edit Status Pengiriman"}, //44
                    {"║ Input receipt number: ", "║ Masukkan nomor resi: "},    //45
                    {"Data is not found", "Data tidak ditemukan"},  //46
                {"Remove Transaction", "Hapus Transaksi"},  //47
                    {"Data with this receipt number has been removed","Data dengan nomor resi yang sesuai sudah dihapus"},  //48
                    {"User Data", "Data Pengguna"}, //49
            
            {"Rute Management", "Manajemen Rute"},  //50
                {"Add New Rute", "Tambah Rute Baru"},   //51
                    {"║ Rute has been available", "║ Rute sudah tersedia"}, //52
                    {"║ Enter the distance between ", "║ Masukkan jarak antara "},  //53
                {"Remove Rute", "Hapus Rute"},  //54
                {"Displays Location's Data", "Menampilkan Data Rute Pengiriman"},   //55

            {"Cost Management", "Manajemen Layanan"}, //56
                {"Add Service Types", "Tambahkan Jenis Layanan"},   //57
                    {"║ ⤷ Enter New Service Name", "║ ⤷ Masukkan Nama Layanan"},    //58
                    {"║ ⤷ Cost: Rp.", "║ ⤷ Masukkan Tarif: Rp."},   //59
                    {"║ ⤷ Minimum delivery time: ","║ ⤷ Masukkan Waktu Pengiriman Minimum: "},  //60
                    {"║ ⤷ Maximum delivery time: ","║ ⤷ Masukkan Waktu Pengiriman Maximum: "},  //61
                {"Edit Cost Service", "Edit Tarif Layanan"},    //62
                    {"║ Service list available: ","║ Daftar Layanan yang Tersedia: "},  //63
                    {"║ ⤷ Enter service number want to change: " ,"║ ⤷ Masukkan nomor layanan yang ingin diubah: "},    //64
                {"Remove Service", "Menghapus Layanan"},    //65
                {"Displays Services' Data", "Menampilkan Layanan Data"},    //66
                    {"Service", "Cost"},    //67

            {"Change Language", "Ganti Bahasa"},    //68
            {"Basic Service Cost Management", "Manajemen Tarif Dasar"}, //69
                {"║ ⤷ Service Cost Management per Kg: ","║ ⤷ Masukkan tarif dasar per Kg: "},   //70
                {"║ ⤷ Service Cost Management per Km: ","║ ⤷ Masukkan tarif dasar per Km: "},   //71
            {"Report", "Laporan"},  //72
            {"Delivery of goods","Pengiriminan Barang"}, //73
                {"Warehouse Inventory", "Inventori Gudang"},    //74
                    {"║ ⤷ Enter warehouse location: ", "║ ⤷ Masukkan lokasi Gudang: "}, //75
                {"Send Pakcage", "Kirim Paket"},    //76
                    {"║ ⤷ Enter index: ", "║ ⤷ Masukkan index: "},  //77
                {"Deliver Package", "Antar Paket"}, //78
            {"Exit", "Keluar"}, //79

        {"Logout Successs. See You! 👋","Anda telah berhasil keluar. Sampai jumpa lain waktu! 👋"}, //80
        {"║ ⤷ Enter Options: ", "║ ⤷ Masukkan Pilihan: "},  //81
        {"Click ⏎ Enter to Continue", "Tekan ⏎ Enter untuk melanjutkan"}, //82

        // Data Tambahan
        {"Weight: ", "Masukkan berat barang: "},

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
    static String BOLD = "\u001B[1m";

    static int selectedLanguage = 1;

    static boolean login = false;
    static boolean isAdmin = false;
    static boolean masuk = false;
    static boolean isKurir = false;

    static String loggedInUsername = "";

    static double tarifPerKg = 2500;
    static double tarifPerKm = 500;

    static String[][] historyTransaksi = {
        {"8032468109752", "29-01-2023", "Nanda", "08866778899", "Yogyakarta", "Reguler", "25700.0", "Farhan", "Abdi", "Jl. Kembang 5 No. 15", "3", "Makanan", "Waiting for pickup", "Malang"},
        {"9276354185046", "12-02-2023", "Gabriel", "08811223344", "Tangerang", "Ekonomi", "33200.0", "Naufal", "Afifah", "Jl. Anggrek 12 No. 8", "7", "Elektronik", "Waiting for pickup", "Bekasi"},
        {"1492578034685", "03-03-2023", "Afifah", "08876543210", "Makassar", "Reguler", "50900.0", "Putra", "Naufal", "Jl. Melati 9 No. 21", "5", "Pakaian", "Waiting for pickup", "Bandung"},
        {"5283176490254", "26-04-2023", "Esa", "08822334455", "Medan", "Ekonomi", "65400.0", "Farhan", "Luthfi", "Jl. Seroja 3 No. 7", "2", "Buku", "Waiting for pickup", "Medan"},
        {"3091754682351", "21-05-2023", "Abdi", "08811223344", "Bogor", "Ekonomi", "34800.0", "Naufal", "Julian", "Jl. Mawar 17 No. 5", "9", "Mainan", "Waiting for pickup", "Bogor"},
        {"6750912348526", "17-06-2023", "Naufal", "08822334455", "Yogyakarta", "Reguler", "66500.0", "Putra", "Gabriel", "Jl. Anggrek 7 No. 12", "8", "Kesehatan", "Waiting for pickup", "Malang"},
        {"8013564729835", "30-06-2023", "Farrel", "08855443322", "Jakarta", "Reguler", "76800.0", "Farhan", "Chiko", "Jl. Melati 15 No. 10", "4", "Alat Tulis", "Waiting for pickup", "Bekasi"},
        {"2674853902164", "14-07-2023", "Atabik", "08855443322", "Bandung", "Ekonomi", "45300.0", "Naufal", "Vincent", "Jl. Kembang 2 No. 19", "1", "Elektronik", "Waiting for pickup", "Bandung"},
        {"4501628397517", "05-08-2023", "Dio", "08876543210", "Surabaya", "Sameday", "29100.0", "Putra", "Saputra", "Jl. Seroja 11 No. 14", "6", "Makanan", "Waiting for pickup", "Medan"},
        {"7246109385273", "09-09-2023", "Pasha", "08899887766", "Serang", "Reguler", "78000.0", "Farhan", "Naufal", "Jl. Anggrek 8 No. 5", "10", "Pakaian", "Waiting for pickup", "Bogor"},
        {"3751928643058", "18-10-2023", "Farhan", "08866778899", "Denpasar", "Reguler", "55700.0", "Naufal", "Petrus", "Jl. Mawar 5 No. 11", "2", "Mainan", "Waiting for pickup", "Malang"},
        {"5038921467584", "02-12-2023", "Chiko", "08811223344", "Malang", "Ekonomi", "87600.0", "Putra", "Saka", "Jl. Kembang 10 No. 17", "7", "Elektronik", "Waiting for pickup", "Bogor"},
        {"6904715283142", "27-09-2023", "Haikal", "08887654321", "Bengkulu", "Sameday", "98800.0", "Farhan", "Vincent", "Jl. Melati 3 No. 9", "3", "Kesehatan", "Waiting for pickup", "Bekasi"},
        {"4892307162453", "11-11-2023", "Cindy", "08899887766", "Bekasi", "Sameday", "65400.0", "Naufal", "Petrus", "Jl. Seroja 8 No. 6", "5", "Makanan", "Waiting for pickup", "Bekasi"},
        {"1234567890123", "01-01-2023", "Ivan", "08812345678", "Surabaya", "Ekonomi", "45000.0", "Putra", "Abdi", "Jl. Anggrek 14 No. 20", "9", "Buku", "Waiting for pickup", "Bogor"},
        {"9876543210987", "07-04-2023", "Luthfi", "08887654321", "Jakarta", "Reguler", "60000.0", "Farhan", "Farrel", "Jl. Kembang 1 No. 18", "1", "Elektronik", "Waiting for pickup", "Malang"},
        {"3456789012345", "14-06-2023", "Adri", "08811223344", "Bandung", "Ekonomi", "35000.0", "Naufal", "Petrus", "Jl. Melati 6 No. 13", "6", "Makanan", "Waiting for pickup", "Bogor"},
        {"8765432109876", "21-08-2023", "Alif", "08899887766", "Makassar", "Sameday", "42000.0", "Putra", "Saputra", "Jl. Anggrek 20 No. 3", "4", "Buku", "Waiting for pickup", "Bandung"},
        {"6543210987654", "03-10-2023", "Dimas", "08876543210", "Denpasar", "Reguler", "58000.0", "Farhan", "Farrel", "Jl. Mawar 13 No. 16", "10", "Mainan", "Waiting for pickup", "Bekasi"},
        {"8765432109876", "11-12-2023", "Julian", "08822334455", "Malang", "Sameday", "67000.0", "Naufal", "Naufal", "Jl. Seroja 2 No. 4", "8", "Kesehatan", "Waiting for pickup", "Malang"},
        {"5432109876543", "25-02-2023", "Petrus", "08866778899", "Bogor", "Reguler", "73000.0", "Putra", "Saka", "Jl. Kembang 8 No. 1", "3", "Elektronik", "Waiting for pickup", "Bogor"},
        {"3210987654321", "10-05-2023", "Saputra", "08855443322", "Surabaya", "Ekonomi", "32000.0", "Farhan", "Rio", "Jl. Mawar 14 No. 7", "5", "Makanan", "Waiting for pickup", "Bekasi"},
        {"9876543210987", "15-07-2023", "Reika", "08811223344", "Semarang", "Reguler", "52000.0", "Naufal", "Chiko", "Jl. Anggrek 11 No. 15", "2", "Alat Tulis", "Waiting for pickup", "Medan"},
        {"3456789012345", "20-09-2023", "Rio", "08887654321", "Yogyakarta", "Sameday", "47000.0", "Putra", "Naufal", "Jl. Seroja 10 No. 2", "9", "Elektronik", "Waiting for pickup", "Bogor"},
        {"9876543210987", "05-11-2023", "Saka", "08899887766", "Tangerang", "Sameday", "69000.0", "Farhan", "Chiko", "Jl. Melati 20 No. 16", "1", "Pakaian", "Waiting for pickup", "Bekasi"},
        {"3210987654321", "15-01-2023", "Taufik", "08876543210", "Bekasi", "Ekonomi", "40000.0", "Naufal", "Vincent", "Jl. Kembang 7 No. 19", "10", "Buku", "Waiting for pickup", "Surabaya"},
        {"9876543210987", "20-03-2023", "Mera", "08822334455", "Gorontalo", "Sameday", "61000.0", "Putra", "Saputra", "Jl. Seroja 4 No. 11", "4", "Kesehatan", "Waiting for pickup", "Bogor"},
        {"3456789012345", "05-05-2023", "Vincent", "08866778899", "Malang", "Reguler", "54000.0", "Farhan", "Petrus", "Jl. Anggrek 3 No. 14", "7", "Makanan", "Arrived at warehouse", "Medan"},
        {"3210987654321", "10-07-2023", "Vira", "08855443322", "Bengkulu", "Ekonomi", "37000.0", "Naufal", "Haikal", "Jl. Kembang 12 No. 9", "1", "Elektronik", "Waiting for pickup", "Bogor"},
        {"9876543210987", "28-10-2023", "Innam", "08822334455", "Surabaya", "Sameday", "55000.0", "Putra", "Farrel", "Jl. Melati 9 No. 5", "6", "Buku", "Waiting for pickup", "Bekasi"},
    };

    static String[][] shipmentDetails = {
        {"3210987654321", "Saka", "Sending"},
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

                System.out.print(languageModule[1][selectedLanguage]);
                String inputUsername = input.next();

                System.out.print(languageModule[2][selectedLanguage]);
                String inputPassword = input.next();
                input.nextLine();

                loginValidation(inputUsername, inputPassword);

                if(!masuk){
                    System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
                    System.out.println("║                                                                                                  ║");
                    System.out.println("║"+centerString(97, languageModule[4][selectedLanguage])+"║");
                    System.out.println("║                                                                                                  ║");
                    System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════════════╝");
                    System.out.print(languageModule[81][selectedLanguage]);
                    input.nextLine();
                    clearTerminal();
                }
            }

            System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
            System.out.println("║                                                                                                  ║");
            System.out.println("║"+centerString(97, languageModule[3][selectedLanguage] + loggedInUsername)+"║");
            System.out.println("║                                                                                                  ║");
            System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════════════╝");
            System.out.print(languageModule[81][selectedLanguage]);
            input.nextLine();
            clearTerminal();

            do {
                displayHeader();
                displayIndonesianMap();

                if(isAdmin){
                    System.out.println("║                                                                                                  ║");
                    System.out.println("║             ╭──────────────────────────────────────────────────────────────────────╮             ║");
                    System.out.println("║             │                                                                      │             ║");
                    System.out.println("║             │     [1]. "+padString(32, languageModule[5][selectedLanguage])+"[6]. "+padString(23, languageModule[68][selectedLanguage])+"│             ║");
                    System.out.println("║             │                                                                      │             ║");
                    System.out.println("║             │     [2]. "+padString(32, languageModule[18][selectedLanguage])+"[7]. "+padString(23, languageModule[71][selectedLanguage])+"│             ║");
                    System.out.println("║             │                                                                      │             ║");
                    System.out.println("║             │     [3]. "+padString(32, languageModule[49][selectedLanguage])+"[8]. "+padString(23, languageModule[72][selectedLanguage])+"│             ║");
                    System.out.println("║             │                                                                      │             ║");
                    System.out.println("║             │     [4]. "+padString(32, languageModule[55][selectedLanguage])+"[9]. "+padString(23, languageModule[78][selectedLanguage])+"│             ║");
                    System.out.println("║             │                                                                      │             ║");
                    System.out.println("║             │     [5]. "+padString(60, languageModule[67][selectedLanguage])+"│             ║");
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
                    System.out.println("║             │                     [1]. "+padString(44, languageModule[72][selectedLanguage])+"│             ║");
                    System.out.println("║             │                                                                      │             ║");
                    System.out.println("║             │                                                                      │             ║");
                    System.out.println("║             │                                                                      │             ║");
                    System.out.println("║             │                     [2]. "+padString(44, languageModule[78][selectedLanguage])+"│             ║");
                    System.out.println("║             │                                                                      │             ║");
                    System.out.println("║             │                                                                      │             ║");
                    System.out.println("║             │                                                                      │             ║"); 
                    System.out.println("║             ╰──────────────────────────────────────────────────────────────────────╯             ║");
                    System.out.println("║                                                                                                  ║"); 
                    System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
                } else {
                    System.out.println("║             ╭──────────────────────────────────────────────────────────────────────╮             ║");
                    System.out.println("║             │                                                                      │             ║");
                    System.out.println("║             │                                                                      │             ║");
                    System.out.println("║             │                                                                      │             ║");
                    System.out.println("║             │   [1]. " + padString(44, languageModule[18][selectedLanguage]) + "   [4]. " + padString(44, languageModule[65][selectedLanguage]) + "   │             ║");
                    System.out.println("║             │                                                                      │             ║");
                    System.out.println("║             │   [2]. " + padString(44, languageModule[19][selectedLanguage]) + "   [5]. " + padString(44, languageModule[69][selectedLanguage]) + "   │             ║");
                    System.out.println("║             │                                                                      │             ║");
                    System.out.println("║             │   [3]. " + padString(44, languageModule[66][selectedLanguage]) + "   [6]. " + padString(44, languageModule[70][selectedLanguage]) + "   │             ║");
                    System.out.println("║             │                                                                      │             ║");
                    System.out.println("║             │                                                                      │             ║");
                    System.out.println("║             │                                                                      │             ║");
                    System.out.println("║             ╰──────────────────────────────────────────────────────────────────────╯             ║");
                    System.out.println("║                                                                                                  ║");
                    System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
                    
   
            }
                
                System.out.print(languageModule[80][selectedLanguage]);
                menuUtama = input.nextInt();
                input.nextLine();
                clearTerminal();

                isLoop = true;
                do {
                    if(isAdmin){
                    menuUtama = menuUtama-1;
                    switch (menuUtama) {
                        case 0:
                            
                                while(!exit) {
                                displayHeader();
                                displayIndonesianMap();

                                System.out.println("║"+YELLOW+centerString(98,"Manajemen Pengguna")+RESET+"║");
                                System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
                                System.out.println("║                                                                                                  ║");
                                System.out.println("║             ╭──────────────────────────────────────────────────────────────────────╮             ║");
                                System.out.println("║             │                                                                      │             ║");
                                System.out.println("║             │                                                                      │             ║");
                                System.out.println("║             │                     [1]. Tambahkan Pengguna                          │             ║");
                                System.out.println("║             │                                                                      │             ║");
                                System.out.println("║             │                     [2]. Hapus Pengguna                              │             ║");
                                System.out.println("║             │                                                                      │             ║");
                                System.out.println("║             │                     [3]. Data Pengguna                               │             ║");
                                System.out.println("║             │                                                                      │             ║");
                                System.out.println("║             │                     [4]. Keluar                                      │             ║");
                                System.out.println("║             │                                                                      │             ║");
                                System.out.println("║             │                                                                      │             ║"); 
                                System.out.println("║             ╰──────────────────────────────────────────────────────────────────────╯             ║");
                                System.out.println("║                                                                                                  ║"); 
                                System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");

                                System.out.print("║ "+padString(32, languageModule[80][selectedLanguage])); //Masukan Pilihan
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

                                    System.out.print(languageModule[81][selectedLanguage]);
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
                                        System.out.print(languageModule[81][selectedLanguage]);
                                        input.nextLine();
                                        clearTerminal();
                                        break;   
                                    case 3:
                                        input.nextLine(); //konsumsi
                                        viewUserAccounts();
                                        System.out.print(languageModule[81][selectedLanguage]);
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
                            
                            exit = false;
                            break;
                                
                                
                        case 1:
                            displayHeader();
                            displayIndonesianMap();

                            System.out.println("║"+YELLOW+centerString(98,"Pengiriman Barang")+RESET+"║");
                            System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
                            System.out.println("║                                                                                                  ║");
                            System.out.println("║             ╭──────────────────────────────────────────────────────────────────────╮             ║");
                            System.out.println("║             │                                                                      │             ║");
                            System.out.println("║             │                     [1]. Melakukan Transaksi                         │             ║");
                            System.out.println("║             │                                                                      │             ║");
                            System.out.println("║             │                     [2]. Edit Status Pengiriman                      │             ║");
                            System.out.println("║             │                                                                      │             ║");
                            System.out.println("║             │                     [3]. Hapus Transaksi                             │             ║");
                            System.out.println("║             │                                                                      │             ║");
                            System.out.println("║             │                     [4]. Riwayat Transaksi                           │             ║");
                            System.out.println("║             │                                                                      │             ║");
                            System.out.println("║             │                     [5]. Kembali ke Menu Utama                       │             ║");
                            System.out.println("║             │                                                                      │             ║"); 
                            System.out.println("║             ╰──────────────────────────────────────────────────────────────────────╯             ║");
                            System.out.println("║                                                                                                  ║"); 
                            System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
                            System.out.print("║ "+padString(32, languageModule[80][selectedLanguage])); 

                            subMenu = input.nextInt();
                            input.nextLine();
                            clearTerminal();

                            switch (subMenu) {
                                case 1:
                                displayHeader();
                                displayIndonesianMap();

                                    String nomorResi;
                                    int pilihanLayanan;
                                    double biayaJarak = 0;

                                    System.out.print(padString(32, languageModule[20][selectedLanguage]));
                                    String namaPengirim = input.nextLine();

                                    System.out.print(padString(32, languageModule[21][selectedLanguage]));
                                    String nomorKontak = input.nextLine();

                                    System.out.print(padString(32, languageModule[22][selectedLanguage]));
                                    String namaPenerima = input.nextLine();

                                    System.out.print(padString(32, languageModule[23][selectedLanguage]));
                                    String alamatPenerima = input.nextLine();

                                    System.out.print(padString(32, languageModule[24][selectedLanguage]));
                                    String deskripsiBarang = input.nextLine();

                                    double beratBarang=0;
                                    int panjang;
                                    int luas;
                                    int tinggi;
                                    int berat=0;
                                    do {
                                        System.out.print("║ "+padString(32, languageModule[82][selectedLanguage]));
                                        while (!input.hasNextInt()) {
                                            input.nextLine();
                                            System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
                                            System.out.println("║                                                                                                  ║");
                                            System.out.println("║"+centerString(99, "⚠️ INPUT HARUS BERUPA BILANGAN BULAT. SILAHKAN COBA LAGI.")+"║");
                                            System.out.println("║                                                                                                  ║");
                                            System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════════════╝");
                                            System.out.print(languageModule[81][selectedLanguage]);
                                            input.nextLine();  
                                            System.out.print("\033[7A\033[0J");
                                            System.out.print("║ "+padString(32, languageModule[82][selectedLanguage]));
                                        }
                                        berat= input.nextInt();

                                        input.nextLine(); // membersihkan buffer input
                                        if (berat <= 0) {
                                            input.nextLine();
                                            System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
                                            System.out.println("║                                                                                                  ║");
                                            System.out.println("║"+centerString(99, "⚠️ PANJANG HARUS LEBIH BESAR DARI 0 . SILAHKAN COBA LAGI.")+"║");
                                            System.out.println("║                                                                                                  ║");
                                            System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════════════╝");
                                            System.out.print(languageModule[81][selectedLanguage]);
                                            input.nextLine();  
                                            System.out.print("\033[7A\033[0J");
                                        } else {
                                            validInput = true;
                                        }
                                    } while (!validInput);
                                    
                                    do {
                                        System.out.print("║ "+padString(32, languageModule[25][selectedLanguage]));
                                        while (!input.hasNextInt()) {
                                            input.nextLine();
                                            System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
                                            System.out.println("║                                                                                                  ║");
                                            System.out.println("║"+centerString(99, "⚠️ INPUT HARUS BERUPA BILANGAN BULAT. SILAHKAN COBA LAGI.")+"║");
                                            System.out.println("║                                                                                                  ║");
                                            System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════════════╝");
                                            System.out.print(languageModule[81][selectedLanguage]);
                                            input.nextLine();  
                                            System.out.print("\033[7A\033[0J");
                                            System.out.print("║ "+padString(32, languageModule[25][selectedLanguage]));
                                        }
                                        panjang= input.nextInt();

                                        input.nextLine(); // membersihkan buffer input
                                        if (panjang <= 0) {
                                            input.nextLine();
                                            System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
                                            System.out.println("║                                                                                                  ║");
                                            System.out.println("║"+centerString(99, "⚠️ PANJANG HARUS LEBIH BESAR DARI 0 . SILAHKAN COBA LAGI.")+"║");
                                            System.out.println("║                                                                                                  ║");
                                            System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════════════╝");
                                            System.out.print(languageModule[81][selectedLanguage]);
                                            input.nextLine();  
                                            System.out.print("\033[7A\033[0J");
                                        } else {
                                            validInput = true;
                                        }
                                    } while (!validInput);
                                    
                                    do {
                                        System.out.print("║ "+padString(32, languageModule[26][selectedLanguage]));
                                        while (!input.hasNextInt()) {
                                            input.nextLine();
                                            System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
                                            System.out.println("║                                                                                                  ║");
                                            System.out.println("║"+centerString(99, "⚠️ INPUT HARUS BERUPA BILANGAN BULAT. SILAHKAN COBA LAGI.")+"║");
                                            System.out.println("║                                                                                                  ║");
                                            System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════════════╝");
                                            System.out.print(languageModule[81][selectedLanguage]);
                                            input.nextLine();  
                                            System.out.print("\033[7A\033[0J");
                                            System.out.print("║ "+padString(32, languageModule[26][selectedLanguage]));
                                        }
                                        luas = input.nextInt();

                                        input.nextLine(); // membersihkan buffer input
                                        if (luas <= 0) {
                                            input.nextLine();
                                            System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
                                            System.out.println("║                                                                                                  ║");
                                            System.out.println("║"+centerString(99, "⚠️ LUAS HARUS LEBIH BESAR DARI 0. SILAHKAN COBA LAGI.")+"║");
                                            System.out.println("║                                                                                                  ║");
                                            System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════════════╝");
                                            System.out.print(languageModule[81][selectedLanguage]);
                                            input.nextLine();  
                                            System.out.print("\033[7A\033[0J");
                                        } else {
                                            validInput = true;
                                        }
                                    } while (!validInput);

                                    do {
                                        System.out.print("║ "+padString(32, languageModule[27][selectedLanguage]));
                                        while (!input.hasNextInt()) {
                                            input.nextLine();
                                            System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
                                            System.out.println("║                                                                                                  ║");
                                            System.out.println("║"+centerString(99, "⚠️ INPUT HARUS BERUPA BILANGAN BULAT. SILAHKAN COBA LAGI.")+"║");
                                            System.out.println("║                                                                                                  ║");
                                            System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════════════╝");
                                            System.out.print(languageModule[81][selectedLanguage]);
                                            input.nextLine();  
                                            System.out.print("\033[7A\033[0J");
                                            System.out.print("║ "+padString(32, languageModule[27][selectedLanguage]));
                                        }
                                        tinggi = input.nextInt();

                                        input.nextLine(); // membersihkan buffer input
                                        if (tinggi <= 0) {
                                            input.nextLine();
                                            System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
                                            System.out.println("║                                                                                                  ║");
                                            System.out.println("║"+centerString(99, "⚠️ LUAS HARUS LEBIH BESAR DARI 0. SILAHKAN COBA LAGI.")+"║");
                                            System.out.println("║                                                                                                  ║");
                                            System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════════════╝");
                                            System.out.print(languageModule[81][selectedLanguage]);
                                            input.nextLine();  
                                            System.out.print("\033[7A\033[0J");
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
                                            System.out.print(languageModule[81][selectedLanguage]);
                                            input.nextLine();  
                                            System.out.print("\033[7A\033[0J");
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
                                    System.out.print ("║ ⤷ Masukkan Pilihan: ");
                                    pilihanLayanan = input.nextInt();
                                    double tarifLayanan = Double.parseDouble(arrayLayanan[pilihanLayanan][1]); 
                                    if (beratBarang<1) {
                                        beratBarang = 1;
                                    } else {
                                        beratBarang = (panjang*luas*tinggi)/6000;
                                    }
                                     
                                    double biayaAkhir = tarifLayanan + (beratBarang*tarifPerKg) + biayaJarak;
                                    nomorResi = generateTrackingNumber();

                                    System.out.println("║");
                                    System.out.println("║ "+padString(32, languageModule[30][selectedLanguage]));
                                    System.out.println("║ 1. VIA Bank");
                                    System.out.println("║ 2. COD");
                                    System.out.println("║ 3. Tunai");
                                    System.out.print("║ "+padString(32, languageModule[31][selectedLanguage]));
                                    int metode = input.nextInt();

                                    switch (metode) {
                                        case 1:
                                        System.out.println("║ Jenis Pilihan Bank yang Tersedia");
                                        System.out.println("║ 1. BRI");
                                        System.out.println("║ 2. BNI");
                                        System.out.println("║ 3. MANDIRI");
                                    
                                        System.out.print("║ pilih jenis Bank yang ingin digunakan (Nama Bank) ");
                                        String jenisBank = input.next();
                                        System.out.println("║ Pembayaran Berhasil menggunakan " +jenisBank);
                                        break;

                                        case 2: 
                                        System.out.println("║ Silahkan lakukan pembayaran sejumlah " +biayaAkhir+ " sebelum menerima barang. Biaya akan dibebankan kepada penerima barang!!!");
                                        break;

                                        case 3:
                                        System.out.println("║ Biaya Pengiriman sebesar: " +biayaAkhir);
                                        System.out.print("║ Bayar: ");
                                        int bayar = input.nextInt();
                                        System.out.println("║ Kembalian: " +(bayar - biayaAkhir));
                                        break;

                                    }

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

                                    System.out.print(languageModule[81][selectedLanguage]);
                                    input.nextLine();   
                                    clearTerminal();                                 
                                    break;
                                case 2:
                                displayHeader();
                                displayIndonesianMap();
                                    validInput = false;
                                    int index = -1;

                                    while (!validInput) {
                                        System.out.print("║ "+padString(32, languageModule[44][selectedLanguage])); // maukan nomor resi
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
                                            System.out.print("║ "+padString(32, languageModule[80][selectedLanguage]));
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

                                    System.out.print(languageModule[81][selectedLanguage]);
                                    input.nextLine();   
                                    clearTerminal(); 
                                break;

                                case 3: 
                                displayHeader();
                                displayIndonesianMap();
                                    // menghapus transaksi berdasarkan nomor resi
                                    validInput = false;
                                    int deleteIndex = -1;

                                    while (!validInput) {
                                        System.out.println("║ "+padString(32, languageModule[44][selectedLanguage])); // masukan nomor resi
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

                                    System.out.print(languageModule[81][selectedLanguage]);
                                    input.nextLine();   
                                    clearTerminal(); 

                                break;
                                case 4:
                                displayHeader();
                                displayIndonesianMap();
                                    Calendar calendar = Calendar.getInstance();
                                    System.out.println("╔══════════════════════════════════════════════════════════════════════════════════════════════════╗");
                                    System.out.println("║"+YELLOW+centerString(98,"History Transaksi")+RESET+"║");
                                    System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
                                    System.out.println("║                                                                                                  ║");
                                    System.out.println("║             ╭──────────────────────────────────────────────────────────────────────╮             ║");
                                    System.out.println("║             │                                                                      │             ║");
                                    System.out.println("║             │                                                                      │             ║");
                                    System.out.println("║             │                                                                      │             ║");
                                    System.out.println("║             │          [1]. Rentang Tanggal         [4]. Tahun                     │             ║");
                                    System.out.println("║             │                                                                      │             ║");
                                    System.out.println("║             │          [2]. Hari                    [5]. Nomor Resi                │             ║");
                                    System.out.println("║             │                                                                      │             ║");
                                    System.out.println("║             │          [3]. Bulan                   [6]. Kembali ke Menu Utama     │             ║");
                                    System.out.println("║             │                                                                      │             ║");
                                    System.out.println("║             │                                                                      │             ║");
                                    System.out.println("║             │                                                                      │             ║"); 
                                    System.out.println("║             ╰──────────────────────────────────────────────────────────────────────╯             ║");
                                    System.out.println("║                                                                                                  ║"); 
                                    System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
                                    System.out.print("║ "+padString(32, languageModule[80][selectedLanguage]));
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
                                            System.out.print(languageModule[81][selectedLanguage]);
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
                            }
                            break;                        
                        case 2:
                            boolean keluar = true;
                            while (keluar) {

                            displayHeader();
                            displayIndonesianMap();

                            System.out.println("║"+YELLOW+centerString(98,"Manajemen Rute")+RESET+"║");
                            System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
                            System.out.println("║                                                                                                  ║");
                            System.out.println("║             ╭──────────────────────────────────────────────────────────────────────╮             ║");
                            System.out.println("║             │                                                                      │             ║");
                            System.out.println("║             │                                                                      │             ║");
                            System.out.println("║             │                     [1]. Tambah Rute                                 │             ║");
                            System.out.println("║             │                                                                      │             ║");
                            System.out.println("║             │                     [2]. Hapus Rute                                  │             ║");
                            System.out.println("║             │                                                                      │             ║");
                            System.out.println("║             │                     [3]. Data Rute                                   │             ║");
                            System.out.println("║             │                                                                      │             ║");
                            System.out.println("║             │                     [4]. Kembali ke Menu Utama                       │             ║");
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

                                    System.out.print(languageModule[81][selectedLanguage]);
                                    input.nextLine();   
                                    clearTerminal(); 
                                         
                                    break;
                                case 3:
                                    viewExpeditionRoutes();
                                    System.out.print(languageModule[81][selectedLanguage]);
                                    input.nextLine();   
                                    clearTerminal(); 
                                    break;
                                case 4:
                                    keluar = false;
                                    clearTerminal();
                                    break;
                                default:
                                }
                        } break;
                        case 3:
                            displayHeader();
                            displayIndonesianMap();

                            System.out.println("║"+YELLOW+centerString(98,"Manajemen Layanan")+RESET+"║");
                            System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
                            System.out.println("║                                                                                                  ║");
                            System.out.println("║             ╭──────────────────────────────────────────────────────────────────────╮             ║");
                            System.out.println("║             │                                                                      │             ║");
                            System.out.println("║             │                     [1]. Tambah Jenis Layanan                        │             ║");
                            System.out.println("║             │                                                                      │             ║");
                            System.out.println("║             │                     [2]. Edit Layanan                                │             ║");
                            System.out.println("║             │                                                                      │             ║");
                            System.out.println("║             │                     [3]. Hapus Layanan                               │             ║");
                            System.out.println("║             │                                                                      │             ║");
                            System.out.println("║             │                     [4]. Data Layanan                                │             ║");
                            System.out.println("║             │                                                                      │             ║");
                            System.out.println("║             │                     [5]. Keluar                                      │             ║");
                            System.out.println("║             │                                                                      │             ║"); 
                            System.out.println("║             ╰──────────────────────────────────────────────────────────────────────╯             ║");
                            System.out.println("║                                                                                                  ║"); 
                            System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
                            System.out.print("║ ⤷ Masukkan Pilihan: ");
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

                                    System.out.print(languageModule[81][selectedLanguage]);
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
                                System.out.print(languageModule[81][selectedLanguage]);
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
                                    System.out.print(languageModule[81][selectedLanguage]);
                                    input.nextLine();   
                                    clearTerminal(); 
                                    break;
                                case 4:
                                    viewExpeditionServices();
                                    System.out.print(languageModule[81][selectedLanguage]);
                                    input.nextLine();   
                                    clearTerminal(); 
                                    break;
                                case 5:
                                    isLoop = false;
                                    clearTerminal();
                                    break;
                                default:
                            }
                            break;

                        case 4:
                            do {
                                displayHeader();
                                displayIndonesianMap();

                                System.out.println("║                                                                                                  ║");
                                System.out.println("║             ╭──────────────────────────────────────────────────────────────────────╮             ║");
                                System.out.println("║             │                                                                      │             ║");
                                System.out.println("║             │                                                                      │             ║");
                                System.out.println("║             │                                                                      │             ║");
                                System.out.println("║             │                         [1]. English                                 │             ║");
                                System.out.println("║             │                                                                      │             ║");
                                System.out.println("║             │                         [2]. Indonesian                              │             ║");
                                System.out.println("║             │                                                                      │             ║");
                                System.out.println("║             │                                                                      │             ║");
                                System.out.println("║             │                                                                      │             ║"); 
                                System.out.println("║             ╰──────────────────────────────────────────────────────────────────────╯             ║");
                                System.out.println("║                                                                                                  ║"); 
                                System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
                                System.out.print("║ ⤷ Masukkan Pilihan: ");
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
                            System.out.print(languageModule[81][selectedLanguage]);
                            input.nextLine();   
                            clearTerminal(); 
                            break;
                           
                        case 7:
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
                                    System.out.print(languageModule[81][selectedLanguage]);
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
                                    System.out.println("Under Development");
                                default:
                                    break;
                            }
                            break;

                        case 8:
                            System.out.println("╔══════════════════════════════════════════════════════════════════════════════════════════════════╗");
                            System.out.println("║                                                                                                  ║");
                            System.out.println("║"+centerString(98, "Anda telah berhasil keluar. Sampai jumpa lain waktu! 👋")+"║");
                            System.out.println("║                                                                                                  ║");
                            System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════════════╝");
                            System.out.print(languageModule[81][selectedLanguage]);
                            input.nextLine();
                            clearTerminal();
                            exit=true;
                            login=false;
                            masuk=false;
                            break;
                        }
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
                                            System.out.print(languageModule[81][selectedLanguage]);
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
                                            System.out.println("Under Development");
                                        default:
                                            break;
                                    }
                                    break;

                         case 2:
                            System.out.println("╔══════════════════════════════════════════════════════════════════════════════════════════════════╗");
                            System.out.println("║                                                                                                  ║");
                            System.out.println("║"+centerString(98, "Anda telah berhasil keluar. Sampai jumpa lain waktu! 👋")+"║");
                            System.out.println("║                                                                                                  ║");
                            System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════════════╝");
                            System.out.print(languageModule[81][selectedLanguage]);
                            input.nextLine();
                            clearTerminal();
                            exit=true;
                            login=false;
                            masuk=false;
                            break;
                            }
                        
                        // SWITCHCASE KASIR
                        } else {
                            switch (menuUtama) { 
                                case 6:
                                System.out.println("╔══════════════════════════════════════════════════════════════════════════════════════════════════╗");
                                System.out.println("║                                                                                                  ║");
                                System.out.println("║"+centerString(98, "Anda telah berhasil keluar. Sampai jumpa lain waktu! 👋")+"║");
                                System.out.println("║                                                                                                  ║");
                                System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════════════╝");
                                System.out.print(languageModule[81][selectedLanguage]);
                                input.nextLine();
                                clearTerminal();
                                exit=true;
                                login=false;
                                masuk=false;
                                break;
                           }
                        
                        }
                    
                    break;
                } while (isLoop);
                


            } while(!exit);
        }
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

    private static String padString(int width, String s) {
    return String.format("%-" + width + "s", s);
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
                } else if ("KURIR".equals(userData[i][2])) {
                    isKurir = true;
                } else {
                    isAdmin = false;
                    isKurir = false;
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
        System.out.println("║                                                                                                  ║");
        System.out.println("║"+YELLOW+centerString(98, "╔═╗╦╔═╗╔╦╗╔═╗╔╦╗  ╔═╗╦╔═╔═╗╔═╗╔═╗╔╦╗╦╔═╗╦"+RESET)+"    ║");
        System.out.println("║"+YELLOW+centerString(98, "╚═╗║╚═╗ ║ ║╣ ║║║  ║╣ ╠╩╗╚═╗╠═╝║╣  ║║║╚═╗║"+RESET)+"    ║");
        System.out.println("║"+YELLOW+centerString(98, "╚═╝╩╚═╝ ╩ ╚═╝╩ ╩  ╚═╝╩ ╩╚═╝╩  ╚═╝═╩╝╩╚═╝╩"+RESET)+"    ║");
        System.out.println("║                                                                                                  ║");
        System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
    }

    private static void clearTerminal(){
        System.out.println(CLEAR);
        System.out.flush();
    }

    private static void displayIndonesianMap(){
        System.out.println("║   ..                                                                                             ║\r\n" + 
                "║   .-===-                                                                                         ║\r\n" + 
                "║     .:===:.                 .              ===-                                                  ║\r\n" + 
                "║        -===-.                             -====:                                                 ║\r\n" + 
                "║          -====-:              :.    ..  .-======.            .     :..                           ║\r\n" + 
                "║        .  =======-.           ===-=============:..  ::-::.:::.     ::.                           ║\r\n" + 
                "║            :======-           -================    .               :     .  .:.                  ║\r\n" + 
                "║          :  .======-:          .=============:     ==::=-..        .      .-====:   .  .         ║\r\n" + 
                "║              .=======::-:       -===========-     -====:                .   .:-::    :-===-:..   ║\r\n" + 
                "║                :=======-   .       .::.::===:     -=- ==:       .-. .::::.   :=-=-.:==========.  ║\r\n" + 
                "║                  :=====:                 .         --  =-..                   .  .:-==========.  ║\r\n" + 
                "║                    .===:                           =:    :                             :======.  ║\r\n" + 
                "║                        :---:.    .                                              .:       -====   ║\r\n" + 
                "║                         .--==-==-====:..                                   .             :====   ║\r\n" + 
                "║                                 .:::--:--.: ......  ...  .   .                          -:.::=.  ║\r\n" + 
                "║                                               ..  ...       .:                                   ║\r\n" + 
                "║                                                     :.     ::                                    ║\r\n" + 
                "╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
    }
    
}
