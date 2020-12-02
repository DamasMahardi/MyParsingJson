package com.example.mympvpjson.controller.homepage;

import com.example.mympvpjson.model.WisataItem;
import com.example.mympvpjson.model.WisataResponse;
import com.example.mympvpjson.model.repositori.ApiRest;
import com.example.mympvpjson.network.Apiclient;
import com.example.mympvpjson.util.constans.Constans;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter implements MainContarct.Presenter {
    private final MainContarct.View view;

    public MainPresenter(MainContarct.View view) {
        this.view = view;
        this.view.setPresenter(this);
    }

    @Override
    public void getWisataList() {
        view.showLoading();
        ApiRest service = Apiclient.getClient().create(ApiRest.class);
        service.getWisataList().enqueue(new Callback<WisataResponse>() {
            @Override
            public void onResponse(Call<WisataResponse> call, Response<WisataResponse> response) {
                if (response.isSuccessful() && response.body() !=null){
                    view.hiddenLoading();
                    view.showWisataResponse(response.body());
                    List<WisataItem> list = response.body().getWisata();
                    view.showDataList(list);

                }else {
                    view.hiddenLoading();
                    view.failedShowData(Constans.MESSAGE_ERROR_REQUEST);
                }
            }

            @Override
            public void onFailure(Call<WisataResponse> call, Throwable t) {
                view.hiddenLoading();
                view.failedShowData(Constans.MESSAGE_ERROR_REQUEST);

            }
        });


    }

    @Override
    public void start() {
        view.initView();

    }
}
