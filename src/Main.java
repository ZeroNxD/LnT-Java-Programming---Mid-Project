import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Main {
	
	Scanner scan = new Scanner(System.in);
	Vector<String> ListofID_Manager = new Vector(); 
	Vector<String> ListofID_Supervisor = new Vector(); 
	Vector<String> ListofID_Admin = new Vector(); 
	Vector<Data> ListofEmployee = new Vector();

	public Main() {
		int menu = 0;
		do {
			System.out.println("1. Insert Data");
			System.out.println("2. View Data");
			System.out.println("3. Update Data");
			System.out.println("4. Delete Data");
			System.out.println("5. Exit");
			System.out.print("Input Menu: ");
			menu = scan.nextInt(); scan.nextLine();
			switch(menu) {
			case(1):
				InsertData();
				break;
			case(2):
				ViewData();
				break;
			case(3):
				ChangeData();
				break;
			case(4):
				DeleteData();
				break;
			}
		} while (menu != 5);
	}

	public static void main(String[] args) {
		new Main();

	}
	
	public void InsertData() {
		Random rnd = new Random();
		String Code_Karyawan = null;
		int index = 0;
		do {
			char temp = (char) ('A' + rnd.nextInt(26));
			if(index == 0) {
				Code_Karyawan = Character.toString(temp);
				index++;
			} else if(index != 0) {
				if(Code_Karyawan.charAt(index-1)!= temp) {
					Code_Karyawan = Code_Karyawan + temp;
					index++;
				} else {
					continue;
				}
			}
		} while (index < 2);
		
		if(index == 2) {
			Code_Karyawan = Code_Karyawan + '-';
			index++;
		}
		
		do {
			int number = rnd.nextInt(10);
			Code_Karyawan = Code_Karyawan + number;
			index++;
		} while(index != 7);
		
		String nama = null;
		String Jenis_Kelamin = null;
		String Jabatan = null;
		System.out.print("Input nama karyawan [>= 3]: ");
		nama = scan.nextLine(); 
		System.out.print("Input jenis kelamin [Laki-laki | Perempuan] (Case Sensitive): ");
		Jenis_Kelamin = scan.nextLine(); 
		System.out.print("Input Jabatan [Manager | Supervisor | Admin] (Case Sensitive) : ");
		Jabatan = scan.nextLine();
		double Gaji = 0;
		if(Jabatan.contains("Manager")) {
			if(ListofID_Manager.size()%3 == 0 && ListofID_Manager.size() != 0) {
				for(int b = 0; b < ListofID_Manager.size(); b++) {
					for(int c = 0; c < ListofEmployee.size(); c++) {
						if(ListofID_Manager.get(b) == ListofEmployee.get(c).getID()) {
							double GajiTambahan = (ListofEmployee.get(c).getGaji() * 0.1) + ListofEmployee.get(c).getGaji(); 
							Data ChangeData2 = new Data(ListofEmployee.get(c).getID(), ListofEmployee.get(c).getNama(), ListofEmployee.get(c).getJenis_kelamin()
							, ListofEmployee.get(c).getJabatan(), GajiTambahan);
							ListofEmployee.set(c, ChangeData2);
						}
					}
				}
				System.out.print("Bonus sebesar 10% telah diberikan kepada karyawan dengan ID ");
				for(int d = 0; d < ListofID_Manager.size(); d++) {
					if(d != ListofID_Manager.size()-1) {
						System.out.print(ListofID_Manager.get(d) + ", ");
					} else {
						System.out.println(ListofID_Manager.get(d));
					}
				}
				Gaji = 8000000;
				ListofID_Manager.add(Code_Karyawan);
			} else {
				Gaji = 8000000;
				ListofID_Manager.add(Code_Karyawan);
			}
		} else if(Jabatan.contains("Supervisor")) {
			if(ListofID_Supervisor.size()%3 == 0 && ListofID_Supervisor.size() != 0) {
				for(int b = 0; b < ListofID_Supervisor.size(); b++) {
					for(int c = 0; c < ListofEmployee.size(); c++) {
						if(ListofID_Supervisor.get(b) == ListofEmployee.get(c).getID()) {
							double GajiTambahan = (ListofEmployee.get(c).getGaji() * 0.075) + ListofEmployee.get(c).getGaji(); 
							Data ChangeData2 = new Data(ListofEmployee.get(c).getID(), ListofEmployee.get(c).getNama(), ListofEmployee.get(c).getJenis_kelamin()
							, ListofEmployee.get(c).getJabatan(), GajiTambahan);
							ListofEmployee.set(c, ChangeData2);
						}
					}
				}
				System.out.print("Bonus sebesar 7,5% telah diberikan kepada karyawan dengan ID ");
				for(int d = 0; d < ListofID_Supervisor.size(); d++) {
					if(d != ListofID_Supervisor.size()-1) {
						System.out.print(ListofID_Supervisor.get(d) + ", ");
					} else {
						System.out.println(ListofID_Supervisor.get(d));
					}
				}
				Gaji = 6000000;
				ListofID_Supervisor.add(Code_Karyawan);
			} else {
				Gaji = 6000000;
				ListofID_Supervisor.add(Code_Karyawan);
			}
		} else if(Jabatan.contains("Admin")) {
			if(ListofID_Admin.size()%3 == 0 && ListofID_Admin.size() != 0) {
				for(int b = 0; b < ListofID_Admin.size(); b++) {
					for(int c = 0; c < ListofEmployee.size(); c++) {
						if(ListofID_Admin.get(b) == ListofEmployee.get(c).getID()) {
							double GajiTambahan = (ListofEmployee.get(c).getGaji() * 0.05) + ListofEmployee.get(c).getGaji(); 
							Data ChangeData2 = new Data(ListofEmployee.get(c).getID(), ListofEmployee.get(c).getNama(), ListofEmployee.get(c).getJenis_kelamin()
							, ListofEmployee.get(c).getJabatan(), GajiTambahan);
							ListofEmployee.set(c, ChangeData2);
						}
					}
				}
				System.out.print("Bonus sebesar 5% telah diberikan kepada karyawan dengan ID ");
				for(int d = 0; d < ListofID_Admin.size(); d++) {
					if(d != ListofID_Admin.size()-1) {
						System.out.print(ListofID_Admin.get(d) + ", ");
					} else {
						System.out.println(ListofID_Admin.get(d));
					}
				}
				Gaji = 4000000;
				ListofID_Admin.add(Code_Karyawan);
			} else {
				Gaji = 4000000;
				ListofID_Admin.add(Code_Karyawan);
			}
		}
		Data newData = new Data(Code_Karyawan, nama, Jenis_Kelamin, Jabatan, Gaji);
		ListofEmployee.add(newData);
		System.out.println("Berhasil menambahkan karyawan dengan ID " + Code_Karyawan);
	}
	
	public void ViewData() {
		if(ListofEmployee.size() == 0) {
			System.out.println("Data karyawan masih kosong");
			System.out.println("Mohon untuk menginput data karyawan");
		} else {
			System.out.format("|%4s|%15s|%30s|%15s|%15s|%15s|\n", "----", "---------------", "------------------------------", "---------------", "---------------", "---------------");
			System.out.format("|%-4s|%-15s|%-30s|%-15s|%-15s|%-15s|\n", "No", "Kode Karyawan", "Nama Karyawan", "Jenis Kelamin", "Jabatan", "Gaji Karyawan");
			System.out.format("|%4s|%15s|%30s|%15s|%15s|%15s|\n", "----", "---------------", "------------------------------", "---------------", "---------------", "---------------");
			ListofEmployee.sort(new NameComparator());
			for(int a = 0; a < ListofEmployee.size(); a++) {
				System.out.format("|%4s|%15s|%30s|%15s|%15s|%15s|\n", a+1, ListofEmployee.get(a).getID(), ListofEmployee.get(a).getNama(), ListofEmployee.get(a).getJenis_kelamin(), 
				ListofEmployee.get(a).getJabatan(), ListofEmployee.get(a).getGaji());
			}
			System.out.format("|%4s|%15s|%30s|%15s|%15s|%15s|\n", "----", "---------------", "------------------------------", "---------------", "---------------", "---------------");
		}
	}
	
	public void ChangeData() {
		if(ListofEmployee.size() == 0) {
			System.out.println("Tidak ada data untuk diganti");
		} else {
			ViewData();
			int change = 0;
			System.out.print("Input nomor urutan karyawan yang ingin diupdate: ");
			change = scan.nextInt(); scan.nextLine();
			String newID = ListofEmployee.get(change-1).getID();
			String NewName = null; 
			String JKELBaru = null; 
			String JabatanBaru = null; 
			double GajiBaru = 0;
			System.out.print("Input nama karyawan [>= 3]: ");
			NewName = scan.nextLine(); 
			System.out.print("Input jenis kelamin [Laki-laki | Perempuan] (Case Sensitive): ");
			JKELBaru = scan.nextLine(); 
			System.out.print("Input Jabatan [Manager | Supervisor | Admin] (Case Sensitive) : ");
			JabatanBaru = scan.nextLine();
			if(JabatanBaru.contains("Manager")) {
				GajiBaru = 8000000;
				ListofID_Manager.add(newID);
				if(ListofEmployee.get(change-1).getJabatan().contains("Supervisor")) {
					for(int h = 0; h < ListofID_Supervisor.size(); h++) {
						if(newID == ListofID_Supervisor.get(h)) {
							ListofID_Supervisor.remove(h);
						}
					}
				} else if(ListofEmployee.get(change-1).getJabatan().contains("Admin")) {
					for(int i = 0; i < ListofID_Admin.size(); i++) {
						if(newID == ListofID_Admin.get(i)) {
							ListofID_Admin.remove(i);
						}
					}
				}
			} else if(JabatanBaru.contains("Supervisor")) {
				GajiBaru = 6000000;
				ListofID_Supervisor.add(newID);
				if(ListofEmployee.get(change-1).getJabatan().contains("Manager")) {
					for(int j = 0; j < ListofID_Manager.size(); j++) {
						if(newID == ListofID_Manager.get(j)) {
							ListofID_Manager.remove(j);
						}
					}
				} else if(ListofEmployee.get(change-1).getJabatan().contains("Admin")) {
					for(int k = 0; k < ListofID_Admin.size(); k++) {
						if(newID == ListofID_Admin.get(k)) {
							ListofID_Admin.remove(k);
						}
					}
				}
			} else if(JabatanBaru.contains("Admin")) {
				GajiBaru = 4000000;
				ListofID_Admin.add(newID);
				if(ListofEmployee.get(change-1).getJabatan().contains("Supervisor")) {
					for(int l = 0; l < ListofID_Supervisor.size(); l++) {
						if(newID == ListofID_Supervisor.get(l)) {
							ListofID_Supervisor.remove(l);
						}
					}
				} else if(ListofEmployee.get(change-1).getJabatan().contains("Manager")) {
					for(int m = 0; m < ListofID_Manager.size(); m++) {
						if(newID == ListofID_Manager.get(m)) {
							ListofID_Manager.remove(m);
						}
					}
				}
			}
			Data ChangeData1 = new Data(newID, NewName, JKELBaru, JabatanBaru, GajiBaru);
			ListofEmployee.set(change-1, ChangeData1);
			System.out.println("Berhasil mengupdate karyawan dengan ID " + newID);
		}
	}
	
	public void DeleteData() {
		if(ListofEmployee.size() == 0) {
			System.out.println("Tidak ada data yang bisa dihapus");
		} else {
			ViewData();
			int DeleteIndex;
			System.out.print("Input nomor urutan karyawan yang ingin dihapus: ");
			DeleteIndex = scan.nextInt(); scan.nextLine();
			String IDIndex = ListofEmployee.get(DeleteIndex-1).getID();
			String JabatanDelete = ListofEmployee.get(DeleteIndex-1).getJabatan();
			
			if(JabatanDelete.contains("Manager")) {
				for(int e = 0; e < ListofID_Manager.size(); e++) {
					if(IDIndex == ListofID_Manager.get(e)) {
						ListofID_Manager.remove(e);
					}
				}
			} else if(JabatanDelete.contains("Supervisor")) {
				for(int f = 0; f < ListofID_Supervisor.size(); f++) {
					if(IDIndex == ListofID_Supervisor.get(f)) {
						ListofID_Supervisor.remove(f);
					}
				}
			} else if(JabatanDelete.contains("Admin")) {
				for(int g = 0; g < ListofID_Admin.size(); g++) {
					if(IDIndex == ListofID_Admin.get(g)) {
						ListofID_Admin.remove(g);
					}
				}
			}
			ListofEmployee.remove(DeleteIndex-1);
			System.out.println("Karyawan dengan kode " + IDIndex + " berhasil dihapus");
		}
	}
	
	static public class NameComparator implements Comparator<Data>{

		@Override
		public int compare(Data o1, Data o2) {
			return o1.getNama().compareTo(o2.getNama());
		}
		
	}
}
