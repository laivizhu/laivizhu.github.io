package com.envisioncn.srm.basic.model.json;

import java.util.ArrayList;
import java.util.List;

import com.envisioncn.srm.basic.util.JsonUtil;

public class ListResult<T> {
	private List<T> root;
	private long totalItem;

	public ListResult() {
	}

	public ListResult(List<T> root, long totalProperty) {
		if (root == null) {
			this.root = new ArrayList<T>();
		}
		this.root = root;
		this.totalItem = totalProperty;
	}

	public ListResult(List<T> root) {
		this.root = root;
		this.totalItem = root.size();
	}

	public List<T> getRoot() {
		return root;
	}

	public void setRoot(List<T> root) {
		this.root = root;
	}

	public long getTotalItem() {
		return totalItem;
	}

	public void setTotalItem(long totalItem) {
		this.totalItem = totalItem;
	}

	public String toJson() {
		if (root != null && root.size() > 0) {
			if (root.get(0) instanceof JsonEntity) {
				StringBuilder sb = new StringBuilder();
				sb.append("{totalItem:").append(totalItem).append(",");
				sb.append("root:[");
				boolean first = true;
				for (T item : root) {
					if (!first) {
						sb.append(",");
					}
					first = false;
					sb.append(((JsonEntity) item).toJson());
				}
				sb.append("]}");
				return sb.toString();
			}
		}
		return JsonUtil.parseObject(this);
	}
}
