package com.sxm.viewmodelstudy01;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CounterViewModel extends ViewModel {

     MutableLiveData<Integer> counter = new MutableLiveData<>();

    public CounterViewModel(@NonNull int counter) {
        this.counter.setValue(counter);
    }

    public void plusOne() {
        int count = counter.getValue();
        counter.postValue(count + 1);
    }

    public void clear() {

        counter.postValue(0);
    }

}
