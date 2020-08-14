package trong.lixco.com.util;

public class StaticPath {
	static String path = "";
	static String pathLocal = "";
	static String pathCenter = "";

	public static String getPath() {
		return path;
	}

	public static void setPath(String path) {
		StaticPath.path = path;
	}

	public static String getPathLocal() {
		return pathLocal;
	}

	public static void setPathLocal(String pathLocal) {
		StaticPath.pathLocal = pathLocal;
	}

	public static String getPathCenter() {
		return pathCenter;
	}

	public static void setPathCenter(String pathCenter) {
		StaticPath.pathCenter = pathCenter;
	}
	

}
