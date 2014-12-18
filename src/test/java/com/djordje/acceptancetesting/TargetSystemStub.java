package com.djordje.acceptancetesting;

import com.djordje.acceptancetesting.ports.TargetSystem;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TargetSystemStub implements TargetSystem {

    private Integer result;

    @Override
    public void receivesData(Integer result) {
        this.result = result;
    }

    public void hasReceived(int expected) {
        assertThat(result, is(expected));

    }
}
