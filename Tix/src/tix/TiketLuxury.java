/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tix;

/**
 *
 * @author Lenovo
 */
public class TiketLuxury extends Tiket implements LayananEksklusif {
        public TiketLuxury(String kodeTiket, Jadwal jadwal, double hargaDasar) throws DataTiketInvalidExeception {
        super(kodeTiket, jadwal, hargaDasar);
    }
        
        @Override
    public double hitungHarga() {
        return hargaDasar + 150000;
    }
    
        @Override
    public String getFasilitasTambahan() {
        return "Makan siang dan Kursi Sleeper";
    }
}
