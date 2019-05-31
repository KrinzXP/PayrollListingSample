package classLibrary;

import java.util.*;
import java.math.*;
import java.text.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import enumLibrary.Gender;

public class FullTimeEmployee extends Employee{
	
	private BigDecimal gajiPokokPerBulan;
	private int persentaseTunjangan;

	public FullTimeEmployee(int nomorKaryawan, String namaDepan, String namaBelakang, Gender jenisKelamin,
			LocalDate tanggalLahir, String tempatLahir, String noKtp, String pekerjaan, LocalDate tanggalMulaiBekerja,
			String statusKaryawan, BigDecimal inputGaji, int percentage) {
		super(nomorKaryawan, namaDepan, namaBelakang, jenisKelamin, tanggalLahir, tempatLahir, noKtp, pekerjaan,
				tanggalMulaiBekerja, statusKaryawan);
		// TODO Auto-generated constructor stub
	}

	public BigDecimal getGajiPokokPerBulan() {
		return gajiPokokPerBulan;
	}
	public void setGajiPokokPerBulan(BigDecimal gajiPokokPerBulan) {
		this.gajiPokokPerBulan = gajiPokokPerBulan;
	}
	public int getPersentaseTunjangan() {
		return persentaseTunjangan;
	}
	public void setPersentaseTunjangan(int persentaseTunjangan) {
		this.persentaseTunjangan = persentaseTunjangan;
	}
	
	public String printEmployeeFullTimeSummary()
	{
		String employeeSummary = String.format("No. Karyawan: %d, Employee Name: %s %s, "
											+ "Gender: %s, Tanggal Lahir: %s\nTempat Lahir: %s, "
											+ "Nomor KTP: %s,Pekerjaan: %s\nMulai Bekerja: %s, "
											+ "Status Karyawan: %s, Gaji Pokok: %s, Tunjangan: %d%% \n",
											nomorKaryawan, namaDepan, namaBelakang, jenisKelamin, 
											tanggalLahir.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)), tempatLahir,
											noKtp, pekerjaan, tanggalMulaiBekerja.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)), 
											statusKaryawan, gajiPokokPerBulan, persentaseTunjangan);
		return employeeSummary;
	}
	

}
