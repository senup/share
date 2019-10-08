//package com.shareinfo.tool;
//
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import java.util.Timer;
//import java.util.TimerTask;
//
///**
// * @author zxx
// * @date 2019/7/5 21:06
// */
//public class TestTimer {
//    public static void main(String[] args) {
//        final JSONObject jsonData = new JSONObject();
//        try {
//            jsonData.put("adminName","aaaaa");
//            jsonData.put("adminPassWord","aaaaaaa");
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//
//        TimerTask timerTask = new TimerTask() {
//            @Override
//            public void run() {
//                new SentRequestTool().doPost("http://127.0.0.1:8080/superadmin/addadmin" , jsonData);
//            }
//        };
//        Timer timer = new Timer();
//        //安排指定的任务在指定的时间开始进行重复的固定延迟执行。这里是每30秒执行一次
//        timer.schedule(timerTask,10,30000);
//    }
//}
