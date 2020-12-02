package com.example.mympvpjson.controller.homepage;

import com.example.mympvpjson.base.BasePresenter;
import com.example.mympvpjson.base.BaseView;
import com.example.mympvpjson.model.WisataItem;
import com.example.mympvpjson.model.WisataResponse;

import java.util.List;

public interface MainContarct {
    interface View extends BaseView<Presenter>{
        void initView();
        void showLoading();
        void hiddenLoading();
        void showDataList(List<WisataItem> list);
        void failedShowData(String message);
        void showWisataResponse(WisataResponse wisataResponse);


    }
    interface  Presenter extends BasePresenter{
        void getWisataList();
    }
}
