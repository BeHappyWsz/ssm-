package common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 * ���ݷ��ع�����
 * @author wsz
 * @date 2018��1��29��
 */
public class DataGrid implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long total = Long.valueOf(0L);
	
	@SuppressWarnings("rawtypes")
	private List<?> rows = new ArrayList();

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}
	
}
