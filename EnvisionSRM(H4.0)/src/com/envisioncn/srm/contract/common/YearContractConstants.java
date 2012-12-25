package com.envisioncn.srm.contract.common;


public class YearContractConstants {
	public static enum State{
		TEMP_PRODUCTIVE, TEMP_NONPRODUCTIVE
	}
	public static String stateString(State state) {
		switch (state) {
		case TEMP_PRODUCTIVE:
			return "生产性物料年度合同模板";
		case TEMP_NONPRODUCTIVE:
			return "非生产性物料年度合同模板";
		}
		return null;
	}
}
