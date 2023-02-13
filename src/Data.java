
public class Data{
	
	private String ID;
	private String nama;
	private String jenis_kelamin;
	private String jabatan;
	private double gaji;
	
	public Data(String ID, String Nama, String jenis, String jab, double gaji) {
		this.ID = ID;
		this.nama = Nama;
		this.jenis_kelamin = jenis;
		this.jabatan = jab;
		this.gaji = gaji;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getJenis_kelamin() {
		return jenis_kelamin;
	}

	public void setJenis_kelamin(String jenis_kelamin) {
		this.jenis_kelamin = jenis_kelamin;
	}

	public String getJabatan() {
		return jabatan;
	}

	public void setJabatan(String jabatan) {
		this.jabatan = jabatan;
	}

	public double getGaji() {
		return gaji;
	}

	public void setGaji(int gaji) {
		this.gaji = gaji;
	}

	
}