import java.util.Scanner;

public class Transaksi{
    public static void Transaction() {
        //inisialisasi
        Scanner input = new Scanner(System.in);
        int beratBarang, jarak;
        double tarifDasar =10000, tarifDasarKg =1000, tarifDasarKm =2000;
        double biayaBerat, biayaJarak, biayaTotal, jumlahBarang, biayaAkhir=0;

        System.out.print("Masukkan jumlah barang: ");
        jumlahBarang = input.nextInt();

        int i = 0;
        //melakukan perulangan sesuai jumlah barang yang akan dikirim
        while (i < jumlahBarang) {
            System.out.print ("Masukkan berat barang ke-" + (i+1) + ": ");
            beratBarang = input.nextInt();
            System.out.print ("Masukkan jarak pengiriman barang ke-" + (i+1) + ": ");
            jarak = input.nextInt();
            i++;
            //menentukan harga berdasarkan data yang telah diinputkan
            if(beratBarang <= 5){
                biayaBerat=0;
            }else{
                biayaBerat=(beratBarang-5)*tarifDasarKg;
            }
            if(jarak <= 100){
                biayaJarak=0;
            }else{
                biayaJarak=(jarak-100)*tarifDasarKm;
            }
            biayaTotal = tarifDasar+biayaBerat+biayaJarak;
            biayaAkhir += biayaTotal;
        }
        System.out.println("estimasi biaya pengiriman: " +biayaAkhir);
    }
}
