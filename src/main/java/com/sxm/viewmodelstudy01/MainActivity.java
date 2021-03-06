package com.sxm.viewmodelstudy01;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements LifecycleOwner {

    private final String TAG = "MainActivity";

    @BindView(R.id.button)
    Button button;
    @BindView(R.id.textView01)
    TextView textView;

    private CounterViewModel viewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: ");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Lifecycle lifecycle = getLifecycle();
        MyObserver myObserver = new MyObserver(lifecycle);

        viewModel = new ViewModelProvider(this).get(CounterViewModel.class);

        viewModel.counter.observe(this,new Observer<Integer>(){
            @Override
            public void onChanged(Integer integer) {
                Log.d(TAG, "onChanged: ");
                textView.setText(String.valueOf(viewModel.counter.getValue()));

            }

        });
        lifecycle.addObserver(myObserver);
        refreshView();
    }

    @OnClick(R.id.button)
    public void onViewClicked() {
        viewModel.plusOne();

    }

    private void refreshView() {
        textView.setText(String.valueOf(viewModel.counter));
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }


}
