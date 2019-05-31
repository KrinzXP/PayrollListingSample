package classLibrary;

import enumLibrary.*;

import java.util.*;
import java.math.*;
import java.text.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Employee {
	
	protected  Integer nomorKaryawan;
	protected  String namaDepan;
	protected  String namaBelakang;
	protected  Gender jenisKelamin;
	protected  LocalDate tanggalLahir;
	protected  String tempatLahir;
	protected  String noKtp;
	protected  String pekerjaan;
	protected  LocalDate tanggalMulaiBekerja;
	protected  String statusKaryawan;
	

	public Employee(Integer nomorKaryawan, String namaDepan, String namaBelakang, Gender jenisKelamin,
			LocalDate tanggalLahir, String tempatLahir, String noKtp, String pekerjaan, 
			LocalDate tanggalMulaiBekerja, String statusKaryawan) {
		this.nomorKaryawan = nomorKaryawan;
		this.namaDepan = namaDepan;
		this.namaBelakang = namaBelakang;
		this.jenisKelamin = jenisKelamin;
		this.tanggalLahir = tanggalLahir;
		this.tempatLahir = tempatLahir;
		this.noKtp = noKtp;
		this.pekerjaan = pekerjaan;
		this.tanggalMulaiBekerja = tanggalMulaiBekerja;
		this.statusKaryawan = statusKaryawan;
	}
	
	public int getNomorKaryawan() {
		return nomorKaryawan;
	}
	public void setNomorKaryawan(Integer nomorKaryawan) {
		this.nomorKaryawan = nomorKaryawan;
	}
	public String getNamaDepan() {
		return namaDepan;
	}
	public void setNamaDepan(String namaDepan) {
		this.namaDepan = namaDepan;
	}
	public String getNamaBelakang() {
		return namaBelakang;
	}
	public void setNamaBelakang(String namaBelakang) {
		this.namaBelakang = namaBelakang;
	}
	public Gender getJenisKelamin() {
		return jenisKelamin;
	}
	public void setJenisKelamin(Gender jenisKelamin) {
		this.jenisKelamin = jenisKelamin;
	}
	public LocalDate getTanggalLahir() {
		return tanggalLahir;
	}
	public void setTanggalLahir(LocalDate tanggalLahir) {
		this.tanggalLahir = tanggalLahir;
	}
	public String getTempatLahir() {
		return tempatLahir;
	}
	public void setTempatLahir(String tempatLahir) {
		this.tempatLahir = tempatLahir;
	}
	public String getNoKtp() {
		return noKtp;
	}
	public void setNoKtp(String noKtp) {
		this.noKtp = noKtp;
	}
	public String getPekerjaan() {
		return pekerjaan;
	}
	public void setPekerjaan(String pekerjaan) {
		this.pekerjaan = pekerjaan;
	}
	public LocalDate getTanggalMulaiBekerja() {
		return tanggalMulaiBekerja;
	}
	public void setTanggalMulaiBekerja(LocalDate tanggalMulaiBekerja) {
		this.tanggalMulaiBekerja = tanggalMulaiBekerja;
	}
	public String getStatusKaryawan() {
		return statusKaryawan;
	}
	public void setStatusKaryawan(String statusKaryawan) {
		this.statusKaryawan = statusKaryawan;
	}
	
	
	public String printEmployeeSummary()
	{
		String employeeSummary = String.format("No. Karyawan: %d, Employee Name: %s %s, "
											+ "Gender: %s, Tanggal Lahir: %s\nTempat Lahir: %s, "
											+ "Nomor KTP: %s,Pekerjaan: %s\nMulai Bekerja: %s, "
											+ "Status Karyawan: %s\n",
											nomorKaryawan, namaDepan, namaBelakang, jenisKelamin, 
											tanggalLahir.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)),
											tempatLahir, noKtp, pekerjaan, 
											tanggalMulaiBekerja.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)), statusKaryawan);
		return employeeSummary;
	}
	
	
}
	

