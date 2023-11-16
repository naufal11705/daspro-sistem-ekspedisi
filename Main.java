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
    public static void main(String[] args) {
        // Deklarasi scanner untuk memasukkan inputan
        Scanner input = new Scanner(System.in);
        
        // Akun default
        String[][] userData = {
            {"admin","admin123","ADMIN"},
            {"Naufal", "000","KASIR"},
            {"Putra", "111","KASIR"},
            {"Farhan", "222","KASIR"}};

        String loggedInUsername = "";

        // Lokasi default
        String[] arrayLokasi = {
            "Malang", "Jakarta", "Surabaya", "Bandung", "Medan",
            "Makassar", "Yogyakarta", "Semarang", "Denpasar", "Serang",
            "Tangerang", "Bengkulu", "Gorontalo", "Bekasi", "Bogor"
        };
        
        // Tarif berdasarkan tujuan pengiriman
        double[] arrayTarifLokasi = {
            8000, 45000, 25000, 16000, 23000, 
            34000, 36000, 23000, 12000, 18000, 
            27000, 30000, 22000, 31000, 19000
        };
        
            
        // Layanan pengiriman default
        String[] arrayLayanan = new String[3];
            arrayLayanan[0] = "Reguler";
            arrayLayanan[1] = "Ekonomi";
            arrayLayanan[2] = "Sameday";

        // Tarif berdasarkan jenis layanan
        double[] arrayTarifLayanan = new double[20];
            arrayTarifLayanan[0] = 10000;
            arrayTarifLayanan[1] = 6000;
            arrayTarifLayanan[2] = 20000;

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

        // Variabel Searching
        String key;
        
        double tarifPerKg = 5000;
        int pilihanLayanan;
        double tarifLayanan = 0;
        double biayaJarak = 0;
        double tarifBaru = 0.0;

        // Array History Pemesanan
        String[][] historyTransaksi = {
            {"29-01-2023", "Nanda", "08866778899", "Yogyakarta", "Reguler", "25700.0", "Farhan", "Abdi", "Jl. Kembang 5 No. 15"},
            {"12-02-2023", "Gabriel", "08811223344", "Tangerang", "Ekonomi", "33200.0", "Naufal", "Afifah", "Jl. Anggrek 12 No. 8"},
            {"03-03-2023", "Afifah", "08876543210", "Makassar", "Reguler", "50900.0", "Putra", "Naufal", "Jl. Melati 9 No. 21"},
            {"26-04-2023", "Esa", "08822334455", "Medan", "Ekonomi", "65400.0", "Farhan", "Luthfi", "Jl. Seroja 3 No. 7"},
            {"21-05-2023", "Abdi", "08811223344", "Bogor", "Ekonomi", "34800.0", "Naufal", "Julian", "Jl. Mawar 17 No. 5"},
            {"17-06-2023", "Naufal", "08822334455", "Semarang", "Sameday", "66500.0", "Putra", "Gabriel", "Jl. Anggrek 7 No. 12"},
            {"30-06-2023", "Farrel", "08855443322", "Jakarta", "Reguler", "76800.0", "Farhan", "Chiko", "Jl. Melati 15 No. 10"},
            {"14-07-2023", "Atabik", "08855443322", "Bandung", "Ekonomi", "45300.0", "Naufal", "Vincent", "Jl. Kembang 2 No. 19"},
            {"05-08-2023", "Dio", "08876543210", "Surabaya", "Sameday", "29100.0", "Putra", "Saputra", "Jl. Seroja 11 No. 14"},
            {"09-09-2023", "Pasha", "08899887766", "Serang", "Reguler", "78000.0", "Farhan", "Naufal", "Jl. Anggrek 8 No. 5"},
            {"18-10-2023", "Farhan", "08866778899", "Denpasar", "Reguler", "55700.0", "Naufal", "Petrus", "Jl. Mawar 5 No. 11"},
            {"02-12-2023", "Chiko", "08811223344", "Malang", "Ekonomi", "87600.0", "Putra", "Saka", "Jl. Kembang 10 No. 17"},
            {"27-09-2023", "Haikal", "08887654321", "Bengkulu", "Sameday", "98800.0", "Farhan", "Vincent", "Jl. Melati 3 No. 9"},
            {"11-11-2023", "Cindy", "08899887766", "Bekasi", "Sameday", "65400.0", "Naufal", "Naufal", "Jl. Seroja 8 No. 6"},
            {"01-01-2023", "Ivan", "08812345678", "Surabaya", "Ekonomi", "45000.0", "Putra", "Abdi", "Jl. Anggrek 14 No. 20"},
            {"07-04-2023", "Luthfi", "08887654321", "Jakarta", "Reguler", "60000.0", "Farhan", "Farrel", "Jl. Kembang 1 No. 18"},
            {"14-06-2023", "Adri", "08811223344", "Bandung", "Ekonomi", "35000.0", "Naufal", "Petrus", "Jl. Melati 6 No. 13"},
            {"21-08-2023", "Alif", "08899887766", "Makassar", "Sameday", "42000.0", "Putra", "Saputra", "Jl. Anggrek 20 No. 3"},
            {"03-10-2023", "Dimas", "08876543210", "Denpasar", "Reguler", "58000.0", "Farhan", "Farrel", "Jl. Mawar 13 No. 16"},
            {"11-12-2023", "Julian", "08822334455", "Malang", "Sameday", "67000.0", "Naufal", "Naufal", "Jl. Seroja 2 No. 4"},
            {"25-02-2023", "Petrus", "08866778899", "Bogor", "Reguler", "73000.0", "Putra", "Saka", "Jl. Kembang 8 No. 1"},
            {"10-05-2023", "Saputra", "08855443322", "Surabaya", "Ekonomi", "32000.0", "Farhan", "Rio", "Jl. Mawar 14 No. 7"},
            {"15-07-2023", "Reika", "08811223344", "Semarang", "Reguler", "52000.0", "Naufal", "Chiko", "Jl. Anggrek 11 No. 15"},
            {"20-09-2023", "Rio", "08887654321", "Yogyakarta", "Sameday", "47000.0", "Putra", "Naufal", "Jl. Seroja 10 No. 2"},
            {"05-11-2023", "Saka", "08899887766", "Tangerang", "Sameday", "69000.0", "Farhan", "Chiko", "Jl. Melati 20 No. 16"},
            {"15-01-2023", "Taufik", "08876543210", "Bekasi", "Ekonomi", "40000.0", "Naufal", "Vincent", "Jl. Kembang 7 No. 19"},
            {"20-03-2023", "Mera", "08822334455", "Gorontalo", "Sameday", "61000.0", "Putra", "Saputra", "Jl. Seroja 4 No. 11"},
            {"05-05-2023", "Vincent", "08866778899", "Medan", "Reguler", "54000.0", "Farhan", "Petrus", "Jl. Anggrek 3 No. 14"},
            {"10-07-2023", "Vira", "08855443322", "Bengkulu", "Ekonomi", "37000.0", "Naufal", "Haikal", "Jl. Kembang 12 No. 9"},
            {"28-10-2023", "Innam", "08822334455", "Surabaya", "Sameday", "55000.0", "Putra", "Farrel", "Jl. Melati 9 No. 5"},
        };
        
        String labelFormat = 
                "╔══════════════════════════════════════════════╦════════════════════════════════════════════════╗\n" +
                "║            POLINEMA EXPEDITION               ║  Tanggal: %-37s║\n" +
                "╠════════════╦═════════════════════════════════╣  Berat: %-39s║\n" +
                "║            ║                                 ║  Layanan: %-37s║\n" +
                "║            ║            PENGIRIM             ║  Biaya Kirim: %-33s║\n" + 
                "║            ║                                 ║  Lokasi Pengiriman: %-27s║\n" +
                "║            ║ Nama: %-26s║                                                ║\n" +
                "║            ║ Nomor Telepon: %-17s║                                                ║\n" +
                "║            ║                                 ║  Nama Penerima: %-31s║\n" +
                "║            ║                                 ║  Alamat: %-38s║\n" +
                "╚════════════╩═════════════════════════════════╩════════════════════════════════════════════════╝";

        String laporanFormat = 
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
                "║ Total Pengiriman Per kg                           ║                 32     ║       Kg        ║\n" +
                "║ Total Pendapatan                                  ║      Rp 450.000,00     ║     Rupiah      ║\n" +
                "║                                                   ║                        ║                 ║\n" +
                "╚═══════════════════════════════════════════════════╩════════════════════════╩═════════════════╝";

        int pilihanBahasa = 1, inputPilihanBahasa;

        // Array Multi Bahasa
        String[][] multilingual = {
            {"Welcome to the Expedition System", "Selamat Datang di Sistem Ekspedisi"},

            {"Delivery of Goods", "Pengiriman Barang"}, //1
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
            {"Location Management", "Manajemen Lokasi"}, //11
                // Bahasa menu manajemen lokasi
                {"Add Location", "Menambahkan Lokasi"},
                {"Remove Location", "Menghapus Lokasi"},
                {"Displays Location's Data", "Menampilkan Data Lokasi"},
                {"Back to the Main Menu", "Kembali ke Menu Utama"},
            {"Cost Management", "Manajemen Tarif"}, //16
                // Bahasa menu Manajemen Tarif
                {"Add Service Types", "Tambahkan Jenis Layanan"},
                {"Change Cost Service", "Merubah Tarif Layanan"},
                {"Remove Service", "Menghapus Layanan"},
                {"Displays Services' Data", "Menampilkan Layanan Data"},
                {"Exit", "Keluar"}, 
            {"Change Language", "Ganti Bahasa"},
            {"Exit", "Keluar"},

            // Bahasa input pilihan
            {"Enter Options: ", "Masukkan Pilihan: "}, 

        };

        // Format tanggal
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        String tanggalHariIni = dateFormat.format(date);
        String inputanTanggalAwal = "00-00-000", inputanTanggalAkhir = "00-00-0000";

        System.out.println("═════════════════════════════════════════════");
        System.out.println("\u001B[33m     Selamat Datang di Sistem Ekspedisi     \u001B[0m");
        System.out.println("═════════════════════════════════════════════");

        while (!login) {
            login = false;
            found = false;
            exit = false;
            isLoop = false;
            isAdmin = false;
            masuk = false;
            while (!masuk) {
                System.out.print("Masukkan Username: ");
                String inputUsername = input.next();

                System.out.print("Masukan Password: ");
                String inputPassword = input.next();

                for (int i = 0; i < userData.length ; i++ ) {
                    if (userData[i][0].equals(inputUsername) && userData[i][1].equals(inputPassword)) {
                        System.out.println("Login Berhasil");
                        login = true;
                        masuk = true;
                        loggedInUsername = inputUsername;
                        
                        if("admin".equals(inputUsername)){
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
                System.out.println("═════════════════════════════════════════════");
                System.out.println("\u001B[33m" + multilingual[0][pilihanBahasa]+   "\u001B[0m");
                System.out.println("═════════════════════════════════════════════");
                if(isAdmin){
                    System.out.println("[0]. " + "Manajemen Pengguna");
                }
                System.out.println("[1]. " + multilingual[1][pilihanBahasa]); //Pengiriman Barang
                System.out.println("[2]. " + multilingual[11][pilihanBahasa]); //Manajemen Lokasi
                System.out.println("[3]. " + multilingual[16][pilihanBahasa]); //Manajemen Tarif
                System.out.println("[4]. " + multilingual[22][pilihanBahasa]); //Ganti Bahasa
                System.out.println("[5]. Laporan Ekspedisi");
                System.out.println("[6]. " + multilingual[23][pilihanBahasa]); //Keluar
                System.out.println("═════════════════════════════════════════════");

                System.out.print(multilingual[24][pilihanBahasa]);
                menuUtama = input.nextInt();
                input.nextLine();

                isLoop = true;

                do {
                    switch (menuUtama) {
                        case 0:
                            if(isAdmin){
                                while(!exit) {
                                System.out.println("═══════════════════════════════════════");
                                System.out.println("Menu");
                                System.out.println("═══════════════════════════════════════");
                                System.out.println("[1] Tambahkan Pengguna");
                                System.out.println("[2] Hapus Pengguna");
                                System.out.println("[3] Data Pengguna");
                                System.out.println("[4] Keluar");
                                System.out.println("═══════════════════════════════════════");

                                System.out.print("Masukan Pilihan: ");
                                int pilihan = input.nextInt();

                                switch (pilihan) {
                                    case 1:
                                    System.out.print("Masukan nama pengguna baru: ");
                                    String usernameBaru = input.next();
                                    System.out.print("Masukan kata sandi baru: ");
                                    String katasandiBaru = input.next();
                                    System.out.print("Masukkan jabatan pengguna baru: ");
                                    String jabatanBaru = input.next();
                                
                                    String[][] newUser = {
                                            {usernameBaru, katasandiBaru, jabatanBaru}
                                    };
                                
                                    // Menggabungkan array userData dengan newUser
                                    String[][] tempUserData = new String[userData.length + newUser.length][userData[0].length];
                                    System.arraycopy(userData, 0, tempUserData, 0, userData.length);
                                    System.arraycopy(newUser, 0, tempUserData, userData.length, newUser.length);
                                    userData = tempUserData;
                                
                                    System.out.println("Pengguna baru berhasil ditambahkan!!!");
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

                                        System.out.println("╔════════════════════════════════════════════════╗");
                                        System.out.println("║                 Data Pengguna                  ║");
                                        System.out.println("╠════════════════╦════════════════╦══════════════╣");
                                        System.out.println("║ Username       ║ Password       ║ Jabatan      ║");
                                        System.out.println("╠════════════════╬════════════════╬══════════════╣");

                                        for (int i = 0; i < userData.length; i++) {
                                            System.out.printf("║ %-14s ║ %-14s ║ %-12s ║%n", userData[i][0], userData[i][1], userData[i][2]);
                                        }
                                        System.out.println("╚════════════════╩════════════════╩══════════════╝");
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
                            System.out.println("═════════════════════════════════════════════");
                            System.out.println("\u001B[33m           Pengiriman Barang          \u001B[0m");
                            System.out.println("═════════════════════════════════════════════");
                            System.out.println("[1]. Melakukan Transaksi"); //Melakukan Transaksi
                            System.out.println("[2]. Mengedit Data Transaksi"); //Mengedit Transaksi
                            System.out.println("[3]. Menghapus Data Transaksi"); //Menghapus Transaksi
                            System.out.println("[4]. Menampilkan Data Transaksi"); //Menampilkan Data Transaksi
                            System.out.println("[5]. Kembali ke Menu Utama"); //Kembali ke Menu Utama
                            System.out.println("═════════════════════════════════════════════");
                            System.out.print("Masukkan Pilihan: "); 

                            subMenu = input.nextInt();
                            input.nextLine();

                            switch (subMenu) {
                                case 1:
                                    int beratBarang;
                                    String lokasiPengiriman;

                                    System.out.print ("Masukkan Nama Pengirim: ");
                                    String namaPengirim = input.nextLine();

                                    System.out.print ("Masukkan Nomor Kontak: ");
                                    String nomorKontak = input.nextLine();

                                    System.out.print ("Masukkan Nama Penerima: ");
                                    String namaPenerima = input.nextLine();

                                    System.out.print ("Masukkan Alamat: ");
                                    String alamatPenerima = input.nextLine();

                                    do {
                                        System.out.print("Masukkan Berat Barang: ");
                                        while (!input.hasNextInt()) {
                                            System.out.println("Input harus berupa bilangan bulat. Silakan coba lagi.");
                                            System.out.print("Masukkan Berat Barang: ");
                                            input.next(); // mengonsumsi input yang tidak valid
                                        }
                                        beratBarang = input.nextInt();
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
                                        System.out.print ("Masukkan Kota Tujuan: ");
                                        lokasiPengiriman = input.next();
                                        for (int i = 0; i < arrayLokasi.length; i++) {
                                            if (arrayLokasi[i] != null && arrayLokasi[i].equalsIgnoreCase(lokasiPengiriman)) {
                                                biayaJarak = arrayTarifLokasi[i];
                                                found = true;
                                                break;
                                            }
                                        }
                                        if(!found) {
                                            System.out.print ("Kota Tujuan tidak Ditemukan!");
                                        }    
                                    } while (!found);
                                    found = false;

                                    //Memilih Jenis Layanan pada Array

                                    for (int i = 0; i < arrayLayanan.length; i++) {
                                        if (arrayLayanan[i] != null) {
                                            System.out.println("["+i+"]. "+arrayLayanan[i]+" - "+arrayTarifLayanan[i]);
                                            
                                        }
                                    }
                                    System.out.print ("Masukkan Pilihan: ");
                                    pilihanLayanan = input.nextInt();
                                    tarifLayanan = arrayTarifLayanan[pilihanLayanan];                      

                                    double biayaAkhir = tarifLayanan + (tarifPerKg * beratBarang) + biayaJarak;

                                    historyTransaksi = Arrays.copyOf(historyTransaksi,historyTransaksi.length + 1);
                                    historyTransaksi[historyTransaksi.length-1] = new String[]{
                                        tanggalHariIni,
                                        namaPengirim,
                                        nomorKontak,
                                        lokasiPengiriman,
                                        arrayLayanan[pilihanLayanan],
                                        Double.toString(biayaAkhir),
                                        loggedInUsername,
                                        namaPenerima,
                                        alamatPenerima};

                                    System.out.println(String.format(
                                        labelFormat,
                                        tanggalHariIni, // Tanggal
                                        beratBarang, // Berat
                                        arrayLayanan[pilihanLayanan], // Nomor Telepon
                                        biayaAkhir, // Biaya Akhir
                                        lokasiPengiriman, // Lokasi
                                        namaPengirim,
                                        nomorKontak,
                                        namaPenerima,
                                        alamatPenerima
                                    ));                                        
                                    break;
                                case 2:
                                    System.out.println("Under Development"); 
                                    break;
                                case 3:
                                    System.out.println("Under Development"); 
                                    break;
                                case 4:
                                    System.out.println("═════════════════════════════════════════════");
                                    System.out.println("\u001B[33m           History Transaksi           \u001B[0m");
                                    System.out.println("═════════════════════════════════════════════");
                                    System.out.println("[1]. Berdasarkan Rentang Tanggal");
                                    System.out.println("[2]. Hari ini");
                                    System.out.println("[3]. Bulan ini");
                                    System.out.println("[4]. Tahun ini");
                                    System.out.println("[5]. Kembali ke Menu Utama");
                                    System.out.println("═════════════════════════════════════════════");
                                    System.out.print("Masukkan Pilihan: ");
                                    editMenu = input.nextInt();
                                    switch (editMenu) {
                                        case 1:
                                            try {
                                                System.out.print("Masukkan Tanggal Awal (dd-MM-yyyy): ");
                                                inputanTanggalAwal = input.next();
                                                System.out.print("Masukkan Tanggal Akhir (dd-MM-yyyy): ");
                                                inputanTanggalAkhir = input.next();
                                                Date startDate = dateFormat.parse(inputanTanggalAwal);
                                                Date endDate = dateFormat.parse(inputanTanggalAkhir);
                                                System.out.println("══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════"); 
                                                System.out.println("                                                                     History Transaksi");
                                                System.out.println("══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════"); 
                                                System.out.println(" No  |   Tanggal   |  Nama Pengirim  |  Nomor Kontak  |   Tujuan    |  Jenis Layanan  |  Biaya  |   Kasir   |  Nama Penerima  |         Alamat Penerima");
                                                System.out.println("══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════");                                                   for (int i = 0; i < historyTransaksi.length; i++) {
                                                    if (historyTransaksi[i][0] != null){
                                                        Date transaksiDate = dateFormat.parse(historyTransaksi[i][0]);
                                                        if (transaksiDate.compareTo(startDate) >= 0 && transaksiDate.compareTo(endDate) <= 0) {
                                                            System.out.println(String.format(" %3d | %11s | %15s | %14s | %11s | %15s | %5s | %9s | %15s | %29s",
                                                                i,
                                                                historyTransaksi[i][0], // Tanggal
                                                                historyTransaksi[i][1], // Nama
                                                                historyTransaksi[i][2], // Nomor Telepon
                                                                historyTransaksi[i][3], // Lokasi
                                                                historyTransaksi[i][4], // Jenis Layanan
                                                                historyTransaksi[i][5], // Tarif
                                                                historyTransaksi[i][6], // Nama Kasir
                                                                historyTransaksi[i][7], // Nama Penerima
                                                                historyTransaksi[i][8]  // Alamat Penerima
                                                            ));
                                                        }
                                                    }
                                                }
                                                System.out.println("══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════"); 
                                                break;
                                            } catch (ParseException e) {
                                                e.printStackTrace();
                                            }
                                            break;
                                        case 2:
                                            try {
                                                Date startDate = dateFormat.parse(tanggalHariIni);
                                                Date endDate = dateFormat.parse(tanggalHariIni);
                                                System.out.println("══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════"); 
                                                System.out.println("                                                                     History Transaksi");
                                                System.out.println("══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════"); 
                                                System.out.println(" No  |   Tanggal   |  Nama Pengirim  |  Nomor Kontak  |   Tujuan    |  Jenis Layanan  |  Biaya  |   Kasir   |  Nama Penerima  |         Alamat Penerima");
                                                System.out.println("══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════");                                                   for (int i = 0; i < historyTransaksi.length; i++) {
                                                    if (historyTransaksi[i][0] != null){
                                                        Date transaksiDate = dateFormat.parse(historyTransaksi[i][0]);
                                                        if (transaksiDate.compareTo(startDate) >= 0 && transaksiDate.compareTo(endDate) <= 0) {
                                                            System.out.println(String.format(" %3d | %11s | %15s | %14s | %11s | %15s | %5s | %9s | %15s | %29s",
                                                                i,
                                                                historyTransaksi[i][0], // Tanggal
                                                                historyTransaksi[i][1], // Nama
                                                                historyTransaksi[i][2], // Nomor Telepon
                                                                historyTransaksi[i][3], // Lokasi
                                                                historyTransaksi[i][4], // Jenis Layanan
                                                                historyTransaksi[i][5], // Tarif
                                                                historyTransaksi[i][6], // Nama Kasir
                                                                historyTransaksi[i][7], // Nama Penerima
                                                                historyTransaksi[i][8]  // Alamat Penerima
                                                            ));
                                                        }
                                                    }
                                                }
                                                System.out.println("══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════"); 
                                                break;
                                            } catch (ParseException e) {
                                                e.printStackTrace();
                                            }
                                            break;
                                        case 3:
                                            try {
                                                Calendar calendar = Calendar.getInstance();
                                                calendar.set(Calendar.DAY_OF_MONTH, 1); // Set the day of the month to the first day
                                                Date startDate = calendar.getTime();

                                                calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
                                                Date endDate = calendar.getTime();

                                                System.out.println("══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════"); 
                                                System.out.println("                                                                     History Transaksi");
                                                System.out.println("══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════"); 
                                                System.out.println(" No  |   Tanggal   |  Nama Pengirim  |  Nomor Kontak  |   Tujuan    |  Jenis Layanan  |  Biaya  |   Kasir   |  Nama Penerima  |         Alamat Penerima");
                                                System.out.println("══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════");   
                                                for (int i = 0; i < historyTransaksi.length; i++) {
                                                    if (historyTransaksi[i][0] != null) {
                                                        Date transaksiDate = dateFormat.parse(historyTransaksi[i][0]);
                                                        if (transaksiDate.compareTo(startDate) >= 0 && transaksiDate.compareTo(endDate) <= 0) {
                                                            System.out.println(String.format(" %3d | %11s | %15s | %14s | %11s | %15s | %5s | %9s | %15s | %29s",
                                                                i,
                                                                historyTransaksi[i][0], // Tanggal
                                                                historyTransaksi[i][1], // Nama
                                                                historyTransaksi[i][2], // Nomor Telepon
                                                                historyTransaksi[i][3], // Lokasi
                                                                historyTransaksi[i][4], // Jenis Layanan
                                                                historyTransaksi[i][5], // Tarif
                                                                historyTransaksi[i][6], // Nama Kasir
                                                                historyTransaksi[i][7], // Nama Penerima
                                                                historyTransaksi[i][8]  // Alamat Penerima
                                                            ));
                                                        }
                                                    }
                                                }

                                                System.out.println("══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════"); 
                                                break;
                                                } catch (ParseException e) {
                                                    e.printStackTrace();
                                                }
                                                break;
                                        case 4:
                                            try {
                                                Calendar calendar = Calendar.getInstance();
                                                calendar.set(Calendar.MONTH, calendar.JANUARY); 
                                                calendar.set(calendar.DAY_OF_MONTH,1);
                                                Date startDate = calendar.getTime();

                                                calendar.set(Calendar.MONTH, Calendar.DECEMBER);
                                                calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
                                                Date endDate = calendar.getTime();

                                                System.out.println("══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════"); 
                                                System.out.println("                                                                     History Transaksi");
                                                System.out.println("══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════"); 
                                                System.out.println(" No  |   Tanggal   |  Nama Pengirim  |  Nomor Kontak  |   Tujuan    |  Jenis Layanan  |  Biaya  |   Kasir   |  Nama Penerima  |         Alamat Penerima");
                                                System.out.println("══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════");    

                                                for (int i = 0; i < historyTransaksi.length; i++) {
                                                    if (historyTransaksi[i][0] != null) {
                                                        Date transaksiDate = dateFormat.parse(historyTransaksi[i][0]);
                                                        if (transaksiDate.compareTo(startDate) >= 0 && transaksiDate.compareTo(endDate) <= 0) {
                                                            System.out.println(String.format(" %3d | %11s | %15s | %14s | %11s | %15s | %5s | %9s | %15s | %29s",
                                                                i,
                                                                historyTransaksi[i][0], // Tanggal
                                                                historyTransaksi[i][1], // Nama
                                                                historyTransaksi[i][2], // Nomor Telepon
                                                                historyTransaksi[i][3], // Lokasi
                                                                historyTransaksi[i][4], // Jenis Layanan
                                                                historyTransaksi[i][5], // Tarif
                                                                historyTransaksi[i][6], // Nama Kasir
                                                                historyTransaksi[i][7], // Nama Penerima
                                                                historyTransaksi[i][8]  // Alamat Penerima
                                                            ));
                                                        }
                                                    }
                                                }

                                                System.out.println("══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════"); 
                                                break;
                                                } catch (ParseException e) {
                                                    e.printStackTrace();
                                                }
                                                break; 
                                            
                                        case 5:
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
                            System.out.println("═════════════════════════════════════════════");
                            System.out.println("\u001B[33m Manajemen Lokasi   \u001B[0m");
                            System.out.println("═════════════════════════════════════════════");

                            System.out.println("[1]. Menambah Lokasi"); //Menambahkan Lokasi
                            System.out.println("[2]. Menghapus Lokasi"); //Menghapus Lokasi
                            System.out.println("[3]. Menampilkan Data Lokasi"); //Menampilkan Data Lokasi
                            System.out.println("[4]. Kembali ke Menu Utama"); //Kembali ke Menu Utama
                            System.out.println("═════════════════════════════════════════════");
                            System.out.print("Masukkan Pilihan: "); 
                            subMenu = input.nextInt();

                            input.nextLine();
                
                            switch (subMenu) {
                                case 1:
                                    System.out.print("Masukkan nama lokasi: ");
                                    String lokasiBaru = input.nextLine();
                                    
                                    
                                    while (!inputValid) {
                                        System.out.print("Masukkan tarif: ");
                                        if (input.hasNextDouble()) {
                                            tarifBaru = input.nextDouble();
                                            inputValid = true;
                                        } else {
                                            System.out.println("Masukan bukan angka. Mohon masukkan angka.");
                                            input.next(); // Menghapus input yang tidak valid agar tidak terjadi infinite loop
                                        }
                                    arrayLokasi = Arrays.copyOf(arrayLokasi,arrayLokasi.length + 1);
                                    arrayLokasi[arrayLokasi.length-1] = lokasiBaru;
                                    arrayTarifLokasi = Arrays.copyOf(arrayTarifLokasi,arrayTarifLokasi.length + 1);
                                    arrayTarifLokasi[arrayTarifLokasi.length-1] = tarifBaru;
                                
                                    }
                                    break;
                                case 2:
                                    System.out.println("Daftar Lokasi yang Tersedia:");
                                    for (int i = 0; i < arrayLokasi.length; i++) {
                                        System.out.println((i + 1) + ". " + arrayLokasi[i]);
                                    }
                        
                                    int deleteIndex = 0;
            

                                    // Validation loop for non-integer input
                                    while (!validInput) {
                                        System.out.print("Masukkan nomor lokasi yang ingin dihapus: ");
                                        try {
                                            deleteIndex = Integer.parseInt(input.nextLine());
                                            validInput = true;
                                        } catch (NumberFormatException e) {
                                            System.out.println("Input yang dimasukkan bukan angka. Silakan masukkan nomor.");
                                        }
                                    }

                                    if (deleteIndex >= 1 && deleteIndex <= arrayLokasi.length) {
                                        String deletedLocation = arrayLokasi[deleteIndex - 1];
                                        System.out.println(deletedLocation + " Telah Dihapus!");

                                        System.arraycopy(arrayLokasi, deleteIndex, arrayLokasi, deleteIndex - 1, arrayLokasi.length - deleteIndex);
                                        arrayLokasi = Arrays.copyOf(arrayLokasi, arrayLokasi.length - 1);

                                        System.arraycopy(arrayTarifLokasi, deleteIndex, arrayTarifLokasi, deleteIndex - 1, arrayTarifLokasi.length - deleteIndex);
                                        arrayTarifLokasi = Arrays.copyOf(arrayTarifLokasi, arrayTarifLokasi.length - 1);
                                    } else {
                                        System.out.println("Nomor lokasi tidak valid");
                                        continue;
                                    }

                                    if (found) {
                                        found = false;
                                    } else {
                                        System.out.println("Key tidak ditemukan");
                                    }                                           
                                    break;
                                case 3:
                                    System.out.println("═════════════════════════════════════════════");
                                    System.out.println("\u001B[33m           Data Lokasi           \u001B[0m");
                                    System.out.println("═════════════════════════════════════════════");
                                    System.out.println(" No  |    Nama Kota   |  Biaya");
                                    System.out.println("═════════════════════════════════════════════");
                                    for (int i = 0; i < arrayLokasi.length; i++) {
                                        String formattedString = String.format(" %3d | %14s | %5s",
                                                i,
                                                arrayLokasi[i], // Nama Kota
                                                arrayTarifLokasi[i] // Tarif
                                        );
                                        System.out.println(formattedString);
                                    }
                                    break;
                                case 4:
                                    keluar = false;
                                    break;
                                default:
                                System.out.println("Invalid choice. Please try again.");
                                }
                        } break;
                        case 3:
                            System.out.println("═════════════════════════════════════════════");
                            System.out.println("\u001B[33mManajemen Tarif\u001B[0m");
                            System.out.println("═════════════════════════════════════════════");

                            System.out.println("[1]. Tambah Jenis Layanan"); //Tambahan Jenis Layanan
                            System.out.println("[2]. Merubah Tarif Layanan"); //Merubah Tarif Layanan
                            System.out.println("[3]. Menghapus Layanan"); //Menghapus Layanan
                            System.out.println("[4]. Menampilkan Layanan Data"); //Menampilkan Layanan Data
                            System.out.println("[5]. Keluar"); //Keluar

                            System.out.println("═════════════════════════════════════════════");
                            System.out.print("Masukkan Pilihan: ");
                            subMenu = input.nextInt();
                            input.nextLine();

                            switch (subMenu) {
                                case 1:
                                    for (int i = 0; i < arrayLayanan.length; i++) {
                                        if (arrayLayanan[i] == null) {
                                            System.out.print("Masukkan Nama Layanan: ");
                                            arrayLayanan[i] = input.next();
                                            while (!inputValid) {
                                                System.out.print("Masukkan Tarif: ");
                                                if (input.hasNextDouble()) {
                                                    tarifLayanan = input.nextDouble();
                                                    inputValid = true;
                                                } else {
                                                    System.out.println("Masukan bukan angka. Mohon masukkan angka.");
                                                    input.next(); // Membersihkan input yang tidak valid dari buffer
                                                }
                                            }
                            
                                            arrayTarifLayanan[i] = tarifLayanan;
                                            break;
                                        }
                                    }
                                    break;
                                case 2:
                                System.out.println("Daftar Layanan yang Tersedia:");
                                for (int i = 0; i < arrayLayanan.length; i++) {
                                    
                                    if (arrayLayanan[i] != null){
                                        System.out.println((i + 1) + ". " + arrayLayanan[i] );

                                    }
                                }
                        
                                System.out.print("Masukkan nomor layanan yang ingin diubah: ");
                                int selectedService = 0;

                                while (!inputValid) {
                                    if (input.hasNextInt()) {
                                        selectedService = input.nextInt();
                                        if (selectedService >= 1 && selectedService <= arrayLayanan.length) {
                                            inputValid = true;
                                        } else {
                                            System.out.println("Nomor layanan tidak valid. Masukkan nomor layanan yang valid:");
                                            input.nextLine(); // Membersihkan newline di buffer
                                        }
                                    } else {
                                        System.out.println("Input bukan angka. Mohon masukkan nomor layanan yang valid:");
                                        input.next(); // Membersihkan input yang tidak valid dari buffer
                                    }
                                }

                                inputValid = false; // Reset inputValid untuk validasi berikutnya

                                if (selectedService >= 1 && selectedService <= arrayLayanan.length) {
                                    System.out.println("Pilih yang ingin diubah:");
                                    System.out.println("1. Nama Layanan");
                                    System.out.println("2. Tarif Layanan");
                                    System.out.print("Masukkan nomor pilihan: ");
                                    int changeOption = 0;

                                    while (!inputValid) {
                                        if (input.hasNextInt()) {
                                            changeOption = input.nextInt();
                                            if (changeOption == 1 || changeOption == 2) {
                                                inputValid = true;
                                            } else {
                                                System.out.println("Pilihan tidak valid. Masukkan nomor pilihan yang valid:");
                                                input.nextLine(); // Membersihkan newline di buffer
                                            }
                                        } else {
                                            System.out.println("Input bukan angka. Mohon masukkan nomor pilihan yang valid:");
                                            input.next(); // Membersihkan input yang tidak valid dari buffer
                                        }
                                    }

                                    if (changeOption == 1) {
                                        System.out.print("Masukkan Nama Layanan Baru: ");
                                        input.nextLine(); // Membersihkan newline di buffer
                                        arrayLayanan[selectedService - 1] = input.nextLine();
                                        System.out.println("Data nama layanan berhasil diupdate.");
                                    } else if (changeOption == 2) {
                                        double newTarif = 0.0;
                                        inputValid = false; // Reset inputValid untuk validasi berikutnya

                                        while (!inputValid) {
                                            System.out.print("Masukkan Tarif Baru: ");
                                            if (input.hasNextDouble()) {
                                                newTarif = input.nextDouble();
                                                inputValid = true;
                                            } else {
                                                System.out.println("Masukan bukan angka. Mohon masukkan angka.");
                                                input.next(); // Membersihkan input yang tidak valid dari buffer
                                            }
                                        }

                                        arrayTarifLayanan[selectedService - 1] = newTarif;
                                        System.out.println("Data tarif layanan berhasil diupdate.");
                                        break;
                                    }
                                } else {
                                    System.out.println("Nomor layanan tidak valid");
                                }
                                break;
                                case 3:
                                    System.out.println("Daftar Layanan yang Tersedia:");
                                    for (int i = 0; i < arrayLayanan.length; i++) {
                                        if (arrayLayanan[i] != null) {
                                            System.out.println((i + 1) + ". " + arrayLayanan[i]);
                                        }
                                    }
                        
                                    int selectedNumber = 0;
        
                                    while (!validInput) {
                                        try {
                                            System.out.print("Pilih nomor layanan yang ingin dihapus: ");
                                            selectedNumber = input.nextInt();
                                            validInput = true;
                                        } catch (InputMismatchException e) {
                                            System.out.println("Masukan bukan angka. Silakan masukkan nomor layanan yang valid.");
                                            input.nextLine(); // Membersihkan buffer
                                        }
                                    }

                                    if (selectedNumber > 0 && selectedNumber <= arrayLayanan.length) {
                                        String pilih = arrayLayanan[selectedNumber - 1];

                                        for (int i = 0; i < arrayLayanan.length; i++) {
                                            if (arrayLayanan[i] != null && arrayLayanan[i].equalsIgnoreCase(pilih)) {
                                                System.out.println(arrayLayanan[i] + " - " + arrayTarifLayanan[i] + " Telah Dihapus!");
                                                arrayLayanan[i] = null;
                                                arrayTarifLayanan[i] = 0;
                                                break;
                                            }
                                        }
                                    } else {
                                        System.out.println("Nomor layanan tidak valid.");
                                    }
                                    break;
                                case 4:
                                        System.out.println("═════════════════════════════════════════════");
                                        System.out.println("\u001B[33m           Data Layanan           \u001B[0m");
                                        System.out.println("═════════════════════════════════════════════");
                                        System.out.println(" No  |   Nama Layanan   |  Biaya");
                                        System.out.println("═════════════════════════════════════════════");
                                    for (int i = 0; i < arrayLayanan.length; i++) {
                                        if (arrayLayanan[i] != null) {
                                             String formattedString = String.format(" %3d | %16s | %5s",
                                                i,
                                                arrayLayanan[i], // Nama Kota
                                                arrayTarifLayanan[i] // Tarif
                                        );
                                        System.out.println(formattedString);
                                        }
                                    }
                                    break;
                                case 5:
                                    isLoop = false;
                                    break;
                                default:
                                System.out.println("Invalid choice. Please try again.");
                            }
                            break;

                        case 4:
                            do {
                                System.out.println("Pilih bahasa (Choose a language):");
                                System.out.println("1. English");
                                System.out.println("2. Indonesian");
                                System.out.print("Masukkan Pilihan: ");
                                inputPilihanBahasa = input.nextInt();

                                switch (inputPilihanBahasa) {
                                    case 1:
                                        pilihanBahasa = inputPilihanBahasa-1;
                                        break;
                                    case 2:
                                        pilihanBahasa = inputPilihanBahasa-1;
                                        break;
                                    default:
                                        System.out.println("Invalid choice. Please try again.");
                                }
                            } while (inputPilihanBahasa > multilingual[0].length);
                            break;
                        case 5:
                            int totalAsset=0, totalBerat=0, totalHarga=0;
                            System.out.println(totalAsset=historyTransaksi.length);
                            System.out.println(String.format(
                                        laporanFormat,
                                        totalAsset
                                    ));               
                            break;
                        case 6:
                            exit=true;
                            login=false;
                            masuk=false;
                            break;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                            break;
                    }
                    break;
                } while (isLoop);
                


            } while(!exit);
        }
    }
}
