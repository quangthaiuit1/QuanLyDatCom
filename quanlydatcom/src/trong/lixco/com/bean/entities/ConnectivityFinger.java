//package trong.lixco.com.bean.entities;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.annotation.PostConstruct;
//import javax.faces.bean.ApplicationScoped;
//import javax.faces.bean.ManagedBean;
//
//import com.zkteco.biometric.FingerprintSensor;
//import com.zkteco.biometric.FingerprintSensorErrorCode;
//import com.zkteco.biometric.FingerprintSensorEx;
//
//import trong.lixco.com.entitynative.Employee;
//
//@ManagedBean(eager = true)
//@ApplicationScoped
//public class ConnectivityFinger {
//
//	List<Employee> allEmployee = new ArrayList<>();
//	Connection con = null;
//	Statement statement = null;
//
//	int fpWidth = 0;
//	// the height of fingerprint image
//	int fpHeight = 0;
//	// for verify test
//	private byte[] lastRegTemp = new byte[2048];
//	// the length of lastRegTemp
//	private int cbRegTemp = 0;
//	// pre-register template
//	private byte[][] regtemparray = new byte[3][2048];
//	// Register
//	private boolean bRegister = false;
//	// Identify
//	private boolean bIdentify = true;
//	// finger id
//	private int iFid = 1;
//
//	private int nFakeFunOn = 1;
//	// must be 3
//	static final int enroll_cnt = 3;
//	// the index of pre-register function
//	private int enroll_idx = 0;
//
//	private byte[] imgbuf = null;
//	private byte[] template = new byte[2048];
//	private int[] templateLen = new int[1];
////	private int[] thamchieu = null;
//	String[] tennv = null;
//	private boolean mbStop = true;
//	private long mhDevice = 0;
//	private long mhDB = 0;
////	private WorkThread workThread = null;
//
//	@PostConstruct
//	public void startup() {
//		con = ConnectivityFinger.getConnection();
//		String sql = "select template.*, manhanvien, tennhanvien from template, nhanvien where template.machamcong = nhanvien.machamcong";
//		try {
//			statement = con.createStatement();
//			ResultSet res = statement.executeQuery(sql);
//			while (res.next()) {
//				Employee tl = new Employee(res.getInt("MaChamCong"), res.getInt("FingerID"), res.getInt("Flag"),
//						res.getString("FingerTemplate"), res.getString("MaNhanVien"), res.getString("TenNhanvien"));
//
//				allEmployee.add(tl);
//			}
//
////			if (0 != mhDevice) {
////				// already inited
//////				textArea.setText("Please close device first!\n");
////				return;
////			}
////			int ret = FingerprintSensorErrorCode.ZKFP_ERR_OK;
////			// Initialize
////			cbRegTemp = 0;
////			bRegister = false;
////			bIdentify = false;
////			iFid = 1;
////			enroll_idx = 0;
////			if (FingerprintSensorErrorCode.ZKFP_ERR_OK != FingerprintSensorEx.Init()) {
//////				textArea.setText("Init failed!\n");
////				return;
////			}
////			ret = FingerprintSensorEx.GetDeviceCount();
////			if (ret < 0) {
//////				textArea.setText("No devices connected!\n");
////				FreeSensor();
////				return;
////			}
////			if (0 == (mhDevice = FingerprintSensorEx.OpenDevice(0))) {
//////				textArea.setText("Open device fail, ret = " + ret + "!\n");
////				FreeSensor();
////				return;
////			}
////			if (0 == (mhDB = FingerprintSensorEx.DBInit())) {
//////				textArea.setText("Init DB fail, ret = " + ret + "!\n");
////				FreeSensor();
////				return;
////			}
////
////			// For ISO/Ansi
////			int nFmt = 0; // Ansi
//////			if (radioISO.isSelected()) {
//////				nFmt = 1; // ISO
//////			}
////			FingerprintSensorEx.DBSetParameter(mhDB, 5010, nFmt);
////			// For ISO/Ansi End
////
////			// set fakefun off
////			// FingerprintSensorEx.SetParameter(mhDevice, 2002,
////			// changeByte(nFakeFunOn), 4);
////
////			byte[] paramValue = new byte[4];
////			int[] size = new int[1];
////			// GetFakeOn
////			// size[0] = 4;
////			// FingerprintSensorEx.GetParameters(mhDevice, 2002, paramValue,
////			// size);
////			// nFakeFunOn = byteArrayToInt(paramValue);
////
////			size[0] = 4;
////			FingerprintSensorEx.GetParameters(mhDevice, 1, paramValue, size);
////			fpWidth = byteArrayToInt(paramValue);
////			size[0] = 4;
////			FingerprintSensorEx.GetParameters(mhDevice, 2, paramValue, size);
////			fpHeight = byteArrayToInt(paramValue);
////
////			imgbuf = new byte[fpWidth * fpHeight];
////			// btnImg.resize(fpWidth, fpHeight);
////			mbStop = false;
////			workThread = new WorkThread();
////			workThread.start();// 线程�?�动
////
////			// load vao bo nho
////			for (int i = 0; i < allEmployee.size(); i++) {
////				Employee tl = new Employee(allEmployee.get(i).getMaChamCong(), allEmployee.get(i).getFingerID(),
////						allEmployee.get(i).getFlag(), allEmployee.get(i).getFingerTemplate());
////				String cmau = tl.getFingerTemplate();
////				int[] sokt = new int[1];
////				sokt[0] = 2048;
////				byte[] mau = new byte[sokt[0]];
////				FingerprintSensor.Base64ToBlob(cmau, mau, sokt[0]);
////				if (0 == (ret = FingerprintSensorEx.DBAdd(mhDB, i + 1, mau))) {
//////					textArea.setText("�?ang load" + mau);
////				} else {
//////					textArea.setText("Bị lỗi" + ret + "\n");
////				}
////			}
//			System.out.println(allEmployee);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//	}
//	
////	private void FreeSensor() {
////		mbStop = true;
////		try { // wait for thread stopping
////			Thread.sleep(1000);
////		} catch (InterruptedException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////		if (0 != mhDB) {
////			FingerprintSensorEx.DBFree(mhDB);
////			mhDB = 0;
////		}
////		if (0 != mhDevice) {
////			FingerprintSensorEx.CloseDevice(mhDevice);
////			mhDevice = 0;
////		}
////		FingerprintSensorEx.Terminate();
////	}
////
////	public static int byteArrayToInt(byte[] bytes) {
////		int number = bytes[0] & 0xFF;
////		// "|="按�?或赋值。
////		number |= ((bytes[1] << 8) & 0xFF00);
////		number |= ((bytes[2] << 16) & 0xFF0000);
////		number |= ((bytes[3] << 24) & 0xFF000000);
////		return number;
////	}
////
////	private class WorkThread extends Thread {
////		@Override
////		public void run() {
////			super.run();
////			int ret = 0;
////			while (!mbStop) {
////				templateLen[0] = 2048;
////				if (0 == (ret = FingerprintSensorEx.AcquireFingerprint(mhDevice, imgbuf, template, templateLen))) {
////					if (nFakeFunOn == 1) {
////						byte[] paramValue = new byte[4];
////						int[] size = new int[1];
////						size[0] = 4;
////						int nFakeStatus = 0;
////						// GetFakeStatus
////						ret = FingerprintSensorEx.GetParameters(mhDevice, 2004, paramValue, size);
////						nFakeStatus = byteArrayToInt(paramValue);
////						System.out.println("ret = " + ret + ",nFakeStatus=" + nFakeStatus);
////						if (0 == ret && (byte) (nFakeStatus & 31) != 31) {
//////							textArea.setText("Is a fake finger?\n");
////							return;
////						}
////					}
//////					OnCatpureOK(imgbuf);
//////					OnExtractOK(template, templateLen[0]);
////				}
////				try {
////					Thread.sleep(500);
////				} catch (InterruptedException e) {
////					e.printStackTrace();
////				}
////
////			}
////		}
////	}
//
//	public static Connection getConnection() {
//		// Load driver mysql
//		try {
//			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//			// handle connect mysql
//			String url = "jdbc:sqlserver://192.168.1.236;databaseName=MITACOSQL";
//			String user = "sa";
//			String password = "LIXCO@admin2016";
//			return DriverManager.getConnection(url, user, password);
//		} catch (ClassNotFoundException | SQLException e) {
//			e.printStackTrace();
//			return null;
//		}
//	}
//
//	public static boolean closeConnection(Connection con, PreparedStatement ps) {
//		try {
//			if (con != null) {
//				con.close();
//			}
//			if (ps != null) {
//				ps.close();
//			}
//		} catch (Exception e2) {
//			return false;
//		}
//		return true;
//	}
//}
