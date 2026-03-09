/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tix;

/**
 *
 * @author Lenovo
 */
public class TiketEkonomi extends Tiket {
    

    public TiketEkonomi(String kodeTiket, Jadwal jadwal, double hargaDasar) throws DataTiketInvalidExeception {
        super(kodeTiket, jadwal, hargaDasar);
    }
    
    @Override
    public double hitungHarga(){
        return hargaDasar;
    }
}

