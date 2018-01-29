package common;
/**
 * 工具类
 * @author wsz
 * @date 2018年1月29日
 */
public class Utils {

	public static boolean nullOrEmpty(Object obj) {
		if(obj == null || "".equals(obj))
			return true;
		else 
			return false;
	}
}
