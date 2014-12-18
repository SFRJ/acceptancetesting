package com.djordje.acceptancetesting;

import com.djordje.acceptancetesting.ports.TargetSystem;
import com.djordje.acceptancetesting.ports.UpstreamSystem;
import org.junit.Test;

import static java.util.Arrays.asList;

public class SomeServiceAcceptanceTest {

    private UpstreamSystemStub upstreamSystemStub = new UpstreamSystemStub();
    private TargetSystemStub targetSystem = new TargetSystemStub();
    private SomeService someService = new SomeService(upstreamSystemStub, targetSystem);

    @Test
    public void shouldCalculateTheResultGivenTheReceivedDataAndPassItToTheTargetSystem() throws Exception{
        upstreamSystemStub.sends(asList(1, 2, 3));
        someService.calculate();
        targetSystem.hasReceived(6);
    }

    private class SomeService {

        private final UpstreamSystem upstreamSystem;
        private final TargetSystem targetSystem;

        public SomeService(UpstreamSystem upstreamSystem, TargetSystem targetSystem) {


            this.upstreamSystem = upstreamSystem;
            this.targetSystem = targetSystem;
        }

        public Integer calculate() {
            Integer result = upstreamSystem.data().stream().reduce(0, (n1, n2) -> n1 + n2);
            targetSystem.receivesData(result);
            return result;
        }
    }
}
