package com.djordje.acceptancetesting;

import com.djordje.acceptancetesting.addapters.SomeServiceAdapter;
import org.junit.Test;

import static java.util.Arrays.asList;

public class SomeServiceAcceptanceTest {

    private UpstreamSystemStub upstreamSystemStub = new UpstreamSystemStub();
    private TargetSystemStub targetSystem = new TargetSystemStub();
    private SomeServiceAdapter someService = new SomeServiceAdapter(upstreamSystemStub, targetSystem);

    @Test
    public void shouldCalculateTheResultGivenTheReceivedDataAndPassItToTheTargetSystem() throws Exception{
        upstreamSystemStub.sends(asList(1, 2, 3));
        someService.calculate();
        targetSystem.hasReceived(6);
    }

}
