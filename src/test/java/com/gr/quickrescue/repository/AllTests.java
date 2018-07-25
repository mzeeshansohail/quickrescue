package com.gr.quickrescue.repository;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AccountRepositoryImplTest.class, ContactRepositoryImplTest.class })
public class AllTests {
	public AllTests() {
	}
}
