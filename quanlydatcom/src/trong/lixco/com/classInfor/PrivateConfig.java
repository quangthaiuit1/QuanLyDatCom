package trong.lixco.com.classInfor;

public class PrivateConfig {
	private long id;
	private String formatDate;
	private String thousandSeparator;
	private String decimalSeparator;
	private String parttenNumber;
	private String maskDate;
	private String locale;
	private int decimalNumber;
	private boolean showHeader = true;

	public PrivateConfig() {
		this.formatDate = "dd/MM/yyyy";
		this.thousandSeparator = ".";
		this.decimalSeparator = ",";
		this.parttenNumber = "#,###,###,###,###,###,##0.00";
		this.maskDate = "99/99/9999";
		this.locale = "vi";
		this.decimalNumber = 0;
	}

	public PrivateConfig(trong.lixco.com.account.servicepublics.PrivateConfig privateConfig) {
		this.id = privateConfig.getId();
		this.formatDate = privateConfig.getPattentDate();
		this.thousandSeparator = privateConfig.getThousandSeparator();
		this.decimalSeparator = privateConfig.getDecimalSeparator();
		this.parttenNumber = privateConfig.getDecimalPattent();
		this.decimalNumber = privateConfig.getDecimalNumber();
		this.showHeader = privateConfig.isShowHeader();

		switch (privateConfig.getPattentDate()) {
		case "dd/MM/yyyy":
			this.maskDate = "99/99/9999";
			break;
		case "dd/MM/yyyy hh:mm:ss":
			this.maskDate = "99/99/9999 99:99:99";
			break;
		case "d/M/yyyy":
			this.maskDate = "99/99/9999";
			break;
		case "d/M/yyyy hh:mm:ss":
			this.maskDate = "99/99/9999 99:mm:ss";
			break;
		case "yyyy/MM/dd":
			this.maskDate = "9999/99/99";
			break;
		case "yyyy/MM/dd hh:mm:ss":
			this.maskDate = "9999/99/99 hh:mm:ss";
			break;
		default:
			break;
		}

		if (".".equals(this.decimalSeparator)) {
			this.locale = "en";
		} else {
			this.locale = "vi";
		}
	}

	public String getFormatDate() {
		return formatDate;
	}

	public void setFormatDate(String formatDate) {
		this.formatDate = formatDate;
	}

	public String getThousandSeparator() {
		return thousandSeparator;
	}

	public void setThousandSeparator(String thousandSeparator) {
		this.thousandSeparator = thousandSeparator;
	}

	public String getDecimalSeparator() {
		return decimalSeparator;
	}

	public void setDecimalSeparator(String decimalSeparator) {
		this.decimalSeparator = decimalSeparator;
	}

	public String getParttenNumber() {
		return parttenNumber;
	}

	public void setParttenNumber(String parttenNumber) {
		this.parttenNumber = parttenNumber;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMaskDate() {
		return maskDate;
	}

	public void setMaskDate(String maskDate) {
		this.maskDate = maskDate;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public int getDecimalNumber() {
		return decimalNumber;
	}

	public void setDecimalNumber(int decimalNumber) {
		this.decimalNumber = decimalNumber;
	}

	public boolean isShowHeader() {
		return showHeader;
	}

	public void setShowHeader(boolean showHeader) {
		this.showHeader = showHeader;
	}

}
