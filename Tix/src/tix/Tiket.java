/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tix;

/**
 *
 * @author Lenovo
 */
public abstract class Tiket {
    protected String kodeTiket;
    protected Jadwal jadwal;
    protected double hargaDasar;
    
    public Tiket(String kodeTiket, Jadwal jadwal, double hargaDasar)throws DataTiketInvalidExeception{
        if (!kodeTiket.startsWith("TIX")){
            throw new DataTiketInvalidExeception("Kde tiket harus diawali TIX");
        }
        
        if (hargaDasar <= 0) {
            throw new DataTiketInvalidExeception("Harga dasar harus lebih dari 0");
        }
        this.kodeTiket = kodeTiket;
        this.jadwal = jadwal;
        this.hargaDasar = hargaDasar;
    }
    
    public String getKodeTiket() {
        return kodeTiket;
    }
    
    public String getDetailJadwal() {
        return jadwal.getDetailJadwal();
    }
    
    public abstract double hitungHarga();
}
