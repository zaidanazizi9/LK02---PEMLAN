package sem2.oop;

import java.util.Scanner;

class Kendaraan {
    public String platNomor;
    public int jumlahPenumpang;
    public int maxPenumpang;
    public Driver supir;

    public Kendaraan(String platNomor, int maxPenumpang) {
        this.platNomor = platNomor;
        this.jumlahPenumpang = 0;
        this.maxPenumpang = maxPenumpang;
    }
    public void penumpangNaik(int naik) {
        int current = this.jumlahPenumpang;
        if (current + naik > this.maxPenumpang) {
            System.out.println("Maaf, penumpang melebihi kapasitas.");
        } else {
            this.jumlahPenumpang += naik;
            System.out.println("Penumpang berhasil naik sebanyak " + naik);
        }
        cekPenumpang();
    }
    public void penumpangNaik(int naik, String jenisPenumpang) {
        int current = this.jumlahPenumpang;
        if (current + naik > this.maxPenumpang) {
            System.out.println("Maaf, penumpang melebihi kapasitas.");
        } else {
            this.jumlahPenumpang += naik;
            System.out.println("Penumpang " + jenisPenumpang + " berhasil naik sebanyak " + naik);
        }
        cekPenumpang();
    }
    public void penumpangTurun(int turun) {
        int current = this.jumlahPenumpang;
        if (current - turun < 0) {
            System.out.println("Tidak ada penumpang yang bisa turun.");
        } else {
            this.jumlahPenumpang -= turun;
            System.out.println("Penumpang berhasil turun sebanyak " + turun);
        }
        cekPenumpang();
    }
    public void showPlatNomor() {
        System.out.println("Kendaraan dengan plat nomor: " + this.platNomor);
    }
    public void showNamaDriver() {
        System.out.println("Driver anda bernama: " + this.supir.nama);
    }
    public void cekPenumpang() {
        System.out.println("Jumlah penumpang saat ini: " + this.jumlahPenumpang);
    }
}

class Driver {
    public String nama;
    public int no_SIM;

    public Driver(String nama) {
        this.nama = nama;
    }
    public void setno_SIM(int no_SIM) {
        this.no_SIM = no_SIM;
    }
}

class Truk extends Kendaraan {
    private int kapasitasMuatan;
    private String jenisMuatan;

    public Truk(String platNomor, int kapasitasMuatan, String jenisMuatan, int maxPenumpang) {
        super(platNomor, maxPenumpang);
        this.kapasitasMuatan = kapasitasMuatan;
        this.jenisMuatan = jenisMuatan;
    }
    public void setKapasitasMuatan(int kapasitasMuatan) {
        this.kapasitasMuatan = kapasitasMuatan;
    }
    public int getKapasitasMuatan() {
        return kapasitasMuatan;
    }
    public String getJenisMuatan() {
        return jenisMuatan;
    }
    public void bakTumpah() {
        System.out.println("Bak truk tumpah");
    }
}

class Bus extends Kendaraan {
    private boolean isToilet;
    private int jumlahPintu;

    public Bus(String platNomor, boolean isToilet, int jumlahPintu, int maxPenumpang) {
        super(platNomor, maxPenumpang);
        this.isToilet = isToilet;
        this.jumlahPintu = jumlahPintu;
    }
    public void setToilet(boolean isToilet) {
        this.isToilet = isToilet;
    }
    public boolean isToilet() {
        return isToilet;
    }
    public int getJumlahPintu() {
        return jumlahPintu;
    }
    public void Telolet() {
        System.out.println(")))TELOLET((( )))TELOLET((( )))TELOLET(((");
    }
}

public class AppKendaraan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pilihanKendaraan = 0;
        int pilihan = 0;

        System.out.println("Selamat datang di Program Kendaraan!");
        while (pilihanKendaraan != 1 && pilihanKendaraan != 2) {
            System.out.println("\nPilih jenis kendaraan:");
            System.out.println("1. Bus");
            System.out.println("2. Truk");
            System.out.print("\nPilihan Anda: ");
            pilihanKendaraan = scanner.nextInt();
            scanner.nextLine();

            if (pilihanKendaraan != 1 && pilihanKendaraan != 2) {
                System.out.println("\nPilihan tidak valid. Silakan pilih 1 atau 2.");
            }
        }

        if (pilihanKendaraan == 1) {
            Bus bus = new Bus("A 1234 BC", true, 3 , 40);
            Driver s1 = new Driver("Joko Santoso");
            bus.supir = s1;
            bus.showNamaDriver();
            bus.showPlatNomor();
            bus.isToilet();
            while (pilihan != 4) {
                System.out.println("\nMenu:");
                System.out.println("1. Naik Penumpang");
                System.out.println("2. Turun Penumpang");
                System.out.println("3. Cek Jumlah Penumpang");
                System.out.println("4. Keluar");
                System.out.print("\nPilihan Anda: ");
                pilihan = scanner.nextInt();
                switch (pilihan) {
                    case 1:
                    System.out.println("\nPilih jenis penumpang:");
                    System.out.println("1. Dewasa");
                    System.out.println("2. Anak-anak");
                    System.out.print("\nPilihan Anda: ");
                    int pilihanPenumpang = scanner.nextInt();
                    System.out.print("Masukkan jumlah penumpang yang akan naik: ");
                    int naik = scanner.nextInt();
                    switch (pilihanPenumpang) {
                        case 1:
                            bus.penumpangNaik(naik, "dewasa");
                            break;
                        case 2:
                            bus.penumpangNaik(naik, "anak-anak");
                            break;
                        default:
                            System.out.println("Pilihan tidak valid.");
                    }
                        break;
                    case 2:
                        System.out.print("Masukkan jumlah penumpang yang akan turun: ");
                        int turun = scanner.nextInt();
                        bus.penumpangTurun(turun);
                        break;
                    case 3:
                        bus.cekPenumpang();
                        break;
                    case 4:
                        System.out.println("Terima kasih telah menggunakan Program Kendaraan!");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid. Silakan pilih antara 1-4.");
                }
            }
    
        } else if (pilihanKendaraan == 2) {
            Truk truk = new Truk("X 1234 YZ", 400, "Pasir", 2);
            Driver s2 = new Driver("Budi Santoso");
            truk.supir = s2;
            truk.showNamaDriver();
            truk.showPlatNomor();
            System.out.println("Kapasitas muatan truk: " + truk.getKapasitasMuatan() + " ton");
            System.out.println("Truk sedang mengangkut: " + truk.getJenisMuatan());
            while (pilihan != 4) {
                System.out.println("\nMenu:");
                System.out.println("1. Naik Penumpang");
                System.out.println("2. Turun Penumpang");
                System.out.println("3. Cek Jumlah Penumpang");
                System.out.println("4. Keluar");
                System.out.print("Pilihan Anda: ");
                pilihan = scanner.nextInt();
                switch (pilihan) {
                    case 1:
                    System.out.println("\nPilih jenis penumpang:");
                    System.out.println("1. Dewasa");
                    System.out.println("2. Anak-anak");
                    System.out.print("\nPilihan Anda: ");
                    int pilihanPenumpang = scanner.nextInt();
                    System.out.print("Masukkan jumlah penumpang yang akan naik: ");
                    int naik = scanner.nextInt();
                    switch (pilihanPenumpang) {
                        case 1:
                            truk.penumpangNaik(naik, "dewasa");
                            break;
                        case 2:
                            truk.penumpangNaik(naik, "anak-anak");
                            break;
                        default:
                            System.out.println("Pilihan tidak valid.");
                    }
                        break;
                    case 2:
                        System.out.print("Masukkan jumlah penumpang yang akan turun: ");
                        int turun = scanner.nextInt();
                        truk.penumpangTurun(turun);
                        break;
                    case 3:
                        truk.cekPenumpang();
                        break;
                    case 4:
                        System.out.println("Terima kasih telah menggunakan Program Kendaraan!");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid. Silakan pilih antara 1-4.");
                }
            }
        }
        scanner.close();
    }
}
