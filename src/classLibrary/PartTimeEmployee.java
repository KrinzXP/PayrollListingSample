package classLibrary;

import java.util.*;
import java.math.*;
import java.text.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import enumLibrary.*;

public class PartTimeEmployee extends Employee{
	private BigDecimal gajiPerHari;
	private int totalHariBekerjaPerBulan;
	

//	public PartTimeEmployee(int nomorKaryawan, String namaDepan, String namaBelakang, Gender jenisKelamin,
//			LocalDate tanggalLahir, String tempatLahir, String noKtp, String pekerjaan, String statusKaryawan,
//			BigDecimal gajiPerHari, int totalHariBekerjaPerBulan) {
//		super(nomorKaryawan, namaDepan, namaBelakang, jenisKelamin, tanggalLahir, tempatLahir, noKtp, pekerjaan,
//				tanggalLahir, statusKaryawan);
//		// TODO Auto-generated constructor stub
//	}

	public PartTimeEmployee(int nomorKaryawan, String namaDepan, String namaBelakang, Gender jenisKelamin,
			LocalDate tanggalLahir, String tempatLahir, String noKtp, String pekerjaan, LocalDate tanggalMulaiBekerja,
			String statusKaryawan, BigDecimal inputGaji, int totalHari) {
		// TODO Auto-generated constructor stub
		super(nomorKaryawan, namaDepan, namaBelakang, jenisKelamin, tanggalLahir, tempatLahir, noKtp, pekerjaan,
				tanggalLahir, statusKaryawan);
	}

	public BigDecimal getGajiPerHari() {
		return gajiPerHari;
	}

	public void setGajiPerHari(BigDecimal gajiPerHari) {
		this.gajiPerHari = gajiPerHari;
	}

	public int getTotalHariBekerjaPerBulan() {
		return totalHariBekerjaPerBulan;
	}

	public void setTotalHariBekerjaPerBulan(int totalHariBekerjaPerBulan) {
		this.totalHariBekerjaPerBulan = totalHariBekerjaPerBulan;
	}
	
	public String printEmployeePartTimeSummary()
	{
		String employeeSummary = String.format("No. Karyawan: %d, Employee Name: %s %s, "
											+ "Gender: %s, Tanggal Lahir: %s\nTempat Lahir: %s, "
											+ "Nomor KTP: %s,Pekerjaan: %s\nMulai Bekerja: %s, "
											+ "Status Karyawan: %s, Gaji Pokok: %s, Tunjangan: %d%% \n",
											nomorKaryawan, namaDepan, namaBelakang, jenisKelamin, 
											tanggalLahir.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)), tempatLahir,
											noKtp, pekerjaan, tanggalMulaiBekerja.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)), 
											statusKaryawan, gajiPerHari, totalHariBekerjaPerBulan);
		return employeeSummary;
	}
}
