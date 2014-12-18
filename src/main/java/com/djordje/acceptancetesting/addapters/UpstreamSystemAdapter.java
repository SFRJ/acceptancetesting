package com.djordje.acceptancetesting.addapters;

import com.djordje.acceptancetesting.ports.UpstreamSystem;

import java.util.List;

public class UpstreamSystemAdapter implements UpstreamSystem {

    @Override
    public List<Integer> data() {
        // This is production code that the acceptance test avoids dealing with
        // For example, it could be a rest endpoint...
        return null;
    }
}
