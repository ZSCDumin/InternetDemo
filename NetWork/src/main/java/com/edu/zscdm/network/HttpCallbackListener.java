package com.edu.zscdm.network;

public interface HttpCallbackListener {

    void onFinish(String response);

    void onError(Exception e);

}