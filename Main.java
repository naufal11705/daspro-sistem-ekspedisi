import java.util.Scanner;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Arrays;
import java.util.Calendar;

public class Main {

    /**
     * @param args
     */

    static String[][] languageModule = {
        {"Welcome to the Expedition System", "Selamat Datang di Sistem Ekspedisi"}, //0
        {"║ ⤷ Input Username  : ", "║ ⤷ Masukkan Nama Pengguna   : "}, //1
        {"║ ⤷ Input Password  : ", "║ ⤷ Masukkan Kata Sandi      : "}, //2
        {"✅ Login Success. Welcome ","✅ Anda berhasil masuk. Selamat datang "}, //3
        {"⛔ OOPS! THERE IS A PROBLEM WITH YOUR LOGIN CREDENTIALS. PLEASE VERIFCATION AND TRY AGAIN.","⛔ OOPS! TERDAPAT MASALAH DENGAN KREDENSIAL LOGIN ANDA. SILAKAN VERIFIKASI DAN COBA LAGI."}, //4
        {"User Management", "Manajemen Pengguna         "}, //5
        {"Add User", "Tambahkan Pengguna"}, //6
        {" ⤷ Enter new Username: ", " ⤷ Masukkan nama pengguna baru: "},  //7
        {" ⤷ Enter new Password: ", " ⤷ Masukkan kata sandi baru: "}, //8
        {" ⤷ Enter new Role user: ", " ⤷ Masukkan jabatan penggun baru: "},   //9
        {"✅ New User Successfully Added.","✅ Pengguna baru berhasil ditambahkan."},   //10
        {"Remove User", "Hapus Pengguna"},  //11
        {"║ ⤷ Enter Username want to remove: ","║ ⤷ Masukan username yang akan dihapus: "}, //12
        {"🗑️  User successfully removed.","🗑️  Pengguna telah dihapus."},   //13
        {"⚠️  USER NOT FOUND. PLEASE TRY AGAIN.","⚠️  PENGGUNA TIDAK DITEMUKAN. SILAKAN COBA LAGI."},   //14
        {"User Data", "Data Pengguna"},    //15
        {"User Management", "Manajemen Pengguna"},  //16
        {"Back to the Main Menu", "Kembali ke Menu Utama"}, //17
        {"Delivery Transaction", "Transaksi Pengiriman       "}, //18
        {"Transactions", "Melakukan Transaksi"}, //19
        {"║ Enter the Sender's Name: ","║ Masukkan Nama Pengirim: "},   //20
        {"║ Enter contact number: ", "║ Masukkan nomor kontak: "},  //21
        {"║ Enter receiver's name: ","║ Masukkan Nama Penerima: "},   //22
        {"║ Enter Address: ", "║ Masukkan Alamat: "},   //23
        {"║ Enter Description: ", "║ Masukkan Deskripsi Barang: "},  //24
        {"║ Input Length: ", "║ Masukkan Panjang: "}, //25
        {"║ Input Width: ", "║ Masukkan Lebar: "}, //26
        {"║ Input Height: ", "║ Masukkan Tinggi: "},  //27
        {"⚠️ ROUTE IS NOT FOUND. PLEASE TRY AGAIN", "⚠️ RUTE TIDAK DITEMUKAN. SILAKAN COBA LAGI."},  //28
        {"day", "hari"},    //29
        {"Payment Method", "Metode Pembayaran"},   //30
        {" ⤷ Choose Payment methode: ", " ⤷ Pilih Metode Pembayaran: "},  //31
        {" ⤷ Choose Available Bank: ", " ⤷ Pilih Bank yang tersedia: "}, //32
        {"Payment successfully used ","Pembayaran berhasil menggunakan "},   //33
        {" ⤷ Please make payment of the amound Rp."," ⤷ Silahkan lakukan Pembayaran sejumlah Rp."},   //34
            {" before receiving goods. The Fee will be charged to the receiver!!!"," sebelum menerima barang. Biaya akan dibebankan kepada penerima!!!"},   //35
        {" ⤷ Shipping cost amount to: "," ⤷ Biaya Pengiriman sebesar: "}, //36
            {" ⤷ Pay: Rp.", " ⤷ Bayar: Rp."},     //37
            {" ⤷ Return: Rp", " ⤷ Kembalian: Rp"},    //38
        {"Sender", "Pegiriman"},    //39
        {"Receiver", "Penerima"},   //40
        {"Date", "Tanggal"},        //41
        {"Cost", "Biaya"},      //42
        {"Edit Transaction", "Edit Transaksi"}, //43
        {" ⤷ Input receipt number: ", " ⤷ Masukkan nomor resi: "},    //44
        {"Data is not found", "Data tidak ditemukan"},  //45
        {"Remove Transaction", "Hapus Transaksi"},  //46
        {"Data with this receipt number has been removed","Data dengan nomor resi yang sesuai sudah dihapus"},  //47
        {"User Data", "Data Pengguna"}, //48
        {"Route Management", "Manajemen Rute"}, //49 
        {"Add New Route", "Tambah Rute Baru"},   //50
        {"Rute has been available", "Rute sudah tersedia"}, //51
        {" ⤷ Enter the distance between ", " ⤷ Masukkan jarak antara "},  //52
        {"Remove Route", "Hapus Rute"},  //53
        {"Displays Location's Data", "Menampilkan Data Rute Pengiriman"},   //54
        {"Service Management", "Manajemen Layanan"}, //55
        {"Add Service Types", "Tambahkan Jenis Layanan"},   //56
        {" ⤷ Enter New Service Name: ", " ⤷ Masukkan Nama Layanan: "},    //57
        {" ⤷ Input new Cost: Rp.", " ⤷ Masukkan Tarif: Rp."},   //58
        {" ⤷ Minimum delivery time: "," ⤷ Masukkan Waktu Pengiriman Minimum: "},  //59
        {" ⤷ Maximum delivery time: "," ⤷ Masukkan Waktu Pengiriman Maximum: "},  //60
        {"Edit Service", "Edit Layanan"},    //61
        {"║ Service list available: ","║ Daftar Layanan yang Tersedia: "},  //62
        {"⤷ Enter service number want to change: " ,"⤷ Masukkan nomor layanan yang ingin diubah: "},    //63
        {"Remove Service", "Menghapus Layanan"},    //64
        {"Displays Services' Data", "Menampilkan Layanan Data"},    //65
        {"Service", "Cost"},    //66
        {"Change Language", "Ganti Bahasa"},    //67
        {"Basic Cost Management", "Manajemen Tarif Dasar"}, //68
        {"Service Cost Management per Kg","Tarif dasar per Kg"},   //69
        {"Service Cost Management per Km","Tarif dasar per Km"},   //70
        {"Report", "Laporan"},  //71
        {"Delivery of goods","Pengiriman Barang"}, //72
        {"Warehouse Inventory", "Inventori Gudang"},    //73
        {" ⤷ Enter warehouse location: ", " ⤷ Masukkan lokasi Gudang: "}, //74
        {"Send Package", "Kirim Paket"},    //75
        {" ⤷ Enter index: ", " ⤷ Masukkan index: "},  //76
        {"Deliver Package", "Antar Paket"}, //77
        {"Logout", "Keluar"}, //78
        {"You have successfully exited. See You! 👋","Anda telah berhasil keluar. Sampai jumpa lain waktu! 👋"}, //79
        {" ⤷ Enter Options: ", " ⤷ Masukkan Pilihan: "},  //80
        {"Click [  ⏎ Enter] to continue... ", "Tekan [  ⏎ Enter] untuk melanjutkan... "}, //81
        {"║ Input Weight: ", "║ Masukkan berat barang: "}, //82
        {"Transaction History", "Histori Transaksi"}, //83
        {"Date Range", "Rentang Tanggal"}, //84
        {"Day", "Hari"}, //85
        {"Month", "Bulan"}, //86
        {"Year", "Tahun"}, //87
        {"Tracking Number", "Nomor Resi"}, //88
        {"Tracking ID", "No Resi"}, //89
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
        {"⚠️ Inputs are not numbers. Please enter a valid number", "⚠️ Inputan bukan angka. Silakan masukkan nomor yang valid"}, //111
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
        {"Invalid number. Please enter a valid number: ","Nomor tidak valid. Silahkan masukkan nomor yang valid: "},//124
        {"⤷ Press [⏎ Enter] if you don't want to edit the data","⤷ Tekan [⏎ Enter] jika tidak ingin mengedit data"},//125
        {"⤷ Enter the route number you want to change: ","⤷ Masukkan nomor rute yang ingin diubah: "},//126
        {"⤷ Do you want to change the delivery status to completed? (Y/N): ","⤷ Apakah anda ingin mengubah status pengiriman menjadi selesai? (Y/N): "},//127
        {"║ Invalid date format. Please enter the date in dd-MM-yyyy format.","║ Format tanggal tidak valid. Harap masukkan tanggal dengan format dd-MM-yyyy."},//128
        {" ⤷ Enter End Date (dd-MM-yyyy): "," ⤷ Masukkan Tanggal Akhir (dd-MM-yyyy): "},//129
        {" ⤷ Enter Start Date (dd-MM-yyyy): "," ⤷ Masukkan Tanggal Awal (dd-MM-yyyy): "},//130
        {"The input must be a number.","Input harus berupa angka."},//131
        {"Invalid date.","Tanggal tidak valid."},//132
        {" ⤷ Enter Date (dd):"," ⤷ Masukkan Tanggal (dd): "},//133
        {"║ Enter a number between 1 and 12.","║ Masukkan angka antara 1 sampai 12."},//134
        {"║ The moon is invalid. Enter a number between 1 and 12.","║ Bulan tidak valid. Masukkan angka antara 1 sampai 12."},//135
        {" ⤷ Enter Month (MM):"," ⤷ Masukkan Bulan (MM): "},//136
        {"║ Input is not a number. Please enter the year between 1900 and 3000.","║ Input bukan angka. Silakan masukkan tahun antara 1900 dan 3000."},//137
        {"║ Invalid year. Please enter the year between 1900 and 3000.","║ Tahun tidak valid. Harap masukkan tahun antara 1900 dan 3000."},//138
        {" ⤷ Enter Year: "," ⤷ Masukkan Tahun: "},//139
        {"║ Data not found. Please try again.","║ Data tidak ditemukan. Silakan coba lagi."},//140
        {"There are no transactions in that date range or that correspond to the month and year.","Tidak ada transaksi pada rentang tanggal tersebut atau yang sesuai dengan bulan dan tahun ini."},//141
        {" ⤷ Enter Options: ", " ⤷ Masukkan Pilihan: "},  //142
        {"Edit User", "Edit Pengguna"}, //143
        {"⤷ Enter the user number you want to change: ","⤷ Masukkan nomor pengguna yang ingin diubah: "},//144
        {"⤷ Enter the user number you want to delete: ","⤷ Masukkan nomor pengguna yang ingin dihapus: "},//145
        {"The input entered is invalid. Please enter the receipt number back!","Input yang dimasukkan tidak valid. Silahkan masukkan nomor resi kembali!"},//146
        {"The data with the corresponding receipt number has been deleted","Data dengan nomor resi yang sesuai sudah dihapus"},//147
        {"The amount of money you give is less","Jumlah uang yang anda berikan kurang"},//148
        {"Admin","Admin"}, //149
        {"Courier","Kurir"}, //150
        {"Cashier","Kasir"}, //151
        {"Polinema Expedition Receipt","Kwitansi Ekspedisi Polinema"}, //152
        {"Sender Name", "Nama Pengirim"}, //153
        {"Package Description", "Deskripsi Paket"}, //154
        {"Weight", "Berat"}, //155
        {"Distance", "Jarak"}, //156
        {"Detail", "Rincian"}, //157
        {"Pay :", "Bayar :"}, //158
        {"Change :", "Kembalian :"}, //159
        {"POLINEMA EXPEDITION", "EKSPEDISI POLINEMA"}, //160
        {"💵 The recipient does not need to pay anything to the courier", "💵 Penerima tidak perlu membayar apapun ke kurir"}, //161
        {"Handling fee", "Ongkir"}, //162
        {" ⤷ Do you want to change the delivery status of the goods? (Y/N): ", " ⤷ Apakah anda ingin mengubah status pengiriman barang? (Y/N): "}, //163
        {"Expedition History", "Riwayat Ekspedisi"}, //164
        {"Monthly Delivery Report: ", "Laporan Pesanan Bulanan: "}, //165
        {"Total Delivery","Jumlah Pengiriman"}, //166
        {"Total Delivery Per kg","Total Pengiriman Per kg"}, //167
        {"Total Income","Total Pendapatan"}, //168
        {"Value", "Nilai"}, //169
        {"Unit", "Satuan"}, //170
        {"Package","Paket"},//171
        {" ⤷ Input Account Number: ", " ⤷ Masukkan Nomor Rekening: "}, //172
        {"Cash", "Tunai"}, //173
        {" ⤷ Do you want to see transaction details? (Y/N): ", " ⤷ Apakah anda ingin melihat detail transaksi? (Y/N): "}, //174
        {"Login", "Masuk"}, //175
        {"Exit", "Keluar"}, //176
        {"Contact Number", "Nomor Kontak"}, //177
        {"║ Input Origin", "║ Masukkan Asal"}, //178
        {"║ Input Destination", "║ Masukkan Tujuan"}, //179
        {"",""}, //180
        {"Inbound", "Barang Masuk"}, //181
        {"Outbound", "Barang Keluar"}, //182
        {" ⤷ Do you want to see package details? (Y/N): ", " ⤷ Apakah anda ingin melihat detail paket? (Y/N): "}, //183
        {"View Package Details", "Lihat Detail Paket"}, //184
        {"Select a Package to Send", "Pilih Paket Untuk Dikirim"}, //184
    };

    static String[][] arrayLayanan = {
        {"Economic","5000", "5", "10"},
        {"Regular", "10000", "2", "5"},
        {"Sameday", "20000", "1", "1"}
    };

    static String[][] rutePengiriman = {
        {"Malang", "Malang", "0"},
        {"Malang", "Bekasi", "818"},
        {"Malang", "Bandung", "753"},
        {"Malang", "Medan", "2738"},
        {"Malang", "Bogor", "875"},
        {"Semarang", "Bekasi", "418"},
        {"Tangerang", "Palembang", "521"},
        {"Batam", "Pekanbaru", "371"},
        {"Yogyakarta", "Malang", "357"},
        {"Nganjuk", "Malang", "153"},
        {"Pasuruan", "Malang", "53"},
    };

    // Akun default
    static String[][] userData = {
        {"Naufal", "2341720080","ADMIN"},
        {"Putra", "2341720248","KASIR"},
        {"Farhan", "2341720258","KURIR"},
    };

    static String[][] historyTransaksi = {
        //untuk cek history & melakukan pengiriman
        {"9876538710987", "18-12-2023", "Saka", "08899887766", "Malang", "Regular", "69000.0", "Farhan", "Reika", "Jl. Melati 20 No. 16", "1500 cm³", "Gadget Elektronik High-end", "Waiting for pickup", "Yogyakarta", "Cash", "Weight", "500.0", "100000", "4000.0", "357", "90500.0", "5000", "08855443322"},
        {"6904715283142", "18-12-2023", "Haikal", "08887654321", "Malang", "Regular", "98800.0", "Farhan", "Vincent", "Jl. Melati 3 No. 9", "3", "Kit Kesehatan Premium", "Waiting for pickup", "Yogyakarta", "Cash", "Weight", "500.0", "100000", "4000.0", "357", "90500.0", "5000", "08855443322"},
        {"9276354185046", "19-12-2023", "Gabriel", "08811223344", "Malang", "Regular", "33200.0", "Naufal", "Afifah", "Jl. Anggrek 12 No. 8", "7", "Smartwatch Fitness Tracker", "Waiting for pickup", "Yogyakarta", "Cash", "Weight", "500.0", "100000", "4000.0", "357", "90500.0", "5000", "08855443322"},
        {"1492578034685", "20-12-2023", "Afifah", "08876543210", "Malang", "Regular", "50900.0", "Putra", "Naufal", "Jl. Melati 9 No. 21", "5", "Pakaian Anak-anak Setelan Lengkap", "Waiting for pickup", "Yogyakarta", "Cash", "Weight", "500.0", "100000", "4000.0", "357", "90500.0", "5000", "08855443322"},
        {"8032468109752", "20-12-2023", "Nanda", "08866778899", "Malang", "Economic", "25700.0", "Farhan", "Abdi", "Jl. Kembang 5 No. 15", "3", "Makanan Ringan Assorted", "Waiting for pickup", "Yogyakarta", "Cash", "Weight", "500.0", "100000", "4000.0", "357", "90500.0", "5000", "08855443322"},
        {"5283176490254", "26-04-2023", "Esa", "08822334455", "Malang", "Economic", "65400.0", "Farhan", "Luthfi", "Jl. Seroja 3 No. 7", "2", "Buku Ensiklopedia Anak-anak", "Arrived at warehouse", "Bandung", "Cash", "Weight", "500.0", "100000", "4000.0", "357", "90500.0", "5000", "08855443322"},
        {"3091754682351", "21-05-2022", "Abdi", "08811223344", "Bogor", "Economic", "34800.0", "Naufal", "Julian", "Jl. Mawar 17 No. 5", "9", "Mainan Puzzle Edukatif", "Waiting for pickup", "Bekasi", "Cash", "Weight", "500.0", "100000", "4000.0", "357", "90500.0", "5000", "08855443322"},
        {"6750912348526", "17-06-2022", "Naufal", "08822334455", "Yogyakarta", "Regular", "66500.0", "Putra", "Gabriel", "Jl. Anggrek 7 No. 12", "8", "Kit Kesehatan Keluarga", "Waiting for pickup", "Malang", "Cash", "Weight", "500.0", "100000", "4000.0", "357", "90500.0", "5000", "08855443322"},
        {"8013564729835", "30-06-2022", "Farrel", "08855443322", "Jakarta", "Regular", "76800.0", "Farhan", "Chiko", "Jl. Melati 15 No. 10", "4", "Alat Tulis Sekolah Premium", "Waiting for pickup", "Bekasi", "Cash", "Weight", "500.0", "100000", "4000.0", "357", "90500.0", "5000", "08855443322"},
        {"2674853902164", "14-07-2022", "Atabik", "08855443322", "Bandung", "Economic", "45300.0", "Naufal", "Vincent", "Jl. Kembang 2 No. 19", "1", "Smartphone Android 128GB", "Waiting for pickup", "Bandung", "Cash", "Weight", "500.0", "100000", "4000.0", "357", "90500.0", "5000", "08855443322"},
        {"4501628397517", "05-08-2023", "Dio", "08876543210", "Surabaya", "Sameday", "29100.0", "Putra", "Saputra", "Jl. Seroja 11 No. 14", "6", "Makanan Kesehatan Organik", "Waiting for pickup", "Pekanbaru", "Cash", "Weight", "500.0", "100000", "4000.0", "357", "90500.0", "5000", "08855443322"},
        {"7246109385273", "09-09-2023", "Pasha", "08899887766", "Serang", "Regular", "78000.0", "Farhan", "Naufal", "Jl. Anggrek 8 No. 5", "10", "Pakaian Dewasa Setelan Formal", "Waiting for pickup", "Malang", "Cash", "Weight", "500.0", "100000", "4000.0", "357", "90500.0", "5000", "08855443322"},
        {"3751928643058", "18-10-2023", "Farhan", "08866778899", "Denpasar", "Regular", "55700.0", "Naufal", "Petrus", "Jl. Mawar 5 No. 11", "2", "Mainan Robot Remote Control", "Waiting for pickup", "Malang", "Cash", "Weight", "500.0", "100000", "4000.0", "357", "90500.0", "5000", "08855443322"},
        {"5038921467584", "02-12-2023", "Chiko", "08811223344", "Malang", "Economic", "87600.0", "Putra", "Saka", "Jl. Kembang 10 No. 17", "7", "Gadget Elektronik Portable", "Waiting for pickup", "Bogor", "Cash", "Weight", "500.0", "100000", "4000.0", "357", "90500.0", "5000", "08855443322"},
        {"4892307162453", "11-11-2023", "Cindy", "08899887766", "Bekasi", "Sameday", "65400.0", "Naufal", "Petrus", "Jl. Seroja 8 No. 6", "5", "Makanan Ringan Assorted Premium", "Waiting for pickup", "Bekasi", "Cash", "Weight", "500.0", "100000", "4000.0", "357", "90500.0", "5000", "08855443322"},
        {"1234567890123", "01-01-2023", "Ivan", "08812345678", "Surabaya", "Economic", "45000.0", "Putra", "Abdi", "Jl. Anggrek 14 No. 20", "9", "Buku Ensiklopedia Anak-anak", "Waiting for pickup", "Bogor", "Cash", "Weight", "500.0", "100000", "4000.0", "357", "90500.0", "5000", "08855443322"},
        {"9876543210987", "07-04-2023", "Luthfi", "08887654321", "Jakarta", "Regular", "60000.0", "Farhan", "Farrel", "Jl. Kembang 1 No. 18", "1", "Gadget Elektronik High-end", "Waiting for pickup", "Malang", "Cash", "Weight", "500.0", "100000", "4000.0", "357", "90500.0", "5000", "08855443322"},
        {"3456789012345", "14-06-2023", "Adri", "08811223344", "Bandung", "Economic", "35000.0", "Naufal", "Petrus", "Jl. Melati 6 No. 13", "6", "Makanan Ringan Assorted", "Waiting for pickup", "Bogor", "Cash", "Weight", "500.0", "100000", "4000.0", "357", "90500.0", "5000", "08855443322"},
        {"8765432109876", "21-08-2023", "Alif", "08899887766", "Makassar", "Sameday", "42000.0", "Putra", "Saputra", "Jl. Anggrek 20 No. 3", "4", "Buku Ensiklopedia Anak-anak", "Waiting for pickup", "Bandung", "Cash", "Weight", "500.0", "100000", "4000.0", "357", "90500.0", "5000", "08855443322"},
        {"6543210987654", "03-10-2023", "Dimas", "08876543210", "Denpasar", "Regular", "58000.0", "Farhan", "Farrel", "Jl. Mawar 13 No. 16", "10", "Mainan Robot Remote Control", "Waiting for pickup", "Bekasi", "Cash", "Weight", "500.0", "100000", "4000.0", "357", "90500.0", "5000", "08855443322"},
        {"8765432109876", "11-12-2023", "Julian", "08822334455", "Malang", "Sameday", "67000.0", "Naufal", "Naufal", "Jl. Seroja 2 No. 4", "8", "Kit Kesehatan Premium", "Waiting for pickup", "Malang", "Cash", "Weight", "500.0", "100000", "4000.0", "357", "90500.0", "5000", "08855443322"},
        {"5432109876543", "25-02-2023", "Petrus", "08866778899", "Bogor", "Regular", "73000.0", "Putra", "Saka", "Jl. Kembang 8 No. 1", "3", "Gadget Elektronik Portable", "Waiting for pickup", "Bogor", "Cash", "Weight", "500.0", "100000", "4000.0", "357", "90500.0", "5000", "08855443322"},
        {"3210987654321", "10-05-2023", "Saputra", "08855443322", "Surabaya", "Economic", "32000.0", "Farhan", "Rio", "Jl. Mawar 14 No. 7", "5", "Makanan Ringan Assorted", "Waiting for pickup", "Bekasi", "Cash", "Weight", "500.0", "100000", "4000.0", "357", "90500.0", "5000", "08855443322"},
        {"9876543210987", "15-07-2023", "Reika", "08811223344", "Semarang", "Regular", "52000.0", "Naufal", "Chiko", "Jl. Anggrek 11 No. 15", "2", "Alat Tulis Sekolah Set Lengkap", "Waiting for pickup", "Medan", "Cash", "Weight", "500.0", "100000", "4000.0", "357", "90500.0", "5000", "08855443322"},
        {"3456789012345", "20-09-2023", "Rio", "08887654321", "Yogyakarta", "Sameday", "47000.0", "Putra", "Naufal", "Jl. Seroja 10 No. 2", "9", "Gadget Elektronik High-end", "Waiting for pickup", "Bogor", "Cash", "Weight", "500.0", "100000", "4000.0", "357", "90500.0", "5000", "08855443322"},
        {"3210987654321", "15-01-2023", "Taufik", "08876543210", "Bekasi", "Economic", "40000.0", "Naufal", "Vincent", "Jl. Kembang 7 No. 19", "10", "Buku Ensiklopedia Anak-anak", "Waiting for pickup", "Surabaya", "Cash", "Weight", "500.0", "100000", "4000.0", "357", "90500.0", "5000", "08855443322"},
        {"9876543210987", "20-03-2023", "Mera", "08822334455", "Gorontalo", "Sameday", "61000.0", "Putra", "Saputra", "Jl. Seroja 4 No. 11", "4", "Kit Kesehatan Keluarga", "Waiting for pickup", "Bogor", "Cash", "Weight", "500.0", "100000", "4000.0", "357", "90500.0", "5000", "08855443322"},
        {"3456789012345", "05-05-2023", "Vincent", "08866778899", "Malang", "Regular", "54000.0", "Farhan", "Petrus", "Jl. Anggrek 3 No. 14", "7", "Makanan Ringan Assorted", "Arrived at warehouse", "Medan", "Cash", "Weight", "500.0", "100000", "4000.0", "357", "90500.0", "5000", "08855443322"},
        {"3210987654321", "10-07-2023", "Vira", "08855443322", "Bengkulu", "Economic", "37000.0", "Naufal", "Haikal", "Jl. Kembang 12 No. 9", "1", "Gadget Elektronik Portable", "Waiting for pickup", "Bogor", "Cash", "Weight", "500.0", "100000", "4000.0", "357", "90500.0", "5000", "08855443322"},
        {"9876543210987", "28-10-2023", "Innam", "08822334455", "Surabaya", "Sameday", "55000.0", "Putra", "Farrel", "Jl. Melati 9 No. 5", "6", "Buku Ensiklopedia Anak-anak", "Waiting for pickup", "Bekasi", "Cash", "Weight", "500.0", "100000", "4000.0", "357", "90500.0", "5000", "08855443322"},

        //data real, sesuai perhitungan transaksi
        {"18122023192438", "18-12-2023", "Rangga Dwi Saputra", "08899887766", "Malang", "Economic", "96000.0", "Naufal", "Farhan Mawaluddin", "Jl. Seroja 3 No. 7", "1.0 kg", "Smartwatch Fitness Tracker", "Waiting for pickup", "Yogyakarta", "Cash", "Weight", "500.0", "100000", "4000.0", "357", "90500.0", "5000", "08855443322"},
        {"18122023190643", "18-12-2023", "Haikal Muhammad Rafli", "08899887766", "Malang", "Regular", "102000.0", "Farhan", "Ahmad Naufal Waskito Aji", "Jl. Melati 20 No. 16", "3.0 kg", "Gadget Elektronik High-end", "Waiting for pickup", "Yogyakarta", "BNI - 72382322", "Weight", "1500.0", "102000", "0.0", "357", "90500.0", "10000", "08855443322"},
    };

    static String[][] shipmentDetails = {
        {"", "", ""},
    };

    static Scanner input = new Scanner(System.in);    
    // Format tanggal
    static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    static Date date = new Date();
    static Date startDate;
    static Date endDate;
    static String tanggalHariIni = dateFormat.format(date);
    static String inputanTanggalAwal = "00-00-000", inputanTanggalAkhir = "00-00-0000";

    static String RESET = "\u001B[0m";
    static String CLEAR = "\033[H\033[2J";
    static String GREEN = "\u001B[32m";
    static String RED = "\u001B[31m";
    static String YELLOW = "\u001B[33m";
    static String BOLD = "\u001B[1m";

    static int selectedLanguage = 0;

    static boolean session = true;
    static boolean isAdmin = false;
    static boolean isKurir = false;

    static String loggedInUsername = "";

    static double tarifPerKg = 2500;
    static double tarifPerKm = 500;

    static int inputselectedLanguage = 0;

    static boolean validInput = false;
    static int menuUtama, subMenu, editMenu;
    static boolean login = false;

    static String bankName;
    static String paymentMethod;

    static String reportFormat;
    static String labelFormat;
    static String receiptFormat;
    static String packageDetailsFormat;
    public static void main(String[] args) {

        while (session) {

            RefreshFormatter();
            clearTerminal();
            displayHeader();
            displayIndonesianMap();
            viewLoginMenu();

            int pilihan;
            System.out.print(languageModule[80][selectedLanguage]);
            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {

                case 1:
                    clearTerminal();
                    Login();
                    break;

                case 2:
                    clearTerminal();
                    ManageLanguage();
                    continue;

                case 3:
                    Exit();
                    continue;

                default:
                    continue;
            }

            notificationBox(97, languageModule[3][selectedLanguage] + loggedInUsername);
            CountdownAndClear(2);

            while(login) {

                while (true) {
                    try {
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
                    } catch (InputMismatchException e) {
                        input.nextLine();
                        clearTerminal();
                        continue;
                    }
                    input.nextLine();
                    clearTerminal();
                    break;
                }                

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
                                    displayHeader();
                                    displayIndonesianMap();
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
                                ManageLanguage();
                                clearTerminal();
                                break;

                            case 3:
                                Logout();
                                break;
                        }
                        
                    } else {
                        switch (menuUtama) { 
                            case 1:
                                ManageTransaction();
                                break;

                            case 2:
                                ManageLanguage();
                                clearTerminal();
                                break;

                            case 3:
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
            columnWidths[j] = maxWidth + 1;
        }
    
        return columnWidths;
    }

    private static String centerString(int width, String s) {
        int padSize = (width - s.length()) / 2;
        return String.format("%" + padSize + "s%s%" + (padSize + (width - s.length()) % 2) + "s", "", s, "");
    }

    private static String padStringLeft(int width, String s) {
        return String.format("%-" + width + "s", s);
    }

    private static String padStringRight(int width, String s) {
        return String.format("%" + width + "s", s);
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
        String formattedHeader = String.format("║ No. ║ %-" + columnWidths[0] + "s ║ %-" + columnWidths[1] + "s ║ %-" + columnWidths[2] + "s",
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
            if(selectedLanguage==1){
                System.out.printf("║ "+(i+1)+".  ║ %-" + columnWidths[0] + "s ║ %-" + columnWidths[1] + "s ║ %-" + columnWidths[2] + "s\n", userData[i][0], userData[i][1], userData[i][2]);
            } else {
                String tempRole = "";
                if(userData[i][2].equals("ADMIN")) {
                    tempRole = "ADMIN";
                } else if(userData[i][2].equals("KASIR")) {
                    tempRole = "CASHIER";
                } else if(userData[i][2].equals("KURIR")) {
                    tempRole = "COURIER";
                }

                System.out.printf("║ "+(i+1)+".  ║ %-" + columnWidths[0] + "s ║ %-" + columnWidths[1] + "s ║ %-" + columnWidths[2] + "s\n", userData[i][0], userData[i][1], tempRole);
            }

        }

        System.out.println("╚════════════════════════════════════════════════════════════╝");
    }

    private static void viewExpeditionRoutes() {
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

    private static void viewExpeditionHistoryByRange(Date startDate, Date endDate){
        int[] columnWidths = calculateColumnWidths(historyTransaksi);
        String formattedHeader = String.format("║ %3s ║ %-" + columnWidths[0] + "s ║ %-" + columnWidths[1] + "s ║ %-" + columnWidths[2] + "s ║ %-" + columnWidths[8] + "s ║ %-" + columnWidths[6] + "s ║ %-" + columnWidths[7] + "s",
            "No", 
            languageModule[89][selectedLanguage], 
            languageModule[90][selectedLanguage],
            languageModule[91][selectedLanguage],
            languageModule[97][selectedLanguage],
            languageModule[95][selectedLanguage],
            languageModule[96][selectedLanguage]
        );

        try{
            System.out.println("╔═════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗"); 
            System.out.println("║"+centerString(125, languageModule[83][selectedLanguage])+"║");
            System.out.println("╠═════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣"); 
            System.out.println(formattedHeader);
            System.out.println("╠═════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣"); 

            for (int i = 0; i < historyTransaksi.length; i++) {
                if (historyTransaksi[i][0] != null){
                    Date transaksiDate = dateFormat.parse(historyTransaksi[i][1]);
                    if (transaksiDate.compareTo(startDate) >= 0 && transaksiDate.compareTo(endDate) <= 0) {
                        System.out.println(String.format("║ %3s ║ %-" + columnWidths[0] + "s ║ %-" + columnWidths[1] + "s ║ %-" + columnWidths[2] + "s ║ %-" + columnWidths[8] + "s ║ %-" + columnWidths[6] + "s ║ %-" + columnWidths[7] + "s",
                            i,
                            historyTransaksi[i][0],
                            historyTransaksi[i][1],
                            historyTransaksi[i][2], 
                            historyTransaksi[i][8],
                            historyTransaksi[i][6],
                            historyTransaksi[i][7] 
                        ));
                    }
                }
            }

            System.out.println("╚═════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝");  
        }catch (ParseException e){
            e.printStackTrace();
        }
    }

    private static void viewExpeditionHistoryByDay(Date startDate, Date endDate) {
        int[] columnWidths = calculateColumnWidths(historyTransaksi);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        boolean dataDitemukan = false;
        String formattedHeader = String.format("║ %3s ║ %-" + columnWidths[0] + "s ║ %-" + columnWidths[1] + "s ║ %-" + columnWidths[2] + "s ║ %-" + columnWidths[8] + "s ║ %-" + columnWidths[6] + "s ║ %-" + columnWidths[7] + "s",
            "No", 
            languageModule[89][selectedLanguage], 
            languageModule[90][selectedLanguage],
            languageModule[91][selectedLanguage],
            languageModule[97][selectedLanguage],
            languageModule[95][selectedLanguage],
            languageModule[96][selectedLanguage]
        );

        System.out.println("╔═════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗"); 
        System.out.println("║"+centerString(125, languageModule[83][selectedLanguage])+"║");
        System.out.println("╠═════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣"); 
        System.out.println(formattedHeader);
        System.out.println("╠═════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣"); 

        for (int i = 0; i < historyTransaksi.length; i++) {
            try {
                Date transaksiDate = dateFormat.parse(historyTransaksi[i][1]);
                Calendar cal = Calendar.getInstance();
                int bulanSekarang = cal.get(Calendar.MONTH) + 1;

                if (transaksiDate.compareTo(startDate) >= 0 && transaksiDate.compareTo(endDate) <= 0
                        && dateFormat.format(transaksiDate).startsWith(String.format("%02d-%02d", startDate.getDate(), bulanSekarang))) {
                    System.out.println(String.format("║ %3s ║ %-" + columnWidths[0] + "s ║ %-" + columnWidths[1] + "s ║ %-" + columnWidths[2] + "s ║ %-" + columnWidths[8] + "s ║ %-" + columnWidths[6] + "s ║ %-" + columnWidths[7] + "s",
                        i,
                        historyTransaksi[i][0],
                        historyTransaksi[i][1],
                        historyTransaksi[i][2], 
                        historyTransaksi[i][8],
                        historyTransaksi[i][6], 
                        historyTransaksi[i][7] 
                    ));
                    dataDitemukan = true;
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        System.out.println("╚═════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝");  

        if (!dataDitemukan) {
            System.out.println(languageModule[141][selectedLanguage]);//"Tidak ada transaksi pada rentang tanggal tersebut atau yang sesuai dengan bulan dan tahun ini."
        }
    }

    private static void viewExpeditionHistoryByMonth(Date startDate, Date endDate) {
        int[] columnWidths = calculateColumnWidths(historyTransaksi);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        boolean dataDitemukan = false;
        String formattedHeader = String.format("║ %3s ║ %-" + columnWidths[0] + "s ║ %-" + columnWidths[1] + "s ║ %-" + columnWidths[2] + "s ║ %-" + columnWidths[8] + "s ║ %-" + columnWidths[6] + "s ║ %-" + columnWidths[7] + "s",
            "No", 
            languageModule[89][selectedLanguage], 
            languageModule[90][selectedLanguage],
            languageModule[91][selectedLanguage],
            languageModule[97][selectedLanguage],
            languageModule[95][selectedLanguage],
            languageModule[96][selectedLanguage]
        );

        System.out.println("╔═════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗"); 
        System.out.println("║"+centerString(125, languageModule[83][selectedLanguage])+"║");
        System.out.println("╠═════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣"); 
        System.out.println(formattedHeader);
        System.out.println("╠═════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣"); 

        for (int i = 0; i < historyTransaksi.length; i++) {
            try {
                Date transaksiDate = dateFormat.parse(historyTransaksi[i][1]);
                Calendar cal = Calendar.getInstance();
                cal.setTime(transaksiDate);
                int transaksiBulan = cal.get(Calendar.MONTH) + 1;
                int transaksiTahun = cal.get(Calendar.YEAR);

                if (transaksiDate.compareTo(startDate) >= 0 && transaksiDate.compareTo(endDate) <= 0
                        && transaksiBulan == startDate.getMonth() + 1 && transaksiTahun == startDate.getYear() + 1900) {
                    System.out.println(String.format("║ %3s ║ %-" + columnWidths[0] + "s ║ %-" + columnWidths[1] + "s ║ %-" + columnWidths[2] + "s ║ %-" + columnWidths[8] + "s ║ %-" + columnWidths[6] + "s ║ %-" + columnWidths[7] + "s",
                        i,
                        historyTransaksi[i][0],
                        historyTransaksi[i][1], 
                        historyTransaksi[i][2], 
                        historyTransaksi[i][8],
                        historyTransaksi[i][6], 
                        historyTransaksi[i][7] 
                    ));
                    dataDitemukan = true;
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        System.out.println("╚═════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝");  
        if (!dataDitemukan) {
            System.out.println("Tidak ada transaksi pada rentang tanggal tersebut atau yang sesuai dengan bulan dan tahun ini.");
        }

    }

    private static void viewExpeditionHistoryByYear(int tahunInput) {
        int[] columnWidths = calculateColumnWidths(historyTransaksi);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        boolean dataDitemukan = false;
        String formattedHeader = String.format("║ %3s ║ %-" + columnWidths[0] + "s ║ %-" + columnWidths[1] + "s ║ %-" + columnWidths[2] + "s ║ %-" + columnWidths[8] + "s ║ %-" + columnWidths[6] + "s ║ %-" + columnWidths[7] + "s",
            "No", 
            languageModule[89][selectedLanguage], 
            languageModule[90][selectedLanguage],
            languageModule[91][selectedLanguage],
            languageModule[97][selectedLanguage],
            languageModule[95][selectedLanguage],
            languageModule[96][selectedLanguage]
        );

        System.out.println("╔═════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗"); 
        System.out.println("║"+centerString(125, languageModule[83][selectedLanguage])+"║");
        System.out.println("╠═════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣"); 
        System.out.println(formattedHeader);
        System.out.println("╠═════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣"); 

        for (int i = 0; i < historyTransaksi.length; i++) {
            try {
                Date transaksiDate = dateFormat.parse(historyTransaksi[i][1]);
                Calendar cal = Calendar.getInstance();
                cal.setTime(transaksiDate);
                int tahunTransaksi = cal.get(Calendar.YEAR);

                if (tahunTransaksi == tahunInput) {
                    System.out.println(String.format("║ %3s ║ %-" + columnWidths[0] + "s ║ %-" + columnWidths[1] + "s ║ %-" + columnWidths[2] + "s ║ %-" + columnWidths[8] + "s ║ %-" + columnWidths[6] + "s ║ %-" + columnWidths[7] + "s",
                        i,
                        historyTransaksi[i][0], 
                        historyTransaksi[i][1], 
                        historyTransaksi[i][2], 
                        historyTransaksi[i][8],
                        historyTransaksi[i][6],
                        historyTransaksi[i][7]
                    ));
                    dataDitemukan = true;
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        System.out.println("╚═════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝"); 
        if (!dataDitemukan) {
            System.out.println("Tidak ada transaksi pada tahun tersebut.");
        }
    }

    private static double getRevenue(Date startDate, Date endDate, String location) {
        int revenue = 0;
        try {
            for (int i = 0; i < historyTransaksi.length; i++) {
                Date transaksiDate = dateFormat.parse(historyTransaksi[i][1]);
                if ((transaksiDate.compareTo(startDate) >= 0 && transaksiDate.compareTo(endDate) <= 0)
                    && historyTransaksi[i][13].equalsIgnoreCase(location)) {
                    
                        revenue += Double.parseDouble(historyTransaksi[i][6]);
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return revenue;  
    }

    private static int getExpeditionCount(Date startDate, Date endDate, String location) {
        int count = 0;
        
        try {
            for (int i = 0; i < historyTransaksi.length; i++) {
                Date transaksiDate = dateFormat.parse(historyTransaksi[i][1]);
                if ((transaksiDate.compareTo(startDate) >= 0 && transaksiDate.compareTo(endDate) <= 0)
                    && historyTransaksi[i][13].equalsIgnoreCase(location)) {
                    count++;
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return count;  
    }

    private static int getInbound(Date startDate, Date endDate, String location) {
        int count = 0;

        try {
            for (int i = 0; i < historyTransaksi.length; i++) {
                Date transaksiDate = dateFormat.parse(historyTransaksi[i][1]);
                if ((historyTransaksi[i][12].equalsIgnoreCase("Arrived at warehouse") 
                    || historyTransaksi[i][12].equalsIgnoreCase("Has been received by the recipient"))
                    && transaksiDate.compareTo(startDate) >= 0 && transaksiDate.compareTo(endDate) <= 0
                    && historyTransaksi[i][4].equalsIgnoreCase(location)) {
                    count++;
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return count;  
    }

    private static int getOutbound(Date startDate, Date endDate, String location) {
        int count = 0;

        try {
            for (int i = 0; i < historyTransaksi.length; i++) {
                Date transaksiDate = dateFormat.parse(historyTransaksi[i][1]);
                if ((historyTransaksi[i][12].equalsIgnoreCase("Arrived at warehouse") 
                    || historyTransaksi[i][12].equalsIgnoreCase("Has been received by the recipient")
                    || historyTransaksi[i][12].equalsIgnoreCase("Sending to destination"))
                    && transaksiDate.compareTo(startDate) >= 0 && transaksiDate.compareTo(endDate) <= 0
                    && historyTransaksi[i][13].equalsIgnoreCase(location)) {
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
        System.out.println("║             │     [1]. "+padStringLeft(28, languageModule[5][selectedLanguage])+"[6]. "+padStringLeft(27, languageModule[68][selectedLanguage])+"│             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │     [2]. "+padStringLeft(28, languageModule[18][selectedLanguage])+"[7]. "+padStringLeft(27, languageModule[71][selectedLanguage])+"│             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │     [3]. "+padStringLeft(28, languageModule[49][selectedLanguage])+"[8]. "+padStringLeft(27, languageModule[72][selectedLanguage])+"│             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │     [4]. "+padStringLeft(28, languageModule[55][selectedLanguage])+"[9]. "+padStringLeft(27, languageModule[78][selectedLanguage])+"│             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │     [5]. "+padStringLeft(60, languageModule[67][selectedLanguage])+"│             ║");
        System.out.println("║             │                                                                      │             ║"); 
        System.out.println("║             ╰──────────────────────────────────────────────────────────────────────╯             ║");
        System.out.println("║                                                                                                  ║"); 
        System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════════════╝");
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
        System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════════════╝");
    }

    private static void viewCourierMenu() {
        System.out.println("║                                                                                                  ║");
        System.out.println("║             ╭──────────────────────────────────────────────────────────────────────╮             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │                     [1]. "+padStringLeft(44, languageModule[72][selectedLanguage])+"│             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │                     [2]. "+padStringLeft(44, languageModule[67][selectedLanguage])+"│             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │                     [3]. "+padStringLeft(44, languageModule[78][selectedLanguage])+"│             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │                                                                      │             ║"); 
        System.out.println("║             ╰──────────────────────────────────────────────────────────────────────╯             ║");
        System.out.println("║                                                                                                  ║"); 
        System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════════════╝");
    }

    private static void viewCashierMenu() {
        System.out.println("║                                                                                                  ║");
        System.out.println("║             ╭──────────────────────────────────────────────────────────────────────╮             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │                     [1]. "+padStringLeft(44, languageModule[19][selectedLanguage])+"│             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │                     [2]. "+padStringLeft(44, languageModule[67][selectedLanguage])+"│             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │                     [3]. "+padStringLeft(44, languageModule[78][selectedLanguage])+"│             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │                                                                      │             ║"); 
        System.out.println("║             ╰──────────────────────────────────────────────────────────────────────╯             ║");
        System.out.println("║                                                                                                  ║"); 
        System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════════════╝");
    }

    private static void viewUserManagementMenu() {
        System.out.println("║                                                                                                  ║");
        System.out.println("║             ╭──────────────────────────────────────────────────────────────────────╮             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │                     [1]. " + padStringLeft(44, languageModule[6][selectedLanguage]) + "│             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │                     [2]. " + padStringLeft(44, languageModule[143][selectedLanguage]) + "│             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │                     [3]. " + padStringLeft(44, languageModule[11][selectedLanguage]) + "│             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │                     [4]. " + padStringLeft(44, languageModule[15][selectedLanguage]) + "│             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │                     [5]. " + padStringLeft(44, languageModule[17][selectedLanguage]) + "│             ║");
        System.out.println("║             │                                                                      │             ║"); 
        System.out.println("║             ╰──────────────────────────────────────────────────────────────────────╯             ║");
        System.out.println("║                                                                                                  ║"); 
        System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════════════╝");
    }

    private static void viewExpeditionTransactionMenu() {
        System.out.println("║                                                                                                  ║");
        System.out.println("║             ╭──────────────────────────────────────────────────────────────────────╮             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │                     [1]. " + padStringLeft(44, languageModule[19][selectedLanguage]) + "│             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │                     [2]. " + padStringLeft(44, languageModule[46][selectedLanguage]) + "│             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │                     [3]. " + padStringLeft(44, languageModule[83][selectedLanguage]) + "│             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │                     [4]. " + padStringLeft(44, languageModule[17][selectedLanguage]) + "│             ║");
        System.out.println("║             │                                                                      │             ║"); 
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             ╰──────────────────────────────────────────────────────────────────────╯             ║");
        System.out.println("║                                                                                                  ║"); 
        System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════════════╝");
    }

    private static void viewRouteMenu() {
        System.out.println("║                                                                                                  ║");
        System.out.println("║             ╭──────────────────────────────────────────────────────────────────────╮             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │                     [1]. " + padStringLeft(44, languageModule[50][selectedLanguage]) + "│             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │                     [2]. " + padStringLeft(44, languageModule[119][selectedLanguage]) + "│             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │                     [3]. " + padStringLeft(44, languageModule[53][selectedLanguage]) + "│             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │                     [4]. " + padStringLeft(44, languageModule[54][selectedLanguage]) + "│             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │                     [5]. " + padStringLeft(44, languageModule[17][selectedLanguage]) + "│             ║");
        System.out.println("║             │                                                                      │             ║"); 
        System.out.println("║             ╰──────────────────────────────────────────────────────────────────────╯             ║");
        System.out.println("║                                                                                                  ║"); 
        System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════════════╝");
    }

    private static void viewCostManagementMenu() {
        System.out.println("║                                                                                                  ║");
        System.out.println("║             ╭──────────────────────────────────────────────────────────────────────╮             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │          [1]. " + padStringLeft(55, languageModule[69][selectedLanguage]) + "│             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │          [2]. " + padStringLeft(55, languageModule[70][selectedLanguage]) + "│             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │          [3]. " + padStringLeft(55, languageModule[17][selectedLanguage]) + "│             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │                                                                      │             ║"); 
        System.out.println("║             ╰──────────────────────────────────────────────────────────────────────╯             ║");
        System.out.println("║                                                                                                  ║"); 
        System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════════════╝");
    }

    private static void viewLoginMenu() {
        System.out.println("║                                                                                                  ║");
        System.out.println("║             ╭──────────────────────────────────────────────────────────────────────╮             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │                       [1]. " + padStringLeft(42, languageModule[175][selectedLanguage]) + "│             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │                       [2]. " + padStringLeft(42, languageModule[67][selectedLanguage]) + "│             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │                       [3]. " + padStringLeft(42, languageModule[176][selectedLanguage]) + "│             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │                                                                      │             ║"); 
        System.out.println("║             ╰──────────────────────────────────────────────────────────────────────╯             ║");
        System.out.println("║                                                                                                  ║"); 
        System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════════════╝");
    }

    private static void viewServiceMenu() {
        System.out.println("║                                                                                                  ║");
        System.out.println("║             ╭──────────────────────────────────────────────────────────────────────╮             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │                     [1]. " + padStringLeft(44, languageModule[56][selectedLanguage]) + "│             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │                     [2]. " + padStringLeft(44, languageModule[61][selectedLanguage]) + "│             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │                     [3]. " + padStringLeft(44, languageModule[64][selectedLanguage]) + "│             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │                     [4]. " + padStringLeft(44, languageModule[65][selectedLanguage]) + "│             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │                     [5]. " + padStringLeft(44, languageModule[17][selectedLanguage]) + "│             ║");
        System.out.println("║             │                                                                      │             ║"); 
        System.out.println("║             ╰──────────────────────────────────────────────────────────────────────╯             ║");
        System.out.println("║                                                                                                  ║"); 
        System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════════════╝");
    }

    private static void notificationBox(int textWidth, String s) {
        System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
        System.out.println("║                                                                                                  ║");
        System.out.println("║"+centerString(textWidth, s)+"║");
        System.out.println("║                                                                                                  ║");
        System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════════════╝");
    }

    private static void AddUser() {
        String jabatanBaru;

        clearTerminal();
        viewUserAccounts();

        System.out.print(languageModule[7][selectedLanguage]);
        String usernameBaru = input.nextLine();
        System.out.print(languageModule[8][selectedLanguage]);
        String katasandiBaru = input.nextLine();

        while (true) {
            System.out.println("╭──────────────────┬───╮");
            System.out.println("│"+centerString(18, languageModule[107][selectedLanguage])+"│ ▼ │");
            System.out.println("╰──────────────────┴───╯");
            System.out.println("╭───┬──────────────────╮");
            System.out.println("│ 1.│"+centerString(18, ""+languageModule[149][selectedLanguage])+"│");
            System.out.println("│ 2.│"+centerString(18, languageModule[150][selectedLanguage])+"│");
            System.out.println("│ 3.│"+centerString(18, languageModule[151][selectedLanguage])+"│");
            System.out.println("╰───┴──────────────────╯");

            System.out.print(languageModule[142][selectedLanguage]);
            int pilihJabatan = input.nextInt();
            input.nextLine();

            switch (pilihJabatan) {
                case 1:
                    jabatanBaru = "ADMIN";
                    break;
                case 2:
                    jabatanBaru = "KURIR";
                    break;
                case 3:
                    jabatanBaru = "KASIR";
                    break;
                default:
                    System.out.print("\033[9A\033[0J");
                    continue;
            }
            break;
        }
                                    
        userData = Arrays.copyOf(userData,userData.length + 1);
        userData[userData.length-1] = new String[] {
            usernameBaru,
            katasandiBaru,
            jabatanBaru};

        clearTerminal();
        viewUserAccounts();
    }

    private static void DeleteUser() {
        clearTerminal();
        viewUserAccounts();

        int deleteIndex = 0;
        validInput = false;

        while (!validInput) {
            System.out.print(languageModule[145][selectedLanguage]);//"⤷ Masukkan nomor pengguna yang ingin dihapus: "
            try {
                deleteIndex = Integer.parseInt(input.nextLine());
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println(languageModule[111][selectedLanguage]);   //"Input yang dimasukkan bukan angka. Silakan masukkan nomor."
            }
        }

        if (deleteIndex >= 1 && deleteIndex <= userData.length) {
            String deletedLocation = userData[deleteIndex - 1][0]+" "+userData[deleteIndex - 1][1];
            System.out.println("║ " + deletedLocation + languageModule[112][selectedLanguage]);//telah dihapus

            System.arraycopy(userData, deleteIndex, userData, deleteIndex - 1, userData.length - deleteIndex);
            userData = Arrays.copyOf(userData, userData.length - 1);
        } else {
            System.out.print(languageModule[123][selectedLanguage]);//"Nomor rute tidak valid"
        }

        clearTerminal();
        viewUserAccounts();
    }

    private static void EditUser() {
        clearTerminal();

        boolean inputValid = false;

        viewUserAccounts();

        System.out.print(languageModule[144][selectedLanguage]);//"⤷ Masukkan nomor rute yang ingin diubah: "
        int selectedService = 0;
        String newData;

        while (!inputValid) {
            if (input.hasNextInt()) {
                selectedService = input.nextInt()-1;
                if (selectedService <= userData.length) {
                    inputValid = true;
                } else {
                    System.out.print(languageModule[124][selectedLanguage]);//"║ Nomor tidak valid. Masukkan nomor yang valid:"
                    input.nextLine();
                }
            } else {
                System.out.println(languageModule[111][selectedService]);   //"║ Input bukan angka. Mohon masukkan nomor yang valid:"
                input.next();
            }
        }

        inputValid = false;
        input.nextLine();

        System.out.println(languageModule[125][selectedLanguage]);//"⤷ Tekan [⏎ Enter] jika tidak ingin mengedit data"

        System.out.print("\t"+userData[selectedService][0] + " ➺  ");
        newData = input.nextLine();
        if(!newData.trim().isEmpty()) {
            userData[selectedService][0] = newData;
        }

        System.out.print("\t"+userData[selectedService][1] + " ➺  ");
        newData = input.nextLine();
        if(!newData.trim().isEmpty()) {
            userData[selectedService][1] = newData;
        }

        while (true) {
            System.out.println("╭──────────────────┬───╮");
            System.out.println("│"+centerString(18, languageModule[107][selectedLanguage])+"│ ▼ │");
            System.out.println("╰──────────────────┴───╯");
            System.out.println("╭───┬──────────────────╮");
            System.out.println("│ 1.│"+centerString(18, ""+languageModule[149][selectedLanguage])+"│");
            System.out.println("│ 2.│"+centerString(18, languageModule[150][selectedLanguage])+"│");
            System.out.println("│ 3.│"+centerString(18, languageModule[151][selectedLanguage])+"│");
            System.out.println("╰───┴──────────────────╯");

            if(selectedLanguage==1){
                System.out.print("\t"+userData[selectedService][2] + " ➺  ");
            } else {
                String tempRole = "";
                if(userData[selectedService][2].equals("ADMIN")) {
                    tempRole = "ADMIN";
                    System.out.print("\t"+tempRole + " ➺  ");
                } else if(userData[selectedService][2].equals("KASIR")) {
                    tempRole = "CASHIER";
                    System.out.print("\t"+tempRole + " ➺  ");
                } else if(userData[selectedService][2].equals("KURIR")) {
                    tempRole = "COURIER";
                    System.out.print("\t"+tempRole + " ➺  ");
                }
            }

            String pilihJabatan = input.nextLine();

            if(pilihJabatan.trim().isEmpty()) {
                break;
            }

            switch (pilihJabatan) {
                case "1":
                    newData = "ADMIN";
                    userData[selectedService][2] = newData;
                    break;
                case "2":
                    newData = "KURIR";
                    userData[selectedService][2] = newData;
                    break;
                case "3":
                    newData = "KASIR";
                    userData[selectedService][2] = newData;
                    break;
                default:
                    break;
            }
            break;
        }

        clearTerminal();
        viewUserAccounts();
    }    

    private static void Login() {
        displayHeader();
        displayIndonesianMap();

        LeftBorder();

        System.out.print(languageModule[1][selectedLanguage]);
        String inputUsername = input.nextLine();

        LeftBorder();

        System.out.print(languageModule[2][selectedLanguage]);
        String inputPassword = input.nextLine();

        LeftBorder();

        loginValidation(inputUsername, inputPassword);

        if(!login){
            notificationBox(97, languageModule[4][selectedLanguage]);
            CountdownAndClear(3);
            Login();
        }
    }

    private static void ManageUser() {
        int pilihan;
        while(true) {

            while (true) {
                try {
                    displayHeader();
                    displayIndonesianMap();
                    viewUserManagementMenu();
                    
                    System.out.print(languageModule[80][selectedLanguage]);//"║ ⤷ Masukkan Pilihan: "
                    pilihan = input.nextInt();
                } catch (InputMismatchException e) {
                    input.nextLine();
                    clearTerminal();
                    continue;
                }
                input.nextLine();
                clearTerminal();
                break;
            }

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
                    DeleteUser();
                    pressEnter();
                    continue;   

                case 4:
                    clearTerminal();
                    viewUserAccounts();
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
                    deleteTransactionByTrackingNumber();
                    pressEnter();
                    continue;

                case 3:
                    while (true) {
                        displayHeader();
                        displayIndonesianMap();
                        viewExpeditionHistoryMenu();
                        System.out.print(languageModule[80][selectedLanguage]);//"║ ⤷ Masukkan Pilihan: "
                        int editMenu = input.nextInt();
                        input.nextLine();
                        
                        switch (editMenu) {
                            case 1:
                                searchHistoryDateRange();
                                continue;

                            case 2:
                                searchHistoryByDay(); 
                                continue;

                            case 3:
                                searchHistoryByMonth();
                                continue;

                            case 4:
                                searchHistoryByYear();
                                continue;

                            case 5:
                                searchHistoryByTrackingNumber();                                                    
                                continue;

                            case 6:
                                clearTerminal();
                                break;

                            default:
                                continue;
                        }
                        break;
                    }

                case 4:
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

            try {
                System.out.print(languageModule[80][selectedLanguage]);//"║ ⤷ Masukkan Pilihan: "
                inputselectedLanguage = input.nextInt();
            } catch (InputMismatchException e) {
                input.nextLine();
                continue;
            }

            if (inputselectedLanguage > 2) {
                continue;
            } else if (inputselectedLanguage < 1) {
                continue;
            } else {
                changeLanguage(inputselectedLanguage);
                RefreshFormatter();
                break;
            }
        } while (true);
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
                    clearTerminal();
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
        System.out.println("║             │          [1]. " + padStringLeft(25, languageModule[84][selectedLanguage]) + "[4]. " + padStringLeft(25, languageModule[87][selectedLanguage]) + "│             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │          [2]. " + padStringLeft(25, languageModule[85][selectedLanguage]) + "[5]. " + padStringLeft(25, languageModule[88][selectedLanguage]) + "│             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │          [3]. " + padStringLeft(25, languageModule[86][selectedLanguage]) + "[6]. " + padStringLeft(25, languageModule[17][selectedLanguage]) + "│             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │                                                                      │             ║"); 
        System.out.println("║             ╰──────────────────────────────────────────────────────────────────────╯             ║");
        System.out.println("║                                                                                                  ║"); 
        System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════════════╝");
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
                        clearTerminal();
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
            viewTransactionDetail();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void searchHistoryByMonth() {
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

            Locale locale;
            if (selectedLanguage == 0) {
                locale = Locale.ENGLISH;

            } else {
                locale = new Locale("id");
            }

            DateFormatSymbols dateFormatSymbols = new DateFormatSymbols(locale);
            String[] monthNames = dateFormatSymbols.getMonths();

            System.out.println("╔════════════════════╗"); 

            for (int i = 0; i < 12; i++) {
                String monthName = monthNames[i];
                System.out.println("║"+padStringLeft(20, " ["+(i + 1) +"]. " + monthName)+"║");
            }

            System.out.println("╚════════════════════╝");  

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

            String tanggalAwal = String.format("01-%02d-%d", bulanInput, tahunInput);
            cal.set(Calendar.MONTH, bulanInput - 1); // Bulan dimulai dari 0
            int hariTerakhir = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
            String tanggalAkhir = String.format("%02d-%02d-%d", hariTerakhir, bulanInput, tahunInput);

            Date startDate = dateFormat.parse(tanggalAwal);
            Date endDate = dateFormat.parse(tanggalAkhir);

            clearTerminal();
            input.nextLine();
            viewExpeditionHistoryByMonth(startDate, endDate);
            viewTransactionDetail();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void searchHistoryByDay() {
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

            Locale locale;
            if (selectedLanguage == 0) {
                locale = Locale.ENGLISH;

            } else {
                locale = new Locale("id");
            }
            
            DateFormatSymbols dateFormatSymbols = new DateFormatSymbols(locale);
            String[] monthNames = dateFormatSymbols.getMonths();

            System.out.println("╔════════════════════╗"); 

            for (int i = 0; i < 12; i++) {
                String monthName = monthNames[i];
                System.out.println("║"+padStringLeft(20, " ["+(i + 1) +"]. " + monthName)+"║");
            }

            System.out.println("╚════════════════════╝");  

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
        
                        String tanggalYangDiinginkan = String.format("%02d-%02d-%d", tanggalInput, bulanInput, tahunInput);
                        Date startDate = dateFormat.parse(tanggalYangDiinginkan);
                        Date endDate = dateFormat.parse(tanggalYangDiinginkan);
        
                        clearTerminal();
                        input.nextLine();
                        viewExpeditionHistoryByDay(startDate, endDate);
                        viewTransactionDetail();
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
            viewTransactionDetail();
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
                System.out.println("║"+YELLOW+centerString(98,languageModule[146][selectedLanguage]+RESET));//"Input yang dimasukkan tidak valid. Silahkan masukkan nomor resi kembali!"
                System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════════════╝");
            }
        }

        if (deleteIndex >= 0 && deleteIndex < historyTransaksi.length) {
            System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
            System.out.println("║"+RED+centerString(98,languageModule[147][selectedLanguage]+RESET));//"Data dengan nomor resi yang sesuai sudah dihapus")
            System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════════════╝");
            System.arraycopy(historyTransaksi, deleteIndex + 1, historyTransaksi, deleteIndex, historyTransaksi.length - deleteIndex - 1);
            historyTransaksi = Arrays.copyOf(historyTransaksi, historyTransaksi.length - 1);
        } else {
            System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
            System.out.println("║"+YELLOW+centerString(98, languageModule[45][selectedLanguage])+RESET);//data tidak ditemukan
            System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════════════╝");
        }
    }

    private static void CreateShipment() {
        String nomorResi;
        int pilihanLayanan;
        double biayaJarak = 0;
        validInput = false;

        displayHeader();
        LeftBorder();

        System.out.print (languageModule[20][selectedLanguage]);
        String namaPengirim = input.nextLine();

        String nomorKontakPengirim;
        do {
            if (!validInput) {
                LeftBorder();
                System.out.print(languageModule[21][selectedLanguage]); // "║ Masukkan Nomor Kontak: "
            }
            
            nomorKontakPengirim = input.nextLine();
            
            if (nomorKontakPengirim.matches("\\d+")) {
                validInput = true;
            } else {
                System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
                System.out.println("║                                                                                                  ║");
                System.out.println("║" + centerString(99, languageModule[114][selectedLanguage] )+"║"); // "⚠️ INPUT HARUS BERUPA BILANGAN BULAT. SILAHKAN COBA LAGI."
                System.out.println("║                                                                                                  ║");
                System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════════════╝");
                Countdown(2); // "Tekan [  ⏎ Enter] untuk melanjutkan"
                System.out.print("\033[7A\033[0J");
            }
        } while (!validInput);
        
        LeftBorder();
        System.out.print (languageModule[22][selectedLanguage]);
        String namaPenerima = input.nextLine();

        String nomorKontakPenerima;
        validInput = false;
        do {
            if (!validInput) {
                LeftBorder();
                System.out.print(languageModule[21][selectedLanguage]); // "║ Masukkan Nomor Kontak: "
            }
            nomorKontakPenerima = input.nextLine();
            
            if (nomorKontakPenerima.matches("\\d+")) {
                validInput = true;
            } else {
                System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
                System.out.println("║                                                                                                  ║");
                System.out.println("║" + centerString(99, languageModule[114][selectedLanguage] )+"║"); // "⚠️ INPUT HARUS BERUPA BILANGAN BULAT. SILAHKAN COBA LAGI."
                System.out.println("║                                                                                                  ║");
                System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════════════╝");
                Countdown(2); // "Tekan [  ⏎ Enter] untuk melanjutkan"
                System.out.print("\033[7A\033[0J");
            }
        } while (!validInput);

        LeftBorder();
        System.out.print (languageModule[23][selectedLanguage]);
        String alamatPenerima = input.nextLine();

        LeftBorder();
        System.out.print(languageModule[24][selectedLanguage]);
        String deskripsiBarang = input.nextLine();

        double beratBarang=0;
        int panjang = 0;
        int lebar=0;
        int tinggi = 0;
        
        do {
            LeftBorder();
            System.out.print(languageModule[82][selectedLanguage]);
            while (!input.hasNextInt()) {
                input.nextLine();
                System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
                System.out.println("║                                                                                                  ║");
                System.out.println("║"+centerString(99,languageModule[114][selectedLanguage] )+"║");  //"⚠️ INPUT HARUS BERUPA BILANGAN BULAT. SILAHKAN COBA LAGI.")
                System.out.println("║                                                                                                  ║");
                System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════════════╝");
                Countdown(2);
                System.out.print("\033[6A\033[0J");
                System.out.print(languageModule[82][selectedLanguage]); //"║ Masukkan Berat: "
            }
            beratBarang= input.nextInt();

            input.nextLine(); // membersihkan buffer input
            if (beratBarang <= 0) {
                input.nextLine();
                System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
                System.out.println("║                                                                                                  ║");
                System.out.println("║"+centerString(99,languageModule[115][selectedLanguage] )+"║");  //"⚠️ BERAT HARUS LEBIH BESAR DARI 0 . SILAHKAN COBA LAGI.")
                System.out.println("║                                                                                                  ║");
                System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════════════╝");
                Countdown(2);
                input.nextLine();  
                System.out.print("\033[7A\033[0J");
            } else {
                validInput = true;
            }
        } while (!validInput);
        
        do {
            LeftBorder();
            System.out.print(languageModule[25][selectedLanguage]); //"║ Masukkan Panjang: "
            while (!input.hasNextInt()) {
                input.nextLine();
                System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
                System.out.println("║                                                                                                  ║");
                System.out.println("║"+centerString(99,languageModule[114][selectedLanguage] )+"║");  //"⚠️ INPUT HARUS BERUPA BILANGAN BULAT. SILAHKAN COBA LAGI.")
                System.out.println("║                                                                                                  ║");
                System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════════════╝");
                Countdown(2);
                System.out.print("\033[6A\033[0J");
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
                Countdown(2);
                input.nextLine();  
                System.out.print("\033[7A\033[0J");
            } else {
                validInput = true;
            }
        } while (!validInput);
        
        do {
            LeftBorder();
            System.out.print(languageModule[26][selectedLanguage]); //"║ Masukkan Lebar: "
            while (!input.hasNextInt()) {
                input.nextLine();
                System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
                System.out.println("║                                                                                                  ║");
                System.out.println("║"+centerString(99,languageModule[114][selectedLanguage] )+"║"); //"⚠️ INPUT HARUS BERUPA BILANGAN BULAT. SILAHKAN COBA LAGI."
                System.out.println("║                                                                                                  ║");
                System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════════════╝");
                Countdown(2);
                System.out.print("\033[6A\033[0J");
                System.out.print(languageModule[26][selectedLanguage]); //"║ Masukkan Lebar: "
            }
            lebar = input.nextInt();

            input.nextLine(); // membersihkan buffer input
            if (lebar <= 0) {
                input.nextLine();
                System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
                System.out.println("║                                                                                                  ║");
                System.out.println("║"+centerString(99, languageModule[117][selectedLanguage])+"║"); //"⚠️ LEBAR HARUS LEBIH BESAR DARI 0. SILAHKAN COBA LAGI."
                System.out.println("║                                                                                                  ║");
                System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════════════╝");
                Countdown(2);
                input.nextLine();  
                System.out.print("\033[7A\033[0J");
            } else {
                validInput = true;
            }
        } while (!validInput);

        do {
            LeftBorder();
            System.out.print(languageModule[27][selectedLanguage]); //"║ Masukkan Tinggi: "
            while (!input.hasNextInt()) {
                input.nextLine();
                System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════════════╣");
                System.out.println("║                                                                                                  ║");
                System.out.println("║"+centerString(99,languageModule[114][selectedLanguage] )+"║");     //"⚠️ INPUT HARUS BERUPA BILANGAN BULAT. SILAHKAN COBA LAGI."
                System.out.println("║                                                                                                  ║");
                System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════════════╝");
                Countdown(2);
                System.out.print("\033[6A\033[0J");
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
                Countdown(2);
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
        int jarak = 0;
        double kembalian=0;
        int bayar=0;
        do {
            LeftBorder();
            System.out.print(languageModule[178][selectedLanguage] + ": ");//asal
            origin = input.nextLine().toUpperCase();

            LeftBorder();
            System.out.print(languageModule[179][selectedLanguage] + ": ");//tujuan
            destination = input.nextLine().toUpperCase();

            LeftBorder();

            for (int i = 0; i < rutePengiriman.length; i++) {
                if ((rutePengiriman[i][0].equalsIgnoreCase(origin) && rutePengiriman[i][1].equalsIgnoreCase(destination)) || 
                (rutePengiriman[i][0].equalsIgnoreCase(destination) && rutePengiriman[i][1].equalsIgnoreCase(origin))) {
                    jarak = Integer.parseInt(rutePengiriman[i][2]);
                    double tarifTambahan = 5000;
                            if (jarak <= 100) {
                                biayaJarak = (jarak * tarifPerKm) / 100;
                            } else {
                                double biayaAwal = (100 * tarifPerKm) / 100; 

                                double sisaJarak = jarak - 100;

                                double biayaTambahan = Math.ceil(sisaJarak / 50) * tarifTambahan;

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
                System.out.println("║"+centerString(99, languageModule[28][selectedLanguage])+"║"); //"⚠️ RUTE TIDAK DITEMUKAN. SILAKAN COBA LAGI."
                System.out.println("║                                                                                                  ║");
                System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════════════╝");
                Countdown(3);
                System.out.print("\033[10A\033[0J");
            }    
        } while (!found);

        //Memilih Jenis Layanan pada Array

        System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════════════╝");
        viewExpeditionServices();
        System.out.print (languageModule[142][selectedLanguage]);//" ⤷ Masukkan Pilihan: "
        pilihanLayanan = input.nextInt();
        double tarifLayanan = Double.parseDouble(arrayLayanan[pilihanLayanan-1][1]);
        
        double biayaBerat = 0 ;
        double biayaVol = 0;
        biayaBerat = (beratBarang * tarifPerKg) / 5;
        biayaVol = (tarifPerKg * (panjang * lebar * tinggi) / 4000) / 5;

        double hargaTertinggi = Math.max (biayaBerat,biayaVol);
        double biayaAkhir;
        String selectedKgVol = "";
        String KgVol;

        if (hargaTertinggi == biayaVol) {
            biayaAkhir = tarifLayanan + hargaTertinggi + biayaJarak;
            KgVol = (panjang * lebar * tinggi)+" cm³";
            selectedKgVol = "Volume";
        } else {
            biayaAkhir = tarifLayanan + hargaTertinggi + biayaJarak;
            KgVol = beratBarang+" kg";
            selectedKgVol = languageModule[155][selectedLanguage];
        }

        nomorResi = generateTrackingNumber();

        System.out.println("╔════════════════════════════════════════════════════════════╗"); 
        System.out.println("║"+centerString(60,languageModule[30][selectedLanguage])+"║"); //"Metode Pembayaran"
        System.out.println("╠════════════════════════════════════════════════════════════╣");
        System.out.println("║ 1. Transfer Bank");
        System.out.println("║ 2. "+getLanguageModuleText(173));
        System.out.println("╚════════════════════════════════════════════════════════════╝");
        System.out.print(languageModule[31][selectedLanguage]); //" ⤷ Pilih Metode Pembayaran: "
        int metode = input.nextInt();

        switch (metode) {
            case 1:
                while (true) {
                    paymentMethod = "Bank";
                    System.out.println("╔════════════════════════════════════════════════════════════╗"); 
                    System.out.println("║"+centerString(60,"BANK")+"║");
                    System.out.println("╠════════════════════════════════════════════════════════════╣");
                    System.out.println("║ 1. BRI");
                    System.out.println("║ 2. BNI");
                    System.out.println("║ 3. MANDIRI");
                    System.out.println("╚════════════════════════════════════════════════════════════╝");
                
                    System.out.print(languageModule[32][selectedLanguage]); //"⤷ Pilih Bank "
                    int jenisBank = input.nextInt();
                    input.nextLine();

                    switch (jenisBank) {
                        case 1:
                            System.out.print(languageModule[172][selectedLanguage]);
                            paymentMethod = "BRI - "+input.nextLine();
                            break;

                        case 2:
                            System.out.print(languageModule[172][selectedLanguage]);
                            paymentMethod = "BNI - "+input.nextLine();
                            break;

                        case 3:
                            System.out.print(languageModule[172][selectedLanguage]); 
                            paymentMethod = "MANDIRI - "+input.nextLine();
                            break;

                        default:
                            continue;
                    }  
                    break;
                }
                bayar = (int) biayaAkhir;
                clearTerminal();
                System.out.println(String.format(
                    receiptFormat,
                    tanggalHariIni,
                    namaPengirim,
                    loggedInUsername,
                    nomorKontakPengirim,
                    nomorResi, 
                    namaPenerima,
                    paymentMethod,
                    nomorKontakPenerima,
                    centerString(51, origin), 
                    centerString(51, destination),
                    deskripsiBarang,
                    selectedKgVol,
                    KgVol,
                    hargaTertinggi,
                    jarak,
                    biayaJarak,
                    arrayLayanan[pilihanLayanan-1][0],
                    arrayLayanan[pilihanLayanan-1][1],
                    Double.toString(biayaAkhir),
                    bayar,
                    kembalian
                )); 
                pressEnter();
                break;   //"║ Pembayaran Berhasil menggunakan "

            case 2:
                paymentMethod = languageModule[173][selectedLanguage];
                boolean validInput = false;

                clearTerminal();
                System.out.println(String.format(
                    receiptFormat,
                    tanggalHariIni,
                    namaPengirim,
                    loggedInUsername,
                    nomorKontakPengirim,
                    nomorResi, 
                    namaPenerima,
                    paymentMethod,
                    nomorKontakPenerima,
                    centerString(51, origin), 
                    centerString(51, destination),
                    deskripsiBarang,
                    selectedKgVol,
                    KgVol,
                    hargaTertinggi,
                    jarak,
                    biayaJarak,
                    arrayLayanan[pilihanLayanan-1][0],
                    arrayLayanan[pilihanLayanan-1][1],
                    Double.toString(biayaAkhir),
                    bayar,
                    kembalian
                )); 

                do {
                    System.out.print(languageModule[37][selectedLanguage]); //"║ Bayar: "

                    while (!input.hasNextInt()) {
                        System.out.println("⚠️ " + languageModule[114][selectedLanguage]); // Pesan untuk input bukan bilangan bulat
                        System.out.print(languageModule[37][selectedLanguage]);
                        input.nextLine(); //"║ Bayar: "
                    }

                    bayar = input.nextInt();

                    if (bayar <= 0) {
                        System.out.println("⚠️ " + languageModule[148][selectedLanguage]); // Pesan untuk input <= 0
                    } else if (bayar < biayaAkhir) {
                        System.out.println("⚠️ " + languageModule[148][selectedLanguage]); // Jumlah uang yang anda berikan kurang
                    } else {
                        validInput = true;
                    }

                    kembalian = (bayar - biayaAkhir);
                    clearTerminal();
                    System.out.println(String.format(
                        receiptFormat,
                        tanggalHariIni,
                        namaPengirim,
                        loggedInUsername,
                        nomorKontakPengirim,
                        nomorResi, 
                        namaPenerima,
                        paymentMethod,
                        nomorKontakPenerima,
                        centerString(51, origin), 
                        centerString(51, destination),
                        deskripsiBarang,
                        selectedKgVol,
                        KgVol,
                        hargaTertinggi,
                        jarak,
                        biayaJarak,
                        arrayLayanan[pilihanLayanan-1][0],
                        arrayLayanan[pilihanLayanan-1][1],
                        Double.toString(biayaAkhir),
                        bayar,
                        kembalian
                    )); 
                } while (!validInput);

            input.nextLine();
            pressEnter();
        }     
            historyTransaksi = Arrays.copyOf(historyTransaksi,historyTransaksi.length + 1);
            historyTransaksi[historyTransaksi.length-1] = new String[]{
            nomorResi,
            tanggalHariIni,
            namaPengirim,
            String.valueOf(nomorKontakPengirim),
            destination,
            arrayLayanan[pilihanLayanan-1][0],
            Double.toString(biayaAkhir),
            loggedInUsername,
            namaPenerima,
            alamatPenerima,
            String.valueOf(KgVol),
            deskripsiBarang,
            "On Process",
            origin,
            paymentMethod,
            selectedKgVol,
            String.valueOf(hargaTertinggi),
            String.valueOf(bayar),
            String.valueOf(kembalian),
            String.valueOf(jarak),
            String.valueOf(biayaJarak),
            arrayLayanan[pilihanLayanan-1][1],
            nomorKontakPenerima
        };

        clearTerminal();
        System.out.println(String.format(
            labelFormat,
            nomorResi,
            arrayLayanan[pilihanLayanan-1][0],
            beratBarang,
            biayaAkhir,
            namaPenerima, 
            namaPengirim,
            alamatPenerima, 
            nomorKontakPengirim,
            destination,
            origin,
            deskripsiBarang
        ));  
    }

    private static void AddRoute() {
        clearTerminal();
        viewExpeditionRoutes();

        boolean routeExist = false;
        String origin;
        String destination;
        
        do {
            routeExist = false;
            System.out.print(" ⤷ "+getLanguageModuleText(93)+": ");
            origin = input.nextLine();
            System.out.print(" ⤷ "+getLanguageModuleText(94)+": ");
            destination = input.nextLine();

            for (int i = 0; i < rutePengiriman.length; i++) {
                if ((rutePengiriman[i][0].equalsIgnoreCase(origin) && rutePengiriman[i][1].equalsIgnoreCase(destination)) || 
                (rutePengiriman[i][0].equalsIgnoreCase(destination) && rutePengiriman[i][1].equalsIgnoreCase(origin))) {
                    System.out.println(languageModule[121][selectedLanguage]);//"Rute tersebut sudah ada!"
                    System.out.print(languageModule[81][selectedLanguage]);//"Tekan [  ⏎ Enter] untuk melanjutkan"
                    input.nextLine();
                    System.out.print("\033[4A\033[0J");
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
                    EditService();
                    pressEnter();
                    continue;

                case 3:
                    DeleteService();
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
        clearTerminal();
        viewExpeditionServices();

        String namaLayanan = "";
        int tarifLayanan = 0;
        int startEstimation = 0;
        int endEstimation = 0;
        boolean inputValid = false;

        System.out.print(languageModule[57][selectedLanguage]);// "║ ⤷ Masukkan Nama Layanan: "
        namaLayanan = input.next();

        while (!inputValid) {
            System.out.print(languageModule[58][selectedLanguage]);//"║ ⤷ Masukkan Tarif: Rp."
            if (input.hasNextInt()) {
                tarifLayanan = input.nextInt();
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

        input.nextLine();

        clearTerminal();
        viewExpeditionServices();
    }

    private static void EditService() {
        clearTerminal();
        viewExpeditionServices();

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

        System.out.println(languageModule[125][selectedLanguage]);//"⤷ Tekan [⏎ Enter] jika tidak ingin mengedit data"

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

        clearTerminal();
        viewExpeditionServices();        
    }

    private static void DeleteService() {
        clearTerminal();
        viewExpeditionServices();

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
            System.arraycopy(arrayLayanan, deleteIndex, arrayLayanan, deleteIndex - 1, arrayLayanan.length - deleteIndex);
            arrayLayanan = Arrays.copyOf(arrayLayanan, arrayLayanan.length - 1);
        } else {
            System.out.println(languageModule[113][selectedLanguage]);//"Nomor layanan tidak valid."
        }
        input.nextLine();

        clearTerminal();
        viewExpeditionServices();        
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
                    System.out.print(languageModule[108][selectedLanguage]+"("+tarifPerKg+") ➪  ");//"║ ⤷ Masukkan tarif dasar per Kg: "
                    tarifPerKg = input.nextInt();
                    input.nextLine();
                    pressEnter();
                    continue;

                case 2:
                    System.out.print(languageModule[109][selectedLanguage]+"("+tarifPerKm+") ➪  ");//"║ ⤷ Masukkan tarif dasar per Kg: "
                    tarifPerKm = input.nextInt();
                    input.nextLine();
                    pressEnter();
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
        int tahun;
        Locale locale;
        int nomorBulan; 

        System.out.print(" ⤷ "+languageModule[100][selectedLanguage]+": ");
        String location = input.nextLine();

        if (selectedLanguage == 0) {
            locale = Locale.ENGLISH;
            System.out.print(" ⤷ Enter Years (YYYY): ");
            tahun = input.nextInt();
            input.nextLine();
            
            DateFormatSymbols dateFormatSymbols = new DateFormatSymbols(locale);
            String[] monthNames = dateFormatSymbols.getMonths();

            System.out.println("╔════════════════════╗"); 

            for (int i = 0; i < 12; i++) {
                String monthName = monthNames[i];
                System.out.println("║"+padStringLeft(20, " ["+(i + 1) +"]. " + monthName)+"║");
            }

            System.out.println("╚════════════════════╝");  

            System.out.print(" ⤷ Enter month index: ");
            nomorBulan = input.nextInt();
        } else {
            locale = new Locale("id");
            System.out.print(" ⤷ Masukkan Tahun (TTTT): ");
            tahun = input.nextInt();
            input.nextLine();

            DateFormatSymbols dateFormatSymbols = new DateFormatSymbols(locale);
            String[] monthNames = dateFormatSymbols.getMonths();

            System.out.println("╔════════════════════╗"); 

            for (int i = 0; i < 12; i++) {
                String monthName = monthNames[i];
                System.out.println("║"+padStringLeft(20, " ["+(i + 1) +"]. " + monthName)+"║");
            }

            System.out.println("╚════════════════════╝");  

            System.out.print(" ⤷ Masukkan index bulan: ");
            nomorBulan = input.nextInt();
        }
        
        input.nextLine();
        Calendar calendar = Calendar.getInstance(locale);
        calendar.set(Calendar.YEAR, tahun);
   
        try {
        } catch (Exception e) {
            System.out.println("Format bulan tidak valid!");
            return;
        }
        Calendar cal = Calendar.getInstance();

        String tanggalAwal = String.format("01-%02d-%d", nomorBulan, tahun);
        cal.set(Calendar.MONTH, nomorBulan - 1); 
        int hariTerakhir = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        String tanggalAkhir = String.format("%02d-%02d-%d", hariTerakhir, nomorBulan, tahun);

        DateFormatSymbols dateFormatSymbols = new DateFormatSymbols(locale);
        String monthName = dateFormatSymbols.getMonths()[nomorBulan-1];

        try {
            Date startDate = dateFormat.parse(tanggalAwal);
            Date endDate = dateFormat.parse(tanggalAkhir);

            clearTerminal();

            System.out.println(String.format(
                reportFormat,
                location.toUpperCase() + ", " + monthName + " " + tahun,
                padStringRight(24, Integer.toString(getExpeditionCount(startDate, endDate, location))),
                padStringRight(24, Integer.toString(getInbound(startDate, endDate, location))),
                padStringRight(24, Integer.toString(getOutbound(startDate, endDate, location))),
                padStringRight(24, "Rp "+Double.toString(getRevenue(startDate, endDate, location)))
            ));
        } catch (Exception e) {
            System.out.println("Error parsing dates!");
        }
    }

    private static void viewShipmentMenu() {
        System.out.println("║                                                                                                  ║");
        System.out.println("║             ╭──────────────────────────────────────────────────────────────────────╮             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │                     [1]. " + padStringLeft(44, languageModule[73][selectedLanguage]) + "│             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │                     [2]. " + padStringLeft(44, languageModule[75][selectedLanguage]) + "│             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │                     [3]. " + padStringLeft(44, languageModule[77][selectedLanguage]) + "│             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │                     [4]. " + padStringLeft(44, languageModule[164][selectedLanguage]) + "│             ║");
        System.out.println("║             │                                                                      │             ║");
        System.out.println("║             │                     [5]. " + padStringLeft(44, languageModule[17][selectedLanguage]) + "│             ║");
        System.out.println("║             │                                                                      │             ║"); 
        System.out.println("║             ╰──────────────────────────────────────────────────────────────────────╯             ║");
        System.out.println("║                                                                                                  ║"); 
        System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════════════╝");

    }

    private static void viewWarehouseInventory() {
        boolean inputFound = true;
        System.out.print(languageModule[74][selectedLanguage]);//"Kirim Paket"
        String location  = input.nextLine();

        clearTerminal();

        while (inputFound) {
            int[] columnWidths = calculateColumnWidths(historyTransaksi);
            String formattedHeader = String.format("║ %3s ║ %-" + columnWidths[0] + "s ║ %-" + columnWidths[11] + "s ║ %-" + columnWidths[4] + "s ║ %-" + columnWidths[9] + "s ║ %-" + columnWidths[12] + "s",
                "No", 
                languageModule[89][selectedLanguage],//no resi
                languageModule[154][selectedLanguage],//deskripsi
                languageModule[94][selectedLanguage],//destination
                languageModule[98][selectedLanguage],//alamat
                "Status"
            );

            System.out.println("╔═══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println(formattedHeader);
            System.out.println("╠═══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣");

            for (int i = 0; i < historyTransaksi.length; i++) {
                if (historyTransaksi[i][13].equalsIgnoreCase(location) && historyTransaksi[i][12].equalsIgnoreCase("Waiting for pickup") ||
                    historyTransaksi[i][4].equalsIgnoreCase(location) && historyTransaksi[i][12].equalsIgnoreCase("Arrived at warehouse")) {
                        System.out.println(String.format("║ %3s ║ %-" + columnWidths[0] + "s ║ %-" + columnWidths[11] + "s ║ %-" + columnWidths[4] + "s ║ %-" + columnWidths[9] + "s ║ %-" + columnWidths[12] + "s",
                            i,
                            historyTransaksi[i][0],
                            historyTransaksi[i][11],
                            historyTransaksi[i][4],
                            historyTransaksi[i][9],
                            historyTransaksi[i][12]
                        ));
                }
            }        
            System.out.println("╚════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝");
            
            System.out.print(getLanguageModuleText(183));
            String confirm = input.nextLine();

            if (confirm.equalsIgnoreCase("Y")){
                System.out.print(getLanguageModuleText(76));
                int index = input.nextInt();
                viewWarehousePackageDetail(index);
                pressEnter();
                continue;
            } else {
                break;
            }
        
        }
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
                            

        while (true) {

            while (shipmentFound) {
                int[] columnWidths = calculateColumnWidths(historyTransaksi);
                String formattedHeader = String.format("║ %3s ║ %-" + columnWidths[0] + "s ║ %-" + columnWidths[11] + "s ║ %-" + columnWidths[5] + "s ║ %-" + columnWidths[4] + "s ║ %-" + columnWidths[9] + "s ║ %-" + columnWidths[12] + "s",
                    "No", 
                    languageModule[89][selectedLanguage],//no resi
                    languageModule[154][selectedLanguage],//deskripsi
                    languageModule[92][selectedLanguage],//layanan
                    languageModule[94][selectedLanguage],//destination
                    languageModule[98][selectedLanguage],//alamat
                    "Status"
                );

                System.out.println("╔════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
                System.out.println("║"+centerString(140, getLanguageModuleText(150)+": "+loggedInUsername)+"║");
                System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣");
                System.out.println(formattedHeader);
                System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣");

                for (int k = 0; k < shipmentDetails.length; k++) {
                    if (shipmentDetails[k][1].equalsIgnoreCase(loggedInUsername) && shipmentDetails[k][2].equalsIgnoreCase("Sending")) {
                        shipmentDetails[k][2] = "Sending";

                        for (int i = 0; i < historyTransaksi.length; i++) {
                            if(historyTransaksi[i][0].equals(shipmentDetails[k][0])) {
                                System.out.println(String.format("║ %3s ║ %-" + columnWidths[0] + "s ║ %-" + columnWidths[11] + "s ║ %-" + columnWidths[5] + "s ║ %-" + columnWidths[4] + "s ║ %-" + columnWidths[9] + "s ║ %-" + columnWidths[12] + "s",
                                    i,
                                    historyTransaksi[i][0],
                                    historyTransaksi[i][11],
                                    historyTransaksi[i][5],
                                    historyTransaksi[i][4],
                                    historyTransaksi[i][9],
                                    historyTransaksi[i][12]
                                ));
                            }
                        }
                    }
                }

                System.out.println("╚════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝");

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
                    clearTerminal();
                    break;
                } else {
                    clearTerminal();
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
                    String formattedHeader = String.format("║ %3s ║ %-" + columnWidths[0] + "s ║ %-" + columnWidths[11] + "s ║ %-" + columnWidths[5] + "s ║ %-" + columnWidths[4] + "s ║ %-" + columnWidths[9] + "s ║ %-" + columnWidths[12] + "s",
                        "No", 
                        languageModule[89][selectedLanguage],//no resi
                        languageModule[154][selectedLanguage],//deskripsi
                        languageModule[92][selectedLanguage],//layanan
                        languageModule[94][selectedLanguage],//destination
                        languageModule[98][selectedLanguage],//alamat
                        "Status"
                    );

                    clearTerminal();
                    System.out.println("╔════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
                    System.out.println(formattedHeader);
                    System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣");

                    for (int i = 0; i < historyTransaksi.length; i++) {
                        if (historyTransaksi[i][13].equalsIgnoreCase(location) && historyTransaksi[i][12].equalsIgnoreCase("Waiting for pickup")) {
                            System.out.println(String.format("║ %3s ║ %-" + columnWidths[0] + "s ║ %-" + columnWidths[11] + "s ║ %-" + columnWidths[5] + "s ║ %-" + columnWidths[4] + "s ║ %-" + columnWidths[9] + "s ║ %-" + columnWidths[12] + "s",
                                i,
                                historyTransaksi[i][0],
                                historyTransaksi[i][11],
                                historyTransaksi[i][5],
                                historyTransaksi[i][4],
                                historyTransaksi[i][9],
                                historyTransaksi[i][12]
                            ));
                            searchIndex++;
                        }
                    }

                    System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣");
                    System.out.println("║ [1] "+getLanguageModuleText(184));
                    System.out.println("║ [2] "+getLanguageModuleText(185));
                    System.out.println("║ [3] "+getLanguageModuleText(176));
                    System.out.println("╚════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝");  

                    System.out.print(getLanguageModuleText(142));
                    int choice = input.nextInt();
                    
                    switch (choice) {
                        case 1:
                            System.out.print(getLanguageModuleText(76));
                            int index = input.nextInt();
                            viewWarehousePackageDetail(index);
                            pressEnter();
                            continue;

                        case 2:
                            if (searchIndex != 0){
                                int indexKirim;
                                boolean adaKesamaanData = false; 
                                System.out.print(languageModule[76][selectedLanguage]);
                                indexKirim = input.nextInt();
                                input.nextLine();

                                for (int i = 0; i < historyTransaksi.length; i++) {
                                    if (i != indexKirim && historyTransaksi[i][12].equals("Waiting for pickup" ) && 
                                        historyTransaksi[i][4].equals(historyTransaksi[indexKirim][4]) && 
                                        historyTransaksi[i][5].equals(historyTransaksi[indexKirim][5]) && 
                                        historyTransaksi[i][0] != historyTransaksi[indexKirim][0] &&
                                        historyTransaksi[i][13].equals(historyTransaksi[indexKirim][13])) {
                                        adaKesamaanData = true;
                                        System.out.println(String.format("║ %3s ║ %-" + columnWidths[0] + "s ║ %-" + columnWidths[11] + "s ║ %-" + columnWidths[5] + "s ║ %-" + columnWidths[4] + "s ║ %-" + columnWidths[9] + "s ║ %-" + columnWidths[12] + "s",
                                            i,
                                            historyTransaksi[i][0],
                                            historyTransaksi[i][11],
                                            historyTransaksi[i][5],
                                            historyTransaksi[i][4],
                                            historyTransaksi[i][9],
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

                                            shipmentDetails = Arrays.copyOf(shipmentDetails,shipmentDetails.length + 1);
                                            shipmentDetails[shipmentDetails.length-1] = new String[] {
                                                historyTransaksi[i][0],
                                                loggedInUsername,
                                                "Sending"};

                                        }
                                    }

                                    historyTransaksi[indexKirim][12] = "Sending to destination";

                                    shipmentDetails = Arrays.copyOf(shipmentDetails,shipmentDetails.length + 1);
                                    shipmentDetails[shipmentDetails.length-1] = new String[] {
                                        historyTransaksi[indexKirim][0],
                                        loggedInUsername,
                                        "Sending"};

                                    clearTerminal();

                                    System.out.println("╔════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
                                    System.out.println("║"+centerString(140, getLanguageModuleText(73)+": "+location.toUpperCase())+"║");
                                    System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣");
                                    System.out.println(formattedHeader);
                                    System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣");

                                    for (int i = 0; i < historyTransaksi.length; i++) {
                                        if (historyTransaksi[i][13].equalsIgnoreCase(location) && historyTransaksi[i][12].equalsIgnoreCase("Waiting for pickup")) {
                                            System.out.println(String.format("║ %3s ║ %-" + columnWidths[0] + "s ║ %-" + columnWidths[11] + "s ║ %-" + columnWidths[5] + "s ║ %-" + columnWidths[4] + "s ║ %-" + columnWidths[9] + "s ║ %-" + columnWidths[12] + "s",
                                                i,
                                                historyTransaksi[i][0],
                                                historyTransaksi[i][11],
                                                historyTransaksi[i][5],
                                                historyTransaksi[i][4],
                                                historyTransaksi[i][9],
                                                historyTransaksi[i][12]
                                            ));
                                            searchIndex++;
                                        }
                                    }

                                    System.out.println("╚════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝");

                                    System.out.println();

                                    System.out.println("╔════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
                                    System.out.println("║"+centerString(140, getLanguageModuleText(150)+": "+loggedInUsername)+"║");
                                    System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣");
                                    System.out.println(formattedHeader);
                                    System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣");

                                    for (int k = 0; k < shipmentDetails.length; k++) {
                                        if (shipmentDetails[k][1].equalsIgnoreCase(loggedInUsername) && shipmentDetails[k][2].equalsIgnoreCase("Sending")) {
                                            shipmentDetails[k][2] = "Sending";

                                            for (int i = 0; i < historyTransaksi.length; i++) {
                                                if(historyTransaksi[i][0].equals(shipmentDetails[k][0])) {
                                                    System.out.println(String.format("║ %3s ║ %-" + columnWidths[0] + "s ║ %-" + columnWidths[11] + "s ║ %-" + columnWidths[5] + "s ║ %-" + columnWidths[4] + "s ║ %-" + columnWidths[9] + "s ║ %-" + columnWidths[12] + "s",
                                                        i,
                                                        historyTransaksi[i][0],
                                                        historyTransaksi[i][11],
                                                        historyTransaksi[i][5],
                                                        historyTransaksi[i][4],
                                                        historyTransaksi[i][9],
                                                        historyTransaksi[i][12]
                                                    ));
                                                }
                                            }

                                            shipmentFound = true;
                                        }
                                    }
                                        
                                    System.out.println("╚════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝");
                                    pressEnter();

                                    } else {
                                        historyTransaksi[indexKirim][12] = "Sending to destination";
                                        shipmentDetails = Arrays.copyOf(shipmentDetails,shipmentDetails.length + 1);
                                        shipmentDetails[shipmentDetails.length-1] = new String[] {
                                            historyTransaksi[indexKirim][0],
                                            loggedInUsername,
                                            "Sending"};
                                    }
                                    
                                    for (int k = 0; k < shipmentDetails.length; k++) {
                                        if (shipmentDetails[k][1].equalsIgnoreCase(loggedInUsername) && shipmentDetails[k][2].equalsIgnoreCase("Sending")) {
                                            shipmentFound = true;
                                        }
                                    }
                            }
                            break;
                    
                        case 3:

                            break;

                        default:
                            continue;
                    }


                    break;
                }
                break;
            }
            break;
        }

    }

    private static void ManageShipment() {
        while (true) {
            displayHeader();
            displayIndonesianMap();
            viewShipmentMenu();

            System.out.print(languageModule[80][selectedLanguage]);//"║ ⤷ Masukkan Pilihan: "
            subMenu = input.nextInt();
            input.nextLine();

            switch (subMenu) {
                case 1:
                    viewWarehouseInventory();
                    clearTerminal();
                    continue;

                case 2:
                    clearTerminal();
                    SendPackage();
                    continue;

                case 3:
                    DeliverPackage();
                    pressEnter();
                    continue;

                case 4:
                    clearTerminal();
                    viewExpeditionHistory();
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

    private static void Logout() {
        login=false;
        isAdmin = false;
        isKurir = false;
    }

    private static void Exit() {
        System.out.println("╔══════════════════════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                                                                                                  ║");
        System.out.println("║"+centerString(98, languageModule[79][selectedLanguage])+"║"); //"Anda telah berhasil keluar. Sampai jumpa lain waktu! 👋"
        System.out.println("║                                                                                                  ║");
        System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════════════╝");
        CountdownAndClear(3);
        session = false;
    }

    private static void EditRoute() {
        clearTerminal();

        boolean inputValid = false;

        viewExpeditionRoutes();

        System.out.print(languageModule[126][selectedLanguage]);//"⤷ Masukkan nomor rute yang ingin diubah: "
        int selectedRoute = 0;
        String newData;

        while (!inputValid) {
            if (input.hasNextInt()) {
                selectedRoute = input.nextInt()-1;
                if (selectedRoute <= rutePengiriman.length) {
                    inputValid = true;
                } else {
                    System.out.print(languageModule[124][selectedLanguage]);//"║ Nomor layanan tidak valid. Masukkan nomor layanan yang valid:"
                    input.nextLine();
                }
            } else {
                System.out.println(languageModule[111][selectedRoute]);   //"║ Input bukan angka. Mohon masukkan nomor layanan yang valid:"
                input.next();
            }
        }

        inputValid = false;
        input.nextLine();

        System.out.println(languageModule[125][selectedLanguage]);//"⤷ Tekan [⏎ Enter] jika tidak ingin mengedit data"

        System.out.print("\t"+rutePengiriman[selectedRoute][0] + " ➺  ");
        newData = input.nextLine();
        if(!newData.trim().isEmpty()) {
            rutePengiriman[selectedRoute][0] = newData;
        }

        System.out.print("\t"+rutePengiriman[selectedRoute][1] + " ➺  ");
        newData = input.nextLine();
        if(!newData.trim().isEmpty()) {
            rutePengiriman[selectedRoute][1] = newData;
        }

        System.out.print("\t"+rutePengiriman[selectedRoute][2] + " ➺  ");
        newData = input.nextLine();
        if(!newData.trim().isEmpty()) {
            rutePengiriman[selectedRoute][2] = newData;
        }

        clearTerminal();
        viewExpeditionRoutes();
    }

    private static void DeliverPackage() {
        clearTerminal();

        int selectedData = 0;

        clearTerminal();
        boolean inputFound = false;
        System.out.print(languageModule[74][selectedLanguage]);//"Kirim Paket"
        String location  = input.nextLine();

        inputFound = true;

        while (inputFound) {
            int[] columnWidths = calculateColumnWidths(historyTransaksi);
            String formattedHeader = String.format("║ %3s ║ %-" + columnWidths[0] + "s ║ %-" + columnWidths[11] + "s ║ %-" + columnWidths[8] + "s ║ %-" + columnWidths[9] + "s ║ %-" + columnWidths[12] + "s",
                "No", 
                languageModule[89][selectedLanguage],//no resi
                languageModule[154][selectedLanguage],//deskripsi
                languageModule[97][selectedLanguage],//penerima
                languageModule[98][selectedLanguage],//alamat
                "Status"
            );

            System.out.println("╔════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println(formattedHeader);
            System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣");

            for (int i = 0; i < historyTransaksi.length; i++) {
                if (historyTransaksi[i][4].equalsIgnoreCase(location) && historyTransaksi[i][12].equalsIgnoreCase("Arrived at warehouse")) {
                    System.out.println(String.format("║ %3s ║ %-" + columnWidths[0] + "s ║ %-" + columnWidths[11] + "s ║ %-" + columnWidths[8] + "s ║ %-" + columnWidths[9] + "s ║ %-" + columnWidths[12] + "s",
                        i,
                        historyTransaksi[i][0],
                        historyTransaksi[i][11],
                        historyTransaksi[i][8],
                        historyTransaksi[i][9],
                        historyTransaksi[i][12]
                    ));
                }
            }

            System.out.println("╚════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝");
            break;
        }

        System.out.print(getLanguageModuleText(163));
        String confirm = input.nextLine();
        if(confirm.equalsIgnoreCase("Y")) {
            System.out.print(getLanguageModuleText(76));
            selectedData = input.nextInt();
            historyTransaksi[selectedData][12] = "Has been received by the recipient";
        }
    }

    private static void viewExpeditionHistory() {
        int[] columnWidths = calculateColumnWidths(historyTransaksi);
        String formattedHeader = String.format("║ %3s ║ %-" + columnWidths[0] + "s ║ %-" + columnWidths[2] + "s ║ %-" + columnWidths[13] + "s ║ %-" + columnWidths[4] + "s ║ %-" + columnWidths[8] + "s ║ %-" + columnWidths[9] + "s ║ %-" + columnWidths[12] + "s",
            "No", 
            languageModule[89][selectedLanguage],//no resi
            languageModule[91][selectedLanguage],//pengirim
            languageModule[93][selectedLanguage],//asal
            languageModule[94][selectedLanguage],//tujuan
            languageModule[97][selectedLanguage],//penerima
            languageModule[98][selectedLanguage],//alamat
            "Status"
        );

        System.out.println("╔════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println(formattedHeader);
        System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣");

        for (int i = 0; i < historyTransaksi.length; i++) {
            if (historyTransaksi[i][12].equalsIgnoreCase("Has been received by the recipient")) {
                System.out.println(String.format("║ %3s ║ %-" + columnWidths[0] + "s ║ %-" + columnWidths[2] + "s ║ %-" + columnWidths[13] + "s ║ %-" + columnWidths[4] + "s ║ %-" + columnWidths[8] + "s ║ %-" + columnWidths[9] + "s ║ %-" + columnWidths[12] + "s",
                    i,
                    historyTransaksi[i][0], 
                    historyTransaksi[i][2], 
                    historyTransaksi[i][13],
                    historyTransaksi[i][4], 
                    historyTransaksi[i][8],
                    historyTransaksi[i][9], 
                    historyTransaksi[i][12]
                ));
            }
        }
        System.out.println("╚════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝");
    }

    private static void viewTransactionDetail() {
        System.out.print(getLanguageModuleText(174));
        String confirm = input.nextLine();

        if (confirm.equalsIgnoreCase("Y")){
            System.out.print(getLanguageModuleText(76));
            int index = input.nextInt();
            clearTerminal();

            System.out.println(String.format(
                receiptFormat,
                historyTransaksi[index][1],
                historyTransaksi[index][2],
                historyTransaksi[index][0],
                historyTransaksi[index][3],
                historyTransaksi[index][7],
                historyTransaksi[index][8],
                historyTransaksi[index][14],
                historyTransaksi[index][22],
                centerString(51, historyTransaksi[index][13]), 
                centerString(51, historyTransaksi[index][4]),
                historyTransaksi[index][11],
                historyTransaksi[index][15],
                historyTransaksi[index][10],
                historyTransaksi[index][16],
                historyTransaksi[index][19],
                historyTransaksi[index][20],
                historyTransaksi[index][5],
                historyTransaksi[index][21],
                historyTransaksi[index][6],
                historyTransaksi[index][17],
                historyTransaksi[index][18]
            )); 

            input.nextLine();
            pressEnter();
        } else {
            CountdownAndClear(2);
        }
    }

    private static void viewExpeditionHistoryByTrackingNumber(String resi){  
        for (int i = 0; i < historyTransaksi.length; i++) {
            if (historyTransaksi[i][0].equals(resi)) {
                System.out.println(String.format(
                    receiptFormat,
                    historyTransaksi[i][1],
                    historyTransaksi[i][2],
                    historyTransaksi[i][0],
                    historyTransaksi[i][3],
                    historyTransaksi[i][7],
                    historyTransaksi[i][8],
                    historyTransaksi[i][14],
                    historyTransaksi[i][22],
                    centerString(51, historyTransaksi[i][13]), 
                    centerString(51, historyTransaksi[i][4]),
                    historyTransaksi[i][11],
                    historyTransaksi[i][15],
                    historyTransaksi[i][10],
                    historyTransaksi[i][16],
                    historyTransaksi[i][19],
                    historyTransaksi[i][20],
                    historyTransaksi[i][5],
                    historyTransaksi[i][21],
                    historyTransaksi[i][6],
                    historyTransaksi[i][17],
                    historyTransaksi[i][18]
                )); 
            }
        }
    }    

    private static void CountdownAndClear(int seconds) {
        try {
            for (int i = seconds; i > 0; i--) {
                if (selectedLanguage == 0) {
                    System.out.print("Wait [🕒 "+i+" seconds ] to continue... ");
                } else {
                    System.out.print("Tunggu [🕒 "+i+" detik ] untuk melanjutkan... ");
                }
                
                Thread.sleep(1000);
                System.out.print("\r");
            }
            clearTerminal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void Countdown(int seconds) {
        try {
            for (int i = seconds; i > 0; i--) {
                if (selectedLanguage == 0) {
                    System.out.println("Wait [🕒 "+i+" seconds ] to continue... ");
                } else {
                    System.out.println("Tunggu [🕒 "+i+" detik ] untuk melanjutkan... ");
                }
                
                Thread.sleep(1000);
                System.out.print("\033[1A\033[2K");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void MoveCursor(int row, int column) {
        System.out.print("\033[" + row + ";" + column + "H");
    }

    private static void RefreshFormatter() {
        reportFormat = 
                "╔═════════════════════════════════════════════════════════════════════════╗\n" +
                "║ "+padStringLeft(72, languageModule[160][selectedLanguage])+"║\n" + 
                "║ "+padStringLeft(25, languageModule[165][selectedLanguage])+"%46s ║\n" + 
                "║ ─────────────────────────────────────────────────────────────────────── ║\n" +
                "║                                                                         ║\n" +
                "║ "+padStringLeft(31, getLanguageModuleText(166))+"%s"+centerString(17, getLanguageModuleText(171))+"║\n" +
                "║ "+padStringLeft(31, getLanguageModuleText(181))+"%s"+centerString(17, getLanguageModuleText(171))+"║\n" +
                "║ "+padStringLeft(31, getLanguageModuleText(182))+"%s"+centerString(17, getLanguageModuleText(171))+"║\n" +
                "║ "+padStringLeft(31, getLanguageModuleText(168))+"%s     Rupiah      ║\n" +
                "║                                                                         ║\n" +
                "╚═════════════════════════════════════════════════════════════════════════╝";


        labelFormat =
                "╭──────────────────────────────────────────────────────────────────────╮\n" +
                "│  "+padStringLeft(40, getLanguageModuleText(160))+"%26s  │\n" +
                "├──────────────────────────────────────────────────────────────────────┤\n" +
                "│                                                                      │\n" +
                "│  "+padStringLeft(18, getLanguageModuleText(92))+padStringLeft(34, getLanguageModuleText(155))+padStringLeft(16, getLanguageModuleText(162))+"│\n" +
                "│  %-18s%-4s Kg                           Rp.%-13s│\n" +
                "│                                                                      │\n" + 
                "│  ╭─────────────────────────────────────────────────────────────────╮ │\n" +
                "│  │"+centerString(65, getLanguageModuleText(161))+"│ │\n" +
                "│  ╰─────────────────────────────────────────────────────────────────╯ │\n" +
                "│                                                                      │\n" +
                "│   "+padStringLeft(38, getLanguageModuleText(94))+padStringLeft(29, getLanguageModuleText(93))+"│\n" +
                "│   %-38s%-29s│\n" +
                "│   %-38s%-29s│\n" +
                "│   %-38s%-29s│\n" +
                "│                                                                      │\n" +
                "├──────────────────────────────────────────────────────────────────────┤\n" +
                "│  "+padStringLeft(68, getLanguageModuleText(154))+"│\n" +
                "│  %-68s│\n" +
                "╰──────────────────────────────────────────────────────────────────────╯";

        receiptFormat =
                "╭───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────╮\n" +
                "│" + centerString(123, getLanguageModuleText(152)) + "│\n" +
                "├───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┤\n" +
                "│                         ╭──────────────────────╮                          ╭─────────────────────────────────────────────╮ │\n" +
                "│  "+padStringLeft(23, getLanguageModuleText(41))+"│ %-21s│   "+padStringLeft(23, getLanguageModuleText(153))+"│ %-44s│ │\n" +
                "│                         ╰──────────────────────╯                          ╰─────────────────────────────────────────────╯ │\n" +
                "│                         ╭──────────────────────╮                          ╭─────────────────────────────────────────────╮ │\n" +
                "│  "+padStringLeft(23, getLanguageModuleText(96))+"│ %-21s│   "+padStringLeft(23, getLanguageModuleText(177))+"│ %-44s│ │\n" +
                "│                         ╰──────────────────────╯                          ╰─────────────────────────────────────────────╯ │\n" +
                "│                         ╭──────────────────────╮                          ╭─────────────────────────────────────────────╮ │\n" +
                "│  "+padStringLeft(23, getLanguageModuleText(89))+"│ %-21s│   "+padStringLeft(23, getLanguageModuleText(40))+"│ %-44s│ │\n" +
                "│                         ╰──────────────────────╯                          ╰─────────────────────────────────────────────╯ │\n" +
                "│                         ╭──────────────────────╮                          ╭─────────────────────────────────────────────╮ │\n" +
                "│  "+padStringLeft(23, getLanguageModuleText(30))+"│ %-21s│   "+padStringLeft(23, getLanguageModuleText(177))+"│ %-44s│ │\n" +
                "│                         ╰──────────────────────╯                          ╰─────────────────────────────────────────────╯ │\n" +
                "│  ╭───────────────────────────────────────────────────╮              ╭───────────────────────────────────────────────────╮ │\n" +
                "│  │"+centerString(51, getLanguageModuleText(93))+"│              │"+centerString(51, getLanguageModuleText(94))+"│ │\n" +
                "│  ├───────────────────────────────────────────────────┤              ├───────────────────────────────────────────────────┤ │\n" +
                "│  │%s│              │%s│ │\n" +
                "│  ╰───────────────────────────────────────────────────╯              ╰───────────────────────────────────────────────────╯ │\n" +
                "│                                                                                                                           │\n" +
                "│  ╭──────────────────────────────────────────────────────────────┬───────────────────────────────────────────┬───────────╮ │\n" +
                "│  │"+centerString(62, getLanguageModuleText(154))+"│                                           │           │ │\n" +
                "│  ├──────────────────────────────────────────────────────────────┤"+centerString(43, getLanguageModuleText(157))+"│   Total   │ │\n" +
                "│  │  %-60s│                                           │           │ │\n" +
                "│  ├──────────────────────────────────────────────────────────────┼───────────────────────────────────────────┼───────────┤ │\n" +
                "│  │  %-60s│%42s │%10s │ │\n" +
                "│  ├──────────────────────────────────────────────────────────────┼───────────────────────────────────────────┼───────────┤ │\n" +
                "│  │  "+padStringLeft(60, getLanguageModuleText(156))+"│%39s km │%10s │ │\n" +
                "│  ├──────────────────────────────────────────────────────────────┼───────────────────────────────────────────┼───────────┤ │\n" +
                "│  │  "+padStringLeft(60, getLanguageModuleText(103))+"│%42s │%10s │ │\n" +
                "│  ╰──────────────────────────────────────────────────────────────┴───────────────────────────────────────────┴───────────╯ │\n" +
                "├───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┤\n" +
                "│  Total :                                                                                                       %10s │\n" +
                "├───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┤\n" +
                "│  "+padStringLeft(25, getLanguageModuleText(158))+"                                                                                     %10s │\n" +
                "├───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┤\n" +
                "│  "+padStringLeft(25, getLanguageModuleText(159))+"                                                                                     %10s │\n" +
                "╰───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────╯";

        packageDetailsFormat =
                "╭─────────────────────────────────────────────────────────────────────────╮\n" +
                "│                         ╭─────────────────────────────────────────────╮ │\n" +
                "│  "+padStringLeft(23, getLanguageModuleText(153))+"│ %-44s│ │\n" +
                "│                         ╰─────────────────────────────────────────────╯ │\n" +
                "│                         ╭─────────────────────────────────────────────╮ │\n" +
                "│  "+padStringLeft(23, getLanguageModuleText(177))+"│ %-44s│ │\n" +
                "│                         ╰─────────────────────────────────────────────╯ │\n" +
                "│                         ╭─────────────────────────────────────────────╮ │\n" +
                "│  "+padStringLeft(23, getLanguageModuleText(40))+"│ %-44s│ │\n" +
                "│                         ╰─────────────────────────────────────────────╯ │\n" +
                "│                         ╭─────────────────────────────────────────────╮ │\n" +
                "│  "+padStringLeft(23, getLanguageModuleText(177))+"│ %-44s│ │\n" +
                "│                         ╰─────────────────────────────────────────────╯ │\n" +
                "│  ╭─────────────────────────╮                ╭─────────────────────────╮ │\n" +
                "│  │"+centerString(25, getLanguageModuleText(93))+"│                │"+centerString(25, getLanguageModuleText(94))+"│ │\n" +
                "│  ├─────────────────────────┤                ├─────────────────────────┤ │\n" +
                "│  │%s│                │%s│ │\n" +
                "│  ╰─────────────────────────╯                ╰─────────────────────────╯ │\n" +
                "│                                                                         │\n" +
                "│  ╭────────────────────────────────┬───────────────────────────────────╮ │\n" +
                "│  │"+centerString(32, getLanguageModuleText(154))+"│                                   │ │\n" +
                "│  ├────────────────────────────────┤"+centerString(31, getLanguageModuleText(157))+"    │ │\n" +
                "│  │  %-30s│                                   │ │\n" +
                "│  ├────────────────────────────────┼───────────────────────────────────┤ │\n" +
                "│  │  %-30s│%34s │ │\n" +
                "│  ├────────────────────────────────┼───────────────────────────────────┤ │\n" +
                "│  │  "+padStringLeft(30, getLanguageModuleText(156))+"│%31s km │ │\n" +
                "│  ├────────────────────────────────┼───────────────────────────────────┤ │\n" +
                "│  │  "+padStringLeft(30, getLanguageModuleText(103))+"│%34s │ │\n" +
                "│  ╰────────────────────────────────┴───────────────────────────────────╯ │\n" +
                "│                                                                         │\n" +
                "╰─────────────────────────────────────────────────────────────────────────╯";

    }

    private static void viewWarehousePackageDetail(int index) {
        clearTerminal();

        System.out.println(String.format(
            packageDetailsFormat,
            historyTransaksi[index][2],
            historyTransaksi[index][3],
            historyTransaksi[index][8],
            historyTransaksi[index][22],
            centerString(25, historyTransaksi[index][13]), 
            centerString(25, historyTransaksi[index][4]),
            historyTransaksi[index][11],
            historyTransaksi[index][15],
            historyTransaksi[index][10],
            historyTransaksi[index][19],
            historyTransaksi[index][5]
        )); 
        input.nextLine();
    }

    private static void LeftBorder() {
        System.out.println("║");
    }

}
