package common;
/**
 * ������
 * @author wsz
 * @date 2018��1��29��
 */
public class Utils {

	public static boolean nullOrEmpty(Object obj) {
		if(obj == null || "".equals(obj))
			return true;
		else 
			return false;
	}
}
