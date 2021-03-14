package com.global.userlistapplication

import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    PersonListItemViewStateTest::class,
    PersonListStatusViewStateTest::class
)
class PersonListTestSuite