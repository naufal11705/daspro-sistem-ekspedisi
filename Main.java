
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


    static Scanner input = new Scanner(System.in);
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
        {"✅ Login Success. Welcome ","✅ Anda berhasil masuk. Selamat datang "}, //4
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
                {"User Data", "Data Pengguna"},    //16
                    {"User Management", "Manajemen Pengguna"},  //17
                {"Back to the Main Menu", "Kembali ke Menu Utama"}, //18

            {"Delivery Transaction", "Transaksi Pengiriman       "}, //19
                {"Transactions", "Melakukan Transaksi"}, //20
                    {"║ Enter the Sender's Name: ","║ Masukkan Nama Pengirim: "},   //21
                    {"║ Enter contact number: ", "║ Masukkan nomor kontak: "},  //22
                    {"║ Enter receiver's name: ","║ Masukkan Nama Penerima: "},   //23
                    {"║ Enter Address: ", "║ Masukkan Alamat: "},   //24
                    {"║ Enter Description: ", "║ Masukkan Deskripsi Barang:"},  //25
                    {"║ Input Length: ", "║ Masukkan Panjang: "}, //26
                    {"║ Input Widht: ", "║ Masukkan Lebar: "}, //27
                    {"║ Input Height: ", "║ Masukkan Tinggi: "},  //28
                    {"⚠️ RUTE IS NOT FOUND. PLEASE TRY AGAIN", "⚠️ RUTE TIDAK DITEMUKAN. SILAKAN COBA LAGI."},  //29
                    {"day", "hari"},    //30
                    {"Payment Methode", "Metode Pembayaran"},   //31
                    {" ⤷ Choose Payment methode: ", " ⤷ Pilih Metode Pembayaran: "},  //32
                    {" ⤷ Choose Available Bank: ", " ⤷ Pilih Bank yang tersedia: "}, //33
                    {"Payment successfully used ","Pembayaran berhasil menggunakan "},   //34
                    {" ⤷ Please make payment of the amound Rp."," ⤷ Silahkan lakukan Pembayaran sejumlah Rp."},   //35
                        {" before receiving goods. The Fee will be charged to the receiver!!!"," sebelum menerima barang. Biaya akan dibebankan kepada penerima!!!"},   //36
                    {" ⤷ Shipping cost amount to: "," ⤷ Biaya Pengiriman sebesar: "}, //37
                        {" ⤷ Pay: Rp.", " ⤷ Bayar: Rp."},     //38
                        {" ⤷ Return: Rp", " ⤷ Kembalian: Rp"},    //39
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
            
            {"Route Management", "Manajemen Rute"}, //49 
                {"Add New Route", "Tambah Rute Baru"},   //50
                    {"║ Rute has been available", "║ Rute sudah tersedia"}, //51
                    {"⤷ Enter the distance between ", "⤷ Masukkan jarak antara "},  //52
                {"Remove Route", "Hapus Rute"},  //53
                {"Displays Location's Data", "Menampilkan Data Rute Pengiriman"},   //54

            {"Service Management", "Manajemen Layanan"}, //56
                {"Add Service Types", "Tambahkan Jenis Layanan"},   //57
                    {"║ ⤷ Enter New Service Name: ", "║ ⤷ Masukkan Nama Layanan: "},    //58
                    {"║ ⤷ Cost: Rp.", "║ ⤷ Masukkan Tarif: Rp."},   //59
                    {"║ ⤷ Minimum delivery time: ","║ ⤷ Masukkan Waktu Pengiriman Minimum: "},  //60
                    {"║ ⤷ Maximum delivery time: ","║ ⤷ Masukkan Waktu Pengiriman Maximum: "},  //61
                {"Edit Service", "Edit Layanan"},    //62
                    {"║ Service list available: ","║ Daftar Layanan yang Tersedia: "},  //63
                    {"⤷ Enter service number want to change: " ,"⤷ Masukkan nomor layanan yang ingin diubah: "},    //64
                {"Remove Service", "Menghapus Layanan"},    //65
                {"Displays Services' Data", "Menampilkan Layanan Data"},    //66
                    {"Service", "Cost"},    //67

            {"Change Language", "Ganti Bahasa"},    //67
            {"Basic Cost Management", "Manajemen Tarif Dasar"}, //68
                {"Service Cost Management per Kg","Tarif dasar per Kg"},   //69
                {"Service Cost Management per Km","Tarif dasar per Km"},   //70
            {"Report", "Laporan"},  //71
            {"Delivery of goods","Pengiriman Barang"}, //72
                {"Warehouse Inventory", "Inventori Gudang"},    //73
                    {"║ ⤷ Enter warehouse location: ", "║ ⤷ Masukkan lokasi Gudang: "}, //74
                {"Send Pakcage", "Kirim Paket"},    //75
                    {"║ ⤷ Enter index: ", "║ ⤷ Masukkan index: "},  //76
                {"Deliver Package", "Antar Paket"}, //77
            {"Exit", "Keluar"}, //78

        {"Logout Successs. See You! 👋","Anda telah berhasil keluar. Sampai jumpa lain waktu! 👋"}, //79
        {"║ ⤷ Enter Options: ", "║ ⤷ Masukkan Pilihan: "},  //80
        {"Click [  ⏎ Enter] to Continue", "Tekan [  ⏎ Enter] untuk melanjutkan"}, //81

        // Data Tambahan
        {"║ Input Weight: ", "║ Masukkan berat barang: "}, //82
        {"Transaction History", "Histori Transaksi"}, //83

        {"Date Range", "Rentang Tanggal"}, //84
        {"Day", "Hari"}, //85
        {"Month", "Bulan"}, //86
        {"Year", "Tahun"}, //87
        {"Tracking Number", "Nomor Resi"}, //88

        {"Tracking Number", "No Resi"}, //89
        {"Date", "Tanggal"}, //90
        {"Sender", "Pengirim"}, //91
        {"Service", "Layanan"}, //92
        {"Origin", "Asal"}, //93
        {"Destination", "Tujuan"}, //94
        {"Cost", "Biaya"}, //95
        {"Cashier", "Kasir"}, //96
        {"Recipient", "Penerima"}, //97
        {"Address", "Alamat"}, //98

        {"Route Data", "Data Rute"}, //99
        {"Location", "Lokasi"}, //100
        {"Distance (Km)", "Jarak (Km)"}, //101

        {"Service Data", "Data Layanan"}, //102
        {"Service", "Layanan"}, //103
        {"Cost (Rp)", "Biaya (Rp)"}, //104

        {"Username", "Nama Pengguna"}, //105
        {"Password", "Kata Sandi"}, //106
        {"Role", "Peran"}, //107

        {"║ ⤷ Input cost per Kg: ", "║ ⤷ Masukkan tarif dasar per Kg: "}, //108
        {"║ ⤷ Input cost per Km: ", "║ ⤷ Masukkan tarif dasar per Km: "}, //109

        {" ⤷ Select the index of services you want to delete: ", "⤷ Pilih index layanan yang ingin dihapus: "}, //110
        {"⚠️ Inputs are not numbers. Please enter a valid service number", "⚠️ Inputan bukan angka. Silakan masukkan nomor layanan yang valid"}, //111
        {" has been deleted!", " Telah Dihapus!"}, //112
        {"Invalid service number.", "Nomor layanan tidak valid."}, //113

        {"⚠️ THE INPUT MUST BE AN INTEGER. PLEASE TRY AGAIN.","⚠️ INPUT HARUS BERUPA BILANGAN BULAT. SILAHKAN COBA LAGI."},//114
        {"⚠️ WEIGHT MUST BE AN INTEGER. PLEASE TRY AGAIN.","⚠️ BERAT HARUS BERUPA BILANGAN BULAT. SILAHKAN COBA LAGI."},//115
        {"⚠️ THE LENGTH MUST BE GREATER THAN 0. PLEASE TRY AGAIN.","⚠️ PANJANG HARUS LEBIH BESAR DARI 0 . SILAHKAN COBA LAGI."},//116
        {"⚠️ THE WIDTH MUST BE GREATER THAN 0. PLEASE TRY AGAIN.","⚠️ LEBAR HARUS LEBIH BESAR DARI 0 . SILAHKAN COBA LAGI."},//117
        {"⚠️ HEIGHT MUST BE GREATER THAN 0. PLEASE TRY AGAIN.","⚠️ TINGGI HARUS LEBIH BESAR DARI 0 . SILAHKAN COBA LAGI."},//118

        {"Edit Route", "Edit Rute"}, //119
        {"║ The input entered is invalid. Please enter the receipt number again!.","║ Input yang dimasukkan tidak valid. Silakan masukkan nomor resi kembali!."},//120
        {"The route already exists!","Rute tersebut sudah ada!"},//121
        {"⤷ Enter the route number you want to delete: ","⤷ Masukkan nomor rute yang ingin dihapus: "},//122
        {"Invalid route number","Nomor rute tidak valid"},//123
        {"║ Invalid service number. Please enter a valid service number:","║ Nomor layanan tidak valid. Masukkan nomor layanan yang valid:"},//124
        {"⤷ Press [⏎ Enter] if you don't want to edit the data","⤷ Tekan [⏎ Enter] jika tidak ingin mengedit data"},//125
        {"⤷ Enter the route number you want to change:","⤷ Masukkan nomor rute yang ingin diubah: "},//126
        {"╠ Do you want to change the delivery status to completed? (Y/N):","╠ Apakah anda ingin mengubah status pengiriman menjadi selesai? (Y/N): "},//127
        {"║ Invalid date format. Please enter the date in dd-MM-yyyy format.","║ Format tanggal tidak valid. Harap masukkan tanggal dengan format dd-MM-yyyy."},//128
        {"║ Enter End Date (dd-MM-yyyy):","║ Masukkan Tanggal Akhir (dd-MM-yyyy): "},//129
        {"║⤷Enter Start Date (dd-MM-yyyy): ","║ ⤷ Masukkan Tanggal Awal (dd-MM-yyyy): "},//130
        {"║ The input must be a number.","║ Input harus berupa angka."},//131
        {"║ Invalid date.","║ Tanggal tidak valid."},//132
        {"║ ⤷ Enter Date (dd):","║ ⤷ Masukkan Tanggal (dd): "},//133
        {"║ Enter a number between 1 and 12.","║ Masukkan angka antara 1 sampai 12."},//134
        {"║ The moon is invalid. Enter a number between 1 and 12.","║ Bulan tidak valid. Masukkan angka antara 1 sampai 12."},//135
        {"║⤷Enter Month (MM):","║ ⤷ Masukkan Bulan (MM): "},//136
        {"║ Input is not a number. Please enter the year between 1900 and 3000.","║ Input bukan angka. Silakan masukkan tahun antara 1900 dan 3000."},//137
        {"║ Invalid year. Please enter the year between 1900 and 3000.","║ Tahun tidak valid. Harap masukkan tahun antara 1900 dan 3000."},//138
        {"║ ⤷ Enter Year: ","║ ⤷ Masukkan Tahun: "},//139
        {"║ Data not found. Please try again.","║ Data tidak ditemukan. Silakan coba lagi."},//140
        {"There are no transactions in that date range or that correspond to the month and year.","Tidak ada transaksi pada rentang tanggal tersebut atau yang sesuai dengan bulan dan tahun ini."},//141
        {" ⤷ Enter Options: ", " ⤷ Masukkan Pilihan: "},  //142

        
    };

    // Format tanggal
    static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    static Date date = new Date();
    static String tanggalHariIni = dateFormat.format(date);
    static String inputanTanggalAwal = "00-00-000", inputanTanggalAkhir = "00-00-0000";

    static String[][] arrayLayanan = {
        {"Economic","5000", "1", "5"},
        {"Regular", "10000", "1", "3"},
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

    static int inputselectedLanguage;

    static boolean validInput = false;
    static int menuUtama, subMenu, editMenu;
    static boolean exit = false;
    static String bankName;
    static String namaMetode;
    

    static String[][] historyTransaksi = {
        {"8032468109752", "29-01-2023", "Nanda", "08866778899", "Yogyakarta", "Regular", "25700.0", "Farhan", "Abdi", "Jl. Kembang 5 No. 15", "3", "Makanan", "Waiting for pickup", "Malang"},
        {"9276354185046", "12-02-2023", "Gabriel", "08811223344", "Tangerang", "Economic", "33200.0", "Naufal", "Afifah", "Jl. Anggrek 12 No. 8", "7", "Elektronik", "Waiting for pickup", "Bekasi"},
        {"1492578034685", "03-03-2023", "Afifah", "08876543210", "Makassar", "Regular", "50900.0", "Putra", "Naufal", "Jl. Melati 9 No. 21", "5", "Pakaian", "Waiting for pickup", "Bandung"},
        {"5283176490254", "26-04-2023", "Esa", "08822334455", "Medan", "Economic", "65400.0", "Farhan", "Luthfi", "Jl. Seroja 3 No. 7", "2", "Buku", "Waiting for pickup", "Medan"},
        {"3091754682351", "21-05-2023", "Abdi", "08811223344", "Bogor", "Economic", "34800.0", "Naufal", "Julian", "Jl. Mawar 17 No. 5", "9", "Mainan", "Waiting for pickup", "Bogor"},
        {"6750912348526", "17-06-2023", "Naufal", "08822334455", "Yogyakarta", "Regular", "66500.0", "Putra", "Gabriel", "Jl. Anggrek 7 No. 12", "8", "Kesehatan", "Waiting for pickup", "Malang"},
        {"8013564729835", "30-06-2023", "Farrel", "08855443322", "Jakarta", "Regular", "76800.0", "Farhan", "Chiko", "Jl. Melati 15 No. 10", "4", "Alat Tulis", "Waiting for pickup", "Bekasi"},
        {"2674853902164", "14-07-2023", "Atabik", "08855443322", "Bandung", "Economic", "45300.0", "Naufal", "Vincent", "Jl. Kembang 2 No. 19", "1", "Elektronik", "Waiting for pickup", "Bandung"},
        {"4501628397517", "05-08-2023", "Dio", "08876543210", "Surabaya", "Sameday", "29100.0", "Putra", "Saputra", "Jl. Seroja 11 No. 14", "6", "Makanan", "Waiting for pickup", "Medan"},
        {"7246109385273", "09-09-2023", "Pasha", "08899887766", "Serang", "Regular", "78000.0", "Farhan", "Naufal", "Jl. Anggrek 8 No. 5", "10", "Pakaian", "Waiting for pickup", "Bogor"},
        {"3751928643058", "18-10-2023", "Farhan", "08866778899", "Denpasar", "Regular", "55700.0", "Naufal", "Petrus", "Jl. Mawar 5 No. 11", "2", "Mainan", "Waiting for pickup", "Malang"},
        {"5038921467584", "02-12-2023", "Chiko", "08811223344", "Malang", "Economic", "87600.0", "Putra", "Saka", "Jl. Kembang 10 No. 17", "7", "Elektronik", "Waiting for pickup", "Bogor"},
        {"6904715283142", "27-09-2023", "Haikal", "08887654321", "Bengkulu", "Sameday", "98800.0", "Farhan", "Vincent", "Jl. Melati 3 No. 9", "3", "Kesehatan", "Waiting for pickup", "Bekasi"},
        {"4892307162453", "11-11-2023", "Cindy", "08899887766", "Bekasi", "Sameday", "65400.0", "Naufal", "Petrus", "Jl. Seroja 8 No. 6", "5", "Makanan", "Waiting for pickup", "Bekasi"},
        {"1234567890123", "01-01-2023", "Ivan", "08812345678", "Surabaya", "Economic", "45000.0", "Putra", "Abdi", "Jl. Anggrek 14 No. 20", "9", "Buku", "Waiting for pickup", "Bogor"},
        {"9876543210987", "07-04-2023", "Luthfi", "08887654321", "Jakarta", "Regular", "60000.0", "Farhan", "Farrel", "Jl. Kembang 1 No. 18", "1", "Elektronik", "Waiting for pickup", "Malang"},
        {"3456789012345", "14-06-2023", "Adri", "08811223344", "Bandung", "Economic", "35000.0", "Naufal", "Petrus", "Jl. Melati 6 No. 13", "6", "Makanan", "Waiting for pickup", "Bogor"},
        {"8765432109876", "21-08-2023", "Alif", "08899887766", "Makassar", "Sameday", "42000.0", "Putra", "Saputra", "Jl. Anggrek 20 No. 3", "4", "Buku", "Waiting for pickup", "Bandung"},
        {"6543210987654", "03-10-2023", "Dimas", "08876543210", "Denpasar", "Regular", "58000.0", "Farhan", "Farrel", "Jl. Mawar 13 No. 16", "10", "Mainan", "Waiting for pickup", "Bekasi"},
        {"8765432109876", "11-12-2023", "Julian", "08822334455", "Malang", "Sameday", "67000.0", "Naufal", "Naufal", "Jl. Seroja 2 No. 4", "8", "Kesehatan", "Waiting for pickup", "Malang"},
        {"5432109876543", "25-02-2023", "Petrus", "08866778899", "Bogor", "Regular", "73000.0", "Putra", "Saka", "Jl. Kembang 8 No. 1", "3", "Elektronik", "Waiting for pickup", "Bogor"},
        {"3210987654321", "10-05-2023", "Saputra", "08855443322", "Surabaya", "Economic", "32000.0", "Farhan", "Rio", "Jl. Mawar 14 No. 7", "5", "Makanan", "Waiting for pickup", "Bekasi"},
        {"9876543210987", "15-07-2023", "Reika", "08811223344", "Semarang", "Regular", "52000.0", "Naufal", "Chiko", "Jl. Anggrek 11 No. 15", "2", "Alat Tulis", "Waiting for pickup", "Medan"},
        {"3456789012345", "20-09-2023", "Rio", "08887654321", "Yogyakarta", "Sameday", "47000.0", "Putra", "Naufal", "Jl. Seroja 10 No. 2", "9", "Elektronik", "Waiting for pickup", "Bogor"},
        {"9876543210987", "05-11-2023", "Saka", "08899887766", "Tangerang", "Sameday", "69000.0", "Farhan", "Chiko", "Jl. Melati 20 No. 16", "1", "Pakaian", "Waiting for pickup", "Bekasi"},
        {"3210987654321", "15-01-2023", "Taufik", "08876543210", "Bekasi", "Economic", "40000.0", "Naufal", "Vincent", "Jl. Kembang 7 No. 19", "10", "Buku", "Waiting for pickup", "Surabaya"},
        {"9876543210987", "20-03-2023", "Mera", "08822334455", "Gorontalo", "Sameday", "61000.0", "Putra", "Saputra", "Jl. Seroja 4 No. 11", "4", "Kesehatan", "Waiting for pickup", "Bogor"},
        {"3456789012345", "05-05-2023", "Vincent", "08866778899", "Malang", "Regular", "54000.0", "Farhan", "Petrus", "Jl. Anggrek 3 No. 14", "7", "Makanan", "Arrived at warehouse", "Medan"},
        {"3210987654321", "10-07-2023", "Vira", "08855443322", "Bengkulu", "Economic", "37000.0", "Naufal", "Haikal", "Jl. Kembang 12 No. 9", "1", "Elektronik", "Waiting for pickup", "Bogor"},
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

        clearTerminal();
        ManageLanguage();
        clearTerminal();

        input.nextLine();

        while (!login) {

            login = false;
            exit = false;
            isAdmin = false;
            isKurir = false;
            masuk = false;

            while (!masuk) {
                displayHeader();
                displayIndonesianMap();
                Login();
            }

            notificationBox(97, languageModule[3][selectedLanguage] + loggedInUsername);
            pressEnter();

            while(!exit) {
                displayHeader();
                displayIndonesianMap();

                if(isAdmin){
                    viewAdminMenu();
                } else if (isKurir) {
                    viewCourierMenu();
                } else {
                    viewCashierMenu();   
                }
                
                System.out.print(languageModule[80][selectedLanguage]);//"║ ⤷ Masukkan Pilihan: "
                menuUtama = input.nextInt();
                input.nextLine();
                clearTerminal();

                while (true) {
                    if(isAdmin){
                        menuUtama = menuUtama-1;
                        switch (menuUtama) {
                            case 0:
                                ManageUser();
                                break;
                                    
                            case 1:
                                ManageTransaction();
                                break;

                            case 2:
                                ManageRoute();
                                break;

                            case 3:
                                ManageService();
                                break;

                            case 4:
                                ManageLanguage();
                                clearTerminal();
                                break;
            
                            case 5:
                                ManageCost();
                                clearTerminal();
                                break;
                                
                            default:
                                break; 
                        }

                        if (isAdmin) { 
                            switch (menuUtama) {
                                case 6: 
                                    viewReport();
                                    pressEnter();
                                    break;
                        
                                case 7:
                                    ManageShipment();
                                    break;

                                case 8:
                                    Logout();
                                    break;
                            }
                        }
                            
                    } else if (isKurir) {
                        switch (menuUtama) {
                            case 1:
                                ManageShipment();
                                break;

                            case 2:
                                Logout();
                                break;
                        }
                        
                    } else {
                        switch (menuUtama) { 
                            case 6:
                                Logout();
                                break;
                        }
                    }
                    break;

                };
            };
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
            languageModule[105][selectedLanguage], 
            languageModule[106][selectedLanguage], 
            languageModule[107][selectedLanguage]
        );
        System.out.println("╔════════════════════════════════════════════════════════════╗"); 
        System.out.println("║"+centerString(60,languageModule[5][selectedLanguage])+"║");
        System.out.println("╠════════════════════════════════════════════════════════════╣");
        System.out.println(formattedHeader);
        System.out.println("╠════════════════════════════════════════════════════════════╣");

        for (int i = 0; i < userData.length; i++) {
            System.out.printf("║ %-" + columnWidths[0] + "s ║ %-" + columnWidths[1] + "s ║ %-" + columnWidths[2] + "s\n", userData[i][0], userData[i][1], userData[i][2]);
        }

        System.out.println("╚════════════════════════════════════════════════════════════╝");
    }

    private static void viewExpeditionRoutes() {
        clearTerminal();
        int[] columnWidths = calculateColumnWidths(rutePengiriman);
        String formattedHeader = String.format("║ %3s ║ %-" + (columnWidths[0] + columnWidths[1] + 3) + "s ║ %-" + columnWidths[2] + "s",
            "No", 
            languageModule[100][selectedLanguage], 
            languageModule[101][selectedLanguage]
        );
        System.out.println("╔════════════════════════════════════════════════════════════╗"); 
        System.out.println("║"+centerString(60,languageModule[99][selectedLanguage])+"║");
        System.out.println("╠════════════════════════════════════════════════════════════╣");
        System.out.println(formattedHeader);
        System.out.println("╠════════════════════════════════════════════════════════════╣");
        for (int i = 0; i < rutePengiriman.length; i++) {
            String formattedString = String.format("║ %3d ║ %-" + columnWidths[0] + "s ⇌ %" + columnWidths[1] + "s ║ %-" + columnWidths[2] + "s" ,
                    (i+1),
                    rutePengiriman[i][0], 
                    rutePengiriman[i][1], 
                    rutePengiriman[i][2] 
            );
            System.out.println(formattedString);
        }
        System.out.println("╚════════════════════════════════════════════════════════════╝");
    } 
    
    private static void viewExpeditionServices() {
        int[] columnWidths = calculateColumnWidths(rutePengiriman);
        String formattedHeader = String.format("║ %3s ║ %-" + columnWidths[0] + "s ║ %-" + columnWidths[1] + "s ║ %-6s ║ %-6s",
            "No", 
            languageModule[103][selectedLanguage], 
            languageModule[104][selectedLanguage],
            "Min",
            "Max"
        );
        System.out.println("╔════════════════════════════════════════════════════════════╗"); 
        System.out.println("║"+centerString(60,languageModule[102][selectedLanguage])+"║");
        System.out.println("╠════════════════════════════════════════════════════════════╣");
        System.out.println(formattedHeader);
        System.out.println("╠════════════════════════════════════════════════════════════╣");
        for (int i = 0; i < arrayLayanan.length; i++) {
            if (arrayLayanan[i] != null) {
                    String formattedString = String.format("║ %3s ║ %-" + columnWidths[0] + "s ║ %-" + columnWidths[1] + "s ║ %-6s ║ %-6s",
                    (i+1),
                    arrayLayanan[i][0], 
                    arrayLayanan[i][1],
                    arrayLayanan[i][2],
                    arrayLayanan[i][3] 
            );
            System.out.println(formattedString);
            }
        }
        System.out.println("╚════════════════════════════════════════════════════════════╝");
    } 

    private static void viewExpeditionHistoryByTrackingNumber(String resi){
        int[] columnWidths = calculateColumnWidths(historyTransaksi);
        String formattedHeader = String.format("║ %3s ║ %-" + columnWidths[0] + "s ║ %-" + columnWidths[1] + "s ║ %-" + columnWidths[2] + "s ║ %-" + columnWidths[5] + "s ║ %-" + columnWidths[13] + "s ║ %-" + columnWidths[4] + "s ║ %-" + columnWidths[6] + "s ║ %-" + columnWidths[7] + "s ║ %-" + columnWidths[8] + "s ║ %-" + columnWidths[9] + "s",
            "No", 
            languageModule[89][selectedLanguage], 
            languageModule[90][selectedLanguage],
            languageModule[91][selectedLanguage],
            languageModule[92][selectedLanguage],
            languageModule[93][selectedLanguage],
            languageModule[94][selectedLanguage],
            languageModule[95][selectedLanguage],
            languageModule[96][selectedLanguage],
            languageModule[97][selectedLanguage],
            languageModule[98][selectedLanguage]
        );
        System.out.println("╔════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗"); 
        System.out.println("║"+centerString(168, languageModule[83][selectedLanguage])+"║");
        System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣"); 
        System.out.println(formattedHeader);
        System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣");           
        for (int i = 0; i < historyTransaksi.length; i++) {
            if (historyTransaksi[i][0].equals(resi)) {
                System.out.println(String.format("║ %3s ║ %-" + columnWidths[0] + "s ║ %-" + columnWidths[1] + "s ║ %-" + columnWidths[2] + "s ║ %-" + columnWidths[5] + "s ║ %-" + columnWidths[13] + "s ║ %-" + columnWidths[4] + "s ║ %-" + columnWidths[6] + "s ║ %-" + columnWidths[7] + "s ║ %-" + columnWidths[8] + "s ║ %-" + columnWidths[9] + "s",
                    i,
                    historyTransaksi[i][0], // Nomor Resi
                    historyTransaksi[i][1], // Tanggal
                    historyTransaksi[i][2], // Nama Pengirim
                    historyTransaksi[i][5],  //Jenis Layanan
                    historyTransaksi[i][13],
                    historyTransaksi[i][4], // Tujuan
                    historyTransaksi[i][6], // Tarif
                    historyTransaksi[i][7], // Nama Kasir
                    historyTransaksi[i][8], // Nama Penerima
                    historyTransaksi[i][9] // Alamat
                ));
            }
        }
        System.out.println("╚════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝"); 
    }

    private static void viewExpeditionHistoryByRange(Date startDate, Date endDate){
        int[] columnWidths = calculateColumnWidths(historyTransaksi);
        String formattedHeader = String.format("║ %3s ║ %-" + columnWidths[0] + "s ║ %-" + columnWidths[1] + "s ║ %-" + columnWidths[2] + "s ║ %-" + columnWidths[5] + "s ║ %-" + columnWidths[13] + "s ║ %-" + columnWidths[4] + "s ║ %-" + columnWidths[6] + "s ║ %-" + columnWidths[7] + "s ║ %-" + columnWidths[8] + "s ║ %-" + columnWidths[9] + "s",
            "No", 
            languageModule[89][selectedLanguage], 
            languageModule[90][selectedLanguage],
            languageModule[91][selectedLanguage],
            languageModule[92][selectedLanguage],
            languageModule[93][selectedLanguage],
            languageModule[94][selectedLanguage],
            languageModule[95][selectedLanguage],
            languageModule[96][selectedLanguage],
            languageModule[97][selectedLanguage],
            languageModule[98][selectedLanguage]
        );
        try{
            System.out.println("╔════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗"); 
            System.out.println("║"+centerString(168, languageModule[83][selectedLanguage])+"║");
            System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣"); 
            System.out.println(formattedHeader);
            System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣"); 
            for (int i = 0; i < historyTransaksi.length; i++) {
                if (historyTransaksi[i][0] != null){
                    Date transaksiDate = dateFormat.parse(historyTransaksi[i][1]);
                    if (transaksiDate.compareTo(startDate) >= 0 && transaksiDate.compareTo(endDate) <= 0) {
                        System.out.println(String.format("║ %3s ║ %-" + columnWidths[0] + "s ║ %-" + columnWidths[1] + "s ║ %-" + columnWidths[2] + "s ║ %-" + columnWidths[5] + "s ║ %-" + columnWidths[13] + "s ║ %-" + columnWidths[4] + "s ║ %-" + columnWidths[6] + "s ║ %-" + columnWidths[7] + "s ║ %-" + columnWidths[8] + "s ║ %-" + columnWidths[9] + "s",
                            i,
                            historyTransaksi[i][0], // Nomor Resi
                            historyTransaksi[i][1], // Tanggal
                            historyTransaksi[i][2], // Nama Pengirim
                            historyTransaksi[i][5],  //Jenis Layanan
                            historyTransaksi[i][13],
                            historyTransaksi[i][4], // Tujuan
                            historyTransaksi[i][6], // Tarif
                            historyTransaksi[i][7], // Nama Kasir
                            historyTransaksi[i][8], // Nama Penerima
                            historyTransaksi[i][9] // Alamat
                        ));
                    }
                }
            }
        System.out.println("╚════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝"); 
        }catch (ParseException e){
            e.printStackTrace();
        }
    }

    private static void viewExpeditionHistoryByDay(Date startDate, Date endDate) {
        int[] columnWidths = calculateColumnWidths(historyTransaksi);
        String formattedHeader = String.format("║ %3s ║ %-" + columnWidths[0] + "s ║ %-" + columnWidths[1] + "s ║ %-" + columnWidths[2] + "s ║ %-" + columnWidths[5] + "s ║ %-" + columnWidths[13] + "s ║ %-" + columnWidths[4] + "s ║ %-" + columnWidths[6] + "s ║ %-" + columnWidths[7] + "s ║ %-" + columnWidths[8] + "s ║ %-" + columnWidths[9] + "s",
            "No", 
            languageModule[89][selectedLanguage], 
            languageModule[90][selectedLanguage],
            languageModule[91][selectedLanguage],
            languageModule[92][selectedLanguage],
            languageModule[93][selectedLanguage],
            languageModule[94][selectedLanguage],
            languageModule[95][selectedLanguage],
            languageModule[96][selectedLanguage],
            languageModule[97][selectedLanguage],
            languageModule[98][selectedLanguage]
        );
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        boolean dataDitemukan = false;

        System.out.println("╔════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗"); 
        System.out.println("║"+centerString(168, languageModule[83][selectedLanguage])+"║");
        System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣"); 
        System.out.println(formattedHeader);
        System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣");  

        for (int i = 0; i < historyTransaksi.length; i++) {
            try {
                Date transaksiDate = dateFormat.parse(historyTransaksi[i][1]);
                Calendar cal = Calendar.getInstance();
                int bulanSekarang = cal.get(Calendar.MONTH) + 1; // Bulan dimulai dari 0
                int tahunSekarang = cal.get(Calendar.YEAR);

                if (transaksiDate.compareTo(startDate) >= 0 && transaksiDate.compareTo(endDate) <= 0
                        && dateFormat.format(transaksiDate).startsWith(String.format("%02d-%02d", startDate.getDate(), bulanSekarang))) {
                        System.out.println(String.format("║ %3s ║ %-" + columnWidths[0] + "s ║ %-" + columnWidths[1] + "s ║ %-" + columnWidths[2] + "s ║ %-" + columnWidths[5] + "s ║ %-" + columnWidths[13] + "s ║ %-" + columnWidths[4] + "s ║ %-" + columnWidths[6] + "s ║ %-" + columnWidths[7] + "s ║ %-" + columnWidths[8] + "s ║ %-" + columnWidths[9] + "s",
                            i,
                            historyTransaksi[i][0], // Nomor Resi
                            historyTransaksi[i][1], // Tanggal
                            historyTransaksi[i][2], // Nama Pengirim
                            historyTransaksi[i][5],  //Jenis Layanan
                            historyTransaksi[i][13],
                            historyTransaksi[i][4], // Tujuan
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

        System.out.println("╚════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝"); 

        if (!dataDitemukan) {
            System.out.print(languageModule[141][selectedLanguage]);//"Tidak ada transaksi pada rentang tanggal tersebut atau yang sesuai dengan bulan dan tahun ini."
        }
    }

    private static void viewExpeditionHistoryByMonth(Date startDate, Date endDate) {
        int[] columnWidths = calculateColumnWidths(historyTransaksi);
        String formattedHeader = String.format("║ %3s ║ %-" + columnWidths[0] + "s ║ %-" + columnWidths[1] + "s ║ %-" + columnWidths[2] + "s ║ %-" + columnWidths[5] + "s ║ %-" + columnWidths[13] + "s ║ %-" + columnWidths[4] + "s ║ %-" + columnWidths[6] + "s ║ %-" + columnWidths[7] + "s ║ %-" + columnWidths[8] + "s ║ %-" + columnWidths[9] + "s",
            "No", 
            languageModule[89][selectedLanguage], 
            languageModule[90][selectedLanguage],
            languageModule[91][selectedLanguage],
            languageModule[92][selectedLanguage],
            languageModule[93][selectedLanguage],
            languageModule[94][selectedLanguage],
            languageModule[95][selectedLanguage],
            languageModule[96][selectedLanguage],
            languageModule[97][selectedLanguage],
            languageModule[98][selectedLanguage]
        );
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        boolean dataDitemukan = false;

        System.out.println("╔════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗"); 
        System.out.println("║"+centerString(168, languageModule[83][selectedLanguage])+"║");
        System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣"); 
        System.out.println(formattedHeader);
        System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣");  

        for (int i = 0; i < historyTransaksi.length; i++) {
            try {
                Date transaksiDate = dateFormat.parse(historyTransaksi[i][1]);

                Calendar cal = Calendar.getInstance();
                cal.setTime(transaksiDate);
                int transaksiBulan = cal.get(Calendar.MONTH) + 1; // Bulan dimulai dari 0
                int transaksiTahun = cal.get(Calendar.YEAR);

                if (transaksiDate.compareTo(startDate) >= 0 && transaksiDate.compareTo(endDate) <= 0
                        && transaksiBulan == startDate.getMonth() + 1 && transaksiTahun == startDate.getYear() + 1900) {
                        System.out.println(String.format("║ %3s ║ %-" + columnWidths[0] + "s ║ %-" + columnWidths[1] + "s ║ %-" + columnWidths[2] + "s ║ %-" + columnWidths[5] + "s ║ %-" + columnWidths[13] + "s ║ %-" + columnWidths[4] + "s ║ %-" + columnWidths[6] + "s ║ %-" + columnWidths[7] + "s ║ %-" + columnWidths[8] + "s ║ %-" + columnWidths[9] + "s",
                            i,
                            historyTransaksi[i][0], // Nomor Resi
                            historyTransaksi[i][1], // Tanggal
                            historyTransaksi[i][2], // Nama Pengirim
                            historyTransaksi[i][5],  //Jenis Layanan
                            historyTransaksi[i][13],
                            historyTransaksi[i][4], // Tujuan
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

        System.out.println("╚════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝"); 
        if (!dataDitemukan) {
            System.out.println("Tidak ada transaksi pada rentang tanggal tersebut atau yang sesuai dengan bulan dan tahun ini.");
        }

    }

    private static void viewExpeditionHistoryByYear(int tahunInput) {
        int[] columnWidths = calculateColumnWidths(historyTransaksi);
        String formattedHeader = String.format("║ %3s ║ %-" + columnWidths[0] + "s ║ %-" + columnWidths[1] + "s ║ %-" + columnWidths[2] + "s ║ %-" + columnWidths[5] + "s ║ %-" + columnWidths[13] + "s ║ %-" + columnWidths[4] + "s ║ %-" + columnWidths[6] + "s ║ %-" + columnWidths[7] + "s ║ %-" + columnWidths[8] + "s ║ %-" + columnWidths[9] + "s",
            "No", 
            languageModule[89][selectedLanguage], 
            languageModule[90][selectedLanguage],
            languageModule[91][selectedLanguage],
            languageModule[92][selectedLanguage],
            languageModule[93][selectedLanguage],
            languageModule[94][selectedLanguage],
            languageModule[95][selectedLanguage],
            languageModule[96][selectedLanguage],
            languageModule[97][selectedLanguage],
            languageModule[98][selectedLanguage]
        );
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        boolean dataDitemukan = false;

        System.out.println("╔════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗"); 
        System.out.println("║"+centerString(168, languageModule[83][selectedLanguage])+"║");
        System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣"); 
        System.out.println(formattedHeader);
        System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣"); 

        for (int i = 0; i < historyTransaksi.length; i++) {
            try {
                Date transaksiDate = dateFormat.parse(historyTransaksi[i][1]);
                Calendar cal = Calendar.getInstance();
                cal.setTime(transaksiDate);
                int tahunTransaksi = cal.get(Calendar.YEAR);

                if (tahunTransaksi == tahunInput) {
                    System.out.println(String.format("║ %3s ║ %-" + columnWidths[0] + "s ║ %-" + columnWidths[1] + "s ║ %-" + columnWidths[2] + "s ║ %-" + columnWidths[5] + "s ║ %-" + columnWidths[13] + "s ║ %-" + columnWidths[4] + "s ║ %-" + columnWidths[6] + "s ║ %-" + columnWidths[7] + "s ║ %-" + columnWidths[8] + "s ║ %-" + columnWidths[9] + "s",
                        i,
                        historyTransaksi[i][0], // Nomor Resi
                        historyTransaksi[i][1], // Tanggal
                        historyTransaksi[i][2], // Nama Pengirim
                        historyTransaksi[i][5],  //Jenis Layanan
                        historyTransaksi[i][13],
                        historyTransaksi[i][4], // Tujuan
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

        System.out.println("╚════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝"); 
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
        if (selectedLanguage==0) {
            System.out.println("╔══════════════════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println("║                                                                                                  ║");
            System.out.println("║"+YELLOW+centerString(98, "╔═╗═╗ ╦╔═╗╔═╗╔╦╗╦╔╦╗╦╔═╗╔╗╔  ╔═╗╦ ╦╔═╗╔╦╗╔═╗╔╦╗"+RESET)+"    ║");
            System.out.println("║"+YELLOW+centerString(98, "║╣ ╔╩╦╝╠═╝║╣  ║║║ ║ ║║ ║║║║  ╚═╗╚╦╝╚═╗ ║ ║╣ ║║║"+RESET)+"    ║");
            System.out.println("║"+YELLOW+centerString(98, "╚═╝╩ ╚═╩  ╚═╝═╩╝╩ ╩ ╩╚═╝╝╚╝  ╚═╝ ╩ ╚═╝ ╩ ╚═╝╩ ╩"+RESET)+"    ║");
            System.out.println("║                                                                                                  ║");
            System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
        } else {
            System.out.println("╔══════════════════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println("║                                                                                                  ║");
            System.out.println("║"+YELLOW+centerString(98, "╔═╗╦╔═╗╔╦╗╔═╗╔╦╗  ╔═╗╦╔═╔═╗╔═╗╔═╗╔╦╗╦╔═╗╦"+RESET)+"    ║");
            System.out.println("║"+YELLOW+centerString(98, "╚═╗║╚═╗ ║ ║╣ ║║║  ║╣ ╠╩╗╚═╗╠═╝║╣  ║║║╚═╗║"+RESET)+"    ║");
            System.out.println("║"+YELLOW+centerString(98, "╚═╝╩╚═╝ ╩ ╚═╝╩ ╩  ╚═╝╩ ╩╚═╝╩  ╚═╝═╩╝╩╚═╝╩"+RESET)+"    ║");
            System.out.println("║                                                                                                  ║");
            System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
        }

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

    private static void pressEnter() {
        System.out.print(languageModule[81][selectedLanguage]);//"Tekan [  ⏎ Enter] untuk melanjutkan"
        input.nextLine();
        clearTerminal();
    }

    private static void viewAdminMenu() {
        System.out.println("║                                                                                                  ║");
        System.out.println("║             ╭──────────────────────────────────────────────────────────────────────╮             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │     [1]. "+padString(28, languageModule[5][selectedLanguage])+"[6]. "+padString(27, languageModule[68][selectedLanguage])+"│             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │     [2]. "+padString(28, languageModule[18][selectedLanguage])+"[7]. "+padString(27, languageModule[71][selectedLanguage])+"│             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │     [3]. "+padString(28, languageModule[49][selectedLanguage])+"[8]. "+padString(27, languageModule[72][selectedLanguage])+"│             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │     [4]. "+padString(28, languageModule[55][selectedLanguage])+"[9]. "+padString(27, languageModule[78][selectedLanguage])+"│             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │     [5]. "+padString(60, languageModule[67][selectedLanguage])+"│             ║");
        System.out.println("║             │                                                                      │             ║"); 
        System.out.println("║             ╰──────────────────────────────────────────────────────────────────────╯             ║");
        System.out.println("║                                                                                                  ║"); 
        System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
    }
    
    private static void viewLanguageMenu() {
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
    }

    private static void viewCourierMenu() {
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
    }

    private static void viewCashierMenu() {
        System.out.println("║             ╭──────────────────────────────────────────────────────────────────────╮             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │   [1]. " + padString(44, languageModule[19][selectedLanguage]) + "   [4]. " + padString(44, languageModule[65][selectedLanguage]) + "   │             ║");
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

    private static void viewUserManagementMenu() {
        System.out.println("║                                                                                                  ║");
        System.out.println("║             ╭──────────────────────────────────────────────────────────────────────╮             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │                     [1]. " + padString(44, languageModule[6][selectedLanguage]) + "│             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │                     [2]. " + padString(44, languageModule[11][selectedLanguage]) + "│             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │                     [3]. " + padString(44, languageModule[15][selectedLanguage]) + "│             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │                     [4]. " + padString(44, languageModule[78][selectedLanguage]) + "│             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │                                                                      │             ║"); 
        System.out.println("║             ╰──────────────────────────────────────────────────────────────────────╯             ║");
        System.out.println("║                                                                                                  ║"); 
        System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
    }

    private static void viewExpeditionTransactionMenu() {
        System.out.println("║                                                                                                  ║");
        System.out.println("║             ╭──────────────────────────────────────────────────────────────────────╮             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │                     [1]. " + padString(44, languageModule[19][selectedLanguage]) + "│             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │                     [2]. " + padString(44, languageModule[43][selectedLanguage]) + "│             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │                     [3]. " + padString(44, languageModule[46][selectedLanguage]) + "│             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │                     [4]. " + padString(44, languageModule[83][selectedLanguage]) + "│             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │                     [5]. " + padString(44, languageModule[17][selectedLanguage]) + "│             ║");
        System.out.println("║             │                                                                      │             ║"); 
        System.out.println("║             ╰──────────────────────────────────────────────────────────────────────╯             ║");
        System.out.println("║                                                                                                  ║"); 
        System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
    }

    private static void viewRouteMenu() {
        System.out.println("║                                                                                                  ║");
        System.out.println("║             ╭──────────────────────────────────────────────────────────────────────╮             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │                     [1]. " + padString(44, languageModule[50][selectedLanguage]) + "│             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │                     [2]. " + padString(44, languageModule[119][selectedLanguage]) + "│             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │                     [3]. " + padString(44, languageModule[53][selectedLanguage]) + "│             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │                     [4]. " + padString(44, languageModule[54][selectedLanguage]) + "│             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │                     [5]. " + padString(44, languageModule[78][selectedLanguage]) + "│             ║");
        System.out.println("║             │                                                                      │             ║"); 
        System.out.println("║             ╰──────────────────────────────────────────────────────────────────────╯             ║");
        System.out.println("║                                                                                                  ║"); 
        System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
    }

    private static void viewCostManagementMenu() {
        System.out.println("║                                                                                                  ║");
        System.out.println("║             ╭──────────────────────────────────────────────────────────────────────╮             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │          [1]. " + padString(55, languageModule[69][selectedLanguage]) + "│             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │          [2]. " + padString(55, languageModule[70][selectedLanguage]) + "│             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │          [3]. " + padString(55, languageModule[78][selectedLanguage]) + "│             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │                                                                      │             ║"); 
        System.out.println("║             ╰──────────────────────────────────────────────────────────────────────╯             ║");
        System.out.println("║                                                                                                  ║"); 
        System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
    }

    private static void viewServiceMenu() {
        System.out.println("║                                                                                                  ║");
        System.out.println("║             ╭──────────────────────────────────────────────────────────────────────╮             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │                     [1]. " + padString(44, languageModule[56][selectedLanguage]) + "│             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │                     [2]. " + padString(44, languageModule[61][selectedLanguage]) + "│             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │                     [3]. " + padString(44, languageModule[64][selectedLanguage]) + "│             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │                     [4]. " + padString(44, languageModule[65][selectedLanguage]) + "│             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │                     [5]. " + padString(44, languageModule[78][selectedLanguage]) + "│             ║");
        System.out.println("║             │                                                                      │             ║"); 
        System.out.println("║             ╰──────────────────────────────────────────────────────────────────────╯             ║");
        System.out.println("║                                                                                                  ║"); 
        System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
    }

    private static void notificationBox(int textWidth, String s) {
        System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
        System.out.println("║                                                                                                  ║");
        System.out.println("║"+centerString(textWidth, s)+"║");
        System.out.println("║                                                                                                  ║");
        System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════════════╝");
    }

    private static void AddUser() {
        System.out.print(languageModule[7][selectedLanguage]);
        String usernameBaru = input.next();
        System.out.print(languageModule[8][selectedLanguage]);
        String katasandiBaru = input.next();
        System.out.print(languageModule[9][selectedLanguage]);
        String jabatanBaru = input.next();
        input.nextLine();
                                    
        userData = Arrays.copyOf(userData,userData.length + 1);
        userData[userData.length-1] = new String[] {
            usernameBaru,
            katasandiBaru,
            jabatanBaru};

        notificationBox(97, languageModule[10][selectedLanguage]);
    }

    private static void EditUser() {
        boolean found = false;
        System.out.print(languageModule[12][selectedLanguage]);
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
            notificationBox(100, languageModule[13][selectedLanguage]);
        } else {
            notificationBox(99, languageModule[14][selectedLanguage]);
        }
    }

    private static void Login() {
        System.out.print(languageModule[1][selectedLanguage]);
        String inputUsername = input.next();

        System.out.print(languageModule[2][selectedLanguage]);
        String inputPassword = input.next();
        input.nextLine();

        loginValidation(inputUsername, inputPassword);

        if(!masuk){
            notificationBox(97, languageModule[4][selectedLanguage]);
            pressEnter();
        }
    }

    private static void ManageUser() {
        while(true) {
            displayHeader();
            displayIndonesianMap();
            viewUserManagementMenu();
            
            System.out.print(languageModule[80][selectedLanguage]);//"║ ⤷ Masukkan Pilihan: "
            int pilihan = input.nextInt();

            switch (pilihan) {

                case 1:
                    AddUser();
                    pressEnter();
                    continue;

                case 2:
                    EditUser();
                    pressEnter();
                    continue;   

                case 3:
                    input.nextLine();
                    clearTerminal();
                    viewUserAccounts();
                    pressEnter();
                    continue;

                case 4:
                    clearTerminal();
                    break;  

                default:
                    continue;
            }
            break;                
        }
    }

    private static void ManageTransaction() {
        while (true) {
            displayHeader();
            displayIndonesianMap();
            viewExpeditionTransactionMenu();
            System.out.print(languageModule[80][selectedLanguage]); //"║ ⤷ Masukkan Pilihan: "

            int subMenu = input.nextInt();
            input.nextLine();
            clearTerminal();

            switch (subMenu) {
                case 1:
                    clearTerminal();
                    CreateShipment();
                    pressEnter();                              
                    continue;

                case 2:
                    displayHeader();
                    displayIndonesianMap();
                    EditTransactionStatus();
                    pressEnter();
                    continue;

                case 3: 
                    displayHeader();
                    displayIndonesianMap();
                    deleteTransactionByTrackingNumber();
                    pressEnter();
                    continue;

                case 4:
                    while (true) {
                        displayHeader();
                        displayIndonesianMap();
                        Calendar calendar = Calendar.getInstance();
                        viewExpeditionHistoryMenu();
                        System.out.print(languageModule[80][selectedLanguage]);//"║ ⤷ Masukkan Pilihan: "
                        int editMenu = input.nextInt();
                        input.nextLine();
                        
                        switch (editMenu) {
                            case 1:
                                searchHistoryDateRange();
                                pressEnter();
                                continue;

                            case 2:
                                searchHistoryByDay();
                                pressEnter(); 
                                continue;

                            case 3:
                                searchHistoryByMonth();
                                pressEnter(); 
                                continue;

                            case 4:
                                searchHistoryByYear();
                                pressEnter(); 
                                continue;

                            case 5:
                                searchHistoryByTrackingNumber();
                                pressEnter();                                                         
                                continue;

                            case 6:
                                break;

                            default:
                                continue;
                        }
                        break;
                    }

                case 5:
                    break;
                default:
                    continue;
            }
            break;
        }
    }

    private static void ManageLanguage() {
        do {
            clearTerminal();
            displayHeader();
            displayIndonesianMap();
            viewLanguageMenu();

            System.out.print(languageModule[80][selectedLanguage]);//"║ ⤷ Masukkan Pilihan: "
            inputselectedLanguage = input.nextInt();
            changeLanguage(inputselectedLanguage);
        } while (inputselectedLanguage > languageModule[0].length);
    }

    private static void ManageRoute() {
        while (true) {
            displayHeader();
            displayIndonesianMap();
            viewRouteMenu();

            System.out.print(languageModule[80][selectedLanguage]); //"║ ⤷ Masukkan Pilihan: "
            subMenu = input.nextInt();

            input.nextLine();
            clearTerminal();

            switch (subMenu) {
                case 1:
                    AddRoute();
                    pressEnter();
                    continue;

                case 2:
                    EditRoute();
                    pressEnter();
                    continue;

                case 3:
                    DeleteRoute();
                    pressEnter();
                    continue;

                case 4:
                    viewExpeditionRoutes();
                    pressEnter();  
                    continue;

                case 5:
                    clearTerminal();
                    break;
                    
                default:
                    continue;
                }
            break;
        }
    }

    private static void viewExpeditionHistoryMenu() {
        System.out.println("║                                                                                                  ║");
        System.out.println("║             ╭──────────────────────────────────────────────────────────────────────╮             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │          [1]. " + padString(25, languageModule[84][selectedLanguage]) + "[4]. " + padString(25, languageModule[87][selectedLanguage]) + "│             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │          [2]. " + padString(25, languageModule[85][selectedLanguage]) + "[5]. " + padString(25, languageModule[88][selectedLanguage]) + "│             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │          [3]. " + padString(25, languageModule[86][selectedLanguage]) + "[6]. " + padString(25, languageModule[17][selectedLanguage]) + "│             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │                                                                      │             ║"); 
        System.out.println("║             ╰──────────────────────────────────────────────────────────────────────╯             ║");
        System.out.println("║                                                                                                  ║"); 
        System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
    }

    private static void searchHistoryByTrackingNumber() {
        validInput = false;
        int searchIndex = -1;
        String searchString = "";

        while (!validInput) {
            System.out.print(languageModule[44][selectedLanguage]);
            searchString = input.nextLine();
            try {
                validInput = true;

                for (int i=0; i<historyTransaksi.length; i++) {
                    if (historyTransaksi[i][0].equals(searchString)) {
                        viewExpeditionHistoryByTrackingNumber(searchString);
                        System.out.print(languageModule[81][selectedLanguage]);//"Tekan [  ⏎ Enter] untuk melanjutkan"
                        input.nextLine();   
                        clearTerminal(); 
                        searchIndex = i;
                        break;
                }
            } 
            if (searchIndex != -1) {
                validInput = true;
            } else { System.out.print(languageModule[140][selectedLanguage]); }//"║ Data tidak ditemukan. Silakan coba lagi."

        } catch (NumberFormatException exception) {
                System.out.print(languageModule[120][selectedLanguage]);;
            }
        }
    }

    private static void searchHistoryByYear() {
        try {
            int tahunInput = 0;

            validInput = false;
            while (!validInput) {
                System.out.print(languageModule[139][selectedLanguage]);//"║ ⤷ Masukkan Tahun: "

                if (input.hasNextInt()) {
                    tahunInput = input.nextInt();
                    input.nextLine();

                    if (tahunInput >= 1900 && tahunInput <= 3000) {
                        validInput = true;
                    } else {
                        System.out.print(languageModule[138][selectedLanguage]);//"║ Tahun tidak valid. Harap masukkan tahun antara 1900 dan 3000."
                    }
                } else {
                    System.out.print(languageModule[137][selectedLanguage]);//"║ Input bukan angka. Silakan masukkan tahun antara 1900 dan 3000."
                    input.next(); 
                }
            }
            clearTerminal();
            viewExpeditionHistoryByYear(tahunInput);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void searchHistoryByMonth() {
        try {
            int bulanInput;
            validInput = false;
            while (true) {
                System.out.print(languageModule[136][selectedLanguage]);//"║ ⤷ Masukkan Bulan (MM): "
                if (input.hasNextInt()) {
                    bulanInput = input.nextInt();
                    if (bulanInput >= 1 && bulanInput <= 12) {
                        break; // Keluar dari loop saat input valid
                    } else {
                        System.out.print(languageModule[135][selectedLanguage]);//"║ Bulan tidak valid. Masukkan angka antara 1 sampai 12."
                    }
                } else {
                    System.out.print(languageModule[134][selectedLanguage]);//"║ Masukkan angka antara 1 sampai 12."
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

            clearTerminal();
            input.nextLine();
            viewExpeditionHistoryByMonth(startDate, endDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void searchHistoryByDay() {
        try {
            int tanggalInput;
            validInput = false;
            while (!validInput) {
                System.out.print(languageModule[133][selectedLanguage]);//"║ ⤷ Masukkan Tanggal (dd): "
                if (input.hasNextInt()) {
                    tanggalInput = input.nextInt();
        
                    if (tanggalInput < 1 || tanggalInput > 31) {
                        System.out.print(languageModule[132][selectedLanguage]);//"║ Tanggal tidak valid."
                    } else {
                        validInput = true;
                        Calendar cal = Calendar.getInstance();
                        int bulanSekarang = cal.get(Calendar.MONTH) + 1; // Bulan dimulai dari 0
                        int tahunSekarang = cal.get(Calendar.YEAR);
        
                        String tanggalYangDiinginkan = String.format("%02d-%02d-%d", tanggalInput, bulanSekarang, tahunSekarang);
                        Date startDate = dateFormat.parse(tanggalYangDiinginkan);
                        Date endDate = dateFormat.parse(tanggalYangDiinginkan);
        
                        clearTerminal();
                        input.nextLine();
                        viewExpeditionHistoryByDay(startDate, endDate);
                    }
                } else {
                    System.out.print(languageModule[131][selectedLanguage]);//"║ Input harus berupa angka."
                    input.next(); 
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void searchHistoryDateRange() {
        boolean validInputTanggalAwal = false;
        boolean validInputTanggalAkhir = false;
        do {
            try {
                System.out.print(languageModule[130][selectedLanguage]);//"║ ⤷ Masukkan Tanggal Awal (dd-MM-yyyy): "
                inputanTanggalAwal = input.next();
                startDate = dateFormat.parse(inputanTanggalAwal);
                validInputTanggalAwal = true;
            } catch (ParseException | InputMismatchException e) {
                System.out.print(languageModule[128][selectedLanguage]);//format tanggal tidak valid 
                input.nextLine(); 
            }
            
        } while (!validInputTanggalAwal);
    
        do {
            try {
                System.out.print(languageModule[129][selectedLanguage]);//"║ Masukkan Tanggal Akhir (dd-MM-yyyy): "
                inputanTanggalAkhir = input.next();
                endDate = dateFormat.parse(inputanTanggalAkhir);
                validInputTanggalAkhir = true;
            } catch (ParseException | InputMismatchException e) {
               System.out.print(languageModule[128][selectedLanguage]);//Format tanggal tidak valid
                input.nextLine(); 
            }
        } while (!validInputTanggalAkhir);
    
        try {
            clearTerminal();
            input.nextLine();
            viewExpeditionHistoryByRange(startDate, endDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void deleteTransactionByTrackingNumber() {
        validInput = false;
        int deleteIndex = -1;

        while (!validInput) {
            System.out.print(languageModule[44][selectedLanguage]);
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
    }

    private static void CreateShipment() {
        String nomorResi;
        int pilihanLayanan;
        double biayaJarak = 0;

        System.out.println("╔══════════════════════════════════════════════════════════════════════════════════════════════════╗");

        System.out.print (languageModule[20][selectedLanguage]);
        String namaPengirim = input.nextLine();

        System.out.print (languageModule[21][selectedLanguage]);
        String nomorKontak = input.nextLine();

        System.out.print (languageModule[22][selectedLanguage]);
        String namaPenerima = input.nextLine();

        System.out.print (languageModule[23][selectedLanguage]);
        String alamatPenerima = input.nextLine();

        System.out.print(languageModule[24][selectedLanguage]);
        String deskripsiBarang = input.nextLine();

        double beratBarang=0;
        int panjang;
        int luas;
        int tinggi;
        int berat=0;
        do {
            System.out.print(languageModule[82][selectedLanguage]);
            while (!input.hasNextInt()) {
                input.nextLine();
                System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
                System.out.println("║                                                                                                  ║");
                System.out.println("║"+centerString(99,languageModule[114][selectedLanguage]+ "║"));  //"⚠️ INPUT HARUS BERUPA BILANGAN BULAT. SILAHKAN COBA LAGI.")
                System.out.println("║                                                                                                  ║");
                System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════════════╝");
                System.out.print(languageModule[81][selectedLanguage]);//"Tekan [  ⏎ Enter] untuk melanjutkan"
                input.nextLine();  
                System.out.print("\033[7A\033[0J");
                System.out.print(languageModule[82][selectedLanguage]); //"║ Masukkan Berat: "
            }
            berat= input.nextInt();

            input.nextLine(); // membersihkan buffer input
            if (berat <= 0) {
                input.nextLine();
                System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
                System.out.println("║                                                                                                  ║");
                System.out.println("║"+centerString(99,languageModule[115] +"║"));  //"⚠️ BERAT HARUS LEBIH BESAR DARI 0 . SILAHKAN COBA LAGI.")
                System.out.println("║                                                                                                  ║");
                System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════════════╝");
                System.out.print(languageModule[81][selectedLanguage]);//"Tekan [  ⏎ Enter] untuk melanjutkan"
                input.nextLine();  
                System.out.print("\033[7A\033[0J");
            } else {
                validInput = true;
            }
        } while (!validInput);
        
        do {
            System.out.print(languageModule[25][selectedLanguage]); //"║ Masukkan Panjang: "
            while (!input.hasNextInt()) {
                input.nextLine();
                System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
                System.out.println("║                                                                                                  ║");
                System.out.println("║"+centerString(99,languageModule[114][selectedLanguage] +"║"));  //"⚠️ INPUT HARUS BERUPA BILANGAN BULAT. SILAHKAN COBA LAGI.")
                System.out.println("║                                                                                                  ║");
                System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════════════╝");
                System.out.print(languageModule[81][selectedLanguage]);//"Tekan [  ⏎ Enter] untuk melanjutkan"
                input.nextLine();  
                System.out.print("\033[7A\033[0J");
                System.out.print(languageModule[25][selectedLanguage]); //msukan panjang
            }
            panjang= input.nextInt();

            input.nextLine(); // membersihkan buffer input
            if (panjang <= 0) {
                input.nextLine();
                System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
                System.out.println("║                                                                                                  ║");
                System.out.println("║"+centerString(99, languageModule[116][selectedLanguage])+"║");  //"⚠️ PANJANG HARUS LEBIH BESAR DARI 0 . SILAHKAN COBA LAGI.")+"
                System.out.println("║                                                                                                  ║");
                System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════════════╝");
                System.out.print(languageModule[81][selectedLanguage]);//"Tekan [  ⏎ Enter] untuk melanjutkan"
                input.nextLine();  
                System.out.print("\033[7A\033[0J");
            } else {
                validInput = true;
            }
        } while (!validInput);
        
        do {
            System.out.print(languageModule[26][selectedLanguage]); //"║ Masukkan Lebar: "
            while (!input.hasNextInt()) {
                input.nextLine();
                System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
                System.out.println("║                                                                                                  ║");
                System.out.println("║"+centerString(99,languageModule[114][selectedLanguage] )+"║"); //"⚠️ INPUT HARUS BERUPA BILANGAN BULAT. SILAHKAN COBA LAGI."
                System.out.println("║                                                                                                  ║");
                System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════════════╝");
                System.out.print(languageModule[81][selectedLanguage]);//"Tekan [  ⏎ Enter] untuk melanjutkan"
                input.nextLine();  
                System.out.print("\033[7A\033[0J");
                System.out.print(languageModule[26][selectedLanguage]); //"║ Masukkan Lebar: "
            }
            luas = input.nextInt();

            input.nextLine(); // membersihkan buffer input
            if (luas <= 0) {
                input.nextLine();
                System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
                System.out.println("║                                                                                                  ║");
                System.out.println("║"+centerString(99, languageModule[117][selectedLanguage])+"║"); //"⚠️ LEBAR HARUS LEBIH BESAR DARI 0. SILAHKAN COBA LAGI."
                System.out.println("║                                                                                                  ║");
                System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════════════╝");
                System.out.print(languageModule[81][selectedLanguage]);//"Tekan [  ⏎ Enter] untuk melanjutkan"
                input.nextLine();  
                System.out.print("\033[7A\033[0J");
            } else {
                validInput = true;
            }
        } while (!validInput);

        do {
            System.out.print(languageModule[27][selectedLanguage]); //"║ Masukkan Tinggi: "
            while (!input.hasNextInt()) {
                input.nextLine();
                System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
                System.out.println("║                                                                                                  ║");
                System.out.println("║"+centerString(99,languageModule[114][selectedLanguage] )+"║");     //"⚠️ INPUT HARUS BERUPA BILANGAN BULAT. SILAHKAN COBA LAGI."
                System.out.println("║                                                                                                  ║");
                System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════════════╝");
                System.out.print(languageModule[81][selectedLanguage]);//"Tekan [  ⏎ Enter] untuk melanjutkan"
                input.nextLine();  
                System.out.print("\033[7A\033[0J");
                System.out.print(languageModule[27][selectedLanguage]); //"║ Masukkan Tinggi: "
            }
            tinggi = input.nextInt();

            input.nextLine(); // membersihkan buffer input
            if (tinggi <= 0) {
                input.nextLine();
                System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
                System.out.println("║                                                                                                  ║");
                System.out.println("║"+centerString(99,languageModule[118][selectedLanguage] )+"║"); //"⚠️ TINGGI HARUS LEBIH BESAR DARI 0. SILAHKAN COBA LAGI."
                System.out.println("║                                                                                                  ║");
                System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════════════╝");
                System.out.print(languageModule[81][selectedLanguage]);//"Tekan [  ⏎ Enter] untuk melanjutkan"
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
            System.out.print("║ " + languageModule[93][selectedLanguage] + ": ");//asal
            origin = input.nextLine();

            System.out.print("║ " + languageModule[94][selectedLanguage] + ": ");//tujuan
            destination = input.nextLine();

            for (int i = 0; i < rutePengiriman.length; i++) {
                if ((rutePengiriman[i][0].equalsIgnoreCase(origin) && rutePengiriman[i][1].equalsIgnoreCase(destination)) || 
                (rutePengiriman[i][0].equalsIgnoreCase(destination) && rutePengiriman[i][1].equalsIgnoreCase(origin))) {
                    int jarak = Integer.parseInt(rutePengiriman[i][2]);
                    double tarifTambahan = 15000;
                            if (jarak <= 100) {
                                biayaJarak = (jarak * tarifPerKm) / 100;
                            } else {
                                double biayaAwal = (100 * tarifPerKm) / 100; // Biaya untuk 100 km pertama

                                // Menghitung sisa jarak setelah 100 km pertama
                                double sisaJarak = jarak - 100;

                                // Menghitung biaya tambahan untuk setiap 10 km selanjutnya
                                double biayaTambahan = Math.ceil(sisaJarak / 10) * tarifTambahan;

                                // Total biaya jarak termasuk tambahan
                                biayaJarak = biayaAwal + biayaTambahan;
                            }
                    found = true;
                    break;
                }
            }
            if(!found) {
                origin = "";
                destination = "";
                System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
                System.out.println("║                                                                                                  ║");
                System.out.println("║"+centerString(98, languageModule[28][selectedLanguage])+"║"); //"⚠️ RUTE TIDAK DITEMUKAN. SILAKAN COBA LAGI."
                System.out.println("║                                                                                                  ║");
                System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════════════╝");
                System.out.print(languageModule[81][selectedLanguage]);//"Tekan [  ⏎ Enter] untuk melanjutkan"
                input.nextLine();  
                System.out.print("\033[8A\033[0J");
            }    
        } while (!found);

        //Memilih Jenis Layanan pada Array

        System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════════════╝");
        viewExpeditionServices();
        System.out.print (languageModule[142][selectedLanguage]);//" ⤷ Masukkan Pilihan: "
        pilihanLayanan = input.nextInt();
        double tarifLayanan = Double.parseDouble(arrayLayanan[pilihanLayanan][1]);
        double beratBarangTemp; 
        if (beratBarang >= 0) {
                    beratBarangTemp = (beratBarang * tarifPerKg) / 5;
                } else {
                    beratBarangTemp = (tarifPerKg * (panjang * luas * tinggi) / 4000) / 5;
                }
                beratBarang = Math.max(beratBarang, beratBarangTemp);

                double biayaAkhir = tarifLayanan + beratBarang + biayaJarak;
        nomorResi = generateTrackingNumber();

        System.out.println("╔════════════════════════════════════════════════════════════╗"); 
        System.out.println("║"+centerString(60,languageModule[30][selectedLanguage])+"║"); //"Metode Pembayaran"
        System.out.println("╠════════════════════════════════════════════════════════════╣");

        System.out.println("║ 1. VIA Bank");
        System.out.println("║ 2. Tunai");
        System.out.println("╚════════════════════════════════════════════════════════════╝");
        System.out.print(languageModule[31][selectedLanguage]); //" ⤷ Pilih Metode Pembayaran: "
        int metode = input.nextInt();

        switch (metode) {
            case 1:
                while (true) {

                    System.out.println("╔════════════════════════════════════════════════════════════╗"); 
                    System.out.println("║"+centerString(60,"BANK")+"║");
                    System.out.println("╠════════════════════════════════════════════════════════════╣");
                    System.out.println("║ 1. BRI");
                    System.out.println("║ 2. BNI");
                    System.out.println("║ 3. MANDIRI");
                    System.out.println("╚════════════════════════════════════════════════════════════╝");
                
                    System.out.print(languageModule[32][selectedLanguage]); //"⤷ Pilih Bank "
                    int jenisBank = input.nextInt();

                    switch (jenisBank) {
                        case 1:
                            bankName = "BRI";
                            break;

                        case 2:
                            bankName = "BNI";
                            break;

                        case 3:
                            bankName = "MANDIRI";
                            break;

                        default:
                            continue;
                    }  
                    break;
                }
                System.out.println(languageModule[33][selectedLanguage] +bankName);
                break;   //"║ Pembayaran Berhasil menggunakan "

            case 2:
                System.out.println(languageModule[36][selectedLanguage]+biayaAkhir);    //"║ Biaya Pengiriman sebesar: " 
                System.out.print(languageModule[37][selectedLanguage]); //"║ Bayar: "
                int bayar = input.nextInt();
                System.out.println(languageModule[38][selectedLanguage] +(bayar - biayaAkhir)); //"║ Kembalian: "
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
        input.nextLine();
    }

    private static void EditTransactionStatus() {
        validInput = false;
        int index = -1;

        while (!validInput) {
            System.out.print(languageModule[44][selectedLanguage]); //"║ ⤷ Masukkan nomor resi: "
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
                System.out.print(languageModule[80][selectedLanguage]);//"║ ⤷ Masukkan Pilihan: "
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
                System.out.println("║"+YELLOW+centerString(98, languageModule[45][selectedLanguage])+RESET);    //"Data tidak ditemukan"
                System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════════════╝");
            }

        } catch (NumberFormatException exception) {
                System.out.print(languageModule[120][selectedLanguage]);;//"║ Input yang dimasukkan tidak valid. Silakan masukkan nomor resi kembali!."
            }
        }
    }

    private static void AddRoute() {
        clearTerminal();
        viewExpeditionRoutes();

        boolean routeExist = false;
        String origin;
        String destination;
        
        do {
            routeExist = false;
            System.out.print("⤷ Origin: ");
            origin = input.nextLine();
            System.out.print("⤷ Destination: ");
            destination = input.nextLine();

            for (int i = 0; i < rutePengiriman.length; i++) {
                if ((rutePengiriman[i][0].equalsIgnoreCase(origin) && rutePengiriman[i][1].equalsIgnoreCase(destination)) || 
                (rutePengiriman[i][0].equalsIgnoreCase(destination) && rutePengiriman[i][1].equalsIgnoreCase(origin))) {
                    System.out.print(languageModule[121][selectedLanguage]);//"Rute tersebut sudah ada!"
                    routeExist = true;
                    break;
                } 
            }


            } while (routeExist); 

            System.out.print(languageModule[52][selectedLanguage]+origin+" - "+destination+": ");   //"║ ⤷ Masukkan Jarak antara "
            String jarak = input.next();

            rutePengiriman = Arrays.copyOf(rutePengiriman,rutePengiriman.length + 1);
            rutePengiriman[rutePengiriman.length-1] = new String[] {
                origin,
                destination,
                jarak};

        clearTerminal();
        input.nextLine();
        viewExpeditionRoutes();
    }

    private static void DeleteRoute() {
        clearTerminal();
        viewExpeditionRoutes();

        int deleteIndex = 0;
        validInput = false;

        while (!validInput) {
            System.out.print(languageModule[122][selectedLanguage]);//"⤷ Masukkan nomor rute yang ingin dihapus: "
            try {
                deleteIndex = Integer.parseInt(input.nextLine());
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println(languageModule[111][selectedLanguage]);   //"Input yang dimasukkan bukan angka. Silakan masukkan nomor."
            }
        }

        if (deleteIndex >= 1 && deleteIndex <= rutePengiriman.length) {
            String deletedLocation = rutePengiriman[deleteIndex - 1][0]+" "+rutePengiriman[deleteIndex - 1][1];
            System.out.println("║ " + deletedLocation + languageModule[112][selectedLanguage]);//telah dihapus

            System.arraycopy(rutePengiriman, deleteIndex, rutePengiriman, deleteIndex - 1, rutePengiriman.length - deleteIndex);
            rutePengiriman = Arrays.copyOf(rutePengiriman, rutePengiriman.length - 1);
        } else {
            System.out.print(languageModule[123][selectedLanguage]);//"Nomor rute tidak valid"
        }

        clearTerminal();
        viewExpeditionRoutes();
    }

    private static void ManageService() {
        while (true) {
            displayHeader();
            displayIndonesianMap();
            viewServiceMenu();

            System.out.print(languageModule[80][selectedLanguage]);//"║ ⤷ Masukkan Pilihan: "
            subMenu = input.nextInt();
            input.nextLine();

            switch (subMenu) {
                case 1:
                    AddService();
                    pressEnter();
                    continue;

                case 2:
                    clearTerminal();
                    viewExpeditionServices();
                    EditService();
                    clearTerminal();
                    viewExpeditionServices();
                    pressEnter();
                    continue;

                case 3:
                    clearTerminal();
                    viewExpeditionServices();
                    DeleteService();
                    clearTerminal();
                    viewExpeditionServices();
                    pressEnter();
                    continue;

                case 4:
                    clearTerminal();
                    viewExpeditionServices();
                    pressEnter();
                    continue;

                case 5:
                    clearTerminal();
                    break;

                default:
                    continue;
            }
            break;
        }
    }

    private static void AddService() {
        String namaLayanan = "";
        double tarifLayanan = 0;
        int startEstimation = 0;
        int endEstimation = 0;
        boolean inputValid = false;

            System.out.print(languageModule[57][selectedLanguage]);// "║ ⤷ Masukkan Nama Layanan: "
            namaLayanan = input.next();
            while (!inputValid) {
                System.out.print(languageModule[58][selectedLanguage]);//"║ ⤷ Masukkan Tarif: Rp."
                if (input.hasNextDouble()) {
                    tarifLayanan = input.nextDouble();
                    inputValid = true;
                } else {
                    System.out.println(languageModule[111][selectedLanguage]);  //"║ Input bukan angka. Mohon masukkan nomor layanan yang valid:"
                    input.next();
                }
            }

            System.out.print(languageModule[59][selectedLanguage]);//"║ ⤷ Masukkan Waktu Pengiriman Minimum: "
            startEstimation = input.nextInt();
            System.out.print(languageModule[60][selectedLanguage]);//"║ ⤷ Masukkan Waktu Pengiriman Maximum: "
            endEstimation = input.nextInt();

            arrayLayanan = Arrays.copyOf(arrayLayanan,arrayLayanan.length + 1);
            arrayLayanan[arrayLayanan.length-1] = new String[] {
                namaLayanan,
                String.valueOf(tarifLayanan),
                String.valueOf(startEstimation),
                String.valueOf(endEstimation)};

    }

    private static void EditService() {
        boolean inputValid = false;

        System.out.print(languageModule[63][selectedLanguage]);//"⤷ Masukkan nomor layanan yang ingin diubah: "
        int selectedService = 0;
        String newData;

        while (!inputValid) {
            if (input.hasNextInt()) {
                selectedService = input.nextInt()-1;
                if (selectedService <= arrayLayanan.length) {
                    inputValid = true;
                } else {
                    System.out.print(languageModule[124][selectedLanguage]);//"║ Nomor layanan tidak valid. Masukkan nomor layanan yang valid:"
                    input.nextLine();
                }
            } else {
                System.out.println(languageModule[111][selectedService]);   //"║ Input bukan angka. Mohon masukkan nomor layanan yang valid:"
                input.next();
            }
        }

        inputValid = false;
        input.nextLine();

        System.out.print(languageModule[125][selectedLanguage]);//"⤷ Tekan [⏎ Enter] jika tidak ingin mengedit data"

        System.out.print("\t"+arrayLayanan[selectedService][0] + " ➺  ");
        newData = input.nextLine();
        if(!newData.trim().isEmpty()) {
            arrayLayanan[selectedService][0] = newData;
        }

        System.out.print("\t"+arrayLayanan[selectedService][1] + " ➺  ");
        newData = input.nextLine();
        if(!newData.trim().isEmpty()) {
            arrayLayanan[selectedService][1] = newData;
        }

        System.out.print("\t"+arrayLayanan[selectedService][2] + " ➺  ");
        newData = input.nextLine();
        if(!newData.trim().isEmpty()) {
            arrayLayanan[selectedService][2] = newData;
        }

        System.out.print("\t"+arrayLayanan[selectedService][3] + " ➺  ");
        newData = input.nextLine();
        if(!newData.trim().isEmpty()) {
            arrayLayanan[selectedService][3] = newData;
        }
    }

    private static void DeleteService() {
        int deleteIndex = 0;
        validInput = false;

        while (!validInput) {
            try {
                System.out.print(languageModule[110][selectedLanguage]);//"⤷ Pilih index layanan yang ingin dihapus: "
                deleteIndex = input.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println(languageModule[111][selectedLanguage]);//"║ Input bukan angka. Mohon masukkan nomor layanan yang valid:"
                input.nextLine();
            }
        }

        if (deleteIndex >= 1 && deleteIndex <= arrayLayanan.length) {
            String deletedLocation = arrayLayanan[deleteIndex - 1][0]+" "+arrayLayanan[deleteIndex - 1][1];

            System.arraycopy(arrayLayanan, deleteIndex, arrayLayanan, deleteIndex - 1, arrayLayanan.length - deleteIndex);
            arrayLayanan = Arrays.copyOf(arrayLayanan, arrayLayanan.length - 1);
        } else {
            System.out.println(languageModule[113][selectedLanguage]);//"Nomor layanan tidak valid."
        }
        input.nextLine();
    }

    private static void ManageCost() {
        while (true) {
            displayHeader();
            displayIndonesianMap();
            viewCostManagementMenu();
            System.out.print(languageModule[80][selectedLanguage]);//"║ ⤷ Masukkan Pilihan: "
            subMenu = input.nextInt();

            switch (subMenu) {
                case 1:
                    System.out.print(languageModule[108][selectedLanguage]);//"║ ⤷ Masukkan tarif dasar per Kg: "
                    tarifPerKg = input.nextInt();
                    continue;

                case 2:
                    System.out.print(languageModule[109][selectedLanguage]);//"║ ⤷ Masukkan tarif dasar per Km: "
                    tarifPerKm = input.nextInt();
                    continue;

                case 3:
                    break;
                    
                default:
                    continue;
            }
            break;
        }
    }

    private static void viewReport() {
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
    }

    private static void viewShipmentMenu() {
        System.out.println("║                                                                                                  ║");
        System.out.println("║             ╭──────────────────────────────────────────────────────────────────────╮             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │                     [1]. " + padString(44, languageModule[73][selectedLanguage]) + "│             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │                     [2]. " + padString(44, languageModule[75][selectedLanguage]) + "│             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │                     [3]. " + padString(44, languageModule[77][selectedLanguage]) + "│             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │                     [4]. " + padString(44, languageModule[78][selectedLanguage]) + "│             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │                                                                      │             ║"); 
        System.out.println("║             ╰──────────────────────────────────────────────────────────────────────╯             ║");
        System.out.println("║                                                                                                  ║"); 
        System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");

    }

    private static void viewWarehouseInventory() {
        clearTerminal();
        boolean inputFound = false;
        System.out.print(languageModule[74][selectedLanguage]);//"Kirim Paket"
        String location  = input.nextLine();

        inputFound = true;

        while (inputFound) {
            int[] columnWidths = calculateColumnWidths(historyTransaksi);
            String formattedHeader = String.format("║ %3s ║ %-" + columnWidths[0] + "s ║ %-" + columnWidths[1] + "s ║ %-" + columnWidths[2] + "s ║ %-" + columnWidths[5] + "s ║ %-" + columnWidths[13] + "s ║ %-" + columnWidths[4] + "s ║ %-" + columnWidths[8] + "s ║ %-" + columnWidths[9] + "s ║ %-" + columnWidths[12] + "s",
                "No", 
                languageModule[89][selectedLanguage],//no resi
                languageModule[90][selectedLanguage],//tanggal
                languageModule[91][selectedLanguage],//pengirim
                languageModule[92][selectedLanguage],//layanan
                languageModule[93][selectedLanguage],//asal
                languageModule[94][selectedLanguage],//tujuan
                languageModule[97][selectedLanguage],//penerima
                languageModule[98][selectedLanguage],//alamat
                "Status"
            );

            System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣");
            System.out.println(formattedHeader);
            System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣");

            for (int i = 0; i < historyTransaksi.length; i++) {
                if (historyTransaksi[i][13].equalsIgnoreCase(location) && historyTransaksi[i][12].equalsIgnoreCase("Waiting for pickup") ||
                    historyTransaksi[i][4].equalsIgnoreCase(location) && historyTransaksi[i][12].equalsIgnoreCase("Arrived at warehouse")) {
                        System.out.println(String.format("║ %3s ║ %-" + columnWidths[0] + "s ║ %-" + columnWidths[1] + "s ║ %-" + columnWidths[2] + "s ║ %-" + columnWidths[5] + "s ║ %-" + columnWidths[13] + "s ║ %-" + columnWidths[4] + "s ║ %-" + columnWidths[8] + "s ║ %-" + columnWidths[9] + "s ║ %-" + columnWidths[12] + "s",
                            i,
                            historyTransaksi[i][0], // Nomor Resi
                            historyTransaksi[i][1], // Tanggal
                            historyTransaksi[i][2], // Nama Pengirim
                            historyTransaksi[i][5],  //Jenis Layanan
                            historyTransaksi[i][13],
                            historyTransaksi[i][4], // Tujuan
                            historyTransaksi[i][8], // Nama Penerima
                            historyTransaksi[i][9], // Alamat
                            historyTransaksi[i][12]
                        ));
                }
            }
            break;
        }
        System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣");
    }

    private static void SendPackage() {
        boolean inputFound = false;
        boolean shipmentFound = false;
        int searchIndex = 0;
        String location;
        for (int k = 0; k < shipmentDetails.length; k++) {
            if (shipmentDetails[k][1].equalsIgnoreCase(loggedInUsername) && shipmentDetails[k][2].equalsIgnoreCase("Sending")) {
                shipmentFound = true;
            }
        }
                            

        while (shipmentFound) {
            int[] columnWidths = calculateColumnWidths(historyTransaksi);
            String formattedHeader = String.format("║ %3s ║ %-" + columnWidths[0] + "s ║ %-" + columnWidths[1] + "s ║ %-" + columnWidths[2] + "s ║ %-" + columnWidths[5] + "s ║ %-" + columnWidths[13] + "s ║ %-" + columnWidths[4] + "s ║ %-" + columnWidths[8] + "s ║ %-" + columnWidths[9] + "s ║ %-" + columnWidths[12] + "s",
                "No", 
                languageModule[89][selectedLanguage], //no resi
                languageModule[90][selectedLanguage], //tanggal
                languageModule[91][selectedLanguage], //pengirim
                languageModule[92][selectedLanguage], //layanan
                languageModule[93][selectedLanguage], //asal
                languageModule[94][selectedLanguage], //tujuan
                languageModule[97][selectedLanguage], //penerima
                languageModule[98][selectedLanguage], //alamat
                "Status"
            );
            System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣");
            System.out.println(centerString(98, "Driver: " +loggedInUsername));
            System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣");
            for (int k = 0; k < shipmentDetails.length; k++) {
                if (shipmentDetails[k][1].equalsIgnoreCase(loggedInUsername) && shipmentDetails[k][2].equalsIgnoreCase("Sending")) {
                    for (int i = 0; i < historyTransaksi.length; i++) {
                        if(historyTransaksi[i][0].equals(shipmentDetails[k][0])) {
                            System.out.println(String.format("║ %3s ║ %-" + columnWidths[0] + "s ║ %-" + columnWidths[1] + "s ║ %-" + columnWidths[2] + "s ║ %-" + columnWidths[5] + "s ║ %-" + columnWidths[13] + "s ║ %-" + columnWidths[4] + "s ║ %-" + columnWidths[8] + "s ║ %-" + columnWidths[9] + "s ║ %-" + columnWidths[12] + "s",
                                i,
                                historyTransaksi[i][0], // Nomor Resi
                                historyTransaksi[i][1], // Tanggal
                                historyTransaksi[i][2], // Nama Pengirim
                                historyTransaksi[i][5],  //Jenis Layanan
                                historyTransaksi[i][13],
                                historyTransaksi[i][4], // Tujuan
                                historyTransaksi[i][8], // Nama Penerima
                                historyTransaksi[i][9], // Alamat
                                historyTransaksi[i][12]
                            ));
                        }
                    }
                }
            }
            System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣");

            System.out.print(languageModule[127][selectedLanguage]); //apakah anda ingin mengubah pesanan menjadi selesai
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
            System.out.print(languageModule[74][selectedLanguage]);//"Kirim Paket"
            location  = input.nextLine();

            for (int i = 0; i < rutePengiriman.length; i++) {
                if ((rutePengiriman[i][0].equalsIgnoreCase(location) || rutePengiriman[i][1].equalsIgnoreCase(location))) {
                    inputFound = true;
                } 
            }

            while (inputFound) {
                int[] columnWidths = calculateColumnWidths(historyTransaksi);
                String formattedHeader = String.format("║ %3s ║ %-" + columnWidths[0] + "s ║ %-" + columnWidths[1] + "s ║ %-" + columnWidths[2] + "s ║ %-" + columnWidths[5] + "s ║ %-" + columnWidths[13] + "s ║ %-" + columnWidths[4] + "s ║ %-" + columnWidths[8] + "s ║ %-" + columnWidths[9] + "s ║ %-" + columnWidths[12] + "s",
                    "No", 
                    languageModule[89][selectedLanguage], //"No Resi"
                    languageModule[90][selectedLanguage], //"Tanggal"
                    languageModule[91][selectedLanguage], //"Pengirim"
                    languageModule[92][selectedLanguage], //"Layanan"
                    languageModule[93][selectedLanguage], //"Asal"
                    languageModule[94][selectedLanguage], //"Tujuan"
                    languageModule[97][selectedLanguage], // "Penerima"
                    languageModule[98][selectedLanguage], // "Alamat"
                    "Status"
                );

                clearTerminal();
                System.out.println("╔════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
                System.out.println(formattedHeader);
                System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣");

                for (int i = 0; i < historyTransaksi.length; i++) {
                    if (historyTransaksi[i][13].equalsIgnoreCase(location) && historyTransaksi[i][12].equalsIgnoreCase("Waiting for pickup")) {
                        System.out.println(String.format("║ %3s ║ %-" + columnWidths[0] + "s ║ %-" + columnWidths[1] + "s ║ %-" + columnWidths[2] + "s ║ %-" + columnWidths[5] + "s ║ %-" + columnWidths[13] + "s ║ %-" + columnWidths[4] + "s ║ %-" + columnWidths[8] + "s ║ %-" + columnWidths[9] + "s ║ %-" + columnWidths[12] + "s",
                            i,
                            historyTransaksi[i][0], // Nomor Resi
                            historyTransaksi[i][1], // Tanggal
                            historyTransaksi[i][2], // Nama Pengirim
                            historyTransaksi[i][5],  //Jenis Layanan
                            historyTransaksi[i][13],
                            historyTransaksi[i][4], // Tujuan
                            historyTransaksi[i][8], // Nama Penerima
                            historyTransaksi[i][9], // Alamat
                            historyTransaksi[i][12]
                        ));
                        searchIndex++;
                    }
                }

                System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣");

                if (searchIndex != 0){
                    int indexKirim;
                    System.out.print(languageModule[76][selectedLanguage]);
                    indexKirim = input.nextInt();

                    boolean adaKesamaanData = false;           
                    for (int i = 0; i < historyTransaksi.length; i++) {
                        if (i != indexKirim && historyTransaksi[i][12].equals("Waiting for pickup" ) && 
                                historyTransaksi[i][4].equals(historyTransaksi[indexKirim][4]) && 
                                historyTransaksi[i][5].equals(historyTransaksi[indexKirim][5]) && 
                                historyTransaksi[i][0] != historyTransaksi[indexKirim][0] &&
                                historyTransaksi[i][13].equals(historyTransaksi[indexKirim][13])) {
                                adaKesamaanData = true;
                                System.out.println(String.format("║ %3s ║ %-" + columnWidths[0] + "s ║ %-" + columnWidths[1] + "s ║ %-" + columnWidths[2] + "s ║ %-" + columnWidths[5] + "s ║ %-" + columnWidths[13] + "s ║ %-" + columnWidths[4] + "s ║ %-" + columnWidths[8] + "s ║ %-" + columnWidths[9] + "s ║ %-" + columnWidths[12] + "s",
                                    i,
                                    historyTransaksi[i][0], // Nomor Resi
                                    historyTransaksi[i][1], // Tanggal
                                    historyTransaksi[i][2], // Nama Pengirim
                                    historyTransaksi[i][5],  //Jenis Layanan
                                    historyTransaksi[i][13],
                                    historyTransaksi[i][4], // Tujuan
                                    historyTransaksi[i][8], // Nama Penerima
                                    historyTransaksi[i][9], // Alamat
                                    historyTransaksi[i][12]
                                ));
                        }
                    }

                    if (adaKesamaanData){
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

                                        System.out.println(String.format("║ %3s ║ %-" + columnWidths[0] + "s ║ %-" + columnWidths[1] + "s ║ %-" + columnWidths[2] + "s ║ %-" + columnWidths[5] + "s ║ %-" + columnWidths[13] + "s ║ %-" + columnWidths[4] + "s ║ %-" + columnWidths[8] + "s ║ %-" + columnWidths[9] + "s ║ %-" + columnWidths[12] + "s",
                                            i,
                                            historyTransaksi[i][0], // Nomor Resi
                                            historyTransaksi[i][1], // Tanggal
                                            historyTransaksi[i][2], // Nama Pengirim
                                            historyTransaksi[i][5],  //Jenis Layanan
                                            historyTransaksi[i][13],
                                            historyTransaksi[i][4], // Tujuan
                                            historyTransaksi[i][8], // Nama Penerima
                                            historyTransaksi[i][9], // Alamat
                                            historyTransaksi[i][12]
                                        ));

                                    }
                            }

                            clearTerminal();

                            System.out.println("╔════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
                            System.out.println("║"+centerString(160, location)+"║");
                            System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣");
                            System.out.println(formattedHeader);
                            System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣");

                            for (int i = 0; i < historyTransaksi.length; i++) {
                                if (historyTransaksi[i][13].equalsIgnoreCase(location) && historyTransaksi[i][12].equalsIgnoreCase("Waiting for pickup")) {
                                    System.out.println(String.format("║ %3s ║ %-" + columnWidths[0] + "s ║ %-" + columnWidths[1] + "s ║ %-" + columnWidths[2] + "s ║ %-" + columnWidths[5] + "s ║ %-" + columnWidths[13] + "s ║ %-" + columnWidths[4] + "s ║ %-" + columnWidths[8] + "s ║ %-" + columnWidths[9] + "s ║ %-" + columnWidths[12] + "s",
                                        i,
                                        historyTransaksi[i][0], // Nomor Resi
                                        historyTransaksi[i][1], // Tanggal
                                        historyTransaksi[i][2], // Nama Pengirim
                                        historyTransaksi[i][5],  //Jenis Layanan
                                        historyTransaksi[i][13],
                                        historyTransaksi[i][4], // Tujuan
                                        historyTransaksi[i][8], // Nama Penerima
                                        historyTransaksi[i][9], // Alamat
                                        historyTransaksi[i][12]
                                    ));
                                    searchIndex++;
                                }
                            }

                            System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣");
                            System.out.println("║"+centerString(160, "⇩   "+loggedInUsername+"   ⇩")+"║");
                            System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣");
                            System.out.println(formattedHeader);
                            System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣");

                            for (int k = 0; k < shipmentDetails.length; k++) {
                                if (shipmentDetails[k][1].equalsIgnoreCase(loggedInUsername) && shipmentDetails[k][2].equalsIgnoreCase("Sending")) {
                                    shipmentDetails[k][2] = "Done";

                                    for (int i = 0; i < historyTransaksi.length; i++) {
                                        if(historyTransaksi[i][0].equals(shipmentDetails[k][0])) {
                                            System.out.println(String.format("║ %3s ║ %-" + columnWidths[0] + "s ║ %-" + columnWidths[1] + "s ║ %-" + columnWidths[2] + "s ║ %-" + columnWidths[5] + "s ║ %-" + columnWidths[13] + "s ║ %-" + columnWidths[4] + "s ║ %-" + columnWidths[8] + "s ║ %-" + columnWidths[9] + "s ║ %-" + columnWidths[12] + "s",
                                                i,
                                                historyTransaksi[i][0], // Nomor Resi
                                                historyTransaksi[i][1], // Tanggal
                                                historyTransaksi[i][2], // Nama Pengirim
                                                historyTransaksi[i][5],  //Jenis Layanan
                                                historyTransaksi[i][13],
                                                historyTransaksi[i][4], // Tujuan
                                                historyTransaksi[i][8], // Nama Penerima
                                                historyTransaksi[i][9], // Alamat
                                                historyTransaksi[i][12]
                                            ));
                                        }
                                    }

                                    shipmentFound = true;
                                }
                            }
                            System.out.println("╚════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝");
                            input.nextLine();
                            pressEnter();
                    } else {
                        System.out.println("║ ⤷ Fitur apaan dah ini, kodenya panjang banget");
                    }

                    
                }
                break;
            }
            break;
        }
    }

    private static void ManageShipment() {
        displayHeader();
        displayIndonesianMap();
        viewShipmentMenu();

        System.out.print(languageModule[80][selectedLanguage]);//"║ ⤷ Masukkan Pilihan: "
        subMenu = input.nextInt();
        input.nextLine();

        switch (subMenu) {
            case 1:
                viewWarehouseInventory();
                pressEnter();
                break;
            case 2:
                SendPackage();
                break;
            case 3:
                System.out.println("Under Development");
                pressEnter();
                break;
            default:
                break;
        }
    }

    private static void Logout() {
        System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
        System.out.println("║                                                                                                  ║");
        System.out.println("║"+centerString(98, languageModule[79][selectedLanguage])+"║"); //"Anda telah berhasil keluar. Sampai jumpa lain waktu! 👋"
        System.out.println("║                                                                                                  ║");
        System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════════════╝");
        pressEnter();
        exit=true;
        login=false;
    }

    private static void EditRoute() {
        clearTerminal();

        boolean inputValid = false;

        viewExpeditionRoutes();

        System.out.print(languageModule[126][selectedLanguage]);//"⤷ Masukkan nomor rute yang ingin diubah: "
        int selectedService = 0;
        String newData;

        while (!inputValid) {
            if (input.hasNextInt()) {
                selectedService = input.nextInt()-1;
                if (selectedService <= rutePengiriman.length) {
                    inputValid = true;
                } else {
                    System.out.print(languageModule[124][selectedLanguage]);//"║ Nomor layanan tidak valid. Masukkan nomor layanan yang valid:"
                    input.nextLine();
                }
            } else {
                System.out.println(languageModule[111][selectedService]);   //"║ Input bukan angka. Mohon masukkan nomor layanan yang valid:"
                input.next();
            }
        }

        inputValid = false;
        input.nextLine();

        System.out.print(languageModule[125][selectedLanguage]);//"⤷ Tekan [⏎ Enter] jika tidak ingin mengedit data"

        System.out.print("\t"+rutePengiriman[selectedService][0] + " ➺  ");
        newData = input.nextLine();
        if(!newData.trim().isEmpty()) {
            rutePengiriman[selectedService][0] = newData;
        }

        System.out.print("\t"+rutePengiriman[selectedService][1] + " ➺  ");
        newData = input.nextLine();
        if(!newData.trim().isEmpty()) {
            rutePengiriman[selectedService][1] = newData;
        }

        System.out.print("\t"+rutePengiriman[selectedService][2] + " ➺  ");
        newData = input.nextLine();
        if(!newData.trim().isEmpty()) {
            rutePengiriman[selectedService][2] = newData;
        }

        clearTerminal();
        viewExpeditionRoutes();
    }
}
