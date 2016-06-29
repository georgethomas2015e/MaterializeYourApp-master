package com.antonioleiva.materializeyourapp;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by kishan on 6/1/2016.
 */
public class ParsingJSon {


    private JSONObject json;

    public ParsingJSon(JSONObject json){
        this.json = json;
    }

    public    void parseJSON(JSONObject json)  {
        // JSONObject value = json.getJSONObject("value");
        GlobalData.messagelist.clear();
        try {
            JSONObject mainObject = new JSONObject(String.valueOf(json));
            if(mainObject.get("STATUS").equals("OK")) {
                JSONArray dataArry = mainObject.getJSONArray("posts");

                //JSONObject object = array.getJSONObject(n);
                for (int i = 0; i < dataArry.length(); i++) {
                    JSONObject jsonData = dataArry.getJSONObject(i);
                    //GlobalData.taskId=jsonData.getString("id");
                    Messages_Model msgs = new Messages_Model();
                    msgs.setAuthorfirstname(jsonData.getString("author-first-name"));
                    msgs.setAuthorlastname(jsonData.getString("author-last-name"));
                    msgs.setMessagebody(jsonData.getString("body"));
                    msgs.setMessagetitle(jsonData.getString("title"));
                    msgs.setPostedOn(jsonData.getString("user-display-posted-date"));
                    msgs.setAuthoravatorurl(jsonData.getString("author-avatar-url"));
                    msgs.setMessageId(jsonData.getString("id"));
                    GlobalData.messagelist.add(msgs);


                }

            }

            else {
                Util.showMessageDialog(MyApplication.getContext(), "Server Error!");
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public    void parseJSONreplies(JSONObject json)  {
        // JSONObject value = json.getJSONObject("value");
        GlobalData.replieslist.clear();
        try {
            JSONObject mainObject = new JSONObject(String.valueOf(json));
            if(mainObject.get("STATUS").equals("OK")) {
                JSONArray dataArry = mainObject.getJSONArray("messageReplies");

                //JSONObject object = array.getJSONObject(n);
                for (int i = 0; i < dataArry.length(); i++) {
                    JSONObject jsonData = dataArry.getJSONObject(i);
                    //GlobalData.taskId=jsonData.getString("id");
                    Repliesmodel replies = new Repliesmodel();
                    replies.setReplyauthfirstname(jsonData.getString("author-firstname"));
                    replies.setReplyauthlastname(jsonData.getString("author-lastname"));
                    replies.setReplybody(jsonData.getString("body"));
                    replies.setReplydate(jsonData.getString("user-display-posted-date"));
                    replies.setReplytime(jsonData.getString("user-display-posted-time"));
                    replies.setReplyauthoravator(jsonData.getString("author-avatar-url"));


                    GlobalData.replieslist.add(replies);

                    // stopping swipe refresh
                }

            }

            else {
                Util.showMessageDialog(MyApplication.getContext(), "Server Error!");
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }




}