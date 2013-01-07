/**
 * 
 */
package com.janlu.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.janlu.algorithm.model.heap.BigHeap;
import com.janlu.algorithm.model.tree.HuffmanTree;
import com.janlu.contents.Constants.AlgorithmConstants;
import com.janlu.exception.AlgorithmException;
import com.janlu.util.DataArrayUtil;
import com.janlu.util.DataUtil;
import com.janlu.util.MethodCglibProxy;
import com.janlu.util.ObjectUtil;
import com.janlu.util.OtherUtil;
import com.janlu.util.OutPrintUtil;
import com.janlu.util.SearchUtil;
import com.janlu.util.SortUtil;

/**
 * @author janlu
 * 
 */
public class AlgorithmTest {

	private final static int SIZE = 100000;
	private SortUtil sortUtil = null;

	@Before
	public void setUp() {
		sortUtil = new SortUtil();
	}

	@Test
	public void testBitSort() {
		int[] datas = { 0, 9, 3, 99, 34, 23, 5, 1, 98, 87, 25, 12, 7, 49, 96 };
		sortUtil.bitSetSort(100, datas);
		for (int num : datas) {
			System.out.print(num + ",");
		}
	}

	@Test
	public void testObjectTurn() {
		Character[] str = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h' };
		ObjectUtil.turn(str, 3);
		for (char c : str) {
			System.out.print(c);
		}
	}

	@Test
	public void testBinSearch() {
		int[] datas = { 0, 9, 3, 99, 34, 23, 5, 4, 65, 87, 54, 12, 43, 49, 96 };
		sortUtil.bitSetSort(100, datas);
		OutPrintUtil.outMessage(SearchUtil.binSearch(datas, 8));
	}

	@Test
	public void testListChangeWord() {
		String[] directory = { "pans", "pots", "opt", "snap", "stop", "tops" };
		Map<String, List<String>> words = OtherUtil.squash(directory);
		for (Map.Entry<String, List<String>> entry : words.entrySet()) {
			for (String str : entry.getValue()) {
				System.out.print(str + ",");
			}
			System.out.println();
		}
	}

	@Test
	public void testQuickSort() {
		int[] datas = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15 };
		sortUtil.quickSort(datas);
		for (int num : datas) {
			System.out.print(num + ",");
		}
	}

	@Test
	public void testBulbSort() {
		int[] datas = { 0, 9, 3, 99, 34, 1, 5, 1, 98, 87, 25, 12, 7, 49, 96 };
		sortUtil.bulbSort(datas);
		for (int num : datas) {
			System.out.print(num + ",");
		}
	}

	@Test
	public void testChoiceSort() {
		int[] datas = { 0, 9, 3, 99, 34, 1, 5, 1, 98, 87, 25, 12, 7, 49, 96 };
		sortUtil.choiceSort(datas);
		for (int num : datas) {
			System.out.print(num + ",");
		}
	}

	@Test
	public void testMegerSort() {
		int[] datas = { 0, 9, 3, 99, 34, 1, 5, 7, 98, 87, 25, 12, 7, 49, 96 };
		sortUtil.megerSort(datas);
		for (int num : datas) {
			System.out.print(num + ",");
		}
	}

	@Test
	public void testHeapSort() {
		int[] datas = { 0, 9, 3, 99, 34, 1, 5, 7, 98, 87, 25, 12, 7, 49, 96 };
		sortUtil.heapSort(datas);
		for (int num : datas) {
			System.out.print(num + ",");
		}
	}

	@Test
	public void testSortTime() throws AlgorithmException {
		SortUtil sortUtilProxy = (SortUtil) MethodCglibProxy.getInstance(new SortUtil());

		int[] number = DataArrayUtil.getRandomArray(SIZE, false);

		sortUtilProxy.bitSetSort(SIZE, DataArrayUtil.copyArray(number));

		sortUtilProxy.quickSort(DataArrayUtil.copyArray(number));

		sortUtilProxy.heapSort(DataArrayUtil.copyArray(number));

		sortUtilProxy.megerSort(DataArrayUtil.copyArray(number));

		sortUtilProxy.bulbSort(DataArrayUtil.copyArray(number));

		sortUtilProxy.choiceSort(DataArrayUtil.copyArray(number));
	}

	@Test
	public void testArray() {
		int income = 2701;
		float tax = 0;
		float[] a = new float[55];
		a[0] = 0;
		for (int i = 1; i < a.length; i++) {
			a[i] = 0.14f + (i - 1) * 0.01f;
		}
		float[] b = new float[a.length + 1];
		b[0] = 0;
		for (int i = 1; i < b.length; i++) {
			for (int j = 0; j < i; j++) {
				b[i] += a[j];
			}
		}
		for (int i = 0; i < 55; i++) {
			int temp = (2200 + i * 500);
			if (income <= temp) {
				tax = 500 * b[i] + a[i] * (income - (temp - 500));
				break;
			}
		}
		System.out.println(tax);
	}

	@Test
	public void testHeapStruct() throws AlgorithmException {
		int[] number = { 1, 19, 17, 99, 48, 35, 22, 25, 42, 20 };
		BigHeap heap = new BigHeap(1000);
		for (int i = 0; i < number.length; i++) {
			heap.add(number[i]);
			System.out.println(heap);
		}
		int size = heap.getHeapSize();
		for (int i = 0; i < size; i++) {
			System.out.print(heap.extractMaxNum() + ",");
		}
		// heap.remove(25);
		OutPrintUtil.outMessage(heap);
	}

	@Test
	public void testTenToOther() throws AlgorithmException {
		OutPrintUtil.outMessage(DataUtil.convert(255, 16));
		// System.out.println(DataUtil.convert(255, 16));
	}

	@Test
	public void testHuffman() {
		HuffmanTree huffmanTree = new HuffmanTree(
				"oweinva;pziouiofw0-23j,./,/.,/.<>?!@##$$$%%^^&&**((()_+flnafasdfiuwekjfskjdhflkjwwoeiuroo;fg290348r-34-340928209128409237457476587yiufdhskfjaskjbdf9023nsd08923rkjhas0d9uf23lknfa'jdsoif[09238ufjwe23390urjfnkjasdvnjhruiahgiuashdfs;klhfi2i93urqojf;alksjdf923uihasjdihfakjsdvjff2903ur9043503897685777gdfvbkxchjhyiu;zhuweionlinefangcaotianyajanlusword@gmail.com@163.comalgorithmtest");
		System.out.println(huffmanTree.coding());
		System.out.println(huffmanTree.zeroStr);
	}

	@Test
	public void testOutPhone() {
		Map<String, String> namePhoneMap = new HashMap<String, String>();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("phone.txt"));
			String temp = null;
			while ((temp = br.readLine()) != null) {
				String[] phoneMaps = temp.split(" ");
				if (phoneMaps.length >= 2) {
					namePhoneMap.put(phoneMaps[0], phoneMaps[1]);
				} else {
					namePhoneMap.put(phoneMaps[0], AlgorithmConstants.EMPTY);
				}
			}
			br.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Test
	public void testMatch(){
		/*int[] number = { 1, 19, 17, 99, 48, 35, 22, 25, 42, 20,100 };
		System.out.println(getMatchCount(number,number.length));
		System.out.println(number[0]);*/
		System.out.println(getLightCount());
	}
	
	public int getMatchCount(int[] a,int n){
		if(n==1) return 0;
		int mid=n/2;
		int k=n-1;
		for(int i=0;i<mid;i++){
			if(a[i]<a[k]){
				int temp=a[i];
				a[i]=a[k];
				a[k]=temp;
			}
			k--;
		}
		return mid+getMatchCount(a,n-mid);
	}
	
	public int getLightCount(){
		int[] visit=new int[100];
		for(int i=0;i<visit.length;i++){
			for(int j=0;j<=i;j++){
				if((i+1)%(j+1)==0){
					visit[i]++;
				}
			}
		}
		int count=0;
		for(int i=0;i<visit.length;i++){
			if(visit[i]%2!=0){
				count++;
				System.out.print((i+1)+",");
			}
		}
		return count;
	}

}
