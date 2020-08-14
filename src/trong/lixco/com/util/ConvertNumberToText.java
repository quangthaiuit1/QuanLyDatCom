package trong.lixco.com.util;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class ConvertNumberToText {

	public static final String KHONG = "không";
	public static final String MOT = "một";
	public static final String HAI = "hai";
	public static final String BA = "ba";
	public static final String BON = "bốn";
	public static final String NAM = "năm";
	public static final String SAU = "sáu";
	public static final String BAY = "bảy";
	public static final String TAM = "tám";
	public static final String CHIN = "chín";
	public static final String LAM = "lăm";
	public static final String LE = "lẻ";
	public static final String MUOI = "mươi";
	public static final String MUOIF = "mười";
	public static final String MOTS = "mốt";
	public static final String TRAM = "trăm";
	public static final String NGHIN = "nghìn";
	public static final String TRIEU = "triệu";
	public static final String TY = "tỷ";

	public static final String[] number = { KHONG, MOT, HAI, BA, BON, NAM, SAU, BAY, TAM, CHIN };

	// Hàm chính đọc số
	public static String readNum(String a) {
		ArrayList<String> kq = new ArrayList<String>();

		// Cắt chuổi string chử số ra thành các chuổi nhỏ 3 chử số
		ArrayList<String> List_Num = Split(a, 3);

		while (List_Num.size() != 0) {
			// Xét 3 số đầu tiên của chuổi (số đầu tiên của List_Num)
			switch (List_Num.size() % 3) {
			// 3 số đó thuộc hàng trăm
			case 1:
				kq.addAll(read_3num(List_Num.get(0)));
				break;
			// 3 số đó thuộc hàng nghìn
			case 2:
				ArrayList<String> nghin = read_3num(List_Num.get(0));
				if (!nghin.isEmpty()) {
					kq.addAll(nghin);
					kq.add(NGHIN);
				}
				break;
			// 3 số đó thuộc hàng triệu
			case 0:
				ArrayList<String> trieu = read_3num(List_Num.get(0));
				if (!trieu.isEmpty()) {
					kq.addAll(trieu);
					kq.add(TRIEU);
				}
				break;
			}

			// Xét nếu 3 số đó thuộc hàng tỷ
			if (List_Num.size() == (List_Num.size() / 3) * 3 + 1 && List_Num.size() != 1)
				kq.add(TY);

			// Xóa 3 số đầu tiên để tiếp tục 3 số kế
			List_Num.remove(0);
		}
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < kq.size(); i++) {
			result.append(kq.get(i) + " ");
		}

		return result.toString();
	}

	// Đọc 3 số
	public static ArrayList<String> read_3num(String a) {
		ArrayList<String> kq = new ArrayList<String>();
		int num = -1;
		try {
			num = Integer.parseInt(a);
		} catch (Exception ex) {
		}
		if (num == 0)
			return kq;

		int hang_tram = -1;
		try {
			hang_tram = Integer.parseInt(a.substring(0, 1));
		} catch (Exception ex) {
		}
		int hang_chuc = -1;
		try {
			hang_chuc = Integer.parseInt(a.substring(1, 2));
		} catch (Exception ex) {
		}
		int hang_dv = -1;
		try {
			hang_dv = Integer.parseInt(a.substring(2, 3));
		} catch (Exception ex) {
		}

		// xét hàng trăm
		if (hang_tram != -1) {
			kq.add(number[hang_tram]);
			kq.add(TRAM);
		}

		// xét hàng chục
		switch (hang_chuc) {
		case -1:
			break;
		case 1:
			kq.add(MUOIF);
			break;
		case 0:
			if (hang_dv != 0)
				kq.add(LE);
			break;
		default:
			kq.add(number[hang_chuc]);
			kq.add(MUOI);
			break;
		}

		// xét hàng đơn vị
		switch (hang_dv) {
		case -1:
			break;
		case 1:
			if ((hang_chuc != 0) && (hang_chuc != 1) && (hang_chuc != -1))
				kq.add(MOTS);
			else
				kq.add(number[hang_dv]);
			break;
		case 5:
			if ((hang_chuc != 0) && (hang_chuc != -1))
				kq.add(LAM);
			else
				kq.add(number[hang_dv]);
			break;
		case 0:
			if (kq.isEmpty())
				kq.add(number[hang_dv]);
			break;
		default:
			kq.add(number[hang_dv]);
			break;
		}
		return kq;
	}

	public static ArrayList<String> Split(String str, int chunkSize) {
		int du = str.length() % chunkSize;
		// Nếu độ dài chuổi không phải bội số của chunkSize thì thêm # vào trước
		// cho đủ.
		if (du != 0)
			for (int i = 0; i < (chunkSize - du); i++)
				str = "#" + str;
		return splitStringEvery(str, chunkSize);
	}

	// Hàm cắt chuổi ra thành chuổi nhỏ
	public static ArrayList<String> splitStringEvery(String s, int interval) {
		ArrayList<String> arrList = new ArrayList<String>();
		int arrayLength = (int) Math.ceil(((s.length() / (double) interval)));
		String[] result = new String[arrayLength];
		int j = 0;
		int lastIndex = result.length - 1;
		for (int i = 0; i < lastIndex; i++) {
			result[i] = s.substring(j, j + interval);
			j += interval;
		}
		result[lastIndex] = s.substring(j);

		/*
		 * Có thể dùng hàm sau để cắt nhưng hiệu suất sẽ thấp hơn cách trên
		 * result = s.split("(?<=\\G.{" + interval + "})");
		 */

		arrList.addAll(Arrays.asList(result));
		return arrList;
	}
	
	public static String docSo(String so, String dVT) {
		String dvtiendotext = "";
		String subDonVi = "";
		if(dVT!=null){
		if (dVT.trim().equals("ĐỒNG")) {
			dvtiendotext = "đồng";
		} else if (dVT.trim().equals("USD")) {
			dvtiendotext = "đô la mỹ";
			subDonVi = "cents";
		} else if (dVT.trim().equals("JPY")) {
			dvtiendotext = "JPY";
		} else if (dVT.trim().equals("UIC")) {
			dvtiendotext = "UIC";
		} else if (dVT.trim().equals("FRF")) {
			dvtiendotext = "FRF";
		} else if (dVT.trim().equals("EUR")) {
			dvtiendotext = "EUR";

		}
		}
		// Convert so sang chuoi 2134141234.234 -> 2134141234,234(String)
		String curentUSD=so;
		System.out.println(so);
		StringBuffer tienbangchu = new StringBuffer();
		if (curentUSD.indexOf(",") != -1) {
			if (dVT.trim().equals("USD")) {
				String result = readNum(curentUSD.substring(0, curentUSD.indexOf(",")).replace(".", ""));
				String sole=curentUSD.substring(curentUSD.indexOf(",") + 1);
				if(!("00".equals(sole))){
				String resultSub = readNum(sole);
				tienbangchu.append(result.toString() + dvtiendotext + " " + resultSub.toString() + subDonVi);
				}else{
					tienbangchu.append(result.toString() + dvtiendotext);
				}
			}else{
				String result = readNum(curentUSD.substring(0, curentUSD.indexOf(",")).replace(".", ""));
				String resultSub = readNum(curentUSD.substring(curentUSD.indexOf(",") + 1));
				tienbangchu.append(result.toString() + dvtiendotext + " lẻ " + resultSub.toString() + subDonVi);
			}
			
		} else {
			String result = readNum(curentUSD.replace(".", ""));
			tienbangchu.append(result.toString() + dvtiendotext);
		}
		String result=tienbangchu.toString().substring(0, 1).toUpperCase() + tienbangchu.toString().substring(1);
		if(result.trim().equalsIgnoreCase("Không")){
			return "";
		}else{
			return result;
		}
	}

	public static String docSo(double so, String dVT) {
		String dvtiendotext = "";
		String subDonVi = "";
		if(dVT!=null){
		if (dVT.trim().equals("ĐỒNG")) {
			dvtiendotext = "đồng";
		} else if (dVT.trim().equals("USD")) {
			dvtiendotext = "đô la mỹ";
			subDonVi = "cents";
		} else if (dVT.trim().equals("JPY")) {
			dvtiendotext = "JPY";
		} else if (dVT.trim().equals("UIC")) {
			dvtiendotext = "UIC";
		} else if (dVT.trim().equals("FRF")) {
			dvtiendotext = "FRF";
		} else if (dVT.trim().equals("EUR")) {
			dvtiendotext = "EUR";

		}
		}
		// Convert so sang chuoi 2134141234.234 -> 2134141234,234(String)
		String curentUSD="0";
		if ("USD".equals(dVT)) {
			DecimalFormat df = new DecimalFormat("###########.00");
			curentUSD=df.format(so);
		}else{
			curentUSD = NumberFormat.getCurrencyInstance(new Locale("vi", "VN")).getInstance().format(so)
					.replace(".", "");
		}
		StringBuffer tienbangchu = new StringBuffer();
		if (curentUSD.indexOf(",") != -1) {
			if (dVT.trim().equals("USD")) {
				String result = readNum(curentUSD.substring(0, curentUSD.indexOf(",")).replace(".", ""));
				String sole=curentUSD.substring(curentUSD.indexOf(",") + 1);
				if(!("00".equals(sole))){
				String resultSub = readNum(sole);
				tienbangchu.append(result.toString() + dvtiendotext + " " + resultSub.toString() + subDonVi);
				}else{
					tienbangchu.append(result.toString() + dvtiendotext);
				}
			}else{
				String result = readNum(curentUSD.substring(0, curentUSD.indexOf(",")).replace(".", ""));
				String resultSub = readNum(curentUSD.substring(curentUSD.indexOf(",") + 1));
				tienbangchu.append(result.toString() + dvtiendotext + " lẻ " + resultSub.toString() + subDonVi);
			}
			
		} else {
			String result = readNum(curentUSD.replace(".", ""));
			tienbangchu.append(result.toString() + dvtiendotext);
		}
		String result=tienbangchu.toString().substring(0, 1).toUpperCase() + tienbangchu.toString().substring(1);
		if(result.trim().equalsIgnoreCase("Không")){
			return "";
		}else{
			return result;
		}
	}

	public static void main(String[] args) {
		Double b = 3008880.075;
		System.out.println(ConvertNumberToText.docSo(b, "USD"));
		
	}
}