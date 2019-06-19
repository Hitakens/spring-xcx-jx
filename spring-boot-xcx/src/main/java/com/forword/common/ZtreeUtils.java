package com.forword.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ZtreeUtils {
	
	/**
	 * 树结构加载方法
	 * @param dataMapList 表数据Map类型
	 * @param pidValue	  父级节点值
	 * @param pidKey	  父级ID字段名
	 * @param idKey		ID字段名
	 * @param TextKey	名称字段名
	 * @return
	 */
	public static List<Ztree> loadTree(List<Map<String, Object>> dataMapList,Object pidValue,String pidKey,String idKey,String TextKey,String contextPath){
	
		List<Ztree> treeList = new ArrayList<>();
		for (Map<String, Object> map : dataMapList) {
			//顶级目录
			if(map.get(pidKey) == null || pidValue.equals(map.get(pidKey))){
				Ztree tree = new Ztree();
				tree.setpId(map.get(pidKey));
				tree.setId(map.get(idKey));
				tree.setName((String)map.get(TextKey));
				if(pidValue.equals("0000000000000000000")){
					tree.setOpen(true);
				}else{
					tree.setOpen(false);
				}
				
				tree.setIcon(contextPath + tree.getIcon());
				tree.setIconClose( contextPath+ tree.getIconClose());
				tree.setIconOpen(contextPath+ tree.getIconOpen());
				//加载子集树
				loadChildren(tree, dataMapList,tree.getId(), pidKey, idKey, TextKey,contextPath );
			
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
	public static void loadChildren(Ztree parentTree,List<Map<String, Object>> dataMapList,Object pidValue,String pidKey,String idKey,String TextKey, String contextPath ){
		List<Ztree> treeList = new ArrayList<>();
		for (Map<String, Object> map : dataMapList) {
	//		System.out.println(map.get(pidKey)+"===="+map.get(idKey)+"===="+map.get(TextKey));
			if(map != null && pidValue != null && pidValue.equals(map.get(pidKey))){
				Ztree tree = new Ztree();
				tree.setpId(map.get(pidKey));
				tree.setId(map.get(idKey));
				tree.setName((String)map.get(TextKey));
				tree.setOpen(false);
				tree.setIcon(contextPath + tree.getIcon());
				tree.setIconClose( contextPath+ tree.getIconClose());
				tree.setIconOpen(contextPath+ tree.getIconOpen());
				
				// 判断是否还有子集
				loadChildren(tree, dataMapList, tree.getId(),pidKey,  idKey, TextKey, contextPath ) ;
				treeList.add(tree);
			}
		}
		if(treeList.size() > 0){
			parentTree.setChildren(treeList);
		}
		
		return ;
	}

}
