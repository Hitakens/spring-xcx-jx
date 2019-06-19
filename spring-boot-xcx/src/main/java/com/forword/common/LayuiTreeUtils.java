package com.forword.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LayuiTreeUtils {
	
	/**
	 * 树结构加载方法
	 * @param dataMapList 表数据Map类型
	 * @param pidValue	  父级节点值
	 * @param pidKey	  父级ID字段名
	 * @param idKey		ID字段名
	 * @param TextKey	名称字段名
	 * @return
	 */
	public static List<LayuiTree> loadTree(List<Map<String, Object>> dataMapList,Object pidValue,String pidKey,String idKey,String TextKey){
	
		List<LayuiTree> treeList = new ArrayList<>();
		for (Map<String, Object> map : dataMapList) {
			//顶级目录
			if(map.get(pidKey) == null || pidValue.equals(map.get(pidKey))){
				LayuiTree tree = new LayuiTree();
				tree.setPid(map.get(pidKey));
				tree.setId(map.get(idKey));
				tree.setName((String)map.get(TextKey));
				tree.setAllName((String)map.get(TextKey));
				tree.setSpread(false);

				//加载子集树
				loadChildren(tree, dataMapList,tree.getId(), pidKey, idKey, TextKey,tree.getAllName());
			
				treeList.add(tree);
			}
		}
		
		return treeList;
	}
	
	/**
	 * 加载子节点
	 * @param parentTree   树对象
	 * @param dataMapList  表数据 
	 * @param pidValue		父节点ID值
	 * @param pidKey		父节点对应字段名
	 * @param idKey			该节点ID字段名
	 * @param TextKey		该节点文本字段名
	 * @param TextValue		该节点文本值
	 */
	public static void loadChildren(LayuiTree parentTree,List<Map<String, Object>> dataMapList,Object pidValue,String pidKey,String idKey,String TextKey,String TextValue){
		List<LayuiTree> treeList = new ArrayList<>();
		for (Map<String, Object> map : dataMapList) {
			if(pidValue.equals(map.get(pidKey))){
				LayuiTree tree = new LayuiTree();
				tree.setPid(pidValue);
				tree.setId(map.get(idKey));
				tree.setName((String)map.get(TextKey));
				tree.setAllName(TextValue +"-"+  map.get(TextKey));
				// 判断是否还有子集
				loadChildren(tree, dataMapList, tree.getId(),pidKey,  idKey, TextKey,tree.getAllName());
				treeList.add(tree);
			}
		}
		if(treeList.size() > 0){
			parentTree.setChildren(treeList);
		}
		
		return ;
	}

	/**
	 * 树结构加载方法
	 * @param dataMapList 表数据Map类型
	 * @param pidValue	  父级节点值
	 * @param pidKey	  父级ID字段名
	 * @param idKey		ID字段名
	 * @param TextKey	名称字段名
	 * @param typeKey   类型字段名
	 * @return
	 */
	public static List<LayuiTree> loadTreeCustom(List<Map<String, Object>> dataMapList,Object pidValue,String pidKey,String idKey,String TextKey,String typeKey){
	
		List<LayuiTree> treeList = new ArrayList<>();
		for (Map<String, Object> map : dataMapList) {
			//顶级目录
			if(map.get(pidKey) == null || pidValue.equals(map.get(pidKey))){
				LayuiTree tree = new LayuiTree();
				tree.setPid(map.get(pidKey));
				tree.setId(map.get(idKey));
				tree.setName(map.get(TextKey));
				tree.setAllId(map.get(idKey));
				tree.setAllName((String)map.get(TextKey));
				tree.setSpread(true);
				tree.setLeaf(false);
				//加载子集树
				loadChildrenCustom(tree, dataMapList,tree.getId(),tree.getAllId(), pidKey, idKey, TextKey,tree.getAllName(),typeKey);
			
				treeList.add(tree);
			}
		}
		
		return treeList;
	}
	
	/**
	 * 加载子节点
	 * @param parentTree   树对象
	 * @param dataMapList  表数据 
	 * @param pidValue		父节点ID值
	 * @param pidKey		父节点对应字段名
	 * @param idKey			该节点ID字段名
	 * @param TextKey		该节点文本字段名
	  * @param typeKey   类型字段名
	 */
	public static void loadChildrenCustom(LayuiTree parentTree,List<Map<String, Object>> dataMapList,Object pidValue,Object pidAllValue,String pidKey,String idKey,String TextKey,String TextValue,String typeKey){
		List<LayuiTree> treeList = new ArrayList<>();
		for (Map<String, Object> map : dataMapList) {
			if(pidValue.equals(map.get(pidKey))){
				LayuiTree tree = new LayuiTree();
				tree.setPid(pidValue);
				tree.setId(map.get(idKey));
				tree.setAllId(pidAllValue +","+map.get(idKey));
				tree.setAllName(TextValue +"-"+  map.get(TextKey));
				tree.setName(map.get(TextKey));
				tree.setSpread(true);
				if("class".equals(map.get(typeKey))) {
					tree.setLeaf(false);
				}else {
					tree.setLeaf(true);
				}
				// 判断是否还有子集
				loadChildrenCustom(tree, dataMapList, tree.getId(),tree.getAllId(),pidKey,  idKey, TextKey,tree.getAllName(),typeKey);
				treeList.add(tree);
			}
		}
		if(treeList.size() > 0){
			parentTree.setChildren(treeList);
		}else {
			if(!parentTree.isLeaf()) {
				parentTree.setChildren(treeList);
			}
		}
		
		return ;
	}

}
