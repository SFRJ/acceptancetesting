package com.djordje.acceptancetesting.addapters;

import com.djordje.acceptancetesting.ports.SomeService;
import com.djordje.acceptancetesting.ports.TargetSystem;
import com.djordje.acceptancetesting.ports.UpstreamSystem;

public class SomeServiceAdapter implements SomeService {

    private final UpstreamSystem upstreamSystem;
    private final TargetSystem targetSystem;

    public SomeServiceAdapter(UpstreamSystem upstreamSystem, TargetSystem targetSystem) {


        this.upstreamSystem = upstreamSystem;
        this.targetSystem = targetSystem;
    }

    public Integer calculate() {
        Integer result = upstreamSystem.data().stream().reduce(0, (n1, n2) -> n1 + n2);
        targetSystem.receivesData(result);
        return result;
    }
}
