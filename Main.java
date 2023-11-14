import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
            {"admin","admin123"},
            {"Naufal", "000"},
            {"Putra", "111"},
            {"Farhan", "222"}};

        String loggedInUsername = "";

        // Lokasi default
        String[][] arrayLokasi = {
            {"Malang", "1"},
            {"Surabaya", "2"},
            {"Semarang", "2"},
            {"Yogyakarta", "3"},
            {"Magelang", "3"},
            {"Pekalongan", "3"},
            {"Cirebon", "4"},
            {"Bandung", "4"},
            {"Bekasi", "4"},
            {"Bogor", "4"},
            {"Jakarta", "5"},
            {"Banten", "5"},
            {"Serang", "5"},
            {"Lumajang", "2"},
            {"Banyuwangi", "3"}
        };


            // "Malang", "Jakarta", "Surabaya", "Bandung", "Medan",
            // "Makassar", "Yogyakarta", "Semarang", "Denpasar", "Serang",
            // "Tangerang", "Bengkulu", "Gorontalo", "Bekasi", "Bogor"
        };
        
        // Tarif berdasarkan tujuan pengiriman
        double[] arrayTarifLokasi = {
            8000, 45000, 25000, 16000, 23000, 
            34000, 36000, 23000, 12000, 18000, 
            27000, 30000, 22000, 31000, 19000
        };
        
            
        // Layanan pengiriman default
        String[][] arrayLayanan = {
            {"Reguler", "3"},
            {"Ekonomi", "2"},
            {"Sameday", "1"}
        };
            

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

        // Variabel untuk switch case menu
        int menuUtama, subMenu, editMenu;

        // Variabel Searching
        String key;
        int beratBarang;
        double biayaAkhir;
        String lokasiPengiriman;
        double tarifPerKg = 5000;
        int pilihanLayanan;
        double tarifLayanan = 0;
        String namaPengirim, nomorKontak;
        double biayaJarak = 0;

        // Array History Pemesanan
        String[][] historyTransaksi = {
            {"1", "29-01-2023", "Nanda", "08866778899", "Yogyakarta", "Reguler", "25700.0", "Farhan"},
            {"2", "12-02-2023", "Gabriel", "08811223344", "Tangerang", "Ekonomi", "33200.0", "Naufal"},
            {"3", "03-03-2023", "Afifah", "08876543210", "Makassar", "Reguler", "50900.0", "Putra"},
            {"4", "26-04-2023", "Esa", "08822334455", "Medan", "Ekonomi", "65400.0", "Farhan"},
            {"5", "21-05-2023", "Abdi", "08811223344", "Bogor", "Ekonomi", "34800.0", "Naufal"},
            {"6", "17-06-2023", "Naufal", "08822334455", "Semarang", "Sameday", "66500.0", "Putra"},
            {"7", "30-06-2023", "Farrel", "08855443322", "Jakarta", "Reguler", "76800.0", "Farhan"},
            {"14-07-2023", "Atabik", "08855443322", "Bandung", "Ekonomi", "45300.0", "Naufal"},
            {"05-08-2023", "Dio", "08876543210", "Surabaya", "Sameday", "29100.0", "Putra"},
            {"09-09-2023", "Pasha", "08899887766", "Serang", "Reguler", "78000.0", "Farhan"},
            {"18-10-2023", "Farhan", "08866778899", "Denpasar", "Reguler", "55700.0", "Naufal"},
            {"02-12-2023", "Chiko", "08811223344", "Malang", "Ekonomi", "87600.0", "Putra"},
            {"27-09-2023", "Haikal", "08887654321", "Bengkulu", "Sameday", "98800.0", "Farhan"},
            {"11-11-2023", "Cindy", "08899887766", "Bekasi", "Sameday", "65400.0", "Naufal"},
            {"01-01-2023", "Ivan", "08812345678", "Surabaya", "Ekonomi", "45000.0", "Putra"},
            {"07-04-2023", "Luthfi", "08887654321", "Jakarta", "Reguler", "60000.0", "Farhan"},
            {"14-06-2023", "Adri", "08811223344", "Bandung", "Ekonomi", "35000.0", "Naufal"},
            {"21-08-2023", "Alif", "08899887766", "Makassar", "Sameday", "42000.0", "Putra"},
            {"03-10-2023", "Dimas", "08876543210", "Denpasar", "Reguler", "58000.0", "Farhan"},
            {"11-12-2023", "Julian", "08822334455", "Malang", "Sameday", "67000.0", "Naufal"},
            {"25-02-2023", "Petrus", "08866778899", "Bogor", "Reguler", "73000.0", "Putra"},
            {"10-05-2023", "Saputra", "08855443322", "Surabaya", "Ekonomi", "32000.0", "Farhan"},
            {"15-07-2023", "Reika", "08811223344", "Semarang", "Reguler", "52000.0", "Naufal"},
            {"20-09-2023", "Rio", "08887654321", "Yogyakarta", "Sameday", "47000.0", "Putra"},
            {"05-11-2023", "Saka", "08899887766", "Tangerang", "Sameday", "69000.0", "Farhan"},
            {"15-01-2023", "Taufik", "08876543210", "Bekasi", "Ekonomi", "40000.0", "Naufal"},
            {"20-03-2023", "Mera", "08822334455", "Gorontalo", "Sameday", "61000.0", "Putra"},
            {"05-05-2023", "Vincent", "08866778899", "Medan", "Reguler", "54000.0", "Farhan"},
            {"10-07-2023", "Vira", "08855443322", "Bengkulu", "Ekonomi", "37000.0", "Naufal"},
            {"28-10-2023", "Innam", "08822334455", "Surabaya", "Sameday", "55000.0", "Putra"},
        };
        
        String labelFormat = 
                "=================================================================================================\n" +
                "|            POLINEMA EXPEDITION               |  Tanggal: %-37s|\n" +
                "================================================  Berat: %-39s|\n" +
                "|            |                                 |  Layanan: %-37s|\n" +
                "|            |            PENGIRIM             |  Biaya Kirim: %-33s|\n" + 
                "|            |                                 |  Lokasi Pengiriman: %-27s|\n" +
                "|            | Nama: %-26s|                                                |\n" +
                "|            | Nomor Telepon: %-17s|                                                |\n" +
                "|            |                                 |                                                |\n" +
                "|            |                                 |                                                |\n" +
                "=================================================================================================";

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

        System.out.println("=============================================");
        System.out.println("\u001B[33m     Selamat Datang di Sistem Ekspedisi     \u001B[0m");
        System.out.println("=============================================");
        

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
                System.out.println("=============================================");
                System.out.println("\u001B[33m" + multilingual[0][pilihanBahasa]+   "\u001B[0m");
                System.out.println("=============================================");
                if(isAdmin){
                    System.out.println("[0]. " + "Manajemen Pengguna");
                }
                System.out.println("[1]. " + multilingual[1][pilihanBahasa]); //Pengiriman Barang
                System.out.println("[2]. " + multilingual[11][pilihanBahasa]); //Manajemen Lokasi
                System.out.println("[3]. " + multilingual[16][pilihanBahasa]); //Manajemen Tarif
                System.out.println("[4]. " + multilingual[22][pilihanBahasa]); //Ganti Bahasa
                System.out.println("[5]. " + multilingual[23][pilihanBahasa]); //Keluar
                System.out.println("=============================================");

                System.out.print(multilingual[24][pilihanBahasa]);
                menuUtama = input.nextInt();
                input.nextLine();

                isLoop = true;

                do {
                    switch (menuUtama) {
                        case 0:
                            if(isAdmin){
                                while(!exit) {
                                System.out.println("=======================================");
                                System.out.println("Menu");
                                System.out.println("=======================================");
                                System.out.println("[1] Tambahkan Pengguna");
                                System.out.println("[2] Hapus Pengguna");
                                System.out.println("[3] Data Pengguna");
                                System.out.println("[4] Keluar");
                                System.out.println("=======================================");

                                System.out.print("Masukan Pilihan: ");
                                int pilihan = input.nextInt();

                                switch (pilihan) {
                                    case 1:
                                        System.out.print("Masukan nama pengguna baru: ");
                                        String usernameBaru = input.next();
                                        System.out.print("Masukan kata sandi baru: ");
                                        String katasandiBaru = input.next();

                                        userData = Arrays.copyOf(userData,userData.length + 1);
                                        userData[userData.length-1] = new String[]{usernameBaru,katasandiBaru};

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
                                        System.out.println("Invalid");
                                        break;
                                }                
                            }
                            }
                            exit = false;
                            break;
                                
                                
                        case 1:
                            System.out.println("=============================================");
                            System.out.println("\u001B[33m           Pengiriman Barang          \u001B[0m");
                            System.out.println("=============================================");
                            System.out.println("[1]. Melakukan Transaksi"); //Melakukan Transaksi
                            //System.out.println("[2]. Mengedit Data Transaksi"); //Mengedit Transaksi
                            System.out.println("[2]. Menghapus Data Transaksi"); //Menghapus Transaksi
                            System.out.println("[3]. Menampilkan Data Transaksi"); //Menampilkan Data Transaksi
                            System.out.println("[4]. Kembali ke Menu Utama"); //Kembali ke Menu Utama
                            System.out.println("=============================================");
                            System.out.print("Masukkan Pilihan: "); 

                            subMenu = input.nextInt();
                            input.nextLine();

                            switch (subMenu) {
                                case 1:
                                    System.out.print ("Masukkan Nama Pengirim: ");
                                    namaPengirim = input.nextLine();

                                    System.out.print ("Masukkan Nomor Kontak: ");
                                    nomorKontak = input.next();

                                    System.out.print ("Masukkan Berat Barang: ");
                                    beratBarang = input.nextInt();
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
                                        if(found != true) {
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

                                    biayaAkhir = tarifLayanan + (tarifPerKg * beratBarang) + biayaJarak;
                                   // int nomorTransaksi=0;

                                    historyTransaksi = Arrays.copyOf(historyTransaksi,historyTransaksi.length + 1);
                                    historyTransaksi[historyTransaksi.length-1] = new String[]{
                                        //Integer.toString(nomorTransaksi),
                                        tanggalHariIni,
                                        namaPengirim,
                                        nomorKontak,
                                        lokasiPengiriman,
                                        arrayLayanan[pilihanLayanan],
                                        Double.toString(biayaAkhir),
                                        loggedInUsername};

                                    System.out.println(String.format(
                                        labelFormat,
                                        tanggalHariIni, // Tanggal
                                        beratBarang, // Berat
                                        arrayLayanan[pilihanLayanan], // Nomor Telepon
                                        biayaAkhir, // Biaya Akhir
                                        lokasiPengiriman, // Lokasi
                                        namaPengirim,
                                        nomorKontak
                                    ));                                        
                                    break;
                                /*case 2:
                                    System.out.println("Under Development"); 
                                    break;*/
                                case 2:
                                    System.out.print("Masukkan Nomor Transaksi yang Ingin dihapus: ");
                                     key = input.next();
                                     for (int i = 0; i < historyTransaksi.length; i++) {
                                        if (historyTransaksi[i] != null && historyTransaksi[i][0].equalsIgnoreCase(key)) {
                                            System.out.println(historyTransaksi[i]+" Telah Dihapus!");
                                            System.arraycopy(historyTransaksi, i + 1, historyTransaksi, i, historyTransaksi.length - 1 - i);
                                            historyTransaksi = Arrays.copyOf(historyTransaksi, historyTransaksi.length - 1);
                                            found = true;
                                            break;
                                        }
                                    }
                                    if(found == true) {
                                        found = false;
                                    } else {
                                        System.out.println("Key tidak ditemukan");
                                    }                                            
                                    break;
                                case 3:
                                    System.out.println("=======================================");
                                    System.out.println("\u001B[33m           History Transaksi           \u001B[0m");
                                    System.out.println("=======================================");
                                    System.out.println("[1]. Berdasarkan Rentang Tanggal");
                                    System.out.println("[2]. Hari ini");
                                    System.out.println("[3]. Bulan ini");
                                    System.out.println("[4]. Tahun ini");
                                    System.out.println("[5]. Kembali ke Menu Utama");
                                    System.out.println("=======================================");
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
                                                System.out.println("=======================================================================================================");
                                                System.out.println("                                   History Transaksi");
                                                System.out.println("=======================================================================================================");
                                                System.out.println(" No  |  Tanggal Transaksi  |  Nama Pengirim  |  Nomor Kontak  |   Tujuan    |  Jenis Layanan  |  Biaya  | Kasir");
                                                System.out.println("=======================================================================================================");                               
                                                for (int i = 0; i < historyTransaksi.length; i++) {
                                                    if (historyTransaksi[i][0] != null){
                                                        Date transaksiDate = dateFormat.parse(historyTransaksi[i][0]);
                                                        if (transaksiDate.compareTo(startDate) >= 0 && transaksiDate.compareTo(endDate) <= 0) {
                                                            System.out.println(String.format(" %3d | %19s | %15s | %14s | %11s | %15s | %5s | %5s",
                                                                i,
                                                                historyTransaksi[i][0], // Tanggal
                                                                historyTransaksi[i][1], // Nama
                                                                historyTransaksi[i][2], // Nomor Telepon
                                                                historyTransaksi[i][3], // Lokasi
                                                                historyTransaksi[i][4], // Jenis Layanan
                                                                historyTransaksi[i][5], // Tarif
                                                                historyTransaksi[i][6]  // Nama Kasir
                                                            ));
                                                        }
                                                    }
                                                }
                                                System.out.println("=======================================================================================================");
                                                break;
                                            } catch (ParseException e) {
                                                e.printStackTrace();
                                            }
                                            break;
                                        case 2:
                                            try {
                                                Date startDate = dateFormat.parse(tanggalHariIni);
                                                Date endDate = dateFormat.parse(tanggalHariIni);
                                                System.out.println("=======================================================================================================");
                                                System.out.println("                                   History Transaksi");
                                                System.out.println("=======================================================================================================");
                                                System.out.println(" No  |  Tanggal Transaksi  |  Nama Pengirim  |  Nomor Kontak  |   Tujuan    |  Jenis Layanan  |  Biaya  | Kasir");
                                                System.out.println("=======================================================================================================");
                                                for (int i = 0; i < historyTransaksi.length; i++) {
                                                    if (historyTransaksi[i][0] != null){
                                                        Date transaksiDate = dateFormat.parse(historyTransaksi[i][0]);
                                                        if (transaksiDate.compareTo(startDate) >= 0 && transaksiDate.compareTo(endDate) <= 0) {
                                                            System.out.println(String.format(" %3d | %19s | %15s | %14s | %11s | %15s | %5s | %5s",
                                                                i,
                                                                historyTransaksi[i][0], // Tanggal
                                                                historyTransaksi[i][1], // Nama
                                                                historyTransaksi[i][2], // Nomor Telepon
                                                                historyTransaksi[i][3], // Lokasi
                                                                historyTransaksi[i][4], // Jenis Layanan
                                                                historyTransaksi[i][5], // Tarif
                                                                historyTransaksi[i][6]  // Nama Kasir
                                                            ));
                                                        }
                                                    }
                                                }
                                                System.out.println("=======================================================================================================");
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

                                                System.out.println("=======================================================================================================");
                                                System.out.println("                                   History Transaksi");
                                                System.out.println("=======================================================================================================");
                                                System.out.println(" No  |  Tanggal Transaksi  |  Nama Pengirim  |  Nomor Kontak  |   Tujuan    |  Jenis Layanan  |  Biaya  | Kasir");
                                                System.out.println("=======================================================================================================");

                                                for (int i = 0; i < historyTransaksi.length; i++) {
                                                    if (historyTransaksi[i][0] != null) {
                                                        Date transaksiDate = dateFormat.parse(historyTransaksi[i][0]);
                                                        if (transaksiDate.compareTo(startDate) >= 0 && transaksiDate.compareTo(endDate) <= 0) {
                                                            System.out.println(String.format(" %3d | %19s | %15s | %14s | %11s | %15s | %5s | %5s",
                                                                i,
                                                                historyTransaksi[i][0], // Tanggal
                                                                historyTransaksi[i][1], // Nama
                                                                historyTransaksi[i][2], // Nomor Telepon
                                                                historyTransaksi[i][3], // Lokasi
                                                                historyTransaksi[i][4], // Jenis Layanan
                                                                historyTransaksi[i][5], // Tarif
                                                                historyTransaksi[i][6]  // Nama Kasir
                                                            ));
                                                        }
                                                    }
                                                }

                                                System.out.println("=======================================================================================================");
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

                                                System.out.println("=======================================================================================================");
                                                System.out.println("                                   History Transaksi");
                                                System.out.println("=======================================================================================================");
                                                System.out.println(" No  |  Tanggal Transaksi  |  Nama Pengirim  |  Nomor Kontak  |   Tujuan    |  Jenis Layanan  |  Biaya  | Kasir");
                                                System.out.println("=======================================================================================================");

                                                for (int i = 0; i < historyTransaksi.length; i++) {
                                                    if (historyTransaksi[i][0] != null) {
                                                        Date transaksiDate = dateFormat.parse(historyTransaksi[i][0]);
                                                        if (transaksiDate.compareTo(startDate) >= 0 && transaksiDate.compareTo(endDate) <= 0) {
                                                            System.out.println(String.format(" %3d | %19s | %15s | %14s | %11s | %15s | %5s | %5s",
                                                                i,
                                                                historyTransaksi[i][0], // Tanggal
                                                                historyTransaksi[i][1], // Nama
                                                                historyTransaksi[i][2], // Nomor Telepon
                                                                historyTransaksi[i][3], // Lokasi
                                                                historyTransaksi[i][4], // Jenis Layanan
                                                                historyTransaksi[i][5], // Tarif
                                                                historyTransaksi[i][6]  // Nama Kasir
                                                            ));
                                                        }
                                                    }
                                                }

                                                System.out.println("=======================================================================================================");
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
                                case 4:
                                    isLoop = false;
                                    break;
                                default:
                                System.out.println("Invalid choice. Please try again.");
                            }
                            break;                        
                        case 2:
                            System.out.println("=======================================");
                            System.out.println("\u001B[33m Manajemen Lokasi   \u001B[0m");
                            System.out.println("=======================================");

                            System.out.println("[1]. Menambah Lokasi"); //Menambahkan Lokasi
                            System.out.println("[2]. Menghapus Lokasi"); //Menghapus Lokasi
                            System.out.println("[3]. Menampilkan Data Lokasi"); //Menampilkan Data Lokasi
                            System.out.println("[4]. Kembali ke Menu Utama"); //Kembali ke Menu Utama
                            System.out.println("=======================================");
                            System.out.print("Masukkan Pilihan: "); 
                            subMenu = input.nextInt();

                            input.nextLine();
                
                            switch (subMenu) {
                                case 1:
                                    System.out.print("Masukkan nama lokasi: ");
                                    String lokasiBaru = input.nextLine();
                                    System.out.print("Masukkan tarif: ");
                                    double tarifBaru = input.nextDouble();
                                    arrayLokasi = Arrays.copyOf(arrayLokasi,arrayLokasi.length + 1);
                                    arrayLokasi[arrayLokasi.length-1] = lokasiBaru;
                                    arrayTarifLokasi = Arrays.copyOf(arrayTarifLokasi,arrayTarifLokasi.length + 1);
                                    arrayTarifLokasi[arrayTarifLokasi.length-1] = tarifBaru;
                                    break;
                                case 2:
                                    System.out.print("Masukkan lokasi yang ingin dihapus: ");
                                    key = input.next();
                                    for (int i = 0; i < arrayLokasi.length; i++) {
                                        if (arrayLokasi[i] != null && arrayLokasi[i].equalsIgnoreCase(key)) {
                                            System.out.println(arrayLokasi[i]+" Telah Dihapus!");
                                            System.arraycopy(arrayLokasi, i + 1, arrayLokasi, i, arrayLokasi.length - 1 - i);
                                            arrayLokasi = Arrays.copyOf(arrayLokasi, arrayLokasi.length - 1);
                                            System.arraycopy(arrayTarifLokasi, i + 1, arrayTarifLokasi, i, arrayTarifLokasi.length - 1 - i);
                                            arrayTarifLokasi = Arrays.copyOf(arrayTarifLokasi, arrayTarifLokasi.length - 1);
                                            found = true;
                                            break;
                                        }
                                    }
                                    if(found == true) {
                                        found = false;
                                    } else {
                                        System.out.println("Key tidak ditemukan");
                                    }                                            
                                    break;
                                case 3:
                                    System.out.println("==================================");
                                    System.out.println("\u001B[33m           Data Lokasi           \u001B[0m");
                                    System.out.println("==================================");
                                    System.out.println(" No  |    Nama Kota   |  Biaya");
                                    System.out.println("==================================");
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
                                    isLoop = false;
                                    break;
                                default:
                                System.out.println("Invalid choice. Please try again.");
                            }
                            break;
                        case 3:
                            System.out.println("=======================================");
                            System.out.println("\u001B[33mManajemen Tarif\u001B[0m");
                            System.out.println("=======================================");

                            System.out.println("[1]. Tambah Jenis Layanan"); //Tambahan Jenis Layanan
                            System.out.println("[2]. Merubah Tarif Layanan"); //Merubah Tarif Layanan
                            System.out.println("[3]. Menghapus Layanan"); //Menghapus Layanan
                            System.out.println("[4]. Menampilkan Layanan Data"); //Menampilkan Layanan Data
                            System.out.println("[5]. Keluar"); //Keluar

                            System.out.println("=======================================");
                            System.out.print("Masukkan Pilihan: ");
                            subMenu = input.nextInt();
                            input.nextLine();

                            switch (subMenu) {
                                case 1:
                                    for (int i = 0; i < arrayLayanan.length; i++) {
                                        if (arrayLayanan[i] == null) {
                                            System.out.print("Masukkan Nama Layanan: ");
                                            arrayLayanan[i] = input.next();
                                            System.out.print("Masukkan Tarif: ");
                                            arrayTarifLayanan[i] = input.nextDouble();
                                            break;
                                        }
                                    }
                                    break;
                                case 2:
                                    System.out.print("Masukkan nama layanan: ");
                                    key = input.next();
                                    for (int i = 0; i < arrayLayanan.length; i++) {
                                        if (arrayLayanan[i].equalsIgnoreCase(key)) {
                                            System.out.print("Masukkan Nama Layanan Baru: ");
                                            arrayLayanan[i] = input.next();
                                            System.out.print("Masukkan Tarif Baru: ");
                                            arrayTarifLayanan[i] = input.nextDouble();
                                            found = true;
                                            break;
                                        }
                                    }
                                    if(found == true) {
                                        found = false;
                                    } else {
                                        System.out.println("Key tidak ditemukan");
                                    }                                            
                                    break;
                                case 3:
                                    System.out.print("Masukkan layanan yang ingin dihapus: ");
                                    key = input.next();
                                    for (int i = 0; i < arrayLayanan.length; i++) {
                                        if (arrayLayanan[i] != null && arrayLayanan[i].equalsIgnoreCase(key)) {
                                            System.out.println(arrayLayanan[i]+" - "+arrayTarifLayanan[i]+" Telah Dihapus!");
                                            arrayLokasi[i] = null;
                                            arrayTarifLayanan[i] = 0;
                                            found = true;
                                            break;
                                        }
                                    }
                                    if(found == true) {
                                        found = false;
                                    } else {
                                        System.out.println("Key tidak ditemukan");
                                    }                                            
                                    break;
                                case 4:
                                        System.out.println("==================================");
                                        System.out.println("\u001B[33m           Data Layanan           \u001B[0m");
                                        System.out.println("==================================");
                                        System.out.println(" No  |   Nama Layanan   |  Biaya");
                                        System.out.println("==================================");
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
