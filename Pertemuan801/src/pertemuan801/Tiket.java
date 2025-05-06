/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pertemuan801;

import java.util.Scanner;

/**
 *
 * @author Ayu sawitri
 */
public class Tiket {
    private String nama,noTiket,tanggal;

     public Tiket(String nama, String noTiket, String tanggal) {
        this.nama = nama;
        this.noTiket = noTiket;
        this.tanggal = tanggal;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNoTiket() {
        return noTiket;
    }

    public void setNoTiket(String noTiket) {
        this.noTiket = noTiket;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    @Override
    public String toString() {
        return "Tiket [nama=" + nama + ", noTiket=" + noTiket + ", tanggal=" + tanggal + "]";
    }
}

class AplikasiTiket {
    private Tiket[] dataTiket;
    private int jumlahTiket;
    private Scanner input;

    public AplikasiTiket() {
        dataTiket = new Tiket[100];
        jumlahTiket = 0;
        input = new Scanner(System.in);
    }

    public void menuAplikasi() {
        int pilihan = 0;

        do {
            System.out.println("Menu Aplikasi Tiket");
            System.out.println("1. Tambah Tiket");
            System.out.println("2. Tampilkan Tiket");
            System.out.println("3. Ubah Tiket");
            System.out.println("4. Hapus Tiket");
            System.out.println("0. Keluar");
            System.out.print("Pilihan: ");
            pilihan = input.nextInt();

            switch (pilihan) {
                case 1:
                    tambahTiket();
                    break;
                case 2:
                    tampilkanTiket();
                    break;
                case 3:
                    ubahTiket();
                    break;
                case 4:
                    hapusTiket();
                    break;
                case 0:
                    System.out.println("Keluar dari Aplikasi Tiket");
                    break;
                default:
                    System.out.println("Pilihan tidak valid");
            }
        } while (pilihan != 0);
    }

    public void tambahTiket() {
        System.out.print("Masukkan nama: ");
        String nama = input.next();
        System.out.print("Masukkan nomor tiket: ");
        String noTiket = input.next();
        System.out.print("Masukkan tanggal tiket: ");
        String tanggal = input.next();

        Tiket tiket = new Tiket(nama, noTiket, tanggal);
        dataTiket[jumlahTiket] = tiket;
        jumlahTiket++;
        System.out.println("Tiket berhasil ditambahkan");
    }

    public void tampilkanTiket() {
        System.out.println("Daftar Tiket:");
        for (int i = 0; i < jumlahTiket; i++) {
            System.out.println((i + 1) + ". " + dataTiket[i]);
        }
    }

    public void ubahTiket() {
        tampilkanTiket();
        System.out.print("Pilih nomor tiket yang ingin diubah: ");
        int index = input.nextInt();
        if (index > 0 && index <= jumlahTiket) {
            System.out.print("Masukkan nama baru: ");
            String nama = input.next();
            System.out.print("Masukkan nomor tiket baru: ");
            String noTiket = input.next();
            System.out.print("Masukkan tanggal tiket baru: ");
            String tanggal = input.next();

            dataTiket[index - 1].setNama(nama);
            dataTiket[index - 1].setNoTiket(noTiket);
            dataTiket[index - 1].setTanggal(tanggal);
            System.out.println("Tiket berhasil diubah");
        } else {
            System.out.println("Nomor tiket tidak valid");
        }
    }

    public void hapusTiket() {
        tampilkanTiket();
        System.out.print("Pilih nomor tiket yang ingin dihapus: ");
        int index = input.nextInt();
        if (index > 0 && index <= jumlahTiket) {
            for (int i = index - 1; i < jumlahTiket - 1; i++) {
                dataTiket[i] = dataTiket[i + 1];
            }
            jumlahTiket--;
            System.out.println("Tiket berhasil dihapus");
        } else {
            System.out.println("Nomor tiket tidak valid");
        }
    }
}