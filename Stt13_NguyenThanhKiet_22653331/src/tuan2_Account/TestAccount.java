package tuan2_Account;

import java.util.Scanner;

public class TestAccount {
	static AccountArray accountList; 
	public static void main(String[] args) throws Exception {

				System.out.println("Chuong Trinh Account");
				accountList =new AccountArray();
		//		createDefaulAcc();
				Account[] dsAcc=accountList.getAccount();
		//		displayTitle();
		//		displayAcc(dsAcc);
		//		Account newAcc= createAcc();
		//		accountList.add(newAcc);
		//		displayTitle();
		//		dsAcc=accountList.getAccount();
		//		displayAcc(dsAcc);
		int opt;
		do {
			opt = menu();
			switch(opt) {
				case 1:{
					createDefaulAcc();
					dsAcc=accountList.getAccount();
					displayTitle();
					displayAcc(dsAcc);
					break;
				}
				case 2:{
					Account newAcc= createAcc();
					accountList.add(newAcc);
					displayTitle();
					dsAcc=accountList.getAccount();
					displayAcc(dsAcc);
					break;
				}
				case 3:{
					
				}

			}
		}while(opt != 6);

	}



	public static void displayTitle()
	{
		String title = String.format("\t%-7s %-20s %-30s %-20s", "NUMBER","ACCOUNT","FULL NAME","ACCOUNT BALANCE");
		System.out.println(title);
	}

	public static long inputLong (String s) {
		long numLong;
		System.out.println(s);
		Scanner sn = new Scanner(System.in);
		numLong = sn.nextLong();
		return numLong;

	}

	public static double inputDouble(String s) {
		double numDouble;
		System.out.println(s);
		Scanner sn = new Scanner(System.in);
		numDouble = sn.nextFloat();
		return numDouble;
	}

	public static String inputString (String s) {
		String str;
		System.out.println(s);
		Scanner sn = new Scanner(System.in);
		str = sn.nextLine();
		return str;

	}
	public static Account createAcc () {
		Account acc;
		long accountNum;
		String name;
		double balance = 0.0;
		accountNum =inputLong("Nhap so Tk ");
		while(accountList.isExistingAccNumber(accountNum))
		{
			System.out.println("So tai khoan da ton tai");
			accountNum= inputLong("Vui long nhap lai");
		}
		name = inputString("Nhap ten tai khoan ");
		acc = new Account(accountNum,name,balance);


		return acc;
	}

	public static void displayAcc(Account[] dsAcc) {
		for(int i=0;i<accountList.SPTT;i++)
		{
			System.out.printf("\t%-7d",i+1);
			System.out.println(dsAcc[i]);
		}
	}

	public static void createDefaulAcc() throws Exception
	{
		Account Acc1= new Account(10001234,"Nguyen Van Duc");
		Account Acc2= new Account(10001235,"Nguyen Thanh An",100000);
		Account Acc3= new Account(10001236,"Nguyen Anh Duc",250000);
		Account Acc4= new Account(10001237,"Nguyen Van Trong",400000);
		accountList.add(Acc1);
		accountList.add(Acc2);
		accountList.add(Acc3);
		accountList.add(Acc4);

	}
	public static int menu()
	{
		int chon ;
		System.out.println("****MENU****\n"+
				"1.Nhập Cứng\n"+
				"2.Thêm Tài Khoản\n"+
				"3.Xóa Tài Khoản\n"
				+ "4.Cập Nhật\n"
				+ "5.Sắp xếp"
				+ "6.Thoát");
		chon =nhapSoNguyen("Mời Bạn Chọn");
		return chon;
	}
	static int nhapSoNguyen(String str) 
	{
		int x;
		System.out.println(str);
		Scanner scn=new Scanner(System.in);
		x= scn.nextInt();
		return x;
	}
	public static void updateAcc () throws Exception {
		long accNum= inputLong("Nhập số tài khoản cần sửa ");
		Account acc= accountList.searchAcc(accNum);
		if(acc != null) {
			System.out.println("Trước khi sửa ");
			displayTitle();
			System.out.println(acc);
			String name = inputString("\n Nhập tên tài khoản mới ");
			double balance = inputDouble("\n Nhập số dư mới ");
			acc.setTenTaiKhoan(name);
			acc.setSoTienTrongTK(balance);
			accountList.update(acc);
		}
		else
		{
			System.out.println("Không tìm thấy tài khoản");
		}
	}
}
