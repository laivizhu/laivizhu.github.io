/**
 * 
 */
package com.janlu.algorithm.model.tree;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.janlu.contents.Constants.AlgorithmConstants;

/**
 * @author janlu
 *
 */
public class HuffmanTree extends Tree<Character> implements Huffman{
	
	private Map<Character,BitSet> codes;
	public String zeroStr;
	private String srcCode;
	
	public HuffmanTree(String srcCode) {
		this.srcCode = srcCode;
		buildHuffman(srcCode);
	}

	@Override
	public String coding() {
		StringBuilder sb=new StringBuilder();
		for(Character c:srcCode.toCharArray()){
			sb.append(bitToString(codes.get(c)));
		}
		return sb.toString();
	}

	@Override
	public String decoding() {
		return srcCode;
	}
	
	public String bitToString(BitSet set){
		if(set.length()==0){
			return this.zeroStr;
		}
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<set.length();i++){
			if(set.get(i)){
				sb.insert(0, AlgorithmConstants.Value.One);
			}else{
				sb.insert(0, AlgorithmConstants.Value.Zero);
			}
		}
		return sb.toString();
	}
	
	public Map<Character,Integer> statistic(String str){
		Map<Character,Integer> result=new HashMap<Character,Integer>();
		for(Character c:str.toCharArray()){
			if(result.get(c)==null){
				result.put(c, 1);
			}else{
				result.put(c, result.get(c)+1);
			}
		}
		return result;
	}
	
	public void buildHuffman(String str){
		Map<Character,Integer> result=statistic(str);
		List<WeightTreeNode<Character>> nodeList=new ArrayList<WeightTreeNode<Character>>();
		for(Map.Entry<Character, Integer> entry:result.entrySet()){
			WeightTreeNode<Character> node=new WeightTreeNode<Character>();
			node.setValue(entry.getKey());
			node.setWeight(entry.getValue());
			nodeList.add(node);
		}
		while(nodeList.size()>1){
			this.root=merger(nodeList);
		}
		buildHuffmanCode(result);
	}
	
	public WeightTreeNode<Character> getMinNode(List<WeightTreeNode<Character>> result){
		int i=0;
		WeightTreeNode<Character> minCharNode=null;
		for(WeightTreeNode<Character> entry:result){
			if(i==0){
				minCharNode=entry;
			}else{
				if(entry.getWeight()<minCharNode.getWeight()){
					minCharNode=entry;
				}
			}
			i++;
		}
		result.remove(minCharNode);
		return minCharNode;
	}
	
	public WeightTreeNode<Character> merger(List<WeightTreeNode<Character>> result){
		WeightTreeNode<Character> minTreeNode=getMinNode(result);
		WeightTreeNode<Character> minTreeNode2=getMinNode(result);
		WeightTreeNode<Character> mergerNode=new WeightTreeNode<Character>();
		mergerNode.setLeft(minTreeNode);
		mergerNode.setRight(minTreeNode2);
		mergerNode.setWeight(minTreeNode.getWeight()+minTreeNode2.getWeight());
		result.add(mergerNode);
		return mergerNode;
	}
	
	public void buildHuffmanCode(Map<Character,Integer> result){
		this.codes=new HashMap<Character,BitSet>();
		for(Map.Entry<Character, Integer> entry:result.entrySet()){
			String code=getHuffmanCode(entry.getKey(),this.root,"");
			codes.put(entry.getKey(), getBitSetFromString(code));
			System.out.println("Character "+entry.getKey()+" coding :"+code);
		}
	}
	
	public String getHuffmanCode(Character value,TreeNode<Character> node,String code){
		if(node.getValue()!=null && value.toString().equals(node.getValue().toString())){
			return code;
		}else{
			String temp=null;
			if(node.left!=null){
				temp=getHuffmanCode(value,node.left,code+"0");
				if(temp!=null){
					return temp;
				}
			}
			if(node.right!=null){
				temp=getHuffmanCode(value,node.right,code+"1");
			}
			return temp==null?null:temp;
		}
	}
	
	public BitSet getBitSetFromString(String bitString){
		BitSet bitSet=new BitSet(bitString.length());
		int i=bitString.length();
		for(char c:bitString.toCharArray()){
			if(c=='0'){
				bitSet.set(--i, false);
			}else{
				bitSet.set(--i, true);
			}
		}
		if(bitString.length()>0 && bitSet.length()==0){
			this.zeroStr=bitString;
		}
		return bitSet;
	}

}
