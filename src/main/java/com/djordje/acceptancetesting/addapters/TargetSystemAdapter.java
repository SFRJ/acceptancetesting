package com.djordje.acceptancetesting.addapters;

import com.djordje.acceptancetesting.ports.TargetSystem;

public class TargetSystemAdapter implements TargetSystem {

    @Override
    public void receivesData(Integer expected) {
        // This is production code that the acceptance test avoids dealing with
        // For example, a database client code, logging system, or other downstream system
        // could go here(let's say)
    }
}
