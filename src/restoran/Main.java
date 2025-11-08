package restoran;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Menu[] makanan = { new Menu("Nasi Padang", 25000, "Makanan"), new Menu("Ayam Bakar", 30000, "Makanan"),
				new Menu("Sate Ayam", 20000, "Makanan"), new Menu("Nasi Goreng", 22000, "Makanan") };

		Menu[] minuman = { new Menu("Es Teh", 5000, "Minuman"), new Menu("Jus Alpukat", 12000, "Minuman"),
				new Menu("Es Jeruk", 8000, "Minuman"), new Menu("Kopi Hitam", 10000, "Minuman") };

		Scanner input = new Scanner(System.in);
		System.out.println("===== MENU RESTORAN =====");
		System.out.println("Makanan:");
		for (int i = 0; i < makanan.length; i++) {
			System.out.println((i + 1) + ". " + makanan[i].nama + " - Rp" + makanan[i].harga);
		}
		System.out.println("\nMinuman:");
		for (int i = 0; i < minuman.length; i++) {
			System.out.println((i + 1) + ". " + minuman[i].nama + " - Rp" + minuman[i].harga);
		}

		System.out.println("\nMasukkan pesanan (maks 4 menu):");
		double total = 0;
		String pesanan = "";

		for (int i = 0; i < 4; i++) {
			System.out.print("Nama menu (atau ketik 'selesai'): ");
			String namaMenu = input.nextLine();

			if (namaMenu.equalsIgnoreCase("selesai"))
				break;

			System.out.print("Jumlah: ");
			int jumlah = Integer.parseInt(input.nextLine());

			boolean found = false;

			for (Menu m : makanan) {
				if (m.nama.equalsIgnoreCase(namaMenu)) {
					total += m.harga * jumlah;
					pesanan += m.nama + " x" + jumlah + " = Rp" + (m.harga * jumlah) + "\n";
					found = true;
					break;
				}
			}

			for (Menu m : minuman) {
				if (m.nama.equalsIgnoreCase(namaMenu)) {
					total += m.harga * jumlah;
					pesanan += m.nama + " x" + jumlah + " = Rp" + (m.harga * jumlah) + "\n";
					found = true;
					break;
				}
			}

			if (!found) {
				System.out.println("Menu tidak ditemukan!");
			}
		}

		double pajak = total * 0.1;
		double biayaPelayanan = 20000;
		double diskon = 0;
		boolean dapatGratisMinuman = false;

		if (total > 100000) {
			diskon = total * 0.1;
		} else if (total > 50000) {
			dapatGratisMinuman = true;
		}

		double totalAkhir = total + pajak + biayaPelayanan - diskon;

		System.out.println("\n===== STRUK PEMBAYARAN =====");
		System.out.println(pesanan);
		System.out.println("Subtotal: Rp" + total);
		System.out.println("Pajak (10%): Rp" + pajak);
		System.out.println("Biaya Pelayanan: Rp" + biayaPelayanan);

		if (diskon > 0) {
			System.out.println("Diskon 10%: -Rp" + diskon);
		}
		if (dapatGratisMinuman) {
			System.out.println("Promo: Beli satu gratis satu (kategori minuman)");
		}

		System.out.println("Total Akhir: Rp" + totalAkhir);
		System.out.println("============================");
		input.close();
	}

}
