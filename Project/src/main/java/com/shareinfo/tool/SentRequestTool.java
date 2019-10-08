//package com.shareinfo.tool;
//
//import org.apache.http.HttpResponse;
//import org.apache.http.HttpStatus;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.entity.StringEntity;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClients;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//
///**
// * @author zxx
// * @date 2019/7/5 19:04
// * 向服务器发起请求的工具
// */
//public class SentRequestTool {
//
//    public static void main(String[] args) {
//        JSONObject jsonData = new JSONObject();
//        try {
//            jsonData.put("adminName","aaaaa");
//            jsonData.put("adminPassWord","aaaaaaa");
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//
//        new SentRequestTool().doPost("http://49.4.92.191:8743/iocm/app/sec/v1.1.0/login" , jsonData);
//    }
//
//    /**
//     * @功能 ： 发起POST请求的函数
//     * @URL ： url地址
//     * @data ： 发起请求的数据
//     */
//    public void doPost(String URL ,JSONObject jsonData) {
//
//        CloseableHttpClient HttpClient = HttpClients.createDefault();
//        /**
//         * HttpPost模拟浏览器发起POST请求
//         */
//        HttpPost httpPost = new HttpPost(URL);
//        /**
//         * 设置发送的数据的格式
//         * */
//        httpPost.setHeader("Content-Type" , "application/x-www-form-urlencoded; charset=utf-8");
//        /**
//         * 模拟火狐发送请求
//         * */
//        httpPost.setHeader("User-Agent" , "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:67.0) Gecko/20100101 Firefox/67.0");
//        /**
//         * 获取响应输入流
//         *
//        InputStream inputStream = null;
//
//        try {
//
//            /**
//             * 以字符串形式传输
//             * HttpClient的提供了几个类为最常见的数据的容器：
//             * 字符串，字节数组，输入流，和文件：StringEntity， ByteArrayEntity， InputStreamEntity，和 FileEntity。
//             * */
//            StringEntity stringEntity = new StringEntity(jsonData.toString() , "UTF-8");
//            /**
//             * setEntity：提交数据
//             * */
//            httpPost.setEntity(stringEntity);
//
//            /**
//             *HttpResponse 发起请求并获取响应的结果
//             * */
//            HttpResponse httpResponse = HttpClient.execute(httpPost);
//
//            if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
//                System.out.println("请求发起成功！！！");
//                /**
//                 * 获取响应输入流
//                 * */
//                inputStream = httpResponse.getEntity().getContent();
//                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream , "utf-8"));
//                StringBuilder stringBuilder = new StringBuilder();
//                String line = null;
//                while((line = reader.readLine()) != null ) {
//                    stringBuilder.append(line + "/n");
//                }
//
//                System.out.println(stringBuilder.toString());
//            } else {
//                System.out.println("请求发起失败 ： " + httpResponse.getStatusLine().getStatusCode());
//            }
//
//        } catch (Exception e) {
//
//        } finally {
//            try {
//                /**
//                 * 关闭数据流
//                 * */
//                inputStream.close();
//                HttpClient.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//    }
//
//}
