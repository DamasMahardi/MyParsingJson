package com.example.mympvpjson.controller.homepage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.mympvpjson.R;
import com.example.mympvpjson.model.WisataItem;
import com.example.mympvpjson.model.WisataResponse;
import com.google.gson.Gson;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainContarct.View{
    @BindView(R.id.rv_ListWisata)
    RecyclerView rvWisataList;
    @BindView(R.id.pb_Progressbar)
    ProgressBar progressBar;
    private MainAdapter mainAdapter;
    private MainContarct.Presenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter = new MainPresenter(this);
        presenter.start();
    }

    @Override
    public void initView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvWisataList.setLayoutManager(linearLayoutManager);
        presenter.getWisataList();

    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);

    }

    @Override
    public void hiddenLoading() {
        progressBar.setVisibility(View.GONE);

    }

    @Override
    public void showDataList(List<WisataItem> list) {
        mainAdapter = new MainAdapter(this, list);
        rvWisataList.setAdapter(mainAdapter);

    }

    @Override
    public void failedShowData(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showWisataResponse(WisataResponse wisataResponse) {
        Log.e("MainActivity", "showWisataResponse: "+ new Gson().toJson(wisataResponse));

    }

    @Override
    public void setPresenter(MainContarct.Presenter presenter) {
        this.presenter = presenter;

    }
}