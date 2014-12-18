package com.djordje.acceptancetesting;

import com.djordje.acceptancetesting.ports.UpstreamSystem;

import java.util.ArrayList;
import java.util.List;

public class UpstreamSystemStub implements UpstreamSystem {
    private List<Integer> data = new ArrayList<Integer>();

    @Override
    public List<Integer> data() {
        return data;
    }

    public void sends(List<Integer> values) {
        data.addAll(values);
    }
}
