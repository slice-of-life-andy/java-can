package name.yuhongliang.cache.redis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import redis.clients.jedis.Jedis;

public class JedisCommon {
	
	public static Jedis getJedis() {
		Jedis jedis = new Jedis("192.168.32.206",6379);
		return jedis;
	}

	public static void main(String[] args) {
		/*Jedis jedis = getJedis();
		jedis.select(2);
		Map<String, String> map = jedis.hgetAll("model_attrs");
		if (null != map && !map.isEmpty()) {
			String targetKey = "\":";
			String targetValue = "\",";
			Map<String, Map<String, String>> modelAttrMap = new HashMap<>();
			for (Entry<String, String> entry : map.entrySet()) {
				if (entry.getValue().length() > 2) {
					String value = entry.getValue().substring(1,entry.getValue().length()-1).replaceAll(" ", "").toLowerCase();
					System.out.println(entry.getKey() + ":" + value);
					List<Integer> positionList = strStr(value, targetKey, targetValue);
					if (null != positionList && !positionList.isEmpty()) {
						System.out.println(positionList.toString());
						int lastPosition = 1;
						Map<String, String> attrMap = new HashMap<>();
						for (int i = 0; i < positionList.size(); i = i + 2) {
							String attrName = value.substring(lastPosition, positionList.get(i));
							lastPosition = positionList.get(i) + 3;
							String attrValue = "";
							if (i == positionList.size() - 1) {
								attrValue = value.substring(lastPosition, value.length() - 1);
							} else {
								attrValue = value.substring(lastPosition, positionList.get(i + 1));
								lastPosition = positionList.get(i + 1) + 3;
							}
							attrMap.put(attrName, attrValue);
						}
						modelAttrMap.put(entry.getKey().toLowerCase(), attrMap);
					}
				}
			}
			
			//iterate map
			for (Entry<String, Map<String, String>> entry : modelAttrMap.entrySet()) {
				System.out.print(entry.getKey() + "@{");
				for (Entry<String, String> attrEntry : entry.getValue().entrySet()) {
					System.out.print(attrEntry.getKey() + ":" + attrEntry.getValue()+ ";");
				}
				System.out.println("}");
			}
		}*/
		
		Jedis jedis = getJedis();
		jedis.select(1);
		String json = jedis.get("200-6591");
		System.out.println("json is :|" + json + "|");
		
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		List<Integer> subList = list.subList(0, 3);
		for(Integer i : list) {
			System.out.println("original list : " + i);
		}
		for (Integer integer : subList) {
			System.out.println("sub LIst : " + integer);
		}
		
	}
	
	public static List<Integer> strStr(String source, String targetKey, String targetValue) {
        if (source == null || targetKey == null || targetValue == null) {
            return null;
        }
        
        int minTargetLength = Math.min(targetKey.length(), targetValue.length());
        List<Integer> list = new ArrayList<>();
        boolean kvFlag = true;
        for (int i = 0; i < source.length() - minTargetLength + 1; i++) {
        		if (kvFlag) {
        			int j = 0;
                for (j = 0; j < targetKey.length(); j++) {
                    if (source.charAt(i + j) != targetKey.charAt(j)) {
                        break;
                    }
                }
                // finished loop, target found
                if (j == targetKey.length()) {
                    list.add(i);
                    kvFlag = !kvFlag;
                }
			} else {
				int k = 0;
	            for (k = 0; k < targetValue.length(); k++) {
	                if (source.charAt(i + k) != targetValue.charAt(k)) {
	                    break;
	                }
	            }
	            // finished loop, target found
	            if (k == targetValue.length()) {
	                list.add(i);
	                kvFlag = !kvFlag;
	            }
			}
            
        }
        return list;
    }
	
	   public static int strStr1(String source, String target) {
	        if (source == null || target == null) {
	            return -1;
	        }
	        
	        for (int i = 0; i < source.length() - target.length() + 1; i++) {
	            int j = 0;
	            for (j = 0; j < target.length(); j++) {
	                if (source.charAt(i + j) != target.charAt(j)) {
	                    break;
	                }
	            }
	            // finished loop, target found
	            if (j == target.length()) {
	                return i;
	            }
	        }
	        return -1;
	    }

}


/*iphone6P:{"颜色": "深空灰,银,金", "内存": "16G,64G,128G,32G", "版本": "国行,港行,其他"}
iphone7P:{"颜色": "亮黑,黑,银,金,玫瑰金,红色", "内存": "32G,128G,256G", "版本": "国行,港行,其他"}
iphone4:{"颜色": "黑,白", "内存": "8G,16G,32G", "版本": "国行,港行,其他"}
iphone7:{"颜色": "亮黑,黑,银,金,玫瑰金,红色", "内存": "32G,128G,256G", "版本": "国行,港行,其他"}
iphone4S:{"颜色": "黑,白", "内存": "16G,32G,64G,8G", "版本": "国行,港行,其他"}
iphone6SP:{"颜色": "深空灰,银,金,玫瑰金", "内存": "16G,32G,64G,128G", "版本": "国行,港行,其他"}
iphoneSE:{"颜色": "深空灰,银,金,玫瑰金", "内存": "16GB,64G", "版本": "国行,港行,其他"}
iphone5:{"颜色": "黑,白", "内存": "16G,32G,64G", "版本": "国行,港行,其他"}
iphone6:{"颜色": "深空灰,银,金", "内存": "16G,64G,128G,32G", "版本": "国行,港行,其他"}
iphone5C:{"颜色": "白,黄,绿,蓝,粉", "内存": "8G,16G,32G", "版本": "国行,港行,其他"}
iphone5S:{"颜色": "深空灰,银,金", "内存": "16G,32G,64G", "版本": "国行,港行,其他"}
iphone6S:{"颜色": "深空灰,银,金,玫瑰金", "内存": "16G,32G,64G,128G", "版本": "国行,港行,其他"}
*/