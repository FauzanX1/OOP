/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tix;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Lenovo
 */
public class Tix {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        ArrayList<Tiket> daftarTiket = new ArrayList<>();
        
        String lanjut = "y";
        
        while (lanjut.equalsIgnoreCase("y") && daftarTiket.size() < 100) {
            try{
                System.out.println("Kode Booking (Awali 'TIX')");
                String kode = input.nextLine();
                
                System.out.println("Tanggal (DD/MM/YYYY)");
                String tanggal = input.nextLine();
                
                System.out.println("Waktu Keberangkatan: ");
                String waktu = input.nextLine();
                
                System.out.println("Stasiun Tujuan: ");
                String tujuan = input.nextLine();
                
                System.out.println("Harga Dasar (Rp): ");
                double harga = Double.parseDouble(input.nextLine());
                
                System.out.println("Kelas (1. Eko, 2.Eks, 3.Lux): ");
                int kelas = Integer.parseInt(input.nextLine());
                
                Jadwal jadwal = new Jadwal(tanggal, waktu, tujuan);
                Tiket tiket = null;
                
                if (kelas == 1) {
                    tiket = new TiketEkonomi(kode, jadwal, harga);
                } 
                else if (kelas == 2) {
                    tiket = new TiketEksekutif(kode, jadwal, harga);
                } 
                else if (kelas == 3) {
                    tiket = new TiketLuxury(kode, jadwal, harga);
                }

                daftarTiket.add(tiket);

                System.out.println("[INFO] Tiket berhasil diterbitkan.");
            } catch (DataTiketInvalidException e) {

                System.out.println("[DITOLAK] " + e.getMessage());

            } catch (Exception e) {

                System.out.println("[ERROR SISTEM] Input harga/kelas harus berupa angka!");

            }
            System.out.print("Cetak tiket lain? (y/n): ");
            lanjut = input.nextLine();

        }
         System.out.println("\n==============================");
        System.out.println("REKAPITULASI TIKET");
        System.out.println("==============================");

        if (daftarTiket.isEmpty()) {

            System.out.println("Belum ada tiket yang diterbitkan.");

        } else {

            for (Tiket t : daftarTiket) {

                System.out.println("Kode Booking : " + t.getKodeTiket());
                System.out.println("Jadwal : " + t.getDetailJadwal());
                System.out.println("Total Harga : Rp " + t.hitungHarga());

                if (t instanceof LayananEksklusif) {
                    System.out.println("Fasilitas : "
                            + ((LayananEksklusif) t).getFasilitasTambahan());
                }

                System.out.println("----------------------------");
            }
        }

        System.out.println("Sesi loket diakhiri.");
    }
        
    }
    
}
