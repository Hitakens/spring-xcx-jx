package com.forword.common.baiduyy;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;

import com.baidu.aip.speech.AipSpeech;
import com.baidu.aip.speech.TtsResponse;
import com.forword.common.ParamConfig;

public class BaiduYyhc {


	public static String getYpfile(String text, String filepath) {
		/*
		 * String auth = getAuth(appKey, secretKey); System.out.println(auth);
		 */
		AipSpeech aipSpeech = new AipSpeech(ParamConfig.APPID, ParamConfig.APIKEY, ParamConfig.SERCETKEY);
		HashMap options = new HashMap();
		options.put("spd", "5");
		options.put("pit", "5");
		options.put("per", "4");
		TtsResponse ttsResponse = aipSpeech.synthesis(text, "zh", 1, options);
		byte[] aa = ttsResponse.getData();
		getFile(aa, filepath, "demo.mp3");
		System.out.println("合成成功");
		return filepath+"/"+"demo.mp3";
	}

	/**
	 * 获取API访问token 该token有一定的有效期，需要自行管理，当失效时需重新获取.
	 * 
	 * @param ak
	 *            - 百度云官网获取的 API Key
	 * @param sk
	 *            - 百度云官网获取的 Securet Key
	 * @return assess_token 示例：
	 *         "24.460da4889caad24cccdb1fea17221975.2592000.1491995545.282335-1234567"
	 */
	/**
	 * 获取权限token
	 * 
	 * @return 返回示例： { "access_token":
	 *         "24.460da4889caad24cccdb1fea17221975.2592000.1491995545.282335-1234567",
	 *         "expires_in": 2592000 }
	 */
	public static String getAuthtok(String ak, String sk) {
		// 获取token地址
		String authHost = "https://aip.baidubce.com/oauth/2.0/token?";
		String getAccessTokenUrl = authHost
				// 1. grant_type为固定参数
				+ "grant_type=client_credentials"
				// 2. 官网获取的 API Key
				+ "&client_id=" + ak
				// 3. 官网获取的 Secret Key
				+ "&client_secret=" + sk;
		try {
			URL realUrl = new URL(getAccessTokenUrl);
			// 打开和URL之间的连接
			HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();
			connection.setRequestMethod("GET");
			connection.connect();
			// 获取所有响应头字段
			Map<String, List<String>> map = connection.getHeaderFields();
			// 遍历所有的响应头字段
			for (String key : map.keySet()) {
				System.err.println(key + "--->" + map.get(key));
			}
			// 定义 BufferedReader输入流来读取URL的响应
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String result = "";
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
			/**
			 * 返回结果示例
			 */
			System.err.println("result:" + result);
			JSONObject jsonObject = new JSONObject(result);
			String access_token = jsonObject.getString("access_token");
			return access_token;
		} catch (Exception e) {
			System.err.printf("获取token失败！");
			e.printStackTrace(System.err);
		}
		return null;
	}

	public static void getFile(byte[] bfile, String filePath, String fileName) {
		BufferedOutputStream bos = null;
		FileOutputStream fos = null;
		File file = null;
		try {
			File dir = new File(filePath);
			if (!dir.exists() && dir.isDirectory()) {// 判断文件目录是否存在
				dir.mkdirs();
			}
			file = new File(filePath + "\\" + fileName);
			fos = new FileOutputStream(file);
			bos = new BufferedOutputStream(fos);
			bos.write(bfile);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (bos != null) {
				try {
					bos.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}

}
