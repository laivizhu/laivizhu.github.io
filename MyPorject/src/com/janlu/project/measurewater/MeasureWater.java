/**
 * 
 */
package com.janlu.project.measurewater;

import java.util.Vector;



/**
 * @author janlu
 * 
 */
public class MeasureWater {

	private Bottle[] bottles;
	private int waterSize;
	private int secondSize;
	private int MaxStepNum;
	//private int maxWaterSize;
	private Vector<String> process = new Vector<String>();// ��ǰ��ˮ����
	private Vector<String> waterprocess = new Vector<String>();// ˮͰ����
	@SuppressWarnings("rawtypes")
	private Vector<Vector> result = new Vector<Vector>();// ������п��ܵĵ�ˮ���
	@SuppressWarnings("rawtypes")
	private Vector<Vector> waterresult = new Vector<Vector>();//

	public MeasureWater(Bottle[] bottles, int waterSize,int secondSize, int maxStepNum) {
		this(bottles,waterSize,maxStepNum);
		this.secondSize=secondSize;
	}
	public MeasureWater(Bottle[] bottles, int waterSize, int maxStepNum) {
		super();
		this.bottles = bottles;
		this.waterSize = waterSize;
		MaxStepNum = maxStepNum;
	}
	
	public void measure(){
		pour(this.process,this.waterprocess,this.bottles,1);
		show();
	}

	public void pour(Vector<String> vec, Vector<String> watervec, Bottle[] bottles,int step) {
		if ((bottles[0].getCurrentSize() == this.waterSize) && (this.secondSize==0 || (this.secondSize!=0 && bottles[1].getCurrentSize()==this.secondSize))) {
			result.addElement(vec);
			waterresult.addElement(watervec);
			return;
		}
		
		if (vec.size() != 0) {
			if (watervec.indexOf(watervec.elementAt(watervec.size()-1))!=watervec.size()-1) {
				return;
			}
		}
		if(step>this.MaxStepNum){
			return;
		}
		iterator(vec, watervec, bottles,step);
	}

	@SuppressWarnings("unchecked")
	private void handle(Vector<String> vec, Vector<String> watervec, Bottle[] bottles, int i, int j,int step) {
		Vector<String> v = (Vector<String>) vec.clone();
		Vector<String> waterv = (Vector<String>) watervec.clone();
		Bottle[] bottlesClone = copyArray(bottles);
		if (bottlesClone[i].isEmpty()) {
			return;
		}
		if(bottlesClone[j].isFull()){
			return;
		}
		bottlesClone[j].boxingFromBottle(bottlesClone[i]);
		v.addElement(bottlesClone[i].getCapacity() + "->" + bottlesClone[j].getCapacity());
		waterv.addElement(getAllBottlesCurrentSize(bottlesClone));
		pour(v, waterv, bottlesClone,step);
	}

	@SuppressWarnings("unchecked")
	private void emptyBottle(Vector<String> vec, Vector<String> watervec, Bottle[] bottles, int i,int step) {
		Vector<String> v = (Vector<String>) vec.clone();
		Vector<String> waterv = (Vector<String>) watervec.clone();
		Bottle[] bottlesClone = copyArray(bottles);
		for (int j = 0; j < bottles.length; j++) {
			if (j == i) {
				if (bottlesClone[j].isEmpty()) {
					return;
				}
				bottlesClone[j].pourWater();
				v.addElement("������������Ϊ" + bottlesClone[j].getCapacity() + "��ƿ��");
				break;
			}
		}
		waterv.addElement(getAllBottlesCurrentSize(bottlesClone));
		pour(v, waterv, bottlesClone,step);
	}

	@SuppressWarnings("unchecked")
	private void fullBottle(Vector<String> vec, Vector<String> watervec, Bottle[] bottles, int i,int step) {
		Vector<String> v = (Vector<String>) vec.clone();
		Vector<String> waterv = (Vector<String>) watervec.clone();
		Bottle[] bottlesClone = copyArray(bottles);
		for (int j = 0; j < bottles.length; j++) {
			if (j == i) {
				if (bottlesClone[j].isFull()) {
					return;
				}
				bottlesClone[j].boxingWater();
				v.addElement("������������Ϊ" + bottlesClone[j].getCapacity() + "��ƿ��");
				break;
			}
		}
		waterv.addElement(getAllBottlesCurrentSize(bottlesClone));
		pour(v, waterv, bottlesClone,step);
	}

	private void iterator(Vector<String> vec, Vector<String> watervec, Bottle[] bottles,int step) {
		// װ������ƿ
		for (int i = 0; i < bottles.length; i++) {
			if(!bottles[i].isFull() && bottles[i].isMove()){
				fullBottle(vec, watervec, bottles, i,step+1);
			}
			
		}
		if(step!=0){
			// ��������ƿ
			for (int i = 0; i < bottles.length; i++) {
				if(!bottles[i].isEmpty() && bottles[i].isMove()){
					emptyBottle(vec, watervec, bottles, i,step+1);
				}
			}
			
			// ������ƿ�е�ˮ������ƿ��
			for (int i = 0; i < bottles.length; i++) {
				if(!bottles[i].isEmpty() && bottles[i].isMove()){
					for (int j = 0; j < bottles.length; j++) {
						if (j == i)
							continue;
						if(!bottles[j].isFull()){
							handle(vec, watervec, bottles, i, j,step+1);
						}
						
					}
				}
			}
		}
		

	}

	private String getAllBottlesCurrentSize(Bottle[] bottles) {
		StringBuilder sb = new StringBuilder("(");
		for (Bottle bottle : bottles) {
			sb.append(bottle.getCapacity() + ":" + bottle.getCurrentSize() + ",");
		}
		sb.append(")");
		return sb.toString();
	}

	@SuppressWarnings("unchecked")
	public void show() {
		int num = 0, min = 10000;// numΪ���ٲ����ĵ�ˮ����������
		if (result.size() == 0) {
			System.out.println("�޷��ɹ���");
			System.exit(0);
		}
		for (int i = 0; i < result.size(); i++) {
			if (min > ((Vector<String>) result.elementAt(i)).size()) {
				min = ((Vector<String>) result.elementAt(i)).size();
				num = i;
			}
			// �о�������� //
			System.out.println(((Vector<String>) result.elementAt(i)).toString());
		}
		System.out.println("���������" + result.size() + "��.");
		System.out.println("���ٲ���Ϊ��" + min);
		System.out.println("��ˮ����Ϊ��");
		for (int i = 0; i < ((Vector<String>) result.elementAt(num)).size(); i++) {
			System.out.print("��" + (i + 1) + "��");
			System.out.print(":" + ((Vector<String>) result.elementAt(num)).elementAt(i));
			System.out.println(":" + ((Vector<String>) waterresult.elementAt(num)).elementAt(i));
		}
	}
	
	private Bottle[] copyArray(Bottle[] srcBottles){
		Bottle[] bottles=new Bottle[srcBottles.length];
		int i=0;
		for(Bottle bottle:srcBottles){
			bottles[i++]=new Bottle(bottle.getCapacity(),bottle.getCurrentSize());
		}
		return bottles;
	}

}
