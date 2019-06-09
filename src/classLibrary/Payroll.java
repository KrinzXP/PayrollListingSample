package classLibrary;

import java.util.*;
import java.math.*;
import java.text.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

import enumLibrary.Gender;

public class Payroll {
	
	private static Scanner scanner = new Scanner(System.in);
	
	private static HashMap<Integer ,Employee> employeeList = new HashMap<Integer ,Employee>();
	private static HashMap<Integer, FullTimeEmployee> fullTimeEmployeeList = new HashMap<Integer, FullTimeEmployee>();
	private static HashMap<Integer, PartTimeEmployee> partTimeEmployeeList = new HashMap<Integer, PartTimeEmployee>();
	
	//Method to Register Employee
	public static void addEmployee()
	{
		Gender jenisKelamin = null;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
		
		System.out.println("Input Nama Depan: ");
		String namaDepan = scanner.nextLine();
		
		System.out.println("Input Nama Belakang: ");
		String namaBelakang = scanner.nextLine();
		
		
		System.out.println("Input Jenis Kelamin (L/P): ");
		String gender = scanner.nextLine().trim();
		
		if(gender.equalsIgnoreCase("L"))
		{
			jenisKelamin = Gender.MALE;
		}
		else if(gender.equalsIgnoreCase("P"))
		{
			jenisKelamin = Gender.FEMALE;
		}
		else
		{
			System.out.println("Salah Input. Harap Masukkan L/P");
			addEmployee();
		}
		
		System.out.println("Input Tanggal Lahir (e.g. 19 February 2019): ");
		String tanggalLahir = scanner.nextLine();
		
		LocalDate date = LocalDate.parse(tanggalLahir, formatter);
		
		System.out.println("Input Tempat Lahir: ");
		String tempatLahir = scanner.nextLine();
		
		System.out.println("Input Nomor KTP: ");
		String nomorKtp = scanner.nextLine();
		
		System.out.println("Input Pekerjaan: ");
		String pekerjaan = scanner.nextLine();
		
		System.out.println("Input Tanggal Mulai Kerja (e.g. 19 February 2019): ");
		String tanggalMulaiKerja = scanner.nextLine();
		LocalDate startDate = LocalDate.parse(tanggalMulaiKerja, formatter);
		
		
		Employee employeeDetail = new Employee(null, namaDepan, namaBelakang, jenisKelamin, date, tempatLahir, nomorKtp,
				pekerjaan, startDate, "Not Set");
		
		int karyawanID = employeeList.size() + 1;
		employeeDetail.setNomorKaryawan(karyawanID);
		
		employeeList.put(karyawanID, employeeDetail);
		
	}
	
	//Set Employee Status 
	public static void setEmployeeStatus()
	{
		if(employeeList.size() == 0)
		{
			System.out.println("Tidak Ada Employee");
		}
		else
		{
			System.out.println("Status Employee Menjadi Full Time Atau Part Time?");
			String inputStatus = scanner.nextLine();
			
			if(inputStatus.equalsIgnoreCase("Full Time"))
			{
				setEmployeeFullTime();
			}
			else if(inputStatus.equalsIgnoreCase("Part Time"))
			{
				setEmployeePartTime();
			}
			else 
			{
				System.out.println("Input salah. Masukkan \"Full Time\" atau \"Part Time\" ");
				setEmployeeStatus();
			}
		}
		
		

	}
	
	public static void setEmployeeFullTime()
	{
		System.out.println("Input Nomor Employee yang hendak dijadikan Full Time Employee");
		int inputNomorEmployee = scanner.nextInt();
		scanner.nextLine();
		if(inputNomorEmployee <= 0 || inputNomorEmployee > employeeList.size())
		{
			System.out.println("Employee tidak ditemukan");
			setEmployeeStatus();
		}
		
		Employee obtainedEmployee = employeeList.get(inputNomorEmployee);
		
		
		
		System.out.println("Input Gaji Per Bulan Employee ini");
		BigDecimal inputGaji = scanner.nextBigDecimal();
		scanner.nextLine();
		System.out.println("Input Persentase Tunjangan Employee Ini");
		int percentage = scanner.nextInt();
		scanner.nextLine();
		
		FullTimeEmployee newFullTime = new FullTimeEmployee(obtainedEmployee.getNomorKaryawan(), obtainedEmployee.getNamaDepan(), obtainedEmployee.getNamaBelakang(), 
				obtainedEmployee.getJenisKelamin(), obtainedEmployee.getTanggalLahir(), obtainedEmployee.getTempatLahir(),
				obtainedEmployee.getNoKtp(), obtainedEmployee.getPekerjaan(), obtainedEmployee.getTanggalMulaiBekerja(),
				obtainedEmployee.getStatusKaryawan(), inputGaji, percentage);
		
		newFullTime.setStatusKaryawan("Full Time");
		newFullTime.setGajiPokokPerBulan(inputGaji);
		newFullTime.setPersentaseTunjangan(percentage);
		
		obtainedEmployee.setStatusKaryawan("Full Time Employee");
		employeeList.replace(obtainedEmployee.getNomorKaryawan(), obtainedEmployee);
		
		int generateKey = fullTimeEmployeeList.size() + 1;
		fullTimeEmployeeList.put(generateKey, newFullTime);
		
	}
	
	public static void setEmployeePartTime()
	{
		System.out.println("Input Nomor Employee yang hendak dijadikan Part Time Employee");
		int inputNomorEmployee = scanner.nextInt();
		scanner.nextLine();
		Employee obtainedEmployee = employeeList.get(inputNomorEmployee);

		System.out.println("Input Gaji Per Hari Employee ini");
		BigDecimal inputGaji = scanner.nextBigDecimal();
		scanner.nextLine();
		
		System.out.println("Input Total Hari Bekerja Employee Ini");
		int totalHari = scanner.nextInt();
		scanner.nextLine();
		
		PartTimeEmployee newPartTime = new PartTimeEmployee(obtainedEmployee.getNomorKaryawan(), obtainedEmployee.getNamaDepan(), obtainedEmployee.getNamaBelakang(), 
				obtainedEmployee.getJenisKelamin(), obtainedEmployee.getTanggalLahir(), obtainedEmployee.getTempatLahir(),
				obtainedEmployee.getNoKtp(), obtainedEmployee.getPekerjaan(), obtainedEmployee.getTanggalMulaiBekerja(),
				obtainedEmployee.getStatusKaryawan(), inputGaji, totalHari);
		
		newPartTime.setStatusKaryawan("Part Time");
		newPartTime.setGajiPerHari(inputGaji);
		newPartTime.setTotalHariBekerjaPerBulan(totalHari);
		
		obtainedEmployee.setStatusKaryawan("Part Time Employee");
		employeeList.replace(obtainedEmployee.getNomorKaryawan(), obtainedEmployee);
		
		int generateKey = partTimeEmployeeList.size() + 1;
		partTimeEmployeeList.put(generateKey, newPartTime);
		
	}
	
	//Printing Methods
	public static void printEmployeeList()
	{
		if(employeeList.size() == 0)
		{
			System.out.println("Tidak ada Employee");
		}
		else
		{
			for (Employee staff : employeeList.values())
			{
				System.out.println(staff.printEmployeeSummary());
			}
		}
		
	}
	
	public static void printFullTimeEmployeeList()
	{
		if(fullTimeEmployeeList.size() == 0)
		{
			System.out.println("Tidak ada Full Time Employee");
		}
		else
		{
			for (FullTimeEmployee fullTimeStaff : fullTimeEmployeeList.values())
			{
				System.out.println(fullTimeStaff.printEmployeeFullTimeSummary());
			}
		}
	}
	
	public static void printPartTimeEmployeeList()
	{
		if(partTimeEmployeeList.size() == 0)
		{
			System.out.println("Tidak ada Part Time Employee");
		}
		else
		{
			for (PartTimeEmployee partTimeStaff : partTimeEmployeeList.values())
			{
				System.out.println(partTimeStaff.printEmployeePartTimeSummary());
			}
		}
	}
	
	public static void printDetailGajiFullTime()
	{
		System.out.println("Tekan Enter untuk lihat Gaji");
		scanner.nextLine();
		for(FullTimeEmployee fullTimeEmployee : fullTimeEmployeeList.values())
		{
			BigDecimal gaji = fullTimeEmployee.getGajiPokokPerBulan();
			int tunjangan = fullTimeEmployee.getPersentaseTunjangan();
			
			BigDecimal nilaiTunjangan = BigDecimal.valueOf(tunjangan).multiply(gaji).divide(new BigDecimal(100));
			BigDecimal totalGaji = gaji.add(nilaiTunjangan);
			
			Locale indonesia = new Locale("id", "ID");
			String indoFormatGajiPokok = NumberFormat.getCurrencyInstance(indonesia).format(gaji);
			String indoFormatTotalGaji = NumberFormat.getCurrencyInstance(indonesia).format(totalGaji);
			
			String printGaji = String.format("No. Karyawan: %d\nGaji Pokok Per Bulan: %s\nTunjangan: %d%%\nTotal Gaji: %s\n",
					fullTimeEmployee.getNomorKaryawan(), indoFormatGajiPokok, fullTimeEmployee.getPersentaseTunjangan(), indoFormatTotalGaji);
			
			System.out.println(printGaji);
		}
		
	}

	public static void printDetailGajiPartTime()
	{
		System.out.println("Tekan Enter untuk lihat Gaji");
		scanner.nextLine();
		for(PartTimeEmployee partTimeEmployee : partTimeEmployeeList.values())
		{
			BigDecimal gaji = partTimeEmployee.getGajiPerHari();
			int hari = partTimeEmployee.getTotalHariBekerjaPerBulan();
			
			BigDecimal totalGaji = BigDecimal.valueOf(hari).multiply(gaji);
			
			Locale indonesia = new Locale("id", "ID");
			String indoFormatGajiPerHari = NumberFormat.getCurrencyInstance(indonesia).format(gaji);
			String indoFormatTotalGaji = NumberFormat.getCurrencyInstance(indonesia).format(totalGaji);
			
			String printGaji = String.format("No. Karyawan: %d\nGaji Per Hari: %s\nHari Kerja: %d\nTotal Gaji: %s\n",
					partTimeEmployee.getNomorKaryawan(), indoFormatGajiPerHari, partTimeEmployee.getTotalHariBekerjaPerBulan(), indoFormatTotalGaji);
			
			System.out.println(printGaji);
		}
		
	}
}

